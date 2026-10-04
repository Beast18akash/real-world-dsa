import java.util.HashSet;

class Main {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        String[] ones = {
            "", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tens = {
            "", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety"
        };

        int result = 0;

        for (int num : nums) {

            String text;

            if (num < 20) {
                text = ones[num];
            } else if (num < 100) {
                text = tens[num / 10];

                if (num % 10 != 0) {
                    text += " " + ones[num % 10];
                }
            } else {
                text = "hundred";
            }

            for (int j = 0; j < text.length(); j++) {
                if (isVowel(text.charAt(j))) {
                    result++;
                }
            }
        }

        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            int required = result - num;

            if (set.contains(required)) {
                count++;
            }

            set.add(num);
        }

        String answer;

        if (count < 20) {
            answer = ones[count];
        } else if (count < 100) {
            answer = tens[count / 10];

            if (count % 10 != 0) {
                answer += " " + ones[count % 10];
            }
        } else if (count == 100) {
            answer = "hundred";
        } else {
            answer = "greater 100";
        }

        System.out.println(answer);
    }

    public static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}