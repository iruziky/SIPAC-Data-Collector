package pages;

import org.openqa.selenium.By;

import components.RequestFilter;
import core.PageObject;

public class FiltersPage extends PageObject {
	private By searchButton = By.xpath("//*[@id=\"submit\"]");
	
	// Alterar para receber uma lista de filtros
	public void selectFilters(RequestFilter filter) {
		if (filter.isSelected()) click(filter.getCheckBoxXPath());
	}
	
	public void searchResults() {
		click(searchButton);
	}
}
