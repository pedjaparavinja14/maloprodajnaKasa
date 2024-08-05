/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Djapac
 */
public class StavkaRacuna extends DomainObject implements Serializable{
    
    private long redniBroj;
    private String artikal;
    private double cena;
    private int kolicina;
    private Racun racun;
    private StatusRacuna statusRacuna;

    public StavkaRacuna() {
    }

    public StavkaRacuna(String artikal, double cena, int kolicina, Racun racun) {
        this.artikal = artikal;
        this.cena = cena;
        this.kolicina = kolicina;
        this.racun = racun;
    }

    public StavkaRacuna(String artikal, double cena, int kolicina, Racun racun, StatusRacuna statusRacuna) {
        this.artikal = artikal;
        this.cena = cena;
        this.kolicina = kolicina;
        this.racun = racun;
        this.statusRacuna = statusRacuna;
    }
    
    
    
    

    public long getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(long redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getArtikal() {
        return artikal;
    }

    public void setArtikal(String artikal) {
        this.artikal = artikal;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return "StavkaRacuna{" + "redniBroj=" + redniBroj + ", artikal=" + artikal + ", cena=" + cena + ", kolicina=" + kolicina + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaRacuna other = (StavkaRacuna) obj;
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (this.kolicina != other.kolicina) {
            return false;
        }
        return Objects.equals(this.artikal, other.artikal);
    }

    @Override
    public String getColumnsForSelect() {
        return "*";
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "stavkaracuna";
    }

    @Override
    public void setAutoIncrementPrimaryKey(long aLong) {
        setRedniBroj(aLong);
        
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    @Override
    public String getParamsForSelect1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnsForInsert() {
        return "artikal,cena,kolicina,racunID";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof StavkaRacuna) {
            try {
                StavkaRacuna stavka = (StavkaRacuna) domainObject;
                statement.setString(1, stavka.getArtikal());
                statement.setDouble(2, stavka.getCena());
                statement.setInt(3, stavka.getKolicina());
                statement.setLong(4, stavka.getRacun().getRacunID());
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Očekivan objekat nije tipa Stavka računa.");
        }
    }

    @Override
    public String getParamsForInsert() {
        return "?,?,?,?";
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws Exception {
        List<DomainObject> lista = new ArrayList<>();
        
        while (rs.next()) {
            StavkaRacuna sr = new StavkaRacuna();
            sr.setRedniBroj(rs.getLong("redniBroj"));
            sr.setArtikal(rs.getString("artikal"));
            sr.setCena(rs.getDouble("cena"));
            sr.setKolicina(rs.getInt("kolicina"));
            
            
            Racun r = new Racun();
            r.setRacunID(rs.getLong("r.racunID"));
            r.setBrojRacuna(rs.getString("r.brojRacuna"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate datum = LocalDate.parse(rs.getString("r.datum"), formatter); 
            r.setDatum(datum);
            
            String statusRacuna = rs.getString("r.statusRacuna");
            StatusRacuna statusR = StatusRacuna.valueOf(statusRacuna);
            r.setStatusRacuna(statusR);
            
           r.setPoreskaStopa(rs.getDouble("r.poreskaStopa"));
           
           
           Kasir zaposleni = new Kasir();
           zaposleni.setKasirID(rs.getLong("r.kasirID"));
           
           
            
            
       
           
            r.setZaposleni(zaposleni);
            sr.setRacun(r);
            
            lista.add(sr);   
        }
        return lista;
    }

    @Override
    public String getReqForSearch() {
         return "sr.racunID";
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof StavkaRacuna) {
            try {
                StavkaRacuna stavka = (StavkaRacuna) domainObject;
                long brRacuna = stavka.getRacun().getRacunID();
                statement.setString(1, "%" + brRacuna + "%");
               
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
        else{
            throw new IllegalArgumentException("Ocekivan objekat tipa Stavka racuna");
        }
   }

    @Override
    public String getParamsForUpdate() {
        return "artikal=?,cena=?,kolicina=?,racunID=? WHERE racunID=? AND redniBroj=?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof StavkaRacuna) {
            try {
                StavkaRacuna stavka = (StavkaRacuna) domainObject;
                statement.setString(1, stavka.getArtikal());
                statement.setDouble(2, stavka.getCena());
                statement.setInt(3, stavka.getKolicina());
                statement.setLong(4, stavka.getRacun().getRacunID());
                statement.setLong(5, stavka.getRacun().getRacunID());
                statement.setLong(6, stavka.getRedniBroj());
                
                
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Očekivan objekat nije tipa Stavka računa.");
        }
    }

    @Override
    public String getInnerJoin1() {
        return "racun r on sr.racunID = r.racunID";
    }

    @Override
    public String getTableName2() {
        return "stavkaracuna sr";
    }

    public StatusRacuna getStatusRacuna() {
        return statusRacuna;
    }

    public void setStatusRacuna(StatusRacuna statusRacuna) {
        this.statusRacuna = statusRacuna;
    }

    @Override
    public String getParamsForDelete() {
        return "WHERE racunID = ? AND redniBroj = ?";
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof StavkaRacuna) {
            try {
                StavkaRacuna sr = (StavkaRacuna) domainObject;
                statement.setLong(1, sr.getRacun().getRacunID());
                statement.setLong(2, sr.getRedniBroj());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Stavka računa.");
        }
        
    }
    
    
    
   
}
