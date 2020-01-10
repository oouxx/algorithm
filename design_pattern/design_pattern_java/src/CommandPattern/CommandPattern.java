package CommandPattern;

import java.util.ArrayList;

class FBSettingWindow {
    private String title;
    private final List<FunctionButton> functionButtons;

    public FBSettingWindow(final String title) {
        this.title = title;
        functionButtons = new ArrayList<>();
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void addFunctionButton(final FunctionButton fb) {
        this.functionButtons.add(fb);
    }

    public void removeFunctionButton(final FunctionButton fb) {
        this.functionButtons.remove(fb);
    }

    public void display() {
        System.out.println("display");
    }
}

class FunctionButton {
    private Command command;
    private String name;
    public FunctionButton(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public setCommand(Command command){
        this.command = command;
    }

    public void onClick() {
    };
}

interface Command{
    void execute();
}

class MinimizeCommand implements Command{
    private WindowHandler windowHandler;
    public MinimizeCommand(){
        this.windowHandler = new WindowHandler();
    }
    @Override
    public void execute() {
        windowHandler.minimize();

    }
}

class HelpCommand implements Command{
    private HelpHandler helpHandler;
    public HelpCommand(){
        this.helpHandler = new HelpHandler();
    }
    @Override
    public void execute() {
        helpHandler.display();
    }
}

class WindowHandler{
    public void minimize(){
        System.out.println("minimize windows");
    }
}

class HelpHandler{
    public void display(){
        System.out.println("display help");
    }
}
