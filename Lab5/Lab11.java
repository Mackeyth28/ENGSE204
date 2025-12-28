package Lab5;

import java.util.Scanner;

// Superclass: Document
class Document {
    protected String title;

    public Document(String title) {
        this.title = title;
    }

    public void displayDetails() {
        System.out.println("Document: " + title);
    }
}

// Subclass: TextDocument
class TextDocument extends Document {
    protected int wordCount;

    public TextDocument(String title, int wordCount) {
        super(title);
        this.wordCount = wordCount;
    }

    @Override
    public void displayDetails() {
        System.out.println("Text: " + title + ", Words: " + wordCount);
    }
}

// Subclass: PDFDocument
class PDFDocument extends Document {
    protected int pageCount;

    public PDFDocument(String title, int pageCount) {
        super(title);
        this.pageCount = pageCount;
    }

    @Override
    public void displayDetails() {
        System.out.println("PDF: " + title + ", Pages: " + pageCount);
    }

    public int getPageCount() {
        return pageCount;
    }
}

public class Lab11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 2 sets of TextDocument and PDFDocument (Total 4 objects)
        // Set 1
        String titleT1 = sc.nextLine();
        int wordsT1 = Integer.parseInt(sc.nextLine());
        String titleP1 = sc.nextLine();
        int pagesP1 = Integer.parseInt(sc.nextLine());

        // Set 2
        String titleT2 = sc.nextLine();
        int wordsT2 = Integer.parseInt(sc.nextLine());
        String titleP2 = sc.nextLine();
        int pagesP2 = Integer.parseInt(sc.nextLine());

        // 1. Create objects
        TextDocument t1 = new TextDocument(titleT1, wordsT1);
        PDFDocument p1 = new PDFDocument(titleP1, pagesP1);
        TextDocument t2 = new TextDocument(titleT2, wordsT2);
        PDFDocument p2 = new PDFDocument(titleP2, pagesP2);

        // 2. Create Parent Class Array (Document[])
        Document[] docs = { t1, p1, t2, p2 };

        // 3. Loop in Array to count total PDF pages using instanceof and Downcasting
        int totalPages = 0;
        for (Document d : docs) {
            if (d instanceof PDFDocument) {
                // Downcast to PDFDocument to access pageCount
                PDFDocument pdf = (PDFDocument) d;
                totalPages += pdf.getPageCount();
            }
        }

        // 4. Loop again to display details of each document
        for (Document d : docs) {
            d.displayDetails();
        }

        // 5. Display total pages
        System.out.println("Total Pages: " + totalPages);

        sc.close();
    }
}