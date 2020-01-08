class Matrix{
    // some code
}
abstract class Image{
    protected ImageImp imp;

    public void setImageImp(ImageImp imp){
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}

interface ImageImp{
    // display matrix
    public void doPaint(Maxtrix m);
}

class WindowsImp implements ImageImp{
    public void doPaint(Matrix m){
        System.out.println("display image in Windows operating system");
    }
}

class LinuxImp implements ImageImp{
    public void doPaint(Matrix m){
        System.out.println("display image in Linux operating system");
    }
}
class UnixImp implements ImageImp{
    public void doPaint(Matrix m){
        System.out.println("display image in UnixImp operating system");
    }
}

class JPGImage extends Image{
    public void parseFile(String fileName){
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + ",format is JPG");
    }
}
class PNGImage extends Image{
    public void parseFile(String fileName){
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + ",format is PNG");
    }
}
class BMPImage extends Image{
    public void parseFile(String fileName){
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + ",format is BMP");
    }
}

class GIFImage extends Image {
    public void parseFile(String fileName) {
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + ",format is GIF");
    }
}

class Client{
    public static void main(String[] args[]){
        Image image;
        ImageImp imp;
        image = (Image) XMLUtil.getBean("image");
        imp = (ImageImp) XMLUtil.getBean("os");
        image.setImageImp(imp);
        image.parseFile("handsome.png");
    }
}
