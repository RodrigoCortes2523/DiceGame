import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class diceHandler implements ActionListener {
    Main m;
    Random random = new Random();
    loot lt = new loot();
    inventoryWindow IW = new inventoryWindow();
    int lootCase = 0;
    boolean sugarrush = false;

    public diceHandler(Main m){
        this.m = m;
    }

    Timer enemyAttackTimer = new Timer(1200, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            enemyTurn();
            enemyAttackTimer.stop();
            rolling();
            playerTurn();
            m.dUi.sShieldLabel.setVisible(false);
        }
    });
    public void rolling() {
        int diceRoll = random.nextInt(6) + 1;
            if (diceRoll == 1 || diceRoll == 2) {
                m.dUi.currentRollLabel.setIcon(m.dUi.gladiusIcon);
                m.dUi.diceNumber = 1;
            }
            else if (diceRoll == 3 || diceRoll == 4) {
                m.dUi.currentRollLabel.setIcon(m.dUi.shieldIcon);
                m.dUi.diceNumber = 2;
            } else if (diceRoll == 5) {
                m.dUi.currentRollLabel.setIcon(m.dUi.axeIcon);
                m.dUi.diceNumber = 3;
            } else {
                m.dUi.currentRollLabel.setIcon(m.dUi.coinIcon);
                m.dUi.diceNumber = 4;
            }
            if (m.dUi.rollAmount == 0){
                m.dUi.rollButton.setEnabled(false);
        }
        }
    public void playerTurn(){
        m.dUi.rollButton.setEnabled(true);
        m.dUi.keepButton.setEnabled(true);
        m.dUi.endButton.setEnabled(true);
        m.dUi.rollAmount = 2;
        m.dUi.rollButton.setText("Roll "+ m.dUi.rollAmount);
        rolling();
    }
    public void enemyTurn(){
        m.dUi.playerLife = m.dUi.playerLife - m.dUi.enemyDamage;
        m.dUi.lifebar.setValue(m.dUi.playerLife);
        m.dUi.lifebarText.setText(String.valueOf(m.dUi.playerLife));
    }
    public void swordDamage(){
        if(sugarrush){
            m.dUi.enemyHP = m.dUi.enemyHP - (m.dUi.swordDamage + m.dUi.sugarRushDamage);
            sugarrush = false;
            m.dUi.buffText.setText("");
        }
        else {
            m.dUi.enemyHP = m.dUi.enemyHP - m.dUi.swordDamage;
        }
        m.dUi.enemyLifebar.setValue(m.dUi.enemyHP);
        m.dUi.rollButton.setEnabled(false);
        m.dUi.keepButton.setEnabled(false);
        m.dUi.enemyLifebarText.setText(String.valueOf(m.dUi.enemyHP));
    }
    public void axeDamage(){
        if(sugarrush){
            m.dUi.enemyHP = m.dUi.enemyHP - (m.dUi.axdDamage + m.dUi.sugarRushDamage);
            sugarrush = false;
            m.dUi.buffText.setText("");
        }
        else {
            m.dUi.enemyHP = m.dUi.enemyHP - m.dUi.axdDamage;
        }
        m.dUi.enemyLifebar.setValue(m.dUi.enemyHP);
        m.dUi.rollButton.setEnabled(false);
        m.dUi.keepButton.setEnabled(false);
        m.dUi.enemyLifebarText.setText(String.valueOf(m.dUi.enemyHP));

    }
    public void gainGold(){
        ++m.dUi.coinAmount;
        m.dUi.coinAmountText.setText(String.valueOf(m.dUi.coinAmount));
        m.dUi.rollButton.setEnabled(false);
        m.dUi.keepButton.setEnabled(false);
    }
    public void createNewBadGuy(){

        int attackRandom = random.nextInt(14) + 1;
        int lifeRandom = random.nextInt(200)+1;

        badGuy bad2 = new badGuy("Mino",lifeRandom,attackRandom);

        m.dUi.enemyLabel.setIcon(bad2.enemyList[0]);

        m.dUi.enemyHP = bad2.health;
        m.dUi.enemyLifebarText.setText(String.valueOf(m.dUi.enemyHP));
        m.dUi.enemyDamage = bad2.attack;
        m.dUi.enemyAttackAmount.setText(String.valueOf(m.dUi.enemyDamage));
        m.dUi.enemyLifebar.setMaximum(bad2.health);
        m.dUi.enemyLifebar.setValue(bad2.health);
    }
    public void removeLolliLabel(){
        IW.inventoryLabel.remove(lt.lolliLabel);
        IW.inventoryLabel.revalidate();
        IW.inventoryLabel.repaint();
    }
    public void generateLoot(){
        lt.generateLoot();

        if (lt.lootList[0] == lt.dvar.lolli) {
            lt.lolliLabel = new JLabel();
            lt.lolliLabel.setIcon(lt.dvar.lolli);
            m.dUi.lootLabel.add(lt.lolliLabel);
            lt.lolliLabel.setToolTipText("""
                    Lollipop:\s
                    This sweet lollipop gives you a slight rush.\s
                     Adds +15 to your next attack newline?""");
            lt.lolliLabel.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {
                    m.dUi.popMenu.show(lt.lolliLabel,e.getY(),e.getY());
                }
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
            });
            lootCase = 1;
        }
        else if (lt.lootList[0] == lt.dvar.werewolf){
            lt.werewolfLabel = new JLabel();
            lt.werewolfLabel.setIcon(lt.dvar.werewolf);
            m.dUi.lootLabel.add(lt.werewolfLabel);
            lt.werewolfLabel.setToolTipText("this is a werewolf");
            lootCase = 2;
        }
        else if (lt.lootList[0] == lt.dvar.pLollis) {
            lt.plollislabel = new JLabel();
            lt.plollislabel.setIcon(lt.dvar.pLollis);
            m.dUi.lootLabel.add(lt.plollislabel);
            lt.plollislabel.setToolTipText("this is a pLollis");
            lootCase = 3;
        }
        else if (lt.lootList[0] == lt.dvar.muffin) {
            lt.muffinLabel = new JLabel();
            lt.muffinLabel.setIcon(lt.dvar.muffin);
            m.dUi.lootLabel.add(lt.muffinLabel);
            lt.muffinLabel.setToolTipText("this is a muffin");
            lootCase = 4;
        }
        else if (lt.lootList[0] == lt.dvar.pump) {
            lt.pumpLabel = new JLabel();
            lt.pumpLabel.setIcon(lt.dvar.pump);
            m.dUi.lootLabel.add(lt.pumpLabel);
            lt.pumpLabel.setToolTipText("this is a pumpkin");
            lootCase = 5;
        }
        else if (lt.lootList[0] == lt.dvar.owl) {
            lt.owlLabel = new JLabel();
            lt.owlLabel.setIcon(lt.dvar.owl);
            m.dUi.lootLabel.add(lt.owlLabel);
            lt.owlLabel.setToolTipText("this is an owl");
            lootCase = 6;
        }


        m.dUi.lootButton.setVisible(true);
        m.dUi.lootLabel.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==m.dUi.exitButton){
            System.exit(0);
        }
        if (e.getSource()==m.dUi.inventoryButton){
            IW.iWindow.setVisible(true);
        }
        if (e.getSource()==m.dUi.rollButton){
            if (m.dUi.rollAmount > 0){
                m.dUi.rollAmount --;
                m.dUi.rollButton.setText("Roll "+m.dUi.rollAmount);
               rolling();
            }
            else {
                m.dUi.rollButton.setEnabled(false);
            }
        }
        if(e.getSource()==m.dUi.keepButton){
            if (m.dUi.diceNumber==1){
                swordDamage();
            }
            if(m.dUi.diceNumber==2){
                m.dUi.sShieldLabel.setVisible(true);
            }
            if(m.dUi.diceNumber==3){
                axeDamage();
            }
            if(m.dUi.diceNumber==4){
              gainGold();
            }
        }
        if(e.getSource()==m.dUi.endButton){
            if (m.dUi.enemyHP > 0) {
                enemyAttackTimer.start();
            }
            m.dUi.endButton.setEnabled(false);
            m.dUi.keepButton.setEnabled(false);
            m.dUi.rollButton.setEnabled(false);
            if(m.dUi.enemyHP <= 0){
                createNewBadGuy();
                generateLoot();
                playerTurn();
            }
        }
        if(e.getSource()==m.dUi.lootButton){
            switch (lootCase) {
                case 1:
                    IW.inventoryLabel.add(lt.lolliLabel);
                    m.dUi.lootLabel.remove(lt.lolliLabel);
                    m.dUi.lootLabel.validate();
                    m.dUi.lootLabel.repaint();
                    break;
                case 2:
                    IW.inventoryLabel.add(lt.werewolfLabel);
                    m.dUi.lootLabel.remove(lt.werewolfLabel);
                    m.dUi.lootLabel.validate();
                    m.dUi.lootLabel.repaint();
                    break;
                case 3:
                    IW.inventoryLabel.add(lt.plollislabel);
                    m.dUi.lootLabel.remove(lt.plollislabel);
                    m.dUi.lootLabel.validate();
                    m.dUi.lootLabel.repaint();
                    break;
                case 4:
                    IW.inventoryLabel.add(lt.muffinLabel);
                    m.dUi.lootLabel.remove(lt.muffinLabel);
                    m.dUi.lootLabel.validate();
                    m.dUi.lootLabel.repaint();
                    break;
                case 5:
                    IW.inventoryLabel.add(lt.pumpLabel);
                    m.dUi.lootLabel.remove(lt.pumpLabel);
                    m.dUi.lootLabel.validate();
                    m.dUi.lootLabel.repaint();
                    break;
                case 6:
                    IW.inventoryLabel.add(lt.owlLabel);
                    m.dUi.lootLabel.remove(lt.owlLabel);
                    m.dUi.lootLabel.validate();
                    m.dUi.lootLabel.repaint();
                    break;
            }


            m.dUi.lootButton.setVisible(false);
            m.dUi.lootLabel.setVisible(false);


        }
    }
}
