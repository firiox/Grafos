

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Test
{
    /**
     * Default constructor for test class Test
     */
    public Test()
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
    @Test
    public void deletesOldTransactionsPeriodically() {
        Transactions transactions = new Transactions();
        transactions.add(oldTransaction());
    
        ManualClock clock = new ManualClock();
    
        HouseKeeper houseKeeper = new HouseKeeper(transactions, clock);
        houseKeeper.start();
    
        clock.elapseTime();
    
        houseKeeper.stop();
    
        assertEquals(0, transactions.count());
  }
}
