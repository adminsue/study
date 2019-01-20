package com.adminsue.study.structure.set;

import java.util.Objects;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-20.
 */
public class SimpleObject {

    private Integer simpleInt;
    private String simpleString;
    private simpleSon simpleSon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleObject that = (SimpleObject) o;
        return Objects.equals(simpleInt, that.simpleInt) &&
                Objects.equals(simpleString, that.simpleString) &&
                Objects.equals(simpleSon, that.simpleSon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simpleInt, simpleString, simpleSon);
    }

    private static class simpleSon {
        private String sonString;
    }

}
