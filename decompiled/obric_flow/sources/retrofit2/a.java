package retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f21735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Callback f21736c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r5, Callback r10, Object r11, int r12) {
        this.f21734a = r12;
        this.f21735b = r5;
        this.f21736c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f21734a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Callback r5 = this.f21736c;
        Throwable r10 = (Throwable) this.d;
        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.a(this.f21735b, r5, r10);
        return;
    L6:
        Callback r11 = this.f21736c;
        Response r12 = (Response) this.d;
        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.b(this.f21735b, r11, r12);
    }
}
