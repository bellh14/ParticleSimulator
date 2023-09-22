import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Graphics;
import java.lang.Math;
import java.util.Vector;

public abstract class Particle extends Forces{

    protected float x;
    protected float y;

    protected double width;
    protected double height;
    protected double radius;
    protected double magnitude;
    //protected ID id;
    protected float velX;
    protected float velY;

    protected float accX;
    protected float accY;

    protected double mass;
    protected double charge;

    public boolean remove;

    public Particle(float x, float y){
        this.x = x;
        this.y = y;
        this.magnitude = Math.sqrt((Math.pow(this.x, 2)) + (Math.pow(this.y, 2)));
    }

    public abstract void render(Graphics g);
    public abstract void tick();
    public abstract Rectangle getBounds();

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY){
        this.velY = velY;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setAccX(float accX) {
        this.accX = accX;
    }

    public void setAccY(float accY) {
        this.accY = accY;
    }

    public float getAccX() {
        return accX;
    }

    public float getAccY() {
        return accY;
    }

    public double getMass(){
        return mass;
    }

    public double getUnitX(){
        return this.x / this.magnitude;
    }
    public double getUnitY(){
        return this.y / this.magnitude;
    }
}
