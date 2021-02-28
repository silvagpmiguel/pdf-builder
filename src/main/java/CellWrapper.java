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

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

public class CellWrapper extends PdfPCell {
    public CellWrapper() {
        super();
    }

    public CellWrapper(int border) {
        this(border, 1);
    }

    public CellWrapper(int border, float borderWidth) {
        this(border, borderWidth, BaseColor.BLACK);
    }

    public CellWrapper(int border, float borderWidth, BaseColor borderColor) {
        this(BaseColor.WHITE, border, borderWidth, borderColor);
    }

    public CellWrapper(BaseColor backgroundColor) {
        this(backgroundColor, 1);
    }

    public CellWrapper(BaseColor backgroundColor, int border) {
        this(backgroundColor, border, 1);
    }

    public CellWrapper(BaseColor backgroundColor, int border, float borderWidth) {
        this(backgroundColor, border, borderWidth, BaseColor.BLACK);
    }

    public CellWrapper(BaseColor backgroundColor, int border, float borderWidth, BaseColor borderColor) {
        super();
        setBackgroundColor(backgroundColor);
        setBorder(border);
        setBorderWidth(borderWidth);
        setBorderColor(borderColor);
    }

    public CellWrapper withPhrase(String text, Font font) {
        setPhrase(new Phrase(text, font));
        return this;
    }

    public CellWrapper withPhrase(String text, Font.FontFamily fontFamily, float fontSize, int fontStyle) {
        setPhrase(new Phrase(text, new Font(fontFamily, fontSize, fontStyle)));
        return this;
    }

    public CellWrapper withBackgroundColor(BaseColor backgroundColor) {
        setBackgroundColor(backgroundColor);
        return this;
    }

    public CellWrapper withBorderWidth(float borderWidth) {
        setBorderWidth(borderWidth);
        return this;
    }

    public CellWrapper withBorderColor(BaseColor borderColor) {
        setBorderColor(borderColor);
        return this;
    }

    public CellWrapper withBorder(int border) {
        setBorder(border);
        return this;
    }

    public CellWrapper withVerticalAlign(int verticalAlignment) {
        setVerticalAlignment(verticalAlignment);
        return this;
    }

    public CellWrapper withHorizontalAlign(int horizontalAlignment) {
        setHorizontalAlignment(horizontalAlignment);
        return this;
    }

    public CellWrapper withPadding(float padding) {
        setPadding(padding);
        return this;
    }
}
