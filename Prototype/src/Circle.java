public class Circle extends Shape{
    private int radius;

    public Circle(){}

    public Circle(Circle target){
        super(target);
        if(target != null)
            this.radius = target.radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }
    @Override
    public boolean equals(Object object2){
        if(!(object2 instanceof Circle) || !super.equals(object2))
            return Boolean.FALSE;
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }
}
