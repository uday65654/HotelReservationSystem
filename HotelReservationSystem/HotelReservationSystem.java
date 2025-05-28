import java.util.*;

class Room {
    int number;
    String type;
    boolean isBooked;

    Room(int number, String type) {
        this.number = number;
        this.type = type;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();

        // Initializing rooms
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Suite"));

        OUTER:
        while (true) {
            System.out.println("\n1. View Rooms\n2. Book Room\n3. View Bookings\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Available Rooms:");
                    for (Room room : rooms) {
                        if (!room.isBooked) {
                            System.out.println("Room " + room.number + " - " + room.type);
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Enter room number to book: ");
                    int roomNo = sc.nextInt();
                    boolean booked = false;
                    for (Room room : rooms) {
                        if (room.number == roomNo && !room.isBooked) {
                            room.isBooked = true;
                            booked = true;
                            System.out.println("Room " + roomNo + " booked successfully!");
                            break;
                        }
                    }   if (!booked) {
                        System.out.println("Room not available.");
                    }
                }
                case 3 -> {
                    System.out.println("Booked Rooms:");
                    for (Room room : rooms) {
                        if (room.isBooked) {
                            System.out.println("Room " + room.number + " - " + room.type);
                        }
                    }
                }
                default -> {
                    break OUTER;
                }
            }
        }
    }
}
