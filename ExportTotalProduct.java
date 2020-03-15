import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExportTotalProduct extends AddProduct {
	Connection con;

	public ExportTotalProduct() throws InstantiationException, IllegalAccessException, SQLException {
		super();

	}

	public static int exportTotal() throws ClassNotFoundException, SQLException, IOException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/storemanagement?verifyServerCertificate=false&useSSL=true";

		Connection con = DriverManager.getConnection(url, "root", "root");

		PreparedStatement st;
		ResultSet rs;

		String sql = "SELECT product_price from storemanagement.product";
		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		ArrayList price = new ArrayList();
		// ArrayList pid = new ArrayList();
//	
//
		while (rs.next()) {
//		//	int id = rs.getInt("product_id");
			int f = rs.getInt("product_price");
//			//price.add(id);
			price.add(f);
		}
		int data = 0;
		for (int i = 0; i < price.size(); i++) {
			data += (int) price.get(i);
		}

//
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("TotalProduct.csv")));

//         
		writer.write("Total product Price =  " + data);
		writer.newLine();
		writer.close();
//
		return 1;

	}

}
