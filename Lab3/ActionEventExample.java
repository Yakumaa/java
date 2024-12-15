// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

// class JavaEv extends JFrame{
//     JLabel l1,l2,l3;
//     JRadioButton r1,r2;
//     ButtonGroup bg;
//     JButton b1;
//      JavaEv(){
//         l1=new JLabel("Gender: ");
//         l3=new JLabel("Result for Action event: ");
//          bg=new ButtonGroup();
//         r1=new JRadioButton("Radio Button 1");
//         r2=new JRadioButton("Radio Button 2");
//         bg.add(r1);
//         bg.add(r2);
//         b1=new JButton("Button 1");
//          add(b1);
//         add(l1);
//         add(r1);
//         add(r2);
//         r1.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 l3.setText("Action result: " + r1.getText() + " Selected");
//             }
//         });
//         r2.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 l3.setText("Action result: " + r2.getText() + " Selected");
//             }
//         });
//         b1.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e){
//                 l3.setText(b1.getText()+" Clicked");
//             }
//         });
//         setVisible(true);
//         setDefaultCloseOperation(3);
//         setLayout(new FlowLayout());
//         setSize(500,500);
//   }         
// }

// public class ActionEventExample {
//   public static void main(String[] args) {
//     JavaEv ev=new JavaEv();
//  }

// }


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Action Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Create radio buttons
        JRadioButton option1 = new JRadioButton("Option 1");
        JRadioButton option2 = new JRadioButton("Option 2");
        JRadioButton option3 = new JRadioButton("Option 3");

        // Group the radio buttons so only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        // Create a button
        JButton submitButton = new JButton("Submit");

        // Create a label to display the result
        JLabel resultLabel = new JLabel("Select an option and click Submit");

        // Add ActionListener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (option1.isSelected()) {
                    resultLabel.setText("You selected: Option 1");
                } else if (option2.isSelected()) {
                    resultLabel.setText("You selected: Option 2");
                } else if (option3.isSelected()) {
                    resultLabel.setText("You selected: Option 3");
                } else {
                    resultLabel.setText("No option selected!");
                }
            }
        });

        // Add components to the frame
        frame.add(option1);
        frame.add(option2);
        frame.add(option3);
        frame.add(submitButton);
        frame.add(resultLabel);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
