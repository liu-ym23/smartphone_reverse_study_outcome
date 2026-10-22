package com.bytedance.tracing.core;

import com.bytedance.apm.util.ListUtils;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class TraceWrapper {
    private static final String TAG = "test_trace";
    private static final ThreadLocal<LinkedList<String>> sThreadTraceName = null;
    private static final ThreadLocal<LinkedList<Span>> sThreadTraceSpan = null;

    public static final class TraceContext {
        String mTraceName;
        Span mTraceSpan;

        TraceContext(Span r1, String r2) {
            this.mTraceSpan = r1;
            this.mTraceName = r2;
        }
    }

    public TraceWrapper() {
    }

    static {
        sThreadTraceSpan = new ThreadLocal();
        sThreadTraceName = new ThreadLocal();
    }

    public static void startTrace(String r2) {
        ThreadLocal<LinkedList<String>> r0 = sThreadTraceName;
        LinkedList<String> r1 = r0.get();
        if (r1 != null) goto L5;
        r1 = new LinkedList();
        r0.set(r1);
    L5:
        r1.push(r2);
    }

    public static void endTrace() {
        LinkedList<String> r0 = sThreadTraceName.get();
        if (ListUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        r0.pop();
    }

    public static TraceContext getFrozenContext() {
        LinkedList<Span> r0 = sThreadTraceSpan.get();
        LinkedList<String> r1 = sThreadTraceName.get();
        if (ListUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        if (ListUtils.isEmpty(r1) == false) goto L8;
        return null;
    L8:
        return new TraceContext(r0.peek(), r1.peek());
    }

    public static void applyTraceContext(TraceContext r5) {
        ThreadLocal<LinkedList<Span>> r0 = sThreadTraceSpan;
        LinkedList<Span> r1 = r0.get();
        ThreadLocal<LinkedList<String>> r2 = sThreadTraceName;
        LinkedList<String> r3 = r2.get();
        if (ListUtils.isEmpty(r1) == true) goto L5;
        r1.clear();
    L8:
        if (ListUtils.isEmpty(r3) == true) goto L10;
        r3.clear();
    L12:
        r1.push(r5.mTraceSpan);
        r3.push(r5.mTraceName);
        return;
    L10:
        if (r3 != null) goto L12;
        r3 = new LinkedList();
        r2.set(r3);
        goto L12
    L5:
        if (r1 != null) goto L8;
        r1 = new LinkedList();
        r0.set(r1);
        goto L8
    }

    public static void clearTraceContext() {
        LinkedList<Span> r0 = sThreadTraceSpan.get();
        LinkedList<String> r1 = sThreadTraceName.get();
        if (ListUtils.isEmpty(r0) == true) goto L7;
        r0.clear();
    L7:
        if (ListUtils.isEmpty(r1) == true) goto L11;
        r1.clear();
        return;
    }

    public static void beginSectionCurrentThread(String r6) {
        ThreadLocal<LinkedList<Span>> r0 = sThreadTraceSpan;
        LinkedList<Span> r1 = r0.get();
        LinkedList<String> r2 = sThreadTraceName.get();
        if (r1 != null) goto L8;
        if (r2 != null) goto L6;
        return;
    L6:
        r1 = new LinkedList();
        r0.set(r1);
    L8:
        if (r1.isEmpty() == true) goto L10;
        Span r3 = r1.peek();
        if (r3.getFinishTs() <= 0) goto L20;
        r1.pop();
        Span r4 = r1.peek();
        if (r4 != null) goto L19;
        r1.push(r3.makeChild(r6).start());
        return;
    L19:
        r1.push(r4.makeChildAndRef(r6, r3.getSpanId()).start());
        return;
    L20:
        r1.push(r3.makeChild(r6).start());
        return;
    L10:
        if (r2 == null) goto L12;
        String r5 = r2.peek();
    L13:
        r1.push(new Span(r5, r6).start());
        return;
    L12:
        r5 = null;
        goto L13
    }

    public static void endSectionCurrentThread() {
        LinkedList<Span> r0 = sThreadTraceSpan.get();
        if (ListUtils.isEmpty(r0) == true) goto L13;
        Span r1 = r0.peek();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getFinishTs() <= 0) goto L11;
        r1 = r0.pop();
    L11:
        r1.getFinishTs();
        r1.finish();
        return;
    }

    public static void addTraceTag(String r2, String r3) {
        LinkedList<Span> r0 = sThreadTraceSpan.get();
        if (ListUtils.isEmpty(r0) == true) goto L10;
        Span r1 = r0.peek();
        if (r1 == null) goto L9;
        r1.addTag(r2, r3);
        return;
    L9:
        return;
    }

    public static void addErrTag(String r1) {
        addTraceTag("error", r1);
    }

    public static void addTraceLog(String r2, Map<String, String> r3) {
        LinkedList<Span> r0 = sThreadTraceSpan.get();
        if (ListUtils.isEmpty(r0) == true) goto L10;
        Span r1 = r0.peek();
        if (r1 == null) goto L9;
        r1.addLog(r2, r3);
        return;
    L9:
        return;
    }

    public static void addTraceLog(String r2) {
        LinkedList<Span> r0 = sThreadTraceSpan.get();
        if (ListUtils.isEmpty(r0) == true) goto L10;
        Span r1 = r0.peek();
        if (r1 == null) goto L9;
        r1.addLog(r2);
        return;
    L9:
        return;
    }

    private static String stringMulti(String r2, int r3) {
        StringBuilder r0 = new StringBuilder(r2.length() * r3);
    L3:
        if (r3 <= 0) goto L6;
        r0.append(r2);
        r3 = r3 - 1;
        goto L3
    L6:
        return r0.toString();
    }
}
