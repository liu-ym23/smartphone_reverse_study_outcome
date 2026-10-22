package com.ss.android.agilelogger.utils;

import android.content.Intent;
import android.os.Bundle;
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

/* JADX INFO: loaded from: classes2.dex */
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

        static {
            TYPE r0 = new TYPE("MSG", 0);
            MSG = r0;
            TYPE r1 = new TYPE("JSON", 1);
            JSON = r1;
            TYPE r2 = new TYPE("BUNDLE", 2);
            BUNDLE = r2;
            TYPE r3 = new TYPE("INTENT", 3);
            INTENT = r3;
            TYPE r4 = new TYPE("THROWABLE", 4);
            THROWABLE = r4;
            TYPE r5 = new TYPE("BORDER", 5);
            BORDER = r5;
            TYPE r6 = new TYPE("STACKTRACE", 6);
            STACKTRACE = r6;
            TYPE r7 = new TYPE("THREAD", 7);
            THREAD = r7;
            TYPE r8 = new TYPE("STACKTRACE_STR", 8);
            STACKTRACE_STR = r8;
            $VALUES = new TYPE[]{r0, r1, r2, r3, r4, r5, r6, r7, r8};
        }

        private TYPE(String r1, int r2) {
            super(r1, r2);
        }

        public static TYPE valueOf(String r1) {
            return (TYPE) Enum.valueOf(TYPE.class, r1);
        }

        public static TYPE[] values() {
            return (TYPE[]) $VALUES.clone();
        }
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

    public FormatUtils() {
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
