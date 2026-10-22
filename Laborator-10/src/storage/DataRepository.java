package storage;
import java.util.ArrayList;
import java.util.List;

public class DataRepository
{

    private List<SensorData>dataRecords = new ArrayList<>();
    private DataRepository()
    {

    }

    public static DataRepository instance;
    public static DataRepository getInstance()
    {
        if(instance == null)
        {
            instance = new DataRepository();
        }
        return instance;
    }

    public void addData(SensorData dataRecord)
    {
        dataRecords.add(dataRecord);
    }

    public List<SensorData> getRecords()
    {
        return dataRecords;
    }
}


