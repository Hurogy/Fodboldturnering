/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fodboldturnering;

/**
 *
 * @author Andreas
 */
public class Klub {
    private String klubNavn;
    private String adresse;
    private String[] hjemmefarver;
    private String[] udefarver;
    private int sejre, uafgjorte, tabte;
    private int pointSum;
    private int antalKampe;
    private int sæsonPlacering;
    private int antalMål;
    private SpillerProfil[] spillere;
    private String trænerNavn;
    private Division divisionsnummer;

    public Klub(String klubNavn) {
        this.klubNavn = klubNavn;
        adresse = "";
        hjemmefarver = new String[3];
        udefarver = new String[3];
        sejre = 0;
        uafgjorte = 0;
        tabte = 0;
        pointSum = 0;
        antalKampe = 0;
        sæsonPlacering = 0;
        antalMål = 0;
        spillere = new SpillerProfil[14];
    }

    public Division getDivisionsnummer() {
        return divisionsnummer;
    }

    public void setDivisionsnummer(Division divisionsnummer) {
        this.divisionsnummer = divisionsnummer;
    }

    public String getKlubNavn() {
        return klubNavn;
    }

    public void setKlubNavn(String klubNavn) {
        this.klubNavn = klubNavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String[] getHjemmefarver() {
        return hjemmefarver;
    }

    public void setHjemmefarver(String[] hjemmefarver) {
        this.hjemmefarver = hjemmefarver;
    }

    public String[] getUdefarver() {
        return udefarver;
    }

    public void setUdefarver(String[] udefarver) {
        this.udefarver = udefarver;
    }

    public int getSejre() {
        return sejre;
    }

    public void setSejre(int sejre) {
        this.sejre = sejre;
    }

    public int getUafgjorte() {
        return uafgjorte;
    }

    public void setUafgjorte(int uafgjorte) {
        this.uafgjorte = uafgjorte;
    }

    public int getTabte() {
        return tabte;
    }

    public void setTabte(int tabte) {
        this.tabte = tabte;
    }
    

    public int getPointSum() {
        return pointSum;
    }

    public void setPointSum(int pointSum) {
        this.pointSum = pointSum;
    }

    public int getAntalKampe() {
        return antalKampe;
    }

    public void setAntalKampe(int antalKampe) {
        this.antalKampe = antalKampe;
    }
    

    public int getSæsonPlacering() {
        return sæsonPlacering;
    }

    public void setSæsonPlacering(int sæsonPlacering) {
        this.sæsonPlacering = sæsonPlacering;
    }

    public int getAntalMål() {
        return antalMål;
    }

    public void setAntalMål(int antalMål) {
        this.antalMål = antalMål;
    }

    public SpillerProfil[] getSpillere() {
        return spillere;
    }

    public void setSpillere(SpillerProfil[] spillere) {
        this.spillere = spillere;
    }

    public String getTrænerNavn() {
        return trænerNavn;
    }

    public void setTrænerNavn(String trænerNavn) {
        this.trænerNavn = trænerNavn;
    }
    
    
}
