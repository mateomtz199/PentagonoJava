import java.awt.*;
import java.awt.event.*;
public class Poligono extends Frame
{  public static void main(String[] args){new Poligono();}

   Poligono()
   {  super("Pentágono de Melina-chan");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
      setSize (600, 400);
      add("Center", new CvTriangles());
      show();

   }
}

class CvTriangles extends Canvas
{  
   int maxX, maxY, minMaxXY, xCenter, yCenter;

   void initgr()
   {  
        Dimension d = getSize();
        maxX = d.width - 1; 
        maxY = d.height - 1;
        minMaxXY = Math.min(maxX, maxY);
        xCenter = maxX/2; 
        yCenter = maxY/2;
   }
   int iX(float x){
       return Math.round(x);
   }
   int iY(float y){
       return maxY - Math.round(y);
   }

   public void paint(Graphics g)
   { 
       initgr();
       float side = 0.95F * minMaxXY; 
       float sideHalf = 0.5F * side;
       float h = sideHalf * (float)Math.sqrt (3);
       
       float Coordenadas[][] = new float[5][2];
       for (int i = 0; i < 5; i++){
          Coordenadas[i][0] = (float) (300 + 150 * Math.cos(i * 2 * Math.PI / 5));
          Coordenadas[i][1] = (float) (180 + 150 * Math.sin(i * 2 * Math.PI / 5));
       }
       
       float xA, yA;
       float xB, yB;
       float xC, yC;
       float xD, yD;
       float xE, yE;
       
       float xA1, yA1;
       float xB1, yB1;
       float xC1, yC1;
       float xD1, yD1;
       float xE1, yE1;
       float p, q;
       q = 0.05F;
       p = 1 - q;
       
       xA = Coordenadas[0][0];
       yA = Coordenadas[0][1];
       xB = Coordenadas[1][0];
       yB = Coordenadas[1][1];
       xC = Coordenadas[2][0];
       yC = Coordenadas[2][1];
       xD = Coordenadas[3][0];
       yD = Coordenadas[3][1];
       xE = Coordenadas[4][0];
       yE = Coordenadas[4][1];
       
//       xA = xCenter - sideHalf / 2;
//       yA = yCenter - 0.5F * h;
//       xB = xCenter + sideHalf / 2;
//       yB = yA;
//       xC = xCenter / 2;
//       yC = yCenter + 0.5F * h / 2;
       
//       System.out.println(xCenter + " " + yCenter + " " + sideHalf);
//       System.out.println(xA + " " + yA + " " + xB + " " + yB + " " + xC + " " + yC);
       for (int i=0; i<50; i++)
       {
           g.drawLine(iX(xA), iY(yA), iX(xB), iY(yB));
           g.drawLine(iX(xB), iY(yB), iX(xC), iY(yC));
           g.drawLine(iX(xC), iY(yC), iX(xD), iY(yD));
           g.drawLine(iX(xD), iY(yD), iX(xE), iY(yE));
           g.drawLine(iX(xE), iY(yE), iX(xA), iY(yA));
           
           xA1 = p * xA + q * xB;
           yA1 = p * yA + q * yB;
           xB1 = p * xB + q * xC;
           yB1 = p * yB + q * yC;
           xC1 = p * xC + q * xD;
           yC1 = p * yC + q * yD;
           xD1 = p * xD + q * xE;
           yD1 = p * yD + q * yE;
           xE1 = p * xE + q * xA;
           yE1 = p * yE + q * yA;
           
           xA = xA1; 
           xB = xB1; 
           xC = xC1;
           xD = xD1;
           xE = xE1;
           yA = yA1; 
           yB = yB1; 
           yC = yC1;
           yD = yD1;
           yE = yE1;
        }
    }
}
