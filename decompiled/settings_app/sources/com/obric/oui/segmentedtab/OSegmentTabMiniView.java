package com.obric.oui.segmentedtab;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OSegmentTabMiniView.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u0007J\u0016\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000fH\u0002J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000fJ\u0018\u0010$\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabMiniView;", "Lcom/obric/oui/segmentedtab/OTouchAnimView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "iconView", "Landroid/widget/ImageView;", "originIconAlpha", "selectState", "", "tabTitle", "Landroid/widget/TextView;", "textSelectColor", "textUnselectColor", "canPerFormAnim", "initView", "", "onTouchAnimUpdate", "animFraction", "", "scene", "setOriginIconAlpha", "setOriginTextColor", "selectedTextColor", "unselectedTextColor", "updateIconAlpha", "isSelected", "updateIconAlphaOnPress", "fraction", "updateSelectState", "updateTextAppearanceOnPress", "updateTextColor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSegmentTabMiniView extends OTouchAnimView {
    public static final Companion Companion = null;
    private static Typeface DEFAULT_TYPE_FACE;
    private static Typeface SELECTED_TYPE_FACE;
    private static int instanceId;
    private final String TAG;
    private ImageView iconView;
    private int originIconAlpha;
    private boolean selectState;
    private TextView tabTitle;
    private int textSelectColor;
    private int textUnselectColor;

    /* JADX INFO: compiled from: OSegmentTabMiniView.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabMiniView$Companion;", "", "()V", "DEFAULT_TYPE_FACE", "Landroid/graphics/Typeface;", "SELECTED_TYPE_FACE", "instanceId", "", "getSelectedTypeFace", "typeface", "weight", "newInstance", "Lcom/obric/oui/segmentedtab/OSegmentTabMiniView;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final OSegmentTabMiniView newInstance(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            View r1 = RelativeLayout.inflate(r2, R.layout.o_layout_tab_segment_small, null);
            if (r1 == null) goto L7;
            OSegmentTabMiniView r3 = (OSegmentTabMiniView) r1;
            r3.initView();
            return r3;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.OSegmentTabMiniView");
        }

        public final Typeface getSelectedTypeFace(Typeface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "typeface");
            if (OSegmentTabMiniView.access$getSELECTED_TYPE_FACE$cp() != null) goto L6;
            OSegmentTabMiniView.access$setSELECTED_TYPE_FACE$cp(Typeface.create(r1, r2, false));
        L6:
            return OSegmentTabMiniView.access$getSELECTED_TYPE_FACE$cp();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OSegmentTabMiniView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OSegmentTabMiniView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OSegmentTabMiniView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ Typeface access$getSELECTED_TYPE_FACE$cp() {
        return SELECTED_TYPE_FACE;
    }

    public static final /* synthetic */ void access$setSELECTED_TYPE_FACE$cp(Typeface r0) {
        SELECTED_TYPE_FACE = r0;
    }

    public OSegmentTabMiniView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        int r5 = instanceId;
        instanceId = r5 + 1;
        this.TAG = Intrinsics.stringPlus("OSegmentTabView_", Integer.valueOf(r5));
    }

    public final void initView() {
        View r0 = findViewById(R.id.tv_tab_title_small);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.tv_tab_title_small)");
        TextView r1 = (TextView) r0;
        this.tabTitle = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r1 = null;
    L5:
        Typeface r2 = r1.getTypeface();
        Intrinsics.checkNotNullExpressionValue(r2, "tabTitle.typeface");
        DEFAULT_TYPE_FACE = r2;
        View r3 = findViewById(R.id.tv_tab_icon_small);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.tv_tab_icon_small)");
        this.iconView = (ImageView) r3;
    }

    public final void setOriginTextColor(int r1, int r2) {
        this.textSelectColor = r1;
        this.textUnselectColor = r2;
    }

    public final void setOriginIconAlpha(int r1) {
        this.originIconAlpha = r1;
    }

    public final void updateSelectState(boolean r4) {
        L.d(this.TAG, Intrinsics.stringPlus("updateSelectState, isSelected: ", Boolean.valueOf(r4)));
        this.selectState = r4;
        setSelected(r4);
        updateTextColor(r4);
        updateIconAlpha(r4);
    }

    private final void updateTextColor(boolean r3) {
        TextView r0 = null;
        if (r3 == true) goto L5;
        cancelAnim();
        TextView r4 = this.tabTitle;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
    L16:
        r0.setTextColor(this.textUnselectColor);
        return;
    L15:
        r0 = r4;
        goto L16
    L5:
        if (isAnimRunning() == true) goto L19;
        TextView r5 = this.tabTitle;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
    L11:
        r0.setTextColor(this.textSelectColor);
        return;
    L10:
        r0 = r5;
        goto L11
    }

    private final void updateIconAlpha(boolean r3) {
        ImageView r0 = null;
        if (r3 == true) goto L5;
        cancelAnim();
        ImageView r4 = this.iconView;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L16:
        r0.setImageAlpha(this.originIconAlpha);
        return;
    L15:
        r0 = r4;
        goto L16
    L5:
        if (isAnimRunning() == true) goto L19;
        ImageView r5 = this.iconView;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L11:
        r0.setImageAlpha(this.originIconAlpha);
        return;
    L10:
        r0 = r5;
        goto L11
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public boolean canPerFormAnim() {
        return !this.selectState;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public void onTouchAnimUpdate(float r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        L.d(this.TAG, "onTouchAnimUpdate, scene: " + r5 + ", animFraction: " + r4);
        updateTextAppearanceOnPress(r4, r5);
        updateIconAlphaOnPress(r4, r5);
    }

    private final void updateTextAppearanceOnPress(float r9, String r10) {
        boolean r1 = false;
        if (Intrinsics.areEqual(r10, OTouchAnimView.PRESS_ANIM_SCENE_PRESS) == false) goto L6;
        int r0 = this.textUnselectColor;
    L12:
        if (r0 != 0) goto L14;
        return;
    L14:
        int r2 = (r0 >> 24) & 255;
        int r3 = RangesKt.coerceIn((int) (r2 * OTouchAnimView.Companion.getAnimatedPressAlpha(r9)), 0, 255);
        int r4 = ((r0 >> 16) & 255) << 16;
        int r5 = (r0 & 255) | ((r4 | (r3 << 24)) | (((r0 >> 8) & 255) << 8));
        TextView r6 = this.tabTitle;
        Typeface r7 = null;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r6 = null;
    L17:
        r6.setTextColor(r5);
        TextView r8 = this.tabTitle;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r8 = null;
    L21:
        if (this.selectState == true) goto L23;
    L31:
        Typeface r11 = DEFAULT_TYPE_FACE;
        if (r11 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("DEFAULT_TYPE_FACE");
    L35:
        r8.setTypeface(r7);
        L.d(this.TAG, "updateTextColorOnPress, scene: " + r10 + ", fraction: " + r9 + ", newTextAlpha: " + r3 + ", originTextAlpha: " + r2);
        return;
    L34:
        r7 = r11;
        goto L35
    L23:
        if (r9 != 0.0f) goto L25;
        r1 = true;
    L25:
        if (r1 == false) goto L31;
        Companion r12 = Companion;
        Typeface r13 = DEFAULT_TYPE_FACE;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("DEFAULT_TYPE_FACE");
    L30:
        r7 = r12.getSelectedTypeFace(r7, 500);
        goto L35
    L29:
        r7 = r13;
        goto L30
    L6:
        if (Intrinsics.areEqual(r10, OTouchAnimView.PRESS_ANIM_SCENE_RELEASE) == true) goto L8;
        r0 = 0;
        goto L12
    L8:
        if (this.selectState == false) goto L10;
        r0 = this.textSelectColor;
        goto L12
    L10:
        r0 = this.textUnselectColor;
        goto L12
    }

    private final void updateIconAlphaOnPress(float r5, String r6) {
        int r0 = RangesKt.coerceIn((int) (this.originIconAlpha * OTouchAnimView.Companion.getAnimatedPressAlpha(r5)), 0, 255);
        ImageView r1 = this.iconView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r1 = null;
    L5:
        r1.setImageAlpha(r0);
        L.d(this.TAG, "updateIconAlphaOnPress, scene: " + r6 + ", fraction: " + r5 + ", alpha: " + r0 + ", originIconAlpha: " + this.originIconAlpha);
    }
}
