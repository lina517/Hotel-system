import java.util.HashMap;
import java.util.Map;

/*public class HotelRooms {
	public HashMap<String,HashMap<String,HashMap<Integer,Room>>> TypeRoom = new HashMap<>();
	
	public HotelRooms (){
	 
	HashMap<String,HashMap<Integer,Room> >statutsingle = new HashMap<>();// cle string  modification , annulation, rservation
	
	//declaration de ArrayList modification poue single========================================================================================
	    HashMap<Integer,Room> ModificationSingle = new HashMap<>();
	 
	ModificationSingle.put(4,new Room(4,"Single", null, null));
	 
	
	statutsingle.put("modification",ModificationSingle);
	 
//==================================================================================================================================
	 HashMap<Integer,Room> DisponibleSingle = new HashMap<>();
		
		DisponibleSingle.put(1,new Room(1,"Single",null,null));
		DisponibleSingle.put(2,new Room(2,"Single",null,null));
		DisponibleSingle.put(3,new Room(3,"Single",null,null));
		statutsingle.put("Disponible",DisponibleSingle);
		
	//declaration de ArrayList Reservation==========================================================================================
  
		HashMap<Integer,Room> ReservationSingle = new HashMap<>();

	
	
	ReservationSingle.put(5,new Room(5,"Single",null,null));
	ReservationSingle.put(6,new Room(6,"Single",null,null));
	 
	 
	statutsingle.put("Reservation",ReservationSingle);
	 
	
	//declaration de ArrayList Annulation=============================================================================================
		
	HashMap<Integer,Room> AnnulationSingle = new HashMap<>();
    AnnulationSingle.put(7,new Room(1,"Single",null,null));
	AnnulationSingle.put(8,new Room(2,"Single",null,null)); 
	AnnulationSingle.put(9,new Room(3,"Single",null,null));
	 
	 
	
	statutsingle.put("Annulation",AnnulationSingle);
	this.TypeRoom.put("Single",statutsingle);
		
		
		
//declaration de ArrayList modification================================================================================================
	HashMap<String,HashMap<Integer,Room> >statutdouble = new HashMap<>();
	

      HashMap<Integer,Room> Modificationdouble = new HashMap<>();
    
    Modificationdouble.put(1,new Room(1,"double", null, null));
    Modificationdouble.put(2,new Room(2,"double", null, null));
    Modificationdouble.put(3,new Room(3,"double", null, null));
    
   
    
    statutdouble.put("modification",Modificationdouble);
     
  
    //declaration de ArrayList Reservation==============================================================================================
    HashMap<Integer,Room> Reservationdouble = new HashMap<>();
    
    Reservationdouble.put(4,new Room(4,"double", null, null));
    Reservationdouble.put(5,new Room(5,"double",null,null));
    Reservationdouble.put(6,new Room(6,"double", null, null));
     
    
    
    statutdouble.put("Reservation",Reservationdouble);
   
    //declaration de ArrayList Annulation==================================================================================================
      
    HashMap<Integer,Room> Annulationdouble = new HashMap<>();
      Annulationdouble.put(7,new Room(1,"double", null, null));
    Annulationdouble.put(8,new Room(2,"double", null, null)); 
    Annulationdouble.put(9,new Room(3,"double", null, null));
     
    statutdouble.put("Annulation",Annulationdouble);
    this.TypeRoom.put("double",statutdouble);

}
}*/
public class HotelRooms {
    private Map<Integer, Room> Rooms;
    private Map<Integer, Reservation> reservations;
    private int reservationCounter;

    public void Reservation(int reservationCounter,int IDchambre, Client IDclient, date dateDebut, date dateFin) {
        Room chambre = Rooms.get(IDchambre);
        if (chambre == null || chambre.isOccuped()) {
            throw new IllegalArgumentException("Chambre non disponible.");
        }
        reservationCounter++;
        Reservation reservation = new Reservation(reservationCounter, IDchambre, IDclient, dateDebut, dateFin);
        reservations.put(reservationCounter, reservation);
        chambre.reserver();
    }

    public void annulerReservation(int idReservation) {
        Reservation reservation = reservations.get(idReservation);
        if (reservation == null) {
            throw new IllegalArgumentException("Réservation introuvable.");
        }
        date now = new date();
         
        reservation.getRoom().liberer();
        reservations.remove(idReservation);
    }
}
