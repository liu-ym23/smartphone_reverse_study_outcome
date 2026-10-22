package com.obric.matrix.platform.sdk.ones.safecushion;

import com.obric.matrix.platform.sdk.ones.safecushion.repair.BaseRepair;
import com.obric.matrix.platform.sdk.ones.safecushion.ui.SafeCushionUiProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixCushionConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001$Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010#\u001a\u00020\u0005R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u0006%"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig;", "", "pkgName", "", "versionCode", "", "versionName", "isBoe", "", "crashThreshold", "crashCountDebounceEnabled", "foregroundCheckEnabled", "repairRules", "", "", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/BaseRepair;", "targetClassName", "uiProvider", "Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionUiProvider;", "(Ljava/lang/String;ILjava/lang/String;ZIZZLjava/util/Map;Ljava/lang/String;Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionUiProvider;)V", "getCrashCountDebounceEnabled", "()Z", "getCrashThreshold", "()I", "getForegroundCheckEnabled", "getPkgName", "()Ljava/lang/String;", "getRepairRules", "()Ljava/util/Map;", "getTargetClassName", "getUiProvider", "()Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionUiProvider;", "getVersionCode", "getVersionName", "getRepairsForCrashCount", "crashCount", "Builder", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixCushionConfig {
    private final boolean crashCountDebounceEnabled;
    private final int crashThreshold;
    private final boolean foregroundCheckEnabled;
    private final boolean isBoe;
    private final String pkgName;
    private final Map<Integer, List<BaseRepair>> repairRules;
    private final String targetClassName;
    private final SafeCushionUiProvider uiProvider;
    private final int versionCode;
    private final String versionName;

    /* JADX INFO: compiled from: MatrixCushionConfig.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0017\"\u00020\u000e¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig$Builder;", "", "()V", "crashCountDebounceEnabled", "", "crashThreshold", "", "foregroundCheckEnabled", "isBoe", "pkgName", "", "repairRules", "", "", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/BaseRepair;", "targetClassName", "uiProvider", "Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionUiProvider;", "versionCode", "versionName", "addRepairRule", "crashCount", "repairs", "", "(I[Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/BaseRepair;)Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig$Builder;", "build", "Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig;", "setCrashCountDebounceEnabled", "setCrashThreshold", "setForegroundCheckEnabled", "setIsBoe", "setPackageName", "setTargetClassName", "setUiProvider", "setVersionCode", "setVersionName", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private boolean crashCountDebounceEnabled;
        private int crashThreshold;
        private boolean foregroundCheckEnabled;
        private boolean isBoe;
        private String pkgName;
        private final Map<Integer, List<BaseRepair>> repairRules;
        private String targetClassName;
        private SafeCushionUiProvider uiProvider;
        private int versionCode;
        private String versionName;

        public Builder() {
            this.pkgName = "";
            this.versionName = "";
            this.crashThreshold = 5;
            this.crashCountDebounceEnabled = true;
            this.foregroundCheckEnabled = true;
            this.repairRules = new LinkedHashMap();
            this.targetClassName = "";
        }

        public final Builder setPackageName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "pkgName");
            this.pkgName = r2;
            return this;
        }

        public final Builder setCrashThreshold(int r1) {
            this.crashThreshold = r1;
            return this;
        }

        public final Builder setCrashCountDebounceEnabled(boolean r1) {
            this.crashCountDebounceEnabled = r1;
            return this;
        }

        public final Builder setForegroundCheckEnabled(boolean r1) {
            this.foregroundCheckEnabled = r1;
            return this;
        }

        public final Builder setVersionCode(int r1) {
            this.versionCode = r1;
            return this;
        }

        public final Builder setVersionName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "versionName");
            this.versionName = r2;
            return this;
        }

        public final Builder setIsBoe(boolean r1) {
            this.isBoe = r1;
            return this;
        }

        public final Builder addRepairRule(int r3, BaseRepair... r4) {
            Intrinsics.checkNotNullParameter(r4, "repairs");
            Map<Integer, List<BaseRepair>> r0 = this.repairRules;
            Integer r5 = Integer.valueOf(r3);
            ArrayList r1 = r0.get(r5);
            if (r1 != null) goto L5;
            r1 = new ArrayList();
            r0.put(r5, r1);
        L5:
            CollectionsKt.addAll(r1, r4);
            return this;
        }

        public final Builder setTargetClassName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "targetClassName");
            this.targetClassName = r2;
            return this;
        }

        public final Builder setUiProvider(SafeCushionUiProvider r2) {
            Intrinsics.checkNotNullParameter(r2, "uiProvider");
            this.uiProvider = r2;
            return this;
        }

        public final MatrixCushionConfig build() {
            String r1 = this.pkgName;
            int r2 = this.versionCode;
            String r3 = this.versionName;
            boolean r4 = this.isBoe;
            int r5 = this.crashThreshold;
            boolean r6 = this.crashCountDebounceEnabled;
            boolean r7 = this.foregroundCheckEnabled;
            Map<Integer, List<BaseRepair>> r0 = this.repairRules;
            LinkedHashMap r8 = new LinkedHashMap(MapsKt.mapCapacity(r0.size()));
            Iterator<T> r9 = r0.entrySet().iterator();
        L4:
            if (r9.hasNext() == false) goto L7;
            Map.Entry r10 = (Map.Entry) r9.next();
            r8.put(r10.getKey(), CollectionsKt.toList((Iterable) r10.getValue()));
            goto L4
        L7:
            return new MatrixCushionConfig(r1, r2, r3, r4, r5, r6, r7, r8, this.targetClassName, this.uiProvider, null);
        }
    }

    public /* synthetic */ MatrixCushionConfig(String r1, int r2, String r3, boolean r4, int r5, boolean r6, boolean r7, Map r8, String r9, SafeCushionUiProvider r10, DefaultConstructorMarker r11) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MatrixCushionConfig(String r1, int r2, String r3, boolean r4, int r5, boolean r6, boolean r7, Map<Integer, ? extends List<? extends BaseRepair>> r8, String r9, SafeCushionUiProvider r10) {
        this.pkgName = r1;
        this.versionCode = r2;
        this.versionName = r3;
        this.isBoe = r4;
        this.crashThreshold = r5;
        this.crashCountDebounceEnabled = r6;
        this.foregroundCheckEnabled = r7;
        this.repairRules = r8;
        this.targetClassName = r9;
        this.uiProvider = r10;
    }

    /* synthetic */ MatrixCushionConfig(String r13, int r14, String r15, boolean r16, int r17, boolean r18, boolean r19, Map r20, String r21, SafeCushionUiProvider r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r23 & 32) == 0) goto L9;
        boolean r7 = true;
    L11:
        if ((r23 & 64) == 0) goto L13;
        boolean r8 = true;
    L14:
        this(r13, r14, r15, r5, r17, r7, r8, r20, r21, r22);
        return;
    L13:
        r8 = r19;
        goto L14
    L9:
        r7 = r18;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final boolean isBoe() {
        return this.isBoe;
    }

    public final int getCrashThreshold() {
        return this.crashThreshold;
    }

    public final boolean getCrashCountDebounceEnabled() {
        return this.crashCountDebounceEnabled;
    }

    public final boolean getForegroundCheckEnabled() {
        return this.foregroundCheckEnabled;
    }

    public final Map<Integer, List<BaseRepair>> getRepairRules() {
        return this.repairRules;
    }

    public final String getTargetClassName() {
        return this.targetClassName;
    }

    public final SafeCushionUiProvider getUiProvider() {
        return this.uiProvider;
    }

    public final List<BaseRepair> getRepairsForCrashCount(int r4) {
        Set<Map.Entry<Integer, List<BaseRepair>>> r3 = this.repairRules.entrySet();
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Object r1 = r5.next();
        if (((Number) ((Map.Entry) r1).getKey()).intValue() > r4) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r2 = false;
        goto L9
    L11:
        List r6 = CollectionsKt.sortedWith(r0, new MatrixCushionConfig$getRepairsForCrashCount$$inlined$sortedBy$1());
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L13:
        if (r8.hasNext() == false) goto L16;
        CollectionsKt.addAll(r7, (List) ((Map.Entry) r8.next()).getValue());
        goto L13
    L16:
        return r7;
    }
}
