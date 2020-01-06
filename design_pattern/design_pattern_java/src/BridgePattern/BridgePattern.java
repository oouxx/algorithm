interface Implementor{
    public void operationImpl();
}

abstract class Abstraction{
    protected Implementor impl; // 定义实现类接口对象

    public void setImpl(Implementor impl){
        this.impl = impl;
    }
    public abstract void operation(); // 声明抽象业务方法
}
// 扩充抽象类
class RefinedAbstraction extends Abstraction{
    public void operation(){
        // 业务代码
        impl.operationImpl();
    }
}