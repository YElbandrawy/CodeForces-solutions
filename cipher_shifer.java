import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cipher_shifer {
    public static void main(String[] args) {
        String originalMessage = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Integer t = Integer.parseInt(br.readLine()); // number of testcases
            for (int i = 0; i < t; i++) {
                Integer n = Integer.parseInt(br.readLine()); // meassage lenght
                String s = br.readLine(); // the encrypted message
                int pivot = 0;
                for (int j = 1; j < n; j++) {
                    if (s.charAt(j) == s.charAt(pivot)) {
                        originalMessage += s.charAt(pivot);
                        if (j < n) {
                            pivot = j + 1;
                            j = pivot;
                        }
                    }
                }
                System.out.println(originalMessage);
                originalMessage = "";

            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}