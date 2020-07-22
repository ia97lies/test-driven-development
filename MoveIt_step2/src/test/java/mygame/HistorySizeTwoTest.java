package mygame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HistorySizeTwoTest {

    @Mock
    Command command1;

    @Mock
    Command command2;
    private History history;
 
    @Before
    public void setUp() {
        history = new History();
        history.execute(command1);
        history.execute(command2);
    }
    
    @Test
    public void shouldUndoTwice() {
        history.undo();
        history.undo();
        verify(command1, times(1)).undo();
    }
    
    @Test
    public void shouldRedoAfterTwoUndo() {
        history.undo();
        history.undo();
        history.redo();
        verify(command1, times(2)).execute();
    }
    
    @Test
    public void shouldRedoLastTwoUndo() {
        history.undo();
        history.undo();
        history.redo();
        history.redo();
        verify(command2, times(2)).execute();
    }
}
