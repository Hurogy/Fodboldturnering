/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import fodboldturnering.Klub;
import fodboldturnering.SpillerProfil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Andreas
 */
public class SpillerHandler {

    private DBHandler dbhandler;
    private HoldHandler holdhandler;

    public SpillerHandler() {
        dbhandler = DBHandler.getInstance();
        holdhandler = new HoldHandler();

    }

    public SpillerProfil getSpiller(String navn) {
        SpillerProfil sp = null;
        try {
            String sql = "Select * From SpillerProfil Where fnavn = '" + navn + "' OR Where enavn = '" + navn + "';";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            String cpr = rs.getString("cpr");
            String fnavn = rs.getString("fnavn");
            String enavn = rs.getString("enavn");
            int alder = rs.getInt("alder");
            int mål = rs.getInt("antalMål");
            int kampe = rs.getInt("antalKampe");
            int advarsler = rs.getInt("antalAdvarsler");
            int udvisninger = rs.getInt("antalUdvisninger");
            int selvmål = rs.getInt("antalSelvmål");
            int maksMål = rs.getInt("maksMål");
            int bedømmelse = rs.getInt("bedømmelse");
            int samletPoint = rs.getInt("samletPoint");
            Klub klub = holdhandler.getKlubInfo(rs.getString("klubNavn"));

            sp = new SpillerProfil(cpr, fnavn, enavn, alder, mål, kampe, advarsler, udvisninger, selvmål, maksMål, bedømmelse, samletPoint, klub);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return sp;
    }

    public ArrayList<SpillerProfil> getSpillere(String hold) {
        ArrayList<SpillerProfil> resultat = new ArrayList<>();
        try {
            String sql = "Select * From SpillerProfil Where klubnavn = '" + hold + "';";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String cpr = rs.getString("cpr");
                String fnavn = rs.getString("fnavn");
                String enavn = rs.getString("enavn");
                int alder = rs.getInt("alder");
                int mål = rs.getInt("antalMål");
                int kampe = rs.getInt("antalKampe");
                int advarsler = rs.getInt("antalAdvarsler");
                int udvisninger = rs.getInt("antalUdvisninger");
                int selvmål = rs.getInt("antalSelvmål");
                int maksMål = rs.getInt("maksMål");
                int bedømmelse = rs.getInt("bedømmelse");
                int samletPoint = rs.getInt("samletPoint");
                Klub klub = holdhandler.getKlubInfo(rs.getString(hold));

                SpillerProfil sp = new SpillerProfil(cpr, fnavn, enavn, alder, mål, kampe, advarsler, udvisninger, selvmål, maksMål, bedømmelse, samletPoint, klub);
                resultat.add(sp);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return resultat;
    }
}
