import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.MysqlConnection;

public class RegisterConnection extends Register_Login {

	Connection con;

	public static int Register_user(String a, String b, int c) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/storemanagement?verifyServerCertificate=false&useSSL=true";

		Connection con = DriverManager.getConnection(url, "root", "root");
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0;
		try {
			String sql = "insert into login(login_username,login_password,login_type) values(?,?,?)";
			st = con.prepareStatement(sql);

			st.setString(1, a);
			st.setString(2, b);
			st.setInt(3, c);
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;
	}

}
