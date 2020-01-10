import java.util.ArrayList;
import java.util.List;

abstract class AbstractObjectList {
    protected List<Object> objects = new ArrayList<>();

    public AbstractObjectList(ArrayList objects) {
        this.objects = objects;
    }

    public void addObject(Object obj) {
        this.objects.add(obj);
    }

    public void removeObject(Object obj) {
        this.objects.remove(obj);
    }

    public List<Object> getObject() {
        return this.objects;
    }

    public abstract AbastractIterator createIterator();
}

class ProductList extends AbstracObjectList {
    public ProductList(List products) {
        super(products);
    }

    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}

interface AbstractIterator {
    public void next();

    public boolean isLast();

    public void previous();

    public boolean isFirst();

    public Object getNextItem();

    public Object getPreviousItem();
}

class ProductIterator implements AbstractIterator {
    private ProductList productList;
    private List products;
    private int cursor1;
    private int cursor2;

    public ProductIterator(ProductList list) {
        this.productList = list;
        this.products = list.getObjects();
        cursor1 = 0;
        cursor2 = products.size() - 1;
    }

    @Override
    public void next() {
        if (cursor1 < products.size()) {
            cursor1++;
        }
    }

    @Override
    public boolean isLast() {
        return (cursor1 == products.size());
    }

    @Override
    public void previous() {
        if (cursor2 > -1) {
            cursor2--;
        }
    }

    @Override
    public boolean isFirst() {
        return (cursor2 == -1);
    }

    @Override
    public Object getNextItem() {
        return products.get(cursor1);
    }

    @Override
    public Object getPreviousItem() {
        return products.get(cursor2);
    }
}
