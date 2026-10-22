package com.android.settingslib.volume.domain.model;

import android.icu.text.PluralRules;
import android.media.RoutingSessionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoutingSession.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/android/settingslib/volume/domain/model/RoutingSession;", "", "routingSessionInfo", "Landroid/media/RoutingSessionInfo;", "isMediaOutputDisabled", "", "isVolumeSeekBarEnabled", "(Landroid/media/RoutingSessionInfo;ZZ)V", "()Z", "getRoutingSessionInfo", "()Landroid/media/RoutingSessionInfo;", "component1", "component2", "component3", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoutingSession {
    private final boolean isMediaOutputDisabled;
    private final boolean isVolumeSeekBarEnabled;
    private final RoutingSessionInfo routingSessionInfo;

    public static /* synthetic */ RoutingSession copy$default(RoutingSession r0, RoutingSessionInfo r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.routingSessionInfo;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.isMediaOutputDisabled;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.isVolumeSeekBarEnabled;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final RoutingSessionInfo component1() {
        return this.routingSessionInfo;
    }

    public final boolean component2() {
        return this.isMediaOutputDisabled;
    }

    public final boolean component3() {
        return this.isVolumeSeekBarEnabled;
    }

    public final RoutingSession copy(RoutingSessionInfo r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "routingSessionInfo");
        return new RoutingSession(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RoutingSession) == true) goto L8;
        return false;
    L8:
        RoutingSession r6 = (RoutingSession) r5;
        if (Intrinsics.areEqual(this.routingSessionInfo, r6.routingSessionInfo) == true) goto L12;
        return false;
    L12:
        if (this.isMediaOutputDisabled == r6.isMediaOutputDisabled) goto L15;
        return false;
    L15:
        if (this.isVolumeSeekBarEnabled == r6.isVolumeSeekBarEnabled) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = this.routingSessionInfo.hashCode() * 31;
        boolean r1 = this.isMediaOutputDisabled;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.isVolumeSeekBarEnabled;
        if (r5 == true) goto L10;
        r2 = r5;
    L10:
        return r4 + r2;
    }

    public String toString() {
        return "RoutingSession(routingSessionInfo=" + this.routingSessionInfo + ", isMediaOutputDisabled=" + this.isMediaOutputDisabled + ", isVolumeSeekBarEnabled=" + this.isVolumeSeekBarEnabled + ')';
    }

    public RoutingSession(RoutingSessionInfo r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "routingSessionInfo");
        this.routingSessionInfo = r2;
        this.isMediaOutputDisabled = r3;
        this.isVolumeSeekBarEnabled = r4;
    }

    public final RoutingSessionInfo getRoutingSessionInfo() {
        return this.routingSessionInfo;
    }

    public final boolean isMediaOutputDisabled() {
        return this.isMediaOutputDisabled;
    }

    public final boolean isVolumeSeekBarEnabled() {
        return this.isVolumeSeekBarEnabled;
    }
}
