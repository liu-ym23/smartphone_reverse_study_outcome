package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oui.R;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.indicator.IndicatorExternalsKt;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.KtExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OListItemGeneral.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u0010\u0010S\u001a\u0002052\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020WH\u0016J\u000e\u0010X\u001a\u0002052\u0006\u0010O\u001a\u00020PJ\b\u0010Y\u001a\u00020NH\u0016J\u001a\u0010Z\u001a\u00020N2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0003J0\u0010[\u001a\u00020N2\u0006\u0010\\\u001a\u0002052\u0006\u0010]\u001a\u00020W2\u0006\u0010^\u001a\u00020W2\u0006\u0010_\u001a\u00020W2\u0006\u0010`\u001a\u00020WH\u0014J\u0018\u0010a\u001a\u00020N2\u0006\u0010b\u001a\u00020W2\u0006\u0010c\u001a\u00020WH\u0014J(\u0010d\u001a\u00020N2\u0006\u0010e\u001a\u00020W2\u0006\u0010f\u001a\u00020W2\u0006\u0010g\u001a\u00020W2\u0006\u0010h\u001a\u00020WH\u0014J\u000e\u0010i\u001a\u00020N2\u0006\u0010j\u001a\u000205J&\u0010k\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010mJ\u0010\u0010n\u001a\u00020N2\u0006\u0010j\u001a\u000205H\u0016J\u0010\u0010o\u001a\u00020N2\b\u0010p\u001a\u0004\u0018\u00010RJ\u0010\u0010q\u001a\u00020N2\u0006\u0010r\u001a\u000205H\u0016J\u0010\u0010s\u001a\u00020N2\b\u0010t\u001a\u0004\u0018\u00010\bJ\u0010\u0010u\u001a\u00020N2\b\u0010p\u001a\u0004\u0018\u00010RJ\u001a\u0010u\u001a\u00020N2\b\u0010p\u001a\u0004\u0018\u00010R2\b\u0010l\u001a\u0004\u0018\u00010mJ\b\u0010v\u001a\u000205H\u0016J\u0006\u0010w\u001a\u00020NR(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010)\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001a\u0010,\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R&\u00106\u001a\u0002052\u0006\u0010\u0007\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u0002052\u0006\u0010\u0007\u001a\u000205@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R$\u0010>\u001a\u0002052\u0006\u0010\u0007\u001a\u000205@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R(\u0010B\u001a\u0004\u0018\u00010A2\b\u0010\u0007\u001a\u0004\u0018\u00010A@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010G\u001a\u0004\u0018\u00010A2\b\u0010\u0007\u001a\u0004\u0018\u00010A@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR(\u0010J\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000b\"\u0004\bL\u0010\r¨\u0006x"}, d2 = {"Lcom/obric/oui/lisitem/OListItemGeneral;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Landroid/graphics/drawable/Drawable;", "contentImage", "getContentImage", "()Landroid/graphics/drawable/Drawable;", "setContentImage", "(Landroid/graphics/drawable/Drawable;)V", "mClContent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMClContent", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMClContent", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mContentElement", "Landroid/widget/FrameLayout;", "getMContentElement", "()Landroid/widget/FrameLayout;", "setMContentElement", "(Landroid/widget/FrameLayout;)V", "", "mContentElementWidth", "getMContentElementWidth", "()F", "setMContentElementWidth", "(F)V", "mIvContent", "Landroid/widget/ImageView;", "getMIvContent", "()Landroid/widget/ImageView;", "setMIvContent", "(Landroid/widget/ImageView;)V", "mLeadingElement", "getMLeadingElement", "setMLeadingElement", "mTrailingElement", "getMTrailingElement", "setMTrailingElement", "mTvSubtitle", "Landroid/widget/TextView;", "getMTvSubtitle", "()Landroid/widget/TextView;", "setMTvSubtitle", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "", "showBackground", "getShowBackground", "()Z", "setShowBackground", "(Z)V", "showDivider", "getShowDivider", "setShowDivider", "showPreDefineBackground", "getShowPreDefineBackground", "setShowPreDefineBackground", "", "subTitleString", "getSubTitleString", "()Ljava/lang/CharSequence;", "setSubTitleString", "(Ljava/lang/CharSequence;)V", "titleString", "getTitleString", "setTitleString", "trailingImage", "getTrailingImage", "setTrailingImage", "addChildToParent", "", "parent", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getContentDefaultOneChildWidth", "", "hasChildVisible", "inflateContent", "init", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setAlpha", IndexDatabaseHelper.IndexColumns.ENABLED, "setChildToParent", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setEnabled", "setLeadingView", "view", "setSelected", MaterialConfigFormatNames.SELECTED, "setTrailingImageView", "drawable", "setTrailingView", "shouldUpdateDividerColorOnPress", "updateState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemGeneral extends OUIFrameLayout {
    private Drawable contentImage;
    public ConstraintLayout mClContent;
    public FrameLayout mContentElement;
    private float mContentElementWidth;
    public ImageView mIvContent;
    public FrameLayout mLeadingElement;
    public FrameLayout mTrailingElement;
    public TextView mTvSubtitle;
    public TextView mTvTitle;
    private boolean showBackground;
    private boolean showDivider;
    private boolean showPreDefineBackground;
    private CharSequence subTitleString;
    private CharSequence titleString;
    private Drawable trailingImage;

    /* JADX WARN: Multi-variable type inference failed */
    public OListItemGeneral(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return true;
    }

    public /* synthetic */ OListItemGeneral(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OListItemGeneral(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, 0, null, 12, null);
        init(r9, r10);
    }

    public final FrameLayout getMLeadingElement() {
        FrameLayout r0 = this.mLeadingElement;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeadingElement");
        return null;
    }

    public final void setMLeadingElement(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mLeadingElement = r2;
    }

    public final FrameLayout getMTrailingElement() {
        FrameLayout r0 = this.mTrailingElement;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTrailingElement");
        return null;
    }

    public final void setMTrailingElement(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mTrailingElement = r2;
    }

    public final FrameLayout getMContentElement() {
        FrameLayout r0 = this.mContentElement;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
        return null;
    }

    public final void setMContentElement(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mContentElement = r2;
    }

    public final ImageView getMIvContent() {
        ImageView r0 = this.mIvContent;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mIvContent");
        return null;
    }

    public final void setMIvContent(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mIvContent = r2;
    }

    public final TextView getMTvTitle() {
        TextView r0 = this.mTvTitle;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        return null;
    }

    public final void setMTvTitle(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mTvTitle = r2;
    }

    public final TextView getMTvSubtitle() {
        TextView r0 = this.mTvSubtitle;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTvSubtitle");
        return null;
    }

    public final void setMTvSubtitle(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mTvSubtitle = r2;
    }

    public final ConstraintLayout getMClContent() {
        ConstraintLayout r0 = this.mClContent;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mClContent");
        return null;
    }

    public final void setMClContent(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mClContent = r2;
    }

    public final CharSequence getTitleString() {
        return this.titleString;
    }

    public final void setTitleString(CharSequence r1) {
        this.titleString = r1;
        getMTvTitle().setText(r1);
    }

    public final CharSequence getSubTitleString() {
        return this.subTitleString;
    }

    public final void setSubTitleString(CharSequence r1) {
        this.subTitleString = r1;
        if (TextUtils.isEmpty(r1) == false) goto L5;
        ViewExtensionsKt.makeGone(getMTvSubtitle());
        return;
    L5:
        ViewExtensionsKt.makeVisible(getMTvSubtitle());
        getMTvSubtitle().setText(this.subTitleString);
    }

    public final Drawable getContentImage() {
        return this.contentImage;
    }

    public final void setContentImage(Drawable r2) {
        this.contentImage = r2;
        if (r2 == null) goto L5;
        getMIvContent().setImageDrawable(this.contentImage);
        getMIvContent().setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        updateState();
        return;
    L5:
        getMIvContent().setVisibility(8);
        goto L6
    }

    public final Drawable getTrailingImage() {
        return this.trailingImage;
    }

    public final void setTrailingImage(Drawable r1) {
        this.trailingImage = r1;
        setTrailingImageView(r1);
    }

    public final void setShowBackground(boolean r1) {
        this.showBackground = r1;
        setShowPreDefineBackground(r1);
    }

    public final boolean getShowBackground() {
        return this.showPreDefineBackground;
    }

    public final boolean getShowPreDefineBackground() {
        return this.showPreDefineBackground;
    }

    public final void setShowPreDefineBackground(boolean r4) {
        this.showPreDefineBackground = r4;
        if (getBackground() != null) goto L10;
        ColorDrawable r0 = null;
        if (r4 == false) goto L7;
        r0 = new ColorDrawable(getResources().getColor(R.color.oui_fill_list_item_card, null));
    L8:
        setBackground(r0);
        return;
    L7:
        Drawable r5 = (Drawable) null;
        goto L8
    }

    public final boolean getShowDivider() {
        return this.showDivider;
    }

    public final void setShowDivider(final boolean r3) {
        this.showDivider = r3;
        final OListItemGeneral r0 = this;
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(r0, new OListItemGeneral$special$$inlined$doOnPreDraw$1(r0, r3, this)), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final float getMContentElementWidth() {
        return this.mContentElementWidth;
    }

    public final void setMContentElementWidth(float r2) {
        this.mContentElementWidth = r2;
        if (r2 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        IndicatorExternalsKt.setWidth(getMContentElement(), (int) r2);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setAlpha(boolean r1) {
        if (r1 == true) goto L4;
        float r2 = 0.3f;
    L5:
        setAlpha(r2);
        return;
    L4:
        r2 = 1.0f;
        goto L5
    }

    public void inflateContent() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_general, this);
    }

    private final void init(Context r4, AttributeSet r5) {
        inflateContent();
        ViewParent r0 = (ViewGroup) findViewById(R.id.ll_root);
        KtExt r1 = KtExt.INSTANCE;
        if (r0 != null) goto L6;
    L4:
        r0 = null;
    L7:
        IOUIAlpha r2 = (IOUIAlpha) r0;
        if (r2 == null) goto L11;
        r2.setChangeAlphaWhenPress(false);
    L11:
        View r3 = findViewById(R.id.fl_leading_element);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.fl_leading_element)");
        setMLeadingElement((FrameLayout) r3);
        View r6 = findViewById(R.id.fl_trailing_element);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.fl_trailing_element)");
        setMTrailingElement((FrameLayout) r6);
        View r7 = findViewById(R.id.fl_content_element);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.fl_content_element)");
        setMContentElement((FrameLayout) r7);
        View r8 = findViewById(R.id.iv_content_img);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.iv_content_img)");
        setMIvContent((ImageView) r8);
        View r9 = findViewById(R.id.cl_content_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.cl_content_container)");
        setMClContent((ConstraintLayout) r9);
        View r10 = findViewById(R.id.tv_content_title);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.tv_content_title)");
        setMTvTitle((TextView) r10);
        View r11 = findViewById(R.id.tv_content_subtitle);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.tv_content_subtitle)");
        setMTvSubtitle((TextView) r11);
        TypedArray r12 = r4.obtainStyledAttributes(r5, R.styleable.OListItemGeneral);
        setTitleString(r12.getString(R.styleable.OListItemGeneral_oui_list_item_title));
        setSubTitleString(r12.getString(R.styleable.OListItemGeneral_oui_list_item_subtitle));
        setTrailingImage(r12.getDrawable(R.styleable.OListItemGeneral_oui_list_item_trailing_image));
        setContentImage(r12.getDrawable(R.styleable.OListItemGeneral_oui_list_item_content_image));
        setShowPreDefineBackground(r12.getBoolean(R.styleable.OListItemGeneral_oui_list_item_show_background, true));
        setShowDivider(r12.getBoolean(R.styleable.OListItemGeneral_oui_list_item_show_divider, false));
        setMContentElementWidth(r12.getDimension(R.styleable.OListItemGeneral_oui_list_item_content_width, 0.0f));
        r12.recycle();
        setRadius((int) getResources().getDimension(R.dimen.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r0 instanceof IOUIAlpha) == false) goto L4;
        goto L4
    }

    public final void setLeadingView(View r8) {
        if (r8 == null) goto L5;
        setChildToParent$default(this, getMLeadingElement(), r8, null, 4, null);
        return;
    }

    public final void setTrailingView(View r3) {
        if (r3 == null) goto L5;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 8388629;
        setChildToParent(getMTrailingElement(), r3, r0);
        return;
    }

    public final void setTrailingView(View r2, FrameLayout.LayoutParams r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L5;
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        r4.gravity = 8388629;
        r3 = r4;
    L5:
        setChildToParent(getMTrailingElement(), r2, r3);
        return;
    }

    public static /* synthetic */ void setChildToParent$default(OListItemGeneral r0, ViewGroup r1, View r2, ViewGroup.LayoutParams r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.setChildToParent(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setChildToParent");
    }

    public final void setChildToParent(ViewGroup r1, View r2, ViewGroup.LayoutParams r3) {
        if (r2 == null) goto L16;
        if (r1 == null) goto L6;
        ViewExtensionsKt.makeVisible(r1);
    L6:
        if (r1 == null) goto L9;
        r1.removeAllViews();
    L9:
        if (r3 != null) goto L13;
        if (r1 == null) goto L22;
        r1.addView(r2);
        return;
    L22:
        return;
    L13:
        if (r1 == null) goto L23;
        r1.addView(r2, r3);
        return;
    L23:
        return;
    L16:
        if (r1 == null) goto L24;
        ViewExtensionsKt.makeGone(r1);
        return;
    }

    public final void addChildToParent(ViewGroup r1, View r2) {
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        ViewExtensionsKt.makeVisible(r1);
    L6:
        if (r1 == null) goto L14;
        r1.addView(r2);
        return;
    L14:
        return;
    L9:
        if (r1 == null) goto L15;
        ViewExtensionsKt.makeGone(r1);
        return;
    }

    public final void setTrailingImageView(Drawable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ImageView r0 = new ImageView(getContext());
        r0.setImageDrawable(r3);
        setTrailingView(r0);
    }

    public final boolean hasChildVisible(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        int r3 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L9;
        int r2 = r1 + 1;
        if (r4.getChildAt(r1).getVisibility() == 0) goto L6;
        r1 = r2;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final void updateState() {
        if (hasChildVisible(getMContentElement()) == false) goto L5;
        IndicatorExternalsKt.setWidth(getMContentElement(), getContentDefaultOneChildWidth());
    L7:
        if (this.mContentElementWidth != 0.0f) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        IndicatorExternalsKt.setWidth(getMContentElement(), (int) this.mContentElementWidth);
        return;
    L13:
        return;
    L9:
        r0 = false;
        goto L10
    L5:
        IndicatorExternalsKt.setWidth(getMContentElement(), MathKt.roundToInt(getResources().getDimension(R.dimen.oui_listitem_content_width_empty)));
        goto L7
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }

    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(getResources().getDimension(R.dimen.oui_listitem_content_width_middle));
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r2);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        getAlphaHelper().onSelectedChanged(this, r2);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        if (r2 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        setShowDivider(this.showDivider);
    }
}
