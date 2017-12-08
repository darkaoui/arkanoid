import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Cadre extends Rectangle{

    public Cadre(double x,double y,double width,double height){
        super(x,y,width,height);
        setColor(Color.BLACK);
    }

    public void setColor(Color color){
        this.setFill(Color.TRANSPARENT);
        this.setStroke(color);
    }
}
