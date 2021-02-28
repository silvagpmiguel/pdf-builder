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

import java.util.Arrays;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PageEvent extends PdfPageEventHelper {
    private String title;
    private int pageNum;
    private int totalPages;

    public PageEvent(String title) {
        this(title, 0);
    }

    public PageEvent(String title, int totalPages) {
        this.title = title;
        this.pageNum = 0;
        this.totalPages = totalPages;
    }

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        try {
            pageNum++;
            FontWrapper font = new FontWrapper().withBoldStyle();
            
            document.add(ElementFactory.newTable(new float[] { 85, 15 })
                    .withSpacingBefore(15f)
                    .withSpacingBefore(15f)
                    .addTextRow(Arrays.asList(title, getPageTitle()), ElementFactory.newCell().withPadding(4), font));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private String getPageTitle(){
        return totalPages == 0 ? "Page: "+pageNum : "Page: "+pageNum+" / "+totalPages;
    }
}