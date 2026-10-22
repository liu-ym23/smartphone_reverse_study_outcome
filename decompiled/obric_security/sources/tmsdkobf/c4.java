package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public class c4 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b5 f124a;

    public c4(b5 r1) {
        this.f124a = r1;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b5.a(this.f124a);     // Catch: Throwable -> L4
        return;
    }
}
