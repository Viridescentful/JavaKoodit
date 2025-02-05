import java.io.*;
import java.net.*;

public class TempentureCalculator {
    public static void main(String[] args) {
        // first, create the url
        BufferedReader bufferedstream = null;
        String line;
        String[] columnNames = new String[0];
        boolean header = true;

        double temperaturesum = 0.0;
        int temperaturecounter = 0;

        URL myUrl;
        try {
            myUrl = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");
        } catch (MalformedURLException e) {
            System.err.println(e);
            return;
        }

        try {
            // open the connection and get the input stream
            // it will automatically generate HTTP GET-request
            InputStream istream = myUrl.openStream();

            // jump to character streams
            InputStreamReader istreamreader = new InputStreamReader(istream);

            // and to buffered reader for efficiency
            bufferedstream = new BufferedReader(istreamreader);

            do {
                line = bufferedstream.readLine();
                if (line != null) {
                    if (header) {
                        // first row of the file contains names of columns
                        columnNames = line.split(";");
                        header = false;
                    } else {
                        // just print data lines with column names
                        String[] columns = line.split(";");

                        String[] time = columns[0].split(" ");
                        if (time[0].equals("01.01.2023")) {
                            for (int i = 0; i < columnNames.length; i++)
                                if (columnNames[i].equals("Aika")) {
                                    System.out.print(columnNames[i] + ": " + columns[i] + " ");
                                } else if (columnNames[i].equals("UlkoTalo")){
                                    temperaturecounter++;
                                    temperaturesum += Double.parseDouble(columns[i].replace(",", "."));
                                    System.out.print(columnNames[i] + ": " + columns[i] + " ");
                                }
                            System.out.println();
                        }
                    }
                }
            } while (line != null);
        } catch (IOException e) {
            // Error output, will print to console even in case of output redirection
            System.err.println(e);
        } finally {
            try {
                // we will close the stream only if we were able to open it
                if (bufferedstream != null)
                    bufferedstream.close();
            } catch (Exception e) {
                System.out.println("Error while closing the file");
            }
        }

        if (temperaturecounter != 0) {
            System.out.println("The average temperature is " + String.format("%.1f", temperaturesum / temperaturecounter) + "C");
        }
    }
}