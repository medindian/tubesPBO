package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import model.Pelamar;
import model.Perusahaan;

public class DatabaseConnection {

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String user = "kel5";
    private String pass = "kel5";
    private Statement st;
    private Connection con;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void savePerusahaan(Perusahaan p){
        try {
            String query = "INSERT INTO `Perusahaan`(`idperusahaan`, `namap`, `alamatp`, `telpp`,"
                    + "`webp`, `emailp`, `thn`, `bank`, 'passp') VALUES ("
                    + "'" + p.getIdAkun() + "',"
                    + "'" + p.getNama() + "',"
                    + "'" + p.getAlamat() + "',"
                    + "'" + p.getNoTelp() + "',"
                    + "'" + p.getWebsite() + "',"
                    + "'" + p.getEmail() + "',"
                    + "'" + p.getThnBerdiri() + "',"
                    + "'" + p.getBank() + "',"
                    + "'" + Arrays.toString(p.getPassword()) + "')";
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
                p = new Perusahaan(rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6), 0,
                rs.getString(8), rs.getString(9).toCharArray());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
    
    public void updatePerusahaan(Perusahaan p) {
        try {
            String query = "update Perusahaan set namap ='"
                    + p.getNama() + "', alamatp= '"
                    + p.getAlamat() + "', telpp= '"
                    + p.getNoTelp() + "', webp= '"
                    + p.getWebsite() + "', emailp= '"
                    + p.getEmail() + "', thn= '"
                    + p.getThnBerdiri() + "', bank= '"
                    + p.getBank() +
                    "' where idPerusahaan = "
                    + p.getIdAkun() + "' AND passp = "
                    + String.valueOf(p.getPassword());
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updatePassPer(Perusahaan p){
        try{
            String query = "update Perusahaan set passp = "
                    + String.valueOf(p.getPassword()) + "' where idPerusahaan = "
                    + p.getIdAkun();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updatePassPelamar(Pelamar p){
        try{
            String query = "update Pelamar set pass = "
                    + String.valueOf(p.getPassword()) + "' where idPelamar = "
                    + p.getIdAkun();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deletePerusahaan(Perusahaan p){
        try {
            String query = "delete from Perusahaan where idPerusahaan= "
                    + p.getIdAkun() + "' AND pass = "
                    + String.valueOf(p.getPassword());
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
    
    public void savePelamar(Pelamar p){
        try {
            String query = "INSERT INTO `Pelamar`(`idpelamar`, `nama`, `alamat`, `telp`,"
                    + "`tgllahir`, `email`, `web`, `pass`,) VALUES ("
                    + "'" + p.getIdAkun() + "',"
                    + "'" + p.getNama() + "',"
                    + "'" + p.getAlamat() + "',"
                    + "'" + p.getNoTelp() + "',"
                    + "'" + p.getTglLahir() + "',"
                    + "'" + p.getEmail() + "',"
                    + "'" + p.getWebsite() + "',"
                    + "'" + Arrays.toString(p.getPassword()) + "')";
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

    public Pelamar getPelamar(String idPelamar){
        Pelamar p = null;
        try {
            String query = "SELECT * FROM `Pelamar` WHERE `idpelamar` = " + idPelamar;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Pelamar(rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                rs.getString(8).toCharArray());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
    
    public void updatePelamar(Pelamar p) {
        try {
            String query = "update pelamar set nama ='"
                    + p.getNama() + "', alamat= '"
                    + p.getAlamat() + "', telp= '"
                    + p.getNoTelp() + "', tgl= '"
                    + p.getTglLahir() + "', email= '"
                    + p.getEmail() + "', web= '"
                    + p.getWebsite() +
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
