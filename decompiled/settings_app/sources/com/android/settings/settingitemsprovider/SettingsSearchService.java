package com.android.settings.settingitemsprovider;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.TelephonyManager;
import android.view.IWindowManager;
import com.GlobalProxyLancet;
import com.android.settings.ISettingsSearchService;
import com.android.settings.IUpdateViewListener;
import com.android.settings.MultiSimAdapter;
import com.android.settings.utils.ReflectionUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsSearchService extends Service {
    private static final String TAG = "SettingsSearchService";
    private final ISettingsSearchService.Stub mBinder;
    private IUpdateViewListener mLocationListener;
    private BroadcastReceiver mLocationModeChangedReceiver;

    public SettingsSearchService() {
        this.mLocationModeChangedReceiver = new AnonymousClass1(this);
        this.mBinder = new AnonymousClass2(this);
    }

    static /* synthetic */ IUpdateViewListener access$000(SettingsSearchService r0) {
        return r0.mLocationListener;
    }

    static /* synthetic */ IUpdateViewListener access$002(SettingsSearchService r0, IUpdateViewListener r1) {
        r0.mLocationListener = r1;
        return r1;
    }

    static /* synthetic */ void access$100(SettingsSearchService r0, boolean r1) {
        r0.setAutoRotation(r1);
    }

    static /* synthetic */ void access$200(SettingsSearchService r0, boolean r1) {
        r0.setPhoneMobileData(r1);
    }

    private void setAutoRotation(boolean r2) {
        IWindowManager r0 = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));     // Catch: RemoteException -> L7
        if (r2 == false) goto L5;
        r0.thawRotation(getPackageName());     // Catch: RemoteException -> L7
    L10:
        return;
    L5:
        r0.freezeRotation(0, getPackageName());     // Catch: RemoteException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    private void setPhoneMobileData(boolean r7) {
        TelephonyManager r6 = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);     // Catch: Exception -> L4
        Method r0 = ReflectionUtils.getMethod("android.telephony.TelephonyManager", "setDataEnabled", new Class[]{Boolean.TYPE});     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.invoke(r6, new Object[]{Boolean.valueOf(r7)});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.location.MODE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mLocationModeChangedReceiver, r0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mLocationModeChangedReceiver);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return this.mBinder;
    }
}
