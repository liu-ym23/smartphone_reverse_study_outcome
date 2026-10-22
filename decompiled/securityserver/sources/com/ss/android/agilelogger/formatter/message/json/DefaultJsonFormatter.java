package com.ss.android.agilelogger.formatter.message.json;

import com.ss.android.agilelogger.formatter.FormatException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultJsonFormatter implements JsonFormatter {
    private static final int JSON_INDENT = 4;

    public DefaultJsonFormatter() {
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(String r1) {
        return format2(r1);
    }

    /* JADX INFO: renamed from: format, reason: avoid collision after fix types in other method */
    public String format2(String r3) {
        if (r3 == null) goto L20;
        if (r3.trim().length() == 0) goto L20;
    L9:
        e = move-exception;
        throw new FormatException("Parse JSON error. JSON string:".concat(r3), e);
    L7:
        if (r3.startsWith("{") == false) goto L12;
        return new JSONObject(r3).toString(4);
    L12:
        if (r3.startsWith("[") == false) goto L16;
        return new JSONArray(r3).toString(4);
    L16:
        throw new FormatException("JSON should start with { or [, but found ".concat(r3));     // Catch: Exception -> L9
    L20:
        throw new FormatException("JSON empty.");
    }
}
