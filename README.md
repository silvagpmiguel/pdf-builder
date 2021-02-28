# PDF Builder ![CI/CD OSSRH](https://github.com/silvagpmiguel/pdf-builder/actions/workflows/main.yml/badge.svg) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.silvagpmiguel/pdf-builder/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/com.github.silvagpmiguel/pdf-builder)

`Pdf Builder` serves as an extension to [itextpdf5](https://itextpdf.com/en/products/itext-5-legacy) library to facilitate the process of making PDF using the Java language.

## Features
- Easily generate a PDF or get his data with `PdfBuilder`
- Make your own [PageEvent](https://api.itextpdf.com/iText5/java/5.5.13.2/com/itextpdf/text/pdf/PdfPageEventHelper.html) and connect it to `PdfBuilder` (usefull for repeating patterns every page/chapter start/end)  
- Create new PDF elements easily with `ElementFactory` (tables, images, text..)
- Insert a new page after an element render (valid with tables, images and phrases)

## Usage
### PdfBuilder
#### *Generic Usage*
```java
new PdfBuilder()
    .open() // Prepares document to start writing new elements (mandatory)
    .addElement(...) // Add Elements(PdfPTable, Font, .. | TableWrapper, FontWrapper, ..)
    .close() // Close streams/document
    .build() // Build the entire PDF
    .generatePdf(PDF_PATH); // Generate PDF at PDF_PATH
 /* .getPdfData(); get Pdf data as a byte[] */
```
#### *Set PageEvent in PdfBuilder*
```java
/* Using constructor */
new PdfBuilder(new PageEvent()) 
/* Using setter */
new PdfBuilder().setPageEvent(new PageEvent)...
```

#### *Set a PageEvent and a List of Elements*
```java
/* PdfBuilder build method will build all elements in the list */
new PdfBuilder(new PageEvent(), List<ElementWrapper>);
```

### ElementFactory
```java
/* Creates a table cell, where you can define cell styles (DEFAULT: BORDERED) */
ElementFactory.newCell()
/* Creates a font (DEFAULT: family - HELVETICA, size - 12) */
ElementFactory.newFont()
/* Creates a new Table with NUM_COLS columns */
ElementFactory.newTable(NUM_COLS)
/* Automatically creates a new Table with the contents of the List */
ElementFactory.newTable(List<List<String>> rows)
/* Automatically creates a new Table with a custom header */
ElementFactory.newTable(List<List<String>> rows, int headerRows, CellWrapper headerStyle)
/* Automatically creates a new Table with a custom header and footer */
ElementFactory.newTable(
    List<List<String>> rows,
    int headerRows, CellWrapper headerStyle, FontWrapper headerFont,
    int footerRows, CellWrapper footerStyle, CellWrapper footerFont)
/* Creates a new Image that needs to be placed in resources */
ElementFactory.newImage(RESOURCES_RELATIVE_PATH)
/* Creates a phrase with TEXT */
ElementFactory.newPhrase(TEXT)
```
### PageEvent
```java
@Override
public void onStartPage(PdfWriter writer, Document document) {
    // gets writer and document in every page start state
}
@Override
public void onEndPage(PdfWriter writer, Document document) {
    // gets writer and document in every page end state
}
```
## Examples
### Pdf Generation
```java
CellWrapper NO_BORDER = ElementFactory.newCell().withBorder(Rectangle.NO_BORDER);
CellWrapper BORDERED = ElementFactory.newCell();
FontWrapper bold = ElementFactory.newCell().withBold().withSize(12f);
FontWrapper normal = ElementFactory.newFont().withSize(10f);
new PdfBuilder()
    .open()
    .addImage(pdfBuilder.newImage("logo.png"))
    .addElement(pdfBuilder.newPhrase("Title"))
    .addElement(pdfBuilder.newTable(2)
        .addTextRow(Arrays.asList("TITLE1", "TITLE2"), NO_BORDER, bold)
        .addTextRow(Arrays.asList("BODY1", "BODY2"), BORDERED, normal))
    .close()
    .build()
    .generatePdf();
```
### Add a Logo and a Custom Title every Page Start
```java
public class PageEvent{
    public PageEvent(){ pageNum = 0; }
    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        pageNum++;
        try {
            document.add(ElementFactory.newImage("logo.png")
                .withSpacingAfter(10));
            document.add(ElementFactory.newTable(2)
                .addTextRow("Hello World", "Page "+pageNum)
                .withSpacingAfter(10));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
```
## [Maven Dependency](https://search.maven.org/artifact/com.github.silvagpmiguel/pdf-builder)
```maven
<dependency>
  <groupId>com.github.silvagpmiguel</groupId>
  <artifactId>pdf-builder</artifactId>
  <version>${pdf-builder.version}</version>
</dependency>
```

## License
Apache License 2.0, see [LICENSE](LICENSE).
