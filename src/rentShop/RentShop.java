
package rentShop;


import javax.swing.JFrame;


public class RentShop extends JFrame
{
    private final int WIDTH_W = 600;
    private final int HEIGHT_W = 700;
    private final int X = 400;
    private final int Y = 50;
    

    public RentShop()
    {
        setTitle("Film Club");
        
        setBounds(X, Y, WIDTH_W, HEIGHT_W);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        
         
    }
    
    
   
    
}
