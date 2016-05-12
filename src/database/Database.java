package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

public class Database {

    private String url = "jdbc:mysql://localhost:3306/lowongankerja";
    private String user = "root";
    private String passUser = "";
    private Statement st = null;
    private Connection con = null;
    private ResultSet rs = null;
    
    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, passUser);
//            st = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
//            ex.printStackTrace();
        }
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
            ex.printStackTrace();
        }
    }

    public ArrayList<Owner> readDataOwner(){
        ArrayList<Owner> daftarOwner = new ArrayList();
        String state = "SELECT idPelamar, namaPelamar, passPelamar FROM pelamar";
        ResultSet ss = getData(state);
        try {
            while (ss.next()) {
                Pelamar p = new Pelamar(rs.getString("idPelamar"), rs.getString("namaPelamar"), rs.getString("passPelamar"));
//                System.out.println("nama : "+ p.getIdAkun());
                daftarOwner.add(p);
            }
            System.out.println("readed data pelamar");
        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
            Logger.getLogger(aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        state = "SELECT idPerusahaan, nama, password FROM perusahaan";
        ss = getData(state);
        try {
            while (ss.next()) {
                Perusahaan pp = new Perusahaan(rs.getString("idPerusahaan"), rs.getString("nama"), rs.getString("password"));
//                System.out.println("nama : "+ pp.getIdAkun());
                daftarOwner.add(pp);
                System.out.println("readed data perusahaan");
            }
        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
            Logger.getLogger(aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarOwner;
    }

    public int savePelamar(Pelamar p){
//        (`idPelamar`, `namaPelamar`, `passPelamar`)
        String state = "INSERT INTO pelamar VALUES ("
            + "'" + p.getIdAkun() + "',"
            + "'" + p.getNama() + "',"
            + "'" + p.getPassword() + "')";
        try {
            query(state);
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    public int savePerusahaan(Perusahaan p){
//        (`idPerusahaan`, `nama`, `password`)
        String state = "INSERT INTO perusahaan VALUES ("
            + "'" + p.getIdAkun() + "',"
            + "'" + p.getNama() + "',"
            + "'" + p.getPassword() + "')";
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
    
    public int saveBerkas(Pelamar p) throws FileNotFoundException, SQLException{
        String state = "INSERT INTO berkaslamaran (idAkun, namaFileCV, namaFileSLK) VALUES ("
            + "'" + p.getIdAkun() + "',"
            + "'" + p.getBerkas().getFileCV() + "',"
            + "'" + p.getBerkas().getFileSLK() + "')";
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        state =  "UPDATE `berkaslamaran`set fileCV=? where idPelamar = " + p.getIdAkun();
        PreparedStatement ps = con.prepareStatement(state);
        File f = new File((p.getBerkas()).getFileCV());
        FileInputStream input = new FileInputStream(f);
        try {
//            PreparedStatement ps = con.prepareStatement(state);            
            ps.setBinaryStream(1, input);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        state = "UPDATE `berkaslamaran`set fileSLK=? where idPelamar = " + p.getIdAkun();
        ps = con.prepareStatement(state);
        File f2 = new File((p.getBerkas()).getFileSLK());
        input = new FileInputStream(f2);
        try{
            ps.setBinaryStream(2, input);
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    public int updateBerkas(Pelamar p) throws SQLException, FileNotFoundException{
        String state =  "UPDATE `berkaslamaran`set fileCV=? where idPelamar = " + p.getIdAkun();
        PreparedStatement ps = con.prepareStatement(state);
        File f = new File((p.getBerkas()).getFileCV());
        FileInputStream input = new FileInputStream(f);
        try {
//            PreparedStatement ps = con.prepareStatement(state);            
            ps.setBinaryStream(1, input);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        state = "UPDATE `berkaslamaran`set fileSLK=? where idPelamar = " + p.getIdAkun();
        ps = con.prepareStatement(state);
        File f2 = new File((p.getBerkas()).getFileSLK());
        input = new FileInputStream(f2);
        try{
            ps.setBinaryStream(2, input);
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
//    public void readBerkas(Pelamar p) throws SQLException, FileNotFoundException{
//        String state = "SELECT fileCV FROM `berkaslamaran` where idPelamar = " + p.getIdAkun();
//        ResultSet rs = getData(state);
//        File f = null; //= new File(rs.getBlob(2));
//        FileInputStream input = null;
//        FileOutputStream output = new FileOutputStream(f);
//        try{
//            if(rs.next()){
//                input = rs.getBinaryStream("fileCV");
//                byte[] buffer = new byte[1024];
//                while (input.read(buffer) > 0){
//                    output.write(buffer);
//                }
//                System.out.println("Saved to file : " + f.getAbsolutePatch());
//            }
//        } catch (SQLException ex){
//            System.out.println(ex.getMessage());
//        }
//    }
    
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
        String state = "SELECT idPelamar, namaFileCV, namaFileSLK FROM `berkaslamaran`";
        ResultSet rs = getData(state);
        try {
            while (rs.next()) {
                BerkasLamaran b = new BerkasLamaran(rs.getString("namaFileCV"), rs.getString("namaFileSLK"));
                daftarBerkas.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return daftarBerkas;
    }
    
    public int updatePassPelamar(Pelamar p){
        String state = "UPDATE pelamar SET passPelamar = '" + p.getPassword() + "' where idPelamar = " + p.getIdAkun();
        try{
            query(state);
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    public int updatePassPerusahaan(Perusahaan p){
        String state = "UPDATE perusahaan SET password = '" + p.getPassword() + "' where idPerusahaan = " + p.getIdAkun();
        try{
            query(state);
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
      
    public void updatePerusahaan(Perusahaan p) {
        String state = "UPDATE perusahaan SET nama = '" + p.getNama()
                    + "', password = '" + p.getPassword() + "' where idPerusahaan = " + p.getIdAkun();
        try {
            query(state);
//            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
//            return -1;
        }
    }
    
    public void updatePelamar(Pelamar p) {
        String state = "UPDATE pelamar SET namaPelamar = '" + p.getNama() + "', passPelamar = '" 
                + p.getPassword()+ "' where idPelamar = " + p.getIdAkun();
        try {
            query(state);
//            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
//            return -1;
        }
    }
    
//    public void deletePerusahaan(String idAkun){
//        String state = "delete from Perusahaan where idPerusahaan= " + idAkun;
//        try {
//            query(state);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    
//    public void deletePelamar(String idAkun){
//        String state = "delete from Pelamar where idPelamar= " + idAkun;
//        try {
//            query(state);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    
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
