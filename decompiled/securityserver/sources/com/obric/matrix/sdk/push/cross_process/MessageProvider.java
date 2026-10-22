package com.obric.matrix.sdk.push.cross_process;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.obric.matrix.push.common.CommonConstants;
import com.obric.matrix.push.common.log.Logger;
import com.obric.matrix.sdk.push.IPushClient;
import com.obric.matrix.sdk.push.model.Message;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class MessageProvider extends ContentProvider implements IPushClient {

    @NotNull
    private final CountDownLatch contextAttachedSignal;

    @NotNull
    private final AtomicBoolean initComplete;

    @NotNull
    private final String tag;

    public MessageProvider() {
        this.tag = "MessageProvider";
        this.initComplete = new AtomicBoolean();
        this.contextAttachedSignal = new CountDownLatch(1);
    }

    private final void ensureInitComplete() {
        AtomicBoolean r0 = this.initComplete;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.initComplete.get() == true) goto L10;
        waitForAppInit();     // Catch: Throwable -> L8
        this.initComplete.set(true);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);
    }

    private final void waitForAppInit() {
        long r2 = System.currentTimeMillis();
        this.contextAttachedSignal.await();     // Catch: Throwable -> L9 InterruptedException -> L11
        if (getContext() == null) goto L8;
        Logger.d(this.tag, "wait for app init cost " + (System.currentTimeMillis() - r2) + " ms");
        return;
    L8:
        throw new IllegalArgumentException("context is null!".toString());     // Catch: Throwable -> L9 InterruptedException -> L11
    L9:
        th = move-exception;
        Logger.d(this.tag, "wait for app init cost " + (System.currentTimeMillis() - r2) + " ms");
        throw th;
    L11:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L9
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@Nullable Context r3, @Nullable ProviderInfo r4) {
        Logger.i(this.tag, "attachInfo");
        super.attachInfo(r3, r4);
        this.contextAttachedSignal.countDown();
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NotNull String r5, @Nullable String r6, @Nullable Bundle r7) {
        Intrinsics.f(r5, "method");
        Logger.d(this.tag, "message provider call: " + r5 + ", " + r6 + ", " + r7);
        ensureInitComplete();
        if (Intrinsics.a(getCallingPackage(), "com.obric.matrix") == false) goto L21;
    L13:
        th = move-exception;
        Logger.e("message provider error: " + th);
        goto L21
    L5:
        if (r5.equals(CommonConstants.PASS_THROUGH_MSG_ACTION) == false) goto L21;
        if (r7 == null) goto L21;
        Object r1 = r7.get(CommonConstants.MSG_ID);     // Catch: Throwable -> L13
        if (r1 == null) goto L18;
        String r2 = (String) r1;     // Catch: Throwable -> L13
        Object r3 = r7.get(CommonConstants.KEY_PASS_THOUGH_DATA);     // Catch: Throwable -> L13
        if (r3 == null) goto L16;
        onReceiveMsg(new Message(r2, (String) r3));     // Catch: Throwable -> L13
        goto L21
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L13
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L13
    L21:
        return super.call(r5, r6, r7);
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri r1, @Nullable String r2, @Nullable String[] r3) {
        Intrinsics.f(r1, "uri");
        ensureInitComplete();
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri r2) {
        Intrinsics.f(r2, "uri");
        ensureInitComplete();
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri r1, @Nullable ContentValues r2) {
        Intrinsics.f(r1, "uri");
        ensureInitComplete();
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Logger.d(this.tag, "onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri r1, @Nullable String[] r2, @Nullable String r3, @Nullable String[] r4, @Nullable String r5) {
        Intrinsics.f(r1, "uri");
        ensureInitComplete();
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri r1, @Nullable ContentValues r2, @Nullable String r3, @Nullable String[] r4) {
        Intrinsics.f(r1, "uri");
        ensureInitComplete();
        return 0;
    }
}
