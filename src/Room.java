import java.util.Scanner;

public class Room {
    private int IDchambre;
    private String Typeroom;
    private date dateDebut;
    private date dateFin;
    private boolean occupe;

    public Room(int IDchambre, String type, date dateDebut, date dateFin) {
        this.IDchambre = IDchambre;
        this.Typeroom = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getIDchambre() {
        return IDchambre;
    }

    public String getTyperoom() {
        return Typeroom;
    }

    public date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public date getDateFin() {
        return dateFin;
    }

    public void setDateFin(date dateFin) {
        this.dateFin = dateFin;
    }
    public boolean isOccupe() {
        return occupe;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    } 
    public void release() {
        this.dateDebut = null;
        this.dateFin = null;
    }

    public boolean isReserved() {
        return (dateDebut != null && dateFin != null);
    }

    public void book(date dateDebut, date dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
