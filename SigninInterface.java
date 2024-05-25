import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class SigninInterface extends JFrame {
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
                    // Ici, vous pouvez dessiner l'image de fond si nécessaire
                }
            };
            mainPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 10, 10, 10); // Espacement entre les composants

            // Ajouter les composants sur le panneau
            // (Code des composants omis pour des raisons de concision)

            // Ajouter le JPanel principal à la fenêtre
            add(mainPanel);
        }
    }
