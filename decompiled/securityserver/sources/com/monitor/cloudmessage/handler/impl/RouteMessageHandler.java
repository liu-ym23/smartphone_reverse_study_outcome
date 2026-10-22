package com.monitor.cloudmessage.handler.impl;

import android.text.TextUtils;
import com.monitor.cloudmessage.callback.IRouteConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RouteMessageHandler extends BaseMessageHandler {
    private static final String KEY_SCHEMA = "schema";
    private IRouteConsumer mRouteConsumer;

    public RouteMessageHandler() {
        this.mRouteConsumer = null;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.ROUTE;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r4) {
        String r0 = new JSONObject(r4.getParams()).optString("schema");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        uploadFailStatus(ErrorMsg.COMMAND_ROUTE_SCHEME_EMPTY_ERROR, r4);
        return true;
    L6:
        IRouteConsumer r1 = this.mRouteConsumer;
        if (r1 == null) goto L13;
        r1.handleRouteUrl(r0);
        ConsumerResult r2 = this.mRouteConsumer.getConsumerResult();
        if (r2.isSuccess() == false) goto L11;
        uploadSuccessStatus(r4);
    L12:
        return true;
    L11:
        uploadFailStatus(r2.getErrMsg(), r2.getSpecificParams(), r4);
        goto L12
    L13:
        return false;
    }

    public void setRouteConsumer(IRouteConsumer r1) {
        this.mRouteConsumer = r1;
    }
}
