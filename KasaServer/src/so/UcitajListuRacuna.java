/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Kasir;
import domain.Racun;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class UcitajListuRacuna extends AbstractSO{

    private List<Racun> listaRacuna = new ArrayList<>();
    private Kasir kasir;
    
    public UcitajListuRacuna() throws Exception {
        super();
    }

    public UcitajListuRacuna(Kasir kasirPrikaz) throws Exception{
        this.kasir = kasirPrikaz;
    }
    
    

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Racun)) {
            throw new Exception("Object is not valid");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.getAllWithInnerJoin((DomainObject) object);

        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Racun) {
                
                if(((Racun) domainObject).getZaposleni().getKasirID() == kasir.getKasirID()){
                
                    listaRacuna.add((Racun) domainObject);
                    
                }
                
                
            }
        }
        if(listaRacuna.isEmpty()){
            throw new Exception("Lista računa je prazna!");
        }
    }
    
    public List<Racun> getListaRacuna() {
        return listaRacuna;
    }
    
}
