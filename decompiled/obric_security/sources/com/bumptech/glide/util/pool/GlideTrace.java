package com.bumptech.glide.util.pool;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class GlideTrace {
    private static final AtomicInteger COOKIE_CREATOR = null;
    private static final int MAX_LENGTH = 127;
    private static final boolean TRACING_ENABLED = false;

    static {
    }

    public static void beginSection(String r0) {
    }

    public static int beginSectionAsync(String r0) {
        return -1;
    }

    public static void beginSectionFormat(String r0, Object r1) {
    }

    public static void beginSectionFormat(String r0, Object r1, Object r2) {
    }

    public static void beginSectionFormat(String r0, Object r1, Object r2, Object r3) {
    }

    public static void endSection() {
    }

    public static void endSectionAsync(String r0, int r1) {
    }

    private GlideTrace() {
    }

    private static String truncateTag(String r2) {
        if (r2.length() > 127) goto L5;
        return r2;
    L5:
        return r2.substring(0, 126);
    }
}
