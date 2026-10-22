package com.obric.oui.coachmark;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.icu.text.PluralRules;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.slice.core.SliceHints;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.popover.v2.OPopoverHelperEx;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OCoachmark.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmark;", "", "()V", "COACHMARK_CONTENT_SHADOW_STYLE_RES", "", "DEFAULT_ACTION_STYLE", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "DEFAULT_AUTO_DISMISS_MILLIS", "", "DEFAULT_MARGIN_DP", "SIDE_BOTTOM_SAFE_MARGIN_DP", "SIDE_HORIZONTAL_SAFE_MARGIN_DP", "TAG", "", "Builder", "Type", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCoachmark {
    private static final int COACHMARK_CONTENT_SHADOW_STYLE_RES = 0;
    private static final OCoachmarkView.ActionStyle DEFAULT_ACTION_STYLE = null;
    private static final long DEFAULT_AUTO_DISMISS_MILLIS = 0;
    private static final int DEFAULT_MARGIN_DP = 8;
    public static final OCoachmark INSTANCE = null;
    private static final int SIDE_BOTTOM_SAFE_MARGIN_DP = 48;
    private static final int SIDE_HORIZONTAL_SAFE_MARGIN_DP = 8;
    private static final String TAG = "OCoachmark";

    /* JADX INFO: compiled from: OCoachmark.kt */
    @Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\u0018\u00002\u00020\u0001:\u0001xB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00100\u001a\u000201J(\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH\u0002J \u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0002J\u001a\u0010=\u001a\u00020#2\b\u0010>\u001a\u0004\u0018\u0001012\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020B2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0010\u0010C\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0006J\u0010\u0010F\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\nJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\fJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\bJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u000fJ\u000e\u0010N\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\fJ&\u0010O\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\f2\u0006\u0010R\u001a\u00020\f2\u0006\u0010S\u001a\u00020\f2\u0006\u0010T\u001a\u00020\fJ\u000e\u0010U\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0015J/\u0010W\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010ZJ\u000e\u0010[\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020\bJ\u000e\u0010]\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010^\u001a\u00020\u00002\b\u0010_\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010`\u001a\u00020\u00002\b\u0010_\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\fJ\u000e\u0010c\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\fJ\u001a\u0010d\u001a\u00020\u00002\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"J\u001a\u0010f\u001a\u00020\u00002\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"J\u0014\u0010g\u001a\u00020\u00002\f\u0010e\u001a\b\u0012\u0004\u0012\u00020#0%J\u001a\u0010h\u001a\u00020\u00002\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"J\u001a\u0010i\u001a\u00020\u00002\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"J\u0014\u0010j\u001a\u00020\u00002\f\u0010e\u001a\b\u0012\u0004\u0012\u00020#0%J\u0010\u0010k\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\nJ\u0010\u0010l\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\nJ\u0010\u0010m\u001a\u00020\u00002\b\b\u0001\u0010n\u001a\u00020\fJ\u0010\u0010o\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\nJ\u000e\u0010p\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/J\u0010\u0010q\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u000e\u0010r\u001a\u0002012\u0006\u0010s\u001a\u00020\u0015J\u0018\u0010t\u001a\u00020#2\u0006\u0010s\u001a\u00020\u00152\u0006\u0010>\u001a\u000201H\u0002J \u0010u\u001a\u00020#2\u0006\u0010s\u001a\u00020\u00152\u0006\u0010>\u001a\u0002012\u0006\u0010v\u001a\u00020\fH\u0002J\u0010\u0010w\u001a\u00020#2\u0006\u0010s\u001a\u00020\u0015H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmark$Builder;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "actionStyle", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "actionStyleExplicitlySet", "", "actionText", "", "arrowOffset", "", "Ljava/lang/Integer;", "autoDismissMillis", "", "closable", "coachmarkStyleRes", "contentPadding", "Lcom/obric/oui/coachmark/OCoachmark$Builder$ContentPadding;", "customContentView", "Landroid/view/View;", "desEllipsize", "Landroid/text/TextUtils$TruncateAt;", "desMaxLines", "description", "dismissOnActionClick", "gravity", "heroImage", "Landroid/graphics/drawable/Drawable;", "icon", "margin", "maxWidth", "onActionClick", "Lkotlin/Function1;", "", "onDismiss", "Lkotlin/Function0;", "onDismissClick", "onPrimaryActionClick", "onSecondaryActionClick", "onShow", "primaryButtonText", "secondaryButtonText", "showArrow", "title", "type", "Lcom/obric/oui/coachmark/OCoachmark$Type;", IndexDatabaseHelper.MetaColumns.BUILD, "Lcom/obric/oui/popover/v2/OPopover;", "coerceWithinBounds", "value", "minBound", "maxBound", "maxFallbackBound", "createCoachmarkView", "Lcom/obric/oui/coachmark/OCoachmarkView;", "primaryActionClickRelay", "Landroid/view/View$OnClickListener;", "secondaryActionClickRelay", "dismissClickRelay", "dismissPopoverAfterClick", "popover", "source", "", "resolveArrowPositionForGravity", "Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "resolveHorizontalGravity", "setActionStyle", "style", "setActionText", "text", "setArrowOffset", "offsetPx", "setArrowVisible", "visible", "setAutoDismissMillis", SliceHints.SUBTYPE_MILLIS, "setClosable", "setContentPadding", "paddingPx", "startPx", "topPx", "endPx", "bottomPx", "setContentView", "view", "setDescription", "maxLines", "ellipsize", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/text/TextUtils$TruncateAt;)Lcom/obric/oui/coachmark/OCoachmark$Builder;", "setDismissOnActionClick", IndexDatabaseHelper.IndexColumns.ENABLED, "setGravity", "setHeroImage", "drawable", "setIcon", "setMargin", "px", "setMaxWidth", "setOnActionClickListener", "listener", "setOnDismissClickListener", "setOnDismissListener", "setOnPrimaryActionClickListener", "setOnSecondaryActionClickListener", "setOnShowListener", "setPrimaryButtonText", "setSecondaryButtonText", "setStyle", "styleRes", "setTitle", "setType", "shouldAlignSideToAnchorCenter", "show", "anchor", "showPopover", "showSideAlignedPopover", "widthMeasureSpec", "validateAnchor", "ContentPadding", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private OCoachmarkView.ActionStyle actionStyle;
        private boolean actionStyleExplicitlySet;
        private CharSequence actionText;
        private final Activity activity;
        private Integer arrowOffset;
        private long autoDismissMillis;
        private boolean closable;
        private int coachmarkStyleRes;
        private ContentPadding contentPadding;
        private View customContentView;
        private TextUtils.TruncateAt desEllipsize;
        private Integer desMaxLines;
        private CharSequence description;
        private boolean dismissOnActionClick;
        private int gravity;
        private Drawable heroImage;
        private Drawable icon;
        private int margin;
        private Integer maxWidth;
        private Function1<? super View, Unit> onActionClick;
        private Function0<Unit> onDismiss;
        private Function1<? super View, Unit> onDismissClick;
        private Function1<? super View, Unit> onPrimaryActionClick;
        private Function1<? super View, Unit> onSecondaryActionClick;
        private Function0<Unit> onShow;
        private CharSequence primaryButtonText;
        private CharSequence secondaryButtonText;
        private boolean showArrow;
        private CharSequence title;
        private Type type;

        /* JADX INFO: compiled from: OCoachmark.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmark$Builder$ContentPadding;", "", "startPx", "", "topPx", "endPx", "bottomPx", "(IIII)V", "getBottomPx", "()I", "getEndPx", "getStartPx", "getTopPx", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        private static final class ContentPadding {
            private final int bottomPx;
            private final int endPx;
            private final int startPx;
            private final int topPx;

            public static /* synthetic */ ContentPadding copy$default(ContentPadding r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r1 = r0.startPx;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r2 = r0.topPx;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r3 = r0.endPx;
            L12:
                if ((r5 & 8) == 0) goto L15;
                r4 = r0.bottomPx;
            L15:
                return r0.copy(r1, r2, r3, r4);
            }

            public final int component1() {
                return this.startPx;
            }

            public final int component2() {
                return this.topPx;
            }

            public final int component3() {
                return this.endPx;
            }

            public final int component4() {
                return this.bottomPx;
            }

            public final ContentPadding copy(int r1, int r2, int r3, int r4) {
                return new ContentPadding(r1, r2, r3, r4);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof ContentPadding) == true) goto L8;
                return false;
            L8:
                ContentPadding r6 = (ContentPadding) r5;
                if (this.startPx == r6.startPx) goto L12;
                return false;
            L12:
                if (this.topPx == r6.topPx) goto L15;
                return false;
            L15:
                if (this.endPx == r6.endPx) goto L18;
                return false;
            L18:
                if (this.bottomPx == r6.bottomPx) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                return (((((Integer.hashCode(this.startPx) * 31) + Integer.hashCode(this.topPx)) * 31) + Integer.hashCode(this.endPx)) * 31) + Integer.hashCode(this.bottomPx);
            }

            public String toString() {
                return "ContentPadding(startPx=" + this.startPx + ", topPx=" + this.topPx + ", endPx=" + this.endPx + ", bottomPx=" + this.bottomPx + ')';
            }

            public ContentPadding(int r1, int r2, int r3, int r4) {
                this.startPx = r1;
                this.topPx = r2;
                this.endPx = r3;
                this.bottomPx = r4;
            }

            public final int getStartPx() {
                return this.startPx;
            }

            public final int getTopPx() {
                return this.topPx;
            }

            public final int getEndPx() {
                return this.endPx;
            }

            public final int getBottomPx() {
                return this.bottomPx;
            }
        }

        /* JADX INFO: compiled from: OCoachmark.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[Type.values().length];
                r0[Type.CARD.ordinal()] = 1;
                r0[Type.PILL.ordinal()] = 2;
                $EnumSwitchMapping$0 = r0;
            }
        }

        public static /* synthetic */ void $r8$lambda$6DIV4gcUFzmOqOq8Au5ynFSosWE(Function1 r0, Builder r1, Ref.ObjectRef r2, View r3) {
            m1082build$lambda27(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$IeGe8kWsyDJe9e18blBUF-5d2Fc, reason: not valid java name */
        public static /* synthetic */ void m1079$r8$lambda$IeGe8kWsyDJe9e18blBUF5d2Fc(Builder r0, Ref.ObjectRef r1, View r2) {
            m1084build$lambda29(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$QyyVMpNE6CqQ-FXDVxKswjuqd0o, reason: not valid java name */
        public static /* synthetic */ void m1080$r8$lambda$QyyVMpNE6CqQFXDVxKswjuqd0o(Ref.ObjectRef r0) {
            m1085build$lambda30(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$pSUr2-QojgSpOUjB-8ZJq5GturY, reason: not valid java name */
        public static /* synthetic */ void m1081$r8$lambda$pSUr2QojgSpOUjB8ZJq5GturY(Builder r0, Ref.ObjectRef r1, View r2) {
            m1083build$lambda28(r0, r1, r2);
        }

        private final int resolveHorizontalGravity(int r5) {
            boolean r1 = true;
            if ((r5 & GravityCompat.START) != 8388611) goto L5;
            boolean r4 = true;
        L7:
            if ((r5 & GravityCompat.END) == 8388613) goto L10;
            r1 = false;
        L10:
            if (r4 == false) goto L12;
            return 3;
        L12:
            if (r1 == false) goto L15;
            return 5;
        L15:
            return r5 & 7;
        L5:
            r4 = false;
            goto L7
        }

        public final Builder setDescription(CharSequence r7) {
            return setDescription$default(this, r7, null, null, 6, null);
        }

        public final Builder setDescription(CharSequence r7, Integer r8) {
            return setDescription$default(this, r7, r8, null, 4, null);
        }

        public Builder(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            this.activity = r2;
            this.type = Type.PILL;
            this.gravity = 80;
            this.margin = OUnitExtensionKt.cdp(r2, 8);
            this.dismissOnActionClick = true;
            this.showArrow = true;
            this.coachmarkStyleRes = R.style.OStyleV2_OCoachmarkView_DayNight;
        }

        public static final /* synthetic */ long access$getAutoDismissMillis$p(Builder r2) {
            return r2.autoDismissMillis;
        }

        public static final /* synthetic */ Function0 access$getOnDismiss$p(Builder r0) {
            return r0.onDismiss;
        }

        public static final /* synthetic */ Function0 access$getOnShow$p(Builder r0) {
            return r0.onShow;
        }

        public final Builder setType(Type r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.type = r2;
            return this;
        }

        public final Builder setGravity(int r2) {
            this.gravity = r2;
            return this;
        }

        public final Builder setMargin(int r2) {
            this.margin = r2;
            return this;
        }

        public final Builder setMaxWidth(int r2) {
            this.maxWidth = Integer.valueOf(r2);
            return this;
        }

        public final Builder setContentPadding(int r2) {
            this.contentPadding = new ContentPadding(r2, r2, r2, r2);
            return this;
        }

        public final Builder setContentPadding(int r2, int r3, int r4, int r5) {
            this.contentPadding = new ContentPadding(r2, r3, r4, r5);
            return this;
        }

        public final Builder setAutoDismissMillis(long r2) {
            this.autoDismissMillis = r2;
            return this;
        }

        public final Builder setDismissOnActionClick(boolean r2) {
            this.dismissOnActionClick = r2;
            return this;
        }

        public final Builder setTitle(CharSequence r2) {
            this.title = r2;
            return this;
        }

        public static /* synthetic */ Builder setDescription$default(Builder r1, CharSequence r2, Integer r3, TextUtils.TruncateAt r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L9;
            r4 = null;
        L9:
            return r1.setDescription(r2, r3, r4);
        }

        public final Builder setDescription(CharSequence r2, Integer r3, TextUtils.TruncateAt r4) {
            this.description = r2;
            this.desMaxLines = r3;
            this.desEllipsize = r4;
            return this;
        }

        public final Builder setActionText(CharSequence r2) {
            this.actionText = r2;
            return this;
        }

        public final Builder setPrimaryButtonText(CharSequence r2) {
            this.primaryButtonText = r2;
            return this;
        }

        public final Builder setSecondaryButtonText(CharSequence r2) {
            this.secondaryButtonText = r2;
            return this;
        }

        public final Builder setIcon(Drawable r2) {
            this.icon = r2;
            return this;
        }

        public final Builder setHeroImage(Drawable r2) {
            this.heroImage = r2;
            return this;
        }

        public final Builder setContentView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.customContentView = r2;
            return this;
        }

        public final Builder setClosable(boolean r2) {
            this.closable = r2;
            return this;
        }

        public final Builder setArrowVisible(boolean r2) {
            this.showArrow = r2;
            return this;
        }

        public final Builder setArrowOffset(int r2) {
            this.arrowOffset = Integer.valueOf(r2);
            return this;
        }

        public final Builder setActionStyle(OCoachmarkView.ActionStyle r2) {
            Intrinsics.checkNotNullParameter(r2, "style");
            this.actionStyle = r2;
            this.actionStyleExplicitlySet = true;
            return this;
        }

        public final Builder setStyle(int r2) {
            this.coachmarkStyleRes = r2;
            return this;
        }

        public final Builder setOnActionClickListener(Function1<? super View, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.onActionClick = r2;
            return this;
        }

        public final Builder setOnPrimaryActionClickListener(Function1<? super View, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.onPrimaryActionClick = r2;
            return this;
        }

        public final Builder setOnSecondaryActionClickListener(Function1<? super View, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.onSecondaryActionClick = r2;
            return this;
        }

        public final Builder setOnDismissClickListener(Function1<? super View, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.onDismissClick = r2;
            return this;
        }

        public final Builder setOnShowListener(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.onShow = r2;
            return this;
        }

        public final Builder setOnDismissListener(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.onDismiss = r2;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v17, types: [T, com.obric.oui.popover.v2.OPopover] */
        public final OPopover build() {
            final Ref.ObjectRef r0 = new Ref.ObjectRef();
            final Function1<? super View, Unit> r1 = this.onPrimaryActionClick;
            if (r1 != null) goto L5;
            r1 = this.onActionClick;
        L5:
            OCoachmarkView r2 = createCoachmarkView(new OCoachmark$Builder$$ExternalSyntheticLambda0(r1, this, r0), new OCoachmark$Builder$$ExternalSyntheticLambda1(this, r0), new OCoachmark$Builder$$ExternalSyntheticLambda2(this, r0));
            r2.setPopWindowMode(true);
            OPopover.Builder r3 = new OPopover.Builder(this.activity).setView(r2).setHideVirtualKey(false).setPopoverShadowEnabled(false).setShadowStyle(OCoachmark.access$getCOACHMARK_CONTENT_SHADOW_STYLE_RES$p()).transparentBg(true).setEnableBubbleMaterial(false);
            long r4 = this.autoDismissMillis;
            if (r4 <= 0) goto L8;
            r3.setAutoDismissDelayMillis(r4);
        L8:
            final Runnable r5 = new OCoachmark$Builder$$ExternalSyntheticLambda3(r0);
            r3.setOnShowListener(new OCoachmark$Builder$build$1(this, r0, r5));
            r3.setOnDismissListener(new OCoachmark$Builder$build$2(r0, r5, this));
            ?? r6 = r3.build();
            r0.element = r6;
            this.customContentView = null;
            return r6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: build$lambda-27, reason: not valid java name */
        private static final void m1082build$lambda27(Function1 r1, Builder r2, Ref.ObjectRef r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "$popoverRef");
            if (r1 == null) goto L6;
            Intrinsics.checkNotNullExpressionValue(r4, "clickedView");
            r1.invoke(r4);
        L6:
            r2.dismissPopoverAfterClick((OPopover) r3.element, "primary action");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: build$lambda-28, reason: not valid java name */
        private static final void m1083build$lambda28(Builder r2, Ref.ObjectRef r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "$popoverRef");
            Function1<? super View, Unit> r0 = r2.onSecondaryActionClick;
            if (r0 == null) goto L6;
            Intrinsics.checkNotNullExpressionValue(r4, "clickedView");
            r0.invoke(r4);
        L6:
            r2.dismissPopoverAfterClick((OPopover) r3.element, "secondary action");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: build$lambda-29, reason: not valid java name */
        private static final void m1084build$lambda29(Builder r2, Ref.ObjectRef r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "$popoverRef");
            Function1<? super View, Unit> r0 = r2.onDismissClick;
            if (r0 == null) goto L6;
            Intrinsics.checkNotNullExpressionValue(r4, "clickedView");
            r0.invoke(r4);
        L6:
            r2.dismissPopoverAfterClick((OPopover) r3.element, "dismiss");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: build$lambda-30, reason: not valid java name */
        private static final void m1085build$lambda30(Ref.ObjectRef r1) {
            Intrinsics.checkNotNullParameter(r1, "$popoverRef");
            OPopover r2 = (OPopover) r1.element;
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.isShowing() == false) goto L10;
            r2.dismiss();
            return;
        }

        public final OPopover show(View r4) {
            Intrinsics.checkNotNullParameter(r4, "anchor");
            validateAnchor(r4);
            OPopover r1 = build();
            showPopover(r4, r1);     // Catch: Exception -> L8
            if (r1.isShowing() == false) goto L6;
            return r1;
        L6:
            String r5 = Intrinsics.stringPlus("show failed: popover is not showing. anchor: ", r4.getClass().getSimpleName());     // Catch: Exception -> L8
            L.e(OCoachmark.TAG, r5);     // Catch: Exception -> L8
            throw new IllegalStateException(r5);     // Catch: Exception -> L8
        L8:
            e = move-exception;
            Exception r6 = e;
            L.e(OCoachmark.TAG, "show failed, type: " + this.type + ", gravity: " + this.gravity + ", margin: " + this.margin, r6);
            throw new IllegalStateException("Failed to show coachmark.", r6);
        }

        private final void showPopover(View r14, OPopover r15) {
            Integer r0 = this.maxWidth;
            if (r0 != null) goto L5;
            int r1 = OUnitExtensionKt.vdp(r14, 320);
        L6:
            int r9 = View.MeasureSpec.makeMeasureSpec(r1, Integer.MIN_VALUE);
            if (shouldAlignSideToAnchorCenter(this.gravity) == false) goto L10;
            showSideAlignedPopover(r14, r15, r9);
            return;
        L10:
            OPopoverHelperEx.showPopoverSmartly$default(OPopoverHelperEx.INSTANCE, r15, r14, this.gravity, false, this.margin, false, r9, 0, 160, null);
            return;
        L5:
            r1 = r0.intValue();
            goto L6
        }

        private final boolean shouldAlignSideToAnchorCenter(int r4) {
            int r0 = r4 & 112;
            int r3 = resolveHorizontalGravity(r4);
            if (r3 != 3) goto L5;
        L8:
            boolean r5 = true;
        L9:
            if (r5 == true) goto L11;
            return false;
        L11:
            if (r0 != 48) goto L13;
            return false;
        L13:
            if (r0 != 80) goto L15;
            return false;
        L15:
            return true;
        L5:
            if (r3 == 5) goto L8;
            r5 = false;
            goto L9
        }

        private final void showSideAlignedPopover(View r19, OPopover r20, int r21) {
            if (r19.getWidth() <= 0) goto L5;
            int r3 = r19.getWidth();
        L7:
            if (r19.getHeight() <= 0) goto L9;
            int r4 = r19.getHeight();
        L10:
            int[] r6 = new int[2];
            r19.getLocationOnScreen(r6);
            int r8 = r6[0];
            int r7 = r6[1];
            int r9 = r8 + r3;
            float r10 = r7 + (r4 / 2.0f);
            r20.getContentView().measure(r21, 0);
            int r11 = r20.getContentView().getMeasuredWidth();
            int r13 = r20.getContentView().getMeasuredHeight();
            if (r11 <= 0) goto L22;
            if (r13 <= 0) goto L22;
            int r15 = resolveHorizontalGravity(this.gravity);
            if (r15 != 3) goto L16;
            int r12 = (r8 - r11) - this.margin;
        L20:
            int r5 = MathKt.roundToInt(r10 - (r13 / 2.0f));
            Context r14 = r19.getContext();
            Intrinsics.checkNotNullExpressionValue(r14, "anchor.context");
            int r16 = OUnitExtensionKt.getRealScreenWidth(r14);
            Context r17 = r19.getContext();
            Intrinsics.checkNotNullExpressionValue(r17, "anchor.context");
            int r18 = OUnitExtensionKt.getRealScreenHeight(r17);
            int r110 = OUnitExtensionKt.vdp(r19, 8);
            int r22 = r16 - r11;
            int r111 = r22 - OUnitExtensionKt.vdp(r19, 8);
            int r112 = OWindowConfigController.getStatusBarHeight(r19.getContext());
            int r113 = r18 - r13;
            int r114 = r113 - OUnitExtensionKt.vdp(r19, 48);
            int r23 = coerceWithinBounds(r12, r110, r111, r22);
            int r24 = coerceWithinBounds(r5, r112, r114, r113);
            r20.setGravity(r15 | 16);
            L.d(OCoachmark.TAG, "show side aligned coachmark. gravity=" + r15 + ", anchor=[" + r8 + ',' + r7 + ',' + r3 + ',' + r4 + "], popover=[" + r11 + ',' + r13 + "], position=[" + r23 + ',' + r24 + "], margin=" + this.margin);
            r20.showAtLocation(r19, 0, r23, r24);
            return;
        L16:
            if (r15 == 5) goto L18;
            r12 = ((r3 - r11) / 2) + r8;
            goto L20
        L18:
            r12 = r9 + this.margin;
        L22:
            String r0 = "side aligned show failed: invalid popover size. width=" + r11 + ", height=" + r13;
            L.e(OCoachmark.TAG, r0);
            throw new IllegalStateException(r0);
        L9:
            r4 = r19.getMeasuredHeight();
            goto L10
        L5:
            r3 = r19.getMeasuredWidth();
            goto L7
        }

        private final int coerceWithinBounds(int r1, int r2, int r3, int r4) {
            if (r3 < r2) goto L5;
            return RangesKt.coerceIn(r1, r2, r3);
        L5:
            return RangesKt.coerceIn(r1, 0, RangesKt.coerceAtLeast(r4, 0));
        }

        private final void dismissPopoverAfterClick(OPopover r3, String r4) {
            if (this.dismissOnActionClick == true) goto L5;
            return;
        L5:
            if (r3 != null) goto L11;
            L r2 = L.INSTANCE;
            if (r2.isBlocked(8) == true) goto L13;
            r2.getImpl().writeLog(OCoachmark.TAG, 8, "dismiss skipped after " + r4 + " click: popover reference missing.", null);
            return;
        L13:
            return;
        L11:
            r3.dismiss();
        }

        private final OCoachmarkView createCoachmarkView(View.OnClickListener r9, View.OnClickListener r10, View.OnClickListener r11) {
            if (this.type != Type.CARD) goto L11;
            if (this.closable == false) goto L11;
            L r0 = L.INSTANCE;
            if (r0.isBlocked(8) == true) goto L11;
            r0.getImpl().writeLog(OCoachmark.TAG, 8, "CARD style does not render close icon; closable has no visual effect.", null);
        L11:
            if (this.customContentView == null) goto L16;
            L r1 = L.INSTANCE;
            if (r1.isBlocked(8) == true) goto L16;
            r1.getImpl().writeLog(OCoachmark.TAG, 8, "custom content view is set; title, description, icon, hero, action, and close configs will be ignored.", null);
        L16:
            CharSequence r2 = this.primaryButtonText;
            if (r2 != null) goto L20;
            r2 = this.actionText;
        L20:
            if (r2 != null) goto L22;
        L25:
            boolean r3 = true;
        L26:
            if (r3 == false) goto L37;
            CharSequence r4 = this.secondaryButtonText;
            if (r4 != null) goto L30;
        L33:
            boolean r5 = true;
        L34:
            if (r5 == false) goto L37;
            boolean r6 = false;
        L38:
            OCoachmarkView r7 = new OCoachmarkView(this.activity, null, 0, this.coachmarkStyleRes);
            int r8 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
            if (r8 != 1) goto L41;
            OCoachmarkView.ContentStyle r12 = OCoachmarkView.ContentStyle.CARD;
        L46:
            r7.setContentStyle(r12);
            r7.setArrowPosition(resolveArrowPositionForGravity(this.gravity));
            r7.setArrowVisible(this.showArrow);
            Integer r13 = this.arrowOffset;
            if (r13 == null) goto L50;
            r7.setArrowOffset(r13.intValue());
        L50:
            Integer r14 = this.maxWidth;
            if (r14 == null) goto L54;
            r7.setMaxWidth(r14.intValue());
        L54:
            ContentPadding r15 = this.contentPadding;
            if (r15 == null) goto L58;
            r7.setContentPadding(r15.getStartPx(), r15.getTopPx(), r15.getEndPx(), r15.getBottomPx());
        L58:
            View r16 = this.customContentView;
            if (r16 == null) goto L61;
            r7.setCustomContentView$OUI_standardRelease(r16);
        L70:
            return r7;
        L61:
            r7.setTitle(this.title);
            r7.setDescription(this.description, this.desMaxLines, this.desEllipsize);
            r7.setPrimaryButtonText(r2);
            r7.setSecondaryButtonText(this.secondaryButtonText);
            r7.setIcon(this.icon);
            r7.setHeroImage(this.heroImage);
            r7.setCloseVisible(this.closable);
            if (this.actionStyleExplicitlySet == false) goto L66;
            OCoachmarkView.ActionStyle r17 = this.actionStyle;
            if (r17 != null) goto L69;
            r17 = OCoachmarkView.ActionStyle.NONE;
        L69:
            r7.setActionStyle(r17);
            r7.setOnPrimaryActionClickListener(r9);
            r7.setOnSecondaryActionClickListener(r10);
            r7.setOnCloseClickListener(r11);
            goto L70
        L66:
            if (r6 == true) goto L68;
            r17 = OCoachmarkView.ActionStyle.NONE;
            goto L69
        L68:
            r17 = OCoachmark.access$getDEFAULT_ACTION_STYLE$p();
            goto L69
        L41:
            if (r8 != 2) goto L44;
            r12 = OCoachmarkView.ContentStyle.PILL;
            goto L46
        L44:
            throw new NoWhenBranchMatchedException();
        L30:
            if (StringsKt.isBlank(r4) == true) goto L33;
            r5 = false;
        L37:
            r6 = true;
            goto L38
        L22:
            if (StringsKt.isBlank(r2) == true) goto L25;
            r3 = false;
            goto L26
        }

        private final void validateAnchor(View r4) {
            if (r4.isAttachedToWindow() == true) goto L5;
            L.e(OCoachmark.TAG, "anchor is not attached to window.");
            throw new IllegalStateException("anchor is not attached to window.");
        L5:
            if (r4.getWidth() <= 0) goto L7;
            int r3 = r4.getWidth();
        L9:
            if (r4.getHeight() <= 0) goto L11;
            int r5 = r4.getHeight();
        L12:
            if (r3 <= 0) goto L15;
            if (r5 <= 0) goto L15;
            return;
        L15:
            String r6 = "anchor has invalid size. width=" + r3 + ", height=" + r5;
            L.e(OCoachmark.TAG, r6);
            throw new IllegalStateException(r6);
        L11:
            r5 = r4.getMeasuredHeight();
            goto L12
        L7:
            r3 = r4.getMeasuredWidth();
            goto L9
        }

        private final OCoachmarkView.ArrowPosition resolveArrowPositionForGravity(int r3) {
            int r0 = r3 & 112;
            if (r0 != 48) goto L7;
            return OCoachmarkView.ArrowPosition.BOTTOM;
        L7:
            if (r0 == 80) goto L9;
            int r2 = resolveHorizontalGravity(r3);
            if (r2 == 3) goto L17;
            if (r2 == 5) goto L19;
            return OCoachmarkView.ArrowPosition.TOP;
        L19:
            return OCoachmarkView.ArrowPosition.LEFT;
        L17:
            return OCoachmarkView.ArrowPosition.RIGHT;
        L9:
            return OCoachmarkView.ArrowPosition.TOP;
        }
    }

    /* JADX INFO: compiled from: OCoachmark.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmark$Type;", "", "(Ljava/lang/String;I)V", "PILL", "CARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CARD = null;
        public static final Type PILL = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{PILL, CARD};
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        static {
            PILL = new Type("PILL", 0);
            CARD = new Type("CARD", 1);
            $VALUES = $values();
        }
    }

    private OCoachmark() {
    }

    public static final /* synthetic */ int access$getCOACHMARK_CONTENT_SHADOW_STYLE_RES$p() {
        return COACHMARK_CONTENT_SHADOW_STYLE_RES;
    }

    public static final /* synthetic */ OCoachmarkView.ActionStyle access$getDEFAULT_ACTION_STYLE$p() {
        return DEFAULT_ACTION_STYLE;
    }

    static {
        INSTANCE = new OCoachmark();
        DEFAULT_ACTION_STYLE = OCoachmarkView.ActionStyle.TEXT_ONLY;
        COACHMARK_CONTENT_SHADOW_STYLE_RES = R.style.OUIShadow_3;
    }
}
