package d.b.s.a.e0;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14716d;

    public a(int r1, int r2, String r3, String r4) {
        this.f14713a = r1;
        this.f14714b = r2;
        this.f14715c = r3;
        this.f14716d = r4;
    }

    public String a() {
        return this.f14716d;
    }

    public void b(String r1) {
        this.f14716d = r1;
    }

    public String toString() {
        return "ErrorCodeTask{mErrorCode=" + this.f14713a + ", mType=" + this.f14714b + ", mInfo='" + this.f14715c + "', mDetail='" + this.f14716d + "'}";
    }
}
