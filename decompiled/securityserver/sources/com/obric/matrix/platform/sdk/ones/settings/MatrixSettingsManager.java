package com.obric.matrix.platform.sdk.ones.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatrixSettingsManager {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    public static final String PROVIDER_AUTH = "content://com.obric.matrix.systemapp.settings.provider/get_app_settings";

    @NotNull
    public static final String TAG = "MatrixSettingsManager";

    @Nullable
    private static MatrixSettingsManager instance;

    @NotNull
    private static final Object instanceLock = null;

    @NotNull
    private static final AtomicBoolean isInited = null;

    @NotNull
    private final MatrixSettingsConfig config;

    @NotNull
    private final Context context;

    @NotNull
    private final Gson gson;

    @NotNull
    private final CopyOnWriteArrayList<SettingsUpdateListener> listeners;

    @NotNull
    private final ReentrantLock lock;

    @Nullable
    private String settingsObject;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MatrixSettingsManager getInstance() {
            if (MatrixSettingsManager.access$getInstance$cp() == null) goto L7;
            MatrixSettingsManager r1 = MatrixSettingsManager.access$getInstance$cp();
            Intrinsics.c(r1);
            return r1;
        L7:
            throw new IllegalStateException("MatrixSettingsManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }

        public final void init(@NotNull Context r3, @NotNull MatrixSettingsConfig r4) {
            Intrinsics.f(r3, "context");
            Intrinsics.f(r4, "config");
            if (MatrixSettingsManager.access$isInited$cp().get() == false) goto L6;
            OLog.i(MatrixSettingsManager.TAG, "is inited");
            return;
        L6:
            Object r2 = MatrixSettingsManager.access$getInstanceLock$cp();
            monitor-enter(r2);
        L12:
            th = move-exception;
            throw th;
        L9:
            if (MatrixSettingsManager.access$getInstance$cp() != null) goto L14;
            MatrixSettingsManager.access$setInstance$cp(new MatrixSettingsManager(r3, r4, null));     // Catch: Throwable -> L12
        L14:
            monitor-exit(r2);
            MatrixSettingsManager r5 = MatrixSettingsManager.access$getInstance$cp();
            Intrinsics.c(r5);
            r5.refreshSettings();
            MatrixSettingsManager r6 = MatrixSettingsManager.access$getInstance$cp();
            Intrinsics.c(r6);
            r6.registerSettingsObserver();
            MatrixSettingsManager.access$isInited$cp().set(true);
        }

        public final boolean isInited() {
            return MatrixSettingsManager.access$isInited$cp().get();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Keep
    @Metadata
    public static final class ConfigDataWrapper {

        @Nullable
        private final Object config_data;

        public ConfigDataWrapper() {
            DefaultConstructorMarker r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ ConfigDataWrapper copy$default(ConfigDataWrapper r0, Object r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.config_data;
        L6:
            return r0.copy(r1);
        }

        @Nullable
        public final Object component1() {
            return this.config_data;
        }

        @NotNull
        public final ConfigDataWrapper copy(@Nullable Object r1) {
            return new ConfigDataWrapper(r1);
        }

        public boolean equals(@Nullable Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof ConfigDataWrapper) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.a(this.config_data, ((ConfigDataWrapper) r4).config_data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        @Nullable
        public final Object getConfig_data() {
            return this.config_data;
        }

        public int hashCode() {
            Object r0 = this.config_data;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        @NotNull
        public String toString() {
            return "ConfigDataWrapper(config_data=" + this.config_data + ')';
        }

        public ConfigDataWrapper(@Nullable Object r1) {
            this.config_data = r1;
        }

        public /* synthetic */ ConfigDataWrapper(Object r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager$getSetting$1, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass1<T> extends TypeToken<T> {
        public AnonymousClass1() {
        }
    }

    static {
        Companion = new Companion(null);
        instanceLock = new Object();
        isInited = new AtomicBoolean(false);
    }

    public /* synthetic */ MatrixSettingsManager(Context r1, MatrixSettingsConfig r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public static final /* synthetic */ MatrixSettingsManager access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ Object access$getInstanceLock$cp() {
        return instanceLock;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getListeners$p(MatrixSettingsManager r0) {
        return r0.listeners;
    }

    public static final /* synthetic */ String access$getSettingsObject$p(MatrixSettingsManager r0) {
        return r0.settingsObject;
    }

    public static final /* synthetic */ AtomicBoolean access$isInited$cp() {
        return isInited;
    }

    public static final /* synthetic */ void access$setInstance$cp(MatrixSettingsManager r0) {
        instance = r0;
    }

    public final void addSettingsUpdateListener(@NotNull SettingsUpdateListener r4) {
        Intrinsics.f(r4, "listener");
        OLog.i(TAG, "addSettingsUpdateListener " + r4);
        if (this.listeners.contains(r4) == true) goto L5;
        this.listeners.add(r4);
    L5:
        ReentrantLock r1 = this.lock;
        r1.lock();
        String r3 = this.settingsObject;     // Catch: Throwable -> L10
        if (r3 == null) goto L12;
        OLog.i(TAG, "注册settingsUpdateListener时settingsObject有值，立即回调 ".concat(r3));     // Catch: Throwable -> L10
        r4.onSettingsUpdate(r3);     // Catch: Throwable -> L10
    L12:
        r1.unlock();
        return;
    L10:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    @Nullable
    public final String getAllSettings() {
        ReentrantLock r0 = this.lock;
        r0.lock();
        String r1 = this.settingsObject;     // Catch: Throwable -> L8
        if (r1 != null) goto L10;
        String r2 = refreshSettings();     // Catch: Throwable -> L8
        r0.unlock();
        return r2;
    L10:
        r0.unlock();
        return r1;
    L8:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @NotNull
    public final Gson getGson() {
        return this.gson;
    }

    public final <T> T getSetting(T r2) {
        if (getAllSettings() != null) goto L10;
        return r2;
    L10:
        getGson();     // Catch: Exception -> L8
        Intrinsics.l();     // Catch: Exception -> L8
        throw null;     // Catch: Exception -> L8
    L8:
        OLog r1 = OLog.INSTANCE;
        Intrinsics.l();
        throw null;
    }

    @Nullable
    public final String refreshSettings() {
        ReentrantLock r1 = this.lock;
        r1.lock();
        Object r2 = null;
        Uri r3 = Uri.parse(PROVIDER_AUTH);     // Catch: Throwable -> L19
        Bundle r4 = new Bundle();     // Catch: Throwable -> L19
        r4.putString("packageName", this.config.getPkgName());     // Catch: Throwable -> L19
        r4.putString("receiverName", this.config.getReceiverName());     // Catch: Throwable -> L19
        Cursor r5 = this.context.getContentResolver().query(r3, null, r4, null);     // Catch: Throwable -> L19
        if (r5 != null) goto L46;
    L25:
        OLog.e(TAG, "getAllSettings cursor is null");     // Catch: Throwable -> L19
        this.settingsObject = null;     // Catch: Throwable -> L19
        Object r6 = null;
    L28:
        Throwable r7 = Result.a(r6);     // Catch: Throwable -> L31
        if (r7 == null) goto L34;
        OLog.INSTANCE.e(TAG, "getAllSettings error", r7);     // Catch: Throwable -> L31
        this.settingsObject = null;     // Catch: Throwable -> L31
    L34:
        if ((r6 instanceof Result.Failure) == true) goto L37;
        r2 = r6;
    L37:
        String r8 = (String) r2;     // Catch: Throwable -> L31
        r1.unlock();
        return r8;
    L46:
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.a(r5, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L6:
        if (r5.moveToFirst() == false) goto L14;
        Object r9 = ((ConfigDataWrapper) this.gson.fromJson(r5.getString(r5.getColumnIndexOrThrow("all_config_str")), ConfigDataWrapper.class)).getConfig_data();     // Catch: Throwable -> L10
        if (r9 == null) goto L12;
        String r10 = this.gson.toJson(r9);     // Catch: Throwable -> L10
    L13:
        this.settingsObject = r10;     // Catch: Throwable -> L10
        String r11 = r10;
    L16:
        CloseableKt.a(r5, null);     // Catch: Throwable -> L19
        r6 = r11;
        if (r11 != null) goto L28;
    L12:
        r10 = null;
        goto L13
    L14:
        OLog.e(TAG, "getAllSettings cursor is empty");     // Catch: Throwable -> L10
        this.settingsObject = null;     // Catch: Throwable -> L10
        r11 = null;
    L19:
        th = move-exception;
        r6 = ResultKt.a(th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    public final void registerSettingsObserver() {
        OLog.i(TAG, "注册observer");
        Uri r0 = Uri.parse(PROVIDER_AUTH);
        final Handler r1 = new Handler(Looper.getMainLooper());
        ContentObserver r2 = new MatrixSettingsManager$registerSettingsObserver$observer$1(this, r1);
        this.context.getContentResolver().registerContentObserver(r0, true, r2);
    }

    public final void removeSettingsUpdateListener(@NotNull SettingsUpdateListener r3) {
        Intrinsics.f(r3, "listener");
        this.listeners.remove(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.INSTANCE.e(TAG, "removeSettingsUpdateListener error", e);
    }

    public final boolean updateSettings() {
        OLog.i(TAG, "callUpdateSettings");     // Catch: Throwable -> L7
        ContentResolver r4 = this.context.getContentResolver();     // Catch: Throwable -> L7
        Object r1 = null;
        if (r4 == null) goto L9;
        r1 = r4.call(Uri.parse(PROVIDER_AUTH), "update_settings", null, null);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.a(r1);
        if (r5 == null) goto L13;
        OLog.INSTANCE.e(TAG, "callUpdateSettings failed", r5);
    L13:
        return !(r1 instanceof Result.Failure);
    L7:
        th = move-exception;
        r1 = ResultKt.a(th);
        goto L9
    }

    private MatrixSettingsManager(Context r1, MatrixSettingsConfig r2) {
        this.context = r1;
        this.config = r2;
        this.listeners = new CopyOnWriteArrayList();
        this.gson = new Gson();
        this.lock = new ReentrantLock();
    }
}
