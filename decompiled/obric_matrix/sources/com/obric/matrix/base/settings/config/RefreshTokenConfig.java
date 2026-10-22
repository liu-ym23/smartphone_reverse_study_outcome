package com.obric.matrix.base.settings.config;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/base/settings/config/RefreshTokenConfig;", "", "canRefreshToken", "", "accessTokenMinExpireIn", "", "refreshTokenMinExpireIn", "(ZJJ)V", "getAccessTokenMinExpireIn", "()J", "getCanRefreshToken", "()Z", "getRefreshTokenMinExpireIn", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RefreshTokenConfig {

    @com.google.gson.y.c("access_token_min_expire_in")
    private final long accessTokenMinExpireIn;

    @com.google.gson.y.c("can_refresh_token")
    private final boolean canRefreshToken;

    @com.google.gson.y.c("refresh_token_min_expire_in")
    private final long refreshTokenMinExpireIn;

    public RefreshTokenConfig() {
        this(false, 0, 0, 7, null);
    }

    public RefreshTokenConfig(boolean r1, long r2, long r4) {
        this.canRefreshToken = r1;
        this.accessTokenMinExpireIn = r2;
        this.refreshTokenMinExpireIn = r4;
    }

    public /* synthetic */ RefreshTokenConfig(boolean r5, long r6, long r8, int r10, kotlin.n0.d.g r11) {
        if ((r10 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r10 & 2) == 0) goto L8;
        long r2 = 604800;
    L10:
        if ((r10 & 4) == 0) goto L12;
        long r12 = 604800;
    L13:
        this(r5, r2, r12);
        return;
    L12:
        r12 = r8;
        goto L13
    L8:
        r2 = r6;
        goto L10
    }

    public static /* synthetic */ RefreshTokenConfig copy$default(RefreshTokenConfig r2, boolean r3, long r4, long r6, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = r2.canRefreshToken;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = r2.accessTokenMinExpireIn;
    L8:
        long r0 = r4;
        if ((r8 & 4) == 0) goto L11;
        r6 = r2.refreshTokenMinExpireIn;
    L11:
        boolean r5 = r3;
        return r2.copy(r5, r0, r6);
    }

    public final boolean component1() {
        return this.canRefreshToken;
    }

    public final long component2() {
        return this.accessTokenMinExpireIn;
    }

    public final long component3() {
        return this.refreshTokenMinExpireIn;
    }

    public final RefreshTokenConfig copy(boolean r7, long r8, long r10) {
        return new RefreshTokenConfig(r7, r8, r10);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof RefreshTokenConfig) == true) goto L8;
        return false;
    L8:
        RefreshTokenConfig r9 = (RefreshTokenConfig) r8;
        if (this.canRefreshToken == r9.canRefreshToken) goto L12;
        return false;
    L12:
        if (this.accessTokenMinExpireIn == r9.accessTokenMinExpireIn) goto L15;
        return false;
    L15:
        if (this.refreshTokenMinExpireIn == r9.refreshTokenMinExpireIn) goto L17;
        return false;
    L17:
        return true;
    }

    public final long getAccessTokenMinExpireIn() {
        return this.accessTokenMinExpireIn;
    }

    public final boolean getCanRefreshToken() {
        return this.canRefreshToken;
    }

    public final long getRefreshTokenMinExpireIn() {
        return this.refreshTokenMinExpireIn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r0 = this.canRefreshToken;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (((r1 * 31) + Long.hashCode(this.accessTokenMinExpireIn)) * 31) + Long.hashCode(this.refreshTokenMinExpireIn);
    }

    public String toString() {
        return "RefreshTokenConfig(canRefreshToken=" + this.canRefreshToken + ", accessTokenMinExpireIn=" + this.accessTokenMinExpireIn + ", refreshTokenMinExpireIn=" + this.refreshTokenMinExpireIn + ')';
    }
}
