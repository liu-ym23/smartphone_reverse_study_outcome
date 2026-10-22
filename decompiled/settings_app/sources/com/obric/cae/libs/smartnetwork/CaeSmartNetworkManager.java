package com.obric.cae.libs.smartnetwork;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.statusreport.CaeStatusReportManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class CaeSmartNetworkManager {
    public static CaeSmartNetworkManager c;
    public ICaeSmartNetworkManager a;
    public final HashMap b;

    public interface CaeWifiLinkThroughputListener {
        void onSecondaryThroughputReported(int r1, int r2);

        void onThroughputReported(int r1, int r2);
    }

    public class CaeWifiLinkThroughputListenerProxy extends ICaeWifiLinkThroughputListener.Stub {
        private final CaeWifiLinkThroughputListener mListener;
        final /* synthetic */ CaeSmartNetworkManager this$0;

        public CaeWifiLinkThroughputListenerProxy(CaeSmartNetworkManager r1, CaeWifiLinkThroughputListener r2) {
            this.this$0 = r1;
            this.mListener = r2;
        }

        public CaeWifiLinkThroughputListener getListener() {
            return this.mListener;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onSecondaryThroughputReported(int r1, int r2) {
            CaeWifiLinkThroughputListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onSecondaryThroughputReported(r1, r2);
            return;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onThroughputReported(int r1, int r2) {
            CaeWifiLinkThroughputListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onThroughputReported(r1, r2);
            return;
        }
    }

    public class a extends Thread {
        public final /* synthetic */ CaeSmartNetworkManager a;

        public a(CaeSmartNetworkManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int r1 = 0;
        L4:
            if (r1 >= 50) goto L30;
            SystemClock.sleep(100);
            this.a.a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}));     // Catch: Exception -> L8
        L10:
            CaeSmartNetworkManager r2 = this.a;
            if (r2.a != null) goto L12;
            r1 = r1 + 1;
            goto L4
        L12:
            r2.a();
            CaeSmartNetworkManager r8 = this.a;
            HashMap r0 = r8.b;
            if (r0 != null) goto L15;
            return;
        L15:
            if (r0.size() <= 0) goto L64;
            Iterator r3 = r8.b.keySet().iterator();
        L18:
            if (r3.hasNext() == false) goto L66;
            CaeWifiLinkThroughputListenerProxy r4 = (CaeWifiLinkThroughputListenerProxy) r8.b.get((Integer) r3.next());
            if (r4 == null) goto L18;
            ICaeSmartNetworkManager r5 = r8.a;
            if (r5 == null) goto L24;
            r5.registerLinkThroughputListener(r4);     // Catch: RemoteException -> L27
        L27:
            LogUtil.e("CaeSmartNetworkManager", "RemoteException !!!");
            goto L18
        L24:
            LogUtil.e("CaeSmartNetworkManager", "autoRegisterListenerOnRetryBindSuccess, mISmartNetworkMgr is null");
            return;
        L66:
            return;
        L64:
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeSmartNetworkManager", "Get service failed: " + e);
            goto L10
        L30:
            LogUtil.e("CaeSmartNetworkManager", "get smart network service error!!!");
            CaeSmartNetworkManager r9 = this.a;
            HashMap r6 = r9.b;
            if (r6 != null) goto L33;
            return;
        L33:
            if (r6.size() <= 0) goto L67;
            Iterator r7 = r9.b.keySet().iterator();
        L36:
            if (r7.hasNext() == false) goto L68;
            Integer r10 = (Integer) r7.next();
            CaeWifiLinkThroughputListenerProxy r11 = (CaeWifiLinkThroughputListenerProxy) r9.b.get(r10);
            if (r11 == null) goto L36;
            if (r11.getListener() == null) goto L36;
            r11.getListener().onThroughputReported(0, 0);
            r11.getListener().onSecondaryThroughputReported(0, 0);
            r9.b.remove(r10);
            goto L36
        L68:
            return;
        }
    }

    public class b implements IBinder.DeathRecipient {
        public final /* synthetic */ CaeSmartNetworkManager a;

        public b(CaeSmartNetworkManager r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeSmartNetworkManager", "statusReport service is dead!");
            CaeSmartNetworkManager r2 = this.a;
            r2.a = null;
            r2.retryGetServiceThread();
        }
    }

    public CaeSmartNetworkManager(Context r6) {
        this.b = new HashMap();
        this.a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}));     // Catch: Exception -> L5
    L8:
        if (this.a == null) goto L10;
        a();
        return;
    L10:
        retryGetServiceThread();
        return;
    L5:
        e = move-exception;
        LogUtil.e("CaeSmartNetworkManager", "Get service failed: " + e);
        goto L8
    }

    public static CaeSmartNetworkManager getInstance(Context r2) {
        if (r2 == null) goto L15;
        monitor-enter(CaeStatusReportManager.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (c != null) goto L8;
        c = new CaeSmartNetworkManager(r2);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L11
        return c;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        this.a.asBinder().linkToDeath(new b(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeSmartNetworkManager");
    }

    public int getLinkThroughput() {
        ICaeSmartNetworkManager r3 = this.a;
        if (r3 != null) goto L11;
        LogUtil.e("CaeSmartNetworkManager", "getLinkThroughput, mISmartNetworkMgr is null");
        return 0;
    L11:
        return r3.getLinkThroughput();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("getLinkThroughput failed: ", e, "CaeSmartNetworkManager");
        return 0;
    }

    public void registerLinkThroughputListener(CaeWifiLinkThroughputListener r4) {
        if (this.a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "registerLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r0 = new CaeWifiLinkThroughputListenerProxy(this, r4);
        this.b.put(Integer.valueOf(r0.hashCode()), r0);
        this.a.registerLinkThroughputListener(r0);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("registerLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }

    public void retryGetServiceThread() {
        new a(this).start();
    }

    public void unregisterLinkThroughputListener(CaeWifiLinkThroughputListener r3) {
        if (this.a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "unregisterLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r4 = (CaeWifiLinkThroughputListenerProxy) this.b.get(Integer.valueOf(r3.hashCode()));
        if (r4 != null) goto L15;
        LogUtil.e("CaeSmartNetworkManager", "unregisterLinkThroughputListener failed: proxy is null");
        return;
    L15:
        this.a.unregisterLinkThroughputListener(r4);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("unregisterLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }
}
