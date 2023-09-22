import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Spawner extends MouseAdapter{
    private Handler handler;
    private Engine engine;
    private Random r = new Random();


    public Spawner(Engine engine, Handler handler){
        this.engine = engine;
        this.handler = handler;
    }

    public double randomParticleSize(int massRange){
        Random rand = new Random();
        double mass = rand.nextInt(massRange) + rand.nextDouble();
        return mass;
    }


    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            int x = e.getX();
            int y = e.getY();
            double mass = randomParticleSize(100);
            handler.addParticle(new BasicParticle(x, y, mass, mass, mass, handler));
        }else if(e.getButton() == 3){
            int x = e.getX();
            int y = e.getY();
            double mass = 1000000000;
            handler.addParticle(new BasicParticle(x, y, mass, 50, 50, handler));
        }
    }
}
