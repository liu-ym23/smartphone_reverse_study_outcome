package com.bytedance.bdlocation.utils.json.deserializer;

import android.location.Location;
import android.os.Build;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.m;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class LocationDeserializer implements i<Location> {
    public LocationDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.i
    public Location deserialize(j r4, Type r5, h r6) {
        m r3 = r4.c();
        Location r7 = new Location(r3.y("mProvider").l());
        r7.setAccuracy(r3.y("mAccuracy").s());
        r7.setAltitude(r3.y("mAltitude").s());
        r7.setBearing(r3.y("mBearing").s());
        int r8 = Build.VERSION.SDK_INT;
        if (r8 < 26) goto L6;
        r7.setBearingAccuracyDegrees(r3.y("mBearingAccuracyDegrees").s());
    L6:
        if (r8 < 17) goto L8;
        r7.setElapsedRealtimeNanos(r3.y("mElapsedRealtimeNanos").g());
    L8:
        r7.setLatitude(r3.y("mLatitude").r());
        r7.setLongitude(r3.y("mLongitude").r());
        r7.setProvider(r3.y("mProvider").l());
        r7.setSpeed(r3.y("mSpeed").s());
        if (r8 < 26) goto L11;
        r7.setSpeedAccuracyMetersPerSecond(r3.y("mSpeedAccuracyMetersPerSecond").s());
    L11:
        r7.setTime(r3.y("mTime").g());
        if (r8 < 26) goto L14;
        r7.setVerticalAccuracyMeters(r3.y("mVerticalAccuracyMeters").s());
    L14:
        return r7;
    }

    @Override // com.google.gson.i
    public /* bridge */ /* synthetic */ Location deserialize(j r1, Type r2, h r3) {
        return deserialize(r1, r2, r3);
    }
}
