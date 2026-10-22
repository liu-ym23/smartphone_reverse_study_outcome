package ru;

import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21796a = null;

    static {
        int[] r5 = new int[Level.values().length];
        r5[Level.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r5[Level.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r5[Level.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r5[Level.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        f21796a = r5;
    }
}
