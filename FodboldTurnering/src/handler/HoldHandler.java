/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import fodboldturnering.Division;
import fodboldturnering.Klub;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Andreas
 */
public class HoldHandler {

    private DBHandler dbhandler;

    public HoldHandler() {
        dbhandler = DBHandler.getInstance();
    }

    public Klub getKlubInfo(String klub) {
        Klub resultat = null;
        try {
            String sql = "Select * From Klub Where klubnavn = '" + klub + "';";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String klubNavn = rs.getString("klubNavn");
                String adresse = rs.getString("adresse");
                int sejre = rs.getInt("sejre");
                int uafgjorte = rs.getInt("uafgjorte");
                int tabte = rs.getInt("tabte");
                int pointSum = rs.getInt("pointSum");
                int antalKampe = rs.getInt("antalKampe");
                int sæsonPlacering = rs.getInt("sæsonplacering");
                int antalMål = rs.getInt("antalMål");
                String trænerNavn = rs.getString("trænerNavn");
                Division divisionsnummer = new Division(rs.getInt("divisionsnummer"));

                Klub k1 = new Klub(klubNavn, adresse, sejre, uafgjorte, tabte, pointSum, antalKampe, sæsonPlacering, antalMål, trænerNavn, divisionsnummer);
                resultat = k1;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return resultat;
    }

    public ArrayList<Klub> getDivisionKlubber(int division) {
        ArrayList<Klub> resultat = new ArrayList<>();
        try {
            String sql = "Select * From Klub Where divisionsnummer ='" + division + "';";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String klubNavn = rs.getString("klubNavn");
                String adresse = rs.getString("adresse");
                int sejre = rs.getInt("sejre");
                int uafgjorte = rs.getInt("uafgjorte");
                int tabte = rs.getInt("tabte");
                int pointSum = rs.getInt("pointSum");
                int antalKampe = rs.getInt("antalKampe");
                int sæsonPlacering = rs.getInt("sæsonplacering");
                int antalMål = rs.getInt("antalMål");
                String trænerNavn = rs.getString("trænerNavn");
                Division divisionsnummer = new Division(rs.getInt("divisionsnummer"));

                Klub k1 = new Klub(klubNavn, adresse, sejre, uafgjorte, tabte, pointSum, antalKampe, sæsonPlacering, antalMål, trænerNavn, divisionsnummer);
                resultat.add(k1);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return resultat;
    }

    public ArrayList<Klub> getAlleKlubber() {
        ArrayList<Klub> resultat = new ArrayList<>();
        try {
            String sql = "Select * From Klub;";
            Statement stmt = dbhandler.getStmt();
            if (stmt == null) {
                System.out.println("statement er null");
            }
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String klubNavn = rs.getString("klubNavn");
                String adresse = rs.getString("adresse");
                int sejre = rs.getInt("sejre");
                int uafgjorte = rs.getInt("uafgjorte");
                int tabte = rs.getInt("tabte");
                int pointSum = rs.getInt("pointSum");
                int antalKampe = rs.getInt("antalKampe");
                int sæsonPlacering = rs.getInt("sæsonplacering");
                int antalMål = rs.getInt("antalMål");
                String trænerNavn = rs.getString("trænerNavn");
                Division divisionsnummer = new Division(rs.getInt("divisionsnummer"));

                Klub k1 = new Klub(klubNavn, adresse, sejre, uafgjorte, tabte, pointSum, antalKampe, sæsonPlacering, antalMål, trænerNavn, divisionsnummer);
                resultat.add(k1);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return resultat;
    }

    public void turneringsstillingPoint(ArrayList<Klub> holdliste) {
        for (int j = 2; j < holdliste.size(); j++) {
            Klub tmpHold = holdliste.get(j);
            int i = j - 1;
            while (i > 0 && holdliste.get(i).getPointSum() > tmpHold.getPointSum()) {
                holdliste.set(i + 1, holdliste.get(i));
                i = i - 1;
                holdliste.set(i + 1, tmpHold);
            }
        }
    }
}
