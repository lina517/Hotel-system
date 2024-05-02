import java.util.Scanner;

public class Room {
    private int IDchambre;
    private String Type;
    private date dateDebut;
    private date dateFin;

    public Room(int IDchambre,String type ) {
        this.IDchambre = IDchambre;
        this.Type = Type;        
    }

	public int getIDchambre() {
        return IDchambre;
    }
    public void release() {
    	this.dateDebut = null;
    	this.dateFin = null;
    }
public static void main(String[] args) {
    
}

	public boolean isReserved() {
		// TODO Auto-generated method stub
		return false;
	}}