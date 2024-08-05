/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Racun;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Djapac
 */
public class ModelTabeleRacuna extends AbstractTableModel{
    
    private List<Racun> lista;
    private String[] kolone;
    
    public ModelTabeleRacuna(){
        lista = new ArrayList<>();
        kolone = new String[]{"Broj računa", "Datum", "Status računa", "Poreska stopa"};
    }
    public ModelTabeleRacuna(List<Racun> lista){
        this.lista = lista;
        kolone = new String[]{"Broj računa", "Datum", "Status računa", "Poreska stopa"};
    }
    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racun r = lista.get(rowIndex);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = r.getDatum().format(dateFormatter);
        
        switch(columnIndex){
            case 0: return r.getBrojRacuna();
            case 1: return formattedDate;
            case 2: return r.getStatusRacuna().toString();
            case 3: return r.getPoreskaStopa();
            default: return "N/A!";
        }
        
    }
    
    public List<Racun> getLista() {
        return lista;
    }
    
    public Racun getRacun(int red){
        return lista.get(red);
    }
    
}
