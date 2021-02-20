import com.itextpdf.text.pdf.PdfPTable;

public class TableStyle {
    private Float spacingBefore;
    private Float spacingAfter;
    private Float totalWidth;
    private Float widthPercentage;
    private float[] widths;
    private Integer horizontalAlignment;
    private Boolean splitLate;
    private Boolean splitRows;

    public TableStyle() {
    }

    public TableStyle(Float spacingBefore, Float spacingAfter, Float totalWidth, Float widthPercentage, float[] widths,
            Integer horizontalAlignment, Boolean splitLate, Boolean splitRows) {
        this.spacingBefore = spacingBefore;
        this.spacingAfter = spacingAfter;
        this.totalWidth = totalWidth;
        this.widthPercentage = widthPercentage;
        this.widths = widths;
        this.horizontalAlignment = horizontalAlignment;
        this.splitLate = splitLate;
        this.splitRows = splitRows;
    }

    public Float getSpacingBefore() {
        return spacingBefore;
    }

    public void setSpacingBefore(Float spacingBefore) {
        this.spacingBefore = spacingBefore;
    }

    public Float getSpacingAfter() {
        return spacingAfter;
    }

    public void setSpacingAfter(Float spacingAfter) {
        this.spacingAfter = spacingAfter;
    }

    public Float getTotalWidth() {
        return totalWidth;
    }

    public void setTotalWidth(Float totalWidth) {
        this.totalWidth = totalWidth;
    }

    public Float getWidthPercentage() {
        return widthPercentage;
    }

    public void setWidthPercentage(Float widthPercentage) {
        this.widthPercentage = widthPercentage;
    }

    public float[] getWidths() {
        return widths;
    }

    public void setWidths(float[] widths) {
        this.widths = widths;
    }

    public Integer getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public void setHorizontalAlignment(Integer horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    public Boolean getSplitLate() {
        return splitLate;
    }

    public void setSplitLate(Boolean splitLate) {
        this.splitLate = splitLate;
    }

    public Boolean getSplitRows() {
        return splitRows;
    }

    public void setSplitRows(Boolean splitRows) {
        this.splitRows = splitRows;
    }

    public PdfPTable buildTableWithStyles(int columns) {
        PdfPTable table = new PdfPTable(columns);
        try {
            if (spacingBefore != null)
                table.setSpacingBefore(spacingBefore);
            if (spacingAfter != null)
                table.setSpacingAfter(spacingAfter);
            if (totalWidth != null)
                table.setTotalWidth(totalWidth);
            if (widthPercentage != null)
                table.setWidthPercentage(widthPercentage);
            if (widths != null)
                table.setWidths(widths);
            if (horizontalAlignment != null)
                table.setHorizontalAlignment(horizontalAlignment);
            if (splitLate != null)
                table.setSplitLate(splitLate);
            if (splitRows != null)
                table.setSplitRows(splitRows);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }
}
