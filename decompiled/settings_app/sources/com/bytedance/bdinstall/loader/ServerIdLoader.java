package com.bytedance.bdinstall.loader;

import android.content.SharedPreferences;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class ServerIdLoader extends BaseLoader {
    private final InstallOptions mConfig;
    private final Env mEnv;

    ServerIdLoader(InstallOptions r3, Env r4) {
        super(true, false, false);
        this.mConfig = r3;
        this.mEnv = r4;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r9) throws JSONException {
        SharedPreferences r8 = this.mEnv.getEnvIsolateSp(this.mConfig.getContext());
        String r0 = ((IInstallParameters) ServiceManager.getService(IInstallParameters.class)).getDeviceId();
        String r3 = r8.getString(Api.KEY_BD_DID, null);
        String r5 = r8.getString(Api.KEY_INSTALL_ID, null);
        String r10 = r8.getString("ssid", null);
        if (DrLog.debug() == false) goto L5;
        DrLog.d("load d=" + r0 + " i=" + r5 + " s=" + r10);
    L5:
        Utils.putStringIfNotEmpty(r9, Api.KEY_INSTALL_ID, r5);
        Utils.putStringIfNotEmpty(r9, "device_id", r0);
        Utils.putStringIfNotEmpty(r9, "ssid", r10);
        Utils.putStringIfNotEmpty(r9, Api.KEY_BD_DID, r3);
        return true;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r1) throws SecurityException {
        r1.remove(Api.KEY_BD_DID);
        r1.remove(Api.KEY_INSTALL_ID);
        r1.remove("ssid");
        r1.remove("device_id");
    }
}
