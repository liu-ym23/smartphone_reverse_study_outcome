package com.bytedance.bdlocation.utils.json.serializer;

import android.location.Location;
import android.os.Build;
import com.bytedance.bdlocation.log.Logger;
import com.google.gson.j;
import com.google.gson.m;
import com.google.gson.q;
import com.google.gson.r;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class LocationSerializer implements r<Location> {
    public LocationSerializer() {
    }

    /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
    public j serialize2(Location r5, Type r6, q r7) {
        m r8 = new m();
        r8.t("mProvider", r5.getProvider());     // Catch: Exception -> L16
        r8.s("mAccuracy", Float.valueOf(r5.getAccuracy()));     // Catch: Exception -> L16
        r8.s("mAltitude", Double.valueOf(r5.getAltitude()));     // Catch: Exception -> L16
        r8.s("mBearing", Float.valueOf(r5.getBearing()));     // Catch: Exception -> L16
        int r9 = Build.VERSION.SDK_INT;     // Catch: Exception -> L16
        if (r9 < 26) goto L7;
        r8.s("mBearingAccuracyDegrees", Float.valueOf(r5.getBearingAccuracyDegrees()));     // Catch: Exception -> L16
    L7:
        if (r9 < 17) goto L9;
        r8.s("mElapsedRealtimeNanos", Long.valueOf(r5.getElapsedRealtimeNanos()));     // Catch: Exception -> L16
    L9:
        r8.s("mLatitude", Double.valueOf(r5.getLatitude()));     // Catch: Exception -> L16
        r8.s("mLongitude", Double.valueOf(r5.getLongitude()));     // Catch: Exception -> L16
        r8.t("mProvider", r5.getProvider());     // Catch: Exception -> L16
        r8.s("mSpeed", Float.valueOf(r5.getSpeed()));     // Catch: Exception -> L16
        if (r9 < 26) goto L12;
        r8.s("mSpeedAccuracyMetersPerSecond", Float.valueOf(r5.getSpeedAccuracyMetersPerSecond()));     // Catch: Exception -> L16
    L12:
        r8.s("mTime", Long.valueOf(r5.getTime()));     // Catch: Exception -> L16
        if (r9 < 26) goto L18;
        r8.s("mVerticalAccuracyMeters", Float.valueOf(r5.getVerticalAccuracyMeters()));     // Catch: Exception -> L16
    L18:
        return r8;
    L16:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L18
    }

    @Override // com.google.gson.r
    public /* bridge */ /* synthetic */ j serialize(Location r1, Type r2, q r3) {
        return serialize2(r1, r2, r3);
    }
}
