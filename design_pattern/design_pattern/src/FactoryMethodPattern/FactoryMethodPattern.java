package FactoryMethodPattern;

interface LoggerFactory{
    public Logger generateLogger();
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