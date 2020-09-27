import java.util.ArrayList;
import java.util.HashMap;
/**
 * Keep track of word counts and word pairs.
 *
 * @author Jonah Matthew Farrow 
 * @version 0.3
 */
public class WordAnalyser
{    
    HashMap<String, Integer> wordStore;
    ArrayList<String> wordRetrieve;
    ArrayList<String> stringStore;  
    public WordAnalyser()
    {
        wordStore = new HashMap();
        wordRetrieve = new ArrayList();
        stringStore = new ArrayList();        
    }

    /**
     * Add a word to the three collections and allocate a value to the hashmap key.
     * @param word the word to be added.
     */
    public void addWord(String word)
    {
        int occurance = 0;
        stringStore.add(word);
        wordRetrieve.add(word);
        if(wordStore.containsKey(word)){
            occurance = wordStore.get(word) + 1;
            wordStore.put(word, occurance);
        }
        else if(wordStore.containsKey(word) != true){
            occurance = 1;
            wordStore.put(word, occurance);           
        }       
    }
    
    /**
     * Get the number of times the given word has been seen.
     * @param word The word to be looked up.
     * @return The number of times the word has been seen.
     */
    public int getCount(String word)
    {
        if(wordStore.containsKey(word)){
            return wordStore.get(word);    
        }
        else{
            return 0;
        }
    }

    /**
     * Return true if firstWord has been immediately
     * followed by secondWord; false otherwise.
     * @param firstWord
     * @param secondWord
     */
    public boolean followedBy(String firstWord, String secondWord)
    {      
        int increase = 0;
        boolean searching = true;
        if(stringStore.contains(firstWord) && stringStore.contains(secondWord)){
            while(searching && increase < stringStore.size()-1){
                if(stringStore.get(increase).equals(firstWord) && stringStore.get(increase + 1).equals(secondWord)){
                    searching = false;
                    return true;
                }
                else{                   
                    increase++;
                    System.out.println(increase);
                }                
            }
        }
        return false;
    }

    /**
     * Get the number of times the given word has been seen,
     * regardless of the case of its occurrences.
     * @param word The word to be looked up.
     * @return The number of times the word has been seen.
     */
    public int getCaseInsensitiveCount(String word)
    {
        int occurance = 0;
        for(String convert : wordRetrieve){            
            if(word.equalsIgnoreCase(convert)){
                occurance++;                    
            }           
        }
        if(occurance > 0){
            return occurance;
        }
        return 0;
    }
}

