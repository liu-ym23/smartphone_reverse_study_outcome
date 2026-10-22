package com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathRuleBaseTNCConfig;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathValueBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTMetaDispatchConfig extends TTHostPathRuleBaseTNCConfig<TTMetaDispatchValue> {
    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathRuleBaseTNCConfig
    public String getConfigRootKey() {
        return "ttnet_req_meta_dp";
    }

    public TTMetaDispatchConfig() {
    }

    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathRuleBaseTNCConfig
    public /* bridge */ /* synthetic */ TTHostPathValueBase parseHostPathValue(Object r1) {
        return parseHostPathValue(r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathRuleBaseTNCConfig
    public TTMetaDispatchValue parseHostPathValue(Object r3) {
        if ((r3 instanceof JSONObject) == false) goto L5;
        JSONObject r4 = (JSONObject) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        TTMetaDispatchValue r0 = new TTMetaDispatchValue();
        r0.queryAddMap = parseMapConfig(r4.optJSONObject("query_add"));
        r0.queryRmSet = parseJSONArrayToSet(r4.optJSONArray("query_rm"));
        r0.headerAddMap = parseMapConfig(r4.optJSONObject("header_add"));
        r0.headerRmSet = parseJSONArrayToSet(r4.optJSONArray("header_rm"));
        return r0;
    L5:
        r4 = null;
        goto L6
    }

    private Map<String, String> parseMapConfig(JSONObject r5) {
        HashMap r4 = new HashMap();
        if (r5 != null) goto L5;
    L15:
        return r4;
    L5:
        if (r5.length() == 0) goto L15;
        Iterator<String> r0 = r5.keys();
    L9:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r4.put(r1, r2);
        goto L9
    }
}
