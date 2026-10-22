package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.color.OPalette;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaskMaterialOwner;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialConfigBuilder;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialOwnerKt;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.ViewUtil;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.floating.OFloatingWindowHelper;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OFloatingTitleBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0018\u0018\u0000 ª\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002ª\u0001B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\f2\b\b\u0002\u0010@\u001a\u00020\tJ$\u0010=\u001a\u00020\f2\u0006\u0010A\u001a\u00020\t2\b\b\u0002\u0010@\u001a\u00020\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ$\u0010=\u001a\u00020\f2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010@\u001a\u00020\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ\u0018\u0010F\u001a\u00020>2\u0006\u0010?\u001a\u00020\f2\b\b\u0002\u0010@\u001a\u00020\tJ$\u0010F\u001a\u00020\f2\u0006\u0010A\u001a\u00020\t2\b\b\u0002\u0010@\u001a\u00020\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ$\u0010F\u001a\u00020\f2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010@\u001a\u00020\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ\u0018\u0010G\u001a\u00020>2\u0006\u0010?\u001a\u00020\f2\b\b\u0002\u0010@\u001a\u00020\tJ$\u0010G\u001a\u00020\f2\u0006\u0010A\u001a\u00020\t2\b\b\u0002\u0010@\u001a\u00020\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ$\u0010G\u001a\u00020\f2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010@\u001a\u00020\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ$\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020E2\b\b\u0002\u0010@\u001a\u00020\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ\u0018\u0010J\u001a\u00020>2\u0006\u0010?\u001a\u00020\f2\b\b\u0002\u0010@\u001a\u00020\tJ$\u0010J\u001a\u00020\f2\u0006\u0010A\u001a\u00020\t2\b\b\u0002\u0010@\u001a\u00020\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ$\u0010J\u001a\u00020\f2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010@\u001a\u00020\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ\u0010\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020,H\u0016J\u0010\u0010M\u001a\u00020>2\u0006\u0010L\u001a\u00020,H\u0016J,\u0010N\u001a\u00020>2\u0006\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\t2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020>01H\u0002J\u0018\u0010R\u001a\u00020\f2\u0006\u0010A\u001a\u00020\t2\u0006\u0010S\u001a\u00020\tH\u0002J\u0018\u0010T\u001a\u00020\f2\u0006\u0010D\u001a\u00020E2\u0006\u0010S\u001a\u00020\tH\u0002J\u0018\u0010U\u001a\u00020\f2\u0006\u0010I\u001a\u00020E2\u0006\u0010S\u001a\u00020\tH\u0002J\u0006\u0010V\u001a\u00020\u0016J\b\u0010W\u001a\u00020\tH\u0002J\u0006\u0010X\u001a\u00020\u0016J\b\u0010Y\u001a\u00020\fH\u0002J\u0006\u0010Z\u001a\u00020\u0016J\u0006\u0010[\u001a\u00020\u0016J\u0010\u0010\\\u001a\u00020>2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010]\u001a\u00020>H\u0002J\b\u0010^\u001a\u00020,H\u0002J\b\u0010_\u001a\u00020,H\u0002J\b\u0010`\u001a\u00020,H\u0002J\b\u0010a\u001a\u00020,H\u0002J\b\u0010b\u001a\u00020>H\u0014J\u0012\u0010c\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u00010eH\u0014J\b\u0010f\u001a\u00020>H\u0014J0\u0010g\u001a\u00020>2\u0006\u0010h\u001a\u00020,2\u0006\u0010i\u001a\u00020\t2\u0006\u0010j\u001a\u00020\t2\u0006\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020\tH\u0014J\u0018\u0010m\u001a\u00020>2\u0006\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\tH\u0014J\b\u0010p\u001a\u00020>H\u0002J\u0006\u0010q\u001a\u00020>J\u0006\u0010r\u001a\u00020>J\u0006\u0010s\u001a\u00020>J\u0006\u0010t\u001a\u00020>J\u0006\u0010u\u001a\u00020>J\u000e\u0010v\u001a\u00020>2\u0006\u0010@\u001a\u00020\tJ\u0006\u0010w\u001a\u00020>J\u0006\u0010x\u001a\u00020>J\u000e\u0010y\u001a\u00020>2\u0006\u0010@\u001a\u00020\tJ\u0006\u0010z\u001a\u00020>J\u000e\u0010{\u001a\u00020>2\u0006\u0010@\u001a\u00020\tJ\u0006\u0010|\u001a\u00020>J\u000e\u0010}\u001a\u00020>2\u0006\u0010@\u001a\u00020\tJ\u0011\u0010~\u001a\u00020>2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u0013\u0010\u0081\u0001\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\fH\u0016J\u000f\u0010\u0082\u0001\u001a\u00020>2\u0006\u0010P\u001a\u00020\tJ\u000f\u0010\u0083\u0001\u001a\u00020>2\u0006\u0010?\u001a\u00020\fJ\u0010\u0010\u0084\u0001\u001a\u00020>2\u0007\u0010\u0085\u0001\u001a\u00020\tJ\u0010\u0010\u0086\u0001\u001a\u00020>2\u0007\u0010\u0087\u0001\u001a\u00020\tJ\u0011\u0010\u0088\u0001\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010EJ\u0010\u0010\u0089\u0001\u001a\u00020>2\u0007\u0010\u0085\u0001\u001a\u00020\tJ\u0011\u0010\u0089\u0001\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010EJ\u0010\u0010\u008a\u0001\u001a\u00020>2\u0007\u0010\u0087\u0001\u001a\u00020\tJ\t\u0010\u008b\u0001\u001a\u00020>H\u0002J\t\u0010\u008c\u0001\u001a\u00020>H\u0007J\u000f\u0010\u008d\u0001\u001a\u00020>2\u0006\u0010P\u001a\u00020\tJ\u0013\u0010\u008e\u0001\u001a\u00020>2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0007J\u0011\u0010\u0091\u0001\u001a\u00020>2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001J\u000f\u0010\u0094\u0001\u001a\u00020>2\u0006\u0010P\u001a\u00020\tJ\u0010\u0010\u0095\u0001\u001a\u00020>2\u0007\u0010\u0087\u0001\u001a\u00020\tJ\u0010\u0010\u0096\u0001\u001a\u00020>2\u0007\u0010\u0085\u0001\u001a\u00020\tJ\u0011\u0010\u0096\u0001\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010EJ\u0010\u0010\u0097\u0001\u001a\u00020>2\u0007\u0010\u0085\u0001\u001a\u00020\tJ\u0011\u0010\u0097\u0001\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010EJ\u0010\u0010\u0098\u0001\u001a\u00020>2\u0007\u0010\u0087\u0001\u001a\u00020\tJ\u000f\u0010\u0099\u0001\u001a\u00020>2\u0006\u0010P\u001a\u00020\tJ\u0010\u0010\u009a\u0001\u001a\u00020>2\u0007\u0010\u009b\u0001\u001a\u00020\tJ\u0010\u0010\u009c\u0001\u001a\u00020>2\u0007\u0010\u009d\u0001\u001a\u00020,J\u0010\u0010\u009e\u0001\u001a\u00020>2\u0007\u0010\u009d\u0001\u001a\u00020,J\u0010\u0010\u009f\u0001\u001a\u00020>2\u0007\u0010\u009d\u0001\u001a\u00020,J\u0010\u0010 \u0001\u001a\u00020>2\u0007\u0010\u009d\u0001\u001a\u00020,J\u0010\u0010¡\u0001\u001a\u00020>2\u0007\u0010\u009d\u0001\u001a\u00020,J\u0010\u0010¢\u0001\u001a\u00020>2\u0007\u0010\u009d\u0001\u001a\u00020,J\u0012\u0010£\u0001\u001a\u00020>2\u0007\u0010¤\u0001\u001a\u00020\tH\u0016J\u0011\u0010¥\u0001\u001a\u00020>2\u0006\u0010+\u001a\u00020,H\u0016J\u0019\u0010¦\u0001\u001a\u00020>2\u0006\u0010O\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\tH\u0002J\u0010\u0010§\u0001\u001a\u00020>2\u0007\u0010¨\u0001\u001a\u00020\tJ\u001b\u0010©\u0001\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\f2\u0006\u0010S\u001a\u00020\tH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u000e\u0010#\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R\u000e\u0010'\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u001f01X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u000e\u00107\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006«\u0001"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/material/MaskMaterialOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backdropTarget", "Landroid/view/View;", "centerButtonGroup", "Lcom/obric/oui/button/OButtonGroup;", "getCenterButtonGroup", "()Lcom/obric/oui/button/OButtonGroup;", "setCenterButtonGroup", "(Lcom/obric/oui/button/OButtonGroup;)V", "centerContainer", "centerCustomContainer", "centerSubtitleView", "Lcom/obric/oui/text/OTextView;", "centerTintColor", "centerTitleContainer", "Landroid/widget/LinearLayout;", "centerTitleGapLargeFontPx", "centerTitleGapPx", "centerTitleHorizontalPaddingPx", "centerTitleView", "currentMaskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "endButtonGroup", "getEndButtonGroup", "setEndButtonGroup", "endContainer", "endSubButtonGroup", "getEndSubButtonGroup", "setEndSubButtonGroup", "endSubTintColor", "endTintColor", "floatingWindowHelper", "Lcom/obric/oui/window/floating/OFloatingWindowHelper;", "isBackdropView", "", "isCenterOverflow", "mIsLargeFont", "mType", "maskMaterial", "Lkotlin/Function1;", "materialMask", "materialSrcType", "startButtonGroup", "getStartButtonGroup", "setStartButtonGroup", "startContainer", "startSubtitleView", "startTintColor", "startTitleContainer", "startTitleView", "titleBarContainer", "addCenterAction", "", "view", Utils.INTENT_KEY_INDEX, "iconRes", "onClick", "Landroid/view/View$OnClickListener;", "text", "", "addEndAction", "addStartAction", "addStartTitleArrowAction", "title", "addSubEndAction", "applyContentMaterial", "apply", "applyMaskMaterial", "applyStyleToGroup", "group", "styleRes", "onTintColorChanged", "createIconActionView", "tintColor", "createTextActionView", "createTitleArrowActionView", "getCenterSubtitleView", "getCenterTitleGap", "getCenterTitleView", "getDefaultTargetView", "getStartSubtitleView", "getStartTitleView", "initAttrs", "initViews", "isCenterVis", "isDarkTheme", "isEndVis", "isStartVis", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onFinishInflate", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDimensionCache", "removeAllCenterAction", "removeAllEndAction", "removeAllStartAction", "removeAllSubEndAction", "removeCenterAction", "removeCenterActionAt", "removeCenterCustomView", "removeEndAction", "removeEndActionAt", "removeStartAction", "removeStartActionAt", "removeSubEndAction", "removeSubEndActionAt", "resetTitleVis", "txt", "Landroid/widget/TextView;", "setBackdropTarget", "setCenterButtonGroupStyle", "setCenterCustomView", "setCenterSubTitle", "resId", "setCenterSubTitleColor", "color", "setCenterSubtitle", "setCenterTitle", "setCenterTitleColor", "setDefaultBackdropTargetForChild", "setDefaultMaskBackground", "setEndButtonGroupStyle", "setMaskBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setMaskBlurRadius", "radius", "", "setStartButtonGroupStyle", "setStartSubTitleColor", "setStartSubtitle", "setStartTitle", "setStartTitleColor", "setSubEndButtonGroupStyle", "setTitleType", "type", "showCenterAction", InvokeHistoryActivity.PREF_SHOW, "showCenterCustomView", "showEndAction", "showMask", "showStartAction", "showSubEndAction", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateGroupItemsTint", "updateLayoutForInsetTop", "insetTop", "updateViewTint", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFloatingTitleBar extends FrameLayout implements MaterialOwner, MaskMaterialOwner {
    private static final int CENTER_TITLE_GAP = 12;
    private static final int CENTER_TITLE_GAP_IN_LARGE_FONT = 4;
    private static final int CENTER_TITLE_HORIZONTAL_PADDING = 8;
    public static final Companion Companion = null;
    private static final String TAG = "OFloatingTitleBar";
    public static final int TYPE_FLOATING = 2;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_WINDOW = 1;
    private View backdropTarget;
    public OButtonGroup centerButtonGroup;
    private FrameLayout centerContainer;
    private FrameLayout centerCustomContainer;
    private OTextView centerSubtitleView;
    private int centerTintColor;
    private LinearLayout centerTitleContainer;
    private int centerTitleGapLargeFontPx;
    private int centerTitleGapPx;
    private int centerTitleHorizontalPaddingPx;
    private OTextView centerTitleView;
    private MaterialConfig currentMaskMaterialConfig;
    public OButtonGroup endButtonGroup;
    private LinearLayout endContainer;
    public OButtonGroup endSubButtonGroup;
    private int endSubTintColor;
    private int endTintColor;
    private final OFloatingWindowHelper floatingWindowHelper;
    private boolean isBackdropView;
    private boolean isCenterOverflow;
    private boolean mIsLargeFont;
    private int mType;
    private Function1<? super Boolean, MaterialConfig> maskMaterial;
    private View materialMask;
    private int materialSrcType;
    public OButtonGroup startButtonGroup;
    private FrameLayout startContainer;
    private OTextView startSubtitleView;
    private int startTintColor;
    private LinearLayout startTitleContainer;
    private OTextView startTitleView;
    private View titleBarContainer;

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$Companion;", "", "()V", "CENTER_TITLE_GAP", "", "CENTER_TITLE_GAP_IN_LARGE_FONT", "CENTER_TITLE_HORIZONTAL_PADDING", "TAG", "", "TYPE_FLOATING", "TYPE_NORMAL", "TYPE_WINDOW", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OFloatingTitleBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OFloatingTitleBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    @Deprecated(message = "not support set default mask background")
    public final void setDefaultMaskBackground() {
    }

    public /* synthetic */ OFloatingTitleBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void access$setCenterTintColor$p(OFloatingTitleBar r0, int r1) {
        r0.centerTintColor = r1;
    }

    public static final /* synthetic */ void access$setEndSubTintColor$p(OFloatingTitleBar r0, int r1) {
        r0.endSubTintColor = r1;
    }

    public static final /* synthetic */ void access$setEndTintColor$p(OFloatingTitleBar r0, int r1) {
        r0.endTintColor = r1;
    }

    public static final /* synthetic */ void access$setStartTintColor$p(OFloatingTitleBar r0, int r1) {
        r0.startTintColor = r1;
    }

    public static final /* synthetic */ void access$updateGroupItemsTint(OFloatingTitleBar r0, OButtonGroup r1, int r2) {
        r0.updateGroupItemsTint(r1, r2);
    }

    public OFloatingTitleBar(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.isBackdropView = true;
        this.materialSrcType = 2;
        this.maskMaterial = new OFloatingTitleBar$maskMaterial$1(this);
        OFloatingWindowHelper r0 = new OFloatingWindowHelper(this);
        this.floatingWindowHelper = r0;
        this.mIsLargeFont = ViewUtil.isInLargeFont(r4.getResources().getConfiguration().fontScale);
        refreshDimensionCache();
        LayoutInflater.from(r4).inflate(R.layout.o_floating_title_bar_layout, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        initViews();
        if (r5 == null) goto L5;
        initAttrs(r5);
    L5:
        r0.setGravity(49);
    }

    public final OButtonGroup getStartButtonGroup() {
        OButtonGroup r0 = this.startButtonGroup;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("startButtonGroup");
        return null;
    }

    public final void setStartButtonGroup(OButtonGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.startButtonGroup = r2;
    }

    public final OButtonGroup getCenterButtonGroup() {
        OButtonGroup r0 = this.centerButtonGroup;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("centerButtonGroup");
        return null;
    }

    public final void setCenterButtonGroup(OButtonGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.centerButtonGroup = r2;
    }

    public final OButtonGroup getEndSubButtonGroup() {
        OButtonGroup r0 = this.endSubButtonGroup;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("endSubButtonGroup");
        return null;
    }

    public final void setEndSubButtonGroup(OButtonGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.endSubButtonGroup = r2;
    }

    public final OButtonGroup getEndButtonGroup() {
        OButtonGroup r0 = this.endButtonGroup;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("endButtonGroup");
        return null;
    }

    public final void setEndButtonGroup(OButtonGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.endButtonGroup = r2;
    }

    public final void updateLayoutForInsetTop(int r6) {
        View r0 = this.materialMask;
        View r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("materialMask");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = getContext().getResources().getDimensionPixelSize(R.dimen.oui_title_bar_mask_height) + r6;
        View r3 = this.materialMask;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("materialMask");
        r3 = null;
    L8:
        r3.setLayoutParams(r1);
        View r4 = this.titleBarContainer;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r4 = null;
    L11:
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L20;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r5;
        r7.topMargin = r6;
        View r8 = this.titleBarContainer;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L17:
        r2.setLayoutParams(r7);
        return;
    L16:
        r2 = r8;
        goto L17
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void initViews() {
        View r0 = findViewById(R.id.start_container);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.start_container)");
        this.startContainer = (FrameLayout) r0;
        View r1 = findViewById(R.id.start_button_group);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.start_button_group)");
        setStartButtonGroup((OButtonGroup) r1);
        View r2 = findViewById(R.id.start_title_container);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.start_title_container)");
        this.startTitleContainer = (LinearLayout) r2;
        View r3 = findViewById(R.id.start_title);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.start_title)");
        this.startTitleView = (OTextView) r3;
        View r4 = findViewById(R.id.start_sub_title);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.start_sub_title)");
        this.startSubtitleView = (OTextView) r4;
        View r5 = findViewById(R.id.center_container);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.center_container)");
        this.centerContainer = (FrameLayout) r5;
        View r6 = findViewById(R.id.center_button_group);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.center_button_group)");
        setCenterButtonGroup((OButtonGroup) r6);
        View r7 = findViewById(R.id.center_custom_container);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.center_custom_container)");
        this.centerCustomContainer = (FrameLayout) r7;
        View r8 = findViewById(R.id.center_title_container);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.center_title_container)");
        this.centerTitleContainer = (LinearLayout) r8;
        View r9 = findViewById(R.id.center_title);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.center_title)");
        this.centerTitleView = (OTextView) r9;
        View r10 = findViewById(R.id.center_sub_title);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.center_sub_title)");
        this.centerSubtitleView = (OTextView) r10;
        OTextView r11 = this.startTitleView;
        View r12 = null;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r11 = null;
    L5:
        r11.setFallbackLineSpacing(false);
        OTextView r13 = this.startSubtitleView;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r13 = null;
    L8:
        r13.setFallbackLineSpacing(false);
        OTextView r14 = this.centerTitleView;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r14 = null;
    L11:
        r14.setFallbackLineSpacing(false);
        OTextView r15 = this.centerSubtitleView;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r15 = null;
    L14:
        r15.setFallbackLineSpacing(false);
        View r16 = findViewById(R.id.end_container);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.end_container)");
        this.endContainer = (LinearLayout) r16;
        View r17 = findViewById(R.id.end_sub_button_group);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.end_sub_button_group)");
        setEndSubButtonGroup((OButtonGroup) r17);
        View r18 = findViewById(R.id.end_button_group);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.end_button_group)");
        setEndButtonGroup((OButtonGroup) r18);
        View r19 = findViewById(R.id.material_mask);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.material_mask)");
        this.materialMask = r19;
        View r20 = findViewById(R.id.title_bar_container);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.title_bar_container)");
        this.titleBarContainer = r20;
        if (r20 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L18:
        r12.setClickable(true);
        this.currentMaskMaterialConfig = this.maskMaterial.invoke(Boolean.valueOf(true ^ isDarkTheme()));
        setDefaultBackdropTargetForChild();
        return;
    L17:
        r12 = r20;
        goto L18
    }

    private final View getDefaultTargetView() {
        if (OMaterialHelper.getEffectOverlayLevel() <= 1) goto L9;
        View r2 = this.titleBarContainer;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        return null;
    L10:
        return r2;
    L9:
        return this;
    }

    private final void initAttrs(AttributeSet r9) {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        int[] r1 = R.styleable.OFloatingTitleBar;
        Intrinsics.checkNotNullExpressionValue(r1, TAG);
        boolean r3 = false;
        TypedArray r10 = r0.obtainStyledAttributes(r9, r1, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r10, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_type) == false) goto L6;
        setTitleType(r10.getInt(R.styleable.OFloatingTitleBar_oFloatingTitleBar_type, 0));
    L6:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitle) == false) goto L9;
        setStartTitle(r10.getString(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitle));
    L9:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitleColor) == false) goto L12;
        setStartTitleColor(r10.getColor(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitleColor, R.color.oui_basic_text_1));
    L12:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitle) == false) goto L15;
        setStartSubtitle(r10.getString(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitle));
    L15:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor) == false) goto L18;
        setStartSubTitleColor(r10.getColor(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor, R.color.oui_basic_text_3));
    L18:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitle) == false) goto L21;
        setCenterTitle(r10.getString(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitle));
    L21:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitleColor) == false) goto L24;
        setCenterTitleColor(r10.getColor(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitleColor, R.color.oui_basic_text_1));
    L24:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitle) == false) goto L27;
        setCenterSubtitle(r10.getString(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitle));
    L27:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor) == false) goto L29;
        setCenterSubTitleColor(r10.getColor(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor, R.color.oui_basic_text_3));
    L29:
        setStartButtonGroupStyle(r10.getResourceId(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startButtonGroupStyle, R.style.OFloatingTitleBar_Action_Standard));
        setCenterButtonGroupStyle(r10.getResourceId(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerButtonGroupStyle, R.style.OFloatingTitleBar_Action_Standard));
        setSubEndButtonGroupStyle(r10.getResourceId(R.styleable.OFloatingTitleBar_oFloatingTitleBar_endSubButtonGroupStyle, R.style.OFloatingTitleBar_Action_Standard));
        setEndButtonGroupStyle(r10.getResourceId(R.styleable.OFloatingTitleBar_oFloatingTitleBar_endButtonGroupStyle, R.style.OFloatingTitleBar_Action_Standard));
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground) == false) goto L36;
        Drawable r2 = r10.getDrawable(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground);
        if (r2 == null) goto L34;
        setMaskBackground(r2);
        goto L36
    L34:
        setMaskBackground(new ColorDrawable(r10.getColor(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground, 0)));
    L36:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground) == false) goto L41;
        if (r10.getBoolean(R.styleable.OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground, false) == false) goto L41;
        setDefaultMaskBackground();
    L41:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oui_widgetBlurColors) == false) goto L55;
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oui_widgetBlurBlendModes) == false) goto L55;
        int r4 = r10.getResourceId(R.styleable.OFloatingTitleBar_oui_widgetBlurColors, R.array.oui_titlebar_blur_colors);
        int r5 = r10.getResourceId(R.styleable.OFloatingTitleBar_oui_widgetBlurBlendModes, R.array.oui_titlebar_blur_blend_modes);
        MaterialConfig r6 = this.currentMaskMaterialConfig;
        MaterialConfig r7 = null;
        if (r6 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r6 = null;
    L47:
        r6.setBlendConfig(OMaterialHelper.getBlendConfigArray(r10.getResources(), r4, r5));
        MaterialConfig r8 = this.currentMaskMaterialConfig;
        if (r8 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L52:
        if (r7.getBlendConfig() != null) goto L55;
        L.e(TAG, "init get widget blur colors or modes error");
        goto L55
    L50:
        r7 = r8;
    L55:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oui_widgetMaterialSrcType) == false) goto L61;
        int r11 = R.styleable.OFloatingTitleBar_oui_widgetMaterialSrcType;
        int r12 = 2;
        if (this.mType != 2) goto L59;
        r12 = 4;
    L59:
        this.materialSrcType = r10.getInt(r11, r12);
    L61:
        if (r10.hasValue(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius) == false) goto L64;
        setMaskBlurRadius(r10.getFloat(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius, BlurToken.Blur_Progress_Thin));
    L64:
        if (r10.getBoolean(R.styleable.OFloatingTitleBar_oui_widgetFitInsetTop, r10.getBoolean(R.styleable.OFloatingTitleBar_oFloatingTitleBar_statusBarImmersion, false)) == true) goto L66;
    L68:
        this.floatingWindowHelper.setupInsets(r3, new OFloatingTitleBar$initAttrs$1$1(this));
        r10.recycle();
        return;
    L66:
        if (this.mType == 1) goto L68;
        r3 = true;
        goto L68
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        boolean r1 = true;
        if ((getParent() instanceof MaskMaterialOwner) == false) goto L8;
    L11:
        if (r1 == false) goto L13;
        showMask(false);
        goto L13
    L8:
        if ((getParent().getParent() instanceof MaskMaterialOwner) == true) goto L11;
        r1 = false;
    L13:
        this.floatingWindowHelper.onAttachedToWindow();
    }

    public final void setTitleType(int r8) {
        this.mType = r8;
        OFloatingWindowHelper r0 = this.floatingWindowHelper;
        if (r8 != 2) goto L5;
        boolean r3 = true;
    L6:
        r0.setFloatingType(r3);
        View r6 = null;
        MaterialConfig r7 = null;
        View r9 = null;
        if (r8 == 0) goto L33;
        if (r8 == 1) goto L25;
        if (r8 != 2) goto L44;
        View r10 = this.titleBarContainer;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r10 = null;
    L14:
        OFloatingTitleBar r1 = this;
        r10.setMinimumHeight(OUnitExtensionKt.vdp(r1, 56));
        View r11 = this.titleBarContainer;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r11 = null;
    L17:
        r11.setPadding(OUnitExtensionKt.vdp(r1, 12), OUnitExtensionKt.vdp(r1, 8), OUnitExtensionKt.vdp(r1, 12), OUnitExtensionKt.vdp(r1, 8));
        MaterialConfig r12 = this.currentMaskMaterialConfig;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L21:
        BlurConfig r13 = r7.getBlurConfig();
        if (r13 == null) goto L45;
        setMaskBlurRadius(r13.getBlurRadius());
        return;
    L45:
        return;
    L20:
        r7 = r12;
        goto L21
    L44:
        return;
    L25:
        View r14 = this.titleBarContainer;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r14 = null;
    L28:
        OFloatingTitleBar r2 = this;
        r14.setMinimumHeight(OUnitExtensionKt.vdp(r2, 64));
        View r15 = this.titleBarContainer;
        if (r15 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L32:
        r9.setPadding(OUnitExtensionKt.vdp(r2, 16), OUnitExtensionKt.vdp(r2, 16), OUnitExtensionKt.vdp(r2, 16), OUnitExtensionKt.vdp(r2, 8));
        return;
    L31:
        r9 = r15;
        goto L32
    L33:
        View r16 = this.titleBarContainer;
        if (r16 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r16 = null;
    L36:
        OFloatingTitleBar r4 = this;
        r16.setMinimumHeight(OUnitExtensionKt.vdp(r4, 56));
        View r17 = this.titleBarContainer;
        if (r17 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L40:
        r6.setPadding(OUnitExtensionKt.vdp(r4, 12), OUnitExtensionKt.vdp(r4, 8), OUnitExtensionKt.vdp(r4, 12), OUnitExtensionKt.vdp(r4, 8));
        return;
    L39:
        r6 = r17;
        goto L40
    L5:
        r3 = false;
        goto L6
    }

    public static /* synthetic */ void addStartAction$default(OFloatingTitleBar r0, View r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = -1;
    L5:
        r0.addStartAction(r1, r2);
    }

    public final void addStartAction(View r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        getStartButtonGroup().addItemView(r4, new ViewGroup.MarginLayoutParams(-2, -2), r5);
        getStartButtonGroup().setVisibility(0);
    }

    public static /* synthetic */ View addStartAction$default(OFloatingTitleBar r0, int r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.addStartAction(r1, r2, r3);
    }

    public final View addStartAction(int r2, int r3, View.OnClickListener r4) {
        View r5 = createIconActionView(r2, this.startTintColor);
        if (r4 == null) goto L5;
        r5.setOnClickListener(r4);
    L5:
        addStartAction(r5, r3);
        return r5;
    }

    public static /* synthetic */ View addStartAction$default(OFloatingTitleBar r0, String r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.addStartAction(r1, r2, r3);
    }

    public final View addStartAction(String r2, int r3, View.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        View r5 = createTextActionView(r2, this.startTintColor);
        if (r4 == null) goto L5;
        r5.setOnClickListener(r4);
    L5:
        addStartAction(r5, r3);
        return r5;
    }

    public static /* synthetic */ View addStartTitleArrowAction$default(OFloatingTitleBar r0, String r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.addStartTitleArrowAction(r1, r2, r3);
    }

    public final View addStartTitleArrowAction(String r2, int r3, View.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        View r5 = createTitleArrowActionView(r2, this.startTintColor);
        if (r4 == null) goto L5;
        r5.setOnClickListener(r4);
    L5:
        addStartAction(r5, r3);
        return r5;
    }

    public final void removeStartActionAt(int r1) {
        getStartButtonGroup().removeItemViewAt(r1);
    }

    public final void removeStartAction() {
        getStartButtonGroup().removeItemView();
    }

    public final void removeAllStartAction() {
        getStartButtonGroup().removeAllItemViews();
    }

    public final void showStartAction(boolean r1) {
        OButtonGroup r0 = getStartButtonGroup();
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public static /* synthetic */ void addCenterAction$default(OFloatingTitleBar r0, View r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = -1;
    L5:
        r0.addCenterAction(r1, r2);
    }

    public final void addCenterAction(View r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        getCenterButtonGroup().addItemView(r4, new ViewGroup.MarginLayoutParams(-2, -2), r5);
        getCenterButtonGroup().setVisibility(0);
    }

    public static /* synthetic */ View addCenterAction$default(OFloatingTitleBar r0, int r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.addCenterAction(r1, r2, r3);
    }

    public final View addCenterAction(int r2, int r3, View.OnClickListener r4) {
        View r5 = createIconActionView(r2, this.centerTintColor);
        if (r4 == null) goto L5;
        r5.setOnClickListener(r4);
    L5:
        addCenterAction(r5, r3);
        return r5;
    }

    public static /* synthetic */ View addCenterAction$default(OFloatingTitleBar r0, String r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.addCenterAction(r1, r2, r3);
    }

    public final View addCenterAction(String r2, int r3, View.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        View r5 = createTextActionView(r2, this.centerTintColor);
        if (r4 == null) goto L5;
        r5.setOnClickListener(r4);
    L5:
        addCenterAction(r5, r3);
        return r5;
    }

    public final void removeCenterActionAt(int r1) {
        getCenterButtonGroup().removeItemViewAt(r1);
    }

    public final void removeCenterAction() {
        getCenterButtonGroup().removeItemView();
    }

    public final void removeAllCenterAction() {
        getCenterButtonGroup().removeAllItemViews();
    }

    public final void showCenterAction(boolean r1) {
        OButtonGroup r0 = getCenterButtonGroup();
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCenterCustomView(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FrameLayout r0 = this.centerCustomContainer;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        FrameLayout r2 = this.centerCustomContainer;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r2 = null;
    L8:
        r2.addView(r4);
        FrameLayout r3 = this.centerCustomContainer;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L12:
        r1.setVisibility(0);
        if ((r4 instanceof MaterialOwner) == false) goto L16;
        ((MaterialOwner) r4).setBackdropTarget(getDefaultTargetView());
        return;
    L16:
        return;
    L11:
        r1 = r3;
        goto L12
    }

    public final void removeCenterCustomView() {
        FrameLayout r0 = this.centerCustomContainer;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        FrameLayout r3 = this.centerCustomContainer;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L9:
        r1.setVisibility(8);
        return;
    L8:
        r1 = r3;
        goto L9
    }

    public final void showCenterCustomView(boolean r1) {
        FrameLayout r0 = this.centerCustomContainer;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r0 = null;
    L5:
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public static /* synthetic */ void addEndAction$default(OFloatingTitleBar r0, View r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = -1;
    L5:
        r0.addEndAction(r1, r2);
    }

    public final void addEndAction(View r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        getEndButtonGroup().addItemView(r4, new ViewGroup.MarginLayoutParams(-2, -2), r5);
        getEndButtonGroup().setVisibility(0);
    }

    public static /* synthetic */ View addEndAction$default(OFloatingTitleBar r0, int r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.addEndAction(r1, r2, r3);
    }

    public final View addEndAction(int r2, int r3, View.OnClickListener r4) {
        View r5 = createIconActionView(r2, this.endTintColor);
        if (r4 == null) goto L5;
        r5.setOnClickListener(r4);
    L5:
        addEndAction(r5, r3);
        return r5;
    }

    public static /* synthetic */ View addEndAction$default(OFloatingTitleBar r0, String r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.addEndAction(r1, r2, r3);
    }

    public final View addEndAction(String r2, int r3, View.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        View r5 = createTextActionView(r2, this.endTintColor);
        if (r4 == null) goto L5;
        r5.setOnClickListener(r4);
    L5:
        addEndAction(r5, r3);
        return r5;
    }

    public final void removeEndActionAt(int r1) {
        getEndButtonGroup().removeItemViewAt(r1);
    }

    public final void removeEndAction() {
        getEndButtonGroup().removeItemView();
    }

    public final void removeAllEndAction() {
        getEndButtonGroup().removeAllItemViews();
    }

    public final void showEndAction(boolean r1) {
        OButtonGroup r0 = getEndButtonGroup();
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public static /* synthetic */ void addSubEndAction$default(OFloatingTitleBar r0, View r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = -1;
    L5:
        r0.addSubEndAction(r1, r2);
    }

    public final void addSubEndAction(View r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        getEndSubButtonGroup().addItemView(r4, new ViewGroup.MarginLayoutParams(-2, -2), r5);
        getEndSubButtonGroup().setVisibility(0);
    }

    public static /* synthetic */ View addSubEndAction$default(OFloatingTitleBar r0, int r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.addSubEndAction(r1, r2, r3);
    }

    public final View addSubEndAction(int r2, int r3, View.OnClickListener r4) {
        View r5 = createIconActionView(r2, this.endSubTintColor);
        if (r4 == null) goto L5;
        r5.setOnClickListener(r4);
    L5:
        addSubEndAction(r5, r3);
        return r5;
    }

    public static /* synthetic */ View addSubEndAction$default(OFloatingTitleBar r0, String r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return r0.addSubEndAction(r1, r2, r3);
    }

    public final View addSubEndAction(String r2, int r3, View.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        View r5 = createTextActionView(r2, this.endSubTintColor);
        if (r4 == null) goto L5;
        r5.setOnClickListener(r4);
    L5:
        addSubEndAction(r5, r3);
        return r5;
    }

    public final void removeSubEndActionAt(int r1) {
        getEndSubButtonGroup().removeItemViewAt(r1);
    }

    public final void removeSubEndAction() {
        getEndSubButtonGroup().removeItemView();
    }

    public final void removeAllSubEndAction() {
        getEndSubButtonGroup().removeAllItemViews();
    }

    public final void showSubEndAction(boolean r1) {
        OButtonGroup r0 = getEndSubButtonGroup();
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public final void setStartButtonGroupStyle(int r3) {
        applyStyleToGroup(getStartButtonGroup(), r3, new C03071(this));
    }

    public final void setCenterButtonGroupStyle(int r3) {
        applyStyleToGroup(getCenterButtonGroup(), r3, new AnonymousClass1(this));
    }

    public final void setSubEndButtonGroupStyle(int r3) {
        applyStyleToGroup(getEndSubButtonGroup(), r3, new C03081(this));
    }

    public final void setEndButtonGroupStyle(int r3) {
        applyStyleToGroup(getEndButtonGroup(), r3, new C03061(this));
    }

    private final void updateGroupItemsTint(OButtonGroup r4, int r5) {
        int r0 = r4.getItemCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r1 + 1;
        updateViewTint(r4.getItemViewAt(r1), r5);
        r1 = r2;
        goto L3
    }

    private final void updateViewTint(View r4, int r5) {
        if ((r4 instanceof ViewGroup) == false) goto L8;
        ViewGroup r6 = (ViewGroup) r4;
        int r0 = r6.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L17;
        int r2 = r1 + 1;
        updateViewTint(r6.getChildAt(r1), r5);
        r1 = r2;
        goto L5
    L17:
        return;
    L8:
        if ((r4 instanceof ImageView) == false) goto L11;
        ((ImageView) r4).setColorFilter(r5);
        return;
    L11:
        if ((r4 instanceof TextView) == false) goto L16;
        ((TextView) r4).setTextColor(r5);
        return;
    }

    private final void applyStyleToGroup(OButtonGroup r7, int r8, Function1<? super Integer, Unit> r9) {
        if (r8 != 0) goto L4;
        return;
    L4:
        TypedArray r10 = getContext().obtainStyledAttributes(r8, R.styleable.OShadowFrame);
        Intrinsics.checkNotNullExpressionValue(r10, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        int r0 = r10.getColor(R.styleable.OShadowFrame_oui_widgetBgColor, 0);
        int r2 = r10.getColor(R.styleable.OShadowFrame_oui_widgetPressColor, 0);
        int r3 = r10.getColor(R.styleable.OShadowFrame_oui_widgetBgColorDisabled, 0);
        int r1 = r10.getColor(R.styleable.OShadowFrame_oui_widgetTintColor, 0);
        String r4 = r10.getString(R.styleable.OShadowFrame_oui_widgetMaterial);
        String r5 = r10.getString(R.styleable.OShadowFrame_oui_widgetMaterialDisabled);
        r10.recycle();
        String r6 = getContext().getString(R.string.oui_material_bg_floating);
        Intrinsics.checkNotNullExpressionValue(r6, "context.getString(R.stri…oui_material_bg_floating)");
        if (StringsKt.contentEquals(r6, r4) == true) goto L7;
    L9:
        if (r0 == 0) goto L25;
        if (r4 == null) goto L16;
        if (r3 != 0) goto L14;
        r3 = r0;
    L14:
        r7.setBgColors(r0, r3, r4, r5);
        goto L25
    L16:
        if (OPalette.isColorFul(r0) == false) goto L21;
        if (r3 == 0) goto L19;
        int r11 = r3;
    L20:
        r7.setBgColors(r0, r11, MaterialConfigBuilder.INSTANCE.createSimpleColorful(MaterialToken.OUI_Bg_Floating_Tinted_Light, r0), MaterialConfigBuilder.INSTANCE.createSimpleColorful(MaterialToken.OUI_Bg_Floating_Tinted_Light, r3));
        goto L25
    L19:
        r11 = r0;
        goto L20
    L21:
        if (r3 != 0) goto L24;
        r3 = r0;
    L24:
        String r12 = (String) null;
        r7.setBgColors(r0, r3, null, null);
    L25:
        if (r2 == 0) goto L27;
        r7.setPressColor(r2);
    L27:
        if (r1 == 0) goto L30;
        r9.invoke(Integer.valueOf(r1));
        return;
    L30:
        return;
    L7:
        if (OPalette.isColorFul(r0) == false) goto L9;
        r4 = null;
        goto L9
    }

    private final View createIconActionView(int r9, int r10) {
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        OUIFrameLayout r7 = new OUIFrameLayout(r1, null, 0, null, 14, null);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        OUIFrameLayout r8 = r7;
        r7.setPadding(OUnitExtensionKt.vdp(r8, 7), OUnitExtensionKt.vdp(r8, 7), OUnitExtensionKt.vdp(r8, 7), OUnitExtensionKt.vdp(r8, 7));
        r7.setClickable(true);
        r7.setRadius(OUnitExtensionKt.vdp(r8, 99));
        ImageView r0 = new ImageView(r7.getContext());
        r0.setImageResource(r9);
        if (r10 == 0) goto L5;
        r0.setColorFilter(r10);
    L5:
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(OUnitExtensionKt.vdp(r8, 22), OUnitExtensionKt.vdp(r8, 22));
        r11.gravity = 17;
        Unit r12 = Unit.INSTANCE;
        r7.addView(r0, r11);
        return r8;
    }

    private final View createTextActionView(String r18, int r19) {
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        OUIFrameLayout r8 = new OUIFrameLayout(r2, null, 0, null, 14, null);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        OUIFrameLayout r1 = r8;
        r8.setMinimumHeight(OUnitExtensionKt.vdp(r1, 36));
        r8.setPadding(OUnitExtensionKt.vdp(r1, 7), 0, OUnitExtensionKt.vdp(r1, 7), 0);
        r8.setClickable(true);
        r8.setRadius(OUnitExtensionKt.vdp(r1, 99));
        Context r11 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        OTextView r4 = new OTextView(r11, null, 0, null, 14, null);
        r4.setText(r18);
        r4.setGravity(17);
        OTextView r7 = r4;
        r4.setPadding(OUnitExtensionKt.vdp(r7, 4), 0, OUnitExtensionKt.vdp(r7, 4), 0);
        r4.setSingleLine(true);
        r4.setMinHeight(OUnitExtensionKt.vdp(r7, 22));
        r4.setTextAppearance(R.style.Button_2_Medium);
        if (r19 == 0) goto L5;
        r4.setTextColor(r19);
    L5:
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        Unit r3 = Unit.INSTANCE;
        r8.addView(r7, r0);
        return r1;
    }

    private final View createTitleArrowActionView(String r18, int r19) {
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        OUILinearLayout r8 = new OUILinearLayout(r2, null, 0, null, 14, null);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        OUILinearLayout r1 = r8;
        r8.setMinimumHeight(OUnitExtensionKt.vdp(r1, 36));
        r8.setPadding(OUnitExtensionKt.vdp(r1, 7), 0, OUnitExtensionKt.vdp(r1, 8), 0);
        r8.setClickable(true);
        r8.setRadius(OUnitExtensionKt.vdp(r1, 99));
        r8.setOrientation(0);
        r8.setGravity(16);
        Context r11 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        OTextView r6 = new OTextView(r11, null, 0, null, 14, null);
        r6.setText(r18);
        r6.setGravity(16);
        OTextView r7 = r6;
        r6.setPadding(OUnitExtensionKt.vdp(r7, 4), 0, 0, 0);
        r6.setSingleLine(true);
        r6.setMinHeight(OUnitExtensionKt.vdp(r7, 22));
        r6.setTextAppearance(R.style.Title_1_Bold);
        if (r19 == 0) goto L5;
        r6.setTextColor(r19);
    L5:
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.gravity = 16;
        Unit r4 = Unit.INSTANCE;
        r8.addView(r7, r3);
        ImageView r5 = new ImageView(r8.getContext());
        r5.setImageResource(R.drawable.o_card_list_item_tail_icon_chevron);
        if (r19 == 0) goto L8;
        r5.setColorFilter(r19);
    L8:
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(OUnitExtensionKt.vdp(r1, 20), OUnitExtensionKt.vdp(r1, 20));
        r0.gravity = 16;
        r0.setMarginStart(OUnitExtensionKt.vdp(r1, 4));
        Unit r9 = Unit.INSTANCE;
        r8.addView(r5, r0);
        return r1;
    }

    public final OTextView getStartTitleView() {
        OTextView r0 = this.startTitleView;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        return null;
    L6:
        return r0;
    }

    public final OTextView getStartSubtitleView() {
        OTextView r0 = this.startSubtitleView;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        return null;
    L6:
        return r0;
    }

    public final OTextView getCenterTitleView() {
        OTextView r0 = this.centerTitleView;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        return null;
    L6:
        return r0;
    }

    public final OTextView getCenterSubtitleView() {
        OTextView r0 = this.centerSubtitleView;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        return null;
    L6:
        return r0;
    }

    public final void setStartTitle(String r4) {
        OTextView r0 = this.startTitleView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r0 = null;
    L5:
        r0.setText(r4);
        OTextView r5 = this.startTitleView;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L9:
        resetTitleVis(r1);
        return;
    L8:
        r1 = r5;
        goto L9
    }

    public final void setStartTitle(int r2) {
        setStartTitle(getResources().getString(r2));
    }

    public final void setStartTitleColor(int r2) {
        OTextView r0 = this.startTitleView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r0 = null;
    L5:
        r0.setTextColor(r2);
        this.currentMaskMaterialConfig = this.maskMaterial.invoke(Boolean.valueOf(isDarkTheme()));
    }

    public final void setStartSubtitle(String r4) {
        OTextView r0 = this.startSubtitleView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r0 = null;
    L5:
        r0.setText(r4);
        OTextView r5 = this.startSubtitleView;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L9:
        resetTitleVis(r1);
        return;
    L8:
        r1 = r5;
        goto L9
    }

    public final void setStartSubtitle(int r2) {
        setStartSubtitle(getResources().getString(r2));
    }

    public final void setStartSubTitleColor(int r1) {
        OTextView r0 = this.startSubtitleView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    public final void setCenterTitle(String r4) {
        OTextView r0 = this.centerTitleView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r0 = null;
    L5:
        r0.setText(r4);
        OTextView r5 = this.centerTitleView;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L9:
        resetTitleVis(r1);
        return;
    L8:
        r1 = r5;
        goto L9
    }

    public final void setCenterTitle(int r2) {
        setCenterTitle(getResources().getString(r2));
    }

    public final void setCenterTitleColor(int r2) {
        OTextView r0 = this.centerTitleView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r0 = null;
    L5:
        r0.setTextColor(r2);
        this.currentMaskMaterialConfig = this.maskMaterial.invoke(Boolean.valueOf(isDarkTheme()));
    }

    public final void setCenterSubtitle(String r4) {
        OTextView r0 = this.centerSubtitleView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r0 = null;
    L5:
        r0.setText(r4);
        OTextView r5 = this.centerSubtitleView;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L9:
        resetTitleVis(r1);
        return;
    L8:
        r1 = r5;
        goto L9
    }

    public final void setCenterSubTitle(int r2) {
        setCenterSubtitle(getResources().getString(r2));
    }

    public final void setCenterSubTitleColor(int r1) {
        OTextView r0 = this.centerSubtitleView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    private final void resetTitleVis(TextView r4) {
        CharSequence r0 = r4.getText();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if ((!r2) == true) goto L13;
        r1 = 8;
    L13:
        r4.setVisibility(r1);
        requestLayout();
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    @Deprecated(message = "not support set mask background")
    public final void setMaskBackground(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        showMask(true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.materialSrcType == (-1)) goto L6;
        MaterialOwnerKt.dispatchBackdropSrcType(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), this.materialSrcType);
        return;
    }

    private final void setDefaultBackdropTargetForChild() {
        View r0 = getDefaultTargetView();
        getStartButtonGroup().setBackdropTarget(r0);
        getCenterButtonGroup().setBackdropTarget(r0);
        getEndButtonGroup().setBackdropTarget(r0);
        getEndSubButtonGroup().setBackdropTarget(r0);
    }

    public final void setMaskBlurRadius(float r6) {
        MaterialConfig r0 = this.currentMaskMaterialConfig;
        MaterialConfig r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r0 = null;
    L5:
        BlurConfig r2 = r0.getBlurConfig();
        if (r2 == null) goto L9;
        r2.setBlurRadius(r6);
    L9:
        OFloatingWindowHelper r3 = this.floatingWindowHelper;
        OFloatingTitleBar r4 = this;
        MaterialConfig r5 = this.currentMaskMaterialConfig;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L13:
        r3.applyBlur(r4, r1, this.materialSrcType);
        if (r6 != 0.0f) goto L16;
        boolean r7 = true;
    L17:
        showMask(!r7);
        return;
    L16:
        r7 = false;
        goto L17
    L12:
        r1 = r5;
        goto L13
    }

    public final void showMask(boolean r1) {
        View r0 = this.materialMask;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("materialMask");
        r0 = null;
    L5:
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
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
    public void applyContentMaterial(boolean r4) {
        MaterialOwnerKt.dispatchApplyContentMaterial(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), r4);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(View r4) {
        this.backdropTarget = r4;
        if (r4 != null) goto L6;
        OFloatingTitleBar r5 = this;
        OMaterialExtBaseKt.setMaterialBackdropTarget(r5, r5);
        setDefaultBackdropTargetForChild();
        return;
    L6:
        OMaterialExtBaseKt.setMaterialBackdropTarget(this, r4);
        MaterialOwnerKt.dispatchBackdropTarget(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), r4);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r4) {
        if (this.isBackdropView == r4) goto L12;
        this.isBackdropView = r4;
        if (this.materialSrcType == (-1)) goto L8;
        return;
    L8:
        if (this.floatingWindowHelper.isFloatingType() == true) goto L10;
        OMaterialExtBaseKt.updateMaterialBackdropTargetType(this, r4);
    L10:
        MaterialOwnerKt.dispatchBackdropTargetType(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), r4);
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r4) {
        this.materialSrcType = r4;
        MaterialOwnerKt.dispatchBackdropSrcType(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), r4);
    }

    private final int getCenterTitleGap() {
        if (this.mIsLargeFont == false) goto L6;
        return this.centerTitleGapLargeFontPx;
    L6:
        return this.centerTitleGapPx;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r21, int r22) {
        this.isCenterOverflow = false;
        OTextView r2 = this.centerTitleView;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r2 = null;
    L5:
        r2.setMaxWidth(Integer.MAX_VALUE);
        OTextView r3 = this.centerSubtitleView;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r3 = null;
    L8:
        r3.setMaxWidth(Integer.MAX_VALUE);
        OTextView r4 = this.startTitleView;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r4 = null;
    L11:
        r4.setMaxWidth(Integer.MAX_VALUE);
        OTextView r5 = this.startSubtitleView;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r5 = null;
    L14:
        r5.setMaxWidth(Integer.MAX_VALUE);
        super.onMeasure(r21, r22);
        boolean r6 = isStartVis();
        boolean r7 = isCenterVis();
        boolean r9 = isEndVis();
        int r10 = getMeasuredWidth();
        View r11 = this.titleBarContainer;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r11 = null;
    L17:
        int r12 = r11.getPaddingLeft();
        View r13 = this.titleBarContainer;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r13 = null;
    L20:
        int r14 = r13.getPaddingRight();
        int r15 = getCenterTitleGap();
        if (r7 == false) goto L26;
        int r16 = r10 / 2;
        FrameLayout r8 = this.centerContainer;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r8 = null;
    L25:
        int r1 = (r16 - (r8.getMeasuredWidth() / 2)) - r15;
    L33:
        if (r6 == false) goto L38;
        int r17 = (r10 / 2) - r12;
        FrameLayout r18 = this.startContainer;
        if (r18 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r18 = null;
    L37:
        int r19 = (r17 - r18.getMeasuredWidth()) - r15;
    L39:
        if (r9 == false) goto L44;
        int r110 = (r10 / 2) - r14;
        LinearLayout r20 = this.endContainer;
        if (r20 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r20 = null;
    L43:
        int r111 = (r110 - r20.getMeasuredWidth()) - r15;
    L45:
        boolean r23 = true;
        if (r6 == false) goto L59;
        int r24 = Math.max(0, r1 - r12);
        FrameLayout r25 = this.startContainer;
        if (r25 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r25 = null;
    L51:
        if (r25.getMeasuredWidth() <= r24) goto L59;
        OTextView r26 = this.startTitleView;
        if (r26 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r26 = null;
    L55:
        r26.setMaxWidth(r24);
        OTextView r27 = this.startSubtitleView;
        if (r27 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r27 = null;
    L58:
        r27.setMaxWidth(r24);
        boolean r28 = true;
    L60:
        if (r7 == false) goto L103;
        int r29 = Math.max(0, Math.min(r19 * 2, r111 * 2));
        FrameLayout r30 = this.centerContainer;
        if (r30 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r30 = null;
    L65:
        if (r30.getMeasuredWidth() <= r29) goto L103;
        this.isCenterOverflow = true;
        int r31 = r19 + r111;
        OTextView r32 = this.centerTitleView;
        if (r32 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r32 = null;
    L69:
        r32.setMaxWidth(r31);
        OTextView r33 = this.centerTitleView;
        if (r33 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException(r3);
        r33 = null;
    L73:
        if (r33.getMeasuredWidth() <= r29) goto L78;
        OTextView r34 = this.centerSubtitleView;
        if (r34 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r34 = null;
    L77:
        r34.setMaxWidth(r31);
    L82:
        FrameLayout r35 = this.centerCustomContainer;
        if (r35 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r35 = null;
    L86:
        if (r35.getVisibility() != 0) goto L88;
        boolean r36 = true;
    L89:
        if (r36 == false) goto L104;
        FrameLayout r37 = this.centerCustomContainer;
        if (r37 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r37 = null;
    L93:
        ViewGroup.LayoutParams r38 = r37.getLayoutParams();
        FrameLayout r39 = this.centerCustomContainer;
        if (r39 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r39 = null;
    L97:
        if (r39.getMeasuredWidth() <= r31) goto L104;
        r38.width = r31;
        FrameLayout r40 = this.centerCustomContainer;
        if (r40 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        FrameLayout r41 = null;
    L102:
        r41.setLayoutParams(r38);
        goto L104
    L101:
        r41 = r40;
    L104:
        if (r23 == false) goto L107;
        super.onMeasure(r21, r22);
        return;
    L107:
        return;
    L88:
        r36 = false;
        goto L89
    L78:
        OTextView r42 = this.centerSubtitleView;
        if (r42 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException(r6);
        r42 = null;
    L81:
        r42.setMaxWidth(r29);
    L103:
        r23 = r28;
    L59:
        r28 = false;
        goto L60
    L44:
        r111 = ((r10 / 2) - r14) - this.centerTitleHorizontalPaddingPx;
        goto L45
    L38:
        r19 = ((r10 / 2) - r12) - this.centerTitleHorizontalPaddingPx;
        goto L39
    L26:
        if (r9 == false) goto L31;
        int r43 = r10 - r14;
        LinearLayout r44 = this.endContainer;
        if (r44 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r44 = null;
    L30:
        r1 = (r43 - r44.getMeasuredWidth()) - r15;
        goto L33
    L31:
        r1 = r10 - r14;
        goto L33
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        super.onLayout(r7, r8, r9, r10, r11);
        if (isCenterVis() == true) goto L5;
        return;
    L5:
        int r12 = getMeasuredWidth();
        View r13 = this.titleBarContainer;
        FrameLayout r14 = null;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r13 = null;
    L8:
        int r15 = r13.getPaddingLeft();
        View r16 = this.titleBarContainer;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r16 = null;
    L11:
        int r17 = r16.getPaddingRight();
        int r0 = getCenterTitleGap();
        if (isStartVis() == false) goto L17;
        FrameLayout r1 = this.startContainer;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r1 = null;
    L16:
        r15 = (r15 + r1.getMeasuredWidth()) + r0;
    L17:
        int r18 = r12 - r17;
        if (isEndVis() == false) goto L23;
        LinearLayout r2 = this.endContainer;
        if (r2 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r2 = null;
    L22:
        r18 = (r18 - r2.getMeasuredWidth()) - r0;
    L23:
        FrameLayout r3 = this.centerContainer;
        if (r3 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r3 = null;
    L26:
        int r4 = r3.getMeasuredWidth();
        FrameLayout r5 = this.centerContainer;
        if (r5 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r5 = null;
    L29:
        int r6 = r5.getMeasuredHeight();
        int r19 = (r12 - r4) / 2;
        int r20 = r19 + r4;
        int r21 = r18 - r15;
        if (r4 <= r21) goto L33;
        r19 = r15;
    L32:
        r20 = r18;
    L38:
        if (this.isCenterOverflow == false) goto L40;
        int r22 = (r21 - r4) / 2;
        r19 = r15 + r22;
        r20 = r18 - r22;
    L40:
        View r23 = this.titleBarContainer;
        if (r23 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r23 = null;
    L43:
        int r24 = r23.getPaddingTop();
        View r110 = this.titleBarContainer;
        if (r110 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r110 = null;
    L46:
        int r111 = r110.getMeasuredHeight();
        View r25 = this.titleBarContainer;
        if (r25 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r25 = null;
    L49:
        int r26 = r24 + ((((r111 - r25.getPaddingBottom()) - r24) - r6) / 2);
        int r27 = r6 + r26;
        FrameLayout r28 = this.centerContainer;
        if (r28 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L53:
        r14.layout(r19, r26, r20, r27);
        return;
    L52:
        r14 = r28;
        goto L53
    L33:
        if (r19 >= r15) goto L35;
        r20 = r15 + r4;
        r19 = r15;
        goto L38
    L35:
        if (r20 <= r18) goto L38;
        r19 = r18 - r4;
        goto L32
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        if (r1 == null) goto L6;
        Intrinsics.checkNotNull(r1);
        this.mIsLargeFont = ViewUtil.isInLargeFont(r1.fontScale);
    L6:
        refreshDimensionCache();
    }

    private final void refreshDimensionCache() {
        OFloatingTitleBar r0 = this;
        this.centerTitleHorizontalPaddingPx = OUnitExtensionKt.vdp(r0, 8);
        this.centerTitleGapPx = OUnitExtensionKt.vdp(r0, 12);
        this.centerTitleGapLargeFontPx = OUnitExtensionKt.vdp(r0, 4);
    }

    private final boolean isStartVis() {
        if (getStartButtonGroup().getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L27;
        OTextView r1 = this.startTitleView;
        OTextView r3 = null;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r1 = null;
    L11:
        if (r1.getVisibility() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L28;
        OTextView r4 = this.startSubtitleView;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L20:
        if (r3.getVisibility() != 0) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == false) goto L26;
        return true;
    L26:
        return false;
    L22:
        r5 = false;
        goto L23
    L18:
        r3 = r4;
        goto L20
    L28:
        return true;
    L13:
        r2 = false;
        goto L14
    L27:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean isCenterVis() {
        if (getCenterButtonGroup().getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L35;
        OTextView r1 = this.centerTitleView;
        FrameLayout r3 = null;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r1 = null;
    L11:
        if (r1.getVisibility() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L36;
        OTextView r4 = this.centerSubtitleView;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r4 = null;
    L19:
        if (r4.getVisibility() != 0) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L37;
        FrameLayout r6 = this.centerCustomContainer;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L28:
        if (r3.getVisibility() != 0) goto L30;
        boolean r7 = true;
    L31:
        if (r7 == false) goto L34;
        return true;
    L34:
        return false;
    L30:
        r7 = false;
        goto L31
    L26:
        r3 = r6;
        goto L28
    L37:
        return true;
    L21:
        r5 = false;
        goto L22
    L36:
        return true;
    L13:
        r2 = false;
        goto L14
    L35:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean isEndVis() {
        if (getEndButtonGroup().getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (getEndSubButtonGroup().getVisibility() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        return true;
    L14:
        return false;
    L10:
        r3 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    private final boolean isDarkTheme() {
        OTextView r0 = this.startTitleView;
        OTextView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r0 = null;
    L5:
        boolean r3 = false;
        if (r0.getVisibility() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L15;
        OTextView r5 = this.startTitleView;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L14:
        int r6 = r2.getTextColors().getDefaultColor();
    L28:
        return !OPalette.isDarkColor(r6);
    L13:
        r2 = r5;
        goto L14
    L15:
        OTextView r4 = this.centerTitleView;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r4 = null;
    L19:
        if (r4.getVisibility() != 0) goto L21;
        r3 = true;
    L21:
        if (r3 == false) goto L30;
        OTextView r7 = this.centerTitleView;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L26:
        r6 = r2.getTextColors().getDefaultColor();
        goto L28
    L25:
        r2 = r7;
        goto L26
    L30:
        return ViewUtilKt.isDarkMode(this);
    L8:
        r1 = false;
        goto L9
    }
}
