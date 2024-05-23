public class Reservation {
    private int IDchambre;
    private HotelRooms type;
    private boolean existe;
    private date dateDebut;
    private date dateFin;

    public Reservation(int IDchambre, String Nom, HotelRooms type, boolean existe, date dateDebut, date dateFin) {
        this.IDchambre = IDchambre;
        this.Nom = Nom;
        this.type = type;
        this.existe = existe;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getIDchambre() {
        return IDchambre;
    }

    public void setIDchambre(int IDchambre) {
        this.IDchambre = IDchambre;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public HotelRooms getType() {
        return type;
    }

    public void setType(HotelRooms type) {
        this.type = type;
    }

   

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public date getdateDebut() {
        return dateDebut;
    }

    public void setdateDebut(date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public date getdateFin() {
        return dateFin;
    }

    public void setdateFin(date dateFin) {
        this.dateFin = dateFin;
    }
}
