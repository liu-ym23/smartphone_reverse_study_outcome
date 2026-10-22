package com.ss.android.agilelogger.formatter.message.object;

import android.os.Bundle;
import com.ss.android.agilelogger.utils.ObjectToStringUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BundleFormatter implements ObjectFormatter<Bundle> {
    public BundleFormatter() {
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Object r1) {
        return format((Bundle) r1);
    }

    public String format(Bundle r1) {
        return ObjectToStringUtils.bundleToString(r1);
    }
}
