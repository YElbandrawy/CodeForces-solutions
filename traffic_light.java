import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class traffic_light {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine().trim()); // Number of test cases

            for (int i = 0; i < t; i++) {
                // Read input
                String[] parts = br.readLine().split(" ");
                int n = Integer.parseInt(parts[0]); // Length of the string
                String c = parts[1]; // Target character

                String rawS = br.readLine().trim();

                // Find all 'g' locations
                List<Integer> gLocations = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (rawS.charAt(j) == 'g') {
                        gLocations.add(j);
                    }
                }

                if (gLocations.isEmpty()) {
                    System.out.println(0);
                    continue; // No 'g' found, no waiting time
                }

                // Compute the nearest 'g' for each position
                int minimal = 0;
                int[] nearestG = new int[n]; // Store the next 'g' for each index
                int lastG = -1;

                // Traverse from right to left
                for (int j = n - 1; j >= 0; j--) {
                    if (rawS.charAt(j) == 'g') {
                        lastG = j;
                    }
                    nearestG[j] = lastG;
                }

                // Find max distance for c -> g
                for (int j = 0; j < n; j++) {
                    if (rawS.charAt(j) == c.charAt(0)) {
                        int dist;
                        if (nearestG[j] != -1) {
                            dist = nearestG[j] - j;
                        } else {
                            // Wrap-around case: c is after the last g, loop back
                            dist = (gLocations.get(0) + n - j);
                        }
                        minimal = Math.max(minimal, dist);
                    }
                }

                System.out.println(minimal);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
