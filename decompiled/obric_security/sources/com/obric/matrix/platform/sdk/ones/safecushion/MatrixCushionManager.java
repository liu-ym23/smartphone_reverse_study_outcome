package com.obric.matrix.platform.sdk.ones.safecushion;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.safecushion.util.AppUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixCushionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionManager;", "", "context", "Landroid/content/Context;", "config", "Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig;", "(Landroid/content/Context;Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig;)V", "getConfig", "getContext", "isSafeCushionProcess", "", "start", "", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixCushionManager {
    public static final Companion Companion = null;
    public static final String TAG = "MatrixCushionManager";
    private static MatrixCushionManager instance;
    private static final Object instanceLock = null;
    private final MatrixCushionConfig config;
    private final Context context;

    /* JADX INFO: compiled from: MatrixCushionManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionManager;", "instanceLock", "getInstance", "init", "", "context", "Landroid/content/Context;", "config", "Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final void init(Context r3, MatrixCushionConfig r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "config");
            Object r2 = MatrixCushionManager.access$getInstanceLock$cp();
            monitor-enter(r2);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (MatrixCushionManager.access$getInstance$cp() != null) goto L7;
            Companion r0 = MatrixCushionManager.Companion;     // Catch: Throwable -> L10
            MatrixCushionManager.access$setInstance$cp(new MatrixCushionManager(r3, r4, null));     // Catch: Throwable -> L10
        L7:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r2);
        }

        public final MatrixCushionManager getInstance() {
            if (MatrixCushionManager.access$getInstance$cp() == null) goto L7;
            MatrixCushionManager r1 = MatrixCushionManager.access$getInstance$cp();
            Intrinsics.checkNotNull(r1);
            return r1;
        L7:
            throw new IllegalStateException("MatrixCushionManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }
    }

    public /* synthetic */ MatrixCushionManager(Context r1, MatrixCushionConfig r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    private MatrixCushionManager(Context r1, MatrixCushionConfig r2) {
        this.context = r1;
        this.config = r2;
    }

    public static final /* synthetic */ MatrixCushionManager access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ Object access$getInstanceLock$cp() {
        return instanceLock;
    }

    public static final /* synthetic */ void access$setInstance$cp(MatrixCushionManager r0) {
        instance = r0;
    }

    static {
        Companion = new Companion(null);
        instanceLock = new Object();
    }

    public final void start() {
        LaunchCrashCatcher.INSTANCE.attach();
        SafeCushionCrashCounter.INSTANCE.increaseSupposeCrashCount();
    }

    public final Context getContext() {
        return this.context;
    }

    public final MatrixCushionConfig getConfig() {
        return this.config;
    }

    public final boolean isSafeCushionProcess() {
        return AppUtil.INSTANCE.isSafeModeProcess(this.context);
    }
}
