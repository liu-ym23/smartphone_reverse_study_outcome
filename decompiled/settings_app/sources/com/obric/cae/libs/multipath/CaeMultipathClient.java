package com.obric.cae.libs.multipath;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class CaeMultipathClient {
    public static volatile CaeMultipathClient e;
    public ICaeMultipathManager a;
    public HandlerThread b;
    public a c;
    public boolean d;

    public class a extends Handler {
        public final /* synthetic */ CaeMultipathClient a;

        public a(CaeMultipathClient r1, Looper r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            int r4 = r3.what;
            boolean r0 = true;
            if (r4 != 1) goto L5;
            CaeMultipathClient.a(this.a);
            return;
        L5:
            if (r4 != 2) goto L17;
            CaeMultipathClient r2 = this.a;
            if (r2.a != null) goto L11;
            r0 = false;
        L11:
            if (r0 == true) goto L15;
            CaeMultipathClient.a(r2);
            return;
        L15:
            return;
        }
    }

    public CaeMultipathClient() {
        this.d = false;
        a();
        this.c.sendEmptyMessage(1);
    }

    public static CaeMultipathClient getInstance() {
        if (e != null) goto L15;
        monitor-enter(CaeMultipathClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new CaeMultipathClient();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeMultipathClient.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public final void a() {
        HandlerThread r0 = new HandlerThread("CaeMultipathConnectThread");
        this.b = r0;
        r0.start();
        this.c = new a(this, this.b.getLooper());
    }

    public String getLatestNetworkTruth() {
        ICaeMultipathManager r3 = this.a;
        if (r3 == null) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L15;
        Log.e("CaeMultipathClient", "Service not connected");
        return null;
    L15:
        return r3.getLatestNetworkTruth();
    L12:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to get latest network truth", e);
        return null;
    L5:
        r0 = false;
        goto L7
    }

    public boolean reportAssistantFailure() {
        ICaeMultipathManager r4 = this.a;
        if (r4 == null) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L15;
        Log.e("CaeMultipathClient", "Service not connected");
        return false;
    L15:
        r4.reportAssistantFailure();     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to report assistant failure", e);
        return false;
    L5:
        r2 = false;
        goto L7
    }

    public boolean reportAssistantOperateApps(int[] r5) {
        ICaeMultipathManager r4 = this.a;
        if (r4 == null) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L15;
        Log.e("CaeMultipathClient", "Service not connected");
        return false;
    L15:
        r4.reportAssistantOperateApps(r5);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to report assistant operate apps", e);
        return false;
    L5:
        r2 = false;
        goto L7
    }

    public static void a(CaeMultipathClient r11) {
        if (r11.d == false) goto L5;
        Log.d("CaeMultipathClient", "Already connecting, skipping");
        return;
    L5:
        r11.d = true;
        IBinder r6 = ServiceManager.getService("cae_multipath");     // Catch: Throwable -> L23 Exception -> L25
        if (r6 != null) goto L34;
        Log.e("CaeMultipathClient", "Failed to get cae_multipath service binder");     // Catch: Throwable -> L23 Exception -> L25
        r11.c.removeMessages(2);     // Catch: Throwable -> L23 Exception -> L25
        r11.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L23 Exception -> L25
    L27:
        r11.d = false;
        return;
    L34:
        int r8 = ICaeMultipathManager.Stub.TRANSACTION_startMultipath;     // Catch: Exception -> L20 Throwable -> L23
        ICaeMultipathManager r0 = (ICaeMultipathManager) ICaeMultipathManager.Stub.class.getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r6});     // Catch: Exception -> L20 Throwable -> L23
        r11.a = r0;     // Catch: Exception -> L20 Throwable -> L23
        if (r0 != null) goto L32;
        Log.e("CaeMultipathClient", "Failed to create service interface");     // Catch: Exception -> L20 Throwable -> L23
        r11.c.removeMessages(2);     // Catch: Exception -> L20 Throwable -> L23
        r11.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Exception -> L20 Throwable -> L23
        goto L27
    L32:
        r6.linkToDeath(new com.obric.cae.libs.multipath.a(r11), 0);     // Catch: RemoteException -> L16 Throwable -> L23 Exception -> L25
    L18:
        Log.d("CaeMultipathClient", "Connected to cae_multipath service");     // Catch: Throwable -> L23 Exception -> L25
        r11.d = false;
        return;
    L16:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to link to death", e);     // Catch: Throwable -> L23 Exception -> L25
    L20:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to get Stub class or asInterface method", e);     // Catch: Throwable -> L23 Exception -> L25
        r11.c.removeMessages(2);     // Catch: Throwable -> L23 Exception -> L25
        r11.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L23 Exception -> L25
    L23:
        th = move-exception;
        r11.d = false;
        throw th;
    L25:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to connect to cae_multipath service", e);     // Catch: Throwable -> L23
        r11.c.removeMessages(2);     // Catch: Throwable -> L23
        r11.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L23
        goto L27
    }
}
