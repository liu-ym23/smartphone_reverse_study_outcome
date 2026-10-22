package com.obric.oui.badge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OBadgeDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 r2\u00020\u0001:\u0002qrB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\u0019H\u0002J\u0006\u0010\\\u001a\u00020ZJ\u0010\u0010]\u001a\u00020Z2\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u0004\u0018\u00010$J\b\u0010a\u001a\u00020\u0006H\u0016J\b\u0010b\u001a\u00020ZH\u0002J\u0014\u0010c\u001a\u0004\u0018\u00010\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010d\u001a\u00020Z2\u0006\u0010e\u001a\u00020\u0006H\u0016J\u0012\u0010f\u001a\u00020Z2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0010\u0010i\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010$J\u0018\u0010j\u001a\u00020/2\u0006\u0010k\u001a\u00020/2\u0006\u0010l\u001a\u00020/H\u0016J\u000e\u0010m\u001a\u00020Z2\u0006\u0010n\u001a\u00020BJ\u0018\u0010m\u001a\u00020Z2\u0006\u0010n\u001a\u00020B2\b\u0010o\u001a\u0004\u0018\u00010BJ\b\u0010p\u001a\u00020ZH\u0002R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR\u000e\u0010\"\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u00100\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020/@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR\u000e\u00109\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000bR\u000e\u0010G\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010K\u001a\u00020>8F¢\u0006\u0006\u001a\u0004\bL\u0010MR$\u0010N\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u000e\u0010S\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010U\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\t\"\u0004\bW\u0010\u000bR\u000e\u0010X\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/obric/oui/badge/OBadgeDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "backgroundColor", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "backgroundPaint", "Landroid/graphics/Paint;", "badgeCenterX", "", "badgeCenterY", "Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;", "badgeGravity", "getBadgeGravity", "()Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;", "setBadgeGravity", "(Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;)V", "badgeHeight", "badgeMinSize", "", "badgeText", "getBadgeText", "()Ljava/lang/String;", "setBadgeText", "(Ljava/lang/String;)V", "badgeTextColor", "getBadgeTextColor", "setBadgeTextColor", "badgeWidth", "contentDescription", "", "dotDiameter", "ellipsisCircleDrawOffset", "ellipsisCircleRadius", "ellipsisColor", "getEllipsisColor", "()Ljava/lang/Integer;", "setEllipsisColor", "(Ljava/lang/Integer;)V", "ellipsisHeight", "ellipsisWidth", "", "enableFontScale", "getEnableFontScale", "()Z", "setEnableFontScale", "(Z)V", "hasCenter", "horizontalOffset", "getHorizontalOffset", "setHorizontalOffset", "horizontalPadding", "internalBadgeText", "internalEllipsisColor", "Ljava/lang/Integer;", "internalTextPaint", "Landroid/text/TextPaint;", "lastAnchorRect", "Landroid/graphics/Rect;", "lastAnchorView", "Landroid/view/View;", "lastOverlayHost", "maxNumber", "getMaxNumber", "setMaxNumber", "maxOverFlow", "needsLayout", "rectF", "Landroid/graphics/RectF;", "textPaint", "getTextPaint", "()Landroid/text/TextPaint;", "textSizeSp", "getTextSizeSp", "()F", "setTextSizeSp", "(F)V", "textWidthExtra", "tmpTextBounds", "verticalOffset", "getVerticalOffset", "setVerticalOffset", "verticalPadding", "calculateBadgeSize", "", "text", "clearText", "draw", "canvas", "Landroid/graphics/Canvas;", "getContentDescription", "getOpacity", "invalidateBadge", "parseNumber", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setContentDescription", "setVisible", "visible", "restart", "updateBadgeCoordinates", "anchor", "overlayHost", "updateBoundsInternal", "BadgeGravity", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBadgeDrawable extends Drawable {
    private static final float BADGE_HORIZONTAL_PADDING_DP = 4.0f;
    private static final float BADGE_MIN_SIZE_DP = 18.0f;
    private static final float BADGE_VERTICAL_PADDING_DP = 4.0f;
    public static final Companion Companion = null;
    public static final int DEFAULT_MAX_COUNT = 9999;
    public static final float DEFAULT_TEXT_SIZE_SP = 12.0f;
    private static final float DOT_DIAMETER_DP = 8.0f;
    private static final int ELLIPSIS_CIRCLE_DRAW_OFFSET_DP = 5;
    private static final double ELLIPSIS_CIRCLE_RADIUS_DP = 1.5d;
    private static final float ELLIPSIS_HEIGHT_DP = 18.0f;
    private static final float ELLIPSIS_WIDTH_DP = 23.0f;
    private static final float MAX_OVERFLOW_DP = 5.0f;
    private static final float TEXT_WIDTH_EXTRA_DP = 1.0f;
    private int backgroundColor;
    private final Paint backgroundPaint;
    private float badgeCenterX;
    private float badgeCenterY;
    private BadgeGravity badgeGravity;
    private float badgeHeight;
    private float badgeMinSize;
    private int badgeTextColor;
    private float badgeWidth;
    private CharSequence contentDescription;
    private final Context context;
    private float dotDiameter;
    private float ellipsisCircleDrawOffset;
    private float ellipsisCircleRadius;
    private float ellipsisHeight;
    private float ellipsisWidth;
    private boolean enableFontScale;
    private boolean hasCenter;
    private int horizontalOffset;
    private float horizontalPadding;
    private String internalBadgeText;
    private Integer internalEllipsisColor;
    private final TextPaint internalTextPaint;
    private Rect lastAnchorRect;
    private View lastAnchorView;
    private View lastOverlayHost;
    private int maxNumber;
    private float maxOverFlow;
    private boolean needsLayout;
    private final RectF rectF;
    private float textSizeSp;
    private float textWidthExtra;
    private final Rect tmpTextBounds;
    private int verticalOffset;
    private float verticalPadding;

    /* JADX INFO: compiled from: OBadgeDrawable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;", "", "(Ljava/lang/String;I)V", "TOP_START", "TOP_END", "CENTER", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum BadgeGravity extends Enum<BadgeGravity> {
        private static final /* synthetic */ BadgeGravity[] $VALUES = null;
        public static final BadgeGravity CENTER = null;
        public static final BadgeGravity TOP_END = null;
        public static final BadgeGravity TOP_START = null;

        private static final /* synthetic */ BadgeGravity[] $values() {
            return new BadgeGravity[]{TOP_START, TOP_END, CENTER};
        }

        public static BadgeGravity valueOf(String r1) {
            return (BadgeGravity) Enum.valueOf(BadgeGravity.class, r1);
        }

        public static BadgeGravity[] values() {
            return (BadgeGravity[]) $VALUES.clone();
        }

        private BadgeGravity(String r1, int r2) {
            super(r1, r2);
        }

        static {
            TOP_START = new BadgeGravity("TOP_START", 0);
            TOP_END = new BadgeGravity("TOP_END", 1);
            CENTER = new BadgeGravity("CENTER", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OBadgeDrawable.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/badge/OBadgeDrawable$Companion;", "", "()V", "BADGE_HORIZONTAL_PADDING_DP", "", "BADGE_MIN_SIZE_DP", "BADGE_VERTICAL_PADDING_DP", "DEFAULT_MAX_COUNT", "", "DEFAULT_TEXT_SIZE_SP", "DOT_DIAMETER_DP", "ELLIPSIS_CIRCLE_DRAW_OFFSET_DP", "ELLIPSIS_CIRCLE_RADIUS_DP", "", "ELLIPSIS_HEIGHT_DP", "ELLIPSIS_WIDTH_DP", "MAX_OVERFLOW_DP", "TEXT_WIDTH_EXTRA_DP", "create", "Lcom/obric/oui/badge/OBadgeDrawable;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OBadgeDrawable create(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new OBadgeDrawable(r2, null);
        }
    }

    /* JADX INFO: compiled from: OBadgeDrawable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[BadgeGravity.values().length];
            r0[BadgeGravity.TOP_START.ordinal()] = 1;
            r0[BadgeGravity.TOP_END.ordinal()] = 2;
            r0[BadgeGravity.CENTER.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ OBadgeDrawable(Context r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @JvmStatic
    public static final OBadgeDrawable create(Context r1) {
        return Companion.create(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private OBadgeDrawable(Context r6) {
        this.context = r6;
        this.horizontalPadding = OUnitExtensionKt.cdpFloat(r6, 4.0f);
        this.verticalPadding = OUnitExtensionKt.cdpFloat(r6, 4.0f);
        this.dotDiameter = OUnitExtensionKt.cdpFloat(r6, 8.0f);
        this.maxOverFlow = OUnitExtensionKt.cdpFloat(r6, MAX_OVERFLOW_DP);
        this.badgeMinSize = OUnitExtensionKt.cdpFloat(r6, 18.0f);
        this.ellipsisCircleRadius = OUnitExtensionKt.cdpFloat(r6, 1.5d);
        this.ellipsisCircleDrawOffset = OUnitExtensionKt.cdpFloat(r6, 5);
        this.ellipsisWidth = OUnitExtensionKt.cdpFloat(r6, ELLIPSIS_WIDTH_DP);
        this.ellipsisHeight = OUnitExtensionKt.cdpFloat(r6, 18.0f);
        this.textWidthExtra = OUnitExtensionKt.cdpFloat(r6, 1.0f);
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        r0.setColor(ContextCompat.getColor(r6, R.color.oui_red_6));
        this.backgroundPaint = r0;
        TextPaint r1 = new TextPaint(1);
        r1.setTextAlign(Paint.Align.CENTER);
        r1.setTypeface(Typeface.create(r1.getTypeface(), 500, false));
        r1.setColor(ContextCompat.getColor(r6, R.color.white));
        r1.setTextSize(OUnitExtensionKt.cspFloat(r6, 12.0f));
        this.internalTextPaint = r1;
        this.tmpTextBounds = new Rect();
        this.rectF = new RectF();
        this.needsLayout = true;
        this.maxNumber = 9999;
        this.badgeGravity = BadgeGravity.TOP_END;
        this.backgroundColor = ContextCompat.getColor(r6, R.color.oui_red_6);
        this.badgeTextColor = ContextCompat.getColor(r6, R.color.white);
        this.enableFontScale = true;
        this.textSizeSp = 12.0f;
    }

    public final String getBadgeText() {
        return this.internalBadgeText;
    }

    public final void setBadgeText(String r2) {
        if (Intrinsics.areEqual(this.internalBadgeText, r2) == false) goto L5;
        return;
    L5:
        String r3 = parseNumber(r2);
        this.internalBadgeText = r3;
        if (r3 == null) goto L13;
        Intrinsics.checkNotNull(r3);
        if (r3.length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        this.internalEllipsisColor = null;
        goto L13
    L10:
        r4 = false;
    L13:
        invalidateBadge();
    }

    public final int getMaxNumber() {
        return this.maxNumber;
    }

    public final void setMaxNumber(int r2) {
        if (r2 >= 1) goto L6;
        r2 = 1;
    L6:
        if (this.maxNumber != r2) goto L8;
        return;
    L8:
        this.maxNumber = r2;
        this.internalBadgeText = parseNumber(this.internalBadgeText);
        invalidateBadge();
    }

    public final BadgeGravity getBadgeGravity() {
        return this.badgeGravity;
    }

    public final void setBadgeGravity(BadgeGravity r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (this.badgeGravity != r2) goto L5;
        return;
    L5:
        this.badgeGravity = r2;
        invalidateBadge();
    }

    public final int getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public final void setHorizontalOffset(int r2) {
        if (this.horizontalOffset != r2) goto L5;
        return;
    L5:
        this.horizontalOffset = r2;
        invalidateBadge();
    }

    public final int getVerticalOffset() {
        return this.verticalOffset;
    }

    public final void setVerticalOffset(int r2) {
        if (this.verticalOffset != r2) goto L5;
        return;
    L5:
        this.verticalOffset = r2;
        invalidateBadge();
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int r2) {
        if (this.backgroundColor != r2) goto L5;
        return;
    L5:
        this.backgroundColor = r2;
        this.backgroundPaint.setColor(r2);
        invalidateSelf();
    }

    public final int getBadgeTextColor() {
        return this.badgeTextColor;
    }

    public final void setBadgeTextColor(int r2) {
        if (this.badgeTextColor != r2) goto L5;
        return;
    L5:
        this.badgeTextColor = r2;
        this.internalTextPaint.setColor(r2);
        invalidateSelf();
    }

    public final Integer getEllipsisColor() {
        return this.internalEllipsisColor;
    }

    public final void setEllipsisColor(Integer r2) {
        if (Intrinsics.areEqual(this.internalEllipsisColor, r2) == false) goto L5;
        return;
    L5:
        this.internalEllipsisColor = r2;
        this.internalBadgeText = null;
        invalidateBadge();
    }

    public final boolean getEnableFontScale() {
        return this.enableFontScale;
    }

    public final void setEnableFontScale(boolean r4) {
        if (this.enableFontScale != r4) goto L5;
        return;
    L5:
        this.enableFontScale = r4;
        DisplayMetrics r5 = this.context.getResources().getDisplayMetrics();
        TextPaint r0 = this.internalTextPaint;
        if (this.enableFontScale == false) goto L8;
        float r6 = TypedValue.applyDimension(2, this.textSizeSp, r5);
    L9:
        r0.setTextSize(r6);
        invalidateBadge();
        return;
    L8:
        r6 = TypedValue.applyDimension(1, this.textSizeSp, r5);
        goto L9
    }

    public final float getTextSizeSp() {
        return this.textSizeSp;
    }

    public final void setTextSizeSp(float r4) {
        if (this.textSizeSp != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.textSizeSp = r4;
        DisplayMetrics r5 = this.context.getResources().getDisplayMetrics();
        TextPaint r1 = this.internalTextPaint;
        if (this.enableFontScale == false) goto L11;
        float r6 = TypedValue.applyDimension(2, this.textSizeSp, r5);
    L12:
        r1.setTextSize(r6);
        invalidateBadge();
        return;
    L11:
        r6 = TypedValue.applyDimension(1, this.textSizeSp, r5);
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public final TextPaint getTextPaint() {
        return this.internalTextPaint;
    }

    public final void setContentDescription(CharSequence r1) {
        this.contentDescription = r1;
    }

    public final CharSequence getContentDescription() {
        return this.contentDescription;
    }

    private final String parseNumber(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L15;
    L13:
        return r4;
    L15:
        Integer r0 = Integer.valueOf(String.valueOf(r4));     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r0, "integer");     // Catch: Exception -> L11
        if (r0.intValue() <= this.maxNumber) goto L8;
        r4 = new StringBuilder().append(this.maxNumber).append('+').toString();     // Catch: Exception -> L11
    L14:
    L8:
        if (r0.intValue() >= 0) goto L14;
        r4 = "";
    L12:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Excepted a int but get ", this.internalBadgeText));
    }

    public final void clearText() {
        this.internalBadgeText = null;
        invalidateBadge();
    }

    public final void updateBadgeCoordinates(View r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "anchor");
        this.lastAnchorView = r8;
        this.lastOverlayHost = r9;
        Rect r0 = new Rect();
        boolean r1 = false;
        if (r9 == null) goto L5;
        int[] r4 = new int[2];
        int[] r5 = new int[2];
        r8.getLocationInWindow(r4);
        r9.getLocationInWindow(r5);
        int r10 = r4[0] - r5[0];
        int r6 = r4[1] - r5[1];
        r0.set(r10, r6, r8.getWidth() + r10, r8.getHeight() + r6);
    L6:
        this.lastAnchorRect = new Rect(r0);
        if (ViewCompat.getLayoutDirection(r8) != 1) goto L9;
        r1 = true;
    L9:
        int r11 = WhenMappings.$EnumSwitchMapping$0[this.badgeGravity.ordinal()];
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L16;
        if (r11 != 3) goto L15;
        int r12 = r0.right - ((r0.right - r0.left) / 2);
    L23:
        if (WhenMappings.$EnumSwitchMapping$0[this.badgeGravity.ordinal()] != 3) goto L25;
        int r13 = r0.bottom - ((r0.bottom - r0.top) / 2);
    L26:
        this.badgeCenterX = r12 + this.horizontalOffset;
        this.badgeCenterY = r13 + this.verticalOffset;
        this.hasCenter = true;
        this.needsLayout = true;
        updateBoundsInternal();
        return;
    L25:
        r13 = r0.top;
        goto L26
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        if (r1 == false) goto L18;
        r12 = r0.left;
        goto L23
    L18:
        r12 = r0.right;
        goto L23
    L19:
        if (r1 == false) goto L21;
        r12 = r0.right;
        goto L23
    L21:
        r12 = r0.left;
        goto L23
    L5:
        r8.getDrawingRect(r0);
        goto L6
    }

    public final void updateBadgeCoordinates(View r2) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        updateBadgeCoordinates(r2, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (isVisible() == true) goto L6;
        return;
    L6:
        if (this.hasCenter == true) goto L9;
        return;
    L9:
        if (this.needsLayout == false) goto L12;
        updateBoundsInternal();
    L12:
        if (this.badgeWidth > 0.0f) goto L14;
        return;
    L14:
        if (this.badgeHeight <= 0.0f) goto L37;
        this.rectF.set(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom);
        float r0 = this.badgeHeight / 2.0f;
        r8.drawRoundRect(this.rectF, r0, r0, this.backgroundPaint);
        String r1 = this.internalBadgeText;
        String r2 = r1;
        if (r2 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        if (r3 == true) goto L26;
        r8.drawText(r1, this.rectF.centerX(), this.rectF.centerY() - ((this.internalTextPaint.ascent() + this.internalTextPaint.descent()) / 2.0f), this.internalTextPaint);
    L26:
        if (getEllipsisColor() == null) goto L35;
        Integer r4 = getEllipsisColor();
        if (r4 != null) goto L31;
    L32:
        float r5 = this.rectF.centerX();
        float r6 = this.rectF.centerY();
        float r7 = this.ellipsisCircleRadius;
        Paint r9 = new Paint();
        Integer r10 = getEllipsisColor();
        Intrinsics.checkNotNull(r10);
        r9.setColor(r10.intValue());
        r9.setAntiAlias(true);
        r8.drawCircle(r5, r6, r7, r9);
        r8.drawCircle(r5 - this.ellipsisCircleDrawOffset, r6, r7, r9);
        r8.drawCircle(r5 + this.ellipsisCircleDrawOffset, r6, r7, r9);
        return;
    L31:
        if (r4.intValue() != 0) goto L32;
        return;
    L35:
        return;
    L19:
        if (r2.length() == 0) goto L22;
        r3 = false;
        goto L23
    }

    private final void updateBoundsInternal() {
        if (this.hasCenter == true) goto L5;
        return;
    L5:
        calculateBadgeSize(this.internalBadgeText);
        float r0 = this.badgeWidth / 2.0f;
        float r2 = this.badgeHeight / 2.0f;
        int r1 = MathKt.roundToInt(this.badgeCenterX - r0);
        int r3 = MathKt.roundToInt(this.badgeCenterY - r2);
        int r4 = MathKt.roundToInt(this.badgeCenterX + r0);
        int r5 = MathKt.roundToInt(this.badgeCenterY + r2);
        Rect r6 = this.lastAnchorRect;
        if (r6 == null) goto L21;
        float r7 = this.maxOverFlow;
        int r8 = WhenMappings.$EnumSwitchMapping$0[this.badgeGravity.ordinal()];
        if (r8 != 1) goto L10;
        float r9 = r6.left - r1;
        if (r9 <= r7) goto L18;
        int r10 = MathKt.roundToInt(r9 - r7);
        r1 = r1 + r10;
        r4 = r4 + r10;
    L18:
        float r11 = r6.top - r3;
        if (r11 <= r7) goto L21;
        int r12 = MathKt.roundToInt(r11 - r7);
        r3 = r3 + r12;
        r5 = r5 + r12;
        goto L21
    L10:
        if (r8 != 2) goto L18;
        float r13 = r4 - r6.right;
        if (r13 <= r7) goto L18;
        int r14 = MathKt.roundToInt(r13 - r7);
        r1 = r1 - r14;
        r4 = r4 - r14;
    L21:
        setBounds(r1, r3, r4, r5);
        this.needsLayout = false;
    }

    private final void calculateBadgeSize(String r5) {
        if (getEllipsisColor() == null) goto L10;
        Integer r0 = getEllipsisColor();
        if (r0 != null) goto L8;
    L9:
        this.badgeWidth = this.ellipsisWidth;
        this.badgeHeight = this.ellipsisHeight;
        return;
    L8:
        if (r0.intValue() != 0) goto L9;
    L10:
        String r1 = r5;
        if (r1 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L19;
        float r6 = this.dotDiameter;
        this.badgeWidth = r6;
        this.badgeHeight = r6;
        return;
    L19:
        this.internalTextPaint.getTextBounds(r5, 0, r5.length(), this.tmpTextBounds);
        float r7 = this.tmpTextBounds.width() + this.textWidthExtra;
        float r3 = this.horizontalPadding;
        float r4 = this.badgeMinSize;
        float r8 = RangesKt.coerceAtLeast(r7 + (2 * r3), r4);
        if (r8 > r4) goto L22;
        float r9 = Math.max(r8, r4);
        this.badgeWidth = r9;
        this.badgeHeight = r9;
        return;
    L22:
        this.badgeWidth = r8;
        this.badgeHeight = r4;
        return;
    L13:
        if (r1.length() == 0) goto L16;
        r2 = false;
        goto L17
    }

    private final void invalidateBadge() {
        this.needsLayout = true;
        invalidateSelf();
        View r0 = this.lastAnchorView;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        updateBadgeCoordinates(r0, this.lastOverlayHost);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.backgroundPaint.setAlpha(r2);
        this.internalTextPaint.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.backgroundPaint.setColorFilter(r2);
        this.internalTextPaint.setColorFilter(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r1, boolean r2) {
        boolean r3 = super.setVisible(r1, r2);
        if (r3 == false) goto L5;
        invalidateSelf();
    L5:
        return r3;
    }
}
