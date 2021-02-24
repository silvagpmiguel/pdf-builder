import java.nio.file.Paths;

import com.itextpdf.text.Image;

public class ImageWrapper extends Image implements ElementWrapper {
    private boolean needPageBreak;

    public ImageWrapper(String resourcesFilepath) {
        super(ImageWrapper.getImageFromResources(resourcesFilepath));
    }

    public ImageWrapper(String resourcesFilepath, float scalePercent) {
        super(ImageWrapper.getImageFromResources(resourcesFilepath));
        scalePercent(scalePercent);
    }

    public ImageWrapper(String resourcesFilepath,
            float scalePercent,
            float absoluteX,
            float absoluteY) {
        super(ImageWrapper.getImageFromResources(resourcesFilepath));
        scalePercent(scalePercent);
        setAbsolutePosition(absoluteX, absoluteY);
    }

    public ImageWrapper withAbsolutePosition(float absoluteX, float absoluteY) {
        setAbsolutePosition(absoluteX, absoluteY);
        return this;
    }

    public ImageWrapper withAlignment(int alignment) {
        setAlignment(alignment);
        return this;
    }

    public ImageWrapper withAlt(String alt) {
        setAlt(alt);
        return this;
    }

    public ImageWrapper scale(float scalePercent) {
        scalePercent(scalePercent);
        return this;
    }

    public ImageWrapper scale(float scaleX, float scaleY) {
        scalePercent(scaleX, scaleY);
        return this;
    }

    public ImageWrapper withSpacingAfter(float spacing) {
        setSpacingAfter(spacing);
        return this;
    }

    public ImageWrapper withSpacingBefore(float spacing) {
        setSpacingBefore(spacing);
        return this;
    }

    public ImageWrapper withRotationDegrees(float alt) {
        setRotationDegrees(alt);
        return this;
    }

    public ImageWrapper fitHeight(boolean flag) {
        setScaleToFitHeight(flag);
        return this;
    }

    public ImageWrapper fitLineWhenOverflow(boolean flag) {
        setScaleToFitLineWhenOverflow(flag);
        return this;
    }

    public ImageWrapper withPageBreak() {
        needPageBreak = true;
        return this;
    }

    @Override
    public boolean needPageBreak() {
        return needPageBreak;
    }
    
    private static Image getImageFromResources(String resourcesFilepath) {
        Image image = null;
        try {
            image = Image.getInstance(Paths
                    .get(PdfBuilder.class.getClassLoader().getResource(resourcesFilepath).toURI())
                    .toAbsolutePath()
                    .toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
