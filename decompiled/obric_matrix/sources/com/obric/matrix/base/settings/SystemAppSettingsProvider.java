package com.obric.matrix.base.settings;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J1\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J=\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!JO\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010#JY\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010$J;\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010&R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/matrix/base/settings/SystemAppSettingsProvider;", "Landroid/content/ContentProvider;", "()V", "broadcastMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "settingsUpdateNotifier", "Lcom/obric/matrix/base/settings/SettingsNotifier;", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "arg", "extras", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "queryArgs", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SystemAppSettingsProvider extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f8849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f8850g;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/base/settings/SystemAppSettingsProvider$onCreate$1", "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "onSettingsUpdate", "", "settingsData", "Lcom/bytedance/news/common/settings/api/SettingsData;", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.bytedance.news.common.settings.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SystemAppSettingsProvider f8851a;

        a(SystemAppSettingsProvider r1) {
            this.f8851a = r1;
        }

        @Override // com.bytedance.news.common.settings.f
        public void a(com.bytedance.news.common.settings.g.c r2) {
            com.obric.matrix.r.c.c.b("SystemAppSettingsProvider", "1111 onSettingsUpdate");
            e r3 = SystemAppSettingsProvider.b(this.f8851a);
            if (r3 == null) goto L6;
            r3.c(SystemAppSettingsProvider.a(this.f8851a));
            return;
        }
    }

    static {
    }

    public SystemAppSettingsProvider() {
        this.f8850g = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ConcurrentHashMap a(SystemAppSettingsProvider r0) {
        return r0.f8850g;
    }

    public static final /* synthetic */ e b(SystemAppSettingsProvider r0) {
        return r0.f8849f;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r2, String r3, Bundle r4) {
        o.f(r2, "method");
        super.call(r2, r3, r4);
        if (o.a(r2, "update_settings") == false) goto L7;
        com.obric.matrix.r.c.c.b("SystemAppSettingsProvider", "call update_settings");
        com.bytedance.news.common.settings.e.g(true);
        return null;
    L7:
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        o.f(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        o.f(r1, "uri");
        return "application/zip";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        o.f(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        com.obric.matrix.r.c.c.b("SystemAppSettingsProvider", "11111onCreate() called");
        Context r2 = getContext();
        o.c(r2);
        this.f8849f = new e(r2);
        com.obric.matrix.r.c.c.b("SystemAppSettingsProvider", "注册settingsmanager更新监听");
        com.bytedance.news.common.settings.e.f(new a(this), true);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r7, String[] r8, Bundle r9, CancellationSignal r10) {
        o.f(r7, "uri");
        String r11 = null;
        if (r9 == null) goto L5;
        String r12 = r9.getString("android:query-arg-sql-selection");
    L6:
        if (r9 == null) goto L8;
        String[] r13 = r9.getStringArray("android:query-arg-sql-selection-args");
    L9:
        String r1 = "";
        if (r12 != null) goto L12;
    L21:
        String r4 = "";
    L23:
        if (r4.length() != 0) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == false) goto L33;
        if (r9 == null) goto L29;
        r4 = r9.getString("packageName");
    L30:
        if (r4 != null) goto L33;
        r4 = "";
        goto L33
    L29:
        r4 = null;
    L33:
        if (r4.length() != 0) goto L35;
        boolean r6 = true;
    L36:
        if (r6 == false) goto L38;
        return null;
    L38:
        if (r12 != null) goto L40;
    L49:
        String r14 = "";
    L51:
        if (r14.length() != 0) goto L53;
        boolean r15 = true;
    L54:
        if (r15 == false) goto L62;
        if (r9 == null) goto L57;
        r11 = r9.getString("receiverName");
    L57:
        if (r11 == null) goto L60;
        r1 = r11;
    L60:
        r14 = r1;
    L62:
        if (r14.length() != 0) goto L64;
        boolean r16 = true;
    L65:
        if (r16 == true) goto L67;
        this.f8850g.put(r4, r14);
    L67:
        com.obric.matrix.r.c.c.b("SystemAppSettingsProvider", "11111systemapp settings provider query start, package = " + r4 + " , receiver = " + r14);
        MatrixCursor r17 = new MatrixCursor(new String[]{"all_config_str"});
        String r18 = f.f8885a.a(r4);     // Catch: Exception -> L70
        com.obric.matrix.r.c.c.b("SystemAppSettingsProvider", r4 + " config = " + r18);     // Catch: Exception -> L70
        r17.addRow(new String[]{r18});     // Catch: Exception -> L70
    L72:
        return r17;
    L70:
        e = move-exception;
        com.obric.matrix.r.c.c.g("SystemAppSettingsProvider", "query() Exception", e);
        goto L72
    L64:
        r16 = false;
        goto L65
    L53:
        r15 = false;
        goto L54
    L40:
        if (k.F(r12, "receiverName = ?", false, 2, null) == false) goto L49;
        if (r13 == null) goto L49;
        if (r13.length != 0) goto L45;
        boolean r19 = true;
    L47:
        if ((!r19) == false) goto L49;
        r14 = r13[1];
        o.e(r14, "selectionArgs[1]");
        goto L51
    L45:
        r19 = false;
        goto L47
    L35:
        r6 = false;
        goto L36
    L25:
        r5 = false;
        goto L26
    L12:
        if (k.F(r12, "packageName = ?", false, 2, null) == false) goto L21;
        if (r13 == null) goto L21;
        if (r13.length != 0) goto L17;
        boolean r20 = true;
    L19:
        if ((!r20) == false) goto L21;
        r4 = r13[0];
        o.e(r4, "selectionArgs[0]");
        goto L23
    L17:
        r20 = false;
        goto L19
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r7, String[] r8, String r9, String[] r10, String r11) {
        o.f(r7, "uri");
        com.obric.matrix.r.c.c.j("SystemAppSettingsProvider", "老版本query方法被调用");
        Bundle r0 = new Bundle();
        r0.putString("android:query-arg-sql-selection", r9);
        r0.putStringArray("android:query-arg-sql-selection-args", r10);
        r0.putString("android:query-arg-sql-sort-order", r11);
        if (r9 != null) goto L5;
    L14:
        if (r9 == null) goto L22;
        if (k.F(r9, "receiverName = ?", false, 2, null) == false) goto L22;
        if (r10 == null) goto L22;
        if (r10.length <= 1) goto L22;
        r0.putString("receiverName", r10[1]);
    L22:
        return query(r7, r8, r0, null);
    L5:
        if (k.F(r9, "packageName = ?", false, 2, null) == false) goto L14;
        if (r10 == null) goto L14;
        if (r10.length != 0) goto L10;
        boolean r4 = true;
    L12:
        if ((!r4) == false) goto L14;
        r0.putString("packageName", r10[0]);
        goto L14
    L10:
        r4 = false;
        goto L12
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5, CancellationSignal r6) {
        o.f(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.f(r1, "uri");
        return 0;
    }
}
