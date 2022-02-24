class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] complex1 = num1.split("\\+");
        int real1 = Integer.valueOf(complex1[0]);
        int imag1 = Integer.valueOf(complex1[1].substring(0, complex1[1].length() - 1));

        String[] complex2 = num2.split("\\+");
        int real2 = Integer.valueOf(complex2[0]);
        int imag2 = Integer.valueOf(complex2[1].substring(0, complex2[1].length() - 1));

        int real = real1 * real2 - imag1 * imag2;
        int imag = real1 * imag2 + real2 * imag1;
        
        return String.valueOf(real) + "+" + String.valueOf(imag) + "i";
    }
}