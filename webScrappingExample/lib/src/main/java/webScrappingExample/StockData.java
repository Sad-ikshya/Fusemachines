package webScrappingExample;

public class StockData {
    String companyName;
    int numberOfTransaction;
    double maximumPrice;
    double minimumPrice;
    double closingPrice;

    public StockData() {
    }

    public StockData(String companyName, int numberOfTransaction, double maximumPrice, double minimumPrice,
            double closingPrice) {
        this.companyName = companyName;
        this.numberOfTransaction = numberOfTransaction;
        this.maximumPrice = maximumPrice;
        this.minimumPrice = minimumPrice;
        this.closingPrice = closingPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getNumberOfTransaction() {
        return numberOfTransaction;
    }

    public double getMaximumPrice() {
        return maximumPrice;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public double getClosingPrice() {
        return closingPrice;
    }
}
