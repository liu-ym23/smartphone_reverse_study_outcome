package com.android.settings.metrics;

import android.content.Context;
import com.obric.apptools.sdk.common.Event;
import com.obric.apptools.sdk.common.IMetricsReporter;
import com.obric.apptools.sdk.common.SlardarOsExt;
import com.slardaros.client.MetricEvent;
import com.slardaros.client.SlardarAgent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SlardarOsReporter implements IMetricsReporter {
    public SlardarOsReporter() {
    }

    @Override // com.obric.apptools.sdk.common.IMetricsReporter
    public void init(Context r1) {
        SlardarAgent.init(r1);
    }

    @Override // com.obric.apptools.sdk.common.IMetricsReporter
    public void report(Event r3) {
        MetricEvent r2 = new MetricEvent(r3.getEventName(), SlardarOsExt.INSTANCE.constructSlardarParams(r3));
        ArrayList r4 = new ArrayList();
        r4.add(r2);
        SlardarAgent.onAgentEventList(r4);
    }
}
