package com.android.launcher3.icons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.android.launcher3.util.FlagOp;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class BitmapInfo {
    public static final int FLAG_CLONE = 4;
    public static final int FLAG_INSTANT = 2;
    public static final int FLAG_NO_BADGE = 2;
    public static final int FLAG_PRIVATE = 8;
    public static final int FLAG_SKIP_USER_BADGE = 4;
    public static final int FLAG_THEMED = 1;
    public static final int FLAG_WORK = 1;
    public static final Bitmap LOW_RES_ICON = null;
    public static final BitmapInfo LOW_RES_INFO = null;
    public static final String TAG = "BitmapInfo";
    private BitmapInfo badgeInfo;
    public final int color;
    public int flags;
    public final Bitmap icon;
    protected Bitmap mMono;
    protected Bitmap mWhiteShadowLayer;

    public @interface DrawableCreationFlags {
    }

    public interface Extender {
        void drawForPersistence(Canvas r1);

        BitmapInfo getExtendedInfo(Bitmap r1, int r2, BaseIconFactory r3, float r4);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo69clone() throws CloneNotSupportedException {
        return clone();
    }

    static {
        Bitmap r0 = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
        LOW_RES_ICON = r0;
        LOW_RES_INFO = fromBitmap(r0);
    }

    public BitmapInfo(Bitmap r1, int r2) {
        this.icon = r1;
        this.color = r2;
    }

    public BitmapInfo withBadgeInfo(BitmapInfo r1) {
        BitmapInfo r0 = clone();
        r0.badgeInfo = r1;
        return r0;
    }

    public BitmapInfo withFlags(FlagOp r2) {
        if (r2 != FlagOp.NO_OP) goto L5;
        return this;
    L5:
        BitmapInfo r1 = clone();
        r1.flags = r2.apply(r1.flags);
        return r1;
    }

    protected BitmapInfo copyInternalsTo(BitmapInfo r2) {
        r2.mMono = this.mMono;
        r2.mWhiteShadowLayer = this.mWhiteShadowLayer;
        r2.flags = this.flags;
        r2.badgeInfo = this.badgeInfo;
        return r2;
    }

    public BitmapInfo clone() {
        return copyInternalsTo(new BitmapInfo(this.icon, this.color));
    }

    public void setMonoIcon(Bitmap r1, BaseIconFactory r2) {
        this.mMono = r1;
        this.mWhiteShadowLayer = r2.getWhiteShadowLayer();
    }

    public final boolean isNullOrLowRes() {
        Bitmap r1 = this.icon;
        if (r1 != null) goto L5;
    L8:
        return true;
    L5:
        if (r1 == LOW_RES_ICON) goto L8;
        return false;
    }

    public final boolean isLowRes() {
        if (LOW_RES_ICON != this.icon) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canPersist() {
        return !isNullOrLowRes();
    }

    public Bitmap getMono() {
        return this.mMono;
    }

    public FastBitmapDrawable newIcon(Context r2) {
        return newIcon(r2, 0);
    }

    public FastBitmapDrawable newIcon(Context r2, int r3) {
        if (isLowRes() == false) goto L6;
        FastBitmapDrawable r0 = new PlaceHolderIconDrawable(this, r2);
    L11:
        applyFlags(r2, r0, r3);
        return r0;
    L6:
        if ((r3 & 1) != 0) goto L8;
    L10:
        r0 = new FastBitmapDrawable(this);
        goto L11
    L8:
        if (this.mMono == null) goto L10;
        r0 = ThemedIconDrawable.newDrawable(this, r2);
        goto L11
    }

    protected void applyFlags(Context r4, FastBitmapDrawable r5, int r6) {
        r5.mDisabledAlpha = GraphicsUtils.getFloat(r4, R.attr.disabledIconAlpha, 1.0f);
        r5.mCreationFlags = r6;
        if ((r6 & 2) != 0) goto L15;
        boolean r1 = false;
        if ((r6 & 1) == 0) goto L7;
        boolean r0 = true;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r1 = true;
    L11:
        Drawable r3 = getBadgeDrawable(r4, r0, r1);
        if (r3 == null) goto L16;
        r5.setBadge(r3);
        return;
    L16:
        return;
    L7:
        r0 = false;
        goto L9
    }

    public Drawable getBadgeDrawable(Context r2, boolean r3) {
        return getBadgeDrawable(r2, r3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Drawable getBadgeDrawable(Context r2, boolean r3, boolean r4) {
        BitmapInfo r0 = this.badgeInfo;
        int r5 = r3;
        if (r0 == null) goto L9;
        if (r4 == false) goto L7;
        r5 = (r3 ? 1 : 0) | 4;
    L7:
        return r0.newIcon(r2, r5);
    L9:
        if (r4 == false) goto L11;
        return null;
    L11:
        int r1 = this.flags;
        if ((r1 & 2) == 0) goto L16;
        return new UserBadgeDrawable(r2, R.drawable.ic_instant_app_badge, R.color.badge_tint_instant, r3);
    L16:
        if ((r1 & 1) == 0) goto L20;
        return new UserBadgeDrawable(r2, R.drawable.ic_work_app_badge, R.color.badge_tint_work, r3);
    L20:
        if ((r1 & 4) == 0) goto L24;
        return new UserBadgeDrawable(r2, R.drawable.ic_clone_app_badge, R.color.badge_tint_clone, r3);
    L24:
        if ((r1 & 8) != 0) goto L26;
        return null;
    L26:
        return new UserBadgeDrawable(r2, R.drawable.ic_private_profile_app_badge, R.color.badge_tint_private, r3);
    }

    public static BitmapInfo fromBitmap(Bitmap r1) {
        return of(r1, 0);
    }

    public static BitmapInfo of(Bitmap r1, int r2) {
        return new BitmapInfo(r1, r2);
    }
}
