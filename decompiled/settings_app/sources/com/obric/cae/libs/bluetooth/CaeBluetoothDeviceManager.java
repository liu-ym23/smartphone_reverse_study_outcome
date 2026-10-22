package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothCallbackExporter;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter;
import com.obric.cae.libs.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class CaeBluetoothDeviceManager {
    public static volatile CaeBluetoothDeviceManager g;
    public final Context a;
    public ICaeBluetoothExporter b;
    public final ArrayList c;
    public final ArrayList d;
    public final a e;
    public final b f;

    public interface CaeBluetoothServiceListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public class a implements IBinder.DeathRecipient {
        public final /* synthetic */ CaeBluetoothDeviceManager a;

        public a(CaeBluetoothDeviceManager r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeBluetoothDeviceManager", "binderDied: CAE service crashed. Attempting to reconnect...");
            if (CaeBluetoothDeviceManager.a(this.a) == null) goto L5;
            CaeBluetoothDeviceManager.a(this.a).asBinder().unlinkToDeath(CaeBluetoothDeviceManager.c(this.a), 0);
            CaeBluetoothDeviceManager.b(this.a);
        L5:
            ArrayList r0 = CaeBluetoothDeviceManager.d(this.a);
            monitor-enter(r0);
            Iterator r1 = CaeBluetoothDeviceManager.d(this.a).iterator();     // Catch: Throwable -> L14
        L9:
            if (r1.hasNext() == false) goto L11;
            ((CaeBluetoothServiceListener) r1.next()).onServiceDisconnected();     // Catch: Throwable -> L14
            goto L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L14
            this.a.bindService();
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    public class b implements ServiceConnection {
        public final /* synthetic */ CaeBluetoothDeviceManager a;

        public b(CaeBluetoothDeviceManager r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r3, IBinder r4) {
            LogUtil.d("CaeBluetoothDeviceManager", "onServiceConnected: " + r3);
            this.a.b = ICaeBluetoothExporter.Stub.asInterface(r4);
            r4.linkToDeath(this.a.e, 0);     // Catch: RemoteException -> L5
        L7:
            ArrayList r5 = this.a.c;
            monitor-enter(r5);
            Iterator r2 = this.a.c.iterator();     // Catch: Throwable -> L15
        L11:
            if (r2.hasNext() == false) goto L13;
            ((CaeBluetoothServiceListener) r2.next()).onServiceConnected();     // Catch: Throwable -> L15
            goto L11
        L13:
            monitor-exit(r5);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        L5:
            e = move-exception;
            com.obric.cae.libs.bluetooth.a.a("linkToDeath failed: ", e, "CaeBluetoothDeviceManager");
            goto L7
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            LogUtil.d("CaeBluetoothDeviceManager", "onServiceDisconnected: " + r3);
            if (CaeBluetoothDeviceManager.a(this.a) != null) goto L5;
        L7:
            CaeBluetoothDeviceManager.b(this.a);
            ArrayList r4 = CaeBluetoothDeviceManager.e(this.a);
            monitor-enter(r4);
            CaeBluetoothDeviceManager.e(this.a).clear();     // Catch: Throwable -> L22
            monitor-exit(r4);     // Catch: Throwable -> L22
            ArrayList r0 = CaeBluetoothDeviceManager.d(this.a);
            monitor-enter(r0);
            Iterator r2 = CaeBluetoothDeviceManager.d(this.a).iterator();     // Catch: Throwable -> L19
        L15:
            if (r2.hasNext() == false) goto L17;
            ((CaeBluetoothServiceListener) r2.next()).onServiceDisconnected();     // Catch: Throwable -> L19
            goto L15
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        L22:
            th = move-exception;
            throw th;
        L5:
            if (CaeBluetoothDeviceManager.a(this.a).asBinder().isBinderAlive() == false) goto L7;
            CaeBluetoothDeviceManager.a(this.a).asBinder().unlinkToDeath(CaeBluetoothDeviceManager.c(this.a), 0);
            goto L7
        }
    }

    public CaeBluetoothDeviceManager(Context r2) {
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new a(this);
        this.f = new b(this);
        this.a = r2.getApplicationContext();
    }

    public static /* synthetic */ ICaeBluetoothExporter a(CaeBluetoothDeviceManager r0) {
        return r0.b;
    }

    public static /* synthetic */ void b(CaeBluetoothDeviceManager r1) {
        r1.b = null;
    }

    public static /* synthetic */ a c(CaeBluetoothDeviceManager r0) {
        return r0.e;
    }

    public static /* synthetic */ ArrayList d(CaeBluetoothDeviceManager r0) {
        return r0.c;
    }

    public static /* synthetic */ ArrayList e(CaeBluetoothDeviceManager r0) {
        return r0.d;
    }

    public static CaeBluetoothDeviceManager getInstance(Context r2) {
        if (g != null) goto L15;
        monitor-enter(CaeBluetoothDeviceManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new CaeBluetoothDeviceManager(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeBluetoothDeviceManager.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public void addServiceListener(CaeBluetoothServiceListener r3) {
        if (r3 == null) goto L15;
        ArrayList r0 = this.c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (this.c.contains(r3) == true) goto L8;
        this.c.add(r3);     // Catch: Throwable -> L12
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (this.b == null) goto L18;
        r3.onServiceConnected();
        return;
    L18:
        return;
    }

    public boolean bindService() {
        b r3 = this.f;
        monitor-enter(r3);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.b == null) goto L9;
        LogUtil.d("CaeBluetoothDeviceManager", "Service is already connected.");     // Catch: Throwable -> L26
        monitor-exit(r3);     // Catch: Throwable -> L26
        return true;
    L9:
        LogUtil.d("CaeBluetoothDeviceManager", "Binding cae bluetooth service...");     // Catch: Throwable -> L26
        Intent r6 = new Intent();     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        r6.setComponent(new ComponentName("com.obric.cae", "com.obric.cae.smartBluetooth.SmartBluetoothService"));     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        r6.setAction("com.obric.cae.libs.bluetooth.ICaeBluetoothExporter");     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        if (this.a.bindService(r6, this.f, 1) == true) goto L16;
        LogUtil.e("CaeBluetoothDeviceManager", "Fail to bind to: " + r6);     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        monitor-exit(r3);     // Catch: Throwable -> L26
        return false;
    L16:
        monitor-exit(r3);     // Catch: Throwable -> L26
        return true;
    L22:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Fail to bind to: " + e);     // Catch: Throwable -> L26
        return false;
    L18:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Exception: " + e);     // Catch: Throwable -> L26
        return false;
    }

    public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r3) {
        ICaeBluetoothExporter r2 = this.b;
        if (r2 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "getDeviceType: Service is not connected");
    L10:
        return new BtDeviceInfoExtEvent(r3, 0);
    L11:
        return r2.getDeviceType(r3);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        goto L10
    }

    public int getProductId(BluetoothDevice r2) {
        ICaeBluetoothExporter r1 = this.b;
        if (r1 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "getProductId: Service is not connected");
        return 0;
    L11:
        return r1.getProductId(r2);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return 0;
    }

    public boolean isAbsoluteVolumeSupported(BluetoothDevice r2) {
        ICaeBluetoothExporter r1 = this.b;
        if (r1 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "isAbsoluteVolumeSupported: Service is not connected");
        return false;
    L11:
        return r1.isAbsoluteVolumeSupported(r2);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return false;
    }

    public void registerEventCallback(ICaeBluetoothCallbackExporter r4) {
        if (r4 == null) goto L21;
        ArrayList r1 = this.d;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.d.contains(r4) == true) goto L15;
        this.d.add(r4);     // Catch: Throwable -> L18
        ICaeBluetoothExporter r3 = this.b;     // Catch: Throwable -> L18
        if (r3 != null) goto L24;
        LogUtil.w("CaeBluetoothDeviceManager", "registerEventCallback: Service is not connected");     // Catch: Throwable -> L18
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L24:
        r3.registerEventCallback(r4);     // Catch: RemoteException -> L12 Throwable -> L18
    L12:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "RemoteException: " + e);     // Catch: Throwable -> L18
        goto L16
    L15:
        LogUtil.d("CaeBluetoothDeviceManager", "registerEventCallback: Callback already registered, ignoring.");     // Catch: Throwable -> L18
        goto L16
    }

    public void removeServiceListener(CaeBluetoothServiceListener r2) {
        if (r2 == null) goto L11;
        ArrayList r0 = this.c;
        monitor-enter(r0);
        this.c.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unbindService() {
        b r1 = this.f;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.b == null) goto L12;
        LogUtil.d("CaeBluetoothDeviceManager", "Unbinding cae bluetooth service...");     // Catch: Throwable -> L14
        this.a.unbindService(this.f);     // Catch: Exception -> L9 Throwable -> L14
    L11:
        this.b = null;     // Catch: Throwable -> L14
        goto L12
    L9:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Exception during unbind: " + e);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L14
    }

    public void unregisterEventCallback(ICaeBluetoothCallbackExporter r3) {
        if (r3 == null) goto L11;
        ArrayList r0 = this.d;
        monitor-enter(r0);
        this.d.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        ICaeBluetoothExporter r2 = this.b;
        if (r2 != null) goto L21;
        LogUtil.w("CaeBluetoothDeviceManager", "unregisterEventCallback: Service is not connected");
        return;
    L21:
        r2.unregisterEventCallback(r3);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
    }
}
