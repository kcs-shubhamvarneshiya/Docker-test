package com.example.file.service.impl;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;

import org.springframework.stereotype.Service;

import com.example.file.service.PdfService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.actions.PdfSubmitAction;
import com.spire.pdf.fields.PdfButtonField;
import com.spire.pdf.fields.PdfCheckBoxField;
import com.spire.pdf.fields.PdfRadioButtonListField;
import com.spire.pdf.fields.PdfRadioButtonListItem;
import com.spire.pdf.fields.PdfTextBoxField;
import com.spire.pdf.graphics.PdfFont;
import com.spire.pdf.graphics.PdfFontFamily;
import com.spire.pdf.graphics.PdfFontStyle;
import com.spire.pdf.graphics.PdfRGBColor;
import com.spire.pdf.graphics.PdfSolidBrush;

@Service
@JsonIgnoreProperties("metadata")
public class PdfServiceImpl extends PdfDocument implements PdfService {

	@Override
	public File createDocument() throws Exception {
		PdfDocument doc = new PdfDocument();

		// Add a page

		PdfPageBase page = doc.getPages().add();

		// Initialize x and y coordinates
		float baseX = 100;
		float baseY = 30;

		// Create two brush objects

		PdfSolidBrush brush1 = new PdfSolidBrush(new PdfRGBColor(Color.blue));

		PdfSolidBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.black));

		// Create a font

		PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, PdfFontStyle.Regular);

		// Add a textbox

		page.getCanvas().drawString("Name:", font, brush1, new Point2D.Float(10, baseY));

		Rectangle2D.Float tbxBounds = new Rectangle2D.Float(baseX, baseY, 150, 15);

		PdfTextBoxField textBox = new PdfTextBoxField(page, "name");

	
		textBox.setBounds(tbxBounds);

		textBox.setText("Enter Your Name");

		textBox.setFont(font);

		doc.getForm().getFields().add(textBox);

		baseY += 25;

		// Add two radio buttons

		page.getCanvas().drawString("Gender:", font, brush1, new Point2D.Float(10, baseY));

		PdfRadioButtonListField radioButtonListField = new PdfRadioButtonListField(page, "gender");

		PdfRadioButtonListItem radioItem1 = new PdfRadioButtonListItem("Male");

		Rectangle2D.Float radioBound1 = new Rectangle2D.Float(baseX, baseY, 15, 15);

		radioItem1.setBounds(radioBound1);

		page.getCanvas().drawString("Male", font, brush2, new Point2D.Float(baseX + 20, baseY));

		PdfRadioButtonListItem radioItem2 = new PdfRadioButtonListItem("Female");

		Rectangle2D.Float radioBound2 = new Rectangle2D.Float(baseX + 70, baseY, 15, 15);

		radioItem2.setBounds(radioBound2);

		page.getCanvas().drawString("Female", font, brush2, new Point2D.Float(baseX + 90, baseY));

		radioButtonListField.getItems().add(radioItem1);

		radioButtonListField.getItems().add(radioItem2);

		radioButtonListField.setSelectedIndex(0);

		doc.getForm().getFields().add(radioButtonListField);

		baseY += 25;

		// Add a textbox

		page.getCanvas().drawString("E-mail:", font, brush1, new Point2D.Float(10, baseY));

		Rectangle2D.Float tbxBounds1 = new Rectangle2D.Float(baseX, baseY, 150, 15);

		PdfTextBoxField textBox1 = new PdfTextBoxField(page, "email");

		textBox1.setBounds(tbxBounds1);

		textBox1.setText("Enter Your Email");

		textBox1.setFont(font);

		doc.getForm().getFields().add(textBox1);

		baseY += 25;

		// Add a textbox

		page.getCanvas().drawString("Phone:", font, brush1, new Point2D.Float(10, baseY));

		Rectangle2D.Float tbxBounds11 = new Rectangle2D.Float(baseX, baseY, 150, 15);

		PdfTextBoxField textBox11 = new PdfTextBoxField(page, "phone");

		textBox11.setBounds(tbxBounds11);

		textBox11.setText("Enter Your phonenumber");

		textBox11.setFont(font);

		doc.getForm().getFields().add(textBox11);

		baseY += 25;

		// add two checkboxes

		page.getCanvas().drawString("Hobbies:", font, brush1, new Point2D.Float(10, baseY));

		Rectangle2D.Float checkboxBound1 = new Rectangle2D.Float(baseX, baseY, 15, 15);

		PdfCheckBoxField checkBoxField1 = new PdfCheckBoxField(page, "hobbiesTravel");

		checkBoxField1.setBounds(checkboxBound1);

		checkBoxField1.setChecked(false);

		page.getCanvas().drawString("Travel", font, brush2, new Point2D.Float(baseX + 20, baseY));

		Rectangle2D.Float checkboxBound2 = new Rectangle2D.Float(baseX + 70, baseY, 15, 15);

		PdfCheckBoxField checkBoxField2 = new PdfCheckBoxField(page, "hobbiesMovie");

		checkBoxField2.setBounds(checkboxBound2);

		checkBoxField2.setChecked(false);

		page.getCanvas().drawString("Movie", font, brush2, new Point2D.Float(baseX + 90, baseY));
		
		doc.getForm().getFields().add(checkBoxField1);

		doc.getForm().getFields().add(checkBoxField2);

		baseY += 25;

		// Add a button

		page.getCanvas().drawString("", font, brush1, new Point2D.Float(10, baseY));

		Rectangle2D.Float btnBounds = new Rectangle2D.Float(baseX, baseY, 50, 15);

		PdfButtonField buttonField = new PdfButtonField(page, "button");

		buttonField.setBounds(btnBounds);

		buttonField.setText("Submit");

		buttonField.setFont(font);

		PdfSubmitAction submitAction = new PdfSubmitAction("http://localhost:8080/saveData");
		
		buttonField.getActions().setMouseDown(submitAction);

		doc.getForm().getFields().add(buttonField);
		
		submitAction.getHttpMethod();

		// Save to file
		doc.saveToFile("..\\src\\main\\resources\\tmp_pdf\\FillableForm.pdf", FileFormat.PDF);
		
		return new File("..\\src\\main\\resources\\tmp_pdf\\FillableForm.pdf");
	}

}
