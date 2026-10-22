package com.ss.android.token;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AuthTokenMultiProcessSharedProvider extends ContentProvider {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f12180j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Uri f12181k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static UriMatcher f12182l = null;

    @SuppressLint({"CI_StaticFieldLeak"})
    private static c m = null;
    private static String n = "token_shared_preference";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedPreferences f12183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, Object> f12184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f12185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f12186i;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f12187f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f12188g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ AuthTokenMultiProcessSharedProvider f12189h;

        a(AuthTokenMultiProcessSharedProvider r1, String r2, String r3) {
            this.f12189h = r1;
            this.f12187f = r2;
            this.f12188g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            AuthTokenMultiProcessSharedProvider r0 = this.f12189h;
            AuthTokenMultiProcessSharedProvider.b(r0, AuthTokenMultiProcessSharedProvider.k(r0.getContext(), this.f12187f, this.f12188g));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Context f12190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ContentValues f12191b;

        private b(Context r2) {
            this.f12191b = new ContentValues();
            this.f12190a = r2.getApplicationContext();
        }

        /* synthetic */ b(Context r1, a r2) {
            this(r1);
        }

        public synchronized void a() {
            monitor-enter(this);
            SharedPreferences.Editor r0 = AuthTokenMultiProcessSharedProvider.p(this.f12190a).edit();     // Catch: Throwable -> L26
            Iterator<Map.Entry<String, Object>> r1 = this.f12191b.valueSet().iterator();     // Catch: Throwable -> L26
        L5:
            if (r1.hasNext() == false) goto L24;
            Map.Entry<String, Object> r2 = r1.next();     // Catch: Throwable -> L26
            Object r3 = r2.getValue();     // Catch: Throwable -> L26
            String r4 = r2.getKey();     // Catch: Throwable -> L26
            d.b.s.a.a0.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider apply key = " + r4 + " value = " + p.O(r3));     // Catch: Throwable -> L26
            if (r3 == null) goto L8;
            if ((r3 instanceof String) == true) goto L11;
            if ((r3 instanceof Boolean) == true) goto L14;
            if ((r3 instanceof Long) == true) goto L17;
            if ((r3 instanceof Integer) == true) goto L20;
            if ((r3 instanceof Float) == false) goto L5;
            r0.putFloat(r4, ((Float) r3).floatValue());     // Catch: Throwable -> L26
            goto L5
        L20:
            r0.putInt(r4, ((Integer) r3).intValue());     // Catch: Throwable -> L26
            goto L5
        L17:
            r0.putLong(r4, ((Long) r3).longValue());     // Catch: Throwable -> L26
            goto L5
        L14:
            r0.putBoolean(r4, ((Boolean) r3).booleanValue());     // Catch: Throwable -> L26
            goto L5
        L11:
            r0.putString(r4, (String) r3);     // Catch: Throwable -> L26
            goto L5
        L8:
            r0.remove(r4);     // Catch: Throwable -> L26
            goto L5
        L24:
            r0.commit();     // Catch: Throwable -> L26
            this.f12190a.getContentResolver().insert(AuthTokenMultiProcessSharedProvider.k(this.f12190a, "key", WsConstants.KEY_CONNECTION_TYPE), this.f12191b);     // Catch: Throwable -> L26
        L28:
            monitor-exit(this);
            return;
        L26:
            th = move-exception;
            d.b.s.a.a0.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider apply error = " + Log.getStackTraceString(th));     // Catch: Throwable -> L30
            o.f(th);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;
        }

        public b b(String r2, boolean r3) {
            this.f12191b.put(r2, Boolean.valueOf(r3));
            return this;
        }

        public b c(String r2, int r3) {
            this.f12191b.put(r2, Integer.valueOf(r3));
            return this;
        }

        public b d(String r2, String r3) {
            this.f12191b.put(r2, r3);
            return this;
        }

        public void e(String r1) {
            this.f12191b.putNull(r1);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f12192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f12193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SharedPreferences f12194c;

        private c(Context r2, String r3, boolean r4) {
            this.f12193b = false;
            this.f12193b = r4;
            this.f12192a = r2.getApplicationContext();
            AuthTokenMultiProcessSharedProvider.d(r3);
            this.f12194c = a(this.f12192a.getApplicationContext(), AuthTokenMultiProcessSharedProvider.c(), 4);
            d.b.s.a.a0.a.a("AuthTokenMultiProcessShared", "MultiProcessShared create");
        }

        /* synthetic */ c(Context r1, String r2, boolean r3, a r4) {
            this(r1, r2, r3);
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences a(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        public b b() {
            return new b(this.f12192a, null);
        }

        public boolean c(String r8, boolean r9) {
        L8:
            th = move-exception;
            o.f(th);
            return r9;
        L3:
            if (this.f12193b == false) goto L7;
            return this.f12194c.getBoolean(r8, r9);
        L7:
            return AuthTokenMultiProcessSharedProvider.f(this.f12192a.getContentResolver().query(AuthTokenMultiProcessSharedProvider.k(this.f12192a, r8, TypedValues.Custom.S_BOOLEAN), null, null, null, null), r9);
        }

        public int d(String r8, int r9) {
        L8:
            th = move-exception;
            o.f(th);
            return r9;
        L3:
            if (this.f12193b == false) goto L7;
            return this.f12194c.getInt(r8, r9);
        L7:
            return AuthTokenMultiProcessSharedProvider.g(this.f12192a.getContentResolver().query(AuthTokenMultiProcessSharedProvider.k(this.f12192a, r8, TypedValues.Custom.S_INT), null, null, null, null), r9);
        }

        public String e(String r10, String r11) {
        L9:
            th = move-exception;
            o.f(th);
            return r11;
        L4:
            if (this.f12193b == false) goto L7;
            String r9 = this.f12194c.getString(r10, r11);     // Catch: Throwable -> L9
            d.b.s.a.a0.a.a("AuthTokenMultiProcessShared", "mSharedPreferences main getString get key = " + r10 + " value = " + p.O(r9));     // Catch: Throwable -> L9
            return r9;
        L7:
            String r12 = AuthTokenMultiProcessSharedProvider.e(this.f12192a.getContentResolver().query(AuthTokenMultiProcessSharedProvider.k(this.f12192a, r10, TypedValues.Custom.S_STRING), null, null, null, null), r11);     // Catch: Throwable -> L9
            d.b.s.a.a0.a.a("AuthTokenMultiProcessShared", " MultiProcessShared getString get key = " + r10 + " value = " + p.O(r12));     // Catch: Throwable -> L9
            return r12;
        }
    }

    static {
    }

    public AuthTokenMultiProcessSharedProvider() {
        this.f12184g = new ConcurrentHashMap();
        this.f12185h = false;
        this.f12186i = new Object();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ void b(AuthTokenMultiProcessSharedProvider r0, Uri r1) {
        r0.u(r1);
    }

    static /* synthetic */ String c() {
        return n;
    }

    static /* synthetic */ String d(String r0) {
        n = r0;
        return r0;
    }

    static /* synthetic */ String e(Cursor r0, String r1) {
        return q(r0, r1);
    }

    static /* synthetic */ boolean f(Cursor r0, boolean r1) {
        return j(r0, r1);
    }

    static /* synthetic */ int g(Cursor r0, int r1) {
        return l(r0, r1);
    }

    private Runnable h(String r2, String r3) {
        return new a(this, r2, r3);
    }

    private void i() {
        if (this.f12185h == true) goto L14;
        Object r0 = this.f12186i;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f12185h == true) goto L9;
        t();     // Catch: Throwable -> L11
        this.f12185h = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    private static boolean j(Cursor r1, boolean r2) {
        if (r1 != null) goto L32;
        return r2;
    L32:
        r2 = r2;
        if (r1.moveToFirst() == false) goto L10;
        r2 = r1.getInt(0);     // Catch: Throwable -> L15
        if (r2 <= 0) goto L9;
        r2 = 1;
        goto L10
    L9:
        r2 = 0;
        goto L10
    L10:
        if (r1 == null) goto L19;
        r1.close();     // Catch: Exception -> L13
    L19:
        return r2;
    L15:
        th = move-exception;
        o.f(th);     // Catch: Throwable -> L20
        if (r1 == null) goto L19;
        r1.close();     // Catch: Exception -> L13
    L20:
        th = move-exception;
        if (r1 != null) goto L27;
    L26:
        throw th;
    L27:
        r1.close();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        o.f(e);
    L13:
        e = move-exception;
        o.f(e);
        goto L19
    }

    public static final synchronized Uri k(Context r3, String r4, String r5) {
        monitor-enter(AuthTokenMultiProcessSharedProvider.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f12181k == null) goto L20;
    L13:
        Uri r6 = f12181k.buildUpon().appendPath(r4).appendPath(r5).build();     // Catch: Throwable -> L16
        monitor-exit(AuthTokenMultiProcessSharedProvider.class);
        return r6;
    L20:
        d.b.s.a.a0.a.a("MultiProcessSharedProvider", "init form getContentUri");     // Catch: Exception -> L8 Throwable -> L16
        r(r3);     // Catch: Exception -> L8 Throwable -> L16
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        o.f(e);     // Catch: Throwable -> L16
        return null;
    }

    private static int l(Cursor r1, int r2) {
        if (r1 != null) goto L28;
        return r2;
    L28:
    L12:
        th = move-exception;
        o.f(th);     // Catch: Throwable -> L17
        if (r1 == null) goto L16;
        r1.close();     // Catch: Exception -> L10
    L16:
        return r2;
    L17:
        th = move-exception;
        if (r1 != null) goto L26;
    L23:
        throw th;
    L26:
        r1.close();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        o.f(e);
    L10:
        e = move-exception;
        o.f(e);
        goto L16
    L5:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getInt(0);     // Catch: Throwable -> L12
    L7:
        if (r1 == null) goto L16;
        r1.close();     // Catch: Exception -> L10
        goto L16
    }

    private synchronized SharedPreferences m() {
        monitor-enter(this);
        SharedPreferences r0 = this.f12183f;     // Catch: Throwable -> L14
        if (r0 != null) goto L12;
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        Context r2 = getContext().getApplicationContext();     // Catch: Throwable -> L14
        String r3 = n;     // Catch: Throwable -> L14
        if (r1 < 11) goto L8;
        int r4 = 4;
    L9:
        SharedPreferences r5 = a(r2, r3, r4);     // Catch: Throwable -> L14
        this.f12183f = r5;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r5;
    L8:
        r4 = 0;
        goto L9
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    public static synchronized c n(Context r3, String r4, boolean r5) {
        monitor-enter(AuthTokenMultiProcessSharedProvider.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (m != null) goto L7;
        m = new c(r3, r4, r5, null);     // Catch: Throwable -> L10
    L7:
        c r6 = m;     // Catch: Throwable -> L10
        monitor-exit(AuthTokenMultiProcessSharedProvider.class);
        return r6;
    }

    public static String o(Context r5, String r6) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r6) == true) goto L23;
        ProviderInfo[] r0 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 8).providers;     // Catch: Exception -> L13
        int r1 = r0.length;     // Catch: Exception -> L13
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L16;
        ProviderInfo r3 = r0[r2];     // Catch: Exception -> L13
        if (r6.equals(r3.name) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return r3.authority;
    L16:
        return r5.getPackageName() + ".auth_token.SHARE_PROVIDER_AUTHORITY";
    L13:
        e = move-exception;
        o.f(e);
        goto L16
    L23:
        return null;
    }

    public static SharedPreferences p(Context r2) {
        return a(r2, n, 4);
    }

    private static String q(Cursor r1, String r2) {
        if (r1 != null) goto L28;
        return r2;
    L28:
    L12:
        th = move-exception;
        o.f(th);     // Catch: Throwable -> L17
        if (r1 == null) goto L16;
        r1.close();     // Catch: Exception -> L10
    L16:
        return r2;
    L17:
        th = move-exception;
        if (r1 != null) goto L26;
    L23:
        throw th;
    L26:
        r1.close();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        o.f(e);
    L10:
        e = move-exception;
        o.f(e);
        goto L16
    L5:
        if (r1.moveToFirst() == false) goto L7;
        r2 = r1.getString(0);     // Catch: Throwable -> L12
    L7:
        if (r1 == null) goto L16;
        r1.close();     // Catch: Exception -> L10
        goto L16
    }

    private static void r(Context r3) {
        if (TextUtils.isEmpty(f12180j) == false) goto L6;
        f12180j = o(r3, AuthTokenMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(f12180j) == true) goto L10;
        d.b.s.a.a0.a.a("AuthTokenMultiProcessSharedProvider", f12180j);
        UriMatcher r4 = new UriMatcher(-1);
        f12182l = r4;
        r4.addURI(f12180j, "*/*", 65536);
        f12181k = Uri.parse("content://" + f12180j);
        return;
    L10:
        throw new IllegalStateException("Must Set AuthTokenMultiProcessSharedProvider Authority");
    }

    private static boolean s() {
        if (TextUtils.isEmpty(f12180j) == false) goto L6;
        return true;
    L6:
        if (f12182l == null) goto L10;
        return false;
    L10:
        return true;
    }

    private void t() {
        SharedPreferences r0 = m();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ?>> r1 = r0.getAll().entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        Map.Entry<String, ?> r2 = r1.next();
        String r3 = r2.getKey();
        Object r4 = r2.getValue();
        if (r4 == null) goto L17;
        if (r3 == null) goto L17;
        this.f12184g.put(r3, r4);
    L17:
        d.b.s.a.a0.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider loadValues key_ = " + r3 + " value_ = " + r4);     // Catch: Exception -> L14
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L14
        r5.put("key_", r3);     // Catch: Exception -> L14
        r5.put("value_", r4);     // Catch: Exception -> L14
        o.F("token_sp_error", r5);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        o.f(e);
        goto L7
    }

    private void u(Uri r2) {
        getContext().getContentResolver().notifyChange(r2, null);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        if (r3 == null) goto L4;
        f12180j = r3.authority;
    L4:
        super.attachInfo(r2, r3);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r2, String r3, String[] r4) {
        i();
        if (s() == false) goto L6;
        return 0;
    L6:
        if (f12182l.match(r2) != 65536) goto L13;
        this.f12184g.clear();     // Catch: Exception -> L9
        m().edit().clear().commit();     // Catch: Exception -> L9
        u(k(getContext(), "key", WsConstants.KEY_CONNECTION_TYPE));     // Catch: Exception -> L9
    L11:
        return 0;
    L9:
        e = move-exception;
        o.f(e);
        goto L11
    L13:
        throw new IllegalArgumentException("Unsupported uri " + r2);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        i();
        return "vnd.android.cursor.item/vnd." + f12180j + ".item";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r12, ContentValues r13) {
        i();
        if (s() == false) goto L6;
        return null;
    L6:
        if (f12182l.match(r12) != 65536) goto L63;
        ArrayList r3 = new ArrayList();     // Catch: Exception -> L59
        Iterator<Map.Entry<String, Object>> r14 = r13.valueSet().iterator();     // Catch: Exception -> L59
        SharedPreferences.Editor r5 = null;
    L9:
        if (r14.hasNext() == false) goto L48;
        Map.Entry<String, Object> r6 = r14.next();     // Catch: Exception -> L59
        Object r7 = r6.getValue();     // Catch: Exception -> L59
        String r8 = r6.getKey();     // Catch: Exception -> L59
        d.b.s.a.a0.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider reallly insert key = " + r8 + " value = " + p.O(r7));     // Catch: Exception -> L59
        if (r8 == null) goto L9;
        boolean r9 = false;
        if (r7 != null) goto L17;
        this.f12184g.remove(r8);     // Catch: Exception -> L59
    L16:
        r9 = true;
    L22:
        if (r9 == false) goto L9;
        d.b.s.a.a0.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider reallly insert key = " + r8 + " value = " + p.O(r7));     // Catch: Exception -> L59
        if (r5 != null) goto L26;
        r5 = m().edit();     // Catch: Exception -> L59
    L26:
        if (r7 != null) goto L29;
        r5.remove(r8);     // Catch: Exception -> L59
        Runnable r10 = null;
    L44:
        if (r10 == null) goto L9;
        r3.add(r10);     // Catch: Exception -> L59
        goto L9
    L29:
        if ((r7 instanceof String) == false) goto L33;
        r5.putString(r8, (String) r7);     // Catch: Exception -> L59
        String r11 = TypedValues.Custom.S_STRING;
    L31:
        r10 = h(r8, r11);     // Catch: Exception -> L59
        goto L44
    L33:
        if ((r7 instanceof Boolean) == false) goto L36;
        r5.putBoolean(r8, ((Boolean) r7).booleanValue());     // Catch: Exception -> L59
        r11 = TypedValues.Custom.S_BOOLEAN;
        goto L31
    L36:
        if ((r7 instanceof Long) == false) goto L39;
        r5.putLong(r8, ((Long) r7).longValue());     // Catch: Exception -> L59
        r11 = "long";
        goto L31
    L39:
        if ((r7 instanceof Integer) == false) goto L42;
        r5.putInt(r8, ((Integer) r7).intValue());     // Catch: Exception -> L59
        r11 = TypedValues.Custom.S_INT;
        goto L31
    L42:
        if ((r7 instanceof Float) == false) goto L47;
        r5.putFloat(r8, ((Float) r7).floatValue());     // Catch: Exception -> L59
        r11 = TypedValues.Custom.S_FLOAT;
        goto L31
    L47:
        throw new IllegalArgumentException("Unsupported type " + r12);     // Catch: Exception -> L59
    L17:
        Object r15 = this.f12184g.get(r8);     // Catch: Exception -> L59
        if (r15 != null) goto L20;
    L21:
        this.f12184g.put(r8, r7);     // Catch: Exception -> L59
        goto L16
    L20:
        if (r15.equals(r7) == true) goto L22;
    L48:
        if (r5 != null) goto L51;
        return null;
    L51:
        if (Build.VERSION.SDK_INT <= 8) goto L53;
        r5.apply();     // Catch: Exception -> L59
    L54:
        Iterator r16 = r3.iterator();     // Catch: Exception -> L59
    L56:
        if (r16.hasNext() == false) goto L61;
        ((Runnable) r16.next()).run();     // Catch: Exception -> L59
    L61:
        return null;
    L53:
        r5.commit();     // Catch: Exception -> L59
    L59:
        e = move-exception;
        o.f(e);
        goto L61
    L63:
        throw new IllegalArgumentException("Unsupported uri " + r12);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (com.ss.android.i.j.l() == null) goto L12;
        if (com.ss.android.i.j.l().g() == false) goto L12;
        if (w.j(getContext()) == true) goto L12;
        throw new IllegalAccessError("should be create in main process");
    L12:
        if (getContext() == null) goto L17;
        if ((getContext().getApplicationContext() instanceof Application) == false) goto L17;
        d.b.s.a.l0.d.j((Application) getContext().getApplicationContext());
    L17:
        if (f12182l == null) goto L25;
        return true;
    L25:
        d.b.s.a.a0.a.a("AuthTokenMultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L20
        r(getContext());     // Catch: Exception -> L20
        return true;
    L20:
        e = move-exception;
        o.f(e);
        e.printStackTrace();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r4, String[] r5, String r6, String[] r7, String r8) {
        i();
        Object r9 = null;
        String r10 = null;
        if (s() == false) goto L6;
        return null;
    L6:
        if (f12182l.match(r4) != 65536) goto L56;
        int r11 = 1;
        if ("all".equals(r4.getPathSegments().get(1)) == false) goto L37;
        Map<String, ?> r3 = m().getAll();     // Catch: Exception -> L52
        MatrixCursor r12 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L52
        Iterator<Map.Entry<String, ?>> r13 = r3.entrySet().iterator();     // Catch: Exception -> L35
    L11:
        r9 = r10;
        if (r13.hasNext() == false) goto L61;
        Map.Entry<String, ?> r14 = r13.next();     // Catch: Exception -> L35
        String r15 = r14.getKey();     // Catch: Exception -> L35
        Object r16 = r14.getValue();     // Catch: Exception -> L35
        MatrixCursor.RowBuilder r0 = r12.newRow();     // Catch: Exception -> L35
        boolean r1 = r16 instanceof String;     // Catch: Exception -> L35
        String r2 = TypedValues.Custom.S_STRING;
        if (r1 == true) goto L33;
        if ((r16 instanceof Boolean) == false) goto L25;
        r2 = TypedValues.Custom.S_BOOLEAN;
        if (((Boolean) r16).booleanValue() == false) goto L22;
        int r17 = 1;
    L23:
        r16 = Integer.valueOf(r17);     // Catch: Exception -> L35
        goto L33
    L22:
        r17 = 0;
        goto L23
    L25:
        if ((r16 instanceof Integer) == false) goto L28;
        r2 = TypedValues.Custom.S_INT;
        goto L33
    L28:
        if ((r16 instanceof Long) == false) goto L31;
        r2 = "long";
        goto L33
    L31:
        if ((r16 instanceof Float) == false) goto L33;
        r2 = TypedValues.Custom.S_FLOAT;
    L33:
        r0.add(r15);     // Catch: Exception -> L35
        r0.add(r16);     // Catch: Exception -> L35
        r0.add(r2);     // Catch: Exception -> L35
        r10 = r15;
    L61:
        return r12;
    L35:
        e = e;
        r9 = r12;
    L53:
        o.f(e);
        return r9;
    L37:
        String r18 = r4.getPathSegments().get(0);     // Catch: Exception -> L52
        if (this.f12184g.containsKey(r18) == true) goto L40;
        return null;
    L40:
        MatrixCursor r19 = new MatrixCursor(new String[]{r18});     // Catch: Exception -> L52
        Object r20 = this.f12184g.get(r18);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r21 = r19.newRow();     // Catch: Exception -> L50
        if ((r20 instanceof Boolean) == true) goto L44;
    L48:
        d.b.s.a.a0.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider  get key = " + r18 + " value = " + p.O(r20));     // Catch: Exception -> L50
        r21.add(r20);     // Catch: Exception -> L50
        r12 = r19;
        r9 = r21;
        goto L61
    L44:
        if (((Boolean) r20).booleanValue() == true) goto L47;
        r11 = 0;
    L47:
        r20 = Integer.valueOf(r11);     // Catch: Exception -> L50
    L50:
        e = e;
        r9 = r19;
    L52:
        e = e;
        goto L53
    L56:
        throw new IllegalArgumentException("Unsupported uri " + r4);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException();
    }
}
