package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
@UsedByReflection("WebView embedders call this to override proxy settings")
public class ProxyChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int GET_PROXY_CONFIG_DELAY_MILLIS = 1000;
    private static final String TAG = "ProxyChangeListener";
    private static boolean sEnabled = true;
    private Delegate mDelegate;
    private final Handler mHandler;
    private final Looper mLooper;
    private long mNativePtr;
    private ProxyReceiver mProxyReceiver;
    private BroadcastReceiver mRealProxyReceiver;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.ProxyChangeListener$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Delegate {
        void proxySettingsChanged();
    }

    interface Natives {
        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void proxySettingsChanged(long r1, ProxyChangeListener r3);

        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void proxySettingsChangedTo(long r1, ProxyChangeListener r3, String r4, int r5, String r6, String[] r7);
    }

    private static class ProxyConfig {
        public static final ProxyConfig DIRECT = null;
        public final String[] mExclusionList;
        public final String mHost;
        public final String mPacUrl;
        public final int mPort;

        static {
            DIRECT = new ProxyConfig("", 0, "", new String[0]);
        }

        public ProxyConfig(String r1, int r2, String r3, String[] r4) {
            this.mHost = r1;
            this.mPort = r2;
            this.mPacUrl = r3;
            this.mExclusionList = r4;
        }

        static /* synthetic */ ProxyConfig access$300(ProxyInfo r0) {
            return fromProxyInfo(r0);
        }

        private static ProxyConfig fromProxyInfo(ProxyInfo r6) {
            String r0 = null;
            if (r6 != null) goto L5;
            return null;
        L5:
            String r1 = r6.getHost();
            Uri r2 = r6.getPacFileUrl();
            if (r1 != null) goto L8;
            r1 = "";
        L8:
            int r4 = r6.getPort();
            if (Uri.EMPTY.equals(r2) == true) goto L13;
            r0 = r2.toString();
        L13:
            return new ProxyConfig(r1, r4, r0, r6.getExclusionList());
        }
    }

    @UsedByReflection("WebView embedders call this to override proxy settings")
    private class ProxyReceiver extends BroadcastReceiver {
        final /* synthetic */ ProxyChangeListener this$0;

        private ProxyReceiver(ProxyChangeListener r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ProxyReceiver(ProxyChangeListener r1, AnonymousClass1 r2) {
            this(r1);
        }

        private /* synthetic */ void a(Intent r1) {
            ProxyChangeListener.access$200(this.this$0, ProxyChangeListener.access$100(r1));
        }

        public /* synthetic */ void b(Intent r1) {
            a(r1);
        }

        @Override // android.content.BroadcastReceiver
        @UsedByReflection("WebView embedders call this to override proxy settings")
        public void onReceive(Context r4, final Intent r5) {
            if (r5.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
            ProxyChangeListener.access$000(this.this$0).postDelayed(new b(this, r5), 1000);
            return;
        }
    }

    static {
    }

    private ProxyChangeListener() {
        Looper r0 = Looper.myLooper();
        this.mLooper = r0;
        this.mHandler = new Handler(r0);
    }

    private /* synthetic */ void a(Intent r1) {
        proxySettingsChanged(getProxyConfig(r1));
    }

    static /* synthetic */ Handler access$000(ProxyChangeListener r0) {
        return r0.mHandler;
    }

    static /* synthetic */ ProxyConfig access$100(Intent r0) {
        return extractNewProxy(r0);
    }

    static /* synthetic */ void access$200(ProxyChangeListener r0, ProxyConfig r1) {
        r0.proxySettingsChanged(r1);
    }

    private void assertOnThread() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        if (onThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
    }

    @CalledByNative
    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    private static ProxyConfig extractNewProxy(Intent r8) {
        Bundle r9 = r8.getExtras();
        if (r9 != null) goto L5;
        return null;
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 21) goto L24;
        return ProxyConfig.access$300((ProxyInfo) r9.get("android.intent.extra.PROXY_INFO"));
    L24:
        Object r10 = r9.get("proxy");     // Catch: Throwable -> L21
        if (r10 != null) goto L13;
        return null;
    L13:
        Class<?> r3 = Class.forName("android.net.ProxyProperties");     // Catch: Throwable -> L21
        Method r4 = r3.getDeclaredMethod("getHost", new Class[0]);     // Catch: Throwable -> L21
        Method r5 = r3.getDeclaredMethod("getPort", new Class[0]);     // Catch: Throwable -> L21
        Method r6 = r3.getDeclaredMethod("getExclusionList", new Class[0]);     // Catch: Throwable -> L21
        String r7 = (String) r4.invoke(r10, new Object[0]);     // Catch: Throwable -> L21
        int r11 = ((Integer) r5.invoke(r10, new Object[0])).intValue();     // Catch: Throwable -> L21
        String[] r12 = ((String) r6.invoke(r10, new Object[0])).split(",");     // Catch: Throwable -> L21
        if (r1 < 19) goto L20;
        String r13 = (String) r3.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(r10, new Object[0]);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r13) == true) goto L20;
        return new ProxyConfig(r7, r11, r13, r12);
    L20:
        return new ProxyConfig(r7, r11, null, r12);
    L21:
        e = move-exception;
        Log.e(TAG, "Using no proxy configuration due to exception:" + e, new Object[0]);
        return null;
    }

    @CalledByNative
    public static String getProperty(String r0) {
        return System.getProperty(r0);
    }

    @RequiresApi(23)
    private ProxyConfig getProxyConfig(Intent r3) {
        ProxyInfo r2 = ((ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")).getDefaultProxy();
        if (r2 != null) goto L7;
        return ProxyConfig.DIRECT;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        if ("localhost".equals(r2.getHost()) == false) goto L15;
        if (r2.getPort() != (-1)) goto L15;
        return extractNewProxy(r3);
    L15:
        return ProxyConfig.access$300(r2);
    }

    private boolean onThread() {
        if (this.mLooper != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    private void proxySettingsChanged(ProxyConfig r10) {
        assertOnThread();
        if (sEnabled == true) goto L5;
        return;
    L5:
        Delegate r0 = this.mDelegate;
        if (r0 == null) goto L9;
        r0.proxySettingsChanged();
    L9:
        if (this.mNativePtr != 0) goto L11;
        return;
    L11:
        if (r10 == null) goto L13;
        ProxyChangeListenerJni.get().proxySettingsChangedTo(this.mNativePtr, this, r10.mHost, r10.mPort, r10.mPacUrl, r10.mExclusionList);
        return;
    L13:
        ProxyChangeListenerJni.get().proxySettingsChanged(this.mNativePtr, this);
    }

    private void registerReceiver() {
        assertOnThread();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.PROXY_CHANGE");
        this.mProxyReceiver = new ProxyReceiver(this, null);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Context r1 = ContextUtils.getApplicationContext();
        BroadcastReceiver r4 = this.mProxyReceiver;
    L6:
        ContextUtils.registerNonExportedBroadcastReceiver(r1, r4, r0);
        return;
    L5:
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), this.mProxyReceiver, new IntentFilter());
        this.mRealProxyReceiver = new ProxyBroadcastReceiver(this);
        r1 = ContextUtils.getApplicationContext();
        r4 = this.mRealProxyReceiver;
        goto L6
    }

    private void runOnThread(Runnable r2) {
        if (onThread() == false) goto L5;
        r2.run();
        return;
    L5:
        this.mHandler.post(r2);
    }

    public static void setEnabled(boolean r0) {
        sEnabled = r0;
    }

    private void unregisterReceiver() {
        assertOnThread();
        ContextUtils.getApplicationContext().unregisterReceiver(this.mProxyReceiver);
        if (this.mRealProxyReceiver == null) goto L5;
        ContextUtils.getApplicationContext().unregisterReceiver(this.mRealProxyReceiver);
    L5:
        this.mProxyReceiver = null;
        this.mRealProxyReceiver = null;
    }

    public /* synthetic */ void b(Intent r1) {
        a(r1);
    }

    public void setDelegateForTesting(Delegate r1) {
        this.mDelegate = r1;
    }

    @CalledByNative
    public void start(long r2) {
        TraceEvent r0 = TraceEvent.scoped("ProxyChangeListener.start");
        assertOnThread();     // Catch: Throwable -> L7
        this.mNativePtr = r2;     // Catch: Throwable -> L7
        registerReceiver();     // Catch: Throwable -> L7
        if (r0 == null) goto L18;
        r0.close();
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (r0 != null) goto L16;
    L13:
        throw th;
    L16:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    @CalledByNative
    public void stop() {
        assertOnThread();
        this.mNativePtr = 0;
        unregisterReceiver();
    }

    void updateProxyConfigFromConnectivityManager(final Intent r3) {
        this.mHandler.postDelayed(new c(this, r3), 1000);
    }
}
