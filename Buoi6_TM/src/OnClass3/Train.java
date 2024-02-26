package OnClass3;

public class Train extends Transport{
    private final double speedTrain = 40;

    @Override
    public double time(double distance) {
        return (distance / speedTrain);
    }
}
