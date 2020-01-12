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

        /*
        long StartTime = System.currentTimeMillis();
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

        //region Strategy Pattern
        /*
        Section cap1 = new Section("Capitol 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.AddElement(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.AddElement(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.AddElement(p3);

        System.out.println("Printare fara align: ");
        cap1.print();

        System.out.println("Printare cu align: ");
        p1.SetStrategy(new AlignLeft());
        p2.SetStrategy(new AlignCenter());
        p3.SetStrategy(new AlignRight());
        cap1.print();
        */
        //endregion

        //region Visitor Pattern
        /*
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.AddElement(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.AddElement(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.AddElement(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.AddElement(p4);
        cap1.AddElement(new ImageProxy("ImageOne"));
        cap1.AddElement(new Image("ImageTwo"));
        cap1.AddElement(new Paragraph("Some text"));
        cap1.AddElement(new Table("Table 1"));
        BookStatistics stats = new BookStatistics();
        cap1.Accept(stats);
        stats.PrintStatistics();
        */
        //endregion

        //region JSON Builder
        /*
        Builder jsonBuilder = new JSONBuilder("book.json");
        jsonBuilder.build();
        Element myBook = jsonBuilder.getResult();
        myBook.print();

         */
        // region Command
        /*
        Command cmd1 = new OpenCommand("book.json");
        cmd1.execute();
        Command cmd2 = new StastisticsCommand();
        cmd2.execute();
        DocumentManager.getInstance().getBook().print();

         */

        //region ObservableObservers

        /*
            Section cap1 = new Section("Capitolul 1");
            Paragraph p1 = new Paragraph("Paragraph 1");
            cap1.AddElement(p1);
            Paragraph p2 = new Paragraph("Paragraph 2");
            cap1.AddElement(p2);
            Paragraph p3 = new Paragraph("Paragraph 3");
            cap1.AddElement(p3);
            Paragraph p4 = new Paragraph("Paragraph 4");
            cap1.AddElement(p4);
            cap1.AddElement(new ImageProxy("ImageOne"));
            cap1.AddElement(new Image("ImageTwo"));
            cap1.AddElement(new Paragraph("Some text"));
            cap1.AddElement(new Table("Table 1"));
            FirstObserver firstObserver = new FirstObserver("first");
            SecondObserver secondObserver = new SecondObserver("second");
            cap1.addObserver(firstObserver);
            cap1.addObserver(secondObserver);
            p1.addObserver(firstObserver);
            p1.addObserver(secondObserver);
            p2.addObserver(firstObserver);
            cap1.setNewValue("CHAPTER 1");
            p1.setNewValue("PARAGRAPH 2");
            p2.setNewValue("PARAGRAPH 3");
            cap1.removeObserver(firstObserver);
            cap1.setNewValue("CHAPTER 1.1");


         */

        //region Memento
        Section cap1 = new Section("Capitolul 1");
        cap1.AddElement(new Paragraph("Moto capitol"));
        cap1.AddElement(new Paragraph("Another One"));
        cap1.AddElement(new Paragraph("Another Two"));
        cap1.AddElement(new Paragraph("Another Three"));
        DocumentManager.getInstance().setBook(cap1);
        System.out.println("Book Content: ");
        DocumentManager.getInstance().getBook().print();
        DeleteCommand dc = new DeleteCommand();
        dc.execute();
        System.out.println("Book Content after the first delete: ");
        DocumentManager.getInstance().getBook().print();
        (new DeleteCommand()).execute();
        System.out.println("Book Content after the second delete: ");
        DocumentManager.getInstance().getBook().print();
        Command undoCommand = new UndoCommand();
        undoCommand.execute();
        System.out.println("Book Content after first undo: ");
        DocumentManager.getInstance().getBook().print();
        undoCommand.execute();
        System.out.println("Book Content after second undo: ");
        DocumentManager.getInstance().getBook().print();
        }
}


