package com.obric.oui.material;

import android.util.Log;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class TokenParserCore {
    private static final String TAG = "TokenParserCore";

    private TokenParserCore() {
    }

    public static <T> ConcurrentHashMap<String, T> createTokenMap(Class<?> r3, Class<?> r4) {
        ConcurrentHashMap<String, T> r0 = new ConcurrentHashMap();
        if (r3 == null) goto L10;
        if (r4 == null) goto L10;
        updateTokenMap(r3, r3.getDeclaredFields(), r4, r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Log.e(TAG, "Failed to parse tokens from class:" + r3.getSimpleName(), th);
    L10:
        return r0;
    }

    public static <T> ConcurrentHashMap<String, T> createTokenMap(Object r3, Class<?> r4) {
        ConcurrentHashMap<String, T> r0 = new ConcurrentHashMap();
        if (r3 == null) goto L10;
        if (r4 == null) goto L10;
        updateTokenMap(r3, r3.getClass().getDeclaredFields(), r4, r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Log.e(TAG, "Failed to parse tokens from " + r3.getClass().getSimpleName(), th);
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> ConcurrentHashMap<String, T> updateTokenMap(Object r5, Field[] r6, Class<?> r7, ConcurrentHashMap<String, T> r8) throws Exception {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        Field r2 = r6[r1];
        if (isTypeCompatible(r7, r2.getType()) == false) goto L10;
        r2.setAccessible(true);
        Object r3 = r2.get(r5);
        if (r3 == null) goto L10;
        r8.put(r2.getName().toLowerCase(Locale.ROOT), r3);
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        return r8;
    }

    public static <T> T parse(String r2, Map<String, T> r3) {
        if (r2 == null) goto L11;
        if (r3 == null) goto L11;
        String r4 = r2.toLowerCase(Locale.ROOT).trim();
        if (r4.length() != 0) goto L10;
        return null;
    L10:
        return r3.get(r4);
    L11:
        return null;
    }

    public static <T> void register(ConcurrentHashMap<String, T> r0, Object r1, Class<?> r2, boolean r3) {
        registerTokens(r0, createTokenMap(r1, r2), r3);
    }

    public static <T> void registerTokens(ConcurrentHashMap<String, T> r3, Map<String, ? extends T> r4, boolean r5) {
        if (r3 == null) goto L19;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L31;
        Iterator<Map.Entry<String, ? extends T>> r6 = r4.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L32;
        Map.Entry<String, ? extends T> r0 = r6.next();
        String r1 = r0.getKey();
        if (r1 == null) goto L9;
        String r2 = r1.toLowerCase(Locale.ROOT).trim();
        if (r2.length() == 0) goto L9;
        if (r5 == true) goto L17;
        r3.putIfAbsent(r2, r0.getValue());
        goto L9
    L17:
        r3.put(r2, r0.getValue());
        goto L9
    L32:
        return;
    L31:
        return;
    }

    private static boolean isTypeCompatible(Class<?> r3, Class<?> r4) {
        if (r3.isAssignableFrom(r4) == false) goto L6;
        return true;
    L6:
        if (r4.isPrimitive() == true) goto L9;
        return false;
    L9:
        if (r4 != Float.TYPE) goto L13;
        if (r3 != Float.class) goto L13;
        return true;
    L13:
        if (r4 != Integer.TYPE) goto L17;
        if (r3 != Integer.class) goto L17;
        return true;
    L17:
        if (r4 != Boolean.TYPE) goto L21;
        if (r3 != Boolean.class) goto L21;
        return true;
    L21:
        if (r4 != Long.TYPE) goto L25;
        if (r3 != Long.class) goto L25;
        return true;
    L25:
        if (r4 != Double.TYPE) goto L29;
        if (r3 != Double.class) goto L29;
        return true;
    L29:
        if (r4 != Short.TYPE) goto L33;
        if (r3 != Short.class) goto L33;
        return true;
    L33:
        if (r4 != Byte.TYPE) goto L37;
        if (r3 != Byte.class) goto L37;
        return true;
    L37:
        if (r4 != Character.TYPE) goto L42;
        if (r3 != Character.class) goto L42;
        return true;
    L42:
        return false;
    }
}
