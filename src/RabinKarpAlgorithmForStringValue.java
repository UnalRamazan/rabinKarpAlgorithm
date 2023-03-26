public class RabinKarpAlgorithmForStringValue {

    private int constant = 10;

    public RabinKarpAlgorithmForStringValue() {

    }

    public void search(String text, String pattern) {

        int sizeOfText = text.length();
        int sizeOfPattern = pattern.length();
        int hashValue = 0;
        int hashValueOfPattern = 0;
        boolean isResult = false;

        //check size pattern
        if (sizeOfPattern > sizeOfText) {
            System.out.println("Pattern size cannot be larger than the text. Please try again!");

        } else {

            long getStartTime = System.currentTimeMillis();//take start time

            int size = sizeOfPattern - 1;
            for (int i = 0; i < sizeOfPattern; i++) {

                hashValue += (Math.pow(constant, size) * text.charAt(i));//calculate hash value for first part in text
                hashValueOfPattern += (Math.pow(constant, size) * pattern.charAt(i));//calculate hash value for pattern

                size--;
            }

            for (int i = 0; i <= sizeOfText - sizeOfPattern; i++) {

                if (hashValue == hashValueOfPattern) {

                    int j;
                    for (j = 0; j < sizeOfPattern; j++) {

                        if (text.charAt(i+ j) != pattern.charAt(j)) {
                            break;
                        }
                    }

                    if (j == sizeOfPattern) {
                        isResult = true;
                        System.out.println("Pattern found at index: " + i);
                    }
                }

                //Calculate hash value for next part of text:
                int temp = (int) Math.pow(constant, sizeOfPattern - 1);
                if (i < (sizeOfText - sizeOfPattern)) {

                    hashValue = (constant * (hashValue - (text.charAt(i) * temp)) + text.charAt(i + sizeOfPattern));
                }
            }

            if (!isResult) {
                System.out.println("No results found!");
            }

            long getEndTime = System.currentTimeMillis();//take finish time
            long getEstimatedTime = getEndTime - getStartTime;
            double getTotalTime = (double) getEstimatedTime / 1000;//saniyeye çevirmek için 1000'e bölüyoruz.

            System.out.println("Total time: " + getTotalTime + " second");
        }
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }
}