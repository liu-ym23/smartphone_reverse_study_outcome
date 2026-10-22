package com.bytedance.bdinstall;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class BDInstallProvider extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f2634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static UriMatcher f2635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Uri f2636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Context f2637i;

    public BDInstallProvider() {
        v0.n(true);     // Catch: Throwable -> L5
        return;
    }

    static synchronized Uri a(Context r2, String r3) {
        monitor-enter(BDInstallProvider.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f2636h == null) goto L17;
    L11:
        Uri r4 = f2636h.buildUpon().appendPath(r3).build();     // Catch: Throwable -> L14
        monitor-exit(BDInstallProvider.class);
        return r4;
    L17:
        d(r2);     // Catch: Exception -> L8 Throwable -> L14
    L8:
        return null;
    }

    static Context b() {
        return f2637i;
    }

    private static String c(Context r5, String r6) {
        if (r5 != null) goto L17;
        return null;
    L17:
        if (TextUtils.isEmpty(r6) == true) goto L15;
        ProviderInfo[] r0 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 8).providers;     // Catch: Exception -> L16
        int r1 = r0.length;     // Catch: Exception -> L16
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L15;
        ProviderInfo r3 = r0[r2];     // Catch: Exception -> L16
        if (r6.equals(r3.name) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return r3.authority;
    L15:
        return r5.getPackageName() + ".bdinstall.provider";
    }

    private static void d(Context r3) {
        if (TextUtils.isEmpty(f2634f) == false) goto L6;
        f2634f = c(r3, BDInstallProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(f2634f) == true) goto L10;
        UriMatcher r4 = new UriMatcher(-1);
        f2635g = r4;
        r4.addURI(f2634f, "*/*", 65536);
        f2636h = Uri.parse("content://" + f2634f);
        return;
    L10:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        f2637i = r2;
        if (r3 == null) goto L5;
        f2634f = r3.authority;
    L5:
        v0.n(true);
        super.attachInfo(r2, r3);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r1, @Nullable String r2, @Nullable String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri r1) {
        return "vnd.android.cursor.item/vnd." + f2634f + ".item";
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri r1, @Nullable ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (f2635g != null) goto L14;
        d(getContext());     // Catch: Exception -> L6
    L6:
        return false;
    L14:
        i.q((Application) v0.e(getContext()));     // Catch: Throwable -> L11
        return true;
    L16:
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri r1, @Nullable String[] r2, @Nullable String r3, @Nullable String[] r4, @Nullable String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r1, @Nullable ContentValues r2, @Nullable String r3, @Nullable String[] r4) {
        return 0;
    }
}
