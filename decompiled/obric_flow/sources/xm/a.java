package xm;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f23160b;

    public /* synthetic */ a(d r5, int r10) {
        this.f23159a = r10;
        this.f23160b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f23159a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        d r5 = this.f23160b;
        r5.f23164a.setAnimation(r5.e);
        if (r5.f23164a.getKeyframeManager() == null) goto L10;
        r5.f23164a.getKeyframeManager().a();
        return;
    L10:
        return;
    L8:
        d r10 = this.f23160b;
        r10.f23164a.setAnimation(r10.e);
        r10.f23164a.requestLayout();
    }
}
