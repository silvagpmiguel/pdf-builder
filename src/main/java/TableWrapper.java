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

import java.util.List;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;

public class TableWrapper extends PdfPTable implements ElementWrapper {
    private List<List<String>> data;
    private CellWrapper bodyCell;
    private FontWrapper bodyFont;
    private int headerRows;
    private CellWrapper headerCell;
    private FontWrapper headerFont;
    private int footerRows;
    private CellWrapper footerCell;
    private FontWrapper footerFont;
    private boolean needPageBreak;

    public TableWrapper(int cols) {
        super(cols);
    }

    public TableWrapper(float[] widths) {
        super(widths);
    }

    public TableWrapper(List<List<String>> data) {
        this(data, new CellWrapper());
    }

    public TableWrapper(List<List<String>> data, int headerRows, CellWrapper headerCell) {
        this(data, new CellWrapper(), new FontWrapper(), headerRows, headerCell, new FontWrapper());
    }

    public TableWrapper(List<List<String>> data,
            int headerRows,
            CellWrapper headerCell,
            FontWrapper headerFont) {
        this(data,
                new CellWrapper(),
                new FontWrapper(),
                headerRows,
                headerCell,
                headerFont,
                0,
                new CellWrapper());
    }

    public TableWrapper(List<List<String>> data,
            int headerRows,
            CellWrapper headerCell,
            FontWrapper headerFont,
            int footerRows,
            CellWrapper footerCell) {
        this(data,
                new CellWrapper(),
                new FontWrapper(),
                headerRows,
                headerCell,
                headerFont,
                footerRows,
                footerCell,
                new FontWrapper());
    }

    public TableWrapper(List<List<String>> data,
            int headerRows,
            CellWrapper headerCell,
            FontWrapper headerFont,
            int footerRows,
            CellWrapper footerCell,
            FontWrapper footerFont) {
        this(data,
                new CellWrapper(),
                new FontWrapper(),
                headerRows,
                headerCell,
                headerFont,
                footerRows,
                footerCell,
                footerFont);
    }

    public TableWrapper(List<List<String>> data, CellWrapper bodyCell) {
        this(data, bodyCell, new FontWrapper());
    }

    public TableWrapper(List<List<String>> data, CellWrapper bodyCell, FontWrapper bodyFont) {
        this(data, bodyCell, bodyFont, 0, new CellWrapper());
    }

    public TableWrapper(List<List<String>> data,
            CellWrapper bodyCell,
            FontWrapper bodyFont,
            int headerRows,
            CellWrapper headerCell) {
        this(data, bodyCell, bodyFont, headerRows, headerCell, new FontWrapper());
    }

    public TableWrapper(List<List<String>> data,
            CellWrapper bodyCell,
            FontWrapper bodyFont,
            int headerRows,
            CellWrapper headerCell,
            FontWrapper headerFont) {
        this(data, bodyCell, bodyFont, headerRows, headerCell, headerFont, 0, new CellWrapper());
    }

    public TableWrapper(List<List<String>> data,
            CellWrapper bodyCell,
            FontWrapper bodyFont,
            int headerRows,
            CellWrapper headerCell,
            FontWrapper headerFont,
            int footerRows,
            CellWrapper footerCell) {
        this(data,
                bodyCell,
                bodyFont,
                headerRows,
                headerCell,
                headerFont,
                footerRows,
                footerCell,
                new FontWrapper());
    }

    public TableWrapper(List<List<String>> data,
            CellWrapper bodyCell,
            FontWrapper bodyFont,
            int headerRows,
            CellWrapper headerCell,
            FontWrapper headerFont,
            int footerRows,
            CellWrapper footerCell,
            FontWrapper footerFont) {
        super(data.get(0).size());
        this.data = data;
        this.bodyCell = bodyCell;
        this.bodyFont = bodyFont;
        this.headerRows = headerRows;
        this.headerCell = headerCell;
        this.headerFont = headerFont;
        this.footerRows = footerRows;
        this.footerCell = footerCell;
        this.footerFont = footerFont;
        fillTable();
    }

    public TableWrapper withLockedWith(boolean isLocked) {
        setLockedWidth(isLocked);
        return this;
    }

