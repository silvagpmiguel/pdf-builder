import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> header = Arrays.asList(new String[] { "HEADER 1", "HEADER 2", "HEADER 3" });
        List<String> row = Arrays.asList(new String[] { "Cell 1", "Cell 2", "Cell 3" });
        List<String> footer = Arrays.asList(new String[] { "FOOTER 1", "FOOTER 2", "FOOTER 3" });
        List<List<String>> table = new ArrayList<>();
        table.add(header);
        for (int i = 0; i < 30; i++)
            table.add(row);
        table.add(footer);

        CellWrapper headerStyle = ElementFactory.newCell().withBackgroundColor(BaseColor.LIGHT_GRAY).withHorizontalAlign(Element.ALIGN_CENTER);
        FontWrapper headerFont = ElementFactory.newFont().withSize(14f);
        CellWrapper bodyStyle = ElementFactory.newCell().withPadding(5);
        FontWrapper bodyFont = ElementFactory.newFont();
        CellWrapper footerStyle = ElementFactory.newCell().withBackgroundColor(BaseColor.CYAN).withHorizontalAlign(Element.ALIGN_CENTER);
        FontWrapper footerFont = ElementFactory.newFont().withSize(14f);

        new PdfBuilder()
            .setPageEvent(new PageEvent(ElementFactory.newImage("img/logo.png", 70f),"PageEvent + Table Example with ElementFactory and PdfBuilder"))
            .open()
            .addElement(
                ElementFactory.newTable(table, bodyStyle, bodyFont, 1, headerStyle, headerFont, 1, footerStyle, footerFont)
            )
            .close()
            .generatePdf("teste.pdf");
    }
}
