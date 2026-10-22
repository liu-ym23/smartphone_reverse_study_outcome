package w7;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f22747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22749c;

    public a(long r5, long r10) {
        this.f22747a = r5;
        this.f22749c = r10;
        if (r10 <= 0) goto L6;
        this.f22748b = true;
        return;
    }
}
