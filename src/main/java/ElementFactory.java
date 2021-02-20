import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class ElementFactory {
    private Font font;
    private Phrase phrase;
    private Image image;
    private PdfPCell cell;
    private PdfPTable table;
    private Document document;

    /** Getters **/
    public Font getFont() {
        return font;
    }

    public Phrase getPhrase() {
        return phrase;
    }

    public Image getImage() {
        return image;
    }

    public PdfPCell getCell() {
        return cell;
    }

    public PdfPTable getTable() {
        return table;
    }

    public Document getDocument() {
        return document;
    }

    /** Setters **/
    /* Font Setters */
    public ElementFactory setFontFamily(Font.FontFamily family) {
        font.setFamily(family.toString());
        return this;
    }

    public ElementFactory setFontSize(float size) {
        font.setSize(size);
        return this;
    }

    public ElementFactory setFontStyle(int style) {
        font.setStyle(style);
        return this;
    }

    /* Phrase Setters */
    public ElementFactory setPhraseFont(Font font) {
        phrase.setFont(font);
        return this;
    }

    /* Image Setters */
    public ElementFactory setImageAlignment(int alignment) {
        image.setAlignment(alignment);
        return this;
    }

    public ElementFactory setImageSpacingAfter(float spacing) {
        image.setSpacingAfter(spacing);
        return this;
    }

    public ElementFactory setImageSpacingBefore(float spacing) {
        image.setSpacingBefore(spacing);
        return this;
    }

    public ElementFactory setImageAbsolutePosition(float absoluteX, float absoluteY) {
        image.setAbsolutePosition(absoluteX, absoluteY);
        return this;
    }

    public ElementFactory setImageAlt(String alt) {
        image.setAlt(alt);
        return this;
    }

    public ElementFactory setImageRotationDegrees(float alt) {
        image.setRotationDegrees(alt);
        return this;
    }

    public ElementFactory setImageScaleToFitHeight(boolean flag) {
        image.setScaleToFitHeight(flag);
        return this;
    }

    public ElementFactory setImageScaleToFitLineWhenOverflow(boolean flag) {
        image.setScaleToFitLineWhenOverflow(flag);
        return this;
    }

    /* Cell Setters */
    public ElementFactory setCellPhrase(String text) {
        phrase = new Phrase(text, font);
        cell.setPhrase(phrase);
        return this;
    }

    public ElementFactory setCellPhraseAndFont(String text, Font.FontFamily fontFamily, float fontSize, int fontStyle) {
        font = new Font(fontFamily, fontSize, fontStyle);
        phrase = new Phrase(text, font);
        cell.setPhrase(phrase);
        return this;
    }

    public ElementFactory setCellBackgroundColor(BaseColor backgroundColor) {
        cell.setBackgroundColor(backgroundColor);
        return this;
    }

    public ElementFactory setCellBorderWidth(float borderWidth) {
        cell.setBorderWidth(borderWidth);
        return this;
    }

    public ElementFactory setCellBorderColor(BaseColor borderColor) {
        cell.setBorderColor(borderColor);
        return this;
    }

    public ElementFactory setCellBorder(int border) {
        cell.setBorder(border);
        return this;
    }

    public ElementFactory setCellVerticalAlignment(int verticalAlignment) {
        cell.setVerticalAlignment(verticalAlignment);
        return this;
    }

    public ElementFactory setCellPadding(float padding) {
        cell.setPadding(padding);
        return this;
    }

    /* Table Setters */
    public ElementFactory setTableSpacingBefore(float spacingBefore) {
        table.setSpacingBefore(spacingBefore);
        return this;
    }

    public ElementFactory setTableSpacingAfter(float spacingAfter) {
        table.setSpacingAfter(spacingAfter);
        return this;
    }

    public ElementFactory setTableTotalWidth(float totalWidth) {
        table.setTotalWidth(totalWidth);
        return this;
    }

    public ElementFactory setTableWidthPercentage(float widthPercentage) {
        table.setWidthPercentage(widthPercentage);
        return this;
    }

    public ElementFactory setTableWidths(float[] widths) {
        try {
            table.setWidths(widths);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ElementFactory setTableHorizontalAlignment(int horizontalAlignment) {
        table.setHorizontalAlignment(horizontalAlignment);
        return this;
    }

    public ElementFactory setTableSplitLate(boolean splitLate) {
        table.setSplitLate(splitLate);
        return this;
    }

    public ElementFactory setTableSplitRows(boolean splitRows) {
        table.setSplitRows(splitRows);
        return this;
    }

    /* Document Setters */
    public ElementFactory setDocPageSize(Rectangle pageSize) {
        document.setPageSize(pageSize);
        return this;
    }

    public ElementFactory setMargins(float marginLeft, float marginRight, float marginTop, float marginBottom) {
        document.setMargins(marginLeft, marginRight, marginTop, marginBottom);
        return this;
    }

    /** Methods **/
    /* Font Methods */
    public ElementFactory buildFont() {
        font = newFont();
        return this;
    }

    public Font newFont() {
        return newFont(Font.FontFamily.UNDEFINED);
    }

    public Font newFont(Font.FontFamily family) {
        return newFont(family, Font.UNDEFINED);
    }

    public Font newFont(Font.FontFamily family, int size) {
        return newFont(family, size, Font.NORMAL);
    }

    public Font newFont(Font.FontFamily family, int size, int style) {
        font = new Font(family, size, style);
        return font;
    }

    /* Phrase Methods */
    public ElementFactory buildPhrase() {
        phrase = newPhrase();
        return this;
    }

    public Phrase newPhrase() {
        return new Phrase();
    }

    public Phrase newPhrase(String text) {
        return newPhrase(text, new Font());
    }

    public Phrase newPhrase(String text, Font font) {
        return new Phrase(text, font);
    }

    /* Image Methods */
    public ElementFactory buildImage(String filename) {
        image = newImage(filename);
        return this;
    }

    public Image newImage(String filename) {
        return newImage(filename, null);
    }

    public Image newImage(String filename, Integer scalePercent) {
        return newImage(filename, scalePercent, null, null);
    }

    public Image newImage(String filename, Integer scalePercent, Float absoluteX, Float absoluteY) {
        try {
            Path path = Paths.get(PdfBuilder.class.getClassLoader().getResource(filename).toURI());
            image = Image.getInstance(path.toAbsolutePath().toString());
            if (scalePercent != null)
                image.scalePercent(scalePercent);
            if (absoluteX != null && absoluteY != null)
                image.setAbsolutePosition(absoluteX, absoluteY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    /* PdfPCell Methods */
    public ElementFactory buildCell() {
        cell = newCell();
        return this;
    }

    public PdfPCell newCell() {
        return newCell(null);
    }

    public PdfPCell newCell(BaseColor bgColor) {
        return newCell(bgColor, null);
    }

    public PdfPCell newCell(BaseColor bgColor, Integer border) {
        return newCell(bgColor, border, null);
    }

    public PdfPCell newCell(BaseColor bgColor, Integer border, Float borderWidth) {
        return newCell(bgColor, border, borderWidth, null);
    }

    public PdfPCell newCell(BaseColor bgColor, Integer border, Float borderWidth, BaseColor borderColor) {
        return newCell(bgColor, border, borderWidth, borderColor, null);
    }

    public PdfPCell newCell(BaseColor bgColor, Integer border, Float borderWidth, BaseColor borderColor,
            Float padding) {
        return newCell(bgColor, border, borderWidth, borderColor, null, padding);
    }

    public PdfPCell newCell(BaseColor bgColor, Integer border, Float borderWidth, Integer align, Float padding) {
        return newCell(bgColor, border, borderWidth, null, align, padding);
    }

    public PdfPCell newCell(BaseColor bgColor, Integer border, Float borderWidth, BaseColor borderColor, Integer align,
            Float padding) {
        cell = new PdfPCell();
        if (bgColor != null)
            cell.setBackgroundColor(bgColor);
        if (border != null)
            cell.setBorder(border);
        if (borderWidth != null)
            cell.setBorderWidth(borderWidth);
        if (borderColor != null)
            cell.setBorderColor(borderColor);
        if (padding != null)
            cell.setPadding(padding);
        if (align != null)
            cell.setVerticalAlignment(align);
        return cell;
    }

    /* PdfPTable Methods */
    public ElementFactory buildTable(List<List<String>> data, int headerRows) {
        table = newTable(data, headerRows);
        return this;
    }

    public PdfPTable newTable(List<List<String>> data, int headerRows) {
        return newTable(data, headerRows, 0);
    }

    public PdfPTable newTable(List<List<String>> data, int headerRows, PdfPCell headerCell, PdfPCell bodyCell) {
        return newTable(data, headerRows, 0, headerCell, bodyCell, null);
    }

    public PdfPTable newTable(List<List<String>> data, int headerRows, int footerRows) {
        return newTable(data, headerRows, footerRows, null, null, null);
    }

    public PdfPTable newTable(List<List<String>> data, int headerRows, int footerRows, PdfPCell headerCell,
            PdfPCell bodyCell, PdfPCell footerCell) {
        return newTable(data, headerRows, footerRows, headerCell, bodyCell, footerCell, null);
    }

    public PdfPTable newTable(List<List<String>> data, int headerRows, int footerRows, PdfPCell headerCell,
            PdfPCell bodyCell, PdfPCell footerCell, Font font) {
        return newTable(data, headerRows, footerRows, headerCell, bodyCell, footerCell, font, null, null);
    }

    public PdfPTable newTable(List<List<String>> data, int headerRows, int footerRows, PdfPCell headerCell,
            PdfPCell bodyCell, PdfPCell footerCell, Font font, Float spacingBefore, Float spacingAfter) {
        return newTable(data, headerRows, footerRows, headerCell, bodyCell, footerCell, font, spacingBefore,
                spacingAfter, null);
    }

    public PdfPTable newTable(List<List<String>> data, int headerRows, int footerRows, PdfPCell headerCell,
            PdfPCell bodyCell, PdfPCell footerCell, Font font, Float spacingBefore, Float spacingAfter,
            float[] widths) {
        return newTable(data, headerRows, footerRows, headerCell, bodyCell, footerCell, font, spacingBefore,
                spacingAfter, widths, null, null, null, null, null);
    }

    public PdfPTable newTable(List<List<String>> data, int headerRows, int footerRows, PdfPCell headerCell,
            PdfPCell bodyCell, PdfPCell footerCell, Font font, Float spacingBefore, Float spacingAfter, float[] widths,
            Float totalWidth, Float widthPercentage, Integer align, Boolean splitLate, Boolean splitRows) {
        final int COLUMNS = data.get(0).size();
        table = new PdfPTable(COLUMNS);
        try {
            if (headerCell == null)
                headerCell = new PdfPCell();
            if (bodyCell == null)
                bodyCell = new PdfPCell();
            if (footerCell == null)
                footerCell = new PdfPCell();
            if (font == null)
                font = new Font();
            if (spacingBefore != null)
                table.setSpacingBefore(spacingBefore);
            if (spacingAfter != null)
                table.setSpacingAfter(spacingAfter);
            if (totalWidth != null)
                table.setTotalWidth(totalWidth);
            if (widthPercentage != null)
                table.setWidthPercentage(widthPercentage);
            if (widths != null)
                table.setWidths(widths);
            if (align != null)
                table.setHorizontalAlignment(align);
            if (splitLate != null)
                table.setSplitLate(splitLate);
            if (splitRows != null)
                table.setSplitRows(splitRows);
            fillTable(data, headerRows, footerRows, headerCell, bodyCell, footerCell, font);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    private void fillTable(List<List<String>> data, int headerRows, int footerRows, PdfPCell headerCell,
            PdfPCell bodyCell, PdfPCell footerCell, Font font) {
        final int TABLE_SIZE = data.size();
        final int FOOTER_START = TABLE_SIZE - footerRows;
        for (int i = 0; i < headerRows; i++) {
            for (String text : data.get(i)) {
                headerCell.setPhrase(new Phrase(text, font));
                table.addCell(headerCell);
            }
        }
        for (int i = headerRows; i < FOOTER_START; i++) {
            for (String text : data.get(i)) {
                bodyCell.setPhrase(new Phrase(text, font));
                table.addCell(bodyCell);
            }
        }
        for (int i = FOOTER_START; i < TABLE_SIZE; i++) {
            for (String text : data.get(i)) {
                footerCell.setPhrase(new Phrase(text, font));
                table.addCell(footerCell);
            }
        }
    }

    /* Document Methods */
    public ElementFactory buildDocument() {
        document = newDocument();
        return this;
    }

    public Document newDocument() {
        return newDocument(PageSize.A4);
    }

    public Document newDocument(Rectangle pageSize) {
        return newDocument(pageSize, 0, 0, 0, 0);
    }

    public Document newDocument(float marginLeft, float marginRight, float marginTop, float marginBottom) {
        return newDocument(PageSize.A4, 0, 0, 0, 0);
    }

    public Document newDocument(Rectangle pageSize, float marginLeft, float marginRight, float marginTop,
            float marginBottom) {
        document = new Document(pageSize, marginLeft, marginRight, marginTop, marginBottom);
        return document;
    }
}
