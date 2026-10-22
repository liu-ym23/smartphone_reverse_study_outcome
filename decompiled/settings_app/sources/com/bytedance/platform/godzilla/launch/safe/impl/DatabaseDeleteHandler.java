package com.bytedance.platform.godzilla.launch.safe.impl;

import android.content.Context;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.launch.safe.FileUtils;
import com.bytedance.platform.godzilla.launch.safe.api.CrashHandler;

/* JADX INFO: loaded from: classes3.dex */
public class DatabaseDeleteHandler extends CrashHandler {
    private String mDbName;

    public DatabaseDeleteHandler(String r2) {
        super("DatabaseDeleteHandler");
        this.mDbName = r2;
    }

    @Override // com.bytedance.platform.godzilla.launch.safe.api.CrashHandler
    public void handle(Context r3) {
        Logger.e("LaunchSafePlugin", getName() + "method is called.");
        FileUtils.dropDatabase(r3, this.mDbName);
    }

    @Override // com.bytedance.platform.godzilla.launch.safe.api.CrashHandler
    public String getInfo() {
        return "DatabaseDeleteHandler_" + this.mDbName;
    }
}
