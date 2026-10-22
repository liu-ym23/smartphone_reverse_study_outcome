package com.obric.matrix.platform.sdk.ones.safecushion.repair;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseRepair.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u001c\u001a\u00020\u001d2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020\u001dH\u0000¢\u0006\u0002\b J\u001c\u0010!\u001a\u00020\u001d2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/BaseRepair;", "Ljava/lang/Runnable;", "alias", "", "(Ljava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "crashCount", "", "getCrashCount", "()I", "crashMsg", "getCrashMsg", "currentCrashCount", "currentCrashMsg", "repairHandler", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionRepairHandler;", "getRepairHandler$sdk_platform_ones_release", "()Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionRepairHandler;", "setRepairHandler$sdk_platform_ones_release", "(Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionRepairHandler;)V", "repairResult", "Lkotlin/Pair;", "", "getRepairResult", "()Lkotlin/Pair;", "setRepairResult", "(Lkotlin/Pair;)V", "bindExecutionContext", "", "bindExecutionContext$sdk_platform_ones_release", "clearExecutionContext", "clearExecutionContext$sdk_platform_ones_release", "repairFinish", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseRepair implements Runnable {
    private final String alias;
    private int currentCrashCount;
    private String currentCrashMsg;
    private SafeCushionRepairHandler repairHandler;
    private Pair<Boolean, String> repairResult;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseRepair() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BaseRepair(String r2) {
        Intrinsics.checkNotNullParameter(r2, "alias");
        this.alias = r2;
    }

    public /* synthetic */ BaseRepair(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final Pair<Boolean, String> getRepairResult() {
        return this.repairResult;
    }

    public final void setRepairResult(Pair<Boolean, String> r1) {
        this.repairResult = r1;
    }

    public final SafeCushionRepairHandler getRepairHandler$sdk_platform_ones_release() {
        return this.repairHandler;
    }

    public final void setRepairHandler$sdk_platform_ones_release(SafeCushionRepairHandler r1) {
        this.repairHandler = r1;
    }

    protected final String getCrashMsg() {
        return this.currentCrashMsg;
    }

    protected final int getCrashCount() {
        return this.currentCrashCount;
    }

    public final void bindExecutionContext$sdk_platform_ones_release(SafeCushionRepairHandler r1, String r2, int r3) {
        this.repairHandler = r1;
        this.currentCrashMsg = r2;
        this.currentCrashCount = r3;
        this.repairResult = null;
    }

    public final void clearExecutionContext$sdk_platform_ones_release() {
        this.repairHandler = null;
        this.currentCrashMsg = null;
        this.currentCrashCount = 0;
        this.repairResult = null;
    }

    public final void repairFinish(Pair<Boolean, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "repairResult");
        this.repairResult = r2;
        SafeCushionRepairHandler r3 = this.repairHandler;
        if (r3 == null) goto L6;
        r3.repairFinish(this);
        return;
    }
}
