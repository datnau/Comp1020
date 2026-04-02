import java.util.Scanner;

public class PlaylistApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        while (true) {
            System.out.println("\nCommands: add, remove, search, print, total, quit");
            System.out.print("Enter command: ");
            String cmd = scanner.nextLine();

            if (cmd.equals("add")) {
                System.out.print("Title: ");
                String title = scanner.nextLine();

                System.out.print("Rating: ");
                int rating = Integer.parseInt(scanner.nextLine());

                System.out.print("Duration: ");
                int duration = Integer.parseInt(scanner.nextLine());

                playlist.addSong(new Song(title, rating, duration));
            }
            else if (cmd.equals("remove")) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                playlist.removeSong(title);
            }
            else if (cmd.equals("search")) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                Song s = playlist.search(title);
                if (s != null) {
                    System.out.println(s);
                } else {
                    System.out.println("Not found");
                }
            }
            else if (cmd.equals("print")) {
                playlist.printAll();
            }
            else if (cmd.equals("total")) {
                System.out.println("Total duration: " + playlist.getTotalDuration());
            }
            else if (cmd.equals("quit")) {
                break;
            }
        }

        scanner.close();
    }
}