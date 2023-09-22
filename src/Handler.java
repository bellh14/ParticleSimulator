import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Handler {

    public ArrayList<Particle> particles = new ArrayList<>();
    public ArrayList<Particle> particlesToAdd = new ArrayList<>();


    public void tick(){

        for(Particle p : this.particles){
            p.tick();
        }

        //add new particles
        this.particles.addAll(this.particlesToAdd);
        this.particlesToAdd.clear();

        //remove particles
        this.particles.removeIf(p -> p.remove);


    }

    public void render(Graphics g){
        for(Particle p : this.particles){
            p.render(g);
        }
    }

    public void addParticle(Particle particle){
        particlesToAdd.add(particle);
    }



}
