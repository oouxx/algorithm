class Data{
    //some code
}

abstract class Data {
    protected DataCollectImpl dataCollectImpl;

    public void setDataCollectImpl(DataCollectImpl dataCollectImpl) {
        this.dataCollectImpl = dataCollectImpl;
    }

    public abstract void displayData(Data data);
}

interface DataCollectionImpl {
    public Data dataCollect(String fileName);
}

class ReadFileDataCollect implements DataCollectionImpl{
    public Data dataCollect(String fileName){
        System.out.println("read file to collect data");
        return new Data();
    }
}
class ReadDatabaseDataCollect implements DataCollectionImpl{
    public Data dataCollect(String fileName){
        System.out.println("read database to collect data");
        return new Data();
    }
}
class ReadExcelDataCollect implements DataCollectionImpl{
    private ExcelApiAdapter excelApiAdapter;
    public ReadExcelDataCollect(){
        this.excelApiAdapter = new ExcelApiAdapter();
    }
    public Data dataCollect(String fileName){
        return this.excelApiAdapter.specificRequest(fileName);
    }
}
class ExcelApiAdapter {
    private ReadExcel readExcel; //adaptee
    public ExcelApiAdapter(){
        readExcel = new ReadExcel();
    }
    public Data specificRequest(String fileName){
        return readExcel.readExcel(fileName);
    }
}
// adaptee
class ReadExcel{
    public Data readExcel(String fileName){
        return new Data();
    }
}
