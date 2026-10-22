package ms.bd.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
class r2 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.mobsec.metasec.ml.c f22474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ s2 f22475b;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ r2 f22476f;

        a(r2 r1) {
            this.f22476f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            s2.c(this.f22476f.f22475b).b(false);
            String r0 = (String) m.a(16777217, 0, 0, "9d908e", new byte[]{12, 105, 95, 125, 14, 124, 22, 76, 126, 101});
            String r1 = (String) m.a(16777217, 0, 0, "edf457", new byte[]{40, 58, 73, 0, 57, 52, 105, 85, 39, 97, 112, 42, 85, 87, 3, 44, 106, 5, 53, 97, 52, 116, 16, 83, 30, 33, 116, 81, 50, 96, 52, 103, 19, 84, 15, 50, 38, 0, 51, 119});
            int r7 = s2.e(this.f22476f.f22475b).c() / 1000;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ r2 f22477f;

        b(r2 r1) {
            this.f22477f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            s2.c(this.f22477f.f22475b).e();
            String r0 = (String) m.a(16777217, 0, 0, "3a98f3", new byte[]{6, 108, 95, 117, 80, 42, 28, 73, 126, 109});
            String r1 = (String) m.a(16777217, 0, 0, "9ac1ef", new byte[]{118, 61, 78, 5, 105, 101, 59, 82, 38, 100, 44, 47, 80, 82, 83, 125, 54, 0, 48, 100, 104, 112, 4, 74, 74, 97, 63, 68, 114, 96, 46, 119, 21, 87, 26, 52, 62, 83});
            int r7 = s2.e(this.f22477f.f22475b).a() / 1000;
        }
    }

    r2(s2 r1, Looper r2) {
        this.f22475b = r1;
        super(r2);
    }

    private void a() {
        if (this.f22474a != null) goto L5;
        this.f22474a = com.bytedance.mobsec.metasec.ml.d.a(s2.b(this.f22475b));
    L5:
        String r0 = (String) m.a(16777217, 0, 0, "47a176", new byte[]{1, 58, 7, 124, 1, 47, 27, 31, 38, 100});
        String r1 = (String) m.a(16777217, 0, 0, "0b64d0", new byte[]{5, 111, 5, 115, 127, 12, 115, 81, 98, 116, 46, 114, 81, 73, 85, 32, 125, 13, 41});
        this.f22474a.c((String) m.a(16777217, 0, 0, "606656", new byte[]{43, 59, 83, 71, 53, 53, 48, 2}));
    }

    private void b(Handler r1, int r2, long r3) {
        Message r0 = new Message();
        r0.what = r2;
        r1.sendMessageDelayed(r0, r3);
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message r5) {
        super.handleMessage(r5);
        int r6 = r5.what;
        if (r6 == 0) goto L21;
        int r1 = 2;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L14;
        r1 = 3;
        if (r6 != 3) goto L10;
        a();
        int r7 = s2.e(this.f22475b).b();
    L16:
        b(this, r1, r7);
        return;
    L10:
        if (r6 != 4) goto L26;
        a();
        s2.c(this.f22475b).b(true);
        s2.h(this.f22475b).removeCallbacks(null);
        s2.i(this.f22475b).countDown();
        return;
    L26:
        return;
    L14:
        s2.c(this.f22475b).g();
    L15:
        r7 = s2.e(this.f22475b).a();
        goto L16
    L17:
        s2.g(this.f22475b).post(new b(this));
        if (s2.e(this.f22475b).e() == true) goto L15;
        b(this, 0, s2.e(this.f22475b).a());
        return;
    L21:
        s2.g(this.f22475b).post(new a(this));
        s2.c(this.f22475b).g();
        b(this, 1, s2.e(this.f22475b).c());
    }
}
