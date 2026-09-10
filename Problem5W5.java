import java.util.Arrays;

public class Problem5W5 implements Comparable<Problem5W5> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public Problem5W5(String name,
                      int matchesPlayed,
                      double battingAverage,
                      boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Rule 1: Experienced player
    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    // Rule 2: Less experienced but fit player
    static boolean isDraftable(int matchesPlayed,
                               boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    // Sort by batting average in descending order
    @Override
    public int compareTo(Problem5W5 other) {

        return Double.compare(
            other.battingAverage,
            this.battingAverage
        );
    }

    public String getName() {
        return name;
    }

    static String draftAndRank(Problem5W5[] players) {

        Problem5W5[] draftable =
                new Problem5W5[players.length];

        int count = 0;

        // Find draftable players
        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed)
                    || isDraftable(
                        players[i].matchesPlayed,
                        players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        // Create array containing only draftable players
        Problem5W5[] finalPlayers =
                Arrays.copyOf(draftable, count);

        // Sort using compareTo()
        Arrays.sort(finalPlayers);

        String result = "";

        for (int i = 0; i < finalPlayers.length; i++) {

            result = result
                    + (i + 1)
                    + ". "
                    + finalPlayers[i].getName();

            if (i < finalPlayers.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Problem5W5[] players = {

            new Problem5W5("Virat", 15, 48.0, false),

            new Problem5W5("Rahul", 7, 55.0, false),

            new Problem5W5("Sameer", 3, 60.0, false),

            new Problem5W5("Dev", 12, 20.0, true)
        };

        System.out.println(
            Problem5W5.draftAndRank(players)
        );
    }
}