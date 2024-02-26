package OnClass3;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Train train = new Train();
        Plane plane = new Plane();

        System.out.println("Thời gian bus: " + bus.time(20));
        System.out.println("Thời gian train: " + train.time(30));
        System.out.println("Thời gian plane: " + plane.time(40));
    }
}
