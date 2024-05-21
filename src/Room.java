import java.util.Scanner;

public class Room {
    private int IDchambre;
    private String Typeroom;
    private date dateDebut;
    private date dateFin;

    public Room(int IDchambre,String type ) {
        this.IDchambre = IDchambre;
        this.Typeroom = Typeroom;        
    }
    public Room(date datedDebut,date dateFin) {
        this.dateDebut = datedDebut;
        this.dateFin = dateFin;
    }
	public int getIDchambre() {
        return IDchambre;
    }
    public void release() {
    	this.dateDebut = null;
    	this.dateFin = null;
    	
    }
   public boolean isReserved() {
		// dateDut verification de date debut et fin <> null
		return false;
	}
    public void book(date dateDebut, date dateFin) {
    	        this.dateDebut = dateDebut;
    	        this.dateFin = dateFin;
    	        // demande la datedebut et fin from user 
    }
    	 
public static void main(String[] args) {
    
}

	
	public Object getStartdate() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getdateDebut() {
		// TODO Auto-generated method stub
		return null;
	}}

