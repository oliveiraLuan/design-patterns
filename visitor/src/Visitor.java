import shapes.Circle;
import shapes.CompoundShape;
import shapes.Dot;
import shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);
    String visitRectangle(Rectangle rectangle);
    String visitCircle(Circle circle);
    String visitCompoundGraphic(CompoundShape compoundShape);
}
