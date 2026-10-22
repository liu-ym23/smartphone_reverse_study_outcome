package com.obric.oui.texteffects.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/obric/oui/texteffects/core/PropertyTrack;", "", "property", "Lcom/obric/oui/texteffects/core/EffectProperty;", "keyframes", "", "Lcom/obric/oui/texteffects/core/Keyframe;", "easing", "Lcom/obric/oui/texteffects/core/EasingSpec;", "selector", "Lcom/obric/oui/texteffects/core/SelectorSpec;", "(Lcom/obric/oui/texteffects/core/EffectProperty;Ljava/util/List;Lcom/obric/oui/texteffects/core/EasingSpec;Lcom/obric/oui/texteffects/core/SelectorSpec;)V", "getEasing", "()Lcom/obric/oui/texteffects/core/EasingSpec;", "getKeyframes", "()Ljava/util/List;", "getProperty", "()Lcom/obric/oui/texteffects/core/EffectProperty;", "getSelector", "()Lcom/obric/oui/texteffects/core/SelectorSpec;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PropertyTrack {
    private final EasingSpec easing;
    private final List<Keyframe> keyframes;
    private final EffectProperty property;
    private final SelectorSpec selector;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PropertyTrack copy$default(PropertyTrack r0, EffectProperty r1, List r2, EasingSpec r3, SelectorSpec r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.property;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.keyframes;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.easing;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.selector;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final EffectProperty component1() {
        return this.property;
    }

    public final List<Keyframe> component2() {
        return this.keyframes;
    }

    public final EasingSpec component3() {
        return this.easing;
    }

    public final SelectorSpec component4() {
        return this.selector;
    }

    public final PropertyTrack copy(EffectProperty r1, List<Keyframe> r2, EasingSpec r3, SelectorSpec r4) {
        Intrinsics.checkNotNullParameter(r1, "property");
        Intrinsics.checkNotNullParameter(r2, "keyframes");
        Intrinsics.checkNotNullParameter(r3, "easing");
        Intrinsics.checkNotNullParameter(r4, "selector");
        return new PropertyTrack(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PropertyTrack) == true) goto L8;
        return false;
    L8:
        PropertyTrack r6 = (PropertyTrack) r5;
        if (this.property == r6.property) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keyframes, r6.keyframes) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.easing, r6.easing) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selector, r6.selector) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.property.hashCode() * 31) + this.keyframes.hashCode()) * 31) + this.easing.hashCode()) * 31) + this.selector.hashCode();
    }

    public String toString() {
        return "PropertyTrack(property=" + this.property + ", keyframes=" + this.keyframes + ", easing=" + this.easing + ", selector=" + this.selector + ')';
    }

    public PropertyTrack(EffectProperty r2, List<Keyframe> r3, EasingSpec r4, SelectorSpec r5) {
        Intrinsics.checkNotNullParameter(r2, "property");
        Intrinsics.checkNotNullParameter(r3, "keyframes");
        Intrinsics.checkNotNullParameter(r4, "easing");
        Intrinsics.checkNotNullParameter(r5, "selector");
        this.property = r2;
        this.keyframes = r3;
        this.easing = r4;
        this.selector = r5;
    }

    public final EffectProperty getProperty() {
        return this.property;
    }

    public final List<Keyframe> getKeyframes() {
        return this.keyframes;
    }

    public /* synthetic */ PropertyTrack(EffectProperty r1, List r2, EasingSpec.Linear r3, SelectorSpec.All r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = EasingSpec.Linear.INSTANCE;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = SelectorSpec.All.INSTANCE;
    L8:
        this(r1, r2, r3, r4);
    }

    public final EasingSpec getEasing() {
        return this.easing;
    }

    public final SelectorSpec getSelector() {
        return this.selector;
    }
}
