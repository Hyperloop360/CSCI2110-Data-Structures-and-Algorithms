public class Player {
    private String name;

    public Player (String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player " + name;
    }

    public boolean kick (Field f, Ball b, double d, double r){

        //Convert to radians and get new coordinates
        double rRad = Math.toRadians(r);
        double nx = b.getBx() + d * Math.cos(rRad);
        double ny = b.getBy() + d * Math.sin(rRad);

        double fieldLeft = f.getTlxpos();
        double fieldTop = f.getTlypos();
        double fieldRight = fieldLeft + f.getWidth();
        double fieldBottom = fieldTop + f.getHeight();

        // Define EPSILON for double comparison
        final double EPSILON = 1e-8;

        // Check if new position is within field bounds
        boolean xInBounds = (nx >= fieldLeft - EPSILON) && (nx <= fieldRight + EPSILON);
        boolean yInBounds = (ny >= fieldTop - EPSILON) && (ny <= fieldBottom + EPSILON);

        boolean reflected = false;
        if (xInBounds && yInBounds) {
            // Case 1: Both coordinates are within bounds
            b.setBx(nx);
            b.setBy(ny);
            reflected = false;

        } else if (!xInBounds && yInBounds) {
            // Case 2: X is out of bounds, Y is within bounds
            // Reflect in X direction - keep original X, use new Y
            b.setBy(ny);
            reflected = true;

        } else if (xInBounds && !yInBounds) {
            // Case 3: Y is out of bounds, X is within bounds
            // Reflect in Y direction - use new X, keep original Y
            b.setBx(nx);
            reflected = true;
        } else {
            // Case 4: Both coordinates are out of bounds
            // Ball returns to original position (no change)
            reflected = true;
        }

        return reflected;
    }


}
