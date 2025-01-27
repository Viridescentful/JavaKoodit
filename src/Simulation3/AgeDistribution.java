package Simulation3;

/*
    Considering I am pulling the age using a randomly generated number, the distribution will be uniform, unlike in the original example;
    where the system worked on weighted chances. Though isn't realistic, this still showcases what is needed.
 */

public class AgeDistribution {
    public static void main(String[] args) {
        final int REITERATIONS = 1000;
        final int MAXAGE = 100;

        int generatedAges[] = new int[MAXAGE+1];

        for (int i = 1; i <= REITERATIONS; i++){
            int x = (int)(Math.random() * MAXAGE) +1;
            generatedAges[x]++;
        }

        System.out.println("Age  count     %-share");
        for (int age = 0; age <= MAXAGE; age++) {
            if (generatedAges[age] != 0) {
                String str = "%-4d %-8d %-8.2f\n";
                System.out.printf(str, age, generatedAges[age], ((double)generatedAges[age])/REITERATIONS*100 );
            }
        }
    }
}
