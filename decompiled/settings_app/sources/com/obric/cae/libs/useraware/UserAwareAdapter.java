package com.obric.cae.libs.useraware;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import com.obric.cae.libs.utils.SmartBindService;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class UserAwareAdapter {
    public static final int ENTER_COMPANY_GEOFENCE_EVENT = 3;
    public static final int ENTER_HOME_GEOFENCE_EVENT = 1;
    public static final int EXIT_COMPANY_GEOFENCE_EVENT = 4;
    public static final int EXIT_HOEM_GEOFENCE_EVENT = 2;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;
    public static volatile UserAwareAdapter f;
    public ICaeUserAware a;
    public final Context b;
    public final CopyOnWriteArrayList c;
    public final SmartBindService d;
    public final a e;

    public interface ServiceConnectionListener {
        void onServiceConnected(UserAwareAdapter r1);

        void onServiceDisconnected();
    }

    public class a implements ServiceConnection {
        public final /* synthetic */ UserAwareAdapter a;

        public a(UserAwareAdapter r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r3, IBinder r4) {
            Log.i("UserAwareAdapter", "service connected: " + r3.getPackageName());
            monitor-enter(UserAwareAdapter.class);
            this.a.a = ICaeUserAware.Stub.asInterface(r4);     // Catch: Throwable -> L16
            monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L16
            Iterator r5 = this.a.c.iterator();
        L8:
            if (r5.hasNext() == false) goto L15;
            ServiceConnectionListener r6 = (ServiceConnectionListener) r5.next();
            if (r6 == null) goto L8;
            r6.onServiceConnected(this.a);     // Catch: Exception -> L13
        L13:
            e = move-exception;
            Log.e("UserAwareAdapter", "Error in onServiceConnected callback", e);
            goto L8
        L15:
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            Log.i("UserAwareAdapter", "service disconnected: " + r3.getPackageName());
            monitor-enter(UserAwareAdapter.class);
            UserAwareAdapter r2 = this.a;     // Catch: Throwable -> L16
            r2.a = null;     // Catch: Throwable -> L16
            monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L16
            Iterator r4 = r2.c.iterator();
        L8:
            if (r4.hasNext() == false) goto L15;
            ServiceConnectionListener r5 = (ServiceConnectionListener) r4.next();
            if (r5 == null) goto L8;
            r5.onServiceDisconnected();     // Catch: Exception -> L13
        L13:
            e = move-exception;
            Log.e("UserAwareAdapter", "Error in onServiceDisconnected callback", e);
            goto L8
        L15:
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    public UserAwareAdapter(Context r5) {
        this.c = new CopyOnWriteArrayList();
        a r0 = new a(this);
        this.e = r0;
        Context r6 = r5.getApplicationContext();
        this.b = r6;
        SmartBindService r1 = new SmartBindService(r6, r0, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.d = r1;
        r1.smartBindToService();
    }

    public static UserAwareAdapter getInstance(Context r2) {
        if (f != null) goto L15;
        monitor-enter(UserAwareAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new UserAwareAdapter(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public void addBssidsToAvoidRomingScan(List<String> r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.addBssidsToAvoidRomingScan(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "addBssidsToAvoidRomingScan failed", e);
    }

    public void addHomeWifiBssids(List<String> r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.addHomeWifiBssids(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "addHomeWifiBssids failed", e);
    }

    public boolean checkLocationPermission(Context r1) {
        if (r1.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L6;
        Log.i("UserAwareAdapter", "checkLocationPermission passed.");
        return true;
    L6:
        Log.e("UserAwareAdapter", "Critical error: Host application lacks ACCESS_FINE_LOCATION permission! WiFi scanning will not work.");
        throw new SecurityException("Your app must grant ACCESS_FINE_LOCATION permission to use this SDK");
    }

    public void clearHomeWifiBssids() {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.clearHomeWifiBssids();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "clearHomeWifiBssids failed", e);
    }

    public boolean isServiceConnected() {
        if (this.a != null) goto L6;
        Log.w("UserAwareAdapter", "UserAwareService is not connected.");
        this.d.smartBindToService();
    L6:
        if (this.a == null) goto L8;
        return true;
    L8:
        return false;
    }

    public void notifyGeofenceChanged(int r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.notifyGeofenceChanged(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "notifyGeofenceChanged failed", e);
    }

    public void notifyHarEvent(HarEventData r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.notifyHarEvent(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "notifyHarEvent failed", e);
    }

    public void notifyLearningSuccess(boolean r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.notifyLearningSuccess(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "notifyLearningSuccess failed", e);
    }

    public void notifyRoomChangedPredicted(int r2) {
        ICaeUserAware r1 = this.a;
        if (r1 == null) goto L11;
        r1.notifyRoomChangedPredicted(r2);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Log.e("UserAwareAdapter", "Failed to notify room changed predicted", e);
        return;
    }

    public void registerCallback(ICaeUserAwareCallback r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.registerCallback(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "registerCallback failed", e);
    }

    public void registerConnectionListener(ServiceConnectionListener r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.c.contains(r2) == true) goto L10;
        this.c.add(r2);
        if (this.a == null) goto L11;
        r2.onServiceConnected(this);
        return;
    L11:
        return;
    }

    public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.registerSmartBluetoothEvent(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "registerSmartBluetoothEvent failed", e);
    }

    public void release() {
        if (this.a == null) goto L5;
        this.b.unbindService(this.e);
        this.a = null;
        Log.i("UserAwareAdapter", "UserAwareAdapter released and service unbound.");
    L5:
        f = null;
    }

    public void setHarMonitorParams(HarMonitorParams r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.setHarMonitorParams(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "setHarMonitorParams failed", e);
    }

    public void setHarState(int r2, long r3, int r5) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.setHarState(r2, r3, r5);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "setHarState failed", e);
    }

    public void setLevel2DataCollection(List<HarLevel2DataReq> r2, int r3, HarLevel2DataResp r4) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.setLevel2DataCollection(r2, r3, r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "setLevel2DataCollection failed", e);
    }

    public void unregisterCallback(ICaeUserAwareCallback r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.unregisterCallback(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "unregisterCallback failed", e);
    }

    public void unregisterConnectionListener(ServiceConnectionListener r1) {
        this.c.remove(r1);
    }

    public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r2) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.a.unregisterSmartBluetoothEvent(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "unregisterSmartBluetoothEvent failed", e);
    }

    public static UserAwareAdapter getInstance(Context r2, ServiceConnectionListener r3) {
        if (f != null) goto L15;
        monitor-enter(UserAwareAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new UserAwareAdapter(r2, r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public UserAwareAdapter(Context r4, ServiceConnectionListener r5) {
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        this.c = r0;
        this.e = new a(this);
        this.b = r4.getApplicationContext();
        if (r5 != null) goto L5;
    L13:
        SmartBindService r6 = new SmartBindService(this.b, this.e, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.d = r6;
        r6.smartBindToService();
        return;
    L5:
        if (r0.contains(r5) == true) goto L8;
        r0.add(r5);
    L8:
        if (this.a == null) goto L13;
        r5.onServiceConnected(this);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.e("UserAwareAdapter", "Error notifying onServiceConnected immediately", e);
        goto L13
    }
}
