package com.ss.android.token;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TokenObjectProvider extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f12195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private UriMatcher f12196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f12197h;

    public TokenObjectProvider() {
        this.f12197h = false;
    }

    public static String a(Context r5) {
        if (r5 != null) goto L16;
        return null;
    L16:
        ProviderInfo r1 = r5.getPackageManager().getProviderInfo(new ComponentName(r5.getPackageName(), TokenObjectProvider.class.getName()), 128);     // Catch: Exception -> L12
        if (r1 == null) goto L14;
        String r2 = r1.authority;     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r2) == true) goto L14;
        d.b.s.a.a0.a.a("TokenObjectProvider", "set authority at getting ProviderInfo");     // Catch: Exception -> L12
        return r2;
    L14:
        d.b.s.a.a0.a.a("TokenObjectProvider", "set authority at making");
        return r5.getPackageName() + ".TokenObjectProvider";
    L12:
        e = move-exception;
        o.f(e);
        goto L14
    }

    private boolean b(Context r5) {
        if (this.f12197h == false) goto L6;
        return true;
    L6:
        if (n.n() == true) goto L8;
        return false;
    L8:
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L10:
        if (this.f12197h == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L24
        return true;
    L14:
        if (TextUtils.isEmpty(this.f12195f) == false) goto L17;
        this.f12195f = a(r5);     // Catch: Throwable -> L24
    L17:
        if (TextUtils.isEmpty(this.f12195f) == false) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L24
        return false;
    L20:
        d.b.s.a.a0.a.a("TokenObjectProvider", "authority=" + this.f12195f);     // Catch: Throwable -> L24
        UriMatcher r6 = new UriMatcher(-1);     // Catch: Throwable -> L24
        this.f12196g = r6;     // Catch: Throwable -> L24
        r6.addURI(this.f12195f, "get_token_object", 1);     // Catch: Throwable -> L24
        this.f12196g.addURI(this.f12195f, "set_token_object", 2);     // Catch: Throwable -> L24
        this.f12196g.addURI(this.f12195f, "save_last_token", 3);     // Catch: Throwable -> L24
        this.f12196g.addURI(this.f12195f, "get_last_same_user_token", 4);     // Catch: Throwable -> L24
        this.f12196g.addURI(this.f12195f, "clear_last_token", 5);     // Catch: Throwable -> L24
        this.f12197h = true;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return this.f12197h;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r3, ProviderInfo r4) {
        if (r4 == null) goto L4;
        d.b.s.a.a0.a.a("TokenObjectProvider", "set authority at attachInfo");
        this.f12195f = r4.authority;
    L4:
        super.attachInfo(r3, r4);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        b(getContext());
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        b(getContext());
        return "vnd.android.cursor.item/vnd." + this.f12195f + ".item";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        b(getContext());
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"[ByDesign9.6]GetXTTToken"})
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        if (b(getContext()) == true) goto L5;
        return null;
    L5:
        int r0 = this.f12196g.match(r1);
        d.b.s.a.a0.a.a("TokenObjectProvider", "query, code=" + r0);
        if (r0 != 1) goto L12;
        p r6 = p.K();
        if (r6 != null) goto L10;
    L20:
        return null;
    L10:
        return r6.U().a();
    L12:
        if (r0 != 4) goto L20;
        p r7 = p.K();
        if (r7 == null) goto L20;
        String r8 = r7.L();
        MatrixCursor r9 = new MatrixCursor(new String[]{"last_token"});     // Catch: Exception -> L18
        r9.newRow().add(r8);     // Catch: Exception -> L18
        return r9;
    L18:
        e = move-exception;
        o.f(e);
        goto L20
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        if (b(getContext()) == true) goto L5;
        return 0;
    L5:
        int r0 = this.f12196g.match(r1);
        d.b.s.a.a0.a.a("TokenObjectProvider", "update, code=" + r0);
        if (r0 != 2) goto L11;
        p r5 = p.K();
        if (r5 == null) goto L20;
        t r6 = r5.U();
        r5.G0(t.d(r1));
        o.c("sub_thread", r6.f12309a);
    L20:
        return 0;
    L11:
        if (r0 != 3) goto L16;
        p r7 = p.K();
        if (r7 == null) goto L20;
        r7.B0();
        goto L20
    L16:
        if (r0 != 5) goto L20;
        p r8 = p.K();
        if (r8 == null) goto L20;
        r8.F();
        goto L20
    }
}
