import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExportProducts extends AddProduct {
	Connection con;

	public ExportProducts() throws InstantiationException, IllegalAccessException, SQLException {
		super();

	}

	public static int exportproduct() throws ClassNotFoundException, SQLException, IOException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/storemanagement?verifyServerCertificate=false&useSSL=true";

		Connection con = DriverManager.getConnection(url, "root", "root");
		PreparedStatement st = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM storemanagement.product";
		st = con.prepareStatement(sql);
		rs = st.executeQuery();

		ArrayList pid = new ArrayList();
		ArrayList pname = new ArrayList();

		ArrayList quantity = new ArrayList();
		ArrayList price = new ArrayList();

		while (rs.next()) {
			int id = rs.getInt("product_id");
			String d = rs.getString("product_name");
			String e = rs.getString("product_quantity");
			int f = rs.getInt("product_price");
			pid.add(id);
			pname.add(d);
			quantity.add(e);

			price.add(f);
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("product.csv")));
		for (int i = 0; i < pid.size(); i++) {

			writer.write("Product ID: " + pid.get(i));
			writer.newLine();
			writer.write("Product Name: " + pname.get(i));
			writer.newLine();
			writer.write(" Product Quantity  : " + quantity.get(i));
			writer.newLine();

			writer.write("Price " + price.get(i));
			writer.newLine();
			writer.newLine();
		}
		writer.close();

		return 1;

	}

}
