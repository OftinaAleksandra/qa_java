import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline feline;

    private final String actualSex;
    private final Boolean expectedIsMane;
    public LionTest(String actualSex, Boolean expectedIsMane) {
        this.actualSex = actualSex;
        this.expectedIsMane = expectedIsMane;
    }

    @Parameterized.Parameters
    public static Object[][] dataForSexLion() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }
    @Test
    public void checkUncorrectedLionSex() throws Exception {
        try{
            Lion lion = new Lion("Неизвестно", feline);

        } catch (Exception thrown){
            String expectedResult = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expectedResult, thrown.getMessage());
        }
    }
    @Test
    public void checkLionSex() throws Exception {
        Lion lion = new Lion(actualSex, feline);
        assertEquals(expectedIsMane, lion.doesHaveMane());
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(actualSex, feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(actualSex,feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

}
