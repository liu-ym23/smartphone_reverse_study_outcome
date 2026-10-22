package ms.bd.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u2 f22480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private x2 f22481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f22483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f22484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f22485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HandlerThread f22486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CountDownLatch f22487h;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ s2 f22488f;

        a(s2 r1) {
            this.f22488f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            s2.i(this.f22488f).await();     // Catch: InterruptedException -> L5
        L3:
            s2.j(this.f22488f).quitSafely();
            String r6 = (String) m.a(16777217, 0, 0, "27637a", new byte[]{7, 58, 80, 126, 1, 120, 29, 31, 113, 102});
            String r7 = (String) m.a(16777217, 0, 0, "7a1d7e", new byte[]{18, 107, 71, 80, 31, 125, 38, 76, 100, 116, 49, 98, 81, 80, 6, 125, 35, 0, 113, 33, 47, 102, 86, 94});
        }
    }

    static {
        String r0 = (String) m.a(16777217, 0, 0, "3174d5", new byte[]{6, 60, 81, 121, 82, 44, 28, 25, 112, 97});
    }

    public s2(u2 r9, String r10) {
        this.f22483d = false;
        if (TextUtils.isEmpty(r10) == false) goto L6;
        String r8 = (String) m.a(16777217, 0, 0, "6283dc", new byte[]{3, 63, 94, 126, 82, 122, 25, 26, 127, 102});
        String r11 = (String) m.a(16777217, 0, 0, "e209e0", new byte[]{93, 62, 74, 89, 26, 33, 103, 26, 109, 108, 112, 124, 3, 76, 74, 55, 79, 55, 33, 96, 103, 112, 81, 72, 75, 50, 111, 1, 100, 109, 58});
        return;
    L6:
        x2 r0 = new x2();
        this.f22481b = r0;
        if (r0.d() == false) goto L10;
        String r1 = (String) m.a(16777217, 0, 0, "e24212", new byte[]{80, 63, 82, 127, 7, 43, 74, 26, 115, 103});
        String r2 = (String) m.a(16777217, 0, 0, "72b891", new byte[]{15, 62, 7, 77, 10, 47, 48, 83, 32, 109, 50, 36, 24, 66, 1, 53, 122});
    L10:
        if (this.f22481b.f() == false) goto L13;
        this.f22482c = r10;
        this.f22480a = r9;
        this.f22487h = new CountDownLatch(1);
        this.f22483d = true;
        return;
    }

    static /* synthetic */ String b(s2 r0) {
        return r0.f22482c;
    }

    static /* synthetic */ u2 c(s2 r0) {
        return r0.f22480a;
    }

    static /* synthetic */ x2 e(s2 r0) {
        return r0.f22481b;
    }

    static /* synthetic */ Handler g(s2 r0) {
        return r0.f22485f;
    }

    static /* synthetic */ Handler h(s2 r0) {
        return r0.f22484e;
    }

    static /* synthetic */ CountDownLatch i(s2 r0) {
        return r0.f22487h;
    }

    static /* synthetic */ HandlerThread j(s2 r0) {
        return r0.f22486g;
    }

    public String a() {
        x2 r0 = this.f22481b;
        if (r0 == null) goto L9;
        if (r0.d() == false) goto L9;
        w2 r2 = new w2();
        r2.f22532g = -2;
        return r2.toString();
    L9:
        if (this.f22483d == true) goto L11;
        return "";
    L11:
        return this.f22480a.f();
    }

    public void d() {
        if (this.f22483d == true) goto L5;
        return;
    L5:
        if (this.f22480a.c() == false) goto L9;
        this.f22485f = new Handler(Looper.getMainLooper());
        HandlerThread r0 = new HandlerThread((String) m.a(16777217, 0, 0, "f01535", new byte[]{123, 59, 84, 68, 51, 54, 96, 2}));
        this.f22486g = r0;
        r0.start();
        this.f22484e = new r2(this, this.f22486g.getLooper());
        Message r1 = new Message();
        r1.what = 1;
        this.f22484e.sendMessage(r1);
        Message r2 = new Message();
        r2.what = 3;
        this.f22484e.sendMessageDelayed(r2, this.f22481b.b());
        return;
    }

    public void f() {
        if (this.f22483d == true) goto L5;
        return;
    L5:
        if (this.f22480a.c() == false) goto L9;
        Message r0 = new Message();
        r0.what = 4;
        this.f22484e.sendMessage(r0);
        new Thread(new a(this)).start();
        return;
    }
}
