import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String [] args) throws Exception{
        List<String> header = Arrays.asList(new String[]{"HEADER 1", "HEADER 2", "HEADER 3"});
        List<String> row = Arrays.asList(new String[]{"Cell 1", "Cell 2", "Cell 3"});
        List<List<String>> table = new ArrayList<>();
        CellStyle headerStyle = new CellStyle();
        CellStyle bodyStyle = new CellStyle(null, null, null, null, null, null, null, null);
        table.add(header);
        for(int i = 0; i < 60 ; i++)
            table.add(row);
        PdfBuilder pdfbuilder = new PdfBuilder();
        pdfbuilder.addTable(table, 1, null, null, headerStyle, bodyStyle);
        pdfbuilder.closeDocument();
        pdfbuilder.generatePdf("teste.pdf");
    }
}
