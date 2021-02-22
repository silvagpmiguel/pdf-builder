import java.util.List;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class TableWrapper extends PdfPTable {
    private List<List<String>> data;
    private PdfPCell bodyCell;
    private Font bodyFont;
    private int headerRows;
    private PdfPCell headerCell;
    private Font headerFont;
    private int footerRows;
    private PdfPCell footerCell;
    private Font footerFont;

    public TableWrapper(int cols){
        super(cols);
    }

    public TableWrapper(float[] widths){
        super(widths);
    }

    public TableWrapper(List<List<String>> data) {
        this(data, new PdfPCell());
    }

    public TableWrapper(List<List<String>> data, int headerRows, PdfPCell headerCell) {
        this(data, new PdfPCell(), new Font(), headerRows, headerCell, new Font());
    }

    public TableWrapper(List<List<String>> data, int headerRows, PdfPCell headerCell, Font headerFont) {
        this(data, new PdfPCell(), new Font(), headerRows, headerCell, headerFont, 0, new PdfPCell());
    }

    public TableWrapper(List<List<String>> data, int headerRows, PdfPCell headerCell, Font headerFont, int footerRows,
            PdfPCell footerCell) {
        this(data, new PdfPCell(), new Font(), headerRows, headerCell, headerFont, footerRows, footerCell, new Font());
    }

    public TableWrapper(List<List<String>> data, int headerRows, PdfPCell headerCell, Font headerFont, int footerRows,
            PdfPCell footerCell, Font footerFont) {
        this(data, new PdfPCell(), new Font(), headerRows, headerCell, headerFont, footerRows, footerCell, footerFont);
    }

    public TableWrapper(List<List<String>> data, PdfPCell bodyCell) {
        this(data, bodyCell, new Font());
    }

    public TableWrapper(List<List<String>> data, PdfPCell bodyCell, Font bodyFont) {
        this(data, bodyCell, bodyFont, 0, new PdfPCell());
    }

    public TableWrapper(List<List<String>> data, PdfPCell bodyCell, Font bodyFont, int headerRows,
            PdfPCell headerCell) {
        this(data, bodyCell, bodyFont, headerRows, headerCell, new Font());
    }

    public TableWrapper(List<List<String>> data, PdfPCell bodyCell, Font bodyFont, int headerRows, PdfPCell headerCell,
            Font headerFont) {
        this(data, bodyCell, bodyFont, headerRows, headerCell, headerFont, 0, new PdfPCell());
    }

    public TableWrapper(List<List<String>> data, PdfPCell bodyCell, Font bodyFont, int headerRows, PdfPCell headerCell,
            Font headerFont, int footerRows, PdfPCell footerCell) {
        this(data, bodyCell, bodyFont, headerRows, headerCell, headerFont, footerRows, footerCell, new Font());
    }

    public TableWrapper(List<List<String>> data, PdfPCell bodyCell, Font bodyFont, int headerRows, PdfPCell headerCell,
            Font headerFont, int footerRows, PdfPCell footerCell, Font footerFont) {
        super(data.get(0).size());
        this.data = data;
        this.bodyCell = bodyCell;
        this.bodyFont = bodyFont;
        this.headerRows = headerRows;
        this.headerCell = headerCell;
        this.headerFont = headerFont;
        this.footerRows = footerRows;
        this.footerCell = footerCell;
        this.footerFont = footerFont;
        fillTable();
    }

    public TableWrapper withSpacingBefore(float spacingBefore) {
        super.setSpacingBefore(spacingBefore);
        return this;
    }

    public TableWrapper withSpacingAfter(float spacingAfter) {
        super.setSpacingAfter(spacingAfter);
        return this;
    }

    public TableWrapper withTotalWidth(float totalWidth) {
        super.setTotalWidth(totalWidth);
        return this;
    }

    public TableWrapper withWidthPercentage(float widthPercentage) {
        super.setWidthPercentage(widthPercentage);
        return this;
    }

    public TableWrapper withWidths(float[] widths) {
        try {
            super.setWidths(widths);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return this;
    }

    public TableWrapper withHorizontalAlignment(int horizontalAlignment) {
        super.setHorizontalAlignment(horizontalAlignment);
        return this;
    }

    public TableWrapper withSplitLate(boolean splitLate) {
        super.setSplitLate(splitLate);
        return this;
    }

    public TableWrapper withSplitRows(boolean splitRows) {
        super.setSplitRows(splitRows);
        return this;
    }

    public TableWrapper addTextCell(String text){
        return addTextCell(text, new PdfPCell(), new Font());
    }

    public TableWrapper addTextCell(String text, PdfPCell cell){
        return addTextCell(text, cell, new Font());
    }

    public TableWrapper addTextCell(String text, Font font){
        return addTextCell(text, new CellWrapper(), font);
    }

    public TableWrapper addTextCell(String text, PdfPCell cell, Font font){
        cell.setPhrase(new Phrase(text, font));
        addCell(cell);
        return this;
    }

    public TableWrapper addTextRow(List<String> row){
        return addTextRow(row, new CellWrapper(), new FontWrapper());
    }
    
    public TableWrapper addTextRow(List<String> row, PdfPCell cell){
        return addTextRow(row, cell, new FontWrapper());
    }

    public TableWrapper addTextRow(List<String> row, Font font){
        return addTextRow(row, new CellWrapper(), font);
    }

    public TableWrapper addTextRow(List<String> row, PdfPCell cell, Font font){
        for(String text : row){
            cell.setPhrase(new Phrase(text, font));
            addCell(cell);
        }
        return this;
    }

    private void fillTable() {
        final int TABLE_SIZE = data.size();
        final int FOOTER_START = TABLE_SIZE - footerRows;

        for (int i = 0; i < headerRows; i++) {
            for (String text : data.get(i)) {
                headerCell.setPhrase(new Phrase(text, headerFont));
                addCell(headerCell);
            }
        }

        for (int i = headerRows; i < FOOTER_START; i++) {
            for (String text : data.get(i)) {
                bodyCell.setPhrase(new Phrase(text, bodyFont));
                addCell(bodyCell);
            }
        }

        for (int i = FOOTER_START; i < TABLE_SIZE; i++) {
            for (String text : data.get(i)) {
                footerCell.setPhrase(new Phrase(text, footerFont));
                addCell(footerCell);
            }
        }
    }
}
