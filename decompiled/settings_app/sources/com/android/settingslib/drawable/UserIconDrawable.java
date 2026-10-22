package com.android.settingslib.drawable;

import android.R;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import com.android.settingslib.utils.BuildCompatUtils;

/* JADX INFO: loaded from: classes.dex */
public class UserIconDrawable extends Drawable implements Drawable.Callback {
    private Drawable mBadge;
    private float mBadgeMargin;
    private float mBadgeRadius;
    private Bitmap mBitmap;
    private Paint mClearPaint;
    private float mDisplayRadius;
    private ColorStateList mFrameColor;
    private float mFramePadding;
    private Paint mFramePaint;
    private float mFrameWidth;
    private final Matrix mIconMatrix;
    private final Paint mIconPaint;
    private float mIntrinsicRadius;
    private boolean mInvalidated;
    private float mPadding;
    private final Paint mPaint;
    private int mSize;
    private ColorStateList mTintColor;
    private PorterDuff.Mode mTintMode;
    private Drawable mUserDrawable;
    private Bitmap mUserIcon;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    public static Drawable getManagedUserDrawable(Context r1) {
        if (BuildCompatUtils.isAtLeastT() == false) goto L7;
        return getUpdatableManagedUserDrawable(r1);
    L7:
        return getDrawableForDisplayDensity(r1, R.drawable.ic_perm_group_audio_settings);
    }

    private static Drawable getUpdatableManagedUserDrawable(final Context r4) {
        return ((DevicePolicyManager) r4.getSystemService(DevicePolicyManager.class)).getResources().getDrawableForDensity("WORK_PROFILE_USER_ICON", "SOLID_COLORED", r4.getResources().getDisplayMetrics().densityDpi, new UserIconDrawable$$ExternalSyntheticLambda0(r4));
    }

    static /* synthetic */ Drawable lambda$getUpdatableManagedUserDrawable$0(Context r1) {
        return getDrawableForDisplayDensity(r1, R.drawable.ic_perm_group_audio_settings);
    }

    private static Drawable getDrawableForDisplayDensity(Context r2, int r3) {
        int r0 = r2.getResources().getDisplayMetrics().densityDpi;
        return r2.getResources().getDrawableForDensity(r3, r0, r2.getTheme());
    }

    public static int getDefaultSize(Context r1) {
        return r1.getResources().getDimensionPixelSize(17106429);
    }

    public UserIconDrawable() {
        this(0);
    }

    public UserIconDrawable(int r7) {
        Paint r0 = new Paint();
        this.mIconPaint = r0;
        Paint r1 = new Paint();
        this.mPaint = r1;
        this.mIconMatrix = new Matrix();
        this.mPadding = 0.0f;
        this.mSize = 0;
        this.mInvalidated = true;
        this.mTintColor = null;
        this.mTintMode = PorterDuff.Mode.SRC_ATOP;
        this.mFrameColor = null;
        r0.setAntiAlias(true);
        r0.setFilterBitmap(true);
        r1.setFilterBitmap(true);
        r1.setAntiAlias(true);
        if (r7 <= 0) goto L5;
        setBounds(0, 0, r7, r7);
        setIntrinsicSize(r7);
    L5:
        setIcon(null);
    }

