import java.awt.Point;

public class Guard {
    private final Point position;
    private final Point direction;

    Guard(Point position, Point direction) {
        this.position = position;
        this.direction = direction;
    }

    public Point getPosition() {
        return position;
    }

    public Point getDirection() {
        return direction;
    }

    public void move() {
        this.position.x += this.direction.x;
        this.position.y += this.direction.y;
    }

    public void rotateRight() {
        int x = this.direction.x;
        int y = this.direction.y;
        this.direction.x = -y;
        this.direction.y = x;
    }

    public Point getNextPosition() {
        return new Point(position.x + direction.x, position.y + direction.y);
    }
}
