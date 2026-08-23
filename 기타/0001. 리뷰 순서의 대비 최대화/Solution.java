public class Solution {
    public int maxReviewInsight(int[] scores, int[][] conflicts, int k) {
        int[] conflictMask = new int[scores.length];

        for (int[] conflict : conflicts) {
            int first = conflict[0];
            int second = conflict[1];

            conflictMask[first] |= 1 << second;
            conflictMask[second] |= 1 << first;
        }

        return dfs(scores, conflictMask, k, 0, 0, 0, 0);
    }

    private int dfs(
            int[] scores,
            int[] conflictMask,
            int k,
            int index,
            int selectedCount,
            int insightSum,
            int selectedMask
    ) {
        if (selectedCount == k) {
            return insightSum;
        }

        if (selectedCount + (scores.length - index) < k) {
            return -1;
        }

        int best = dfs(
                scores,
                conflictMask,
                k,
                index + 1,
                selectedCount,
                insightSum,
                selectedMask
        );

        if ((conflictMask[index] & selectedMask) == 0) {
            best = Math.max(
                    best,
                    dfs(
                            scores,
                            conflictMask,
                            k,
                            index + 1,
                            selectedCount + 1,
                            insightSum + scores[index],
                            selectedMask | (1 << index)
                    )
            );
        }

        return best;
    }
}
