package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.android.settings.MultiSimAdapter;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceParamsLoader extends BaseLoader {
    private final Context mApp;
    private final Env mEnv;
    private final InstallOptions mOption;

    DeviceParamsLoader(Context r3, InstallOptions r4, Env r5) {
        super(false, true);
        this.mApp = r3;
        this.mOption = r4;
        this.mEnv = r5;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r4) throws JSONException, SecurityException {
        TelephonyManager r0 = (TelephonyManager) this.mApp.getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r0 == null) goto L5;
        Utils.putStringIfNotEmpty(r4, Api.KEY_CARRIER, r0.getNetworkOperatorName());
        Utils.putStringIfNotEmpty(r4, Api.KEY_MCC_MNC, r0.getNetworkOperator());
    L5:
        IInstallParameters r1 = (IInstallParameters) ServiceManager.getService(IInstallParameters.class);
        Utils.putStringIfNotEmpty(r4, Api.KEY_C_UDID, r1.getClientUDID());
        if (this.mEnv.isChildMode() == true) goto L8;
        Utils.putStringIfNotEmpty(r4, Api.KEY_OPEN_UDID, r1.getOpenUdid(true));
    L8:
        return true;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r1) {
        super.remove(r1);
        r1.remove(Api.KEY_CARRIER);
        r1.remove(Api.KEY_MCC_MNC);
        r1.remove(Api.KEY_C_UDID);
        r1.remove(Api.KEY_OPEN_UDID);
    }
}
