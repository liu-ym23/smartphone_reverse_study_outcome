package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FlavorSpecialLoader extends BaseLoader {
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r1) throws JSONException, SecurityException {
        return true;
    }

    FlavorSpecialLoader(Context r1, InstallOptions r2) {
        super(false, false);
    }
}
