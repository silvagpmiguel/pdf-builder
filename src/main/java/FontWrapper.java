import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;

public class FontWrapper extends Font {
    public FontWrapper() {
        this(Font.FontFamily.UNDEFINED);
    }

    public FontWrapper(Font.FontFamily family) {
        this(family, DEFAULTSIZE);
    }

    public FontWrapper(float size) {
        this(size, Font.NORMAL);
    }

    public FontWrapper(float size, int style) {
        this(Font.FontFamily.UNDEFINED, size, style);
    }

    public FontWrapper(Font.FontFamily family, float size) {
        this(family, size, Font.NORMAL);
    }

    public FontWrapper(Font.FontFamily family, float size, int style) {
        this(family, size, style, BaseColor.BLACK);
    }

    public FontWrapper(Font.FontFamily family, float size, int style, BaseColor color) {
        super(family, size, style, color);
    }

    public FontWrapper withFamily(Font.FontFamily family) {
        setFamily(family.toString());
        return this;
    }

    public FontWrapper withSize(float size) {
        setSize(size);
        return this;
    }

    public FontWrapper withStyle(int style) {
        setStyle(style);
        return this;
    }

    public FontWrapper withColor(BaseColor color) {
        setColor(color);
        return this;
    }

    public FontWrapper withBoldStyle() {
        setStyle(Font.BOLD);
        return this;
    }

    public FontWrapper withItalicStyle() {
        setStyle(Font.ITALIC);
        return this;
    }

    public FontWrapper withBoldItalicStyle() {
        setStyle(Font.BOLDITALIC);
        return this;
    }
}
