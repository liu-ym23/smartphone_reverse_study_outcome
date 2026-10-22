package com.bytedanceos.application;

import com.bytedanceos.security.permission.PermissionApp;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class AppComparator {
    public static final Comparator<AppEntry> ALPHA_COMPARATOR = null;
    public static final Comparator<PermissionApp> PERMISSIONAPP_COMPARATOR = null;

    public AppComparator() {
    }

    static {
        ALPHA_COMPARATOR = new AnonymousClass1();
        PERMISSIONAPP_COMPARATOR = new AnonymousClass2();
    }
}
