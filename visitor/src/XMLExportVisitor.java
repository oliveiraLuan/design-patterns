import shapes.*;

import static java.lang.StringTemplate.STR;

public class XMLExportVisitor implements Visitor {
    public String export(Shape... shapes){
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        for(Shape shape : shapes){
            sb.append(shape.accept(this)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String visitDot(Dot dot) {
        return STR."<dot> \n <id>\{dot.getId()}</id> \n <x>\{dot.getX()}</x> \n<y>\{dot.getY()}</y>\n</dot>";
    }

    @Override
    public String visitRectangle(Rectangle rectangle) {
        return STR."<rectangle> \n <id>\{rectangle.getId()}</id> \n <x>\{rectangle.getX()}</x> \n<y>\{rectangle.getY()}</y><width>\{rectangle.getWidth()}</width>\n<height>\{rectangle.getHeight()}</height>\n</rectangle>";
    }

    @Override
    public String visitCircle(Circle circle) {
        return STR."<circle> \n <id>\{circle.getId()}</id> \n <x>\{circle.getX()}</x>\n<y>\{circle.getY()}</y>\n<radius>\{circle.getRadius()}</radius>\n</circle>";
    }

    @Override
    public String visitCompoundGraphic(CompoundShape compoundShape) {
        return STR."<compound_graphic>\n<id>\{compoundShape}</id>\n\{_visitCompoundGraphic(compoundShape)}</compound_graphic>\n";
    }

    private String _visitCompoundGraphic(CompoundShape compoundShape){
        StringBuilder sb = new StringBuilder();
        for(Shape shape : compoundShape.children){
            String obj = shape.accept(this);
            obj = "    "  + obj.replace("\n", "\n    ") + "\n";
            sb.append(obj);
        }
        return sb.toString();
    }
}
