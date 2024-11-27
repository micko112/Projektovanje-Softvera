/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Organizator {
    private String ime;         // Ime organizatora
private String brojTelefona;     // Kontakt informacije organizatora
private int iskustvo;       // Iskustvo u godinama

    public Organizator() {
    }

    public Organizator(String ime, String brojTelefona, int iskustvo) {
        this.ime = ime;
        this.brojTelefona = brojTelefona;
        this.iskustvo = iskustvo;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public int getIskustvo() {
        return iskustvo;
    }

    public void setIskustvo(int iskustvo) {
        this.iskustvo = iskustvo;
    }

    @Override
    public String toString() {
        return   ime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.ime);
        hash = 59 * hash + Objects.hashCode(this.brojTelefona);
        hash = 59 * hash + this.iskustvo;
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
        final Organizator other = (Organizator) obj;
        return Objects.equals(this.brojTelefona, other.brojTelefona);
    }
    
}
