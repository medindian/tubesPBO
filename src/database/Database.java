package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.BerkasLamaran;
import model.Lowongan;
import model.Owner;
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
//        int hasil = 0;
        try {
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
//            hasil = 1;
//            System.out.println("Berhasil");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        return hasil;
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
        } catch (SQLException ex) {
            System.out.println(ex.getNextException());
        }
    }
    
    public ArrayList<Owner> readDataOwner(){
        ArrayList<Owner> daftarOwner = new ArrayList();
        String state = "SELECT idPerusahaan, nama, password FROM `perusahaan`";
        ResultSet rs = getData(state);
        try {
            while (rs.next()) {
                Perusahaan pp = new Perusahaan(rs.getString("idPerusahaan"), rs.getString("nama"), rs.getString("password"));
                daftarOwner.add(pp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        state = "SELECT idPelamar, namaPelamar, passPelamar FROM `pelamar`";
        rs = getData(state);
        try {
            while (rs.next()) {
                Pelamar p = new Pelamar(rs.getString("idPelamar"), rs.getString("namaPelamar"), rs.getString("passPelamar"));
                daftarOwner.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return daftarOwner;
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
    
    public int savePerusahaan(String id, String name, String password){
        String state = "INSERT INTO `perusahaan`(`idPerusahaan`, `nama`, 'password') VALUES ("
            + "'" + id + "',"
            + "'" + name + "',"
            + "'" + password + "')";
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
    
    public ArrayList<Lowongan> listLowongan(String company){
        ArrayList<Lowongan> daftar = new ArrayList();
        String state = "SELECT namaPkj, deadline FROM `lowongan` WHERE idPerusahaan = "+company;
        ResultSet rs = getData(state);
        try {
            while (rs.next()) {
                Lowongan w = new Lowongan(rs.getString("namaPkj"), rs.getDate("deadline"));
                daftar.add(w);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return daftar;
    }
    
    public ArrayList<Lowongan> readDataLowongan(){
        ArrayList<Lowongan> daftarLowong = new ArrayList();
        String state = "SELECT idPerusahaan, namaPkj, deadline FROM `lowongan`";
        ResultSet rs = getData(state);
        try {
            while (rs.next()) {
                Lowongan w = new Lowongan(rs.getString("namaPkj"), rs.getDate("deadline"));
                daftarLowong.add(w);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return daftarLowong;
    }
    
    public ArrayList<BerkasLamaran> readDataBerkasLamaran(){
        ArrayList<BerkasLamaran> daftarBerkas = new ArrayList();
        String state = "SELECT idPelamar, fileCV, fileSLK FROM `berkaslamaran`";
        ResultSet rs = getData(state);
        try {
            while (rs.next()) {
                BerkasLamaran b = new BerkasLamaran(rs.getString("idPelamar"), rs.getString("fileCV"), rs.getString("fileSLK"));
                daftarBerkas.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return daftarBerkas;
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
    
    public void deleteLowongan(Perusahaan p, String nama){
        String state = "delete from berkaslamaran where idPelamar= " + p.getIdAkun() 
                + "and namaPkj = "+nama;
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
    
    public ArrayList getListLowongan(Perusahaan p) {
        ArrayList<Lowongan> listLowong = new ArrayList<>();
        try {
            String state = "SELECT namaPkj, deadline FROM `lowongan` where idPerusahaan = "+p.getIdAkun();
            ResultSet rs = getData(state);
            while (rs.next()) {
                Lowongan w = new Lowongan(rs.getString("namaPkj"), rs.getDate("deadline"));
                listLowong.add(w);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listLowong;
    }
    
}
