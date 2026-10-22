package com.obric.matrix.platform.sdk.ones.safecushion.repair;

import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.sdk.ones.safecushion.util.SafeCushionFileUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeCushionRepairHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\r2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000RE\u0010\u0007\u001a-\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionRepairHandler;", "", "()V", "allRepairSuccess", "", "repairMsg", "", "repairResultListener", "Lkotlin/Function1;", "Lkotlin/Pair;", "Lkotlin/ParameterName;", "name", "result", "", "getRepairResultListener", "()Lkotlin/jvm/functions/Function1;", "setRepairResultListener", "(Lkotlin/jvm/functions/Function1;)V", "repairRunnableList", "Ljava/util/LinkedList;", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/BaseRepair;", "allRepairFinish", "repair", "repairFinish", "baseRepair", "startRepair", "repairList", "", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SafeCushionRepairHandler {
    public static final Companion Companion = null;
    private static final String TAG = "SafeCushionRepair";
    private boolean allRepairSuccess;
    private String repairMsg;
    private Function1<? super Pair<Boolean, String>, Unit> repairResultListener;
    private final LinkedList<BaseRepair> repairRunnableList;

    /* JADX INFO: compiled from: SafeCushionRepairHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionRepairHandler$Companion;", "", "()V", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$478v3PkbuZMvvxtW6AihTRMSwgk(BaseRepair r0) {
        m185repair$lambda3(r0);
    }

    public static /* synthetic */ void $r8$lambda$fRzgnaZXX417J5G1DBYvKF4gxbA(SafeCushionRepairHandler r0) {
        m184allRepairFinish$lambda4(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public SafeCushionRepairHandler() {
        this.repairRunnableList = new LinkedList();
        this.allRepairSuccess = true;
    }

    public final Function1<Pair<Boolean, String>, Unit> getRepairResultListener() {
        return this.repairResultListener;
    }

    public final void setRepairResultListener(Function1<? super Pair<Boolean, String>, Unit> r1) {
        this.repairResultListener = r1;
    }

    public final void startRepair(List<? extends BaseRepair> r6) {
        Iterator<T> r0 = this.repairRunnableList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BaseRepair) r0.next()).clearExecutionContext$sdk_platform_ones_release();
        goto L4
    L6:
        this.repairRunnableList.clear();
        boolean r1 = true;
        this.allRepairSuccess = true;
        this.repairMsg = null;
        String r2 = SafeCushionFileUtils.INSTANCE.getCrashMsg();
        int r3 = SafeCushionFileUtils.INSTANCE.getCrashCount();
        List<? extends BaseRepair> r4 = r6;
        if (r4 != null) goto L9;
    L12:
        if (r1 == true) goto L18;
        Iterator<T> r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        ((BaseRepair) r7.next()).bindExecutionContext$sdk_platform_ones_release(this, r2, r3);
        goto L15
    L17:
        this.repairRunnableList.addAll(r4);
    L18:
        repair();
        return;
    L9:
        if (r4.isEmpty() == true) goto L12;
        r1 = false;
        goto L12
    }

    private final void repair() {
        if (this.repairRunnableList.isEmpty() == false) goto L6;
        allRepairFinish();
        return;
    L6:
        final BaseRepair r0 = this.repairRunnableList.peekFirst();
        if (r0 != null) goto L10;
        allRepairFinish();
        return;
    L10:
        SafeCushionThreadExecutor.INSTANCE.executeOnIO(new SafeCushionRepairHandler$$ExternalSyntheticLambda1(r0));
    }

    /* JADX INFO: renamed from: repair$lambda-3, reason: not valid java name */
    private static final void m185repair$lambda3(BaseRepair r4) {
        Intrinsics.checkNotNullParameter(r4, "$runnable");
        r4.run();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e(TAG, "repair: error", e);
        if (r4.getRepairHandler$sdk_platform_ones_release() == null) goto L15;
        String r0 = e.getMessage();
        if (r0 != null) goto L11;
        r0 = "repair exception";
    L11:
        r4.repairFinish(TuplesKt.to(false, r0));
        return;
    }

    public final void repairFinish(BaseRepair r5) {
        Intrinsics.checkNotNullParameter(r5, "baseRepair");
        Pair<Boolean, String> r0 = r5.getRepairResult();
        boolean r1 = true;
        if (r0 == null) goto L5;
        boolean r2 = r0.getFirst().booleanValue();
    L6:
        this.allRepairSuccess &= r2;
        if (r2 == true) goto L22;
        String r3 = null;
        if (r0 == null) goto L11;
        String r4 = r0.getSecond();
    L12:
        String r6 = r4;
        if (r6 != null) goto L15;
    L18:
        if (r1 == true) goto L22;
        if (r0 == null) goto L21;
        r3 = r0.getSecond();
    L21:
        this.repairMsg = r3;
        goto L22
    L15:
        if (r6.length() == 0) goto L18;
        r1 = false;
        goto L18
    L11:
        r4 = null;
    L22:
        this.repairRunnableList.remove(r5);
        r5.clearExecutionContext$sdk_platform_ones_release();
        repair();
        return;
    L5:
        r2 = true;
        goto L6
    }

    private final void allRepairFinish() {
        SafeCushionThreadExecutor.INSTANCE.runOnMain(new SafeCushionRepairHandler$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: allRepairFinish$lambda-4, reason: not valid java name */
    private static final void m184allRepairFinish$lambda4(SafeCushionRepairHandler r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Function1<? super Pair<Boolean, String>, Unit> r0 = r2.repairResultListener;
        if (r0 == null) goto L6;
        r0.invoke(TuplesKt.to(Boolean.valueOf(r2.allRepairSuccess), r2.repairMsg));
        return;
    }
}
