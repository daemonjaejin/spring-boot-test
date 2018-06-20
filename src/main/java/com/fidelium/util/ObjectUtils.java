package com.fidelium.util;

import java.util.Arrays;

public class ObjectUtils {

    private ObjectUtils() {
    }

    /**
     * private 배열 public Get,Set Util
     * 
     * @param args
     * @return array
     */
    public static final <T> T[] reallocate(final T[] args) {
        T[] returnArray = null;
        if (args != null) {
            returnArray = Arrays.copyOf(args, args.length);
        }
        return returnArray;
    }

}
