package com.obric.oui.coachmark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.widget.TextViewCompat;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.color.OPalette;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OCoachmarkView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u001f*\u0001\u001b\u0018\u0000 ¦\u00012\u00020\u0001:\b¤\u0001¥\u0001¦\u0001§\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010V\u001a\u00020WH\u0002J\u0010\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020ZH\u0002J\"\u0010[\u001a\u00020W2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\\\u001a\u00020W2\u0006\u0010]\u001a\u00020\u0007H\u0002J\b\u0010^\u001a\u00020WH\u0002J\b\u0010_\u001a\u00020WH\u0002J\b\u0010`\u001a\u00020WH\u0002J\b\u0010a\u001a\u00020WH\u0002J\u0010\u0010b\u001a\u0002042\u0006\u0010c\u001a\u00020\u0013H\u0002J\b\u0010d\u001a\u0004\u0018\u000100J\b\u0010e\u001a\u000204H\u0002J\b\u0010f\u001a\u000204H\u0002J\b\u0010g\u001a\u000204H\u0002J\b\u0010h\u001a\u000204H\u0002J\b\u0010i\u001a\u000204H\u0002J\b\u0010j\u001a\u00020WH\u0014J\b\u0010k\u001a\u00020WH\u0002J\n\u0010l\u001a\u0004\u0018\u00010KH\u0002J\n\u0010m\u001a\u0004\u0018\u000100H\u0002J\u000e\u0010n\u001a\u00020W2\u0006\u0010o\u001a\u00020\u0010J\u0010\u0010p\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u000100J\u000e\u0010r\u001a\u00020W2\u0006\u0010s\u001a\u00020\u0007J\u000e\u0010t\u001a\u00020W2\u0006\u0010u\u001a\u00020\u0019J\u000e\u0010v\u001a\u00020W2\u0006\u0010w\u001a\u000204J\u0012\u0010x\u001a\u00020W2\b\b\u0001\u0010y\u001a\u00020\u0007H\u0016J\u000e\u0010z\u001a\u00020W2\u0006\u0010w\u001a\u000204J\u000e\u0010{\u001a\u00020W2\u0006\u0010|\u001a\u00020\u0007J'\u0010{\u001a\u00020W2\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0007J\u000f\u0010\u0081\u0001\u001a\u00020W2\u0006\u0010o\u001a\u00020+J\u0017\u0010\u0082\u0001\u001a\u00020W2\u0006\u0010c\u001a\u00020\u0013H\u0000¢\u0006\u0003\b\u0083\u0001J\u0012\u0010\u0084\u0001\u001a\u00020W2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0007J4\u0010\u0086\u0001\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u0001002\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00072\f\b\u0002\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0007¢\u0006\u0003\u0010\u008a\u0001J\u0012\u0010\u008b\u0001\u001a\u00020W2\t\u0010\u008c\u0001\u001a\u0004\u0018\u000109J\u0012\u0010\u008d\u0001\u001a\u00020W2\t\u0010\u008c\u0001\u001a\u0004\u0018\u000109J\u0010\u0010\u008e\u0001\u001a\u00020W2\u0007\u0010\u008f\u0001\u001a\u00020\u0007J\u0012\u0010\u0090\u0001\u001a\u00020W2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010KJ\u0012\u0010\u0092\u0001\u001a\u00020W2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010KJ\u0012\u0010\u0093\u0001\u001a\u00020W2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010KJ\u0012\u0010\u0094\u0001\u001a\u00020W2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010KJ\u0011\u0010\u0095\u0001\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u000100J\u0011\u0010\u0096\u0001\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u000100J\u000f\u0010\u0097\u0001\u001a\u00020W2\u0006\u0010w\u001a\u000204J\u0011\u0010\u0098\u0001\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u000100J\u0011\u0010\u0099\u0001\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u000100J\u0012\u0010\u009a\u0001\u001a\u00020W2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0007J\u0012\u0010\u009b\u0001\u001a\u00020W2\u0007\u0010\u009c\u0001\u001a\u000204H\u0002J\t\u0010\u009d\u0001\u001a\u00020WH\u0002J\t\u0010\u009e\u0001\u001a\u00020WH\u0002J\t\u0010\u009f\u0001\u001a\u00020WH\u0002J\t\u0010 \u0001\u001a\u00020WH\u0002J\t\u0010¡\u0001\u001a\u00020WH\u0002J\t\u0010¢\u0001\u001a\u00020WH\u0002J\t\u0010£\u0001\u001a\u00020WH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0016\u00106\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u00107\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010A\u001a\u0002042\u0006\u0010@\u001a\u0002048F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0018\u0010E\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010FX\u0082\u000e¢\u0006\u0004\n\u0002\u0010HR\u000e\u0010I\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010S\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¨\u0001"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "actionFilledButton", "Lcom/obric/oui/button/OButton;", "actionNeutralTextColor", "Ljava/lang/Integer;", "actionPrimaryTextColor", "actionStyle", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "actionTextButton", "actionTextContainer", "Landroid/view/View;", "actionTextPrimaryButton", "arrowColor", "Landroid/content/res/ColorStateList;", "arrowOffsetPx", "arrowPosition", "Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "arrowTriangleOutlineProvider", "com/obric/oui/coachmark/OCoachmarkView$arrowTriangleOutlineProvider$1", "Lcom/obric/oui/coachmark/OCoachmarkView$arrowTriangleOutlineProvider$1;", "arrowView", "Landroid/widget/ImageView;", "bgColor", "closeButton", "Lcom/obric/oui/button/OIconButton;", "closeIconTint", "containerView", "contentContainer", "Landroid/view/ViewGroup;", "contentPaddingBottomPx", "contentPaddingEndPx", "contentPaddingStartPx", "contentPaddingTopPx", "contentStyle", "Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "customContentView", "descTextAppearance", "descTextColor", "descriptionText", "", "descriptionView", "Lcom/obric/oui/text/OTextView;", "enableMaterial", "", "filledActionBackgroundColor", "filledActionTextColor", "heroContainer", "heroDrawable", "Landroid/graphics/drawable/Drawable;", "heroImage", "iconContainer", "iconDrawable", "iconTint", "iconView", "isContentPaddingCustomized", "value", "isPopWindowMode", "()Z", "setPopWindowMode", "(Z)V", "materials", "", "Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/material/MaterialConfig;", "maxWidthPx", "primaryActionClickListener", "Landroid/view/View$OnClickListener;", "primaryActionText", "secondaryActionClickListener", "secondaryActionText", "showArrow", "showCloseIcon", "textGroup", "titleText", "titleTextAppearance", "titleTextColor", "titleView", "applyAppearance", "", "applyAppearanceAttributes", "array", "Landroid/content/res/TypedArray;", "applyAttributes", "applyContainerRadius", "radiusPx", "applyCustomContentPadding", "applyDefaults", "applyStylePadding", "applyStyledColors", "detachFromParent", "view", "getText", "hasDualTextActions", "hasPrimaryActionText", "hasSecondaryActionText", "hasVisibleActions", "isDarkTheme", "onDetachedFromWindow", "releaseCustomContentView", "resolveDisplayedActionClickListener", "resolveDisplayedActionText", "setActionStyle", "style", "setActionText", "text", "setArrowOffset", "offsetPx", "setArrowPosition", "position", "setArrowVisible", "visible", "setBackgroundColor", "color", "setCloseVisible", "setContentPadding", "paddingPx", "startPx", "topPx", "endPx", "bottomPx", "setContentStyle", "setCustomContentView", "setCustomContentView$OUI_standardRelease", "setDescTextAppearance", "resId", "setDescription", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/text/TextUtils$TruncateAt;)V", "setHeroImage", "drawable", "setIcon", "setMaxWidth", "widthPx", "setOnActionClickListener", "listener", "setOnCloseClickListener", "setOnPrimaryActionClickListener", "setOnSecondaryActionClickListener", "setPrimaryButtonText", "setSecondaryButtonText", "setShowCloseIcon", "setText", "setTitle", "setTitleTextAppearance", "updateActionTextTopMargin", "showIcon", "updateActions", "updateArrowPosition", "updateContainerPadding", "updateContent", "updateContentStyle", "updateDisplayedActionClickListener", "updateLayout", "ActionStyle", "ArrowPosition", "Companion", "ContentStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCoachmarkView extends OUIFrameLayout {
    public static final int CARD_CONTENT_PADDING_DP = 16;
    public static final int CARD_HORIZONTAL_PADDING_DP = 20;
    public static final int CARD_RADIUS_DP = 20;
    public static final int CARD_WIDTH_DP = 320;
    public static final Companion Companion = null;
    public static final int DEFAULT_HEIGHT_DP = 48;
    public static final int DEFAULT_ICON_GAP_DP = 12;
    public static final int DEFAULT_MAX_WIDTH_DP = 320;
    public static final int PILL_CONTENT_PADDING_DP = 8;
    public static final int PILL_HORIZONTAL_PADDING_DP = 20;
    public static final int PILL_RADIUS_DP = 28;
    public static final int SIDE_ARROW_HEIGHT_DP = 20;
    public static final int SIDE_ARROW_INTRUSION_DP = 2;
    public static final int SIDE_ARROW_WIDTH_DP = 10;
    private static final String TAG = "OCoachmarkView";
    public static final int TEXT_ACTION_TOP_MARGIN_TEXT_ONLY_DP = 12;
    public static final int TEXT_ACTION_TOP_MARGIN_WITH_ICON_DP = 8;
    public static final int TITLE_DESC_GAP_DP = 4;
    public static final int TOP_BOTTOM_ARROW_HEIGHT_DP = 9;
    public static final int TOP_BOTTOM_ARROW_INTRUSION_DP = 1;
    public static final int TOP_BOTTOM_ARROW_WIDTH_DP = 20;
    private final OButton actionFilledButton;
    private Integer actionNeutralTextColor;
    private Integer actionPrimaryTextColor;
    private ActionStyle actionStyle;
    private final OButton actionTextButton;
    private final View actionTextContainer;
    private final OButton actionTextPrimaryButton;
    private ColorStateList arrowColor;
    private int arrowOffsetPx;
    private ArrowPosition arrowPosition;
    private final OCoachmarkView$arrowTriangleOutlineProvider$1 arrowTriangleOutlineProvider;
    private final ImageView arrowView;
    private int bgColor;
    private final OIconButton closeButton;
    private ColorStateList closeIconTint;
    private final OUIFrameLayout containerView;
    private final ViewGroup contentContainer;
    private int contentPaddingBottomPx;
    private int contentPaddingEndPx;
    private int contentPaddingStartPx;
    private int contentPaddingTopPx;
    private ContentStyle contentStyle;
    private View customContentView;
    private int descTextAppearance;
    private ColorStateList descTextColor;
    private CharSequence descriptionText;
    private final OTextView descriptionView;
    private boolean enableMaterial;
    private Integer filledActionBackgroundColor;
    private Integer filledActionTextColor;
    private final View heroContainer;
    private Drawable heroDrawable;
    private final ImageView heroImage;
    private final OUIFrameLayout iconContainer;
    private Drawable iconDrawable;
    private ColorStateList iconTint;
    private final ImageView iconView;
    private boolean isContentPaddingCustomized;
    private boolean isPopWindowMode;
    private MaterialConfig[] materials;
    private int maxWidthPx;
    private View.OnClickListener primaryActionClickListener;
    private CharSequence primaryActionText;
    private View.OnClickListener secondaryActionClickListener;
    private CharSequence secondaryActionText;
    private boolean showArrow;
    private boolean showCloseIcon;
    private final View textGroup;
    private CharSequence titleText;
    private int titleTextAppearance;
    private ColorStateList titleTextColor;
    private final OTextView titleView;

    /* JADX INFO: compiled from: OCoachmarkView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "TEXT_ONLY", "FILLED_BUTTON", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ActionStyle extends Enum<ActionStyle> {
        private static final /* synthetic */ ActionStyle[] $VALUES = null;
        public static final Companion Companion = null;
        public static final ActionStyle FILLED_BUTTON = null;
        public static final ActionStyle NONE = null;
        public static final ActionStyle TEXT_ONLY = null;
        private final int value;

        /* JADX INFO: compiled from: OCoachmarkView.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle$Companion;", "", "()V", "fromValue", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "value", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final ActionStyle fromValue(int r6) {
                ActionStyle[] r5 = ActionStyle.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                ActionStyle r3 = r5[r2];
                if (r3.getValue() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return ActionStyle.NONE;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ ActionStyle[] $values() {
            return new ActionStyle[]{NONE, TEXT_ONLY, FILLED_BUTTON};
        }

        public static ActionStyle valueOf(String r1) {
            return (ActionStyle) Enum.valueOf(ActionStyle.class, r1);
        }

        public static ActionStyle[] values() {
            return (ActionStyle[]) $VALUES.clone();
        }

        private ActionStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            NONE = new ActionStyle("NONE", 0, 0);
            TEXT_ONLY = new ActionStyle("TEXT_ONLY", 1, 1);
            FILLED_BUTTON = new ActionStyle("FILLED_BUTTON", 2, 2);
            $VALUES = $values();
            Companion = new Companion(null);
        }
    }

    /* JADX INFO: compiled from: OCoachmarkView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP", "BOTTOM", "LEFT", "RIGHT", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ArrowPosition extends Enum<ArrowPosition> {
        private static final /* synthetic */ ArrowPosition[] $VALUES = null;
        public static final ArrowPosition BOTTOM = null;
        public static final Companion Companion = null;
        public static final ArrowPosition LEFT = null;
        public static final ArrowPosition RIGHT = null;
        public static final ArrowPosition TOP = null;
        private final int value;

        /* JADX INFO: compiled from: OCoachmarkView.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition$Companion;", "", "()V", "fromValue", "Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "value", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final ArrowPosition fromValue(int r6) {
                ArrowPosition[] r5 = ArrowPosition.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                ArrowPosition r3 = r5[r2];
                if (r3.getValue() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return ArrowPosition.TOP;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ ArrowPosition[] $values() {
            return new ArrowPosition[]{TOP, BOTTOM, LEFT, RIGHT};
        }

        public static ArrowPosition valueOf(String r1) {
            return (ArrowPosition) Enum.valueOf(ArrowPosition.class, r1);
        }

        public static ArrowPosition[] values() {
            return (ArrowPosition[]) $VALUES.clone();
        }

        private ArrowPosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            TOP = new ArrowPosition("TOP", 0, 0);
            BOTTOM = new ArrowPosition("BOTTOM", 1, 1);
            LEFT = new ArrowPosition("LEFT", 2, 2);
            RIGHT = new ArrowPosition("RIGHT", 3, 3);
            $VALUES = $values();
            Companion = new Companion(null);
        }
    }

    /* JADX INFO: compiled from: OCoachmarkView.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$Companion;", "", "()V", "CARD_CONTENT_PADDING_DP", "", "CARD_HORIZONTAL_PADDING_DP", "CARD_RADIUS_DP", "CARD_WIDTH_DP", "DEFAULT_HEIGHT_DP", "DEFAULT_ICON_GAP_DP", "DEFAULT_MAX_WIDTH_DP", "PILL_CONTENT_PADDING_DP", "PILL_HORIZONTAL_PADDING_DP", "PILL_RADIUS_DP", "SIDE_ARROW_HEIGHT_DP", "SIDE_ARROW_INTRUSION_DP", "SIDE_ARROW_WIDTH_DP", "TAG", "", "TEXT_ACTION_TOP_MARGIN_TEXT_ONLY_DP", "TEXT_ACTION_TOP_MARGIN_WITH_ICON_DP", "TITLE_DESC_GAP_DP", "TOP_BOTTOM_ARROW_HEIGHT_DP", "TOP_BOTTOM_ARROW_INTRUSION_DP", "TOP_BOTTOM_ARROW_WIDTH_DP", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OCoachmarkView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PILL", "CARD", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ContentStyle extends Enum<ContentStyle> {
        private static final /* synthetic */ ContentStyle[] $VALUES = null;
        public static final ContentStyle CARD = null;
        public static final Companion Companion = null;
        public static final ContentStyle PILL = null;
        private final int value;

        /* JADX INFO: compiled from: OCoachmarkView.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle$Companion;", "", "()V", "fromValue", "Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "value", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final ContentStyle fromValue(int r6) {
                ContentStyle[] r5 = ContentStyle.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                ContentStyle r3 = r5[r2];
                if (r3.getValue() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return ContentStyle.PILL;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ ContentStyle[] $values() {
            return new ContentStyle[]{PILL, CARD};
        }

        public static ContentStyle valueOf(String r1) {
            return (ContentStyle) Enum.valueOf(ContentStyle.class, r1);
        }

        public static ContentStyle[] values() {
            return (ContentStyle[]) $VALUES.clone();
        }

        private ContentStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            PILL = new ContentStyle("PILL", 0, 0);
            CARD = new ContentStyle("CARD", 1, 1);
            $VALUES = $values();
            Companion = new Companion(null);
        }
    }

    /* JADX INFO: compiled from: OCoachmarkView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r0 = new int[ContentStyle.values().length];
            r0[ContentStyle.PILL.ordinal()] = 1;
            r0[ContentStyle.CARD.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[ActionStyle.values().length];
            r1[ActionStyle.TEXT_ONLY.ordinal()] = 1;
            r1[ActionStyle.FILLED_BUTTON.ordinal()] = 2;
            r1[ActionStyle.NONE.ordinal()] = 3;
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[ArrowPosition.values().length];
            r2[ArrowPosition.TOP.ordinal()] = 1;
            r2[ArrowPosition.BOTTOM.ordinal()] = 2;
            r2[ArrowPosition.LEFT.ordinal()] = 3;
            r2[ArrowPosition.RIGHT.ordinal()] = 4;
            $EnumSwitchMapping$2 = r2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OCoachmarkView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OCoachmarkView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OCoachmarkView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public final void setDescription(CharSequence r7) {
        setDescription$default(this, r7, null, null, 6, null);
    }

    public final void setDescription(CharSequence r7, Integer r8) {
        setDescription$default(this, r7, r8, null, 4, null);
    }

    public static final /* synthetic */ ActionStyle access$getActionStyle$p(OCoachmarkView r0) {
        return r0.actionStyle;
    }

    public static final /* synthetic */ ArrowPosition access$getArrowPosition$p(OCoachmarkView r0) {
        return r0.arrowPosition;
    }

    public /* synthetic */ OCoachmarkView(Context r1, AttributeSet r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = R.attr.ocoachmarkViewStyle;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = R.style.OStyleV2_OCoachmarkView_DayNight;
    L11:
        this(r1, r2, r3, r4);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.oui.coachmark.OCoachmarkView$arrowTriangleOutlineProvider$1] */
    public OCoachmarkView(Context r7, AttributeSet r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9, new OUIStyleProvider(r7, r8, r9, r10));
        ?? r0 = new OCoachmarkView$arrowTriangleOutlineProvider$1(this);
        this.arrowTriangleOutlineProvider = r0;
        this.actionStyle = ActionStyle.NONE;
        this.arrowPosition = ArrowPosition.TOP;
        this.contentStyle = ContentStyle.PILL;
        this.showArrow = true;
        OCoachmarkView r2 = this;
        this.maxWidthPx = OUnitExtensionKt.vdp(r2, 320);
        this.contentPaddingStartPx = OUnitExtensionKt.vdp(r2, 20);
        this.contentPaddingTopPx = OUnitExtensionKt.vdp(r2, 8);
        this.contentPaddingEndPx = OUnitExtensionKt.vdp(r2, 20);
        this.contentPaddingBottomPx = OUnitExtensionKt.vdp(r2, 8);
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(r2) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.enableMaterial = r3;
        LayoutInflater.from(r7).inflate(R.layout.o_coachmark, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setChangeAlphaWhenPress(false);
        View r11 = findViewById(R.id.coachmark_container);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.coachmark_container)");
        OUIFrameLayout r12 = (OUIFrameLayout) r11;
        this.containerView = r12;
        r12.setChangeAlphaWhenPress(false);
        View r13 = findViewById(R.id.iv_coachmark_arrow);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.iv_coachmark_arrow)");
        ImageView r14 = (ImageView) r13;
        this.arrowView = r14;
        r14.setOutlineProvider((ViewOutlineProvider) r0);
        View r15 = findViewById(R.id.coachmark_hero_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.coachmark_hero_container)");
        this.heroContainer = r15;
        View r16 = findViewById(R.id.coachmark_hero_image);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.coachmark_hero_image)");
        this.heroImage = (ImageView) r16;
        View r17 = findViewById(R.id.coachmark_content_container);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.coachmark_content_container)");
        this.contentContainer = (ViewGroup) r17;
        View r18 = findViewById(R.id.coachmark_icon_container);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.coachmark_icon_container)");
        this.iconContainer = (OUIFrameLayout) r18;
        View r19 = findViewById(R.id.coachmark_icon);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.coachmark_icon)");
        this.iconView = (ImageView) r19;
        View r20 = findViewById(R.id.tv_coachmark_title);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.tv_coachmark_title)");
        OTextView r21 = (OTextView) r20;
        this.titleView = r21;
        r21.getPaint().setSubpixelText(true);
        r21.setIncludeFontPadding(true);
        View r22 = findViewById(R.id.tv_coachmark_description);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.tv_coachmark_description)");
        OTextView r23 = (OTextView) r22;
        this.descriptionView = r23;
        r23.getPaint().setSubpixelText(true);
        r23.setIncludeFontPadding(true);
        View r24 = findViewById(R.id.coachmark_text_group);
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.coachmark_text_group)");
        this.textGroup = r24;
        View r25 = findViewById(R.id.coachmark_action_text_container);
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.coachmark_action_text_container)");
        this.actionTextContainer = r25;
        View r26 = findViewById(R.id.btn_coachmark_action_text);
        Intrinsics.checkNotNullExpressionValue(r26, "findViewById(R.id.btn_coachmark_action_text)");
        this.actionTextButton = (OButton) r26;
        View r27 = findViewById(R.id.btn_coachmark_action_text_primary);
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.btn_co…mark_action_text_primary)");
        this.actionTextPrimaryButton = (OButton) r27;
        View r28 = findViewById(R.id.btn_coachmark_action_filled);
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.btn_coachmark_action_filled)");
        this.actionFilledButton = (OButton) r28;
        View r29 = findViewById(R.id.btn_coachmark_close);
        Intrinsics.checkNotNullExpressionValue(r29, "findViewById(R.id.btn_coachmark_close)");
        this.closeButton = (OIconButton) r29;
        applyDefaults();
        applyAttributes(r8, r9, r10);
        updateLayout();
        return;
    L5:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L7;
        r3 = true;
        goto L8
    }

    public final boolean isPopWindowMode() {
        return this.isPopWindowMode;
    }

    public final void setPopWindowMode(boolean r2) {
        if (this.isPopWindowMode == r2) goto L12;
        this.isPopWindowMode = r2;
        if (this.enableMaterial == true) goto L7;
        return;
    L7:
        if (this.materials == null) goto L14;
        if (r2 == false) goto L10;
        OMaterialHelper.setEffectSrc(this.containerView, 3);
        OMaterialHelper.setEffectSrc(this.arrowView, 3);
        return;
    L10:
        OMaterialHelper.setEffectSrc(this.containerView, 2);
        OMaterialHelper.setEffectSrc(this.arrowView, 2);
        return;
    L14:
        return;
    }

    public final void setText(CharSequence r7) {
        setDescription$default(this, r7, null, null, 6, null);
    }

    public final CharSequence getText() {
        CharSequence r0 = this.descriptionText;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.descriptionView.getText();
    }

    public final void setTitle(CharSequence r1) {
        this.titleText = r1;
        updateLayout();
    }

    public static /* synthetic */ void setDescription$default(OCoachmarkView r1, CharSequence r2, Integer r3, TextUtils.TruncateAt r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.setDescription(r2, r3, r4);
    }

    public final void setDescription(CharSequence r1, Integer r2, TextUtils.TruncateAt r3) {
        this.descriptionText = r1;
        if (r2 == null) goto L6;
        int r4 = r2.intValue();
        this.descriptionView.setMaxLines(r4);
    L6:
        if (r3 == null) goto L9;
        this.descriptionView.setEllipsize(r3);
    L9:
        updateLayout();
    }

    public final void setContentStyle(ContentStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        if (this.contentStyle == r2) goto L6;
        this.contentStyle = r2;
        applyStylePadding();
        updateLayout();
        return;
    }

    public final void setIcon(Drawable r1) {
        this.iconDrawable = r1;
        updateLayout();
    }

    public final void setHeroImage(Drawable r1) {
        this.heroDrawable = r1;
        updateLayout();
    }

    public final void setCustomContentView$OUI_standardRelease(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (this.customContentView != r4) goto L7;
        updateLayout();
        return;
    L7:
        if (detachFromParent(r4) == true) goto L13;
        L r3 = L.INSTANCE;
        if (r3.isBlocked(8) == true) goto L15;
        r3.getImpl().writeLog(TAG, 8, "custom content view ignored because it cannot be moved into coachmark content container.", null);
        return;
    L15:
        return;
    L13:
        this.contentContainer.removeAllViews();
        this.customContentView = r4;
        this.contentContainer.addView(r4);
        updateLayout();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        releaseCustomContentView();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        if (this.bgColor == r2) goto L6;
        this.bgColor = r2;
        applyAppearance();
        return;
    }

    public final void setTitleTextAppearance(int r2) {
        if (this.titleTextAppearance == r2) goto L6;
        this.titleTextAppearance = r2;
        applyAppearance();
        return;
    }

    public final void setDescTextAppearance(int r2) {
        if (this.descTextAppearance == r2) goto L6;
        this.descTextAppearance = r2;
        applyAppearance();
        return;
    }

    public final void setMaxWidth(int r2) {
        if (r2 > 0) goto L4;
        return;
    L4:
        if (this.maxWidthPx == r2) goto L8;
        this.maxWidthPx = r2;
        updateLayout();
        return;
    }

    public final void setContentPadding(int r2) {
        this.isContentPaddingCustomized = true;
        this.contentPaddingStartPx = r2;
        this.contentPaddingTopPx = r2;
        this.contentPaddingEndPx = r2;
        this.contentPaddingBottomPx = r2;
        updateLayout();
    }

    public final void setContentPadding(int r2, int r3, int r4, int r5) {
        this.isContentPaddingCustomized = true;
        this.contentPaddingStartPx = r2;
        this.contentPaddingTopPx = r3;
        this.contentPaddingEndPx = r4;
        this.contentPaddingBottomPx = r5;
        updateLayout();
    }

    public final void setActionText(CharSequence r1) {
        setPrimaryButtonText(r1);
    }

    public final void setPrimaryButtonText(CharSequence r1) {
        this.primaryActionText = r1;
        updateLayout();
    }

    public final void setSecondaryButtonText(CharSequence r1) {
        this.secondaryActionText = r1;
        updateLayout();
    }

    public final void setActionStyle(ActionStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        if (this.actionStyle == r2) goto L6;
        this.actionStyle = r2;
        updateLayout();
        return;
    }

    public final void setOnActionClickListener(View.OnClickListener r1) {
        setOnPrimaryActionClickListener(r1);
    }

    public final void setOnPrimaryActionClickListener(View.OnClickListener r1) {
        this.primaryActionClickListener = r1;
        updateDisplayedActionClickListener();
    }

    public final void setOnSecondaryActionClickListener(View.OnClickListener r1) {
        this.secondaryActionClickListener = r1;
        updateDisplayedActionClickListener();
    }

    public final void setArrowVisible(boolean r2) {
        if (this.showArrow != r2) goto L5;
        return;
    L5:
        this.showArrow = r2;
        ViewExtensionsKt.setVisibility(this.arrowView, r2);
        updateArrowPosition();
    }

    public final void setArrowPosition(ArrowPosition r2) {
        Intrinsics.checkNotNullParameter(r2, "position");
        if (this.arrowPosition != r2) goto L5;
        return;
    L5:
        this.arrowPosition = r2;
        updateArrowPosition();
    }

    public final void setArrowOffset(int r2) {
        if (this.arrowOffsetPx != r2) goto L5;
        return;
    L5:
        this.arrowOffsetPx = r2;
        updateArrowPosition();
    }

    public final void setOnCloseClickListener(View.OnClickListener r1) {
        this.closeButton.setOnClickListener(r1);
    }

    public final void setShowCloseIcon(boolean r2) {
        if (this.showCloseIcon == r2) goto L6;
        this.showCloseIcon = r2;
        applyStylePadding();
        updateLayout();
        return;
    }

    public final void setCloseVisible(boolean r1) {
        setShowCloseIcon(r1);
    }

    private final void applyDefaults() {
        this.bgColor = getContext().getColor(R.color.oui_bg_base_3_high_elevation);
        this.containerView.setMinimumHeight(OUnitExtensionKt.vdp(this, 48));
        this.containerView.setBackgroundColor(this.bgColor);
        this.containerView.setOuterNormalColor(this.bgColor);
        updateArrowPosition();
    }

    private final void applyAttributes(AttributeSet r5, int r6, int r7) {
        TypedArray r8 = getContext().obtainStyledAttributes(r5, R.styleable.OCoachmarkView, r6, r7);
        CharSequence r9 = r8.getText(R.styleable.OCoachmarkView_android_text);     // Catch: Throwable -> L71
        if (r9 == null) goto L8;
        this.descriptionText = r9;     // Catch: Throwable -> L71
    L8:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmTitle) == false) goto L11;
        this.titleText = r8.getText(R.styleable.OCoachmarkView_cmTitle);     // Catch: Throwable -> L71
    L11:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmIcon) == false) goto L14;
        this.iconDrawable = r8.getDrawable(R.styleable.OCoachmarkView_cmIcon);     // Catch: Throwable -> L71
    L14:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmHeroImage) == false) goto L16;
        Drawable r10 = r8.getDrawable(R.styleable.OCoachmarkView_cmHeroImage);     // Catch: Throwable -> L71
    L17:
        if (r10 == null) goto L20;
        this.heroDrawable = r10;     // Catch: Throwable -> L71
    L20:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmContentStyle) == false) goto L23;
        this.contentStyle = ContentStyle.Companion.fromValue(r8.getInt(R.styleable.OCoachmarkView_cmContentStyle, ContentStyle.PILL.getValue()));     // Catch: Throwable -> L71
    L23:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmShowCloseIcon) == false) goto L25;
        this.showCloseIcon = r8.getBoolean(R.styleable.OCoachmarkView_cmShowCloseIcon, false);     // Catch: Throwable -> L71
    L25:
        applyStylePadding();     // Catch: Throwable -> L71
        if (r8.hasValue(R.styleable.OCoachmarkView_cmActionText) == false) goto L28;
        this.primaryActionText = r8.getText(R.styleable.OCoachmarkView_cmActionText);     // Catch: Throwable -> L71
        boolean r11 = true;
    L30:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmPrimaryButtonText) == false) goto L33;
        this.primaryActionText = r8.getText(R.styleable.OCoachmarkView_cmPrimaryButtonText);     // Catch: Throwable -> L71
        r11 = true;
    L33:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmSecondaryButtonText) == false) goto L36;
        this.secondaryActionText = r8.getText(R.styleable.OCoachmarkView_cmSecondaryButtonText);     // Catch: Throwable -> L71
        r11 = true;
    L36:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmActionStyle) == false) goto L38;
        this.actionStyle = ActionStyle.Companion.fromValue(r8.getInt(R.styleable.OCoachmarkView_cmActionStyle, ActionStyle.NONE.getValue()));     // Catch: Throwable -> L71
        boolean r1 = true;
    L39:
        Intrinsics.checkNotNullExpressionValue(r8, "this");     // Catch: Throwable -> L71
        applyAppearanceAttributes(r8);     // Catch: Throwable -> L71
        if (r8.hasValue(R.styleable.OCoachmarkView_cmMaxWidth) == false) goto L43;
        this.maxWidthPx = r8.getDimensionPixelSize(R.styleable.OCoachmarkView_cmMaxWidth, this.maxWidthPx);     // Catch: Throwable -> L71
    L43:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmContentPadding) == false) goto L45;
        int r2 = r8.getDimensionPixelSize(R.styleable.OCoachmarkView_cmContentPadding, this.contentPaddingStartPx);     // Catch: Throwable -> L71
        this.contentPaddingStartPx = r2;     // Catch: Throwable -> L71
        this.contentPaddingTopPx = r2;     // Catch: Throwable -> L71
        this.contentPaddingEndPx = r2;     // Catch: Throwable -> L71
        this.contentPaddingBottomPx = r2;     // Catch: Throwable -> L71
        boolean r3 = true;
    L47:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmContentPaddingStart) == false) goto L50;
        this.contentPaddingStartPx = r8.getDimensionPixelSize(R.styleable.OCoachmarkView_cmContentPaddingStart, this.contentPaddingStartPx);     // Catch: Throwable -> L71
        r3 = true;
    L50:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmContentPaddingTop) == false) goto L53;
        this.contentPaddingTopPx = r8.getDimensionPixelSize(R.styleable.OCoachmarkView_cmContentPaddingTop, this.contentPaddingTopPx);     // Catch: Throwable -> L71
        r3 = true;
    L53:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmContentPaddingEnd) == false) goto L56;
        this.contentPaddingEndPx = r8.getDimensionPixelSize(R.styleable.OCoachmarkView_cmContentPaddingEnd, this.contentPaddingEndPx);     // Catch: Throwable -> L71
        r3 = true;
    L56:
        if (r8.hasValue(R.styleable.OCoachmarkView_cmContentPaddingBottom) == false) goto L58;
        this.contentPaddingBottomPx = r8.getDimensionPixelSize(R.styleable.OCoachmarkView_cmContentPaddingBottom, this.contentPaddingBottomPx);     // Catch: Throwable -> L71
        r3 = true;
    L58:
        if (r3 == false) goto L60;
        this.isContentPaddingCustomized = true;     // Catch: Throwable -> L71
    L60:
        boolean r0 = r8.getBoolean(R.styleable.OCoachmarkView_cmShowArrow, true);     // Catch: Throwable -> L71
        this.showArrow = r0;     // Catch: Throwable -> L71
        ViewExtensionsKt.setVisibility(this.arrowView, r0);     // Catch: Throwable -> L71
        this.arrowPosition = ArrowPosition.Companion.fromValue(r8.getInt(R.styleable.OCoachmarkView_cmArrowPosition, ArrowPosition.TOP.getValue()));     // Catch: Throwable -> L71
        if (r8.hasValue(R.styleable.OCoachmarkView_cmArrowOffset) == false) goto L63;
        this.arrowOffsetPx = r8.getDimensionPixelSize(R.styleable.OCoachmarkView_cmArrowOffset, 0);     // Catch: Throwable -> L71
    L63:
        r8.recycle();
        if (r1 == true) goto L76;
        if (r11 == false) goto L77;
        L r4 = L.INSTANCE;
        if (r4.isBlocked(8) == true) goto L78;
        r4.getImpl().writeLog(TAG, 8, "Action text is set without cmActionStyle; action will stay hidden.", null);
        return;
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L45:
        r3 = false;
        goto L47
    L38:
        r1 = false;
        goto L39
    L28:
        r11 = false;
        goto L30
    L16:
        r10 = r8.getDrawable(R.styleable.OCoachmarkView_android_src);     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        r8.recycle();
        throw th;
    }

    private final void applyAppearanceAttributes(TypedArray r6) {
        if (r6.hasValue(R.styleable.OCoachmarkView_cmBackgroundColor) == false) goto L6;
        this.bgColor = r6.getColor(R.styleable.OCoachmarkView_cmBackgroundColor, this.bgColor);
    L21:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmTitleTextColor) == false) goto L24;
        this.titleTextColor = r6.getColorStateList(R.styleable.OCoachmarkView_cmTitleTextColor);
    L24:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmDescTextColor) == false) goto L27;
        this.descTextColor = r6.getColorStateList(R.styleable.OCoachmarkView_cmDescTextColor);
    L27:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmIconTint) == false) goto L30;
        this.iconTint = r6.getColorStateList(R.styleable.OCoachmarkView_cmIconTint);
    L30:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmCloseIconTint) == false) goto L33;
        this.closeIconTint = r6.getColorStateList(R.styleable.OCoachmarkView_cmCloseIconTint);
    L33:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmArrowColor) == false) goto L36;
        this.arrowColor = r6.getColorStateList(R.styleable.OCoachmarkView_cmArrowColor);
    L36:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmActionNeutralTextColor) == false) goto L39;
        this.actionNeutralTextColor = Integer.valueOf(r6.getColor(R.styleable.OCoachmarkView_cmActionNeutralTextColor, 0));
    L39:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmActionPrimaryTextColor) == false) goto L42;
        this.actionPrimaryTextColor = Integer.valueOf(r6.getColor(R.styleable.OCoachmarkView_cmActionPrimaryTextColor, 0));
    L42:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmFilledActionTextColor) == false) goto L45;
        this.filledActionTextColor = Integer.valueOf(r6.getColor(R.styleable.OCoachmarkView_cmFilledActionTextColor, 0));
    L45:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmFilledActionBackgroundColor) == false) goto L48;
        this.filledActionBackgroundColor = Integer.valueOf(r6.getColor(R.styleable.OCoachmarkView_cmFilledActionBackgroundColor, 0));
    L48:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmTitleTextAppearance) == false) goto L51;
        this.titleTextAppearance = r6.getResourceId(R.styleable.OCoachmarkView_cmTitleTextAppearance, 0);
    L51:
        if (r6.hasValue(R.styleable.OCoachmarkView_cmDescTextAppearance) == false) goto L54;
        this.descTextAppearance = r6.getResourceId(R.styleable.OCoachmarkView_cmDescTextAppearance, 0);
    L54:
        if (this.enableMaterial == false) goto L57;
        this.enableMaterial = r6.getBoolean(R.styleable.OCoachmarkView_oui_widgetEnableMaterial, true);
    L57:
        if (this.enableMaterial == false) goto L63;
        String r0 = r6.getString(R.styleable.OCoachmarkView_oui_widgetMaterial);
        if (r0 != null) goto L61;
        r0 = r6.getResources().getString(R.string.oui_material_bg_popup);
    L61:
        this.materials = MaterialToken.parseSet(r0, !isDarkTheme());
        return;
    L63:
        return;
    L6:
        if (r6.hasValue(R.styleable.OCoachmarkView_android_background) == false) goto L21;
        Drawable r1 = r6.getDrawable(R.styleable.OCoachmarkView_android_background);
        if ((r1 instanceof ColorDrawable) == false) goto L10;
        ColorDrawable r2 = (ColorDrawable) r1;
    L11:
        if (r2 != null) goto L13;
        Integer r3 = null;
    L14:
        if (r3 == null) goto L16;
        this.bgColor = r3.intValue();
        goto L21
    L16:
        L r4 = L.INSTANCE;
        if (r4.isBlocked(8) == true) goto L21;
        r4.getImpl().writeLog(TAG, 8, "android:background is not a color; ignored. Use cmBackgroundColor for color.", null);
        goto L21
    L13:
        r3 = Integer.valueOf(r2.getColor());
        goto L14
    L10:
        r2 = null;
        goto L11
    }

    private final boolean isDarkTheme() {
        int r0 = this.bgColor;
        if (r0 != 0) goto L7;
        return ViewUtilKt.isDarkMode(this);
    L7:
        return OPalette.isDarkColor(r0);
    }

    private final void updateLayout() {
        updateContentStyle();
        updateContent();
        if (this.materials == null) goto L6;
        this.containerView.setEnableShadowWidthRadius(true);
    L6:
        applyAppearance();
        applyStylePadding();
        updateContainerPadding();
        updateArrowPosition();
    }

    private final void updateContentStyle() {
        this.containerView.setWidthLimit(this.maxWidthPx);
        OUIFrameLayout r0 = this.containerView;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L17;
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        FrameLayout.LayoutParams r3 = r2;
        ContentStyle r4 = this.contentStyle;
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 != 1) goto L7;
        int r6 = -2;
    L14:
        r3.width = r6;
        r0.setLayoutParams(r2);
        return;
    L7:
        if (r5 != 2) goto L12;
        int r7 = OWindowConfigController.getFullWindowSize(getContext()).getWidth();
        r6 = OUnitExtensionKt.vdp(this, 320);
        if (r6 <= r7) goto L14;
        r6 = -1;
        goto L14
    L12:
        throw new NoWhenBranchMatchedException();
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    private final void applyStylePadding() {
        if (this.isContentPaddingCustomized == false) goto L6;
        return;
    L6:
        if (this.customContentView == null) goto L9;
        applyCustomContentPadding();
        return;
    L9:
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.contentStyle.ordinal()];
        int r1 = 0;
        if (r0 != 1) goto L12;
        OCoachmarkView r2 = this;
        this.contentPaddingStartPx = OUnitExtensionKt.vdp(r2, 20);
        this.contentPaddingTopPx = OUnitExtensionKt.vdp(r2, 8);
        if (this.showCloseIcon == true) goto L33;
        r1 = OUnitExtensionKt.vdp(r2, 20);
    L33:
        this.contentPaddingEndPx = r1;
        this.contentPaddingBottomPx = OUnitExtensionKt.vdp(r2, 8);
        return;
    L12:
        if (r0 != 2) goto L36;
        boolean r3 = hasVisibleActions();
        if (this.iconDrawable == null) goto L20;
        if (this.heroDrawable != null) goto L20;
        r1 = 1;
    L20:
        if (r1 == 0) goto L23;
        if (r3 == false) goto L23;
        int r4 = OUnitExtensionKt.vdp(this, 16);
    L24:
        this.contentPaddingStartPx = r4;
        OCoachmarkView r5 = this;
        this.contentPaddingTopPx = OUnitExtensionKt.vdp(r5, 16);
        if (r3 == false) goto L27;
        int r6 = OUnitExtensionKt.vdp(r5, 16);
    L28:
        this.contentPaddingEndPx = r6;
        this.contentPaddingBottomPx = OUnitExtensionKt.vdp(r5, 16);
        return;
    L27:
        r6 = OUnitExtensionKt.vdp(r5, 20);
    L23:
        r4 = OUnitExtensionKt.vdp(this, 20);
        goto L24
    }

    private final void applyCustomContentPadding() {
        ContentStyle r0 = this.contentStyle;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        OCoachmarkView r2 = this;
        int r3 = OUnitExtensionKt.vdp(r2, 20);
        int r4 = OUnitExtensionKt.vdp(r2, 8);
        this.contentPaddingStartPx = r3;
        this.contentPaddingTopPx = r4;
        this.contentPaddingEndPx = r3;
        this.contentPaddingBottomPx = r4;
        return;
    L5:
        if (r1 != 2) goto L11;
        OCoachmarkView r5 = this;
        int r6 = OUnitExtensionKt.vdp(r5, 20);
        int r7 = OUnitExtensionKt.vdp(r5, 16);
        this.contentPaddingStartPx = r6;
        this.contentPaddingTopPx = r7;
        this.contentPaddingEndPx = r6;
        this.contentPaddingBottomPx = r7;
        return;
    }

    private final void applyAppearance() {
        int r1 = WhenMappings.$EnumSwitchMapping$0[this.contentStyle.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = OUnitExtensionKt.vdp(this, 28);
    L10:
        applyContainerRadius(r2);
        if (this.enableMaterial == false) goto L20;
        MaterialConfig[] r4 = this.materials;
        if (r4 == null) goto L20;
        if (this.showArrow == false) goto L17;
        OUIFrameLayout r11 = this.containerView;
        Intrinsics.checkNotNull(r4);
        OMaterialExtBaseKt.material$default(r11, r4[0], false, 0, 6, null);
        OMaterialHelper.setStrokeEffect(this.containerView, 0.0f, 0);
        this.containerView.setOuterNormalColor(0);
        this.containerView.setBorderWidth(0);
    L18:
        OUIFrameLayout r3 = this.containerView;
        GradientDrawable r5 = new GradientDrawable();
        r5.setShape(0);
        r5.setCornerRadius(r2);
        r5.setColor(0);
        r3.setBackground(r5);
    L22:
        int r6 = this.titleTextAppearance;
        if (r6 == 0) goto L25;
        TextViewCompat.setTextAppearance(this.titleView, r6);
    L25:
        int r7 = this.descTextAppearance;
        if (r7 == 0) goto L28;
        TextViewCompat.setTextAppearance(this.descriptionView, r7);
    L28:
        applyStyledColors();
        return;
    L17:
        OUIFrameLayout r8 = this.containerView;
        Intrinsics.checkNotNull(r4);
        OMaterialExtBaseKt.materials$default(r8, r4, false, 0, null, 14, null);
    L20:
        if (this.bgColor == 0) goto L22;
        OUIFrameLayout r9 = this.containerView;
        GradientDrawable r10 = new GradientDrawable();
        r10.setCornerRadius(r2);
        r10.setColor(this.bgColor);
        r9.setBackground(r10);
        this.containerView.setOuterNormalColor(this.bgColor);
        goto L22
    L5:
        if (r1 != 2) goto L8;
        r2 = OUnitExtensionKt.vdp(this, 20);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final void applyContainerRadius(int r2) {
        this.containerView.setShadowCornerRadius(r2);
        if (this.containerView.isEnableShadowWidthRadius() == false) goto L6;
        this.containerView.setRadius(r2);
        return;
    }

    private final void applyStyledColors() {
        ColorStateList r0 = this.titleTextColor;
        if (r0 == null) goto L6;
        this.titleView.setTextColor(r0);
    L6:
        ColorStateList r1 = this.descTextColor;
        if (r1 == null) goto L10;
        this.descriptionView.setTextColor(r1);
    L10:
        this.iconView.setImageTintList(this.iconTint);
        ColorStateList r2 = this.closeIconTint;
        if (r2 == null) goto L14;
        this.closeButton.setImageTintList(r2);
    L14:
        Integer r3 = this.actionNeutralTextColor;
        if (r3 == null) goto L18;
        int r4 = r3.intValue();
        this.actionTextButton.setTextColor(r4);
    L18:
        Integer r5 = this.actionPrimaryTextColor;
        if (r5 == null) goto L22;
        int r6 = r5.intValue();
        this.actionTextPrimaryButton.setTextColor(r6);
    L22:
        Integer r7 = this.filledActionTextColor;
        if (r7 == null) goto L26;
        int r8 = r7.intValue();
        this.actionFilledButton.setTextColor(r8);
    L26:
        Integer r9 = this.filledActionBackgroundColor;
        if (r9 == null) goto L31;
        int r10 = r9.intValue();
        this.actionFilledButton.setBackgroundTintList(ColorStateList.valueOf(r10));
        this.actionFilledButton.setOuterNormalColor(r10);
        return;
    }

    private final void updateContent() {
        View r0 = this.customContentView;
        boolean r1 = true;
        if (r0 == null) goto L9;
        if (r0 == null) goto L84;
        ViewExtensionsKt.setVisibility(r0, true);
        return;
    L84:
        return;
    L9:
        if (this.heroDrawable == null) goto L11;
        boolean r2 = true;
    L12:
        ViewExtensionsKt.setVisibility(this.heroContainer, r2);
        if (r2 == false) goto L15;
        this.heroImage.setImageDrawable(this.heroDrawable);
    L17:
        if (r2 == true) goto L19;
    L24:
        if (r2 == false) goto L26;
    L28:
        boolean r3 = false;
    L29:
        ViewExtensionsKt.setVisibility(this.iconContainer, r3);
        if (r3 == false) goto L32;
        this.iconView.setImageDrawable(this.iconDrawable);
    L33:
        View r6 = this.textGroup;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L83;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        ViewGroup.MarginLayoutParams r9 = r8;
        if (r3 == false) goto L38;
        int r10 = OUnitExtensionKt.vdp(this, 12);
    L39:
        r9.setMarginStart(r10);
        r6.setLayoutParams(r8);
        CharSequence r11 = this.titleText;
        if (r11 != null) goto L42;
    L45:
        boolean r12 = true;
    L46:
        boolean r13 = !r12;
        ViewExtensionsKt.setVisibility(this.titleView, r13);
        this.titleView.setText(this.titleText);
        OTextView r14 = this.descriptionView;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L81;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        ViewGroup.MarginLayoutParams r17 = r16;
        if (r13 == false) goto L51;
        int r18 = OUnitExtensionKt.vdp(this, 4);
    L52:
        r17.topMargin = r18;
        r14.setLayoutParams(r16);
        this.descriptionView.setText(this.descriptionText);
        this.descriptionView.setMaxWidth(Math.min(this.maxWidthPx, OWindowConfigController.getFullWindowSize(getContext()).getWidth()));
        CharSequence r19 = this.titleText;
        if (r19 != null) goto L55;
    L58:
        boolean r20 = true;
    L59:
        if (r20 == false) goto L72;
        CharSequence r21 = this.descriptionText;
        if (r21 != null) goto L63;
    L66:
        boolean r22 = true;
    L67:
        if (r22 == false) goto L72;
        L r23 = L.INSTANCE;
        if (r23.isBlocked(8) == true) goto L72;
        r23.getImpl().writeLog(TAG, 8, "Coachmark title and description are empty.", null);
        goto L72
    L63:
        if (StringsKt.isBlank(r21) == true) goto L66;
        r22 = false;
    L72:
        updateActions();
        updateActionTextTopMargin(r3);
        if (this.contentStyle == ContentStyle.PILL) goto L75;
    L77:
        r1 = false;
    L78:
        ViewExtensionsKt.setVisibility(this.closeButton, r1);
        return;
    L75:
        if (this.showCloseIcon == false) goto L77;
    L55:
        if (StringsKt.isBlank(r19) == true) goto L58;
        r20 = false;
        goto L59
    L51:
        r18 = 0;
        goto L52
    L81:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L42:
        if (StringsKt.isBlank(r11) == true) goto L45;
        r12 = false;
        goto L46
    L38:
        r10 = 0;
        goto L39
    L83:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L32:
        this.iconView.setImageDrawable(null);
        goto L33
    L26:
        if (this.iconDrawable == null) goto L28;
        r3 = true;
        goto L29
    L19:
        if (this.iconDrawable == null) goto L24;
        L r24 = L.INSTANCE;
        if (r24.isBlocked(8) == true) goto L24;
        r24.getImpl().writeLog(TAG, 8, "Hero image is set; cmIcon will be ignored.", null);
        goto L24
    L15:
        this.heroImage.setImageDrawable(null);
        goto L17
    L11:
        r2 = false;
        goto L12
    }

    private final boolean detachFromParent(View r7) {
        ViewParent r0 = r7.getParent();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0 != this.contentContainer) goto L9;
        return true;
    L9:
        if ((r0 instanceof ViewGroup) == true) goto L16;
        L r6 = L.INSTANCE;
        if (r6.isBlocked(8) == true) goto L22;
        r6.getImpl().writeLog(TAG, 8, Intrinsics.stringPlus("custom content view has a non-ViewGroup parent: ", r0.getClass().getSimpleName()), null);
        return false;
    L22:
        return false;
    L16:
        L r8 = L.INSTANCE;
        if (r8.isBlocked(8) == true) goto L20;
        r8.getImpl().writeLog(TAG, 8, "custom content view already has a parent; it will be moved into coachmark content container.", null);
    L20:
        ((ViewGroup) r0).removeView(r7);
        return true;
    }

    private final void releaseCustomContentView() {
        View r0 = this.customContentView;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.getParent();
        ViewGroup r2 = this.contentContainer;
        if (r1 != r2) goto L8;
        r2.removeView(r0);
    L8:
        this.customContentView = null;
    }

    private final void updateActionTextTopMargin(boolean r4) {
        View r0 = this.actionTextContainer;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L11;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        ViewGroup.MarginLayoutParams r3 = r2;
        if (r4 == false) goto L7;
        int r5 = OUnitExtensionKt.vdp(this, 8);
    L8:
        r3.topMargin = r5;
        r0.setLayoutParams(r2);
        return;
    L7:
        r5 = OUnitExtensionKt.vdp(this, 12);
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void updateActions() {
        CharSequence r0 = resolveDisplayedActionText();
        boolean r1 = hasPrimaryActionText();
        boolean r2 = hasSecondaryActionText();
        boolean r3 = hasDualTextActions();
        ViewExtensionsKt.setVisibility(this.actionTextContainer, false);
        ViewExtensionsKt.setVisibility(this.actionTextButton, false);
        ViewExtensionsKt.setVisibility(this.actionTextPrimaryButton, false);
        ViewExtensionsKt.setVisibility(this.actionFilledButton, false);
        this.actionTextButton.setOnClickListener(null);
        this.actionTextPrimaryButton.setOnClickListener(null);
        this.actionFilledButton.setOnClickListener(null);
        if (this.primaryActionClickListener == null) goto L10;
        if (r1 == true) goto L10;
        L r4 = L.INSTANCE;
        if (r4.isBlocked(8) == true) goto L10;
        r4.getImpl().writeLog(TAG, 8, "Primary action listener is set without primary action text.", null);
    L10:
        if (this.secondaryActionClickListener == null) goto L16;
        if (r2 == true) goto L16;
        L r5 = L.INSTANCE;
        if (r5.isBlocked(8) == true) goto L16;
        r5.getImpl().writeLog(TAG, 8, "Secondary action listener is set without secondary action text.", null);
    L16:
        if (r2 == false) goto L22;
        if (r1 == true) goto L22;
        L r6 = L.INSTANCE;
        if (r6.isBlocked(8) == true) goto L22;
        r6.getImpl().writeLog(TAG, 8, "Secondary action text is set without primary action text; secondary action will not render by itself.", null);
    L22:
        if (r2 == true) goto L24;
    L29:
        int r7 = WhenMappings.$EnumSwitchMapping$1[this.actionStyle.ordinal()];
        if (r7 != 1) goto L32;
        if (r3 == false) goto L51;
        ViewExtensionsKt.setVisibility(this.actionTextContainer, true);
        ViewExtensionsKt.setVisibility(this.actionTextButton, true);
        ViewExtensionsKt.setVisibility(this.actionTextPrimaryButton, true);
        this.actionTextButton.setText(this.secondaryActionText);
        this.actionTextPrimaryButton.setText(this.primaryActionText);
        this.actionTextButton.setOnClickListener(this.secondaryActionClickListener);
        this.actionTextPrimaryButton.setOnClickListener(this.primaryActionClickListener);
        return;
    L51:
        if (r0 != null) goto L57;
        L r8 = L.INSTANCE;
        if (r8.isBlocked(8) == true) goto L60;
        r8.getImpl().writeLog(TAG, 8, "ActionStyle " + access$getActionStyle$p(this) + " is set without action text.", null);
        return;
    L60:
        return;
    L57:
        ViewExtensionsKt.setVisibility(this.actionTextContainer, true);
        ViewExtensionsKt.setVisibility(this.actionTextButton, true);
        this.actionTextButton.setText(r0);
        updateDisplayedActionClickListener();
        return;
    L32:
        if (r7 != 2) goto L34;
        if (r0 != null) goto L47;
        L r9 = L.INSTANCE;
        if (r9.isBlocked(8) == true) goto L59;
        r9.getImpl().writeLog(TAG, 8, "ActionStyle " + access$getActionStyle$p(this) + " is set without action text.", null);
        return;
    L59:
        return;
    L47:
        ViewExtensionsKt.setVisibility(this.actionFilledButton, true);
        this.actionFilledButton.setText(r0);
        updateDisplayedActionClickListener();
        return;
    L34:
        if (r7 != 3) goto L64;
        if (r0 == null) goto L61;
        L r10 = L.INSTANCE;
        if (r10.isBlocked(8) == true) goto L65;
        r10.getImpl().writeLog(TAG, 8, "action text is set while ActionStyle.NONE; action will stay hidden.", null);
        return;
    L65:
        return;
    L61:
        return;
    L64:
        return;
    L24:
        if (this.actionStyle != ActionStyle.FILLED_BUTTON) goto L29;
        L r11 = L.INSTANCE;
        if (r11.isBlocked(8) == true) goto L29;
        r11.getImpl().writeLog(TAG, 8, "Secondary action text is set with FILLED_BUTTON; filled coachmark renders only the primary action.", null);
        goto L29
    }

    private final void updateDisplayedActionClickListener() {
        if (hasDualTextActions() == false) goto L6;
        this.actionTextButton.setOnClickListener(this.secondaryActionClickListener);
        this.actionTextPrimaryButton.setOnClickListener(this.primaryActionClickListener);
        return;
    L6:
        View.OnClickListener r0 = resolveDisplayedActionClickListener();
        this.actionTextButton.setOnClickListener(r0);
        this.actionTextPrimaryButton.setOnClickListener(null);
        this.actionFilledButton.setOnClickListener(r0);
    }

    private final boolean hasPrimaryActionText() {
        CharSequence r1 = this.primaryActionText;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final boolean hasSecondaryActionText() {
        CharSequence r1 = this.secondaryActionText;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final boolean hasDualTextActions() {
        if (this.actionStyle == ActionStyle.TEXT_ONLY) goto L5;
    L9:
        return false;
    L5:
        if (hasPrimaryActionText() == false) goto L9;
        if (hasSecondaryActionText() == false) goto L9;
        return true;
    }

    private final CharSequence resolveDisplayedActionText() {
        if (hasPrimaryActionText() == true) goto L7;
        return null;
    L7:
        return this.primaryActionText;
    }

    private final View.OnClickListener resolveDisplayedActionClickListener() {
        if (hasPrimaryActionText() == true) goto L7;
        return null;
    L7:
        return this.primaryActionClickListener;
    }

    private final boolean hasVisibleActions() {
        if (this.actionStyle != ActionStyle.NONE) goto L5;
    L7:
        return false;
    L5:
        if (resolveDisplayedActionText() == null) goto L7;
        return true;
    }

    private final void updateArrowPosition() {
        if (this.arrowPosition != ArrowPosition.TOP) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (this.showArrow == true) goto L12;
        int r2 = 0;
    L16:
        OUIFrameLayout r5 = this.containerView;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L99;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        FrameLayout.LayoutParams r8 = r7;
        r8.topMargin = 0;
        r8.bottomMargin = 0;
        r8.setMarginStart(0);
        r8.setMarginEnd(0);
        int r9 = WhenMappings.$EnumSwitchMapping$2[this.arrowPosition.ordinal()];
        int r11 = 8388627;
        if (r9 == 1) goto L28;
        if (r9 == 2) goto L27;
        if (r9 == 3) goto L26;
        if (r9 != 4) goto L25;
        int r10 = 8388629;
    L29:
        r8.gravity = r10;
        int r12 = WhenMappings.$EnumSwitchMapping$2[this.arrowPosition.ordinal()];
        if (r12 == 1) goto L38;
        if (r12 == 2) goto L37;
        if (r12 == 3) goto L36;
        if (r12 != 4) goto L39;
        r8.setMarginEnd(r2);
    L39:
        r5.setLayoutParams(r7);
        if (r1 == false) goto L42;
        int r3 = R.drawable.oui_coachmark_arrow;
    L43:
        OCoachmarkView r13 = this;
        if (r1 == false) goto L46;
        int r14 = OUnitExtensionKt.vdp(r13, 20);
    L47:
        if (r1 == false) goto L49;
        int r15 = OUnitExtensionKt.vdp(this, 9);
    L50:
        ImageView r16 = this.arrowView;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L97;
        FrameLayout.LayoutParams r18 = (FrameLayout.LayoutParams) r17;
        FrameLayout.LayoutParams r19 = r18;
        r19.width = r14;
        r19.height = r15;
        int r20 = WhenMappings.$EnumSwitchMapping$2[this.arrowPosition.ordinal()];
        if (r20 == 1) goto L61;
        if (r20 == 2) goto L60;
        if (r20 == 3) goto L62;
        if (r20 != 4) goto L59;
        r11 = 8388629;
        goto L62
    L59:
        throw new NoWhenBranchMatchedException();
    L62:
        r19.gravity = r11;
        r16.setLayoutParams(r18);
        this.arrowView.setImageResource(r3);
        ColorStateList r4 = this.arrowColor;
        if (r4 == null) goto L66;
        this.arrowView.setImageTintList(r4);
    L66:
        ImageView r21 = this.arrowView;
        int r22 = WhenMappings.$EnumSwitchMapping$2[this.arrowPosition.ordinal()];
        float r23 = 0.0f;
        if (r22 == 1) goto L75;
        if (r22 == 2) goto L74;
        if (r22 == 3) goto L75;
        if (r22 == 4) goto L75;
        throw new NoWhenBranchMatchedException();
    L74:
        float r24 = 180.0f;
    L76:
        r21.setRotation(r24);
        ImageView r25 = this.arrowView;
        if (this.arrowPosition != ArrowPosition.RIGHT) goto L79;
        float r26 = -1.0f;
    L80:
        r25.setScaleX(r26);
        this.arrowView.setScaleY(1.0f);
        ImageView r27 = this.arrowView;
        if (r1 == false) goto L83;
        r23 = this.arrowOffsetPx;
    L83:
        r27.setTranslationX(r23);
        this.arrowView.invalidateOutline();
        if (this.enableMaterial == false) goto L100;
        MaterialConfig[] r28 = this.materials;
        if (r28 == null) goto L102;
        MaterialConfig r29 = r28[0];
        OMaterialExtBaseKt.material$default(this.arrowView, r29, false, 0, 6, null);
        this.arrowView.setBackgroundColor(0);
        this.arrowView.setImageDrawable(null);
        StrokeConfig r30 = r29.getStroke();
        if (r30 != null) goto L92;
        return;
    L92:
        if (this.arrowView.getVisibility() != 0) goto L94;
        this.containerView.setBorderWidth(0);
        return;
    L94:
        this.containerView.setBorderWidth(OUnitExtensionKt.vdp(this, r30.getWidth()));
        return;
    L102:
        return;
    L100:
        return;
    L79:
        r26 = 1.0f;
    L75:
        r24 = 0.0f;
        goto L76
    L60:
        r11 = 81;
        goto L62
    L61:
        r11 = 49;
        goto L62
    L97:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L49:
        r15 = OUnitExtensionKt.vdp(this, 20);
        goto L50
    L46:
        r14 = OUnitExtensionKt.vdp(r13, 10);
        goto L47
    L42:
        r3 = R.drawable.oui_coachmark_arrow_left;
        goto L43
    L36:
        r8.setMarginStart(r2);
        goto L39
    L37:
        r8.bottomMargin = r2;
        goto L39
    L38:
        r8.topMargin = r2;
        goto L39
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        r10 = 8388627;
        goto L29
    L27:
        r10 = 81;
        goto L29
    L28:
        r10 = 49;
        goto L29
    L99:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L12:
        if (r1 == false) goto L14;
        r2 = OUnitExtensionKt.vdp(this, 8);
        goto L16
    L14:
        r2 = OUnitExtensionKt.vdp(this, 8);
        goto L16
    L5:
        if (this.arrowPosition == ArrowPosition.BOTTOM) goto L8;
        r1 = false;
        goto L10
    }

    private final void updateContainerPadding() {
        this.contentContainer.setPaddingRelative(this.contentPaddingStartPx, this.contentPaddingTopPx, this.contentPaddingEndPx, this.contentPaddingBottomPx);
    }
}
