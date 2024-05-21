import java.util.ArrayList;
import java.util.HashMap;

class Hotel {
    
	private HotelRooms Rooms = new HotelRooms();
	
	public Integer BookRoom (date dateDebut, date dateFin,String Typeroom) {
		 
		HashMap<String,HashMap<Integer,Room> > statut = Rooms.TypeRoom.get(Typeroom);
		HashMap<Integer,Room> disponible = statut.get("Disponible");
		Room roomdispo;	
		for( Room entry : disponible.values()) {
		    roomdispo=entry;
			break;
		}
		if (roomdispo.isReserved() == false) {
		 roomdispo.book(dateDebut, dateFin);

		return  roomdispo.getIDchambre();
		disponible.remove(IDchambre);
		// correction de syntaxe de remove /// ajouter la chambre dans le hashmap reservation
		 // modification de chambre changer la date debut ou fin ou les deux 
		// l'annulation de chambre -- supprimer la chmabre from hash annulation o ndiroha f ash disponible
	}
		return null;
	}
    public void releaseRoom(int IDchambre) {
            Room room = Rooms.get(IDchambre - 1); // Index commence à 0, donc IDchambre - 1
            if (room != null && room.getdateDebut() != null && room.getdateFin() != null && room.isReserved()){
                room.release();
            
        }  }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        // Example usage
       
       
