package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.android.settings.MultiSimAdapter;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class SimCountryLoader extends BaseLoader {
    private final Context mApp;

    SimCountryLoader(Context r3) {
        super(true, false);
        this.mApp = r3;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r2) throws JSONException {
        Utils.putStringIfNotEmpty(r2, Api.KEY_SIM_REGION, ((TelephonyManager) this.mApp.getSystemService(MultiSimAdapter.PHONE_KEY)).getSimCountryIso());
        return true;
    }
}
