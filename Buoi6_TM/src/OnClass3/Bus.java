package OnClass3;



public class Bus extends Transport{
    private double distance;

    @Override
    public double time(double distance) {
        return (distance / Constant.SPEED_BUS);
    }
}
