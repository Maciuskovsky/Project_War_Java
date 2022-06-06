public class TypeSoldier extends Soldier{

    TypeSoldier(int hp, int damage, int typeOfSoldier) {
        super(hp, damage);

        switch(typeOfSoldier){
            case 1:{
                hp = 50;
                damage = 20;
                break;
            }
            case 2:{
                hp = 100;
                damage = 15;
                break;
            }
            default:{
                hp = 150;
                damage = 10;
            }
        }
    }
}
