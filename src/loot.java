import javax.swing.*;

public class loot {
    diceVar dvar = new diceVar();

    JLabel lolliLabel,werewolfLabel, plollislabel,muffinLabel,pumpLabel,owlLabel;
    ImageIcon[] lootList = {dvar.lolli,dvar.werewolf,dvar.pLollis,dvar.muffin,dvar.pump,dvar.owl};


    loot(){
        generateLoot();

    }

    public void generateLoot(){
        for (int i = 0; i < lootList.length; i++){
            int index = (int)(Math.random() * lootList.length);

            ImageIcon temp = lootList[0];
            lootList[0] = lootList[index];
            lootList[index] = temp;
        }

//        if (lootList[0] == dvar.lolli) {
//            lolliLabel = new JLabel();
//            lolliLabel.setIcon(dvar.lolli);
//            dvar.lootLabel.add(lolliLabel);
//            lolliLabel.setToolTipText("this is a lolli");
//        }
//        else if (lootList[0] == dvar.werewolf){
//            werewolfLabel = new JLabel();
//            werewolfLabel.setIcon(dvar.werewolf);
//            dvar.lootLabel.add(werewolfLabel);
//            werewolfLabel.setToolTipText("this is a werewolf");
//        }
    }
    public void createLootLabel(){

    }


}
