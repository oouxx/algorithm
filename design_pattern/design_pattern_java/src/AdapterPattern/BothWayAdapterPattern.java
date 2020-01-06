class Adapter implements Target, Adaptee{
    private Target target;
    private Adaptee adaptee;

    public Adapter(Target target){
        this.target = target;
    }

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    public void request(){
        adaptee.request();
    }
    
    public void specificRequest(){
        target.request();
    }
}