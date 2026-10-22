package com.obric.safecheck.dataSync.miitAntiFraud;

import com.obric.olog.OLog;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GxbRiskAppCache.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007J-\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbRiskAppCache;", "", "()V", "MAX_SIZE", "", "TAG", "", "cache", "Ljava/util/LinkedHashMap;", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbRiskAppItem;", "lock", "clear", "", "contains", "", "packageName", "get", "put", "ruleType", "ruleNo", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "snapshot", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbRiskAppCache {
    public static final GxbRiskAppCache INSTANCE = null;
    private static final int MAX_SIZE = 10;
    private static final String TAG = "GxbRiskAppCache";
    private static final LinkedHashMap<String, GxbRiskAppItem> cache = null;
    private static final Object lock = null;

    @JvmStatic
    public static final void put(String r2, Integer r3) {
        put$default(r2, r3, null, 4, null);
    }

    static {
        INSTANCE = new GxbRiskAppCache();
        lock = new Object();
        cache = new LinkedHashMap(10, 0.75f, false);
    }

    private GxbRiskAppCache() {
    }

    public static /* synthetic */ void put$default(String r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
        String r5 = (String) null;
    L5:
        put(r0, r1, r2);
    }

    @JvmStatic
    public static final void put(String r10, Integer r11, String r12) {
        String r2 = r10;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return;
    L11:
        GxbRiskAppItem r4 = new GxbRiskAppItem(r10, r11, r12);
        Object r5 = lock;
        monitor-enter(r5);
        LinkedHashMap<String, GxbRiskAppItem> r6 = cache;     // Catch: Throwable -> L25
        r6.remove(r10);     // Catch: Throwable -> L25
        r6.put(r10, r4);     // Catch: Throwable -> L25
        if (r6.size() <= 10) goto L22;
        String r7 = r6.keySet().iterator().next();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r7, "cache.keys.iterator().next()");     // Catch: Throwable -> L25
        String r8 = r7;     // Catch: Throwable -> L25
        GxbRiskAppItem r9 = r6.remove(r8);     // Catch: Throwable -> L25
        String r13 = null;
        if (r9 == null) goto L18;
        Integer r14 = r9.getRuleType();     // Catch: Throwable -> L25
    L19:
        if (r9 == null) goto L21;
        r13 = r9.getRuleNo();     // Catch: Throwable -> L25
    L21:
        OLog.d(TAG, "evict eldest, pkg=" + r8 + ", ruleType=" + r14 + ", ruleNo=" + r13 + ", size=" + r6.size());     // Catch: Throwable -> L25
        goto L22
    L18:
        r14 = null;
    L22:
        OLog.d(TAG, "put, pkg=" + r10 + ", ruleType=" + r11 + ", ruleNo=" + r12 + ", size=" + r6.size());     // Catch: Throwable -> L25
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r5);
        return;
    L25:
        th = move-exception;
        throw th;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r3 = false;
        goto L9
    }

    @JvmStatic
    public static final GxbRiskAppItem get(String r2) {
        String r0 = r2;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return null;
    L12:
        Object r3 = lock;
        monitor-enter(r3);
        GxbRiskAppItem r4 = cache.get(r2);     // Catch: Throwable -> L17
        monitor-exit(r3);
        return r4;
    L17:
        th = move-exception;
        throw th;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean contains(String r2) {
        String r0 = r2;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        Object r3 = lock;
        monitor-enter(r3);
        boolean r4 = cache.containsKey(r2);     // Catch: Throwable -> L16
        monitor-exit(r3);
        return r4;
    L16:
        th = move-exception;
        throw th;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final List<GxbRiskAppItem> snapshot() {
        Object r0 = lock;
        monitor-enter(r0);
        Collection<GxbRiskAppItem> r1 = cache.values();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r1, "cache.values");     // Catch: Throwable -> L7
        List<GxbRiskAppItem> r2 = CollectionsKt.toList(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void clear() {
        Object r0 = lock;
        monitor-enter(r0);
        cache.clear();     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        OLog.d(TAG, "clear all");
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
