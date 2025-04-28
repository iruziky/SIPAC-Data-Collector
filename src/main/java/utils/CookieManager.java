package utils;

import org.openqa.selenium.Cookie;
import java.io.*;
import java.util.Set;

import core.DriverFactory;

public class CookieManager {
	
    public static void salvarCookies() {
        try {
            FileOutputStream fileOut = new FileOutputStream("cookies.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            Set<org.openqa.selenium.Cookie> cookies = DriverFactory.getDriver().manage().getCookies();
            
            out.writeObject(cookies);
            
            out.close();
            fileOut.close();
            System.out.println("Cookies salvos.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarCookies() {
        try {
            FileInputStream fileIn = new FileInputStream("cookies.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            @SuppressWarnings("unchecked")
            Set<Cookie> cookies = (Set<Cookie>) in.readObject();
            
            for (Cookie cookie : cookies) {
                DriverFactory.getDriver().manage().addCookie((org.openqa.selenium.Cookie) cookie);
            }
            
            in.close();
            fileIn.close();
            System.out.println("Cookies carregados.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}