import javax.swing.*;

public class badGuy {
    diceVar dvar = new diceVar();

    String name;
    int health;
    int attack;
    ImageIcon[] enemyList = {dvar.enemy1,dvar.enemy2,dvar.enemy3};


    badGuy(String name, int health, int attack){
        this.name = name;
        this.health = health;
        this.attack = attack;
        generateEnemy();
    }
    public void generateEnemy(){
        for (int i = 0; i < enemyList.length; i++){
            int index = (int)(Math.random() * enemyList.length);

            ImageIcon temp = enemyList[0];
            enemyList[0] = enemyList[index];
            enemyList[index] = temp;
        }


    }


}
