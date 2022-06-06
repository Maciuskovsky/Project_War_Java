public class TypeTank extends Tank {


    TypeTank(int hp, int damage, int typeOfTank) {
        super(hp, damage);

        switch(typeOfTank){
            case 1:{
                hp = 1500;
                damage = 150;
                break;
            }
            default:{
                hp = 2000;
                damage = 100;
            }
        }
    }
}
