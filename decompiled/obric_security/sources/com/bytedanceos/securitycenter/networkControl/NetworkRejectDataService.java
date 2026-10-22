package com.bytedanceos.securitycenter.networkControl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.NetworkPolicyManager;
import android.net.Uri;
import android.os.IPowerAdvisor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import com.bytedanceos.security.AppExitTrace;
import com.bytedanceos.securitycenter.Utils;
import com.obric.olog.OLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkRejectDataService extends IntentService {
    private static final String ACTION_CONFIG_UPDATE = "com.android.providers.downloads.ACTION_SYNC_DATA_FINISH";
    public static final String ACTION_INIT_DATA = "init_data";
    public static final String ACTION_INIT_DOZE_DATA = "init_doze_data";
    public static final String ACTION_UPDATE_DOZE_DATA = "update_doze_data";
    private static final String TAG = "NetworkRejectDataService";
    private static final String TASK_NAME = "network_reject_white_list";
    private static final String URI = "content://com.bytedanceos.datasync/sync_datas";
    private String mReceivedMD5;

    public NetworkRejectDataService() {
        super(TAG);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String r0 = intent.getAction();
        OLog.i(TAG, "onHandleIntent#action:" + r0);
        if (TextUtils.equals(r0, ACTION_CONFIG_UPDATE) == false) goto L30;
        if (TextUtils.equals(intent.getStringExtra("name"), TASK_NAME) == false) goto L107;
        Cursor r13 = getBaseContext().getContentResolver().query(Uri.parse(URI), null, null, new String[]{TASK_NAME}, null);
        if (r13 != null) goto L9;
        return;
    L9:
        byte[] r1 = null;
        int r2 = r13.getColumnIndex("md5");     // Catch: Throwable -> L17 Exception -> L19
        int r3 = r13.getColumnIndex("data");     // Catch: Throwable -> L17 Exception -> L19
        if (r13.moveToFirst() == false) goto L14;
    L12:
        this.mReceivedMD5 = r13.getString(r2);     // Catch: Throwable -> L17 Exception -> L19
        r1 = r13.getBlob(r3);     // Catch: Throwable -> L17 Exception -> L19
        if (r13.moveToNext() == true) goto L12;
    L14:
        r13.close();
        if (r1 == null) goto L24;
        updateDataFromRemote(this, r1);
    L24:
        updateDefaultWhitelist();
        return;
    L17:
        th = move-exception;
        r13.close();
        if (r1 == null) goto L28;
        updateDataFromRemote(this, r1);
    L28:
        throw th;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        r13.close();
        if (r1 == null) goto L24;
        updateDataFromRemote(this, r1);
        goto L24
    L107:
        return;
    L30:
        if (TextUtils.equals(r0, ACTION_INIT_DATA) == false) goto L56;
        Set<String> r14 = NetworkRejectHelper.getWhiteList(this);
        Set<String> r4 = NetworkRejectHelper.getSystemWhiteList(this);
        PackageManager r5 = getPackageManager();
        if (r5 != null) goto L34;
        return;
    L34:
        NetworkPolicyManager r6 = NetworkPolicyManager.from(this);
        List<PackageInfo> r7 = r5.getInstalledPackages(0);
        HashSet r8 = new HashSet();
        if (r7 == null) goto L54;
        Iterator<PackageInfo> r9 = r7.iterator();
    L38:
        if (r9.hasNext() == false) goto L54;
        ApplicationInfo r10 = r9.next().applicationInfo;
        if ((r10.flags & 1) != 0) goto L52;
        if ((r10.flags & 128) != 0) goto L52;
        if (r14.contains(r10.packageName) == false) goto L47;
        r8.add(r10.packageName);
        int r11 = 0;
    L49:
        if (r10.uid <= 10000) goto L38;
        NetworkRejectHelper.setRealPolicy(r6, r10.uid, r11);
        goto L38
    L47:
        r11 = 8;
    L52:
        if (r4.contains(r10.packageName) == false) goto L38;
        r8.add(r10.packageName);
    L54:
        SharedPreferences r15 = getSharedPreferences(NetworkRejectHelper.NETWORK_CONTROL, 0);
        DeviceIdleControllerHelper.addApps(r8);
        r15.edit().putBoolean("init", true).putBoolean(NetworkRejectHelper.NETWORKPOLICY_DOZE_INIT, true).commit();
        updateDefaultWhitelist();
        AppExitTrace.getInstance().finishTask(AppExitTrace.TASK_NRDS_INIT_DATA);
        return;
    L56:
        if (TextUtils.equals(r0, ACTION_INIT_DOZE_DATA) == false) goto L78;
        Set<String> r16 = NetworkRejectHelper.getSystemWhiteList(this);
        PackageManager r12 = getPackageManager();
        if (r12 != null) goto L60;
        return;
    L60:
        NetworkPolicyManager r17 = NetworkPolicyManager.from(this);
        List<PackageInfo> r18 = r12.getInstalledPackages(0);
        HashSet r19 = new HashSet();
        if (r18 == null) goto L76;
        Iterator<PackageInfo> r20 = r18.iterator();
    L64:
        if (r20.hasNext() == false) goto L76;
        ApplicationInfo r21 = r20.next().applicationInfo;
        if ((r21.flags & 1) != 0) goto L74;
        if ((r21.flags & 128) != 0) goto L74;
        if (r17.getUidPolicy(r21.uid) != 0) goto L64;
        r19.add(r21.packageName);
    L74:
        if (r16.contains(r21.packageName) == false) goto L64;
        r19.add(r21.packageName);
    L76:
        DeviceIdleControllerHelper.addApps(r19);
        getSharedPreferences(NetworkRejectHelper.NETWORK_CONTROL, 0).edit().putBoolean(NetworkRejectHelper.NETWORKPOLICY_DOZE_INIT, true).commit();
        updateDefaultWhitelist();
        AppExitTrace.getInstance().finishTask(AppExitTrace.TASK_NRDS_INIT_DOZE_DATA);
        return;
    L78:
        if (TextUtils.equals(r0, ACTION_UPDATE_DOZE_DATA) == false) goto L111;
        updateDozeData();
        return;
    }

    private void updateDozeData() {
        Set<String> r0 = NetworkRejectHelper.getLocalSystemWhiteList(this);
        Set<String> r1 = NetworkRejectHelper.getNetSystemWhiteList(this);
        if (r1 == null) goto L6;
        r0 = r1;
    L6:
        PackageManager r4 = getPackageManager();
        if (r4 != null) goto L9;
        return;
    L9:
        List<PackageInfo> r5 = r4.getInstalledPackages(0);
        HashSet r2 = new HashSet();
        if (r5 == null) goto L23;
        Iterator<PackageInfo> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L23;
        ApplicationInfo r3 = r6.next().applicationInfo;
        if ((r3.flags & 1) != 0) goto L19;
        if ((r3.flags & 128) == 0) goto L13;
    L19:
        if (r0.contains(r3.packageName) == false) goto L13;
        if (DeviceIdleControllerHelper.isWhileListApp(r3.packageName) == true) goto L13;
        r2.add(r3.packageName);
    L23:
        DeviceIdleControllerHelper.addApps(r2);
        AppExitTrace.getInstance().finishTask(AppExitTrace.TASK_NRDS_UPDATE_DOZE_DATA);
        OLog.i(TAG, "updateDozeData#whileListApp gms:" + DeviceIdleControllerHelper.isWhileListApp("com.google.android.gms"));
    }

    private void updateDefaultWhitelist() {
        IPowerAdvisor r0 = IPowerAdvisor.Stub.asInterface(ServiceManager.getService("poweradvisor"));
        if (r0 == null) goto L9;
        r0.updateDefaultWhitelist((String[]) NetworkRejectHelper.getWhiteList(this).toArray(new String[0]));     // Catch: RemoteException -> L6
        return;
    L10:
        return;
    }

    private void updateDataFromRemote(Context contexts, byte[] data) {
        NetworkRejectHelper.saveToPreferences(contexts, new String(data));
        Utils.sendCloudFeedBack(contexts, TASK_NAME, this.mReceivedMD5);
    }
}
