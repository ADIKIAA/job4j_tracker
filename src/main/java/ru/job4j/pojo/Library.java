package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book one = new Book("Clean code", 17);
        Book two = new Book("Java", 56);
        Book three = new Book("PC", 156);
        Book four = new Book("Notes", 74);
        Book[] books = new Book[4];
        books[0] = one;
        books[1] = two;
        books[2] = three;
        books[3] = four;
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            System.out.println(b.getName() + " - " + b.getPages());
        }
        System.out.println();
        Book y = books[0];
        books[0] = books[3];
        books[3] = y;
        for (int index = 0; index < books.length; index++) {
            Book x = books[index];
            System.out.println(x.getName() + " - " + x.getPages());
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            Book z = books[index];
            if (z.getName().equals("Clean code")) {
                System.out.println(z.getName() + " - " + z.getPages());
            }
        }
    }
}
