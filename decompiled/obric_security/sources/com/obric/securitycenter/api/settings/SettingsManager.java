package com.obric.securitycenter.api.settings;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.tracing.internal.TracingConstants;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SettingsManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0002J!\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0002¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0007J\u0014\u0010!\u001a\u0004\u0018\u00010 2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bJ\u001e\u0010!\u001a\u0004\u0018\u00010 2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020$H\u0007J\u0016\u0010%\u001a\u0004\u0018\u00010\u00012\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0002J!\u0010&\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0007¢\u0006\u0002\u0010\u001eJ!\u0010&\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030'H\u0007¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020\u00172\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J$\u0010.\u001a\u00020/2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020 H\u0007J\u001c\u00102\u001a\u00020/2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u00103\u001a\u00020\u0017H\u0007J\u0016\u00104\u001a\u00020/2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000406H\u0007J\u0010\u00107\u001a\u00020/2\u0006\u00100\u001a\u00020$H\u0007J\u0012\u00108\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010$H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/securitycenter/api/settings/SettingsManager;", "", "()V", "MOCK_KEY_CONFIG", "", "MOCK_KEY_ENABLED_CLASSES", "MOCK_PREF_NAME", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "mMockValueProviderLazy", "Lcom/obric/securitycenter/api/settings/SettingsValueProvider;", "getMMockValueProviderLazy", "()Lcom/obric/securitycenter/api/settings/SettingsValueProvider;", "mMockValueProviderLazy$delegate", "mSettingsValueProviderLazy", "getMSettingsValueProviderLazy", "mSettingsValueProviderLazy$delegate", "mockEnabledClassNames", "Ljava/util/concurrent/ConcurrentHashMap;", "", "findValueField", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "getCustomTypeDefaultValue", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Class;)Ljava/lang/Object;", "getEffectiveJsonValue", "Lcom/google/gson/JsonElement;", "getJsonValue", "provider", "getMockSettingsConfig", "Lcom/google/gson/JsonObject;", "getValue", "getValueSafely", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "isMockEnabled", "loadStoredMockState", "Lcom/obric/securitycenter/api/settings/SettingsManager$StoredMockState;", "context", "Landroid/content/Context;", "putJsonValue", "", "settingsConfig", "value", "setMockEnabled", "enabled", "setMockEnabledClassNames", "classNames", "", "updateMockSettingsConfig", "updateSettingsConfig", "StoredMockState", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SettingsManager {
    public static final SettingsManager INSTANCE = null;
    private static final String MOCK_KEY_CONFIG = "mock_config";
    private static final String MOCK_KEY_ENABLED_CLASSES = "enabled_classes";
    private static final String MOCK_PREF_NAME = "pm_settings_mock";
    private static final Lazy gson$delegate = null;
    private static final Lazy mMockValueProviderLazy$delegate = null;
    private static final Lazy mSettingsValueProviderLazy$delegate = null;
    private static final ConcurrentHashMap<String, Boolean> mockEnabledClassNames = null;

    /* JADX INFO: compiled from: SettingsManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/securitycenter/api/settings/SettingsManager$StoredMockState;", "", "mockConfig", "Lcom/google/gson/JsonObject;", "enabledClassNames", "", "", "(Lcom/google/gson/JsonObject;Ljava/util/Set;)V", "getEnabledClassNames", "()Ljava/util/Set;", "getMockConfig", "()Lcom/google/gson/JsonObject;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class StoredMockState {
        private final Set<String> enabledClassNames;
        private final JsonObject mockConfig;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoredMockState copy$default(StoredMockState r0, JsonObject r1, Set r2, int r3, Object r4) {
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

        public final StoredMockState copy(JsonObject r1, Set<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "enabledClassNames");
            return new StoredMockState(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof StoredMockState) == true) goto L8;
            return false;
        L8:
            StoredMockState r6 = (StoredMockState) r5;
            if (Intrinsics.areEqual(this.mockConfig, r6.mockConfig) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.enabledClassNames, r6.enabledClassNames) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            JsonObject r0 = this.mockConfig;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.enabledClassNames.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "StoredMockState(mockConfig=" + this.mockConfig + ", enabledClassNames=" + this.enabledClassNames + ")";
        }

        public StoredMockState(JsonObject r2, Set<String> r3) {
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

    private SettingsManager() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMockEnabledClassNames$p() {
        return mockEnabledClassNames;
    }

    public static final /* synthetic */ StoredMockState access$loadStoredMockState(SettingsManager r0, Context r1) {
        return r0.loadStoredMockState(r1);
    }

    static {
        INSTANCE = new SettingsManager();
        mSettingsValueProviderLazy$delegate = LazyKt.lazy(SettingsManager$mSettingsValueProviderLazy$2.INSTANCE);
        gson$delegate = LazyKt.lazy(SettingsManager$gson$2.INSTANCE);
        mMockValueProviderLazy$delegate = LazyKt.lazy(SettingsManager$mMockValueProviderLazy$2.INSTANCE);
        mockEnabledClassNames = new ConcurrentHashMap();
    }

    private final SettingsValueProvider getMSettingsValueProviderLazy() {
        return (SettingsValueProvider) mSettingsValueProviderLazy$delegate.getValue();
    }

    private final Gson getGson() {
        return (Gson) gson$delegate.getValue();
    }

    private final SettingsValueProvider getMMockValueProviderLazy() {
        return (SettingsValueProvider) mMockValueProviderLazy$delegate.getValue();
    }

    private final StoredMockState loadStoredMockState(Context r3) {
        SharedPreferences r2 = r3.getApplicationContext().getSharedPreferences(MOCK_PREF_NAME, 0);
        Set<String> r4 = r2.getStringSet(MOCK_KEY_ENABLED_CLASSES, SetsKt.emptySet());
        JsonObject r0 = null;
        if (r4 == null) goto L5;
        Set r5 = CollectionsKt.toSet(r4);
    L6:
        if (r5 != null) goto L8;
        r5 = SetsKt.emptySet();
    L8:
        String r6 = r2.getString(MOCK_KEY_CONFIG, null);
        if (r6 != null) goto L11;
    L13:
        r6 = null;
    L14:
        if (r6 != null) goto L23;
        JsonObject r7 = (JsonObject) null;
    L22:
        return new StoredMockState(r0, r5);
    L23:
        JsonElement r8 = JsonParser.parseString(r6);     // Catch: Throwable -> L20
        if (r8.isJsonObject() == false) goto L22;
        r0 = r8.getAsJsonObject();     // Catch: Throwable -> L20
    L20:
        JsonObject r9 = (JsonObject) null;
        goto L22
    L11:
        if ((!StringsKt.isBlank(r6)) == false) goto L13;
    L5:
        r5 = null;
        goto L6
    }

    @JvmStatic
    public static final <T> T getValueSafely(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        SettingsManager r1 = INSTANCE;     // Catch: Throwable -> L14
        Object r2 = r1.getValue(r5);     // Catch: Throwable -> L14
        if (r2 != null) goto L16;
        SettingsKey r3 = (SettingsKey) r5.getAnnotation(SettingsKey.class);     // Catch: Throwable -> L14
        if (r3 == null) goto L8;
        String r4 = r3.value();     // Catch: Throwable -> L14
    L9:
        if (r4 != null) goto L11;
    L12:
        r2 = r1.getCustomTypeDefaultValue(r5);     // Catch: Throwable -> L14
        goto L16
    L11:
        if (r1.getMSettingsValueProviderLazy().containsKey(r4) == true) goto L16;
    L8:
        r4 = null;
    L16:
        if (r2 != null) goto L19;
        return null;
    L19:
        return (T) r2;
    L14:
        th = move-exception;
        th.printStackTrace();
        r2 = INSTANCE.getCustomTypeDefaultValue(r5);
        goto L16
    }

    @JvmStatic
    public static final <T> T getValueSafely(KClass<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        return (T) getValueSafely(JvmClassMappingKt.getJavaClass(r1));
    }

    @JvmStatic
    public static final void updateSettingsConfig(JsonObject r1) {
        SettingsValueProvider r0 = INSTANCE.getMSettingsValueProviderLazy();
        if (r1 != null) goto L5;
        r1 = new JsonObject();
    L5:
        r0.updateSettingsConfig(r1);
    }

    @JvmStatic
    public static final void updateMockSettingsConfig(JsonObject r1) {
        Intrinsics.checkNotNullParameter(r1, "settingsConfig");
        INSTANCE.getMMockValueProviderLazy().updateSettingsConfig(r1);
    }

    @JvmStatic
    public static final JsonObject getMockSettingsConfig() {
        return INSTANCE.getMMockValueProviderLazy().getSettingsConfig();
    }

    @JvmStatic
    public static final void setMockEnabled(Class<?> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        if (r2 == false) goto L5;
        ConcurrentHashMap<String, Boolean> r3 = mockEnabledClassNames;
        String r4 = r1.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "clazz.name");
        r3.put(r4, true);
        return;
    L5:
        mockEnabledClassNames.remove(r1.getName());
    }

    @JvmStatic
    public static final void setMockEnabledClassNames(Set<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "classNames");
        mockEnabledClassNames.clear();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        String r0 = (String) r4.next();
        mockEnabledClassNames.put(r0, true);
        goto L4
    }

    @JvmStatic
    public static final boolean isMockEnabled(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        return Intrinsics.areEqual(mockEnabledClassNames.get(r1.getName()), true);
    }

    @JvmStatic
    public static final JsonElement getEffectiveJsonValue(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        SettingsManager r0 = INSTANCE;
        if (isMockEnabled(r2) == false) goto L8;
        JsonElement r1 = r0.getJsonValue(r2, r0.getMMockValueProviderLazy());
        if (r1 == null) goto L8;
        return r1;
    L8:
        return r0.getJsonValue(r2, r0.getMSettingsValueProviderLazy());
    }

    @JvmStatic
    public static final void putJsonValue(Class<?> r3, JsonObject r4, JsonElement r5) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "settingsConfig");
        Intrinsics.checkNotNullParameter(r5, "value");
        SettingsKey r0 = (SettingsKey) r3.getAnnotation(SettingsKey.class);
        if (r0 == null) goto L33;
        String r1 = r0.value();
        if (r1 == null) goto L34;
        Scope r6 = (Scope) r3.getAnnotation(Scope.class);
        if (r6 == null) goto L14;
        Class<? extends IScope> r7 = r6.module();
        if (r7 == null) goto L14;
        SettingsKey r8 = (SettingsKey) r7.getAnnotation(SettingsKey.class);
        if (r8 == null) goto L14;
        String r9 = r8.value();
    L15:
        String r2 = r9;
        if (r2 != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == false) goto L25;
        r4.add(r1, r5);
        return;
    L25:
        JsonElement r11 = r4.get(r9);
        if (r11 != null) goto L28;
    L30:
        JsonObject r12 = new JsonObject();
        r4.add(r9, r12);
        JsonObject r13 = r12;
    L31:
        r13.add(r1, r5);
        return;
    L28:
        if (r11.isJsonObject() == false) goto L30;
        r13 = r11.getAsJsonObject();
        goto L31
    L18:
        if (r2.length() == 0) goto L21;
        r10 = false;
    L14:
        r9 = null;
        goto L15
    L34:
        return;
    }

    public final JsonElement getJsonValue(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return getJsonValue(r2, getMSettingsValueProviderLazy());
    }

    private final JsonElement getJsonValue(Class<?> r3, SettingsValueProvider r4) {
        SettingsKey r2 = (SettingsKey) r3.getAnnotation(SettingsKey.class);
        if (r2 == null) goto L37;
        String r5 = r2.value();
        if (r5 == null) goto L37;
        Scope r6 = (Scope) r3.getAnnotation(Scope.class);
        if (r6 == null) goto L14;
        Class<? extends IScope> r7 = r6.module();
        if (r7 == null) goto L14;
        SettingsKey r8 = (SettingsKey) r7.getAnnotation(SettingsKey.class);
        if (r8 == null) goto L14;
        String r9 = r8.value();
    L15:
        String r1 = r9;
        if (r1 != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == false) goto L24;
        JsonElement r11 = r4.get(r5);
    L31:
        if (r11 != null) goto L34;
        return null;
    L34:
        if (r11.isJsonNull() == false) goto L36;
        return null;
    L36:
        return r11;
    L24:
        JsonElement r12 = r4.get(r9);
        if (r12 != null) goto L28;
        return null;
    L28:
        if (r12.isJsonObject() == true) goto L30;
        return null;
    L30:
        r11 = r12.getAsJsonObject().get(r5);
        goto L31
    L18:
        if (r1.length() == 0) goto L21;
        r10 = false;
    L14:
        r9 = null;
    L37:
        return null;
    }

    private final Object getValue(Class<?> r4) {
        Field r0 = findValueField(r4);
        if (r0 == null) goto L5;
        Type r1 = r0.getGenericType();
    L6:
        if (r1 != null) goto L9;
        return null;
    L9:
        if (isMockEnabled(r4) == false) goto L14;
        JsonElement r2 = getJsonValue(r4, getMMockValueProviderLazy());
        if (r2 == null) goto L14;
        return getGson().fromJson(r2, r1);
    L14:
        JsonElement r5 = getJsonValue(r4, getMSettingsValueProviderLazy());
        if (r5 != null) goto L18;
        return null;
    L18:
        return getGson().fromJson(r5, r1);
    L5:
        r1 = null;
        goto L6
    }

    private final <T> T getCustomTypeDefaultValue(Class<?> r9) {
        Field[] r8 = r9.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r8, TracingConstants.KEY_FIELDS);
        if (r8.length != 0) goto L5;
        boolean r10 = true;
    L7:
        if ((!r10) == false) goto L36;
        ArrayList r11 = new ArrayList();
        int r3 = r8.length;
        int r4 = 0;
        Field r5 = null;
    L9:
        if (r4 >= r3) goto L16;
        Field r6 = r8[r4];
        Value r7 = (Value) r6.getAnnotation(Value.class);
        if (r7 == null) goto L15;
        r11.add(r6);
        if (r7.isDefault() == false) goto L15;
        r5 = r6;
    L15:
        r4 = r4 + 1;
        goto L9
    L16:
        if (r5 == null) goto L18;
    L20:
        if (r5 == null) goto L37;
        r5.setAccessible(true);
        if (Modifier.isStatic(r5.getModifiers()) == false) goto L38;
        T r12 = (T) r5.get(null);
        if (r12 != null) goto L39;
        return null;
    L39:
        return r12;
    L27:
        e = move-exception;
        e.printStackTrace();
        return null;
    L38:
        return null;
    L37:
        return null;
    L18:
        if (r11.size() != 1) goto L20;
        r5 = (Field) r11.get(0);
        goto L20
    L36:
        return null;
    L5:
        r10 = false;
        goto L7
    }

    private final Field findValueField(Class<?> r9) {
        Field[] r8 = r9.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r8, TracingConstants.KEY_FIELDS);
        if (r8.length != 0) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == false) goto L9;
        return null;
    L9:
        ArrayList r11 = new ArrayList();
        int r3 = r8.length;
        int r4 = 0;
        Field r5 = null;
    L10:
        if (r4 >= r3) goto L17;
        Field r6 = r8[r4];
        Value r7 = (Value) r6.getAnnotation(Value.class);
        if (r7 == null) goto L16;
        r11.add(r6);
        if (r7.isDefault() == false) goto L16;
        r5 = r6;
    L16:
        r4 = r4 + 1;
        goto L10
    L17:
        if (r5 == null) goto L20;
        return r5;
    L20:
        if (r11.size() == 1) goto L22;
        return null;
    L22:
        return (Field) r11.get(0);
    L5:
        r10 = false;
        goto L7
    }
}
