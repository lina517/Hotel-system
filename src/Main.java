import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionListener;

public class Main {
    private static JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Créer une instance de l'interface de connexion (signin)
                SigninInterface signinInterface = new SigninInterface();
                signinInterface.setVisible(true);
            }
        });
    }

    // Classe de l'interface de connexion (signin)
    static class SigninInterface extends JFrame {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JTextField emailField;

        public SigninInterface() {
            setTitle("Signin");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(720, 430);
            setLocationRelativeTo(null); // Centrer la fenêtre

            // Créer un JPanel comme conteneur principal
            JPanel mainPanel = new JPanel() {
                // Surcharge de la méthode paintComponent pour dessiner l'image de fond
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    try {
                        // Charger l'image de fond
                        BufferedImage img = ImageIO.read(new File("C:\\Users\\HP\\Desktop\\Light Blue.jpg"));
                        // Dessiner l'image sur le panneau
                        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            mainPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 10, 10, 10); // Espacement entre les composants

            // Ajouter les composants sur le panneau
            JLabel usernameLabel = new JLabel("Username:");
            gbc.gridx = 0;
            gbc.gridy = 0;
            mainPanel.add(usernameLabel, gbc);

            usernameField = new JTextField();
            usernameField.setPreferredSize(new Dimension(200, 30)); // Taille préférée pour le champ de texte
            gbc.gridx = 1;
            gbc.gridy = 0;
            mainPanel.add(usernameField, gbc);

            JLabel passwordLabel = new JLabel("Password:");
            gbc.gridx = 0;
            gbc.gridy = 1;
            mainPanel.add(passwordLabel, gbc);

            passwordField = new JPasswordField();
            passwordField.setPreferredSize(new Dimension(200, 30)); // Taille préférée pour le champ de texte
            gbc.gridx = 1;
            gbc.gridy = 1;
            mainPanel.add(passwordField, gbc);

            JLabel emailLabel = new JLabel("Email:");
            gbc.gridx = 0;
            gbc.gridy = 2;
            mainPanel.add(emailLabel, gbc);

            emailField = new JTextField();
            emailField.setPreferredSize(new Dimension(200, 30)); // Taille préférée pour le champ de texte
            gbc.gridx = 1;
            gbc.gridy = 2;
            mainPanel.add(emailField, gbc);

            JButton signinButton = new JButton("Signin");
            signinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    signin();
                }
            });
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            mainPanel.add(signinButton, gbc);

            // Ajouter le JPanel principal à la fenêtre
            add(mainPanel);
        }

        private void signin() {
            // Logique de connexion ici
            // Ici, vous pouvez implémenter la vérification des informations de connexion
            // et la logique pour afficher la fenêtre principale si la connexion réussit.
            openMainFrame();
            dispose(); // Ferme la fenêtre de connexion après la connexion réussie
        }

        private void openMainFrame() {
            frame = new JFrame("Hotel Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(720, 430);
            frame.setLocationRelativeTo(null); // Centrer la fenêtre
                    
            // Créer un JPanel pour les boutons
            JPanel buttonPanel = new JPanel(new GridBagLayout()) {
                // Surcharge de la méthode paintComponent pour dessiner l'image de fond
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    try {
                        // Charger l'image de fond
                        BufferedImage img = ImageIO.read(new File("C:\\Users\\HP\\Desktop\\reserve.jpg"));
                        // Dessiner l'image sur le panneau
                        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            // Créer et configurer les boutons
            JButton addReservationButton = new JButton("Ajouter une réservation");
            JButton modifyReservationButton = new JButton("Modifier une réservation");
            JButton cancelReservationButton = new JButton("Annuler une réservation");
            
            JButton exitButton = new JButton("Quitter");

            // Ajouter un écouteur d'événements pour le bouton "Ajouter une réservation"
            addReservationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Créer et afficher la fenêtre de réservation
                    ReservationInterface reservationInterface = new ReservationInterface();
                    reservationInterface.setVisible(true);
                }
            });
            modifyReservationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Créer et afficher la fenêtre de modification des réservations
                    ModifyReservationInterface modifyReservationInterface = new ModifyReservationInterface();
                    modifyReservationInterface.setVisible(true);
                }
            });
            // Ajustement de la taille des boutons
            Dimension buttonSize = new Dimension(200, 30);
            addReservationButton.setPreferredSize(buttonSize);
            modifyReservationButton.setPreferredSize(buttonSize);
            cancelReservationButton.setPreferredSize(buttonSize);
            
            exitButton.setPreferredSize(buttonSize);

            // Ajouter les boutons au JPanel
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            buttonPanel.add(addReservationButton, gbc);
            gbc.gridy++;
            buttonPanel.add(modifyReservationButton, gbc);
            gbc.gridy++;
            buttonPanel.add(cancelReservationButton, gbc);
            gbc.gridy++;
            
            buttonPanel.add(exitButton, gbc);

            // Ajouter le bouton de retour au JPanel des boutons
            JButton returnButton = new JButton("Retour");
            returnButton.setPreferredSize(buttonSize); // Ajustement de la taille du bouton

            // Ajouter un écouteur d'événements pour le bouton de retour
            returnButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Afficher à nouveau la fenêtre de connexion (signin)
                    SigninInterface signinInterface = new SigninInterface();
                    signinInterface.setVisible(true);
                    frame.dispose(); // Fermer la fenêtre actuelle
                }
            });

            // Ajouter le bouton de retour au JPanel des boutons
            gbc.gridy++;
            buttonPanel.add(returnButton, gbc);

            // Ajouter le JPanel des boutons à la fenêtre
            frame.add(buttonPanel, BorderLayout.CENTER);

            // Afficher la fenêtre
            frame.setVisible(true);
        }

    }
}
