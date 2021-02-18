import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PageEvent extends PdfPageEventHelper {
    private Image logo;
    private int pageNum;

    public PageEvent(String logoName) {
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(logoName).toURI());
            logo = Image.getInstance(path.toAbsolutePath().toString());
            logo.scalePercent(70);
            logo.setSpacingAfter(50f);
            logo.setSpacingBefore(50f);
            pageNum = 1;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        try {
            document.add(logo);
            PdfPTable table = new PdfPTable(2);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            table.addCell(new CellStyle().buildCellWithStyles("Titulo 1"));
            table.addCell(new CellStyle().buildCellWithStyles("Page "+(pageNum++)));
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}