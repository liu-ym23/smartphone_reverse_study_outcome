package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTMpaService;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public final class TTCronetMpaService extends TTMpaService {
    private static final String TAG = "TTCronetMpaService";
    private TTMpaService.ICallback mAccAddressCallback;
    private TTMpaService.ICallback mInitCallback;
    private long mMpaServiceAdapter;
    private final Object mMpaServiceAdapterLock;
    private CronetUrlRequestContext mRequestContext;

    public TTCronetMpaService(CronetUrlRequestContext r2) {
        this.mMpaServiceAdapterLock = new Object();
        this.mRequestContext = r2;
    }

    public static /* synthetic */ TTMpaService.ICallback access$000(TTCronetMpaService r0) {
        return r0.mInitCallback;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ TTMpaService.ICallback access$200(TTCronetMpaService r0) {
        return r0.mAccAddressCallback;
    }

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeCommand(long r1, String r3, String r4);

    private native long nativeCreateMpaServiceAdapter(long r1);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeInit(long r1);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeSetAccAddress(long r1, String[] r3);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStart(long r1);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStop(long r1);

    @CalledByNative
    private void onInitFinish(final boolean r2, final String r3) {
        postToSubThread(new AnonymousClass1(this, r2, r3));
    }

    @CalledByNative
    private void onSetAccAddressFinish(final boolean r2, final String r3) {
        postToSubThread(new AnonymousClass2(this, r2, r3));
    }

    private void postToSubThread(Runnable r1) {
        Thread r0 = new Thread(r1);
        r0.setName("TTCronetMpaService_Thread");
        r0.start();
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void command(String r6, String r7) {
        Object r0 = this.mMpaServiceAdapterLock;
        monitor-enter(r0);
        long r1 = this.mMpaServiceAdapter;     // Catch: Throwable -> L8
        if (r1 != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        nativeCommand(r1, r6, r7);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void init(TTMpaService.ICallback r6) {
        Object r0 = this.mMpaServiceAdapterLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mMpaServiceAdapter != 0) goto L9;
        this.mMpaServiceAdapter = nativeCreateMpaServiceAdapter(this.mRequestContext.getUrlRequestContextAdapter());     // Catch: Throwable -> L7
    L9:
        this.mInitCallback = r6;     // Catch: Throwable -> L7
        nativeInit(this.mMpaServiceAdapter);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void setAccAddress(List<String> r6, TTMpaService.ICallback r7) {
        Object r0 = this.mMpaServiceAdapterLock;
        monitor-enter(r0);
        long r1 = this.mMpaServiceAdapter;     // Catch: Throwable -> L8
        if (r1 != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mAccAddressCallback = r7;     // Catch: Throwable -> L8
        nativeSetAccAddress(r1, (String[]) r6.toArray(new String[r6.size()]));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void start() {
        Object r0 = this.mMpaServiceAdapterLock;
        monitor-enter(r0);
        long r1 = this.mMpaServiceAdapter;     // Catch: Throwable -> L8
        if (r1 != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        nativeStart(r1);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void stop() {
        Object r0 = this.mMpaServiceAdapterLock;
        monitor-enter(r0);
        long r1 = this.mMpaServiceAdapter;     // Catch: Throwable -> L8
        if (r1 != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        nativeStop(r1);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
