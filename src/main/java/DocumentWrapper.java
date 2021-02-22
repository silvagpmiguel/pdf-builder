import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;

public class DocumentWrapper extends Document {

    public DocumentWrapper() {
        super();
    }

    public DocumentWrapper(Rectangle pageSize) {
        super(PageSize.A4);
    }

    public DocumentWrapper(float marginLeft, float marginRight, float marginTop, float marginBottom) {
        super(PageSize.A4, marginLeft, marginRight, marginTop, marginBottom);
    }

    public DocumentWrapper(Rectangle pageSize, float marginLeft, float marginRight, float marginTop,
            float marginBottom) {
        super(pageSize, marginLeft, marginRight, marginTop, marginBottom);
    }

    public DocumentWrapper addNewPage() {
        super.newPage();
        return this;
    }

    public DocumentWrapper withPageSize(Rectangle pageSize) {
        super.setPageSize(pageSize);
        return this;
    }

    public DocumentWrapper withMargins(float marginLeft, float marginRight, float marginTop, float marginBottom) {
        super.setMargins(marginLeft, marginRight, marginTop, marginBottom);
        return this;
    }

    public DocumentWrapper clone() {
        return new DocumentWrapper(pageSize, marginLeft, marginRight, marginTop, marginBottom);
    }
}
