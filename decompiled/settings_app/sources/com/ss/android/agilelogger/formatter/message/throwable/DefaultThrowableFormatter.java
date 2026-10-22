package com.ss.android.agilelogger.formatter.message.throwable;

import com.ss.android.agilelogger.utils.StackTraceUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultThrowableFormatter implements ThrowableFormatter {
    public DefaultThrowableFormatter() {
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Throwable r1) {
        return format2(r1);
    }

    /* JADX INFO: renamed from: format, reason: avoid collision after fix types in other method */
    public String format2(Throwable r1) {
        return StackTraceUtils.getStackTraceString(r1);
    }
}
