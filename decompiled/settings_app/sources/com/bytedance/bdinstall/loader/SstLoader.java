package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.oaid.OaidMonitor;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.storage.CNDeviceParamsProvider;
import com.bytedance.bdinstall.util.SensitiveUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class SstLoader extends BaseLoader {
    private static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    public static final String KEY_BUILD_SERIAL = "build_serial";
    public static final String KEY_MC = "mc";
    public static final String KEY_OAID_SUPPORT = "oaid_may_support";
    public static final String KEY_SERIAL_NUMBER = "serial_number";
    public static final String KEY_SIM_SERIAL_NUMBER = "sim_serial_number";
    public static final String KEY_UDID = "udid";
    public static final String KEY_UDID_LIST = "udid_list";
    private final Context mApp;
    private final InstallOptions mOptions;

    SstLoader(Context r3, InstallOptions r4) {
        super(true, false);
        this.mApp = r3;
        this.mOptions = r4;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r8) throws JSONException {
        if (this.mOptions.isTouristMode() == true) goto L26;
        IInstallParameters r0 = (IInstallParameters) ServiceManager.getService(IInstallParameters.class);
        String[] r2 = null;
        if ((r0 instanceof CNDeviceParamsProvider) == false) goto L9;
        CNDeviceParamsProvider r1 = (CNDeviceParamsProvider) r0;
        String r3 = r1.getSerialNumber();
        JSONArray r4 = r1.getUdIdList();
        String r5 = r1.getUdId();
        if (this.mOptions.reportPhoneDetailInfo() == false) goto L12;
        r2 = r1.getSimSerialNumbers();
    L12:
        Utils.putStringIfNotEmpty(r8, KEY_BUILD_SERIAL, r3);
        Utils.putStringIfNotEmpty(r8, KEY_ALIYUN_UUID, AliYunUUIDHandler.inst().getCloudUUID());
        if (validMultiIm(r4) == false) goto L15;
        r8.put(KEY_UDID_LIST, r4);
    L15:
        String r6 = SensitiveUtils.getMacAddress(this.mApp);
        if (TextUtils.isEmpty(r6) == true) goto L18;
        r8.put(KEY_MC, r6);
    L18:
        Utils.putStringIfNotEmpty(r8, KEY_UDID, r5);
        Utils.putStringIfNotEmpty(r8, KEY_SERIAL_NUMBER, r3);
        if (this.mOptions.reportPhoneDetailInfo() == false) goto L26;
        if (r2 == null) goto L26;
        JSONArray r7 = new JSONArray();
        int r9 = r2.length;
        int r10 = 0;
    L23:
        if (r10 >= r9) goto L25;
        r7.put(new JSONObject().put(KEY_SIM_SERIAL_NUMBER, r2[r10]));
        r10 = r10 + 1;
        goto L23
    L25:
        r8.put(KEY_SIM_SERIAL_NUMBER, r7);
        goto L26
    L9:
        r3 = SensitiveUtils.getSerialNumber(this.mApp, this.mOptions);
        r4 = SensitiveUtils.getMultiImei(this.mApp, this.mOptions);
        r5 = SensitiveUtils.getDeviceIdWithCache(this.mApp, this.mOptions);
        if (this.mOptions.reportPhoneDetailInfo() == false) goto L12;
        r2 = SensitiveUtils.getSimSerialNumbers(this.mApp, this.mOptions);
    L26:
        OaidMonitor.registerWaitOaid();
        Map<String, String> r11 = Oaid.instance(this.mApp).getOaid(BDInstall.getAdIdConfig().getAdIdWaitTime());
        OaidMonitor.registerWaitFinish();
        DrLog.d("getOaid: returned=" + r11);
        r8.put(KEY_OAID_SUPPORT, Oaid.instance(this.mApp).maySupport());
        if (r11 == null) goto L32;
        r8.put("oaid", new JSONObject(r11));
        return true;
    L32:
        return true;
    }

    private static boolean validMultiIm(JSONArray r5) {
        if (r5 == null) goto L14;
        int r1 = r5.length();
        if (r1 <= 0) goto L19;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L21;
        JSONObject r3 = r5.optJSONObject(r2);
        if (r3 == null) goto L13;
        if (TextUtils.isEmpty(r3.optString("id")) == true) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L7
    L21:
        return false;
    L19:
        return false;
    L14:
        return false;
    }
}
