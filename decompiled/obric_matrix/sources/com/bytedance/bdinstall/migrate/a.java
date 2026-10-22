package com.bytedance.bdinstall.migrate;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdinstall.d1.h;
import com.bytedance.bdinstall.q;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PackageManager f2845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f2846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedPreferences f2848d;

    @WorkerThread
    public a(Context r3) {
        Context r0 = r3.getApplicationContext();
        this.f2848d = h.a(r3);
        this.f2845a = r0.getPackageManager();
        this.f2846b = new ComponentName(r3, MigrateDetectorActivity.class);
        boolean r4 = f();
        this.f2847c = r4;
        q.a("MigrateDetector#constructor migrate=" + r4);
    }

    private int b() {
        return this.f2845a.getComponentEnabledSetting(this.f2846b);
    }

    private static String c(int r1) {
        if (r1 != 0) goto L4;
        return "STATE_DEFAULT";
    L4:
        if (r1 != 1) goto L6;
        return "STATE_ENABLED";
    L6:
        if (r1 == 2) goto L9;
        return "UNKNOWN";
    L9:
        return "STATE_DISABLED";
    }

    @Nullable
    public static String d(Context r2) {
        return h.a(r2).getString("old_did", null);
    }

    private boolean f() {
        int r1 = b();     // Catch: Exception -> L11
        int r4 = this.f2848d.getInt("component_state", 0);
        q.a("MigrateDetector#isMigrateInternal cs=" + c(r1) + " ss=" + c(r4));
        if (r1 != 0) goto L10;
        if (r4 != 2) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean g(Context r2) {
        return h.a(r2).getBoolean("is_migrate", false);
    }

    public static void h(Context r1, String r2, boolean r3) {
        SharedPreferences.Editor r4 = h.a(r1).edit();
        r4.putString("old_did", r2);
        if (r3 == false) goto L5;
        r4.putBoolean("is_migrate", true);
    L6:
        r4.apply();
        return;
    L5:
        r4.remove("is_migrate");
        goto L6
    }

    public void a() {
        q.a("MigrateDetector#disableComponent");
        this.f2845a.setComponentEnabledSetting(this.f2846b, 2, 1);     // Catch: Exception -> L5
        this.f2848d.edit().putInt("component_state", 2).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        q.d("MigrateDetector#disableComponent error", e);
    }

    public boolean e() {
        return this.f2847c;
    }
}
