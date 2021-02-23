import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PdfBuilder extends PdfPageEventHelper{
    private List<Element> elementList;
    private DocumentWrapper document;
    private PdfWriter pdfWriter;
    private ByteArrayOutputStream outputStream;
    private int pageNum;
    private int totalPages;
    private Element logo;
    private String title;

    public PdfBuilder() {
        this(new DocumentWrapper());
    }

    public PdfBuilder(DocumentWrapper document) {
        this(document, new ArrayList<Element>());
    }

    public PdfBuilder(Element logo) {
        this(logo, null);
    }
    
    public PdfBuilder(Element logo, String title) {
        this(new ArrayList<Element>(), logo, title);
    }

    public PdfBuilder(List<Element> elementList, Element logo) {
        this(new DocumentWrapper(), elementList, logo, null, 0);
    }

    public PdfBuilder(List<Element> elementList, Element logo, String title) {
        this(new DocumentWrapper(), elementList, logo, null, 0);
    }

    public PdfBuilder(List<Element> elementList, Element logo, String title, int totalPages) {
        this(new DocumentWrapper(), elementList, logo, title, totalPages);
    }

    public PdfBuilder(DocumentWrapper document, List<Element> elementList) {
        this(document, elementList, null);
    }

    public PdfBuilder(DocumentWrapper document, List<Element> elementList, Element logo) {
        this(document, elementList, logo, null, 0);
    }

    public PdfBuilder(DocumentWrapper document, List<Element> elementList, Element logo, String title) {
        this(document, elementList, logo, title, 0);
    }

    public PdfBuilder(DocumentWrapper document, List<Element> elementList, Element logo, String title, int totalPages) {
        this.document = document;
        this.elementList = elementList;
        init();
        this.logo = logo;
        this.title = title;
        this.pageNum = 1;
        this.totalPages = totalPages;
    }
    
    public List<Element> getElementList(){
        return elementList;
    }

    public byte[] getPdfData() {
        return outputStream.toByteArray();
    }

    public int getPageNumber() {
        return this.pageNum - 1;
    }

    public PdfBuilder setPageEvent(PdfPageEventHelper pageEvent) {
        this.pdfWriter.setPageEvent(pageEvent);
        return this;
    }

    public PdfBuilder addElement(Element element) {
        elementList.add(element);
        return this;
    }

    public PdfBuilder build() {
        for (Element element : elementList) {
            try {
                document.add(element);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void generatePdf(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(outputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PdfBuilder open() {
        document.open();
        return this;
    }

    public PdfBuilder close() {
        try {
            outputStream.close();
            pdfWriter.close();
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    private String getTitle(){
        return pageNum == 0 ? ("Page " + pageNum) : ("Page " + pageNum + "/" + totalPages);
    }

    private void init() {
        try {
            outputStream = new ByteArrayOutputStream();
            pdfWriter = PdfWriter.getInstance(document, outputStream);
            pdfWriter.setPageEvent(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Page Events */
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
            ++this.pageNum;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}