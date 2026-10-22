package com.obric.securitycenter.api.settings;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.obric.securitycenter.api.TrackUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/securitycenter/api/settings/SettingsValueProvider;", "", "settingsConfig", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;)V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "containsKey", "", "key", "", "get", "Lcom/google/gson/JsonElement;", "getSettingsConfig", "stableArray", "Lcom/google/gson/JsonArray;", "src", "stableObject", "stableSerialize", "obj", "stableValue", "element", "updateSettingsConfig", "", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SettingsValueProvider {
    private final Lazy gson$delegate;
    private volatile JsonObject settingsConfig;

    public SettingsValueProvider(JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "settingsConfig");
        this.gson$delegate = LazyKt.lazy(SettingsValueProvider$gson$2.INSTANCE);
        updateSettingsConfig(r2);
    }

    private final Gson getGson() {
        return (Gson) this.gson$delegate.getValue();
    }

    public final synchronized void updateSettingsConfig(JsonObject r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "settingsConfig");     // Catch: Throwable -> L18
        String r1 = null;
        JsonObject r2 = null;
        if (this.settingsConfig == null) goto L10;
        JsonObject r0 = this.settingsConfig;     // Catch: Throwable -> L18
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("settingsConfig");     // Catch: Throwable -> L18
    L9:
        r1 = stableSerialize(r2);     // Catch: Throwable -> L18
        goto L10
    L8:
        r2 = r0;
    L10:
        String r3 = stableSerialize(r5);     // Catch: Throwable -> L18
        if (r1 != null) goto L13;
    L14:
        TrackUtils.INSTANCE.trackEvent("security_settings_update", MapsKt.mapOf(TuplesKt.to("settings", r3)), true);     // Catch: Throwable -> L18
    L15:
        this.settingsConfig = r5;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L13:
        if (Intrinsics.areEqual(r1, r3) == true) goto L15;
    L18:
        th = move-exception;
        throw th;
    }

    public final JsonObject getSettingsConfig() {
        JsonObject r0 = this.settingsConfig;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("settingsConfig");
        return null;
    L6:
        return r0;
    }

    public final boolean containsKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        JsonObject r1 = this.settingsConfig;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("settingsConfig");
        r1 = null;
    L6:
        return r1.has(r2);
    }

    public final JsonElement get(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        JsonObject r1 = this.settingsConfig;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("settingsConfig");
        r1 = null;
    L6:
        return r1.get(r2);
    }

    private final String stableSerialize(JsonObject r2) {
        String r1 = getGson().toJson(stableObject(r2));
        Intrinsics.checkNotNullExpressionValue(r1, "gson.toJson(stableObject(obj))");
        return r1;
    }

    private final JsonObject stableObject(JsonObject r5) {
        JsonObject r0 = new JsonObject();
        Set<String> r1 = r5.keySet();
        Intrinsics.checkNotNullExpressionValue(r1, "src.keySet()");
        List r2 = CollectionsKt.toMutableList(r1);
        CollectionsKt.sort(r2);
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        String r4 = (String) r3.next();
        r0.add(r4, stableValue(r5.get(r4)));
        goto L4
    L6:
        return r0;
    }

    private final JsonArray stableArray(JsonArray r3) {
        JsonArray r0 = new JsonArray();
        Iterator<JsonElement> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(stableValue(r4.next()));
        goto L4
    L6:
        return r0;
    }

    private final JsonElement stableValue(JsonElement r2) {
        if (r2 != null) goto L4;
    L15:
        JsonNull r1 = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r1, "INSTANCE");
        return r1;
    L4:
        if (r2.isJsonNull() == true) goto L15;
        if (r2.isJsonObject() == false) goto L11;
        JsonObject r3 = r2.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r3, "element.asJsonObject");
        return stableObject(r3);
    L11:
        if (r2.isJsonArray() == false) goto L14;
        JsonArray r4 = r2.getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue(r4, "element.asJsonArray");
        return stableArray(r4);
    L14:
        return r2;
    }
}
