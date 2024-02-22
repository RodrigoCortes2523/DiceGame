import javax.swing.*;

public class diceVar{
    JFrame window;
    JPanel lifebarPanel,coinPanel,enemyStatPanel,backgroundPanel,statPanel,shopPanel,actionPanel,enemyLifebarPanel;
    JLabel backgroundLabel,diceLabel,lootLabel,axeLabel,gladiusLabel,shieldLabel,coinLabel,diceBorderLabel,playerLabel,armorTextLabel,coinTextLabel, sShieldLabel,enemyLabel,currentRollLabel;
    JTextArea lifebarText,buffText,armorText,coinAmountText,coinText,enemyLifebarText, enemyAttackText,enemyAttackAmount;
    JProgressBar lifebar,enemyLifebar;
    JButton shopButton,exitButton,rollButton,keepButton,endButton,inventoryButton,optionsButton,lootButton;
    JPopupMenu popMenu;


    ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\backgrounds\\b3.png");

    ImageIcon diceInventory = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\inventorydice.png");
    ImageIcon inventoryBorderIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\inventoryborder.png");
    ImageIcon lootInventory = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\inventory2x2.png");

    ImageIcon axeIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\battleAxe.png");
    ImageIcon gladiusIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\gladius.png");
    ImageIcon shieldIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\roundShield.png");
    ImageIcon coinIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\crownCoin.png");
    ImageIcon sShieldIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\shield.png");

    ImageIcon playerIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\Characters\\blueHeroRight.png");
    ImageIcon enemy1 = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\chibi\\minotaur1Idle2.png");
    ImageIcon enemy2 = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\chibi\\minotaur2Idle2.png");
    ImageIcon enemy3 = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\chibi\\minotaur3Idle2.png");


    ImageIcon redButtonIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\yellowMButton.png");
    ImageIcon greyButtonIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\greyButton.png");

    ImageIcon lolli = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\moreHalloweenIcons\\64x64\\15.png");
    ImageIcon pLollis = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\moreHalloweenIcons\\64x64\\22.png");
    ImageIcon muffin = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\moreHalloweenIcons\\64x64\\20.png");
    ImageIcon pump = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\moreHalloweenIcons\\64x64\\1.png");
    ImageIcon werewolf = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\moreHalloweenIcons\\64x64\\46.png");
    ImageIcon owl = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\moreHalloweenIcons\\64x64\\49.png");

    int playerLife = 100;
    int rollAmount = 2;
    int diceNumber = 1;
    int enemyHP = 100;
    int swordDamage = 25;
    int axdDamage = 50;
    int blockAmount = 10;
    int coinAmount = 0;
    int enemyDamage = 10;
    int sugarRushDamage = 15;
}
