import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class diceUI extends diceVar{
    Main mm;
    inventoryWindow IW = new inventoryWindow();
    loot ltt = new loot();
    badGuy bad1 = new badGuy("Minotaur",100,10);

    public diceUI(Main mm){
        this.mm = mm;
        createUI();
    }
    public void createUI(){
        drawFrame();
        drawPanels();
        drawText();
        drawBars();
        drawLabels();
        drawButtons();
        drawPopupMenus();

        drawBackground();

        window.setVisible(true);
    }

    public void drawFrame(){
        window = new JFrame();
        window.setSize(1000,900);
        window.setTitle("Dice Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
    }
    public void drawBackground(){

        Container pain = window.getContentPane();
        backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundIcon);
        pain.add(backgroundLabel);
    }
    public void drawPanels(){
        statPanel = new JPanel();
        statPanel.setBounds(300,700,225,40);
        statPanel.setBackground(Color.blue);
        statPanel.setOpaque(true);
        statPanel.setLayout(new GridLayout(1,2));
        window.add(statPanel);

        coinPanel = new JPanel();
        coinPanel.setBounds(300,775,200,40);
        coinPanel.setBackground(Color.yellow);
        coinPanel.setLayout(new GridLayout(1,2));
        coinPanel.setOpaque(false);
        window.add(coinPanel);

        shopPanel = new JPanel();
        shopPanel.setBounds(20,200,350,180);
        shopPanel.setBackground(null);
        shopPanel.setOpaque(false);
        shopPanel.setLayout(new GridLayout(2,2));
        window.add(shopPanel);

        actionPanel = new JPanel();
        actionPanel.setBounds(530,430,150,200);
        actionPanel.setOpaque(false);
        actionPanel.setLayout(new GridLayout(4,1));
        window.add(actionPanel);

        enemyStatPanel = new JPanel();
        enemyStatPanel.setBounds(700,700,225,40);
        enemyStatPanel.setBackground(Color.black);
        enemyStatPanel.setOpaque(true);
        enemyStatPanel.setLayout(new GridLayout(1,2));
        window.add(enemyStatPanel);


    }
    public void drawLabels(){
        playerLabel = new JLabel();
        playerLabel.setBounds(295,450,245,200);
        playerLabel.setIcon(playerIcon);
        window.add(playerLabel);

        enemyLabel = new JLabel();
        enemyLabel.setBounds(700,450,245,200);
        enemyLabel.setIcon(enemy1);
        window.add(enemyLabel);

        diceLabel = new JLabel();
        diceLabel.setLayout(new GridLayout(3,2));
        diceLabel.setBackground(Color.orange);
        diceLabel.setOpaque(true);
        diceLabel.setBounds(20,468,256,384);
        diceLabel.setIcon(diceInventory);
        window.add(diceLabel);

        diceBorderLabel = new JLabel();
        diceBorderLabel.setIcon(inventoryBorderIcon);
        diceBorderLabel.setOpaque(true);
        diceBorderLabel.setBounds(0,450,295,415);
        window.add(diceBorderLabel);

        axeLabel = new JLabel();
        axeLabel.setIcon(axeIcon);
        diceLabel.add(axeLabel);

        shieldLabel = new JLabel();
        shieldLabel.setIcon(shieldIcon);
        diceLabel.add(shieldLabel);

        gladiusLabel = new JLabel();
        gladiusLabel.setIcon(gladiusIcon);
        diceLabel.add(gladiusLabel);

        coinLabel = new JLabel();
        coinLabel.setIcon(coinIcon);
        diceLabel.add(coinLabel);

        shieldLabel = new JLabel();
        shieldLabel.setIcon(shieldIcon);
        diceLabel.add(shieldLabel);

        gladiusLabel = new JLabel();
        gladiusLabel.setIcon(gladiusIcon);
        diceLabel.add(gladiusLabel);

        currentRollLabel = new JLabel();
        currentRollLabel.setBounds(540,300,128,128);
        currentRollLabel.setOpaque(false);
        currentRollLabel.setIcon(gladiusIcon);
        window.add(currentRollLabel);

        sShieldLabel = new JLabel();
        sShieldLabel.setIcon(sShieldIcon);
        sShieldLabel.setVisible(false);
        statPanel.add(sShieldLabel);

        lootLabel = new JLabel();
        lootLabel.setBounds(750,250,145,135);
        lootLabel.setIcon(lootInventory);
        lootLabel.setLayout(new GridLayout(2,2));
        lootLabel.setOpaque(true);
        lootLabel.setVisible(false);
        window.add(lootLabel);

    }
    public void drawBars(){
        lifebarPanel = new JPanel();
        lifebarPanel.setBounds(300,660,300,30);
        lifebarPanel.setBackground(null);
        lifebarPanel.setLayout(new GridLayout(1,1));
        window.add(lifebarPanel);

        lifebar = new JProgressBar(0,playerLife);
        lifebar.setPreferredSize(new Dimension(300,30));
        lifebar.setValue(playerLife);
        lifebar.setBorderPainted(false);
        lifebar.setForeground(Color.red);
        lifebar.setBackground(Color.darkGray);
        lifebarPanel.add(lifebar);

        enemyLifebarPanel = new JPanel();
        enemyLifebarPanel.setBounds(680,660,300,30);
        enemyLifebarPanel.setBackground(null);
        enemyLifebarPanel.setLayout(new GridLayout(1,1));
        window.add(enemyLifebarPanel);

        enemyLifebar = new JProgressBar();
        enemyLifebar.setPreferredSize(new Dimension(300,30));
        enemyLifebar.setValue(enemyHP);
        enemyLifebar.setBorderPainted(false);
        enemyLifebar.setForeground(Color.red);
        enemyLifebar.setBackground(Color.darkGray);
        enemyLifebar.setStringPainted(true);
        enemyLifebarPanel.add(enemyLifebar);
    }
    public void drawText(){
        lifebarText = new JTextArea(String.valueOf(playerLife));
        lifebarText.setBounds(415,660,75,25);
        lifebarText.setOpaque(false);
        lifebarText.setEditable(false);
        lifebarText.setFocusable(false);
        lifebarText.setForeground(Color.white);
        lifebarText.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        window.add(lifebarText);

        enemyLifebarText = new JTextArea(String.valueOf("HP: "+enemyHP));
        enemyLifebarText.setBounds(700,630,220,25);
        enemyLifebarText.setOpaque(false);
        enemyLifebarText.setEditable(false);
        enemyLifebarText.setFocusable(false);
        enemyLifebarText.setForeground(Color.white);
        enemyLifebarText.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        window.add(enemyLifebarText);


        armorText = new JTextArea("Armor: ");
        armorText.setFont(new Font("Book Antiqua",Font.PLAIN,32));
        armorText.setForeground(Color.white);
        armorText.setFocusable(false);
        armorText.setEditable(false);
        armorText.setOpaque(false);
        statPanel.add(armorText);

        coinText = new JTextArea("Coins: ");
        coinText.setFont(new Font("Book Antiqua",Font.PLAIN,32));
        coinText.setForeground(Color.white);
        coinText.setFocusable(false);
        coinText.setEditable(false);
        coinText.setOpaque(false);
        coinPanel.add(coinText);

        coinAmountText = new JTextArea(""+coinAmount);
        coinAmountText.setFont(new Font("Book Antiqua",Font.PLAIN,32));
        coinAmountText.setForeground(Color.white);
        coinAmountText.setFocusable(false);
        coinAmountText.setEditable(false);
        coinAmountText.setOpaque(false);
        coinPanel.add(coinAmountText);

        enemyAttackText = new JTextArea("Attack: ");
        enemyAttackText.setFont(new Font("Book Antiqua",Font.PLAIN,32));
        enemyAttackText.setForeground(Color.white);
        enemyAttackText.setFocusable(false);
        enemyAttackText.setEditable(false);
        enemyAttackText.setOpaque(false);
        enemyStatPanel.add(enemyAttackText);

        enemyAttackAmount = new JTextArea(String.valueOf(bad1.attack));
        enemyAttackAmount.setFont(new Font("Book Antiqua",Font.PLAIN,32));
        enemyAttackAmount.setForeground(Color.white);
        enemyAttackAmount.setFocusable(false);
        enemyAttackAmount.setEditable(false);
        enemyAttackAmount.setOpaque(false);
        enemyStatPanel.add(enemyAttackAmount);

        buffText = new JTextArea();
        buffText.setFont(new Font("Book Antiqua",Font.PLAIN,32));
        buffText.setBounds(295,420,230,45);
        buffText.setForeground(Color.white);
        buffText.setFocusable(false);
        buffText.setEditable(false);
        buffText.setOpaque(false);
        window.add(buffText);


    }
    public void drawButtons(){
        shopButton = new JButton();
        shopButton.setText("Shop");
        shopButton.setHorizontalTextPosition(JButton.CENTER);
        shopButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        shopButton.setIcon(redButtonIcon);
        shopButton.addActionListener(mm.dHandler);
        shopButton.setContentAreaFilled(false);
        shopButton.setFocusable(false);
        shopButton.setBorder(null);
        shopPanel.add(shopButton);

        inventoryButton = new JButton("Inventory");
        inventoryButton.setIcon(greyButtonIcon);
        inventoryButton.setHorizontalTextPosition(JButton.CENTER);
        inventoryButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        inventoryButton.setContentAreaFilled(false);
        inventoryButton.addActionListener(mm.dHandler);
        inventoryButton.setFocusable(false);
        inventoryButton.setBorder(null);
        shopPanel.add(inventoryButton);

        optionsButton = new JButton("Options");
        optionsButton.setIcon(greyButtonIcon);
        optionsButton.setHorizontalTextPosition(JButton.CENTER);
        optionsButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        optionsButton.setContentAreaFilled(false);
        optionsButton.addActionListener(mm.dHandler);
        optionsButton.setFocusable(false);
        optionsButton.setBorder(null);
        shopPanel.add(optionsButton);

        exitButton = new JButton("Exit");
        exitButton.setIcon(greyButtonIcon);
        exitButton.setHorizontalTextPosition(JButton.CENTER);
        exitButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusable(false);
        exitButton.addActionListener(mm.dHandler);
        exitButton.setBorder(null);
        shopPanel.add(exitButton);

        rollButton = new JButton();
        rollButton.setText("Roll "+rollAmount);
        rollButton.setIcon(greyButtonIcon);
        rollButton.setHorizontalTextPosition(JButton.CENTER);
        rollButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        rollButton.setContentAreaFilled(false);
        rollButton.addActionListener(mm.dHandler);
        rollButton.setToolTipText("Roll the dice");
        rollButton.setFocusable(false);
        rollButton.setBorder(null);
        actionPanel.add(rollButton);

        keepButton = new JButton("Keep");
        keepButton.setIcon(greyButtonIcon);
        keepButton.setHorizontalTextPosition(JButton.CENTER);
        keepButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        keepButton.setContentAreaFilled(false);
        keepButton.addActionListener(mm.dHandler);
        keepButton.setFocusable(false);
        keepButton.setBorder(null);
        actionPanel.add(keepButton);

        endButton = new JButton("End Turn");
        endButton.setIcon(greyButtonIcon);
        endButton.setHorizontalTextPosition(JButton.CENTER);
        endButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));;
        endButton.setContentAreaFilled(false);
        endButton.addActionListener(mm.dHandler);
        endButton.setFocusable(false);
        endButton.setBorder(null);
        actionPanel.add(endButton);

        lootButton = new JButton("Loot");
        lootButton.setBounds(750,375,150,78);
        lootButton.setHorizontalTextPosition(JButton.CENTER);
        lootButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        lootButton.setContentAreaFilled(false);
        lootButton.setFocusable(false);
        lootButton.setBorder(null);
        lootButton.addActionListener(mm.dHandler);
        lootButton.setVisible(false);
        lootButton.setIcon(greyButtonIcon);
        window.add(lootButton);


    }
    public void drawPopupMenus(){
        popMenu = new JPopupMenu();
        JMenuItem[] menuItem = new JMenuItem[3];
        menuItem[1] = new JMenuItem("Eat");
        menuItem[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("you used the item");
                mm.dHandler.removeLolliLabel();
                mm.dHandler.sugarrush = true;
                buffText.setText("SUGAR RUSH!!");
            }
        });
        popMenu.add(menuItem[1]);






    }
}
