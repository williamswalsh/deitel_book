package debugging;

public class App {
    public static void main(String[] args) {
        // javac -g App.java        Generates debug info required by debugger
        // -g:vars                  Generates a local var table in the .class file
        // jdb

        // > run | stop | cont
        // > run App

        // stop -> add breakpoint at line 19
        // stop App:19

        // print x
        // prints var value at breakpoint

        int x = 23;
        System.out.println("Hello World");
        x = 53;
    }
}
