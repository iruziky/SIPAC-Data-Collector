package client;

import org.openqa.selenium.By;

import core.DriverManager;
import utils.DriverInterations;

public class LoginClient {
    
    private By campoUsuario = By.xpath("//*[@id='username']");
    private By campoSenha = By.xpath("//*[@id=\"password\"]");
    private By botaoLogin = By.xpath("//*[@id=\"login-form\"]/div[6]/button");
    
    public void fazerLogin(String usuario, String senha) {
    	DriverManager.getDriver();

    	DriverInterations.waitElement(campoUsuario, 5);
    	DriverInterations.write(campoUsuario, usuario);
    	DriverInterations.write(campoSenha, senha);
        
    	DriverInterations.click(botaoLogin);
    	System.out.println("AQUI");
    }
}