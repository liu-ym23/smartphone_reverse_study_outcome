package com.monitor.cloudmessage.handler.impl;

import android.text.TextUtils;
import com.monitor.cloudmessage.callback.IABTestConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ABTestMessageHandler extends BaseMessageHandler {
    private static final String KEY_FIELD = "field";
    private static final String KEY_SPKEY = "spKey";
    private static final String KEY_VALUE = "value";
    private IABTestConsumer mAbTestConsumer;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.ABTEST;
    }

    public ABTestMessageHandler() {
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r6) throws Exception {
        JSONObject r0 = new JSONObject(r6.getParams());
        if (this.mAbTestConsumer != null) goto L6;
        return false;
    L6:
        if (checkWifiOnly(r0, r6) == false) goto L8;
        return true;
    L8:
        String r1 = r0.optString(KEY_FIELD);
        if (TextUtils.isEmpty(r1) == false) goto L11;
        return false;
    L11:
        Object r2 = r0.get("value");
        this.mAbTestConsumer.notifyABTestModelUpdate(r1, r2);
        if (this.mAbTestConsumer.isUpdateABTestInfoInSP() == false) goto L14;
        String r3 = r0.optString(KEY_SPKEY);
        this.mAbTestConsumer.notifyABTestSPUpdate(r3, r2);
    L14:
        ConsumerResult r4 = this.mAbTestConsumer.getConsumerResult();
        if (r4.isSuccess() == false) goto L17;
        uploadSuccessStatus(r6);
    L18:
        return true;
    L17:
        uploadFailStatus(r4.getErrMsg(), r4.getSpecificParams(), r6);
        goto L18
    }

    public void setmAbTestConsumer(IABTestConsumer r1) {
        this.mAbTestConsumer = r1;
    }
}
