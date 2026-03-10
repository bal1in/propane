package finalthing;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.util.Arrays;
import javax.swing.JOptionPane;

public class graph extends Frame {
    //global variable so the input from the constructor can be passed to the paint method
    public String[][] Pinputs;
    
    public Color[] colours = {Color.blue, Color.cyan, Color.green, Color.magenta, Color.orange, Color.pink, Color.red, Color.yellow};

    //constructor
    public graph(String[][] inputs)
    {
        Pinputs = inputs;
        setVisible(true);
        setSize(640, 480);
        
        //this checks to see when the X button is pressed - when it is, destroy the window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                dispose();
            }
        });
    }
    //canvases are very strange
    //to display something you must override the default "paint" method
    //and it'll just do whatever you put in it automatically when the Frame is created
    //from what i can tell it just does not work inside a JFrame using netbeans' standard window generator
    @Override
    public void paint(Graphics g)
    {
        //import useful thing
        utils u = new utils();

        //finding the largest number in order to scale the graph to the window size
        double largest = 0;
        for(int i=0; i<Pinputs.length; i++){
            for(int j=0; j<Pinputs[0].length; j++){
                //checkInt method from utils class - returns true if it is possible to convert to an integer
                if(u.checkInt(Pinputs[i][j])){
                    if(Integer.parseInt(Pinputs[i][j]) > largest){
                        largest = Integer.parseInt(Pinputs[i][j]);
                    }
                }
            }
        }
        //leaving some padding for text
        if(largest == 0){
            JOptionPane.showMessageDialog(this, "Select some numbers to generate a graph", "whoopsies", HEIGHT);
            dispose();
        }
        int multy = (int) (420/largest);
        int multx = 600/Pinputs.length;        
        
        //loop to draw horizontal lines and y-axis scale
        //i2 counts down
        double i2=10;
        //i counts up, starting at 60 and incrementing by 40 (this corresponds directly to the y value of each line)
        for(int i=60; i <= 440; i=i+40){
            g.setColor(Color.black);
            //double because we need decimals here
            //there are 10 lines so each line's corresponding number is the biggest multiplied by a fraction of whichever line it is
            double v = (largest*(i2/10));
            
            //messy if statements to truncate long decimals
            if(String.valueOf(v).split("\\.").length>1){
                if(String.valueOf(v).split("\\.")[1].length()>3){
                    String temp = String.valueOf(v).split("\\.")[0]
                            + "."
                            + String.valueOf(v).split("\\.")[1].substring(0, 3);
                    v = Double.parseDouble(temp);
                }
            }
            
            g.drawString(String.valueOf(v), 10, i);
            g.setColor(Color.lightGray);
            g.drawLine(30, i-5, 620, i-5);
            i2--;
        }
        
        //g.setColor(Color.black);
        //g.drawString(String.valueOf(largest), 10, 60);
        //g.drawString("0", 10, 460);
        
        for(int i=0; i<Pinputs[0].length; i++){
            //finding the amount of potential plots on this line which are not strings
            int count=0;
            for(int j=0; j<Pinputs.length; j++){
                //using the method which was made earlier
                if(u.checkInt(Pinputs[j][i])){
                    count++;
                }
            }
            
            //arrays for plot points
            int[] xPoints = new int[count];
            int[] yPoints = new int[count];
            
            //more arrays for plot points
            int[] yPoints2 = new int[count];
            
            //variable to check for strings for a second time
            int count2 = 0;        
            for(int l=0; l<Pinputs.length; l++){
                
                if(u.checkInt(Pinputs[l][i])){
                    //moving each point from a "start" position bearing the multiplier in mind
                    //y=0 is at the bottom of the window for some reason so that must be inverted
                    yPoints[count2] = 460-(Integer.parseInt(Pinputs[l][i])*multy);
                    xPoints[count2] = 40+(count2*multx);
                    //this one is 1 pixel higher to make a second line, to make the graph thicker
                    yPoints2[count2] = 459-(Integer.parseInt(Pinputs[l][i])*multy);
                    count2++;
                }
            
            }
            //MOD operation ensures only one of the eight available can be requested
            g.setColor(colours[i % 8]);
            //actually plot the damn line
            g.drawPolyline(xPoints,yPoints, xPoints.length);
            g.drawPolyline(xPoints,yPoints2, xPoints.length);
            //legend using the first row
            g.drawString(Pinputs[0][i], 20, 460-(15*i));
        }
    }
}
