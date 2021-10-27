package pages;

import static driver.DriverManager.getDriver;

import org.openqa.selenium.*;


public class CartPage extends BasePage {

	static private final String CART_URL = "https://www.kruidvat.nl/cart";
	static private final By PRODUCT_LINK = By.xpath("//a[@class='product-summary__img-link']");

	public WebElement getProductLink() {
		return findElement(PRODUCT_LINK);
	}

	public void openCartOnUiWithCookie(String cartId) {
		Cookie cartCookie = new Cookie("kvn-cart", cartId);
		getDriver().get(CART_URL);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().addCookie(cartCookie);
		getDriver().navigate().refresh();
	}
}