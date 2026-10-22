package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ReflectionAccessFilterHelper {

    /* JADX INFO: renamed from: com.google.gson.internal.ReflectionAccessFilterHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class AccessChecker {
        public static final AccessChecker INSTANCE = null;

        public abstract boolean canAccess(AccessibleObject r1, Object r2);

        private AccessChecker() {
        }

        /* synthetic */ AccessChecker(AnonymousClass1 r1) {
            this();
        }

        static {
            if (JavaVersion.isJava9OrLater() == true) goto L12;
        L6:
            AccessChecker r1 = null;
        L7:
            if (r1 != null) goto L9;
            r1 = new AnonymousClass2();
        L9:
            INSTANCE = r1;
            return;
        L12:
            final Method r0 = AccessibleObject.class.getDeclaredMethod("canAccess", new Class[]{Object.class});     // Catch: NoSuchMethodException -> L11
            r1 = new AnonymousClass1(r0);     // Catch: NoSuchMethodException -> L11
            goto L7
        }
    }

    private ReflectionAccessFilterHelper() {
    }

    public static boolean isJavaType(Class<?> r0) {
        return isJavaType(r0.getName());
    }

    private static boolean isJavaType(String r1) {
        if (r1.startsWith("java.") == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.startsWith("javax.") == true) goto L8;
        return false;
    }

    public static boolean isAndroidType(Class<?> r0) {
        return isAndroidType(r0.getName());
    }

    private static boolean isAndroidType(String r1) {
        if (r1.startsWith("android.") == false) goto L5;
    L10:
        return true;
    L5:
        if (r1.startsWith("androidx.") == true) goto L10;
        if (isJavaType(r1) == true) goto L10;
        return false;
    }

    public static boolean isAnyPlatformType(Class<?> r1) {
        String r2 = r1.getName();
        if (isAndroidType(r2) == false) goto L5;
    L12:
        return true;
    L5:
        if (r2.startsWith("kotlin.") == true) goto L12;
        if (r2.startsWith("kotlinx.") == true) goto L12;
        if (r2.startsWith("scala.") == true) goto L12;
        return false;
    }

    public static ReflectionAccessFilter.FilterResult getFilterResult(List<ReflectionAccessFilter> r2, Class<?> r3) {
        Iterator<ReflectionAccessFilter> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        ReflectionAccessFilter.FilterResult r0 = r4.next().check(r3);
        if (r0 == ReflectionAccessFilter.FilterResult.INDECISIVE) goto L4;
        return r0;
    L9:
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }

    public static boolean canAccess(AccessibleObject r1, Object r2) {
        return AccessChecker.INSTANCE.canAccess(r1, r2);
    }
}
