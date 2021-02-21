import java.nio.file.Paths;

import com.itextpdf.text.Image;

public class ImageWrapper extends Image {
    public ImageWrapper(String resourcesFilepath) {
        super(ImageWrapper.getImageFromResources(resourcesFilepath));
    }

    public ImageWrapper(String resourcesFilepath, float scalePercent) {
        super(ImageWrapper.getImageFromResources(resourcesFilepath));
        super.scalePercent(scalePercent);
    }

    public ImageWrapper(String resourcesFilepath, float scalePercent, float absoluteX, float absoluteY) {
        super(ImageWrapper.getImageFromResources(resourcesFilepath));
        super.scalePercent(scalePercent);
        super.setAbsolutePosition(absoluteX, absoluteY);
    }

    public ImageWrapper withAbsolutePosition(float absoluteX, float absoluteY) {
        super.setAbsolutePosition(absoluteX, absoluteY);
        return this;
    }

    public ImageWrapper withAlignment(int alignment) {
        super.setAlignment(alignment);
        return this;
    }

    public ImageWrapper withAlt(String alt) {
        super.setAlt(alt);
        return this;
    }

    public ImageWrapper scale(float scalePercent) {
        super.scalePercent(scalePercent);
        return this;
    }

    public ImageWrapper scale(float scaleX, float scaleY) {
        super.scalePercent(scaleX, scaleY);
        return this;
    }

    public ImageWrapper withSpacingAfter(float spacing) {
        super.setSpacingAfter(spacing);
        return this;
    }

    public ImageWrapper withSpacingBefore(float spacing) {
        super.setSpacingBefore(spacing);
        return this;
    }

    public ImageWrapper withRotationDegrees(float alt) {
        super.setRotationDegrees(alt);
        return this;
    }

    public ImageWrapper fitHeight(boolean flag) {
        super.setScaleToFitHeight(flag);
        return this;
    }

    public ImageWrapper fitLineWhenOverflow(boolean flag) {
        super.setScaleToFitLineWhenOverflow(flag);
        return this;
    }

    private static Image getImageFromResources(String resourcesFilepath) {
        Image image = null;
        try {
            image = Image
                    .getInstance(Paths.get(PdfBuilder.class.getClassLoader().getResource(resourcesFilepath).toURI())
                            .toAbsolutePath().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
