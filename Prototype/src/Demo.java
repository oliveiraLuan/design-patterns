import java.util.ArrayList;
import java.util.List;

public static void main(String[] args) {
    List<Shape> shapes = new ArrayList<>();
    List<Shape> copies = new ArrayList<>();

    Circle circle = new Circle();
    circle.setX(10);
    circle.setY(5);
    circle.setColor("Blue");
    circle.setRadius(5);

    Circle anotherCircle = (Circle) circle.clone();

    Rectangle rectangle = new Rectangle();
    rectangle.setX(10);
    rectangle.setY(15);
    rectangle.setColor("Brown");
    rectangle.setHeight(30);
    rectangle.setWidth(15);

    shapes.add(circle);
    shapes.add(anotherCircle);
    shapes.addLast(rectangle);
    cloneAndCompare(shapes, copies);
}

private static void cloneAndCompare(List<Shape> shapes, List<Shape> copies){
    shapes.stream().forEach(shape -> copies.add(shape.clone()));

    for(int i = 0;  i < shapes.size(); i++){
        if(shapes.get(i) != copies.get(i)){
            System.out.println(STR."\{i}: O Array de Shapes tem objetos diferentes ");
            if(shapes.get(i).equals(copies.get(i))){
                System.out.println("E eles são idênticos");
            } else {
                System.out.println(STR."\{i}Mas eles naão são idênticos");
            }
        } else{
            System.out.println(STR."\{i} Objetos são os mesmos");
        }
    }
}