/* 
 *  Copyright 2021 com.github.silvagpmiguel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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
