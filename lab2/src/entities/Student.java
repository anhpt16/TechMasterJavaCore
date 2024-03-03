package entities;

public class Student {
    private int id;
    private String name;
    private double scoreMath, scorePhysic, scoreChemistry;
    public static int autoIncrease = 1;

    public Student(String name, double scoreMath, double scorePhysic, double scoreChemistry) {
        this.id = autoIncrease;
        this.name = name;
        this.scoreMath = scoreMath;
        this.scorePhysic = scorePhysic;
        this.scoreChemistry = scoreChemistry;
        autoIncrease++;
    }

    public double getScoreMath() {
        return scoreMath;
    }

    public double getScorePhysic() {
        return scorePhysic;
    }

    public double getScoreChemistry() {
        return scoreChemistry;
    }

    public double averageScore(double scoreMath, double scorePhysic, double scoreChemistry){
        return (scoreMath + scorePhysic + scoreChemistry)/3;
    }

    public String level(double scoreMath, double scorePhysic, double scoreChemistry){
        double avgScore = (scoreMath + scorePhysic + scoreChemistry)/3;
        if (avgScore >= 8)
            return "A";
        else if (avgScore < 8 && avgScore >= 6.5)
            return "B";
        else
            return "C";
    }

    @Override
    public String toString() {
        return "Id: " + id + "\t,Name: " + name + "\t,Avg: " + averageScore(scoreMath, scorePhysic, scoreChemistry)
                + "\t,Xếp Loại: " + level(scoreMath, scorePhysic, scoreChemistry);
    }
}
