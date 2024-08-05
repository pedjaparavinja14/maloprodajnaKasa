/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Kasir;
import domain.Racun;
import domain.StavkaRacuna;
import java.util.List;
import so.IzmeniRacun;
import so.PrijaviKasira;
import so.PronadjiStavke;
import so.SacuvajRacun;
import so.UcitajListuRacuna;

/**
 *
 * @author Djapac
 */
public class Controller {

    public Kasir login(Kasir kasir) throws Exception {
        PrijaviKasira loginZaposleni = new PrijaviKasira();
        loginZaposleni.execute(kasir);
        return loginZaposleni.getZaposlenog();
    }

    public void createBill(Racun racun) throws Exception {
        SacuvajRacun sacuvajRacun = new SacuvajRacun();
        sacuvajRacun.execute(racun);
    }

    public Object getAllBills(Kasir kasirPrikaz) throws Exception {
        UcitajListuRacuna ucitajRacune = new UcitajListuRacuna(kasirPrikaz);
        ucitajRacune.execute(new Racun());
        return ucitajRacune.getListaRacuna();
    }

    public List<StavkaRacuna> searchBillItems(StavkaRacuna r) throws Exception {
        PronadjiStavke pronadjiStavke = new PronadjiStavke(r);
        pronadjiStavke.execute(r);
        return pronadjiStavke.getListaStavki();
    }

    public void updateBill(Racun racunZaIzmenu) throws Exception{
        IzmeniRacun izmeniRacun = new IzmeniRacun(racunZaIzmenu);
        izmeniRacun.execute(racunZaIzmenu);
    }
    
}
