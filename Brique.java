import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Brique extends Rectangle {

    public Brique(double x,double y,double width,double height){
        super(x,y,width,height);
    }

    public void setColor(Color color){
        this.setFill(color);
    }
}
