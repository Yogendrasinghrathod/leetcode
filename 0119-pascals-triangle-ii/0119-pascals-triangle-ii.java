class Solution {
    public List<Integer> getRow(int k) {
        List<Integer> row = new ArrayList<>();
        long value = 1;  // The first value in the row is always 1
        row.add((int)value);

        for (int i = 1; i <= k; i++) {
            // Calculate the next value using the previous value
            value = value * (k - i + 1) / i;
            row.add((int)value);
        }

        return row;
    }
}
