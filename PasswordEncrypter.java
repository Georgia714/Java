import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.Scanner;

public class PasswordEncrypter {


    public static void main(String[] args) throws NoSuchAlgorithmException {

        password();

    }

/* The password method below hashes a password to create a new one. It does this by creating an object of the class
MessageDigest for the MD5 algorithm. The password will be saved in this format in bytes*/

    public static void password() throws NoSuchAlgorithmException{
        Scanner userInput = new Scanner(System.in);
        //System.out.println("Please enter a password: ");
        //String passwordToHash = userInput.nextLine();
        String passwordToHash = "password";
        String generatedPassword;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Add password bytes to digest
            md.update(passwordToHash.getBytes());
            // Get the hash's bytes
            byte[] bytes = md.digest();
            // This bytes[] has bytes in decimal format;
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
            // Passes the generated password through the next method to generate the salt
            getSalt(generatedPassword);

        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        //return generatedPassword;
    }

    /*The method below creates the salt. A salt is a random word added to the end of a password and this is also hashed
    to make it even more secure. This is also saved as the data type: bytes.*/
    public static void getSalt(String pw) throws NoSuchAlgorithmException{

        // Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        // Create array for salt
        byte[] salt = new byte[16];
        // Get a random salt
        sr.nextBytes(salt);

        String x = Base64.getEncoder().encodeToString(salt);
        //Passes the password and salt through the next method
        addition(pw, x);
    }

    public static void addition(String password, String salt){

        password = password.concat(salt);
        String note = "The hashed password is " + password;

        Path path = Paths.get("output.txt");

        try {
            Files.writeString(path, note, StandardCharsets.UTF_8);
        }
        catch (IOException ex) {
            System.out.println("error");
        }

        System.out.println("The password is: " + password);
    }


}

