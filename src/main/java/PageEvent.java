import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PageEvent extends PdfPageEventHelper {
    private Element logo;
    private String title;
    private int pageNum;

    public PageEvent(Element logo, String title) {
        this.logo = logo;
        this.title = title;
        this.pageNum = 1;
    }

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        try {
            document.add(logo);
            PdfPTable table = new PdfPTable(new float[]{90, 10});
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            table.addCell(new CellStyle().buildCellWithStyles(title));
            table.addCell(new CellStyle().buildCellWithStyles("Page "+(pageNum++)));
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}