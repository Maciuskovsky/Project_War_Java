import java.util.List;
import java.util.Random;

public class Position {
    static Map mapSize = new Map(50,50);
    //List<Integer>

    static Map getMapSize() {
        return mapSize;
    }
    public int getLength(){
        return Map.sizeLength;
    }
    public int getWidth(){
        return Map.sizeWidth;
    }
    public static void main(String[] args){
        System.out.println(getMapSize());
        System.out.println("Test1");
    }

    public void changePosition() {
        int numberOfSteps;
        //maxSteps z klasy jednostek ile kroków mogą wykonać
        int maxSteps = 3;
        int positionX = 10;
        int positionY = 12;
        for (numberOfSteps = 0;numberOfSteps<maxSteps;) {
            int step;
            Random walk = new Random();
            step = walk.nextInt(4);
            switch (step) {
                case 0:
                    if(positionX<=getLength()){
                    positionX++;
                    numberOfSteps++;
                    break;
                    } else break;
                case 1:
                    if(positionY<=getWidth()) {
                        positionY++;
                        numberOfSteps++;
                        break;
                    } else break;
                case 2:
                    if(positionX>=0) {
                        positionX--;
                        numberOfSteps++;
                        break;
                    } else break;
                case 3:
                    if(positionY>=0) {
                        positionY--;
                        numberOfSteps++;
                        break;
                    } else break;
            }
        }
    }

}
