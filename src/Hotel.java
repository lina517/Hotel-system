 import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private Map<Integer, Reservation> reservations;
    private Map<Integer, Room> rooms;
    private int availableRooms;
	private int reservationCounter;

    public Hotel() {
        this.reservations = new HashMap<>();
        this.rooms = new HashMap<>();
        this.availableRooms = 0;
    }

    public void addRoom(int IDchambre, Room room) {
        if (rooms.containsKey(IDchambre)) {
            throw new IllegalArgumentException("La chambre existe déjà.");
        }
        rooms.put(IDchambre, room);
        availableRooms++;
    }

    public void removeRoom(int IDchambre) {
        Room room = rooms.get(IDchambre);
        if (room == null) {
            throw new IllegalArgumentException("La chambre n'existe pas.");
        }
        if (room.isOccuped()) {
            throw new IllegalStateException("Impossible de supprimer une chambre occupée.");
        }
        rooms.remove(IDchambre);
        availableRooms--;
    }
    public Integer bookRoom(date dateDebut, date dateFin, String type) {
        for (Room room : rooms.values()) {
            if (!room.isOccuped() && room.getTyperoom().equals(type)) {
                room.reserver();
                availableRooms--;
                Reservation reservation = new Reservation(generateReservationID(), room.getIDchambre(), null, dateDebut, dateFin);
                reservations.put(reservation.getReservationCounter(), reservation);
                return reservation.getReservationCounter();
            }
        }
        return null;
    }
    public void modifyRoom(int IDchambre, Room newRoom) {
        Room room = rooms.get(IDchambre);
        if (room != null) {
            if (!room.isOccuped()) {
                rooms.put(IDchambre, newRoom);
                System.out.println("Chambre modifiée avec succès.");
            } else {
                System.out.println("Impossible de modifier une chambre occupée.");
            }
        } else {
            System.out.println("Chambre introuvable.");
        }
    }
    public Integer makeReservation(int roomID, date startDate, date endDate) {
        Room room = rooms.get(roomID);
        if (room != null && !room.isOccuped()) {
            room.reserver();
            int reservationID = generateReservationID();
            Reservation reservation = new Reservation(reservationID, roomID, null, startDate, endDate);
            reservations.put(reservationID, reservation);
            System.out.println("Nouvelle réservation effectuée avec succès. ID de réservation : " + reservationID);
            return reservationID;
        } else {
            System.out.println("Impossible de réserver la chambre : chambre occupée ou introuvable.");
            return null;
        }
    }
    private int generateReservationID() {
        // Incrémenter le compteur d'identifiants de réservation
        return ++reservationCounter;
    }
     

    public void release(int reservationID) {
        Reservation reservation = reservations.get(reservationID);
        if (reservation != null) {
            Room room = rooms.get(reservation.getIDchambre());
            if (room != null && room.isOccuped()) {
                room.liberer();
                reservations.remove(reservationID);
                availableRooms++;
                System.out.println("Réservation libérée avec succès.");
            } else {
                System.out.println("La chambre associée à cette réservation n'est pas occupée.");
            }
        } else {
            System.out.println("Réservation introuvable.");
        }
    }

    public void annulerReservation(int idReservation) {
        Reservation reservation = reservations.get(idReservation);
        if (reservation == null) {
            throw new IllegalArgumentException("Réservation introuvable.");
        }
        date now = new date();
        if (now.estApres(reservation.getdateDebut())) {
            throw new IllegalStateException("Impossible d'annuler une réservation en cours ou passée.");
        }
        Room room = rooms.get(reservation.getChambre());
        room.liberer();
        reservations.remove(idReservation);
    }

    public void modifyReservation(int reservationID, date newdateDebut, date newdateFin) {
        Reservation reservation = reservations.get(reservationID);
        if (reservation != null) {
            try {
                if (!areValidReservationDates(newdateDebut, newdateFin)) {
                    throw new IllegalArgumentException("Dates de réservation invalides.");
                }
                
                Room room = rooms.get(reservation.getIDchambre());
                if (room == null) {
                    throw new IllegalArgumentException("Chambre associée introuvable.");
                }

                // Vérifier si la chambre est occupée pendant la période spécifiée
                if (room.isOccuped(newdateDebut, newdateFin)) {
                    throw new IllegalStateException("La chambre est occupée pendant cette période.");
                }

                // Modification de la réservation
                reservation.setdateDebut(newdateDebut);
                reservation.setdateFin(newdateFin);
                System.out.println("Réservation modifiée avec succès.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        } else {
            System.out.println("Réservation introuvable.");
        }
    }



    private boolean areValidReservationDates(date newdateDebut, date newdateFin) {
        date now = new date();
        return !now.estAvant(newdateDebut) && !now.estAvant(newdateFin) && !newdateFin.estAvant(newdateDebut);
    }
}
