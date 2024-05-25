import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationInterface extends JFrame {
    private JTextField dateDebutField;
    private JTextField dateFinField;
    private JComboBox<String> typeComboBox;
    private int reservationCounter;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ReservationInterface reservationInterface = new ReservationInterface();
                reservationInterface.setVisible(true);
            }
        });
    }

    public ReservationInterface() {
    	 reservationCounter = 0;
        setTitle("Ajouter une réservation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(720, 430);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("C:\\Users\\HP\\Desktop\\ajoute.jpg");
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel dateDebutLabel = new JLabel("Date de début (jj/mm/aaaa):");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(dateDebutLabel, gbc);

        dateDebutField = new JTextField();
        dateDebutField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(dateDebutField, gbc);

        JLabel dateFinLabel = new JLabel("Date de fin (jj/mm/aaaa):");
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(dateFinLabel, gbc);

        dateFinField = new JTextField();
        dateFinField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(dateFinField, gbc);

        JLabel typeLabel = new JLabel("Type de chambre:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(typeLabel, gbc);

        String[] types = {"Simple", "Double"};
        typeComboBox = new JComboBox<>(types);
        typeComboBox.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(typeComboBox, gbc);

        JButton submitButton = new JButton("Valider");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validerReservation();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(submitButton, gbc);

        add(mainPanel);
    }

    

    private void validerReservation() {
        String dateDebutString = dateDebutField.getText();
        String dateFinString = dateFinField.getText();
        String type = (String) typeComboBox.getSelectedItem();

        try {
            // Valider le format de la date
            validateDateFormat(dateDebutString);
            validateDateFormat(dateFinString);

            // Extraire les composants de la date de début
            String[] partsDebut = dateDebutString.split("/");
            int jourDebut = Integer.parseInt(partsDebut[0]);
            int moisDebut = Integer.parseInt(partsDebut[1]);
            int anneeDebut = Integer.parseInt(partsDebut[2]);

            // Extraire les composants de la date de fin
            String[] partsFin = dateFinString.split("/");
            int jourFin = Integer.parseInt(partsFin[0]);
            int moisFin = Integer.parseInt(partsFin[1]);
            int anneeFin = Integer.parseInt(partsFin[2]);

            // Vérifier si la date de début est après la date de fin
            if (anneeDebut > anneeFin || (anneeDebut == anneeFin && (moisDebut > moisFin || (moisDebut == moisFin && jourDebut > jourFin)))) {
                JOptionPane.showMessageDialog(null, "La date de début ne peut pas être après la date de fin.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                reservationCounter++;
                // La réservation est valide, afficher un message de confirmation
                String confirmationMessage = "Réservation validée avec succès !\n" +
                                             "Date de début : " + dateDebutString + "\n" +
                                             "Date de fin : " + dateFinString + "\n" +
                                             "Type de chambre : " + type +
                                             "\nID de réservation : " + reservationCounter;

                JOptionPane.showMessageDialog(null, confirmationMessage, "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                // Ajouter le bouton de retour
                JButton returnButton = new JButton("Retour");
                returnButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Fermer la fenêtre de réservation
                        dispose();
                    }
                });

                // Ajouter le bouton de retour à un conteneur visible
                JPanel returnPanel = new JPanel();
                returnPanel.add(returnButton);

                // Ajouter le conteneur avec le bouton de retour à la fenêtre principale
                add(returnPanel, BorderLayout.SOUTH);

                // Rafraîchir l'affichage
                revalidate();
                repaint();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void validateDateFormat(String date) throws IllegalArgumentException {
        String[] parts = date.split("/");
        if (parts.length != 3 || parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) {
            throw new IllegalArgumentException("Format de date invalide. Veuillez saisir la date au format jj/mm/aaaa.");
        }

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (month < 1 || month > 12 || day < 1 || day > daysInMonth(month, year)) {
            throw new IllegalArgumentException("Date invalide.");
        }
    }

    private static int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

