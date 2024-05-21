 import java.util.ArrayList;
import java.util.List;

public class ClientDatabase {
    private List<Client> clients;

    public ClientDatabase() {
        clients = new ArrayList<>();
    }

    // Ajouter un client à la base de données
    public void addClient(Client client) {
        clients.add(client);
    }

    // Authentifier un client en vérifiant son nom d'utilisateur et son mot de passe
    public Client authenticate(String username, String password) {
        for (Client client : clients) {
            if (client.getUsername().equals(username) && client.getPassword().equals(password)) {
                return client;
            }
        }
        return null; // Retourne null si l'authentification échoue
    }
}
 
