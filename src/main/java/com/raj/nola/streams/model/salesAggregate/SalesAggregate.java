package com.raj.nola.streams.model.salesAggregate;

import com.raj.nola.streams.model.salesRecord.Payload;
import com.raj.nola.streams.model.salesRecord.SalesRecord;
import org.springframework.stereotype.Component;

@Component
public class SalesAggregate {

    String customerCategory;

    int categoryCount;

    double averageSales;

    double totalSales;

    public SalesAggregate init(){
        System.out.println("Inside Init");
        SalesAggregate sg = new SalesAggregate();
        sg.setAverageSales(0);
        sg.setCategoryCount(0);
        sg.setTotalSales(0);
        return sg;
    }

    public SalesAggregate aggregate(Payload salesRec, SalesAggregate aggValue){


        SalesAggregate salesAggregate = new SalesAggregate();
        salesAggregate.setCategoryCount(aggValue.getCategoryCount()+1);
        salesAggregate.setTotalSales(aggValue.getTotalSales()+salesRec.getPrice());
        salesAggregate.setAverageSales((aggValue.getTotalSales()+salesRec.getPrice()) / (aggValue.getCategoryCount()+1));


        return salesAggregate;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    public int getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(int categoryCount) {
        this.categoryCount = categoryCount;
    }

    public double getAverageSales() {
        return averageSales;
    }

    public void setAverageSales(double averageSales) {
        this.averageSales = averageSales;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String toString() {
        return "SalesAggregate{" +
                "customerCategory='" + customerCategory + '\'' +
                ", categoryCount=" + categoryCount +
                ", averageSales=" + averageSales +
                ", totalSales=" + totalSales +
                '}';
    }
}
