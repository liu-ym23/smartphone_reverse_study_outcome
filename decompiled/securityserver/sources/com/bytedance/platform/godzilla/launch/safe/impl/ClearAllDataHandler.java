package com.bytedance.platform.godzilla.launch.safe.impl;

import android.content.Context;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.launch.safe.FileUtils;
import com.bytedance.platform.godzilla.launch.safe.api.CrashHandler;

/* JADX INFO: loaded from: classes.dex */
public class ClearAllDataHandler extends CrashHandler {
    public ClearAllDataHandler() {
        super("ClearAllDataHandler");
    }

    @Override // com.bytedance.platform.godzilla.launch.safe.api.CrashHandler
    public String getInfo() {
        return "ClearAllDataHandler";
    }

    @Override // com.bytedance.platform.godzilla.launch.safe.api.CrashHandler
    public void handle(Context r2) {
        Logger.e("LaunchSafePlugin", getName() + "method is called.");
        FileUtils.cleanApplicationData(r2, new String[0]);
    }
}
