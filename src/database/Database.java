package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import model.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private String url = "jdbc:mysql://localhost:3306/lowongankerja";
    private String user = "root";
    private String passUser = "";
    private Statement st = null;
    private Connection con = null;
    private ResultSet rs = null;
    
    public ResultSet getRS(){
        try{
            return rs;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, passUser);
//            st = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ResultSet getData(String SQLString) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(SQLString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    public void query(String SQLString) throws SQLException {
        try {
            st = con.createStatement();
            st.executeUpdate(SQLString);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    public void bindTableLowongan(Perusahaan p){
//        connect();
//        String s = "SELECT `idLowongan`, `namaPkj`, `deadline` FROM `lowongan` "
//                + "WHERE `idPerusahaan` = '" + p.getIdAkun();
//        ResultSet rs = getData(s);
//        try {
//            ResultSetMetaData rsmt = rs.getMetaData();
//            int c = rsmt.getColumnCount();
//            Vector column = new Vector(c);
//            for (int i=1; i <= c; i++){
//                column.add(rsmt.getColumnName(i));
//            }
//            Vector data = new Vector();
//            Vector row = new Vector();
//            while (rs.next()){
//                row = new Vector(c);
//                for (int i=1; i <= c; i++){
//                    row.add(rs.getString(i));
//                }
//                data.add(row);
//            }
//        } catch (SQLException ex){
//            Logger.getLogger(aplikasi.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    //untuk mengambil data dari tabel pelamar dan perusahaan yg ada pd mysql
    public ArrayList<Owner> readDataOwner(){
        ArrayList<Owner> daftarOwner = new ArrayList();
        String state = "SELECT idPelamar, namaPelamar, passPelamar FROM pelamar";
        ResultSet ss = getData(state);
        try {
            while (ss.next()) {
                Pelamar p = new Pelamar(rs.getInt("idPelamar"), rs.getString("namaPelamar"), rs.getString("passPelamar"));
                daftarOwner.add(p);
            }
            System.out.println("data pelamar terbaca");
        } catch (SQLException ex) {
            Logger.getLogger(aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        state = "SELECT idPerusahaan, nama, password FROM perusahaan";
        ss = getData(state);
        try {
            int j=0;
            while (ss.next()) {
                Perusahaan pp = new Perusahaan(rs.getInt("idPerusahaan"), rs.getString("nama"), rs.getString("password"));
                daftarOwner.add(pp);
            }
            System.out.println("data perusahaan terbaca");
        } catch (SQLException ex) {
            Logger.getLogger(aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarOwner;
    }
    
    //untuk mengambil data dari tabel lowongan yg ada pd mysql
    public ArrayList<Lowongan> readDataLowongan(){
        ArrayList<Lowongan> daftarLowongan = new ArrayList();
        String state = "SELECT `idLowongan`, `namaPkj`, `deadline` FROM `lowongan`";
        ResultSet ss = getData(state);
        try {
            while (ss.next()) {
                Lowongan l = new Lowongan(rs.getInt("idLowongan"), rs.getString("namaPkj"), rs.getDate("deadline"));
                daftarLowongan.add(l);
            }
            System.out.println("data lowongan terbaca");
        } catch (SQLException ex) {
            Logger.getLogger(aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarLowongan;
    }
    
    //untuk menambahkan akun pelamar baru pada database
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
    
    //untuk menambahkan akun perusahaan baru pada database
    public int savePerusahaan(Perusahaan p){
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
    
    //untuk menambahkan lowongan baru pada database
    public int saveLowongan(Perusahaan p, Lowongan data, Date sqldate){
        String state = "INSERT INTO `lowongan`(`idPerusahaan`, `idLowongan`, `namaPkj`, `deadline`) VALUES ("
            + "'" + p.getIdAkun() + "',"
            + "'" + data.getId() + "',"
            + "'" + data.getNamaPkrj() + "',"
            + "'" + sqldate + "')";
        try {
            query(state);
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    //untuk menyimpan perubahan data lowongan dari suatu perusahaan
    public int updateLowongan(Perusahaan p, Lowongan data, Date sqldate){
        String state = "UPDATE `lowongan` SET `namaPkj` = '" + data.getNamaPkrj()
            + "', `deadline`= '" + sqldate
            + "' where `idPerusahaan` = " + p.getIdAkun() 
            + "' AND `idLowongan` = " + data.getId();
        try {
            query(state);
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    //untuk menyimpan perubahan password suatu akun pelamar
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
    
    //untuk menyimpan perubahan password suatu akun perusahaan
    public int updatePassPerusahaan(Perusahaan p){
        String state = "UPDATE perusahaan SET password = '" + p.getPassword() 
                + "' where `idPerusahaan` = '" + p.getIdAkun() +"'";
        try{
            query(state);
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    //untuk menyimpan perubahan data akun perusahaan
    public void updatePerusahaan(Perusahaan p) {
        String state = "UPDATE perusahaan SET nama = '" + p.getNama()
                    + "', password = '" + p.getPassword() + "' where idPerusahaan = " + p.getIdAkun();
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //untuk menyimpan perubahan data akun pelamar
    public void updatePelamar(Pelamar p) {
        String state = "UPDATE pelamar SET namaPelamar = '" + p.getNama() + "', passPelamar = '" 
                + p.getPassword()+ "' where idPelamar = " + p.getIdAkun();
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //untuk menyimpan data berkas yg dikonversikan dalam bentuk blob
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
    
    //untuk menyimpan perubahan data berkas yang sudah ada sebelumnya
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
    
    //untuk menampilkan data perusahaan pada jComboBox pada pencarian lowongan
    public HashMap<String, Integer> populateCombo(){
        HashMap<String, Integer> listCompany = new HashMap<>();
        connect();
        Statement st;
        ResultSet rs;
        String state = "SELECT `idPerusahaan`, `nama` FROM `perusahaan";
        try {
            st = con.createStatement();
            rs = st.executeQuery(state);
            while(rs.next()){
                listCompany.put(rs.getString("nama"), rs.getInt("idPerusahaan"));
            }
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listCompany;
    }
    
    //untuk menampilkan data lowongan (dari suatu perusahaan) pada jComboBox pada pencarian lowongan
    public HashMap<String, Integer> populateComboLowongan(Perusahaan p){
        HashMap<String, Integer> listJobVacancy = new HashMap<>();
        connect();
        Statement st;
        ResultSet rs;
        String state = "SELECT `idLowongan`, `namaPkj`, `deadline` FROM `lowongan` "
                + "where idPerusahaan = " + p.getIdAkun();
        try {
//            rs = getData(state);
            st = con.createStatement();
            rs = st.executeQuery(state);
            while(rs.next()){
                String s = rs.getString("namaPkj")+ " , Deadline : "+ rs.getDate("deadline");
                listJobVacancy.put(s, rs.getInt("idLowongan"));
            }
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listJobVacancy;
    }
    
    public ArrayList<Lowongan> populateTableLowongan(Perusahaan p){
        ArrayList<Lowongan> listJobVacancy = new ArrayList<Lowongan>();
        connect();
        Statement st;
        ResultSet rs;
        String state = "SELECT `idLowongan`, `namaPkj`, `deadline` FROM `lowongan` "
                + "where idPerusahaan = " + p.getIdAkun();
        try {
            st = con.createStatement();
            rs = st.executeQuery(state);
            while(rs.next()){
                Lowongan l = new Lowongan(rs.getInt("idLowongan"), rs.getString("namaPkj"), rs.getDate("deadline"));
                listJobVacancy.add(l);
            }
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listJobVacancy;
    }
    
    //untuk menghapus akun perusahaan
    public void deletePerusahaan(String idAkun){
        String state = "delete from Perusahaan where idPerusahaan= " + idAkun;
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //untuk menghapus akun pelamar
    public void deletePelamar(String idAkun){
        String state = "delete from Pelamar where idPelamar= " + idAkun;
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //untuk menghapus data lowongan dari suatu perusahaan
    public void deleteLowongan(Perusahaan p, Lowongan l){
        String state = "delete from berkaslamaran where idPelamar= " + p.getIdAkun() 
                + "and idLowongan = " + l.getId();
        try {
            query(state);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // ?
    public void readBerkas(Pelamar p) throws SQLException, FileNotFoundException{
        String state = "SELECT fileCV FROM `berkaslamaran` where idPelamar = " + p.getIdAkun();
        ResultSet rs = getData(state);
        File f = null; //= new File(rs.getBlob(2));
        FileInputStream input = null;
//        FileOutputStream output = new FileOutputStream(f);
        try{
            if(rs.next()){
//                input = rs.getBinaryStream("fileCV");
                byte[] buffer = new byte[1024];
//                while (input.read(buffer) > 0){
//                    output.write(buffer);
//                }
//                System.out.println("Saved to file : " + f.getAbsolutePatch());
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    // ?
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
    
    // ?
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
    
    // ?
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
    
    // ?
    public ArrayList getListLowongan(Perusahaan p) {
        ArrayList<Lowongan> listLowong = new ArrayList<>();
        try {
            String state = "SELECT idLowongan, namaPkj, deadline FROM `lowongan` where idPerusahaan = "+p.getIdAkun();
            ResultSet rs = getData(state);
            while (rs.next()) {
                Lowongan w = new Lowongan(rs.getInt("idLowongan"),rs.getString("namaPkj"), rs.getDate("deadline"));
                listLowong.add(w);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listLowong;
    }
    
}
