package AbstractFactoryPattern;

interface OperationController{
    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();
}

class SymbianOperationController implements OperationController{
    public void moveUp(){
        System.out.println("I can moveUp");
    }
    public void moveLeft(){
        System.out.println("I can moveLeft");
    }
    public void moveRight(){
        System.out.println("I can movRight");
    }
    public void moveDown(){
        System.out.println("I can moveDown");
    }
}
class AndroidOperationController implements OperationController{
    public void moveUp(){
        System.out.println("I can moveUp");
    }
    public void moveLeft(){
        System.out.println("I can moveLeft");
    }
    public void moveRight(){
        System.out.println("I can movRight");
    }
    public void moveDown(){
        System.out.println("I can moveDown");
    }
}
class WindowsMobileOperationController implements OperationController{
    public void moveUp(){
        System.out.println("I can moveUp");
    }
    public void moveLeft(){
        System.out.println("I can moveLeft");
    }
    public void moveRight(){
        System.out.println("I can movRight");
    }
    public void moveDown(){
        System.out.println("I can moveDown");
    }
}

interface InterfaceController {
    void display();
}

class SymbianInterfaceController implements InterfaceController {
    public display(){
        System.out.println("I can display");
    }
}
class AndroidInterfaceController implements InterfaceController {
    public display(){
        System.out.println("I can display");
    }
}
class WindowsMobileInterfaceController implements InterfaceController {
    public display(){
        System.out.println("I can display");
    }
}

interface Factory {
    OperationController generateOperationController();
    InterfaceController generateInterfaceController();
}

class Symbian implements Factory {
    public OperationController generateOperationController(){
        System.out.println("I can generate operation controller");
        return new SymbianOperationController();
    }
    public generateInterfaceController(){
        System.out.println("I can generate interface controller");
        return new SymbianInterfaceController();
    }
}
class Android implements Factory {
    public OperationController generateOperationController(){
        System.out.println("I can generate operation controller");
        return new AndroidOperationController();
    }
    public generateInterfaceController(){
        System.out.println("I can generate interface controller");
        return new AndroidInterfaceController();
    }
}
class WindowsMobile implements Factory {
    public OperationController generateOperationController(){
        System.out.println("I can generate operation controller");
        return new WindowsMobileOperationController();
    }
    public generateInterfaceController(){
        final InterfaceController interfaceController = new InterfaceController();
        System.out.println("I can generate interface controller");
        return new WindowsMobileInterfaceController();
    }
}

class Client{
    public static void main(){
        System.out.println();
    }
}

