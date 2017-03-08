package sillygame;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ms on 08-03-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class DiceGameTest {

    @Mock
    Printer printer;
    @Mock
    Dice d1, d2;

    @Test(expected = Exception.class)
    public void testExceptionAfterThreeThrows() throws Exception {
        DiceGame game = new DiceGame(printer, d1, d2);
        game.roll();
        game.roll();
        game.roll();
        game.roll();

    }

    @Test
    public void testResetAfterNewGame() throws Exception {
        DiceGame game = new DiceGame(printer, d1, d2);
        game.roll();
        game.roll();
        game.roll();
        game.roll();
        game.startGame();
        game.roll();
        Assert.assertTrue(true);

    }

  @Test
  public void testGame() throws Exception {
         //given
      when(d1.roll()).thenReturn(2).thenReturn(5).thenReturn(2);
      when(d2.roll()).thenReturn(2).thenReturn(7).thenReturn(1);
      DiceGame game = new DiceGame(printer, d1, d2);
        //when
      game.setPlayer("Kurt");
      int res  = game.roll();
      int res1 = game.roll();
      int res2 = game.roll();
        //then
      Assert.assertThat(res, Matchers.is(4));
      Assert.assertThat(res1, Matchers.is(12));
      Assert.assertThat(res2, Matchers.is(3));

        //Behavior
      verify(printer, times(1)).print("Kurt you Lost the game");
  }
}
