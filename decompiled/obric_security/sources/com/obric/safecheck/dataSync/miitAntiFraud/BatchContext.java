package com.obric.safecheck.dataSync.miitAntiFraud;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import com.obric.olog.OLog;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.dao.GxbAntiFraudRuleDao;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.securitycenter.api.ApplicationContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BatchContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0013\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/BatchContext;", "", "totalCount", "", "(I)V", "doneCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "pendingDeletes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pendingDeletesLock", ApkVirusCheckProvider.KEY_RESULTS, "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/ItemResult;", "addPendingDelete", "", "ruleNo", "version", SafeCushionConstant.FINISH_STATE, "success", "", "flushPendingDeletes", "obtainVersionRecord", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateVersionRecordSP;", "onBatchDone", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BatchContext {
    public static final Companion Companion = null;
    private static final String TAG = "GxbUpdateBatchContext";
    private final AtomicInteger doneCount;
    private final HashMap<String, String> pendingDeletes;
    private final Object pendingDeletesLock;
    private final List<ItemResult> results;
    private final int totalCount;

    /* JADX INFO: compiled from: BatchContext.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/BatchContext$Companion;", "", "()V", "TAG", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BatchContext(int r2) {
        this.totalCount = r2;
        List<ItemResult> r3 = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(r3, "Collections.synchronizedList(mutableListOf())");
        this.results = r3;
        this.doneCount = new AtomicInteger(0);
        this.pendingDeletes = new HashMap();
        this.pendingDeletesLock = new Object();
    }

    public final void finish(String r3, boolean r4) {
        String r0 = r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        this.results.add(new ItemResult(r3, r4));
    L12:
        if (this.doneCount.incrementAndGet() < this.totalCount) goto L15;
        onBatchDone();
        return;
    L15:
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void addPendingDelete(String r3, String r4) {
        String r0 = r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        Object r2 = this.pendingDeletesLock;
        monitor-enter(r2);
        String r5 = this.pendingDeletes.get(r3);     // Catch: Throwable -> L23
        if (r5 != null) goto L18;
    L19:
        this.pendingDeletes.put(r3, r4);     // Catch: Throwable -> L23
    L20:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r2);
        return;
    L18:
        if (r4.compareTo(r5) <= 0) goto L20;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void onBatchDone() {
        flushPendingDeletes();
        List<ItemResult> r0 = this.results;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.results);     // Catch: Throwable -> L57
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L57
        monitor-exit(r0);
        if (r1.isEmpty() == false) goto L10;
        OLog.d(TAG, "batch done, no valid version to record");
        return;
    L10:
        GxbUpdateVersionRecordSP r8 = obtainVersionRecord();
        if (r8 != null) goto L14;
        OLog.e(TAG, "batch done, version record unavailable, skip");
        return;
    L14:
        ArrayList r3 = r1;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L16:
        if (r5.hasNext() == false) goto L20;
        Object r6 = r5.next();
        if ((!((ItemResult) r6).getSuccess()) == false) goto L16;
        r4.add(r6);
        goto L16
    L20:
        Iterator r7 = r4.iterator();
        String r9 = null;
        if (r7.hasNext() == true) goto L23;
        Object r10 = null;
    L32:
        ItemResult r11 = (ItemResult) r10;
        if (r11 == null) goto L35;
        String r12 = r11.getVersion();
    L36:
        if (r12 == null) goto L39;
        OLog.d(TAG, "batch done, has failure, mark failed version is " + r12);
        r8.updateLatestVersionFailed(r12);
        return;
    L39:
        Iterator r13 = r3.iterator();
        if (r13.hasNext() == true) goto L42;
        Object r14 = null;
    L51:
        ItemResult r15 = (ItemResult) r14;
        if (r15 == null) goto L54;
        r9 = r15.getVersion();
    L54:
        if (r9 == null) goto L71;
        OLog.d(TAG, "batch done, all success, mark success version is " + r9);
        r8.updateLatestVersionSuccess(r9);
        return;
    L71:
        return;
    L42:
        r14 = r13.next();
        if (r13.hasNext() == false) goto L51;
        String r16 = ((ItemResult) r14).getVersion();
    L46:
        Object r17 = r13.next();
        String r18 = ((ItemResult) r17).getVersion();
        if (r16.compareTo(r18) >= 0) goto L50;
        r14 = r17;
        r16 = r18;
    L50:
        if (r13.hasNext() == true) goto L46;
    L35:
        r12 = null;
        goto L36
    L23:
        r10 = r7.next();
        if (r7.hasNext() == false) goto L32;
        String r19 = ((ItemResult) r10).getVersion();
    L27:
        Object r20 = r7.next();
        String r21 = ((ItemResult) r20).getVersion();
        if (r19.compareTo(r21) <= 0) goto L31;
        r10 = r20;
        r19 = r21;
    L31:
        if (r7.hasNext() == true) goto L27;
    L57:
        th = move-exception;
        throw th;
    }

    private final void flushPendingDeletes() {
        Object r0 = this.pendingDeletesLock;
        monitor-enter(r0);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.pendingDeletes.isEmpty() == false) goto L9;
        OLog.d(TAG, "flushPendingDeletes, empty, skip");     // Catch: Throwable -> L31
        monitor-exit(r0);
        return;
    L9:
        HashMap r1 = new HashMap(this.pendingDeletes);     // Catch: Throwable -> L31
        this.pendingDeletes.clear();     // Catch: Throwable -> L31
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r0);
        Context r10 = ApplicationContainer.INSTANCE.getApplication();
        if (r10 != null) goto L34;
        OLog.e(TAG, "flushPendingDeletes, application context null, skip, size=" + r1.size());
        return;
    L34:
        GxbAntiFraudRuleDao r11 = AntiFraudDatabase.getDatabase(r10).gxbAntiFraudRuleDao();     // Catch: Throwable -> L28
        OLog.d(TAG, "flushPendingDeletes start, size=" + r1.size());
        Iterator r2 = r1.entrySet().iterator();
        int r3 = 0;
        int r4 = 0;
    L18:
        if (r2.hasNext() == false) goto L26;
        Map.Entry r5 = (Map.Entry) r2.next();
        String r6 = (String) r5.getKey();
        String r7 = (String) r5.getValue();
        if (r11.deleteByRuleNoIfVersionLE(r6, r7) > 0) goto L22;
        r4 = r4 + 1;
        goto L18
    L22:
        r3 = r3 + 1;
    L24:
        th = move-exception;
        OLog.e(TAG, "flushPendingDeletes, delete failed, ruleNo=" + r6 + ", delVersion=" + r7, th);
        goto L18
    L26:
        OLog.d(TAG, "flushPendingDeletes end, deleted=" + r3 + ", skipped=" + r4);
        return;
    L28:
        th = move-exception;
        OLog.e(TAG, "flushPendingDeletes, obtain dao failed", th);
    }

    private final GxbUpdateVersionRecordSP obtainVersionRecord() {
        Context r1 = ApplicationContainer.INSTANCE.getApplication();
        if (r1 != null) goto L7;
        return null;
    L7:
        return new GxbUpdateVersionRecordSP(r1);
    }
}
