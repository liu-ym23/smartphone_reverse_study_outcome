package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.service.IInstallParameters;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface RegisterResultListener {
    boolean onRegisterResult(JSONObject r1, Env r2, IInstallParameters r3);
}
