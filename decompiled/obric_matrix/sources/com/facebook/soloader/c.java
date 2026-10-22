package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class c extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final File f6809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f6810b;

    public c(File r1, int r2) {
        this.f6809a = r1;
        this.f6810b = r2;
    }

    private static String[] c(File r3) {
        boolean r0 = SoLoader.f6785a;
        if (r0 == false) goto L14;
        Api18TraceUtils.a("SoLoader.getElfDependencies[" + r3.getName() + "]");
    L14:
        String[] r4 = i.a(r3);     // Catch: Throwable -> L9
        if (r0 == false) goto L8;
        Api18TraceUtils.b();
    L8:
        return r4;
    L9:
        th = move-exception;
        if (SoLoader.f6785a == false) goto L13;
        Api18TraceUtils.b();
    L13:
        throw th;
    }

    private void d(File r3, int r4, StrictMode.ThreadPolicy r5) {
        String[] r2 = c(r3);
        Log.d("SoLoader", "Loading lib dependencies: " + Arrays.toString(r2));
        int r6 = 0;
    L4:
        if (r6 >= r2.length) goto L10;
        String r0 = r2[r6];
        if (r0.startsWith("/") == true) goto L9;
        SoLoader.j(r0, r4 | 1, r5);
    L9:
        r6 = r6 + 1;
        goto L4
    }

    @Override // com.facebook.soloader.k
    public int a(String r2, int r3, StrictMode.ThreadPolicy r4) {
        return e(r2, r3, this.f6809a, r4);
    }

    protected int e(String r5, int r6, File r7, StrictMode.ThreadPolicy r8) {
        File r0 = new File(r7, r5);
        if (r0.exists() == true) goto L6;
        Log.d("SoLoader", r5 + " not found on " + r7.getCanonicalPath());
        return 0;
    L6:
        Log.d("SoLoader", r5 + " found on " + r7.getCanonicalPath());
        if ((r6 & 1) == 0) goto L13;
        if ((this.f6810b & 2) == 0) goto L13;
        Log.d("SoLoader", r5 + " loaded implicitly");
        return 2;
    L13:
        if ((this.f6810b & 1) == 0) goto L15;
        d(r0, r6, r8);
    L24:
        SoLoader.f6786b.a(r0.getAbsolutePath(), r6);     // Catch: UnsatisfiedLinkError -> L18
        return 1;
    L18:
        e = move-exception;
        if (e.getMessage().contains("bad ELF magic") == false) goto L23;
        Log.d("SoLoader", "Corrupted lib file detected");
        return 3;
    L23:
        throw e;
    L15:
        Log.d("SoLoader", "Not resolving dependencies for " + r5);
        goto L24
    }

    @Override // com.facebook.soloader.k
    public String toString() {
        String r0 = String.valueOf(this.f6809a.getCanonicalPath());     // Catch: IOException -> L4
    L6:
        return getClass().getName() + "[root = " + r0 + " flags = " + this.f6810b + ']';
    L4:
        r0 = this.f6809a.getName();
        goto L6
    }
}
