public class Reservation {
    private int numchambre;
    private String Nom;
    private hash type;
    private boolean occupe;
    private boolean existe;
    private date startDate;
    private date endDate;

    public Reservation(int numchambre, String Nom, hash type, boolean occupe, boolean existe, date startDate, date endDate) {
        this.numchambre = numchambre;
        this.Nom = Nom;
        this.type = type;
        this.occupe = occupe;
        this.existe = existe;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getNumchambre() {
        return numchambre;
    }

    public void setNumchambre(int numchambre) {
        this.numchambre = numchambre;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public hash getType() {
        return type;
    }

    public void setType(Hash type) {
        this.type = type;
    }

    public boolean isOccupe() {
        return occupe;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public date getStartDate() {
        return startDate;
    }

    public void setStartDate(date startDate) {
        this.startDate = startDate;
    }

    public date getEndDate() {
        return endDate;
    }

    public void setEndDate(date endDate) {
        this.endDate = endDate;
    }
}
