package com.bytedance.bdlocation.client;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import d.b.c.d.h;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationClient {
    public static String COMMON_UPLOAD_SOURCE = "from_client";
    private Context mContext;
    private LocationOption mOption;

    static {
    }

    public BDLocationClient(Context r1) {
        this.mContext = r1;
    }

    private LocationOption getOption(BDLocationClientOption r3) {
        LocationOption r2 = new LocationOption();
        r2.setLocateType(r3.getLocateType());
        r2.setLocationTimeOutMs(r3.getLocationTimeOut());
        r2.setMaxCacheTime(r3.getMaxCacheTime());
        r2.setUploadSource(r3.getUploadSource());
        r2.setCert(r3.isCert());
        r2.setAccuracyLevel(r3.getAccuracyLevel());
        r2.setInterval(r3.getInterval());
        r2.setTriggerType(r3.getTriggerType());
        r2.setMode(r3.getLocationMode());
        r2.setBpeaCert(r3.getBpeaCert());
        r2.setLatestAdminVersion(r3.isLatestAdminVersion());
        r2.setUpload(r3.isUpload());
        if (TextUtils.isEmpty(r2.getUploadSource()) == false) goto L5;
        r2.setUploadSource(COMMON_UPLOAD_SOURCE);
    L5:
        r2.setExtra(r3.getExtra());
        return r2;
    }

    private long getPollUploadInterval() {
        return d.b.c.a.a.b().c();
    }

    public boolean checkInit(BDLocationCallback r4) {
        if (BDLocationConfig.checkInit() == false) goto L6;
        return true;
    L6:
        Logger.i("Must be called after BDLocation initialization!");
        if (r4 == null) goto L11;
        r4.onError(new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION));
        return false;
    L11:
        return false;
    }

    @Nullable
    @WorkerThread
    public BDLocation getLocation() {
        Logger.d("BDLocationClient:getLocation synchronization");
        if (checkInit(null) == true) goto L5;
        return null;
    L5:
        LocationOption r0 = this.mOption;
        if (r0 == null) goto L10;
        r0.setOnceLocation(true);
        this.mOption.setBpeaAction("getLocationCert");
        LocationUtil.checkBpeaCertNull("execLocation", this.mOption.getBpeaCert());
        return h.F().A(new LocationOption(this.mOption));
    L10:
        throw new BDLocationException(BDLocationExceptionMessage.LOCATION_OPTION_IS_NULL, EnvironmentCompat.MEDIA_UNKNOWN, BDLocationException.ERROR_LOCATION_OPTION);
    }

    public void getLocation(@NonNull BDLocationCallback r4) {
        Logger.d("BDLocationClient:getLocation asynchronous");
        if (checkInit(r4) == true) goto L5;
        return;
    L5:
        LocationOption r0 = this.mOption;
        if (r0 != null) goto L10;
        if (r4 == null) goto L10;
        r4.onError(new BDLocationException(BDLocationExceptionMessage.LOCATION_OPTION_IS_NULL, EnvironmentCompat.MEDIA_UNKNOWN, BDLocationException.ERROR_LOCATION_OPTION));
        return;
    L10:
        r0.setOnceLocation(true);
        this.mOption.setBpeaAction("getLocation");
        LocationUtil.checkBpeaCertNull("getLocation", this.mOption.getBpeaCert());     // Catch: BDLocationException -> L14
        h.F().Y(r4, new LocationOption(this.mOption));
        return;
    L14:
        e = move-exception;
        r4.onError(e);
    }

    public void setClientOption(BDLocationClientOption r5) {
        if (r5.getBpeaCert() != null) goto L5;
        Logger.i("setClientOption bpea cert is null,trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        LocationOption r6 = getOption(r5);
        this.mOption = r6;
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.getMaxCacheTime() <= 0) goto L12;
        this.mOption.setMaxCacheTime(getPollUploadInterval());
        return;
    }

    @AnyThread
    public void startLocation(@Nullable BDLocationCallback r5) {
        monitor-enter(this);
        Logger.d("BDLocationClient:startLocation");     // Catch: Throwable -> L23
        if (checkInit(r5) == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L7:
        LocationOption r0 = this.mOption;     // Catch: Throwable -> L23
        if (r0 != null) goto L13;
        if (r5 == null) goto L13;
        r5.onError(new BDLocationException(BDLocationExceptionMessage.LOCATION_OPTION_IS_NULL, EnvironmentCompat.MEDIA_UNKNOWN, BDLocationException.ERROR_LOCATION_OPTION));     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L13:
        r0.setOnceLocation(false);     // Catch: Throwable -> L23
        this.mOption.setBpeaAction("startLocation");     // Catch: Throwable -> L23
        LocationUtil.checkBpeaCertNull("startLocation", this.mOption.getBpeaCert());     // Catch: BDLocationException -> L18 Throwable -> L23
        h.F().X(r5, new LocationOption(this.mOption));     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L18:
        e = move-exception;
        if (r5 == null) goto L22;
        r5.onError(e);     // Catch: Throwable -> L23
    L22:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    @AnyThread
    public void stopLocation() {
        monitor-enter(this);
        Logger.d("BDLocationClient:stopLocation");     // Catch: Throwable -> L6
        h.F().Z();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
