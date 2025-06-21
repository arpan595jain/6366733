public class FinancialForecasting {
    public static void main(String[] args) {
        int[] months = {1, 2, 3, 4, 5, 6};
        int[] revenue = {200, 220, 240, 260, 280, 300};

        int n = months.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        for (int i = 0; i < n; i++) {
            sumX += months[i];
            sumY += revenue[i];
            sumXY += months[i] * revenue[i];
            sumX2 += months[i] * months[i];
        }

        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;
        System.out.println("Revenue Forecast:");
        for (int i = 7; i <= 9; i++) {
            double prediction = slope * i + intercept;
            System.out.println("Month " + i+": " + (int) prediction);
        }
    }
}
