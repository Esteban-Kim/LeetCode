class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> availableWords = new HashSet<>(wordList);

        if (!availableWords.contains(endWord)) {
            return 0;
        }

        PriorityQueue<Word> pQueue = new PriorityQueue<>((a, b) -> {
            return a.count-b.count;
        });
        pQueue.add(new Word(beginWord, 1));

        while (!pQueue.isEmpty()) {
            Set<String> nextSetOfWords = new HashSet<>();
            Word temp = pQueue.poll();
            if (temp.currentWord.equals(endWord)) {
                return temp.count;
            }
            for (String word : availableWords) {
                if (differentByOne(temp.currentWord, word)) {
                    pQueue.add(new Word(word, temp.count+1));
                } else {
                    nextSetOfWords.add(word);
                }
            }
            availableWords = nextSetOfWords;
        }

        return 0;
    }

    public boolean differentByOne(String w1, String w2) {
        int count = 0;
        for (int index = 0; index < w1.length(); index++) {
            if (w1.charAt(index) != w2.charAt(index)) {
                count++;
            }
        }
        return count == 1;
    }
}

class Word {
    String currentWord;
    int count;
    public Word(String currentWord, int count) {
        this.currentWord = currentWord;
        this.count = count;
    }
}