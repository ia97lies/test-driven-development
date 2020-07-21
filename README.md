# TDD Workshop
The workshop focuses specifically on test-driven development mantra and provides tips and tricks on how to achieve that. After the workshop you will be able to practice test-driven development with any language, it is not limited to Java.

# Topics
* 15' Min intro
* 30' live hacking by the presenter
* 45' Involving the audience, we do it together
* 45' The audience works on their own and present the solution to the rest

We do 10' breaks between the blocks.

## Your Tasks
Do the following steps before the workshop!

* Import MoveIt_step0 in your IDE as a Gradle project and build it, Java 8 should be sufficient.
* Run the application, you can move a square with WASD keys on the screen.
* Make sure the dummy test is working!

## The Whole Picture 
We will program a turn-based mini-game with undo and redo. In the end, you can move around on an xz-plane and you can undo and redo the movements of your character.
For this, we implement the command pattern from [the gang of 4](https://en.wikipedia.org/wiki/Design_Patterns). See [here](https://gameprogrammingpatterns.com/command.html) if you want to read more about this pattern.

### Command Pattern
We will capsulate every movement into a command in our case the **MoveCommand**, we do **not** reuse command objects.
The command has two methods an *execute()* and an *undo()*

We store these commands into a history object. The **History** class does have *execute(Command command)*, *undo()*, and *redo()* methods.

### Example
The history object contains a list of commands and in this example the last executed command was **command2**
```
command1 *command2*
```

To execute a command we simply call *history.execute(command)* that then calls command.exectue() and store the command into a structure. We were initially on **command2** and move on to **command3**
```
command1 command2 *command3*
```

To undo the current command, we simply call *history.undo()* that calls then *command.undo()* of **command3** and move to the command before in our example to **command2**
```
command1 *command2* command3
```

To redo a command we undid we simply move one command further and call again *command.execute()* in our example it is **command3**
```
command1 command2 *command3*
```

