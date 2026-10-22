package com.ss.android.agilelogger.formatter.message.object;

import android.content.Intent;
import com.ss.android.agilelogger.utils.ObjectToStringUtils;

/* JADX INFO: loaded from: classes5.dex */
public class IntentFormatter implements ObjectFormatter<Intent> {
    public IntentFormatter() {
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Object r1) {
        return format((Intent) r1);
    }

    public String format(Intent r1) {
        return ObjectToStringUtils.intentToString(r1);
    }
}
