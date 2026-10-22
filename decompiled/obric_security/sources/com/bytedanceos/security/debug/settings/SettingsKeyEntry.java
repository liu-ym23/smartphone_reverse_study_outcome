package com.bytedanceos.security.debug.settings;

import com.obric.securitycenter.api.settings.IScope;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsKeyAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry;", "", "()V", "ChildEntry", "ScopeEntry", "Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry$ChildEntry;", "Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry$ScopeEntry;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SettingsKeyEntry {

    /* JADX INFO: compiled from: SettingsKeyAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\r\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001b\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry$ChildEntry;", "Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry;", "settingsClass", "Ljava/lang/Class;", "settingsKeyValue", "", "titleValue", "moduleScopeClass", "Lcom/obric/securitycenter/api/settings/IScope;", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V", "getModuleScopeClass", "()Ljava/lang/Class;", "getSettingsClass", "getSettingsKeyValue", "()Ljava/lang/String;", "getTitleValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChildEntry extends SettingsKeyEntry {
        private final Class<? extends IScope> moduleScopeClass;
        private final Class<?> settingsClass;
        private final String settingsKeyValue;
        private final String titleValue;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChildEntry copy$default(ChildEntry r0, Class r1, String r2, String r3, Class r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.settingsClass;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.settingsKeyValue;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.titleValue;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.moduleScopeClass;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final Class<?> component1() {
            return this.settingsClass;
        }

        public final String component2() {
            return this.settingsKeyValue;
        }

        public final String component3() {
            return this.titleValue;
        }

        public final Class<? extends IScope> component4() {
            return this.moduleScopeClass;
        }

        public final ChildEntry copy(Class<?> r1, String r2, String r3, Class<? extends IScope> r4) {
            Intrinsics.checkNotNullParameter(r1, "settingsClass");
            Intrinsics.checkNotNullParameter(r2, "settingsKeyValue");
            Intrinsics.checkNotNullParameter(r3, "titleValue");
            return new ChildEntry(r1, r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ChildEntry) == false) goto L14;
            ChildEntry r4 = (ChildEntry) r3;
            if (Intrinsics.areEqual(this.settingsClass, r4.settingsClass) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.settingsKeyValue, r4.settingsKeyValue) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.titleValue, r4.titleValue) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.moduleScopeClass, r4.moduleScopeClass) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            Class<?> r0 = this.settingsClass;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.settingsKeyValue;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.titleValue;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Class<? extends IScope> r10 = this.moduleScopeClass;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
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
            return "ChildEntry(settingsClass=" + this.settingsClass + ", settingsKeyValue=" + this.settingsKeyValue + ", titleValue=" + this.titleValue + ", moduleScopeClass=" + this.moduleScopeClass + ")";
        }

        public final Class<?> getSettingsClass() {
            return this.settingsClass;
        }

        public final String getSettingsKeyValue() {
            return this.settingsKeyValue;
        }

        public final String getTitleValue() {
            return this.titleValue;
        }

        public final Class<? extends IScope> getModuleScopeClass() {
            return this.moduleScopeClass;
        }

        public ChildEntry(Class<?> r2, String r3, String r4, Class<? extends IScope> r5) {
            Intrinsics.checkNotNullParameter(r2, "settingsClass");
            Intrinsics.checkNotNullParameter(r3, "settingsKeyValue");
            Intrinsics.checkNotNullParameter(r4, "titleValue");
            super(null);
            this.settingsClass = r2;
            this.settingsKeyValue = r3;
            this.titleValue = r4;
            this.moduleScopeClass = r5;
        }
    }

    /* JADX INFO: compiled from: SettingsKeyAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry$ScopeEntry;", "Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry;", "scopeClass", "Ljava/lang/Class;", "Lcom/obric/securitycenter/api/settings/IScope;", "settingsKeyValue", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "getScopeClass", "()Ljava/lang/Class;", "getSettingsKeyValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ScopeEntry extends SettingsKeyEntry {
        private final Class<? extends IScope> scopeClass;
        private final String settingsKeyValue;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ScopeEntry copy$default(ScopeEntry r0, Class r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.scopeClass;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.settingsKeyValue;
        L9:
            return r0.copy(r1, r2);
        }

        public final Class<? extends IScope> component1() {
            return this.scopeClass;
        }

        public final String component2() {
            return this.settingsKeyValue;
        }

        public final ScopeEntry copy(Class<? extends IScope> r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "scopeClass");
            Intrinsics.checkNotNullParameter(r2, "settingsKeyValue");
            return new ScopeEntry(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ScopeEntry) == false) goto L10;
            ScopeEntry r4 = (ScopeEntry) r3;
            if (Intrinsics.areEqual(this.scopeClass, r4.scopeClass) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.settingsKeyValue, r4.settingsKeyValue) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            Class<? extends IScope> r0 = this.scopeClass;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.settingsKeyValue;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "ScopeEntry(scopeClass=" + this.scopeClass + ", settingsKeyValue=" + this.settingsKeyValue + ")";
        }

        public final Class<? extends IScope> getScopeClass() {
            return this.scopeClass;
        }

        public final String getSettingsKeyValue() {
            return this.settingsKeyValue;
        }

        public ScopeEntry(Class<? extends IScope> r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "scopeClass");
            Intrinsics.checkNotNullParameter(r3, "settingsKeyValue");
            super(null);
            this.scopeClass = r2;
            this.settingsKeyValue = r3;
        }
    }

    private SettingsKeyEntry() {
    }

    public /* synthetic */ SettingsKeyEntry(DefaultConstructorMarker r1) {
        this();
    }
}
