package com.obric.matrix.platform.sdk.ones.account.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ILogger {

    @Metadata
    public static final class DefaultImpls {
        public static /* synthetic */ void d$default(ILogger r0, String r1, String r2, Throwable r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
        L6:
            r0.d(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
        }

        public static /* synthetic */ void e$default(ILogger r0, String r1, String r2, Throwable r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
        L6:
            r0.e(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }

        public static /* synthetic */ void i$default(ILogger r0, String r1, String r2, Throwable r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
        L6:
            r0.i(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
        }

        public static /* synthetic */ void v$default(ILogger r0, String r1, String r2, Throwable r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
        L6:
            r0.v(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
        }

        public static /* synthetic */ void w$default(ILogger r0, String r1, String r2, Throwable r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
        L6:
            r0.w(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
        }
    }

    void d(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3);

    void e(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3);

    void i(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3);

    void v(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3);

    void w(@NotNull String r1, @NotNull String r2, @Nullable Throwable r3);
}
