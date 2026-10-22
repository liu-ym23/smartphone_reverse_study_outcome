package com.android.settingslib.core.instrumentation;

import android.content.Context;
import android.metrics.LogMaker;
import android.text.TextUtils;
import android.util.Pair;
import com.android.internal.logging.MetricsLogger;

/* JADX INFO: loaded from: classes.dex */
public class EventLogWriter implements LogWriter {
    public EventLogWriter() {
    }

    @Override // com.android.settingslib.core.instrumentation.LogWriter
    public void visible(Context r1, int r2, int r3, int r4) {
        MetricsLogger.action(new LogMaker(r3).setType(1).addTaggedData(833, Integer.valueOf(r2)).addTaggedData(1089, Integer.valueOf(r4)));
    }

    @Override // com.android.settingslib.core.instrumentation.LogWriter
    public void hidden(Context r1, int r2, int r3) {
        MetricsLogger.action(new LogMaker(r2).setType(2).addTaggedData(1089, Integer.valueOf(r3)));
    }

    @Override // com.android.settingslib.core.instrumentation.LogWriter
    public void clicked(int r2, String r3) {
        LogMaker r1 = new LogMaker(830).setType(4);
        if (r2 == 0) goto L6;
        r1.addTaggedData(833, Integer.valueOf(r2));
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r1.addTaggedData(854, r3);
    L8:
        MetricsLogger.action(r1);
    }

    @Override // com.android.settingslib.core.instrumentation.LogWriter
    public void changed(int r2, String r3, int r4) {
        LogMaker r1 = new LogMaker(853).setType(4);
        if (r2 == 0) goto L6;
        r1.addTaggedData(833, Integer.valueOf(r2));
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r1.addTaggedData(854, r3);
        r1.addTaggedData(1089, Integer.valueOf(r4));
    L8:
        MetricsLogger.action(r1);
    }

    @Override // com.android.settingslib.core.instrumentation.LogWriter
    public void action(Context r3, int r4, Pair<Integer, Object>... r5) {
        LogMaker r2 = new LogMaker(r4).setType(4);
        if (r5 == null) goto L7;
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L7;
        Pair<Integer, Object> r0 = r5[r7];
        r2.addTaggedData(((Integer) r0.first).intValue(), r0.second);
        r7 = r7 + 1;
    L7:
        MetricsLogger.action(r2);
    }

    @Override // com.android.settingslib.core.instrumentation.LogWriter
    public void action(Context r1, int r2, int r3) {
        MetricsLogger.action(r1, r2, r3);
    }

    @Override // com.android.settingslib.core.instrumentation.LogWriter
    public void action(Context r1, int r2, boolean r3) {
        MetricsLogger.action(r1, r2, r3);
    }

    @Override // com.android.settingslib.core.instrumentation.LogWriter
    public void action(Context r1, int r2, String r3) {
        MetricsLogger.action(new LogMaker(r2).setType(4).setPackageName(r3));
    }

    @Override // com.android.settingslib.core.instrumentation.LogWriter
    public void action(int r1, int r2, int r3, String r4, int r5) {
        LogMaker r0 = new LogMaker(r2).setType(4);
        if (r1 == 0) goto L6;
        r0.addTaggedData(833, Integer.valueOf(r3));
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L8;
        r0.addTaggedData(854, r4);
        r0.addTaggedData(1089, Integer.valueOf(r5));
    L8:
        MetricsLogger.action(r0);
    }
}
