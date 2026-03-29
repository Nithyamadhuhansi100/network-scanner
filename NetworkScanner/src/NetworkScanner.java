
import java.net.InetAddress;
import java.util.Scanner;

    public class NetworkScanner {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("===== Network Scanner Tool =====");

            // Get subnet from user
            System.out.print("Enter subnet (example: 192.168.1): ");
            String subnet = sc.nextLine();

            // Range input
            System.out.print("Enter start IP (1-254): ");
            int start = sc.nextInt();

            System.out.print("Enter end IP (1-254): ");
            int end = sc.nextInt();

            System.out.println("\nScanning network...\n");

            for (int i = start; i <= end; i++) {
                String host = subnet + "." + i;

                try {
                    InetAddress address = InetAddress.getByName(host);

                    // Check if reachable
                    if (address.isReachable(1000)) {
                        System.out.println( host + " is ONLINE");

                        // Optional: get host name
                        System.out.println("   Hostname: " + address.getHostName());
                    } else {
                        System.out.println(  host + " is OFFLINE");
                    }

                } catch (Exception e) {
                    System.out.println("Error scanning " + host);
                }
            }

            System.out.println("\nScan Complete...");
            sc.close();
        }
    }

