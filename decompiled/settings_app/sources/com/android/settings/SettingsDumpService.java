package com.android.settings;

import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkTemplate;
import android.os.IBinder;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.android.settings.applications.ProcStatsData;
import com.android.settingslib.mobile.dataservice.DataServiceUtils;
import com.android.settingslib.net.DataUsageController;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.bdinstall.Api;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsDumpService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    public SettingsDumpService() {
    }

    @Override // android.app.Service
    protected void dump(FileDescriptor r2, PrintWriter r3, String[] r4) {
        JSONObject r5 = new JSONObject();
        r5.put("service", "Settings State");     // Catch: Exception -> L5
        r5.put("storage", dumpStorage());     // Catch: Exception -> L5
        r5.put("datausage", dumpDataUsage());     // Catch: Exception -> L5
        r5.put("memory", dumpMemory());     // Catch: Exception -> L5
    L7:
        r3.println(r5);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private JSONObject dumpMemory() throws JSONException {
        JSONObject r0 = new JSONObject();
        ProcStatsData r1 = new ProcStatsData(this, false);
        r1.refreshStats(true);
        ProcStatsData.MemInfo r4 = r1.getMemInfo();
        r0.put("used", String.valueOf(r4.realUsedRam));
        r0.put("free", String.valueOf(r4.realFreeRam));
        r0.put(PerfConsts.PERF_DISK_TOTAL, String.valueOf(r4.realTotalRam));
        r0.put("state", r1.getMemState());
        return r0;
    }

    private JSONObject dumpDataUsage() throws JSONException {
        JSONObject r0 = new JSONObject();
        DataUsageController r1 = new DataUsageController(this);
        ConnectivityManager r2 = (ConnectivityManager) getSystemService(ConnectivityManager.class);
        if (r2 != null) goto L5;
        return r0;
    L5:
        SubscriptionManager r3 = SubscriptionManager.from(this);
        TelephonyManager r4 = TelephonyManager.from(this);
        if (r2.isNetworkSupported(0) == false) goto L13;
        JSONArray r5 = new JSONArray();
        Iterator<SubscriptionInfo> r6 = r3.getAllSubscriptionInfoList().iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        SubscriptionInfo r7 = r6.next();
        JSONObject r8 = dumpDataUsage(NetworkTemplate.buildTemplateMobileAll(r4.getSubscriberId(r7.getSubscriptionId())), r1);
        r8.put(DataServiceUtils.MobileNetworkInfoData.COLUMN_ID, r7.getSubscriptionId());
        r5.put(r8);
        goto L9
    L11:
        r0.put("cell", r5);
    L13:
        if (r2.isNetworkSupported(1) == false) goto L16;
        r0.put("wifi", dumpDataUsage(NetworkTemplate.buildTemplateWifiWildcard(), r1));
    L16:
        if (r2.isNetworkSupported(9) == false) goto L18;
        r0.put("ethernet", dumpDataUsage(NetworkTemplate.buildTemplateEthernet(), r1));
    L18:
        return r0;
    }

    private JSONObject dumpDataUsage(NetworkTemplate r3, DataUsageController r4) throws JSONException {
        JSONObject r2 = new JSONObject();
        DataUsageController.DataUsageInfo r5 = r4.getDataUsageInfo(r3);
        r2.put(Api.KEY_CARRIER, r5.carrier);
        r2.put("start", r5.startDate);
        r2.put("usage", r5.usageLevel);
        r2.put("warning", r5.warningLevel);
        r2.put(DataUsageFragment.INTENT_EXTRA_LIMIT, r5.limitLevel);
        return r2;
    }

    private JSONObject dumpStorage() throws JSONException {
        JSONObject r0 = new JSONObject();
        Iterator r8 = ((StorageManager) getSystemService(StorageManager.class)).getVolumes().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        VolumeInfo r1 = (VolumeInfo) r8.next();
        JSONObject r2 = new JSONObject();
        if (r1.isMountedReadable() == false) goto L8;
        File r3 = r1.getPath();
        r2.put("used", String.valueOf(r3.getTotalSpace() - r3.getFreeSpace()));
        r2.put(PerfConsts.PERF_DISK_TOTAL, String.valueOf(r3.getTotalSpace()));
    L8:
        r2.put("path", r1.getInternalPath());
        r2.put("state", r1.getState());
        r2.put("stateDesc", r1.getStateDescription());
        r2.put("description", r1.getDescription());
        r0.put(r1.getId(), r2);
        goto L4
    L9:
        return r0;
    }
}
