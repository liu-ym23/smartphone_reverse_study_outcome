package com.bytedance.perf.monitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class AnrEntryManager {
    public static long FOUND_DURATION = 600000;
    public static int MAX_ANR_SIZE = 3;
    public static int MAX_QUEUE_SIZE = 10;
    public static LinkedBlockingQueue<AnrEntry> mAnrEntries;

    static {
        mAnrEntries = new LinkedBlockingQueue(MAX_QUEUE_SIZE);
    }

    public AnrEntryManager() {
    }

    private static boolean checkIsSafe(AnrEntry r1) {
        LinkedBlockingQueue<AnrEntry> r0 = mAnrEntries;
        if (r0 != null) goto L5;
    L6:
        if (r1 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L8;
        goto L6
    }

    public static void clear() {
        mAnrEntries.clear();
    }

    public static String getCostTop2Stack(AnrEntry r4) {
        if (checkIsSafe(r4) == false) goto L7;
        return r4.stack;
    L7:
        if (r4 != null) goto L9;
        String r5 = "";
    L10:
        StringBuilder r0 = new StringBuilder(r5);
        ArrayList r6 = new ArrayList();
        Iterator<AnrEntry> r1 = mAnrEntries.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        AnrEntry r2 = r1.next();
        if (r2 == null) goto L12;
        r6.add(r2);
        goto L12
    L16:
        Collections.sort(r6);
        int r3 = Math.min(MAX_ANR_SIZE, r6.size());
        int r7 = 0;
    L18:
        if (r7 >= (r3 - 1)) goto L24;
        if (r6.get(r7) == null) goto L22;
        r0.append("\n");
        r0.append(((AnrEntry) r6.get(r7)).stack);
    L22:
        r7 = r7 + 1;
        goto L18
    L24:
        return r0.toString();
    L9:
        r5 = r4.stack;
        goto L10
    }

    public static void putAnr(AnrEntry r2) {
        if (mAnrEntries != null) goto L14;
        mAnrEntries = new LinkedBlockingQueue(MAX_QUEUE_SIZE);
    L14:
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (mAnrEntries.size() != MAX_QUEUE_SIZE) goto L10;
        mAnrEntries.take();     // Catch: InterruptedException -> L8
    L10:
        mAnrEntries.put(r2);     // Catch: InterruptedException -> L8
    }
}
