package com.ss.android.agilelogger.formatter.stacktrace;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultStackTraceFormatter implements StackTraceFormatter {
    public DefaultStackTraceFormatter() {
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(StackTraceElement[] r1) {
        return format2(r1);
    }

    /* JADX INFO: renamed from: format, reason: avoid collision after fix types in other method */
    public String format2(StackTraceElement[] r5) {
        StringBuilder r4 = new StringBuilder(256);
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.length == 0) goto L28;
        int r1 = 0;
        if (r5.length == 1) goto L10;
        int r0 = r5.length;
    L12:
        if (r1 >= r0) goto L22;
        if (r1 != 0) goto L17;
        r4.append("\n");
    L17:
        if (r1 == (r0 - 1)) goto L19;
        r4.append("\t├ ");
        r4.append(r5[r1].toString());
        r4.append("\n");
    L20:
        r1 = r1 + 1;
        goto L12
    L19:
        r4.append("\t└ ");
        r4.append(r5[r1].toString());
        goto L20
    L22:
        return r4.toString();
    L10:
        return "\t─ " + r5[0].toString();
    L28:
        return null;
    }
}
