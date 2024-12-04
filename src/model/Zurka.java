/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author user
 */

  public class Zurka {
      private int id;
    private String naziv;
    private Organizator organizator;
    private TipZurke tip;
    private LocalDate datum;
    private String lokacija;
    private int brojGostiju;
    private double budzet;

    public Zurka(int id, String naziv, Organizator organizator, TipZurke tip, LocalDate datum, String lokacija, int brojGostiju, double budzet) {
        this.id = id;
        this.naziv = naziv;
        this.organizator = organizator;
        this.tip = tip;
        this.datum = datum;
        this.lokacija = lokacija;
        this.brojGostiju = brojGostiju;
        this.budzet = budzet;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Konstruktori
    public Zurka(String naziv, Organizator organizator, TipZurke tip, LocalDate datum, String lokacija, int brojGostiju, double budzet) {
        this.naziv = naziv;
        this.organizator = organizator;
        this.tip = tip;
        this.datum = datum;
        this.lokacija = lokacija;
        this.brojGostiju = brojGostiju;
        this.budzet = budzet;
    }

    // Get i Set metode
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Organizator getOrganizator() {
        return organizator;
    }

    public void setOrganizator(Organizator organizator) {
        this.organizator = organizator;
    }

    public TipZurke getTip() {
        return tip;
    }

    public void setTip(TipZurke tip) {
        this.tip = tip;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public int getBrojGostiju() {
        return brojGostiju;
    }

    public void setBrojGostiju(int brojGostiju) {
        this.brojGostiju = brojGostiju;
    }

    public double getBudzet() {
        return budzet;
    }

    public void setBudzet(double budzet) {
        this.budzet = budzet;
    }

    // equals metoda
   @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Zurka zurka = (Zurka) obj;

        if (brojGostiju != zurka.brojGostiju) return false;
        if (Double.compare(zurka.budzet, budzet) != 0) return false;
        if (!naziv.equals(zurka.naziv)) return false;
        if (!organizator.equals(zurka.organizator)) return false;
        if (tip != zurka.tip) return false;
        if (!datum.equals(zurka.datum)) return false;
        return lokacija.equals(zurka.lokacija);
    }

    // toString metoda
    @Override
    public String toString() {
        return "Zurka{" +
                "naziv='" + naziv + '\'' +
                ", organizator=" + organizator +
                ", tip=" + tip +
                ", datum='" + datum + '\'' +
                ", lokacija='" + lokacija + '\'' +
                ", brojGostiju=" + brojGostiju +
                ", budzet=" + budzet +
                '}';
    }
}
  
