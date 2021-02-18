import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
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
    private PageEvent pageEvent;

    public PdfBuilder(){
        document = new Document(PageSize.A4, 10f, 10f, 15f, 30f);
        try {
            outputStream = new ByteArrayOutputStream();
            pdfWriter = PdfWriter.getInstance(document, outputStream);
            pageEvent = new PageEvent("logo_pdf.png");
            pdfWriter.setPageEvent(pageEvent);
            document.open();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public PdfBuilder(Rectangle pageSize, float marginLeft, float marginRight, float marginTop, float marginBottom, String nameLogo){
        final Rectangle PAGE_SIZE = pageSize == null ? PageSize.A4 : pageSize;
        document = new Document(PAGE_SIZE, marginLeft, marginRight, marginTop, marginBottom);
        try {
            outputStream = new ByteArrayOutputStream();
            pdfWriter = PdfWriter.getInstance(document, outputStream);
            document.open();
            pageEvent = new PageEvent(nameLogo);
            pdfWriter.setPageEvent(pageEvent);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addImage(String name, Integer scalePercent){
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(name).toURI());
            Image img = Image.getInstance(path.toAbsolutePath().toString());
            if(scalePercent != null)
                img.scalePercent(scalePercent);
            document.add(img);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addTable(List<List<String>> data, int numRowsHeader, Float spacingBefore, Float spacingAfter, CellStyle headerStyle, CellStyle bodyStyle){
        final int NUM_COLS = data.get(0).size();
        PdfPTable table = new PdfPTable(NUM_COLS);
        if(spacingBefore != null)
            table.setSpacingBefore(spacingBefore);
        if(spacingAfter != null)
            table.setSpacingAfter(spacingAfter);
        addTableRows(table, data, 0, numRowsHeader, headerStyle);
        addTableRows(table, data, numRowsHeader, data.size(), bodyStyle);
        try{
            document.add(table);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addTableRows(PdfPTable table, List<List<String>> rows, int from, int to, CellStyle cellStyle){
        for(int i = from; i < to; i++){
            addTableRow(table, rows.get(i), cellStyle);
        }
    }

    public void addTableRow(PdfPTable table, List<String> row, CellStyle cellStyle){
        for(String text : row){
            table.addCell(cellStyle.buildCellWithStyles(text));
        }
    }

    public void closeDocument(){
        document.close();
    }

    public byte[] getBytes(){
        return outputStream.toByteArray();
    }

    public void generatePdf(String filename){
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(outputStream.toByteArray());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
