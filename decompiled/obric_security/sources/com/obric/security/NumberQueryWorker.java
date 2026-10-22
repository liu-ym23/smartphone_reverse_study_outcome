package com.obric.security;

import android.os.Bundle;
import bytedanceos.app.numberassistant.NumberAssistantCallback;
import bytedanceos.app.numberassistant.NumberAssistantProxy;
import bytedanceos.app.numberassistant.NumberQueryParams;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes4.dex */
public class NumberQueryWorker {
    public NumberQueryWorker() {
    }

    public void doWork(NumberAssistantProxy sNumberAssistantProxy, final String number, final Bundle extra, NumberAssistantCallback callback) {
        NumberQueryParams.Builder r0 = new NumberQueryParams.Builder(number);
        r0.setQueryType(2);
        r0.setExtension(extra);
        OLog.d("_CallSmsIntercept", "numberQueryWorker sNumberAssistantProxy = " + sNumberAssistantProxy);
        if (sNumberAssistantProxy == null) goto L6;
        sNumberAssistantProxy.queryNumberInfo(r0.build(), callback);
        return;
    }
}
