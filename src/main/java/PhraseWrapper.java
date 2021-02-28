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

import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;

public class PhraseWrapper extends Phrase implements ElementWrapper{
    private boolean needPageBreak = false;
    private static final long serialVersionUID = 8364750317580117161L;

    public PhraseWrapper() {
        super();
    }

    public PhraseWrapper(String text) {
        super(text);
    }

    public PhraseWrapper(String text, Font font) {
        super(text, font);
    }

    public PhraseWrapper(String text, Font.FontFamily family, float size, int style) {
        super(text, new Font(family, size, style));
    }

    public PhraseWrapper withFont(Font font) {
        setFont(font);
        return this;
    }

    public PhraseWrapper withFont(Font.FontFamily family, float size, int style) {
        setFont(new Font(family, size, style));
        return this;
    }

    public PhraseWrapper withPageBreak(){
        this.needPageBreak = true;
        return this;
    }
    
    @Override
    public boolean needPageBreak() {
        return this.needPageBreak;
    }
}
