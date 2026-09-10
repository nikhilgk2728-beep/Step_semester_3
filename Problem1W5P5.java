import java.util.Arrays;

public class Problem1W5P5 {

    static void applyMultipliers(double[] scores,
                                 int captainIndex,
                                 int viceCaptainIndex) {

        scores[captainIndex] = scores[captainIndex] * 2;
        scores[viceCaptainIndex] = scores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {

        double[] scores = {40, 55, 30, 62};

        applyMultipliers(scores, 1, 3);

        System.out.println(Arrays.toString(scores));
    }
}