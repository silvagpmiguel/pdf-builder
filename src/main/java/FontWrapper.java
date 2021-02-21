import com.itextpdf.text.Font;

public class FontWrapper extends Font {
    public FontWrapper() {
        super();
    }

    public FontWrapper(Font.FontFamily family) {
        super(family);
    }

    public FontWrapper(Font.FontFamily family, float size) {
        super(family, size);
    }

    public FontWrapper(Font.FontFamily family, float size, int style) {
        super(family, size, style);
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
}
