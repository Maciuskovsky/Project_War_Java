import java.util.ArrayList;

public class Division extends Place {
    boolean team;
    Division(int x,int y, int typeOfTank, int typeOfSoldier,int amountOfTanks, int amountOfSoldiers, boolean team){
        super(x,y);
        this.team=team;
        for(int i=0;i<amountOfTanks;i++){
            Tank tank = new TypeTank(x,y,typeOfTank);
            units.add(tank);
        }
        for(int i=0;i<amountOfSoldiers;i++){
            Soldier soldier = new TypeSoldier(x,y,typeOfSoldier);
            units.add(soldier);
        }
    }
    ArrayList<Unit> units = new ArrayList<>();



}
