import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> header = Arrays.asList(new String[] { "HEADER 1", "HEADER 2", "HEADER 3" });
        List<String> row = Arrays.asList(new String[] { "Cell 1", "Cell 2", "Cell 3" });
        List<List<String>> table = new ArrayList<>();
        CellStyle headerStyle = new CellStyle();
        CellStyle bodyStyle = new CellStyle();
        TableStyle tableStyle = new TableStyle();
        table.add(header);
        for (int i = 0; i < 60; i++)
            table.add(row);
        PdfBuilder pdfBuilder = new PdfBuilder();
        pdfBuilder
            .setPageEvent(new PageEvent(PdfBuilder.buildImage("logo.png", 70), "Logo + Table Example with Page Event"))
            .open()
            .addElement(PdfBuilder.buildTable(table, 1, tableStyle, headerStyle, bodyStyle))
            .close()
            .generatePdf("teste.pdf");
    }
}
