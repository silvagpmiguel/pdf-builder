import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PdfBuilder {
    private List<Element> elementList;
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

    public PdfBuilder(PdfPageEventHelper pageEvent){
        this(new DocumentWrapper(), null);
    }

    public PdfBuilder(DocumentWrapper document, PdfPageEventHelper pageEvent) {
        this(document, pageEvent, new ArrayList<>());
    }
    
    public PdfBuilder(PdfPageEventHelper pageEvent, List<Element> elementList) {
        this(new DocumentWrapper(), pageEvent, elementList);
    }

    public PdfBuilder(DocumentWrapper document, PdfPageEventHelper pageEvent, List<Element> elementList) {
        this.document = document;
        this.elementList = elementList;
        init();
        setPageEvent(pageEvent);
    }

    public PdfPageEventHelper getPageEvent() {
        return pageEvent;
    }

    public List<Element> getElementList(){
        return elementList;
    }

    public byte[] getPdfData() {
        return outputStream.toByteArray();
    }

    public int getPageNumber() {
        return pdfWriter.getPageNumber()+1;
    }

    public PdfBuilder setPageEvent(PdfPageEventHelper pageEvent) {
        this.pageEvent = pageEvent;
        this.pdfWriter.setPageEvent(pageEvent);
        return this;
    }

    public PdfBuilder addElement(Element element) {
        elementList.add(element);
        return this;
    }

    public PdfBuilder build() {
        for (Element element : elementList) {
            try {
                document.add(element);
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
            outputStream.close();
            pdfWriter.close();
            document.close();
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
