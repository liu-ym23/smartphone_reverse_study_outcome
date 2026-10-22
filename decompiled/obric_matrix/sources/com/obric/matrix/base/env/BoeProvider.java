package com.obric.matrix.base.env;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016JO\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u0018J;\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/matrix/base/env/BoeProvider;", "Landroid/content/ContentProvider;", "()V", "mMatcher", "Landroid/content/UriMatcher;", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BoeProvider extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private UriMatcher f8834f;

    public BoeProvider() {
        UriMatcher r0 = new UriMatcher(-1);
        this.f8834f = r0;
        r0.addURI("com.obric.matrix.boe", "get_boe", 1);
        this.f8834f.addURI("com.obric.matrix.boe", "get_ppe", 2);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        o.f(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        o.f(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        o.f(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r3, String[] r4, String r5, String[] r6, String r7) {
        o.f(r3, "uri");
        String r8 = getCallingPackage();
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        boolean r9 = com.obric.matrix.q.a.a.f9829a.b(com.bytedance.mpaas.app.a.f5245g, r8);
        MatrixCursor r10 = null;
        if (r9 == true) goto L9;
        com.obric.matrix.r.c.c.f("BoeProvider", "query() isSignAuthSuccessful: " + r9);
        return null;
    L9:
        int r2 = this.f8834f.match(r3);
        if (r2 != 1) goto L12;
        MatrixCursor r0 = new MatrixCursor(new String[]{"is_boe"});     // Catch: Exception -> L28
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L26
        r11.append("query() isBoeEnable: ");     // Catch: Exception -> L26
        d r12 = d.f8838a;     // Catch: Exception -> L26
        r11.append(r12.e());     // Catch: Exception -> L26
        com.obric.matrix.r.c.c.b("BoeProvider", r11.toString());     // Catch: Exception -> L26
        if (r12.e() == false) goto L24;
        r0.addRow(new Integer[]{1});     // Catch: Exception -> L26
    L25:
        r10 = r0;
    L33:
        return r10;
    L24:
        r0.addRow(new Integer[]{0});     // Catch: Exception -> L26
        goto L25
    L12:
        if (r2 != 2) goto L34;
        r0 = new MatrixCursor(new String[]{"is_ppe"});     // Catch: Exception -> L28
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L26
        r13.append("query() isPpeEnable: ");     // Catch: Exception -> L26
        d r14 = d.f8838a;     // Catch: Exception -> L26
        r13.append(r14.f());     // Catch: Exception -> L26
        com.obric.matrix.r.c.c.b("BoeProvider", r13.toString());     // Catch: Exception -> L26
        if (r14.f() == false) goto L18;
        r0.addRow(new Integer[]{1});     // Catch: Exception -> L26
        goto L25
    L18:
        r0.addRow(new Integer[]{0});     // Catch: Exception -> L26
        goto L25
    L34:
        return null;
    L28:
        e = e;
    L29:
        com.obric.matrix.r.c.c.g("BoeProvider", "query() Exception", e);
        return r10;
    L26:
        e = e;
        r10 = r0;
        goto L29
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.f(r1, "uri");
        return 0;
    }
}
