package com.android.settingslib;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MobileNetworkTypeIcon.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/android/settingslib/MobileNetworkTypeIcon;", "", "name", "", "iconResId", "", "contentDescriptionResId", "(Ljava/lang/String;II)V", "getContentDescriptionResId", "()I", "getIconResId", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MobileNetworkTypeIcon {
    private final int contentDescriptionResId;
    private final int iconResId;
    private final String name;

    public static /* synthetic */ MobileNetworkTypeIcon copy$default(MobileNetworkTypeIcon r0, String r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.iconResId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.contentDescriptionResId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.iconResId;
    }

    public final int component3() {
        return this.contentDescriptionResId;
    }

    public final MobileNetworkTypeIcon copy(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "name");
        return new MobileNetworkTypeIcon(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MobileNetworkTypeIcon) == true) goto L8;
        return false;
    L8:
        MobileNetworkTypeIcon r6 = (MobileNetworkTypeIcon) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (this.iconResId == r6.iconResId) goto L15;
        return false;
    L15:
        if (this.contentDescriptionResId == r6.contentDescriptionResId) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + Integer.hashCode(this.iconResId)) * 31) + Integer.hashCode(this.contentDescriptionResId);
    }

    public String toString() {
        return "MobileNetworkTypeIcon(name=" + this.name + ", iconResId=" + this.iconResId + ", contentDescriptionResId=" + this.contentDescriptionResId + ')';
    }

    public MobileNetworkTypeIcon(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.name = r2;
        this.iconResId = r3;
        this.contentDescriptionResId = r4;
    }

    public final String getName() {
        return this.name;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final int getContentDescriptionResId() {
        return this.contentDescriptionResId;
    }
}
