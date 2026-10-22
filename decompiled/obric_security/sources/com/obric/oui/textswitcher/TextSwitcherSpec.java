package com.obric.oui.textswitcher;

import android.widget.ViewSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\rHÆ\u0003JI\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/obric/oui/textswitcher/TextSwitcherSpec;", "", "textSpec", "Lcom/obric/oui/textswitcher/TextSpec;", "animationSpec", "Lcom/obric/oui/textswitcher/AnimationSpec;", "triggerSpec", "Lcom/obric/oui/textswitcher/TextSwitcherTriggerSpec;", "dataSpec", "Lcom/obric/oui/textswitcher/TextSwitcherDataSpec;", "viewFactory", "Landroid/widget/ViewSwitcher$ViewFactory;", "isSupportMarquee", "", "(Lcom/obric/oui/textswitcher/TextSpec;Lcom/obric/oui/textswitcher/AnimationSpec;Lcom/obric/oui/textswitcher/TextSwitcherTriggerSpec;Lcom/obric/oui/textswitcher/TextSwitcherDataSpec;Landroid/widget/ViewSwitcher$ViewFactory;Z)V", "getAnimationSpec", "()Lcom/obric/oui/textswitcher/AnimationSpec;", "getDataSpec", "()Lcom/obric/oui/textswitcher/TextSwitcherDataSpec;", "()Z", "getTextSpec", "()Lcom/obric/oui/textswitcher/TextSpec;", "getTriggerSpec", "()Lcom/obric/oui/textswitcher/TextSwitcherTriggerSpec;", "getViewFactory", "()Landroid/widget/ViewSwitcher$ViewFactory;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextSwitcherSpec {
    private final AnimationSpec animationSpec;
    private final TextSwitcherDataSpec dataSpec;
    private final boolean isSupportMarquee;
    private final TextSpec textSpec;
    private final TextSwitcherTriggerSpec triggerSpec;
    private final ViewSwitcher.ViewFactory viewFactory;

    public TextSwitcherSpec() {
        this(null, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ TextSwitcherSpec copy$default(TextSwitcherSpec r4, TextSpec r5, AnimationSpec r6, TextSwitcherTriggerSpec r7, TextSwitcherDataSpec r8, ViewSwitcher.ViewFactory r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.textSpec;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.animationSpec;
    L8:
        AnimationSpec r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.triggerSpec;
    L11:
        TextSwitcherTriggerSpec r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.dataSpec;
    L14:
        TextSwitcherDataSpec r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.viewFactory;
    L17:
        ViewSwitcher.ViewFactory r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.isSupportMarquee;
    L20:
        TextSpec r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final TextSpec component1() {
        return this.textSpec;
    }

    public final AnimationSpec component2() {
        return this.animationSpec;
    }

    public final TextSwitcherTriggerSpec component3() {
        return this.triggerSpec;
    }

    public final TextSwitcherDataSpec component4() {
        return this.dataSpec;
    }

    public final ViewSwitcher.ViewFactory component5() {
        return this.viewFactory;
    }

    public final boolean component6() {
        return this.isSupportMarquee;
    }

    public final TextSwitcherSpec copy(TextSpec r8, AnimationSpec r9, TextSwitcherTriggerSpec r10, TextSwitcherDataSpec r11, ViewSwitcher.ViewFactory r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r8, "textSpec");
        Intrinsics.checkNotNullParameter(r9, "animationSpec");
        Intrinsics.checkNotNullParameter(r10, "triggerSpec");
        return new TextSwitcherSpec(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextSwitcherSpec) == true) goto L8;
        return false;
    L8:
        TextSwitcherSpec r6 = (TextSwitcherSpec) r5;
        if (Intrinsics.areEqual(this.textSpec, r6.textSpec) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.animationSpec, r6.animationSpec) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.triggerSpec, r6.triggerSpec) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dataSpec, r6.dataSpec) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.viewFactory, r6.viewFactory) == true) goto L24;
        return false;
    L24:
        if (this.isSupportMarquee == r6.isSupportMarquee) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r0 = ((((this.textSpec.hashCode() * 31) + this.animationSpec.hashCode()) * 31) + this.triggerSpec.hashCode()) * 31;
        TextSwitcherDataSpec r1 = this.dataSpec;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ViewSwitcher.ViewFactory r5 = this.viewFactory;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        boolean r7 = this.isSupportMarquee;
        ?? r8 = r7;
        if (r7 == false) goto L14;
        r8 = 1;
    L14:
        return r6 + r8;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TextSwitcherSpec(textSpec=" + this.textSpec + ", animationSpec=" + this.animationSpec + ", triggerSpec=" + this.triggerSpec + ", dataSpec=" + this.dataSpec + ", viewFactory=" + this.viewFactory + ", isSupportMarquee=" + this.isSupportMarquee + ')';
    }

    public TextSwitcherSpec(TextSpec r2, AnimationSpec r3, TextSwitcherTriggerSpec r4, TextSwitcherDataSpec r5, ViewSwitcher.ViewFactory r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "textSpec");
        Intrinsics.checkNotNullParameter(r3, "animationSpec");
        Intrinsics.checkNotNullParameter(r4, "triggerSpec");
        this.textSpec = r2;
        this.animationSpec = r3;
        this.triggerSpec = r4;
        this.dataSpec = r5;
        this.viewFactory = r6;
        this.isSupportMarquee = r7;
    }

    public /* synthetic */ TextSwitcherSpec(TextSpec r13, AnimationSpec r14, TextSwitcherTriggerSpec r15, TextSwitcherDataSpec r16, ViewSwitcher.ViewFactory r17, boolean r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 1) == 0) goto L5;
        TextSpec r0 = new TextSpec(null, null, null, 7, null);
    L6:
        ViewSwitcher.ViewFactory r2 = null;
        if ((r19 & 2) == 0) goto L9;
        AnimationSpec r1 = new AnimationSpec(null, null, 3, null);
    L11:
        if ((r19 & 4) == 0) goto L13;
        TextSwitcherTriggerSpec r3 = new TextSwitcherTriggerSpec(0, 0, false, 7, null);
    L15:
        if ((r19 & 8) == 0) goto L17;
        TextSwitcherDataSpec r4 = null;
    L19:
        if ((r19 & 16) != 0) goto L23;
        r2 = r17;
    L23:
        if ((r19 & 32) == 0) goto L25;
        boolean r5 = false;
    L26:
        this(r0, r1, r3, r4, r2, r5);
        return;
    L25:
        r5 = r18;
        goto L26
    L17:
        r4 = r16;
        goto L19
    L13:
        r3 = r15;
        goto L15
    L9:
        r1 = r14;
        goto L11
    L5:
        r0 = r13;
        goto L6
    }

    public final TextSpec getTextSpec() {
        return this.textSpec;
    }

    public final AnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final TextSwitcherTriggerSpec getTriggerSpec() {
        return this.triggerSpec;
    }

    public final TextSwitcherDataSpec getDataSpec() {
        return this.dataSpec;
    }

    public final ViewSwitcher.ViewFactory getViewFactory() {
        return this.viewFactory;
    }

    public final boolean isSupportMarquee() {
        return this.isSupportMarquee;
    }
}
