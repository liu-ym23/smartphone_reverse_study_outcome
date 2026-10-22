package z2;

import com.bytedance.ai.monitor.AppletErrorCode;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppletErrorCode f23370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f23371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f23372c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ long e;

    public /* synthetic */ c(AppletErrorCode r5, String r10, String r11, Function1 r12, long r13) {
        this.f23370a = r5;
        this.f23371b = r10;
        this.f23372c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r5 = new a(this.f23370a, this.f23371b);
        r5.f23366n = this.f23372c;
        this.d.invoke(r5);
        r5.e = this.e;
        d.c(r5);
    }
}
