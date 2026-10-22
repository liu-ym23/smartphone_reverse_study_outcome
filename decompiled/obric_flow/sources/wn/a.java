package wn;

import com.lynx.tasm.image.AutoSizeImage;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f22872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f22873c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ AutoSizeImage g;

    public /* synthetic */ a(AutoSizeImage r5, boolean r10, int r11, int r12, int r13, int r14, int r15) {
        this.f22871a = r15;
        this.g = r5;
        this.f22872b = r10;
        this.f22873c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f22871a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r5 = this.e;
        int r10 = this.f;
        AutoSizeImage.t(this.g, this.f22872b, this.f22873c, this.d, r5, r10);
        return;
    L6:
        int r11 = this.e;
        int r12 = this.f;
        AutoSizeImage.t(this.g, this.f22872b, this.f22873c, this.d, r11, r12);
    }
}
