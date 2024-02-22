import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inventoryWindow {
    JFrame iWindow;
    JButton inventoryCloseButton;
    JLabel inventoryLabel;
    ImageIcon inventoryIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\inventory6x5Borderless.png");
    ImageIcon greyButtonIcon = new ImageIcon("C:\\Users\\Rod\\Desktop\\Code Resourses\\resizedImages\\greyButton.png");
    ImageIcon lolli = new ImageIcon("C:\\Users\\Rod\\Desktop\\RodAssets\\moreHalloweenIcons\\64x64\\15.png");
    inventoryWindow() {
        createIWindow();
    }

    public void createIWindow(){

        iWindow = new JFrame();
        iWindow.setSize(406,440);
        iWindow.getContentPane().setBackground(Color.black);
        iWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        iWindow.setLocationRelativeTo(iWindow);
        iWindow.setLayout(null);
//        iWindow.setUndecorated(true);
        iWindow.setResizable(true);
        iWindow.setVisible(false);

        inventoryLabel = new JLabel();
        inventoryLabel.setIcon(inventoryIcon);
        inventoryLabel.setBounds(0,0,394,350);
        inventoryLabel.setLayout(new GridLayout(5,6));
        iWindow.add(inventoryLabel);

        inventoryCloseButton = new JButton("Close");
        inventoryCloseButton.setHorizontalTextPosition(JButton.CENTER);
        inventoryCloseButton.setFont(new Font("Book Antiqua",Font.PLAIN,24));
        inventoryCloseButton.setIcon(greyButtonIcon);
        inventoryCloseButton.setBounds(125,350,150,50);
        inventoryCloseButton.setBorder(null);
        inventoryCloseButton.setFocusable(false);
        inventoryCloseButton.setContentAreaFilled(false);
        inventoryCloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==inventoryCloseButton){
                    iWindow.setVisible(false);
                }
            }
        });
        iWindow.add(inventoryCloseButton);



    }
}
