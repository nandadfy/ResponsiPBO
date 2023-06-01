import java.sql.*;
import javax.swing.JOptionPane;

public class ModelLomba {
    String DBurl = "jdbc:mysql://localhost/db_lomba";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    static String[] username;
    String data[] = new String[2];

    public ModelLomba() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            System.out.println("Koneksi gagal");
        }
    }
    public String[][] readLomba(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5];

            String query = "SELECT * FROM lomba";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("judul"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = String.valueOf(resultSet.getDouble("alur"));
                data[jmlData][2] = String.valueOf(resultSet.getDouble("orisinalitas"));
                data[jmlData][3] = String.valueOf(resultSet.getDouble("pemilihanKata"));
                data[jmlData][4] = String.valueOf(resultSet.getDouble("nilai"));
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }


    public void insertLomba(String Judul, double Alur, double Orisinalitas, double PemilihanKata, double Nilai){
        int jmlData=0;

        try {
            String query = "SELECT * FROM lomba WHERE judul='" + Judul +"'";
            System.out.println(Judul + " " + Alur + " " + Orisinalitas + " " + PemilihanKata);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) {
                query = "INSERT INTO lomba(judul,alur,orisinalitas,pemilihanKata,Nilai) VALUES('"+ Judul +"','"+ Alur +"','"+ Orisinalitas +"','"+ PemilihanKata +"','"+ Nilai +"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateLomba(String Judul, double Alur, double Orisinalitas, double PemilihanKata, double Nilai){
        int jmlData=0;
        try {
            String query = "SELECT * FROM lomba WHERE judul='" + Judul +"'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) {
                query = "UPDATE lomba SET alur='" + Alur + "', orisinalitas='" + Orisinalitas + "', pemilihanKata='" + PemilihanKata + "', nilai='"+ Nilai + "' WHERE judul='" +Judul +"'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil Diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM lomba";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteLomba (String Judul) {
        try{
            String query = "DELETE FROM lomba WHERE judul = '"+ Judul +"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}

