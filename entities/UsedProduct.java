package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class UsedProduct extends Product{
    private LocalDate manufactureDate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
    public UsedProduct(){}
    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    @Override
    public String priceTag(){
        return name + " (used) $ "
                + String.format("%.2f", price)
                + ("Manufacture date: " + sdf);
    }
}
