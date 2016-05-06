package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Lowongan;
import model.Pelamar;
import model.Perusahaan;

public class Database {

    private String url = "jdbc:mysql://localhost:3306/lowongankerja";
    private String user = "root";
    private String pass = "";
    private Statement st;
    private Connection con;
    private ResultSet rs = null;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
//            System.out.println("Berhasil");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void savePerusahaan(String idAkun, String nama, String pass){
        String query = "INSERT INTO `Perusahaan`(`idPerusahaan`, `nama`, 'pass') VALUES ("
                    + "'" + idAkun + "',"
                    + "'" + nama + "',"
                    + "'" + pass + "')";
        try {
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void savePelamar(String idAkun, String nama, String pass){
        String query = "INSERT INTO `Pelamar`(`idPelamar`, `namaPelamar`, `passPelamar`,) VALUES ("
            + "'" + idAkun + "',"
            + "'" + nama + "',"
            + "'" + pass + "')";
        try {
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void saveLowongan(String idAkun, String namaPekerjaan, Date deadline){
        String query = "INSERT INTO `lowongan` VALUES "
            + "'" + namaPekerjaan + "',"
            + "'" + deadline + "',"
            + "'" + idAkun;
        try {
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void saveBerkas(String idAkun, String cv, String slk){
        String query = "INSERT INTO `berkaslamaran VALUES "
            + "'" + cv + "',"
            + "'" + slk + "',"
            + "'" + idAkun;
        try {
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    public ArrayList<Perusahaan> getDataPerusahaan(String idPerusahaan){
        ArrayList<Perusahaan> daftarPrs = new ArrayList();
        try {
            String query = "SELECT * FROM `Perusahaan`";
            rs = st.executeQuery(query);
            while (rs.next()) {
                Perusahaan p = new Perusahaan(rs.getString(1), rs.getString(2), rs.getString(3));
                daftarPrs.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarPrs;
    }
    
    public ArrayList<Pelamar> getDataPelamar(){
        ArrayList<Pelamar> daftarPel = new ArrayList();
        try {
            String query = "SELECT * FROM `Pelamar`";
            rs = st.executeQuery(query);
            while (rs.next()) {
                Pelamar p = new Pelamar(rs.getString(1), rs.getString(2), rs.getString(3));
                daftarPel.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarPel;
    }
    
    public ArrayList<Lowongan> getDataLowongan(){
        ArrayList<Lowongan> daftarLowong = new ArrayList();
        try {
            String query = "SELECT * FROM `lowongan`";
            rs = st.executeQuery(query);
            while (rs.next()) {
//                Lowongan w = new Lowongan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                Lowongan w = new Lowongan(rs.getString(1), rs.getDate(2));
                daftarLowong.add(w);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarLowong;
    }
    
    public void updatePerusahaan(String id, String nama, String pass) {
        String query = "update Perusahaan set nama ='" + nama
                    + ", pass ='" + pass + "' where idPerusahaan = " + id;
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updatePelamar(String id, String nama, String pass) {
        String query = "update Pelamar set namaPelamar ='" + nama
                    + ", passPelamar ='" + pass + "' where idPelamar = " + id;
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
        String query = "update Pelamar set passPelamar = " + pass + "' where idPelamar = "
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
            String query = "SELECT idPerusahaan, nama FROM `Perusahaan`";
            rs = st.executeQuery(query);
            while (rs.next()) {
                listId.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listId.toArray(new String[0]);
    }
    
    public String[] getListIDPelamar() {
        ArrayList<String> listId = new ArrayList<>();
        try {
            String query = "SELECT idPelamar, namaPelamar FROM `pelamar`";
            rs = st.executeQuery(query);
            while (rs.next()) {
                listId.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listId.toArray(new String[0]);
    }
    
    public String[] getListLowongan() {
        ArrayList<String> listLowong = new ArrayList<>();
        try {
            String query = "SELECT namaPkj FROM `lowongan`";
            rs = st.executeQuery(query);
            while (rs.next()) {
                listLowong.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listLowong.toArray(new String[0]);
    }

}
