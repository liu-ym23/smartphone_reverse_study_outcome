package com.obric.pushservice;

import android.content.Context;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushInitializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/pushservice/PushInitializer;", "", "()V", "APP_KEY", "", "TAG", "initialized", "", "init", "", "context", "Landroid/content/Context;", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PushInitializer {
    private static final String APP_KEY = "1015";
    public static final PushInitializer INSTANCE = null;
    private static final String TAG = "PushInitializer";
    private static volatile boolean initialized;

    static {
        INSTANCE = new PushInitializer();
    }

    private PushInitializer() {
    }

    public static final /* synthetic */ boolean access$getInitialized$p(PushInitializer r0) {
        return initialized;
    }

    public static final /* synthetic */ void access$setInitialized$p(PushInitializer r0, boolean r1) {
        initialized = r1;
    }

    @JvmStatic
    public static final void init(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (initialized == false) goto L6;
        OLog.d(TAG, "push already initialized, skip");
        return;
    L6:
        PushInitializer r0 = INSTANCE;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (initialized == false) goto L13;
        monitor-exit(r0);
        return;
    L13:
        initialized = true;     // Catch: Throwable -> L17
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r0);
        OLog.d(TAG, "start init push");
        Context r3 = r2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context.applicationContext");
        PushService.registerPush(r3, APP_KEY, new AnonymousClass2());
    }
}
