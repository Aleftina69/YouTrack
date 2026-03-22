package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class HeaderPage extends BasePage {

    private By userMenu = By.xpath("//div[@class='user-menu']");
    private By logoutButton = By.xpath("//a[contains(text(),'Выход')]");

    public void logout() {
        click(userMenu);
        click(logoutButton);
    }
}