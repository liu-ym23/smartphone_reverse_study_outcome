package com.bytedanceos.security.debug.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SettingsMockStore.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedanceos/security/debug/settings/SettingsMockStore;", "", "()V", "KEY_CONFIG", "", "KEY_ENABLED_CLASSES", "PREF_NAME", "clear", "", "context", "Landroid/content/Context;", "load", "Lcom/bytedanceos/security/debug/settings/SettingsMockStore$State;", "save", "state", "State", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingsMockStore {
    public static final SettingsMockStore INSTANCE = null;
    private static final String KEY_CONFIG = "mock_config";
    private static final String KEY_ENABLED_CLASSES = "enabled_classes";
    private static final String PREF_NAME = "pm_settings_mock";

    /* JADX INFO: compiled from: SettingsMockStore.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedanceos/security/debug/settings/SettingsMockStore$State;", "", "mockConfig", "Lcom/google/gson/JsonObject;", "enabledClassNames", "", "", "(Lcom/google/gson/JsonObject;Ljava/util/Set;)V", "getEnabledClassNames", "()Ljava/util/Set;", "getMockConfig", "()Lcom/google/gson/JsonObject;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class State {
        private final Set<String> enabledClassNames;
        private final JsonObject mockConfig;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State r0, JsonObject r1, Set r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.mockConfig;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.enabledClassNames;
        L9:
            return r0.copy(r1, r2);
        }

        public final JsonObject component1() {
            return this.mockConfig;
        }

        public final Set<String> component2() {
            return this.enabledClassNames;
        }

        public final State copy(JsonObject r1, Set<String> r2) {
            Intrinsics.checkNotNullParameter(r1, "mockConfig");
            Intrinsics.checkNotNullParameter(r2, "enabledClassNames");
            return new State(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof State) == false) goto L10;
            State r4 = (State) r3;
            if (Intrinsics.areEqual(this.mockConfig, r4.mockConfig) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.enabledClassNames, r4.enabledClassNames) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            JsonObject r0 = this.mockConfig;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Set<String> r4 = this.enabledClassNames;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "State(mockConfig=" + this.mockConfig + ", enabledClassNames=" + this.enabledClassNames + ")";
        }

        public State(JsonObject r2, Set<String> r3) {
            Intrinsics.checkNotNullParameter(r2, "mockConfig");
            Intrinsics.checkNotNullParameter(r3, "enabledClassNames");
            this.mockConfig = r2;
            this.enabledClassNames = r3;
        }

        public final JsonObject getMockConfig() {
            return this.mockConfig;
        }

        public final Set<String> getEnabledClassNames() {
            return this.enabledClassNames;
        }
    }

    static {
        INSTANCE = new SettingsMockStore();
    }

    private SettingsMockStore() {
    }

    public final State load(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        SharedPreferences r3 = r4.getSharedPreferences(PREF_NAME, 0);
        Set r0 = null;
        String r5 = r3.getString(KEY_CONFIG, null);
        if (r5 == null) goto L21;
        Intrinsics.checkNotNullExpressionValue(r5, "it");
        if ((!StringsKt.isBlank(r5)) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L21;
        Intrinsics.checkNotNullExpressionValue(r5, "sp.getString(KEY_CONFIG,…tBlank() } ?: return null");
        JsonElement r6 = JsonParser.parseString(r5);     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r6, "element");     // Catch: Throwable -> L22
        if (r6.isJsonObject() == false) goto L21;
        JsonObject r7 = r6.getAsJsonObject();     // Catch: Throwable -> L22
        Set<String> r8 = r3.getStringSet(KEY_ENABLED_CLASSES, SetsKt.emptySet());
        if (r8 == null) goto L17;
        r0 = CollectionsKt.toSet(r8);
    L17:
        if (r0 != null) goto L19;
        r0 = SetsKt.emptySet();
    L19:
        Intrinsics.checkNotNullExpressionValue(r7, "config");
        return new State(r7, r0);
    L21:
        return null;
    }

    public final void save(Context r2, State r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "state");
        r2.getSharedPreferences(PREF_NAME, 0).edit().putString(KEY_CONFIG, r3.getMockConfig().toString()).putStringSet(KEY_ENABLED_CLASSES, CollectionsKt.toSet(r3.getEnabledClassNames())).apply();
    }

    public final void clear(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        r2.getSharedPreferences(PREF_NAME, 0).edit().clear().apply();
    }
}
