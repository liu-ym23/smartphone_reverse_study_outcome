package com.bytedance.apm6.consumer.slardar.header;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeaderUtils {
    private static long sHeaderKey = -1;

    static {
    }

    static long getTimeByHeaderId(long r3) {
        if (r3 >= 0) goto L6;
        return 0;
    L6:
        return r3 >> 16;
    }

    public HeaderUtils() {
    }

    public static JSONObject serialize(HeaderInfo r8) {
        if (r8 != null) goto L31;
        return null;
    L31:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L30
        if (r8.getStableExtra() == null) goto L9;
        r1 = JsonUtils.copyJson2(r1, r8.getStableExtra());     // Catch: Exception -> L30
    L9:
        if (r8.getDynamicExtra() == null) goto L11;
        r1 = JsonUtils.copyJson2(r1, r8.getDynamicExtra());     // Catch: Exception -> L30
    L11:
        r1.put("version_code", r8.getVersionCode());     // Catch: Exception -> L30
        r1.put("version_name", r8.getVersionName());     // Catch: Exception -> L30
        r1.put("manifest_version_code", r8.getManifestVersionCode());     // Catch: Exception -> L30
        r1.put("update_version_code", r8.getUpdateVersionCode());     // Catch: Exception -> L30
        r1.put("app_version", r8.getAppVersion());     // Catch: Exception -> L30
        r1.put("os", r8.getOs());     // Catch: Exception -> L30
        r1.put("device_platform", r8.getDevicePlatform());     // Catch: Exception -> L30
        r1.put("os_version", r8.getOsVersion());     // Catch: Exception -> L30
        r1.put("os_api", r8.getApiVersion());     // Catch: Exception -> L30
        r1.put("device_model", r8.getDeviceModel());     // Catch: Exception -> L30
        r1.put("device_brand", r8.getDeviceBrand());     // Catch: Exception -> L30
        r1.put("device_manufacturer", r8.getDeviceManufacturer());     // Catch: Exception -> L30
        r1.put("process_name", r8.getProcessName());     // Catch: Exception -> L30
        r1.put("sid", r8.getSid());     // Catch: Exception -> L30
        r1.put("rom_version", r8.getRomVersion());     // Catch: Exception -> L30
        r1.put("package", r8.getPackageName());     // Catch: Exception -> L30
        r1.put("monitor_version", r8.getMonitorVersion());     // Catch: Exception -> L30
        r1.put("channel", r8.getChannel());     // Catch: Exception -> L30
        r1.put("aid", r8.getAid());     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r8.getDeviceId()) == true) goto L14;
        r1.put("device_id", r8.getDeviceId());     // Catch: Exception -> L30
    L14:
        r1.put("uid", r8.getUid());     // Catch: Exception -> L30
        r1.put("phone_startup_time", r8.getPhoneStartTime());     // Catch: Exception -> L30
        r1.put("release_build", r8.getReleaseBuild());     // Catch: Exception -> L30
        if (r8.getConfigTime() == (-1)) goto L18;
        r1.put(Constants.KEY_CONFIG_TIME, String.valueOf(r8.getConfigTime()));     // Catch: Exception -> L30
    L18:
        if (TextUtils.isEmpty(r8.getVerifyInfo()) == true) goto L20;
        r1.put("verify_info", r8.getVerifyInfo());     // Catch: Exception -> L30
    L20:
        r1.put("current_update_version_code", r8.getCurrentUpdateVersionCode());     // Catch: Exception -> L30
        if (r8.getNtpTime() == (-1)) goto L24;
        r1.put(Constants.KEY_NTP_TIME, r8.getNtpTime());     // Catch: Exception -> L30
    L24:
        if (r8.getNtpOffset() == (-1)) goto L27;
        r1.put(Constants.KEY_NTP_OFFSET, r8.getNtpOffset());     // Catch: Exception -> L30
    L27:
        if (r8.getFilters() == null) goto L29;
        r1.put("filters", r8.getFilters());     // Catch: Exception -> L30
    L29:
        return r1;
    L30:
        return null;
    }

    public static HeaderInfo deserialize(byte[] r5) {
        HeaderInfo r1 = new HeaderInfo();     // Catch: Exception -> L9
        JSONObject r2 = new JSONObject(new String(r5));     // Catch: Exception -> L9
        r1.setVersionCode(JsonUtils.removeString(r2, "version_code"));     // Catch: Exception -> L9
        r1.setVersionName(JsonUtils.removeString(r2, "version_name"));     // Catch: Exception -> L9
        r1.setManifestVersionCode(JsonUtils.removeString(r2, "manifest_version_code"));     // Catch: Exception -> L9
        r1.setUpdateVersionCode(JsonUtils.removeString(r2, "update_version_code"));     // Catch: Exception -> L9
        r1.setAppVersion(JsonUtils.removeString(r2, "app_version"));     // Catch: Exception -> L9
        r1.setOs(JsonUtils.removeString(r2, "os"));     // Catch: Exception -> L9
        r1.setDevicePlatform(JsonUtils.removeString(r2, "device_platform"));     // Catch: Exception -> L9
        r1.setOsVersion(JsonUtils.removeString(r2, "os_version"));     // Catch: Exception -> L9
        r1.setApiVersion(JsonUtils.removeInt(r2, "os_api"));     // Catch: Exception -> L9
        r1.setDeviceModel(JsonUtils.removeString(r2, "device_model"));     // Catch: Exception -> L9
        r1.setDeviceBrand(JsonUtils.removeString(r2, "device_brand"));     // Catch: Exception -> L9
        r1.setDeviceManufacturer(JsonUtils.removeString(r2, "device_manufacturer"));     // Catch: Exception -> L9
        r1.setProcessName(JsonUtils.removeString(r2, "process_name"));     // Catch: Exception -> L9
        r1.setSid(JsonUtils.removeLong(r2, "sid"));     // Catch: Exception -> L9
        r1.setRomVersion(JsonUtils.removeString(r2, "rom_version"));     // Catch: Exception -> L9
        r1.setPackageName(JsonUtils.removeString(r2, "package"));     // Catch: Exception -> L9
        r1.setMonitorVersion(JsonUtils.removeString(r2, "monitor_version"));     // Catch: Exception -> L9
        r1.setChannel(JsonUtils.removeString(r2, "channel"));     // Catch: Exception -> L9
        r1.setAid(JsonUtils.removeInt(r2, "aid"));     // Catch: Exception -> L9
        r1.setDeviceId(JsonUtils.removeString(r2, "device_id"));     // Catch: Exception -> L9
        r1.setPhoneStartTime(JsonUtils.removeLong(r2, "phone_startup_time"));     // Catch: Exception -> L9
        r1.setReleaseBuild(JsonUtils.removeString(r2, "release_build"));     // Catch: Exception -> L9
        r1.setUid(JsonUtils.removeLong(r2, "uid"));     // Catch: Exception -> L9
        r1.setVerifyInfo(JsonUtils.removeString(r2, "verify_info"));     // Catch: Exception -> L9
        r1.setCurrentUpdateVersionCode(JsonUtils.removeString(r2, "current_update_version_code"));     // Catch: Exception -> L9
        if (r2.has(Constants.KEY_CONFIG_TIME) == false) goto L14;
        r1.setConfigTime(JsonUtils.removeInt(r2, Constants.KEY_CONFIG_TIME));     // Catch: Exception -> L9
    L14:
        r1.setFilters(new JSONObject((String) r2.remove("filters")));     // Catch: Exception -> L11
    L7:
        r1.setStableExtra(r2);     // Catch: Exception -> L9
        return r1;
    L9:
        return null;
    }

    public static long getUniqueHeaderId() {
        if (sHeaderKey != (-1)) goto L6;
        long r0 = ApmContext.getStartId();
        sHeaderKey = (r0 << 16) | ((long) Process.myPid());
    L6:
        return sHeaderKey;
    }
}
