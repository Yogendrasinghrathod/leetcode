class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies, (a, b) -> b - a);

        int total = arr.length, removed = 0, sets = 0;
        for (int freq : frequencies) {
            total -= freq;
            sets++;
            if (total <= arr.length / 2) {
                break;
            }
        }

        return sets;
    }
}
