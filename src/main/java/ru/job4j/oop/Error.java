package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error one = new Error();
        Error two = new Error(true, 4, "this is error");
        Error three = new Error(false, 2, "this is error");
        one.printInfo();
        System.out.println();
        two.printInfo();
        System.out.println();
        three.printInfo();
    }
}
