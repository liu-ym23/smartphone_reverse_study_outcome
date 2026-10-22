package com.obric.security.cleaner.bigfile;

import kotlin.Metadata;

/* JADX INFO: compiled from: CleanerGlobals.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/security/cleaner/bigfile/CleanerGlobals;", "", "()V", "BIG_FILE_MIN_SIZE", "", "USER10_BASE_PATH", "", "USER_DOPPELGANGER", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class CleanerGlobals {
    public static final long BIG_FILE_MIN_SIZE = 10485760;
    public static final CleanerGlobals INSTANCE = null;
    public static final String USER10_BASE_PATH = "/storage/emulated/10";
    public static final int USER_DOPPELGANGER = 10;

    static {
        INSTANCE = new CleanerGlobals();
    }

    private CleanerGlobals() {
    }
}
