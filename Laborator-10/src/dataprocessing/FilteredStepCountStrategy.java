package dataprocessing;

import storage.DataRepository;
import storage.SensorData;

import java.util.List;
import java.util.stream.Collectors;

public class FilteredStepCountStrategy implements StepCountStrategy {

    private int stepCount = 0;
    @Override
    public void consumeMessage(SensorData sample) {
        if (sample.getStepsCount() <= 0) {
            return;
        }

        long oneMinuteAgo = sample.getTimestamp() - 60000;

        // Folosim doar înregistrările anterioare acestui sample, nu toate!
        List<SensorData> lastMinuteRecords = DataRepository.getInstance().getRecords().stream()
                .filter(d -> d.getTimestamp() >= oneMinuteAgo && d.getTimestamp() <= sample.getTimestamp())
                .collect(Collectors.toList());

        int stepsInLastMinute = lastMinuteRecords.stream()
                .mapToInt(SensorData::getStepsCount)
                .sum();

        if (stepsInLastMinute <= 1000) {
            stepCount += sample.getStepsCount();
        }

    }
    @Override
    public int getTotalSteps() {
        return stepCount;
    }

    @Override
    public String getStrategyDescription() {
        return "strategia care numara doar pasii pozitivi si doar daca in ultimul minut nu s-au inregistrat mai mult de 1000 pasi";
    }
}
