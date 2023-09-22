import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Engine extends Canvas implements Runnable{

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 960;
    private Handler handler;
    private boolean running = true;
    private Engine engine;
    private Spawner spawner;

    private Thread thread;


    public Engine(){
        handler = new Handler();
        new Window(WIDTH, HEIGHT, this);
        spawner = new Spawner(this, handler);
        this.addMouseListener(spawner);


    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(4);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);

        g.dispose();
        bs.show();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;


    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();

        }
    }

    /*public void run() {

        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }


        }
        stop();
    }*/

    public void run(){
        try{
            while(running){
                tick();
                render();
            }

        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void tick(){
        handler.tick();

    }

    public static int clamp(float b, int min, int max){
        if(b >= max){
            b = max;
        }else if(b <= min){
            b = min;
        }
        return (int) b;
    }

    public static void main(String[] args){

        new Engine();
    }
}
