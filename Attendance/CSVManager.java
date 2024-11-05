package Attendance;

import java.io.*;
import java.util.*;

public class CSVManager {

    public static void writeToCSV(String filepath , String[] data,boolean append) {
        try(FileWriter writer = new FileWriter(filepath,append);
        BufferedWriter bw = new  BufferedWriter(writer)) {
            bw.write(String.join(",",data));
            bw.write("\n");
        }
        catch (IOException e) {
            System.out.println("Error Writing File: " + e.getMessage());
        }
    }
    
    public static List<String[]> readFromCSV(String filepath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath)) ) {
            String line;
            while((line = reader.readLine()) != null) {
                data.add(line.split(","));
            }
        }
        catch(IOException e) {
            System.out.println("Error Writing File: " + e.getMessage());
        }
        return data;
    }
    
    public static void writeAllToCSV(String filepath,List<String[]> data,boolean append) {
        try(FileWriter writer = new FileWriter(filepath,append);
        BufferedWriter bw = new  BufferedWriter(writer)) {
            for(String[] row : data) {
            bw.write(String.join("," ,row));
            bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error Writing File: " + e.getMessage());
        }
    }

    public static boolean removeFromCSV(String filepath,String id) {
        List<String[]> data = readFromCSV(filepath);

        boolean removed = data.removeIf(row -> row[1].equals(id));

        if(removed) {
            writeAllToCSV(filepath,data,false);
        }
        return removed;
    } 
}