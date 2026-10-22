package rh;

import com.bytedance.pia.core.utils.j;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f21745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fh.a f21746c;

    public /* synthetic */ e(i r5, fh.a r10, int r11) {
        this.f21744a = r11;
        this.f21745b = r5;
        this.f21746c = r10;
    }

    @Override // fh.a
    public final void accept(Object r5) {
        String r10 = (String) r5;
        switch(this.f21744a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        j.A(this.f21745b.f21763h + "Handle message from worker (Message: " + r10 + ")");
        this.f21746c.accept(r10);
        return;
    L6:
        j.s(this.f21745b.f21763h + "Handle error from worker(Error: " + r10 + ")");
        this.f21746c.accept(r10);
    }
}
