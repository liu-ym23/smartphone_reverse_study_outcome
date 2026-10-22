package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.shadow.ShadowConfig;
import com.obric.oui.shadow.ShadowConfigCore;
import com.obric.oui.shadow.ShadowTokenCore;
import com.obric.oui.utils.ViewUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class OUILayoutHelper implements IOUILayout {
    public static final int RADIUS_OF_HALF_VIEW_HEIGHT = -1;
    public static final int RADIUS_OF_HALF_VIEW_WIDTH = -2;
    public static final String TAG = "OUILayoutHelper";
    private boolean adaptNoXmlConstruct;
    private float dividerColorStrength;
    private Shadow firstShadow;
    private final Shadow firstShadowForDraw;
    private AttributeSet mAttributeSet;
    private int mBLRadius;
    private int mBRRadius;
    private int mBorderColor;
    private RectF mBorderRect;
    private int mBorderWidth;
    private int mBottomDividerAlpha;
    private int mBottomDividerColor;
    private int mBottomDividerHeight;
    private int mBottomDividerInsetLeft;
    private int mBottomDividerInsetRight;
    private Paint mClipPaint;
    private Context mContext;
    private int mDefAttr;
    private int mDefStyle;
    private Paint mDividerPaint;
    private boolean mEnableShadowWithRadius;
    private int mHeightLimit;
    private int mHeightMini;
    private boolean mIsOutlineExcludePadding;
    private boolean mIsShowBorderOnlyBeforeL;
    private boolean mIsSupportMirroring;
    private int mLeftDividerAlpha;
    private int mLeftDividerColor;
    private int mLeftDividerInsetBottom;
    private int mLeftDividerInsetTop;
    private int mLeftDividerWidth;
    private PorterDuffXfermode mMode;
    private int mOuterNormalColor;
    private int mOutlineInsetBottom;
    private int mOutlineInsetLeft;
    private int mOutlineInsetRight;
    private int mOutlineInsetTop;
    private WeakReference<View> mOwner;
    private Path mPath;
    private int mRadius;
    private float[] mRadiusArray;
    private int mRightDividerAlpha;
    private int mRightDividerColor;
    private int mRightDividerInsetBottom;
    private int mRightDividerInsetTop;
    private int mRightDividerWidth;
    private float mShadowAlpha;
    private int mShadowColor;
    private int mShadowElevation;
    private int mShadowInsetX;
    private int mShadowInsetY;
    private Path mShadowPath;
    private boolean mShadowVisible;
    private boolean mShouldUseRadiusArray;
    private int mTLRadius;
    private int mTRRadius;
    private int mTopDividerAlpha;
    private int mTopDividerColor;
    private int mTopDividerHeight;
    private int mTopDividerInsetLeft;
    private int mTopDividerInsetRight;
    private int mWidthLimit;
    private int mWidthMini;
    private Shadow secondShadow;
    private final Shadow secondShadowForDraw;
    private float shadowCornerRadius;

    public static boolean useFeature() {
        return true;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onPressAlphaChange(int r1) {
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return false;
    }

    static /* synthetic */ int access$000(OUILayoutHelper r0) {
        return r0.getRealRadius();
    }

    static /* synthetic */ boolean access$100(OUILayoutHelper r0) {
        return r0.mShouldUseRadiusArray;
    }

    static /* synthetic */ int access$1000(OUILayoutHelper r0) {
        return r0.mOutlineInsetRight;
    }

    static /* synthetic */ boolean access$1100(OUILayoutHelper r0) {
        return r0.mIsOutlineExcludePadding;
    }

    static /* synthetic */ float access$1200(OUILayoutHelper r0) {
        return r0.mShadowAlpha;
    }

    static /* synthetic */ int access$1300(OUILayoutHelper r0) {
        return r0.mShadowElevation;
    }

    static /* synthetic */ int access$200(OUILayoutHelper r0) {
        return r0.mTLRadius;
    }

    static /* synthetic */ int access$300(OUILayoutHelper r0) {
        return r0.mTRRadius;
    }

    static /* synthetic */ int access$400(OUILayoutHelper r0) {
        return r0.mBRRadius;
    }

    static /* synthetic */ int access$500(OUILayoutHelper r0) {
        return r0.mBLRadius;
    }

    static /* synthetic */ boolean access$600(OUILayoutHelper r0) {
        return r0.mEnableShadowWithRadius;
    }

    static /* synthetic */ int access$700(OUILayoutHelper r0) {
        return r0.mOutlineInsetTop;
    }

    static /* synthetic */ int access$800(OUILayoutHelper r0) {
        return r0.mOutlineInsetBottom;
    }

    static /* synthetic */ int access$900(OUILayoutHelper r0) {
        return r0.mOutlineInsetLeft;
    }

    public OUILayoutHelper(Context r4, AttributeSet r5, int r6, int r7) {
        this.mWidthLimit = 0;
        this.mHeightLimit = 0;
        this.mWidthMini = 0;
        this.mHeightMini = 0;
        this.mTopDividerHeight = 0;
        this.mTopDividerInsetLeft = 0;
        this.mTopDividerInsetRight = 0;
        this.mTopDividerAlpha = 255;
        this.mBottomDividerHeight = 0;
        this.mBottomDividerInsetLeft = 0;
        this.mBottomDividerInsetRight = 0;
        this.mBottomDividerAlpha = 255;
        this.mLeftDividerWidth = 0;
        this.mLeftDividerInsetTop = 0;
        this.mLeftDividerInsetBottom = 0;
        this.mLeftDividerAlpha = 255;
        this.mRightDividerWidth = 0;
        this.mRightDividerInsetTop = 0;
        this.mRightDividerInsetBottom = 0;
        this.mRightDividerAlpha = 255;
        this.dividerColorStrength = 1.0f;
        this.mTLRadius = 0;
        this.mTRRadius = 0;
        this.mBLRadius = 0;
        this.mBRRadius = 0;
        this.mEnableShadowWithRadius = false;
        this.mBorderColor = 0;
        this.mBorderWidth = 1;
        this.mOuterNormalColor = 0;
        this.mIsOutlineExcludePadding = false;
        this.mPath = new Path();
        this.mShadowPath = null;
        this.mIsShowBorderOnlyBeforeL = true;
        this.mShadowElevation = 0;
        this.mShadowColor = -16777216;
        this.mShadowInsetX = 0;
        this.mShadowInsetY = 0;
        this.mOutlineInsetLeft = 0;
        this.mOutlineInsetRight = 0;
        this.mOutlineInsetTop = 0;
        this.mOutlineInsetBottom = 0;
        this.mIsSupportMirroring = false;
        this.adaptNoXmlConstruct = false;
        this.mShadowVisible = true;
        this.firstShadow = Shadow.NONE.copy();
        this.secondShadow = Shadow.NONE.copy();
        this.firstShadowForDraw = Shadow.NONE.copy();
        this.secondShadowForDraw = Shadow.NONE.copy();
        this.shadowCornerRadius = 0.0f;
        this.mContext = r4;
        this.mAttributeSet = r5;
        this.mDefAttr = r6;
        this.mDefStyle = r7;
    }

    public OUILayoutHelper(Context r2, AttributeSet r3, int r4, View r5) {
        this(r2, r3, r4, 0);
        initView(r5);
    }

    public void setAdaptNoXmlConstruct(boolean r1) {
        this.adaptNoXmlConstruct = r1;
    }

    public void initView(View r18) {
        float r1 = r18.getResources().getDisplayMetrics().density;
        this.mOwner = new WeakReference(r18);
        int r2 = ContextCompat.getColor(this.mContext, R.color.oui_line_2);
        this.mTopDividerColor = r2;
        this.mBottomDividerColor = r2;
        int r3 = ContextCompat.getColor(this.mContext, R.color.oui_line_2);
        this.mRightDividerColor = r3;
        this.mLeftDividerColor = r3;
        this.mMode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r4 = new Paint();
        this.mClipPaint = r4;
        r4.setAntiAlias(true);
        float r5 = OUIResHelper.getAttrFloatValue(this.mContext, R.attr.oui_general_shadow_alpha);
        if (r5 <= 0.0f) goto L5;
        this.mShadowAlpha = r5;
    L5:
        this.mBorderRect = new RectF();
        int r6 = 0;
        if (this.adaptNoXmlConstruct == false) goto L8;
    L15:
        TypedArray r7 = this.mContext.obtainStyledAttributes(this.mAttributeSet, R.styleable.OUILayout, this.mDefAttr, this.mDefStyle);
        int r8 = r7.getIndexCount();
        int r9 = 0;
        int r10 = 0;
        boolean r11 = false;
        int r16 = 0;
    L16:
        if (r9 >= r8) goto L132;
        int r12 = r7.getIndex(r9);
        if (r12 != R.styleable.OUILayout_android_maxWidth) goto L21;
        this.mWidthLimit = r7.getDimensionPixelSize(r12, this.mWidthLimit);
    L123:
        if (r12 != R.styleable.OUILayout_oui_bottomLeft_radius) goto L126;
        this.mBLRadius = r7.getDimensionPixelSize(r12, 0);
    L126:
        if (r12 != R.styleable.OUILayout_oui_bottomRight_radius) goto L129;
        this.mBRRadius = r7.getDimensionPixelSize(r12, 0);
    L129:
        if (r12 != R.styleable.OUILayout_oui_topRight_radius) goto L131;
        this.mTRRadius = r7.getDimensionPixelSize(r12, 0);
    L131:
        r9 = r9 + 1;
        goto L16
    L21:
        if (r12 != R.styleable.OUILayout_android_maxHeight) goto L24;
        this.mHeightLimit = r7.getDimensionPixelSize(r12, this.mHeightLimit);
        goto L123
    L24:
        if (r12 != R.styleable.OUILayout_android_minWidth) goto L27;
        this.mWidthMini = r7.getDimensionPixelSize(r12, this.mWidthMini);
        goto L123
    L27:
        if (r12 != R.styleable.OUILayout_android_minHeight) goto L30;
        this.mHeightMini = r7.getDimensionPixelSize(r12, this.mHeightMini);
        goto L123
    L30:
        if (r12 != R.styleable.OUILayout_oui_topDividerColor) goto L33;
        this.mTopDividerColor = r7.getColor(r12, this.mTopDividerColor);
        goto L123
    L33:
        if (r12 != R.styleable.OUILayout_oui_topDividerHeight) goto L36;
        this.mTopDividerHeight = r7.getDimensionPixelSize(r12, this.mTopDividerHeight);
        goto L123
    L36:
        if (r12 != R.styleable.OUILayout_oui_topDividerInsetLeft) goto L39;
        this.mTopDividerInsetLeft = r7.getDimensionPixelSize(r12, this.mTopDividerInsetLeft);
        goto L123
    L39:
        if (r12 != R.styleable.OUILayout_oui_topDividerInsetRight) goto L42;
        this.mTopDividerInsetRight = r7.getDimensionPixelSize(r12, this.mTopDividerInsetRight);
        goto L123
    L42:
        if (r12 != R.styleable.OUILayout_oui_bottomDividerColor) goto L45;
        this.mBottomDividerColor = r7.getColor(r12, this.mBottomDividerColor);
        goto L123
    L45:
        if (r12 != R.styleable.OUILayout_oui_bottomDividerHeight) goto L48;
        this.mBottomDividerHeight = r7.getDimensionPixelSize(r12, this.mBottomDividerHeight);
        goto L123
    L48:
        if (r12 != R.styleable.OUILayout_oui_bottomDividerInsetLeft) goto L51;
        this.mBottomDividerInsetLeft = r7.getDimensionPixelSize(r12, this.mBottomDividerInsetLeft);
        goto L123
    L51:
        if (r12 != R.styleable.OUILayout_oui_bottomDividerInsetRight) goto L54;
        this.mBottomDividerInsetRight = r7.getDimensionPixelSize(r12, this.mBottomDividerInsetRight);
        goto L123
    L54:
        if (r12 != R.styleable.OUILayout_oui_leftDividerColor) goto L57;
        this.mLeftDividerColor = r7.getColor(r12, this.mLeftDividerColor);
        goto L123
    L57:
        if (r12 != R.styleable.OUILayout_oui_leftDividerWidth) goto L60;
        this.mLeftDividerWidth = r7.getDimensionPixelSize(r12, this.mLeftDividerWidth);
        goto L123
    L60:
        if (r12 != R.styleable.OUILayout_oui_leftDividerInsetTop) goto L63;
        this.mLeftDividerInsetTop = r7.getDimensionPixelSize(r12, this.mLeftDividerInsetTop);
        goto L123
    L63:
        if (r12 != R.styleable.OUILayout_oui_leftDividerInsetBottom) goto L66;
        this.mLeftDividerInsetBottom = r7.getDimensionPixelSize(r12, this.mLeftDividerInsetBottom);
        goto L123
    L66:
        if (r12 != R.styleable.OUILayout_oui_rightDividerColor) goto L69;
        this.mRightDividerColor = r7.getColor(r12, this.mRightDividerColor);
        goto L123
    L69:
        if (r12 != R.styleable.OUILayout_oui_rightDividerWidth) goto L72;
        this.mRightDividerWidth = r7.getDimensionPixelSize(r12, this.mRightDividerWidth);
        goto L123
    L72:
        if (r12 != R.styleable.OUILayout_oui_rightDividerInsetTop) goto L75;
        this.mRightDividerInsetTop = r7.getDimensionPixelSize(r12, this.mRightDividerInsetTop);
        goto L123
    L75:
        if (r12 != R.styleable.OUILayout_oui_rightDividerInsetBottom) goto L78;
        this.mRightDividerInsetBottom = r7.getDimensionPixelSize(r12, this.mRightDividerInsetBottom);
        goto L123
    L78:
        if (r12 != R.styleable.OUILayout_oui_layout_borderColor) goto L81;
        this.mBorderColor = r7.getColor(r12, this.mBorderColor);
        goto L123
    L81:
        if (r12 != R.styleable.OUILayout_oui_layout_borderWidth) goto L84;
        this.mBorderWidth = r7.getDimensionPixelSize(r12, this.mBorderWidth);
        goto L123
    L84:
        if (r12 != R.styleable.OUILayout_oui_radius) goto L87;
        r16 = r7.getDimensionPixelSize(r12, 0);
        goto L123
    L87:
        if (r12 != R.styleable.OUILayout_oui_outerNormalColor) goto L90;
        this.mOuterNormalColor = r7.getColor(r12, this.mOuterNormalColor);
        goto L123
    L90:
        if (r12 != R.styleable.OUILayout_oui_showBorderOnlyBeforeL) goto L93;
        this.mIsShowBorderOnlyBeforeL = r7.getBoolean(r12, this.mIsShowBorderOnlyBeforeL);
        goto L123
    L93:
        if (r12 != R.styleable.OUILayout_oui_shadowElevation) goto L96;
        r10 = r7.getDimensionPixelSize(r12, r10);
        goto L123
    L96:
        if (r12 != R.styleable.OUILayout_oui_shadowAlpha) goto L99;
        this.mShadowAlpha = r7.getFloat(r12, this.mShadowAlpha);
        goto L123
    L99:
        if (r12 != R.styleable.OUILayout_oui_useThemeGeneralShadowElevation) goto L102;
        r11 = r7.getBoolean(r12, false);
        goto L123
    L102:
        if (r12 != R.styleable.OUILayout_oui_outlineInsetLeft) goto L105;
        this.mOutlineInsetLeft = r7.getDimensionPixelSize(r12, 0);
        goto L123
    L105:
        if (r12 != R.styleable.OUILayout_oui_outlineInsetRight) goto L108;
        this.mOutlineInsetRight = r7.getDimensionPixelSize(r12, 0);
        goto L123
    L108:
        if (r12 != R.styleable.OUILayout_oui_outlineInsetTop) goto L111;
        this.mOutlineInsetTop = r7.getDimensionPixelSize(r12, 0);
        goto L123
    L111:
        if (r12 != R.styleable.OUILayout_oui_outlineInsetBottom) goto L114;
        this.mOutlineInsetBottom = r7.getDimensionPixelSize(r12, 0);
        goto L123
    L114:
        if (r12 != R.styleable.OUILayout_oui_outlineExcludePadding) goto L117;
        this.mIsOutlineExcludePadding = r7.getBoolean(r12, false);
        goto L123
    L117:
        if (r12 != R.styleable.OUILayout_oui_support_image_mirroring) goto L120;
        this.mIsSupportMirroring = r7.getBoolean(r12, false);
        goto L123
    L120:
        if (r12 != R.styleable.OUILayout_oui_topLeft_radius) goto L123;
        this.mTLRadius = r7.getDimensionPixelSize(r12, 0);
        goto L123
    L132:
        ShadowConfigCore[] r13 = ShadowTokenCore.parse(r7.getString(R.styleable.OUILayout_oui_shadow));
        if (r13 == null) goto L137;
        this.firstShadow.updateFromConfig(r13[0], r1);
        if (r13.length <= 1) goto L141;
        this.secondShadow.updateFromConfig(r13[1], r1);
    L141:
        this.firstShadowForDraw.update(this.firstShadow);
        this.secondShadowForDraw.update(this.secondShadow);
        this.shadowCornerRadius = r7.getDimension(R.styleable.OUILayout_oui_shadowCornerRadius, 0.0f);
        r7.recycle();
        r6 = r10;
        int r14 = r16;
    L142:
        if (r6 != 0) goto L145;
        if (r11 == false) goto L145;
        r6 = OUIResHelper.getAttrDimen(this.mContext, R.attr.oui_general_shadow_elevation);
    L145:
        setRadiusAndShadow(r14, r6, this.mShadowAlpha);
        return;
    L137:
        int r15 = r7.getResourceId(R.styleable.OUILayout_oui_shadow_style, 0);
        if (r15 == 0) goto L140;
        applyShadowStyleFromResource(this.mContext, r15);
        goto L141
    L140:
        this.firstShadow.updateFromConfig(ShadowConfig.fromStyleRes(r7, R.styleable.OUILayout_oui_firstShadowColor, R.styleable.OUILayout_oui_firstShadowBlur, R.styleable.OUILayout_oui_firstOffsetX, R.styleable.OUILayout_oui_firstOffsetY, R.styleable.OUILayout_oui_firstShadowSpread));
        this.secondShadow.updateFromConfig(ShadowConfig.fromStyleRes(r7, R.styleable.OUILayout_oui_secondShadowColor, R.styleable.OUILayout_oui_secondShadowBlur, R.styleable.OUILayout_oui_secondOffsetX, R.styleable.OUILayout_oui_secondOffsetY, R.styleable.OUILayout_oui_secondShadowSpread));
        goto L141
    L8:
        if (this.mAttributeSet != null) goto L15;
        if (this.mDefAttr != 0) goto L15;
        if (this.mDefStyle != 0) goto L15;
        r14 = 0;
        r11 = false;
        goto L142
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowStyle(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        applyShadowStyleFromResource(this.mContext, r2);
        this.firstShadowForDraw.update(this.firstShadow);
        this.secondShadowForDraw.update(this.secondShadow);
        invalidate();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowInsets(int r1, int r2) {
        this.mShadowInsetX = r1;
        this.mShadowInsetY = r2;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowCornerRadius(int r1) {
        this.shadowCornerRadius = r1;
    }

    private void applyShadowStyleFromResource(Context r8, int r9) {
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.OUILayout);
        this.firstShadow.updateFromConfig(ShadowConfig.fromStyleRes(r10, R.styleable.OUILayout_oui_firstShadowColor, R.styleable.OUILayout_oui_firstShadowBlur, R.styleable.OUILayout_oui_firstOffsetX, R.styleable.OUILayout_oui_firstOffsetY, R.styleable.OUILayout_oui_firstShadowSpread));
        this.secondShadow.updateFromConfig(ShadowConfig.fromStyleRes(r10, R.styleable.OUILayout_oui_secondShadowColor, R.styleable.OUILayout_oui_secondShadowBlur, R.styleable.OUILayout_oui_secondOffsetX, R.styleable.OUILayout_oui_secondOffsetY, R.styleable.OUILayout_oui_secondShadowSpread));
        r10.recycle();
    }

    public static List<Shadow> createShadowListFromAttr(Context r2, TypedArray r3, int r4) {
        List<Shadow> r0 = extractShadowInfo(r2, r3.getString(r4));
        if (r0 == null) goto L6;
        ArrayList r5 = new ArrayList(2);
        r5.addAll(r0);
        return r5;
    L6:
        int r6 = r3.getResourceId(r4, 0);
        if (r6 != 0) goto L10;
        return null;
    L10:
        List<Shadow> r7 = extractShadowInfo(r2, r6);
        ArrayList r8 = new ArrayList(2);
        r8.addAll(r7);
        return r8;
    }

    public static List<Shadow> extractShadowInfo(Context r5, String r6) {
        ShadowConfigCore[] r7 = ShadowTokenCore.parse(r6);
        if (r7 != null) goto L6;
        return null;
    L6:
        float r8 = r5.getResources().getDisplayMetrics().density;
        ArrayList r0 = new ArrayList();
        Shadow r1 = Shadow.fromConfigWithDensity(r7[0], r8);
        Shadow r2 = Shadow.NONE;
        if (r7.length <= 1) goto L9;
        r2 = Shadow.fromConfigWithDensity(r7[1], r8);
    L9:
        r0.add(r1);
        r0.add(r2);
        return r0;
    }

    public static List<Shadow> extractShadowInfo(Context r8, int r9) {
        ArrayList r0 = new ArrayList();
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.OUILayout);
        Shadow r11 = Shadow.fromConfig(ShadowConfig.fromStyleRes(r10, R.styleable.OUILayout_oui_firstShadowColor, R.styleable.OUILayout_oui_firstShadowBlur, R.styleable.OUILayout_oui_firstOffsetX, R.styleable.OUILayout_oui_firstOffsetY, R.styleable.OUILayout_oui_firstShadowSpread));
        Shadow r1 = Shadow.fromConfig(ShadowConfig.fromStyleRes(r10, R.styleable.OUILayout_oui_secondShadowColor, R.styleable.OUILayout_oui_secondShadowBlur, R.styleable.OUILayout_oui_secondOffsetX, R.styleable.OUILayout_oui_secondOffsetY, R.styleable.OUILayout_oui_secondShadowSpread));
        r10.recycle();
        r0.add(r11);
        r0.add(r1);
        return r0;
    }

    private static void initShadow(TypedArray r1, Shadow r2, int r3, int r4, int r5, int r6, int r7) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.setColor(r1.getColor(r3, Color.parseColor("#00000000")));
        r2.setRadius(r1.getDimension(r4, 0.0f));
        r2.setOffsetX(r1.getDimension(r5, 0.0f));
        r2.setOffsetY(r1.getDimension(r6, 0.0f));
        r2.setSpread(r1.getDimension(r7, 0.0f));
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setUseThemeGeneralShadowElevation() {
        int r0 = OUIResHelper.getAttrDimen(this.mContext, R.attr.oui_general_shadow_elevation);
        this.mShadowElevation = r0;
        setRadiusAndShadow(this.mRadius, r0, this.mShadowAlpha);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineExcludePadding(boolean r2) {
        if (useFeature() == false) goto L9;
        View r0 = this.mOwner.get();
        if (r0 != null) goto L7;
        return;
    L7:
        this.mIsOutlineExcludePadding = r2;
        r0.invalidateOutline();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setWidthLimit(int r2) {
        if (this.mWidthLimit == r2) goto L6;
        this.mWidthLimit = r2;
        return true;
    L6:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setHeightLimit(int r2) {
        if (this.mHeightLimit == r2) goto L6;
        this.mHeightLimit = r2;
        return true;
    L6:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r1) {
        this.mWidthMini = r1;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftSeparatorColor(int r2) {
        if (this.mLeftDividerColor == r2) goto L6;
        this.mLeftDividerColor = r2;
        invalidate();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomSeparatorColor(int r2) {
        if (this.mBottomDividerColor == r2) goto L6;
        this.mBottomDividerColor = r2;
        invalidate();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopSeparatorColor(int r2) {
        if (this.mTopDividerColor == r2) goto L6;
        this.mTopDividerColor = r2;
        invalidate();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightSeparatorColor(int r2) {
        if (this.mRightDividerColor == r2) goto L6;
        this.mRightDividerColor = r2;
        invalidate();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateDividerColorStrength(float r2) {
        if (this.dividerColorStrength == r2) goto L6;
        this.dividerColorStrength = r2;
        invalidate();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowElevation() {
        return this.mShadowElevation;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public float getShadowAlpha() {
        return this.mShadowAlpha;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.mShadowColor;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineInset(int r2, int r3, int r4, int r5) {
        if (useFeature() == false) goto L9;
        View r0 = this.mOwner.get();
        if (r0 != null) goto L7;
        return;
    L7:
        this.mOutlineInsetLeft = r2;
        this.mOutlineInsetRight = r4;
        this.mOutlineInsetTop = r3;
        this.mOutlineInsetBottom = r5;
        r0.invalidateOutline();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.mIsShowBorderOnlyBeforeL = r1;
        invalidate();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowElevation(int r2) {
        if (this.mShadowElevation != r2) goto L5;
        return;
    L5:
        this.mShadowElevation = r2;
        invalidateOutline();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowAlpha(float r2) {
        if (this.mShadowAlpha != r2) goto L5;
        return;
    L5:
        this.mShadowAlpha = r2;
        invalidateOutline();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowColor(int r2) {
        if (this.mShadowColor != r2) goto L5;
        return;
    L5:
        this.mShadowColor = r2;
        setShadowColorInner(r2);
    }

    private void setShadowColorInner(int r1) {
        View r0 = this.mOwner.get();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setOutlineAmbientShadowColor(r1);
        r0.setOutlineSpotShadowColor(r1);
    }

    private void invalidateOutline() {
        if (useFeature() == false) goto L13;
        View r0 = this.mOwner.get();
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = this.mShadowElevation;
        if (r1 != 0) goto L10;
        r0.setElevation(0.0f);
    L11:
        r0.invalidateOutline();
        return;
    L10:
        r0.setElevation(r1);
        goto L11
    }

    private void invalidate() {
        View r0 = this.mOwner.get();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.invalidate();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r3) {
        if (this.mRadius == r3) goto L6;
        setRadiusAndShadow(r3, this.mShadowElevation, this.mShadowAlpha);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r1, int r2, int r3, int r4) {
        this.mTLRadius = r1;
        this.mTRRadius = r2;
        this.mBLRadius = r3;
        this.mBRRadius = r4;
        setRadiusAndShadow(this.mRadius, this.mShadowElevation, this.mShadowAlpha);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getRadius() {
        return this.mRadius;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setEnableShadowWidthRadius(boolean r1) {
        this.mEnableShadowWithRadius = r1;
        updateClipToOutline();
        invalidate();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isEnableShadowWidthRadius() {
        return this.mEnableShadowWithRadius;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r2, int r3, float r4) {
        setRadiusAndShadow(r2, r3, this.mShadowColor, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r4, int r5, int r6, float r7) {
        View r0 = this.mOwner.get();
        if (r0 != null) goto L5;
        return;
    L5:
        this.mRadius = r4;
        if (this.shadowCornerRadius != 0.0f) goto L8;
        this.shadowCornerRadius = r4;
    L8:
        this.mShouldUseRadiusArray = isRadiusWithSideHidden();
        this.mShadowElevation = r5;
        this.mShadowAlpha = r7;
        this.mShadowColor = r6;
        if (useFeature() == false) goto L18;
        int r8 = this.mShadowElevation;
        if (r8 != 0) goto L13;
    L16:
        r0.setElevation(0.0f);
    L17:
        setShadowColorInner(this.mShadowColor);
        r0.setOutlineProvider(new AnonymousClass1(this));
        updateClipToOutline();
        goto L18
    L13:
        if (this.mShouldUseRadiusArray == true) goto L16;
        r0.setElevation(r8);
    L18:
        r0.invalidate();
    }

    private void updateClipToOutline() {
        View r0 = this.mOwner.get();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (this.mEnableShadowWithRadius == false) goto L8;
        r0.setClipToOutline(false);
        return;
    L8:
        int r3 = this.mRadius;
        if (r3 != (-2)) goto L11;
    L13:
        r2 = true;
    L14:
        r0.setClipToOutline(r2);
        return;
    L11:
        if (r3 == (-1)) goto L13;
        if (r3 <= 0) goto L14;
        goto L13
    }

    public boolean isRadiusWithSideHidden() {
        if (this.mBLRadius <= 0) goto L5;
    L12:
        return true;
    L5:
        if (this.mTRRadius > 0) goto L12;
        if (this.mTLRadius > 0) goto L12;
        if (this.mBRRadius > 0) goto L12;
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopDivider(int r1, int r2, int r3, int r4) {
        this.mTopDividerInsetLeft = r1;
        this.mTopDividerInsetRight = r2;
        this.mTopDividerHeight = r3;
        this.mTopDividerColor = r4;
        requestDraw();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomDivider(int r1, int r2, int r3, int r4) {
        this.mBottomDividerInsetLeft = r1;
        this.mBottomDividerInsetRight = r2;
        this.mBottomDividerColor = r4;
        this.mBottomDividerHeight = r3;
        requestDraw();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftDivider(int r1, int r2, int r3, int r4) {
        this.mLeftDividerInsetTop = r1;
        this.mLeftDividerInsetBottom = r2;
        this.mLeftDividerWidth = r3;
        this.mLeftDividerColor = r4;
        requestDraw();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightDivider(int r1, int r2, int r3, int r4) {
        this.mRightDividerInsetTop = r1;
        this.mRightDividerInsetBottom = r2;
        this.mRightDividerWidth = r3;
        this.mRightDividerColor = r4;
        requestDraw();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowTopDivider(int r1, int r2, int r3, int r4) {
        updateTopDivider(r1, r2, r3, r4);
        this.mLeftDividerWidth = 0;
        this.mRightDividerWidth = 0;
        this.mBottomDividerHeight = 0;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowBottomDivider(int r1, int r2, int r3, int r4) {
        updateBottomDivider(r1, r2, r3, r4);
        this.mLeftDividerWidth = 0;
        this.mRightDividerWidth = 0;
        this.mTopDividerHeight = 0;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowLeftDivider(int r1, int r2, int r3, int r4) {
        updateLeftDivider(r1, r2, r3, r4);
        this.mRightDividerWidth = 0;
        this.mTopDividerHeight = 0;
        this.mBottomDividerHeight = 0;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowRightDivider(int r1, int r2, int r3, int r4) {
        updateRightDivider(r1, r2, r3, r4);
        this.mLeftDividerWidth = 0;
        this.mTopDividerHeight = 0;
        this.mBottomDividerHeight = 0;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setTopDividerAlpha(int r1) {
        this.mTopDividerAlpha = r1;
        requestDraw();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBottomDividerAlpha(int r1) {
        this.mBottomDividerAlpha = r1;
        requestDraw();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setLeftDividerAlpha(int r1) {
        this.mLeftDividerAlpha = r1;
        requestDraw();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRightDividerAlpha(int r1) {
        this.mRightDividerAlpha = r1;
        requestDraw();
    }

    public int handleMiniWidth(int r3, int r4) {
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L8;
        int r2 = this.mWidthMini;
        if (r4 >= r2) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r2, 1073741824);
    L8:
        return r3;
    }

    public int handleMiniHeight(int r3, int r4) {
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L8;
        int r2 = this.mHeightMini;
        if (r4 >= r2) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r2, 1073741824);
    L8:
        return r3;
    }

    public int getMeasuredWidthSpec(int r3) {
        if (this.mWidthLimit > 0) goto L5;
        return r3;
    L5:
        if (View.MeasureSpec.getSize(r3) > this.mWidthLimit) goto L7;
        return r3;
    L7:
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.mWidthLimit, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.mWidthLimit, 1073741824);
    }

    public int getMeasuredHeightSpec(int r3) {
        if (this.mHeightLimit > 0) goto L5;
        return r3;
    L5:
        if (View.MeasureSpec.getSize(r3) > this.mHeightLimit) goto L7;
        return r3;
    L7:
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.mHeightLimit, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.mHeightLimit, 1073741824);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderColor(int r1) {
        this.mBorderColor = r1;
        requestDraw();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderWidth(int r1) {
        this.mBorderWidth = r1;
        requestDraw();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOuterNormalColor(int r1) {
        this.mOuterNormalColor = r1;
        requestDraw();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasTopSeparator() {
        if (this.mTopDividerHeight <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasRightSeparator() {
        if (this.mRightDividerWidth <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBottomSeparator() {
        if (this.mBottomDividerHeight <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasLeftSeparator() {
        if (this.mLeftDividerWidth <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBorder() {
        if (this.mBorderWidth <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(Shadow r2, Shadow r3) {
        setShadow(r2, r3, false);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(Shadow r2, Shadow r3, boolean r4) {
        if (r2 != null) goto L4;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.equals(this.secondShadow) == true) goto L22;
    L8:
        if (r4 == true) goto L14;
        if (r2 != null) goto L11;
        r2 = Shadow.NONE.copy();
    L11:
        if (r3 != null) goto L13;
        r3 = Shadow.NONE.copy();
    L13:
        this.firstShadow = r2;
        this.secondShadow = r3;
        this.firstShadowForDraw.update(r2);
        this.secondShadowForDraw.update(r3);
    L19:
        invalidate();
        return;
    L14:
        if (r2 != null) goto L16;
        r2 = Shadow.NONE.copy();
    L16:
        if (r3 != null) goto L18;
        r3 = Shadow.NONE.copy();
    L18:
        ArrayList r5 = new ArrayList(2);
        r5.add(r2);
        r5.add(r3);
        ArrayList r6 = new ArrayList(2);
        r6.add(this.firstShadowForDraw.copy());
        r6.add(this.secondShadowForDraw.copy());
        ShadowAnimator.startAnim(this, r6, r5);
        goto L19
    L22:
        return;
    L4:
        if (r2.equals(this.firstShadow) == false) goto L8;
        goto L5
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public List<Shadow> getCurrentShadows() {
        ArrayList r0 = new ArrayList(2);
        Shadow r1 = this.firstShadowForDraw;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        Shadow r2 = this.secondShadowForDraw;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        return r0;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateShadows(List<Shadow> r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L10;
        this.firstShadowForDraw.update(r3.get(0));
        if (r3.size() <= 1) goto L9;
        this.secondShadowForDraw.update(r3.get(1));
        goto L10
    L9:
        this.secondShadowForDraw.reset();
    L10:
        invalidate();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowVisible(boolean r2, boolean r3) {
        if (this.mShadowVisible == r2) goto L16;
        this.mShadowVisible = r2;
        if (r3 == false) goto L11;
        ArrayList r4 = new ArrayList(2);
        r4.add(this.firstShadowForDraw.copy());
        r4.add(this.secondShadowForDraw.copy());
        ArrayList r0 = new ArrayList(2);
        if (this.mShadowVisible == false) goto L9;
        r0.add(this.firstShadow);
        r0.add(this.secondShadow);
    L10:
        ShadowAnimator.startVisibilityAnim(this, r4, r0);
    L14:
        invalidate();
        return;
    L9:
        r0.add(Shadow.NONE);
        r0.add(Shadow.NONE);
        goto L10
    L11:
        if (r2 == false) goto L13;
        this.firstShadowForDraw.update(this.firstShadow);
        this.secondShadowForDraw.update(this.secondShadow);
        goto L14
    L13:
        this.firstShadowForDraw.update(Shadow.NONE);
        this.secondShadowForDraw.update(Shadow.NONE);
        goto L14
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isShadowVisible() {
        return this.mShadowVisible;
    }

    public void drawDividers(Canvas r12, int r13, int r14) {
        View r0 = this.mOwner.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mDividerPaint == null) goto L8;
    L16:
        r12.save();
        r12.translate(r0.getScrollX(), r0.getScrollY());
        int r1 = this.mTopDividerHeight;
        if (r1 <= 0) goto L22;
        this.mDividerPaint.setStrokeWidth(r1);
        this.mDividerPaint.setColor(ViewUtil.applyColorAlphaStrength(this.mTopDividerColor, this.dividerColorStrength));
        int r2 = this.mTopDividerAlpha;
        if (r2 >= 255) goto L21;
        this.mDividerPaint.setAlpha(r2);
    L21:
        float r7 = this.mTopDividerHeight / 2.0f;
        r12.drawLine(this.mTopDividerInsetLeft, r7, r13 - this.mTopDividerInsetRight, r7, this.mDividerPaint);
    L22:
        int r3 = this.mBottomDividerHeight;
        if (r3 <= 0) goto L28;
        this.mDividerPaint.setStrokeWidth(r3);
        this.mDividerPaint.setColor(ViewUtil.applyColorAlphaStrength(this.mBottomDividerColor, this.dividerColorStrength));
        int r4 = this.mBottomDividerAlpha;
        if (r4 >= 255) goto L27;
        this.mDividerPaint.setAlpha(r4);
    L27:
        float r9 = (float) Math.floor(r14 - (this.mBottomDividerHeight / 2.0f));
        r12.drawLine(this.mBottomDividerInsetLeft, r9, r13 - this.mBottomDividerInsetRight, r9, this.mDividerPaint);
    L28:
        int r5 = this.mLeftDividerWidth;
        if (r5 <= 0) goto L34;
        this.mDividerPaint.setStrokeWidth(r5);
        this.mDividerPaint.setColor(ViewUtil.applyColorAlphaStrength(this.mLeftDividerColor, this.dividerColorStrength));
        int r6 = this.mLeftDividerAlpha;
        if (r6 >= 255) goto L33;
        this.mDividerPaint.setAlpha(r6);
    L33:
        float r8 = this.mLeftDividerWidth / 2.0f;
        r12.drawLine(r8, this.mLeftDividerInsetTop, r8, r14 - this.mLeftDividerInsetBottom, this.mDividerPaint);
    L34:
        int r10 = this.mRightDividerWidth;
        if (r10 <= 0) goto L40;
        this.mDividerPaint.setStrokeWidth(r10);
        this.mDividerPaint.setColor(ViewUtil.applyColorAlphaStrength(this.mRightDividerColor, this.dividerColorStrength));
        int r11 = this.mRightDividerAlpha;
        if (r11 >= 255) goto L39;
        this.mDividerPaint.setAlpha(r11);
    L39:
        float r15 = (float) Math.floor(r13 - (this.mRightDividerWidth / 2.0f));
        r12.drawLine(r15, this.mRightDividerInsetTop, r15, r14 - this.mRightDividerInsetBottom, this.mDividerPaint);
    L40:
        r12.restore();
        return;
    L8:
        if (this.mTopDividerHeight <= 0) goto L10;
    L15:
        this.mDividerPaint = new Paint();
        goto L16
    L10:
        if (this.mBottomDividerHeight > 0) goto L15;
        if (this.mLeftDividerWidth > 0) goto L15;
        if (this.mRightDividerWidth <= 0) goto L16;
        goto L15
    }

    private int getRealRadius() {
        View r0 = this.mOwner.get();
        if (r0 == null) goto L5;
        int r2 = this.mRadius;
        if (r2 != (-1)) goto L10;
        return r0.getHeight() / 2;
    L10:
        if (r2 == (-2)) goto L12;
        return r2;
    L12:
        return r0.getWidth() / 2;
    L5:
        return this.mRadius;
    }

    public void draw(Canvas r4) {
        View r0 = this.mOwner.get();
        if (r0 != null) goto L5;
        return;
    L5:
        drawShadow(r4);
        if (r0.isHardwareAccelerated() == false) goto L9;
        return;
    L9:
        if (this.mShouldUseRadiusArray == false) goto L11;
        return;
    L11:
        Drawable r5 = r0.getBackground();
        if (r5 != null) goto L14;
    L16:
        Drawable r6 = r0.getForeground();
        if (r6 != null) goto L19;
        return;
    L19:
        if ((r6 instanceof RoundCornerDrawable) == true) goto L23;
        RoundCornerDrawable r1 = new RoundCornerDrawable(r6, this.mContext.getResources().getDisplayMetrics());
        r1.setRadius(this.mRadius);
        r0.setForeground(r1);
        return;
    L23:
        return;
    L14:
        if ((r5 instanceof RoundCornerDrawable) == true) goto L16;
        RoundCornerDrawable r2 = new RoundCornerDrawable(r5, this.mContext.getResources().getDisplayMetrics());
        r2.setRadius(this.mRadius);
        r0.setBackground(r2);
        goto L16
    }

    public void dispatchRoundBorderDraw(Canvas r16) {
        View r1 = this.mOwner.get();
        if (r1 != null) goto L5;
        return;
    L5:
        int r9 = getRealRadius();
        if (r9 > 0) goto L8;
    L12:
        boolean r4 = false;
    L14:
        if (this.mBorderWidth > 0) goto L16;
    L18:
        boolean r10 = false;
    L19:
        if (r4 == true) goto L23;
        if (r10 == true) goto L23;
        return;
    L23:
        if (this.mIsShowBorderOnlyBeforeL == true) goto L25;
    L29:
        int r5 = r16.getWidth();
        int r6 = r16.getHeight();
        r16.save();
        r16.translate(r1.getScrollX(), r1.getScrollY());
        float r7 = this.mBorderWidth / 2.0f;
        if (this.mIsOutlineExcludePadding == false) goto L32;
        this.mBorderRect.set(r1.getPaddingLeft() + r7, r1.getPaddingTop() + r7, (r5 - r1.getPaddingRight()) - r7, (r6 - r1.getPaddingBottom()) - r7);
    L34:
        if (this.mShouldUseRadiusArray == true) goto L36;
    L39:
        if (r4 == false) goto L45;
        int r2 = r16.saveLayer(0.0f, 0.0f, r5, r6, null, 31);
        r16.drawColor(this.mOuterNormalColor);
        this.mClipPaint.setColor(this.mOuterNormalColor);
        this.mClipPaint.setStyle(Paint.Style.FILL);
        this.mClipPaint.setXfermode(this.mMode);
        if (this.mShouldUseRadiusArray == true) goto L43;
        drawRoundRect(r16, this.mBorderRect, r9, this.mClipPaint);
    L44:
        this.mClipPaint.setXfermode(null);
        r16.restoreToCount(r2);
        goto L45
    L43:
        drawRoundRect(r16, this.mBorderRect, this.mRadiusArray, this.mClipPaint);
    L45:
        if (r10 == false) goto L52;
        this.mClipPaint.setColor(this.mBorderColor);
        this.mClipPaint.setStrokeWidth(this.mBorderWidth);
        this.mClipPaint.setStyle(Paint.Style.STROKE);
        if (this.mShouldUseRadiusArray == false) goto L49;
        drawRoundRect(r16, this.mBorderRect, this.mRadiusArray, this.mClipPaint);
        goto L52
    L49:
        if (r9 > 0) goto L51;
        r16.drawRect(this.mBorderRect, this.mClipPaint);
        goto L52
    L51:
        drawRoundRect(r16, this.mBorderRect, r9, this.mClipPaint);
    L52:
        r16.restore();
        return;
    L36:
        if (this.mRadiusArray != null) goto L38;
        this.mRadiusArray = new float[8];
    L38:
        float[] r3 = this.mRadiusArray;
        int r8 = this.mTLRadius;
        r3[0] = r8;
        r3[1] = r8;
        int r11 = this.mTRRadius;
        r3[2] = r11;
        r3[3] = r11;
        int r12 = this.mBLRadius;
        r3[4] = r12;
        r3[5] = r12;
        int r13 = this.mBRRadius;
        r3[6] = r13;
        r3[7] = r13;
        goto L39
    L32:
        this.mBorderRect.set(r7, r7, r5 - r7, r6 - r7);
        goto L34
    L25:
        if (useFeature() == false) goto L29;
        if (this.mShadowElevation == 0) goto L29;
        return;
    L16:
        if (this.mBorderColor == 0) goto L18;
        r10 = true;
        goto L19
    L8:
        if (useFeature() == true) goto L12;
        if (this.mOuterNormalColor == 0) goto L12;
        r4 = true;
        goto L14
    }

    private void drawShadow(Canvas r5) {
        Shadow r0 = this.firstShadowForDraw;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Shadow r3 = this.secondShadowForDraw;
        if (r3 != null) goto L11;
    L13:
        r1 = false;
    L14:
        if (r2 == true) goto L19;
        if (r1 == true) goto L19;
        this.mShadowPath = null;
        return;
    L19:
        if (this.mEnableShadowWithRadius == false) goto L21;
    L26:
        drawShadowLayer(r5, this.firstShadowForDraw);
        drawShadowLayer(r5, this.secondShadowForDraw);
        return;
    L21:
        if (this.mRadius == 0) goto L23;
    L24:
        Log.e(TAG, " 阴影和圆角同时存在阴影不生效");
        return;
    L23:
        if (this.mShouldUseRadiusArray == false) goto L26;
    L11:
        if (r3.valid() == false) goto L13;
    L5:
        if (r0.valid() == false) goto L7;
        r2 = true;
        goto L8
    }

    private void drawShadowLayer(Canvas r6, Shadow r7) {
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.getCornerRadius() <= 0.0f) goto L7;
        float r0 = r7.getCornerRadius();
    L8:
        View r2 = this.mOwner.get();
        if (this.mShadowPath != null) goto L11;
        this.mShadowPath = new Path();
    L11:
        RectF r4 = new RectF(0.0f, 0.0f, r2.getWidth(), r2.getHeight());
        int r1 = this.mShadowInsetX;
        if (r1 == 0) goto L14;
    L15:
        r4.inset(r1, this.mShadowInsetY);
    L16:
        this.mShadowPath.reset();
        this.mShadowPath.addRoundRect(r4, r0, r0, Path.Direction.CW);
        int r3 = r6.save();
        RectF r5 = new RectF(r4);
        r5.offset(r7.getOffsetX(), r7.getOffsetY());
        r5.inset(-r7.getSpread(), -r7.getSpread());
        r6.clipOutPath(this.mShadowPath);
        r7.getPaint().setColor(r7.getColor());
        r6.drawRoundRect(r5, r0, r0, r7.getPaint());
        r6.restoreToCount(r3);
        return;
    L14:
        if (this.mShadowInsetY == 0) goto L16;
    L7:
        r0 = this.shadowCornerRadius;
        goto L8
    }

    private void drawRoundRect(Canvas r3, RectF r4, float[] r5, Paint r6) {
        this.mPath.reset();
        this.mPath.addRoundRect(r4, r5, Path.Direction.CW);
        r3.drawPath(this.mPath, r6);
    }

    private void drawRoundRect(Canvas r1, RectF r2, int r3, Paint r4) {
        float r0 = r3 * 1.0f;
        r1.drawRoundRect(r2, r0, r0, r4);
    }

    public void setSupportMirroring(boolean r1) {
        this.mIsSupportMirroring = r1;
    }

    public boolean IsSupportMirroring() {
        return this.mIsSupportMirroring;
    }

    public void requestDraw() {
        View r0 = this.mOwner.get();
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    public boolean setMinimumHeight(int r1) {
        this.mHeightMini = r1;
        return true;
    }
}
