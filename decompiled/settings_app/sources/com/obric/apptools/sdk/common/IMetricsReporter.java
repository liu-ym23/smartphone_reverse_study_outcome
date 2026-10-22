package com.obric.apptools.sdk.common;

import android.content.Context;
import com.obric.olog.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppMetrics.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/obric/apptools/sdk/common/IMetricsReporter;", "", "init", "", "context", "Landroid/content/Context;", Constants.REPORT_FIELD, "event", "Lcom/obric/apptools/sdk/common/Event;", "tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IMetricsReporter {
    void init(Context r1);

    void report(Event r1);
}
