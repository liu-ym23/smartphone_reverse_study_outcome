package com.bytedance.push.settings.storage;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<com.bytedance.push.settings.a, ContentObserver> f5508c;

    class a implements j {
        a(d r1) {
        }

        @Override // com.bytedance.push.settings.storage.j
        public Uri a(Context r1, com.bytedance.push.settings.storage.b r2) {
            return d.f(r1, r2);
        }
    }

    class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.push.settings.a f5509a;

        b(d r1, Handler r2, com.bytedance.push.settings.a r3) {
            this.f5509a = r3;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1, Uri r2) {
            super.onChange(r1, r2);
            this.f5509a.a();
        }
    }

    private static final class c implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f5510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Context f5512c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ContentValues f5513d;

        c(Context r2, String r3, j r4) {
            this.f5513d = new ContentValues();
            this.f5512c = r2.getApplicationContext();
            this.f5510a = r4;
            this.f5511b = r3;
        }

        public c a() {
            throw new UnsupportedOperationException("no support clear");
        }

        @Override // android.content.SharedPreferences.Editor
        public synchronized void apply() {
            monitor-enter(this);
            com.bytedance.push.settings.storage.b r0 = new com.bytedance.push.settings.storage.b(this.f5511b, "key", "val", WsConstants.KEY_CONNECTION_TYPE);     // Catch: Throwable -> L5
            this.f5512c.getContentResolver().insert(this.f5510a.a(this.f5512c, r0), this.f5513d);     // Catch: Throwable -> L5
        L7:
            monitor-exit(this);
            return;
        L5:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public c b(String r2, boolean r3) {
            this.f5513d.put(r2, Boolean.valueOf(r3));
            return this;
        }

        public c c(String r2, float r3) {
            this.f5513d.put(r2, Float.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public /* bridge */ /* synthetic */ SharedPreferences.Editor clear() {
            a();
            throw null;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return false;
        }

        public c d(String r2, int r3) {
            this.f5513d.put(r2, Integer.valueOf(r3));
            return this;
        }

        public c e(String r2, long r3) {
            this.f5513d.put(r2, Long.valueOf(r3));
            return this;
        }

        public c f(String r2, String r3) {
            this.f5513d.put(r2, r3);
            return this;
        }

        public c g(String r2) {
            this.f5513d.putNull(r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public /* bridge */ /* synthetic */ SharedPreferences.Editor putBoolean(String r1, boolean r2) {
            b(r1, r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public /* bridge */ /* synthetic */ SharedPreferences.Editor putFloat(String r1, float r2) {
            c(r1, r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public /* bridge */ /* synthetic */ SharedPreferences.Editor putInt(String r1, int r2) {
            d(r1, r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public /* bridge */ /* synthetic */ SharedPreferences.Editor putLong(String r1, long r2) {
            e(r1, r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public /* bridge */ /* synthetic */ SharedPreferences.Editor putString(String r1, String r2) {
            f(r1, r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r1, Set<String> r2) {
            throw new UnsupportedOperationException("putStringSet not support");
        }

        @Override // android.content.SharedPreferences.Editor
        public /* bridge */ /* synthetic */ SharedPreferences.Editor remove(String r1) {
            g(r1);
            return this;
        }
    }

    d(Context r2, String r3) {
        this.f5508c = new ConcurrentHashMap();
        this.f5506a = r2;
        this.f5507b = r3;
    }

    static /* synthetic */ Uri f(Context r0, com.bytedance.push.settings.storage.b r1) {
        return h(r0, r1);
    }

    private static boolean g(Cursor r1, boolean r2) {
        if (r1 != null) goto L18;
        return r2;
    L18:
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
    L10:
        n(r1);
        return r2;
    L15:
        th = move-exception;
        n(r1);
        throw th;
    L5:
        if (r1.moveToFirst() == false) goto L10;
        boolean r0 = false;
        if (r1.getInt(0) <= 0) goto L9;
        r0 = true;
    L9:
        r2 = r0;
        goto L10
    }

    private static synchronized Uri h(Context r1, com.bytedance.push.settings.storage.b r2) {
        monitor-enter(d.class);
        Uri r3 = PushProvider.b(r1, r2);     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    private Uri i(Context r1, String r2, String r3, String r4, String r5) {
        return h(r1, new com.bytedance.push.settings.storage.b(r2, r3, r4, r5));
    }

    private static float j(Cursor r1, float r2) {
        if (r1 != null) goto L10;
        return r2;
    L10:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getFloat(0);     // Catch: Throwable -> L9
    L7:
        n(r1);
        return r2;
    }

    private static int k(Cursor r1, int r2) {
        if (r1 != null) goto L10;
        return r2;
    L10:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getInt(0);     // Catch: Throwable -> L9
    L7:
        n(r1);
        return r2;
    }

    private static long l(Cursor r1, long r2) {
        if (r1 != null) goto L10;
        return r2;
    L10:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getLong(0);     // Catch: Throwable -> L9
    L7:
        n(r1);
        return r2;
    }

    private static String m(Cursor r1, String r2) {
        if (r1 != null) goto L10;
        return r2;
    L10:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getString(0);     // Catch: Throwable -> L9
    L7:
        n(r1);
        return r2;
    }

    private static void n(Cursor r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: Exception -> L5
        return;
    L9:
        return;
    }

    @Override // com.bytedance.push.settings.storage.i
    public boolean a(String r2) {
        return getBoolean(r2, false);
    }

    @Override // com.bytedance.push.settings.storage.i
    public String b(String r2) {
        return getString(r2, null);
    }

    @Override // com.bytedance.push.settings.storage.i
    public long c(String r3) {
        return getLong(r3, 0);
    }

    @Override // com.bytedance.push.settings.storage.i
    public boolean contains(String r5) {
        Uri r0 = h(this.f5506a, null);     // Catch: Throwable -> L4
        return com.bytedance.push.settings.storage.a.d(this.f5506a.getContentResolver().call(r0, "_contains", null, com.bytedance.push.settings.storage.a.c(this.f5507b, r5)));
    L4:
        return false;
    }

    @Override // com.bytedance.push.settings.storage.i
    public int d(String r2) {
        return getInt(r2, 0);
    }

    @Override // com.bytedance.push.settings.storage.i
    public float e(String r2) {
        return getFloat(r2, 0.0f);
    }

    @Override // com.bytedance.push.settings.storage.i
    public SharedPreferences.Editor edit() {
        return new c(this.f5506a, this.f5507b, new a(this));
    }

    @Override // com.bytedance.push.settings.storage.i
    public boolean getBoolean(String r9, boolean r10) {
        return g(this.f5506a.getContentResolver().query(i(this.f5506a, this.f5507b, r9, String.valueOf(r10), TypedValues.Custom.S_BOOLEAN), null, null, null, null), r10);
    L4:
        return r10;
    }

    @Override // com.bytedance.push.settings.storage.i
    public float getFloat(String r9, float r10) {
        return j(this.f5506a.getContentResolver().query(i(this.f5506a, this.f5507b, r9, String.valueOf(r10), TypedValues.Custom.S_FLOAT), null, null, null, null), r10);
    L4:
        return r10;
    }

    @Override // com.bytedance.push.settings.storage.i
    public int getInt(String r9, int r10) {
        return k(this.f5506a.getContentResolver().query(i(this.f5506a, this.f5507b, r9, String.valueOf(r10), TypedValues.Custom.S_INT), null, null, null, null), r10);
    L4:
        return r10;
    }

    @Override // com.bytedance.push.settings.storage.i
    public long getLong(String r9, long r10) {
        return l(this.f5506a.getContentResolver().query(i(this.f5506a, this.f5507b, r9, String.valueOf(r10), "long"), null, null, null, null), r10);
    L4:
        return r10;
    }

    @Override // com.bytedance.push.settings.storage.i
    public String getString(String r9, String r10) {
        return m(this.f5506a.getContentResolver().query(i(this.f5506a, this.f5507b, r9, r10, TypedValues.Custom.S_STRING), null, null, null, null), r10);
    L4:
        return r10;
    }

    @Override // com.bytedance.push.settings.storage.i
    public void registerValChanged(Context r3, String r4, String r5, com.bytedance.push.settings.a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Uri r7 = PushProvider.c(r3, this.f5507b, r4, r5);
        if (r7 != null) goto L7;
        return;
    L7:
        b r8 = new b(this, new Handler(Looper.getMainLooper()), r6);
        r3.getContentResolver().registerContentObserver(r7, true, r8);
        this.f5508c.put(r6, r8);
    }

    @Override // com.bytedance.push.settings.storage.i
    public void unregisterValChanged(com.bytedance.push.settings.a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ContentObserver r3 = this.f5508c.remove(r2);
        if (r3 != null) goto L7;
        return;
    L7:
        this.f5506a.getContentResolver().unregisterContentObserver(r3);
    }
}
