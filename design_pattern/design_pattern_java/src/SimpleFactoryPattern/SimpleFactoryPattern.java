package SimpleFactoryPattern;

interface Chart{
    void display();
}

class PieChart implements Chart{
    public PieChart(){
        System.out.println("create PieChart");
    }
    public void display(){
        System.out.println("display PieChart");
    }
}
class HistogramChart implements Chart{
    public HistogramChart(){
        System.out.println("create HistogramChart");
    }
    public void display(){
        System.out.println("display HistogramChart");
    }
}
class LineChart implements Chart{
    public LineChart(){
        System.out.println("create LineChart");
    }
    public void display(){
        System.out.println("display LineChart");
    }
}

class ChartFactory{
    public static Chart getChart(String type){
        Chart chart = null;
        if(type.equalsIgnoreCase("PieChart")){
            chart = new PieChart();
        }else if(type.equalsIgnoreCase("HistogramChart")){
            chart = new HistogramChart();
        }else if(type.equalsIgnoreCase("LineChart")){
            chart = new LineChart();
        }
        return chart;
    }
}