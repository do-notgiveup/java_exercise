package vn.edu.likelion.WriteFileIntoDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class WriteFileIntoDbApplication {

    public static void writeFileIntoDb(String url, String user, String pass) {

        BufferedReader br = null;
        PreparedStatement stat = null;
        ResultSet resultSet = null;
        try (Connection conn = DriverManager.getConnection(url, user, pass)){
            br = new BufferedReader(new FileReader("StudentsList.txt"));
            String line;
            String query;

            // xoa db truoc khi add
            conn.prepareStatement("delete from hocvien").execute();

            while ((line = br.readLine()) != null) {
                resultSet = conn.prepareStatement("select count(*) from hocvien").executeQuery();
                int id = 0;
                if (resultSet.next())
                    id = (Integer.parseInt(resultSet.getString(1)) + 1);

                query = "insert into hocvien(id, name, status) values (?, ?, ?)";
                stat = conn.prepareStatement(query);
                stat.setInt(1, id);
                stat.setString(2, line.split("\t")[1]);
                stat.setInt(3, Integer.parseInt(line.split("\t")[2]));
                stat.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                stat.close();
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
