package com.obric.matrix.platform.sdk.ones.settings;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixSettingsManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ(\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002H\u00160\u0018H\u0082\b¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011J\u001e\u0010\u001c\u001a\u0002H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u00012\u0006\u0010\u001d\u001a\u0002H\u0016H\u0086\b¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010!\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\"\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager;", "", "context", "Landroid/content/Context;", "config", "Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsConfig;", "(Landroid/content/Context;Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsConfig;)V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/matrix/platform/sdk/ones/settings/SettingsUpdateListener;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "settingsObject", "", "addSettingsUpdateListener", "", "listener", "callSettingsProvider", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Landroid/content/ContentProviderClient;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getAllSettings", "getSetting", "default", "(Ljava/lang/Object;)Ljava/lang/Object;", "notifySettingsUpdated", "jsonString", "refreshSettings", "registerSettingsObserver", "removeSettingsUpdateListener", "updateSettings", "", "Companion", "ConfigDataWrapper", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixSettingsManager {
    public static final Companion Companion = null;
    public static final String PROVIDER_AUTH = "content://com.obric.matrix.systemapp.settings.provider/get_app_settings";
    public static final String TAG = "MatrixSettingsManager";
    private static MatrixSettingsManager instance;
    private static final Object instanceLock = null;
    private static final AtomicBoolean isInited = null;
    private final MatrixSettingsConfig config;
    private final Context context;
    private final Gson gson;
    private final CopyOnWriteArrayList<SettingsUpdateListener> listeners;
    private final ReentrantLock lock;
    private String settingsObject;

    /* JADX INFO: compiled from: MatrixSettingsManager.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020\u0012J\u001d\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager$Companion;", "", "()V", "PROVIDER_AUTH", "", "TAG", "instance", "Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager;", "instanceLock", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInstance", "init", "", "context", "Landroid/content/Context;", "config", "Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsConfig;", "", "prepare", "prepare$sdk_platform_ones_release", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final void prepare$sdk_platform_ones_release(Context r3, MatrixSettingsConfig r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "config");
            Object r2 = MatrixSettingsManager.access$getInstanceLock$cp();
            monitor-enter(r2);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (MatrixSettingsManager.access$getInstance$cp() != null) goto L7;
            Companion r0 = MatrixSettingsManager.Companion;     // Catch: Throwable -> L10
            MatrixSettingsManager.access$setInstance$cp(new MatrixSettingsManager(r3, r4, null));     // Catch: Throwable -> L10
        L7:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r2);
        }

        public final void init(Context r2, MatrixSettingsConfig r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "config");
            if (MatrixSettingsManager.access$isInited$cp().get() == false) goto L6;
            OLog.i(MatrixSettingsManager.TAG, "is inited");
            return;
        L6:
            prepare$sdk_platform_ones_release(r2, r3);
            MatrixSettingsManager r1 = MatrixSettingsManager.access$getInstance$cp();
            Intrinsics.checkNotNull(r1);
            r1.refreshSettings();
            MatrixSettingsManager r4 = MatrixSettingsManager.access$getInstance$cp();
            Intrinsics.checkNotNull(r4);
            r4.registerSettingsObserver();
            MatrixSettingsManager.access$isInited$cp().set(true);
        }

        public final boolean isInited() {
            return MatrixSettingsManager.access$isInited$cp().get();
        }

        public final MatrixSettingsManager getInstance() {
            if (MatrixSettingsManager.access$getInstance$cp() == null) goto L7;
            MatrixSettingsManager r1 = MatrixSettingsManager.access$getInstance$cp();
            Intrinsics.checkNotNull(r1);
            return r1;
        L7:
            throw new IllegalStateException("MatrixSettingsManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }
    }

    /* JADX INFO: compiled from: MatrixSettingsManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager$ConfigDataWrapper;", "", "config_data", "(Ljava/lang/Object;)V", "getConfig_data", "()Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ConfigDataWrapper {
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

        public final Object component1() {
            return this.config_data;
        }

        public final ConfigDataWrapper copy(Object r1) {
            return new ConfigDataWrapper(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof ConfigDataWrapper) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.config_data, ((ConfigDataWrapper) r4).config_data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            Object r0 = this.config_data;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "ConfigDataWrapper(config_data=" + this.config_data + ')';
        }

        public ConfigDataWrapper(Object r1) {
            this.config_data = r1;
        }

        public /* synthetic */ ConfigDataWrapper(Object r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }

        public final Object getConfig_data() {
            return this.config_data;
        }
    }

    public /* synthetic */ MatrixSettingsManager(Context r1, MatrixSettingsConfig r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    private MatrixSettingsManager(Context r1, MatrixSettingsConfig r2) {
        this.context = r1;
        this.config = r2;
        this.listeners = new CopyOnWriteArrayList();
        this.gson = new Gson();
        this.lock = new ReentrantLock();
    }

    public static final /* synthetic */ MatrixSettingsManager access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ Object access$getInstanceLock$cp() {
        return instanceLock;
    }

    public static final /* synthetic */ String access$getSettingsObject$p(MatrixSettingsManager r0) {
        return r0.settingsObject;
    }

    public static final /* synthetic */ AtomicBoolean access$isInited$cp() {
        return isInited;
    }

    public static final /* synthetic */ void access$notifySettingsUpdated(MatrixSettingsManager r0, String r1) {
        r0.notifySettingsUpdated(r1);
    }

    public static final /* synthetic */ void access$setInstance$cp(MatrixSettingsManager r0) {
        instance = r0;
    }

    public final Gson getGson() {
        return this.gson;
    }

    static {
        Companion = new Companion(null);
        instanceLock = new Object();
        isInited = new AtomicBoolean(false);
    }

    public final String refreshSettings() {
        ReentrantLock r2 = this.lock;
        r2.lock();
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L41
        Uri r5 = Uri.parse(PROVIDER_AUTH);     // Catch: Throwable -> L41
        Bundle r6 = new Bundle();     // Catch: Throwable -> L41
        r6.putString("packageName", this.config.getPkgName());     // Catch: Throwable -> L41
        r6.putString("receiverName", this.config.getReceiverName());     // Catch: Throwable -> L41
        ContentProviderClient r0 = this.context.getContentResolver().acquireUnstableContentProviderClient(Uri.parse(PROVIDER_AUTH));     // Catch: Throwable -> L36
        if (r0 == null) goto L35;
        Cursor r7 = r0.query(r5, null, r6, null);     // Catch: Throwable -> L32
        if (r7 == null) goto L26;
        Cursor r8 = r7;     // Catch: Throwable -> L32
        Cursor r9 = r8;     // Catch: Throwable -> L21
        if (r9.moveToFirst() == false) goto L16;
        Object r10 = ((ConfigDataWrapper) this.gson.fromJson(r9.getString(r9.getColumnIndexOrThrow("all_config_str")), ConfigDataWrapper.class)).getConfig_data();     // Catch: Throwable -> L21
        if (r10 == null) goto L14;
        String r11 = this.gson.toJson(r10);     // Catch: Throwable -> L21
    L15:
        this.settingsObject = r11;     // Catch: Throwable -> L21
    L18:
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L32
        if (r11 == null) goto L26;
    L28:
        if (r0 == null) goto L30;
        r0.close();     // Catch: Throwable -> L41
    L30:
        Object r1 = Result.m774constructorimpl(r11);     // Catch: Throwable -> L41
    L43:
        Throwable r12 = Result.m777exceptionOrNullimpl(r1);     // Catch: Throwable -> L53
        if (r12 == null) goto L47;
        OLog.INSTANCE.e(TAG, "getAllSettings error", r12);     // Catch: Throwable -> L53
        this.settingsObject = null;     // Catch: Throwable -> L53
    L47:
        if (Result.m780isFailureimpl(r1) == true) goto L50;
        r3 = r1;
    L50:
        String r13 = (String) r3;     // Catch: Throwable -> L53
        r2.unlock();
        return r13;
    L14:
        r11 = null;
        goto L15
    L16:
        OLog.e(TAG, "getAllSettings cursor is empty");     // Catch: Throwable -> L21
        this.settingsObject = null;     // Catch: Throwable -> L21
        String r14 = (String) null;     // Catch: Throwable -> L21
        r11 = null;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L26:
        MatrixSettingsManager r15 = this;     // Catch: Throwable -> L32
        OLog.e(TAG, "getAllSettings cursor is null");     // Catch: Throwable -> L32
        this.settingsObject = null;     // Catch: Throwable -> L32
        String r16 = (String) null;     // Catch: Throwable -> L32
        r11 = null;
    L32:
        th = th;
    L38:
        if (r0 == null) goto L40;
        r0.close();     // Catch: Throwable -> L41
    L40:
        throw th;     // Catch: Throwable -> L41
    L35:
        throw new IllegalStateException("provider client is null".toString());     // Catch: Throwable -> L36
    L36:
        th = th;
        r0 = null;
    L53:
        th = move-exception;
        r2.unlock();
        throw th;
    L41:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L53
        r1 = Result.m774constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L53
        goto L43
    }

    public final String getAllSettings() {
        ReentrantLock r0 = this.lock;
        r0.lock();
        String r1 = this.settingsObject;     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        String r2 = refreshSettings();     // Catch: Throwable -> L10
        r0.unlock();
        return r2;
    L8:
        r0.unlock();
        return r1;
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final /* synthetic */ <T> T getSetting(T r5) {
        String r0 = getAllSettings();
        if (r0 != null) goto L12;
        return r5;
    L12:
        Gson r4 = getGson();     // Catch: Exception -> L9
        Intrinsics.needClassReification();     // Catch: Exception -> L9
        T r6 = (T) r4.fromJson(r0, new AnonymousClass1().getType());
        if (r6 != null) goto L14;
        return r5;
    L14:
        return r6;
    L9:
        e = move-exception;
        OLog r1 = OLog.INSTANCE;
        StringBuilder r2 = new StringBuilder("Failed to parse setting to type ");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        r1.e(TAG, r2.append(Object.class.getSimpleName()).toString(), e);
        return r5;
    }

    public final boolean updateSettings() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        OLog.i(TAG, "callUpdateSettings");     // Catch: Throwable -> L24
        String r3 = Uri.parse(PROVIDER_AUTH).getAuthority();     // Catch: Throwable -> L24
        if (r3 == null) goto L23;
        Intrinsics.checkNotNullExpressionValue(r3, "uri.authority ?: error(\"…vider authority is null\")");     // Catch: Throwable -> L24
        Uri r0 = Uri.parse(PROVIDER_AUTH);     // Catch: Throwable -> L24
        ContentProviderClient r4 = null;
        ContentProviderClient r5 = this.context.getContentResolver().acquireUnstableContentProviderClient(r0);     // Catch: Throwable -> L18
        if (r5 == null) goto L17;
        Bundle r1 = r5.call(r3, "update_settings", null, null);     // Catch: Throwable -> L14
        if (r5 == null) goto L12;
        r5.close();     // Catch: Throwable -> L24
    L12:
        Object r6 = Result.m774constructorimpl(r1);     // Catch: Throwable -> L24
    L26:
        Throwable r7 = Result.m777exceptionOrNullimpl(r6);
        if (r7 == null) goto L30;
        OLog.INSTANCE.e(TAG, "callUpdateSettings failed", r7);
    L30:
        return Result.m781isSuccessimpl(r6);
    L14:
        th = th;
        r4 = r5;
    L19:
        if (r4 == null) goto L21;
        r4.close();     // Catch: Throwable -> L24
    L21:
        throw th;     // Catch: Throwable -> L24
    L17:
        throw new IllegalStateException("provider client is null".toString());     // Catch: Throwable -> L18
    L18:
        th = th;
        goto L19
    L23:
        throw new IllegalStateException("provider authority is null".toString());     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    public final void addSettingsUpdateListener(SettingsUpdateListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        OLog.i(TAG, "addSettingsUpdateListener " + r5);
        if (this.listeners.contains(r5) == true) goto L5;
        this.listeners.add(r5);
    L5:
        ReentrantLock r1 = this.lock;
        r1.lock();
        String r4 = this.settingsObject;     // Catch: Throwable -> L11
        if (r4 == null) goto L9;
        OLog.i(TAG, "注册settingsUpdateListener时settingsObject有值，立即回调 " + r4);     // Catch: Throwable -> L11
        r5.onSettingsUpdate(r4);     // Catch: Throwable -> L11
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        r1.unlock();
        return;
    L11:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    public final void removeSettingsUpdateListener(SettingsUpdateListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.listeners.remove(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.INSTANCE.e(TAG, "removeSettingsUpdateListener error", e);
    }

    private final void notifySettingsUpdated(String r3) {
        OLog.i(TAG, "settings刷新了，通知所有listener");
        Iterator<T> r2 = this.listeners.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((SettingsUpdateListener) r2.next()).onSettingsUpdate(r3);
        goto L4
    }

    private final <T> T callSettingsProvider(Function1<? super ContentProviderClient, ? extends T> r4) {
        Uri r0 = Uri.parse(PROVIDER_AUTH);
        ContentProviderClient r2 = null;
        ContentProviderClient r3 = this.context.getContentResolver().acquireUnstableContentProviderClient(r0);     // Catch: Throwable -> L12
        if (r3 == null) goto L11;
        T r5 = r4.invoke(r3);     // Catch: Throwable -> L8
        InlineMarker.finallyStart(1);
        r3.close();
        InlineMarker.finallyEnd(1);
        return r5;
    L8:
        th = th;
        r2 = r3;
    L13:
        InlineMarker.finallyStart(1);
        if (r2 == null) goto L16;
        r2.close();
    L16:
        InlineMarker.finallyEnd(1);
        throw th;
    L11:
        throw new IllegalStateException("provider client is null".toString());     // Catch: Throwable -> L12
    L12:
        th = th;
        goto L13
    }

    public final void registerSettingsObserver() {
        OLog.i(TAG, "注册observer");
        Uri r0 = Uri.parse(PROVIDER_AUTH);
        final Handler r1 = new Handler(Looper.getMainLooper());
        ContentObserver r2 = new MatrixSettingsManager$registerSettingsObserver$observer$1(this, r1);
        this.context.getContentResolver().registerContentObserver(r0, true, r2);
    }
}
