package com.obric.settingcommon;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class CloudServiceEnabler extends SettingsEnabler {
    private final String AUTHORITY;
    private final String CLOUD_SERVICE_URI;
    private final String METHOD_GET_CLOUD_SERVICE_SWITCH_STATE;
    private final String METHOD_SET_CLOUD_SERVICE_SWITCH_STATE;
    private final String SPECIAL_KEY;
    private final String SWITCH_VALUE;
    private String specailKey;

    public CloudServiceEnabler(Context r1, OSwitch r2, String r3) {
        super(r1, r2);
        this.SPECIAL_KEY = "special_key";
        this.SWITCH_VALUE = "switch_value";
        this.AUTHORITY = "com.obric.cloudservice";
        this.CLOUD_SERVICE_URI = "content://com.obric.cloudservice";
        this.METHOD_GET_CLOUD_SERVICE_SWITCH_STATE = "getCloudServiceSwitchState";
        this.METHOD_SET_CLOUD_SERVICE_SWITCH_STATE = "setCloudServiceSwitchState";
        this.specailKey = r3;
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        ContentProviderClient r1 = null;
        this.mSwitch.setOnCheckedChangeListener(null);
        ContentProviderClient r2 = this.mContext.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.obric.cloudservice"));     // Catch: Throwable -> L13 Exception -> L15
        Bundle r3 = new Bundle();     // Catch: Exception -> L11 Throwable -> L22
        r3.putString("special_key", this.specailKey);     // Catch: Exception -> L11 Throwable -> L22
        if (r2 == null) goto L9;
        Bundle r4 = r2.call("com.obric.cloudservice", "getCloudServiceSwitchState", null, r3);     // Catch: Exception -> L11 Throwable -> L22
        if (r4 == null) goto L9;
        this.mSwitch.setChecked(r4.getBoolean("switch_value", false));     // Catch: Exception -> L11 Throwable -> L22
    L9:
        if (r2 != null) goto L19;
    L20:
        this.mSwitch.setOnCheckedChangeListener(this);
        return;
    L19:
        r2.close();
    L11:
        Exception e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L22
        this.mSwitch.setChecked(false);     // Catch: Throwable -> L22
        if (r2 == null) goto L20;
    L22:
        th = th;
        r1 = r2;
    L24:
        if (r1 == null) goto L26;
        r1.close();
    L26:
        throw th;
    L15:
        e = move-exception;
        r2 = null;
        e = e;
    L13:
        th = th;
        goto L24
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r5, boolean r6) {
        super.onCheckedChanged(r5, r6);
        ContentProviderClient r7 = null;
        Uri r0 = Uri.parse("content://com.obric.cloudservice");     // Catch: Throwable -> L14 Exception -> L16
        ContentProviderClient r1 = this.mContext.getContentResolver().acquireUnstableContentProviderClient(r0);     // Catch: Throwable -> L14 Exception -> L16
        Bundle r2 = new Bundle();     // Catch: Throwable -> L10 Exception -> L12
        r2.putString("special_key", this.specailKey);     // Catch: Throwable -> L10 Exception -> L12
        r2.putBoolean("switch_value", r6);     // Catch: Throwable -> L10 Exception -> L12
        if (r1 == null) goto L7;
        r1.call("com.obric.cloudservice", "setCloudServiceSwitchState", null, r2);     // Catch: Throwable -> L10 Exception -> L12
    L7:
        TrackerEventUpload.switchEvent(this.specailKey, r6);     // Catch: Throwable -> L10 Exception -> L12
        if (r1 == null) goto L24;
        r1.close();
    L24:
        return;
    L12:
        e = e;
        r7 = r1;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L14
        if (r7 == null) goto L24;
        r7.close();
    L10:
        th = th;
        r7 = r1;
    L21:
        if (r7 == null) goto L23;
        r7.close();
    L23:
        throw th;
    L14:
        th = th;
    L16:
        e = e;
        goto L17
    }
}
