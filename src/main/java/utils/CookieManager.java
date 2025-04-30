package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Set;

import core.DriverManager;

public class CookieManager {
	
    public static void salvarCookies() {
        try {
            FileOutputStream fileOut = new FileOutputStream("cookies.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            Set<org.openqa.selenium.Cookie> cookies = DriverManager.getDriver().manage().getCookies();
            
            out.writeObject(cookies);
            
            out.close();
            fileOut.close();
            System.out.println("Cookies salvos.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarCookies() {
        WebDriver driver = DriverManager.getDriver();

        File file = new File("cookies.ser");

        if (!file.exists() || file.length() == 0) {
            System.out.println("Arquivo de cookies não existe ou está vazio.");
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            Set<Cookie> cookies = (Set<Cookie>) in.readObject();
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }
            System.out.println("Cookies carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean validarCookies(String urlProtegida) {
    	CookieManager.carregarCookies();
		DriverManager.getDriver().get(urlProtegida);
		return DriverManager.getDriver().getCurrentUrl().equals(urlProtegida);
    }
}