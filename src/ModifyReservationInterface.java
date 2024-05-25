import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ModifyReservationInterface extends JFrame {
    private JTextField reservationIDField;
    private JTextField newStartDateField;
    private JTextField newEndDateField;

    public ModifyReservationInterface() {
        setTitle("Modifier une réservation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(720, 430);
        setLocationRelativeTo(null); // Centrer la fenêtre

         
        JPanel mainPanel = new JPanel(new GridBagLayout()) {
             
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Charger l'image de fond
                    BufferedImage img = ImageIO.read(new File("C:\\Users\\HP\\Desktop\\modifier.jpg"));
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

        JLabel newStartDateLabel = new JLabel("Nouvelle date de début :");
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(newStartDateLabel, gbc);

        newStartDateField = new JTextField();
        newStartDateField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(newStartDateField, gbc);

        JLabel newEndDateLabel = new JLabel("Nouvelle date de fin :");
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(newEndDateLabel, gbc);

        newEndDateField = new JTextField();
        newEndDateField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(newEndDateField, gbc);

        JButton modifyButton = new JButton("Modifier");
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer les informations saisies par l'utilisateur
                int reservationID = Integer.parseInt(reservationIDField.getText());
                String newStartDate = newStartDateField.getText();
                String newEndDate = newEndDateField.getText();

                 
                modifyReservation(reservationID, newStartDate, newEndDate);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(modifyButton, gbc);

        // Ajouter le JPanel principal à la fenêtre
        add(mainPanel);
    }

    // Méthode pour modifier la réservation
    private void modifyReservation(int reservationID, String newStartDate, String newEndDate) {
         
        JOptionPane.showMessageDialog(this, "La réservation a été modifiée avec succès.", "Modification Réussie", JOptionPane.INFORMATION_MESSAGE);
        
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ModifyReservationInterface modifyInterface = new ModifyReservationInterface();
                modifyInterface.setVisible(true);
            }
        });
    }
}
