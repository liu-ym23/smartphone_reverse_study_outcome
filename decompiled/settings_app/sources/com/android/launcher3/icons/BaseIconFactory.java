package com.android.launcher3.icons;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.InsetDrawable;
import android.icu.lang.UCharacter;
import android.os.UserHandle;
import android.util.SparseArray;
import com.android.launcher3.util.FlagOp;
import com.android.launcher3.util.UserIconInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BaseIconFactory implements AutoCloseable {
    private static final int DEFAULT_WRAPPER_BACKGROUND = -1;
    private static final float ICON_BADGE_SCALE = 0.444f;
    private static final float LEGACY_ICON_SCALE = 0.0f;
    public static final int MODE_ALPHA = 1;
    public static final int MODE_DEFAULT = 0;
    public static final int MODE_HARDWARE = 3;
    public static final int MODE_HARDWARE_WITH_SHADOW = 4;
    public static final int MODE_WITH_SHADOW = 2;
    private static int PLACEHOLDER_BACKGROUND_COLOR;
    private final SparseArray<UserIconInfo> mCachedUserInfo;
    private final Canvas mCanvas;
    private final ColorExtractor mColorExtractor;
    protected final Context mContext;
    protected final int mFillResIconDpi;
    protected final int mIconBitmapSize;
    protected boolean mMonoIconEnabled;
    private IconNormalizer mNormalizer;
    private final Rect mOldBounds;
    private final PackageManager mPm;
    private ShadowGenerator mShadowGenerator;
    private final boolean mShapeDetection;
    private Bitmap mWhiteShadowLayer;
    private int mWrapperBackgroundColor;
    private Drawable mWrapperIcon;

    /* JADX INFO: renamed from: com.android.launcher3.icons.BaseIconFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class CenterTextDrawable extends ColorDrawable {
        private final String mText;
        private final Rect mTextBounds;
        private final Paint mTextPaint;

        CenterTextDrawable(String r3, int r4) {
            this.mTextBounds = new Rect();
            Paint r0 = new Paint(3);
            this.mTextPaint = r0;
            this.mText = r3;
            r0.setColor(r4);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas r7) {
            Rect r0 = getBounds();
            this.mTextPaint.setTextSize(r0.height() / 3.0f);
            Paint r1 = this.mTextPaint;
            String r2 = this.mText;
            r1.getTextBounds(r2, 0, r2.length(), this.mTextBounds);
            r7.drawText(this.mText, r0.exactCenterX() - this.mTextBounds.exactCenterX(), r0.exactCenterY() - this.mTextBounds.exactCenterY(), this.mTextPaint);
        }
    }

    protected static class ClippedMonoDrawable extends InsetDrawable {
        private final AdaptiveIconDrawable mCrop;

        public ClippedMonoDrawable(Drawable r3) {
            super(r3, -AdaptiveIconDrawable.getExtraInsetFraction());
            this.mCrop = new AdaptiveIconDrawable(new ColorDrawable(-16777216), null);
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas r3) {
            this.mCrop.setBounds(getBounds());
            int r0 = r3.save();
            r3.clipPath(this.mCrop.getIconMask());
            super.draw(r3);
            r3.restoreToCount(r0);
        }
    }

    private static class EmptyWrapper extends DrawableWrapper {
        EmptyWrapper() {
            super(new ColorDrawable());
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public Drawable.ConstantState getConstantState() {
            Drawable r0 = getDrawable();
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.getConstantState();
        }
    }

    private static class FixedSizeBitmapDrawable extends BitmapDrawable {
        public FixedSizeBitmapDrawable(Bitmap r2) {
            super(null, r2);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return getBitmap().getWidth();
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return getBitmap().getWidth();
        }
    }

    public static class IconOptions {
        Integer mExtractedColor;
        int mGenerationMode;
        boolean mIsInstantApp;
        UserHandle mUserHandle;
        UserIconInfo mUserIconInfo;

        public IconOptions() {
            this.mGenerationMode = 2;
        }

        public IconOptions setUser(UserHandle r1) {
            this.mUserHandle = r1;
            return this;
        }

        public IconOptions setUser(UserIconInfo r1) {
            this.mUserIconInfo = r1;
            return this;
        }

        public IconOptions setInstantApp(boolean r1) {
            this.mIsInstantApp = r1;
            return this;
        }

        public IconOptions setExtractedColor(int r1) {
            this.mExtractedColor = Integer.valueOf(r1);
            return this;
        }

        public IconOptions setBitmapGenerationMode(int r1) {
            this.mGenerationMode = r1;
            return this;
        }
    }

    private static class NoopDrawable extends ColorDrawable {
        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return 1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return 1;
        }

        private NoopDrawable() {
        }

        /* synthetic */ NoopDrawable(AnonymousClass1 r1) {
            this();
        }
    }

    public static int getBadgeSizeForIconSize(int r1) {
        return (int) (r1 * ICON_BADGE_SCALE);
    }

    static {
        LEGACY_ICON_SCALE = (1.0f / ((AdaptiveIconDrawable.getExtraInsetFraction() * 2.0f) + 1.0f)) * 0.7f;
        PLACEHOLDER_BACKGROUND_COLOR = Color.rgb(UCharacter.UnicodeBlock.PAU_CIN_HAU_ID, UCharacter.UnicodeBlock.PAU_CIN_HAU_ID, UCharacter.UnicodeBlock.PAU_CIN_HAU_ID);
    }

    protected BaseIconFactory(Context r2, int r3, int r4, boolean r5) {
        this.mOldBounds = new Rect();
        this.mCachedUserInfo = new SparseArray();
        this.mWrapperBackgroundColor = -1;
        Context r6 = r2.getApplicationContext();
        this.mContext = r6;
        this.mShapeDetection = r5;
        this.mFillResIconDpi = r3;
        this.mIconBitmapSize = r4;
        this.mPm = r6.getPackageManager();
        this.mColorExtractor = new ColorExtractor();
        Canvas r7 = new Canvas();
        this.mCanvas = r7;
        r7.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
        clear();
    }

    public BaseIconFactory(Context r2, int r3, int r4) {
        this(r2, r3, r4, false);
    }

    protected void clear() {
        this.mWrapperBackgroundColor = -1;
    }

    public ShadowGenerator getShadowGenerator() {
        if (this.mShadowGenerator != null) goto L6;
        this.mShadowGenerator = new ShadowGenerator(this.mIconBitmapSize);
    L6:
        return this.mShadowGenerator;
    }

    public IconNormalizer getNormalizer() {
        if (this.mNormalizer != null) goto L6;
        this.mNormalizer = new IconNormalizer(this.mContext, this.mIconBitmapSize, this.mShapeDetection);
    L6:
        return this.mNormalizer;
    }

    public BitmapInfo createIconBitmap(Intent.ShortcutIconResource r4) {
        Resources r1 = this.mPm.getResourcesForApplication(r4.packageName);     // Catch: Exception -> L8
        if (r1 == null) goto L7;
        return createBadgedIconBitmap(r1.getDrawableForDensity(r1.getIdentifier(r4.resourceName, null, null), this.mFillResIconDpi));
    L7:
        return null;
    }

    public BitmapInfo createIconBitmap(String r4, int r5) {
        return BitmapInfo.of(createIconBitmap(new AdaptiveIconDrawable(new ColorDrawable(PLACEHOLDER_BACKGROUND_COLOR), new CenterTextDrawable(r4, r5)), 0.92f), r5);
    }

    public BitmapInfo createIconBitmap(Bitmap r3) {
        if (this.mIconBitmapSize == r3.getWidth()) goto L5;
    L6:
        r3 = createIconBitmap(new BitmapDrawable(this.mContext.getResources(), r3), 1.0f);
    L8:
        return BitmapInfo.of(r3, this.mColorExtractor.findDominantColorByHue(r3));
    L5:
        if (this.mIconBitmapSize == r3.getHeight()) goto L8;
        goto L6
    }

    public BitmapInfo createShapedIconBitmap(Bitmap r9, IconOptions r10) {
        FixedSizeBitmapDrawable r1 = new FixedSizeBitmapDrawable(r9);
        float r11 = AdaptiveIconDrawable.getExtraInsetFraction();
        float r5 = r11 / ((2.0f * r11) + 1.0f);
        return createBadgedIconBitmap(new AdaptiveIconDrawable(new ColorDrawable(-16777216), new InsetDrawable(r1, r5, r5, r5, r5)), r10);
    }

    public BitmapInfo createBadgedIconBitmap(Drawable r2) {
        return createBadgedIconBitmap(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BitmapInfo createBadgedIconBitmap(Drawable r8, IconOptions r9) {
        float[] r1 = new float[1];
        AdaptiveIconDrawable r10 = normalizeAndWrapToAdaptiveIcon(r8, null, r1);
        float r3 = r1[0];
        if (r9 != null) goto L5;
        int r4 = 2;
    L6:
        Bitmap r5 = createIconBitmap(r10, r3, r4);
        if (r9 != null) goto L9;
    L11:
        int r6 = this.mColorExtractor.findDominantColorByHue(r5);
    L12:
        BitmapInfo r7 = BitmapInfo.of(r5, r6);
        if ((r10 instanceof BitmapInfo.Extender) == false) goto L16;
        r7 = ((BitmapInfo.Extender) r10).getExtendedInfo(r5, r6, this, r1[0]);
    L23:
        return r7.withFlags(getBitmapFlagOp(r9));
    L16:
        if (IconProvider.ATLEAST_T == false) goto L23;
        if (this.mMonoIconEnabled == false) goto L23;
        Drawable r11 = getMonochromeDrawable(r10);
        if (r11 == null) goto L23;
        r7.setMonoIcon(createIconBitmap(r11, r1[0], 1), this);
        goto L23
    L9:
        if (r9.mExtractedColor == null) goto L11;
        r6 = r9.mExtractedColor.intValue();
        goto L12
    L5:
        r4 = r9.mGenerationMode;
        goto L6
    }

    protected Drawable getMonochromeDrawable(AdaptiveIconDrawable r1) {
        Drawable r0 = r1.getMonochrome();
        if (r0 != null) goto L5;
        return null;
    L5:
        return new ClippedMonoDrawable(r0);
    }

    public FlagOp getBitmapFlagOp(IconOptions r4) {
        FlagOp r0 = FlagOp.NO_OP;
        if (r4 != null) goto L5;
        return r0;
    L5:
        if (r4.mIsInstantApp == false) goto L7;
        r0 = r0.addFlag(2);
    L7:
        UserIconInfo r1 = r4.mUserIconInfo;
        if (r1 == null) goto L10;
    L12:
        if (r1 != null) goto L14;
        return r0;
    L14:
        return r1.applyBitmapInfoFlags(r0);
    L10:
        if (r4.mUserHandle == null) goto L12;
        r1 = getUserInfo(r4.mUserHandle);
        goto L12
    }

    protected UserIconInfo getUserInfo(UserHandle r4) {
        int r0 = r4.hashCode();
        UserIconInfo r1 = this.mCachedUserInfo.get(r0);
        if (r1 != null) goto L10;
        NoopDrawable r2 = new NoopDrawable(null);
        if (r2 == this.mPm.getUserBadgedIcon(r2, r4)) goto L7;
        int r3 = 1;
    L8:
        UserIconInfo r5 = new UserIconInfo(r4, r3);
        this.mCachedUserInfo.put(r0, r5);
        return r5;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r1;
    }

    public Bitmap getWhiteShadowLayer() {
        if (this.mWhiteShadowLayer != null) goto L6;
        this.mWhiteShadowLayer = createScaledBitmap(new AdaptiveIconDrawable(new ColorDrawable(-1), null), 4);
    L6:
        return this.mWhiteShadowLayer;
    }

    public Bitmap createScaledBitmap(Drawable r4, int r5) {
        RectF r0 = new RectF();
        float[] r1 = new float[1];
        return createIconBitmap(normalizeAndWrapToAdaptiveIcon(r4, r0, r1), Math.min(r1[0], ShadowGenerator.getScaleForBounds(r0)), r5);
    }

    public void setWrapperBackgroundColor(int r3) {
        if (Color.alpha(r3) >= 255) goto L5;
        r3 = -1;
    L5:
        this.mWrapperBackgroundColor = r3;
    }

    protected AdaptiveIconDrawable normalizeAndWrapToAdaptiveIcon(Drawable r2, RectF r3, float[] r4) {
        if (r2 != null) goto L5;
        return null;
    L5:
        AdaptiveIconDrawable r5 = wrapToAdaptiveIcon(r2, r3);
        r4[0] = getNormalizer().getScale(r5, r3, null, null);
        return r5;
    }

    private Drawable createScaledDrawable(Drawable r9, float r10) {
        float r8 = r9.getIntrinsicHeight();
        float r0 = r9.getIntrinsicWidth();
        if (r8 <= r0) goto L8;
        if (r0 <= 0.0f) goto L8;
        float r1 = (r0 / r8) * r10;
        float r11 = r10;
        r10 = r1;
    L13:
        float r6 = (1.0f - r10) / 2.0f;
        float r7 = (1.0f - r11) / 2.0f;
        return new InsetDrawable(r9, r6, r7, r6, r7);
    L8:
        if (r0 > r8) goto L10;
    L12:
        r11 = r10;
        goto L13
    L10:
        if (r8 <= 0.0f) goto L12;
        r11 = (r8 / r0) * r10;
        goto L13
    }

    public AdaptiveIconDrawable wrapToAdaptiveIcon(Drawable r7, RectF r8) {
        if ((r7 instanceof AdaptiveIconDrawable) == true) goto L5;
        EmptyWrapper r0 = new EmptyWrapper();
        AdaptiveIconDrawable r1 = new AdaptiveIconDrawable(new ColorDrawable(this.mWrapperBackgroundColor), r0);
        r1.setBounds(0, 0, 1, 1);
        boolean[] r3 = new boolean[1];
        float r9 = getNormalizer().getScale(r7, r8, r1.getIconMask(), r3);
        if (r3[0] == true) goto L9;
        r0.setDrawable(createScaledDrawable(r7, r9 * LEGACY_ICON_SCALE));
    L10:
        return r1;
    L9:
        r0.setDrawable(createScaledDrawable(r7, 1.0f - AdaptiveIconDrawable.getExtraInsetFraction()));
        goto L10
    L5:
        return (AdaptiveIconDrawable) r7;
    }

    protected Bitmap createIconBitmap(Drawable r2, float r3) {
        return createIconBitmap(r2, r3, 0);
    }

    protected Bitmap createIconBitmap(final Drawable r8, final float r9, final int r10) {
        int r0 = this.mIconBitmapSize;
        if (r10 != 1) goto L5;
        Bitmap r1 = Bitmap.createBitmap(r0, r0, Bitmap.Config.ALPHA_8);
    L12:
        if (r8 != null) goto L14;
        return r1;
    L14:
        this.mCanvas.setBitmap(r1);
        drawIconBitmap(this.mCanvas, r8, r9, r10, r1);
        this.mCanvas.setBitmap(null);
        return r1;
    L5:
        if (r10 == 3) goto L10;
        if (r10 == 4) goto L10;
        r1 = Bitmap.createBitmap(r0, r0, Bitmap.Config.ARGB_8888);
    L10:
        return BitmapRenderer.createHardwareBitmap(r0, r0, new BaseIconFactory$$ExternalSyntheticLambda0(this, r8, r9, r10));
    }

    /* JADX INFO: renamed from: lambda$createIconBitmap$0$com-android-launcher3-icons-BaseIconFactory, reason: not valid java name */
    /* synthetic */ void m68x10733312(Drawable r7, float r8, int r9, Canvas r10) {
        drawIconBitmap(r10, r7, r8, r9, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void drawIconBitmap(Canvas r7, Drawable r8, float r9, int r10, Bitmap r11) {
        int r0 = this.mIconBitmapSize;
        this.mOldBounds.set(r8.getBounds());
        if ((r8 instanceof AdaptiveIconDrawable) == false) goto L15;
        float r12 = r0;
        int r13 = Math.max((int) Math.ceil(0.035f * r12), Math.round((r12 * (1.0f - r9)) / 2.0f));
        int r1 = (r0 - r13) - r13;
        r8.setBounds(0, 0, r1, r1);
        int r14 = r7.save();
        float r15 = r13;
        r7.translate(r15, r15);
        if (r10 != 2) goto L7;
    L8:
        getShadowGenerator().addPathShadow(((AdaptiveIconDrawable) r8).getIconMask(), r7);
    L10:
        if ((r8 instanceof BitmapInfo.Extender) == false) goto L12;
        ((BitmapInfo.Extender) r8).drawForPersistence(r7);
    L13:
        r7.restoreToCount(r14);
    L34:
        r8.setBounds(this.mOldBounds);
        return;
    L12:
        r8.draw(r7);
        goto L13
    L7:
        if (r10 != 4) goto L10;
    L15:
        if ((r8 instanceof BitmapDrawable) == false) goto L21;
        BitmapDrawable r2 = (BitmapDrawable) r8;
        Bitmap r3 = r2.getBitmap();
        if (r3 == null) goto L21;
        if (r3.getDensity() != 0) goto L21;
        r2.setTargetDensity(this.mContext.getResources().getDisplayMetrics());
    L21:
        int r4 = r8.getIntrinsicWidth();
        int r5 = r8.getIntrinsicHeight();
        if (r4 <= 0) goto L29;
        if (r5 <= 0) goto L29;
        float r6 = r4 / r5;
        if (r4 <= r5) goto L27;
        int r16 = (int) (r0 / r6);
        int r17 = r0;
    L30:
        int r18 = (r0 - r17) / 2;
        int r19 = (r0 - r16) / 2;
        r8.setBounds(r18, r19, r17 + r18, r16 + r19);
        r7.save();
        float r20 = r0 / 2;
        r7.scale(r9, r9, r20, r20);
        r8.draw(r7);
        r7.restore();
        if (r10 != 2) goto L34;
        if (r11 == null) goto L34;
        getShadowGenerator().drawShadow(r11, r7);
        r7.save();
        r7.scale(r9, r9, r20, r20);
        r8.draw(r7);
        r7.restore();
        goto L34
    L27:
        if (r5 <= r4) goto L29;
        r17 = (int) (r0 * r6);
        r16 = r0;
    L29:
        r17 = r0;
        r16 = r17;
        goto L30
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        clear();
    }

    public BitmapInfo makeDefaultIcon() {
        return createBadgedIconBitmap(getFullResDefaultActivityIcon(this.mFillResIconDpi));
    }

    public static Drawable getFullResDefaultActivityIcon(int r2) {
        return (Drawable) Objects.requireNonNull(Resources.getSystem().getDrawableForDensity(R.drawable.sym_def_app_icon, r2));
    }
}
