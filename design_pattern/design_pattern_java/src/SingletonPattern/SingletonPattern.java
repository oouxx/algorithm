
/**
   @title: ${file_name}
 * @author wangxinxing961129@gmail.com
 * @date ${date}${time}
 */
import java.util.List;
import java.util.ArrayList;

class TaskManager{
    private static TaskManager tm = null;
    private TaskManager(){
    }
    public void displayProcesses(){
        System.out.println("display processes");
    }
    public void displayServices(){
        System.out.println("display services");
    }
    public static TaskManger getInstance(){
        if(tm == null){
            tm = new TaskManager();
        }
        return tm;
    }
}

class LoadBalancer{
    private static LoadBalancer lb = null;
    private static List<String> serverList = new ArrayList<>();
    private LoadBalancer(){};
    public LoadBalancer getLoadBalancer(){
        if(lb == null){
            lb = new LoadBalancer();
        }
        return lb;
    }
    public void addServer(String server){
        serverList.add(server);
    }
    public void remove(String server){
        serverList.remove(server);
    }
    public String getServer(){
        return serverList.get(0);
    }
}

// EagerSingleton
class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){
        
    }
    public EagerSingleton getInstance(){
        if(instance == null){
            instance = new EagerSingleton();
        }
        return instance;
    }
}

// LazySingleton
class LazySingleton {
    private static final LazySingleton instance = new LazySingleton();
    private LazySingleton(){

    }
    // performance problem
    synchronized public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

// LazySingleton
class LazySingleton {
    private static final LazySingleton instance = new LazySingleton();
    private LazySingleton(){

    }
    // performance problem
    synchronized public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 double check LazySingleton
 still not perfect
 */
class LazySingleton {
    // volatie
    private volatile static LazySingleton instance = new LazySingleton();

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        // first check
        if (instance == null) {
            // lock code
            synchronized (LazySingleton.class) {
                // second check
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

/** 
    由于静态单
    例对象没有作为Singleton的成员变量直接实例化，因此类加载时不会实例化Singleton，第一次
    调用getInstance()时将加载内部类HolderClass，在该内部类中定义了一个static类型的变量
    instance，此时会首先初始化这个成员变量，由Java虚拟机来保证其线程安全性，确保该成员
    变量只能初始化一次。由于getInstance()方法没有任何线程锁定，因此其性能不会造成任何影
    响。
*/
// final solution
class Singleton{
    private Singleton(){

    }
    private static class HolderClass{
        private final static Singleton instance = new Singleton();
    }
    public static Singleton getInstance(){
        return HolderClass.instance;
    }

}
