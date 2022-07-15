package com.project;
import java.sql.*;
public class proxy implements vedi,aggiungi{
   public String n;
   public String sc;
   public String[] string;
    static Connection connection = DB.getIstances().getConnection();

    @Override
    public void insert(Utente utente) {
        try {
            String sqlInsert = "INSERT INTO UTENTE VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sqlInsert);
            ps.setInt(1, utente.getID());
            ps.setString(2, utente.getUsername());
            ps.setInt(3, utente.getPunteggio());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException sqlException)
        {
            System.out.println("impossibile inserire utente");
        }
    }
    @Override
   public void Vedi() {
        try {
            String sqlselect = "SELECT NOME,SCORE FROM UTENTE ORDER BY SCORE DESC;";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sqlselect);
            string = new String[5];
            int t = 0;
            while (t < 5 && rs.next()) {
                n = rs.getString("NOME");
                sc = rs.getString("SCORE");
                string[t] = n.toString() + " " + sc.toString();
                t++;

            }
            rs.close();
        } catch (SQLException sqlException) {
            System.out.println("impossibile vedere i record del database");
        }
    }
}