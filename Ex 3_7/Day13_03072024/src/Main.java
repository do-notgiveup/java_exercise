import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //-----------------------------------------------
        // bai 1
        // lam theo cach thuong
        //getMaxPrimeDivisor(77);

        // lam theo lambda
        IMaxPrimeDivisorInterface x = (num) -> {
            int max = 2;
            for (int i = 2; i <= (int) num; i++) {
                //la so nguyen to va la uoc
                if (isPrime(i) && num % i == 0) {
                    max = i;
                    num = num / i;
                }
            }
            System.out.println(max);
        };
        x.getMaxDivisor(70);
        x.getMaxDivisor(176);
        x.getMaxDivisor(36);
        x.getMaxDivisor(38);

        //---------------------------------------------------
        // bai 2
        IConvertDecimalToBinaryInterface c = (num) -> {
            StringBuilder result = new StringBuilder();
            // ta cu chia num cho 2 cho den khi num < 1 va lay phan du dao nguoc
            while (num >= 1) {
                result.append(num % 2);
                num /= 2;
            }
            System.out.println(result.reverse());
        };
        c.convertDecimalToBinary(33);
        c.convertDecimalToBinary(747);
    }

    // ham phuc vu cho cach lam binh thuong
    public static void getMaxPrimeDivisor(int num) {
        int max = 2;
        for (int i = 2; i <= (int) num; i++) {
            if (isPrime(i) && num % i == 0) { //la so nguyen to
                max = i;
                num = num / i;
            }
        }
        System.out.println(max);
    }

    // ham de check so nguyen to, snt -> true else false
    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}