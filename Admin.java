import java.util.HashMap;
import java.util.Map;

public class Admin {

    private Map<Integer, Room> rooms;
    private int reservationCounter;

    public Admin() {
        this.rooms = new HashMap<>();
        this.reservationCounter = 0;
    }

    // Ajouter une chambre à l'hôtel
    public void addRoom(int roomNumber, Room room) {
        if (rooms.containsKey(roomNumber)) {
            throw new IllegalArgumentException("La chambre existe déjà.");
        }
        rooms.put(roomNumber, room);
    }

    // Réserver une chambre
    public void makeReservation(int IDchambre, Client client, String startDate, String endDate) {
        Room room = rooms.get(IDchambre);
        if (room == null || room.isOccupied()) {
            throw new IllegalArgumentException("La chambre n'est pas disponible.");
        }

        reservationCounter++;
        Reservation reservation = new Reservation(reservationCounter, IDchambre, client, startDate, endDate);
        room.reserve();
        room.setReservation(reservation);
    }

    // Annuler une réservation
    public void cancelReservation(int reservationId) {
        for (Room room : rooms.values()) {
            Reservation reservation = room.getReservation();
            if (reservation != null && reservation.getId() == reservationId) {
                room.cancelReservation();
                return;
            }
        }
        throw new IllegalArgumentException("Réservation introuvable.");
    }

    // Obtenir toutes les réservations
    public Map<Integer, Reservation> getAllReservations() {
        Map<Integer, Reservation> reservations = new HashMap<>();
        for (Room room : rooms.values()) {
            Reservation reservation = room.getReservation();
            if (reservation != null) {
                reservations.put(reservation.getId(), reservation);
            }
        }
        return reservations;
    }

    // Obtenir toutes les chambres
    public Map<Integer, Room> getAllRooms() {
        return rooms;
    }

    // Obtenir les informations sur une chambre spécifique
    public Room getRoomInfo(int IDchambre) {
        return rooms.get(IDchambre);
    }

    // Modifier les informations sur une chambre spécifique
    public void updateRoomInfo(int IDchambre, Room newRoomInfo) {
        if (!rooms.containsKey(IDchambre)) {
            throw new IllegalArgumentException("La chambre n'existe pas.");
        }
        rooms.put(IDchambre, newRoomInfo);
    }

    // Supprimer une chambre de l'hôtel
    public void deleteRoom(int IDchambre) {
        if (!rooms.containsKey(IDchambre)) {
            throw new IllegalArgumentException("La chambre n'existe pas.");
        }
        rooms.remove(IDchambre);
    }

    // Méthode pour supprimer une chambre
    public void removeRoom(int roomNumber) {
        if (!rooms.containsKey(roomNumber)) {
            throw new IllegalArgumentException("La chambre n'existe pas.");
        }
        rooms.remove(roomNumber);
        // Si vous aviez une variable availableRooms, vous pouvez la décrémenter ici.
    }
}
