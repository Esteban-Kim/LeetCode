class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;

        int length = brackets.length, previousUpper = 0;

        for (int index = 0; index < length; index++) {
            int[] bracket = brackets[index];
            int upper = bracket[0], taxRate = bracket[1];

            if (income < previousUpper) {
                break;
            }

            double totalAmountToTax = Math.min(upper, income)-previousUpper;
            double taxRateModified = ((double)taxRate/100);
            tax += (totalAmountToTax*taxRateModified);

            previousUpper = upper;
        }

        return tax;
    }
}