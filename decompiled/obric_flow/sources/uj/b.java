package uj;

import com.bytedance.ttnet.diagnosis.IDiagnosisCallback;
import com.bytedance.ttnet.diagnosis.IDiagnosisRequest;
import java.lang.reflect.Constructor;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements IDiagnosisRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IDiagnosisCallback f22363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f22365c;
    public final int d;
    public final int e;
    public final a f;

    public b(int r5, List r10, int r11, int r12) {
        this.f = new a();
        this.f22364b = r5;
        this.f22365c = r10;
        this.d = r11;
        this.e = r12;
        Class<?> r13 = Class.forName("org.chromium.diagnosis.CronetDiagnosisRequestImpl");     // Catch: Throwable -> L5
    L6:
        if (r13 == null) goto L10;
        Class r14 = Integer.TYPE;
        Constructor<?> r15 = r13.getDeclaredConstructor(new Class[]{a.class, r14, List.class, r14, r14});
        Integer r16 = Integer.valueOf(this.f22364b);
        Integer r17 = Integer.valueOf(this.d);
        Integer r18 = Integer.valueOf(this.e);
        r15.newInstance(new Object[]{this.f, r16, this.f22365c, r17, r18});
        return;
    L10:
        throw new ClassNotFoundException("org.chromium.diagnosis.CronetDiagnosisRequestImpl class not found");
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public final void cancel() {
        monitor-enter(this);
        monitor-exit(this);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public final void doExtraCommand(String r5, String r10) {
        monitor-enter(this);
        monitor-exit(this);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public final void setUserExtraInfo(String r5) {
        monitor-enter(this);
        doExtraCommand("extra_info", r5);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public final void start(IDiagnosisCallback r5) {
        monitor-enter(this);
        this.f22363a = r5;     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }
}
