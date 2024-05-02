import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*public class Hotel {
    private Room[] rooms;

    public Hotel(String hotelName, Room[] rooms) {
        this.rooms = rooms;
    }

    // Afficher les chambres disponibles dans l'hôtel
    public void displayAvailableRooms() {
        System.out.println("Chambres disponibles :");
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                System.out.println(room);
            }
        }
    }

    // Enregistrement d'un client dans une chambre
    public void checkIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro de la chambre : ");
        int roomNumber = scanner.nextInt();
        // Trouver la chambre par son numéro
        Room room = findRoom(roomNumber);
        if (room != null) {
            if (!room.isOccupied()) {
                System.out.print("Entrez le nom du client : "); // remove 
                String guestName = scanner.next();
                try {
                    room.checkIn(guestName);
                    System.out.println("Le client " + guestName + " a été enregistré dans la chambre " + roomNumber + ".");
                } catch (Exception e) {
                    System.out.println("Erreur : " + e.getMessage());
                }
            } else {
                System.out.println("Cette chambre est déjà occupée.");
            }
        } else {
            System.out.println("La chambre " + roomNumber + " n'existe pas.");
        }
    }

    // Check-out d'un client d'une chambre
    public void checkOut() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro de la chambre : ");// type 
        int roomNumber = scanner.nextInt();
        // Trouver la chambre par son numéro
        Room room = findRoom(roomNumber);
        if (room != null) {
            if (room.isOccupied()) {
                String guestName = room.getGuestName();
                room.setGuestName("");
                room.setOccupied(false);
                System.out.println("Le client " + guestName + " a quitté la chambre " + roomNumber + ".");
            } else {
                System.out.println("La chambre " + roomNumber + " n'est pas occupée.");
            }
        } else {
            System.out.println("La chambre " + roomNumber + " n'existe pas.");
        }
    }

    // Trouver une chambre par son numéro
    private Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}*/
import java.util.HashMap;
import java.util.Map;

class Hotel {
	ArrayList<Room> rooms = new ArrayList<>();

    public Hotel() {
    	

        // Initialize rooms
      
    	rooms.add(new Room(1,"Single"));
        rooms.add(new Room(2,"Single"));
        rooms.add(new Room(3,"Single"));
        rooms.add(new Room(4,"Single"));  
        rooms.add(new Room(5,"Single"));
        rooms.add(new Room(6,"Single"));
        rooms.add(new Room(7,"Single"));
        rooms.add(new Room(8,"Single"));
        rooms.add(new Room(9,"Single"));
        rooms.add(new Room(10,"Single"));
        rooms.add(new Room(11,"Double"));
        rooms.add(new Room(12,"Double"));
        rooms.add(new Room(13,"Double"));  
        rooms.add(new Room(14,"Double"));
        rooms.add(new Room(15,"Double"));
        rooms.add(new Room(16,"Double"));
        rooms.add(new Room(17,"Double"));
        rooms.add(new Room(18,"Double"));
        rooms.add(new Room(19,"Double"));
        rooms.add(new Room(20,"Double"));
        
        // faire 3 hashmap ( reservation , modification et cancel )
    }

        

    public void releaseRoom(int roomId) {
        Room room = rooms.get(roomId);
        if (room != null && room.isReserved()) {
            room.release();
        }  
    }
 
    // Méthode utilitaire pour formater le temps en millisecondes en une chaîne lisible
    private String formatTime(long timeInMillis) {
      long seconds = timeInMillis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        long months = days / 30; // Estimation simple : 30 jours par mois
        return String.format("%d months, %d days, %d hours, %d minutes", months, days % 30, hours % 24, minutes % 60);
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        // Example usage
       