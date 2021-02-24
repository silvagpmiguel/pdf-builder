import com.itextpdf.text.Element;

public interface ElementWrapper extends Element {
    public boolean needPageBreak();
}
