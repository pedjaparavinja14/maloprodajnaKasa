/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.text.DateFormatter;


/**
 *
 * @author Djapac
 */
public class Racun extends DomainObject implements Serializable{
    
    private long racunID;
    private String brojRacuna;
    private LocalDate datum;
    private StatusRacuna statusRacuna;
    private double poreskaStopa;
    private Kasir zaposleni;
    private List<StavkaRacuna> listaStavki;
    private String izvestaj;

    public Racun() {
    }

    public Racun(String brojRacuna, LocalDate datum, StatusRacuna statusRacuna, double poreskaStopa, Kasir zaposleni, List<StavkaRacuna> listaStavki) {
        this.brojRacuna = brojRacuna;
        this.datum = datum;
        this.statusRacuna = statusRacuna;
        this.poreskaStopa = poreskaStopa;
        this.zaposleni = zaposleni;
        this.listaStavki = listaStavki;
    }

    public Racun(String brojRacuna, LocalDate datum, StatusRacuna statusRacuna, double poreskaStopa, Kasir zaposleni) {
        this.brojRacuna = brojRacuna;
        this.datum = datum;
        this.statusRacuna = statusRacuna;
        this.poreskaStopa = poreskaStopa;
        this.zaposleni = zaposleni;
    }
    
    

    @Override
    public String toString() {
        return "Racun{" + "racunID=" + racunID + ", brojRacuna=" + brojRacuna + ", datum=" + datum + ", statusRacuna=" + statusRacuna + ", poreskaStopa=" + poreskaStopa + ", zaposleni=" + zaposleni + ", listaStavki=" + listaStavki + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Racun other = (Racun) obj;
        if (this.racunID != other.racunID) {
            return false;
        }
        if (Double.doubleToLongBits(this.poreskaStopa) != Double.doubleToLongBits(other.poreskaStopa)) {
            return false;
        }
        if (!Objects.equals(this.brojRacuna, other.brojRacuna)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (this.statusRacuna != other.statusRacuna) {
            return false;
        }
        if (!Objects.equals(this.zaposleni, other.zaposleni)) {
            return false;
        }
        return Objects.equals(this.listaStavki, other.listaStavki);
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
        return "racun";
    }

    @Override
    public void setAutoIncrementPrimaryKey(long aLong) {
        setRacunID(aLong);
    }

    public long getRacunID() {
        return racunID;
    }

    public void setRacunID(long racunID) {
        this.racunID = racunID;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    
    public double getPoreskaStopa() {
        return poreskaStopa;
    }

    public void setPoreskaStopa(double poreskaStopa) {
        this.poreskaStopa = poreskaStopa;
    }

    public Kasir getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Kasir zaposleni) {
        this.zaposleni = zaposleni;
    }

    public List<StavkaRacuna> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRacuna> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public String getParamsForSelect1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public StatusRacuna getStatusRacuna() {
        return statusRacuna;
    }

    public void setStatusRacuna(StatusRacuna statusRacuna) {
        this.statusRacuna = statusRacuna;
    }

    @Override
    public String getColumnsForInsert() {
        return "brojRacuna,datum,statusRacuna,poreskaStopa,kasirID";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof Racun) {
            try {
                Racun r = (Racun) domainObject;
                statement.setString(1, r.getBrojRacuna());
                statement.setDate(2, java.sql.Date.valueOf(r.getDatum()));
                statement.setString(3, r.getStatusRacuna().toString());
                statement.setDouble(4, r.getPoreskaStopa());
                statement.setLong(5, r.getZaposleni().getKasirID());
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Ocekivan objekat tipa Rezervacija.");
        }
    }

    @Override
    public String getParamsForInsert() {
        return "?,?,?,?,?";
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws Exception {
        List<DomainObject> lista = new ArrayList<>();
        
        while (rs.next()) {
            Racun r = new Racun();
            r.setRacunID(rs.getLong("racunID"));
            r.setBrojRacuna(rs.getString("brojRacuna"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate datum = LocalDate.parse(rs.getString("datum"), formatter); 
            r.setDatum(datum);
            
            String statusRacuna = rs.getString("statusRacuna");
            StatusRacuna statusR = StatusRacuna.valueOf(statusRacuna);
            r.setStatusRacuna(statusR);
            
           r.setPoreskaStopa(rs.getDouble("poreskaStopa"));
           
           
           Kasir zaposleni = new Kasir();
           zaposleni.setKasirID(rs.getLong("k.kasirID"));
           zaposleni.setKorisnickoIme(rs.getString("k.korisnickoIme"));
           zaposleni.setLozinka(rs.getString("k.lozinka"));
           zaposleni.setIme(rs.getString("k.ime"));
           zaposleni.setPrezime(rs.getString("k.prezime"));
           
            
            
       
           
            r.setZaposleni(zaposleni);
            
            
            lista.add(r);   
        }
        return lista;
    }

    @Override
    public String getReqForSearch() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForUpdate() {
        return "brojRacuna=?,datum=?,statusRacuna=?,poreskaStopa=?,kasirID=? WHERE brojRacuna LIKE ?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof Racun) {
            try {
                Racun r = (Racun) domainObject;
                statement.setString(1, r.getBrojRacuna());
                statement.setDate(2, java.sql.Date.valueOf(r.getDatum()));
                statement.setString(3, r.getStatusRacuna().toString());
                statement.setDouble(4, r.getPoreskaStopa());
                statement.setLong(5, r.getZaposleni().getKasirID());
                statement.setString(6, r.getBrojRacuna());
                
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Ocekivan objekat tipa Račun.");
        }
    }

    @Override
    public String getInnerJoin1() {
        return "kasir k ON r.kasirID=k.kasirID";
    }

    @Override
    public String getTableName2() {
        return "racun r";
    }

    @Override
    public String getParamsForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getIzvestaj() {
        return izvestaj;
    }

    public void setIzvestaj(String izvestaj) {
        this.izvestaj = izvestaj;
    }
    
    
    
    
    
    
    
}
