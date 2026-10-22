package com.bytedance.ttnet.diagnosis;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class b implements IDiagnosisRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IDiagnosisCallback f6312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f6314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f6320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bytedance.frameworks.baselib.network.http.cronet.d.a.InterfaceC0149a f6321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.bytedance.frameworks.baselib.network.http.cronet.d.a f6322k;

    class a implements com.bytedance.frameworks.baselib.network.http.cronet.d.a.InterfaceC0149a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f6323a;

        a(b r1) {
            this.f6323a = r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.d.a.InterfaceC0149a
        public void a(String r2) {
            if (b.a(this.f6323a) == null) goto L6;
            b.a(this.f6323a).onDiagnosisComplete(r2);
            return;
        }
    }

    static {
    }

    public b(int r2, List<String> r3, int r4, int r5, int r6) {
        this.f6321j = new a(this);
        this.f6318g = false;
        this.f6319h = false;
        this.f6313b = r2;
        this.f6314c = r3;
        this.f6315d = r4;
        this.f6316e = r5;
        this.f6317f = r6;
        c();
    }

    static /* synthetic */ IDiagnosisCallback a(b r0) {
        return r0.f6312a;
    }

    private Class<?> b(String r1) {
        return Class.forName(r1);
    L4:
        return null;
    }

    private void c() {
        if (this.f6322k != null) goto L11;
        Class<?> r0 = b("org.chromium.diagnosis.CronetDiagnosisRequestImpl");
        if (r0 == null) goto L10;
        Class<?> r3 = Integer.TYPE;
        Object r1 = r0.getDeclaredConstructor(new Class[]{com.bytedance.frameworks.baselib.network.http.cronet.d.a.InterfaceC0149a.class, r3, List.class, r3, r3, r3}).newInstance(new Object[]{this.f6321j, Integer.valueOf(this.f6313b), this.f6314c, Integer.valueOf(this.f6315d), Integer.valueOf(this.f6316e), Integer.valueOf(this.f6317f)});
        if ((r1 instanceof com.bytedance.frameworks.baselib.network.http.cronet.d.a) == false) goto L12;
        this.f6322k = (com.bytedance.frameworks.baselib.network.http.cronet.d.a) r1;
        return;
    L12:
        return;
    L10:
        throw new ClassNotFoundException("org.chromium.diagnosis.CronetDiagnosisRequestImpl class not found");
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void cancel() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f6318g == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (this.f6319h == true) goto L11;
        this.f6322k.cancel();     // Catch: Throwable -> L13
        this.f6319h = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void doExtraCommand(String r2, String r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f6318g == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.f6322k.doExtraCommand(r2, r3);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void setUserExtraInfo(String r2) {
        monitor-enter(this);
        this.f6320i = r2;     // Catch: Throwable -> L6
        doExtraCommand("extra_info", r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void start(IDiagnosisCallback r2) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f6318g == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        this.f6312a = r2;     // Catch: Throwable -> L14
        this.f6322k.start();     // Catch: Throwable -> L14
        this.f6318g = true;     // Catch: Throwable -> L14
        String r3 = this.f6320i;     // Catch: Throwable -> L14
        if (r3 != null) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        if (r3.isEmpty() == true) goto L12;
        doExtraCommand("extra_info", this.f6320i);     // Catch: Throwable -> L14
        goto L12
    }
}
