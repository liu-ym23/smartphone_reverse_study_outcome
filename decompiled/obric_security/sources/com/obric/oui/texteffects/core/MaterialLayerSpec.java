package com.obric.oui.texteffects.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/texteffects/core/MaterialLayerSpec;", "", "blurDirection", "Lcom/obric/oui/texteffects/core/Direction;", "(Lcom/obric/oui/texteffects/core/Direction;)V", "getBlurDirection", "()Lcom/obric/oui/texteffects/core/Direction;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialLayerSpec {
    private final Direction blurDirection;

    public static /* synthetic */ MaterialLayerSpec copy$default(MaterialLayerSpec r0, Direction r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.blurDirection;
    L6:
        return r0.copy(r1);
    }

    public final Direction component1() {
        return this.blurDirection;
    }

    public final MaterialLayerSpec copy(Direction r1) {
        Intrinsics.checkNotNullParameter(r1, "blurDirection");
        return new MaterialLayerSpec(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MaterialLayerSpec) == true) goto L9;
        return false;
    L9:
        if (this.blurDirection == ((MaterialLayerSpec) r4).blurDirection) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.blurDirection.hashCode();
    }

    public String toString() {
        return "MaterialLayerSpec(blurDirection=" + this.blurDirection + ')';
    }

    public MaterialLayerSpec(Direction r2) {
        Intrinsics.checkNotNullParameter(r2, "blurDirection");
        this.blurDirection = r2;
    }

    public final Direction getBlurDirection() {
        return this.blurDirection;
    }
}
