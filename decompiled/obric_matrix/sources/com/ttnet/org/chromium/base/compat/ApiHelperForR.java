package com.ttnet.org.chromium.base.compat;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.input.InputManager;
import android.net.Uri;
import android.os.storage.StorageManager;
import android.view.Display;
import android.view.InputEvent;
import android.view.VerifiedInputEvent;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
public final class ApiHelperForR {
    private ApiHelperForR() {
    }

    public static Display getDisplay(Context r0) {
        return r0.getDisplay();
    }

    public static Rect getMaximumWindowMetricsBounds(WindowManager r0) {
        return r0.getMaximumWindowMetrics().getBounds();
    }

    public static File getVolumeDir(StorageManager r0, Uri r1) {
        return r0.getStorageVolume(r1).getDirectory();
    }

    public static void setProcessStateSummary(ActivityManager r0, byte[] r1) {
        r0.setProcessStateSummary(r1);
    }

    public static VerifiedInputEvent verifyInputEvent(InputManager r0, InputEvent r1) {
        return r0.verifyInputEvent(r1);
    }
}
