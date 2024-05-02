 import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
// Hotel class represents the hotel and its operations

// Room class represents a hotel room

// HotelManagementSystem class contains the main method to run the program
 /*public class HotelManagementSystem {
    public static void main(String[] args) {
        int n = 50 ; // Number of rooms you want to create
        Room[] rooms = new Room[n]; // creations des users 

        for (int i = 0; i < n; i++) {
            rooms[i] = new Room(i + 1);
        }
        class Room {
            private int number;

            public Room(int number) {
                this.number = number;
            }

            public int getNumber() {
                return number;
            }
        }
       
        // Create a hotel object
        Hotel hotel = new Hotel("Grand Hotel", rooms);
        Scanner Scanner = new Scanner(System.in);
        // Display menu and handle user input .. // date and time 
        while (true) {
            System.out.println("\n--- Hotel Management System by Grand Hotel ---");
            System.out.println("1. Check-in");
            System.out.println("2. Check-out");
            System.out.println("3. View available rooms");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = Scanner.nextInt();
            switch (choice) {
                case 1:
                    hotel.checkIn();
                    break;
                case 2:
                    hotel.checkOut();
                    break;
                case 3:
                    hotel.displayAvailableRooms();
                    break;
                case 4:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
 
 /* ==========Partie deux Lyna  =============================================================================================================================================================
  import java.util.Scanner;
 

//date de départ <date darrivé 
// id room lazam ki y3awd ydemendiha tkoun occupée
// exception date

public class Reservation {
  private static List<Reservation> reservations = new ArrayList<>();// hna dnrio 3 haspmap 

  public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

          while (true) {
            
              System.out.println("1. Ajouter une réservation"); hashmap 1
              System.out.println("2. Modifier une réservation"); hashmap 2
              System.out.println("3. Annuler une réservation");hashmap 3
              System.out.println("4. Afficher toutes les réservations");
              System.out.println("5. Quitter");
          int choice = scanner.nextInt();
          
          switch (choice) {
            case 1:
                addReservation();
                break;
            case 2:
                modifyReservation();
                break;
            case 3:
                cancelReservation();
                break;
            case 4:
                displayReservations();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide");
                }
        }
  }
          private static void addReservation() {
              Scanner scanner = new Scanner(System.in);

              System.out.println("Nom du client : ");
              String name = scanner.nextLine();

              System.out.println("Date d'arrivée (jj/mm/aaaa) : ");
              String arrivalDate = scanner.nextLine();

              System.out.println("Date de départ (jj/mm/aaaa) : ");
              String departureDate = scanner.nextLine();
              System.out.println("Type de chambre : ");
              String roomType = scanner.nextLine();

              Reservation reservation = new Reservation(name, arrivalDate, departureDate, roomType);
              reservations.add(reservation);

              System.out.println("Réservation ajoutée avec succès");
          }
          private static void validateDateFormat(String date) throws IllegalArgumentException {
              String[] parts = date.split("/");
              if (parts.length != 3  parts[0].length() != 2  parts[1].length() != 2  parts[2].length() != 4) {
                  throw new IllegalArgumentException("Format de date invalide. Veuillez saisir la date au format jj/mm/aaaa.");
              }

              int day = Integer.parseInt(parts[0]);
              int month = Integer.parseInt(parts[1]);
              int year = Integer.parseInt(parts[2]);

              if (month < 1  month > 12  day < 1  day > daysInMonth(month, year)  year < 1000  year > 9999) {
                  throw new IllegalArgumentException("Date invalide.");
              }
          }
          Lyna, [4/10/2024 9:07 AM]
private static int daysInMonth(int month, int year) {
              switch (month) {
                  case 4: case 6: case 9: case 11:
                      return 30;
                  case 2:
                      return (year % 4 == 0 && (year % 100 != 0  year % 400 == 0)) ? 29 : 28;
                  default:
                      return 31;
              }
          }


          private static void modifyReservation() {
              Scanner scanner = new Scanner(System.in);
              System.out.println("Numéro de la réservation : ");
              int reservationNumber = scanner.nextInt();
              scanner.nextLine(); // Consommer la nouvelle ligne

              Reservation reservation = reservations.get(reservationNumber - 1);

              System.out.println("Nom du client : ");
              String name = scanner.nextLine();

              System.out.println("Date d'arrivée (jj/mm/aaaa) : ");
              String arrivalDate = scanner.nextLine();
              System.out.println("Date de départ (jj/mm/aaaa) : ");
              String departureDate = scanner.nextLine();

              System.out.println("Type de chambre : ");
              String roomType = scanner.nextLine();

              reservation.setName(name);
              reservation.setArrivalDate(arrivalDate);
              reservation.setDepartureDate(departureDate);
              reservation.setRoomType(roomType);

              System.out.println("Réservation modifiée avec succès");
              }
              private static void cancelReservation() {
                  Scanner scanner = new Scanner(System.in);

                  System.out.println("Numéro de la réservation : ");
                  int reservationNumber = scanner.nextInt();

                  reservations.remove(reservationNumber - 1);

                  System.out.println("Réservation annulée avec succès");
                  }
            
              private static void displayReservations() {
                  for (Reservation reservation : reservations) {
                      System.out.println(reservation); // Utilisation de la méthode toString()
                  }
              }
              private static void validateDateFormat1(String date) throws IllegalArgumentException {
                  String[] parts = date.split("/");
                  if (parts.length != 3  parts[0].length() != 2  parts[1].length() != 2  parts[2].length() != 4) {
                      throw new IllegalArgumentException("Format de date invalide. Veuillez saisir la date au format jj/mm/aaaa.");
                  }

                  int day = Integer.parseInt(parts[0]);
                  int month = Integer.parseInt(parts[1]);
                  int year = Integer.parseInt(parts[2]);

                  if (month < 1  month > 12  day < 1  day > 31  year < 1000 || year > 9999) {
                      throw new IllegalArgumentException("Date invalide.");
                  }
              }

              private String name;
              private String arrivalDate;
              private String departureDate;
              private String roomType;
              
              public Reservation(String name, String arrivalDate, String departureDate, String roomType) {
                  this.name = name;
                  this.arrivalDate = arrivalDate;
                  this.departureDate = departureDate;
                  this.roomType = roomType;
              }

              public String getRoomType() {
                  return roomType;
              }
              public void setRoomType(String roomType) {
                  this.roomType = roomType;
              }
              public String getDepartureDate() {
                  return departureDate;
              }
              public void setDepartureDate(String departureDate) {
                  this.departureDate = departureDate;
              }
                //methode d'accés
              public String getName() {
                  return name;
              }

Lyna, [4/10/2024 9:07 AM]
public void setName(String name) {
                  this.name = name;
              }
              public String getArrivalDate() {
                  return arrivalDate;
              }

              public void setArrivalDate(String arrivalDate) {
                  this.arrivalDate = arrivalDate;
              }
              
              @Override
              public String toString() {
                  return "Nom du client : " + name + "\nDate d'arrivée : " + arrivalDate +
                         "\nDate de départ : " + departureDate + "\nType de chambre : " + roomType + "\n";
              }
}*/
 
 