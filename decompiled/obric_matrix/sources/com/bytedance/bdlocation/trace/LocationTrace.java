package com.bytedance.bdlocation.trace;

import android.util.Log;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationTrace implements LocateCallback {
    private static final int THROWABLES_LENGTH = 16;
    private boolean isCache;
    private TraceCallback mCallback;
    private BDLocationException mError;
    private long mFirstCallbackTimeMs;
    private long mGeocodeDuration;
    private BDLocation mLocation;
    private long mStartTimeMs;
    private long mStopTimeMs;
    private final String mTag;
    private List<Throwable> mThrowables;

    public LocationTrace(String r2) {
        this.mTag = r2;
        this.mThrowables = Collections.synchronizedList(new ArrayList(3));
    }

    private void endTrace(boolean r14) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        if (r14 == true) goto L6;
        r0.onStop();
    L6:
        this.mStopTimeMs = System.currentTimeMillis();
        BDLocation r1 = this.mLocation;
        BDLocationException r2 = this.mError;
        if (BDLocationConfig.isDebug() == false) goto L10;
        Log.d("BDLocation", toString());
    L10:
        if (this.mFirstCallbackTimeMs != 0) goto L12;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
    L12:
        JSONObject r3 = new JSONObject();
        JSONObject r4 = new JSONObject();
        r3.put(TraceCons.METRIC_BIZ, this.mTag);     // Catch: Exception -> L28
        if (BDLocationConfig.isBackground() == false) goto L16;
        int r5 = 1;
    L17:
        r3.put(TraceCons.METRIC_BACKGROUND, r5);     // Catch: Exception -> L28
        if (r1 == null) goto L21;
        r3.put("total_duration", this.mFirstCallbackTimeMs - this.mStartTimeMs);     // Catch: Exception -> L28
        r3.put(TraceCons.METRIC_GEO_COST, this.mGeocodeDuration);     // Catch: Exception -> L28
        r3.put(TraceCons.METRIC_REDUCE, r14);     // Catch: Exception -> L28
        r3.put("status", 1);     // Catch: Exception -> L28
        return;
    L21:
        if (r2 == null) goto L31;
        r3.put("total_duration", this.mFirstCallbackTimeMs - this.mStartTimeMs);     // Catch: Exception -> L28
        r3.put("status", 0);     // Catch: Exception -> L28
        r3.put(TraceCons.METRIC_REDUCE, r14);     // Catch: Exception -> L28
        r4.put(TraceCons.EXTRA_FAIL_CODE, r2.getCode());     // Catch: Exception -> L28
        r4.put(TraceCons.EXTRA_FAIL_MESSAGE, r2.getMessage());     // Catch: Exception -> L28
        Iterator<Map.Entry<String, String>> r13 = r2.getExtra().entrySet().iterator();     // Catch: Exception -> L28
    L24:
        if (r13.hasNext() == false) goto L33;
        Map.Entry<String, String> r15 = r13.next();     // Catch: Exception -> L28
        r4.put(r15.getKey(), r15.getValue());     // Catch: Exception -> L28
        goto L24
    L33:
        return;
    L31:
        return;
    L16:
        r5 = 0;
        goto L17
    }

    private void reset() {
        this.isCache = false;
        this.mStopTimeMs = 0;
        this.mFirstCallbackTimeMs = 0;
        this.mLocation = null;
        this.mError = null;
        this.mGeocodeDuration = 0;
    }

    public void addGeocodeDuration(long r5) {
        if (this.mGeocodeDuration != 0) goto L6;
        this.mGeocodeDuration = r5;
        return;
    }

    public void addTraceInfo(BDLocation r5) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L5;
        r0.onLocationChanged(new BDLocation(r5));
    L5:
        this.mLocation = r5;
        this.isCache = r5.isCache();
        if (this.mFirstCallbackTimeMs != 0) goto L9;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
        return;
    }

    public void addTraceInfo(BDLocationException r5) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L5;
        r0.onError(r5);
    L5:
        this.mError = r5;
        if (this.mThrowables.size() >= 16) goto L10;
        this.mThrowables.add(r5);     // Catch: Exception -> L13
    L10:
        if (this.mFirstCallbackTimeMs != 0) goto L16;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
        return;
    }

    public void clearCauses() {
        this.mThrowables.clear();
    }

    public void endTrace() {
        endTrace(false);
    }

    @Nullable
    public BDLocationException getAllCauses() {
        if (this.mThrowables.isEmpty() == true) goto L7;
        return new BDLocationException(new ArrayList(this.mThrowables));
    L7:
        return this.mError;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public String getTag() {
        return this.mTag;
    }

    public long getTraceTimeMs() {
        return this.mStopTimeMs - this.mStartTimeMs;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateChange(String r1, BDLocation r2) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onLocateChange(r1, r2);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateError(String r1, BDLocationException r2) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onLocateError(r1, r2);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStart(String r1) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onLocateStart(r1);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStop(String r1) {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onLocateStop(r1);
        return;
    }

    public void reduce(BDLocationException r1) {
        addTraceInfo(r1);
        endTrace(true);
        reset();
    }

    public void setTraceCallback(TraceCallback r1) {
        this.mCallback = r1;
    }

    public void startTrace() {
        TraceCallback r0 = this.mCallback;
        if (r0 == null) goto L5;
        r0.onStart(this);
    L5:
        this.mStartTimeMs = System.currentTimeMillis();
        if (BDLocationConfig.isDebug() == false) goto L9;
        Log.d("BDLocation", this.mTag);
        return;
    }

    public String toString() {
        return "LocationTrace{mTag='" + this.mTag + "', mStartTimeMs=" + this.mStartTimeMs + ", isCache=" + this.isCache + ", mStopTimeMs=" + this.mStopTimeMs + ", mLocation=" + this.mLocation + ", mError=" + this.mError + '}';
    }
}
