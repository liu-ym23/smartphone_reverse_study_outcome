package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
class fe {
    private static Object b;
    private static fe c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p6 f201a;

    static {
        b = new Object();
    }

    private fe() {
        this.f201a = ((me) qd.a(9)).b("soft_list_sp_name");
    }

    public static fe c() {
        if (c != null) goto L15;
        Object r0 = b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new fe();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public int a() {
        return this.f201a.getInt("soft_list_profile_full_quantity_", 0);
    }

    public boolean b() {
        return this.f201a.getBoolean("soft_list_profile_full_upload_", false);
    }

    public void a(boolean r2) {
        this.f201a.putBoolean("soft_list_profile_full_upload_", r2);
    }

    public void a(int r2) {
        this.f201a.putInt("soft_list_profile_full_quantity_", r2);
    }
}
