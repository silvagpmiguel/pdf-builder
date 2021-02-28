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

public class FontWrapper extends Font {
    public FontWrapper() {
        this(Font.FontFamily.UNDEFINED);
    }

    public FontWrapper(Font.FontFamily family) {
        this(family, DEFAULTSIZE);
    }

    public FontWrapper(float size) {
        this(size, Font.NORMAL);
    }

    public FontWrapper(float size, int style) {
        this(Font.FontFamily.UNDEFINED, size, style);
    }

    public FontWrapper(Font.FontFamily family, float size) {
        this(family, size, Font.NORMAL);
    }

    public FontWrapper(Font.FontFamily family, float size, int style) {
        this(family, size, style, BaseColor.BLACK);
    }

    public FontWrapper(Font.FontFamily family, float size, int style, BaseColor color) {
        super(family, size, style, color);
    }

    public FontWrapper withFamily(Font.FontFamily family) {
        setFamily(family.toString());
        return this;
    }

    public FontWrapper withSize(float size) {
        setSize(size);
        return this;
    }

    public FontWrapper withStyle(int style) {
        setStyle(style);
        return this;
    }

    public FontWrapper withColor(BaseColor color) {
        setColor(color);
        return this;
    }

    public FontWrapper withBoldStyle() {
        setStyle(Font.BOLD);
        return this;
    }

    public FontWrapper withItalicStyle() {
        setStyle(Font.ITALIC);
        return this;
    }

    public FontWrapper withBoldItalicStyle() {
        setStyle(Font.BOLDITALIC);
        return this;
    }
}
