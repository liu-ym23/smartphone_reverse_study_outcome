package com.obric.capabilitykit.entity.app;

import android.icu.text.PluralRules;
import android.net.Uri;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "", SlardarSettingsConsts.SETTING_IMAGE, "Landroid/net/Uri;", "title", "", "subtitle", "time", "", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;J)V", "getImage", "()Landroid/net/Uri;", "getSubtitle", "()Ljava/lang/String;", "getTime", "()J", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DisplayRepresentation {
    private final Uri image;
    private final String subtitle;
    private final long time;
    private final String title;

    public DisplayRepresentation(Uri r2, String r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "title");
        this.image = r2;
        this.title = r3;
        this.subtitle = r4;
        this.time = r5;
    }

    public /* synthetic */ DisplayRepresentation(Uri r8, String r9, String r10, long r11, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        Uri r2 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r4 = null;
    L10:
        this(r2, r9, r4, r11);
        return;
    L9:
        r4 = r10;
        goto L10
    L5:
        r2 = r8;
        goto L7
    }

    public static /* synthetic */ DisplayRepresentation copy$default(DisplayRepresentation r3, Uri r4, String r5, String r6, long r7, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.image;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.title;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.subtitle;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.time;
    L14:
        Uri r8 = r4;
        return r3.copy(r8, r11, r0, r7);
    }

    public final Uri component1() {
        return this.image;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final long component4() {
        return this.time;
    }

    public final DisplayRepresentation copy(Uri r7, String r8, String r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "title");
        return new DisplayRepresentation(r7, r8, r9, r10);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof DisplayRepresentation) == true) goto L8;
        return false;
    L8:
        DisplayRepresentation r7 = (DisplayRepresentation) r6;
        if (Intrinsics.areEqual(this.image, r7.image) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r7.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subtitle, r7.subtitle) == true) goto L18;
        return false;
    L18:
        if (this.time == r7.time) goto L20;
        return false;
    L20:
        return true;
    }

    public final Uri getImage() {
        return this.image;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Uri r0 = this.image;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.title.hashCode()) * 31;
        String r4 = this.subtitle;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + Long.hashCode(this.time);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DisplayRepresentation(image=" + this.image + ", title=" + this.title + ", subtitle=" + this.subtitle + ", time=" + this.time + ')';
    }
}
