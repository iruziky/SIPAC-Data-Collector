package pages;

import org.openqa.selenium.By;

import core.PageObject;

public class HomePage extends PageObject {
    
    private By requestsMenu = By.xpath("//*[@id=\"formmenuadm_menuadm_menu\"]/table/tbody/tr/td[1]/span[2]");
    private By subMenu = By.xpath("//*[@id=\"cmSubMenuID1\"]/table/tbody/tr[1]/td[2]");
    private By sentRequests = By.xpath("//*[@id=\"cmSubMenuID2\"]/table/tbody/tr[1]");
    
    public void getRequestsMenu() {
        waitElement(requestsMenu, 10);
        
        click(requestsMenu);
        click(subMenu);
        click(sentRequests);
    }
}
