package com.android.server.pm;

import android.app.ActivityOptions;
import android.app.ObricActivityManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Intent;
import android.content.pm.LauncherApps;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes.dex */
public class ObricShortcutServiceImpl implements IObricShortcutService {
    private final ShortcutService mBase;

    public ObricShortcutServiceImpl(ShortcutService service) {
        this.mBase = service;
    }

    public Boolean startRequestConfirmActivity(Intent confirmIntent, int launcherUserId, LauncherApps.PinItemRequest request) {
        int displayId = ObricActivityManager.getAutoDisplayId();
        if (displayId <= 0) goto L17;
        if (request == null) goto L17;
        ActivityOptions options = ActivityOptions.makeBasic();
        String packageName = "";
        if (request.getShortcutInfo() == null) goto L8;
        packageName = request.getShortcutInfo().getPackage();
    L12:
        if (ObricActivityManager.isPackageVisibleOnDisplay(packageName, displayId) == false) goto L14;
        options.setLaunchDisplayId(displayId);
    L14:
        this.mBase.mContext.startActivityAsUser(confirmIntent, options.toBundle(), UserHandle.of(launcherUserId));
        return true;
    L8:
        AppWidgetProviderInfo info = request.getAppWidgetProviderInfo(this.mBase.mContext);
        if (info == null) goto L12;
        packageName = info.getActivityInfo().packageName;
    L17:
        return false;
    }
}
