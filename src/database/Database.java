package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pelamar;
import model.Perusahaan;

public class Database {

    String url = "jdbc:mysql://localhost:3306/lowongankerja";
    String user = "root";
    String pass = "";
    Statement st;
    Connection con;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            System.out.println("Berhasil");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void savePerusahaan(String idAkun, String nama, String pass){
        try {
            String query = "INSERT INTO `Perusahaan`(`idperusahaan`, `namap`, 'passp') VALUES ("
                    + "'" + idAkun + "',"
                    + "'" + nama + "',"
                    + "'" + pass + "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
//            int generatedId = -1;
//            if (rs.next()) {
//                generatedId = rs.getInt(1);
//            } 
//            p.setId(generatedId);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void savePelamar(String idAkun, String nama, String pass){
        try {
            String query = "INSERT INTO `Pelamar`(`idpelamar`, `nama`, `pass`,) VALUES ("
                    + "'" + idAkun + "',"
                    + "'" + nama + "',"
                    + "'" + pass + "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
//            int generatedId = -1;
//            if (rs.next()) {
//                generatedId = rs.getInt(1);
//            }
//            p.setId(generatedId);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Perusahaan getPerusahaan(String idPerusahaan){
        Perusahaan p = null;
        try {
            String query = "SELECT * FROM `Perusahaan` WHERE `idperusahaan` = " + idPerusahaan;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Perusahaan(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
    
    public Pelamar getPelamar(String idPelamar){
        Pelamar p = null;
        try {
            String query = "SELECT * FROM `Pelamar` WHERE `idperusahaan` = " + idPelamar;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Pelamar(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
    
    public void updatePerusahaan(String id, String nama, String pass) {
        String query = "update Perusahaan set namap ='" + nama
                    + ", passp ='" + pass + "' where idPerusahaan = " + id;
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updatePelamar(String id, String nama, String pass) {
        String query = "update Pelamar set nama ='" + nama
                    + ", pass ='" + pass + "' where idPelamar = " + id;
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updatePassPerusahaan(String id, String pass){
        String query = "update Perusahaan set pass = " + pass + "' where idPerusahaan = "
                    + id;
        try{
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updatePassPelamar(String id, String pass){
        String query = "update Pelamar set pass = " + pass + "' where idPelamar = "
                    + id;
        try{
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deletePerusahaan(String idAkun){
        String query = "delete from Perusahaan where idPerusahaan= " + idAkun;
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deletePelamar(String idAkun){
        String query = "delete from Pelamar where idPelamar= " + idAkun;
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public String[] getListIDPerusahaan() {
        ArrayList<String> listId = new ArrayList<>();
        try {
            String query = "SELECT idPerusahaan, namap FROM `perusahaan`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                listId.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listId.toArray(new String[0]);
    }
    
    

    public Pelamar getPelamar(String idPelamar){
        Pelamar p = null;
        try {
            String query = "SELECT * FROM `Pelamar` WHERE `idpelamar` = " + idPelamar;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Pelamar(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
    
    public void updatePelamar(Pelamar p) {
        try {
            String query = "update pelamar set nama ='"
                    + p.getNama() + 
                    "' where idPelamar = "
                    + p.getIdAkun() + "' AND pass = "
                    + String.valueOf(p.getPassword());
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deletePelamar(Pelamar p){
        try {
            String query = "delete from pelamar where idPelamar = "
                    + p.getIdAkun() + "' AND pass = "
                    + String.valueOf(p.getPassword());
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public String[] getListIDPelamar() {
        ArrayList<String> listId = new ArrayList<>();
        try {
            String query = "SELECT idPelamar, nama FROM `pelamar`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                listId.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listId.toArray(new String[0]);
    }

}
