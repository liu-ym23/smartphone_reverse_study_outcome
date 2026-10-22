package com.bytedance.push.settings.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PushProvider extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f5488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Uri f5489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static UriMatcher f5490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f5491i;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f5492f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f5493g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f5494h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f5495i;

        a(String r1, String r2, String r3, Context r4) {
            this.f5492f = r1;
            this.f5493g = r2;
            this.f5494h = r3;
            this.f5495i = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            b r0 = new b(this.f5492f, this.f5493g, "val", this.f5494h);
            Uri r1 = PushProvider.b(this.f5495i, r0);
            if (r1 != null) goto L10;
            return;
        L10:
            this.f5495i.getContentResolver().notifyChange(r1, null);     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public PushProvider() {
    }

    static Runnable a(Context r1, String r2, String r3, String r4) {
        return new a(r2, r3, r4, r1);
    }

    static synchronized Uri b(Context r2, b r3) {
        monitor-enter(PushProvider.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (f5489g == null) goto L24;
    L13:
        if (r3 != null) goto L17;
        Uri r4 = f5489g;     // Catch: Throwable -> L20
        monitor-exit(PushProvider.class);
        return r4;
    L17:
        Uri r5 = r3.b(f5489g);     // Catch: Throwable -> L20
        monitor-exit(PushProvider.class);
        return r5;
    L24:
        e(r2);     // Catch: Exception -> L8 Throwable -> L20
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        return null;
    }

    public static synchronized Uri c(Context r2, String r3, String r4, String r5) {
        monitor-enter(PushProvider.class);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (f5489g == null) goto L30;
    L13:
        if (r2 != null) goto L15;
    L24:
        Uri r6 = f5489g;     // Catch: Throwable -> L27
        monitor-exit(PushProvider.class);
        return r6;
    L15:
        if (TextUtils.isEmpty(r3) == true) goto L24;
        if (TextUtils.isEmpty(r4) == true) goto L24;
        if (TextUtils.isEmpty(r5) == true) goto L24;
        Uri r7 = new b(r3, r4, "val", r5).b(f5489g);     // Catch: Throwable -> L27
        monitor-exit(PushProvider.class);
        return r7;
    L30:
        e(r2);     // Catch: Exception -> L8 Throwable -> L27
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        return null;
    }

    private static String d(Context r5, String r6) {
        if (r5 != null) goto L18;
        return null;
    L18:
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        return r5.getPackageName() + ".push.settings";
    L6:
        if (TextUtils.isEmpty(r6) == true) goto L17;
        ProviderInfo[] r0 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 8).providers;     // Catch: Exception -> L14
        int r1 = r0.length;     // Catch: Exception -> L14
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L17;
        ProviderInfo r3 = r0[r2];     // Catch: Exception -> L14
        if (r6.equals(r3.name) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return r3.authority;
    }

    private static void e(Context r3) {
        if (TextUtils.isEmpty(f5488f) == false) goto L6;
        f5488f = d(r3, PushProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(f5488f) == true) goto L10;
        UriMatcher r4 = new UriMatcher(-1);
        f5490h = r4;
        r4.addURI(f5488f, "*/*/*/*", 65536);
        f5489g = Uri.parse("content://" + f5488f);
        return;
    L10:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    public static boolean f(Context r1) {
        if (f5491i == false) goto L5;
    L8:
        return true;
    L5:
        if (com.ss.android.k.c.c.c(r1) == true) goto L8;
        return false;
    }

    private static boolean g() {
        if (TextUtils.isEmpty(f5488f) == false) goto L6;
        return true;
    L6:
        if (f5490h == null) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        if (r3 == null) goto L4;
        f5488f = r3.authority;
    L4:
        super.attachInfo(r2, r3);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r1, String r2, Bundle r3) {
        e r4 = f.a(r1);
        if (r4 != null) goto L6;
        return null;
    L6:
        return r4.b(getContext(), r2, r3);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return "vnd.android.cursor.item/vnd." + f5488f + ".item";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r12, ContentValues r13) {
        if (g() == false) goto L6;
        return null;
    L6:
        if (f5490h.match(r12) != 65536) goto L62;
        List<String> r0 = r12.getPathSegments();
        if (r0 != null) goto L10;
        return null;
    L10:
        String r1 = r0.get(0);
        i r2 = com.bytedance.push.settings.e.a().a(getContext(), true, r1);     // Catch: Exception -> L58
        SharedPreferences.Editor r3 = r2.edit();     // Catch: Exception -> L58
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L58
        Iterator<Map.Entry<String, Object>> r14 = r13.valueSet().iterator();     // Catch: Exception -> L58
    L13:
        if (r14.hasNext() == false) goto L51;
        Map.Entry<String, Object> r5 = r14.next();     // Catch: Exception -> L58
        Object r6 = r5.getValue();     // Catch: Exception -> L58
        String r7 = r5.getKey();     // Catch: Exception -> L58
        if (r6 == null) goto L16;
        if ((r6 instanceof String) == true) goto L20;
        if ((r6 instanceof Boolean) == true) goto L26;
        if ((r6 instanceof Long) == true) goto L32;
        if ((r6 instanceof Integer) == true) goto L38;
        if ((r6 instanceof Float) == false) goto L50;
        if (r2.e(r7) == ((Float) r6).floatValue()) goto L13;
        r3.putFloat(r7, ((Float) r6).floatValue());     // Catch: Exception -> L58
        String r8 = TypedValues.Custom.S_FLOAT;
    L47:
        if (r8 == null) goto L13;
        r4.add(a(getContext(), r1, r7, r8));     // Catch: Exception -> L58
        goto L13
    L50:
        throw new IllegalArgumentException("Unsupported type " + r12);     // Catch: Exception -> L58
    L38:
        if (r2.d(r7) == ((Integer) r6).intValue()) goto L13;
        r3.putInt(r7, ((Integer) r6).intValue());     // Catch: Exception -> L58
        r8 = TypedValues.Custom.S_INT;
        goto L47
    L32:
        if (r2.c(r7) == ((Long) r6).longValue()) goto L13;
        r3.putLong(r7, ((Long) r6).longValue());     // Catch: Exception -> L58
        r8 = "long";
        goto L47
    L26:
        if (r2.a(r7) == ((Boolean) r6).booleanValue()) goto L13;
        r3.putBoolean(r7, ((Boolean) r6).booleanValue());     // Catch: Exception -> L58
        r8 = TypedValues.Custom.S_BOOLEAN;
        goto L47
    L20:
        if (TextUtils.equals(r2.b(r7), (String) r6) == true) goto L13;
        r3.putString(r7, (String) r6);     // Catch: Exception -> L58
        r8 = TypedValues.Custom.S_STRING;
        goto L47
    L16:
        r3.remove(r7);     // Catch: Exception -> L58
        r8 = null;
        goto L47
    L51:
        if (r3 != null) goto L53;
        return null;
    L53:
        r3.apply();     // Catch: Exception -> L58
        Iterator r11 = r4.iterator();     // Catch: Exception -> L58
    L55:
        if (r11.hasNext() == false) goto L60;
        ((Runnable) r11.next()).run();     // Catch: Exception -> L58
    L60:
        return null;
    L58:
        e = move-exception;
        e.printStackTrace();
        goto L60
    L62:
        throw new IllegalArgumentException("Unsupported uri " + r12);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f5491i = true;
        if (f5490h == null) goto L10;
    L9:
        return true;
    L10:
        e(getContext());     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r4, String[] r5, String r6, String[] r7, String r8) {
        if (g() == false) goto L6;
        return null;
    L6:
        if (f5490h.match(r4) == 65536) goto L8;
        return null;
    L8:
        b r9 = b.a(r4);
        if (r9 != null) goto L11;
    L51:
        return null;
    L11:
        if (TextUtils.isEmpty(r9.f5496a) == true) goto L51;
        if (TextUtils.isEmpty(r9.f5497b) == true) goto L51;
        if (TextUtils.isEmpty(r9.f5499d) == true) goto L51;
        i r3 = com.bytedance.push.settings.e.a().a(getContext(), true, r9.f5496a);
        String r10 = r9.f5499d;
        r10.hashCode();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -891985903: goto L37;
            case 3327612: goto L33;
            case 64711720: goto L29;
            case 97526364: goto L25;
            case 1958052158: goto L21;
            default: goto L40;
        };
    L40:
        switch(r11) {
            case 0: goto L48;
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L43;
            default: goto L42;
        };
    L43:
        int r12 = r3.getInt(r9.f5497b, Integer.parseInt(r9.f5498c));
    L44:
        Object r13 = Integer.valueOf(r12);
    L49:
        MatrixCursor r14 = new MatrixCursor(new String[]{r9.f5497b});
        r14.newRow().add(r13);
        return r14;
    L45:
        r13 = Float.valueOf(r3.getFloat(r9.f5497b, Float.parseFloat(r9.f5498c)));
        goto L49
    L46:
        r12 = r3.getBoolean(r9.f5497b, Boolean.parseBoolean(r9.f5498c));
        goto L44
    L47:
        r13 = Long.valueOf(r3.getLong(r9.f5497b, Long.parseLong(r9.f5498c)));
        goto L49
    L48:
        r13 = r3.getString(r9.f5497b, r9.f5498c);
        goto L49
    L42:
        throw new IllegalArgumentException("unknown type");
    L21:
        if (r10.equals(TypedValues.Custom.S_INT) == false) goto L40;
        r11 = 4;
        goto L40
    L25:
        if (r10.equals(TypedValues.Custom.S_FLOAT) == false) goto L40;
        r11 = 3;
        goto L40
    L29:
        if (r10.equals(TypedValues.Custom.S_BOOLEAN) == false) goto L40;
        r11 = 2;
        goto L40
    L33:
        if (r10.equals("long") == false) goto L40;
        r11 = 1;
        goto L40
    L37:
        if (r10.equals(TypedValues.Custom.S_STRING) == false) goto L40;
        r11 = 0;
        goto L40
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }
}
