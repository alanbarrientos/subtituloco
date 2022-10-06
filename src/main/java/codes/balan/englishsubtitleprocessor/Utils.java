package codes.balan.englishsubtitleprocessor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Utils {
    File file= null;
    private boolean isFirstTime= true;
    private int localMinute = 0;

    //todo falta inplementar todo lo de abajo
    public Word[] tagPOS(String sentence){
        String[] wordsString = sentence.split(" +");
        Word[] words = new Word[wordsString.length];
        for (int i=0; i<wordsString.length; i++) {
            if(i==0){
                words[i]=new Word(wordsString[i], TypeWord.VERB);
            }
            words[i]=new Word(wordsString[i], TypeWord.NOT_VERB);
        }
        return words;
    }
    public void writeInFile(int minute, Word word, String outputFile) throws IOException {
//       Write a tile if the minute change when we call again and write words in file with a ", " and if the word is VERB put some advise like this "<word>"
        if(isFirstTime){
            file = new File(outputFile);
            FileWriter fileWriter= new FileWriter(file);
            fileWriter.write("");
            isFirstTime=false;
            fileWriter.close();
        }
        try {
            // Creates a Writer using FileWriter

            if(localMinute!=minute){
                localMinute = minute;
                String localTitle = "\n\n Wors Up to minute: "+ minute + "\n\n";
                Files.write(Paths.get(file.getAbsolutePath()), localTitle.getBytes(), StandardOpenOption.APPEND);

            }
            String localWord= word.getWord()+ "\n";
            // Writes the program to file
            Files.write(Paths.get(file.getAbsolutePath()), localWord.getBytes(), StandardOpenOption.APPEND);
            // Closes the writer
        }catch (Exception e) {
            e.getStackTrace();
        }

    }
    public void writeInHTML(int minute, Word word, String outputFile){
    }
    public void writeAsSubtitle(List<String> LinesFileSubtitle, Word word, String outputFile){
    }
}
