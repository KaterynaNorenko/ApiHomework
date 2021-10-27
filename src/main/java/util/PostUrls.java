package util;

public class PostUrls {
	private static final String CREATE_NEW_CART_URL = "https://www.kruidvat.nl/api/v2/kvn/users/anonymous/carts?lang=nl";
	private static final String CREATED_CART_URL = "https://www.kruidvat.nl/api/v2/kvn/users/anonymous/carts/cartId/entries?lang=nl";

	public static String getCreateNewCartUrl() {
		return CREATE_NEW_CART_URL;
	}

	public static String getCreatedCartUrl(String cartId) {
		return CREATED_CART_URL.replace("cartId", cartId);
	}
}