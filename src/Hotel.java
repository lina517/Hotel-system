import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private Map<Integer, Reservation> reservations;
    private Map<Integer, Room> rooms;
    private int availableRooms;

    public Hotel() {
        this.reservations = new HashMap<>();
        this.rooms = new HashMap<>();
        this.availableRooms = 0; // Initialiser à zéro, les chambres seront ajoutées plus tard
    }

    // Méthode pour ajouter une chambre
    public void addRoom(int roomNumber, Room room) {
        if (rooms.containsKey(roomNumber)) {
            throw new IllegalArgumentException("La chambre existe déjà.");
        }
        rooms.put(roomNumber, room);
        availableRooms++; // Augmenter le nombre de chambres disponibles
    }

    // Méthode pour supprimer une chambre
    public void removeRoom(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room == null) {
            throw new IllegalArgumentException("La chambre n'existe pas.");
        }
        if (room.isOccupe()) {
            throw new IllegalStateException("Impossible de supprimer une chambre réservée.");
        }
        rooms.remove(roomNumber);
        availableRooms--; // Diminuer le nombre de chambres disponibles
    }

    // Méthode pour réserver une chambre
    public Integer bookRoom(date dateDebut, date dateFin, String Typeroom) {
        for (Room room : rooms.values()) {
            if (!room.isOccupe()) {
                room.book(dateDebut, dateFin);
                availableRooms--;
                return room.getIDchambre();
            }
        }
        return null; // Retourne null si aucune chambre n'est disponible
    }

    public void release(int IDreservation) {
        Reservation reservation = reservations.get(IDreservation);
        if (reservation != null) {
            // Récupérer la chambre associée à cette réservation
            Room room = reservation.getRoom();
            if (room != null && room.isOccupe()) {
                // Libérer la chambre en mettant à jour son statut
                room.liberer();
                // Supprimer la réservation de la liste des réservations
                reservations.remove(IDreservation);
                // Mettre à jour le nombre de chambres disponibles
                availableRooms++;
                System.out.println("Réservation libérée avec succès.");
            } else {
                System.out.println("La chambre associée à cette réservation n'est pas occupée.");
            }
        } else {
            System.out.println("Réservation introuvable.");
        }
    }
}
