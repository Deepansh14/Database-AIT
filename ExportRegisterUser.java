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

public class ExportRegisterUser  extends Register_Login{
	
	
	Connection con;
	
	public static int exportuser() throws SQLException, IOException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/storemanagement?verifyServerCertificate=false&useSSL=true";

		Connection con = DriverManager.getConnection(url, "root", "root");
		PreparedStatement st = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM storemanagement.login";
		st = con.prepareStatement(sql);
		rs = st.executeQuery();

		
		ArrayList uname = new ArrayList();

		ArrayList upwd = new ArrayList();
		ArrayList type = new ArrayList();

		while (rs.next()) {
		
			String d = rs.getString("login_username");
			String e = rs.getString("login_password");
			String f = rs.getString("login_type");
			uname.add(d);
			upwd.add(e);
			type.add(f);

		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("RegisterUser.csv")));
		for (int i = 0; i < uname.size(); i++) {

		
			writer.write(" UserName: " + uname.get(i));
			writer.newLine();
			writer.write(" Password  : " + upwd.get(i));
			writer.newLine();

			writer.write("Type: " + type.get(i));
		
			writer.newLine();
		}
		writer.close();

		return 1;

	}

}
