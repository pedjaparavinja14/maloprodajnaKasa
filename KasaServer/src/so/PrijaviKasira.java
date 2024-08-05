/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Kasir;

/**
 *
 * @author Djapac
 */
public class PrijaviKasira extends AbstractSO{

    private Kasir kasir;

    public PrijaviKasira() throws Exception {
        super();
    }
    
    
    
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Kasir)) {
            throw new Exception("Object is not valid");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        DomainObject domainObject=databaseBroker.login((DomainObject)object);
        
        if (domainObject instanceof Kasir) {
            kasir = (Kasir)domainObject;
        }
    }

    public Kasir getZaposlenog() {
        return kasir;
    }
    
}
