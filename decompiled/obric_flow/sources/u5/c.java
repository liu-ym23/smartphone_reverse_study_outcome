package u5;

import com.bytedance.apm.agent.v2.instrumentation.FragmentTimeAgent;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f22258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f22259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f22260c;

    public c(String r5, long r10, long r11) {
        this.f22258a = r5;
        this.f22259b = r10;
        this.f22260c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r5 = FragmentTimeAgent.access$100().contains(FragmentTimeAgent.access$000());
        FragmentTimeAgent.access$100().add(FragmentTimeAgent.access$000());
        long r10 = this.f22259b;
        long r11 = this.f22260c;
        FragmentTimeAgent.access$200(r5, this.f22258a, r10, r11);
    }
}
