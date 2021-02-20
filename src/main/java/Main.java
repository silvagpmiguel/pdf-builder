import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.BaseColor;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> header = Arrays.asList(new String[] { "HEADER 1", "HEADER 2", "HEADER 3" });
        List<String> row = Arrays.asList(new String[] { "Cell 1", "Cell 2", "Cell 3" });
        List<List<String>> table = new ArrayList<>();
        ElementFactory factory = new ElementFactory();
        table.add(header);
        for (int i = 0; i < 60; i++)
            table.add(row);
        new PdfBuilder()
                .setPageEvent(new PageEvent(factory.newImage("logo.png", 70), "Logo + Table Example with Page Event"))
                .open()
                .addElement(
                        factory.newTable(table, 2, 1, factory.buildCell().setCellBorderColor(BaseColor.RED).getCell(),
                                factory.newCell(), factory.buildCell().setCellBorderColor(BaseColor.BLUE).getCell()))
                .close().generatePdf("teste.pdf");
    }
}
