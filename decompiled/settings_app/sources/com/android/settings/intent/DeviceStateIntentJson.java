package com.android.settings.intent;

import com.android.settings.wifi.WifiAuthorizeUtils;
import com.bytedance.bdinstall.Api;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JX\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0007Jd\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0007¨\u0006\u0012"}, d2 = {"Lcom/android/settings/intent/DeviceStateIntentJson;", "", "()V", "buildDeviceState", "Lorg/json/JSONObject;", "processor", "", "ram", "storageTotal", "storageAvailable", "screenSize", Api.KEY_RESOLUTION, "brand", "model", "osVersion", "ipAddress", "buildDeviceStateMap", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStateIntentJson {
    public static final DeviceStateIntentJson INSTANCE = null;

    static {
        INSTANCE = new DeviceStateIntentJson();
    }

    private DeviceStateIntentJson() {
    }

    @JvmStatic
    public static final Map<String, Object> buildDeviceStateMap(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r17, "processor");
        Intrinsics.checkNotNullParameter(r18, "ram");
        Intrinsics.checkNotNullParameter(r19, "storageTotal");
        Intrinsics.checkNotNullParameter(r20, "storageAvailable");
        Intrinsics.checkNotNullParameter(r21, "screenSize");
        Intrinsics.checkNotNullParameter(r22, Api.KEY_RESOLUTION);
        Intrinsics.checkNotNullParameter(r23, "brand");
        Intrinsics.checkNotNullParameter(r24, "model");
        Intrinsics.checkNotNullParameter(r25, "osVersion");
        Intrinsics.checkNotNullParameter(r26, "ipAddress");
        return MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("processor", r17), TuplesKt.to("ram", r18), TuplesKt.to("storage_total", r19), TuplesKt.to("storage_available", r20), TuplesKt.to("screen_size", r21), TuplesKt.to(Api.KEY_RESOLUTION, r22), TuplesKt.to("brand", r23), TuplesKt.to("model", r24), TuplesKt.to("os_version", r25), TuplesKt.to(WifiAuthorizeUtils.EXTRA_NAME_IP_ADDRESS, r26)});
    }

    @JvmStatic
    public static final JSONObject buildDeviceState(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r1, "processor");
        Intrinsics.checkNotNullParameter(r2, "ram");
        Intrinsics.checkNotNullParameter(r3, "storageTotal");
        Intrinsics.checkNotNullParameter(r4, "storageAvailable");
        Intrinsics.checkNotNullParameter(r5, "screenSize");
        Intrinsics.checkNotNullParameter(r6, Api.KEY_RESOLUTION);
        Intrinsics.checkNotNullParameter(r7, "brand");
        Intrinsics.checkNotNullParameter(r8, "model");
        Intrinsics.checkNotNullParameter(r9, "osVersion");
        Intrinsics.checkNotNullParameter(r10, "ipAddress");
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r11 = buildDeviceStateMap(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, Object> r12 = r11.next();
        r0.put(r12.getKey(), r12.getValue());
        goto L4
    L6:
        return r0;
    }
}
