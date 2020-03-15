import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class LoginConnection extends LoginFrame {

	Connection con;

	public static int Login(String a, String b) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/storemanagement?verifyServerCertificate=false&useSSL=true";

		Connection con = DriverManager.getConnection(url, "root", "root");
		PreparedStatement st = null;
		ResultSet rs = null;

		String sql = "SELECT login_username,login_password FROM login where login_username = ? ";

		st = con.prepareStatement(sql);
		st.setString(1, a);
		rs = st.executeQuery();

		int num = 1;
		while (rs.next()) {
			String id = rs.getString(1);
			String pwd = rs.getString(2);
			if (a.equals(id) && b.equals(pwd)) {

				num = 0;

			}

		}

		return num;
	}
}
