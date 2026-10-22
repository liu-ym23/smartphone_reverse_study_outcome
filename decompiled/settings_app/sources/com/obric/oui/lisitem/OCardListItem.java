package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.common.oui.R;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OCardListItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000 ±\u00012\u00020\u0001:\u0002±\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020AH\u0002J\u0006\u0010C\u001a\u00020AJ\u0016\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007J\u0006\u0010G\u001a\u00020\u0001J\u0006\u0010H\u001a\u00020\u0007J\u0006\u0010I\u001a\u00020\u0001J\u0006\u0010J\u001a\u00020\u0007J\u0006\u0010K\u001a\u00020\u0015J\u0006\u0010L\u001a\u00020\u0011J\b\u0010M\u001a\u0004\u0018\u00010(J\b\u0010N\u001a\u0004\u0018\u00010(J\u0010\u0010O\u001a\u0004\u0018\u0001062\u0006\u0010P\u001a\u00020\u0007J\u0010\u0010Q\u001a\u0004\u0018\u0001062\u0006\u0010P\u001a\u00020\u0007J\u0010\u0010R\u001a\u0004\u0018\u00010(2\u0006\u0010P\u001a\u00020\u0007J\b\u0010S\u001a\u0004\u0018\u00010TJ\b\u0010U\u001a\u0004\u0018\u000106J\b\u0010V\u001a\u0004\u0018\u00010WJ\b\u0010X\u001a\u0004\u0018\u00010YJ\u0006\u0010Z\u001a\u00020,J\u0006\u0010[\u001a\u00020*J\b\u0010\\\u001a\u0004\u0018\u00010TJ\b\u0010]\u001a\u0004\u0018\u00010^J\u0006\u0010_\u001a\u000206J\u0006\u0010`\u001a\u00020:J\b\u0010a\u001a\u0004\u0018\u00010(J\u0006\u0010b\u001a\u00020,J\b\u0010c\u001a\u0004\u0018\u00010^J\u0006\u0010d\u001a\u00020?J\u0006\u0010e\u001a\u000206J\b\u0010f\u001a\u00020AH\u0014J\u0012\u0010g\u001a\u00020A2\b\u0010h\u001a\u0004\u0018\u00010iH\u0014J\b\u0010j\u001a\u00020AH\u0014J\u0010\u0010k\u001a\u00020A2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010l\u001a\u00020A2\u0006\u0010m\u001a\u00020(2\u0006\u0010n\u001a\u00020*H\u0002J\b\u0010o\u001a\u00020AH\u0002J\b\u0010p\u001a\u00020AH\u0002J\b\u0010q\u001a\u00020AH\u0002J\b\u0010r\u001a\u00020AH\u0002J\b\u0010s\u001a\u00020AH\u0002J\u0006\u0010t\u001a\u00020AJ\u0010\u0010u\u001a\u00020A2\b\u0010v\u001a\u0004\u0018\u00010wJ\u000e\u0010u\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J\u000e\u0010y\u001a\u00020A2\u0006\u0010z\u001a\u00020\u0007J\u001a\u0010{\u001a\u00020A2\u0006\u0010|\u001a\u00020\u00072\b\b\u0002\u0010}\u001a\u00020*H\u0007J\u000e\u0010~\u001a\u00020A2\u0006\u0010\u007f\u001a\u00020\u0007J\u0010\u0010\u0080\u0001\u001a\u00020A2\u0007\u0010\u0081\u0001\u001a\u00020*J\u000f\u0010\u0082\u0001\u001a\u00020A2\u0006\u0010z\u001a\u00020\u0015J\u000f\u0010\u0082\u0001\u001a\u00020A2\u0006\u0010z\u001a\u00020\u0007J\u0011\u0010\u0083\u0001\u001a\u00020A2\b\u0010z\u001a\u0004\u0018\u00010\u0015J\u0011\u0010\u0084\u0001\u001a\u00020A2\b\u0010m\u001a\u0004\u0018\u00010(J\u000f\u0010\u0084\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J\u0011\u0010\u0085\u0001\u001a\u00020A2\b\u0010m\u001a\u0004\u0018\u00010(J\u000f\u0010\u0085\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J&\u0010\u0086\u0001\u001a\u00020A2\b\u0010m\u001a\u0004\u0018\u00010(2\u0006\u0010P\u001a\u00020\u00072\t\b\u0002\u0010\u0087\u0001\u001a\u00020*H\u0007J$\u0010\u0086\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\t\b\u0002\u0010\u0087\u0001\u001a\u00020*H\u0007J\u0010\u0010\u0088\u0001\u001a\u00020A2\u0007\u0010\u0089\u0001\u001a\u00020\u0007J\u0010\u0010\u008a\u0001\u001a\u00020A2\u0007\u0010\u008b\u0001\u001a\u00020\u0007J%\u0010\u008c\u0001\u001a\u00020A2\u0007\u0010\u008d\u0001\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\t\b\u0002\u0010\u0087\u0001\u001a\u00020*H\u0007J\u0010\u0010\u008e\u0001\u001a\u00020A2\u0007\u0010\u008f\u0001\u001a\u00020\u0007J\u0010\u0010\u0090\u0001\u001a\u00020A2\u0007\u0010\u0091\u0001\u001a\u00020*J\u0010\u0010\u0092\u0001\u001a\u00020A2\u0007\u0010\u0091\u0001\u001a\u00020*J\u0011\u0010\u0093\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020*H\u0016J\u001f\u0010\u0094\u0001\u001a\u00020A2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010^2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u0007H\u0007J\u0011\u0010\u0097\u0001\u001a\u00020A2\b\u0010v\u001a\u0004\u0018\u00010wJ\u000f\u0010\u0097\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J\u0013\u0010\u0098\u0001\u001a\u00020A2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001J\u0013\u0010\u009b\u0001\u001a\u00020A2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009c\u0001J\u0010\u0010\u009d\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0012\u0010\u009f\u0001\u001a\u00020A2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010^J\u0011\u0010 \u0001\u001a\u00020A2\b\u0010m\u001a\u0004\u0018\u00010(J\u000f\u0010 \u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J\u0011\u0010¡\u0001\u001a\u00020A2\b\u0010v\u001a\u0004\u0018\u00010wJ\u000f\u0010¡\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J\u0012\u0010¢\u0001\u001a\u00020A2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010^J\u0019\u0010£\u0001\u001a\u00020A2\u0007\u0010¤\u0001\u001a\u00020\u00072\u0007\u0010¥\u0001\u001a\u00020\u0007J\u0010\u0010¦\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010§\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010¨\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010©\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010ª\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010«\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010¬\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0007\u0010\u00ad\u0001\u001a\u00020AJ\u0007\u0010®\u0001\u001a\u00020AJ\u0007\u0010¯\u0001\u001a\u00020AJ\t\u0010°\u0001\u001a\u00020AH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010.\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006²\u0001"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appIcon", "Lcom/obric/oui/image/OImageAppIcon;", "bgColor", "cardContainer", "Lcom/obric/oui/layout/OUIFrameLayout;", "cardListItemPositionHelper", "Lcom/obric/oui/lisitem/OCardListItemPositionHelper;", "contentContainer", "Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "contentContainerBg", "Lcom/obric/oui/common/style/OStateGradientDrawable;", "value", "Landroid/content/res/ColorStateList;", "contentContainerBgColor", "getContentContainerBgColor", "()Landroid/content/res/ColorStateList;", "setContentContainerBgColor", "(Landroid/content/res/ColorStateList;)V", "contentDefaultContainerBgColor", "contentMarkContainerBgColor", "currentPosition", "currentSwipeOffset", "currentType", "customDividerEnd", "customDividerStart", "customEndContainer", "customStartContainer", "customStartLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "customTitleMode", "divider", "Landroid/view/View;", "enableSwipeDivider", "", "icon", "Landroid/widget/ImageView;", "iconContainer", "isMark", "()Z", "setMark", "(Z)V", "maxTailTextWidth", "root", "showCardBg", "subTitle", "Lcom/obric/oui/text/OTextView;", "subTitleColor", "swipeContainer", "swipeLayout", "Lcom/obric/oui/swipeaction/OSwipeLayout;", "tailIcon", "title", "titleColor", "titleContainer", "Landroid/widget/LinearLayout;", "addAppIconIfNotExist", "", "checkContentContainerListenerForBackground", "clearCustomTitleView", "customDivider", "start", TraceStatsConsts.STATS_KEY_END, "getCardContainer", "getCardPosition", "getCardRoot", "getCardType", "getContentColor", "getContentContainer", "getCustomEndView", "getCustomStartView", "getCustomTitleDetail", "index", "getCustomTitleText", "getCustomTitleView", "getEndCheckBox", "Lcom/obric/oui/checkbox/OCheckBoxLayout;", "getEndDetail", "getEndMark", "Lcom/obric/oui/checkbox/OCheckMark;", "getEndSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "getIconView", "getShowCardBg", "getStartCheckBox", "getSubTitle", "", "getSubTitleView", "getSwipeLayout", "getSwipeView", "getTailIconView", "getTitle", "getTitleContainer", "getTitleView", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "parseAttributes", "recursiveSetEnabled", "view", IndexDatabaseHelper.IndexColumns.ENABLED, "resetContentContainerBackground", "resetContentContainerCorner", "resetCustomEndDetail", "resetIconCorner", "resetTitlePadding", "revertContentColor", "setAppIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "setBgColor", "color", "setCardPosition", "position", "animate", "setCardType", "type", "setContentChecked", "checked", "setContentColor", "setContentMarkColor", "setCustomEndView", "setCustomStartView", "setCustomTitleView", "matchParent", "setDefaultCustomEndView", "defaultCustomEnd", "setDefaultCustomStartView", "defaultCustomStart", "setDefaultCustomTitleView", "defaultCustomTitle", "setDefaultTailIcon", "defaultTailIcon", "setEnableSwipe", "enable", "setEnableSwipeDivider", "setEnabled", "setEndDetailText", "text", "maxWidth", "setIcon", "setOnContentClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnContentLongClickListener", "Landroid/view/View$OnLongClickListener;", "setShowCardBg", "show", "setSubTitle", "setSwipeView", "setTailIcon", "setTitle", "setTitleColor", "titleC", "subTitleC", "showCustomEnd", "showCustomStart", "showDivider", "showIcon", "showSubTitle", "showTailIcon", "showTitle", "swipeClose", "swipeOpen", "swipeToggle", "updateDividerPosition", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCardListItem extends FrameLayout {
    public static final int CUSTOM_END_CHECKBOX = 0;
    public static final int CUSTOM_END_DETAIL = 3;
    public static final int CUSTOM_END_HANDLE = 4;
    public static final int CUSTOM_END_MARK = 2;
    public static final int CUSTOM_END_SWITCH = 1;
    public static final int CUSTOM_START_CHECKBOX = 0;
    public static final int CUSTOM_TITLE_DETAIL = 1;
    public static final int CUSTOM_TITLE_ICON = 0;
    public static final int CUSTOM_TITLE_NONE = -1;
    public static final Companion Companion = null;
    public static final int DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP = 168;
    public static final int POSITION_BOTTOM = 3;
    public static final int POSITION_MIDDLE = 2;
    public static final int POSITION_SINGLE = 0;
    public static final int POSITION_TOP = 1;
    public static final int TAIL_ICON_ARROW = 0;
    public static final int TAIL_ICON_CHEVRON = 1;
    public static final int TYPE_CONTAINER = 2;
    public static final int TYPE_LARGE = 1;
    public static final int TYPE_NORMAL = 0;
    private OImageAppIcon appIcon;
    private int bgColor;
    private final OUIFrameLayout cardContainer;
    private final OCardListItemPositionHelper cardListItemPositionHelper;
    private final OUICardConstraintLayout contentContainer;
    private OStateGradientDrawable contentContainerBg;
    private ColorStateList contentContainerBgColor;
    private ColorStateList contentDefaultContainerBgColor;
    private ColorStateList contentMarkContainerBgColor;
    private int currentPosition;
    private int currentSwipeOffset;
    private int currentType;
    private int customDividerEnd;
    private int customDividerStart;
    private final FrameLayout customEndContainer;
    private final FrameLayout customStartContainer;
    private View.OnLayoutChangeListener customStartLayoutChangeListener;
    private int customTitleMode;
    private final View divider;
    private boolean enableSwipeDivider;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private boolean isMark;
    private int maxTailTextWidth;
    private final FrameLayout root;
    private boolean showCardBg;
    private final OTextView subTitle;
    private int subTitleColor;
    private FrameLayout swipeContainer;
    private OSwipeLayout swipeLayout;
    private final ImageView tailIcon;
    private final OTextView title;
    private int titleColor;
    private final LinearLayout titleContainer;

    /* JADX INFO: compiled from: OCardListItem.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItem$Companion;", "", "()V", "CUSTOM_END_CHECKBOX", "", "CUSTOM_END_DETAIL", "CUSTOM_END_HANDLE", "CUSTOM_END_MARK", "CUSTOM_END_SWITCH", "CUSTOM_START_CHECKBOX", "CUSTOM_TITLE_DETAIL", "CUSTOM_TITLE_ICON", "CUSTOM_TITLE_NONE", "DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP", "POSITION_BOTTOM", "POSITION_MIDDLE", "POSITION_SINGLE", "POSITION_TOP", "TAIL_ICON_ARROW", "TAIL_ICON_CHEVRON", "TYPE_CONTAINER", "TYPE_LARGE", "TYPE_NORMAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$V3ppt_lP6BfUucBNKZySkjiFCOA(OCardListItem r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        m1236_init_$lambda1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void $r8$lambda$rOgupYxOd7hAmZabgnCvZANBZFs(OCardListItem r0) {
        m1237updateDividerPosition$lambda17(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public OCardListItem(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OCardListItem(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public final void setCardPosition(int r4) {
        setCardPosition$default(this, r4, false, 2, null);
    }

    public final void setCustomTitleView(int r7, int r8) {
        setCustomTitleView$default(this, r7, r8, false, 4, null);
    }

    public final void setCustomTitleView(View r7, int r8) {
        setCustomTitleView$default(this, r7, r8, false, 4, null);
    }

    public final void setDefaultCustomTitleView(int r7, int r8) {
        setDefaultCustomTitleView$default(this, r7, r8, false, 4, null);
    }

    public final void setEndDetailText(CharSequence r4) {
        setEndDetailText$default(this, r4, 0, 2, null);
    }

    public /* synthetic */ OCardListItem(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ int access$getCurrentType$p(OCardListItem r0) {
        return r0.currentType;
    }

    public static final /* synthetic */ View access$getDivider$p(OCardListItem r0) {
        return r0.divider;
    }

    public static final /* synthetic */ boolean access$getEnableSwipeDivider$p(OCardListItem r0) {
        return r0.enableSwipeDivider;
    }

    public static final /* synthetic */ void access$setCurrentSwipeOffset$p(OCardListItem r0, int r1) {
        r0.currentSwipeOffset = r1;
    }

    public OCardListItem(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.showCardBg = true;
        this.bgColor = getResources().getColor(R.color.oui_fill_list_item_card);
        this.contentContainerBg = new OStateGradientDrawable();
        ColorStateList r0 = getResources().getColorStateList(R.color.o_card_list_item_content_bg_color);
        Intrinsics.checkNotNullExpressionValue(r0, "resources.getColorStateL…st_item_content_bg_color)");
        this.contentDefaultContainerBgColor = r0;
        this.titleColor = getResources().getColor(R.color.oui_basic_text_1);
        this.subTitleColor = getResources().getColor(R.color.oui_basic_text_3);
        this.customDividerStart = -1;
        this.customDividerEnd = -1;
        this.enableSwipeDivider = true;
        this.customTitleMode = -1;
        this.contentContainerBgColor = this.contentDefaultContainerBgColor;
        this.maxTailTextWidth = OUnitExtensionKt.vdp(this, 168);
        setClipChildren(false);
        setClipToPadding(false);
        if (getLayoutParams() != null) goto L5;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    L5:
        View r8 = LayoutInflater.from(r5).inflate(R.layout.o_card_list_item_layout, this, true);
        if (r8 == null) goto L14;
        FrameLayout r9 = (FrameLayout) r8;
        View r10 = findViewById(R.id.card_list_item_root);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.card_list_item_root)");
        FrameLayout r11 = (FrameLayout) r10;
        this.root = r11;
        r11.setClickable(true);
        View r12 = findViewById(R.id.card_container);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.card_container)");
        OUIFrameLayout r13 = (OUIFrameLayout) r12;
        this.cardContainer = r13;
        r13.setChangeAlphaWhenPress(false);
        r13.setChangeAlphaWhenDisable(false);
        View r1 = findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.content_container)");
        OUICardConstraintLayout r2 = (OUICardConstraintLayout) r1;
        this.contentContainer = r2;
        r2.setChangeAlphaWhenPress(false);
        r2.setChangeAlphaWhenDisable(true);
        View r14 = findViewById(R.id.custom_start_container);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.custom_start_container)");
        this.customStartContainer = (FrameLayout) r14;
        View r15 = findViewById(R.id.icon_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.icon_container)");
        this.iconContainer = (FrameLayout) r15;
        View r16 = findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.icon)");
        this.icon = (ImageView) r16;
        View r17 = findViewById(R.id.title_container);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.title_container)");
        this.titleContainer = (LinearLayout) r17;
        View r18 = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.title)");
        this.title = (OTextView) r18;
        View r19 = findViewById(R.id.sub_title);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.sub_title)");
        this.subTitle = (OTextView) r19;
        View r20 = findViewById(R.id.custom_end_container);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.custom_end_container)");
        this.customEndContainer = (FrameLayout) r20;
        View r21 = findViewById(R.id.tail_icon);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.tail_icon)");
        this.tailIcon = (ImageView) r21;
        View r22 = findViewById(R.id.card_divider);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.card_divider)");
        this.divider = r22;
        this.customStartLayoutChangeListener = new OCardListItem$$ExternalSyntheticLambda0(this);
        View r23 = findViewById(R.id.swipe_layout);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.swipe_layout)");
        OSwipeLayout r24 = (OSwipeLayout) r23;
        this.swipeLayout = r24;
        r24.setChangeAlphaWhenPress(false);
        this.swipeLayout.setChangeAlphaWhenDisable(false);
        this.swipeLayout.setSwipeEnabled(false);
        this.swipeLayout.addSwipeListener(new AnonymousClass2(this));
        View r25 = findViewById(R.id.swip_container);
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.swip_container)");
        this.swipeContainer = (FrameLayout) r25;
        if (r6 == null) goto L11;
        parseAttributes(r6);
    L11:
        resetContentContainerCorner();
        setCardType(this.currentType);
        setTitleColor(this.titleColor, this.subTitleColor);
        this.cardListItemPositionHelper = new OCardListItemPositionHelper(r13, this.showCardBg, this.bgColor, this.currentPosition);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final ColorStateList getContentContainerBgColor() {
        return this.contentContainerBgColor;
    }

    public final void setContentContainerBgColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (Intrinsics.areEqual(this.contentContainerBgColor, r2) == true) goto L9;
        this.contentContainerBgColor = r2;
        OStateGradientDrawable r1 = this.contentContainerBg;
        if (r1 == null) goto L10;
        r1.setSolidColors(r2);
        return;
    L10:
        return;
    }

    public final boolean isMark() {
        return this.isMark;
    }

    public final void setMark(boolean r2) {
        if (this.isMark == r2) goto L12;
        this.isMark = r2;
        if (r2 == false) goto L10;
        ColorStateList r3 = this.contentMarkContainerBgColor;
        if (r3 == null) goto L14;
        setContentContainerBgColor(r3);
        return;
    L14:
        return;
    L10:
        setContentContainerBgColor(this.contentDefaultContainerBgColor);
        return;
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final void m1236_init_$lambda1(OCardListItem r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.divider.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L9;
        r0.updateDividerPosition();
        return;
    L9:
        return;
    L5:
        r10 = false;
        goto L6
    }

    private final void parseAttributes(AttributeSet r9) {
        TypedArray r10 = getContext().obtainStyledAttributes(r9, R.styleable.OCardListItemContainer);
        Intrinsics.checkNotNullExpressionValue(r10, "context.obtainStyledAttr…e.OCardListItemContainer)");
    L74:
        th = move-exception;
        r10.recycle();
        throw th;
    L4:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_showCardBg) == false) goto L6;
        this.showCardBg = r10.getBoolean(R.styleable.OCardListItemContainer_ocardlistitem_showCardBg, true);     // Catch: Throwable -> L74
    L6:
        this.bgColor = r10.getColor(R.styleable.OCardListItemContainer_ocardlistitem_bgColor, getResources().getColor(R.color.oui_fill_list_item_card));     // Catch: Throwable -> L74
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_contentColorList) == false) goto L13;
        ColorStateList r0 = r10.getColorStateList(R.styleable.OCardListItemContainer_ocardlistitem_contentColorList);     // Catch: Throwable -> L74
        if (r0 != null) goto L11;
        r0 = getResources().getColorStateList(R.color.o_card_list_item_content_bg_color);     // Catch: Throwable -> L74
        Intrinsics.checkNotNullExpressionValue(r0, "resources.getColorStateL…st_item_content_bg_color)");     // Catch: Throwable -> L74
    L11:
        this.contentDefaultContainerBgColor = r0;     // Catch: Throwable -> L74
        setContentContainerBgColor(r0);     // Catch: Throwable -> L74
    L13:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_cardType) == false) goto L16;
        this.currentType = r10.getInt(R.styleable.OCardListItemContainer_ocardlistitem_cardType, 0);     // Catch: Throwable -> L74
    L16:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_cardPosition) == false) goto L19;
        this.currentPosition = r10.getInt(R.styleable.OCardListItemContainer_ocardlistitem_cardPosition, 0);     // Catch: Throwable -> L74
    L19:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_customStart) == false) goto L22;
        setCustomStartView(r10.getResourceId(R.styleable.OCardListItemContainer_ocardlistitem_customStart, 0));     // Catch: Throwable -> L74
    L22:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomStart) == false) goto L25;
        setDefaultCustomStartView(r10.getInt(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomStart, 0));     // Catch: Throwable -> L74
    L25:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_icon) == false) goto L28;
        setIcon(r10.getResourceId(R.styleable.OCardListItemContainer_ocardlistitem_icon, 0));     // Catch: Throwable -> L74
    L28:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_title) == false) goto L30;
        setTitle(r10.getString(R.styleable.OCardListItemContainer_ocardlistitem_title));     // Catch: Throwable -> L74
    L30:
        this.titleColor = r10.getColor(R.styleable.OCardListItemContainer_ocardlistitem_titleColor, getResources().getColor(R.color.oui_basic_text_1));     // Catch: Throwable -> L74
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_subTitle) == false) goto L33;
        setSubTitle(r10.getString(R.styleable.OCardListItemContainer_ocardlistitem_subTitle));     // Catch: Throwable -> L74
    L33:
        this.subTitleColor = r10.getColor(R.styleable.OCardListItemContainer_ocardlistitem_subTitleColor, getResources().getColor(R.color.oui_basic_text_3));     // Catch: Throwable -> L74
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomTitle) == false) goto L37;
        setDefaultCustomTitleView$default(this, r10.getInt(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomTitle, 0), 0, false, 4, null);     // Catch: Throwable -> L74
    L37:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_customEnd) == false) goto L40;
        setCustomEndView(r10.getResourceId(R.styleable.OCardListItemContainer_ocardlistitem_customEnd, 0));     // Catch: Throwable -> L74
    L40:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomEnd) == false) goto L43;
        setDefaultCustomEndView(r10.getInt(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomEnd, 0));     // Catch: Throwable -> L74
    L43:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_endDetailText) == false) goto L46;
        setEndDetailText$default(this, r10.getString(R.styleable.OCardListItemContainer_ocardlistitem_endDetailText), 0, 2, null);     // Catch: Throwable -> L74
    L46:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_tailIcon) == false) goto L49;
        setTailIcon(r10.getResourceId(R.styleable.OCardListItemContainer_ocardlistitem_tailIcon, 0));     // Catch: Throwable -> L74
    L49:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_defaultTailIcon) == false) goto L52;
        setDefaultTailIcon(r10.getInt(R.styleable.OCardListItemContainer_ocardlistitem_defaultTailIcon, 0));     // Catch: Throwable -> L74
    L52:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_showCustomStart) == false) goto L55;
        showCustomStart(r10.getBoolean(R.styleable.OCardListItemContainer_ocardlistitem_showCustomStart, false));     // Catch: Throwable -> L74
    L55:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_showIcon) == false) goto L58;
        showIcon(r10.getBoolean(R.styleable.OCardListItemContainer_ocardlistitem_showIcon, false));     // Catch: Throwable -> L74
    L58:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_showTitle) == false) goto L61;
        showTitle(r10.getBoolean(R.styleable.OCardListItemContainer_ocardlistitem_showTitle, false));     // Catch: Throwable -> L74
    L61:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_showSubTitle) == false) goto L64;
        showSubTitle(r10.getBoolean(R.styleable.OCardListItemContainer_ocardlistitem_showSubTitle, false));     // Catch: Throwable -> L74
    L64:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_showCustomEnd) == false) goto L67;
        showCustomEnd(r10.getBoolean(R.styleable.OCardListItemContainer_ocardlistitem_showCustomEnd, false));     // Catch: Throwable -> L74
    L67:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_showTailIcon) == false) goto L70;
        showTailIcon(r10.getBoolean(R.styleable.OCardListItemContainer_ocardlistitem_showTailIcon, false));     // Catch: Throwable -> L74
    L70:
        if (r10.hasValue(R.styleable.OCardListItemContainer_ocardlistitem_showDivider) == false) goto L72;
        showDivider(r10.getBoolean(R.styleable.OCardListItemContainer_ocardlistitem_showDivider, false));     // Catch: Throwable -> L74
    L72:
        r10.recycle();
    }

    private final void resetContentContainerBackground() {
        if (this.showCardBg == false) goto L5;
        OCardListItem r0 = this;
        int r1 = 12;
    L6:
        int r2 = OUnitExtensionKt.vdp(r0, r1);
        OStateGradientDrawable r3 = this.contentContainerBg;
        if (r3 == null) goto L10;
        r3.setSolidColors(getContentContainerBgColor());
    L10:
        OStateGradientDrawable r4 = this.contentContainerBg;
        if (r4 == null) goto L14;
        r4.setCornerRadius(r2);
    L14:
        checkContentContainerListenerForBackground();
        return;
    L5:
        r0 = this;
        r1 = 20;
        goto L6
    }

    private final void resetContentContainerCorner() {
        resetContentContainerBackground();
        if (this.showCardBg == false) goto L5;
        OCardListItem r0 = this;
        int r1 = 12;
    L6:
        int r2 = OUnitExtensionKt.vdp(r0, r1);
        OSwipeLayout r3 = this.swipeLayout;
        boolean r4 = this.showCardBg;
        boolean r5 = false;
        if (r4 == false) goto L9;
        int r6 = r2;
    L10:
        if (r4 == true) goto L13;
        r2 = 0;
    L13:
        r3.setRadius(r6, 0, r2, 0);
        if (this.divider.getVisibility() != 0) goto L16;
        r5 = true;
    L16:
        if (r5 == false) goto L19;
        updateDividerPosition();
        return;
    L19:
        return;
    L9:
        r6 = 0;
        goto L10
    L5:
        r0 = this;
        r1 = 20;
        goto L6
    }

    private final void checkContentContainerListenerForBackground() {
        if (this.contentContainer.hasOnClickListeners() == false) goto L5;
    L8:
        this.contentContainer.setBackground(this.contentContainerBg);
        return;
    L5:
        if (this.contentContainer.hasOnLongClickListeners() == true) goto L8;
        this.contentContainer.setBackground(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OStateGradientDrawable r0 = this.contentContainerBg;
        if (r0 == null) goto L6;
        r0.endAnimation();
    L6:
        this.customStartContainer.addOnLayoutChangeListener(this.customStartLayoutChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.customStartContainer.removeOnLayoutChangeListener(this.customStartLayoutChangeListener);
    }

    public final void setBgColor(int r1) {
        this.cardListItemPositionHelper.setBgColor(r1);
    }

    public final void setContentColor(int r2) {
        ColorStateList r3 = ColorStateList.valueOf(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "valueOf(color)");
        setContentColor(r3);
    }

    public final void setContentColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "color");
        setContentContainerBgColor(r2);
    }

    public final ColorStateList getContentColor() {
        return getContentContainerBgColor();
    }

    public final void setContentMarkColor(ColorStateList r1) {
        this.contentMarkContainerBgColor = r1;
        if (r1 != null) goto L6;
        setContentContainerBgColor(this.contentDefaultContainerBgColor);
        return;
    }

    public final void setContentChecked(boolean r2) {
        if (r2 == false) goto L9;
        this.contentContainer.setSelected(true);
        if (getContentContainerBgColor().isStateful() == true) goto L11;
        OStateGradientDrawable r3 = this.contentContainerBg;
        if (r3 == null) goto L13;
        r3.setColor(getResources().getColor(R.color.oui_state_overlay_pressed));
        return;
    L13:
        return;
    L11:
        return;
    L9:
        this.contentContainer.setSelected(false);
    }

    public final void revertContentColor() {
        OStateGradientDrawable r0 = this.contentContainerBg;
        if (r0 == null) goto L7;
        r0.setSolidColors(getContentContainerBgColor());
        return;
    }

    public final void setShowCardBg(boolean r1) {
        this.showCardBg = r1;
        resetContentContainerCorner();
        this.cardListItemPositionHelper.setShowCardBg(this.showCardBg);
    }

    public final boolean getShowCardBg() {
        return this.showCardBg;
    }

    public final void setCardType(int r8) {
        this.currentType = r8;
        boolean r3 = true;
        if (r8 == 0) goto L18;
        if (r8 != 1) goto L6;
        OCardListItem r5 = this;
        this.contentContainer.setPaddingRelative(0, 0, OUnitExtensionKt.vdp(r5, 4), 0);
        this.contentContainer.setMinimumHeight(OUnitExtensionKt.vdp(r5, 60));
        this.titleContainer.setVisibility(0);
        FrameLayout r9 = this.customStartContainer;
        ViewGroup.LayoutParams r6 = r9.getLayoutParams();
        if (r6 == null) goto L17;
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        r7.width = -2;
        r9.setLayoutParams(r7);
        FrameLayout r10 = this.iconContainer;
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        r0.width = OUnitExtensionKt.vdp(r5, 60);
        r0.height = OUnitExtensionKt.vdp(r5, 60);
        r10.setLayoutParams(r0);
        this.iconContainer.setPadding(OUnitExtensionKt.vdp(r5, 12), OUnitExtensionKt.vdp(r5, 12), OUnitExtensionKt.vdp(r5, 12), OUnitExtensionKt.vdp(r5, 12));
    L21:
        resetIconCorner();
        if (this.divider.getVisibility() == 0) goto L25;
        r3 = false;
    L25:
        if (r3 == false) goto L30;
        updateDividerPosition();
        return;
    L30:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L6:
        if (r8 != 2) goto L21;
        this.contentContainer.setPaddingRelative(0, 0, 0, 0);
        this.contentContainer.setMinimumHeight(0);
        this.titleContainer.setVisibility(8);
        FrameLayout r11 = this.customStartContainer;
        ViewGroup.LayoutParams r1 = r11.getLayoutParams();
        if (r1 == null) goto L12;
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        r2.width = -1;
        r11.setLayoutParams(r2);
        showCustomStart(true);
        goto L21
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L18:
        OCardListItem r12 = this;
        this.contentContainer.setPaddingRelative(0, 0, OUnitExtensionKt.vdp(r12, 4), 0);
        this.contentContainer.setMinimumHeight(OUnitExtensionKt.vdp(r12, 48));
        this.titleContainer.setVisibility(0);
        FrameLayout r13 = this.customStartContainer;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L29;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        r15.width = -2;
        r13.setLayoutParams(r15);
        FrameLayout r16 = this.iconContainer;
        ViewGroup.LayoutParams r4 = r16.getLayoutParams();
        r4.width = OUnitExtensionKt.vdp(r12, 48);
        r4.height = OUnitExtensionKt.vdp(r12, 48);
        r16.setLayoutParams(r4);
        this.iconContainer.setPadding(OUnitExtensionKt.vdp(r12, 10), OUnitExtensionKt.vdp(r12, 10), OUnitExtensionKt.vdp(r12, 10), OUnitExtensionKt.vdp(r12, 10));
        goto L21
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setTitleColor(int r1, int r2) {
        this.titleColor = r1;
        this.subTitleColor = r2;
        this.title.setTextColor(r1);
        this.subTitle.setTextColor(this.subTitleColor);
    }

    private final void resetIconCorner() {
        this.icon.setClipToOutline(true);
        this.icon.setOutlineProvider(new AnonymousClass1(this));
        this.icon.invalidateOutline();
    }

    public final int getCardType() {
        return this.currentType;
    }

    public static /* synthetic */ void setCardPosition$default(OCardListItem r0, int r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.setCardPosition(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCardPosition");
    }

    public final void setCardPosition(int r1, boolean r2) {
        this.currentPosition = r1;
        this.cardListItemPositionHelper.setCardPosition(r1, r2);
    }

    public final int getCardPosition() {
        return this.currentPosition;
    }

    public final FrameLayout getCardRoot() {
        return this.root;
    }

    public final FrameLayout getCardContainer() {
        return this.cardContainer;
    }

    public final OUICardConstraintLayout getContentContainer() {
        return this.contentContainer;
    }

    public final void setCustomStartView(View r2) {
        this.customStartContainer.removeAllViews();
        if (r2 == null) goto L6;
        this.customStartContainer.addView(r2);
    L6:
        if (this.divider.getVisibility() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        updateDividerPosition();
        return;
    L12:
        return;
    L8:
        r3 = false;
        goto L9
    }

    public final void setCustomStartView(int r3) {
        this.customStartContainer.removeAllViews();
        if (r3 == 0) goto L6;
        FrameLayout.inflate(getContext(), r3, this.customStartContainer);     // Catch: Exception -> L12
    L6:
        if (this.divider.getVisibility() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L15;
        updateDividerPosition();
        return;
    L15:
        return;
    L8:
        r4 = false;
        goto L9
    }

    public final void setDefaultCustomStartView(int r2) {
        this.customStartContainer.removeAllViews();
        if (r2 != 0) goto L6;
        setCustomStartView(R.layout.o_card_list_item_custom_start_checkbox);
    L6:
        if (this.divider.getVisibility() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        updateDividerPosition();
        return;
    L12:
        return;
    L8:
        r3 = false;
        goto L9
    }

    public final View getCustomStartView() {
        if (this.customStartContainer.getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return null;
    L8:
        return this.customStartContainer.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final OCheckBoxLayout getStartCheckBox() {
        if ((getCustomStartView() instanceof OCheckBoxLayout) == false) goto L10;
        View r1 = getCustomStartView();
        if (r1 == null) goto L9;
        return (OCheckBoxLayout) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    public final void showCustomStart(boolean r2) {
        FrameLayout r0 = this.customStartContainer;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        resetTitlePadding();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setIcon(Drawable r4) {
        boolean r1 = false;
        this.icon.setVisibility(0);
        OImageAppIcon r0 = this.appIcon;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (r4 == null) goto L8;
        this.icon.setImageDrawable(r4);
    L10:
        if (this.divider.getVisibility() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L15;
        updateDividerPosition();
        return;
    L15:
        return;
    L8:
        this.icon.setImageDrawable(null);
        goto L10
    }

    public final void setIcon(int r4) {
        boolean r1 = false;
        this.icon.setVisibility(0);
        OImageAppIcon r0 = this.appIcon;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (r4 == 0) goto L8;
        this.icon.setImageResource(r4);
    L10:
        if (this.divider.getVisibility() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L15;
        updateDividerPosition();
        return;
    L15:
        return;
    L8:
        this.icon.setImageDrawable(null);
        goto L10
    }

    public final void setAppIcon(Drawable r3) {
        this.icon.setVisibility(8);
        addAppIconIfNotExist();
        if (r3 == null) goto L8;
        OImageAppIcon r0 = this.appIcon;
        if (r0 == null) goto L13;
        r0.setImageDrawable(r3);
    L13:
        if (this.divider.getVisibility() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        updateDividerPosition();
        return;
    L19:
        return;
    L15:
        r4 = false;
        goto L16
    L8:
        OImageAppIcon r5 = this.appIcon;
        if (r5 == null) goto L13;
        r5.setImageDrawable(null);
        goto L13
    }

    public final void setAppIcon(int r3) {
        this.icon.setVisibility(8);
        addAppIconIfNotExist();
        if (r3 == 0) goto L8;
        OImageAppIcon r0 = this.appIcon;
        if (r0 == null) goto L13;
        r0.setImageResource(r3);
    L13:
        if (this.divider.getVisibility() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        updateDividerPosition();
        return;
    L19:
        return;
    L15:
        r4 = false;
        goto L16
    L8:
        OImageAppIcon r5 = this.appIcon;
        if (r5 == null) goto L13;
        r5.setImageDrawable(null);
        goto L13
    }

    private final void addAppIconIfNotExist() {
        OImageAppIcon r0 = (OImageAppIcon) this.iconContainer.findViewById(R.id.o_list_item_app_icon);
        this.appIcon = r0;
        if (r0 != null) goto L5;
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        OImageAppIcon r1 = new OImageAppIcon(r2, null, 0, 6, null);
        r1.setId(R.id.o_list_item_app_icon);
        r1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.appIcon = r1;
        this.iconContainer.addView(r1);
        return;
    L5:
        if (r0 == null) goto L10;
        r0.setVisibility(0);
        return;
    }

    public final ImageView getIconView() {
        return this.icon;
    }

    public final void showIcon(boolean r2) {
        FrameLayout r0 = this.iconContainer;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        resetTitlePadding();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setTitle(CharSequence r1) {
        this.title.setText(r1);
    }

    public final CharSequence getTitle() {
        return this.title.getText();
    }

    public final OTextView getTitleView() {
        return this.title;
    }

    public final void showTitle(boolean r4) {
        CharSequence r0 = getTitle();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L16;
        OTextView r3 = this.title;
        if (r4 == true) goto L15;
        r1 = 8;
    L15:
        r3.setVisibility(r1);
        return;
    L16:
        this.title.setVisibility(8);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    private final void resetTitlePadding() {
        boolean r1 = true;
        if (this.customStartContainer.getVisibility() != 8) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        if ((getCustomStartView() instanceof OCheckBoxLayout) == true) goto L10;
    L15:
        LinearLayout r2 = this.titleContainer;
        r2.setPadding(0, r2.getPaddingTop(), this.titleContainer.getPaddingRight(), this.titleContainer.getPaddingBottom());
    L17:
        if (this.divider.getVisibility() == 0) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L22;
        updateDividerPosition();
    L22:
        requestLayout();
        return;
    L10:
        if (this.iconContainer.getVisibility() != 8) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        this.titleContainer.setPadding(OUnitExtensionKt.vdp(this, 12), this.titleContainer.getPaddingTop(), this.titleContainer.getPaddingRight(), this.titleContainer.getPaddingBottom());
        goto L17
    L12:
        r3 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public final void setSubTitle(CharSequence r1) {
        this.subTitle.setText(r1);
    }

    public final CharSequence getSubTitle() {
        return this.subTitle.getText();
    }

    public final OTextView getSubTitleView() {
        return this.subTitle;
    }

    public final void showSubTitle(boolean r4) {
        CharSequence r0 = getSubTitle();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L16;
        OTextView r3 = this.subTitle;
        if (r4 == true) goto L15;
        r1 = 8;
    L15:
        r3.setVisibility(r1);
        return;
    L16:
        this.subTitle.setVisibility(8);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public final LinearLayout getTitleContainer() {
        return this.titleContainer;
    }

    public static /* synthetic */ void setCustomTitleView$default(OCardListItem r0, View r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        r0.setCustomTitleView(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomTitleView");
    }

    public final void setCustomTitleView(View r1, int r2, boolean r3) {
        if (r1 == null) goto L5;
        this.titleContainer.addView(r1, r2);
        return;
    }

    public static /* synthetic */ void setCustomTitleView$default(OCardListItem r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        r0.setCustomTitleView(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomTitleView");
    }

    public final void setCustomTitleView(int r10, int r11, boolean r12) {
        if (r10 != 0) goto L22;
        return;
    L22:
        int r2 = 0;
        setCustomTitleView$default(this, LayoutInflater.from(getContext()).inflate(r10, this.titleContainer, false), r11, false, 4, null);     // Catch: Exception -> L21
        LinearLayout r9 = this.titleContainer;     // Catch: Exception -> L21
        ViewGroup.LayoutParams r13 = r9.getLayoutParams();     // Catch: Exception -> L21
        if (r13 == null) goto L19;
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13;     // Catch: Exception -> L21
        if (r12 == false) goto L8;
        int r15 = 0;
    L9:
        r14.width = r15;     // Catch: Exception -> L21
        if (r12 == true) goto L12;
        boolean r0 = true;
    L13:
        r14.constrainedWidth = r0;     // Catch: Exception -> L21
        if (r12 == true) goto L17;
        r2 = 1;
    L17:
        r14.matchConstraintDefaultWidth = r2;     // Catch: Exception -> L21
        r9.setLayoutParams(r14);     // Catch: Exception -> L21
        return;
    L12:
        r0 = false;
        goto L13
    L8:
        r15 = -2;
        goto L9
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");     // Catch: Exception -> L21
    }

    public static /* synthetic */ void setDefaultCustomTitleView$default(OCardListItem r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 4) == 0) goto L9;
        r3 = true;
        if (r1 == 1) goto L9;
        r3 = false;
    L9:
        r0.setDefaultCustomTitleView(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDefaultCustomTitleView");
    }

    public final void setDefaultCustomTitleView(int r5, int r6, boolean r7) {
        int r0 = this.customTitleMode;
        if (r0 != r5) goto L16;
        if (r0 != 1) goto L10;
        LinearLayout r4 = this.titleContainer;
        ViewGroup.LayoutParams r8 = r4.getLayoutParams();
        if (r8 == null) goto L9;
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) r8;
        r9.width = 0;
        r9.constrainedWidth = false;
        r9.matchConstraintDefaultWidth = 0;
        r4.setLayoutParams(r9);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L10:
        LinearLayout r10 = this.titleContainer;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L15;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        r12.width = -2;
        r12.constrainedWidth = true;
        r12.matchConstraintDefaultWidth = 1;
        r10.setLayoutParams(r12);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L16:
        if (r0 < 0) goto L19;
        if (r0 == r5) goto L19;
        clearCustomTitleView();
    L19:
        this.customTitleMode = r5;
        if (r5 == 0) goto L28;
        if (r5 == 1) goto L27;
        this.customTitleMode = -1;
        clearCustomTitleView();
        LinearLayout r13 = this.titleContainer;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L26;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        r15.width = -2;
        r15.constrainedWidth = true;
        r15.matchConstraintDefaultWidth = 1;
        r13.setLayoutParams(r15);
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L27:
        setCustomTitleView(R.layout.o_card_list_item_custom_title_detail, r6, r7);
        return;
    L28:
        setCustomTitleView(R.layout.o_card_list_item_custom_title_icon, r6, r7);
    }

    public final void clearCustomTitleView() {
        View r0 = this.titleContainer.findViewById(R.id.custom_title_container);
        if (r0 == null) goto L7;
        this.titleContainer.removeView(r0);
        return;
    }

    public final View getCustomTitleView(int r2) {
        if (this.titleContainer.getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return null;
    L8:
        return this.titleContainer.getChildAt(r2);
    L5:
        r0 = false;
        goto L6
    }

    public final OTextView getCustomTitleText(int r1) {
        View r0 = getCustomTitleView(r1);
        if ((r0 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        return (OTextView) ((ViewGroup) r0).findViewById(R.id.custom_title_text);
    }

    public final OTextView getCustomTitleDetail(int r1) {
        View r0 = getCustomTitleView(r1);
        if ((r0 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        return (OTextView) ((ViewGroup) r0).findViewById(R.id.custom_title_detail);
    }

    public final void setCustomEndView(View r2) {
        this.customEndContainer.removeAllViews();
        if (r2 != null) goto L6;
    L13:
        resetCustomEndDetail();
        return;
    L6:
        if ((r2.getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r0 = r2.getParent();
        if (r0 == null) goto L11;
        ((ViewGroup) r0).removeView(r2);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L12:
        this.customEndContainer.addView(r2);
        goto L13
    }

    public final void setCustomEndView(int r3) {
        this.customEndContainer.removeAllViews();
        if (r3 != 0) goto L8;
    L5:
        resetCustomEndDetail();
        return;
    L8:
        FrameLayout.inflate(getContext(), r3, this.customEndContainer);     // Catch: Exception -> L7
        goto L5
    }

    public final void setDefaultCustomEndView(int r2) {
        this.customEndContainer.removeAllViews();
        if (r2 != 0) goto L5;
        setCustomEndView(R.layout.o_card_list_item_custom_end_checkbox);
        return;
    L5:
        if (r2 != 1) goto L7;
        setCustomEndView(R.layout.o_card_list_item_custom_end_switch);
        return;
    L7:
        if (r2 != 2) goto L9;
        setCustomEndView(R.layout.o_card_list_item_custom_end_mark);
        return;
    L9:
        if (r2 != 3) goto L11;
        setCustomEndView(R.layout.o_card_list_item_custom_end_detail);
        return;
    L11:
        if (r2 == 4) goto L13;
        setCustomEndView(null);
        return;
    L13:
        setCustomEndView(R.layout.o_card_list_item_custom_end_handle);
    }

    private final void resetCustomEndDetail() {
        boolean r1 = true;
        if (this.customEndContainer.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L46;
        View r2 = getCustomEndView();
        ViewGroup.LayoutParams r4 = this.customEndContainer.getLayoutParams();
        ViewGroup.MarginLayoutParams r6 = null;
        if ((r4 instanceof ConstraintLayout.LayoutParams) == false) goto L11;
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) r4;
    L12:
        if (r2 == null) goto L22;
        if ((r2.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L22;
        ViewGroup.LayoutParams r7 = r2.getLayoutParams();
        if (r7 == null) goto L20;
        ((FrameLayout.LayoutParams) r7).gravity = GravityCompat.END;
        goto L22
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L22:
        if ((r2 instanceof OTextView) == false) goto L43;
        OTextView r3 = (OTextView) r2;
        if (TextUtils.isEmpty(r3.getText()) == true) goto L43;
        if (r5 == null) goto L28;
        r5.matchConstraintMaxWidth = this.maxTailTextWidth;
    L28:
        ViewGroup.LayoutParams r8 = r3.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L31;
        r6 = (ViewGroup.MarginLayoutParams) r8;
    L31:
        if (r6 == null) goto L42;
        int r9 = r6.leftMargin;
        int r10 = r6.topMargin;
        if (this.tailIcon.getVisibility() == 0) goto L37;
        r1 = false;
    L37:
        OCardListItem r11 = this;
        if (r1 == false) goto L40;
        int r12 = OUnitExtensionKt.vdp(r11, 0);
    L41:
        r6.setMargins(r9, r10, r12, r6.bottomMargin);
        goto L42
    L40:
        r12 = OUnitExtensionKt.vdp(r11, 6);
    L42:
        r3.setLayoutParams(r6);
        return;
    L43:
        if (r5 == null) goto L54;
        r5.matchConstraintMaxWidth = -2;
        return;
    L54:
        return;
    L11:
        r5 = null;
        goto L12
    L46:
        FrameLayout r13 = this.customEndContainer;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L51;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        r15.matchConstraintMaxWidth = -2;
        r13.setLayoutParams(r15);
        return;
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L5:
        r0 = false;
        goto L7
    }

    public final View getCustomEndView() {
        if (this.customEndContainer.getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return null;
    L8:
        return this.customEndContainer.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final OCheckBoxLayout getEndCheckBox() {
        if ((getCustomEndView() instanceof OCheckBoxLayout) == false) goto L10;
        View r1 = getCustomEndView();
        if (r1 == null) goto L9;
        return (OCheckBoxLayout) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    public final OSwitch getEndSwitch() {
        if ((getCustomEndView() instanceof OSwitch) == false) goto L10;
        View r1 = getCustomEndView();
        if (r1 == null) goto L9;
        return (OSwitch) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
    L10:
        return null;
    }

    public final OCheckMark getEndMark() {
        if ((getCustomEndView() instanceof OCheckMark) == false) goto L10;
        View r1 = getCustomEndView();
        if (r1 == null) goto L9;
        return (OCheckMark) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckMark");
    L10:
        return null;
    }

    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L10;
        View r1 = getCustomEndView();
        if (r1 == null) goto L9;
        return (OTextView) r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L10:
        return null;
    }

    public static /* synthetic */ void setEndDetailText$default(OCardListItem r0, CharSequence r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        r0.setEndDetailText(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEndDetailText");
    }

    public final void setEndDetailText(CharSequence r2, int r3) {
        if (r3 <= 0) goto L4;
        this.maxTailTextWidth = r3;
    L6:
        if ((getCustomEndView() instanceof OTextView) == false) goto L12;
        View r4 = getCustomEndView();
        if (r4 == null) goto L11;
        ((OTextView) r4).setText(r2);
    L19:
        resetCustomEndDetail();
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L12:
        setDefaultCustomEndView(3);
        if ((getCustomEndView() instanceof OTextView) == false) goto L19;
        View r5 = getCustomEndView();
        if (r5 == null) goto L18;
        ((OTextView) r5).setText(r2);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L4:
        this.maxTailTextWidth = OUnitExtensionKt.vdp(this, 168);
        goto L6
    }

    public final void showCustomEnd(boolean r2) {
        FrameLayout r0 = this.customEndContainer;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        resetCustomEndDetail();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setTailIcon(Drawable r1) {
        if (r1 == null) goto L5;
        this.tailIcon.setImageDrawable(r1);
        return;
    }

    public final void setTailIcon(int r1) {
        if (r1 == 0) goto L4;
        this.tailIcon.setImageResource(r1);
        return;
    L4:
        this.tailIcon.setImageDrawable(null);
    }

    public final void setDefaultTailIcon(int r2) {
        if (r2 != 0) goto L4;
        setTailIcon(getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_arrow));
        return;
    L4:
        if (r2 != 1) goto L10;
        setTailIcon(getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_chevron));
        return;
    }

    public final ImageView getTailIconView() {
        return this.tailIcon;
    }

    public final void showTailIcon(boolean r2) {
        ImageView r0 = this.tailIcon;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        resetCustomEndDetail();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void customDivider(int r1, int r2) {
        this.customDividerStart = r1;
        this.customDividerEnd = r2;
    }

    public final void showDivider(boolean r3) {
        View r0 = this.divider;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        if (r3 == false) goto L14;
        View r4 = this.divider;
        if (this.enableSwipeDivider == false) goto L11;
        float r2 = this.currentSwipeOffset;
    L12:
        r4.setTranslationX(r2);
        updateDividerPosition();
        return;
    L11:
        r2 = 0.0f;
        goto L12
    L14:
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public final void setEnableSwipeDivider(boolean r2) {
        this.enableSwipeDivider = r2;
        if (this.divider.getVisibility() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L13;
        View r4 = this.divider;
        if (this.enableSwipeDivider == false) goto L10;
        float r1 = this.currentSwipeOffset;
    L11:
        r4.setTranslationX(r1);
        return;
    L10:
        r1 = 0.0f;
        goto L11
    L13:
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final void updateDividerPosition() {
        this.divider.post(new OCardListItem$$ExternalSyntheticLambda1(this));
        requestLayout();
    }

    /* JADX INFO: renamed from: updateDividerPosition$lambda-17, reason: not valid java name */
    private static final void m1237updateDividerPosition$lambda17(OCardListItem r8) {
        Intrinsics.checkNotNullParameter(r8, "this$0");
        int r0 = r8.customDividerStart;
        int r1 = r8.customDividerEnd;
        ViewGroup.MarginLayoutParams r2 = null;
        if (r0 == (-1)) goto L5;
        if (r1 == (-1)) goto L5;
    L42:
        ViewGroup.LayoutParams r3 = r8.divider.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L45;
        r2 = (ViewGroup.MarginLayoutParams) r3;
    L45:
        if (r2 == null) goto L48;
        r2.setMargins(r0, r2.topMargin, r1, r2.bottomMargin);
    L48:
        r8.divider.setLayoutParams(r2);
        return;
    L5:
        ViewGroup.LayoutParams r4 = r8.cardContainer.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L8;
        r4 = null;
    L8:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        boolean r6 = false;
        if (r5 == null) goto L11;
        int r7 = r5.leftMargin;
    L12:
        int r9 = r8.cardContainer.getPaddingLeft();
        ViewGroup.LayoutParams r10 = r8.cardContainer.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
        r10 = null;
    L15:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        if (r11 == null) goto L18;
        int r12 = r11.rightMargin;
    L19:
        int r13 = r8.cardContainer.getPaddingRight();
        r0 = r7 + r9;
        if (r8.customStartContainer.getVisibility() != 0) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        r0 = r0 + r8.customStartContainer.getWidth();
    L26:
        if (r8.iconContainer.getVisibility() != 0) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == false) goto L32;
        r0 = r0 + r8.iconContainer.getWidth();
    L32:
        if (r8.customStartContainer.getVisibility() != 8) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == true) goto L37;
    L41:
        r1 = OUnitExtensionKt.vdp(r8, 8) + (r12 + r13);
        goto L42
    L37:
        if (r8.iconContainer.getVisibility() != 8) goto L39;
        r6 = true;
    L39:
        if (r6 == false) goto L41;
        r0 = r0 + r8.titleContainer.getPaddingLeft();
        goto L41
    L34:
        r16 = false;
        goto L35
    L28:
        r15 = false;
        goto L29
    L22:
        r14 = false;
        goto L23
    L18:
        r12 = 0;
        goto L19
    L11:
        r7 = 0;
        goto L12
    }

    public final void setEnableSwipe(boolean r2) {
        this.swipeLayout.setSwipeEnabled(r2);
        FrameLayout r1 = this.swipeContainer;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setSwipeView(View r2) {
        this.swipeContainer.removeAllViews();
        if (r2 == null) goto L6;
        this.swipeContainer.addView(r2);
        return;
    }

    public final void setSwipeView(int r2) {
        this.swipeContainer.removeAllViews();
        if (r2 == 0) goto L9;
        FrameLayout.inflate(getContext(), r2, this.swipeContainer);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final OSwipeLayout getSwipeLayout() {
        return this.swipeLayout;
    }

    public final View getSwipeView() {
        if (this.swipeContainer.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.swipeContainer.getChildAt(0);
    }

    public final void swipeOpen() {
        if (this.swipeLayout.isSwipeEnabled() == false) goto L6;
        this.swipeLayout.open();
        return;
    }

    public final void swipeClose() {
        if (this.swipeLayout.isSwipeEnabled() == false) goto L6;
        this.swipeLayout.close();
        return;
    }

    public final void swipeToggle() {
        if (this.swipeLayout.isSwipeEnabled() == false) goto L6;
        this.swipeLayout.toggle();
        return;
    }

    public final void setOnContentClickListener(View.OnClickListener r2) {
        this.contentContainer.setOnClickListener(r2);
        checkContentContainerListenerForBackground();
    }

    public final void setOnContentLongClickListener(View.OnLongClickListener r2) {
        this.contentContainer.setOnLongClickListener(r2);
        checkContentContainerListenerForBackground();
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.contentContainer.setEnabled(r2);
        this.customStartContainer.setEnabled(r2);
        this.iconContainer.setEnabled(r2);
        this.icon.setEnabled(r2);
        OImageAppIcon r0 = this.appIcon;
        if (r0 == null) goto L6;
        r0.setEnabled(r2);
    L6:
        this.titleContainer.setEnabled(r2);
        this.title.setEnabled(r2);
        this.subTitle.setEnabled(r2);
        this.customEndContainer.setEnabled(r2);
        this.tailIcon.setEnabled(r2);
        this.swipeLayout.setEnabled(r2);
        recursiveSetEnabled(this.customStartContainer, r2);
        recursiveSetEnabled(this.customEndContainer, r2);
        recursiveSetEnabled(this.swipeContainer, r2);
    }

    private final void recursiveSetEnabled(View r5, boolean r6) {
        if ((r5 instanceof ViewGroup) == false) goto L7;
        ViewGroup r7 = (ViewGroup) r5;
        int r0 = r7.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        int r2 = r1 + 1;
        View r3 = r7.getChildAt(r1);
        r3.setEnabled(r6);
        Intrinsics.checkNotNullExpressionValue(r3, "child");
        recursiveSetEnabled(r3, r6);
        r1 = r2;
        goto L5
    L9:
        return;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        this.maxTailTextWidth = OUnitExtensionKt.vdp(this, 168);
    }
}
