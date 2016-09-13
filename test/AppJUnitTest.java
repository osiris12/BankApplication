
import app.Bank;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AppJUnitTest {
    private static Bank bank;
    
    public AppJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        bank = new Bank();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1() {
        int test = bank.checkNumberOfAccountss();
        assertTrue("More than one account exist.", test >= 0);
    }
    
    @Test
    public void test2(){
        
    }
}
