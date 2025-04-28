package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import core.PageObject;

public class LoginPage extends PageObject {
    
    private By campoUsuario = By.xpath("//*[@id='username']");
    private By campoSenha = By.xpath("//*[@id=\"password\"]");
    private By botaoLogin = By.xpath("//*[@id=\"login-form\"]/div[6]/button");
    
    public void fazerLogin(String usuario, String senha) {
    	waitElement(campoUsuario, 5);
    	
        write(campoUsuario, usuario);
        write(campoSenha, senha);
        
        click(botaoLogin);
    }
    
    public void salvarCookies() {
        try {
            FileOutputStream fileOut = new FileOutputStream("cookies.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            Set<Cookie> cookies = driver.manage().getCookies();
            
            out.writeObject(cookies);
            out.close();
            fileOut.close();
            System.out.println("Cookies salvos.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void carregarCookies() {
        try {
            FileInputStream fileIn = new FileInputStream("cookies.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            @SuppressWarnings("unchecked")
            Set<Cookie> cookies = (Set<Cookie>) in.readObject();
            
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }
            
            in.close();
            fileIn.close();
            System.out.println("Cookies carregados.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}