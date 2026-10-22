package d.b.b.e.a.k;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f12650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONArray f12651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f12652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12654e;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f12655a = null;

        static {
            f12655a = new b();
        }

        static /* synthetic */ b a() {
            return f12655a;
        }
    }

    /* JADX INFO: renamed from: d.b.b.e.a.k.b$b, reason: collision with other inner class name */
    static final enum EnumC0330b extends Enum<EnumC0330b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0330b f12656g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0330b f12657h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ EnumC0330b[] f12658i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f12659f;

        static {
            EnumC0330b r0 = new EnumC0330b("SERVER_DROP", 0, "server drop message");
            f12656g = r0;
            EnumC0330b r1 = new EnumC0330b("FULL_DISK", 1, "disk is full");
            f12657h = r1;
            f12658i = new EnumC0330b[]{r0, r1};
        }

        private EnumC0330b(String r1, int r2, String r3) {
            super(r1, r2);
            this.f12659f = r3;
        }

        public static EnumC0330b valueOf(String r1) {
            return (EnumC0330b) Enum.valueOf(EnumC0330b.class, r1);
        }

        public static EnumC0330b[] values() {
            return (EnumC0330b[]) f12658i.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f12659f;
        }
    }

    b() {
        this.f12651b = new JSONArray();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static SharedPreferences a(Application r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private synchronized void b() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f12652c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f12652c = true;     // Catch: Throwable -> L13
        SharedPreferences r0 = a(d.b.b.o.a.b(), d.b.b.i.c.a.m() + "_drop_message", 0);     // Catch: Throwable -> L13
        this.f12650a = r0;     // Catch: Throwable -> L13
        String r1 = r0.getString("drop_data_items", "");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r1) == false) goto L19;
    L11:
        monitor-exit(this);
        return;
    L19:
        this.f12651b = new JSONArray(r1);     // Catch: Exception -> L16 Throwable -> L13
        goto L11
    }

    static b c() {
        return a.a();
    }

    JSONArray d() {
        b();
        JSONArray r0 = new JSONArray();
        JSONArray r1 = new JSONArray();
        int r2 = 0;
    L13:
        if (r2 >= this.f12651b.length()) goto L10;
        if (r2 >= 10) goto L8;
        r0.put(this.f12651b.get(r2));     // Catch: Exception -> L12
    L9:
        r2 = r2 + 1;
        goto L13
    L8:
        r1.put(this.f12651b.get(r2));     // Catch: Exception -> L12
    L10:
        this.f12651b = r1;
        this.f12650a.edit().putString("drop_data_items", this.f12651b.toString()).commit();
        return r0;
    }

    void e(long r5, long r7, long r9, EnumC0330b r11) {
        b();
        JSONObject r1 = new JSONObject();
        r1.put("log_type", "server_drop_data");     // Catch: Exception -> L13
        r1.put("timestamp", r9);     // Catch: Exception -> L13
        r1.put("drop_data_count", r5);     // Catch: Exception -> L13
        r1.put("drop_data_bytes", r7);     // Catch: Exception -> L13
        if (r11 != EnumC0330b.f12656g) goto L6;
        r1.put("x-tt-logid", this.f12653d);     // Catch: Exception -> L13
        r1.put("drop_timestamp", this.f12654e);     // Catch: Exception -> L13
    L6:
        if (r11 == null) goto L8;
        r1.put("drop_reason", r11);     // Catch: Exception -> L13
    L8:
        this.f12651b.put(r1);     // Catch: Exception -> L13
        if (d.b.b.o.a.c() == false) goto L11;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "monitorDropLog:" + this.f12651b.toString());     // Catch: Exception -> L13
    L11:
        this.f12650a.edit().putString("drop_data_items", this.f12651b.toString()).commit();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "monitorDropLog:", e);
    }

    void f(String r1) {
        this.f12653d = r1;
    }

    void g(long r1) {
        this.f12654e = r1;
    }
}
