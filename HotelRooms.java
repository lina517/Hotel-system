import java.util.HashMap;

public class HotelRooms {
	public HashMap<String,HashMap<String,HashMap<Integer,Room>>> TypeRoom = new HashMap<>();
	
	public HotelRooms (){
	 
	HashMap<String,HashMap<Integer,Room> >statutsingle = new HashMap<>();// cle string  modification , annulation, rservation
	
	//declaration de ArrayList modification poue single========================================================================================
	    HashMap<Integer,Room> ModificationSingle = new HashMap<>();
	 
	ModificationSingle.put(4,new Room(4,"Single"));
	 
	 
	statutsingle.put("modification",ModificationSingle);
	 
//==========================================================================
	 HashMap<Integer,Room> DisponibleSingle = new HashMap<>();
		
		DisponibleSingle.put(1,new Room(1,"Single"));
		DisponibleSingle.put(2,new Room(2,"Single"));
		DisponibleSingle.put(3,new Room(3,"Single"));
		statutsingle.put("Disponible",DisponibleSingle);
		
	//declaration de ArrayList Reservation==========================================================================================
  
		HashMap<Integer,Room> ReservationSingle = new HashMap<>();

	
	
	ReservationSingle.put(5,new Room(5,"Single"));
	ReservationSingle.put(6,new Room(6,"Single"));
	 
	 
	statutsingle.put("Reservation",ReservationSingle);
	 
	
	//declaration de ArrayList Annulation=============================================================================================
		
	HashMap<Integer,Room> AnnulationSingle = new HashMap<>();
    AnnulationSingle.put(7,new Room(1,"Single"));
	AnnulationSingle.put(8,new Room(2,"Single")); 
	AnnulationSingle.put(9,new Room(3,"Single"));
	 
	 
	
	statutsingle.put("Annulation",AnnulationSingle);
	this.TypeRoom.put("Single",statutsingle);
		
		
		
//declaration de ArrayList modification================================================================================================
	HashMap<String,HashMap<Integer,Room> >statutdouble = new HashMap<>();
	

      HashMap<Integer,Room> Modificationdouble = new HashMap<>();
    
    Modificationdouble.put(1,new Room(1,"double"));
    Modificationdouble.put(2,new Room(2,"double"));
    Modificationdouble.put(3,new Room(3,"double"));
    
   
    
    statutdouble.put("modification",Modificationdouble);
     
  
    //declaration de ArrayList Reservation==============================================================================================
    HashMap<Integer,Room> Reservationdouble = new HashMap<>();
    
    Reservationdouble.put(4,new Room(4,"double"));
    Reservationdouble.put(5,new Room(5,"double"));
    Reservationdouble.put(6,new Room(6,"double"));
     
    
    
    statutdouble.put("Reservation",Reservationdouble);
   
    
    //declaration de ArrayList Annulation==================================================================================================
      
    HashMap<Integer,Room> Annulationdouble = new HashMap<>();
      Annulationdouble.put(7,new Room(1,"double"));
    Annulationdouble.put(8,new Room(2,"double")); 
    Annulationdouble.put(9,new Room(3,"double"));
     
    statutdouble.put("Annulation",Annulationdouble);
    this.TypeRoom.put("double",statutdouble);


}
}

