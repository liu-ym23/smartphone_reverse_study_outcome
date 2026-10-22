package com.obric.apptools.sdk.common;

import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SlardarOsExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\n\u001a\u00020\u000b*\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/apptools/sdk/common/SlardarOsExt;", "", "()V", "CATEGORY_KEY", "", "EVENTNAME_KEY", "EXTRA_KEY", "LOGTYPE_KEY", "METRICS_KEY", "TIMESTAMP_KEY", "constructSlardarParams", "Lorg/json/JSONObject;", "Lcom/obric/apptools/sdk/common/Event;", "tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SlardarOsExt {
    private static final String CATEGORY_KEY = "category";
    private static final String EVENTNAME_KEY = "event_name";
    private static final String EXTRA_KEY = "extra";
    public static final SlardarOsExt INSTANCE = null;
    private static final String LOGTYPE_KEY = "log_type";
    private static final String METRICS_KEY = "metrics";
    private static final String TIMESTAMP_KEY = "client_timestamp";

    static {
        INSTANCE = new SlardarOsExt();
    }

    private SlardarOsExt() {
    }

    public final JSONObject constructSlardarParams(Event r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        JSONObject r3 = new JSONObject();
        r3.put("event_name", r4.getEventName());
        r3.put("client_timestamp", r4.getEndTime());
        r3.put("log_type", "flexible");
        r3.put("category", new JSONObject(MapsKt.toMap(r4.getCategoryParams())));
        r3.put("metrics", new JSONObject(MapsKt.toMap(r4.getMetricsParams())));
        r3.put("extra", new JSONObject(MapsKt.toMap(r4.getExtraParams())));
        return r3;
    }
}
