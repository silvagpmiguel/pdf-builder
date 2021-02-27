import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PageEvent extends PdfPageEventHelper {
    private Image logo;
    private String title;
    private int pageNumber;
    private int totalPages;

    public PageEvent(Image logo, String title) {
        this(logo, title, 0);
    }

    public PageEvent(Image logo, String title, int totalPages) {
        this.logo = logo;
        this.title = title;
        this.pageNumber = 0;
        this.totalPages = totalPages;
    }

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        try {
            pageNumber++;
            FontWrapper font = new FontWrapper().withBoldStyle();
            List<String> firstHeaderRow = Arrays.asList(title,
                    getHeaderPhrase(pageNumber, totalPages));
            TableWrapper firstHeaderTable = ElementFactory.newTable(new float[] { 83, 17 });
            document.add(logo);
            document.add(firstHeaderTable.withSpacingBefore(10f)
                    .addTextRow(firstHeaderRow, ElementFactory.newCell().withPadding(4), font));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private String getHeaderPhrase(int pageNumber, int totalPages) {
        return totalPages == 0
                ? ("PAGE " + pageNumber)
                : ("PAGE " + pageNumber + "/" + totalPages);
    }
}