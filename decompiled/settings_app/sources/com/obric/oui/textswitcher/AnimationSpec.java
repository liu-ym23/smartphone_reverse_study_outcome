package com.obric.oui.textswitcher;

import android.icu.text.PluralRules;
import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/textswitcher/AnimationSpec;", "", "inAnimation", "Landroid/view/animation/Animation;", "outAnimation", "(Landroid/view/animation/Animation;Landroid/view/animation/Animation;)V", "getInAnimation", "()Landroid/view/animation/Animation;", "getOutAnimation", "component1", "component2", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimationSpec {
    private final Animation inAnimation;
    private final Animation outAnimation;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimationSpec() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnimationSpec copy$default(AnimationSpec r0, Animation r1, Animation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.inAnimation;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.outAnimation;
    L9:
        return r0.copy(r1, r2);
    }

    public final Animation component1() {
        return this.inAnimation;
    }

    public final Animation component2() {
        return this.outAnimation;
    }

    public final AnimationSpec copy(Animation r1, Animation r2) {
        return new AnimationSpec(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AnimationSpec) == true) goto L8;
        return false;
    L8:
        AnimationSpec r6 = (AnimationSpec) r5;
        if (Intrinsics.areEqual(this.inAnimation, r6.inAnimation) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.outAnimation, r6.outAnimation) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Animation r0 = this.inAnimation;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Animation r4 = this.outAnimation;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AnimationSpec(inAnimation=" + this.inAnimation + ", outAnimation=" + this.outAnimation + ')';
    }

    public AnimationSpec(Animation r1, Animation r2) {
        this.inAnimation = r1;
        this.outAnimation = r2;
    }

    public /* synthetic */ AnimationSpec(Animation r2, Animation r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Animation getInAnimation() {
        return this.inAnimation;
    }

    public final Animation getOutAnimation() {
        return this.outAnimation;
    }
}
