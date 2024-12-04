/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Baza.DBBroker;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Zurka;
import model.Organizator;
import model.TipZurke;


public class Controller {
    
    private static Controller instance;
    
    public static Controller getInstance(){
        
        if(instance==null){
            instance = new Controller();
        }
            return instance;
    }
    
    
    private List<Zurka> listaZurka = new ArrayList<>();
    private List<Organizator> listaOrganizatora = new ArrayList<>();

    DBBroker dbb;
    public Controller() {
        dbb = new DBBroker();
        
//        Organizator micko = new Organizator("micko", "0648617909", 5);
//        
//        Organizator nidza = new Organizator("Nidza", "0649132549", 2);
//      
//         Zurka NovaGodina = new Zurka("proslava nove godine", micko, TipZurke.KUCNA_ZURKA, LocalDate.of(2024, 12, 31), "save Jovanovica 71", 50, 50000);
//         Zurka Rodjendan = new Zurka("Rodjendan", nidza, TipZurke.RODJENDAN, LocalDate.of(2025, 7, 1), "save Jovanovica 71", 20, 30000);
//         Zurka KoktelZurka = new Zurka("Koktel Party", micko, TipZurke.TEMATSKA_ZURKA, LocalDate.of(2025, 7, 18), "save Jovanovica 71", 70, 100000);
//         
//        listaZurka.add(NovaGodina);
//        listaZurka.add(Rodjendan);
//        listaZurka.add(KoktelZurka);
//        listaOrganizatora.add(nidza);
//        listaOrganizatora.add(micko );          
    }

    public List<Zurka> getListaZurka() {
        return listaZurka;
    }

    public void setListaZurka(List<Zurka> listaZurka) {
        this.listaZurka = listaZurka;
    }

    public List<Organizator> getListaOrganizatora() {
        return listaOrganizatora;
    }

    public void setListaOrganizatora(List<Organizator> listaOrganizatora) {
        this.listaOrganizatora = listaOrganizatora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.listaZurka);
        hash = 71 * hash + Objects.hashCode(this.listaOrganizatora);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Controller other = (Controller) obj;
        if (!Objects.equals(this.listaZurka, other.listaZurka)) {
            return false;
        }
        return Objects.equals(this.listaOrganizatora, other.listaOrganizatora);
    }

    @Override
    public String toString() {
        return "Controller{" + "listaZurka=" + listaZurka + ", listaOrganizatora=" + listaOrganizatora + '}';
    }

    public List<Zurka> ucitajZurkeIzBaze(){
        dbb = new DBBroker();
        return dbb.ucitajListuZurka();
    }
    public void dodajZurku(Zurka zurka) {
        listaZurka.add(zurka);
        
    }

    public void izmeniZurku(Zurka selektovanaZurka) {
     
    }
    
    
    
    
}
