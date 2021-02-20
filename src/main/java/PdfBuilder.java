import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class PdfBuilder {
    private Document document;
    private PdfWriter pdfWriter;
    private ByteArrayOutputStream outputStream;
    private PdfPageEventHelper pageEvent;

    public PdfBuilder() {
        this(new Document());
    }

    public PdfBuilder(Document document) {
        this.document = document;
        try {
            outputStream = new ByteArrayOutputStream();
            pdfWriter = PdfWriter.getInstance(document, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PdfPageEventHelper getPageEvent() {
        return pageEvent;
    }

    public PdfBuilder setPageEvent(PdfPageEventHelper pageEvent) {
        this.pageEvent = pageEvent;
        this.pdfWriter.setPageEvent(pageEvent);
        return this;
    }

    public PdfBuilder addElement(Element element) {
        try {
            document.add(element);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public byte[] getPdfData() {
        return outputStream.toByteArray();
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
}
