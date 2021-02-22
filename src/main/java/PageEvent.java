import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PageEvent extends PdfPageEventHelper {
    private Element logo;
    private String title;
    private int pageNum;
    private int totalPages;

    public PageEvent(Element logo, String title) {
        this.logo = logo;
        this.title = title;
        this.pageNum = 1;
    }

    public PageEvent(Element logo, String title, int totalPages) {
        this.logo = logo;
        this.title = title;
        this.pageNum = 1;
        this.totalPages = totalPages;
    }

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        try {
            document.add(logo);
            PdfPTable table = new PdfPTable(new float[] { 85, 15 });
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            table.addCell(new Phrase(title));
            if (totalPages == 0) {
                table.addCell(new Phrase("Page " + pageNum));
            } else {
                table.addCell(new Phrase("Page " + pageNum + "/" + totalPages));
            }
            pageNum++;
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}