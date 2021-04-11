package app;

import app.view.MainWindow;

public class Main {
    public static void main(String[] args) {
        System.out.println("tu main");
        MainWindow window = new MainWindow();
        window.display(args);
    }
}
