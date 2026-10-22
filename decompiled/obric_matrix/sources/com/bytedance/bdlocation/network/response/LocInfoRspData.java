package com.bytedance.bdlocation.network.response;

import androidx.annotation.NonNull;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.RegionCountry;
import com.google.gson.y.c;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocInfoRspData {

    @c("disabled_uuid_list")
    public List<String> disableUuidList;

    @c("is_indoor")
    public int isIndoor;

    @c("is_locate")
    public boolean isLocate;

    @c("Location")
    public LocationResult location;

    @c("next_ble_scan_interval")
    public long nextBleScanInterval;

    @c("next_gps_scan_interval")
    public long nextGPSScanInterval;

    @c("next_polling_upload_interval")
    public long nextPollingUploadInterval;

    @c("Country")
    public RegionCountry regionCountry;

    @c("submit_ble_now")
    public boolean submitBleNow;
    public String submitLogId;

    public LocInfoRspData(@NonNull LocInfoRspData r3) {
        this.isIndoor = r3.isIndoor;
        this.isLocate = r3.isLocate;
        this.submitLogId = r3.submitLogId;
        this.location = r3.location;
        this.nextBleScanInterval = r3.nextBleScanInterval;
        this.submitBleNow = r3.submitBleNow;
        this.nextPollingUploadInterval = r3.nextPollingUploadInterval;
        this.regionCountry = r3.regionCountry;
        this.nextGPSScanInterval = r3.nextGPSScanInterval;
        this.disableUuidList = r3.disableUuidList;
    }

    public String toString() {
        return "LocInfoRspData{isIndoor=" + this.isIndoor + ", isLocate=" + this.isLocate + ", submitLogId='" + this.submitLogId + "', nextBleScanInterval=" + this.nextBleScanInterval + ", submitBleNow=" + this.submitBleNow + ", nextPollingUploadInterval=" + this.nextPollingUploadInterval + ", location=" + this.location + ", regionCountry=" + this.regionCountry + ", nextGPSScanInterval=" + this.nextGPSScanInterval + ", disableUuidList=" + this.disableUuidList + '}';
    }
}
