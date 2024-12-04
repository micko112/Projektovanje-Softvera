/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Baza;

import java.util.ArrayList;
import java.util.List;
import model.Zurka;
import java.sql.Statement;
import Baza.Konekcija;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TipZurke;
import java.sql.ResultSet;
import java.util.Date;
import model.Organizator;
/**
 *
 * @author user
 */
public class DBBroker {
    
    private List<Zurka> listaZurki= new ArrayList<>();
   
    public  List<Zurka> ucitajListuZurka() {
            
        try {
            String upit = "Select * "
                    + "from zurke z join organizatori o on z.organizatorID = o.id";
        
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int orgID = rs.getInt("o.id");
                String ime = rs.getString("o.ime");
                String brojTelefona = rs.getString("o.brojtelefona");
                int iskustvo = rs.getInt("o.iskustvo");

                int id = rs.getInt("z.id");
                String naziv = rs.getString("z.naziv");
                String tipz = rs.getString("z.tip");
                TipZurke tip = TipZurke.valueOf(tipz);
                LocalDate datum = rs.getDate("z.datum").toLocalDate();
                String lokacija = rs.getString("z.lokacija");
                int brGostiju = rs.getInt("z.brojGostiju");
                int budzet = rs.getInt("z.budzet");
                 Organizator organizator = new  Organizator(orgID, ime, brojTelefona, iskustvo);
              Zurka zurka = new Zurka(id, naziv, organizator, tip, datum, lokacija, brGostiju, budzet);
              listaZurki.add(zurka);
            }

          
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listaZurki;
     
    }
    
    
    
}
