package tubes;

import java.util.Date;

public class Perusahaan extends Orang{
    	private Lowongan [] daftarLowongan;
	private int thnBerdiri;
	private String jenisUsaha;
	private String namaBank;
	private String password;
	private int nLowongan=0;
	
	public void createLowongan(String nmLowongan, Date deadline){
            daftarLowongan[nLowongan] = new Lowongan(nmLowongan, deadline);
            nLowongan++;
         };
	
	public Perusahaan (String nama, String alamat, String noTelp, String email, String website){
		super(nama, alamat, noTelp, email, website);
	}
	
	public void setThnBerdiri (String thn){
		this.thnBerdiri = thn;
	}
	
	public void setJnsUsaha (String jenisUsaha){
		this.jenisUsaha=jenisUsaha;
	}
	
	public void setBank (String bank){
		this.namaBank=bank;
	}
	
	public void setPassword (String pass){
		this.password=pass;
	}
	
	public int getThnBerdiri(){
		return thnBerdiri;
	}
	
	public String getJnsUsaha(){
		return jenisUsaha;
	}
	
	public String getBank(){
		return namaBank;
	}
	
	public String getPassword(){
		return password ;
	}
	
	public void viewLowongan(){
		int i=0;
		for (daftarLowongan lw: Lowongan.getALL()){
			String Lowongan[]={
				lw.super(getNama()),
				lw.getJnsUsaha(),
				lw.getThnBerdiri(),
			};
			l[i]=Lowongan;
			i++;
			}
		}
	}
	
	public void hapusLowongan (int id){
		if (id>=1)&&(id<=10) {
			Lowongan.remove(Lowongan.merge (l));
		}
	}
	
	public void terimaPelamar (int idLowongan, int idPelamar){
		if (idLowongan<>0){
			return;
		}
		else if (idPelamar<>0){
			return "Tidak Diterima";
		}
		else
	}

	public void cekPassword (String password){
		
	}
}
