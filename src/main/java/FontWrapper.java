import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;

public class FontWrapper extends Font {
    public FontWrapper() {
        super();
    }

    public FontWrapper(Font.FontFamily family) {
        super(family);
    }

    public FontWrapper(float size) {
        super(Font.FontFamily.HELVETICA, size);
    }

    public FontWrapper(float size, int style) {
        super(Font.FontFamily.HELVETICA, size, style);
    }

    public FontWrapper(Font.FontFamily family, float size) {
        super(family, size);
    }

    public FontWrapper(Font.FontFamily family, float size, int style) {
        super(family, size, style);
    }

    public FontWrapper(Font.FontFamily family, float size, int style, BaseColor color) {
        super(family, size, style, color);
    }

    public FontWrapper withFamily(Font.FontFamily family) {
        super.setFamily(family.toString());
        return this;
    }

    public FontWrapper withSize(float size) {
        super.setSize(size);
        return this;
    }

    public FontWrapper withStyle(int style) {
        super.setStyle(style);
        return this;
    }

    
    public FontWrapper withColor(BaseColor color) {
        super.setColor(color);
        return this;
    }

    public FontWrapper withBoldStyle(){
        super.setStyle(Font.BOLD);
        return this;
    }

    public FontWrapper withItalicStyle(){
        super.setStyle(Font.ITALIC);
        return this;
    }

    public FontWrapper withBoldItalicStyle(){
        super.setStyle(Font.BOLDITALIC);
        return this;
    }
}