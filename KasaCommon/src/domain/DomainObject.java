/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Djapac
 */
public abstract class DomainObject {
    
    
    public abstract String getColumnsForSelect();
    
    public abstract void setParamsForSelect(PreparedStatement statement, DomainObject domainObject);
    
    public abstract String getTableName();
    
    public abstract void setAutoIncrementPrimaryKey(long aLong);
    
    public abstract String getParamsForSelect1();
    
    public abstract DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject);
    
     public abstract String getColumnsForInsert();
    
    public abstract void setParamsForInsert(PreparedStatement statement, DomainObject domainObject);


    public abstract String getParamsForInsert();

    public abstract List<DomainObject> getParamsForSelect(ResultSet rs) throws Exception;

    public abstract String getReqForSearch();
     
    public abstract void setParamsForSearch(PreparedStatement statement, DomainObject domainObject);

    public abstract String getParamsForUpdate();
 
    public abstract void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject);

    public abstract String getInnerJoin1();
    
    public abstract String getTableName2();
    
     public abstract String getParamsForDelete();
    
    public abstract void setParamsForDelete(PreparedStatement statement, DomainObject domainObject);
    
    
}
