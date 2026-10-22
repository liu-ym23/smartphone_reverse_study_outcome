package com.android.settings.applock.data;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class AppLockComparator {
    public static Comparator<AppEntry> sAlphaComparator;
    public static Comparator<AppEntry> sSwitchComparator;

    public AppLockComparator() {
    }

    static {
        sSwitchComparator = new AnonymousClass1();
        sAlphaComparator = new AnonymousClass2();
    }
}
