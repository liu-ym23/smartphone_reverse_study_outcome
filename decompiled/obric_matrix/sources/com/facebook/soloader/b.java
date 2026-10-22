package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f6808c;

    public b(Context r3, int r4) {
        Context r0 = r3.getApplicationContext();
        this.f6806a = r0;
        if (r0 != null) goto L5;
        Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
        this.f6806a = r3;
    L5:
        this.f6807b = r4;
        this.f6808c = new c(new File(this.f6806a.getApplicationInfo().nativeLibraryDir), r4);
    }

    @Override // com.facebook.soloader.k
    public int a(String r1, int r2, StrictMode.ThreadPolicy r3) {
        return this.f6808c.a(r1, r2, r3);
    }

    @Override // com.facebook.soloader.k
    protected void b(int r1) {
        this.f6808c.b(r1);
    }

    public boolean c() {
        File r0 = this.f6808c.f6809a;     // Catch: PackageManager.NameNotFoundException -> L6
        Context r1 = this.f6806a;     // Catch: PackageManager.NameNotFoundException -> L6
        Context r2 = r1.createPackageContext(r1.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L6
        File r3 = new File(r2.getApplicationInfo().nativeLibraryDir);     // Catch: PackageManager.NameNotFoundException -> L6
        if (r0.equals(r3) == true) goto L11;
        Log.d("SoLoader", "Native library directory updated from " + r0 + " to " + r3);     // Catch: PackageManager.NameNotFoundException -> L6
        int r4 = this.f6807b | 1;     // Catch: PackageManager.NameNotFoundException -> L6
        this.f6807b = r4;     // Catch: PackageManager.NameNotFoundException -> L6
        c r5 = new c(r3, r4);     // Catch: PackageManager.NameNotFoundException -> L6
        this.f6808c = r5;     // Catch: PackageManager.NameNotFoundException -> L6
        r5.b(r4);     // Catch: PackageManager.NameNotFoundException -> L6
        this.f6806a = r2;     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L11:
        return false;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.facebook.soloader.k
    public String toString() {
        return this.f6808c.toString();
    }
}
