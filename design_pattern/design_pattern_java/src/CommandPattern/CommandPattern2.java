package CommandPattern;

/**
 * command queue
 *@author wxx
 */
import java.util.*;

class Command {
    public void execute(){
    }
}

class CommandQueue {
    private ArrayList<Command> commands = new ArrayList<>();
    public void addCommand(Command command){
        commands.add(command);
    }
    public void removeCommand(Command command){
        commands.remove(command);
    }
    public void execute(){
        for(Object command: commands){
            ((Command) command).execute();
        }
    }

}

class Invoker{
    private CommandQueue commandQueue;

    public Invoker(CommandQueue commandQueue){
        this.commandQueue = commandQueue;
    }
    public void setCommandQueue(CommandQueue commandQueue){
        this.commandQueue = commandQueue;
    }
    public void call(){
        commandQueue.execute();
    }
}
