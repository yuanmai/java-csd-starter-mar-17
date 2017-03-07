# User Stories
## As a tennis player I want to make reservation online, so that I can start playing when I arrive.
## As a tennis player I want to find the nearest court around my area, so that I can save time.
## As a premium member I can set up recurring reservations for practices so that I don’t need to set up repeatedly.
## As a tennis player I want to send the reservation information to my partner, so that he/she can arrive on time.
## As a court manager, I want to publish the available hours and fee rates of my courts, so that my customers can make reservation.
## As a court manager, I want to collect reservation fee.

# Environment & Tools
## JDK 8
## IntelliJ
## git
## Maven

```
package kata;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TranslatorTest {
    @Test
    public void pig_latin_rules() {
        assertEquals("appleway", toPigLatin("apple"));
        assertEquals("ananabay", toPigLatin("banana"));
        assertEquals("Appleway", toPigLatin("Apple"));
        assertEquals("Ananabay", toPigLatin("Banana"));
    }

    String toPigLatin(String input) {
        if ("aeiouyAEIOUY".contains(((Character) input.charAt(0)).toString())) {
            return input + "way";
        }

        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            if ("aeiouyAEIOUY".contains(((Character) input.charAt(i)).toString())) {
                index = i;
                break;
            }
        }

        String a = input.substring(index);
        String b = input.substring(0, index).toLowerCase();

        String result = a + b + "ay";

        if (Character.isUpperCase(input.charAt(0))) {
            String word = result;
            Character ch = Character.toUpperCase(word.charAt(0));
            word = ch + word.substring(1);
            result = word;
        }

        return result;
    }

}
```
