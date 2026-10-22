package com.ss.android.ugc.aweme.framework.services;

/* JADX INFO: loaded from: classes5.dex */
public final class Defaults {
    private static final Double DOUBLE_DEFAULT = null;
    private static final Float FLOAT_DEFAULT = null;

    private Defaults() {
    }

    static {
        DOUBLE_DEFAULT = Double.valueOf(0.0d);
        FLOAT_DEFAULT = Float.valueOf(0.0f);
    }

    public static <T> T defaultValue(Class<T> r2) {
        requireNonNull(r2);
        if (r2 != Boolean.TYPE) goto L7;
        return (T) Boolean.FALSE;
    L7:
        if (r2 != Character.TYPE) goto L11;
        return (T) (char) 0;
    L11:
        if (r2 != Byte.TYPE) goto L15;
        return (T) (byte) 0;
    L15:
        if (r2 != Short.TYPE) goto L19;
        return (T) (short) 0;
    L19:
        if (r2 != Integer.TYPE) goto L23;
        return (T) 0;
    L23:
        if (r2 != Long.TYPE) goto L27;
        return (T) 0L;
    L27:
        if (r2 != Float.TYPE) goto L31;
        return (T) FLOAT_DEFAULT;
    L31:
        if (r2 == Double.TYPE) goto L33;
        return null;
    L33:
        return (T) DOUBLE_DEFAULT;
    }

    public static <T> T requireNonNull(T r0) {
        r0.getClass();
        return r0;
    }
}
