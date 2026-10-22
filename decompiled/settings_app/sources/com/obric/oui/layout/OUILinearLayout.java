package com.obric.oui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.IOUIStyleProvider;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUIEffectHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OUILinearLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\bZ\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B/\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\t\u0010\"\u001a\u00020\u0002H\u0096\u0001J-\u0010#\u001a&\u0012\f\u0012\n &*\u0004\u0018\u00010%0% &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u00010'0$H\u0096\u0001J\t\u0010(\u001a\u00020\u0015H\u0096\u0001J\t\u0010)\u001a\u00020\u0003H\u0096\u0001J\t\u0010*\u001a\u00020\nH\u0096\u0001J\t\u0010+\u001a\u00020,H\u0096\u0001J\t\u0010-\u001a\u00020\nH\u0096\u0001J\t\u0010.\u001a\u00020\nH\u0096\u0001J\u0019\u0010/\u001a\u00020\u00182\u000e\u0010\u001e\u001a\n &*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\t\u00100\u001a\u00020\u0011H\u0096\u0001J\t\u00101\u001a\u00020\u0011H\u0096\u0001J\t\u00102\u001a\u00020\u0011H\u0096\u0001J\t\u00103\u001a\u00020\u0011H\u0096\u0001J\t\u00104\u001a\u00020\u0011H\u0096\u0001J \u00105\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\t\u00106\u001a\u00020\u0011H\u0096\u0001J\b\u00107\u001a\u00020\u0011H\u0016J\t\u00108\u001a\u00020\u0011H\u0096\u0001J\b\u00109\u001a\u00020\u0018H\u0014J\b\u0010:\u001a\u00020\u0018H\u0014J\u0010\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u0011H\u0016J\u0018\u0010=\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0014J\u0011\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\nH\u0096\u0001J!\u0010B\u001a\u00020\u00182\u000e\u0010C\u001a\n &*\u0004\u0018\u00010D0D2\u0006\u0010E\u001a\u00020\u0011H\u0096\u0001J!\u0010F\u001a\u00020\u00182\u000e\u0010C\u001a\n &*\u0004\u0018\u00010D0D2\u0006\u0010E\u001a\u00020\u0011H\u0096\u0001J\u0010\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\nH\u0014J)\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0096\u0001J)\u0010N\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0096\u0001J)\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096\u0001J)\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\nH\u0096\u0001J\u0019\u0010]\u001a\u00020\u00182\u000e\u0010^\u001a\n &*\u0004\u0018\u00010_0_H\u0096\u0001J\t\u0010`\u001a\u00020\u0018H\u0096\u0001J\u0013\u0010a\u001a\u00020\u00182\b\b\u0001\u0010b\u001a\u00020\nH\u0096\u0001J\u0011\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\nH\u0096\u0001J\u0011\u0010e\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0011\u0010g\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010i\u001a\u00020\u00182\u0006\u0010j\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010k\u001a\u00020\u00182\u0006\u0010l\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010m\u001a\u00020\u00182\u0006\u0010n\u001a\u00020\u0011H\u0096\u0001J\u0010\u0010o\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0011H\u0016J\u0010\u0010q\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u0011H\u0016J\u0010\u0010s\u001a\u00020\u00112\u0006\u0010t\u001a\u00020\nH\u0016J\u0011\u0010u\u001a\u00020\u00182\u0006\u0010v\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010w\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0010\u0010x\u001a\u00020\u00182\u0006\u0010y\u001a\u00020\nH\u0016J\u0011\u0010z\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001J\u0011\u0010|\u001a\u00020\u00182\u0006\u0010}\u001a\u00020\u0011H\u0096\u0001J,\u0010~\u001a\u00020\u00182\u0006\u0010\u007f\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\n2\u0007\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u0083\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0084\u0001\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u0011H\u0016J\u0013\u0010\u0085\u0001\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\nH\u0096\u0001J.\u0010\u0085\u0001\u001a\u00020\u00182\u0007\u0010\u0087\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\n2\u0007\u0010\u0089\u0001\u001a\u00020\n2\u0007\u0010\u008a\u0001\u001a\u00020\nH\u0096\u0001J%\u0010\u008b\u0001\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020,H\u0096\u0001J.\u0010\u008b\u0001\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u008e\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020,H\u0096\u0001J\u0012\u0010\u008f\u0001\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u0090\u0001\u001a\u00020\u00182\u0007\u0010\u0091\u0001\u001a\u00020\u0011H\u0016J-\u0010\u0092\u0001\u001a\u00020\u00182\u000b\b\u0001\u0010\u0093\u0001\u001a\u0004\u0018\u00010%2\u000b\b\u0001\u0010\u0094\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010\u0095\u0001\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0096\u0001\u001a\u00020\u00182\u0007\u0010\u008d\u0001\u001a\u00020,H\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020\u00182\u0007\u0010\u008e\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0098\u0001\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0099\u0001\u001a\u00020\u00182\u0007\u0010\u009a\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010\u009b\u0001\u001a\u00020\u00182\u0007\u0010\u009c\u0001\u001a\u00020\n2\u0007\u0010\u009d\u0001\u001a\u00020\nH\u0096\u0001J\u0015\u0010\u009e\u0001\u001a\u00020\u00182\t\b\u0001\u0010\u009f\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010 \u0001\u001a\u00020\u00182\u0007\u0010¡\u0001\u001a\u00020\u00112\u0007\u0010\u0095\u0001\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010¢\u0001\u001a\u00020\u00182\u0007\u0010£\u0001\u001a\u00020\u0011H\u0096\u0001J\u000f\u0010¤\u0001\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0011J\u0012\u0010¥\u0001\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\n\u0010¦\u0001\u001a\u00020\u0018H\u0096\u0001J\u000f\u0010§\u0001\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0011J\u0012\u0010¨\u0001\u001a\u00020\u00112\u0007\u0010©\u0001\u001a\u00020\nH\u0016J\u0013\u0010ª\u0001\u001a\u00020\u00182\u0007\u0010«\u0001\u001a\u00020\nH\u0096\u0001J\n\u0010¬\u0001\u001a\u00020\u0011H\u0096\u0001J*\u0010\u00ad\u0001\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0096\u0001J\u0012\u0010®\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001J\u0013\u0010¯\u0001\u001a\u00020\u00182\u0007\u0010°\u0001\u001a\u00020,H\u0096\u0001J*\u0010±\u0001\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0096\u0001J\u0012\u0010²\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001J*\u0010³\u0001\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096\u0001J\u0012\u0010´\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001J;\u0010µ\u0001\u001a\u00020\u00182/\b\u0001\u0010¶\u0001\u001a(\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u0001 &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u00010'0$H\u0096\u0001J*\u0010·\u0001\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\nH\u0096\u0001J\u0012\u0010¸\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "provider", "Lcom/obric/oui/common/style/OUIStyleProvider;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/obric/oui/common/style/OUIStyleProvider;)V", "mAlphaHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "mIsFakePressed", "", "mLayoutHelper", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mOUIEffectHelper", "Lcom/obric/oui/common/style/OUIEffectHelper;", "decideIsNeedUpdatePressedForegroundBySelf", "disablePressReleaseAnim", "", "disable", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "draw", "getAlphaHelper", "getCurrentShadows", "", "Lcom/obric/oui/common/style/Shadow;", "kotlin.jvm.PlatformType", "", "getEffectHelper", "getLayoutHelper", "getRadius", "getShadowAlpha", "", "getShadowColor", "getShadowElevation", "handleTouchEvent", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "init", "isEnableShadowWidthRadius", "isFakePressed", "isShadowVisible", "onAttachedToWindow", "onDetachedFromWindow", "onHoverChanged", "hovered", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPressAlphaChange", "alpha", "onPressedChanged", PerfConsts.KEY_CURRENT_GALVANIC, "Landroid/view/View;", "pressed", "onSelectedChanged", "onWindowVisibilityChanged", "visibility", "onlyShowBottomDivider", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowLeftDivider", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowRightDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowTopDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "refreshColors", "scene", "", "resetAlphaAnim", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBottomDividerAlpha", "dividerAlpha", "setChangeAlphaWhenDisable", "changeAlphaWhenDisable", "setChangeAlphaWhenPress", "changeAlphaWhenPress", "setChangeAlphaWhenSelected", "changeAlphaWhenSelected", "setEnableShadowWidthRadius", "enableShadowWidthRadius", "setEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "setFakePressed", "fakePressed", "setHeightLimit", "heightLimit", "setKeepPressAlpha", "keep", "setLeftDividerAlpha", "setMinimumHeight", "minHeight", "setOuterNormalColor", "color", "setOutlineExcludePadding", "outlineExcludePadding", "setOutlineInset", "left", "top", "right", "bottom", "setOverridePressColor", "setPressed", "setRadius", "radius", "tlRadius", "trRadius", "blRadius", "brRadius", "setRadiusAndShadow", "shadowElevation", "shadowAlpha", "shadowColor", "setRightDividerAlpha", "setSelected", MaterialConfigFormatNames.SELECTED, "setShadow", "firstShadow", "secondShadow", "animate", "setShadowAlpha", "setShadowColor", "setShadowCornerRadius", "setShadowElevation", "elevation", "setShadowInsets", "insetX", "insetY", "setShadowStyle", "styleResId", "setShadowVisible", "visible", "setShowBorderOnlyBeforeL", "showBorderOnlyBeforeL", "setSoundEffectEnabled", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "setVibrateEnabled", "setWidthLimit", "widthLimit", "setWidthMin", "minWidth", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "updateDividerColorStrength", "strength", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "updateShadows", MaterialConfigFormatNames.SHADOWS, "updateTopDivider", "updateTopSeparatorColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OUILinearLayout extends LinearLayout implements IOUIAlpha, IOUILayout, IOUIStyleProvider {
    private final /* synthetic */ IOUIAlpha $$delegate_0;
    private final /* synthetic */ IOUILayout $$delegate_1;
    private final /* synthetic */ OUIStyleProvider $$delegate_2;
    private OUIAlphaHelper mAlphaHelper;
    private boolean mIsFakePressed;
    private OUILayoutHelper mLayoutHelper;
    private OUIEffectHelper mOUIEffectHelper;

    public OUILinearLayout(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, null, 14, null);
    }

    public OUILinearLayout(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, null, 12, null);
    }

    public OUILinearLayout(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, null, 8, null);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.$$delegate_1.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void disablePressReleaseAnim(boolean r1) {
        this.$$delegate_0.disablePressReleaseAnim(r1);
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public IOUIAlpha getAlphaHelper() {
        return this.$$delegate_2.getAlphaHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public List<Shadow> getCurrentShadows() {
        return this.$$delegate_1.getCurrentShadows();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public OUIEffectHelper getEffectHelper() {
        return this.$$delegate_2.getEffectHelper();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public IOUILayout getLayoutHelper() {
        return this.$$delegate_2.getLayoutHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getRadius() {
        return this.$$delegate_1.getRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public float getShadowAlpha() {
        return this.$$delegate_1.getShadowAlpha();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.$$delegate_1.getShadowColor();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowElevation() {
        return this.$$delegate_1.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void handleTouchEvent(MotionEvent r1) {
        this.$$delegate_0.handleTouchEvent(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBorder() {
        return this.$$delegate_1.hasBorder();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBottomSeparator() {
        return this.$$delegate_1.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasLeftSeparator() {
        return this.$$delegate_1.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasRightSeparator() {
        return this.$$delegate_1.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasTopSeparator() {
        return this.$$delegate_1.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isEnableShadowWidthRadius() {
        return this.$$delegate_1.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isShadowVisible() {
        return this.$$delegate_1.isShadowVisible();
    }

    public void onPressAlphaChange(int r1) {
        this.$$delegate_1.onPressAlphaChange(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onPressedChanged(View r1, boolean r2) {
        this.$$delegate_0.onPressedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onSelectedChanged(View r1, boolean r2) {
        this.$$delegate_0.onSelectedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowBottomDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowLeftDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowRightDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowTopDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void refreshColors(String r1) {
        this.$$delegate_0.refreshColors(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void resetAlphaAnim() {
        this.$$delegate_0.resetAlphaAnim();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderColor(int r1) {
        this.$$delegate_1.setBorderColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderWidth(int r1) {
        this.$$delegate_1.setBorderWidth(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBottomDividerAlpha(int r1) {
        this.$$delegate_1.setBottomDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenPress(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenSelected(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setEnableShadowWidthRadius(boolean r1) {
        this.$$delegate_1.setEnableShadowWidthRadius(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r1) {
        this.$$delegate_0.setKeepPressAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setLeftDividerAlpha(int r1) {
        this.$$delegate_1.setLeftDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOuterNormalColor(int r1) {
        this.$$delegate_1.setOuterNormalColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineExcludePadding(boolean r1) {
        this.$$delegate_1.setOutlineExcludePadding(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineInset(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.setOutlineInset(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setOverridePressColor(int r1) {
        this.$$delegate_0.setOverridePressColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r1) {
        this.$$delegate_1.setRadius(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.setRadius(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r1, int r2, float r3) {
        this.$$delegate_1.setRadiusAndShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r1, int r2, int r3, float r4) {
        this.$$delegate_1.setRadiusAndShadow(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRightDividerAlpha(int r1) {
        this.$$delegate_1.setRightDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(Shadow r1, Shadow r2, boolean r3) {
        this.$$delegate_1.setShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowAlpha(float r1) {
        this.$$delegate_1.setShadowAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowColor(int r1) {
        this.$$delegate_1.setShadowColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowCornerRadius(int r1) {
        this.$$delegate_1.setShadowCornerRadius(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowElevation(int r1) {
        this.$$delegate_1.setShadowElevation(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowInsets(int r1, int r2) {
        this.$$delegate_1.setShadowInsets(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowStyle(int r1) {
        this.$$delegate_1.setShadowStyle(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowVisible(boolean r1, boolean r2) {
        this.$$delegate_1.setShadowVisible(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.$$delegate_1.setShowBorderOnlyBeforeL(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setTopDividerAlpha(int r1) {
        this.$$delegate_1.setTopDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setUseThemeGeneralShadowElevation() {
        this.$$delegate_1.setUseThemeGeneralShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r1) {
        this.$$delegate_1.setWidthMin(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return this.$$delegate_1.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomSeparatorColor(int r1) {
        this.$$delegate_1.updateBottomSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateDividerColorStrength(float r1) {
        this.$$delegate_1.updateDividerColorStrength(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftSeparatorColor(int r1) {
        this.$$delegate_1.updateLeftSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightSeparatorColor(int r1) {
        this.$$delegate_1.updateRightSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateShadows(List<Shadow> r1) {
        this.$$delegate_1.updateShadows(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopSeparatorColor(int r1) {
        this.$$delegate_1.updateTopSeparatorColor(r1);
    }

    public /* synthetic */ OUILinearLayout(Context r2, AttributeSet r3, int r4, OUIStyleProvider r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = new OUIStyleProvider(r2, r3, r4, 0);
    L11:
        this(r2, r3, r4, r5);
    }

    public OUILinearLayout(Context r2, AttributeSet r3, int r4, OUIStyleProvider r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "provider");
        super(r2, r3);
        this.$$delegate_0 = r5.getAlphaHelper();
        this.$$delegate_1 = r5.getLayoutHelper();
        this.$$delegate_2 = r5;
        r5.initView(this);
        this.mLayoutHelper = (OUILayoutHelper) getLayoutHelper();
        this.mAlphaHelper = (OUIAlphaHelper) getAlphaHelper();
        this.mOUIEffectHelper = getEffectHelper();
        init(r2, r3, r4);
    }

    public final void init(Context r1, AttributeSet r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r4, int r5) {
        OUILayoutHelper r0 = this.mLayoutHelper;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        int r6 = r0.getMeasuredWidthSpec(r4);
        OUILayoutHelper r1 = this.mLayoutHelper;
        Intrinsics.checkNotNull(r1);
        int r7 = r1.getMeasuredHeightSpec(r5);
        super.onMeasure(r6, r7);
        OUILayoutHelper r2 = this.mLayoutHelper;
        Intrinsics.checkNotNull(r2);
        int r3 = r2.handleMiniWidth(r6, getMeasuredWidth());
        OUILayoutHelper r8 = this.mLayoutHelper;
        Intrinsics.checkNotNull(r8);
        int r9 = r8.handleMiniHeight(r7, getMeasuredHeight());
        if (r6 != r3) goto L7;
        if (r7 != r9) goto L7;
        return;
    L7:
        super.onMeasure(r3, r9);
        return;
    L8:
        super.onMeasure(r4, r5);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setWidthLimit(int r2) {
        OUILayoutHelper r0 = this.mLayoutHelper;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.setWidthLimit(r2) == false) goto L10;
        requestLayout();
        invalidate();
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setHeightLimit(int r2) {
        OUILayoutHelper r0 = this.mLayoutHelper;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.setHeightLimit(r2) == false) goto L10;
        requestLayout();
        invalidate();
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        OUILayoutHelper r0 = this.mLayoutHelper;
        if (r0 == null) goto L6;
        r0.draw(r2);
    L6:
        super.draw(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        OUILayoutHelper r0 = this.mLayoutHelper;
        if (r0 == null) goto L6;
        r0.drawDividers(r4, getWidth(), getHeight());
    L6:
        OUILayoutHelper r3 = this.mLayoutHelper;
        if (r3 == null) goto L11;
        r3.dispatchRoundBorderDraw(r4);
        return;
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L6;
        r0.setPressed(r2);
    L6:
        super.setPressed(r2);
        OUIAlphaHelper r1 = this.mAlphaHelper;
        if (r1 == null) goto L11;
        r1.onPressedChanged(this, r2);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        OUIAlphaHelper r0 = this.mAlphaHelper;
        if (r0 == null) goto L7;
        r0.onEnabledChanged(this, r2);
        return;
    }

    @Override // android.view.View
    public void onHoverChanged(boolean r1) {
        super.onHoverChanged(r1);
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L7;
        r0.onHoverChanged(r1);
        return;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L7;
        r0.dispatchGenericMotionEvent(r2);
    L7:
        return super.dispatchGenericMotionEvent(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L6;
        r0.dispatchTouchEvent(r2);
    L6:
        OUIAlphaHelper r1 = this.mAlphaHelper;
        if (r1 == null) goto L11;
        r1.handleTouchEvent(r2);
    L11:
        return super.dispatchTouchEvent(r2);
    }

    public final void setVibrateEnabled(boolean r1) {
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L7;
        r0.setVibrateEnabled(r1);
        return;
    }

    public final void setSoundEffectEnabled(boolean r1) {
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L7;
        r0.setSoundEffectEnabled(r1);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setFakePressed(boolean r2) {
        if (this.mIsFakePressed == r2) goto L13;
        this.mIsFakePressed = r2;
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L8;
        r0.setPressed(r2);
    L8:
        OUIAlphaHelper r3 = this.mAlphaHelper;
        if (r3 == null) goto L14;
        r3.onPressedChanged(this, this.mIsFakePressed);
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isFakePressed() {
        return this.mIsFakePressed;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L7;
        r0.onAttachedToWindow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L7;
        r0.onDetachedFromWindow();
        return;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L7;
        r0.onWindowVisibilityChanged(r1);
        return;
    }

    @Override // android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        OUIAlphaHelper r0 = this.mAlphaHelper;
        if (r0 == null) goto L7;
        r0.onSelectedChanged(this, r2);
        return;
    }

    @Override // android.view.View
    public void setMinimumHeight(int r2) {
        OUILayoutHelper r0 = this.mLayoutHelper;
        if (r0 == null) goto L6;
        r0.setMinimumHeight(r2);
    L6:
        super.setMinimumHeight(r2);
    }
}
