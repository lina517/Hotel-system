import java.util.ArrayList;
import java.util.HashMap;

public class hash {
	HashMap<String,HashMap<String, ArrayList<Room>>> Type = new HashMap<>();// cle double single ---
	HashMap<String,ArrayList<Room> >statutsingle = new HashMap<>();// cle string  modification , annulation, rservation
	
	//declaration de ArrayList modification---------------------------------------------------------------------
	
	    ArrayList<Room> ModificationSingle = new ArrayList<>();
	{
	ModificationSingle.add(new Room(1,"Single"));
	ModificationSingle.add(new Room(2,"Single"));
	ModificationSingle.add(new Room(3,"Single"));
	ModificationSingle.add(new Room(4,"Single"));
	ModificationSingle.add(new Room(5,"Single"));
	ModificationSingle.add(new Room(6,"Single"));
	ModificationSingle.add(new Room(7,"Single"));
	ModificationSingle.add(new Room(8,"Single"));
	ModificationSingle.add(new Room(9,"Single"));
	ModificationSingle.add(new Room(10,"Single"));
	statutsingle.put("modification",ModificationSingle);
	Type.put("Single",statutsingle);
}
	//declaration de ArrayList Reservation-----------------------------------------------------------------------
 
		ArrayList<Room> ReservationSingle = new ArrayList<>();
	{
	ReservationSingle.add(new Room(1,"Single"));
	ReservationSingle.add(new Room(2,"Single"));
	ReservationSingle.add(new Room(3,"Single"));
	ReservationSingle.add(new Room(4,"Single"));
	ReservationSingle.add(new Room(5,"Single"));
	ReservationSingle.add(new Room(6,"Single"));
	ReservationSingle.add(new Room(7,"Single"));
	ReservationSingle.add(new Room(8,"Single"));
	ReservationSingle.add(new Room(9,"Single"));
	ReservationSingle.add(new Room(10,"Single"));
	Type.put("Single",statutsingle);
	}
	//declaration de ArrayList Annulation-----------------------------------------------------------------------
		
		ArrayList<Room> AnnulationSingle = new ArrayList<>();{
    AnnulationSingle.add(new Room(1,"Single"));
	AnnulationSingle.add(new Room(2,"Single")); 
	AnnulationSingle.add(new Room(3,"Single"));
	AnnulationSingle.add(new Room(4,"Single")); 
	AnnulationSingle.add(new Room(5,"Single"));
	AnnulationSingle.add(new Room(6,"Single"));
	AnnulationSingle.add(new Room(7,"Single"));
	AnnulationSingle.add(new Room(8,"Single"));
	AnnulationSingle.add(new Room(9,"Single"));
	AnnulationSingle.add(new Room(10,"Single"));
	statutsingle.put("Annulation",AnnulationSingle);
	Type.put("Single",statutsingle);
		}
		
}
