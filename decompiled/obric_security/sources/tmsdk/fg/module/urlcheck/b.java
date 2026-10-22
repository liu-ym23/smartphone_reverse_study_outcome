package tmsdk.fg.module.urlcheck;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import tmsdk.common.module.urlcheck.UrlCheckResultV3;
import tmsdk.fg.creator.BaseManagerF;
import tmsdkobf.bd;
import tmsdkobf.d;
import tmsdkobf.i1;
import tmsdkobf.q8;
import tmsdkobf.rc;
import tmsdkobf.ve;
import tmsdkobf.w6;
import tmsdkobf.za;

/* JADX INFO: loaded from: classes5.dex */
final class b extends BaseManagerF {
    private ConcurrentHashMap b;
    private LinkedHashMap c;
    private long d;

    class a implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ICheckUrlCallbackV3 f81a;
        final /* synthetic */ String b;
        final /* synthetic */ b c;

        a(b r1, ICheckUrlCallbackV3 r2, String r3) {
            this.c = r1;
            this.f81a = r2;
            this.b = r3;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r3, int r4, int r5, int r6, JceStruct r7) {
            q8.c("UrlCheckManagerV2Impl", "onFinish() seqNo: " + r3 + " cmdId: " + r4 + " retCode: " + r5 + " dataRetCode: " + r6);
            rc r8 = (rc) r7;
            if (r8 != null) goto L5;
        L17:
            this.f81a.onCheckUrlCallback(null);
            return;
        L5:
            if (r8.f478a == null) goto L17;
            UrlCheckResultV3 r9 = new UrlCheckResultV3(this.b, r8.f478a);
            this.f81a.onCheckUrlCallback(r9);
            long r10 = System.currentTimeMillis();
            b.m2362$$Nest$fgetb(this.c).put(Long.valueOf(r10), r9);
            LinkedHashMap r11 = b.m2363$$Nest$fgetc(this.c);
            monitor-enter(r11);
            b.m2363$$Nest$fgetc(this.c).put(Long.valueOf(r10), r9);     // Catch: Throwable -> L14
            monitor-exit(r11);     // Catch: Throwable -> L14
            b r2 = this.c;
            if (b.m2364$$Nest$fgetd(r2) != 0) goto L21;
            b.m2365$$Nest$fputd(r2, r10);
            return;
        L21:
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetb, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConcurrentHashMap m2362$$Nest$fgetb(b r0) {
        return r0.b;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetc, reason: not valid java name */
    static /* bridge */ /* synthetic */ LinkedHashMap m2363$$Nest$fgetc(b r0) {
        return r0.c;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetd, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2364$$Nest$fgetd(b r2) {
        return r2.d;
    }

    /* JADX INFO: renamed from: -$$Nest$fputd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2365$$Nest$fputd(b r0, long r1) {
        r0.d = r1;
    }

    b() {
    }

    private void b() {
        long r0 = System.currentTimeMillis();
        long r2 = this.d;
        if (r2 != 0) goto L5;
        return;
    L5:
        if ((r0 - r2) < 21600000) goto L34;
        ArrayList r3 = new ArrayList();
        LinkedHashMap r4 = this.c;
        monitor-enter(r4);
        Iterator r8 = this.c.keySet().iterator();     // Catch: Throwable -> L24
    L11:
        if (r8.hasNext() == false) goto L15;
        long r9 = ((Long) r8.next()).longValue();     // Catch: Throwable -> L24
        this.d = r9;     // Catch: Throwable -> L24
        if ((r0 - r9) < 21600000) goto L15;
        r8.remove();     // Catch: Throwable -> L24
        r3.add(Long.valueOf(r9));     // Catch: Throwable -> L24
    L15:
        monitor-exit(r4);     // Catch: Throwable -> L24
        Iterator r1 = r3.iterator();
    L18:
        if (r1.hasNext() == false) goto L21;
        Long r5 = (Long) r1.next();
        this.b.remove(r5);
        goto L18
    L21:
        if (this.b.size() != 0) goto L33;
        this.d = 0;
        return;
    L33:
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private void c() {
        if (this.b != null) goto L6;
        this.b = new ConcurrentHashMap();
    L6:
        if (this.c != null) goto L9;
        this.c = new LinkedHashMap();
        return;
    }

    public boolean a(String r11, int r12, ICheckUrlCallbackV3 r13) {
        if (r11 != null) goto L4;
        return false;
    L4:
        if (r11.length() == 0) goto L21;
        if (r13 == null) goto L22;
        c();
        b();
        Iterator r0 = this.b.values().iterator();
    L9:
        if (r0.hasNext() == false) goto L14;
        UrlCheckResultV3 r1 = (UrlCheckResultV3) r0.next();
        if (r11.equalsIgnoreCase(r1.url) == false) goto L9;
        r13.onCheckUrlCallback(r1);
        return true;
    L14:
        i1 r6 = new i1();
        r6.f258a = 1;
        r6.b = r12;
        bd r14 = new bd();
        r6.c = r14;
        r14.f118a = r11;
        rc r7 = new rc();
        za r4 = ve.e();
        q8.c("UrlCheckManagerV2Impl", "sendShark url = " + r6.c.f118a);
        r4.a(2002, r6, r7, 0, new a(this, r13, r11));
        d.a();
        return true;
    L22:
        return false;
    L21:
        return false;
    }

    @Override // tmsdkobf.b0
    public int getSingletonType() {
        return 0;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r1) {
    }
}
