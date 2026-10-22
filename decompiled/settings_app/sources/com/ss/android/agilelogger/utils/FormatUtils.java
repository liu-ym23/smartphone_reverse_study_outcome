package com.ss.android.agilelogger.utils;

import android.content.Intent;
import android.os.Bundle;
import com.android.vcard.VCardConstants;
import com.ss.android.agilelogger.formatter.Formatter;
import com.ss.android.agilelogger.formatter.border.DefaultBorderFormatter;
import com.ss.android.agilelogger.formatter.message.DefaultDateFormatter;
import com.ss.android.agilelogger.formatter.message.json.DefaultJsonFormatter;
import com.ss.android.agilelogger.formatter.message.object.BundleFormatter;
import com.ss.android.agilelogger.formatter.message.object.IntentFormatter;
import com.ss.android.agilelogger.formatter.message.throwable.DefaultThrowableFormatter;
import com.ss.android.agilelogger.formatter.stacktrace.DefaultStackTraceFormatter;
import com.ss.android.agilelogger.formatter.thread.DefaultThreadFormatter;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class FormatUtils {
    private static ConcurrentHashMap<TYPE, Formatter> formatterHashMap;

    public static final enum TYPE extends Enum<TYPE> {
        private static final /* synthetic */ TYPE[] $VALUES = null;
        public static final TYPE BORDER = null;
        public static final TYPE BUNDLE = null;
        public static final TYPE INTENT = null;
        public static final TYPE JSON = null;
        public static final TYPE MSG = null;
        public static final TYPE STACKTRACE = null;
        public static final TYPE STACKTRACE_STR = null;
        public static final TYPE THREAD = null;
        public static final TYPE THROWABLE = null;

        private TYPE(String r1, int r2) {
            super(r1, r2);
        }

        public static TYPE valueOf(String r1) {
            return (TYPE) Enum.valueOf(TYPE.class, r1);
        }

        public static TYPE[] values() {
            return (TYPE[]) $VALUES.clone();
        }

        static {
            TYPE r0 = new TYPE(VCardConstants.PARAM_TYPE_MSG, 0);
            MSG = r0;
            TYPE r1 = new TYPE("JSON", 1);
            JSON = r1;
            TYPE r3 = new TYPE("BUNDLE", 2);
            BUNDLE = r3;
            TYPE r5 = new TYPE("INTENT", 3);
            INTENT = r5;
            TYPE r7 = new TYPE("THROWABLE", 4);
            THROWABLE = r7;
            TYPE r9 = new TYPE("BORDER", 5);
            BORDER = r9;
            TYPE r11 = new TYPE("STACKTRACE", 6);
            STACKTRACE = r11;
            TYPE r13 = new TYPE("THREAD", 7);
            THREAD = r13;
            TYPE r15 = new TYPE("STACKTRACE_STR", 8);
            STACKTRACE_STR = r15;
            $VALUES = new TYPE[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }
    }

    public FormatUtils() {
    }

    static {
        ConcurrentHashMap<TYPE, Formatter> r0 = new ConcurrentHashMap();
        formatterHashMap = r0;
        r0.put(TYPE.MSG, new DefaultDateFormatter());
        formatterHashMap.put(TYPE.JSON, new DefaultJsonFormatter());
        formatterHashMap.put(TYPE.BUNDLE, new BundleFormatter());
        formatterHashMap.put(TYPE.INTENT, new IntentFormatter());
        formatterHashMap.put(TYPE.BORDER, new DefaultBorderFormatter());
        formatterHashMap.put(TYPE.STACKTRACE, new DefaultStackTraceFormatter());
        formatterHashMap.put(TYPE.THREAD, new DefaultThreadFormatter());
        formatterHashMap.put(TYPE.THROWABLE, new DefaultThrowableFormatter());
    }

    public static String format(TYPE r2, String r3) {
        Formatter r0 = formatterHashMap.get(r2);
        if (r0 != null) goto L5;
        return r3;
    L5:
        if (r2 != TYPE.BORDER) goto L9;
        return r0.format(new String[]{r3});
    L9:
        return r0.format(r3);
    }

    public static String format(TYPE r1, StackTraceElement[] r2) {
        return formatterHashMap.get(r1).format(r2);
    }

    public static String format(TYPE r1, Bundle r2) {
        return ((BundleFormatter) formatterHashMap.get(r1)).format(r2);
    }

    public static String format(TYPE r1, Intent r2) {
        return ((IntentFormatter) formatterHashMap.get(r1)).format(r2);
    }

    public static String format(TYPE r1, Throwable r2) {
        return formatterHashMap.get(r1).format(r2);
    }

    public static String format(TYPE r1, Thread r2) {
        return formatterHashMap.get(r1).format(r2);
    }
}
