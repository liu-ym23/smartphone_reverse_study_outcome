package com.ss.android.account.share.data.write.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.ss.android.i.n.a.c;
import com.ss.android.i.n.a.e.a;
import com.ss.android.i.n.a.e.b;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJM\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/ss/android/account/share/data/write/provider/SecShareDataProvider;", "Landroid/content/ContentProvider;", "", "onCreate", "()Z", "Landroid/net/Uri;", "uri", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "mode", "Landroid/os/ParcelFileDescriptor;", "openFile", "(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;", "Lcom/ss/android/i/n/a/e/a;", "f", "Lcom/ss/android/i/n/a/e/a;", "secShareDataLocalSp", "<init>", "()V", "sec_share_data_release"}, k = 1, mv = {1, 1, 15})
public final class SecShareDataProvider extends ContentProvider {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final UriMatcher f11798g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f11799f;

    static {
        f11798g = new UriMatcher(-1);
    }

    public SecShareDataProvider() {
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        o.g(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        o.g(r10, "uri");
        int r0 = f11798g.match(r10);
        if (r0 != 2) goto L5;
        Context r9 = getContext();
        if (r9 == null) goto L32;
        o.b(r9, "context ?: return null");
        String r11 = r9.getPackageName();
        if (TextUtils.isEmpty(r11) == false) goto L31;
        return null;
    L31:
        return r11 + ".SecShareProviderAuthority";
    L32:
        return null;
    L5:
        if (r0 == 3) goto L7;
        return null;
    L7:
        String r3 = r10.getLastPathSegment();
        if (r3 == null) goto L10;
        int r12 = k.U(r3, '.', 0, false, 6, null);
    L11:
        if (r12 < 0) goto L23;
        String r13 = r10.getLastPathSegment();
        if (r13 == null) goto L21;
        o.b(r13, "uri.lastPathSegment!!");
        int r14 = r12 + 1;
        if (r13 == null) goto L20;
        String r15 = r13.substring(r14);
        o.b(r15, "(this as java.lang.String).substring(startIndex)");
        String r16 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r15);
        if (r16 == null) goto L33;
        return r16;
    L33:
        return "application/octet-stream";
    L20:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    L21:
        o.p();
        throw null;
    L23:
        return "application/octet-stream";
    L10:
        r12 = -1;
        goto L11
    }

    @Override // android.content.ContentProvider
    public synchronized Uri insert(Uri r1, ContentValues r2) {
        monitor-enter(this);
        o.g(r1, "uri");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context r0 = getContext();
        if (r0 == null) goto L9;
        o.b(r0, "context ?: return false");
        this.f11799f = a.f11931d.a(r0);
        String r5 = r0.getPackageName();
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return false;
    L7:
        UriMatcher r1 = f11798g;
        r1.addURI(r5 + ".SecShareProviderAuthority", "sec_share/*", 2);
        r1.addURI(r5 + ".SecShareProviderAuthority", "sec_share_file/*", 3);
        return true;
    L9:
        return false;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r3, String r4) {
        o.g(r3, "uri");
        o.g(r4, "mode");
        if (Build.VERSION.SDK_INT >= 19) goto L7;
        c r2 = c.d();
        r2.b("share_sdk_provider_not_support");
        r2.c();
        return null;
    L7:
        if (b.f11939f.b(getCallingPackage()) == true) goto L10;
        return null;
    L10:
        if (f11798g.match(r3) == 3) goto L13;
        return null;
    L13:
        if (getContext() == null) goto L38;
        String r5 = r3.getLastPathSegment();
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == true) goto L38;
        com.ss.android.i.n.a.b r7 = com.ss.android.i.n.a.b.f11915a;
        Context r8 = getContext();
        if (r8 == null) goto L36;
        o.b(r8, "context!!");
        String r9 = r3.getLastPathSegment();
        if (r9 == null) goto L34;
        o.b(r9, "uri.lastPathSegment!!");
        File r10 = r7.a(r8, r9);
        if (r10 == null) goto L38;
        if (r10.exists() == false) goto L38;
        if (r10.isFile() == false) goto L38;
        return ParcelFileDescriptor.open(r10, 268435456);
    L34:
        o.p();
        throw null;
    L36:
        o.p();
        throw null;
    L17:
        if (r5.length() == 0) goto L20;
        r6 = false;
    L38:
        return null;
    }

    @Override // android.content.ContentProvider
    public synchronized Cursor query(Uri r2, String[] r3, String r4, String[] r5, String r6) {
        monitor-enter(this);
        o.g(r2, "uri");     // Catch: Throwable -> L33
        MatrixCursor r7 = null;
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        c r8 = c.d();     // Catch: Throwable -> L33
        r8.b("share_sdk_provider_not_support");     // Catch: Throwable -> L33
        r8.c();     // Catch: Throwable -> L33
        monitor-exit(this);
        return null;
    L9:
        if (b.f11939f.b(getCallingPackage()) == true) goto L14;
        monitor-exit(this);
        return null;
    L14:
        if (f11798g.match(r2) == 2) goto L17;
        monitor-exit(this);
        return null;
    L17:
        List<String> r9 = r2.getPathSegments();     // Catch: Throwable -> L33
        int r10 = r9.size();     // Catch: Throwable -> L33
        if (r10 <= 0) goto L31;
        String r11 = r9.get(r10 - 1);     // Catch: Throwable -> L33
        o.b(r11, "pathSegments[size - 1]");     // Catch: Throwable -> L33
        String r12 = r11;     // Catch: Throwable -> L33
        a r13 = this.f11799f;     // Catch: Exception -> L36 Throwable -> L33
        if (r13 == null) goto L27;
        String r14 = r13.d(r12);     // Catch: Exception -> L36 Throwable -> L33
        MatrixCursor r15 = new MatrixCursor(new String[]{r12});     // Catch: Exception -> L36 Throwable -> L33
        r15.newRow().add(r12, r14);     // Catch: Exception -> L26 Throwable -> L33
        monitor-exit(this);
        return r15;
    L26:
        r7 = r15;
        goto L29
    L27:
        o.p();     // Catch: Exception -> L36 Throwable -> L33
        throw null;
    L29:
        monitor-exit(this);
        return r7;
    L31:
        monitor-exit(this);
        return null;
    L33:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.g(r1, "uri");
        return 0;
    }
}
