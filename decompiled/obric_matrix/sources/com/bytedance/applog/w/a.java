package com.bytedance.applog.w;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.applog.util.n;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Cloneable {
    private static final SimpleDateFormat u = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f2443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f2444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f2448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f2449l;
    public String m;
    public int n;
    public int o;
    public int p;
    public int q;
    String r;
    int s;
    int t;

    static {
        u = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    }

    public a() {
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.s = -1;
        this.t = 0;
        t(0);
    }

    public static String e(long r2) {
        return u.format(new Date(r2));
    }

    public static a f(String r4) {
        JSONObject r1 = new JSONObject(r4);     // Catch: Throwable -> L8
        a r5 = b.f2450d.get(r1.optString("k_cls", ""));     // Catch: Throwable -> L8
        if (r5 == null) goto L7;
        return r5.a().p(r1);
    L7:
        return null;
    L8:
        th = move-exception;
        n.i(th);
        return null;
    }

    protected abstract JSONObject B();

    public a a() {
        return (a) super.clone();
    L4:
        e = move-exception;
        n.i(e);
        return null;
    }

    final String c() {
        List<String> r0 = h();
        if (r0 == null) goto L9;
        StringBuilder r1 = new StringBuilder(128);
        r1.append("create table if not exists ");
        r1.append(n());
        r1.append("(");
        int r3 = 0;
    L6:
        if (r3 >= r0.size()) goto L8;
        r1.append(r0.get(r3));
        r1.append(" ");
        r1.append(r0.get(r3 + 1));
        r1.append(",");
        r3 = r3 + 2;
        goto L6
    L8:
        r1.delete(r1.length() - 1, r1.length());
        r1.append(")");
        return r1.toString();
    L9:
        return null;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    protected final void d(@NonNull JSONObject r7) {
        boolean r0 = com.bytedance.applog.a.m();
        if (r0 == false) goto L5;
    L6:
        r7.put("user_id", this.f2447j);
    L7:
        if (r0 == false) goto L9;
    L10:
        r7.put("uid", this.f2448k);
    L11:
        if (r0 == false) goto L13;
    L14:
        r7.put("user_type", this.o);
    L15:
        if (r0 == false) goto L17;
    L18:
        r7.put("user_is_login", this.p);
    L19:
        if (r0 == false) goto L21;
    L22:
        r7.put("user_is_auth", this.q);
        return;
    L21:
        if (this.q > 0) goto L22;
        return;
    L17:
        if (this.p <= 0) goto L19;
    L13:
        if (this.o <= 0) goto L15;
    L9:
        if (this.f2448k <= 0) goto L11;
    L5:
        if (this.f2447j <= 0) goto L7;
        goto L6
    }

    protected List<String> h() {
        return Arrays.asList(new String[]{"_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, "user_id", TypedValues.Custom.S_INT, "uid", TypedValues.Custom.S_INT, "session_id", "varchar", "user_unique_id", "varchar", "ab_sdk_version", "varchar", "user_type", TypedValues.Custom.S_INT, "user_is_login", TypedValues.Custom.S_INT, "user_is_auth", TypedValues.Custom.S_INT, "priority", TypedValues.Custom.S_INT, "forward", TypedValues.Custom.S_INT});
    }

    protected String i() {
        return null;
    }

    protected String j() {
        return "sid:" + this.f2446i;
    }

    public int k() {
        return this.t;
    }

    public int m() {
        return this.s;
    }

    @NonNull
    abstract String n();

    public int o(@NonNull Cursor r3) {
        this.f2443f = r3.getLong(0);
        this.f2444g = r3.getLong(1);
        this.f2445h = r3.getLong(2);
        this.n = r3.getInt(3);
        this.f2447j = r3.getLong(4);
        this.f2448k = r3.getLong(5);
        this.f2446i = r3.getString(6);
        this.f2449l = r3.getString(7);
        this.m = r3.getString(8);
        this.o = r3.getInt(9);
        this.p = r3.getInt(10);
        this.q = r3.getInt(11);
        this.s = r3.getInt(12);
        this.t = r3.getInt(13);
        return 14;
    }

    protected a p(@NonNull JSONObject r6) {
        this.f2444g = r6.optLong("local_time_ms", 0);
        this.f2443f = 0;
        this.f2445h = 0;
        this.n = 0;
        this.f2447j = 0;
        this.f2448k = 0;
        this.f2446i = null;
        this.f2449l = null;
        this.m = null;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.s = r6.optInt("priority", -1);
        this.t = r6.optInt("forward");
        return this;
    }

    public void q(int r1) {
        this.t = r1;
    }

    public void r(int r1) {
        this.s = r1;
    }

    public void t(long r3) {
        if (r3 != 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        this.f2444g = r3;
    }

    @NonNull
    public String toString() {
        String r0 = n();
        if (getClass().getSimpleName().equalsIgnoreCase(r0) == true) goto L5;
        r0 = r0 + ", " + getClass().getSimpleName();
    L5:
        String r1 = this.f2446i;
        String r3 = "-";
        if (r1 == null) goto L12;
        int r4 = r1.indexOf("-");
        if (r4 < 0) goto L10;
        r1 = r1.substring(0, r4);
    L10:
        r3 = r1;
    L12:
        return "{" + r0 + ", " + j() + ", " + r3 + ", " + this.f2444g + "}";
    }

    @NonNull
    public final JSONObject u() {
        JSONObject r0 = new JSONObject();
        r0.put("k_cls", n());     // Catch: JSONException -> L5
        z(r0);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        n.i(e);
        goto L7
    }

    @NonNull
    public final JSONObject v() {
        this.r = e(this.f2444g);     // Catch: JSONException -> L4
        return B();
    L4:
        e = move-exception;
        com.bytedance.applog.o.b.e(this, com.bytedance.applog.r.b.d.n);
        com.bytedance.applog.o.b.i(com.bytedance.applog.r.b.a.x, com.bytedance.applog.o.b.a(this));
        n.i(e);
        return null;
    }

    final ContentValues w(@Nullable ContentValues r1) {
        if (r1 != null) goto L4;
        r1 = new ContentValues();
    L5:
        y(r1);
        return r1;
    L4:
        r1.clear();
        goto L5
    }

    protected void y(@NonNull ContentValues r3) {
        r3.put("local_time_ms", Long.valueOf(this.f2444g));
        r3.put("tea_event_index", Long.valueOf(this.f2445h));
        r3.put("nt", Integer.valueOf(this.n));
        r3.put("user_id", Long.valueOf(this.f2447j));
        r3.put("uid", Long.valueOf(this.f2448k));
        r3.put("session_id", this.f2446i);
        r3.put("user_unique_id", this.f2449l);
        r3.put("ab_sdk_version", this.m);
        r3.put("user_type", Integer.valueOf(this.o));
        r3.put("user_is_login", Integer.valueOf(this.p));
        r3.put("user_is_auth", Integer.valueOf(this.q));
        r3.put("priority", Integer.valueOf(this.s));
        r3.put("forward", Integer.valueOf(this.t));
    }

    protected void z(@NonNull JSONObject r4) {
        r4.put("local_time_ms", this.f2444g);
        r4.put("priority", this.s);
        r4.put("forward", this.t);
    }
}
