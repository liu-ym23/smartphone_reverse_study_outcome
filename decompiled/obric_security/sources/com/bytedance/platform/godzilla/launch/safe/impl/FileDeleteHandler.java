package com.bytedance.platform.godzilla.launch.safe.impl;

import android.content.Context;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.launch.safe.FileUtils;
import com.bytedance.platform.godzilla.launch.safe.api.CrashHandler;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class FileDeleteHandler extends CrashHandler {
    private String mFileName;

    public FileDeleteHandler(String r2) {
        super("FileDeleteHandler");
        this.mFileName = r2;
    }

    @Override // com.bytedance.platform.godzilla.launch.safe.api.CrashHandler
    public void handle(Context r2) {
        Logger.e("LaunchSafePlugin", getName() + "method is called.");
        FileUtils.dropFile(new File(this.mFileName));
    }

    @Override // com.bytedance.platform.godzilla.launch.safe.api.CrashHandler
    public String getInfo() {
        return "FileDeleteHandler_" + this.mFileName;
    }
}
