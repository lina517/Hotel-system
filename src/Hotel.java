 import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class Hotel {
	    private List<Reservation> reservations;
	    private List<Room> rooms;
	    private int availableRooms;

	    public Hotel() {
	        this.reservations = new ArrayList<>();
	        this.rooms = new ArrayList<>();
	        // Initialiser le nombre de chambres disponibles avec le nombre total de chambres
	        this.availableRooms = rooms.size();
	    }

	    public Integer bookRoom(date dateDebut, date dateFin, String Typeroom) {
	        for (Room room : rooms) {
	            if (!room.isReserved()) {
	                room.book(dateDebut, dateFin);
	                availableRooms--;
	                return room.getIDchambre();
	            }
	        }
	        return null; // Retourne null si aucune chambre n'est disponible
	    }

	    public void releaseRoom(int IDchambre) {
	        for (Room room : rooms) {
	            if (room.getIDchambre() == IDchambre && room.isReserved()) {
	                room.release();
	                availableRooms++;
	                break;
	            }
	        }
	    }
	}
	
       
