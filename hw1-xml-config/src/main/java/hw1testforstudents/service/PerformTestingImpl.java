package hw1testforstudents.service;

import hw1testforstudents.domain.Person;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerformTestingImpl implements PerformTesting {

    private final static String COMMA_DELIMITER = ",";
    private String fileNameCSV = " ";

    public void setFileNameCSV (String fileNameCSV) {
        this.fileNameCSV = fileNameCSV;
    }

        public void performTesting(Person person){
        person.test.clear();
        InputStream fromCSVfile =
                getClass().getClassLoader().getResourceAsStream(fileNameCSV);

        try (Scanner scanner = new Scanner(fromCSVfile)) {
            while (scanner.hasNextLine()) {
                person.test.add(getRecordFromLine(scanner.nextLine()));
            }
        }

        System.out.println("Hi "+ person.getName()+" "+ person.getSurname() + ", please answer following questions: ");

        for (List<String> list : person.test) {
            askQuestion(list);
            list.set(0,receiveAnswer());
        }
    }

    private void askQuestion(List<String> list){

        System.out.println(list.get(2));
        for (int i = 3; i < list.size(); i++){
            if (i%2 != 0 ) {
                System.out.print(list.get(i)+": ");
            } else {
                System.out.print(list.get(i)+"\n");
            }
        }

    }

    private String receiveAnswer(){
        String[] answers = {"A","B","C","D","E"};
        int r = (int) Math.round(Math.random()*5.0 - 0.5);
        System.out.println("Please enter your choice: " + answers[r]);
        return answers[r];
    }

    private List<String> getRecordFromLine(String line) {
        List<String> entries = new ArrayList();
        try (Scanner lineScanner = new Scanner(line)) {
            lineScanner.useDelimiter(COMMA_DELIMITER);
            while (lineScanner.hasNext()) {
                entries.add(lineScanner.next());
            }
        }
        return entries;
    }

}
