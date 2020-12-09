/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

public class SaveableDictionary {
    private HashMap<String, String> dictionary = new HashMap<>();
    private String file;
    
    public SaveableDictionary() {
    }
    
    public SaveableDictionary(String fileName) {
        this.file=fileName;
    }
    
    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get(file))) {
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(":");
                this.add(words[0], words[1]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean save() {
        try (PrintWriter writer = new PrintWriter(file)){
            ArrayList<String> words = new ArrayList<>();
            for (String k: dictionary.keySet()) {
                words.add(dictionary.get(k));
                if (!words.contains(k)) {
                    writer.write(k+":"+dictionary.get(k)+"\n");
                }
            }
            writer.close();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public void add(String word, String translation) {
        if (!(dictionary.containsKey(word))) {
            dictionary.put(word, translation);
        }
        
        if (!(dictionary.containsKey(translation))) {
            dictionary.put(translation, word);
        }
    }
    
    public String translate(String word) {
        return dictionary.get(word);
    }
    
    public void delete(String word) {
        if (dictionary.containsKey(word)) {
            String k = dictionary.get(word);
            dictionary.remove(word);
            dictionary.remove(k);
        }
    }

}
