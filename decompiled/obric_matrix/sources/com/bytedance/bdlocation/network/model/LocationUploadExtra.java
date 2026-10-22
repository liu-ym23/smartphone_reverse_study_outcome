package com.bytedance.bdlocation.network.model;

import androidx.annotation.Nullable;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.scan.gps.BDGpsInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocationUploadExtra {
    private LogIdCacheEntity logIdCacheEntity;
    private List<BDBleInfo> mBleInfoList;
    private Object mBpeaCert;
    private long mCurrentStationDuration;
    private String mExtra;
    private String mGpsAndBleMark;
    private BDGpsInfo mGpsInfo;
    private boolean mLatestAdminVersion;
    private long mLightSubmitDuration;
    private long mStartLocationTime;
    private int triggerType;
    private long uploadInterval;
    private String uploadSource;

    public LocationUploadExtra() {
        this.mGpsAndBleMark = "";
    }

    @Nullable
    public List<BDBleInfo> getBleList() {
        return this.mBleInfoList;
    }

    public Object getBpeaCert() {
        return this.mBpeaCert;
    }

    public long getCurrentStationDuration() {
        return this.mCurrentStationDuration;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public String getGpsAndBleMark() {
        return this.mGpsAndBleMark;
    }

    public BDGpsInfo getGpsInfo() {
        return this.mGpsInfo;
    }

    public long getLightSubmitDuration() {
        return this.mLightSubmitDuration;
    }

    @Nullable
    public LogIdCacheEntity getLogIdCache() {
        return this.logIdCacheEntity;
    }

    public long getStartLocationTime() {
        return this.mStartLocationTime;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    @Nullable
    public long getUploadInterval() {
        return this.uploadInterval;
    }

    @Nullable
    public String getUploadSource() {
        return this.uploadSource;
    }

    public boolean isLatestAdminVersion() {
        return this.mLatestAdminVersion;
    }

    public void setBleList(List<BDBleInfo> r1) {
        this.mBleInfoList = r1;
    }

    public void setBpeaCert(Object r1) {
        this.mBpeaCert = r1;
    }

    public void setCurrentStationDuration(long r1) {
        this.mCurrentStationDuration = r1;
    }

    public void setExtra(String r1) {
        this.mExtra = r1;
    }

    public void setGpsAndBleMark(String r1) {
        this.mGpsAndBleMark = r1;
    }

    public void setGpsInfo(BDGpsInfo r1) {
        this.mGpsInfo = r1;
    }

    public void setLatestAdminVersion(boolean r1) {
        this.mLatestAdminVersion = r1;
    }

    public void setLightSubmitDuration(long r1) {
        this.mLightSubmitDuration = r1;
    }

    public void setLogIdCache(LogIdCacheEntity r1) {
        this.logIdCacheEntity = r1;
    }

    public void setStartLocationTime(long r1) {
        this.mStartLocationTime = r1;
    }

    public void setTriggerType(int r1) {
        this.triggerType = r1;
    }

    public void setUploadInterval(long r1) {
        this.uploadInterval = r1;
    }

    public void setUploadSource(String r1) {
        this.uploadSource = r1;
    }
}