    public UserIconDrawable setIcon(Bitmap r5) {
        Drawable r0 = this.mUserDrawable;
        if (r0 == null) goto L5;
        r0.setCallback(null);
        this.mUserDrawable = null;
    L5:
        this.mUserIcon = r5;
        if (r5 != null) goto L8;
        this.mIconPaint.setShader(null);
        this.mBitmap = null;
    L9:
        onBoundsChange(getBounds());
        return this;
    L8:
        this.mIconPaint.setShader(new BitmapShader(r5, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        goto L9
    }

    public UserIconDrawable setIconDrawable(Drawable r3) {
        Drawable r0 = this.mUserDrawable;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.mUserIcon = null;
        this.mUserDrawable = r3;
        if (r3 != null) goto L8;
        this.mBitmap = null;
    L9:
        onBoundsChange(getBounds());
        return this;
    L8:
        r3.setCallback(this);
        goto L9
    }

    public boolean isEmpty() {
        if (getUserIcon() == null) goto L5;
    L7:
        return false;
    L5:
        if (getUserDrawable() != null) goto L7;
        return true;
    }

    public UserIconDrawable setBadge(Drawable r3) {
        this.mBadge = r3;
        if (r3 != null) goto L5;
        invalidateSelf();
    L9:
        return this;
    L5:
        if (this.mClearPaint != null) goto L7;
        Paint r4 = new Paint();
        this.mClearPaint = r4;
        r4.setAntiAlias(true);
        this.mClearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mClearPaint.setStyle(Paint.Style.FILL);
    L7:
        onBoundsChange(getBounds());
        goto L9
    }

    public UserIconDrawable setBadgeIfManagedUser(Context r3, int r4) {
        if (r4 == (-10000)) goto L12;
        DevicePolicyManager r0 = (DevicePolicyManager) r3.getSystemService(DevicePolicyManager.class);
        if (r0.getProfileOwnerAsUser(r4) != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L12;
        Drawable r6 = getManagementBadge(r3);
    L14:
        return setBadge(r6);
    L7:
        if (r0.getProfileOwnerOrDeviceOwnerSupervisionComponent(UserHandle.of(r4)) != null) goto L9;
        r5 = true;
    L12:
        r6 = null;
        goto L14
    }

    public UserIconDrawable setBadgeIfManagedDevice(Context r2) {
        if (((DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class)).getDeviceOwnerComponentOnAnyUser() == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        Drawable r3 = getManagementBadge(r2);
    L10:
        return setBadge(r3);
    L8:
        r3 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private static Drawable getManagementBadge(Context r1) {
        if (BuildCompatUtils.isAtLeastT() == false) goto L7;
        return getUpdatableManagementBadge(r1);
    L7:
        return getDrawableForDisplayDensity(r1, R.drawable.ic_perm_group_audio_settings);
    }

    private static Drawable getUpdatableManagementBadge(final Context r4) {
        return ((DevicePolicyManager) r4.getSystemService(DevicePolicyManager.class)).getResources().getDrawableForDensity("WORK_PROFILE_ICON", "SOLID_COLORED", r4.getResources().getDisplayMetrics().densityDpi, new UserIconDrawable$$ExternalSyntheticLambda1(r4));
    }

    static /* synthetic */ Drawable lambda$getUpdatableManagementBadge$1(Context r1) {
        return getDrawableForDisplayDensity(r1, R.drawable.ic_notification_cast_2);
    }

    public void setBadgeRadius(float r1) {
        this.mBadgeRadius = r1;
        onBoundsChange(getBounds());
    }

    public void setBadgeMargin(float r1) {
        this.mBadgeMargin = r1;
        onBoundsChange(getBounds());
    }

    public void setPadding(float r1) {
        this.mPadding = r1;
        onBoundsChange(getBounds());
    }

    private void initFramePaint() {
        if (this.mFramePaint != null) goto L6;
        Paint r0 = new Paint();
        this.mFramePaint = r0;
        r0.setStyle(Paint.Style.STROKE);
        this.mFramePaint.setAntiAlias(true);
        return;
    }

    public void setFrameWidth(float r2) {
        initFramePaint();
        this.mFrameWidth = r2;
        this.mFramePaint.setStrokeWidth(r2);
        onBoundsChange(getBounds());
    }

    public void setFramePadding(float r1) {
        initFramePaint();
        this.mFramePadding = r1;
        onBoundsChange(getBounds());
    }

    public void setFrameColor(int r2) {
        initFramePaint();
        this.mFramePaint.setColor(r2);
        invalidateSelf();
    }

    public void setFrameColor(ColorStateList r1) {
        initFramePaint();
        this.mFrameColor = r1;
        invalidateSelf();
    }

    public void setIntrinsicSize(int r1) {
        this.mSize = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        if (this.mInvalidated == false) goto L6;
        rebake();
    L6:
        if (this.mBitmap == null) goto L15;
        ColorStateList r0 = this.mTintColor;
        if (r0 != null) goto L10;
        this.mPaint.setColorFilter(null);
    L13:
        r5.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mPaint);
        return;
    L10:
        int r1 = r0.getColorForState(getState(), this.mTintColor.getDefaultColor());
        if (shouldUpdateColorFilter(r1, this.mTintMode) == false) goto L13;
        this.mPaint.setColorFilter(new PorterDuffColorFilter(r1, this.mTintMode));
        goto L13
    }

    private boolean shouldUpdateColorFilter(int r3, PorterDuff.Mode r4) {
        ColorFilter r2 = this.mPaint.getColorFilter();
        if ((r2 instanceof PorterDuffColorFilter) == false) goto L10;
        PorterDuffColorFilter r5 = (PorterDuffColorFilter) r2;
        int r0 = r5.getColor();
        PorterDuff.Mode r6 = r5.getMode();
        if (r0 != r3) goto L11;
        if (r6 != r4) goto L12;
        return false;
    L12:
        return true;
    L11:
        return true;
    L10:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.mPaint.setAlpha(r2);
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r1) {
        this.mTintColor = r1;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r1) {
        this.mTintMode = r1;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return new BitmapDrawable(this.mBitmap).getConstantState();
    }

    public UserIconDrawable bake() {
        if (this.mSize <= 0) goto L12;
        int r1 = this.mSize;
        onBoundsChange(new Rect(0, 0, r1, r1));
        rebake();
        this.mFrameColor = null;
        this.mFramePaint = null;
        this.mClearPaint = null;
        Drawable r2 = this.mUserDrawable;
        if (r2 == null) goto L7;
        r2.setCallback(null);
        this.mUserDrawable = null;
    L10:
        return this;
    L7:
        Bitmap r3 = this.mUserIcon;
        if (r3 == null) goto L10;
        r3.recycle();
        this.mUserIcon = null;
        goto L10
    L12:
        throw new IllegalStateException("Baking requires an explicit intrinsic size");
    }

    private void rebake() {
        this.mInvalidated = false;
        if (this.mBitmap != null) goto L5;
        return;
    L5:
        if (this.mUserDrawable == null) goto L7;
    L9:
        Canvas r1 = new Canvas(this.mBitmap);
        r1.drawColor(0, PorterDuff.Mode.CLEAR);
        Drawable r2 = this.mUserDrawable;
        if (r2 == null) goto L13;
        r2.draw(r1);
    L15:
        ColorStateList r3 = this.mFrameColor;
        if (r3 == null) goto L18;
        this.mFramePaint.setColor(r3.getColorForState(getState(), 0));
    L18:
        float r0 = this.mFrameWidth;
        if ((this.mFramePadding + r0) <= 0.001f) goto L22;
        r1.drawCircle(getBounds().exactCenterX(), getBounds().exactCenterY(), (this.mDisplayRadius - this.mPadding) - (r0 * 0.5f), this.mFramePaint);
    L22:
        if (this.mBadge == null) goto L28;
        float r4 = this.mBadgeRadius;
        if (r4 <= 0.001f) goto L29;
        float r5 = r4 * 2.0f;
        float r6 = this.mBitmap.getHeight() - r5;
        float r7 = this.mBitmap.getWidth() - r5;
        this.mBadge.setBounds((int) r7, (int) r6, (int) (r7 + r5), (int) (r5 + r6));
        float r8 = (this.mBadge.getBounds().width() * 0.5f) + this.mBadgeMargin;
        float r9 = this.mBadgeRadius;
        r1.drawCircle(r7 + r9, r6 + r9, r8, this.mClearPaint);
        this.mBadge.draw(r1);
        return;
    L29:
        return;
    L28:
        return;
    L13:
        if (this.mUserIcon == null) goto L15;
        int r10 = r1.save();
        r1.concat(this.mIconMatrix);
        r1.drawCircle(this.mUserIcon.getWidth() * 0.5f, this.mUserIcon.getHeight() * 0.5f, this.mIntrinsicRadius, this.mIconPaint);
        r1.restoreToCount(r10);
        goto L15
    L7:
        if (this.mUserIcon != null) goto L9;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r7) {
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        if (this.mUserIcon == null) goto L7;
    L9:
        float r0 = Math.min(r7.width(), r7.height()) * 0.5f;
        int r3 = (int) (r0 * 2.0f);
        Bitmap r4 = this.mBitmap;
        if (r4 != null) goto L12;
    L13:
        this.mDisplayRadius = r0;
        if (r4 == null) goto L16;
        r4.recycle();
    L16:
        this.mBitmap = Bitmap.createBitmap(r3, r3, Bitmap.Config.ARGB_8888);
    L17:
        float r1 = Math.min(r7.width(), r7.height()) * 0.5f;
        this.mDisplayRadius = r1;
        float r2 = ((r1 - this.mFrameWidth) - this.mFramePadding) - this.mPadding;
        RectF r5 = new RectF(r7.exactCenterX() - r2, r7.exactCenterY() - r2, r7.exactCenterX() + r2, r7.exactCenterY() + r2);
        if (this.mUserDrawable == null) goto L20;
        Rect r8 = new Rect();
        r5.round(r8);
        this.mIntrinsicRadius = Math.min(this.mUserDrawable.getIntrinsicWidth(), this.mUserDrawable.getIntrinsicHeight()) * 0.5f;
        this.mUserDrawable.setBounds(r8);
    L23:
        invalidateSelf();
        return;
    L20:
        Bitmap r9 = this.mUserIcon;
        if (r9 == null) goto L23;
        float r10 = r9.getWidth() * 0.5f;
        float r6 = this.mUserIcon.getHeight() * 0.5f;
        this.mIntrinsicRadius = Math.min(r10, r6);
        float r11 = this.mIntrinsicRadius;
        this.mIconMatrix.setRectToRect(new RectF(r10 - r11, r6 - r11, r10 + r11, r6 + r11), r5, Matrix.ScaleToFit.FILL);
        goto L23
    L12:
        if (r3 == ((int) (this.mDisplayRadius * 2.0f))) goto L17;
    L7:
        if (this.mUserDrawable != null) goto L9;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.mInvalidated = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r0 = this.mFrameColor;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isStateful() == false) goto L7;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int r0 = this.mSize;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return ((int) this.mIntrinsicRadius) * 2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        scheduleSelf(r2, r3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r1, Runnable r2) {
        unscheduleSelf(r2);
    }

    public Drawable getUserDrawable() {
        return this.mUserDrawable;
    }

    public Bitmap getUserIcon() {
        return this.mUserIcon;
    }

    public boolean isInvalidated() {
        return this.mInvalidated;
    }

    public Drawable getBadge() {
        return this.mBadge;
    }
}
