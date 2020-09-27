import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WordAnalyserTest.
 *
 * @author  (Jonah Farrow)
 * @version (0.1)
 */
public class WordAnalyserTest
{
    private WordAnalyser wordAnal1;

    /**
     * Default constructor for test class WordAnalyserTest
     */
    public WordAnalyserTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        wordAnal1 = new WordAnalyser();
        wordAnal1.addWord("cheese");
        wordAnal1.addWord("Book");
        wordAnal1.addWord("Jelly");
        wordAnal1.addWord("Cake");
        wordAnal1.addWord("frog");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /*
    @Test
    public void wordCheckOccurance()
    {
        WordAnalyser wordAnal1 = new WordAnalyser();     
        System.out.println("1. " +wordAnal1.returnOccurance());
        assertEquals(5, wordAnal1.returnOccurance());    
        System.out.println("2. " +wordAnal1.returnOccurance());
    }
    */
    @Test
    public void wordAddToLists()
    {
        assertEquals(true, wordAnal1.wordStore.containsKey("cheese"));
    }

    @Test
    public void getCountFindsWord()
    {
        assertEquals(1, wordAnal1.getCount("cheese"));
        wordAnal1.addWord("cheese");
        assertEquals(2, wordAnal1.getCount("cheese"));
    }

    @Test
    public void getCountReturnsZero()
    {
        assertEquals(0, wordAnal1.getCount("WordNotInList"));
    }

    @Test
    public void followedByForEveryWordInCollection()
    {
        assertEquals(true, wordAnal1.followedBy("cheese", "Book"));
        assertEquals(true, wordAnal1.followedBy("Book", "Jelly"));
        assertEquals(true, wordAnal1.followedBy("Cake", "frog"));
    }

    @Test
    public void followedByForWordsNotInOrder()
    {
        assertEquals(false, wordAnal1.followedBy("cheese", "Jelly"));
        assertEquals(false, wordAnal1.followedBy("Book", "frog"));
        assertEquals(false, wordAnal1.followedBy("Book", "cheese"));
    }

    @Test
    public void followedByForOneWordInCollectionAndOneNot()
    {
        assertEquals(false, wordAnal1.followedBy("cheese", "WordNotInList"));
    }

    @Test
    public void followedByNeitherWordInCollection()
    {
        assertEquals(false, wordAnal1.followedBy("WordNotInCollection", "AlsoNotInCollection"));
    }

    @Test
    public void getCaseInsensitiveCorrectReturn()
    {
        wordAnal1.addWord("cheese");
        assertEquals(2, wordAnal1.getCaseInsensitiveCount("Cheese"));
        wordAnal1.addWord("booK");
        wordAnal1.addWord("BOOK");
        assertEquals(3, wordAnal1.getCaseInsensitiveCount("book"));
        wordAnal1.addWord("cAKE");
        assertEquals(2, wordAnal1.getCaseInsensitiveCount("cake"));
    }

    @Test
    public void getCaseInsensitiveWordEnteredDoesNotExist()
    {
        assertEquals(0, wordAnal1.getCaseInsensitiveCount("green"));
        assertEquals(0, wordAnal1.getCaseInsensitiveCount("caaakee"));
        assertEquals(0, wordAnal1.getCaseInsensitiveCount("boooooook"));
        assertEquals(0, wordAnal1.getCaseInsensitiveCount("books"));
    }
}









