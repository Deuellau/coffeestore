import java.util.Scanner;

public class WordGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Grabs a random word from word list
        String word = words[wordsIndex(words.length)];

        int lives = 10;  // Number of Lives
        char[] letters = new char[word.length()];
        char[] placeholder = new char[word.length()];
        String misses = "";  // Wrong guesses

        // Store each letter from word
        for (int i = 0; i < word.length(); i++) {
            letters[i] = word.charAt(i);
        }

        for (int i = 0; i < word.length(); i++) {
            placeholder[i] = '_';
        }

        //System.out.println("**show ans:" + Arrays.toString(letters));
        displayUI(placeholder, lives, misses);

        // Game
        while (true) {
            boolean win_condition = true;
            String input;
        
            // Receive input from user unless input length does not match word length
            while (true) {
                System.out.print("\nGuess the word: ");
                input = scanner.next();
                if (input.length() == word.length()) {
                    break;
                }
                System.out.println("Your guess does not match the word length");
            }
            
            // Store each letter from input (Same as ln17)
            char[] inputLetters = new char[input.length()];
            for (int i = 0; i < input.length(); i++) {
                inputLetters[i] = input.charAt(i);
            }

            for (int i = 0; i < word.length(); i++) {
                // If guessed letter is correct, rewrite placeholder as guessed letter
                if (letters[i] == inputLetters[i]) {
                    placeholder[i] = letters[i];
                }
                // Minus a live if display letter does not match guessed letter, add to misses text
                else if (placeholder[i] != letters[i]) {
                    misses += inputLetters[i] + " ";
                    lives -= 1;
                }
            }

            // Check if all display letters matches word.
            for (int i = 0; i < word.length(); i++) {
                if (letters[i] != placeholder[i]) {
                    win_condition = false;
                }
            } 
            // Win game if all display letters matches word
            if (win_condition) {
                System.out.println("You Won!!!\n");
                break;
            }

            // Quit game if lives are zero
            if (lives <= 0) {
                System.out.println("\nNo more lives, you lost");
                System.out.println("The word was: " + word);
                break;
            }

            // Display UI
            displayUI(placeholder, lives, misses);
        }
    }
    

    // List of words
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear","beaver", "camel", "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat", "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout", "turkey","turtle", "weasel", "whale", "wolf", "wombat", "zebra"};


    // Randoms an number from 1 to num of words in words
    public static int wordsIndex(int wordLength) {
        return (int)(Math.random()*(wordLength)) + 1;
    }


    public static void displayUI (char[] placeholder, int lives, String misses) {
        // Prints heart icon per number of lives
        System.out.print("Lives: ");
        for (int i = 0; i < lives; i++) {
            System.out.print("\u2764" + " ");
        }
        System.out.println("");

        System.out.print("Misses: ");
            System.out.print(misses);
        System.out.println("");

        System.out.print("Word: ");
        for (int i = 0; i < placeholder.length; i++) {
            System.out.print(placeholder[i] + " ");
        }
        System.out.println("");
    }
}
