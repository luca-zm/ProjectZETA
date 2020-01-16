package logic.persistence;

public class Query {
	
	public static final String SCOPE_IDENTITY = "SELECT LAST_INSERT_ID()";
	
	public static final String INSERT_ACTCODE = "INSERT INTO activationcode(activationCode, greenCoinAdded) VALUES (?,?)";

	public static final String INSERT_ADDRESS = "INSERT INTO address ( address, city, postalCode, telephone, state, country, zone) values (?,?,?,?,?,?,?)";
	
	public static final String INSERT_COLLECTIONPOINT = "INSERT INTO collectionpoint(name, longitude, latitude, address, openingTime, closingTime, isAvailable) VALUES (?,?,?,?,?,?,?)";
	
	public static final String INSERT_MESSAGE = "INSERT INTO message(date, title, bodymessage, type, userId) VALUES (?,?,?,?,?)";
	
	public static final String INSERT_PRODUCT = "INSERT INTO product(name, price, discountPercentage, category, image, description, availability) VALUES (?,?,?,?,?,?,?)";

	public static final String INSERT_BONUSTRAN = "INSERT INTO bonustran(date, description, greenCoinAdded, userId) VALUES (?,?,?,?)";
	
	public static final String INSERT_ACTCODETRAN = "INSERT INTO activationcodetran(date, activationCode, greenCoinAdded, userId) VALUES (?,?,?,?)";
	
	public static final String INSERT_SHIPMENT = "INSERT INTO shipment(date, trackingNumber, product, price, deliveryStatus, userId) VALUES (?,?,?,?,?,?)";
	
	public static final String INSERT_USER = "INSERT INTO user(mail, name, surname, pass, type, cart, history, boards, greenCoin, address) VALUES (?,?,?,?,?,?,?,?,?,?)";
	
	public static final String INSERT_WISHLIST = "INSERT INTO wishlist(userId, productId) VALUES (?,?)";

	public static final String DELETE_ACTCODE = "DELETE FROM activationcode WHERE activationCode = ?";
	
	public static final String DELETE_ADDRESS = "DELETE FROM address WHERE id = ?";
	
	public static final String DELETE_COLLECTIONPOINT = "DELETE FROM collectionpoint WHERE id = ?";
	
	public static final String DELETE_MESSAGE = "DELETE FROM message WHERE id = ?";
	
	public static final String DELETE_PRODUCT = "DELETE FROM product WHERE id = ?";
	
	public static final String DELETE_BONUSTRAN = "DELETE FROM bonustran WHERE id = ?";
	
	public static final String DELETE_ACTCODETRAN = "DELETE FROM actcodetran WHERE id = ?";
	
	public static final String DELETE_SHIPMENT = "DELETE FROM shipment WHERE id = ?";
	
	public static final String DELETE_USER = "DELETE FROM user WHERE id = ?";
	
	public static final String DELETE_WISHLIST = "DELETE FROM wishlist WHERE userId = ? AND productId = ?";
	
	
	/** dal progetto di MAURO
	 * 
	 * 
	 * public static final String RETRIEVE_CATEGORIES = "SELECT * FROM categories";

    public static final String FIND_REGISTERED_USER = "SELECT * FROM users WHERE Mail = ? and password = ?";

    public static final String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE Mail = ?";

    public static final String SEARCH_PRODUCTS_BY_NAME = "SELECT * " +
            "FROM products " +
            "WHERE Availability = 1 AND products.ProductName LIKE ?";

    public static final String SEARCH_PRODUCT = "SELECT * " +
            "FROM products";

    public static final String SEARCH_PRDUCT_BY_ID = "SELECT * " +
            "FROM products " +
            "WHERE products.ProductID = ?";

    public static final String INSERT_PRODUCT = "INSERT INTO Products (ProducerEmail, Category, ProductName, " +
            "ProductDescription, Picture, Price, Manufacturer, isCharitable, DiscountPercentage, " +
            "ShipmentCost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String UPDATE_PRODUCT = "UPDATE products SET ProductName=?, ProductDescription=?, Price=?, DiscountPercentage=? WHERE ProductID=?";

    public static final String DELETE_PRODUCT = "DELETE FROM products WHERE ProductID = ?";

    public static final String ADD_REVIEW = "INSERT INTO reviews(productId, username, rating, comment) VALUES (?,?,?,?)";

    public static final String FIND_REVIEWS_BY_PRODUCT_ID = "SELECT * FROM reviews WHERE productId = ?";

    public static final String FIND_REVIEWS_BY_USERNAME = "SELECT * FROM reviews WHERE username = ?";

    public static final String FIND_SHIPMENT_STATUS = "SELECT * FROM shipments WHERE ShipmentTrack = ?"; //Creato da Richard

    public static final String FIND_USER_BY_USERNAME = "SELECT * FROM users WHERE Username = ?"; //Creato da Richard

    public static final String INSERT_USER = "INSERT INTO users (Username, Mail, Password, Name, Surname, Address1, Address2, City, State, PostalCode, Country, Phone, Website, PayPalAccount, Type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; //Creato da Richard
**/
	
	
}
