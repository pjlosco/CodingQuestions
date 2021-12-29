package puzzle;

import java.util.*;

public class CommonWords {

    /**
     * Amazon is partnering with the linguistics department at a local university to analyze important works of
     * English literature and identify patterns in word usage across different eras. To ensure a cleaner output,
     * the linguistics department has provided a list of commonly used words (e.g., "an", "the", etc.) to exclude
     * from the analysis. In the context of this search, a word is an alphabetic sequence of characters having no
     * whitespace or punctuation.
     *
     * Note: Words that have a different case are counted as the same word.
     *      * The order of words does not matter in the output list.
     *      * All words in the wordsToExclude list are unique.
     *      * Any character other than letters from the English alphabet should be treated as white space.
     *
     * @param literatureText a string representing the block of text
     * @param wordsToExclude a list of strings representing the commonly used words to be excluded while analyzing the word frequency.
     * @return a list of strings representing the most frequently used word in the text or in case of a tie, all of the most frequently used words in the text.
     */
    List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude)
    {
        Map<String, Integer> commonWords = new HashMap();

        List<String> wordsToExcludeNew = new ArrayList<>();
        for (String word : wordsToExclude) {
            wordsToExcludeNew.add(word.toLowerCase());
        }

        // clean up string
        literatureText = literatureText.replaceAll("[^A-Za-z0-9]", " ").toLowerCase();
        String[] words = literatureText.split(" ");

        List<String> highestCountWords = new ArrayList<>();
        int highestCount = 0;

        for (String word : words) {
            if (wordsToExcludeNew.contains(word) || word.isEmpty()) {
                continue;
            } else {
                int occurances = 0;
                if (commonWords.containsKey(word)) {
                    occurances = commonWords.get(word);
                }
                occurances = occurances +1;

                commonWords.put(word, occurances);

                if (occurances == highestCount) {
                    highestCountWords.add(word);
                    highestCount = occurances;
                } else if (occurances > highestCount) {
                    highestCountWords = new ArrayList<>();
                    highestCountWords.add(word);
                    highestCount = occurances;
                }
            }
        }
        return highestCountWords;
    }
}
