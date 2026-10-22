package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class MatrixEventObserver extends ContentObserver {

    @NotNull
    private static final String BROADCAST_PROVIDER_AUTHORITY = "com.obric.matrix.outward_event_provider";

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String TAG = "MatrixEventObserver";

    @NotNull
    private final String myPath;

    @NotNull
    private final Lazy myUri$delegate;
    private final boolean notifyForDescendants;
    private volatile boolean registered;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ MatrixEventObserver(String r1, boolean r2, Handler r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ String access$getMyPath$p(MatrixEventObserver r0) {
        return r0.myPath;
    }

    private final Uri getMyUri() {
        Object r1 = this.myUri$delegate.getValue();
        Intrinsics.e(r1, "<get-myUri>(...)");
        return (Uri) r1;
    }

    public abstract void handleContentChange(@NotNull Uri r1);

    @Override // android.database.ContentObserver
    public void onChange(boolean r6, @Nullable Uri r7) {
        super.onChange(r6, r7);
        if (r7 != null) goto L5;
    L13:
        MLog.w$default(TAG, "onChange, ignore! uri: [" + r7 + "], registered: [" + this.registered + ']', null, 4, null);
        return;
    L5:
        if (this.registered == false) goto L13;
        MLog.d$default(TAG, "onChange, uri: [" + r7 + ']', null, 4, null);
        handleContentChange(r7);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        MLog.e(TAG, "onChange, error! myUri: " + getMyUri() + ", uri Changed: " + r7, e);
    }

    public final synchronized void register(@NotNull Context r6) {
        monitor-enter(this);
        Intrinsics.f(r6, "context");     // Catch: Throwable -> L9
        if (this.registered == true) goto L13;
        ContentResolver r7 = r6.getContentResolver();     // Catch: Throwable -> L9
        if (r7 == null) goto L12;
        r7.registerContentObserver(getMyUri(), this.notifyForDescendants, this);     // Catch: Throwable -> L9
        MLog.d$default(TAG, "register, " + getMyUri(), null, 4, null);     // Catch: Throwable -> L9
        this.registered = true;     // Catch: Throwable -> L9
    L14:
        monitor-exit(this);
        return;
    L12:
        throw new IllegalStateException("contentResolver not found");     // Catch: Throwable -> L9
    L13:
        MLog.w$default(TAG, "register, already registered", null, 4, null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void unregister(@NotNull Context r5) {
        monitor-enter(this);
        Intrinsics.f(r5, "context");     // Catch: Throwable -> L9
        if (this.registered == false) goto L13;
        ContentResolver r6 = r5.getContentResolver();     // Catch: Throwable -> L9
        if (r6 == null) goto L12;
        r6.unregisterContentObserver(this);     // Catch: Throwable -> L9
        MLog.d$default(TAG, "unregister, " + getMyUri(), null, 4, null);     // Catch: Throwable -> L9
        this.registered = false;     // Catch: Throwable -> L9
    L14:
        monitor-exit(this);
        return;
    L12:
        throw new IllegalStateException("contentResolver not found");     // Catch: Throwable -> L9
    L13:
        MLog.w$default(TAG, "unregister, not registered", null, 4, null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public MatrixEventObserver(@NotNull String r2, boolean r3, @Nullable Handler r4) {
        Intrinsics.f(r2, "myPath");
        super(r4);
        this.myPath = r2;
        this.notifyForDescendants = r3;
        this.myUri$delegate = LazyKt.b(new MatrixEventObserver$myUri$2(this));
    }
}
