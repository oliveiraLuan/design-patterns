package shapes;

public class Rectangle implements Shape {
    private int id, x, y, z, width, height;

    public Rectangle(int id, int x, int y, int z, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int id, int x, int y, int z, int width) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitRectangle(this);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
