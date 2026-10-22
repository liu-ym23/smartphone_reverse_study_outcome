package tmsdkobf;

import tmsdk.common.TMServiceFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class h9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f241a;
    private String b;

    public h9(String r2) {
        this.f241a = r2;
        this.b = "TMSProperties" + this.f241a;
    }

    private String a(String r1) {
        return r1;
    }

    public boolean a(String r2, boolean r3) {
        return a().getBoolean(a(r2), r3);
    }

    public void b(String r1) {
        a().remove(r1);
    }

    public int a(String r2, int r3) {
        return a().getInt(a(r2), r3);
    }

    public long a(String r2, long r3) {
        return a().getLong(a(r2), r3);
    }

    private p6 a() {
        return TMServiceFactory.getPreferenceService(this.b);
    }

    public String a(String r2, String r3) {
        return a().getString(a(r2), r3);
    }

    public void a(String r1, boolean r2, boolean r3) {
        a().putBoolean(a(r1), r2);
    }

    public void a(String r1, int r2, boolean r3) {
        a().putInt(a(r1), r2);
    }

    public void a(String r1, long r2, boolean r4) {
        a().putLong(a(r1), r2);
    }

    public void a(String r1, String r2, boolean r3) {
        a().putString(a(r1), r2);
    }
}
