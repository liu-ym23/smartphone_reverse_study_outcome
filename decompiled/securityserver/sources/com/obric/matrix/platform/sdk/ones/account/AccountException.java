package com.obric.matrix.platform.sdk.ones.account;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AccountException extends Exception {
    private final int code;

    @NotNull
    private final String msg;

    @JvmOverloads
    public AccountException(int r7) {
        String r2 = null;
        Throwable r3 = null;
        this(r7, r2, r3, 6, null);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return "code: " + this.code + ", msg: " + this.msg + ", cause: " + getCause();
    }

    @JvmOverloads
    public AccountException(int r8, @NotNull String r9) {
        Intrinsics.f(r9, NotificationCompat.CATEGORY_MESSAGE);
        Throwable r4 = null;
        this(r8, r9, r4, 4, null);
    }

    public /* synthetic */ AccountException(int r1, String r2, Throwable r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }

    @JvmOverloads
    public AccountException(int r2, @NotNull String r3, @Nullable Throwable r4) {
        Intrinsics.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        super(r4);
        this.code = r2;
        this.msg = r3;
    }
}
