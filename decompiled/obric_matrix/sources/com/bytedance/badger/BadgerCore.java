package com.bytedance.badger;

import android.content.Context;
import android.os.Build;
import com.bytedance.badger.data.BadgerNativeUpdateCallback;
import java.nio.charset.Charset;
import kotlin.b0;
import kotlin.c0;
import kotlin.h;
import kotlin.i;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class BadgerCore implements IBadger {
    public static final f Companion = null;
    private static final String TAG = "BadgerCore";
    private static final h instance$delegate = null;
    private volatile Context applicationContext;
    private volatile kotlin.n0.c.a deviceIdGetter;
    private volatile boolean isCoreInitialized;
    private volatile boolean isInitialized;
    private final Object nativeUpdateLock;
    private volatile com.bytedance.badger.k.b netRequestInterface;
    private volatile kotlin.n0.c.a publicIpAddressListGetter;

    static {
        Companion = new f(null);
        instance$delegate = i.b(e.f2551f);
    }

    public BadgerCore() {
        this.nativeUpdateLock = new Object();
    }

    public static final /* synthetic */ h access$getInstance$cp() {
        return instance$delegate;
    }

    private final native String nativeGetInformationEncoded(String r1, int r2, int r3, int[] r4);

    private final native String nativeGetInformationInstantly(String r1, int r2, int[] r3);

    private final native int nativeHash(byte[] r1);

    private final native void nativeInit();

    private final native void nativeUpdateDeviceInfo(String r1, String r2);

    private final native void nativeUpdateDisabledFeatures(String[] r1);

    private final native int nativeUpdateWithCallbacks(int r1, boolean r2, BadgerNativeUpdateCallback r3);

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.data.d awaitUpdateWithFullCallback(int r5, l r6) {
        o.g(r6, "fullCallback");
        if (com.bytedance.badger.h.a.t.p() == true) goto L7;
        d.g(TAG, "Badger not enabled");
        return com.bytedance.badger.data.d.f2540g;
    L7:
        if (this.isInitialized == false) goto L34;
        if (initCore() == false) goto L32;
        Object r0 = this.nativeUpdateLock;
        monitor-enter(r0);
        int r4 = nativeUpdateWithCallbacks(r5, false, new g(this, r5, r6));     // Catch: Throwable -> L28
        monitor-exit(r0);
        com.bytedance.badger.data.d[] r7 = com.bytedance.badger.data.d.values();
        int r1 = r7.length;
        int r2 = 0;
    L15:
        if (r2 >= r1) goto L23;
        com.bytedance.badger.data.d r3 = r7[r2];
        if (r3.a() != r4) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == true) goto L24;
        r2 = r2 + 1;
    L24:
        if (r3 == null) goto L27;
        return r3;
    L27:
        return com.bytedance.badger.data.d.f2540g;
    L19:
        r8 = false;
        goto L20
    L23:
        r3 = null;
    L28:
        th = move-exception;
        throw th;
    L32:
        throw new IllegalStateException("BadgerCore not initialized");
    L34:
        throw new IllegalStateException("Badger not initialized");
    }

    public final String genChallenge(String r2, long r3) {
        o.g(r2, "challengeKey");
        if (initCore() == false) goto L11;
        String r4 = r2 + r3;
        Charset r5 = kotlin.u0.d.f21429a;
        if (r4 == null) goto L9;
        byte[] r6 = r4.getBytes(r5);
        o.b(r6, "(this as java.lang.String).getBytes(charset)");
        int r1 = nativeHash(r6);
        c0.b(r1);
        return c0.j(r1);
    L9:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    L11:
        throw new IllegalStateException("BadgerCore init failed");
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.data.a getBadgerReport(com.bytedance.badger.data.b r11, int r12) {
        o.g(r11, "req");
        if (com.bytedance.badger.h.a.t.p() == true) goto L7;
        d.g(TAG, "Badger not enabled");
        return null;
    L7:
        if (this.isInitialized == false) goto L26;
        if (initCore() == false) goto L24;
        String r0 = r11.getDeviceId();
        String r1 = Build.MODEL;
        o.b(r1, "Build.MODEL");
        nativeUpdateDeviceInfo(r0, r1);
        String r2 = genChallenge(r11.c(), r11.b());
        long r3 = System.nanoTime();
        int[] r4 = new int[2];
        monitor-enter(this);
        String r5 = nativeGetInformationEncoded(r2, r11.d(), r12, r4);     // Catch: Throwable -> L20
        monitor-exit(this);
        int r6 = r4[0];
        if (r4[1] != 1) goto L17;
        boolean r7 = true;
    L19:
        return new com.bytedance.badger.data.a(r5, r6, r7, System.nanoTime() - r3);
    L17:
        r7 = false;
    L20:
        th = move-exception;
        throw th;
    L24:
        throw new IllegalStateException("BadgerCore not initialized");
    L26:
        throw new IllegalStateException("Badger not initialized");
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.data.a getBadgerReportInstantly(com.bytedance.badger.data.b r11) {
        o.g(r11, "req");
        if (com.bytedance.badger.h.a.t.p() == true) goto L7;
        d.g(TAG, "Badger not enabled");
        return null;
    L7:
        if (this.isInitialized == false) goto L19;
        if (initCore() == false) goto L17;
        String r0 = r11.getDeviceId();
        String r1 = Build.MODEL;
        o.b(r1, "Build.MODEL");
        nativeUpdateDeviceInfo(r0, r1);
        String r2 = genChallenge(r11.c(), r11.b());
        long r3 = System.nanoTime();
        int[] r4 = new int[2];
        String r5 = nativeGetInformationInstantly(r2, r11.d(), r4);
        int r6 = r4[0];
        if (r4[1] != 1) goto L13;
        boolean r7 = true;
    L15:
        return new com.bytedance.badger.data.a(r5, r6, r7, System.nanoTime() - r3);
    L13:
        r7 = false;
        goto L15
    L17:
        throw new IllegalStateException("BadgerCore not initialized");
    L19:
        throw new IllegalStateException("Badger not initialized");
    }

    @Override // com.bytedance.badger.IBadger
    public Context getContext() {
        if (this.isInitialized == false) goto L10;
        Context r1 = this.applicationContext;
        if (r1 == null) goto L7;
        return r1;
    L7:
        o.v("applicationContext");
        throw null;
    L10:
        throw new IllegalStateException("Badger not initialized");
    }

    public final String getDeviceId() {
        kotlin.n0.c.a r0 = this.deviceIdGetter;
        if (r0 != null) goto L5;
        o.v("deviceIdGetter");
        throw null;
    L5:
        return (String) r0.invoke();
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.k.a getLoginHandler() {
        return com.bytedance.badger.i.d.f2597c;
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.k.b getNetRequestInterface() {
        if (this.isInitialized == false) goto L10;
        com.bytedance.badger.k.b r1 = this.netRequestInterface;
        if (r1 == null) goto L7;
        return r1;
    L7:
        o.v("netRequestInterface");
        throw null;
    L10:
        throw new IllegalStateException("Badger not initialized");
    }

    public final com.bytedance.badger.k.d getPublicIpAddressInfo() {
        kotlin.n0.c.a r0 = this.publicIpAddressListGetter;
        if (r0 != null) goto L5;
        o.v("publicIpAddressListGetter");
        throw null;
    L5:
        return (com.bytedance.badger.k.d) r0.invoke();
    }

    @Override // com.bytedance.badger.IBadger
    public boolean init(a r4) {
        o.g(r4, "initParams");
        if (this.isInitialized == false) goto L5;
        return true;
    L5:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.isInitialized == false) goto L10;
        monitor-exit(this);
        return true;
    L10:
        Context r0 = r4.getContext().getApplicationContext();     // Catch: Throwable -> L16
        o.b(r0, "initParams.getContext().applicationContext");     // Catch: Throwable -> L16
        this.applicationContext = r0;     // Catch: Throwable -> L16
        this.netRequestInterface = r4.getNetRequestInterface();     // Catch: Throwable -> L16
        this.deviceIdGetter = r4.c();     // Catch: Throwable -> L16
        this.publicIpAddressListGetter = r4.b();     // Catch: Throwable -> L16
        c r5 = r4.a();     // Catch: Throwable -> L16
        if (r5 == null) goto L13;
        d.f2526b.a(r5);     // Catch: Throwable -> L16
    L13:
        this.isInitialized = true;     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    }

    @Override // com.bytedance.badger.IBadger
    public boolean initCore() {
        if (this.isCoreInitialized == false) goto L5;
        return true;
    L5:
        com.bytedance.badger.h.a r0 = com.bytedance.badger.h.a.t;
        if (r0.p() == true) goto L8;
        return false;
    L8:
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L10:
        if (this.isCoreInitialized == false) goto L42;
        monitor-exit(this);
        return true;
    L42:
        System.loadLibrary("bdbadger");     // Catch: Throwable -> L27 UnsatisfiedLinkError -> L32
        d.f(TAG, "load library success");     // Catch: Throwable -> L37
        Object[] r1 = r0.o().toArray(new String[0]);     // Catch: Throwable -> L22
        if (r1 == null) goto L21;
        nativeUpdateDisabledFeatures((String[]) r1);     // Catch: Throwable -> L22
        nativeInit();     // Catch: Throwable -> L22
        com.bytedance.badger.module.d.a();     // Catch: Throwable -> L22
        this.isCoreInitialized = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return true;
    L21:
        throw new b0("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        d.e(TAG, "Failed to init core: " + th.getMessage());     // Catch: Throwable -> L37
        return false;
    L32:
        e = move-exception;
        d.e(TAG, "Failed to load library: " + e.getMessage());     // Catch: Throwable -> L37
        return false;
    L27:
        th = move-exception;
        d.e(TAG, "Failed to load library, unknown error: " + th.getMessage());     // Catch: Throwable -> L37
        return false;
    }

    @Override // com.bytedance.badger.IBadger
    public boolean isInitialized() {
        return this.isInitialized;
    }

    @Override // com.bytedance.badger.IBadger
    public void startPeriodicReport(boolean r1) {
        com.bytedance.badger.j.f.f2619g.c(r1);
    }

    @Override // com.bytedance.badger.IBadger
    public void updateConfig(JSONObject r1) {
        com.bytedance.badger.h.a.t.d(r1);
    }
}
