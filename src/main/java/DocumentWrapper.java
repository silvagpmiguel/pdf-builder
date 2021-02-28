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
