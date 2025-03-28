package TestPackage.distributions;

/** A random number generator based on the tstudent distribution.
  * automatically generated by <code>MetaGenerator</code> 
  * @version 1.0, Thu Oct 03 11:03:30 BST 2002
  * @author F.Mallet from C.Simatos's original
  */

public class Tstudent extends Generator implements ContinuousGenerator {
    private long deg_freedom;
    /**
     * the seed is aumatically provided by the <code>SeedGenerator</code>
     */
    public Tstudent(long deg_freedom) {
        super();
        set(deg_freedom);
    }

    /**
     * The constructor with which a specific seed is set for the random
     * number generator
     * @param seed The initial seed for the generator, two instances with
     *             the same seed will generate the same sequence of numbers
     */
    public Tstudent(long deg_freedom, long seed) {
        super(seed);
        set(deg_freedom);
    }

    private void set(long deg_freedom) {
        if (deg_freedom<=0)
            throw new ParameterException("Tstudent: The degrees of freedom must be a positive integer.");
        this.deg_freedom = deg_freedom;
    }

    /**
     * Generate a new random number.
     * @return The next random number in the sequence
     */
    public double sample() { 
         return distrib.tstudent(deg_freedom);
    }
}
