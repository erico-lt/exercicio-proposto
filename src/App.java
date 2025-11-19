import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import model.entites.Product;

public class App {
    public static void main(String[] args){     
        
        String strPath = "C:\\test";     
        File path = new File(strPath);          
        List<Product> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path + "\\in.txt"))) {
            String line = br.readLine();
            while (line != null) {
                String[] linesVet = line.split(",");               
                list.add(new Product(linesVet[0],Double.valueOf(linesVet[1]) ,Integer.valueOf(linesVet[2])));                       
                line = br.readLine();
            }
            
            boolean success = new File(strPath + "\\out").mkdir();     
            System.out.println("Diretório criado com sucesso: " + success);
            
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(strPath + "\\out\\summary.txt"))){
                for(Product prod : list){
                    bw.write(prod.getName()+", ");
                    bw.write(String.valueOf(prod.totalValeu()));
                    bw.newLine();
                }                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            File file = new File(strPath + "\\out\\summary.txt");
            try (BufferedReader br2 = new BufferedReader(new FileReader(file))) {
                String line2 = br2.readLine();
                while (line2 != null) {
                    System.out.println(line2);
                    line2 = br2.readLine();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }       
        
    }

    
}
