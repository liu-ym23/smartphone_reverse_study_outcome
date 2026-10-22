package com.obric.oui.sheet.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.color.OPalette;
import com.obric.oui.common.style.ODynamicThemeWidget;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaskMaterialOwner;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialOwnerKt;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.ViewUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OSheetTitleBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0016\u0018\u0000 ¶\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004¶\u0001·\u0001B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010n\u001a\u0002042\u0006\u0010o\u001a\u00020\nJ\u0016\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020\nJ\u000e\u0010t\u001a\u0002042\u0006\u0010o\u001a\u00020\nJ\u000e\u0010u\u001a\u00020q2\u0006\u0010o\u001a\u00020\nJ\u000e\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\rJ\u0010\u0010y\u001a\u00020w2\u0006\u0010z\u001a\u00020\"H\u0016J\u0010\u0010{\u001a\u00020w2\u0006\u0010|\u001a\u00020\nH\u0016J\u0010\u0010}\u001a\u00020w2\u0006\u0010z\u001a\u00020\"H\u0016J\u001f\u0010~\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020G2\u0007\u0010\u0080\u0001\u001a\u00020\nJ\u001b\u0010\u0081\u0001\u001a\u0002042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0007J \u0010\u0084\u0001\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020G2\u0007\u0010\u0080\u0001\u001a\u00020\nJ\u0017\u0010\u0085\u0001\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020GJ=\u0010\u0086\u0001\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020G2\u0007\u0010\u0087\u0001\u001a\u00020\n2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010\u008b\u0001J\u0017\u0010\u008c\u0001\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020GJ=\u0010\u008d\u0001\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020G2\u0007\u0010\u0087\u0001\u001a\u00020\n2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010\u008b\u0001J\u0017\u0010\u008e\u0001\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020GJ\u0017\u0010\u008f\u0001\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020GJ\u0017\u0010\u0090\u0001\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020GJ\t\u0010\u0091\u0001\u001a\u00020\nH\u0002J\t\u0010\u0092\u0001\u001a\u00020\rH\u0002J\u001f\u0010\u0093\u0001\u001a\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u0096\u0001\u001a\u00020\n2\u0006\u0010x\u001a\u00020\rH\u0002J\t\u0010\u0097\u0001\u001a\u00020\nH\u0002J\u0007\u0010\u0098\u0001\u001a\u00020*J\u0011\u0010\u0099\u0001\u001a\u00020w2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0011\u0010\u009a\u0001\u001a\u00020w2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\t\u0010\u009b\u0001\u001a\u00020\"H\u0016J\t\u0010\u009c\u0001\u001a\u00020\"H\u0002J\u0015\u0010\u009d\u0001\u001a\u00020w2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0014J6\u0010 \u0001\u001a\u00020w2\u0007\u0010¡\u0001\u001a\u00020\"2\u0007\u0010¢\u0001\u001a\u00020\n2\u0007\u0010£\u0001\u001a\u00020\n2\u0007\u0010¤\u0001\u001a\u00020\n2\u0007\u0010¥\u0001\u001a\u00020\nH\u0014J\u001b\u0010¦\u0001\u001a\u00020w2\u0007\u0010§\u0001\u001a\u00020\n2\u0007\u0010¨\u0001\u001a\u00020\nH\u0014J\t\u0010©\u0001\u001a\u00020wH\u0002J\u0007\u0010ª\u0001\u001a\u00020wJ\u0007\u0010«\u0001\u001a\u00020wJ\u0013\u0010¬\u0001\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u00ad\u0001\u001a\u00020w2\u0007\u0010®\u0001\u001a\u00020\nJ\u0010\u0010\u00ad\u0001\u001a\u00020w2\u0007\u0010¯\u0001\u001a\u00020\u0019J\t\u0010°\u0001\u001a\u00020wH\u0002J\u0007\u0010±\u0001\u001a\u00020wJ\u0012\u0010²\u0001\u001a\u00020w2\u0007\u0010³\u0001\u001a\u00020\nH\u0016J\u0011\u0010´\u0001\u001a\u00020w2\u0006\u0010!\u001a\u00020\"H\u0016J\t\u0010µ\u0001\u001a\u00020wH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u000e\u00101\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000207X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020=X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R$\u0010I\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020H@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u001a\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00120RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010T\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR(\u0010Y\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u001c\"\u0004\b[\u0010\u001eR(\u0010\\\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u001c\"\u0004\b^\u0010\u001eR\u001a\u0010_\u001a\u00020`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010b\"\u0004\bg\u0010dR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006¸\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaskMaterialOwner;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backdropTarget", "Landroid/view/View;", "centerTitleGapLargeFontPx", "centerTitleGapPx", "centerTitleHorizontalPaddingPx", "currentMaskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "currentTheme", "getCurrentTheme", "()I", "setCurrentTheme", "(I)V", "value", "", "desText", "getDesText", "()Ljava/lang/String;", "setDesText", "(Ljava/lang/String;)V", "fixedCenterSubTitleDefaultMaxWidth", "fixedCenterTitleDefaultMaxWidth", "isBackdropView", "", "isFixedCenterOverflow", "mCenterContainer", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterTitleView", "Landroid/widget/TextView;", "mDesContainerView", "mDesTextView", "Lcom/obric/oui/text/OTextView;", "mFixedCenterContainer", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterSubTitleView", "mFixedCenterTitleView", "mHandleView", "Landroid/widget/ImageView;", "mIsLargeFont", "mLeftActionBack", "Lcom/obric/oui/button/OIconButtonFloating;", "getMLeftActionBack", "()Lcom/obric/oui/button/OIconButtonFloating;", "setMLeftActionBack", "(Lcom/obric/oui/button/OIconButtonFloating;)V", "mLeftContainer", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftTitleView", "mRightContainer", "getMRightContainer", "setMRightContainer", "mTitleBarRoot", "Landroid/view/ViewGroup;", "Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "mTitlePosition", "getMTitlePosition", "()Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;)V", "mTitleView", "getMTitleView", "()Landroid/widget/TextView;", "maskMaterial", "Lkotlin/Function1;", "materialSrcType", "showLeftBack", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "subTitleText", "getSubTitleText", "setSubTitleText", "titleText", "getTitleText", "setTitleText", "touchStartX", "", "getTouchStartX", "()F", "setTouchStartX", "(F)V", "touchStartY", "getTouchStartY", "setTouchStartY", "velocityTracker", "Landroid/view/VelocityTracker;", "getVelocityTracker", "()Landroid/view/VelocityTracker;", "setVelocityTracker", "(Landroid/view/VelocityTracker;)V", "addLeftImageView", "drawableId", "addRightButton", "Lcom/obric/oui/button/OButton;", "style", "stringId", "addRightImageView", "addRightTransButton", "addRightView", "", "view", "applyContentMaterial", "apply", "applyDynamicTheme", "themeStyle", "applyMaskMaterial", "createButton", "root", "layoutResId", "createHandleView", "sheet", "Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "createIconButton", "createNeutralButton", "createNeutralIconButton", "iconResId", "tintColor", "Landroid/content/res/ColorStateList;", "contentDescriptionResId", "(Landroid/content/Context;Landroid/view/ViewGroup;ILandroid/content/res/ColorStateList;Ljava/lang/Integer;)Lcom/obric/oui/button/OIconButtonFloating;", "createPrimaryButton", "createPrimaryIconButton", "createPrimaryLightButton", "createTransButton", "createUnderstatedButton", "getCenterTitleGap", "getDefaultTargetView", "getFixedCenterSafeBounds", "Lkotlin/Pair;", "totalWidth", "getOccupiedWidth", "getTitleBarContentWidth", "getTitleView", "init", "initAttrs", "isDarkTheme", "isFixedCenterTitleVisible", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDimensionCache", "removeAllLeftViews", "removeAllRightViews", "setBackdropTarget", "setCenterText", "resId", "title", "setDefaultBackdropTargetForChild", "sheetTitleBarStyle", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateMaterial", "Companion", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSheetTitleBar extends FrameLayout implements MaskMaterialOwner, MaterialOwner, ODynamicThemeWidget {
    private static final int CENTER_TITLE_GAP = 12;
    private static final int CENTER_TITLE_GAP_IN_LARGE_FONT = 4;
    private static final int CENTER_TITLE_HORIZONTAL_PADDING = 8;
    public static final Companion Companion = null;
    public static final int STYLE_AREA_ONLY_ICON = 7;
    public static final int STYLE_BACK = 1;
    public static final int STYLE_CUSTOM_BACKGROUND = 9;
    public static final int STYLE_DELETE = 3;
    public static final int STYLE_HIGHLIGHT_BLUE = 4;
    public static final int STYLE_HIGHLIGHT_RED = 5;
    public static final int STYLE_MIX = 10;
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NORMAL_WITH_ICON = 6;
    public static final int STYLE_SEARCH = 8;
    public static final int STYLE_SETTING = 2;
    public static final int STYLE_TNT_3_BLUE = 11;
    private View backdropTarget;
    private int centerTitleGapLargeFontPx;
    private int centerTitleGapPx;
    private int centerTitleHorizontalPaddingPx;
    private MaterialConfig currentMaskMaterialConfig;
    private int currentTheme;
    private String desText;
    private int fixedCenterSubTitleDefaultMaxWidth;
    private int fixedCenterTitleDefaultMaxWidth;
    private boolean isBackdropView;
    private boolean isFixedCenterOverflow;
    public FrameLayout mCenterContainer;
    private TextView mCenterTitleView;
    private FrameLayout mDesContainerView;
    private OTextView mDesTextView;
    public FrameLayout mFixedCenterContainer;
    private TextView mFixedCenterSubTitleView;
    private TextView mFixedCenterTitleView;
    private ImageView mHandleView;
    private boolean mIsLargeFont;
    public OIconButtonFloating mLeftActionBack;
    public LinearLayout mLeftContainer;
    private TextView mLeftTitleView;
    public LinearLayout mRightContainer;
    private ViewGroup mTitleBarRoot;
    private TitlePosition mTitlePosition;
    private Function1<? super Boolean, MaterialConfig> maskMaterial;
    private int materialSrcType;
    private boolean showLeftBack;
    private String subTitleText;
    private String titleText;
    private float touchStartX;
    private float touchStartY;
    private VelocityTracker velocityTracker;

    /* JADX INFO: compiled from: OSheetTitleBar.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar$Companion;", "", "()V", "CENTER_TITLE_GAP", "", "CENTER_TITLE_GAP_IN_LARGE_FONT", "CENTER_TITLE_HORIZONTAL_PADDING", "STYLE_AREA_ONLY_ICON", "STYLE_BACK", "STYLE_CUSTOM_BACKGROUND", "STYLE_DELETE", "STYLE_HIGHLIGHT_BLUE", "STYLE_HIGHLIGHT_RED", "STYLE_MIX", "STYLE_NORMAL", "STYLE_NORMAL_WITH_ICON", "STYLE_SEARCH", "STYLE_SETTING", "STYLE_TNT_3_BLUE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OSheetTitleBar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TitlePosition extends Enum<TitlePosition> {
        private static final /* synthetic */ TitlePosition[] $VALUES = null;
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;
        private final int value;

        private static final /* synthetic */ TitlePosition[] $values() {
            return new TitlePosition[]{FIXED_CENTER, FLOW_WITH_ACTION, LEFT_IN_ACTION};
        }

        public static TitlePosition valueOf(String r1) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r1);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) $VALUES.clone();
        }

        private TitlePosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            FIXED_CENTER = new TitlePosition("FIXED_CENTER", 0, 0);
            FLOW_WITH_ACTION = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            LEFT_IN_ACTION = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OSheetTitleBar.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TitlePosition.values().length];
            r0[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r0[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r0[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-_ApIx8XXrAENWjnmFxJ2Xsj7L8, reason: not valid java name */
    public static /* synthetic */ boolean m532$r8$lambda$_ApIx8XXrAENWjnmFxJ2Xsj7L8(OSheetTitleBar r0, SheetMoveDelegate r1, View r2, MotionEvent r3) {
        return m533createHandleView$lambda8(r0, r1, r2, r3);
    }

    static {
        Companion = new Companion(null);
    }

    public OSheetTitleBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OSheetTitleBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OSheetTitleBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OSheetTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.fixedCenterTitleDefaultMaxWidth = Integer.MAX_VALUE;
        this.fixedCenterSubTitleDefaultMaxWidth = Integer.MAX_VALUE;
        this.mIsLargeFont = ViewUtil.isInLargeFont(r2.getResources().getConfiguration().fontScale);
        this.isBackdropView = true;
        this.materialSrcType = 2;
        this.maskMaterial = new OSheetTitleBar$maskMaterial$1(this);
        this.showLeftBack = true;
        this.mTitlePosition = TitlePosition.FIXED_CENTER;
        refreshDimensionCache();
        init(r2);
        if (r3 == null) goto L5;
        initAttrs(r3);
    L5:
        updateMaterial();
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r0 = this.mLeftContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final void setMLeftContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mLeftContainer = r2;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r0 = this.mRightContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final void setMRightContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mRightContainer = r2;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r0 = this.mCenterContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        return null;
    }

    public final void setMCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mCenterContainer = r2;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r0 = this.mFixedCenterContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
        return null;
    }

    public final void setMFixedCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mFixedCenterContainer = r2;
    }

    protected final int getCurrentTheme() {
        return this.currentTheme;
    }

    protected final void setCurrentTheme(int r1) {
        this.currentTheme = r1;
    }

    public final OIconButtonFloating getMLeftActionBack() {
        OIconButtonFloating r0 = this.mLeftActionBack;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final void setMLeftActionBack(OIconButtonFloating r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mLeftActionBack = r2;
    }

    public final boolean getShowLeftBack() {
        return this.showLeftBack;
    }

    public final void setShowLeftBack(boolean r3) {
        this.showLeftBack = r3;
        OIconButtonFloating r0 = getMLeftActionBack();
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        if (this.mTitlePosition != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public final String getSubTitleText() {
        return this.subTitleText;
    }

    public final void setSubTitleText(String r5) {
        this.subTitleText = r5;
        TextView r0 = null;
        if (r5 != null) goto L9;
        TextView r4 = this.mFixedCenterSubTitleView;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r0.setVisibility(8);
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        TextView r2 = this.mFixedCenterSubTitleView;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r2 = null;
    L12:
        r2.setVisibility(0);
        TextView r6 = this.mFixedCenterSubTitleView;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L16:
        r0.setText(r5);
        return;
    L15:
        r0 = r6;
        goto L16
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setTitleText(String r3) {
        this.titleText = r3;
        if (r3 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r3);
    }

    public final String getDesText() {
        return this.desText;
    }

    public final void setDesText(String r5) {
        this.desText = r5;
        String r6 = r5;
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        OTextView r3 = null;
        FrameLayout r4 = null;
        if (r1 == false) goto L16;
        FrameLayout r7 = this.mDesContainerView;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L15:
        r4.setVisibility(8);
        return;
    L14:
        r4 = r7;
        goto L15
    L16:
        FrameLayout r2 = this.mDesContainerView;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
        r2 = null;
    L19:
        r2.setVisibility(0);
        OTextView r8 = this.mDesTextView;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
    L23:
        r3.setText(r6);
        return;
    L22:
        r3 = r8;
        goto L23
    L5:
        if (r6.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final TextView getMTitleView() {
        TitlePosition r0 = this.mTitlePosition;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        TextView r3 = this.mFixedCenterTitleView;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        return null;
    L20:
        return r3;
    L5:
        if (r1 != 2) goto L7;
        r3 = this.mCenterTitleView;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        return null;
    L7:
        if (r1 != 3) goto L12;
        r3 = this.mLeftTitleView;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final TitlePosition getMTitlePosition() {
        return this.mTitlePosition;
    }

    public final void setMTitlePosition(TitlePosition r8) {
        Intrinsics.checkNotNullParameter(r8, "value");
        this.mTitlePosition = r8;
        int r9 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        TextView r6 = null;
        if (r9 != 1) goto L5;
        TextView r10 = this.mFixedCenterTitleView;
        if (r10 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r10 = null;
    L34:
        r10.setVisibility(0);
        TextView r11 = this.mCenterTitleView;
        if (r11 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r11 = null;
    L37:
        r11.setVisibility(8);
        TextView r12 = this.mLeftTitleView;
        if (r12 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L41:
        r6.setVisibility(8);
    L42:
        getMTitleView().setText(this.titleText);
        return;
    L40:
        r6 = r12;
        goto L41
    L5:
        if (r9 != 2) goto L7;
        TextView r13 = this.mFixedCenterTitleView;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r13 = null;
    L23:
        r13.setVisibility(8);
        TextView r14 = this.mCenterTitleView;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r14 = null;
    L26:
        r14.setVisibility(0);
        TextView r15 = this.mLeftTitleView;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L30:
        r6.setVisibility(8);
        goto L42
    L29:
        r6 = r15;
        goto L30
    L7:
        if (r9 != 3) goto L42;
        TextView r16 = this.mFixedCenterTitleView;
        if (r16 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r16 = null;
    L12:
        r16.setVisibility(8);
        TextView r17 = this.mCenterTitleView;
        if (r17 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r17 = null;
    L15:
        r17.setVisibility(8);
        TextView r18 = this.mLeftTitleView;
        if (r18 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L19:
        r6.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L18:
        r6 = r18;
        goto L19
    }

    private final void init(Context r3) {
        FrameLayout.inflate(r3, R.layout.o_sheet_title_bar_container_v2, this);
        View r4 = findViewById(R.id.sheet_title_bar_main);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.sheet_title_bar_main)");
        this.mTitleBarRoot = (ViewGroup) r4;
        View r5 = findViewById(R.id.center_title);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.center_title)");
        this.mCenterTitleView = (TextView) r5;
        View r6 = findViewById(R.id.left_title);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.left_title)");
        this.mLeftTitleView = (TextView) r6;
        View r7 = findViewById(R.id.ll_left_action_container);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.ll_left_action_container)");
        setMLeftContainer((LinearLayout) r7);
        View r8 = findViewById(R.id.ll_right_action_container);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.ll_right_action_container)");
        setMRightContainer((LinearLayout) r8);
        View r9 = findViewById(R.id.fl_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.fl_center_action_container)");
        setMCenterContainer((FrameLayout) r9);
        View r10 = findViewById(R.id.fl_fixed_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.fl_fix…_center_action_container)");
        setMFixedCenterContainer((FrameLayout) r10);
        View r11 = findViewById(R.id.fixed_center_title);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.fixed_center_title)");
        this.mFixedCenterTitleView = (TextView) r11;
        View r12 = findViewById(R.id.left_action_back);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OIconButtonFloating) r12);
        View r13 = findViewById(R.id.fixed_center_sub_title);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.fixed_center_sub_title)");
        this.mFixedCenterSubTitleView = (TextView) r13;
        View r14 = findViewById(R.id.sheet_title_bar_des);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.sheet_title_bar_des)");
        this.mDesContainerView = (FrameLayout) r14;
        View r15 = findViewById(R.id.sheet_title_bar_des_text);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.sheet_title_bar_des_text)");
        OTextView r16 = (OTextView) r15;
        this.mDesTextView = r16;
        TextView r0 = null;
        if (r16 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
        r16 = null;
    L5:
        r16.setEnableAutoAlignLeft(true);
        TextView r17 = this.mFixedCenterTitleView;
        if (r17 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r17 = null;
    L8:
        this.fixedCenterTitleDefaultMaxWidth = r17.getMaxWidth();
        TextView r18 = this.mFixedCenterSubTitleView;
        if (r18 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L12:
        this.fixedCenterSubTitleDefaultMaxWidth = r0.getMaxWidth();
        return;
    L11:
        r0 = r18;
        goto L12
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public void applyDynamicTheme(int r2) {
        if (this.currentTheme == r2) goto L6;
        this.currentTheme = r2;
        updateMaterial();
        return;
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public boolean isDarkTheme() {
        int r0 = this.currentTheme;
        boolean r1 = false;
        if (r0 != 0) goto L5;
        TextView r2 = this.mLeftTitleView;
        TextView r4 = null;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r2 = null;
    L12:
        if (r2.getVisibility() != 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L21;
        TextView r5 = this.mLeftTitleView;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L20:
        int r6 = r4.getTextColors().getDefaultColor();
    L35:
        return !OPalette.isDarkColor(r6);
    L19:
        r4 = r5;
        goto L20
    L21:
        TextView r7 = this.mFixedCenterTitleView;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r7 = null;
    L25:
        if (r7.getVisibility() != 0) goto L27;
        r1 = true;
    L27:
        if (r1 == false) goto L33;
        TextView r8 = this.mFixedCenterTitleView;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L32:
        r6 = r4.getTextColors().getDefaultColor();
        goto L35
    L31:
        r4 = r8;
        goto L32
    L33:
        r6 = -16777216;
        goto L35
    L14:
        r3 = false;
        goto L15
    L5:
        if (r0 == 2) goto L7;
        return false;
    L7:
        return true;
    }

    private final void initAttrs(AttributeSet r4) {
        TypedArray r5 = getContext().getTheme().obtainStyledAttributes(r4, R.styleable.OCTitleBar, 0, 0);
        int r0 = r5.getInt(R.styleable.OCTitleBar_oui_title_pos, TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r0]);     // Catch: Throwable -> L6
        setTitleText(r5.getString(R.styleable.OCTitleBar_oui_title_text));     // Catch: Throwable -> L6
        setDesText(r5.getString(R.styleable.OCTitleBar_oui_title_des_text));     // Catch: Throwable -> L6
        setShowLeftBack(r5.getBoolean(R.styleable.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L6
        setSubTitleText(r5.getString(R.styleable.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L6
        r5.recycle();
        return;
    L6:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    private final void updateMaterial() {
        MaterialConfig r0 = this.maskMaterial.invoke(Boolean.valueOf(!isDarkTheme()));
        this.currentMaskMaterialConfig = r0;
        OSheetTitleBar r1 = this;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r0 = null;
    L5:
        OMaterialHelper.setCommonGradientBlur(r1, r0, this.materialSrcType);
        View r3 = this.backdropTarget;
        if (r3 != null) goto L9;
        r3 = r1;
    L9:
        OMaterialExtBaseKt.setMaterialBackdropTarget(r1, r3);
    }

    public final OButton createNeutralButton(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        return OButton.Companion.createNeutralButton(r1, r2);
    }

    public final OButton createPrimaryButton(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        return OButton.Companion.createPrimaryButton(r1, r2);
    }

    public final OIconButtonFloating createNeutralIconButton(Context r2, ViewGroup r3, int r4, ColorStateList r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        OIconButtonFloating r7 = createIconButton(r2, r3, R.layout.o_widget_titlebar_neutral_icon_button);
        OMaterialExtBaseKt.setMaterialBackdropTarget(r7, getDefaultTargetView());
        r7.setIcon(r4);
        if (r5 == null) goto L6;
        r7.setIconTintColor(r5);
    L6:
        if (r6 == null) goto L9;
        r6.intValue();
        r7.setContentDescription(r7.getContext().getString(r6.intValue()));
    L9:
        return r7;
    }

    public final OIconButtonFloating createPrimaryIconButton(Context r2, ViewGroup r3, int r4, ColorStateList r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        OIconButtonFloating r7 = createIconButton(r2, r3, R.layout.o_widget_titlebar_primary_icon_button);
        OMaterialExtBaseKt.setMaterialBackdropTarget(r7, getDefaultTargetView());
        r7.setIcon(r4);
        if (r5 == null) goto L6;
        r7.setIconTintColor(r5);
    L6:
        if (r6 == null) goto L9;
        r6.intValue();
        r7.setContentDescription(r7.getContext().getString(r6.intValue()));
    L9:
        return r7;
    }

    public final OButton createPrimaryLightButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        OButton r4 = OButton.Companion.createPrimaryLightButton(r2, r3);
        OMaterialExtBaseKt.setMaterialBackdropTarget(r4, getDefaultTargetView());
        return r4;
    }

    public final OButton createTransButton(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        return OButton.Companion.createTransButton(r1, r2);
    }

    public final OButton createUnderstatedButton(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        return OButton.Companion.createUnderstatedButton(r1, r2);
    }

    public final OButton createButton(Context r1, ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        return OButton.Companion.createButton(r1, r2, r3);
    }

    public final OIconButtonFloating createIconButton(Context r1, ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        View r0 = FrameLayout.inflate(r1, r3, r2);
        if (r0 == null) goto L11;
        View r4 = ((ViewGroup) r0).getChildAt(r2.getChildCount() - 1);
        if (r4 == null) goto L9;
        return (OIconButtonFloating) r4;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OIconButtonFloating");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final float getTouchStartX() {
        return this.touchStartX;
    }

    public final void setTouchStartX(float r1) {
        this.touchStartX = r1;
    }

    public final float getTouchStartY() {
        return this.touchStartY;
    }

    public final void setTouchStartY(float r1) {
        this.touchStartY = r1;
    }

    public final VelocityTracker getVelocityTracker() {
        return this.velocityTracker;
    }

    public final void setVelocityTracker(VelocityTracker r1) {
        this.velocityTracker = r1;
    }

    public final ImageView createHandleView(Context r4, final SheetMoveDelegate r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "sheet");
        View r6 = FrameLayout.inflate(r4, R.layout.o_widget_titlebar_handler, this).findViewById(R.id.title_handler);
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(context, R.layou…wById(R.id.title_handler)");
        ImageView r7 = (ImageView) r6;
        this.mHandleView = r7;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
        r7 = null;
    L5:
        r7.setOnTouchListener(new OSheetTitleBar$$ExternalSyntheticLambda0(this, r5));
        ImageView r3 = this.mHandleView;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
        return null;
    L9:
        return r3;
    }

    /* JADX INFO: renamed from: createHandleView$lambda-8, reason: not valid java name */
    private static final boolean m533createHandleView$lambda8(OSheetTitleBar r9, SheetMoveDelegate r10, View r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$sheet");
        if (r9.velocityTracker != null) goto L5;
        r9.velocityTracker = VelocityTracker.obtain();
    L5:
        VelocityTracker r13 = r9.velocityTracker;
        if (r13 == null) goto L9;
        r13.addMovement(r12);
    L9:
        int r14 = r12.getAction();
        if (r14 != 0) goto L12;
        r9.touchStartX = r12.getRawX();
        r9.touchStartY = r12.getRawY();
        r9.requestFocus();
        SheetMoveDelegate.DefaultImpls.move$default(r10, 0.0f, 0.0f, true, 3, null);
    L35:
        return true;
    L12:
        if (r14 != 1) goto L14;
    L19:
        VelocityTracker r15 = r9.velocityTracker;
        if (r15 == null) goto L23;
        r15.computeCurrentVelocity(1000);
    L23:
        VelocityTracker r16 = r9.velocityTracker;
        if (r16 != null) goto L26;
        float r17 = 0.0f;
    L27:
        VelocityTracker r2 = r9.velocityTracker;
        if (r2 == null) goto L31;
        r2.recycle();
    L31:
        r9.velocityTracker = null;
        if ((r12.getRawY() - r9.touchStartY) < 0.0f) goto L35;
        r10.fling(0.0f, r17);
        goto L35
    L26:
        r17 = r16.getYVelocity();
        goto L27
    L14:
        if (r14 != 2) goto L16;
        SheetMoveDelegate.DefaultImpls.move$default(r10, 0.0f, RangesKt.coerceAtLeast(r12.getRawY() - r9.touchStartY, 0.0f), false, 4, null);
        goto L35
    L16:
        if (r14 == 3) goto L19;
        goto L19
    }

    public final ImageView addLeftImageView(int r3) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(r3);
        getMLeftContainer().addView(r0);
        return r0;
    }

    public final ImageView addRightImageView(int r3) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(r3);
        getMRightContainer().addView(r0);
        return r0;
    }

    public final OButton addRightButton(int r3, int r4) {
        if (r3 != 0) goto L5;
        Context r5 = getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        OButton r2 = createNeutralButton(r5, getMRightContainer());
    L9:
        r2.setText(r4);
        return r2;
    L5:
        if (r3 == 4) goto L7;
        Context r6 = getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        r2 = createPrimaryLightButton(r6, getMRightContainer());
        goto L9
    L7:
        Context r7 = getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        r2 = createPrimaryLightButton(r7, getMRightContainer());
        goto L9
    }

    public final OButton addRightTransButton(int r3) {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        OButton r2 = createTransButton(r0, getMRightContainer());
        r2.setButtonSourceBitmap(r3);
        return r2;
    }

    public final void setCenterText(int r2) {
        String r3 = getResources().getString(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "resources.getString(resId)");
        setTitleText(r3);
    }

    public final void setCenterText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        setTitleText(r2);
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final void removeAllLeftViews() {
        getMLeftContainer().removeAllViews();
    }

    public final void addRightView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        getMRightContainer().addView(r2);
    }

    public final void removeAllRightViews() {
        getMRightContainer().removeAllViews();
    }

    public final void sheetTitleBarStyle() {
        getMTitleView().setTextSize(16.0f);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void applyMaskMaterial(boolean r3) {
        int r0 = this.materialSrcType;
        if (r0 == (-1)) goto L6;
        MaterialOwnerKt.applyBackdropMaterial(this, r3, r0);
        return;
    L6:
        MaterialOwnerKt.applyBackdropMaterial(this, r3, this.isBackdropView);
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r3) {
        if (this.materialSrcType == (-1)) goto L6;
        MaterialOwnerKt.dispatchApplyContentMaterial(CollectionsKt.listOf(getMLeftActionBack()), r3);
        MaterialOwnerKt.applyBackdropMaterial(this, r3, this.materialSrcType);
        return;
    L6:
        MaterialOwnerKt.dispatchApplyContentMaterial(CollectionsKt.listOf(getMLeftActionBack()), r3);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(View r2) {
        this.backdropTarget = r2;
        if (r2 != null) goto L6;
        OSheetTitleBar r3 = this;
        OMaterialExtBaseKt.setMaterialBackdropTarget(r3, r3);
        setDefaultBackdropTargetForChild();
        return;
    L6:
        OMaterialExtBaseKt.setMaterialBackdropTarget(this, r2);
        MaterialOwnerKt.dispatchBackdropTarget(CollectionsKt.listOf(getMLeftActionBack()), r2);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r3) {
        if (this.isBackdropView == r3) goto L9;
        this.isBackdropView = r3;
        if (this.materialSrcType == (-1)) goto L7;
        return;
    L7:
        OMaterialExtBaseKt.updateMaterialBackdropTargetType(this, r3);
        MaterialOwnerKt.dispatchBackdropTargetType(CollectionsKt.listOf(getMLeftActionBack()), r3);
        return;
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r2) {
        this.materialSrcType = r2;
        MaterialOwnerKt.dispatchBackdropSrcType(CollectionsKt.listOf(getMLeftActionBack()), r2);
        OMaterialExtBaseKt.updateMaterialBackdropSrcType(this, r2);
    }

    private final void setDefaultBackdropTargetForChild() {
        View r0 = getDefaultTargetView();
        getMLeftActionBack().setBackdropTarget(r0);
    }

    private final View getDefaultTargetView() {
        if (OMaterialHelper.getEffectOverlayLevel() <= 1) goto L10;
        ViewGroup r2 = this.mTitleBarRoot;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
        r2 = null;
    L8:
        return r2;
    L10:
        return this;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r9, int r10) {
        boolean r0 = false;
        this.isFixedCenterOverflow = false;
        TextView r1 = this.mFixedCenterTitleView;
        TextView r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r1 = null;
    L5:
        r1.setMaxWidth(this.fixedCenterTitleDefaultMaxWidth);
        TextView r2 = this.mFixedCenterSubTitleView;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r2 = null;
    L8:
        r2.setMaxWidth(this.fixedCenterSubTitleDefaultMaxWidth);
        super.onMeasure(r9, r10);
        if (isFixedCenterTitleVisible() == true) goto L11;
        return;
    L11:
        int r4 = getTitleBarContentWidth();
        if (r4 > 0) goto L14;
        return;
    L14:
        Pair<Integer, Integer> r5 = getFixedCenterSafeBounds(r4);
        int r6 = r5.component1().intValue();
        int r7 = r5.component2().intValue();
        int r8 = r4 / 2;
        int r11 = Math.max(0, Math.min((r8 - r6) * 2, (r7 - r8) * 2));
        int r12 = Math.max(0, r7 - r6);
        if (getMFixedCenterContainer().getMeasuredWidth() <= r11) goto L39;
        boolean r13 = true;
        this.isFixedCenterOverflow = true;
        int r14 = Math.min(this.fixedCenterTitleDefaultMaxWidth, r12);
        int r15 = Math.min(this.fixedCenterSubTitleDefaultMaxWidth, r12);
        TextView r16 = this.mFixedCenterTitleView;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r16 = null;
    L20:
        if (r16.getMaxWidth() == r14) goto L25;
        TextView r17 = this.mFixedCenterTitleView;
        if (r17 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r17 = null;
    L24:
        r17.setMaxWidth(r14);
        r0 = true;
    L25:
        TextView r18 = this.mFixedCenterSubTitleView;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r18 = null;
    L29:
        if (r18.getMaxWidth() == r15) goto L35;
        TextView r19 = this.mFixedCenterSubTitleView;
        if (r19 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L34:
        r3.setMaxWidth(r15);
    L36:
        if (r13 == false) goto L40;
        super.onMeasure(r9, r10);
        return;
    L40:
        return;
    L33:
        r3 = r19;
        goto L34
    L35:
        r13 = r0;
        goto L36
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        if (isFixedCenterTitleVisible() == true) goto L5;
        return;
    L5:
        int r7 = getTitleBarContentWidth();
        if (r7 > 0) goto L8;
        return;
    L8:
        Pair<Integer, Integer> r8 = getFixedCenterSafeBounds(r7);
        int r9 = r8.component1().intValue();
        int r10 = r8.component2().intValue();
        int r11 = Math.max(0, r10 - r9);
        int r12 = getMFixedCenterContainer().getMeasuredWidth();
        int r13 = (r7 - r12) / 2;
        int r0 = r13 + r12;
        if (r12 <= r11) goto L11;
    L10:
        r13 = r9;
    L17:
        if (this.isFixedCenterOverflow == false) goto L20;
        if (r12 > r11) goto L20;
        r13 = r9 + ((r11 - r12) / 2);
        r10 = r13 + r12;
    L20:
        getMFixedCenterContainer().layout(r13, getMFixedCenterContainer().getTop(), r10, getMFixedCenterContainer().getBottom());
        return;
    L11:
        if (r13 >= r9) goto L13;
        r10 = r9 + r12;
        goto L10
    L13:
        if (r0 <= r10) goto L15;
        r13 = r10 - r12;
        goto L17
    L15:
        r10 = r0;
        goto L17
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        if (r1 == null) goto L6;
        this.mIsLargeFont = ViewUtil.isInLargeFont(r1.fontScale);
    L6:
        refreshDimensionCache();
    }

    private final int getCenterTitleGap() {
        if (this.mIsLargeFont == false) goto L6;
        return this.centerTitleGapLargeFontPx;
    L6:
        return this.centerTitleGapPx;
    }

    private final int getTitleBarContentWidth() {
        ViewGroup r0 = this.mTitleBarRoot;
        ViewGroup r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
        r0 = null;
    L6:
        if (r0.getMeasuredWidth() <= 0) goto L13;
        ViewGroup r3 = this.mTitleBarRoot;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
    L14:
        return r1.getMeasuredWidth();
    L10:
        r1 = r3;
        goto L14
    L13:
        return getMeasuredWidth();
    }

    private final Pair<Integer, Integer> getFixedCenterSafeBounds(int r6) {
        ViewGroup r0 = this.mTitleBarRoot;
        ViewGroup r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
        r0 = null;
    L5:
        int r2 = r0.getPaddingLeft();
        ViewGroup r3 = this.mTitleBarRoot;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
    L9:
        int r4 = r1.getPaddingRight();
        int r5 = getCenterTitleGap();
        int r7 = getOccupiedWidth(getMLeftContainer());
        int r8 = getOccupiedWidth(getMRightContainer());
        if (r7 <= 0) goto L12;
        int r9 = (r2 + r7) + r5;
    L13:
        if (r8 <= 0) goto L15;
        int r10 = ((r6 - r4) - r8) - r5;
    L17:
        return TuplesKt.to(Integer.valueOf(r9), Integer.valueOf(r10));
    L15:
        r10 = (r6 - r4) - this.centerTitleHorizontalPaddingPx;
        goto L17
    L12:
        r9 = r2 + this.centerTitleHorizontalPaddingPx;
        goto L13
    L8:
        r1 = r3;
        goto L9
    }

    private final void refreshDimensionCache() {
        OSheetTitleBar r0 = this;
        this.centerTitleGapPx = OUnitExtensionKt.vdp(r0, 12);
        this.centerTitleGapLargeFontPx = OUnitExtensionKt.vdp(r0, 4);
        this.centerTitleHorizontalPaddingPx = OUnitExtensionKt.vdp(r0, 8);
    }

    private final boolean isFixedCenterTitleVisible() {
        if (this.mTitlePosition == TitlePosition.FIXED_CENTER) goto L5;
        return false;
    L5:
        if (getMFixedCenterContainer().getVisibility() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L29;
        TextView r1 = this.mFixedCenterTitleView;
        TextView r3 = null;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r1 = null;
    L13:
        if (r1.getVisibility() != 0) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L27;
        TextView r4 = this.mFixedCenterSubTitleView;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L22:
        if (r3.getVisibility() != 0) goto L24;
        boolean r5 = true;
    L25:
        if (r5 == true) goto L27;
        return false;
    L24:
        r5 = false;
        goto L25
    L20:
        r3 = r4;
    L27:
        return true;
    L15:
        r2 = false;
        goto L16
    L29:
        return false;
    L7:
        r0 = false;
        goto L8
    }

    private final int getOccupiedWidth(View r3) {
        int r0 = 0;
        if (r3.getVisibility() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L15:
        return 0;
    L8:
        if (r3.getMeasuredWidth() <= 0) goto L15;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        r0 = r5.getMarginStart() + r5.getMarginEnd();
    L14:
        return r3.getMeasuredWidth() + r0;
    L5:
        r2 = false;
        goto L6
    }
}
