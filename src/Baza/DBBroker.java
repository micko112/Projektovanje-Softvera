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
import java.sql.PreparedStatement;
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
                double budzet = rs.getDouble("z.budzet");
                 Organizator organizator = new  Organizator(orgID, ime, brojTelefona, iskustvo);
              Zurka zurka = new Zurka(id, naziv, organizator, tip, datum, lokacija, brGostiju, budzet);
              listaZurki.add(zurka);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listaZurki;
     
    }

    public List<Organizator> ucitajOrganizatoreIzBaze() {
          List<Organizator> listaOrg =  new ArrayList<>();
        try {
        
            String upit = "SELECT * FROM organizatori o";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                int id = rs.getInt("o.id");
                String ime = rs.getString("o.ime");
                String brojTel = rs.getString("o.brojTelefona");
                int iskustvo = rs.getInt("o.iskustvo");
                
                Organizator org = new Organizator(id, ime, brojTel, iskustvo);
                listaOrg.add(org);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaOrg;
        
    }

    public void dodajZurku(Zurka zurka) {
     
        try {
            String upit = "INSERT INTO zurke(id,naziv,organizatorID,tip,datum,lokacija,brojGostiju,budzet) Values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
           
            
            ps.setInt(1, zurka.getId());
            ps.setString(2, zurka.getNaziv());
            ps.setInt(3, zurka.getOrganizator().getId());
            ps.setString(4, String.valueOf(zurka.getTip()));
            ps.setDate(5, java.sql.Date.valueOf(zurka.getDatum()));
            ps.setString(6, zurka.getLokacija());
            ps.setInt(7, zurka.getBrojGostiju());
             ps.setDouble(8, zurka.getBudzet());
            
             ps.executeUpdate();
             Konekcija.getInstance().getConnection().commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void izmeniZurku(Zurka selektovanaZurka) {
        try {
            String upit = "Update zurke set naziv = ?, organizatorId = ?, tip =?, datum = ?, lokacija = ?, brojGostiju = ?, budzet = ? "
                    + "where id = ?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
               ps.setInt(8, selektovanaZurka.getId());
            ps.setString(1, selektovanaZurka.getNaziv());
            ps.setInt(2, selektovanaZurka.getOrganizator().getId());
            ps.setString(3, String.valueOf(selektovanaZurka.getTip()));
            ps.setDate(4, java.sql.Date.valueOf(selektovanaZurka.getDatum()));
            ps.setString(5, selektovanaZurka.getLokacija());
            ps.setInt(6, selektovanaZurka.getBrojGostiju());
             ps.setDouble(7, selektovanaZurka.getBudzet());
             ps.executeUpdate();
             Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

   
    
}
