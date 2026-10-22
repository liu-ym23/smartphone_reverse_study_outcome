package com.bytedance.bdlocation.client;

import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.entity.LocationExtraBean;

/* JADX INFO: loaded from: classes.dex */
public class LocationOption {
    private boolean downGradeLocation;
    private int geocodeMode;
    private long interval;
    private boolean locationChanged;
    private LocationExtraBean locationExtraBean;
    private long locationTimeOutMs;
    private int mAccuracyLevel;
    private String mBpeaAction;
    private Object mBpeaCert;
    private boolean mCert;
    private boolean mChineseRegion;
    private String mExtra;
    private boolean mIsIndoor;
    private boolean mLatestAdminVersion;
    private int mLocateType;
    private int mTriggerType;
    private long mUploadInterval;
    private long maxCacheTime;
    private int mode;
    private boolean onceLocation;
    private boolean sIsUpload;
    private boolean scanBle;
    private long startLocationTime;
    private String uploadSource;

    public LocationOption() {
        this.mAccuracyLevel = 4;
        this.uploadSource = "";
        this.mBpeaAction = "";
        this.mLocateType = -1;
        this.sIsUpload = true;
        this.mTriggerType = 1;
        this.locationTimeOutMs = 30000;
        this.mCert = false;
        this.locationChanged = false;
        this.onceLocation = true;
        this.downGradeLocation = false;
        this.mode = 2;
        this.maxCacheTime = 600000;
        this.geocodeMode = 1;
        this.mLatestAdminVersion = false;
        this.scanBle = true;
        this.mChineseRegion = true;
    }

