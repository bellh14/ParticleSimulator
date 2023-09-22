import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;
import java.awt.Shape;


public class BasicParticle extends Particle{

    Handler handler;

    public BasicParticle(float x, float y, Handler handler){
        super(x, y);
        this.mass = 1;
        this.width = 1;
        this.height = 1;
        this.radius = 1;
        this.handler = handler;
    }

    public BasicParticle(float x, float y, double mass, double width, double height, Handler handler){
        super(x, y);
        this.mass = mass;
        this.width = width;
        this.height = height;
        this.handler = handler;
    }
    public void render(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }

    public void tick() {
        /*accY += gravity;
        velY += accY;
        x += velX;
        y += velY;*/
        Vector<Double> gForce;
        if(handler.particles.size() > 1){
            for(Particle p : handler.particles){
                //Particle p = handler.particleIterator.next();
                if(this == p){
                    continue;
                }
                gForce = this.gravitationalAttraction(this, p);
                accX += (gForce.elementAt(0) / this.mass);
                accY += (gForce.elementAt(1) / this.mass);
                velX += accX;
                velY += accY;
                x += velX;
                y += velY;
                //System.out.println(this.unitDistanceVector(this, p));
            }
        }



        x = Engine.clamp(x, 0, (int) Engine.WIDTH - 37);
        y = Engine.clamp(y, 0, (int) Engine.HEIGHT - 64);

        if(x == 0 || x == Engine.WIDTH - 37){
            this.remove = true;
        }else if(y == 0 || y == Engine.HEIGHT - 64){
            this.remove = true;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

}
