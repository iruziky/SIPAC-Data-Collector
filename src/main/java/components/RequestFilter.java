package components;

import org.openqa.selenium.By;

public class RequestFilter {
	private boolean checkBoxState;
    private By checkBoxXPath;
  	
    @SuppressWarnings("unused")
	private String dataInput;
	@SuppressWarnings("unused")
	private By dataInputxPath;
    
  	public RequestFilter(By xPath, boolean selected) {
		super();
		this.checkBoxXPath = xPath;
		this.checkBoxState = selected;
	}

	public By getCheckBoxXPath() {
		return checkBoxXPath;
	}

	public void setCheckBoxXPath(By xPath) {
		this.checkBoxXPath = xPath;
	}
	
	public boolean isSelected() {
		return checkBoxState;
	}
	
	public void setSelected(boolean selected) {
		this.checkBoxState = selected;
	}
}