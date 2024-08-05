/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import java.sql.SQLException;
import repository.db.DatabaseBroker;
import repository.db.DatabaseConnection;

/**
 *
 * @author Djapac
 */
public abstract class AbstractSO {
    
    protected DatabaseBroker databaseBroker;
    
    public AbstractSO() throws Exception {
        databaseBroker = new DatabaseBroker(DatabaseConnection.getInstance().pop());
    }
    
    public void execute(Object object) throws Exception {
        try {
            validate(object);
            executeOperation(object);
            commit();
        } catch (Exception ex) {
            rollback();
            throw ex;
        }
    }

    protected abstract void validate(Object object) throws Exception;
   

    protected abstract void executeOperation(Object object) throws Exception;
    
    private void commit() throws SQLException {
        databaseBroker.getConnection().commit();
    }

    private void rollback() throws SQLException {
        databaseBroker.getConnection().rollback();
    }
}
