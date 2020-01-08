package CompositePattern;

import java.util.ArrayList;

abstract class AbstractFile{
    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();
}
// leaf
class ImageFile extends AbstractFile{
    private String name;
    public ImageFile(String name){
        this.name = name;
    }
    public void add(AbstractFile file){
        System.out.println("sorry, the method do not support");
    }

    public void remove(AbstractFile file){
        System.out.println("sorry, the method do not support");
    }
    public AbstractFile getChild(int i){
        System.out.println("sorry, the method do not support");
        return null;
    }
    public void killVirus(){
        System.out.println("kill virus for " + name);
    }
}

class TextFile extends AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        System.out.println("sorry, the method do not support");
    }

    public void remove(AbstractFile file) {
        System.out.println("sorry, the method do not support");
    }

    public AbstractFile getChild(int i) {
        System.out.println("sorry, the method do not support");
        return null;
    }

    public void killVirus() {
        System.out.println("kill virus for " + name);
    }
}

class VideoFile extends AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        System.out.println("sorry, the method do not support");
    }

    public void remove(AbstractFile file) {
        System.out.println("sorry, the method do not support");
    }

    public AbstractFile getChild(int i) {
        System.out.println("sorry, the method do not support");
        return null;
    }

    public void killVirus() {
        System.out.println("kill virus for " + name);
    }
}
class Folder extends AbstractFile {
    private ArrayList<AbstractFile> list = new ArrayList<AbstractFile>();
    private String name;
    public Folder(String name){
        this.name = name;
    }

    public void add(AbstractFile file) {
        list.add(c);
    }

    public void remove(AbstractFile file) {
        list.remove(c);
    }

    public AbstractFile getChild(int i) {
        return list.get(i);

    }
    public void killVirus() {
        for(Object obj: list){
            ((AbstractFile)obj).killVirus();
        }
    }
}

// 透明组合模式中，抽象构件Component中声明了所有用于管理成员对象的方法
/**
 * 透明组合模式的缺点是不够安全，因为叶子对象和容器对象在本质上是有区别的。叶子对象
 * 不可能有下一个层次的对象，即不可能包含成员对象，因此为其提供add()、remove()以及
 * getChild()等方法是没有意义的，这在编译阶段不会出错，但在运行阶段如果调用这些方法可 能会出错（如果没有提供相应的错误处理代码）。
 */

// 安全组合模式中，在抽象构件Component中没有声明任何用于管理成员对象的方法
/**
 * 安全组合模式的缺点是不够透明，因为叶子构件和容器构件具有不同的方法，且容器构件中
 * 那些用于管理成员对象的方法没有在抽象构件类中定义，因此客户端不能完全针对抽象编
 * 程，必须有区别地对待叶子构件和容器构件。在实际应用中，安全组合模式的使用频率也非 常高，在Java AWT中使用的组合模式就是安全组合模式。
 */
