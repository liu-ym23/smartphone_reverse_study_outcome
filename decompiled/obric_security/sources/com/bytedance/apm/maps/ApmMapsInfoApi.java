package com.bytedance.apm.maps;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ApmMapsInfoApi {
    private static MapInfoCallback mmapInfoCallBack;

    public interface MapInfoCallback {
        void addInfo(Map<Object, Object> r1);
    }

    public ApmMapsInfoApi() {
    }

    public static void addMapInfo(Map<Object, Object> r1) {
        MapInfoCallback r0 = mmapInfoCallBack;
        if (r0 == null) goto L9;
        r0.addInfo(r1);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void SetCallback(MapInfoCallback r0) {
        if (r0 == null) goto L5;
        mmapInfoCallBack = r0;
        return;
    }
}
