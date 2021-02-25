import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;

public class DocumentWrapper extends Document {

    public DocumentWrapper() {
        super();
    }

    public DocumentWrapper(Rectangle pageSize) {
        this(pageSize, 0, 0, 0, 0);
    }

    public DocumentWrapper(float marginLeft,
            float marginRight,
            float marginTop,
            float marginBottom) {
        this(PageSize.A4, marginLeft, marginRight, marginTop, marginBottom);
    }

    public DocumentWrapper(float... margins) {
        this(PageSize.A4, margins);
    }

    public DocumentWrapper(Rectangle pageSize,
            float marginLeft,
            float marginRight,
            float marginTop,
            float marginBottom) {
        super(pageSize, marginLeft, marginRight, marginTop, marginBottom);
    }

    public DocumentWrapper(Rectangle pageSize, float... margins) {
        super(pageSize, margins[0], margins[1], margins[2], margins[3]);
    }

    public DocumentWrapper addNewPage() {
        newPage();
        return this;
    }

    public DocumentWrapper withPageSize(Rectangle pageSize) {
        setPageSize(pageSize);
        return this;
    }

    public DocumentWrapper
            withMargins(float marginLeft, float marginRight, float marginTop, float marginBottom) {
        setMargins(marginLeft, marginRight, marginTop, marginBottom);
        return this;
    }
}
