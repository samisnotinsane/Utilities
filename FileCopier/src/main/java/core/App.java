package main.java.core;

import javax.swing.*;

/**
 * Created by sameen on 11/11/2016.
 */
public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileCopyTool();
            }
        });
    }
}
