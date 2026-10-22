package com.bytedance.apm6.java_alloc;

import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.services.apm.api.EnsureManager;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class JavaAllocReporter {
    private static final Charset US_ASCII = null;
    private final ReportInfoReader reportInfoReader;

    /* JADX INFO: renamed from: com.bytedance.apm6.java_alloc.JavaAllocReporter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class AllocThrowable extends Throwable {
        private final StackTraceElement[] elements;
        private final String msg;

        public AllocThrowable(String r1, StackTraceElement[] r2) {
            this.msg = r1;
            this.elements = r2;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            monitor-exit(this);
            return this;
        }

        @Override // java.lang.Throwable
        public StackTraceElement[] getStackTrace() {
            return this.elements;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return this.msg;
        }
    }

    public static class ReportInfoReader implements IRecordReader {
        private JavaAllocConfig currentConfig;
        private long endTime;
        private String scene;
        private long startTime;
        private final ReportTraceReader traceReader;

        public ReportInfoReader() {
            this.traceReader = new ReportTraceReader(null);
        }

        @Override // com.bytedance.apm6.java_alloc.IRecordReader
        public void onHeadInfo(String r1, long r2, long r4, int r6, JavaAllocConfig r7, long r8, long r10) {
            this.currentConfig = r7;
            this.startTime = r8;
            this.endTime = r10;
            this.scene = r1;
            if (ApmContext.isDebugMode() == false) goto L6;
            Logger.d("JavaAllocReporter", "report totalObjectsCount: " + r2 + ", totalBytes: " + r4 + ", recordCount: " + r6);
            return;
        }

        @Override // com.bytedance.apm6.java_alloc.IRecordReader
        public boolean onItem(String r7, int r8, int r9, Trace r10, int r11) {
            r10.onTrace(this.traceReader);
            if (ReportTraceReader.access$100(this.traceReader).size() <= 0) goto L5;
            reportCustom(r7, r8, r9, ReportTraceReader.access$100(this.traceReader), r11);
        L5:
            this.traceReader.clear();
            return true;
        }

        void reportCustom(String r3, int r4, int r5, List<StackTraceElement> r6, int r7) {
            StackTraceElement[] r8 = (StackTraceElement[]) r6.toArray(new StackTraceElement[0]);
            if (r7 != 1) goto L5;
            String r9 = "HighFrequency";
        L6:
            AllocThrowable r0 = new AllocThrowable("java_alloc(" + r9 + ") class: " + r3, r8);
            if (ApmContext.isDebugMode() == false) goto L9;
            Logger.d("JavaAllocReporter", "report class: " + r3 + ", java_alloc count: " + r4 + ", bytes: " + r5 + ", trace: " + ReportTraceReader.access$200(this.traceReader).toString());
        L9:
            HashMap r10 = new HashMap();
            r10.put("java_alloc_count", String.valueOf(r4));
            r10.put("java_alloc_size", String.valueOf(r5));
            r10.put("java_alloc_sample", String.valueOf(this.currentConfig.collect_per_thousand_alloc));
            r10.put("java_alloc_count_threshold", String.valueOf(this.currentConfig.threshold_alloc_frequency));
            r10.put("java_alloc_size_threshold", String.valueOf(this.currentConfig.threshold_alloc_size));
            r10.put("java_alloc_duration", String.valueOf(this.endTime - this.startTime));
            r10.put("java_alloc_scene", this.scene);
            EnsureManager.ensureNotReachHere(r0, "java_alloc", r10);
            return;
        L5:
            r9 = "LargeObject";
            goto L6
        }
    }

    private static class ReportTraceReader implements ITraceReader {
        private final char[] charArrayBuffer;
        private final List<StackTraceElement> elements;
        private final StringBuilder result;

        private ReportTraceReader() {
            this.elements = new ArrayList();
            this.result = new StringBuilder();
            this.charArrayBuffer = new char[4096];
        }

        /* synthetic */ ReportTraceReader(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ List access$100(ReportTraceReader r0) {
            return r0.elements;
        }

        static /* synthetic */ StringBuilder access$200(ReportTraceReader r0) {
            return r0.result;
        }

        @Override // com.bytedance.apm6.java_alloc.ITraceReader
        public boolean onItem(byte[] r4, int r5, byte[] r6, int r7, int r8) {
            if (ApmContext.isDebugMode() == false) goto L5;
            this.result.append("  at ").append(JavaAllocReporter.convertAscii(r4, this.charArrayBuffer, r5), 0, r5).append('(').append(JavaAllocReporter.convertAscii(r6, this.charArrayBuffer, r7), 0, r7).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r8).append(")\n");
        L5:
            String r9 = String.valueOf(JavaAllocReporter.convertAscii(r4, this.charArrayBuffer, r5), 0, r5);
            String r10 = String.valueOf(JavaAllocReporter.convertAscii(r6, this.charArrayBuffer, r7), 0, r7);
            int r11 = r9.lastIndexOf(46);
            this.elements.add(new StackTraceElement(r9.substring(0, r11), r9.substring(r11 + 1, r5), r10, r8));
            return true;
        }

        public void clear() {
            this.elements.clear();
            this.result.setLength(0);
        }
    }

    public JavaAllocReporter() {
        this.reportInfoReader = new ReportInfoReader();
    }

    static {
        US_ASCII = StandardCharsets.US_ASCII;
    }

    static char[] convertAscii(byte[] r2, char[] r3, int r4) {
        int r1 = 0;
        if (r4 <= r3.length) goto L8;
        int r5 = r4 - r3.length;
    L6:
        if (r1 >= r3.length) goto L10;
        r3[r1] = (char) (r2[r1 + r5] & 255);
        r1 = r1 + 1;
    L10:
        return r3;
    L8:
        if (r1 >= r4) goto L10;
        r3[r1] = (char) (r2[r1] & 255);
        r1 = r1 + 1;
        goto L8
    }

    public void report() {
        JavaAllocCollector.getInstance().getReportInfo(this.reportInfoReader);
    }
}
