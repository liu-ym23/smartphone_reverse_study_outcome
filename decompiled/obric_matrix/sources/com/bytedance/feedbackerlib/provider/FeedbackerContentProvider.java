package com.bytedance.feedbackerlib.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.feedbackerlib.m.c;
import com.bytedance.feedbackerlib.m.o;
import com.bytedance.feedbackerlib.m.q;
import com.bytedance.feedbackerlib.model.a;
import com.bytedance.feedbackerlib.model.e.e;

/* JADX INFO: loaded from: classes.dex */
public class FeedbackerContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f4626g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Uri f4627h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Uri f4628i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Uri f4629j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Uri f4630k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Uri f4631l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final UriMatcher f4632f;

    static {
        String r0 = o.d();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        r0 = "com.bytedance.feedbacker.unknown";
        c.a("FeedbackerContentProvid", "getPackageNameFromActivityThread failed! use packageName: com.bytedance.feedbacker.unknown", new RuntimeException());
    L5:
        String r1 = r0 + ".feedbacker.cache";
        f4626g = r1;
        Uri r2 = Uri.parse("content://" + r1);
        f4627h = r2;
        f4628i = Uri.withAppendedPath(r2, NotificationCompat.CATEGORY_EMAIL);
        f4629j = Uri.withAppendedPath(r2, "user_access_token");
        f4631l = Uri.withAppendedPath(r2, "employee_id");
        f4630k = Uri.withAppendedPath(r2, "clear_cache");
    }

    public FeedbackerContentProvider() {
        this.f4632f = new UriMatcher(-1);
    }

    public static int a(@Nullable Context r2) {
        if (r2 != null) goto L5;
    L12:
        return 0;
    L5:
        if (r2.getApplicationContext() == null) goto L12;
        ContentResolver r3 = r2.getApplicationContext().getContentResolver();
        if (r3 != null) goto L11;
        return 0;
    L11:
        return r3.delete(f4630k, null, null);
    }

    private int b() {
        q.d.n.c(null);
        q.c.f4307g.b(-1);
        q.d.s.c(null);
        q.d.t.c(null);
        a.I().y();
        return 4;
    }

    @NonNull
    private Cursor c() {
        e r3 = a.I().P();
        if (r3 != null) goto L5;
        String r4 = null;
    L7:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r4 = q.d.n.a(null);
    L9:
        MatrixCursor r1 = new MatrixCursor(new String[]{NotificationCompat.CATEGORY_EMAIL});
        r1.addRow(new String[]{r4});
        return r1;
    L5:
        r4 = r3.f4623b;
        goto L7
    }

    @NonNull
    private Cursor d() {
        e r3 = a.I().P();
        int r0 = -1;
        if (r3 != null) goto L5;
        int r4 = -1;
    L6:
        if (r4 != (-1)) goto L11;
        String r1 = q.d.t.a(null);
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r4 = Integer.valueOf(r1).intValue();     // Catch: Throwable -> L14
    L12:
        MatrixCursor r2 = new MatrixCursor(new String[]{"employee_id"});
        r2.addRow(new String[]{String.valueOf(r0)});
        return r2;
    L11:
        r0 = r4;
        goto L12
    L5:
        r4 = r3.f4625d;
        goto L6
    }

    @NonNull
    private Cursor e() {
        String r3 = a.I().O();
        MatrixCursor r1 = new MatrixCursor(new String[]{"user_access_token"});
        r1.addRow(new String[]{r3});
        return r1;
    }

    @Nullable
    public static String f(@Nullable Context r7) {
        if (r7 != null) goto L5;
    L23:
        return null;
    L5:
        if (r7.getApplicationContext() == null) goto L23;
        ContentResolver r1 = r7.getApplicationContext().getContentResolver();
        if (r1 != null) goto L10;
        return null;
    L10:
        Cursor r8 = r1.query(f4628i, null, null, null, null);
        if (r8 != null) goto L24;
        return null;
    L24:
    L20:
        th = move-exception;
        r8.close();
        throw th;
    L14:
        if (r8.moveToFirst() == true) goto L17;
        r8.close();
        return null;
    L17:
        String r0 = r8.getString(r8.getColumnIndex(NotificationCompat.CATEGORY_EMAIL));     // Catch: Throwable -> L20
        r8.close();
        return r0;
    }

    @Nullable
    public static String g(@Nullable Context r7) {
        if (r7 != null) goto L5;
    L23:
        return null;
    L5:
        if (r7.getApplicationContext() == null) goto L23;
        ContentResolver r1 = r7.getApplicationContext().getContentResolver();
        if (r1 != null) goto L10;
        return null;
    L10:
        Cursor r8 = r1.query(f4631l, null, null, null, null);
        if (r8 != null) goto L24;
        return null;
    L24:
    L20:
        th = move-exception;
        r8.close();
        throw th;
    L14:
        if (r8.moveToFirst() == true) goto L17;
        r8.close();
        return null;
    L17:
        String r0 = r8.getString(r8.getColumnIndex("employee_id"));     // Catch: Throwable -> L20
        r8.close();
        return r0;
    }

    @Nullable
    public static String h(@Nullable Context r7) {
        if (r7 != null) goto L5;
    L23:
        return null;
    L5:
        if (r7.getApplicationContext() == null) goto L23;
        ContentResolver r1 = r7.getApplicationContext().getContentResolver();
        if (r1 != null) goto L10;
        return null;
    L10:
        Cursor r8 = r1.query(f4629j, null, null, null, null);
        if (r8 != null) goto L24;
        return null;
    L24:
    L20:
        th = move-exception;
        r8.close();
        throw th;
    L14:
        if (r8.moveToFirst() == true) goto L17;
        r8.close();
        return null;
    L17:
        String r0 = r8.getString(r8.getColumnIndex("user_access_token"));     // Catch: Throwable -> L20
        r8.close();
        return r0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        if (this.f4632f.match(r1) == 3) goto L7;
        return 0;
    L7:
        return b();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        UriMatcher r0 = this.f4632f;
        String r1 = f4626g;
        r0.addURI(r1, NotificationCompat.CATEGORY_EMAIL, 1);
        this.f4632f.addURI(r1, "user_access_token", 2);
        this.f4632f.addURI(r1, "clear_cache", 3);
        this.f4632f.addURI(r1, "employee_id", 4);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        int r6 = this.f4632f.match(r1);
        if (r6 == 1) goto L15;
        if (r6 == 2) goto L13;
        if (r6 == 4) goto L11;
        return null;
    L11:
        return d();
    L13:
        return e();
    L15:
        return c();
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }
}
