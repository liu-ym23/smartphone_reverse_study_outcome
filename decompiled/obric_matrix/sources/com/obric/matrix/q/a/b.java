package com.obric.matrix.q.a;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.r.c.c;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J1\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J=\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!JO\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010#J;\u0010$\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010%R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006'"}, d2 = {"Lcom/obric/matrix/base/auth/BaseAuthenticationProvider;", "Landroid/content/ContentProvider;", "()V", "mMatcher", "Landroid/content/UriMatcher;", "getMMatcher", "()Landroid/content/UriMatcher;", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "", "arg", "extras", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "valus", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "queryArgs", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class b extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final UriMatcher f9839f;

    static {
    }

    public b() {
        this.f9839f = new UriMatcher(-1);
    }

    public final UriMatcher a() {
        return this.f9839f;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r1, String r2, Bundle r3) {
        o.f(r1, "method");
        String r0 = getCallingPackage();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (a.f9829a.b(com.bytedance.mpaas.app.a.f5245g, r0) == false) goto L9;
        c.b("BaseAuthenticationProvider", "call isAuth success query args");
        return null;
    L9:
        c.b("BaseAuthenticationProvider", "call isAuth failed callPkg = " + r0);
        throw new com.obric.matrix.q.c.b();
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
    public Cursor query(Uri r1, String[] r2, Bundle r3, CancellationSignal r4) {
        o.f(r1, "uri");
        String r0 = getCallingPackage();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (a.f9829a.b(com.bytedance.mpaas.app.a.f5245g, r0) == false) goto L9;
        c.b("BaseAuthenticationProvider", "query isAuth success query args");
        return null;
    L9:
        c.b("BaseAuthenticationProvider", "query isAuth failed callPkg = " + r0);
        throw new com.obric.matrix.q.c.b();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.f(r1, "uri");
        String r0 = getCallingPackage();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (a.f9829a.b(com.bytedance.mpaas.app.a.f5245g, r0) == false) goto L9;
        c.b("BaseAuthenticationProvider", "query isAuth success query selection");
        return null;
    L9:
        c.b("BaseAuthenticationProvider", "query isAuth failed callPkg = " + r0);
        throw new com.obric.matrix.q.c.b();
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.f(r1, "uri");
        return 0;
    }
}
