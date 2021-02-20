import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PdfBuilder {
    private Document document;
    private PdfWriter pdfWriter;
    private ByteArrayOutputStream outputStream;
    private PdfPageEventHelper pageEvent;

    public PdfBuilder() {
        this(new DocumentStyle());
    }

    public PdfBuilder(DocumentStyle documentStyle) {
        document = documentStyle.buildDocumentWithStyles();
        try {
            outputStream = new ByteArrayOutputStream();
            pdfWriter = PdfWriter.getInstance(document, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Element buildImage(String name, Integer scalePercent) {
        Image image = null;
        try {
            Path path = Paths.get(PdfBuilder.class.getClassLoader().getResource(name).toURI());
            image = Image.getInstance(path.toAbsolutePath().toString());
            if (scalePercent != null)
                image.scalePercent(scalePercent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public static Element buildTable(List<List<String>> data, int numRowsHeader, TableStyle tableStyle,
            CellStyle headerStyle, CellStyle bodyStyle) {
        final int COL_NUM = data.get(0).size();
        PdfPTable table = tableStyle.buildTableWithStyles(COL_NUM);
        buildTableRows(table, data, 0, numRowsHeader, headerStyle);
        buildTableRows(table, data, numRowsHeader, data.size(), bodyStyle);
        return table;
    }

    public PdfBuilder addElement(Element element) {
        try {
            document.add(element);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public static void buildTableRows(PdfPTable table, List<List<String>> rows, int from, int to, CellStyle cellStyle) {
        for (int i = from; i < to; i++) {
            buildTableRow(table, rows.get(i), cellStyle);
        }
    }

    public static void buildTableRow(PdfPTable table, List<String> row, CellStyle cellStyle) {
        for (String text : row) {
            table.addCell(cellStyle.buildCellWithStyles(text));
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
}
