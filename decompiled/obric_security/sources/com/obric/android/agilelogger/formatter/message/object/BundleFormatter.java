package com.obric.android.agilelogger.formatter.message.object;

import android.os.Bundle;
import com.obric.android.agilelogger.utils.ObjectToStringUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BundleFormatter implements ObjectFormatter<Bundle> {
    public BundleFormatter() {
    }

    @Override // com.obric.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Object r1) {
        return format((Bundle) r1);
    }

    public String format(Bundle r1) {
        return ObjectToStringUtils.bundleToString(r1);
    }
}
