import java.util.ArrayList;
import java.util.List;

public class ClientDatabase {
    private static List<Client> clients;

    public ClientDatabase() {
        clients = new ArrayList<>();
    }

    // Ajouter un client à la base de données
    public void addClient(Client client) {
        clients.add(client);
    }

    // Authentifier un client en vérifiant son nom d'utilisateur, son mot de passe et son e-mail
    public Client authenticate(String username, String password, String email) {
        System.out.println("Authentification avec : Username=" + username + ", Password=" + password + ", Email=" + email);
        
        // Comparaison avec les clients dans la base de données
        for (Client client : clients) {
            // Vérifier l'authentification en ignorant la casse des lettres
            if (client.getUsername().equalsIgnoreCase(username) && client.getPassword().equals(password) && client.getEmail().equalsIgnoreCase(email)) {
                return client;
            }
        }
        return null; // Retourne null si l'authentification échoue
    }
}

