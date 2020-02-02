package logic.persistence;

public class Query {
	
	public static final String SCOPE_IDENTITY = "SELECT LAST_INSERT_ID()";
	
	public static final String INSERT_ACTCODE = "INSERT INTO activationcode(activationCode, greenCoinAdded) VALUES (?,?)";

	public static final String INSERT_ADDRESS = "INSERT INTO address ( address, city, postalCode, telephone, state, zone) values (?,?,?,?,?,?)";
	
	public static final String INSERT_COLLECTIONPOINT = "INSERT INTO collectionpoint(name, longitude, latitude, address, openingTime, closingTime) VALUES (?,?,?,?,?,?)";
	
	public static final String INSERT_MESSAGE = "INSERT INTO message(date, title, bodymessage, type, userId) VALUES (?,?,?,?,?)";
	
	public static final String INSERT_PRODUCT = "INSERT INTO product(name, price, discountPercentage, category, image, description, availability) VALUES (?,?,?,?,?,?,?)";

	public static final String INSERT_BONUSTRAN = "INSERT INTO bonustran(date, description, greenCoinAdded, userId) VALUES (?,?,?,?)";
	
	public static final String INSERT_ACTCODETRAN = "INSERT INTO activationcodetran(date, activationCode, greenCoinAdded, userId) VALUES (?,?,?,?)";
	
	public static final String INSERT_SHIPMENT = "INSERT INTO shipment(date, trackingNumber, product, deliveryStatus, userId) VALUES (?,?,?,?,?)";
	
	public static final String INSERT_USER = "INSERT INTO user(mail, name, surname, pass, type, greenCoin, address) VALUES (?,?,?,?,?,?,?)";
	
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
	
	public static final String SELECT_ACTCODE = "SELECT * from activationcode WHERE activationCode = ?";

	public static final String SELECT_ADDRESS = "SELECT * from address WHERE id = ?";
	
	public static final String SELECT_COLLECTIONPOINT = "SELECT * from collectionpoint";
	
	public static final String SELECT_MESSAGE = "SELECT * from message WHERE userid = ?";
	
	public static final String SELECT_MESSAGEBROAD = "SELECT * from message WHERE userid = 0";
	
	public static final String SELECT_PRODUCTS = "SELECT * from product";
	
	public static final String SELECT_PRODUCT = "SELECT * from product WHERE id = ?";

	public static final String SELECT_BONUSTRAN = "SELECT * from bonustran WHERE userid = ?";
	
	public static final String SELECT_ACTCODETRAN = "SELECT * from activationcodetran WHERE userid = ?";
	
	public static final String SELECT_SHIPMENT = "SELECT * from shipment WHERE userid = ?";
	
	public static final String SELECT_REGISTEREDUSER = "SELECT * from user WHERE mail = ?";
	
	public static final String SELECT_USERBYID = "SELECT * from user WHERE id = ?";
	
	public static final String SELECT_USERS = "SELECT * from user";
	
	public static final String SELECT_WISHLIST = "SELECT * from wishlist WHERE userid = ?";
	
	public static final String UPDATE_ADDRESS = "UPDATE address SET address = ?, city = ?, postalCode = ?, telephone = ?, state = ?, zone = ? WHERE ID = ? ";
	
	public static final String UPDATE_COLLECTIONPOINT = "UPDATE collectionpoint SET name = ?, longitude = ?, latitude = ?, address = ?, openingTime = ?, closingTime = ? WHERE ID = ? ";
	
	public static final String UPDATE_PRODUCT = "UPDATE product SET name = ?, price = ?, discountPercentage = ?, category = ?, image = ?, description = ?, availability = ? WHERE ID = ? ";
	
	public static final String UPDATE_USER = "UPDATE user SET mail = ?, name = ?, surname = ?, pass = ?, type = ?, greenCoin = ?, address = ? WHERE id = ?";
	
	//.............
	public static final String FIND_PROD_IN_LIST = "SELECT * from wishlist WHERE productid = ?";

}