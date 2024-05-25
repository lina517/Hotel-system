public class Reservation {
     
	private int IDchambre;
    private HotelRooms type;
    private boolean existe;
    private Client IDclient;
    private date dateDebut;
    private date dateFin;
    public int reservationCounter;

    public Reservation(int reservationCounter,int IDchambre, Client IDclient, date dateDebut, date dateFin) {
        this.IDchambre = IDchambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.IDchambre = IDchambre;
        this.IDclient = IDclient;
        this.reservationCounter= reservationCounter;
        
    }
    
     

	public void book(date dateDebut, date dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
	public int getIDchambre() {
        return IDchambre;
    }

    public void setIDchambre(int IDchambre) {
        this.IDchambre = IDchambre;
    }
    
    public void setdateFin(date dateFin) {
        this.dateFin = dateFin;
    }
    
    public void setdateDebut(date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public HotelRooms getType() {
        return type;
    }
    
    public date getdateDebut() {
        return this.dateDebut;
    }
    
    public int getChambre() {
        return this.IDchambre;
    }

    public void setType(HotelRooms type) {
        this.type = type;
    }
    public void setclient(Client client) {
	this.IDclient = client;
}

   public Client hetclient() {
	   return IDclient;
   }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

	public Room getRoom() {
		// TODO Auto-generated method stub
		return null;
	}



	public Integer getReservationCounter() {
        return reservationCounter; // Retourne la valeur actuelle du compteur de réservation
    }
	public void setReservationCounter(int ReservationCounter) {
		this.reservationCounter = ReservationCounter;
	}

}
