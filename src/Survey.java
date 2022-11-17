import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {

        /**
         COMPLETE THIS CLASS AFTER ALL OTHER CLASSES ARE COMPLETED
         */

        /*
        Write a program that will get information from 3 participants and
        -Print information for each participant
        -Print how many participants were male
        -Print how many participants were female
        -Print the age of the youngest person
        -Print the age of the eldest person
         */


        Scanner scanner = new Scanner(System.in);

        ArrayList<Participant> participants = new ArrayList<>();

        int maxAge = 0;
        int minAge = Integer.MAX_VALUE;

        do {
            System.out.println(SurveyQuestions.askToJoin);
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Y")) System.out.println(SurveyQuestions.askName);
            String answerName = scanner.nextLine();

            System.out.println(SurveyQuestions.askAge);
            int answerAge = scanner.nextInt();
            scanner.nextLine();
            if (answerAge > maxAge) maxAge = answerAge;
            if (answerAge < minAge) minAge = answerAge;



            System.out.println(SurveyQuestions.askGender);
            char answerGender = scanner.nextLine().toUpperCase().charAt(0);

            Participant participant = new Participant(answerName,answerAge,answerGender);
            participants.add(participant);

            if (participant.gender == 'M') Participant.addMaleParticipants();
            else Participant.addFemaleParticipants();
            Participant.addParticipants();


        }while (Participant.totalNumberOfParticipants < 3) ;

        for (Participant p : participants) {
            System.out.println(p);
        }

        System.out.println("The total number of male participant = " + Participant.totalNumberOfMaleParticipants);
        System.out.println("The total number of female participant = " + Participant.totalNumberOfFemaleParticipants);
        System.out.println("The age of the youngest person is = " + minAge);
        System.out.println("The age of the eldest person is = " + maxAge);
    }
}
