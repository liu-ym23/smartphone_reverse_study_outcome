package com.bytedance.services.apm.api;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class EnsureManager {
    private static IEnsure sEnsure;

    private EnsureManager() {
    }

    public static void setEnsureImpl(IEnsure r0) {
        sEnsure = r0;
    }

    public static IEnsure getEnsureImpl() {
        return sEnsure;
    }

    public static boolean ensureTrue(boolean r1) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return r1;
    L5:
        r0.ensureTrue(r1);
        return r1;
    }

    public static boolean ensureFalse(boolean r1) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return r1;
    L5:
        r0.ensureFalse(r1);
        return r1;
    }

    public static boolean ensureTrue(boolean r1, String r2) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return r1;
    L5:
        r0.ensureTrue(r1, r2);
        return r1;
    }

    public static boolean ensureTrue(boolean r1, String r2, Map<String, String> r3) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return r1;
    L5:
        r0.ensureTrue(r1, r2, r3);
        return r1;
    }

    public static boolean ensureFalse(boolean r1, String r2) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return r1;
    L5:
        r0.ensureFalse(r1, r2);
        return r1;
    }

    public static boolean ensureFalse(boolean r1, String r2, Map<String, String> r3) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return r1;
    L5:
        r0.ensureFalse(r1, r2, r3);
        return r1;
    }

    public static void ensureNotReachHere() {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere();
    }

    public static void ensureNotReachHere(String r1) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1);
    }

    public static void ensureNotReachHere(Throwable r1) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1);
    }

    public static void reportLogEException(int r0, Throwable r1, String r2, boolean r3) {
        IEnsure r4 = sEnsure;
        if (r4 != null) goto L5;
        return;
    L5:
        r4.reportLogException(r0, r1, r2);
    }

    public static void ensureNotReachHere(Throwable r1, String r2) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1, r2);
    }

    public static void ensureNotReachHere(String r1, Map<String, String> r2) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1, r2);
    }

    public static void ensureNotReachHere(Throwable r1, String r2, Map<String, String> r3) {
        IEnsure r0 = sEnsure;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1, r2, r3);
    }

    public static boolean ensureNotEmpty(Collection r2) {
        if (r2 != null) goto L4;
    L6:
        boolean r0 = false;
    L7:
        IEnsure r1 = sEnsure;
        if (r1 != null) goto L10;
        return r0;
    L10:
        r1.ensureNotEmpty(r2);
        return r0;
    L4:
        if (r2.isEmpty() == true) goto L6;
        r0 = true;
        goto L7
    }

    public static boolean ensureNotNull(Object r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        IEnsure r1 = sEnsure;
        if (r1 != null) goto L8;
        return r0;
    L8:
        r1.ensureNotNull(r2);
        return r0;
    L4:
        r0 = false;
        goto L5
    }

    public static boolean ensureNotNull(Object r2, String r3) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        IEnsure r1 = sEnsure;
        if (r1 != null) goto L8;
        return r0;
    L8:
        r1.ensureNotNull(r2, r3);
        return r0;
    L4:
        r0 = false;
        goto L5
    }
}
