package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f21519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21520b;

    public b2(String r1) {
        this.f21519a = r1;
        this.f21520b = 0;
    }

    public boolean a() {
        if (this.f21520b == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public String b() {
        int r0 = this.f21520b;
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        int r1 = this.f21519a.indexOf(46, r0);
        if (r1 != (-1)) goto L10;
        String r2 = this.f21519a.substring(this.f21520b);
        this.f21520b = -1;
        return r2;
    L10:
        String r3 = this.f21519a.substring(this.f21520b, r1);
        this.f21520b = r1 + 1;
        return r3;
    }
}
