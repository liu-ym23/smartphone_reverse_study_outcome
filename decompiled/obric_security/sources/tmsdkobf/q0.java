package tmsdkobf;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.qualityscan.BlurDetector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.fg.module.spacemanager.SpaceManager;
import tmsdk.fg.module.spacemanager.SpaceScanResult;

/* JADX INFO: loaded from: classes5.dex */
public class q0 {
    public static double d = 0.65d;
    public static int e = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile AtomicBoolean f426a;
    private final BlurDetector b;
    private int c;

    class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f427a;
        final /* synthetic */ Handler b;
        final /* synthetic */ int c;
        final /* synthetic */ q0 d;

        a(q0 r1, List r2, Handler r3, int r4) {
            this.d = r1;
            this.f427a = r2;
            this.b = r3;
            this.c = r4;
        }

        @Override // tmsdkobf.q0.b
        public void a(SpaceScanResult r3) {
            this.f427a.add(r3);
            q8.c("BlurPhotoProcessor", "scan blur found，path = " + r3.mPath);
            Message r0 = this.b.obtainMessage(4610);
            r0.obj = r3;
            this.b.sendMessage(r0);
        }

        @Override // tmsdkobf.q0.b
        public void a() {
            q0 r0 = this.d;
            int r1 = q0.m2433$$Nest$fgetc(r0) + 1;
            q0.m2434$$Nest$fputc(r0, r1);
            if (r1 > this.c) goto L6;
            Message r2 = this.b.obtainMessage(4611);
            r2.arg1 = (q0.m2433$$Nest$fgetc(this.d) * 100) / this.c;
            this.b.sendMessage(r2);
            return;
        }
    }

    private interface b {
        void a();

        void a(SpaceScanResult r1);
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f428a;
        private CountDownLatch b;
        private Handler c;
        private double d;
        private float e;
        private b f;
        final /* synthetic */ q0 g;

        public c(q0 r2, List r3, double r4, Handler r6, CountDownLatch r7, b r8) {
            this.g = r2;
            q8.c("BlurPhotoProcessor", "ImageProcessor size = " + r3.size());
            this.f428a = r3;
            this.b = r7;
            this.c = r6;
            this.d = r4;
            this.e = System.currentTimeMillis();
            this.f = r8;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r0 = 0;
        L30:
        L27:
            th = move-exception;
            this.b.countDown();
            throw th;
        L4:
            if (r0 >= this.f428a.size()) goto L10;
            if (q0.m2432$$Nest$fgeta(this.g).get() == true) goto L8;
            SpaceScanResult r1 = (SpaceScanResult) this.f428a.get(r0);     // Catch: Throwable -> L27
            if ((System.currentTimeMillis() - this.e) < (8000.0d - (this.d * 20.0d))) goto L16;
            this.e = System.currentTimeMillis();     // Catch: Throwable -> L27
            q8.a("BlurPhotoProcessor", "pause 8 s");     // Catch: Throwable -> L27
            p0.a(200);     // Catch: Throwable -> L27
        L16:
            if (this.g.a(r1) <= this.d) goto L21;
            b r4 = this.f;     // Catch: Throwable -> L27
            if (r4 == null) goto L21;
            r4.a(r1);     // Catch: Throwable -> L27
        L21:
            if (q0.m2432$$Nest$fgeta(this.g).get() == true) goto L22;
            b r2 = this.f;     // Catch: Throwable -> L27
            if (r2 == null) goto L26;
            r2.a();     // Catch: Throwable -> L27
        L26:
            r0 = r0 + 1;
            goto L30
        L22:
            q8.a("BlurPhotoProcessor", "blur scan is canceled");     // Catch: Throwable -> L27
            Message r3 = this.c.obtainMessage(4612);     // Catch: Throwable -> L27
            Handler r5 = this.c;     // Catch: Throwable -> L27
        L9:
            r5.sendMessage(r3);     // Catch: Throwable -> L27
            goto L10
        L8:
            q8.a("BlurPhotoProcessor", "scan is canceled");     // Catch: Throwable -> L27
            r3 = this.c.obtainMessage(4612);     // Catch: Throwable -> L27
            r5 = this.c;     // Catch: Throwable -> L27
        L10:
            this.b.countDown();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgeta, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m2432$$Nest$fgeta(q0 r0) {
        return r0.f426a;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetc, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2433$$Nest$fgetc(q0 r0) {
        return r0.c;
    }

    /* JADX INFO: renamed from: -$$Nest$fputc, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2434$$Nest$fputc(q0 r0, int r1) {
        r0.c = r1;
    }

    static {
    }

    public q0() {
        this.f426a = new AtomicBoolean();
        this.b = new BlurDetector();
        this.c = 0;
    }

    public double a(String r10) {
        double[] r2 = {0.0d};
        if (r10.endsWith(".jpg") == false) goto L5;
    L31:
        Bitmap r6 = p0.a(r10);     // Catch: Throwable -> L26
        if (r6 == null) goto L24;
        Bitmap.Config r7 = r6.getConfig();     // Catch: Throwable -> L26
        Bitmap.Config r8 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L26
        if (r7 == r8) goto L20;
        Bitmap r1 = r6.copy(r8, true);     // Catch: Throwable -> L26
        r6.recycle();     // Catch: Throwable -> L26
        r6 = r1;
    L20:
        if (r6.getConfig() == r8) goto L22;
        q8.b("BlurPhotoProcessor", "Image color format error,color format cannot be converted ARGB_8888");     // Catch: Throwable -> L26
        r2[0] = 0.0d;     // Catch: Throwable -> L26
    L23:
        r6.recycle();     // Catch: Throwable -> L26
    L28:
        q8.a("BlurPhotoProcessor", "blur image, Path=" + r10 + ",value=" + r2[0]);
    L30:
        return r2[0];
    L22:
        r2[0] = this.b.blurDetect(r6);     // Catch: Throwable -> L26
        goto L23
    L24:
        r2[0] = 0.0d;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r2[0] = 0.0d;
        q8.b("BlurPhotoProcessor", th);
        System.gc();
        goto L28
    L5:
        if (r10.endsWith(".png") == true) goto L31;
        if (r10.endsWith(".jpeg") == true) goto L31;
        if (r10.endsWith(".JPG") == true) goto L31;
        if (r10.endsWith(".PNG") == true) goto L31;
        if (r10.endsWith(".JPEG") == false) goto L30;
        goto L31
    }

    public double a(SpaceScanResult r10) {
        double[] r2 = {0.0d};
        String r6 = r10.mPath;
        if (r6.endsWith(".jpg") == false) goto L5;
    L31:
        Bitmap r11 = p0.a(r10);     // Catch: Throwable -> L26
        if (r11 == null) goto L24;
        Bitmap.Config r7 = r11.getConfig();     // Catch: Throwable -> L26
        Bitmap.Config r8 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L26
        if (r7 == r8) goto L20;
        Bitmap r1 = r11.copy(r8, true);     // Catch: Throwable -> L26
        r11.recycle();     // Catch: Throwable -> L26
        r11 = r1;
    L20:
        if (r11.getConfig() == r8) goto L22;
        q8.b("BlurPhotoProcessor", "Image color format error,color format cannot be converted ARGB_8888");     // Catch: Throwable -> L26
        r2[0] = 0.0d;     // Catch: Throwable -> L26
    L23:
        r11.recycle();     // Catch: Throwable -> L26
    L28:
        q8.a("BlurPhotoProcessor", "blur image, Path=" + r6 + ",value=" + r2[0]);
    L30:
        return r2[0];
    L22:
        r2[0] = this.b.blurDetect(r11);     // Catch: Throwable -> L26
        goto L23
    L24:
        r2[0] = 0.0d;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r2[0] = 0.0d;
        q8.b("BlurPhotoProcessor", th);
        System.gc();
        goto L28
    L5:
        if (r6.endsWith(".png") == true) goto L31;
        if (r6.endsWith(".jpeg") == true) goto L31;
        if (r6.endsWith(".JPG") == true) goto L31;
        if (r6.endsWith(".PNG") == true) goto L31;
        if (r6.endsWith(".JPEG") == false) goto L30;
        goto L31
    }

    public void a() {
        this.f426a.set(true);
    }

    private long[] a(List r5) {
        int r4 = r5.size();
        Iterator r6 = r5.iterator();
        long r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L7;
        r0 = r0 + ((SpaceScanResult) r6.next()).mSize;
        goto L4
    L7:
        return new long[]{r4, r0};
    }

    public int a(ArrayList r25, double r26, Handler r28, int r29) {
        q0 r0 = this;
        ArrayList r9 = r25;
        int r1 = r29;
        int r11 = 0;
        r0.f426a.set(false);
        if (r28 == null) goto L41;
        if (r9 == null) goto L41;
        if (r26 >= 0.0d) goto L9;
    L38:
        q8.b("BlurPhotoProcessor", "blur threshold >= 0 && blur <= 1");
        Message r2 = r28.obtainMessage(4613);
        int r3 = -53;
    L39:
        r2.arg1 = r3;
        r2.obj = null;
        r28.sendMessage(r2);
        return -1;
    L9:
        if (r26 > 1.0d) goto L38;
        if (r0.f426a.get() == false) goto L15;
        q8.a("BlurPhotoProcessor", "scan is canceled");
        r28.sendMessage(r28.obtainMessage(4612));
        return SpaceManager.ERROR_CODE_CANCEL_SCAN;
    L15:
        int r14 = (int) a(r25)[0];
        r0.c = 0;
        ArrayList r15 = new ArrayList();
        long r16 = System.currentTimeMillis();
        int r8 = 1;
        if (r1 >= 1) goto L18;
    L20:
        r1 = e;
    L21:
        q8.c("BlurPhotoProcessor", "startScan totalCount = " + r14);
        int r7 = Math.min(r1, r14);
        int r18 = r14 / r7;
        int r4 = r14 % r7;
        CountDownLatch r6 = new CountDownLatch(r7);
        we r5 = ve.f();
        int r10 = 0;
        int r12 = 0;
        int r13 = 0;
    L22:
        if (r13 >= r7) goto L31;
        int r19 = r10 + r18;
        if (r4 <= 0) goto L26;
        int r20 = r8;
    L27:
        int r17 = r19 + r20;
        if (r4 <= 0) goto L30;
        r4 = r4 - 1;
    L30:
        int r110 = r4;
        q8.c("BlurPhotoProcessor", "start = " + r10 + ", end = " + Math.min(r17, r14));
        ArrayList r21 = new ArrayList(r9.subList(r10, Math.min(r17, r14)));
        a r22 = new a(r0, r15, r28, r14);
        int r23 = r12;
        we r24 = r5;
        CountDownLatch r27 = r6;
        r12 = r23 + 1;
        r24.a(new c(this, r21, r26, r28, r27, r22), "blurDetector" + r23);
        r13 = r13 + 1;
        r0 = this;
        r10 = r17;
        r7 = r7;
        r5 = r24;
        r4 = r110;
        r8 = 1;
        r6 = r27;
        r11 = 0;
        r9 = r25;
        goto L22
    L26:
        r20 = r11;
        goto L27
    L31:
        int r30 = r7;
        r6.await();     // Catch: InterruptedException -> L34
    L36:
        q8.c("BlurPhotoProcessor", "Blur scanResult totalCount = " + r14 + ", scanResult = " + r15.size() + ", taskCount = " + r30 + ", costTime = " + (System.currentTimeMillis() - r16));
        Message r31 = r28.obtainMessage(4613);
        r31.arg1 = 0;
        r31.obj = r15;
        r28.sendMessage(r31);
        return 0;
    L34:
        e = move-exception;
        q8.a("BlurPhotoProcessor", e);
        goto L36
    L18:
        if (r1 > 99) goto L20;
    L41:
        q8.b("BlurPhotoProcessor", "startScan parameter is null");
        r2 = r28.obtainMessage(4613);
        r3 = -3;
        goto L39
    }
}
