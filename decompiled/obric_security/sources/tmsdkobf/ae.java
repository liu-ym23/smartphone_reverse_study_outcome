package tmsdkobf;

import android.os.Handler;
import android.os.Message;
import com.tencent.qqimagecompare.QQImageFeatureHSV;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.fg.module.spacemanager.SpaceManager;

/* JADX INFO: loaded from: classes5.dex */
public class ae {
    public static int c = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f98a;
    private int b;

    /* JADX INFO: renamed from: $r8$lambda$96otigR5-k4vAIUIIfzmtx1Bu-8, reason: not valid java name */
    public static /* synthetic */ void m2374$r8$lambda$96otigR5k4vAIUIIfzmtx1Bu8(ae r0, BlockingQueue r1, Handler r2, List r3, int r4, CountDownLatch r5) {
        r0.a(r1, r2, r3, r4, r5);
    }

    static {
    }

    public ae() {
        this.f98a = new AtomicBoolean();
        this.b = 0;
    }

    private List a(w7 r9) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = a(r9.c);
        if (this.f98a.get() == true) goto L23;
        if (r1 == null) goto L23;
        int r2 = 0;
    L8:
        if (r2 >= r1.size()) goto L22;
        if (this.f98a.get() == true) goto L11;
        ArrayList r4 = (ArrayList) r1.get(r2);
        if (r4 == null) goto L21;
        if (r4.isEmpty() == true) goto L21;
        w7 r5 = new w7(r9);
        Iterator r6 = r4.iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        int r7 = ((Integer) r6.next()).intValue();
        w7.a r8 = (w7.a) r9.c.get(r7);
        r5.c.add(r8);
        goto L18
    L20:
        b(r5);
        r0.add(r5);
    L21:
        r2 = r2 + 1;
        goto L8
    L11:
        return null;
    L22:
        return r0;
    L23:
        return null;
    }

    private List b(List r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.size() - 1;
    L3:
        if (r1 < 0) goto L15;
        if (this.f98a.get() == true) goto L6;
        d9 r2 = (d9) r5.get(r1);
        if (r2 == null) goto L14;
        if (r2.e == true) goto L14;
        a(r0, new w7.a(r2));
    L14:
        r1 = r1 - 1;
        goto L3
    L6:
        return null;
    L15:
        return r0;
    }

    private void b(ArrayList r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.size()) goto L9;
        if (this.f98a.get() == true) goto L12;
        w7.a r1 = (w7.a) r4.get(r0);
        r1.i = u7.a(r1);
        r0 = r0 + 1;
        goto L4
    L12:
        return;
    }

    public void a() {
        this.f98a.set(true);
    }

    private ArrayList a(ArrayList r11) {
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet();
        b(r11);
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r11.size()) goto L27;
        if (this.f98a.get() == true) goto L7;
        ArrayList r4 = a(r3, r0);
        QQImageFeatureHSV r5 = ((w7.a) r11.get(r3)).i;
        int r6 = r3 + 1;
        int r7 = r6;
    L10:
        if (r7 >= r11.size()) goto L21;
        QQImageFeatureHSV r8 = ((w7.a) r11.get(r7)).i;
        if (r5 == null) goto L19;
        if (r8 == null) goto L19;
        if (u7.a(r5, r8) < 75) goto L19;
        if (r1.contains(Integer.valueOf(r7)) == true) goto L19;
        r1.add(Integer.valueOf(r7));
        r4.add(Integer.valueOf(r7));
    L19:
        r7 = r7 + 1;
        goto L10
    L21:
        if (r4.isEmpty() == true) goto L25;
        if (r1.contains(Integer.valueOf(r3)) == true) goto L25;
        r1.add(Integer.valueOf(r3));
        r4.add(Integer.valueOf(r3));
    L25:
        r3 = r6;
        goto L4
    L7:
        return null;
    L27:
        if (r2 >= r11.size()) goto L32;
        w7.a r10 = (w7.a) r11.get(r2);
        QQImageFeatureHSV r9 = r10.i;
        if (r9 == null) goto L31;
        r9.finish();
        r10.i = null;
    L31:
        r2 = r2 + 1;
        goto L27
    L32:
        return r0;
    }

    private void b(w7 r4) {
        ArrayList r3 = r4.c;
        int r0 = 0;
    L4:
        if (r0 >= r3.size()) goto L10;
        w7.a r1 = (w7.a) r3.get(r0);
        if (r0 == 0) goto L8;
        r1.h = true;
    L9:
        r0 = r0 + 1;
        goto L4
    L8:
        r1.h = false;
        goto L9
    }

    private long[] a(List r7) {
        Iterator r6 = r7.iterator();
        long r0 = 0;
        int r2 = 0;
    L4:
        if (r6.hasNext() == false) goto L10;
        w7 r3 = (w7) r6.next();
        r2 = r2 + r3.c.size();
        Iterator r4 = r3.c.iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        r0 = r0 + ((w7.a) r4.next()).b;
        goto L7
    L10:
        return new long[]{r2, r0};
    }

    private ArrayList a(int r3, ArrayList r4) {
        Iterator r2 = r4.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ArrayList r0 = (ArrayList) r2.next();
        if (r0.contains(Integer.valueOf(r3)) == false) goto L4;
        return r0;
    L8:
        ArrayList r5 = new ArrayList();
        r4.add(r5);
        return r5;
    }

    private void a(List r6, w7.a r7) {
        Iterator r5 = r6.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        w7 r0 = (w7) r5.next();
        if ((r0.f597a - r7.f149a) > 30000) goto L4;
        r0.c.add(r7);
        return;
    L9:
        w7 r8 = new w7(r7.f149a);
        r8.f597a = r7.f149a;
        r8.c.add(r7);
        r6.add(r8);
    }

    private /* synthetic */ void a(BlockingQueue r2, Handler r3, List r4, int r5, CountDownLatch r6) {
    L16:
    L13:
        th = move-exception;
        r6.countDown();
        throw th;
    L3:
        if (r2.isEmpty() == true) goto L11;
        if (this.f98a.get() == true) goto L6;
        w7 r0 = (w7) r2.poll();     // Catch: Throwable -> L13
        if (r0 == null) goto L16;
        a(r0, r4, r5, r3);     // Catch: Throwable -> L13
        goto L16
    L6:
        r3.sendMessage(r3.obtainMessage(4356));     // Catch: Throwable -> L13
    L11:
        r6.countDown();
    }

    private void a(w7 r3, List r4, int r5, Handler r6) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.c.size() <= 1) goto L23;
        List r0 = a(r3);
        if (this.f98a.get() == false) goto L10;
        r6.sendMessage(r6.obtainMessage(4356));
        return;
    L10:
        monitor-enter(r4);
        this.b += r3.c.size();     // Catch: Throwable -> L17
        r4.addAll(r0);     // Catch: Throwable -> L17
        if (r0.size() <= 0) goto L14;
        Message r7 = r6.obtainMessage(4354);     // Catch: Throwable -> L17
        r7.obj = le.b(r0);     // Catch: Throwable -> L17
        r6.sendMessage(r7);     // Catch: Throwable -> L17
    L14:
        Message r8 = r6.obtainMessage(4355);     // Catch: Throwable -> L17
        r8.arg1 = (this.b * 100) / r5;     // Catch: Throwable -> L17
        r6.sendMessage(r8);     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public int a(ArrayList r17, int r18, final Handler r19) {
        int r0 = r18;
        this.f98a.set(false);
        if (r19 == null) goto L28;
        if (r17 == null) goto L28;
        final ArrayList r10 = new ArrayList();
        List r3 = b(r17);
        if (this.f98a.get() == false) goto L11;
        r19.sendMessage(r19.obtainMessage(4356));
        return SpaceManager.ERROR_CODE_CANCEL_SCAN;
    L11:
        if (r3 != null) goto L14;
        q8.b("SimilarPhotoProcesser", "startScan sort get null result");
        Message r1 = r19.obtainMessage(4357);
        r1.arg1 = -256;
        r1.obj = null;
        r19.sendMessage(r1);
        return -1;
    L14:
        long r12 = System.currentTimeMillis();
        final int r5 = (int) a(r3)[0];
        this.b = 0;
        if (r0 >= 1) goto L17;
    L19:
        r0 = c;
    L20:
        int r14 = r0;
        final CountDownLatch r15 = new CountDownLatch(r14);
        we r6 = ve.f();
        final LinkedBlockingQueue r2 = new LinkedBlockingQueue(r3);
        Runnable r4 = new ae$$ExternalSyntheticLambda0(this, r2, r19, r10, r5, r15);
        int r7 = 0;
    L21:
        if (r7 >= r14) goto L30;
        r6.a(r4, "SimilarDataLoader_" + r7);
        r7 = r7 + 1;
        goto L21
    L30:
        r15.await();     // Catch: InterruptedException -> L25
    L26:
        q8.c("SimilarPhotoProcesser", "Similar scanResult sourceCount = " + r17.size() + ", scanResult = " + r10.size() + ", taskCount = " + r14 + ", costTime = " + (System.currentTimeMillis() - r12));
        Message r8 = r19.obtainMessage(4357);
        r8.arg1 = 0;
        r8.obj = le.b(r10);
        r19.sendMessage(r8);
        return 0;
    L25:
        Thread.currentThread().interrupt();
        goto L26
    L17:
        if (r0 > 99) goto L19;
    L28:
        q8.b("SimilarPhotoProcesser", "startScan parameter is null");
        return -1;
    }
}
