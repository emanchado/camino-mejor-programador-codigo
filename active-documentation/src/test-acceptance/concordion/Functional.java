package concordion;

import java.util.ArrayList;
import java.util.List;

public class Functional {
    public static <T, U> List<U> collect(List<T> ts, Functor<T, U> functor) {
        ArrayList<U> us = new ArrayList<U>();
        for (T t : ts) {
            us.add(functor.execute(t));
        }
        return us;
    }

    public static String join(List<String> strings, String joiner) {
        if (strings.isEmpty()) {
            return "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(strings.get(0));

            for (int i = 1; i < strings.size(); i++) {
                stringBuilder.append(joiner).append(strings.get(i));
            }
            return stringBuilder.toString();
        }
    }

    public static interface Functor<T, U> {
        U execute(T element);
    }
}