    public TableWrapper withSpacingBefore(float spacingBefore) {
        setSpacingBefore(spacingBefore);
        return this;
    }

    public TableWrapper withSpacingAfter(float spacingAfter) {
        setSpacingAfter(spacingAfter);
        return this;
    }

    public TableWrapper withTotalWidth(float totalWidth) {
        setTotalWidth(totalWidth);
        return this;
    }

    public TableWrapper withWidthPercentage(float widthPercentage) {
        setWidthPercentage(widthPercentage);
        return this;
    }

    public TableWrapper withWidths(float[] widths) {
        try {
            setWidths(widths);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return this;
    }

    public TableWrapper withHorizontalAlignment(int horizontalAlignment) {
        setHorizontalAlignment(horizontalAlignment);
        return this;
    }

    public TableWrapper withSplitLate(boolean splitLate) {
        setSplitLate(splitLate);
        return this;
    }

    public TableWrapper withSplitRows(boolean splitRows) {
        setSplitRows(splitRows);
        return this;
    }

    public TableWrapper withPageBreak() {
        needPageBreak = true;
        return this;
    }

    public TableWrapper addTextCell(String text) {
        return addTextCell(text, new CellWrapper(), new FontWrapper());
    }

    public TableWrapper addTextCell(String text, CellWrapper cell) {
        return addTextCell(text, cell, new FontWrapper());
    }

    public TableWrapper addTextCell(String text, FontWrapper font) {
        return addTextCell(text, new CellWrapper(), font);
    }

    public TableWrapper addTextCell(String text, CellWrapper cell, FontWrapper font) {
        cell.setPhrase(new Phrase(text, font));
        addCell(cell);
        return this;
    }

    public TableWrapper addTextRow(List<String> row) {
        return addTextRow(row, new CellWrapper(), new FontWrapper());
    }

    public TableWrapper addTextRow(List<String> row, CellWrapper cell) {
        return addTextRow(row, cell, new FontWrapper());
    }

    public TableWrapper addTextRow(List<String> row, FontWrapper font) {
        return addTextRow(row, new CellWrapper(), font);
    }

    public TableWrapper addTextRow(List<String> row, CellWrapper cell, FontWrapper font) {
        for (String text : row) {
            addTextCell(text, cell, font);
        }
        return this;
    }

    public TableWrapper addTextRow(List<String> rowText,
            CellWrapper rowCellStyle,
            List<FontWrapper> rowFontStyle) {
        for (int i = 0; i < rowText.size(); i++) {
            addTextCell(rowText.get(i), rowCellStyle, rowFontStyle.get(i));
        }
        return this;
    }

    public TableWrapper addTextRow(List<String> rowText,
            List<CellWrapper> rowCellStyle,
            FontWrapper rowFontStyle) {
        for (int i = 0; i < rowText.size(); i++) {
            addTextCell(rowText.get(i), rowCellStyle.get(i), rowFontStyle);
        }
        return this;
    }

    public TableWrapper addTextRow(List<String> rowText,
            List<CellWrapper> rowCellStyle,
            List<FontWrapper> rowFontStyle) {
        for (int i = 0; i < rowText.size(); i++) {
            addTextCell(rowText.get(i), rowCellStyle.get(i), rowFontStyle.get(i));
        }
        return this;
    }

    @Override
    public boolean needPageBreak() {
        return needPageBreak;
    }

    private void fillTable() {
        final int TABLE_SIZE = data.size();
        final int FOOTER_START = TABLE_SIZE - footerRows;

        for (int i = 0; i < headerRows; i++) {
            for (String text : data.get(i)) {
                headerCell.setPhrase(new Phrase(text, headerFont));
                addCell(headerCell);
            }
        }

        for (int i = headerRows; i < FOOTER_START; i++) {
            for (String text : data.get(i)) {
                bodyCell.setPhrase(new Phrase(text, bodyFont));
                addCell(bodyCell);
            }
        }

        for (int i = FOOTER_START; i < TABLE_SIZE; i++) {
            for (String text : data.get(i)) {
                footerCell.setPhrase(new Phrase(text, footerFont));
                addCell(footerCell);
            }
        }
    }
}
