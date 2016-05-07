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

    public int connect() {
        int hasil = 0;
        try {
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            hasil = 1;
//            System.out.println("Berhasil");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hasil;
    }

    public ResultSet getData(String SQLString) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(SQLString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    public void query(String SQLString) throws SQLException {
        try {
            st = con.createStatement();
            st.executeUpdate(SQLString);
        } catch (SQLException c) {
            c.printStackTrace();
        }
    }
    
    public int savePerusahaan(String idAkun, String nama, String pass){
        String state = "INSERT INTO `perusahaan`(`idPerusahaan`, `nama`, 'password') VALUES ("
            + "'" + idAkun + "',"
            + "'" + nama + "',"
            + "'" + pass + "')";
        try {
            query(state);
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    public int savePelamar(String idAkun, String nama, String pass){
        String state = "INSERT INTO `pelamar`(`idPelamar`, `namaPelamar`, `passPelamar`) VALUES ("
            + "'" + idAkun + "',"
            + "'" + nama + "',"
            + "'" + pass + "')";
        try {
            query(state);
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    public void saveLowongan(String idAkun, String namaPekerjaan, Date deadline){
        String state = "INSERT INTO `lowongan` (`namaPkj`, `deadline`, `idPerusahaan`) VALUES ("
            + "'" + namaPekerjaan + "',"
            + "'" + deadline + "',"
            + "'" + idAkun + "')";
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void saveBerkas(String idAkun, String cv, String slk){
        String state = "INSERT INTO `berkaslamaran` (`fileCV`, `fileSLK`, `idPelamar`) VALUES ("
            + "'" + cv + "',"
            + "'" + slk + "',"
            + "'" + idAkun + "')";
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    public ArrayList<Perusahaan> readDataPerusahaan(){
        ArrayList<Perusahaan> daftarPrs = new ArrayList();
        try {
            String query = "SELECT idPerusahaan, nama, password FROM `Perusahaan`";
            ResultSet rs = getData(query);
            while (rs.next()) {
                Perusahaan p = new Perusahaan(rs.getString("idPerusahaan"), rs.getString("nama"), rs.getString("password"));
                daftarPrs.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarPrs;
    }
    
    public ArrayList<Pelamar> readDataPelamar(){
        ArrayList<Pelamar> daftarPel = new ArrayList();
        String state = "SELECT idPelamar, namaPelamar, passPelamar FROM `Pelamar`";
        ResultSet rs = getData(state);
        try {
            while (rs.next()) {
                Pelamar p = new Pelamar(rs.getString("idPelamar"), rs.getString("namaPelamar"), rs.getString("passPelamar"));
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
            String query = "SELECT idPerusahaan, namaPkj, deadline FROM `lowongan`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
//                Lowongan w = new Lowongan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                Lowongan w = new Lowongan(rs.getString("namaPkj"), rs.getDate("deadline"));
                daftarLowong.add(w);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarLowong;
    }
    
    public void updatePerusahaan(String id, String nama, String pass) {
        String state = "update Perusahaan set nama ='" + nama
                    + ", pass ='" + pass + "' where idPerusahaan = " + id;
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updatePelamar(String id, String nama, String pass) {
        String state = "update Pelamar set namaPelamar ='" + nama
                    + ", passPelamar ='" + pass + "' where idPelamar = " + id;
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updatePassPerusahaan(String id, String pass){
        String state = "update Perusahaan set pass = " + pass + "' where idPerusahaan = "
                    + id;
        try{
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updatePassPelamar(String id, String pass){
        String state = "update Pelamar set passPelamar = " + pass + "' where idPelamar = "
                    + id;
        try{
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deletePerusahaan(String idAkun){
        String state = "delete from Perusahaan where idPerusahaan= " + idAkun;
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deletePelamar(String idAkun){
        String state = "delete from Pelamar where idPelamar= " + idAkun;
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public String[] getListIDPerusahaan() {
        ArrayList<String> listId = new ArrayList<>();
        try {
            String state = "SELECT idPerusahaan, nama FROM `Perusahaan`";
            query(state);
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
            String state = "SELECT idPelamar, namaPelamar FROM `pelamar`";
            ResultSet rs = getData(state);
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
            String state = "SELECT namaPkj FROM `lowongan`";
            ResultSet rs = getData(state);
            while (rs.next()) {
                listLowong.add(rs.getString("namaPkj"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listLowong.toArray(new String[0]);
    }

}
