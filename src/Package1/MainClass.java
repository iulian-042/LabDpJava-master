package Package1;

public class MainClass {

    public static void main(String[] args) {

        Book Titanic = new Book("Titanic");
        Author rPaul = new Author("Radu Paul");
        Titanic.AddAuthor(rPaul);

        //region Composite Pattern
        /*Section chpt1 = new Section("Chapter 1");
        Section chpt11 = new Section("Chapter 1.1");
        Section chpt111 = new Section("Chapter 1.1.1");
        Section chpt1111 = new Section("Chapter 1.1.1.1");

        Titanic.AddContent(new Paragraph("Paragraph pentru carte"));
        Titanic.AddContent(chpt1);

        chpt1.AddElement(new Paragraph("Moto capitol"));
        chpt1.AddElement(chpt11);

        chpt11.AddElement(new Paragraph("Text from SubChapter 1.1"));
        chpt11.AddElement(chpt111);

        chpt111.AddElement(new Paragraph("Text from subchapter 1.1.1"));
        chpt111.AddElement(chpt1111);

        chpt1111.AddElement(new Image("Image from subchapter 1.1.1.1"));

        Titanic.Print();*/
        //endregion

        //region Proxy Pattern

        /*long StartTime = System.currentTimeMillis();
        ImageProxy img1 = new ImageProxy("Image 1");
        ImageProxy img2 = new ImageProxy("Image 2");
        ImageProxy img3 = new ImageProxy("Image 3");

        Section section1 = new Section("Section 1");
        section1.AddElement(img1);

        Section section2 = new Section("Section 2");
        section2.AddElement(img2);
        section2.AddElement(img3);

        Book book1 = new Book("Book 1");
        book1.AddContent(section1);
        book1.AddContent(section2);
        long EndTime = System.currentTimeMillis();

        System.out.println("Creation of the content took " + (EndTime - StartTime) + " miliseconds");

        StartTime = System.currentTimeMillis();
        section1.print();
        EndTime = System.currentTimeMillis();
        System.out.println("Printing of the section 1 took " + (EndTime - StartTime) + " miliseconds");

        StartTime = System.currentTimeMillis();
        section1.print();
        EndTime = System.currentTimeMillis();
        System.out.println("Printing of the section 1 took " + (EndTime - StartTime) + " miliseconds");
        */
        //endregion

            Section cap1 = new Section("Capitolul 1");
            Paragraph p1 = new Paragraph("Paragraph 1");
            cap1.AddElement(p1);
            Paragraph p2 = new Paragraph("Paragraph 2");
            cap1.AddElement(p2);
            Paragraph p3 = new Paragraph("Paragraph 3");
            cap1.AddElement(p3);
            Paragraph p4 = new Paragraph("Paragraph 4");
            cap1.AddElement(p4);
            System.out.println("Printing without Alignment");

            System.out.println();
            cap1.print();
            p1.setAlignStrategy(new AlignCenter());
            p2.setAlignStrategy(new AlignRight());
            p3.setAlignStrategy(new AlignLeft());
            System.out.println();
            System.out.println("Printing with Alignment");
            System.out.println();
            cap1.print();

    }

}