    public LocationOption(LocationOption r5) {
        this.mAccuracyLevel = 4;
        this.uploadSource = "";
        this.mBpeaAction = "";
        this.mLocateType = -1;
        this.sIsUpload = true;
        this.mTriggerType = 1;
        this.locationTimeOutMs = 30000;
        this.mCert = false;
        this.locationChanged = false;
        this.onceLocation = true;
        this.downGradeLocation = false;
        this.mode = 2;
        this.maxCacheTime = 600000;
        this.geocodeMode = 1;
        this.mLatestAdminVersion = false;
        this.scanBle = true;
        this.mChineseRegion = true;
        if (r5 != null) goto L5;
        return;
    L5:
        this.locationTimeOutMs = r5.locationTimeOutMs;
        this.interval = r5.interval;
        this.mode = r5.mode;
        this.maxCacheTime = r5.maxCacheTime;
        this.geocodeMode = r5.geocodeMode;
        this.mIsIndoor = r5.mIsIndoor;
        this.uploadSource = r5.uploadSource;
        this.mBpeaCert = r5.mBpeaCert;
        this.mBpeaAction = r5.mBpeaAction;
        this.mAccuracyLevel = r5.mAccuracyLevel;
        this.mTriggerType = r5.mTriggerType;
        this.mLocateType = r5.mLocateType;
        this.sIsUpload = r5.sIsUpload;
        this.onceLocation = r5.onceLocation;
        this.downGradeLocation = r5.downGradeLocation;
        this.mLatestAdminVersion = r5.mLatestAdminVersion;
        this.locationChanged = r5.locationChanged;
        this.mCert = r5.mCert;
        this.mUploadInterval = r5.mUploadInterval;
        this.startLocationTime = r5.startLocationTime;
        this.locationExtraBean = r5.locationExtraBean;
        this.scanBle = r5.scanBle;
        this.mChineseRegion = r5.mChineseRegion;
        this.mExtra = r5.mExtra;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LocationOption) == true) goto L8;
        return false;
    L8:
        LocationOption r9 = (LocationOption) r8;
        if (this.locationTimeOutMs == r9.locationTimeOutMs) goto L12;
        return false;
    L12:
        if (this.interval == r9.interval) goto L15;
        return false;
    L15:
        if (this.geocodeMode == r9.geocodeMode) goto L18;
        return false;
    L18:
        if (this.mIsIndoor == r9.mIsIndoor) goto L21;
        return false;
    L21:
        if (this.sIsUpload == r9.sIsUpload) goto L24;
        return false;
    L24:
        if (this.onceLocation == r9.onceLocation) goto L27;
        return false;
    L27:
        if (this.downGradeLocation == r9.downGradeLocation) goto L30;
        return false;
    L30:
        if (this.mLatestAdminVersion == r9.mLatestAdminVersion) goto L33;
        return false;
    L33:
        if (this.mCert == r9.mCert) goto L36;
        return false;
    L36:
        if (this.mTriggerType == r9.mTriggerType) goto L39;
        return false;
    L39:
        if (this.mLocateType == r9.mLocateType) goto L42;
        return false;
    L42:
        if (this.mAccuracyLevel == r9.mAccuracyLevel) goto L45;
        return false;
    L45:
        if (TextUtils.equals(this.uploadSource, r9.uploadSource) == true) goto L48;
        return false;
    L48:
        if (this.mBpeaCert == r9.mBpeaCert) goto L51;
        return false;
    L51:
        if (TextUtils.equals(this.mBpeaAction, r9.mBpeaAction) == true) goto L54;
        return false;
    L54:
        if (TextUtils.equals(this.mExtra, r9.mExtra) == true) goto L57;
        return false;
    L57:
        if (this.startLocationTime == r9.startLocationTime) goto L60;
        return false;
    L60:
        if (this.mode != r9.mode) goto L63;
        return true;
    L63:
        return false;
    }

    public int getAccuracyLevel() {
        return this.mAccuracyLevel;
    }

    public String getBpeaAction() {
        return this.mBpeaAction;
    }

    public Object getBpeaCert() {
        return this.mBpeaCert;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public int getGeocodeMode() {
        return this.geocodeMode;
    }

    public long getInterval() {
        return this.interval;
    }

    public int getLocateType() {
        return this.mLocateType;
    }

    public LocationExtraBean getLocationExtraBean() {
        return this.locationExtraBean;
    }

    public long getLocationTimeOutMs() {
        return this.locationTimeOutMs;
    }

    public long getMaxCacheTime() {
        return this.maxCacheTime;
    }

    public int getMode() {
        return this.mode;
    }

    public long getStartLocationTime() {
        return this.startLocationTime;
    }

    public int getTriggerType() {
        return this.mTriggerType;
    }

    public long getUploadInterval() {
        return this.mUploadInterval;
    }

    public String getUploadSource() {
        return this.uploadSource;
    }

    public int hashCode() {
        long r0 = this.locationTimeOutMs;
        long r3 = this.interval;
        int r1 = ((((((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.mode) * 31) + this.mTriggerType) * 31) + this.mAccuracyLevel) * 31) + this.mLocateType) * 31) + this.geocodeMode) * 31;
        long r4 = this.maxCacheTime;
        int r2 = (((((((((((((r1 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + (this.mIsIndoor ? 1 : 0)) * 31) + (this.sIsUpload ? 1 : 0)) * 31) + (this.mCert ? 1 : 0)) * 31) + (this.onceLocation ? 1 : 0)) * 31) + (this.downGradeLocation ? 1 : 0)) * 31) + (this.mLatestAdminVersion ? 1 : 0)) * 31;
        String r5 = this.uploadSource;
        int r6 = 0;
        if (r5 == null) goto L5;
        int r7 = r5.hashCode();
    L6:
        int r8 = (r2 + r7) * 31;
        Object r9 = this.mBpeaCert;
        if (r9 == null) goto L9;
        int r10 = r9.hashCode();
    L10:
        int r11 = (r8 + r10) * 31;
        String r12 = this.mBpeaAction;
        if (r12 == null) goto L13;
        int r13 = r12.hashCode();
    L14:
        int r14 = (r11 + r13) * 31;
        String r15 = this.mExtra;
        if (r15 == null) goto L17;
        r6 = r15.hashCode();
    L17:
        int r16 = (r14 + r6) * 31;
        long r17 = this.startLocationTime;
        return r16 + ((int) ((r17 >>> 32) ^ r17));
    L13:
        r13 = 0;
        goto L14
    L9:
        r10 = 0;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    public boolean isCert() {
        return this.mCert;
    }

    public boolean isChineseRegion() {
        return this.mChineseRegion;
    }

    public boolean isDownGradeLocation() {
        return this.downGradeLocation;
    }

    public boolean isIndoor() {
        return this.mIsIndoor;
    }

    public boolean isLatestAdminVersion() {
        return this.mLatestAdminVersion;
    }

    public boolean isLocationChanged() {
        return this.locationChanged;
    }

    public boolean isOnceLocation() {
        return this.onceLocation;
    }

    public boolean isUpload() {
        return this.sIsUpload;
    }

    public boolean scanBle() {
        return this.scanBle;
    }

    public void setAccuracyLevel(int r1) {
        this.mAccuracyLevel = r1;
    }

    public void setBpeaAction(String r1) {
        this.mBpeaAction = r1;
    }

    public void setBpeaCert(Object r1) {
        this.mBpeaCert = r1;
    }

    public void setCert(boolean r1) {
        this.mCert = r1;
    }

    public void setChineseRegion(boolean r1) {
        this.mChineseRegion = r1;
    }

    public void setDownGradeLocation(boolean r1) {
        this.downGradeLocation = r1;
    }

    public void setExtra(String r1) {
        this.mExtra = r1;
    }

    public void setGeocodeMode(int r1) {
        this.geocodeMode = r1;
    }

    public void setIndoor(boolean r1) {
        this.mIsIndoor = r1;
    }

    public void setInterval(long r1) {
        this.interval = r1;
    }

    public void setLatestAdminVersion(boolean r1) {
        this.mLatestAdminVersion = r1;
    }

    public void setLocateType(int r1) {
        this.mLocateType = r1;
    }

    public void setLocationChanged(boolean r1) {
        this.locationChanged = r1;
    }

    public void setLocationExtraBean(LocationExtraBean r1) {
        this.locationExtraBean = r1;
    }

    public void setLocationTimeOutMs(long r4) {
        if (r4 >= CoroutineLiveDataKt.DEFAULT_TIMEOUT) goto L5;
        r4 = 5000;
    L5:
        this.locationTimeOutMs = r4;
    }

    public void setMaxCacheTime(long r1) {
        this.maxCacheTime = r1;
    }

    public void setMode(int r1) {
        this.mode = r1;
    }

    public void setOnceLocation(boolean r1) {
        this.onceLocation = r1;
    }

    public void setScanBle(boolean r1) {
        this.scanBle = r1;
    }

    public void setStartLocationTime(long r1) {
        this.startLocationTime = r1;
    }

    public void setTriggerType(int r1) {
        this.mTriggerType = r1;
    }

    public void setUpload(boolean r1) {
        this.sIsUpload = r1;
    }

    public void setUploadInterval(long r1) {
        this.mUploadInterval = r1;
    }

    public void setUploadSource(String r1) {
        this.uploadSource = r1;
    }

    public String toString() {
        return "LocationOption{sIsUpload=" + this.sIsUpload + ", locationTimeOutMs=" + this.locationTimeOutMs + ", interval=" + this.interval + ", mode=" + this.mode + ", triggerType=" + this.mTriggerType + ", triggerType=" + this.mLocateType + ", maxCacheTime=" + this.maxCacheTime + ", getGeocodeMode=" + this.geocodeMode + ", mIsIndoor=" + this.mIsIndoor + ", mCert=" + this.mCert + ", onceLocation=" + this.onceLocation + ", downGradeLocation=" + this.downGradeLocation + ", mLatestAdminVersion=" + this.mLatestAdminVersion + ", mBpeaAction=" + this.mBpeaAction + ", mExtra=" + this.mExtra + ", startLocationTime=" + this.startLocationTime + '}';
    }
}
