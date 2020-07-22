# Script
## Goal we want to achive in the third part of the TDD workshop
### Precedure
We proceed now with the history object
### Notes
* Don't use move command for testing
* Explain that the step size might changed
* Use mocks -> mockito

## My Path

* New test HistoryTest

* shouldExecuteCommand()
** History history = new History();
** Compilation fails
** (alt+Enter)
** Compiles
** @RunWith(MockitoJUnitRunner.class)
   @Mock
   Command command;
   history.execute(command);
** Compilation fails
** (alt+Enter) on CommandMock and execute.
** Compiles

* We want to check if execute gets called
   verify(command, times(1)).execute();
** Run tests
** Test fails
** Extend history execute with 
   command.execute();
** Run tests

* shouldUndo()
** History history = new History();
   history.undo();
** Compilation fails
** (alt+Enter)
** Compiles
** We can not test more, so we need a command to proceed testing

* shouldUndoLastCommand()
** History history = new History();
   CommandMock command = new CommandMock()
   history.execute(command);
   history.undo();
   verify(command, times(1)).undo();
** Run tests
** Test fails
** Extend History and hold the command you execute in a Command command member variable (do resist start directly with a array)
   and call then this commands undo.
** Run tests
** New test will pass, but the old testUndo() will fail with NullException becaus undo calls a null pointer commands undo method.
** Write a if around the undo command
** Run tests

* Refactor test and make a fixture. Lets call this new test HistorySizeOneTest
** Move shouldExecuteCommand and shouldUndoLastCommand into this fixture
** Move the comon part int to the setUpMethod
   history = new History();
   command = new CommandMock();
   history.execute(command); 
** Make member variables of history and command
** Run tests

* shouldRedo
** Add this test in our initial HistoryTest class
** history.redo()
** Compilation fails
** (alt+Enter)
** Compiles

* shouldRedoLastUndo
** In HistorySizeOneTest
** history.undo();
   history.redo();
   verify(command, times(2)).execute;
** Run tests
** Test fails
** Add command.execute() to the History redo method
** Run tests
** New test will pass, but the old shouldRedo() will fail with NullException becaus redo calls a null pointer commands execute method.
** Make a if around the command.execute() in the redo method
** Run tests

* Refactor the history class with a linked list
** LinkedList<Command> commands;
   /* important that it is LinkedList */
** use getFirst() for everything.
** use isEmpty() instead of null check
** See that everything still works
** Refactoring code with a bunch of tests is so much more fun!!

* new test HistorySizieTwoTest
** Story is now command1 and command2
** shouldUndoTwice()
** history.undo();
   history.undo();
   verify(command1, times(1)).undo()
** In the undo do
   commands.removeLast().undo();
** Run Tests
** HistorySizeOneTest:shouldRedolastUndo() will fail, because we drop the command on undo.
** Add a redo list LinkedList<Command> redoCommands;
** Move the removed command into the redoCommands list.
** In the redo we call redos.getFirst().exectue();
** shouldRedoAfterTwoUndo()
   history.undo();
   history.undo();
   history.redo();
   verify(command1, times(2)).execute();
** Run tests
** Test fails
** Just replace getFirst with getLast();
** Run tests
** But this is still not the final solution
** shouldRedoTwoUndos()
   history.undo();
   history.undo();
   history.redo();
   history.redo();
   verify(command2, times(2)).execute();
** Run tests
** Test fails
** Just replace getLast() with removeLast()


