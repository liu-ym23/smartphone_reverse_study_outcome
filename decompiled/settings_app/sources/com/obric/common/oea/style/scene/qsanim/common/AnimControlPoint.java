package com.obric.common.oea.style.scene.qsanim.common;

import com.obric.common.oea.foundation.animation.engine.FloatPropertyCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AnimControlPoint.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\u0000J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/AnimControlPoint;", "", "y", "", "per", "(FF)V", "getPer", "()F", "setPer", "(F)V", "getY", "setY", "copy", "reset", "", "toString", "", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimControlPoint {
    public static final Companion Companion = null;
    private static final FloatPropertyCompat<AnimControlPoint> PROPERTY_Y = null;
    private float per;
    private float y;

    /* JADX INFO: compiled from: AnimControlPoint.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/AnimControlPoint$Companion;", "", "()V", "PROPERTY_Y", "Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;", "Lcom/obric/common/oea/style/scene/qsanim/common/AnimControlPoint;", "getPROPERTY_Y", "()Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final FloatPropertyCompat<AnimControlPoint> getPROPERTY_Y() {
            return AnimControlPoint.access$getPROPERTY_Y$cp();
        }
    }

    public AnimControlPoint(float r1, float r2) {
        this.y = r1;
        this.per = r2;
    }

    public static final /* synthetic */ FloatPropertyCompat access$getPROPERTY_Y$cp() {
        return PROPERTY_Y;
    }

    public final float getY() {
        return this.y;
    }

    public final void setY(float r1) {
        this.y = r1;
    }

    public final float getPer() {
        return this.per;
    }

    public final void setPer(float r1) {
        this.per = r1;
    }

    public final AnimControlPoint copy() {
        return new AnimControlPoint(this.y, this.per);
    }

    public final void reset() {
        this.y = 0.0f;
        this.per = 0.0f;
    }

    public String toString() {
        return "[y: " + this.y + ", per: " + this.per + ']';
    }

    static {
        Companion = new Companion(null);
        final String r1 = "y";
        PROPERTY_Y = new AnimControlPoint$Companion$PROPERTY_Y$1(r1);
    }
}
