import java.util.Vector;

public class Forces {
    protected double gravitationalConstant;

    public Forces(){
        //gravitationalConstant = .0000000000667;
        gravitationalConstant = .0000000667;
    }

    public <P extends Particle> double dotProduct(P p1, P p2){
        double dotProduct = (p1.x * p2.x) + (p2.y * p2.y);
        return dotProduct;
    }

    public <P extends Particle> double distance(P p1, P p2){
        double distance = Math.sqrt((Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)));
        return distance;
    }

    public <P extends Particle> Vector<Double> unitDistanceVector(P p1, P p2){
        Vector<Double> unitDistanceV = new Vector<>();
        unitDistanceV.add(p2.getUnitX() - p1.getUnitX());
        unitDistanceV.add(p2.getUnitY() - p1.getUnitY());
        return unitDistanceV;
    }

    public  <P extends Particle> Vector<Double> gravitationalAttraction(P p1, P p2){
        Vector<Double> gravitationalForce = new Vector<>();
        double gForceMagnitude = 0;
        Vector<Double> unitDistance = unitDistanceVector(p1, p2);
        gForceMagnitude = gravitationalConstant * ((p1.mass * p2.mass) / Math.pow(distance(p1, p2), 2));
        gravitationalForce.add(gForceMagnitude * unitDistance.elementAt(0));
        gravitationalForce.add(gForceMagnitude * unitDistance.elementAt(1));
        return gravitationalForce;
    }

    public <P extends Particle> Vector<Double> centripetalAcc(P p1, P p2){

    }
}
