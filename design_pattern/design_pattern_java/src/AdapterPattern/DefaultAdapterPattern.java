interface ServiceInterface{
    void serviceMethod1();
    void serviceMethod2();
    void serviceMethod3();
}

abstract class AbstractServiceClass implements ServiceInterface{
    @Override
    public void serviceMethod1() {
        // TODO Auto-generated method stub
        
    }    
    @Override
    public void serviceMethod2() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void serviceMethod3() {
        // TODO Auto-generated method stub
        
    }
}

class ConcreteServiceClass extends AbstractServiceClass{
    public void serviceMethod1(){
        System.out.println("implement serviceMethod1");
    }
}
