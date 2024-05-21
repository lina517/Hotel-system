public class date {

    private int jourDebut;
    private int moisDebut;
    private int anneeDebut;

    public date(int jourDebut, int moisDebut, int anneeDebut) {
        this.jourDebut = jourDebut;
        this.moisDebut = moisDebut;
        this.anneeDebut = anneeDebut;
    }

    public boolean estDisponible(int jour, int mois, int annee) {
        // Calculer la date de fin de la réservation
        int jourFin = jourDebut;
        int moisFin = moisDebut;
        int anneeFin = anneeDebut;

        // Gérer le passage au mois suivant
        while (jourFin > joursDansMois(moisFin, anneeFin)) {
            jourFin -= joursDansMois(moisFin, anneeFin);
            moisFin++;
            if (moisFin > 12) {
                moisFin = 1;
                anneeFin++;
            }
        }

        // Vérifier si la date donnée est comprise dans la période de réservation
        return annee >= anneeDebut && annee <= anneeFin &&
                mois >= moisDebut && mois <= moisFin &&
                jour >= jourDebut && jour <= jourFin;
    }

    // Méthode pour obtenir le nombre de jours dans un mois donné
    private int joursDansMois(int mois, int annee) {
        if (mois == 2) {
            return estAnneeBissextile(annee) ? 29 : 28;
        } else if (mois == 4 || mois == 6 || mois == 9 || mois == 11) {
            return 30;
        } else {
            return 31;
        }
    }
    private String formatTime(long timeInMillis) {
        long seconds = timeInMillis / 1000;
          long minutes = seconds / 60;
          long hours = minutes / 60;
          long days = hours / 24;
          long months = days / 30; // Estimation simple : 30 jours par mois
          return String.format("%d months, %d days, %d hours, %d minutes", months, days % 30, hours % 24, minutes % 60);
      }

    // Méthode pour vérifier si une année est bissextile
    private boolean estAnneeBissextile(int annee) {
        return (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0);
    }

}

