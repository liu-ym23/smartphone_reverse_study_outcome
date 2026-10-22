package tmsdkobf;

import androidx.work.WorkRequest;
import tmsdk.common.creator.ManagerCreatorC;

/* JADX INFO: loaded from: classes5.dex */
public abstract class nb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f369a = false;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h9 f370a;

        a(h9 r1) {
            this.f370a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.sleep(WorkRequest.MIN_BACKOFF_MILLIS);     // Catch: InterruptedException -> L5
        L7:
            ua.a(ManagerCreatorC.getManager(yd.class));
            throw null;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    static {
    }

    public static void a() {
        if (f369a == false) goto L5;
        return;
    L5:
        f369a = true;
        h9 r0 = new h9("tms");
        if (r0.a("reportlc", false) == true) goto L9;
        ve.f().a(new a(r0), "nmct");
        return;
    }
}
