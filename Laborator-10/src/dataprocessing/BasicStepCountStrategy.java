package dataprocessing;

import storage.SensorData;

public class BasicStepCountStrategy implements StepCountStrategy {

    private int stepCount = 0;
    @Override
    public void consumeMessage(SensorData sample) {
        stepCount += sample.getStepsCount();
    }

    @Override
    public int getTotalSteps() {
        return stepCount;
    }

    @Override
    public String getStrategyDescription() {
        return " strategia care numara toti pasi";
    }
}
