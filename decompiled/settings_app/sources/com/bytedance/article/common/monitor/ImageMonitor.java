package com.bytedance.article.common.monitor;

import com.bytedance.apm.ApmContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ImageMonitor {

    /* JADX INFO: renamed from: com.bytedance.article.common.monitor.ImageMonitor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Holder {
        private static final ImageMonitor sInstance = null;

        private Holder() {
        }

        static /* synthetic */ ImageMonitor access$000() {
            return sInstance;
        }

        static {
            sInstance = new ImageMonitor(null);
        }
    }

    /* synthetic */ ImageMonitor(AnonymousClass1 r1) {
        this();
    }

    private ImageMonitor() {
    }

    public static ImageMonitor getInstance() {
        return Holder.access$000();
    }

    public void monitorImageSample(String r1, int r2, String r3, long r4, JSONObject r6) {
        if (ApmContext.isDebugMode() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("ImageMonitor has not worked, please use ByteFresco or ByteGlide");
    }
}
