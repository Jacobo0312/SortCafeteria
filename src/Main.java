import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

public class Main {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        

        int n = Integer.parseInt(br.readLine());
        String line;

        String message = "";
        for (int i = 0; i < n; i++) {
            line = br.readLine();

            message += sort(line) + "\n";

        }
        bw.write(message);
        bw.flush();
        bw.close();
        br.close();

    }

    public static String sort(String line) {
        ArrayList<Integer> counters = new ArrayList<Integer>();
        String[] input = line.split(" ");
        double[] numbers = new double[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Double.parseDouble(input[i]);
        }

        bubbleSort(numbers, counters);
        // System.out.println(Arrays.toString(numbers));
        // System.out.println(counters.toString());

        double prom = 0;

        for (int counter : counters) {
            prom += counter;
        }
        prom = prom / counters.size();


        //System.out.println(prom);

        BigDecimal formatNumber = new BigDecimal(prom);
        formatNumber = formatNumber.setScale(2, RoundingMode.DOWN);

        BigDecimal oneDecimal = new BigDecimal(formatNumber.doubleValue());
        oneDecimal = oneDecimal.setScale(1, RoundingMode.HALF_UP);

        String message;

        if ((formatNumber.doubleValue() * 10) % 1 == 0) {
            message = oneDecimal + "-";
        } else {
            message = formatNumber + "-";

        }

        for (int i = 0; i < numbers.length; i++) {

                message += numbers[i] + " ";
            }
        
        return message;
    }

    public static void bubbleSort(double[] arraySort, ArrayList<Integer> counters) {

        for (int j = 1; j < arraySort.length; j++) {
            int count = 0;
            for (int i = 0; i < arraySort.length - j; i++) {
                if (arraySort[i] > arraySort[i + 1]) {
                    double temp = arraySort[i];
                    arraySort[i] = arraySort[i + 1];
                    arraySort[i + 1] = temp;
                    count++;
                }

            }

            counters.add(count);
        }

    }

}