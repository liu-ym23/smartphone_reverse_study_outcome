package sj;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f21922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f21923c = null;
    public static volatile SharedPreferences d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Context f21924a;

    static {
        f21923c = new Object();
    }

    public f(Context r5) {
        if (r5 == null) goto L13;
        this.f21924a = r5.getApplicationContext();
    L13:
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (d != null) goto L8;
        d = this.f21924a.getSharedPreferences("image_opt_table", 0);     // Catch: Throwable -> L10
    L8:
        SharedPreferences r10 = d;     // Catch: Throwable -> L10
        r10.getInt("image_opt_switch", 0);     // Catch: Throwable -> L10
        r10.getLong("image_opt_black_interval", 0);     // Catch: Throwable -> L10
        r10.getInt("image_opt_failed_times", 0);     // Catch: Throwable -> L10
        r10.getInt("image_opt_limit_count", 0);     // Catch: Throwable -> L10
    }
}
