/* 
 *  Copyright 2021 com.github.silvagpmiguel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PdfBuilder {
    private List<ElementWrapper> elementList;
    private DocumentWrapper document;
    private PdfWriter pdfWriter;
    private ByteArrayOutputStream outputStream;
    private PdfPageEventHelper pageEvent;

    public PdfBuilder() {
        this(new DocumentWrapper());
    }

    public PdfBuilder(DocumentWrapper document) {
        this(document, null);
    }

    public PdfBuilder(PdfPageEventHelper pageEvent) {
        this(new DocumentWrapper(), null);
    }

    public PdfBuilder(DocumentWrapper document, PdfPageEventHelper pageEvent) {
        this(document, pageEvent, new ArrayList<ElementWrapper>());
    }

    public PdfBuilder(PdfPageEventHelper pageEvent, List<ElementWrapper> elementList) {
        this(new DocumentWrapper(), pageEvent, elementList);
    }

    public PdfBuilder(DocumentWrapper document,
            PdfPageEventHelper pageEvent,
            List<ElementWrapper> elementList) {
        this.document = document;
        this.elementList = elementList;
        init();
        setPageEvent(pageEvent);
    }

    public PdfPageEventHelper getPageEvent() {
        return pageEvent;
    }

    public List<ElementWrapper> getElementList() {
        return elementList;
    }

    public byte[] getPdfData() {
        return outputStream.toByteArray();
    }

    public int getPageNumber() {
        return pdfWriter.getPageNumber();
    }

    public PdfBuilder setPageEvent(PdfPageEventHelper pageEvent) {
        this.pageEvent = pageEvent;
        this.pdfWriter.setPageEvent(pageEvent);
        return this;
    }

    public PdfBuilder addElement(ElementWrapper element) {
        elementList.add(element);
        return this;
    }

    public PdfBuilder build() {
        for (ElementWrapper element : elementList) {
            try {
                document.add(element);
                if (element.needPageBreak()) {
                    document.addNewPage();
                }
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void generatePdf(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(outputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PdfBuilder open() {
        document.open();
        return this;
    }

    public PdfBuilder close() {
        try {
            document.close();
            pdfWriter.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    private void init() {
        try {
            outputStream = new ByteArrayOutputStream();
            pdfWriter = PdfWriter.getInstance(document, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
