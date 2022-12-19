package com.example.backEnd.signature;

import java.io.File;
import java.io.IOException;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="sign")
@CrossOrigin
public class Sign {
    /*
    public static void main(String args[]) throws Exception {

        //Loading an existing document
        File file = new File("C:/pdfBox/InsertImage_IP.pdf");
        PDDocument doc = Loader.loadPDF(file);

        //Retrieving the page
        PDPage page = doc.getPage(0);

        //Creating PDImageXObject object
        PDImageXObject pdImage = PDImageXObject.createFromFile("C:/pdfBox/logo.png", doc);

        //creating the PDPageContentStream object
        PDPageContentStream contents = new PDPageContentStream(doc, page);

        //Drawing the image in the PDF document
        contents.drawImage(pdImage, 70, 250);
        System.out.println("Image inserted");

        //Closing the PDPageContentStream object
        contents.close();

        //Saving the document
        doc.save("C:/pdfBox/InsertImage_OP.pdf");

        //Closing the document
        doc.close();
    }
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long signID;
    @Transient
    private File file;
    @Transient
    private PDDocument doc;
    @Transient
    private PDPage page;
    @Transient
    private PDImageXObject pdImage;
    @Transient
    private PDPageContentStream contents;
    private long documentID;
    public Sign(long documentID) {
        this.documentID = documentID;
        file = null;
        doc = null;
        page = null;
        pdImage = null;
        contents = null;
    }
    public Sign() {
        documentID = 0;
        file = null;
        doc = null;
        page = null;
        pdImage = null;
        contents = null;
    }
    public File getFile() {
        return file;
    }

    public void setFile(String path) {
        this.file = new File(path);

    }

    public PDDocument getDoc() {
        return doc;
    }

    public void setDoc(File file) throws IOException {
        this.doc = Loader.loadPDF(file);
    }

    public PDPage getPage() {
        return page;
    }

    public void setPage(int i) {
        this.page = doc.getPage(i); //i = 0 first page
    }

    public PDImageXObject getPdImage() {
        return pdImage;
    }

    public void setPdImage(String pathOfImage, PDDocument doc) throws IOException {
        this.pdImage = PDImageXObject.createFromFile(pathOfImage, doc);
    }

    public PDPageContentStream getContents() {
        return contents;
    }

    public void setContents(PDDocument doc, PDPage page) throws IOException {
        this.contents = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true, true);
    }

    public long getDocumentID() {
        return documentID;
    }

    public void setDocumentID(long documentID) {
        this.documentID = documentID;
    }

    public void drawImageNe(PDPageContentStream contents, PDImageXObject pdImage) throws IOException {
        contents.drawImage(pdImage, 70, 250);

    }
    public void closeContents(PDPageContentStream contents) throws IOException {
        contents.close();

    }
    public void docSave(PDDocument doc, String path) throws IOException {
        doc.save(path);

    }

    public void closeDoc(PDDocument doc) throws IOException {
        doc.close();
    }
}

