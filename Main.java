package com.company;

/**
 * @autor Tomas Soukal
 */
public class Main {

    public String boo = "Boo";

    public static void main(String[] args) {
	    Thread handler = new Thread(new ThreadHandler());
	    handler.start();
    }
}
