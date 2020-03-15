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

public class ExportMember extends AddMember {
	Connection con;

	public ExportMember() throws InstantiationException, IllegalAccessException, SQLException {
		super();

	}

	public static int exportmember() throws SQLException, IOException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/storemanagement?verifyServerCertificate=false&useSSL=true";

		Connection con = DriverManager.getConnection(url, "root", "root");
		PreparedStatement st = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM storemanagement.member";
		st = con.prepareStatement(sql);
		rs = st.executeQuery();

		ArrayList mid = new ArrayList();
		ArrayList mname = new ArrayList();

		ArrayList email = new ArrayList();
		ArrayList contact = new ArrayList();

		while (rs.next()) {
			int id = rs.getInt("member_id");
			String d = rs.getString("name");
			String e = rs.getString("email");
			int f = rs.getInt("contact");
			mid.add(id);
			mname.add(d);
			email.add(e);

			contact.add(f);
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("members.csv")));
		for (int i = 0; i < mid.size(); i++) {

			writer.write("Member ID: " + mid.get(i));
			writer.newLine();
			writer.write("Member Name: " + mname.get(i));
			writer.newLine();
			writer.write(" Email  : " + email.get(i));
			writer.newLine();

			writer.write("Contact: " + contact.get(i));
			writer.newLine();
			writer.newLine();
		}
		writer.close();

		return 1;
	}

}
