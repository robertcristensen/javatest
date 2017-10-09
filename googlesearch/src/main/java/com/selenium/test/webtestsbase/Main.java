package com.selenium.test.webtestsbase;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args){
        System.out.println("Fake Main");
        try {
            String u = "http://18.221.112.57:4446/wd/hub";
            URL url = new URL(u);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
