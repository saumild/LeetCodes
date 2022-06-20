class Solution {

    private class TrieNode {
        Character c;
        TrieNode[] next = new TrieNode[26];
        boolean end = false;

        TrieNode(Character c) {
            this.c = c;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode(null);

        for (String word : words) {
            word = new StringBuilder(word).reverse().toString();
            TrieNode curr = root;
            for (int i = 0; i <= word.length(); i++) {
                if (i == word.length()) {
                    curr.end = true;
                    break;
                }
                char c = word.charAt(i);
                int idx = c - 'a';
                if (curr.next[idx] != null) {
                    curr = curr.next[idx];
                } else {
                    TrieNode next = new TrieNode(c);
                    curr.next[idx] = next;
                    curr = next;
                }
            }
        }
        return dfs(root, 0);
    }

    private int dfs(TrieNode root, int currDepth) {
        int result = 0;
        boolean hasNext = false;
        for (TrieNode next : root.next) if (next != null) {
            hasNext = true;
            result += dfs(next, currDepth+1);
        }
        if (!hasNext) {
            return currDepth + 1;
        }
        return result;
    }
}