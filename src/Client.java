import java.util.Scanner;

public class Client {
	private String username;
    private String password;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    

    // Getters et Setters pour le nom d'utilisateur et le mot de passe
    public class Cliient {
        private String username;
        private String password;

        public Cliient(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getters et Setters pour le nom d'utilisateur et le mot de passe
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
    }
    public static void main(String[] args) {
        // Créer la base de données des Clients
        ClientDatabase clientDB = new ClientDatabase();

        // Ajouter des Clients à la base de données
        clientDB.addClient(new Client("Lina", "password1"));
        clientDB.addClient(new Client("Meriem", "password2"));
        clientDB.addClient(new Client("Safa", "password3"));
        clientDB.addClient(new Client("Mohammed", "password4"));
        clientDB.addClient(new Client("Linda", "password5"));
        clientDB.addClient(new Client("Marya", "password6"));
        clientDB.addClient(new Client("Houda", "password7"));
        clientDB.addClient(new Client("malak", "password8"));
        clientDB.addClient(new Client("soumia", "password9"));
        clientDB.addClient(new Client("Meriem", "password10"));
        clientDB.addClient(new Client("alice123", "password11"));
        clientDB.addClient(new Client("bobsmith", "password12"));
        clientDB.addClient(new Client("carol_89", "password13"));
        clientDB.addClient(new Client("david_jones", "password14"));
        clientDB.addClient(new Client("emily34", "password15"));
        clientDB.addClient(new Client("franklin", "password16"));
        
        // Créer une instance de Client
        Client client = new Client(null, null);

        // Demander la connexion d'un compte
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre nom d'utilisateur : ");
        String username = scanner.nextLine();
        System.out.println("Entrez votre mot de passe : ");
        String password = scanner.nextLine();

        // Authentifier le compte
        client.authenticateClient(clientDB, username, password);
    
    // Méthode pour authentifier un client en utilisant la base de données des clients
    public void authenticateClient(ClientDatabase clientDB, String username, String password) {
        Client client = clientDB.authenticate(username, password);
        if (client != null) {
            System.out.println("Authentification réussie pour " + client.getUsername());
        } else {
            System.out.println("Authentification échouée. Nom d'utilisateur ou mot de passe incorrect.");
        }
    
    public Object getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	public Object getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
//============================================================================================================================
	//part reservation 
       public static void CHECKIN (){
        // Demander la date de début de la réservation
    	System.out.println("Donner votre information");
	    System.out.println("Le Type de chambre :");
	    String Type = scanner.nextInt();
        System.out.println("Date de début (jj mm aaaa) :");
        int jourDebut = scanner.nextInt();
        int moisDebut = scanner.nextInt();
        int anneeDebut = scanner.nextInt();

        // Demander la date de fin de la réservation
        System.out.println("Date de fin (jj mm aaaa) :");
        int jourFin = scanner.nextInt();
        int moisFin = scanner.nextInt();
        int anneeFin = scanner.nextInt();
        // appel de method enregistrer 
     // appel de method annuler la reservation
     // appel de method modifier la reservation 
// engistrer la reservation 
// annuler la reservation 
// modifier la reservation 
//
}
    }
    }
    }