# Script
## Start With MoveIt
* Explain roughly the playerFactory
** Location
** Size is 1

* How you can place a player to be visible

* Only x, z plane in right handed coordinate system
** positive z is going forward
** negative z is going backward
** positive x is going to the left
** negative x is going to the right

* Explain actionListener where the keys are bound to
** show in the code
** run the app
=> show the problem of not beeing able to test, or only from a outside view
=> tell about the idea of a undo/redo
=> tell them about the command pattern

## Implement command pattern TDD
* Command interface *Command.java* with an *execute()* and an *undo()* method.

* Create a MoveCommandTest

* And first test "shouldMove()"

* Command command = new MoveCommand()
** Not compile => create MoveCommand class (alt+Enter)
** Move the MoveCommand file to the "SourcePackages"
** Resolve conflict in MoveCommand (alt+Enter) => implement all methods of Interface Command
** It compiles

* Command command = new MoveCommand(player, 1, 0);
** We want to move a player so we have to capsulate the player in the Command
** The player is just a Node, we do not want graphics involed so we use a Mock Player.
** Node player = new Node("Player")
** Failure as the constructor for MoveCommand(player, 1, 0) is missing.
** Resolve conflict (alt+Enter)

* assertEquals(new Vector3f(1, 0, 0), player.getLocalTranslation());
** Run tests
** Player did not move still on 0, 0, 0 but should be on 1, 0 ,0
** In the constructor of MoveCommand: this.player = player; (alt+Enter)
** In the execute method: player.move(1, 0, 0);
** Run tests

* Rename test to shouldMoveLeft() make it more specific what you test

* shouldMoveRight()
** Node player = new Node("Player");
   Command command = new MoveCommand(player, -1, 0);
   command.execute();
   assertEquals(new Vector3f(-1, 0, 0), player.getLocalTranslation());        
** Run tests
** shouldMoveRight will fail
** Store x in the MoveCommand
** Use x in the player.move(...) instead of the constant
** Refactor the test and move the player instantiation into the setUpMethod();
** In nevisproxy we name this a fixture, a set of tests with a similar story. A very simple one in this case.

* shouldMoveUp() analog to shouldMoveRight()
** Command command = new MoveCommand(player, 0, -1);
   command.execute();
   assertEquals(new Vector3f(0, 0, -1), player.getLocalTranslation());        
** Run tests
** shouldMoveUp will fail
** Store y in the MoveCommand
** Use y int the player.move(...). This is the smallest possible change.
** Run tests.

* shouldUndoRightMove()
** Command command = new MoveCommand(player, -1, 0);
   command.execute();
   command.undo();
   assertEquals(new Vector3f(0, 0, 0), player.getLocalTranslation());
** Run tests
** Test shouldUndoMove() should fail.
** Set player to (0, 0, 0) static, this is the smallest possible step.

* shouldUndoDoubleRightMove()
** Command command = new MoveCommand(player, -1, 0);
   command.execute();
   command = new MoveCommand(player, -1, 0);
   command.execute();
   command.undo();
   assertEquals(new Vector3f(-1, 0, 0), player.getLocalTranslation());
** Run tests
** Test shouldUndoMove() should fail.
** Move player back to (-1, 0, 0), smallest possible step is player.move(-x, 0, 0)
** Refactor test and make a CommandMoveUndoTest

* shouldUndoUp()
** Command command2 = new MoveCommand(player, 0, 1);
   command2.execute();
   command2.undo();
   assertEquals(new Vector3f(-1, 0, 0), player.getLocalTranslation());
** Run tests
** Test shouldUndoUp() should fail.
** Move player back to (-1, 0, 0), smallest possible step is player.move(-x, 0 , -y);
** Run tests

