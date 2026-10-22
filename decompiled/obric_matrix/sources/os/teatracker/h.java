package os.teatracker;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f22720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f22721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f22722d;

    public h(String r2, JSONObject r3) {
        this(r2, r3, false);
    }

    public h(String r7, JSONObject r8, boolean r9) {
        this(r7, r8, r9, System.currentTimeMillis());
    }

    public h(String r2, JSONObject r3, boolean r4, long r5) {
        this.f22722d = false;
        this.f22719a = r2;
        this.f22720b = r3;
        this.f22722d = r4;
        this.f22721c = r5;
    }

    public String a() {
        return this.f22719a;
    }

    public JSONObject b() {
        return this.f22720b;
    }

    public int c() {
        String r0 = this.f22719a;
        if (r0 == null) goto L5;
        int r1 = 40 + (r0.length() * 2);
    L6:
        JSONObject r2 = this.f22720b;
        if (r2 == null) goto L10;
        r1 = (r1 + 24) + (r2.toString().length() * 2);
    L10:
        return (r1 + 8) + 1;
    L5:
        r1 = 16;
        goto L6
    }

    public long d() {
        return this.f22721c;
    }

    public boolean e() {
        return this.f22722d;
    }

    public void f(JSONObject r1) {
        this.f22720b = r1;
    }

    public String toString() {
        return "Event{isInstant = '" + this.f22722d + "', event = '" + this.f22719a + "', jsonParams = '" + this.f22720b + "'}";
    }
}
