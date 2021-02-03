package sk.itsovy.kutka;

import java.util.function.Predicate;

public class PredicateFromNLD<T> implements Predicate<City> {
    @Override
    public boolean test(City city) {
        return city.getCode().equals("NLD");
    }
}
