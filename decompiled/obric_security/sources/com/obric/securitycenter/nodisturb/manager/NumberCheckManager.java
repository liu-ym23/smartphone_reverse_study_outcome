package com.obric.securitycenter.nodisturb.manager;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.ApplicationContainer;
import com.obric.securitycenter.api.GlobalManagerCreator;
import com.obric.securitycenter.api.INumberCheckManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NumberCheckManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/NumberCheckManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "initNumberCheckManager", "", "onDestroy", "queryNumberMarkClassify", "", "number", "", "Companion", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NumberCheckManager {
    public static final Companion Companion = null;
    public static final String SETTINGS_KEY = "SmartCallInterceptClassify";
    private static final String TAG = "NumberCheckManager";
    private final Context context;

    /* JADX INFO: compiled from: NumberCheckManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/NumberCheckManager$Companion;", "", "()V", "SETTINGS_KEY", "", "TAG", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public NumberCheckManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        initNumberCheckManager();
    }

    public final Context getContext() {
        return this.context;
    }

    public final void initNumberCheckManager() {
        INumberCheckManager r0 = (INumberCheckManager) GlobalManagerCreator.INSTANCE.getManager(INumberCheckManager.class);
        if (r0 == null) goto L6;
        r0.init(this.context);
        return;
    }

    public final int queryNumberMarkClassify(String r8) {
        Intrinsics.checkNotNullParameter(r8, "number");
        Context r0 = ApplicationContainer.INSTANCE.getApplication();
        Unit r1 = null;
        if (r0 == null) goto L5;
        ContentResolver r2 = r0.getContentResolver();
    L6:
        int r3 = Settings.Global.getInt(r2, SETTINGS_KEY, -1);
        if (r3 > 0) goto L9;
        return -1;
    L9:
        final AtomicInteger r4 = new AtomicInteger(-1);
        final CountDownLatch r5 = new CountDownLatch(1);
        INumberCheckManager r6 = (INumberCheckManager) GlobalManagerCreator.INSTANCE.getManager(INumberCheckManager.class);
        if (r6 == null) goto L12;
        r6.queryNumberMarkClassify(r8, new Bundle(), new AnonymousClass1(r4, r5));
        r1 = Unit.INSTANCE;
    L12:
        if (r1 != null) goto L23;
        r5.countDown();
        return r4.get();
    L23:
        r5.await(1000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L17
    L19:
        int r7 = r4.get();
        OLog.d(TAG, "_CallSmsIntercept : switch = " + r3 + ", resultClassify = " + r7);
        if ((r3 & r7) == 0) goto L22;
        return r7;
    L22:
        return -1;
    L17:
        e = move-exception;
        Thread.currentThread().interrupt();
        e.printStackTrace();
        goto L19
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        INumberCheckManager r1 = (INumberCheckManager) GlobalManagerCreator.INSTANCE.getManager(INumberCheckManager.class);
        if (r1 == null) goto L6;
        r1.onDestroy();
        return;
    }
}
