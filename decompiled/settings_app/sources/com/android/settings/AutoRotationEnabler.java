package com.android.settings;

import android.content.Context;
import android.database.ContentObserver;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.IWindowManager;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoRotationEnabler implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "AutoRotationSettings";
    private final ContentObserver mAccelerometerRotationObserver;
    private Context mContext;
    private OSwitch mSettingSwitch;

    public void updateRotationSwitchState() {
        boolean r2 = false;
        if (android.provider.Settings.System.getInt(this.mContext.getContentResolver(), "accelerometer_rotation", 0) == 0) goto L5;
        r2 = true;
    L5:
        this.mSettingSwitch.setChecked(r2);
    }

    public AutoRotationEnabler(Context r1, OSwitch r2, ContentObserver r3) {
        this.mContext = r1;
        this.mSettingSwitch = r2;
        this.mAccelerometerRotationObserver = r3;
    }

    public void registerContentObserver() {
        this.mContext.getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor("accelerometer_rotation"), true, this.mAccelerometerRotationObserver);
    }

    public void unregisterContentObserver() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mAccelerometerRotationObserver);
    }

    public void setAutoRotation(boolean r4) {
        IWindowManager r0 = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));     // Catch: RemoteException -> L8
        if (r4 == false) goto L5;
        r0.thawRotation(this.mContext.getPackageName());     // Catch: RemoteException -> L8
    L6:
        this.mSettingSwitch.setChecked(r4);     // Catch: RemoteException -> L8
        return;
    L5:
        r0.freezeRotation(0, this.mContext.getPackageName());     // Catch: RemoteException -> L8
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        setAutoRotation(r2);
    }
}
