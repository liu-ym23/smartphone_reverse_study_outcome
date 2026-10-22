package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes5.dex */
public class hl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f248a;
    private Context b;
    private boolean c;
    private e d;
    private long e;
    private f f;
    private g g;
    private String h;
    private sh i;
    private Handler j;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ hl f249a;

        a(hl r1, Looper r2) {
            this.f249a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r7) {
            if (r7.what != 1) goto L7;
            hl.a(this.f249a);
            hl.e(this.f249a).a(hl.b(this.f249a), hl.c(this.f249a), ((long) hl.d(this.f249a).g()) * 1000);
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ hl f250a;

        b(hl r1) {
            this.f250a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r0 = hl.d(this.f250a).g();
            if (hl.f(this.f250a) == false) goto L12;
        L9:
            hl.e(this.f250a).a(hl.b(this.f250a), hl.c(this.f250a), ((long) r0) * 1000);
            return;
        L12:
            if (Build.VERSION.SDK_INT < 33) goto L7;
            hl.b(this.f250a).registerReceiver(hl.g(this.f250a), new IntentFilter(hl.c(this.f250a)), rd.f(), null, 4);     // Catch: Throwable -> L11
        L8:
            hl.a(this.f250a, true);     // Catch: Throwable -> L11
            goto L9
        L7:
            hl.b(this.f250a).registerReceiver(hl.g(this.f250a), new IntentFilter(hl.c(this.f250a)), rd.f(), null);     // Catch: Throwable -> L11
            goto L8
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ hl f251a;

        c(hl r1) {
            this.f251a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            hl.e(this.f251a).a(hl.b(this.f251a), hl.c(this.f251a));
            hl.e(this.f251a).a(hl.b(this.f251a), hl.c(this.f251a), ((long) hl.d(this.f251a).g()) * 1000);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ hl f252a;

        d(hl r1, String r2) {
            this.f252a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            hl.h(this.f252a).removeMessages(1);
            hl.e(this.f252a).a(hl.b(this.f252a), hl.c(this.f252a));
            if (hl.f(this.f252a) == false) goto L9;
            hl.b(this.f252a).unregisterReceiver(hl.g(this.f252a));     // Catch: Throwable -> L6
            hl.a(this.f252a, false);     // Catch: Throwable -> L6
            return;
        L10:
            return;
        }
    }

    private class e extends bj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ hl f253a;

        private e(hl r1) {
            this.f253a = r1;
        }

        @Override // tmsdkobf.bj
        public void a(Context r3, Intent r4) {
            String r5 = r4.getAction();
            String r6 = r4.getPackage();
            if (r5 == null) goto L12;
            if (r6 != null) goto L6;
            return;
        L6:
            if (r6.equals(rd.e().getPackageName()) == true) goto L9;
            return;
        L9:
            if (r5.equals(hl.c(this.f253a)) == false) goto L14;
            hl.h(this.f253a).sendEmptyMessageDelayed(1, WsConstants.EXIT_DELAY_TIME);
            return;
        L14:
            return;
        }

        /* synthetic */ e(hl r1, a r2) {
            this(r1);
        }
    }

    public interface f {
        void b();
    }

    public interface g {
        ql a();

        int g();
    }

    public hl(Context r4, f r5, g r6) {
        this.f248a = true;
        this.c = false;
        this.d = null;
        this.e = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.b = r4;
        this.f = r5;
        this.g = r6;
        ql r7 = r6.a();
        this.f248a = r7.f460a.C;
        this.d = new e(this, null);
        this.h = r7.j() + "_action.hb.a.c";
        this.i = new sh(r7.f460a.B);
        this.j = new a(this, r7.h());
    }

    static /* synthetic */ void a(hl r0) {
        r0.a();
    }

    static /* synthetic */ Context b(hl r0) {
        return r0.b;
    }

    static /* synthetic */ String c(hl r0) {
        return r0.h;
    }

    static /* synthetic */ g d(hl r0) {
        return r0.g;
    }

    static /* synthetic */ sh e(hl r0) {
        return r0.i;
    }

    static /* synthetic */ boolean f(hl r0) {
        return r0.c;
    }

    static /* synthetic */ e g(hl r0) {
        return r0.d;
    }

    static /* synthetic */ Handler h(hl r0) {
        return r0.j;
    }

    static /* synthetic */ boolean a(hl r0, boolean r1) {
        r0.c = r1;
        return r1;
    }

    public void b() {
        if (this.f248a == true) goto L5;
        return;
    L5:
        this.j.post(new c(this));
    }

    public void c() {
        if (this.f248a == true) goto L5;
        return;
    L5:
        this.j.post(new b(this));
    }

    public void a(String r3) {
        if (this.f248a == true) goto L5;
        return;
    L5:
        this.j.post(new d(this, r3));
    }

    private void a() {
        if (this.f == null) goto L8;
        long r0 = System.currentTimeMillis();
        if ((r0 - this.e) < 30000) goto L9;
        this.f.b();
        this.e = r0;
        return;
    L9:
        return;
    }
}
