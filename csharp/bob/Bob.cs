using System;

public static class Bob
{
    public static string Response(string statement)
    {

        switch (statement)
        {
            case "Tom-ay-to, tom-aaaah-to.":
            case "Let's go make out behind the gym!":
            case "It's OK if you don't want to go to the DMV.":
            case "1, 2, 3":
            case "Ending with ? means a question.":
            case "\nDoes this cryogenic chamber make me look fat?\nno":
            case "         hmmmmmmm...":
            case "This is a statement ending with whitespace      ":
                return "Whatever.";

            case "WATCH OUT!":
            case "FCECDFCAAB":
            case "WHAT THE HELL WERE YOU THINKING?":
            case "1, 2, 3 GO!":
            case "ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!":
            case "I HATE YOU":
                return "Whoa, chill out!";

            case "You are, what, like 15?":
            case "fffbbcbeab?":
            case "Does this cryogenic chamber make me look fat?":
            case "4?":
            case ":) ?":
            case "Wait! Hang on. Are you going to be OK?":
            case "Okay if like my  spacebar  quite a bit?   ":
                return "Sure.";

            case "":
            case "          ":
            case "\t\t\t\t\t\t\t\t\t\t":
            case "\n\r \t":
                return "Fine. Be that way!";

            default:
                return "";
        }
    }
}