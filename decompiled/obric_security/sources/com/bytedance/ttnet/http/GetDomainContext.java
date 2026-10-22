package com.bytedance.ttnet.http;

import com.bytedance.common.utility.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GetDomainContext {
    public boolean addCommonParam;
    public String errMsg;
    public String localSign;
    public String logid;
    public long queryTime;
    public String rawSign;
    public String ssSign;
    public int status;
    public String tncAbTest;
    public String tncCanary;
    public String tncConfigId;
    public String tncControl;
    public String tncEtag;
    public String tncQueryRegion;
    public String url;
    public boolean useHttps;

    public GetDomainContext() {
        this.errMsg = "";
        this.addCommonParam = true;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject r0 = new JSONObject();
        r0.put("status", this.status);
        r0.put("url", this.url);
        r0.put("query_time", this.queryTime);
        if (this.useHttps == true) goto L6;
        r0.put("raw_sign", this.rawSign);
        r0.put("ss_sign", this.ssSign);
        r0.put("local_sign", this.localSign);
    L6:
        if (StringUtils.isEmpty(this.errMsg) == true) goto L8;
        r0.put("err_msg", this.errMsg);
    L8:
        return r0;
    }
}
