package com.infopper.pdfgenerator.pdfexporter;

import com.infopper.pdfgenerator.dto.UserDto;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class UserPdfExporter {

    public UserPdfExporter(List<UserDto> allUser) {
    }

    public void generator(List<UserDto> listUserDto, HttpServletResponse response) throws IOException {

        // Create object of Document
        Document document = new Document(PageSize.A4);

        // Getting instance of pdf writer
        PdfWriter.getInstance(document, response.getOutputStream());

        // opening Document
        document.open();

        // creating font
        //Setting font Size & Style
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);

        // creating paragraph
        Paragraph paragraph = new Paragraph("List of Users", fontTitle);
        //Aligning the paragraph in the Document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        // Adding the created document in the paragraph
        document.add(paragraph);

        //Creating table of the column 6
        PdfPTable table = new PdfPTable(6);

        //Setting width of the Table and its spacing
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{1, 3, 4.5f, 1, 2, 3.5f});
        table.setSpacingBefore(5);

        // create Table cells for Table Header
        PdfPCell cell = new PdfPCell();
        // Setting background color and Padding of the table cell
        cell.setBackgroundColor(Color.BLUE);

        cell.setPadding(5);

        // Create font
        // Setting font Style and Size

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(Color.white);


        // Adding Heading in the Created Table
        // Adding cell to table


        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("NAME", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("ADDRESS", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("AGE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("GENDER", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("MOBILE_NUMBER", font));
        table.addCell(cell);

        // Iterating the list of UserDtos
        //
        for (UserDto userDto : listUserDto) {

            table.addCell(String.valueOf(userDto.getId()));
            table.addCell(userDto.getName());
            table.addCell(userDto.getAddress());
            table.addCell(String.valueOf(userDto.getAge()));
            table.addCell(userDto.getGender());
            table.addCell(userDto.getMobileNumber());
        }
        // Adding created Table in the Document File
        document.add(table);
        // Closing the Document
        document.close();
    }

}
