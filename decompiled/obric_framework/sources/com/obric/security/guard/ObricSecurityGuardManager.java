package com.obric.security.guard;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ServiceManager;
import android.security.obric.guard.ObricSettingsEvent;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import com.obric.security.IObricSecurityPluginService;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityGuardManager {
    private static final int PLUGIN_CODE = 4;
    private static final String SECURITY_SERVICE_NAME = "ObricSecurityService";
    private static final String TAG = "ObricSecurityGuardManager";
    private IObricSecurityGuardService service;

    public ObricSecurityGuardManager() {
    }

    public Bundle getCurrentAppGrantPermissionInfo(String packageName) {
        if (getService() == null) goto L12;
        return getService().getCurrentAppGrantPermissionInfo(packageName);
    L6:
        e = move-exception;
        Log.e(TAG, "getCurrentAppGrantPermissionInfo occur exception, " + e.getMessage());
        return null;
    L12:
        return null;
    }

    public Bundle getAppGrantPermissionInfo(String packageName, String[] permission) {
        if (getService() == null) goto L12;
        return getService().getAppGrantPermissionInfo(packageName, permission);
    L6:
        e = move-exception;
        Log.e(TAG, "getAppGrantPermissionInfo occur exception, " + e.getMessage());
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public void updateMinPerPolicy(String packageName, String perPolicy) {
        if (getService() == null) goto L11;
        getService().updateMinPerPolicy(packageName, perPolicy);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "updateMinPerPolicy occur exception, " + e.getMessage());
        return;
    }

    public void updatePolicyFile(String fileName, String perPolicy) {
        if (getService() == null) goto L11;
        getService().updatePolicyFile(fileName, perPolicy);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "updatePolicyFile occur exception, " + e.getMessage());
        return;
    }

    public String getSecurityPolicy(String fileName) {
        if (getService() == null) goto L12;
        return getService().getSecurityPolicy(fileName);
    L6:
        e = move-exception;
        Log.e(TAG, "getSecurityPolicy occur exception, " + e.getMessage());
        return null;
    L12:
        return null;
    }

    public int getActivityRiskType(String packageName, String activityName, Bundle extra) {
        if (getService() == null) goto L12;
        return getService().getActivityRiskType(packageName, activityName, extra);
    L6:
        e = move-exception;
        Log.e(TAG, "getActivityRiskType occur exception, " + e.getMessage());
        return -1;
    L12:
        return -1;
    }

    private IObricSecurityGuardService getService() {
        if (this.service == null) goto L16;
        return this.service;
    L16:
        IBinder securityServiceBinder = ServiceManager.getService(SECURITY_SERVICE_NAME);     // Catch: Exception -> L13
        if (securityServiceBinder != null) goto L11;
        Log.e(TAG, "getService binder is null.");     // Catch: Exception -> L13
        return null;
    L11:
        IObricSecurityPluginService securityService = IObricSecurityPluginService.Stub.asInterface(securityServiceBinder);     // Catch: Exception -> L13
        IBinder binder = securityService.querySecurityPlugin(4);     // Catch: Exception -> L13
        this.service = IObricSecurityGuardService.Stub.asInterface(binder);     // Catch: Exception -> L13
        return this.service;
    L13:
        e = move-exception;
        Log.e(TAG, "getService failed. " + e.getMessage());
        return null;
    }

    public void registerSettingsEventObserver(IObricSettingsEventObserver observer) {
        Log.i(TAG, "registerSettingsEventObserver");
        if (observer != null) goto L7;
        Log.e(TAG, "input observer is null!");
        return;
    L7:
        if (getService() == null) goto L15;
        getService().registerSettingsEventObserver(observer);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "registerSettingsEventObserver occur exception, " + e.getMessage());
        return;
    }

    public void unregisterSettingsEventObserver(IObricSettingsEventObserver observer) {
        Log.i(TAG, "unregisterSettingsEventObserver");
        if (observer != null) goto L7;
        Log.e(TAG, "input observer is null!");
        return;
    L7:
        if (getService() == null) goto L15;
        getService().unregisterSettingsEventObserver(observer);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "unregisterSettingsEventObserver occur exception, " + e.getMessage());
        return;
    }

    public void bdSettingsEventStart(Context context, int eventType, Bundle extra) {
        if (context != null) goto L7;
        Log.e(TAG, "input context is null!");
        return;
    L7:
        if (ObricSettingsEvent.isValid(eventType) == true) goto L10;
        Log.e(TAG, "input event type is invalid!");
        return;
    L10:
        String displayName = "";
        Display display = context.getDisplay();
        if (display == null) goto L13;
        displayName = display.getName();
    L13:
        Log.i(TAG, "bdSettingsEventStart eventType:" + eventType + " displayName:" + displayName);
        if (TextUtils.equals(displayName, "auto_action") == true) goto L17;
        return;
    L17:
        if (getService() == null) goto L25;
        getService().bdSettingsEventStart(eventType, extra);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        Log.e(TAG, "bdSettingsEventStart occur exception, " + e.getMessage());
        return;
    }

    public void bdSettingsEventEnd(Context context, int eventType, Bundle extra) {
        if (context != null) goto L7;
        Log.e(TAG, "input context is null!");
        return;
    L7:
        if (ObricSettingsEvent.isValid(eventType) == true) goto L10;
        Log.e(TAG, "input event type is invalid!");
        return;
    L10:
        Log.i(TAG, "bdSettingsEventEnd eventType:" + eventType);
        if (getService() == null) goto L19;
        getService().bdSettingsEventEnd(eventType, extra);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "bdSettingsEvent occur exception, " + e.getMessage());
        return;
    }
}
