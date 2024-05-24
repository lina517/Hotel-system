import java.util.Scanner;

public class Room {
    private int IDchambre;
    private String Typeroom;
    private date dateDebut;
    private date dateFin;
    private boolean occupe;
    private String Room;

    public Room(int IDchambre, String type, date dateDebut, date dateFin) {
        this.IDchambre = IDchambre;
        this.Typeroom = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
 
        public Room(int IDchambre) {
            this.IDchambre = IDchambre;
            this.occupe = false;
        }

        public boolean isOccupe() {
            return occupe;
        }
        public boolean getisOccupe() {
        	return isOccupe();
        }

        public void reserver() {
            occupe = true;
        }

        public void liberer() {
            occupe = false;
        }
    
    public int getIDchambre() {
        return IDchambre;
    }

    public String getTyperoom() {
        return Typeroom;
    }

    
    public boolean setOccupe(boolean occupe) {
        this.occupe = occupe;
        return occupe;}
    
    public boolean getoccupe() {
        return occupe;
    }


    public void book(date dateDebut, date dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
 
}
