package com.bytedance.librarian;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class Librarian {
    static Context sContext;
    private static final Object sLock = null;
    static LibrarianMonitor sMonitor;
    static volatile String sVersion;

    static {
        sLock = new Object();
    }

    public Librarian() {
    }

    public static UnsatisfiedLinkError[] getErrors() {
        return LibrarianUnsatisfiedLinkError.getErrors();
    }

    public static String getInnerInfo() {
        LibrarianImpl r0 = LibrarianImpl.instance;
        if (r0 == null) goto L7;
        return sVersion + r0.getLoadedLibsInfo();
    L7:
        return sVersion;
    }

    public static void init(Context r2, String r3, LibrarianMonitor r4) {
        Object r0 = sLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sVersion == null) goto L11;
        Log.w(LibrarianImpl.Constants.TAG, "already set init, just skip...");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r2 == null) goto L17;
        if (r3 == null) goto L17;
        sContext = r2;
        sVersion = r3;
        sMonitor = r4;
        return;
    L17:
        throw new IllegalStateException("context or version is null in init");
    }

    public static void loadLibrary(String r2) {
        loadLibraryInternal(r2, false, false, null);
    }

    public static void loadLibraryForModule(String r2, Context r3) {
        loadLibraryInternal(r2, false, true, r3);
    }

    public static void loadLibraryForModuleRecursively(String r1, Context r2) {
        loadLibraryInternal(r1, true, true, r2);
    }

    private static void loadLibraryInternal(String r0, boolean r1, boolean r2, Context r3) {
        if (r2 == true) goto L4;
    L6:
        LibrarianImpl r4 = LibrarianImpl.instance;
        if (r4 == null) goto L9;
        r4.loadLibrary(r0, r1);
        return;
    L9:
        LibrarianMonitor r5 = sMonitor;
        if (r5 == null) goto L12;
        r5.systemLoadLibrary(r0);
        return;
    L12:
        System.loadLibrary(r0);
        return;
    L4:
        if (sContext != null) goto L6;
        sContext = r3;
        goto L6
    }

    public static void loadLibraryRecursively(String r3) {
        loadLibraryInternal(r3, true, false, null);
    }
}
