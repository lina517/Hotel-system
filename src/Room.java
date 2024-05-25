import java.util.Scanner;

public class Room {
    private int IDchambre;
    private String Typeroom;
    private boolean isOccuped;
    private String Room;

    public Room(int IDchambre, String type, date dateDebut, date dateFin) {
        this.IDchambre = IDchambre;
        this.Typeroom = type;
        
    }
 
        public Room(int IDchambre) {
            this.IDchambre = IDchambre;
            this.isOccuped = false;
        }

        public boolean isOccuped() {
            return isOccuped;
        }
        public boolean getisOccuped() {
        	return isOccuped();
        }

        public void reserver() {
            isOccuped = true;
        }

        public void liberer() {
            isOccuped = false;
        }
    
    public int getIDchambre() {
        return IDchambre;
    }

    public String getTyperoom() {
        return Typeroom;
    }

    
    public boolean setisOccuped(boolean isOccuped) {
        this.isOccuped = isOccuped;
        return isOccuped;}
    
    public boolean getisOcuuped() {
        return isOccuped;
    }

	public void book(date dateDebut, date dateFin) {
		// TODO Auto-generated method stub
		
	}

	public boolean isOccuped(date newdateDebut, date newdateFin) {
		// TODO Auto-generated method stub
		return false;
	}
 
}
