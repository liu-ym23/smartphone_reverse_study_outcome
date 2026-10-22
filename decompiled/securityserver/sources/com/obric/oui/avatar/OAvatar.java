package com.obric.oui.avatar;

import a.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OAvatar extends ConstraintLayout {
    public final OCircleImageView b;
    public final OCircleImageView c;
    public final AppCompatImageView e;
    public final Space f;
    public IconType i;
    public int j;

    @Metadata
    public static final enum AvatarSize extends Enum<AvatarSize> {
        public static final /* synthetic */ AvatarSize[] c = null;
        public final int b;

        static {
            c = new AvatarSize[]{new AvatarSize("DP_16", 0, 16), new AvatarSize("DP_20", 1, 20), new AvatarSize("DP_24", 2, 24), new AvatarSize("DP_32", 3, 32), new AvatarSize("DP_40", 4, 40), new AvatarSize("DP_48", 5, 48), new AvatarSize("DP_56", 6, 56), new AvatarSize("DP_64", 7, 64), new AvatarSize("DP_72", 8, 72)};
        }

        public AvatarSize(String r1, int r2, int r3) {
            super(r1, r2);
            this.b = r3;
        }

        public static AvatarSize valueOf(String r1) {
            return (AvatarSize) Enum.valueOf(AvatarSize.class, r1);
        }

        public static AvatarSize[] values() {
            return (AvatarSize[]) c.clone();
        }
    }

    @Metadata
    public static final enum IconType extends Enum<IconType> {
        public static final IconType b = null;
        public static final IconType c = null;
        public static final /* synthetic */ IconType[] e = null;

        static {
            IconType r0 = new IconType("ONLINE", 0);
            b = r0;
            IconType r1 = new IconType("LOGO", 1);
            c = r1;
            e = new IconType[]{r0, r1};
        }

        public static IconType valueOf(String r1) {
            return (IconType) Enum.valueOf(IconType.class, r1);
        }

        public static IconType[] values() {
            return (IconType[]) e.clone();
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[AvatarSize.values().length];
            r0[2] = 1;
            r0[3] = 2;
            r0[4] = 3;
            r0[5] = 4;
            r0[6] = 5;
            r0[7] = 6;
            r0[8] = 7;
            int[] r1 = new int[AvatarSize.values().length];
            r1[2] = 1;
            r1[3] = 2;
            r1[4] = 3;
            r1[5] = 4;
            r1[6] = 5;
            r1[7] = 6;
            r1[8] = 7;
            int[] r2 = new int[IconType.values().length];
            r2[1] = 1;
            r2[0] = 2;
        }
    }

    @JvmOverloads
    public OAvatar(@NotNull Context r4, @Nullable AttributeSet r5) {
        Intrinsics.f(r4, "context");
        super(r4, r5);
        this.i = IconType.c;
        this.j = -1;
        View.inflate(r4, R.layout.o_widget_avatar, this);
        View r6 = findViewById(R.id.iv_avatar);
        Intrinsics.e(r6, "findViewById(R.id.iv_avatar)");
        OCircleImageView r7 = (OCircleImageView) r6;
        this.b = r7;
        View r0 = findViewById(R.id.iv_icon);
        Intrinsics.e(r0, "findViewById(R.id.iv_icon)");
        this.c = (OCircleImageView) r0;
        View r1 = findViewById(R.id.iv_bg);
        Intrinsics.e(r1, "findViewById(R.id.iv_bg)");
        this.e = (AppCompatImageView) r1;
        View r2 = findViewById(R.id.spacer);
        Intrinsics.e(r2, "findViewById(R.id.spacer)");
        this.f = (Space) r2;
        setClipChildren(false);
        Resources r3 = Resources.getSystem();
        Intrinsics.e(r3, "Resources.getSystem()");
        r7.setBorderWidth(MathKt.a(TypedValue.applyDimension(1, 1, r3.getDisplayMetrics())));
        r7.setBorderColor(ContextCompat.getColor(r4, R.color.LineReverse2));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(int r4, int r5, int r6, int r7) {
        Space r0 = this.f;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L11;
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        ((ViewGroup.MarginLayoutParams) r2).rightMargin = r4;
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = r5;
        r0.setLayoutParams(r2);
        setAvatarInset(1);
        OCircleImageView r8 = this.c;
        r8.setContentPadding(0);
        r8.setBorderWidth(r6);
        r8.setBorderColor(this.j);
        ViewGroup.LayoutParams r3 = r8.getLayoutParams();
        if (r3 == null) goto L9;
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) r3;
        int r10 = (r6 * 2) + r7;
        ((ViewGroup.MarginLayoutParams) r9).width = r10;
        ((ViewGroup.MarginLayoutParams) r9).height = r10;
        r8.setLayoutParams(r9);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    @NotNull
    public final AppCompatImageView getBackgroundImageView() {
        return this.e;
    }

    @NotNull
    public final OCircleImageView getContentImageView() {
        return this.b;
    }

    @NotNull
    public final OCircleImageView getLogoImageView() {
        return this.c;
    }

    public final void setAvatar(@NotNull Bitmap r2) {
        Intrinsics.f(r2, "bitmap");
        this.b.setImageBitmap(r2);
    }

    public final void setAvatarInset(int r2) {
        OCircleImageView r1 = this.b;
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L7;
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r0;
        r3.setMargins(r2, r2, r2, r2);
        r1.setLayoutParams(r3);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setAvatarSize(@NotNull AvatarSize r15) {
        Intrinsics.f(r15, PerfConsts.PERF_DISK_FILE_SIZE);
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L37;
        int r1 = r15.b;
        r0.width = a.d("Resources.getSystem()", 1, r1);
        r0.height = a.d("Resources.getSystem()", 1, r1);
        setLayoutParams(r0);
        OCircleImageView r2 = this.c;
        if (r2.isShown() == true) goto L7;
        return;
    L7:
        if (r2.getDrawable() == null) goto L39;
        IconType r3 = this.i;
        float r4 = 0.0f;
        float r6 = 2.0f;
        if (r3 != IconType.b) goto L23;
        float r5 = 8.0f;
        switch(r15.ordinal()) {
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L13;
            default: goto L12;
        };
    L12:
        r5 = 0.0f;
        r6 = 0.0f;
    L21:
        g(a.d("Resources.getSystem()", 1, r4), a.d("Resources.getSystem()", 1, r4), a.d("Resources.getSystem()", 1, r6), a.d("Resources.getSystem()", 1, r5));
        return;
    L13:
        r4 = ((2 * 2.0f) + 12.0f) + 2.0f;
    L14:
        r5 = 12.0f;
        goto L21
    L15:
        r4 = ((2 * 2.0f) + 12.0f) + 1.0f;
        goto L14
    L16:
        r4 = ((2 * 2.0f) + 10.0f) + 0.5f;
        r5 = 10.0f;
        goto L21
    L17:
        r4 = ((2 * 1.5f) + 8.0f) + 0.5f;
    L18:
        r6 = 1.5f;
        goto L21
    L19:
        r4 = ((2 * 1.5f) + 8.0f) - 0.5f;
        goto L18
    L20:
        r5 = 6.0f;
        r6 = 1.0f;
        r4 = ((2 * 1.0f) + 6.0f) - 1;
        goto L21
    L23:
        if (r3 != IconType.c) goto L41;
        float r7 = 16.0f;
        switch(r15.ordinal()) {
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L32;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L27;
            default: goto L26;
        };
    L26:
        float r16 = 0.0f;
        r7 = 0.0f;
        r6 = 0.0f;
    L34:
        g(a.d("Resources.getSystem()", 1, r4), a.d("Resources.getSystem()", 1, r16), a.d("Resources.getSystem()", 1, r6), a.d("Resources.getSystem()", 1, r7));
        return;
    L27:
        float r17 = (2 * 2.0f) + 20.0f;
        float r8 = r17 - 2.0f;
        float r18 = r17 - 4.0f;
        r7 = 20.0f;
    L28:
        float r13 = r8;
        r4 = r18;
        r16 = r13;
        goto L34
    L29:
        float r19 = (2 * 2.0f) + 16.0f;
        r8 = r19 - 2.0f;
        r18 = r19 - 4.0f;
        goto L28
    L30:
        float r110 = (2 * 1.5f) + 16.0f;
        r8 = r110 - 1.5f;
        r18 = r110 - 3.5f;
    L31:
        r6 = 1.5f;
        goto L28
    L32:
        float r111 = (2 * 1.5f) + 12.0f;
        r8 = r111 - 1.5f;
        r18 = r111 - 3.5f;
        r7 = 12.0f;
        goto L31
    L33:
        float r112 = (2 * 1.0f) + 10.0f;
        r8 = r112 - 1.0f;
        r18 = r112 - 3.0f;
        r6 = 1.0f;
        r7 = 10.0f;
        goto L28
    L41:
        return;
    L39:
        return;
    L37:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setIconBorderColor(@ColorInt int r1) {
        this.j = r1;
    }

    public final void setIconType(@NotNull IconType r2) {
        Intrinsics.f(r2, "iconType");
        this.i = r2;
    }

    public final void setAvatar(@Nullable Drawable r1) {
        this.b.setImageDrawable(r1);
    }

    public final void setAvatar(int r1) {
        this.b.setImageResource(r1);
    }
}
