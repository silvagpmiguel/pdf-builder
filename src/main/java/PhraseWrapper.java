import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;

public class PhraseWrapper extends Phrase implements ElementWrapper{
    private boolean needPageBreak = false;
    private static final long serialVersionUID = 8364750317580117161L;

    public PhraseWrapper() {
        super();
    }

    public PhraseWrapper(String text) {
        super(text);
    }

    public PhraseWrapper(String text, Font font) {
        super(text, font);
    }

    public PhraseWrapper(String text, Font.FontFamily family, float size, int style) {
        super(text, new Font(family, size, style));
    }

    public PhraseWrapper withFont(Font font) {
        setFont(font);
        return this;
    }

    public PhraseWrapper withFont(Font.FontFamily family, float size, int style) {
        setFont(new Font(family, size, style));
        return this;
    }

    public PhraseWrapper withPageBreak(){
        this.needPageBreak = true;
        return this;
    }
    
    @Override
    public boolean needPageBreak() {
        return this.needPageBreak;
    }
}
