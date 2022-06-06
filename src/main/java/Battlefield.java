import java.util.ArrayList;
import java.util.Random;

public class Battlefield {
    static int width=16;
    static int height=10;
    static int villages=5;
    static int minefield=4;
    static int division=10;
    static Place place[][] = new Place[height][width];
    static ArrayList<Division> dywizje = new ArrayList<>();


    public static void main(String[] args){
        generateBattlefield();

    }
    public static void generateBattlefield(){
        Random random = new Random();
        for(int y=0;y<height;y++) {
            for(int x=0;x<width;x++){
            place[y][x]=new Empty(x,y);
            }
        }
        for(int i=0;i<villages;i++) {
            int randomX = random.nextInt(width);
            int randomY = random.nextInt(height);
            if(place[randomY][randomX] instanceof Empty){
                place[randomY][randomX] = new Village(randomX,randomY);
            }
        }
        for(int i=0;i<minefield;i++) {
            int randomX = random.nextInt(width);
            int randomY = random.nextInt(height);
            if(place[randomY][randomX] instanceof Empty){
                place[randomY][randomX] = new Minefield(randomX,randomY);
            }
        }
        for(int i=0;i<division;i++) {
            int randomX = random.nextInt(width);
            int randomY = random.nextInt(height);
            if (place[randomY][randomX] instanceof Empty) {
                Division division = new Division(randomX,randomY);
                dywizje.add(division);
                place[randomY][randomX] = division;
            }
        }
    }
    public static void moveDivisions(){
        Random random = new Random();
        for(Division division : dywizje){
            int randomNumber = random.nextInt(9);
            switch (randomNumber){
                case 0:{
                    if(division.x>0 && division.y>0 && !(place[division.y-1][division.x-1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x--;
                        division.y--;
                        place[division.y][division.x] = division;
                        divisionMoved();
                    }}
                case 1:{
                    if(division.x<width-1 && division.y<height-1 && !(place[division.y+1][division.x+1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x++;
                        division.y++;
                        place[division.y][division.x] = division;
                        divisionMoved();
                    }}
                case 2:{
                    if(division.x>0 && division.y<height-1 && !(place[division.y+1][division.x-1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x--;
                        division.y++;
                        place[division.y][division.x] = division;
                        divisionMoved();
                    }}
                case 3:{
                    if(division.x<width-1 && division.y>0 && !(place[division.y-1][division.x+1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x++;
                        division.y--;
                        place[division.y][division.x] = division;
                        divisionMoved();
                    }}
                case 4:{
                    if(division.x>0 && !(place[division.y][division.x-1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x--;
                        place[division.y][division.x] = division;
                        divisionMoved();
                    }}
                case 5:{
                    if(division.x<width-1  && !(place[division.y][division.x+1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x++;
                        place[division.y][division.x] = division;
                        divisionMoved();
                    }}
                case 6:{
                    if(division.y>0 && !(place[division.y-1][division.x] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.y--;
                        place[division.y][division.x] = division;
                        divisionMoved();
                    }}
                case 7:{
                    if(division.y<height-1 && !(place[division.y+1][division.x] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.y++;
                        place[division.y][division.x] = division;
                        divisionMoved();
                    }}
                default: break;
            }}}
    public static void divisionMoved(Division division){
        int x = division.x;
        int y = division.y;
        if(place[y][x] instanceof Minefield){

        }
    }
    }



    }
