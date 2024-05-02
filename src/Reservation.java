import java.util.HashMap;
import java.util.Map;



class Reservation {
	 private int numchambre;
	    private String Nom;
	    private HashMap;
	    private boolean occupé;
	    private boolean exist;
    private long startDate;
    private long endDate;

    public Reservation(int roomId, String roomType, long startDate, long endDate) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public long getStartDate() {
        return startDate;
    }

    public long getEndDate() {
        return endDate;
    }
   

	private String formatTime(long endDate2) {
		// TODO Auto-generated method stub
		return null;
	}
}

/*import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Création de la première HashMap
        Map<String, HashMap<String, Integer>> mapDeMaps = new HashMap<>();

        // Création de la deuxième HashMap et ajout à la première HashMap
        HashMap<String, Integer> innerMap1 = new HashMap<>();
        innerMap1.put("A", 1);
        innerMap1.put("B", 2);
        mapDeMaps.put("Première", innerMap1);

        // Création d'une autre deuxième HashMap et ajout à la première HashMap
        HashMap<String, Integer> innerMap2 = new HashMap<>();
        innerMap2.put("C", 3);
        innerMap2.put("D", 4);
        mapDeMaps.put("Deuxième", innerMap2);

        // Accès aux éléments de la deuxième HashMap à partir de la première HashMap
        System.out.println("Valeur associée à 'A' dans la première map: " + mapDeMaps.get("Première").get("A"));
        System.out.println("Valeur associée à 'D' dans la deuxième map: " + mapDeMaps.get("Deuxième").get("D"));
    }*/

    
}