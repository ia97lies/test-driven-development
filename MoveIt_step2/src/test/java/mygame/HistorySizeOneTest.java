package mygame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HistorySizeOneTest {

    @Mock
    Command command;
    private History history;
 
    @Before
    public void setUp() {
        history = new History();
        history.execute(command);
    }
    
    @Test
    public void shouldExecuteCommand() {
        verify(command, times(1)).execute();
    }
    
    @Test
    public void shouldUndoLastCommand() {
        history.undo();
        verify(command, times(1)).undo();
    }
    
    @Test
    public void shouldRedoLastUndo() {
        history.undo();
        history.redo();
        verify(command, times(2)).execute();
    }
}
