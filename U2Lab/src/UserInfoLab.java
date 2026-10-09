import java.util.Scanner;
public class UserInfoLab
{
    public static void main(String[] args)
    {
        // Part 1
        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.

        // Create Scanner for keyboard input
        Scanner input = new Scanner(System.in);

        // First name
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        // Last name
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        // Pass both names to method and save result
        String username = generateUsername(firstName, lastName);


        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:

        // User password
        System.out.print("Enter a password: ");
        String userPassword = input.nextLine();

        // Pass password to method and save result
        boolean password = validatePassword(userPassword);

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.
        if (password)
        {
            // Ask user for credit card number
            System.out.print("Enter credit card number: ");
            String creditCard = input.nextLine();

            // Pass card number to method and save result
            String maskedCard = maskCreditCard(creditCard);

            // Display the masked credit card
            System.out.println(maskedCard);
        }

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

    }

    public static String generateUsername(String firstName, String lastName)
    {
        // Fill in this method and return an appropriate username

        // Get first 3 letters or the whole name if the name is shorter than 3
        if (firstName.length() > 3)
        {
            firstName = firstName.substring(0,3);
        }

        // Do the same to the last name
        if (lastName.length() > 3)
        {
            lastName = lastName.substring(0, 3);
        }

        // Combine the strings and make them lower case
        String username = (firstName + lastName).toLowerCase();

        // Return the username
        return username;
    }


    public static boolean validatePassword(String password)
    {
        // Fill in this method and return true/false if the password is valid

        // Assume password is valid at first
        boolean valid = true;

        // Check if password has at least 8 characters
        if (password.length() < 8)
        {
            System.out.println("Password must be at least 8 characters.");
            valid = false;
        }

        // Check if password has at least one uppercase letter
        if (password.equals(password.toLowerCase()))
        {
            System.out.println("Password must contain an uppercase letter.");
            valid = false;
        }

        // Check if password contains at least one digit
        if (!containsDigit(password))
        {
            System.out.println("Password must contain a digit.");
            valid = false;
        }

        // Return true if all requirements are met
        return valid;
    }

    public static String maskCreditCard(String creditCardNumber) {
        // Fill in this method and if the credit card is valid, return a masked CC

        // Check if card has exactly 16 digits
        if (creditCardNumber.length() == 16 && allDigits(creditCardNumber)) {
            // Get the last 4 digits
            String lastFour = creditCardNumber.substring(12);

            // Hide the first 12 digits and show the last 4
            return "**** **** **** " + lastFour;
        }
        else
        {
            return "N/A";
        }
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str)
    {
        char[] chars = str.toCharArray();
        for (char c: chars)
        {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str)
    {
        char[] chars = str.toCharArray();
        for (char c: chars)
        {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
