import java.util.*;
import java.util.stream.Collectors;

public class SpringArray {
    SpringArray(){};
    private static int index = 0;
    private static List<Spring> listOfSprings;

    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";
    private static final String OPENING_BRACE = "{";
    private static final String CLOSING_BRACE= "}";
    private static final List<String> OPENERS = List.of(OPENING_BRACE, OPENING_BRACKET);
    private static final List<String> CLOSERS = List.of(CLOSING_BRACE, CLOSING_BRACKET);

    public static Spring equivalentSpring(String springExpr) {
        listOfSprings = new ArrayList<>();
        ArrayList<List<Integer>> indexPairs = getIndexPairs(springExpr);
        return solve(springExpr, indexPairs);
    }

    public static Spring equivalentSpring(String springExpr, Spring[] springs) {
        listOfSprings = Arrays.stream(springs).collect(Collectors.toList());
        ArrayList<List<Integer>> indexPairs = getIndexPairs(springExpr);
        return solve(springExpr, indexPairs);
    }

    protected static ArrayList<List<Integer>> getIndexPairs(String springExpr) {
        ArrayList<List<Integer>> indexes = new ArrayList<>();

        for (int i = 0; i < springExpr.length(); i++) {
            if (OPENERS.contains(Character.toString(springExpr.charAt(i)))) {
                indexes.add(List.of(i, getClosingIndex(springExpr, i)));
            }
        }
        return indexes;
    }

    private static int getClosingIndex(String springExpr, int index) {

        String current = Character.toString(springExpr.charAt(index));
        String openingBr = "";
        String closingBr = "";
        if(current.equalsIgnoreCase(OPENING_BRACE)){
            openingBr = OPENING_BRACE;
        }else {
            openingBr = OPENING_BRACKET;
        }
        if(current.equalsIgnoreCase(CLOSING_BRACE)) {
            closingBr = CLOSING_BRACE;
        }else {
            closingBr = CLOSING_BRACKET;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(current);

        for (int i = index + 1; i<springExpr.length(); i++) {
            String charNow = Character.toString(springExpr.charAt(i));
            if (charNow.equals(closingBr)) {
                queue.poll();
            }else if (charNow.equals(openingBr)) {
                queue.add(charNow);
            }
            if (queue.size() == 0) {
                return i;
            }
        }
        throw new IllegalArgumentException("The Spring Expression is Invalid");
    }

    private static Spring solve(String springExpr, ArrayList<List<Integer>> indexes) {
        int start = 0;
        int end = springExpr.length();
        if (start==end-1) {
            if (listOfSprings.size()!= 0) {
                return listOfSprings.get(index++);
            } else {
                return new Spring();
            }
        }
                return null;
    }
}

