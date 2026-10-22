package com.android.settingslib.notification;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.util.IconDrawableFactory;
import com.GlobalProxyLancet;
import com.android.launcher3.icons.BaseIconFactory;
import com.android.settingslib.R;
import com.android.settingslib.Utils;

/* JADX INFO: loaded from: classes.dex */
public class ConversationIconFactory extends BaseIconFactory {
    private static final float BADGE_CENTER = 46.0f;
    private static final float BADGE_ORIGIN = 40.0f;
    private static final float BADGE_SIZE = 12.0f;
    private static final float BASE_ICON_SIZE = 56.0f;
    private static final float CIRCLE_MARGIN = 36.0f;
    private static final float CIRCLE_RADIUS = 0.0f;
    private static final float HEAD_SIZE = 52.0f;
    private static final float INN_CIRCLE_DIA = 0.0f;
    private static final float INN_CIRCLE_RAD = 0.0f;
    private static final float OUT_CIRCLE_DIA = 20.0f;
    private static final float OUT_CIRCLE_RAD = 10.0f;
    private static final float RING_STROKE_WIDTH = 0.0f;
    final IconDrawableFactory mIconDrawableFactory;
    private int mImportantConversationColor;
    final LauncherApps mLauncherApps;
    final PackageManager mPackageManager;

    public static class ConversationIconDrawable extends Drawable {
        private Drawable mBadgeIcon;
        private Drawable mBaseIcon;
        private int mIconSize;
        private Paint mPaddingPaint;
        private Paint mRingPaint;
        private boolean mShowRing;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r1) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r1) {
        }

        public ConversationIconDrawable(Drawable r1, Drawable r2, int r3, int r4, boolean r5) {
            this.mBaseIcon = r1;
            this.mBadgeIcon = r2;
            this.mIconSize = r3;
            this.mShowRing = r5;
            Paint r6 = new Paint();
            this.mRingPaint = r6;
            r6.setStyle(Paint.Style.STROKE);
            this.mRingPaint.setColor(r4);
            Paint r7 = new Paint();
            this.mPaddingPaint = r7;
            r7.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mPaddingPaint.setColor(-1);
        }

        public void setImportant(boolean r2) {
            if (r2 == this.mShowRing) goto L6;
            this.mShowRing = r2;
            invalidateSelf();
            return;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.mIconSize;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.mIconSize;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r9) {
            float r0 = getBounds().width() / ConversationIconFactory.BASE_ICON_SIZE;
            int r1 = (int) (ConversationIconFactory.access$000() * r0);
            int r2 = (int) (ConversationIconFactory.HEAD_SIZE * r0);
            int r3 = (int) (40.0f * r0);
            int r4 = (int) (ConversationIconFactory.BADGE_CENTER * r0);
            float r5 = r1;
            this.mPaddingPaint.setStrokeWidth(r5);
            float r6 = (int) (ConversationIconFactory.access$100() * r0);
            Drawable r7 = this.mBaseIcon;
            if (r7 == null) goto L5;
            r7.setBounds(0, 0, r2, r2);
            this.mBaseIcon.draw(r9);
        L7:
            if (this.mBadgeIcon == null) goto L9;
            float r8 = r4;
            r9.drawCircle(r8, r8, r6, this.mPaddingPaint);
            this.mBadgeIcon.setBounds(r3, r3, r2, r2);
            this.mBadgeIcon.draw(r9);
        L11:
            if (this.mShowRing == false) goto L14;
            this.mRingPaint.setStrokeWidth(r5);
            float r10 = r4;
            r9.drawCircle(r10, r10, r6, this.mRingPaint);
            return;
        L14:
            return;
        L9:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w("ConversationIconFactory", "ConversationIconDrawable has null badge icon");
            goto L11
        L5:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w("ConversationIconFactory", "ConversationIconDrawable has null base icon");
            goto L7
        }
    }

    static /* synthetic */ float access$000() {
        return RING_STROKE_WIDTH;
    }

    static /* synthetic */ float access$100() {
        return CIRCLE_RADIUS;
    }

    static {
        float r0 = (float) Math.sqrt(288.0d);
        INN_CIRCLE_DIA = r0;
        float r2 = r0 / 2.0f;
        INN_CIRCLE_RAD = r2;
        CIRCLE_RADIUS = r2 + ((10.0f - r2) / 2.0f);
        RING_STROKE_WIDTH = (20.0f - r0) / 2.0f;
    }

    public ConversationIconFactory(Context r2, LauncherApps r3, PackageManager r4, IconDrawableFactory r5, int r6) {
        super(r2, r2.getResources().getConfiguration().densityDpi, r6);
        this.mLauncherApps = r3;
        this.mPackageManager = r4;
        this.mIconDrawableFactory = r5;
        this.mImportantConversationColor = r2.getResources().getColor(R.color.important_conversation, null);
    }

    public Drawable getBaseIconDrawable(ShortcutInfo r2) {
        return this.mLauncherApps.getShortcutIconDrawable(r2, this.mFillResIconDpi);
    }

    public Drawable getAppBadge(String r3, int r4) {
        ApplicationInfo r5 = this.mPackageManager.getApplicationInfoAsUser(r3, 128, r4);     // Catch: PackageManager.NameNotFoundException -> L4
        return Utils.getBadgedIcon(this.mContext, r5);
    L5:
        return this.mPackageManager.getDefaultActivityIcon();
    }

    public Drawable getConversationDrawable(ShortcutInfo r1, String r2, int r3, boolean r4) {
        return getConversationDrawable(getBaseIconDrawable(r1), r2, r3, r4);
    }

    public Drawable getConversationDrawable(Drawable r8, String r9, int r10, boolean r11) {
        return new ConversationIconDrawable(r8, getAppBadge(r9, UserHandle.getUserId(r10)), this.mIconBitmapSize, this.mImportantConversationColor, r11);
    }
}
