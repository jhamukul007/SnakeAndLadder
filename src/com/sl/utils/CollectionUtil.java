package com.sl.utils;

import java.util.Collection;

public class CollectionUtil {
    public static boolean isEmpty(final Collection col) {
        return col == null || col.isEmpty();
    }
}
