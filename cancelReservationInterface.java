import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class CancelReservationInterface extends JFrame {
    private JTextField reservationIDField;

    public CancelReservationInterface() {
        setTitle("Annuler une réservation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(720, 430);
        setLocationRelativeTo(null); // Centrer la fenêtre

        JPanel mainPanel = new JPanel(new GridBagLayout()) {
            // Surcharge de la méthode paintComponent pour dessiner l'image de fond
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Charger l'image de fond
                    BufferedImage img = ImageIO.read(new File("C:\\Users\\HP\\Desktop\\delete.jpg"));
                    // Dessiner l'image sur le panneau
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espacement entre les composants

        JLabel reservationIDLabel = new JLabel("ID de réservation:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(reservationIDLabel, gbc);

        reservationIDField = new JTextField();
        reservationIDField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(reservationIDField, gbc);

        JButton cancelButton = new JButton("Annuler");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer l'ID de réservation saisi par l'utilisateur
                int reservationID = Integer.parseInt(reservationIDField.getText());

                // Appeler la méthode pour annuler la réservation
                cancelReservation(reservationID);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(cancelButton, gbc);

        // Ajouter le JPanel principal à la fenêtre
        add(mainPanel);
    }

    // Méthode pour annuler la réservation
    private void cancelReservation(int reservationID) {
        // Supposons que vous ayez une classe Hotel avec une méthode pour annuler la réservation
        // Ici, vous pouvez ajouter la logique pour annuler la réservation avec l'ID donné
        // et libérer automatiquement la chambre réservée
        // Par exemple :
        // hotel.cancelReservation(reservationID);
        // JOptionPane.showMessageDialog(null, "Réservation annulée avec succès.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CancelReservationInterface cancelInterface = new CancelReservationInterface();
                cancelInterface.setVisible(true);
            }
        });
    }
}
