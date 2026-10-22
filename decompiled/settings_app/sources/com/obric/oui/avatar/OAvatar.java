package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.android.vcard.VCardConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAvatar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002/0B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u0015J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#J\u0010\u0010!\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\nJ\u000e\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\nJ\u000e\u0010)\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bJ\u001a\u0010*\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u001a\u0010*\u001a\u00020\u00152\b\b\u0001\u0010&\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0010\u0010+\u001a\u00020\u00152\b\b\u0001\u0010,\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010.\u001a\u00020\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/oui/avatar/OAvatar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "avatarSize", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "iconBorderColor", "", "iconType", "Lcom/obric/oui/avatar/OAvatar$IconType;", "ivAvatar", "Lcom/obric/oui/avatar/OCircleImageView;", "ivBg", "Landroidx/appcompat/widget/AppCompatImageView;", "ivIcon", "spacer", "Landroid/widget/Space;", "applyIconSizeInternal", "", "spaceHorizontalMargin", "spaceVerticalMargin", "borderWidth", "contentSize", "applyLogoIconSize", PerfConsts.PERF_DISK_FILE_SIZE, "applyOnlineIconSize", "getBackgroundImageView", "getContentImageView", "getLogoImageView", "hideIcon", "setAvatar", "bitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "setAvatarInset", "inset", "setAvatarSize", "setIcon", "setIconBorderColor", "color", "setIconType", "showIcon", "AvatarSize", "IconType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatar extends ConstraintLayout {
    private AvatarSize avatarSize;
    private int iconBorderColor;
    private IconType iconType;
    private final OCircleImageView ivAvatar;
    private final AppCompatImageView ivBg;
    private final OCircleImageView ivIcon;
    private final Space spacer;

    /* JADX INFO: compiled from: OAvatar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "", "dpValue", "", "(Ljava/lang/String;II)V", "getDpValue", "()I", "DP_16", "DP_20", "DP_24", "DP_32", "DP_40", "DP_48", "DP_56", "DP_64", "DP_72", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum AvatarSize extends Enum<AvatarSize> {
        private static final /* synthetic */ AvatarSize[] $VALUES = null;
        public static final AvatarSize DP_16 = null;
        public static final AvatarSize DP_20 = null;
        public static final AvatarSize DP_24 = null;
        public static final AvatarSize DP_32 = null;
        public static final AvatarSize DP_40 = null;
        public static final AvatarSize DP_48 = null;
        public static final AvatarSize DP_56 = null;
        public static final AvatarSize DP_64 = null;
        public static final AvatarSize DP_72 = null;
        private final int dpValue;

        private static final /* synthetic */ AvatarSize[] $values() {
            return new AvatarSize[]{DP_16, DP_20, DP_24, DP_32, DP_40, DP_48, DP_56, DP_64, DP_72};
        }

        public static AvatarSize valueOf(String r1) {
            return (AvatarSize) Enum.valueOf(AvatarSize.class, r1);
        }

        public static AvatarSize[] values() {
            return (AvatarSize[]) $VALUES.clone();
        }

        private AvatarSize(String r1, int r2, int r3) {
            super(r1, r2);
            this.dpValue = r3;
        }

        public final int getDpValue() {
            return this.dpValue;
        }

        static {
            DP_16 = new AvatarSize("DP_16", 0, 16);
            DP_20 = new AvatarSize("DP_20", 1, 20);
            DP_24 = new AvatarSize("DP_24", 2, 24);
            DP_32 = new AvatarSize("DP_32", 3, 32);
            DP_40 = new AvatarSize("DP_40", 4, 40);
            DP_48 = new AvatarSize("DP_48", 5, 48);
            DP_56 = new AvatarSize("DP_56", 6, 56);
            DP_64 = new AvatarSize("DP_64", 7, 64);
            DP_72 = new AvatarSize("DP_72", 8, 72);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OAvatar.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$IconType;", "", "(Ljava/lang/String;I)V", "ONLINE", VCardConstants.PROPERTY_LOGO, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum IconType extends Enum<IconType> {
        private static final /* synthetic */ IconType[] $VALUES = null;
        public static final IconType LOGO = null;
        public static final IconType ONLINE = null;

        private static final /* synthetic */ IconType[] $values() {
            return new IconType[]{ONLINE, LOGO};
        }

        public static IconType valueOf(String r1) {
            return (IconType) Enum.valueOf(IconType.class, r1);
        }

        public static IconType[] values() {
            return (IconType[]) $VALUES.clone();
        }

        private IconType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            ONLINE = new IconType("ONLINE", 0);
            LOGO = new IconType(VCardConstants.PROPERTY_LOGO, 1);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OAvatar.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[AvatarSize.values().length];
            r0[AvatarSize.DP_24.ordinal()] = 1;
            r0[AvatarSize.DP_32.ordinal()] = 2;
            r0[AvatarSize.DP_40.ordinal()] = 3;
            r0[AvatarSize.DP_48.ordinal()] = 4;
            r0[AvatarSize.DP_56.ordinal()] = 5;
            r0[AvatarSize.DP_64.ordinal()] = 6;
            r0[AvatarSize.DP_72.ordinal()] = 7;
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[IconType.values().length];
            r1[IconType.LOGO.ordinal()] = 1;
            r1[IconType.ONLINE.ordinal()] = 2;
            $EnumSwitchMapping$1 = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAvatar(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OAvatar(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OAvatar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.avatarSize = AvatarSize.DP_24;
        this.iconType = IconType.LOGO;
        this.iconBorderColor = -1;
        ConstraintLayout.inflate(r3, R.layout.o_widget_avatar, this);
        View r5 = findViewById(R.id.iv_avatar);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.iv_avatar)");
        OCircleImageView r6 = (OCircleImageView) r5;
        this.ivAvatar = r6;
        View r0 = findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.iv_icon)");
        this.ivIcon = (OCircleImageView) r0;
        View r1 = findViewById(R.id.iv_bg);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.iv_bg)");
        this.ivBg = (AppCompatImageView) r1;
        View r2 = findViewById(R.id.spacer);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.spacer)");
        this.spacer = (Space) r2;
        setClipChildren(false);
        r6.setBorderWidth(OUnitExtensionKt.vdp(this, 1));
        r6.setBorderColor(ContextCompat.getColor(r3, R.color.LineReverse2));
    }

    public final void setAvatarSize(AvatarSize r4) {
        Intrinsics.checkNotNullParameter(r4, PerfConsts.PERF_DISK_FILE_SIZE);
        this.avatarSize = r4;
        OAvatar r0 = this;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L16;
        r1.width = OUnitExtensionKt.vdp(r0, r4.getDpValue());
        r1.height = OUnitExtensionKt.vdp(r0, r4.getDpValue());
        r0.setLayoutParams(r1);
        if (this.ivIcon.isShown() == true) goto L7;
        return;
    L7:
        if (this.ivIcon.getDrawable() != null) goto L9;
        return;
    L9:
        if (this.iconType != IconType.ONLINE) goto L12;
        applyOnlineIconSize(r4);
        return;
    L12:
        if (this.iconType != IconType.LOGO) goto L20;
        applyLogoIconSize(r4);
        return;
    L20:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setAvatarInset(int r3) {
        OCircleImageView r2 = this.ivAvatar;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 == null) goto L7;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        r1.setMargins(r3, r3, r3, r3);
        r2.setLayoutParams(r1);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final void applyOnlineIconSize(AvatarSize r9) {
        float r0 = 12.0f;
        float r3 = 1.5f;
        switch(WhenMappings.$EnumSwitchMapping$0[r9.ordinal()]) {
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        r0 = 0.0f;
        float r10 = 0.0f;
        r3 = 0.0f;
    L13:
        OAvatar r1 = this;
        applyIconSizeInternal(OUnitExtensionKt.vdp(r1, r10), OUnitExtensionKt.vdp(r1, r10), OUnitExtensionKt.vdp(r1, r3), OUnitExtensionKt.vdp(r1, r0));
        return;
    L5:
        r10 = ((2 * 2.0f) + 12.0f) + 2.0f;
    L8:
        r3 = 2.0f;
        goto L13
    L6:
        r10 = ((2 * 2.0f) + 12.0f) + 1.0f;
        goto L8
    L7:
        r10 = ((2 * 2.0f) + 10.0f) + 0.5f;
        r0 = 10.0f;
        goto L8
    L9:
        r10 = ((2 * 1.5f) + 8.0f) + 0.5f;
    L11:
        r0 = 8.0f;
        goto L13
    L10:
        r10 = ((2 * 1.5f) + 8.0f) - 0.5f;
        goto L11
    L12:
        r0 = 6.0f;
        r10 = ((2 * 1.0f) + 6.0f) - 1;
        r3 = 1.0f;
        goto L13
    }

    private final void applyLogoIconSize(AvatarSize r10) {
        float r0 = 20.0f;
        float r5 = 2.0f;
        switch(WhenMappings.$EnumSwitchMapping$0[r10.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        r0 = 0.0f;
        float r11 = 0.0f;
        float r1 = 0.0f;
        r5 = 0.0f;
    L11:
        OAvatar r2 = this;
        applyIconSizeInternal(OUnitExtensionKt.vdp(r2, r11), OUnitExtensionKt.vdp(r2, r1), OUnitExtensionKt.vdp(r2, r5), OUnitExtensionKt.vdp(r2, r0));
        return;
    L5:
        float r12 = (2 * 2.0f) + 20.0f;
        r1 = r12 - 2.0f;
        r11 = r12 - 4.0f;
        goto L11
    L6:
        float r13 = (2 * 2.0f) + 16.0f;
        float r3 = r13 - 2.0f;
        r11 = r13 - 4.0f;
    L8:
        r1 = r3;
        r0 = 16.0f;
        goto L11
    L7:
        float r14 = (2 * 1.5f) + 16.0f;
        r3 = r14 - 1.5f;
        r11 = r14 - 3.5f;
        r5 = 1.5f;
        goto L8
    L9:
        float r15 = (2 * 1.5f) + 12.0f;
        r1 = r15 - 1.5f;
        r11 = r15 - 3.5f;
        r0 = 12.0f;
        r5 = 1.5f;
        goto L11
    L10:
        r5 = 1.0f;
        r0 = 10.0f;
        float r16 = (2 * 1.0f) + 10.0f;
        r1 = r16 - 1.0f;
        r11 = r16 - 3.0f;
        goto L11
    }

    private final void applyIconSizeInternal(int r5, int r6, int r7, int r8) {
        Space r0 = this.spacer;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L11;
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        ConstraintLayout.LayoutParams r3 = r2;
        r3.rightMargin = r5;
        r3.bottomMargin = r6;
        r0.setLayoutParams(r2);
        setAvatarInset(1);
        this.ivIcon.setContentPadding(0);
        this.ivIcon.setBorderWidth(r7);
        this.ivIcon.setBorderColor(this.iconBorderColor);
        OCircleImageView r4 = this.ivIcon;
        ViewGroup.LayoutParams r9 = r4.getLayoutParams();
        if (r9 == null) goto L9;
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r9;
        ConstraintLayout.LayoutParams r11 = r10;
        int r12 = r8 + (r7 * 2);
        r11.width = r12;
        r11.height = r12;
        r4.setLayoutParams(r10);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setIconBorderColor(int r1) {
        this.iconBorderColor = r1;
    }

    public final void setAvatar(Bitmap r2) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        this.ivAvatar.setImageBitmap(r2);
    }

    public final void setAvatar(Drawable r1) {
        this.ivAvatar.setImageDrawable(r1);
    }

    public final void setAvatar(int r1) {
        this.ivAvatar.setImageResource(r1);
    }

    public final void setIconType(IconType r2) {
        Intrinsics.checkNotNullParameter(r2, "iconType");
        this.iconType = r2;
    }

    public static /* synthetic */ void setIcon$default(OAvatar r0, int r1, IconType r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = IconType.LOGO;
    L5:
        r0.setIcon(r1, r2);
    }

    public final void setIcon(int r2, IconType r3) {
        Intrinsics.checkNotNullParameter(r3, "iconType");
        setIcon(ContextCompat.getDrawable(getContext(), r2), r3);
    }

    public static /* synthetic */ void setIcon$default(OAvatar r0, Drawable r1, IconType r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = IconType.LOGO;
    L5:
        r0.setIcon(r1, r2);
    }

    public final void setIcon(Drawable r3, IconType r4) {
        Intrinsics.checkNotNullParameter(r4, "iconType");
        if (r3 != null) goto L6;
        ViewExtensionsKt.makeGone(this.ivIcon);
        return;
    L6:
        if (getParent() != null) goto L8;
    L14:
        this.iconType = r4;
        this.ivIcon.setImageDrawable(r3);
        ViewExtensionsKt.makeVisible(this.ivIcon);
        int r5 = WhenMappings.$EnumSwitchMapping$1[r4.ordinal()];
        if (r5 != 1) goto L17;
        applyLogoIconSize(this.avatarSize);
        return;
    L17:
        if (r5 != 2) goto L24;
        applyOnlineIconSize(this.avatarSize);
        return;
    L24:
        return;
    L8:
        if ((getParent() instanceof ViewGroup) == false) goto L14;
        ViewParent r0 = getParent();
        if (r0 == null) goto L13;
        ((ViewGroup) r0).setClipChildren(false);
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void hideIcon() {
        ViewExtensionsKt.makeGone(this.ivIcon);
    }

    public final void showIcon() {
        ViewExtensionsKt.makeVisible(this.ivIcon);
    }

    public final OCircleImageView getContentImageView() {
        return this.ivAvatar;
    }

    public final AppCompatImageView getBackgroundImageView() {
        return this.ivBg;
    }

    public final OCircleImageView getLogoImageView() {
        return this.ivIcon;
    }
}
