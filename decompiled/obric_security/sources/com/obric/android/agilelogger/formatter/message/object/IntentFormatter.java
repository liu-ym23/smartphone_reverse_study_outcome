package com.obric.android.agilelogger.formatter.message.object;

import android.content.Intent;
import com.obric.android.agilelogger.utils.ObjectToStringUtils;

/* JADX INFO: loaded from: classes2.dex */
public class IntentFormatter implements ObjectFormatter<Intent> {
    public IntentFormatter() {
    }

    @Override // com.obric.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Object r1) {
        return format((Intent) r1);
    }

    public String format(Intent r1) {
        return ObjectToStringUtils.intentToString(r1);
    }
}
