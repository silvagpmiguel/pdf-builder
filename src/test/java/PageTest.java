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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageTest {
    @Test
    @DisplayName("Generated PDF Pages Test")
    public void shouldAddPages(){
        List<String> header = Arrays.asList(new String[] { "HEADER 1", "HEADER 2", "HEADER 3" });
        List<String> row = Arrays.asList(new String[] { "Cell 1", "Cell 2", "Cell 3" });
        List<String> footer = Arrays.asList(new String[] { "FOOTER 1", "FOOTER 2", "FOOTER 3" });
        List<List<String>> table = new ArrayList<>();
        table.add(header);
        for (int i = 0; i < 40; i++)
            table.add(row);
        table.add(footer);
        String title = "PageEvent with currentPage/totalPages in every pdf page";
        CellWrapper headerStyle = ElementFactory.newCell().withBackgroundColor(BaseColor.LIGHT_GRAY)
                .withHorizontalAlign(Element.ALIGN_CENTER);
        FontWrapper headerFont = ElementFactory.newFont().withSize(14f);
        CellWrapper bodyStyle = ElementFactory.newCell().withPadding(5);
        FontWrapper bodyFont = ElementFactory.newFont();
        CellWrapper footerStyle = ElementFactory.newCell().withBackgroundColor(BaseColor.CYAN)
                .withHorizontalAlign(Element.ALIGN_CENTER);
        FontWrapper footerFont = ElementFactory.newFont().withSize(14f);
        PdfBuilder pdfBuilder = new PdfBuilder(new PageEvent(title))
            .open()
            .addElement(ElementFactory.newTable(table, bodyStyle, bodyFont, 1, headerStyle, headerFont, 1,footerStyle, footerFont))
            .build()
            .close();
        int totalPages = pdfBuilder.getPageNumber();
        assertEquals(totalPages, 2);
    }
}
