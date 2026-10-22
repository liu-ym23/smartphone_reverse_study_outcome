package com.bytedance.platform.godzilla.launch.safe.impl;

import android.content.Context;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.launch.safe.FileUtils;
import com.bytedance.platform.godzilla.launch.safe.api.CrashHandler;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class FolderDeleteHandler extends CrashHandler {
    private String mFolderName;

    public FolderDeleteHandler(String r2) {
        super("FolderDeleteHandler");
        this.mFolderName = r2;
    }

    @Override // com.bytedance.platform.godzilla.launch.safe.api.CrashHandler
    public void handle(Context r2) {
        Logger.e("LaunchSafePlugin", getName() + "method is called.");
        FileUtils.dropFileOrDirectory(new File(this.mFolderName));
    }

    @Override // com.bytedance.platform.godzilla.launch.safe.api.CrashHandler
    public String getInfo() {
        return "FolderDeleteHandler_" + this.mFolderName;
    }
}
