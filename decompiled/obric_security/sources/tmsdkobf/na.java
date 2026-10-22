package tmsdkobf;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.common.TMSDKContext;
import tmsdk.fg.module.spacemanager.ISpaceScanListener;
import tmsdk.fg.module.spacemanager.SpaceManager;

/* JADX INFO: loaded from: classes5.dex */
public class na {
    private static na A;
    private static final String[] v = null;
    private static final int w = 0;
    private static final int x = 0;
    private static final int y = 0;
    private static final int z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f366a;
    private ISpaceScanListener b;
    private ISpaceScanListener c;
    private ISpaceScanListener d;
    private ISpaceScanListener e;
    private Handler f;
    private volatile int g;
    private volatile int h;
    private final Object i;
    private final AtomicBoolean j;
    private volatile int k;
    private final Object l;
    private final AtomicBoolean m;
    private volatile int n;
    private final Object o;
    private final AtomicBoolean p;
    private long q;
    private final AtomicBoolean r;
    private ae s;
    private q0 t;
    private q2 u;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ na f367a;

        a(na r1, Looper r2) {
            this.f367a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r6) {
            int r0 = r6.what;
            switch(r0) {
                case 4097: goto L24;
                case 4098: goto L21;
                case 4099: goto L18;
                case 4100: goto L14;
                case 4101: goto L11;
                default: goto L5;
            };
        L11:
            ISpaceScanListener r1 = na.m2392$$Nest$fgetb(this.f367a);
            if (r1 == null) goto L77;
            r1.onFinish(r6.arg1, r6.obj);
        L17:
            na r5 = this.f367a;
            na.m2399$$Nest$fputb(r5, null);
            na.m2403$$Nest$fputg(r5, 1);
            return;
        L77:
            return;
        L14:
            ISpaceScanListener r7 = na.m2392$$Nest$fgetb(this.f367a);
            if (r7 == null) goto L78;
            r7.onCancelFinished();
            goto L17
        L78:
            return;
        L18:
            ISpaceScanListener r8 = na.m2392$$Nest$fgetb(this.f367a);
            if (r8 == null) goto L80;
        L69:
            r8.onProgressChanged(r6.arg1);
            return;
        L80:
            return;
        L21:
            ISpaceScanListener r9 = na.m2392$$Nest$fgetb(this.f367a);
            if (r9 == null) goto L81;
        L72:
            r9.onFound(r6.obj);
            return;
        L81:
            return;
        L24:
            ISpaceScanListener r10 = na.m2392$$Nest$fgetb(this.f367a);
            if (r10 == null) goto L82;
        L75:
            r10.onStart();
            return;
        L82:
            return;
        L5:
            switch(r0) {
                case 4353: goto L41;
                case 4354: goto L38;
                case 4355: goto L35;
                case 4356: goto L30;
                case 4357: goto L27;
                default: goto L7;
            };
        L27:
            ISpaceScanListener r2 = na.m2393$$Nest$fgetc(this.f367a);
            if (r2 == null) goto L83;
            r2.onFinish(r6.arg1, r6.obj);
            na r11 = this.f367a;
            na.m2400$$Nest$fputc(r11, null);
            na.m2404$$Nest$fputh(r11, 4);
            StringBuilder r12 = new StringBuilder("handleMessage finish | sSimilarState = ");
        L33:
            int r13 = na.m2396$$Nest$fgeth(this.f367a);
        L34:
            q8.c("PhotoManager", r12.append(r13).toString());
            return;
        L83:
            return;
        L30:
            ISpaceScanListener r14 = na.m2393$$Nest$fgetc(this.f367a);
            if (r14 == null) goto L84;
            r14.onCancelFinished();
            na r15 = this.f367a;
            na.m2400$$Nest$fputc(r15, null);
            na.m2404$$Nest$fputh(r15, 4);
            r12 = new StringBuilder("handleMessage cancel | sSimilarState = ");
            goto L33
        L84:
            return;
        L35:
            r8 = na.m2393$$Nest$fgetc(this.f367a);
            if (r8 != null) goto L69;
            return;
        L38:
            r9 = na.m2393$$Nest$fgetc(this.f367a);
            if (r9 != null) goto L72;
            return;
        L41:
            r10 = na.m2393$$Nest$fgetc(this.f367a);
            if (r10 != null) goto L75;
            return;
        L7:
            switch(r0) {
                case 4609: goto L57;
                case 4610: goto L54;
                case 4611: goto L51;
                case 4612: goto L47;
                case 4613: goto L44;
                default: goto L9;
            };
        L44:
            ISpaceScanListener r3 = na.m2394$$Nest$fgetd(this.f367a);
            if (r3 == null) goto L89;
            r3.onFinish(r6.arg1, r6.obj);
            na r16 = this.f367a;
            na.m2401$$Nest$fputd(r16, null);
            na.m2405$$Nest$fputk(r16, 14);
            r12 = new StringBuilder("handleMessage finish | sBlurState = ");
        L50:
            r13 = na.m2397$$Nest$fgetk(this.f367a);
            goto L34
        L89:
            return;
        L47:
            ISpaceScanListener r17 = na.m2394$$Nest$fgetd(this.f367a);
            if (r17 == null) goto L90;
            r17.onCancelFinished();
            na r18 = this.f367a;
            na.m2401$$Nest$fputd(r18, null);
            na.m2405$$Nest$fputk(r18, 14);
            r12 = new StringBuilder("handleMessage cancel | sBlurState = ");
            goto L50
        L90:
            return;
        L51:
            r8 = na.m2394$$Nest$fgetd(this.f367a);
            if (r8 != null) goto L69;
            return;
        L54:
            r9 = na.m2394$$Nest$fgetd(this.f367a);
            if (r9 != null) goto L72;
            return;
        L57:
            r10 = na.m2394$$Nest$fgetd(this.f367a);
            if (r10 != null) goto L75;
            return;
        L9:
            switch(r0) {
                case 4865: goto L73;
                case 4866: goto L70;
                case 4867: goto L67;
                case 4868: goto L63;
                case 4869: goto L60;
                default: goto L101;
            };
        L60:
            ISpaceScanListener r4 = na.m2395$$Nest$fgete(this.f367a);
            if (r4 == null) goto L94;
            r4.onFinish(r6.arg1, r6.obj);
            na r19 = this.f367a;
            na.m2402$$Nest$fpute(r19, null);
            na.m2406$$Nest$fputn(r19, 24);
            r12 = new StringBuilder("handleMessage finish | sCompressState = ");
        L66:
            r13 = na.m2398$$Nest$fgetn(this.f367a);
            goto L34
        L94:
            return;
        L63:
            ISpaceScanListener r20 = na.m2395$$Nest$fgete(this.f367a);
            if (r20 == null) goto L95;
            r20.onCancelFinished();
            na r21 = this.f367a;
            na.m2402$$Nest$fpute(r21, null);
            na.m2406$$Nest$fputn(r21, 24);
            r12 = new StringBuilder("handleMessage cancel | sCompressState = ");
            goto L66
        L95:
            return;
        L67:
            r8 = na.m2395$$Nest$fgete(this.f367a);
            if (r8 != null) goto L69;
            return;
        L70:
            r9 = na.m2395$$Nest$fgete(this.f367a);
            if (r9 != null) goto L72;
            return;
        L73:
            r10 = na.m2395$$Nest$fgete(this.f367a);
            if (r10 != null) goto L75;
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f368a;
        public long b;
        public long c;
        public long d;
        public ArrayList e;
        public Pair f;
        public Pair g;

        public b() {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetb, reason: not valid java name */
    static /* bridge */ /* synthetic */ ISpaceScanListener m2392$$Nest$fgetb(na r0) {
        return r0.b;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetc, reason: not valid java name */
    static /* bridge */ /* synthetic */ ISpaceScanListener m2393$$Nest$fgetc(na r0) {
        return r0.c;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetd, reason: not valid java name */
    static /* bridge */ /* synthetic */ ISpaceScanListener m2394$$Nest$fgetd(na r0) {
        return r0.d;
    }

    /* JADX INFO: renamed from: -$$Nest$fgete, reason: not valid java name */
    static /* bridge */ /* synthetic */ ISpaceScanListener m2395$$Nest$fgete(na r0) {
        return r0.e;
    }

    /* JADX INFO: renamed from: -$$Nest$fgeth, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2396$$Nest$fgeth(na r0) {
        return r0.h;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetk, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2397$$Nest$fgetk(na r0) {
        return r0.k;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetn, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2398$$Nest$fgetn(na r0) {
        return r0.n;
    }

    /* JADX INFO: renamed from: -$$Nest$fputb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2399$$Nest$fputb(na r0, ISpaceScanListener r1) {
        r0.b = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputc, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2400$$Nest$fputc(na r0, ISpaceScanListener r1) {
        r0.c = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2401$$Nest$fputd(na r0, ISpaceScanListener r1) {
        r0.d = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fpute, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2402$$Nest$fpute(na r0, ISpaceScanListener r1) {
        r0.e = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputg, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2403$$Nest$fputg(na r0, int r1) {
        r0.g = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputh, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2404$$Nest$fputh(na r0, int r1) {
        r0.h = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputk, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2405$$Nest$fputk(na r0, int r1) {
        r0.k = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2406$$Nest$fputn(na r0, int r1) {
        r0.n = r1;
    }

    static {
        v = new String[]{"_id", "_data", "datetaken", "_size"};
        w = b("_id");
        x = b("datetaken");
        y = b("_data");
        z = b("_size");
        A = null;
    }

    private na() {
        this.f366a = new byte[0];
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = 0;
        this.h = 0;
        this.i = new Object();
        this.j = new AtomicBoolean(false);
        this.k = 0;
        this.l = new Object();
        this.m = new AtomicBoolean(false);
        this.n = 0;
        this.o = new Object();
        this.p = new AtomicBoolean(false);
        this.q = 0;
        AtomicBoolean r1 = new AtomicBoolean();
        this.r = r1;
        this.g = 1;
        r1.set(false);
        this.f = new a(this, Looper.getMainLooper());
    }

    private static long a(long r2, String r4) {
        if (r2 <= 0) goto L6;
        return r2;
    L6:
        return new File(r4).length();
    }

    private static long b(long r3, String r5) {
        if (r3 <= 0) goto L6;
        return r3;
    L6:
        if (c9.f(r5) == false) goto L9;
        r3 = c9.a(r5);
    L9:
        if (r3 == 0) goto L11;
        return r3;
    L11:
        return new File(r5).lastModified();
    }

    public static na e() {
        if (A != null) goto L6;
        A = new na();
    L6:
        return A;
    }

    public int c() {
        if (2 == this.g) goto L6;
        return -1;
    L6:
        this.r.set(true);
        return 1;
    }

    public int d() {
        this.q = System.currentTimeMillis();
        this.j.set(true);
        if (3 == this.h) goto L6;
        q8.c("PhotoManager", "cancelSimilarProcess return | sSimilarState = " + this.h);
        return -1;
    L6:
        this.s.a();
        this.h = 4;
        q8.c("PhotoManager", "cancelSimilarProcess | sSimilarState = " + this.h);
        return 1;
    }

    public void f() {
        this.j.set(false);
        this.m.set(false);
        this.p.set(false);
    }

    private static boolean c(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return false;
    L5:
        return new File(r1).exists();
    }

    public int a() {
        this.q = System.currentTimeMillis();
        this.m.set(true);
        q8.c("PhotoManager", "cancelBlurProcess = " + this.m);
        if (13 == this.k) goto L6;
        q8.c("PhotoManager", "cancelBlurProcess return | sBlurState = " + this.k);
        return -1;
    L6:
        this.t.a();
        this.k = 14;
        q8.c("PhotoManager", "cancelBlurProcess | sBlurState = " + this.k);
        return 1;
    }

    public int b() {
        this.q = System.currentTimeMillis();
        this.p.set(true);
        if (23 == this.n) goto L6;
        q8.c("PhotoManager", "cancelCompressProcess return | sCompressState = " + this.n);
        return -1;
    L6:
        this.u.a();
        this.n = 24;
        q8.c("PhotoManager", "cancelCompressProcess | sCompressState = " + this.n);
        return 1;
    }

    public void d(ISpaceScanListener r2) {
        this.h = 4;
        this.c = r2;
    }

    private static int b(String r5) {
        String[] r0 = v;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (r0[r2].equals(r5) == true) goto L6;
        r3 = r3 + 1;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return -1;
    }

    public long a(String r2) {
        if (this.u != null) goto L6;
        this.u = new q2();
    L6:
        return this.u.a(r2);
    }

    public void c(ISpaceScanListener r1) {
        this.b = r1;
    }

    public long a(String r2, int r3) {
        if (this.u != null) goto L6;
        this.u = new q2();
    L6:
        return this.u.a(r2, r3);
    }

    public int b(String[] r8) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.g == 1) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L23
        return SpaceManager.ERROR_CODE_CONCURRENCY;
    L8:
        this.r.set(false);     // Catch: Throwable -> L23
        this.g = 2;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        this.f.sendMessage(this.f.obtainMessage(FragmentTransaction.TRANSIT_FRAGMENT_OPEN));
        long r2 = System.currentTimeMillis();
        ArrayList r9 = a(TMSDKContext.getApplicaionContext().getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, v, r8);
        if (this.r.get() == false) goto L15;
    L12:
        this.f.sendMessage(this.f.obtainMessage(4100));
        return SpaceManager.ERROR_CODE_CANCEL_SCAN;
    L15:
        if (r9.size() != 0) goto L18;
        Message r10 = this.f.obtainMessage(4101);
        r10.obj = null;
        r10.arg1 = SpaceManager.ERROR_CODE_IMG_NOT_FOUND;
        this.f.sendMessage(r10);
        return SpaceManager.ERROR_CODE_IMG_NOT_FOUND;
    L18:
        d9.a(r9);
        if (this.r.get() == true) goto L12;
        b r0 = new b();
        r0.e = r9;
        a(r0);
        q8.b("PhotoManager", "scan take time:" + (System.currentTimeMillis() - r2));
        Message r11 = this.f.obtainMessage(4101);
        r11.obj = le.a(r0);
        r11.arg1 = 0;
        this.f.sendMessage(r11);
        return 0;
    }

    public long a(String r2, int r3, String r4) {
        if (this.u != null) goto L6;
        this.u = new q2();
    L6:
        return this.u.a(r2, r3, r4);
    }

    public void b(ISpaceScanListener r2) {
        this.n = 24;
        this.e = r2;
    }

    public int a(ArrayList r9, double r10, int r12) {
        q8.c("PhotoManager", "getBlurPhotos mStopBlurRequest = " + this.m);
        if (this.m.getAndSet(false) == true) goto L5;
    L8:
        q8.c("PhotoManager", "getBlurPhotos start");
        Object r2 = this.l;
        monitor-enter(r2);
        q8.c("PhotoManager", "synchronized getBlurPhotos");     // Catch: Throwable -> L23
        if (this.k == 14) goto L17;
        q8.c("PhotoManager", "synchronized getBlurPhotos return | sBlurState = " + this.k);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        return SpaceManager.ERROR_CODE_CONCURRENCY;
    L17:
        if (this.t != null) goto L19;
        this.t = new q0();     // Catch: Throwable -> L23
    L19:
        this.k = 13;     // Catch: Throwable -> L23
        q8.c("PhotoManager", "synchronized getBlurPhotos | sBlurState = " + this.k);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        this.f.sendMessage(this.f.obtainMessage(4609));
        long r0 = System.currentTimeMillis();
        int r8 = this.t.a(r9, r10, this.f, r12);
        q8.e("PhotoManager", "blurResult = " + r8 + ", Blur time consume : " + (System.currentTimeMillis() - r0) + "ms");
        return r8;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (Math.abs(this.q - System.currentTimeMillis()) >= 300) goto L8;
        q8.c("PhotoManager", "getBlurPhotos stop");
        q8.c("PhotoManager", "getBlurPhotos stop mStopBlurRequest = " + this.m);
        return SpaceManager.ERROR_CODE_STOP_ERROR;
    }

    public int a(List r7) {
        if (this.p.getAndSet(false) == true) goto L5;
    L8:
        Object r2 = this.o;
        monitor-enter(r2);
    L23:
        th = move-exception;
        throw th;
    L11:
        if (this.n == 24) goto L17;
        q8.c("PhotoManager", "getCompressPhotos return | sCompressState = " + this.n);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        return SpaceManager.ERROR_CODE_CONCURRENCY;
    L17:
        if (this.u != null) goto L19;
        this.u = new q2();     // Catch: Throwable -> L23
    L19:
        this.n = 23;     // Catch: Throwable -> L23
        q8.c("PhotoManager", "getCompressPhotos | sCompressState = " + this.n);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        this.f.sendMessage(this.f.obtainMessage(4865));
        long r0 = System.currentTimeMillis();
        int r6 = this.u.a(r7, this.f);
        q8.e("PhotoManager", "compressResult = " + r6 + ", Compress time consume : " + (System.currentTimeMillis() - r0) + "ms");
        return r6;
    L5:
        if (Math.abs(this.q - System.currentTimeMillis()) >= 300) goto L8;
        q8.c("PhotoManager", "getCompressPhotos stop");
        return SpaceManager.ERROR_CODE_STOP_ERROR;
    }

    private String[] a(String[] r3) {
        String[] r2 = new String[r3.length];
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        r2[r0] = String.valueOf(r3[r0].toLowerCase().hashCode());
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }

    private void a(b r12) {
        ArrayList r11 = r12.e;
        if (r11 != null) goto L5;
        return;
    L5:
        long r0 = 0;
        r12.f368a = 0;
        r12.c = 0;
        r12.b = 0;
        r12.d = 0;
        Iterator r13 = r11.iterator();
        int r4 = 0;
        int r5 = 0;
        long r2 = 0;
    L7:
        if (r13.hasNext() == false) goto L15;
        d9 r6 = (d9) r13.next();
        if (r6.e == false) goto L11;
        r2 = r2 + r6.b;
        r5 = r5 + 1;
    L11:
        long r7 = r6.b;
        r0 = r0 + r7;
        r4 = r4 + 1;
        if (r6.d == true) goto L13;
        r12.f368a += r7;
        goto L7
    L13:
        r12.b += r7;
        goto L7
    L15:
        r12.f = new Pair(Integer.valueOf(r4), Long.valueOf(r0));
        r12.g = new Pair(Integer.valueOf(r5), Long.valueOf(r2));
    }

    public int a(ArrayList r7, int r8) {
        if (this.j.getAndSet(false) == true) goto L5;
    L8:
        q8.c("PhotoManager", "getSimilarPhotos start");
        Object r2 = this.i;
        monitor-enter(r2);
        q8.c("PhotoManager", "synchronized getSimilarPhotos");     // Catch: Throwable -> L23
        if (this.h == 4) goto L17;
        q8.c("PhotoManager", "synchronized getSimilarPhotos return | sSimilarState = " + this.h);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        return SpaceManager.ERROR_CODE_CONCURRENCY;
    L17:
        if (this.s != null) goto L19;
        this.s = new ae();     // Catch: Throwable -> L23
    L19:
        this.h = 3;     // Catch: Throwable -> L23
        q8.c("PhotoManager", "synchronized getSimilarPhotos | sSimilarState = " + this.h);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        this.f.sendMessage(this.f.obtainMessage(4353));
        long r0 = System.currentTimeMillis();
        int r6 = this.s.a(r7, r8, this.f);
        q8.e("PhotoManager", "similarResult = " + r6 + ", Similar time consume : " + (System.currentTimeMillis() - r0) + "ms");
        return r6;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (Math.abs(this.q - System.currentTimeMillis()) >= 300) goto L8;
        q8.c("PhotoManager", "getSimilarPhotos stop");
        return SpaceManager.ERROR_CODE_STOP_ERROR;
    }

    private ArrayList a(ContentResolver r17, Uri r18, String[] r19, String[] r20) {
        ArrayList r2 = new ArrayList();
        Cursor r5 = null;
        if (r20 != null) goto L6;
        Cursor r1 = r17.query(r18, r19, "_size>30720", null, null);     // Catch: Throwable -> L28
    L5:
        r5 = r1;
        if (r5 == null) goto L25;
        r5.moveToFirst();     // Catch: Throwable -> L28
        int r3 = r5.getCount();     // Catch: Throwable -> L28
        int r6 = 0;
    L14:
        if (r5.isAfterLast() == true) goto L26;
        if (this.r.get() == true) goto L26;
        String r13 = r5.getString(y);     // Catch: Throwable -> L28
        r6 = r6 + 1;     // Catch: Throwable -> L28
        Message r8 = this.f.obtainMessage(InputDeviceCompat.SOURCE_TOUCHSCREEN);     // Catch: Throwable -> L28
        r8.obj = r13;     // Catch: Throwable -> L28
        this.f.sendMessage(r8);     // Catch: Throwable -> L28
        Message r9 = this.f.obtainMessage(FragmentTransaction.TRANSIT_FRAGMENT_FADE);     // Catch: Throwable -> L28
        r9.arg1 = (r6 * 100) / r3;     // Catch: Throwable -> L28
        this.f.sendMessage(r9);     // Catch: Throwable -> L28
        if (c(r13) == true) goto L21;
    L23:
        q8.e("PhotoManager", "media file not exist : " + r13);     // Catch: Throwable -> L28
    L24:
        r5.moveToNext();     // Catch: Throwable -> L28
        goto L14
    L21:
        if (c9.g(r13) == false) goto L23;
        r2.add(new d9(b(r5.getLong(x), r13), a(r5.getLong(z), r13), r13, r5.getLong(w)));     // Catch: Throwable -> L28
    L26:
        if (r5 != null) goto L39;
    L32:
        return r2;
    L39:
        r5.close();     // Catch: Exception -> L37
        goto L32
    L25:
        q8.b("PhotoManager", "cursor is null!");     // Catch: Throwable -> L28
        goto L26
    L6:
        String[] r10 = a(r20);     // Catch: Throwable -> L28
        String r7 = "bucket_id=?";
        int r11 = 1;
    L8:
        if (r11 >= r20.length) goto L10;
        r7 = r7 + " OR bucket_id=?";     // Catch: Throwable -> L28
        r11 = r11 + 1;     // Catch: Throwable -> L28
        goto L8
    L10:
        r1 = r17.query(r18, r19, r7 + " AND _size>30720", r10, null);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        q8.a("PhotoManager", th.getMessage(), th);     // Catch: Throwable -> L33
        if (0 == 0) goto L32;
    L33:
        th = move-exception;
        if (0 != 0) goto L44;
    L36:
        throw th;
    L44:
        r5.close();     // Catch: Exception -> L38
        goto L36
    }

    public void a(ISpaceScanListener r2) {
        this.k = 14;
        this.d = r2;
    }
}
