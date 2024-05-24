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

    // ======================Méthode pour ajouter une chambre===========================================================
    public void addRoom(int roomNumber, Room room) {
        if (rooms.containsKey(roomNumber)) {
            throw new IllegalArgumentException("La chambre existe déjà.");
        }
        rooms.put(roomNumber, room);
        availableRooms++; // Augmenter le nombre de chambres disponibles
    }

    //==================Méthode pour supprimer une chambre=====================================================================
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

    //=============== réserver une chambre=================================================================================
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
    //==========liberer la chambre========================================================================================
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
    //============================annulation de reservation===========================================================================
    public void annulerReservation(int idReservation) {
        Reservation reservation = reservations.get(idReservation);
        if (reservation == null) {
            throw new IllegalArgumentException("Réservation introuvable.");
        }
        date now = new date();
        //if (now.after(reservation.getdateDebut())) {
          //  throw new IllegalStateException("Impossible d'annuler une réservation en cours ou passée.");
        //}
        Room room1 = rooms.get(reservation.getChambre());
        room1.liberer();
        reservations.remove(idReservation);
    }
    //=====================Modifier la reservation========================================================================================
    public void modifyReservation(int reservationID, date newdateDebut, date newdateFin) {
        Reservation reservation = reservations.get(reservationID);
        if (reservation != null) {
            Room room = reservation.getRoom();
            if (room != null && room.isOccupe()) {
                // Vérifier si les nouvelles dates de réservation sont valides
                if (areValidReservationDates(newdateDebut, newdateFin)) {
                    // Mettre à jour les dates de réservation
                    reservation.setdateDebut(newdateDebut);
                    reservation.setdateFin(newdateFin);
                    System.out.println("Réservation modifiée avec succès.");
                } else {
                    System.out.println("Dates de réservation invalides.");
                }
            } else {
                System.out.println("La chambre associée à cette réservation n'est pas occupée.");
            }
        } else {
            System.out.println("Réservation introuvable.");
        }
    }

	private boolean areValidReservationDates(date newdateDebut, date newdateFin) {
		// TODO Auto-generated method stub
		return false;
	}
    }
