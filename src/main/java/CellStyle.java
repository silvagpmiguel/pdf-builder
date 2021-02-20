import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

public class CellStyle {
    private BaseColor backgroundColor;
    private Float borderWidth;
    private BaseColor borderColor;
    private Integer border;
    private Integer alignment;
    private Float padding;
    private Font.FontFamily fontFamily;
    private Float fontSize;
    private Integer fontStyle;

    public CellStyle(){}

    public CellStyle(BaseColor backgroundColor, Integer border, BaseColor borderColor, Float borderWidth,
            Integer alignment, Float padding, Font.FontFamily family, Float fontSize, Integer fontStyle) {
        this.backgroundColor = backgroundColor;
        this.border = border;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        this.alignment = alignment;
        this.padding = padding;
        this.fontFamily = family;
        this.fontSize = fontSize;
        this.fontStyle = fontStyle;
    }

    public BaseColor getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(BaseColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Integer getBorder() {
        return border;
    }

    public void setBorder(Integer border) {
        this.border = border;
    }

    public Float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Float borderWidth) {
        this.borderWidth = borderWidth;
    }

    public BaseColor getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(BaseColor borderColor) {
        this.borderColor = borderColor;
    }

    public Integer getAlignment() {
        return alignment;
    }

    public void setAlignment(Integer alignment) {
        this.alignment = alignment;
    }

    public Float getPadding() {
        return padding;
    }

    public void setPadding(Float padding) {
        this.padding = padding;
    }

    public Font.FontFamily getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(Font.FontFamily family) {
        this.fontFamily = family;
    }

    public Float getFontSize() {
        return fontSize;
    }

    public void setFontSize(Float fontSize) {
        this.fontSize = fontSize;
    }

    public Integer getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(Integer fontStyle) {
        this.fontStyle = fontStyle;
    }

    public PdfPCell buildCellWithStyles(String text) {
        PdfPCell cell = new PdfPCell();
        Font font = new Font();
        if (backgroundColor != null)
            cell.setBackgroundColor(this.backgroundColor);
        if (border != null)
            cell.setBorder(border);
        if (borderWidth != null)
            cell.setBorderWidth(borderWidth);
        if (borderColor != null)
            cell.setBorderColor(borderColor);
        if (padding != null)
            cell.setPadding(padding);
        if (alignment != null)
            cell.setVerticalAlignment(alignment);
        if(fontFamily != null)
            font.setFamily(fontFamily.toString());
        if(fontSize != null)
            font.setSize(fontSize);
        if(fontStyle != null)
            font.setStyle(fontStyle);
        cell.setPhrase(new Phrase(text, font));
        return cell;
    }
}
