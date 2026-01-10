package javaconcepts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A short example demonstrating the usage of the Java Date-Time API.
 * This program performs the following operations:
 * - Displays the current date.
 * - Calculates and displays a future date by adding days to the current date.
 * - Formats a date into a specific string pattern.
 * - Parses a date string back into a LocalDate object.
 */
public class DateTimeApiShortExample {

    /**
     * The main method demonstrating various Date-Time API operations.
     *
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Get the current date
        LocalDate lDate1 = LocalDate.now();
        System.out.println("Current Date " + lDate1);

        // Calculate a future date by adding 5 days to the current date
        LocalDate futureDate = lDate1.plusDays(5);
        System.out.println("Future Date " + futureDate);

        // Define a formatter to format dates in the "dd-MM-yyyy" pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the future date into a string
        String strDate = futureDate.format(formatter);
        System.out.println("String formatted date " + strDate);

        // Define a date string in the "dd-MM-yyyy" format
        String newStrDate = "18-11-2019";

        // Parse the date string back into a LocalDate object
        LocalDate newDate = LocalDate.parse(newStrDate, formatter);
        System.out.println("Parsed date " + newDate);
    }
}