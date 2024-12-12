package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDConnection {
    private Connection connect;
    private static final String url = "jdbc:mysql://localhost:3306/gestion-employe"; // Assurez-vous que la base de données "gestion-employe" existe
    private static final String user = "root"; // Utilisateur par défaut pour MySQL sous XAMPP
    private static final String password = ""; // Mot de passe par défaut sous XAMPP est vide

    public BDConnection() {
        try {
            // Charger le pilote MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Ouvrir la connexion
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Connection was established successfully!");
        } catch (Exception e) {
            e.printStackTrace(); // Affiche les détails de l'erreur
            System.err.println("Couldn't establish the connection: " + e.getMessage());
        }
    }

    public Connection getConnect() {
        return connect;
    }
}
