import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    Feline predator;

    @Test
    public void getSoundTestReturnCorrectValue() {
        Cat cat = new Cat(predator);
        String actualSound = cat.getSound();
        assertEquals("Мяу", actualSound);
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(predator);
        cat.getFood();
        Mockito.verify(predator, Mockito.times(1)).eatMeat();
    }

}
