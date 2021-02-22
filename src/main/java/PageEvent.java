import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
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
            List<String> row = Arrays.asList(title, getTitle());
            document.add(logo);
            document.add(
                ElementFactory.newTable(new float[] { 85, 15 })
                    .withSpacingBefore(10f)
                    .withSpacingAfter(10f)
                    .addTextRow(row)
            );
            pageNum++;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private String getTitle(){
        return totalPages == 0 ? ("Page " + pageNum) : ("Page " + pageNum + "/" + totalPages);
    }
}