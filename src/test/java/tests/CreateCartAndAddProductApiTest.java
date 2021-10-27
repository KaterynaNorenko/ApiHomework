package tests;

import static driver.DriverManager.getDriver;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import helpers.MapHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pages.CartPage;
import templates.TemplatePayload;
import util.PostUrls;

import static org.assertj.core.api.Assertions.assertThat;


public class CreateCartAndAddProductApiTest {

	private final CartPage cartPage = new CartPage();
	private final PostUrls postUrls = new PostUrls();

	private final String contentType = "application/json";
	private final String productID = "4256477";
	private final int qty = 1;

	@Test
	public void createNewCartAndAddProduct() {

		Response createNewCartResponse = given().contentType(contentType).accept(contentType).when().post(
				postUrls.getCreateNewCartUrl()).then().extract().response();

		String cartId = createNewCartResponse.jsonPath().getString("guid");

		String request = TemplatePayload.getTemplatePayload("cartTemplate.txt",
				MapHelper.mapOf("code", "4256477", "quantity", "1"));
		given().header("Content-Type", contentType).body(request).post(
				postUrls.getCreatedCartUrl(cartId)).then().log().all().assertThat().statusCode(200).and().contentType(
				ContentType.JSON).body(matchesJsonSchemaInClasspath("schemaResponseCart.json")).body("entry.product.code",
				equalTo(productID)).body("quantity", equalTo(qty));

		cartPage.openCartOnUiWithCookie(cartId);

		assertThat(cartPage.getProductLink().getAttribute("href").contains(productID)).as(
				"Cart does not contain expected product").isTrue();

		getDriver().quit();
	}
}