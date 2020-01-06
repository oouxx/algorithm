package FactoryMethodPattern;

interface LoggerFactory{
    public Logger generateLogger();

    public Logger generateLogger(String strParam);

    public Logger generateLogger(Object objParam);
}
// hide factory method
// reduce client's works
abstract class LoggerFactory{
    public abstract Logger generateLogger();
    public void writeLog(){
        Logger logger = this.generateLogger();
        logger.writeLog();
    }
}


interface Logger{
    public void writeLog();
}

class DatabaseLogger implements Logger{
    public void writeLog(){
        System.out.println("DatabaseLogger");
    }
}
class FileLogger implements Logger{
    public void writeLog(){
        System.out.println("FileLogger");
    }
}
class DatabaseLoggerFactory implements LoggerFactory{
    public Logger generateLogger(){
        Logger databasLogger = new DatabaseLogger();
        System.out.println("DatabaseLogger has generated");
        return databasLogger;
    }
}
class FileLoggerFactory implements LoggerFactory{
    public Logger generateLogger(){
        Logger fileLogger = new FileLogger();
        System.out.println("FileLogger has generated");
        return fileLogger;
    }
}
class Client{
    public void main(){
        LoggerFactory factory;
        Logger logger;
        factory = new FileLoggerFactory();
        logger = factory.generateLogger();
        logger.writeLog();
    }
}
