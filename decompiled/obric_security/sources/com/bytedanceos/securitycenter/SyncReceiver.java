package com.bytedanceos.securitycenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedanceos.securitycenter.dynamicResolution.DynamicResolutionDataService;
import com.bytedanceos.securitycenter.networkControl.NetworkRejectDataService;

/* JADX INFO: loaded from: classes2.dex */
public class SyncReceiver extends BroadcastReceiver {
    private static final String ACTION_CONFIG_UPDATE = "com.android.providers.downloads.ACTION_SYNC_DATA_FINISH";
    private static final String NETWORK_REJECT_TASK_NAME = "network_reject_white_list";
    private static final String POW_DISPLAY_TASK_NAME = "pow_display";

    public SyncReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (ACTION_CONFIG_UPDATE.equals(intent.getAction()) == false) goto L11;
        String r5 = intent.getStringExtra("name");
        if (TextUtils.equals(r5, POW_DISPLAY_TASK_NAME) == false) goto L8;
        Intent r6 = new Intent(context, DynamicResolutionDataService.class);
        r6.setAction(ACTION_CONFIG_UPDATE);
        r6.putExtra("name", POW_DISPLAY_TASK_NAME);
        context.startService(r6);
        return;
    L8:
        if (TextUtils.equals(r5, NETWORK_REJECT_TASK_NAME) == false) goto L13;
        Intent r7 = new Intent(context, NetworkRejectDataService.class);
        r7.setAction(ACTION_CONFIG_UPDATE);
        r7.putExtra("name", NETWORK_REJECT_TASK_NAME);
        context.startService(r7);
        return;
    L13:
        return;
    }
}
