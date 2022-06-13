import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//import java.io.PrintWriter; logowanie zdarzeń do pliku
//import java.io.FileWriter; logowanie zdarzeń do pliku
public class Battlefield {
    static int width=16;
    static int height=10;
    static int villages=5;
    static int minefield=4;
    static int division=10;
    static boolean win=false;
    static Place place[][] = new Place[height][width];
    static ArrayList<Division> dywizje = new ArrayList<>();
    static ArrayList<Integer> arrayTanks = new ArrayList<>();
    static ArrayList<Integer> arraySoldiers = new ArrayList<>();
    static ArrayList<Integer> arrayTypeSoldiers = new ArrayList<>();
    static ArrayList<Integer> arrayTypeTanks = new ArrayList<>();
    static ArrayList<Integer> arrayTeam = new ArrayList<>();


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj wysokość planszy:");
            height = scanner.nextInt();
            System.out.println("Podaj szerokość planszy");
            width = scanner.nextInt();
            System.out.println("Podaj ilość pól minowych:");
            minefield = scanner.nextInt();
            System.out.println("Podaj ilość wiosek:");
            villages = scanner.nextInt();
            System.out.println("Podaj całkowitą ilość dywizji:");
            division = scanner.nextInt();
            System.out.println("Schemat wyboru dla dywizji: \nCyfra jeden - drużyna niebieska, Cyfra 2 - drużyna czerwona\nWybór żołnierzy: cyfra 1 - (50hp, broń: m4a1 - 20 dmg),  " +
                    "cyfra 2 - (100hp, broń: AK-47 - 15 dmg),  cyfra 3 - (150hp, broń: glock-17 - 10dmg)\nWybór czołgów: cyfra 1 - (T-55 - 2000hp, 100dmg)" +
                    "  cyfra 2 - (M1 Abrams - 1500hp, 150 dmg)\nSchemat zapisu informacji");
            for(int i=0;i<division;i++){
                System.out.println("Wybierz drużynę dywizji "+ (i+1)+":");
                arrayTeam.add(i, scanner.nextInt());
                System.out.println("Wybierz liczbę żołnierzy: ");
                arraySoldiers.add(i, scanner.nextInt());
                System.out.println("Wybierz typ żołnierzy: ");
                arrayTypeSoldiers.add(i, scanner.nextInt());
                System.out.println("Wybierz ilość czołgów: ");
                arrayTanks.add(i, scanner.nextInt());
                System.out.println("Wybierz typ czołgów:");
                arrayTypeTanks.add(i, scanner.nextInt());
            }
        generateBattlefield();
        
        // FileWriter plik=new FileWriter("BattleResultsLog.txt",true);
        // PrintWriter out=new PrintWriter(plik);
        
        int dayCounter=0;
            while(!win){
                moveDivisions();
                boolean team1=false;
                boolean team2=false;
                for(Division division : dywizje){
                    System.out.println(division.units.size());
                    
                    //out.println("Rozmiar dywizji" + " : " + division.units.size()); przykładowy zapis
					//out.println();
                    
                    if(division.team==false){
                        team1=true;
                        System.out.println("Masa1");
                    }else {team2=true;
                        System.out.println("Jesi");}
                }
                dayCounter++;
                System.out.println(dayCounter);
                System.out.println(dywizje.size());
                if(team1==false || team2==false){
                    win=true;
                    System.out.println("Wygrana");
                    
                    // out.close();
                    
                }
            }


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
                boolean temp;
                switch(arrayTeam.get(i)){
                    case 1:{
                        temp=false;
                        break;
                    }
                    default:{
                        temp=true;
                    }
                }
                System.out.println(temp);
                Division division = new Division(randomX,randomY,arrayTypeTanks.get(i),arrayTypeSoldiers.get(i),arrayTanks.get(i),arraySoldiers.get(i),temp);
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
                        divisionMoved(division);
                        place[division.y][division.x] = division;
                    }}
                case 1:{
                    if(division.x<width-1 && division.y<height-1 && !(place[division.y+1][division.x+1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x++;
                        division.y++;
                        divisionMoved(division);
                        place[division.y][division.x] = division;
                    }}
                case 2:{
                    if(division.x>0 && division.y<height-1 && !(place[division.y+1][division.x-1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x--;
                        division.y++;
                        divisionMoved(division);
                        place[division.y][division.x] = division;
                    }}
                case 3:{
                    if(division.x<width-1 && division.y>0 && !(place[division.y-1][division.x+1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x++;
                        division.y--;
                        divisionMoved(division);
                        place[division.y][division.x] = division;
                    }}
                case 4:{
                    if(division.x>0 && !(place[division.y][division.x-1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x--;
                        divisionMoved(division);
                        place[division.y][division.x] = division;
                    }}
                case 5:{
                    if(division.x<width-1  && !(place[division.y][division.x+1] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.x++;
                        divisionMoved(division);
                        place[division.y][division.x] = division;
                    }}
                case 6:{
                    if(division.y>0 && !(place[division.y-1][division.x] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.y--;
                        divisionMoved(division);
                        place[division.y][division.x] = division;
                    }}
                case 7:{
                    if(division.y<height-1 && !(place[division.y+1][division.x] instanceof Village)){
                        place[division.y][division.x] = new Empty(division.x, division.y);
                        division.y++;
                        divisionMoved(division);
                        place[division.y][division.x] = division;
                    }}
                default: break;
            }}}
    public static void divisionMoved(Division division){
        int x = division.x;
        int y = division.y;
        if(place[y][x] instanceof Minefield){
            for(Unit unit : division.units){
                unit.hp *= 0.8;
            }
        }
        if(place[y][x] instanceof Division){
            if(((Division) place[y][x]).team == division.team){
                mergeDivisions(division,(Division)place[y][x]);
            }else{
                battle(division,(Division)place[y][x]);
            }
        }
    }
    public static void mergeDivisions(Division division,Division division2){
        for(Unit unit : division2.units){
            division.units.add(unit);
        }
        dywizje.remove(division2);
    }
    public static void battle(Division division, Division division2){
        while(!division.units.isEmpty() || !division2.units.isEmpty()){
        int counter1 = 0;
        int counter2 = 0;
        for(Unit unit : division2.units){
            counter2 += unit.damage;
        }
        for(Unit unit : division.units){
            counter1 += unit.damage;
        }
        for(Unit unit : division2.units){
            if(unit.hp<counter1){
                counter1 -= unit.hp;
                division2.units.remove(unit);
            }else {
                unit.hp -= counter1;
            }
        }
        for(Unit unit : division.units){
            if(unit.hp<counter2){
                counter2 -= unit.hp;
                division.units.remove(unit);
            }else{
                unit.hp -= counter2;
            }
        }
    }
        if(division.units.isEmpty()){
            dywizje.remove(division);
        }else {
            dywizje.remove(division2);
        }
    }

    }
