package com.health.util;

import java.util.Collection;

/**
 * Created by forip on 2017/4/22.
 */
public class CollectionsUtil {

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(Collection collection) {
        return (collection == null) || collection.isEmpty();
    }

    /**
     * 判断集合是否不为空
     */
    public static boolean isNotEmpty(Collection collection) {
        return (collection != null) && !(collection.isEmpty());
    }
}
