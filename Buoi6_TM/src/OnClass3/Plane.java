package OnClass3;

public class Plane extends Transport{
    private final double speedPlane = 80;

    @Override
    public double time(double distance) {
        return (distance / speedPlane);
    }
}
