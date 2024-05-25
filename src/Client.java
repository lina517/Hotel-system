import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private String username;
    private String password;
    private String email;

    public Client(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Méthode pour authentifier un client en utilisant la base de données des clients
    
        // ...

        // Méthode pour authentifier un client en utilisant la base de données des clients
        public void authenticateClient(ClientDatabase clientDB, String username, String password, String email) {
            Client client = clientDB.authenticate(username, password, email);
            if (client != null) {
                System.out.println("Authentification réussie pour " + client.getUsername());
            } else {
                System.out.println("Authentification échouée. Nom d'utilisateur ou mot de passe incorrect.");
            }
        }
    



    // Méthode d'authentification
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

    // Base de données des clients
    private static List<Client> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // Créer la base de données des Clients
            ClientDatabase clientDB = new ClientDatabase();

            // Ajouter des Clients à la base de données
            clientDB.addClient(new Client("lina","1","lina@gmail.com"));
            clientDB.addClient(new Client("Meriem","2","Meriem@gmail.com"));
            clientDB.addClient(new Client("Safa","3","Safa@gmail.com"));
            clientDB.addClient(new Client("Mohammed","4","Mohammed@gmail.com"));
            clientDB.addClient(new Client("Linda","5","Linda@gmail.com"));

            // Créer une instance de Client
            Client client = new Client(null, null, null);

            // Demander la connexion d'un compte
            // Authentifier le compte
            client.authenticateClient(clientDB, "Lina", "password1", "Lina@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

	
