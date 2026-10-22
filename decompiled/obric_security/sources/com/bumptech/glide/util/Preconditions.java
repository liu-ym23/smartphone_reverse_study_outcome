package com.bumptech.glide.util;

import android.text.TextUtils;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r1) {
        checkArgument(r1, "");
    }

    public static void checkArgument(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static <T> T checkNotNull(T r1) {
        return (T) checkNotNull(r1, "Argument must not be null");
    }

    public static <T> T checkNotNull(T r0, String r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(r1);
    }

    public static String checkNotEmpty(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T extends Collection<Y>, Y> T checkNotEmpty(T r1) {
        if (r1.isEmpty() == true) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("Must not be empty.");
    }
}
