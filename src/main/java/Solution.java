import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] orderedScore = Arrays.copyOf(score, n);
        Arrays.sort(orderedScore);
        Map<Integer, Integer> ranks = new HashMap<>(n);

        for (int i = n - 1; i >= 0; i--) {
            ranks.put(orderedScore[i], n - i);
        }

        String[] relativeRanks = new String[n];

        for (int i = 0; i < n; i++) {
            int rank = ranks.get(score[i]);
            relativeRanks[i] = switch (rank) {
                case 1 -> "Gold Medal";
                case 2 -> "Silver Medal";
                case 3 -> "Bronze Medal";
                default -> String.valueOf(rank);
            };
        }
        return relativeRanks;
    }
}