package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.println("Enter the number of products: ");
        int N = sc.nextInt();

        for(int i = 1; i <= N; i++){
            System.out.println("Product #" + (i) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if(type == 'c'){
                list.add(new Product(name, price));
            } else if (type == 'u') {
                System.out.println("Data de fabricaçao (DD/MM/YYYY) ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, date));
            } else {
                System.out.println("Taxa de importação: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
        }
        System.out.println();
        System.out.println("ETIQUETAS DE PREÇO: ");
        for(Product prod : list){
            System.out.println(prod.priceTag());
        }



        sc.close();
    }
}