package com.bytedance.monitor.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = null;
    private static final Map<Class<?>, Class<?>> originalWrapperMap = null;
    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = null;

    private static boolean isPackageAccess(int r0) {
        if ((r0 & 7) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    MemberUtils() {
    }

    static {
        ORDERED_PRIMITIVE_TYPES = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        HashMap r0 = new HashMap();
        originalWrapperMap = r0;
        wrapperPrimitiveMap = new HashMap();
        r0.put(Byte.TYPE, Byte.class);
        r0.put(Boolean.TYPE, Boolean.class);
        r0.put(Short.TYPE, Short.class);
        r0.put(Character.TYPE, Character.class);
        r0.put(Long.TYPE, Long.class);
        r0.put(Integer.TYPE, Integer.class);
        r0.put(Float.TYPE, Float.class);
        r0.put(Double.TYPE, Double.class);
        r0.put(Void.TYPE, Void.TYPE);
        Iterator r1 = r0.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Class<?> r2 = (Class) r1.next();
        Class<?> r3 = originalWrapperMap.get(r2);
        if (r2.equals(r3) == true) goto L4;
        wrapperPrimitiveMap.put(r3, r2);
        goto L4
    }

    static boolean isAccessible(Member r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (Modifier.isPublic(r1.getModifiers()) == false) goto L8;
        if (r1.isSynthetic() == true) goto L8;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean setAccessible(AccessibleObject r3) {
        if (r3 != 0) goto L5;
    L16:
        return false;
    L5:
        if (r3.isAccessible() == true) goto L16;
        Member r1 = (Member) r3;
        if (r3.isAccessible() == true) goto L16;
        if (Modifier.isPublic(r1.getModifiers()) == false) goto L16;
        if (isPackageAccess(r1.getDeclaringClass().getModifiers()) == false) goto L16;
        r3.setAccessible(true);     // Catch: Exception -> L17
        return true;
    }

    static boolean isAssignable(Class<?> r1, Class<?> r2) {
        return isAssignable(r1, r2, true);
    }

    static boolean isAssignable(Class<?>[] r4, Class<?>[] r5, boolean r6) {
        if (InnerUtils.hasSameLength(r4, r5) == true) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
        r4 = InnerUtils.EMPTY_CLASS_ARRAY;
    L7:
        if (r5 != null) goto L9;
        r5 = InnerUtils.EMPTY_CLASS_ARRAY;
    L9:
        int r0 = 0;
    L11:
        if (r0 >= r4.length) goto L16;
        if (isAssignable(r4[r0], r5[r0], r6) == false) goto L14;
        r0 = r0 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    }

    static boolean isAssignable(Class<?> r2, Class<?> r3, boolean r4) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r2 == null) goto L8;
        if (r4 == false) goto L25;
        if (r2.isPrimitive() == false) goto L18;
        if (r3.isPrimitive() == true) goto L18;
        r2 = primitiveToWrapper(r2);
        if (r2 != null) goto L18;
        return false;
    L18:
        if (r3.isPrimitive() == false) goto L25;
        if (r2.isPrimitive() == true) goto L25;
        r2 = wrapperToPrimitive(r2);
        if (r2 != null) goto L25;
        return false;
    L25:
        if (r2.equals(r3) == false) goto L28;
        return true;
    L28:
        if (r2.isPrimitive() == false) goto L32;
        return isAssignableFrom(r2, r3);
    L32:
        return r3.isAssignableFrom(r2);
    L8:
        return !r3.isPrimitive();
    }

    private static boolean isAssignableFrom(Class<?> r4, Class<?> r5) {
        if (r5.isPrimitive() == true) goto L6;
        return false;
    L6:
        if (Integer.TYPE.equals(r4) == false) goto L16;
        if (Long.TYPE.equals(r5) == true) goto L14;
        if (Float.TYPE.equals(r5) == true) goto L14;
        if (Double.TYPE.equals(r5) == true) goto L14;
        return false;
    L14:
        return true;
    L16:
        if (Long.TYPE.equals(r4) == false) goto L24;
        if (Float.TYPE.equals(r5) == true) goto L22;
        if (Double.TYPE.equals(r5) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        if (Boolean.TYPE.equals(r4) == false) goto L26;
    L56:
        return false;
    L26:
        if (Double.TYPE.equals(r4) == true) goto L56;
        if (Float.TYPE.equals(r4) == false) goto L33;
        return Double.TYPE.equals(r5);
    L33:
        if (Integer.TYPE.equals(r5) == false) goto L35;
    L42:
        boolean r0 = true;
    L44:
        if (Character.TYPE.equals(r4) == false) goto L46;
    L55:
        return r0;
    L46:
        if (Short.TYPE.equals(r4) == true) goto L55;
        if (Byte.TYPE.equals(r4) == true) goto L51;
        return false;
    L51:
        if (Short.TYPE.equals(r5) == true) goto L54;
        if (r0 == true) goto L54;
        return false;
    L54:
        return true;
    L35:
        if (Long.TYPE.equals(r5) == true) goto L42;
        if (Float.TYPE.equals(r5) == true) goto L42;
        if (Double.TYPE.equals(r5) == true) goto L42;
        r0 = false;
        goto L44
    }

    static Class<?> primitiveToWrapper(Class<?> r1) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.isPrimitive() == true) goto L6;
        return r1;
    L6:
        return originalWrapperMap.get(r1);
    }

    private static float getPrimitivePromotionCost(Class<?> r5, Class<?> r6) {
        if (r5.isPrimitive() == true) goto L5;
        r5 = wrapperToPrimitive(r5);
        float r0 = 0.1f;
    L6:
        int r2 = 0;
    L7:
        if (r5 == r6) goto L16;
        Class<?>[] r3 = ORDERED_PRIMITIVE_TYPES;
        if (r2 >= r3.length) goto L16;
        if (r5 != r3[r2]) goto L15;
        r0 = r0 + 0.1f;
        if (r2 >= (r3.length - 1)) goto L15;
        r5 = r3[r2 + 1];
    L15:
        r2 = r2 + 1;
    L16:
        return r0;
    L5:
        r0 = 0.0f;
        goto L6
    }

    static Class<?> wrapperToPrimitive(Class<?> r1) {
        return wrapperPrimitiveMap.get(r1);
    }

    static int compareParameterTypes(Class<?>[] r0, Class<?>[] r1, Class<?>[] r2) {
        float r3 = getTotalTransformationCost(r2, r0);
        float r4 = getTotalTransformationCost(r2, r1);
        if (r3 >= r4) goto L6;
        return -1;
    L6:
        if (r4 >= r3) goto L8;
        return 1;
    L8:
        return 0;
    }

    private static float getObjectTransformationCost(Class<?> r2, Class<?> r3) {
        if (r3.isPrimitive() == true) goto L5;
        float r0 = 0.0f;
    L7:
        if (r2 == null) goto L16;
        if (r3.equals(r2) == true) goto L16;
        if (r3.isInterface() == false) goto L15;
        if (isAssignable(r2, r3) == false) goto L15;
        r0 = r0 + 0.25f;
    L15:
        r0 = r0 + 1.0f;
        r2 = r2.getSuperclass();
    L16:
        if (r2 == null) goto L18;
        return r0;
    L18:
        return r0 + 1.5f;
    L5:
        return getPrimitivePromotionCost(r2, r3);
    }

    private static float getTotalTransformationCost(Class<?>[] r4, Class<?>[] r5) {
        float r0 = 0.0f;
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L6;
        r0 = r0 + getObjectTransformationCost(r4[r1], r5[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
