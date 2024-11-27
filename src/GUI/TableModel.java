/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Controller.Controller;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Zurka;

/**
 *
 * @author user
 */
public class TableModel extends AbstractTableModel {
private List<Zurka> listaZurka;

    public TableModel(List<Zurka> listaZurka) {
        this.listaZurka = listaZurka;
    }
   

    private Controller kontroler = Controller.getInstance();
    private String kolone[] = {"naziv", "organizator", "tip", "datum", "lokacija","broj Gostiju", "Budzet" };
    @Override
    public int getRowCount() {
      return kontroler.getListaZurka().size();
    }

    @Override
    public int getColumnCount() {
       return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zurka zurka =  listaZurka.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zurka.getNaziv();
           case 1:
                return zurka.getOrganizator();
                case 2:
                return zurka.getTip();
                case 3:
                return zurka.getDatum();
                case 4:
                return zurka.getLokacija();
                case 5:
                return zurka.getBrojGostiju();
                 case 6:
                return zurka.getBudzet();
            default:
               return "Nigga nema tvog polja";
        }
  
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    void osveziPodatke() {
        fireTableDataChanged();
    }
    
    
}
