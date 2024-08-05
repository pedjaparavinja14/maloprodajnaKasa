/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Racun;
import domain.StavkaRacuna;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class PronadjiStavke extends AbstractSO{

    private StavkaRacuna stavka;
    private List<StavkaRacuna> listaStavki = new ArrayList<>();
   

    public PronadjiStavke(StavkaRacuna sr) throws Exception {
        this.stavka = sr;
    }
    
    
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof StavkaRacuna)) {
            throw new Exception("Object is not valid!");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.searchWithInnerJoin((DomainObject) object);

        
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof StavkaRacuna) {
                listaStavki.add((StavkaRacuna) domainObject);
            }
        }  
        if (listaStavki.isEmpty()) {
           throw new Exception("Lista stavki je prazna");
        }
    }
    
    public List<StavkaRacuna> getListaStavki() {
        return listaStavki;
    }
    
}
