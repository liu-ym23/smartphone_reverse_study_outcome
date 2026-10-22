package com.obric.oui.avatar;

import android.graphics.Bitmap;
import android.icu.text.PluralRules;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAvatarQueueViewV2WithClip.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003JA\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/obric/oui/avatar/OAvatarInParam;", "", "avatarSize", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "shape", "Lcom/obric/oui/avatar/OAvatarQueueShape;", "avatarBitmapQueue", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "overLapSizeDp", "", "(Lcom/obric/oui/avatar/OAvatar$AvatarSize;Lcom/obric/oui/avatar/OAvatarQueueShape;Ljava/util/ArrayList;I)V", "getAvatarBitmapQueue", "()Ljava/util/ArrayList;", "setAvatarBitmapQueue", "(Ljava/util/ArrayList;)V", "getAvatarSize", "()Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "setAvatarSize", "(Lcom/obric/oui/avatar/OAvatar$AvatarSize;)V", "getOverLapSizeDp", "()I", "setOverLapSizeDp", "(I)V", "getShape", "()Lcom/obric/oui/avatar/OAvatarQueueShape;", "setShape", "(Lcom/obric/oui/avatar/OAvatarQueueShape;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarInParam {
    private ArrayList<Bitmap> avatarBitmapQueue;
    private OAvatar.AvatarSize avatarSize;
    private int overLapSizeDp;
    private OAvatarQueueShape shape;

    public OAvatarInParam() {
        this(null, null, null, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OAvatarInParam copy$default(OAvatarInParam r0, OAvatar.AvatarSize r1, OAvatarQueueShape r2, ArrayList r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.avatarSize;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.shape;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.avatarBitmapQueue;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.overLapSizeDp;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final OAvatar.AvatarSize component1() {
        return this.avatarSize;
    }

    public final OAvatarQueueShape component2() {
        return this.shape;
    }

    public final ArrayList<Bitmap> component3() {
        return this.avatarBitmapQueue;
    }

    public final int component4() {
        return this.overLapSizeDp;
    }

    public final OAvatarInParam copy(OAvatar.AvatarSize r1, OAvatarQueueShape r2, ArrayList<Bitmap> r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "avatarSize");
        Intrinsics.checkNotNullParameter(r2, "shape");
        Intrinsics.checkNotNullParameter(r3, "avatarBitmapQueue");
        return new OAvatarInParam(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OAvatarInParam) == true) goto L8;
        return false;
    L8:
        OAvatarInParam r6 = (OAvatarInParam) r5;
        if (this.avatarSize == r6.avatarSize) goto L12;
        return false;
    L12:
        if (this.shape == r6.shape) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarBitmapQueue, r6.avatarBitmapQueue) == true) goto L18;
        return false;
    L18:
        if (this.overLapSizeDp == r6.overLapSizeDp) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.avatarSize.hashCode() * 31) + this.shape.hashCode()) * 31) + this.avatarBitmapQueue.hashCode()) * 31) + Integer.hashCode(this.overLapSizeDp);
    }

    public String toString() {
        return "OAvatarInParam(avatarSize=" + this.avatarSize + ", shape=" + this.shape + ", avatarBitmapQueue=" + this.avatarBitmapQueue + ", overLapSizeDp=" + this.overLapSizeDp + ')';
    }

    public OAvatarInParam(OAvatar.AvatarSize r2, OAvatarQueueShape r3, ArrayList<Bitmap> r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "avatarSize");
        Intrinsics.checkNotNullParameter(r3, "shape");
        Intrinsics.checkNotNullParameter(r4, "avatarBitmapQueue");
        this.avatarSize = r2;
        this.shape = r3;
        this.avatarBitmapQueue = r4;
        this.overLapSizeDp = r5;
    }

    public /* synthetic */ OAvatarInParam(OAvatar.AvatarSize r1, OAvatarQueueShape r2, ArrayList r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = OAvatar.AvatarSize.DP_16;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = OAvatarQueueShape.Queue;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = new ArrayList();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = 3;
    L14:
        this(r1, r2, r3, r4);
    }

    public final OAvatar.AvatarSize getAvatarSize() {
        return this.avatarSize;
    }

    public final void setAvatarSize(OAvatar.AvatarSize r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.avatarSize = r2;
    }

    public final OAvatarQueueShape getShape() {
        return this.shape;
    }

    public final void setShape(OAvatarQueueShape r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.shape = r2;
    }

    public final ArrayList<Bitmap> getAvatarBitmapQueue() {
        return this.avatarBitmapQueue;
    }

    public final void setAvatarBitmapQueue(ArrayList<Bitmap> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.avatarBitmapQueue = r2;
    }

    public final int getOverLapSizeDp() {
        return this.overLapSizeDp;
    }

    public final void setOverLapSizeDp(int r1) {
        this.overLapSizeDp = r1;
    }
}
