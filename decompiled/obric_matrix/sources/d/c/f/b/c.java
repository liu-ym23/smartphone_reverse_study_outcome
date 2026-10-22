package d.c.f.b;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15560c;

    public c() {
        a();
    }

    public void a() {
        this.f15558a = false;
        this.f15559b = 4;
        c();
    }

    public void b() {
        this.f15560c++;
    }

    public void c() {
        this.f15560c = 0;
    }

    public void d(boolean r1) {
        this.f15558a = r1;
    }

    public boolean e() {
        if (this.f15558a == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f15560c >= this.f15559b) goto L7;
        return true;
    }
}
