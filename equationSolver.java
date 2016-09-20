import java.util.Scanner;
public class equationSolver
{
    /**
     * Main class just meant for testing purposes
     * @param args[] command line arguments unused in this program
     */
    public static void main(String args[])
    {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Please enter an eqation in the form of _x + _y "
        +" = _ where the blanks represent the constants in front of the " +
        "varible, also leave out the = sign when writing the equation");
        int constant1 = kbd.nextInt();
        int constant2 = kbd.nextInt();
        int answer1 = kbd.nextInt();
        kbd.nextLine();
        System.out.println("Now do the same thing for the second equation");
        int constant3 = kbd.nextInt();
        int constant4 = kbd.nextInt();
        int answer2 = kbd.nextInt();
        systemsOfLinearEquations(constant1, constant2, answer1,
        constant3, constant4, answer2);
    }

    /**
     * A method that will solve a 2 equation system of linear equations using
     * matrices it will then output the X and Y value where the lines
     * intercept
     * @param constant1 the first constant of the first equation
     * @param constant2 the second constant of the first equation
     * @param answer1 the answer for the first equation
     * @param constant3 the first constant of the second equation
     * @param constant4 the second constant of the second equation
     * @param answer2 the answer for the second equation <br>
     * Pre: both equations are put into standard form<br>
     * Post: the intercept point is printed out
     */
    public static void systemsOfLinearEquations
    (
        double constant1, //in
        double constant2, //in
        double answer1, //in
        double constant3, //in
        double constant4, //in
        double answer2 //in
    )
    {
        //array to hold all the constants (acting as a 2x2 matrix 0 and 1
        //being the top row and 2 and 3 being the bottom row)
        double[] constants = new double[4];
        constants[0] = constant1;
        constants[1] = constant2;
        constants[2] = constant3;
        constants[3] = constant4;

        //finding the determinant of the matrix
        double determinant = ((constants[0] * constants[3]) -
        (constants[1] * constants[2]));

        //making a new matrix to hold the adjugate of the constants matrix
        double[] adj = new double[4];
        //the top left and bottom right corner switch with one another
        adj[0] = constants[3];
        adj[3] = constants[0];
        //the top right and bottom left corner become negative
        adj[2] = -1 * constants[2];
        adj[1] = -1 * constants[1];

        //new matrix to hold the inverse of the constants matrix
        double[] inverse = new double[4];
        //finding the scaler being 1 / the determinant
        double scaler = 1/determinant;
        //multiplying all elements of the adjugate by the scaler to get the
        //inverse
        inverse[0] = scaler * adj[0];
        inverse[1] = scaler * adj[1];
        inverse[2] = scaler * adj[2];
        inverse[3] = scaler * adj[3];

        //new matrix to hold the X and Y values of where the 2 equations
        //intercept
        double[] solution = new double [2];
        //The X value
        solution[0] = (inverse[0] * answer1) + (inverse[1] * answer2);
        //the Y value
        solution[1] = (inverse[2] * answer1) + (inverse[3] * answer2);
        //printing out the value
        System.out.println("X: " + solution[0] + " Y: " + solution[1]);
    }
}
