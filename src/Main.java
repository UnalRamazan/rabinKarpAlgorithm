public class Main {
    public static void main(String[] args) {

        String text = "qwertyuiopasdfghjklzxcvbnm";
        String pattern = "ui";

        RabinKarpAlgorithmForStringValue rabinKarpAlgorithmForStringValue = new RabinKarpAlgorithmForStringValue();

        rabinKarpAlgorithmForStringValue.search(text, pattern);
    }
}