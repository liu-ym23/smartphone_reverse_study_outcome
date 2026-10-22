package com.android.settings.intent;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/android/settings/intent/DeviceStateIntentNetworkFields;", "", "()V", "buildNetworkState", "Lorg/json/JSONObject;", "cellularEnabled", "", "connected", "buildNetworkStateMap", "", "", "isCellularConnected", "dataState", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStateIntentNetworkFields {
    public static final DeviceStateIntentNetworkFields INSTANCE = null;

    static {
        INSTANCE = new DeviceStateIntentNetworkFields();
    }

    @JvmStatic
    public static final boolean isCellularConnected(int r1) {
        if (r1 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private DeviceStateIntentNetworkFields() {
    }

    @JvmStatic
    public static final Map<String, Boolean> buildNetworkStateMap(boolean r2, boolean r3) {
        return MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("cellular_enabled", Boolean.valueOf(r2)), TuplesKt.to("connected", Boolean.valueOf(r3))});
    }

    @JvmStatic
    public static final JSONObject buildNetworkState(boolean r2, boolean r3) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, Boolean>> r4 = buildNetworkStateMap(r2, r3).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, Boolean> r5 = r4.next();
        r0.put(r5.getKey(), r5.getValue().booleanValue());
        goto L4
    L6:
        return r0;
    }
}
