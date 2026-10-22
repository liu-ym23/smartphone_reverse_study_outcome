package com.obric.security.health.ui;

import com.obric.security.health.model.HealthCheckItemSnapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OptimizeCenterUiState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\rHÆ\u0003JW\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\rHÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006%"}, d2 = {"Lcom/obric/security/health/ui/OptimizeCenterUiState;", "", "phase", "Lcom/obric/security/health/ui/OptimizeCenterPhase;", "displayScore", "", "modules", "", "Lcom/obric/security/health/ui/OptimizeModuleUi;", "completedItems", "Lcom/obric/security/health/model/HealthCheckItemSnapshot;", "todoItems", "bottomAction", "", "(Lcom/obric/security/health/ui/OptimizeCenterPhase;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getBottomAction", "()Ljava/lang/String;", "getCompletedItems", "()Ljava/util/List;", "getDisplayScore", "()I", "getModules", "getPhase", "()Lcom/obric/security/health/ui/OptimizeCenterPhase;", "getTodoItems", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OptimizeCenterUiState {
    private final String bottomAction;
    private final List<HealthCheckItemSnapshot> completedItems;
    private final int displayScore;
    private final List<OptimizeModuleUi> modules;
    private final OptimizeCenterPhase phase;
    private final List<HealthCheckItemSnapshot> todoItems;

    public OptimizeCenterUiState() {
        this(null, 0, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OptimizeCenterUiState copy$default(OptimizeCenterUiState r4, OptimizeCenterPhase r5, int r6, List r7, List r8, List r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.phase;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.displayScore;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.modules;
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.completedItems;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.todoItems;
    L17:
        List r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.bottomAction;
    L20:
        OptimizeCenterPhase r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final OptimizeCenterPhase component1() {
        return this.phase;
    }

    public final int component2() {
        return this.displayScore;
    }

    public final List<OptimizeModuleUi> component3() {
        return this.modules;
    }

    public final List<HealthCheckItemSnapshot> component4() {
        return this.completedItems;
    }

    public final List<HealthCheckItemSnapshot> component5() {
        return this.todoItems;
    }

    public final String component6() {
        return this.bottomAction;
    }

    public final OptimizeCenterUiState copy(OptimizeCenterPhase r8, int r9, List<OptimizeModuleUi> r10, List<HealthCheckItemSnapshot> r11, List<HealthCheckItemSnapshot> r12, String r13) {
        Intrinsics.checkNotNullParameter(r8, "phase");
        Intrinsics.checkNotNullParameter(r10, "modules");
        Intrinsics.checkNotNullParameter(r11, "completedItems");
        Intrinsics.checkNotNullParameter(r12, "todoItems");
        Intrinsics.checkNotNullParameter(r13, "bottomAction");
        return new OptimizeCenterUiState(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof OptimizeCenterUiState) == false) goto L18;
        OptimizeCenterUiState r4 = (OptimizeCenterUiState) r3;
        if (Intrinsics.areEqual(this.phase, r4.phase) == true) goto L8;
        return false;
    L8:
        if (this.displayScore == r4.displayScore) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.modules, r4.modules) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.completedItems, r4.completedItems) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.todoItems, r4.todoItems) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bottomAction, r4.bottomAction) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        OptimizeCenterPhase r0 = this.phase;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + Integer.hashCode(this.displayScore)) * 31;
        List<OptimizeModuleUi> r4 = this.modules;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<HealthCheckItemSnapshot> r7 = this.completedItems;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<HealthCheckItemSnapshot> r10 = this.todoItems;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.bottomAction;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "OptimizeCenterUiState(phase=" + this.phase + ", displayScore=" + this.displayScore + ", modules=" + this.modules + ", completedItems=" + this.completedItems + ", todoItems=" + this.todoItems + ", bottomAction=" + this.bottomAction + ")";
    }

    public OptimizeCenterUiState(OptimizeCenterPhase r2, int r3, List<OptimizeModuleUi> r4, List<HealthCheckItemSnapshot> r5, List<HealthCheckItemSnapshot> r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "phase");
        Intrinsics.checkNotNullParameter(r4, "modules");
        Intrinsics.checkNotNullParameter(r5, "completedItems");
        Intrinsics.checkNotNullParameter(r6, "todoItems");
        Intrinsics.checkNotNullParameter(r7, "bottomAction");
        this.phase = r2;
        this.displayScore = r3;
        this.modules = r4;
        this.completedItems = r5;
        this.todoItems = r6;
        this.bottomAction = r7;
    }

    public /* synthetic */ OptimizeCenterUiState(OptimizeCenterPhase r5, int r6, List r7, List r8, List r9, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = OptimizeCenterPhase.OPTIMIZING;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = 0;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = CollectionsKt.emptyList();
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = CollectionsKt.emptyList();
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = CollectionsKt.emptyList();
    L17:
        List r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = "";
    L20:
        OptimizeCenterPhase r14 = r5;
        this(r14, r13, r0, r1, r2, r10);
    }

    public final OptimizeCenterPhase getPhase() {
        return this.phase;
    }

    public final int getDisplayScore() {
        return this.displayScore;
    }

    public final List<OptimizeModuleUi> getModules() {
        return this.modules;
    }

    public final List<HealthCheckItemSnapshot> getCompletedItems() {
        return this.completedItems;
    }

    public final List<HealthCheckItemSnapshot> getTodoItems() {
        return this.todoItems;
    }

    public final String getBottomAction() {
        return this.bottomAction;
    }
}
