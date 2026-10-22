package tmsdk.fg.module.urlcheck;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import tmsdk.common.module.urlcheck.UrlCheckResult;
import tmsdk.fg.creator.BaseManagerF;
import tmsdkobf.b3;
import tmsdkobf.d;
import tmsdkobf.g8;
import tmsdkobf.h8;
import tmsdkobf.k9;
import tmsdkobf.pf;
import tmsdkobf.q8;
import tmsdkobf.qf;
import tmsdkobf.ve;
import tmsdkobf.w6;
import tmsdkobf.za;

/* JADX INFO: loaded from: classes5.dex */
final class a extends BaseManagerF {
    private ConcurrentHashMap b;
    private LinkedHashMap c;
    private long d;
    private UrlCheckResult e;

    /* JADX INFO: renamed from: tmsdk.fg.module.urlcheck.a$a, reason: collision with other inner class name */
    class C0096a implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f79a;
        final /* synthetic */ String b;
        final /* synthetic */ ICheckUrlCallback c;
        final /* synthetic */ pf d;
        final /* synthetic */ a e;

        C0096a(a r1, long r2, String r4, ICheckUrlCallback r5, pf r6) {
            this.e = r1;
            this.f79a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r7, int r8, int r9, int r10, JceStruct r11) {
            q8.c("UrlCheckManager", "onFinish() seqNo: " + r7 + " cmdId: " + r8 + " retCode: " + r9 + " dataRetCode: " + r10 + " exec time : " + (System.currentTimeMillis() - this.f79a));
            q8.b("UrlCheckManager", "[UrlCheckManager] disconnect for checkUrl");
            qf r12 = (qf) r11;
            if (r9 == 0) goto L7;
            q8.b("UrlCheckManager", "no net or service error retCode : " + r9 + " !!!");
            UrlCheckResult r13 = new UrlCheckResult(this.b, -1, -1, -1, -1);
        L5:
            ICheckUrlCallback r6 = this.c;
        L6:
            r6.onCheckUrlCallback(r13);
            return;
        L7:
            if (r12 != null) goto L9;
            q8.c("UrlCheckManager", "response is null");
            r6 = this.c;
            r13 = null;
            goto L6
        L9:
            long r14 = System.currentTimeMillis();
            r12.a(this.d.a());
            a.m2358$$Nest$fgetb(this.e).put(Long.valueOf(r14), r12);
            LinkedHashMap r15 = a.m2359$$Nest$fgetc(this.e);
            monitor-enter(r15);
            a.m2359$$Nest$fgetc(this.e).put(Long.valueOf(r14), r12);     // Catch: Throwable -> L18
            monitor-exit(r15);     // Catch: Throwable -> L18
            a r16 = this.e;
            if (a.m2360$$Nest$fgetd(r16) != 0) goto L16;
            a.m2361$$Nest$fputd(r16, r14);
        L16:
            r13 = new UrlCheckResult(r12);
        L18:
            th = move-exception;
            throw th;
        }
    }

    class b implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UrlCheckResult f80a;
        final /* synthetic */ String b;
        final /* synthetic */ pf c;
        final /* synthetic */ Object d;
        final /* synthetic */ a e;

        b(a r1, UrlCheckResult r2, String r3, pf r4, Object r5) {
            this.e = r1;
            this.f80a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r5, int r6, int r7, int r8, JceStruct r9) {
            q8.c("UrlCheckManager", "Sync--onFinish() seqNo: " + r5 + " cmdId: " + r6 + " retCode: " + r7 + " dataRetCode: " + r8);
            q8.b("UrlCheckManager", "[UrlCheckManager] disconnect for checkUrl");
            qf r10 = (qf) r9;
            if (r7 == 0) goto L5;
            q8.b("UrlCheckManager", "no net or service error retCode : " + r7 + " !!!");
            UrlCheckResult r11 = this.f80a;
            r11.mUrl = this.b;
            r11.result = -1;
            r11.mEvilType = -1;
        L15:
            Object r12 = this.d;
            monitor-enter(r12);
            q8.c("UrlCheckManager", "sync--notify");     // Catch: Throwable -> L20
            this.d.notify();     // Catch: Throwable -> L20
            monitor-exit(r12);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        L5:
            if (r10 != null) goto L7;
            q8.c("UrlCheckManager", "res == null");
            goto L15
        L7:
            q8.c("UrlCheckManager", "UrlType:" + r10.f + "|req.getUrl:" + this.c.a());
            long r13 = System.currentTimeMillis();
            r10.a(this.c.a());
            a.m2358$$Nest$fgetb(this.e).put(Long.valueOf(r13), r10);
            q8.c("UrlCheckManager", "sync--加入缓存, url is " + r10.d());
            LinkedHashMap r14 = a.m2359$$Nest$fgetc(this.e);
            monitor-enter(r14);
            a.m2359$$Nest$fgetc(this.e).put(Long.valueOf(r13), r10);     // Catch: Throwable -> L23
            monitor-exit(r14);     // Catch: Throwable -> L23
            a r15 = this.e;
            if (a.m2360$$Nest$fgetd(r15) != 0) goto L14;
            a.m2361$$Nest$fputd(r15, r13);
        L14:
            UrlCheckResult.responseToRes(this.f80a, r10);
        L23:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetb, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConcurrentHashMap m2358$$Nest$fgetb(a r0) {
        return r0.b;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetc, reason: not valid java name */
    static /* bridge */ /* synthetic */ LinkedHashMap m2359$$Nest$fgetc(a r0) {
        return r0.c;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetd, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2360$$Nest$fgetd(a r2) {
        return r2.d;
    }

    /* JADX INFO: renamed from: -$$Nest$fputd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2361$$Nest$fputd(a r0, long r1) {
        r0.d = r1;
    }

    a() {
        this.e = null;
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
        this.b = new ConcurrentHashMap();
        this.c = new LinkedHashMap();
    }

    public int a(String r17, ICheckUrlCallback r18) {
        if (r17 != null) goto L5;
        return -1006;
    L5:
        if (r17.length() == 0) goto L29;
        if (r18 == null) goto L30;
        b();
        Iterator r0 = this.b.values().iterator();
    L10:
        if (r0.hasNext() == false) goto L16;
        qf r2 = (qf) r0.next();
        if (r17.equalsIgnoreCase(r2.d()) == false) goto L10;
        r18.onCheckUrlCallback(new UrlCheckResult(r2));
        return 0;
    L16:
        if (k9.c() == true) goto L19;
        q8.b("UrlCheckManager", "no net!!!");
        r18.onCheckUrlCallback(new UrlCheckResult(r17, -1, -1, -1, -1));
        return 0;
    L19:
        za r10 = ve.e();
        pf r12 = new pf();
        r12.a(r17);
        if (b3.c() == false) goto L22;
        g8 r1 = new g8();
        r12.g = r1;
        r1.b = h8.d().e();
        r12.g.f215a = h8.d().b();
        r12.g.c = h8.d().f();
    L22:
        qf r13 = new qf();
        r13.a(r17);
        q8.c("UrlCheckManager", "[GUID] " + r10.b());
        q8.a("UrlCheckManager", "[UrlCheckManager] connect for  checkUrl");
        r10.a(1040, r12, r13, 0, new C0096a(this, System.currentTimeMillis(), r17, r18, r12));
        d.a();
        return 0;
    L30:
        return -1006;
    L29:
        return -1006;
    }

    @Override // tmsdkobf.b0
    public int getSingletonType() {
        return 0;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r1) {
        c();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public UrlCheckResult a(String r15) {
        if (r15 != null) goto L4;
        return null;
    L4:
        if (r15.length() == 0) goto L40;
        b();
        q8.c("UrlCheckManager", "Sync--mCheckedUrlsCache size is " + this.b.values().size());
        Iterator r0 = this.b.values().iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        qf r1 = (qf) r0.next();
        if (r15.equalsIgnoreCase(r1.d()) == false) goto L8;
        return new UrlCheckResult(r1);
    L14:
        if (k9.c() == true) goto L17;
        q8.b("UrlCheckManager", "no net !!!");
        return new UrlCheckResult(r15, -1, -1, -1, -1);
    L17:
        za r7 = ve.e();
        pf r9 = new pf();
        r9.a(r15);
        if (b3.c() == false) goto L20;
        g8 r2 = new g8();
        r9.g = r2;
        r2.b = h8.d().e();
        r9.g.f215a = h8.d().b();
        r9.g.c = h8.d().f();
    L20:
        qf r10 = new qf();
        r10.a(r15);
        UrlCheckResult r6 = new UrlCheckResult();
        r6.mUrl = r15;
        Object r13 = new Object();
        q8.c("UrlCheckManager", "[GUID] " + r7.b());
        q8.a("UrlCheckManager", "[UrlCheckManager] connect for  checkUrl");
        r7.a(1040, r9, r10, 0, new b(this, r6, r15, r9, r13));
        monitor-enter(r13);
        q8.c("UrlCheckManager", "sync--wait");     // Catch: Throwable -> L24 Exception -> L33
        r13.wait();     // Catch: Throwable -> L24 Exception -> L33
    L24:
        th = move-exception;
        throw th;
    L26:
        monitor-exit(r13);     // Catch: Throwable -> L24
        d.a();
        return r6;
    L40:
        return null;
    }
}
