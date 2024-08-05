/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Racun;
import domain.StatusRacuna;
import domain.StavkaRacuna;

/**
 *
 * @author Djapac
 */
public class IzmeniRacun extends AbstractSO{

    Racun racun;
    
    
    public IzmeniRacun() throws Exception {
        super();
    }

    public IzmeniRacun(Racun racunZaIzmenu) throws Exception{
        this.racun = racunZaIzmenu;
    }

    
    
    
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Racun)) {
            throw new Exception("Object is not valid");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        
        databaseBroker.update((Racun) object);
        
        Racun r = (Racun) object;
        for (StavkaRacuna stavka : r.getListaStavki()){
            
            if(stavka.getStatusRacuna().equals(StatusRacuna.BRISANJE)){
                stavka.setRacun(r);
                databaseBroker.delete(stavka);
                
            }else if(stavka.getStatusRacuna().equals(StatusRacuna.IZMENJEN)){
                
            stavka.setRacun(r);
            databaseBroker.update(stavka);
                
            }
            
            
        }
        
        
    }
    
}
