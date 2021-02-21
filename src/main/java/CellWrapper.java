import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

public class CellWrapper extends PdfPCell {
    public CellWrapper() {
        super();
    }

    public CellWrapper(int border) {
        this(border, 1);
    }

    public CellWrapper(int border, float borderWidth) {
        this(border, borderWidth, BaseColor.BLACK);
    }

    public CellWrapper(int border, float borderWidth, BaseColor borderColor) {
        this(BaseColor.WHITE, border, borderWidth, borderColor);
    }

    public CellWrapper(BaseColor backgroundColor) {
        this(backgroundColor, 1);
    }

    public CellWrapper(BaseColor backgroundColor, int border) {
        this(backgroundColor, border, 1);
    }

    public CellWrapper(BaseColor backgroundColor, int border, float borderWidth) {
        this(backgroundColor, border, borderWidth, BaseColor.BLACK);
    }

    public CellWrapper(BaseColor backgroundColor, int border, float borderWidth, BaseColor borderColor) {
        super();
        super.setBackgroundColor(backgroundColor);
        super.setBorder(border);
        super.setBorderWidth(borderWidth);
        super.setBorderColor(borderColor);
    }

    public CellWrapper withPhrase(String text, Font font) {
        super.setPhrase(new Phrase(text, font));
        return this;
    }

    public CellWrapper withPhrase(String text, Font.FontFamily fontFamily, float fontSize, int fontStyle) {
        super.setPhrase(new Phrase(text, new Font(fontFamily, fontSize, fontStyle)));
        return this;
    }

    public CellWrapper withBackgroundColor(BaseColor backgroundColor) {
        super.setBackgroundColor(backgroundColor);
        return this;
    }

    public CellWrapper withBorderWidth(float borderWidth) {
        super.setBorderWidth(borderWidth);
        return this;
    }

    public CellWrapper withCellBorderColor(BaseColor borderColor) {
        super.setBorderColor(borderColor);
        return this;
    }

    public CellWrapper withCellBorder(int border) {
        super.setBorder(border);
        return this;
    }

    public CellWrapper withVerticalAlign(int verticalAlignment) {
        super.setVerticalAlignment(verticalAlignment);
        return this;
    }

    public CellWrapper withHorizontalAlign(int horizontalAlignment) {
        super.setHorizontalAlignment(horizontalAlignment);
        return this;
    }

    public CellWrapper withPadding(float padding) {
        super.setPadding(padding);
        return this;
    }
}
