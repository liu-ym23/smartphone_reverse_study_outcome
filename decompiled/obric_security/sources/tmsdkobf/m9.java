package tmsdkobf;

import android.content.Context;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class m9 {
    private static m9 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f348a;
    private final String b;
    private me c;

    static {
    }

    private m9(Context r1) {
        this.f348a = "ConfigInfo";
        this.b = "sk";
        this.c = (me) qd.a(9);
    }

    public static m9 e() {
        if (d != null) goto L15;
        monitor-enter(m9.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new m9(TMSDKContext.getApplicaionContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(m9.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public Boolean a() {
        return Boolean.valueOf(g().getBoolean("ac_swi", false));
    }

    public long b() {
        return g().getLong("ad", 0);
    }

    public int c() {
        return g().getInt("ae", -1);
    }

    public boolean d() {
        return g().getBoolean("key_dv_sw", true);
    }

    public long f() {
        return g().getLong("lct", 0);
    }

    public p6 g() {
        return this.c.b("ConfigInfo");
    }

    public p6 h() {
        return this.c.b("sk");
    }

    public Boolean i() {
        return Boolean.valueOf(g().getBoolean("seitch_turing", true));
    }

    public long j() {
        return g().getLong("update_sdk_setting_last_time", 0);
    }

    public void a(Boolean r2) {
        g().putBoolean("ac_swi", r2.booleanValue());
    }

    public void b(long r2) {
        g().putLong("lct", r2);
    }

    public void c(Boolean r2) {
        g().putBoolean("seitch_turing", r2.booleanValue());
    }

    public void a(long r2) {
        g().putLong("ad", r2);
    }

    public void b(Boolean r2) {
        g().putBoolean("roach_exist", r2.booleanValue());
    }

    public void c(long r2) {
        g().putLong("update_sdk_setting_last_time", r2);
    }

    public void a(int r2) {
        g().putInt("ae", r2);
    }

    public void a(boolean r2) {
        g().putBoolean("key_dv_sw", r2);
    }
}
