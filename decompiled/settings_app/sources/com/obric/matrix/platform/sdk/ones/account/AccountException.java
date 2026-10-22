package com.obric.matrix.platform.sdk.ones.account;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.alog.AlogMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccountException.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/AccountException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", AlogMonitor.ALOG_RESULT_CODE, "", NotificationCompat.CATEGORY_MESSAGE, "", "cause", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "toString", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountException extends Exception {
    private final int code;
    private final String msg;

    public AccountException(int r7) {
        this(r7, null, null, 6, null);
    }

    public AccountException(int r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
        this(r8, r9, null, 4, null);
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

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public AccountException(int r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        super(r4);
        this.code = r2;
        this.msg = r3;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "code: " + this.code + ", msg: " + this.msg + ", cause: " + getCause();
    }
}
