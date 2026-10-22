package com.obric.common.oea.style.scene.search;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatableKt;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.style.R;
import com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SearchModeSwitchAnimHelperType1.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0016\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010 \u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/common/oea/style/scene/search/SearchModeSwitchAnimHelperType1;", "Lcom/obric/common/oea/style/scene/common/AbstractModeSwitchAnimComposer;", "()V", "cancelButton", "Landroid/view/View;", "searchBox", "searchBoxAffiliatedContent", "", "searchBoxContainer", "searchBoxFullWidth", "", "searchBoxParentContent", "searchBoxShrunkWidth", "searchBoxTransitionY", "addSearchBoxAffiliatedContent", "view", "hideViewWhenAlphaBecomeZero", "", "addSearchBoxParentContent", "enterWithoutAnim", "", "exitWithoutAnim", "handleSingleEnterAnimEnd", "finished", "handleSingleExitAnimEnd", "hideViewIfNeeded", "makeEnterAnims", "", "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "makeExitAnims", "release", "setCancelButton", "setSearchBox", "fullWidth", "targetWidth", "transitionY", "setSearchBoxContainer", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchModeSwitchAnimHelperType1 extends AbstractModeSwitchAnimComposer {
    public static final Companion Companion = null;
    private static final String TAG = "SearchTransitionAnimHelperType1";
    private View cancelButton;
    private View searchBox;
    private List<View> searchBoxAffiliatedContent;
    private View searchBoxContainer;
    private int searchBoxFullWidth;
    private List<View> searchBoxParentContent;
    private int searchBoxShrunkWidth;
    private int searchBoxTransitionY;

    /* JADX INFO: compiled from: SearchModeSwitchAnimHelperType1.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/style/scene/search/SearchModeSwitchAnimHelperType1$Companion;", "", "()V", "TAG", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SearchModeSwitchAnimHelperType1() {
        super(1000);
        this.searchBoxFullWidth = -1;
    }

    public final SearchModeSwitchAnimHelperType1 setSearchBox(View r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.searchBox = r2;
        this.searchBoxFullWidth = r3;
        this.searchBoxShrunkWidth = r4;
        this.searchBoxTransitionY = r5;
        return this;
    }

    public final SearchModeSwitchAnimHelperType1 setCancelButton(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.cancelButton = r2;
        if (r3 == false) goto L5;
        r2.setTag(R.id.anim_tag_view_gone_when_alpha_become_zero, true);
    L5:
        return this;
    }

    public final SearchModeSwitchAnimHelperType1 setSearchBoxContainer(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.searchBoxContainer = r2;
        return this;
    }

    public final SearchModeSwitchAnimHelperType1 addSearchBoxAffiliatedContent(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (this.searchBoxAffiliatedContent != null) goto L5;
        this.searchBoxAffiliatedContent = new ArrayList();
    L5:
        List<View> r0 = this.searchBoxAffiliatedContent;
        if (r0 == null) goto L8;
        r0.add(r2);
    L8:
        if (r3 == false) goto L10;
        r2.setTag(R.id.anim_tag_view_gone_when_alpha_become_zero, true);
    L10:
        return this;
    }

    public final SearchModeSwitchAnimHelperType1 addSearchBoxParentContent(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (this.searchBoxParentContent != null) goto L5;
        this.searchBoxParentContent = new ArrayList();
    L5:
        List<View> r0 = this.searchBoxParentContent;
        if (r0 == null) goto L8;
        r0.add(r2);
    L8:
        if (r3 == false) goto L10;
        r2.setTag(R.id.anim_tag_view_gone_when_alpha_become_zero, true);
    L10:
        return this;
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void release() {
        super.release();
        View r1 = (View) null;
        this.searchBox = null;
        this.cancelButton = null;
        this.searchBoxContainer = null;
        List r2 = (List) null;
        this.searchBoxAffiliatedContent = null;
        this.searchBoxParentContent = null;
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public List<PropertyAnimatable.Builder> makeEnterAnims() {
        ArrayList r1 = new ArrayList();
        View r2 = this.searchBoxContainer;
        if (r2 == null) goto L5;
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r2, 0.0f, 1, null), AnimationProperty.FloatProperty.TRANSLATION_Y, Float.valueOf(r2.getTranslationY()), this.searchBoxTransitionY, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 16, null));
    L5:
        List<View> r3 = this.searchBoxAffiliatedContent;
        if (r3 == null) goto L14;
        Iterator<T> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        View r8 = (View) r4.next();
        if (r8.getVisibility() == 0) goto L13;
        r8.setVisibility(0);
        r8.setAlpha(0.0f);
    L13:
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r8, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r8.getAlpha()), 1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_IN_QUAD), null, 16, null), AnimationProperty.FloatProperty.TRANSLATION_Y, Float.valueOf(r8.getTranslationY()), this.searchBoxTransitionY, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 16, null));
    L14:
        View r5 = this.searchBox;
        if (r5 != null) goto L17;
    L20:
        View r6 = this.cancelButton;
        if (r6 != null) goto L23;
    L26:
        List<View> r0 = this.searchBoxParentContent;
        if (r0 == null) goto L32;
        Iterator<T> r7 = r0.iterator();
    L30:
        if (r7.hasNext() == false) goto L32;
        View r9 = (View) r7.next();
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r9, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r9.getAlpha()), 0.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null, 16, null));
    L32:
        return r1;
    L23:
        if (r6.getVisibility() == 0) goto L25;
        r6.setVisibility(0);
        r6.setAlpha(0.0f);
    L25:
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r6, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r6.getAlpha()), 1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, Token.Delay.OUI_ANIMATION_DELAY_SHORT_2, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null, 16, null));
        goto L26
    L17:
        if (this.searchBoxShrunkWidth > 0) goto L19;
        Log.w(TAG, "enterSearchMode cant play search box width anim, searchBoxFullWidth < 0");
        goto L20
    L19:
        r1.add(PropertyAnimatable.Builder.ofInt$default(PropertyAnimatableKt.animator$default(r5, 0.0f, 1, null), AnimationProperty.IntProperty.WIDTH, Integer.valueOf(r5.getWidth()), this.searchBoxShrunkWidth, AnimationSpecKt.springInt$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 16, null));
        goto L20
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void handleSingleEnterAnimEnd(View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (r4 == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r3.getTag(R.id.anim_tag_view_gone_when_alpha_become_zero), true) == false) goto L13;
        List<View> r2 = this.searchBoxParentContent;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.contains(r3) != true) goto L15;
        r3.setVisibility(8);
        return;
    L15:
        return;
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public List<PropertyAnimatable.Builder> makeExitAnims() {
        ArrayList r1 = new ArrayList();
        View r2 = this.searchBoxContainer;
        if (r2 == null) goto L5;
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r2, 0.0f, 1, null), AnimationProperty.FloatProperty.TRANSLATION_Y, Float.valueOf(r2.getTranslationY()), 0.0f, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1, 0, 4, null), null, 16, null));
    L5:
        List<View> r3 = this.searchBoxAffiliatedContent;
        if (r3 == null) goto L11;
        Iterator<T> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        View r8 = (View) r4.next();
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r8, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r8.getAlpha()), 0.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null, 16, null), AnimationProperty.FloatProperty.TRANSLATION_Y, Float.valueOf(r8.getTranslationY()), 0.0f, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1, 0, 4, null), null, 16, null));
    L11:
        View r5 = this.searchBox;
        if (r5 != null) goto L14;
    L17:
        View r6 = this.cancelButton;
        if (r6 == null) goto L20;
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r6, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r6.getAlpha()), 0.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_1, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_LINEAR), null, 16, null));
    L20:
        List<View> r0 = this.searchBoxParentContent;
        if (r0 == null) goto L26;
        Iterator<T> r7 = r0.iterator();
    L24:
        if (r7.hasNext() == false) goto L26;
        View r9 = (View) r7.next();
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r9, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r9.getAlpha()), 1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_IN_QUAD), null, 16, null));
    L26:
        return r1;
    L14:
        if (this.searchBoxFullWidth > 0) goto L16;
        Log.e(TAG, "searchBoxFullWidth <= 0: " + this.searchBoxFullWidth);
        goto L17
    L16:
        r1.add(PropertyAnimatable.Builder.ofInt$default(PropertyAnimatableKt.animator$default(r5, 0.0f, 1, null), AnimationProperty.IntProperty.WIDTH, Integer.valueOf(r5.getWidth()), this.searchBoxFullWidth, AnimationSpecKt.springInt$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1, 0, 4, null), null, 16, null));
        goto L17
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void handleSingleExitAnimEnd(View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (r4 == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r3.getTag(R.id.anim_tag_view_gone_when_alpha_become_zero), true) == false) goto L16;
        List<View> r5 = this.searchBoxAffiliatedContent;
        if (r5 == null) goto L13;
        if (r5.contains(r3) != true) goto L13;
        r3.setVisibility(8);
        return;
    L13:
        if (Intrinsics.areEqual(this.cancelButton, r3) == false) goto L18;
        r3.setVisibility(8);
        return;
    L18:
        return;
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void enterWithoutAnim() {
        super.enterWithoutAnim();
        View r0 = this.searchBoxContainer;
        if (r0 == null) goto L5;
        r0.setTranslationY(this.searchBoxTransitionY);
    L5:
        List<View> r1 = this.searchBoxAffiliatedContent;
        if (r1 == null) goto L14;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        View r3 = (View) r2.next();
        if (r3.getVisibility() == 0) goto L13;
        r3.setVisibility(0);
    L13:
        r3.setAlpha(1.0f);
        r3.setTranslationY(this.searchBoxTransitionY);
    L14:
        View r4 = this.searchBox;
        if (r4 == null) goto L19;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof ViewGroup.LayoutParams) == false) goto L19;
        r5.width = RangesKt.coerceAtLeast(this.searchBoxShrunkWidth, 0);
        r4.setLayoutParams(r5);
    L19:
        View r6 = this.cancelButton;
        if (r6 != null) goto L22;
    L25:
        List<View> r7 = this.searchBoxParentContent;
        if (r7 == null) goto L31;
        Iterator<T> r8 = r7.iterator();
    L29:
        if (r8.hasNext() == false) goto L36;
        View r9 = (View) r8.next();
        r9.setAlpha(0.0f);
        hideViewIfNeeded(r9);
        goto L29
    L36:
        return;
    L31:
        return;
    L22:
        if (r6.getVisibility() == 0) goto L24;
        r6.setVisibility(0);
    L24:
        r6.setAlpha(1.0f);
        goto L25
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void exitWithoutAnim() {
        super.exitWithoutAnim();
        View r0 = this.searchBoxContainer;
        if (r0 == null) goto L5;
        r0.setTranslationY(0.0f);
    L5:
        List<View> r1 = this.searchBoxAffiliatedContent;
        if (r1 == null) goto L11;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        View r3 = (View) r2.next();
        r3.setAlpha(0.0f);
        r3.setTranslationY(0.0f);
        hideViewIfNeeded(r3);
    L11:
        View r4 = this.searchBox;
        if (r4 == null) goto L16;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof ViewGroup.LayoutParams) == false) goto L16;
        r5.width = RangesKt.coerceAtLeast(this.searchBoxFullWidth, 0);
        r4.setLayoutParams(r5);
    L16:
        View r6 = this.cancelButton;
        if (r6 == null) goto L19;
        r6.setAlpha(0.0f);
        hideViewIfNeeded(r6);
    L19:
        List<View> r7 = this.searchBoxParentContent;
        if (r7 == null) goto L25;
        Iterator<T> r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L28;
        ((View) r8.next()).setAlpha(1.0f);
        goto L23
    L28:
        return;
    }

    private final void hideViewIfNeeded(View r2) {
        if (Intrinsics.areEqual(r2.getTag(R.id.anim_tag_view_gone_when_alpha_become_zero), true) == false) goto L6;
        r2.setVisibility(8);
        return;
    }
}
