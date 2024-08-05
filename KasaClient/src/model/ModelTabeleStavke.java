/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.StavkaRacuna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Djapac
 */
public class ModelTabeleStavke extends AbstractTableModel{

    List<StavkaRacuna> lista;
    private String[] kolone;
    
    public ModelTabeleStavke(){
        lista = new ArrayList<>();
        kolone = new String[]{"Artikal", "Cena", "Količina"};
    }
    
    public ModelTabeleStavke(List <StavkaRacuna> lista) {
        this.lista = lista;
        kolone = new String[]{"Artikal", "Cena", "Količina"};
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
        StavkaRacuna stavka = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return stavka.getArtikal();
            case 1: return stavka.getCena();
            case 2: return stavka.getKolicina();
            default: return "N/A!";
        }
        
    }
    
    public void updateTable(List<StavkaRacuna> lista) {
        this.lista=lista;
        fireTableDataChanged();
    }

    public void refresh() {
        fireTableDataChanged();
    }

    public StavkaRacuna getStavkaRacuna(int red) {
        return lista.get(red);
    }
    
    public List<StavkaRacuna> getLista() {
        return lista;
    }

    public void popuniStavku(StavkaRacuna stavka) {
        lista.add(stavka);
        fireTableDataChanged();
        
    }
    
}
