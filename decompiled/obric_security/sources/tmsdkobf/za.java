package tmsdkobf;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class za {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f659a = false;
    private static u6 b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static za f660a;

        static {
            f660a = new za(null);
        }
    }

    static {
    }

    private za() {
    }

    /* synthetic */ za(zaIA r1) {
        this();
    }

    public static za c() {
        return a.f660a;
    }

    public static synchronized u6 d() {
        monitor-enter(za.class);
        u6 r1 = b;     // Catch: Throwable -> L7
        monitor-exit(za.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void a() {
        d().closeConnection();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        q8.a("shark_PubSharkService", "closeConnection, e:" + th.getMessage());
    }

    public String b() {
        String r2 = d().c();
        q8.a("shark_PubSharkService", "getGuid:[" + r2 + "]");
        return r2;
    }

    public void e() {
        d().d();
    }

    public void f() {
        d().b();
    }

    public void g() {
        d().a();
    }

    public static synchronized void a(m3 r10) {
        monitor-enter(za.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f659a == false) goto L8;
        monitor-exit(za.class);
        return;
    L8:
        Context r3 = rd.e();     // Catch: Throwable -> L15
        boolean r4 = a(r3);     // Catch: Throwable -> L15
        b4 r5 = new b4();     // Catch: Throwable -> L15
        if (mb.j() == false) goto L11;
        q8.a("shark_PubSharkService", "init isSamsungChannel");     // Catch: Throwable -> L15
        int r6 = 0;
    L12:
        q8.a("shark_PubSharkService", "alarm:" + r6 + "keepSec:180");     // Catch: Throwable -> L15
        rd r11 = ud.a(r3).f(ya.f()).c(ya.g()).c(ya.h()).a(ya.e()).a(r10).a(r5).h(r4).e(r4).d(false).a(null).a(null).g(false).a(new l3()).a(r6).c(false).b(180).a(false).b(false).b(ye.d().c()).a();     // Catch: Throwable -> L15
        r11.c(false);     // Catch: Throwable -> L15
        r11.a(true);     // Catch: Throwable -> L15
        r11.b(true);     // Catch: Throwable -> L15
        b = r11;     // Catch: Throwable -> L15
        f659a = true;     // Catch: Throwable -> L15
        monitor-exit(za.class);
        return;
    L11:
        r6 = 1;
        goto L12
    }

    private static boolean a(Context r1) {
        q8.a("shark_PubSharkService", "isMainProcess：" + TMSDKContext.mIsMainProcess);
        return TMSDKContext.mIsMainProcess;
    }

    public void a(int r1, JceStruct r2, int r3, a7 r4) {
        d().a(r1, r2, r3, r4);
    }

    public WeakReference a(int r7, JceStruct r8, JceStruct r9, int r10, w6 r11) {
        return d().a(r7, r8, r9, r10, r11);
    }

    public WeakReference a(int r9, JceStruct r10, JceStruct r11, int r12, w6 r13, long r14) {
        return d().a(r9, r10, r11, r12, r13, r14);
    }

    public WeakReference a(int r8, byte[] r9, int r10, v6 r11, long r12) {
        return d().a(r8, r9, r10, r11, r12);
    }

    public void a(int r7, long r8, int r10, JceStruct r11) {
        d().a(r7, r8, r10, r11);
    }

    public a7 a(int r1, int r2) {
        return d().a(r1, r2);
    }
}
