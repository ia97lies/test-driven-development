package mygame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HistoryTest {
    
    @Test
    public void shouldUndo() {
        History history = new History();
        history.undo();
    }
    
    @Test
    public void shouldRedo() {
        History history = new History();
        history.redo();
    }
}
