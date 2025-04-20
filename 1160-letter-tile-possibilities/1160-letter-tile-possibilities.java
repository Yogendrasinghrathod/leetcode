class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        backtrack(tiles, new StringBuilder(), result);
        return result.size();
    }
    
    private void backtrack(String tiles, StringBuilder temp, Set<String> result) {
        if (temp.length() > 0) {
            result.add(temp.toString());
        }
        
        for (int i = 0; i < tiles.length(); i++) {
            if (i > 0 && tiles.charAt(i) == tiles.charAt(i - 1)) continue;
            temp.append(tiles.charAt(i));
            backtrack(tiles.substring(0, i) + tiles.substring(i + 1), temp, result);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
