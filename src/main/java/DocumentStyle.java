import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;

public class DocumentStyle {
    private Rectangle pageSize;
    private float marginLeft;
    private float marginRight;
    private float marginTop;
    private float marginBottom;

    public DocumentStyle() {
        this(PageSize.A4, 10f, 10f, 15f, 30f);
    }

    public DocumentStyle(Rectangle pageSize, float marginLeft, float marginRight, float marginTop, float marginBottom) {
        this.pageSize = pageSize;
        this.marginLeft = marginLeft;
        this.marginRight = marginRight;
        this.marginTop = marginTop;
        this.marginBottom = marginBottom;
    }

    public Rectangle getPageSize() {
        return pageSize;
    }

    public void setPageSize(Rectangle pageSize) {
        this.pageSize = pageSize;
    }

    public float getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(float marginLeft) {
        this.marginLeft = marginLeft;
    }

    public float getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(float marginRight) {
        this.marginRight = marginRight;
    }

    public float getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(float marginTop) {
        this.marginTop = marginTop;
    }

    public float getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(float marginBottom) {
        this.marginBottom = marginBottom;
    }

    public Document buildDocumentWithStyles() {
        return new Document(pageSize, marginLeft, marginRight, marginTop, marginBottom);
    }
}
