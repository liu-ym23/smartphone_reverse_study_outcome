package yh;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements fh.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f23267b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f23268c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23269a;

    static {
        f23267b = new a(0);
        f23268c = new a(1);
    }

    public /* synthetic */ a(int r5) {
        this.f23269a = r5;
    }

    @Override // fh.b
    public final Object create() {
        switch(this.f23269a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new g();
    L7:
        return new d();
    }
}
