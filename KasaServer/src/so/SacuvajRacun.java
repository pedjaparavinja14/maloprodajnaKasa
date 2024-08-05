/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Racun;
import domain.StavkaRacuna;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class SacuvajRacun extends AbstractSO{

    public SacuvajRacun() throws Exception {
        super();
    }

    
    
    @Override
    protected void validate(Object object) throws Exception {
        
        if (!(object instanceof Racun)) {
            throw new Exception("Object is not valid");
        }
        Racun rac = (Racun) object;
        
        List<DomainObject> lista = databaseBroker.getAllWithInnerJoin(rac);
        
        for(DomainObject domainObject : lista){
            if(domainObject instanceof Racun){
                 Racun baza = (Racun) domainObject;
                 
                 if(rac.getBrojRacuna().equals(baza.getBrojRacuna())){
                     throw new Exception("Račun sa ovim brojem računa već postoji u bazi!");
                 }
            }
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.add((Racun) object);
        
        Racun racun = (Racun) object;
        for (StavkaRacuna stavka : racun.getListaStavki()){
            stavka.setRacun(racun);
            databaseBroker.add(stavka);
        }
    }
    
}
