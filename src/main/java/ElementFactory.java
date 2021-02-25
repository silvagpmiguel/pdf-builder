import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;

public class ElementFactory {
    /* FontWrapper Methods */
    public static FontWrapper newFont() {
        return new FontWrapper();
    }

    public static FontWrapper newFont(Font.FontFamily family) {
        return new FontWrapper(family);
    }

    public static FontWrapper newFont(Font.FontFamily family, float size) {
        return new FontWrapper(family, size);
    }

    public static FontWrapper newFont(Font.FontFamily family, float size, int style) {
        return new FontWrapper(family, size, style);
    }

    /* Phrase Methods */
    public static PhraseWrapper newPhrase() {
        return new PhraseWrapper();
    }

    public static PhraseWrapper newPhrase(String text) {
        return new PhraseWrapper(text);
    }

    public static PhraseWrapper newPhrase(String text, FontWrapper FontWrapper) {
        return new PhraseWrapper(text, FontWrapper);
    }

    /* Image Methods */
    public static ImageWrapper newImage(String filename) {
        return new ImageWrapper(filename);
    }

    public static ImageWrapper newImage(String filename, float scalePercent) {
        return new ImageWrapper(filename, scalePercent);
    }

    public static Image newImage(String filename, int scalePercent, float absoluteX, float absoluteY) {
        return new ImageWrapper(filename, scalePercent, absoluteX, absoluteY);
    }

    /* CellWrapper Methods */
    public static CellWrapper newCell() {
        return new CellWrapper();
    }

    public static CellWrapper newCell(int border) {
        return new CellWrapper(border);
    }

    public static CellWrapper newCell(int border, float borderWidth) {
        return new CellWrapper(border, borderWidth);
    }

    public static CellWrapper newCell(int border, float borderWidth, BaseColor borderColor) {
        return new CellWrapper(border, borderWidth, borderColor);
    }

    public static CellWrapper newCell(BaseColor bgColor) {
        return new CellWrapper(bgColor);
    }

    public static CellWrapper newCell(BaseColor bgColor, int border) {
        return new CellWrapper(bgColor, border);
    }

    public static CellWrapper newCell(BaseColor bgColor, int border, float borderWidth) {
        return new CellWrapper(bgColor, border, borderWidth);
    }

    public static CellWrapper newCell(BaseColor bgColor, int border, float borderWidth, BaseColor borderColor) {
        return new CellWrapper(bgColor, border, borderWidth, borderColor);
    }

    /* PdfPTable Methods */
    public static TableWrapper newTable(int cols){
        return new TableWrapper(cols);
    }

    public static TableWrapper newTable(float[] widths){
        return new TableWrapper(widths);
    }

    public static TableWrapper newTable(List<List<String>> data) {
        return new TableWrapper(data);
    }

    public static TableWrapper newTable(List<List<String>> data, int headerRows, CellWrapper headerCell) {
        return new TableWrapper(data, new CellWrapper(), new FontWrapper(), headerRows, headerCell, new FontWrapper());
    }

    public static TableWrapper newTable(List<List<String>> data, int headerRows, CellWrapper headerCell, FontWrapper headerFont) {
        return new TableWrapper(data, new CellWrapper(), new FontWrapper(), headerRows, headerCell, headerFont, 0,
                new CellWrapper());
    }

    public static TableWrapper newTable(List<List<String>> data, int headerRows, CellWrapper headerCell, FontWrapper headerFont,
            int footerRows, CellWrapper footerCell) {
        return new TableWrapper(data, new CellWrapper(), new FontWrapper(), headerRows, headerCell, headerFont, footerRows,
                footerCell, new FontWrapper());
    }

    public static TableWrapper newTable(List<List<String>> data, int headerRows, CellWrapper headerCell, FontWrapper headerFont,
            int footerRows, CellWrapper footerCell, FontWrapper footerFontWrapper) {
        return new TableWrapper(data, new CellWrapper(), new FontWrapper(), headerRows, headerCell, headerFont, footerRows,
                footerCell, footerFontWrapper);
    }

    public static TableWrapper newTable(List<List<String>> data, CellWrapper bodyCell) {
        return new TableWrapper(data, bodyCell);
    }

    public static TableWrapper newTable(List<List<String>> data, CellWrapper bodyCell, FontWrapper bodyFont) {
        return new TableWrapper(data, bodyCell, bodyFont);
    }

    public static TableWrapper newTable(List<List<String>> data, CellWrapper bodyCell, FontWrapper bodyFont, int headerRows,
            CellWrapper headerCell) {
        return new TableWrapper(data, bodyCell, bodyFont, headerRows, headerCell);
    }

    public static TableWrapper newTable(List<List<String>> data, CellWrapper bodyCell, FontWrapper bodyFont, int headerRows,
            CellWrapper headerCell, FontWrapper headerFont) {
        return new TableWrapper(data, bodyCell, bodyFont, headerRows, headerCell, headerFont);
    }

    public static TableWrapper newTable(List<List<String>> data, CellWrapper bodyCell, FontWrapper bodyFont, int headerRows,
            CellWrapper headerCell, FontWrapper headerFont, int footerRows, CellWrapper footerCell) {
        return new TableWrapper(data, bodyCell, bodyFont, headerRows, headerCell, headerFont, footerRows, footerCell);
    }

    public static TableWrapper newTable(List<List<String>> data, CellWrapper bodyCell, FontWrapper bodyFont, int headerRows,
            CellWrapper headerCell, FontWrapper headerFont, int footerRows, CellWrapper footerCell, FontWrapper footerFontWrapper) {
        return new TableWrapper(data, bodyCell, bodyFont, headerRows, headerCell, headerFont, footerRows, footerCell,
                footerFontWrapper);
    }

    /* Document Methods */
    public static DocumentWrapper newDocument() {
        return new DocumentWrapper();
    }

    public static DocumentWrapper newDocument(Rectangle pageSize) {
        return new DocumentWrapper(pageSize);
    }

    public static DocumentWrapper newDocument(float marginLeft,
            float marginRight,
            float marginTop,
            float marginBottom) {
        return new DocumentWrapper(PageSize.A4, marginLeft, marginRight, marginTop, marginBottom);
    }

    public static DocumentWrapper newDocument(float... margins) {
        return new DocumentWrapper(PageSize.A4, margins);
    }

    public static DocumentWrapper newDocument(Rectangle pageSize,
            float marginLeft,
            float marginRight,
            float marginTop,
            float marginBottom) {
        return new DocumentWrapper(pageSize, marginLeft, marginRight, marginTop, marginBottom);
    }

    public static DocumentWrapper newDocument(Rectangle pageSize, float... margins) {
        return new DocumentWrapper(pageSize, margins[0], margins[1], margins[2], margins[3]);
    }
}
