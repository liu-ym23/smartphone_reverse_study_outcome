package com.bytedanceos.preventdisturb.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import bytedanceos.util.NameAvatarController;
import com.obric.security.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class AvatarImageView extends ImageView {
    private static HashMap<String, Bitmap> sClassifyAvatarHashmap;
    private static Bitmap sDefailtSpamAvatar;
    private static Bitmap sDefaultAvatar;
    private static Bitmap sDefaultGroupAvatar;
    private Bitmap mAvatarBase;
    private String mClassify;
    private String mDrawName;
    private Paint mDrawPaint;
    private boolean mIsGroup;
    private boolean mIsInDatabase;
    private boolean mIsSpam;
    private Bitmap mLogo;
    private NameAvatarController mNameAvatarController;
    private Rect mRect;

    static {
        sClassifyAvatarHashmap = new HashMap();
    }

    public AvatarImageView(Context context) {
        this(context, null);
    }

    public AvatarImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AvatarImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mIsGroup == false) goto L6;
        Bitmap r0 = getDefaultGroupAvatar();
    L25:
        if (r0 != null) goto L27;
        r0 = getDefaultAvatare();
    L27:
        drawCircle(canvas);
        canvas.drawBitmap(r0, null, getRect(), this.mDrawPaint);
        return;
    L6:
        if (this.mIsInDatabase == true) goto L8;
        r0 = this.mLogo;
        if (r0 != null) goto L25;
        if (TextUtils.isEmpty(this.mClassify) == true) goto L22;
        r0 = drawClassifyAvatar(getAvatarBase());
        goto L25
    L22:
        if (TextUtils.isEmpty(this.mDrawName) == true) goto L24;
        r0 = getAvatarBase();
        this.mNameAvatarController.drawName(this.mDrawName, r0);
    L24:
        r0 = null;
        goto L25
    L8:
        if (getDrawable() == null) goto L13;
        if ((getDrawable() instanceof BitmapDrawable) == false) goto L13;
        r0 = ((BitmapDrawable) getDrawable()).getBitmap();
    L13:
        if (TextUtils.isEmpty(this.mDrawName) == true) goto L24;
        r0 = getAvatarBase();
        this.mNameAvatarController.drawName(this.mDrawName, r0);
        goto L25
    }

    private Rect getRect() {
        if (this.mRect != null) goto L5;
        this.mRect = new Rect(0, 0, getWidth(), getHeight());
    L5:
        Rect r0 = this.mRect;
        r0.right = getWidth();
        Rect r1 = this.mRect;
        r1.bottom = getHeight();
        return this.mRect;
    }

    private void drawCircle(Canvas canvas) {
        this.mDrawPaint.reset();
        this.mDrawPaint.setAntiAlias(true);
        this.mDrawPaint.setColor(SupportMenu.CATEGORY_MASK);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, this.mDrawPaint);
        this.mDrawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void init() {
        this.mDrawPaint = new Paint();
        this.mNameAvatarController = NameAvatarController.getInstances(getContext());
    }

    private Bitmap getAvatarBase() {
        if (this.mAvatarBase != null) goto L6;
        this.mAvatarBase = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    L6:
        return this.mAvatarBase;
    }

    private Bitmap getDefaultAvatare() {
        if (this.mIsSpam == false) goto L10;
        if (sDefailtSpamAvatar != null) goto L8;
        sDefailtSpamAvatar = BitmapFactory.decodeResource(getResources(), R.drawable.spam_contact_picture);
    L8:
        return sDefailtSpamAvatar;
    L10:
        if (sDefaultAvatar != null) goto L13;
        sDefaultAvatar = BitmapFactory.decodeResource(getResources(), R.drawable.contact_picture);
    L13:
        return sDefaultAvatar;
    }

    private Bitmap getClassifyAvatar() {
        if (sClassifyAvatarHashmap.containsKey(this.mClassify) == true) goto L24;
        if ("crank".equals(this.mClassify) == false) goto L8;
        int r0 = R.drawable.classify_crank;
    L20:
        if (r0 <= 0) goto L24;
        Bitmap r1 = BitmapFactory.decodeResource(getResources(), r0);
        sClassifyAvatarHashmap.put(this.mClassify, r1);
        return r1;
    L8:
        if ("express".equals(this.mClassify) == false) goto L11;
        r0 = R.drawable.classify_express;
        goto L20
    L11:
        if ("promote sales".equals(this.mClassify) == false) goto L14;
        r0 = R.drawable.classify_promote_sales;
        goto L20
    L14:
        if ("fraud".equals(this.mClassify) == false) goto L17;
        r0 = R.drawable.classify_fraud;
        goto L20
    L17:
        if ("house agent".equals(this.mClassify) == false) goto L19;
        r0 = R.drawable.classify_house_agent;
        goto L20
    L19:
        r0 = -1;
    L24:
        return sClassifyAvatarHashmap.get(this.mClassify);
    }

    private Bitmap getDefaultGroupAvatar() {
        if (sDefaultGroupAvatar != null) goto L6;
        sDefaultGroupAvatar = BitmapFactory.decodeResource(getResources(), R.drawable.group_contacts_picture);
    L6:
        return sDefaultGroupAvatar;
    }

    private Bitmap drawClassifyAvatar(Bitmap bm) {
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        Canvas r2 = new Canvas(bm);
        r2.drawBitmap(this.mNameAvatarController.getRoundBG().copy(Bitmap.Config.ARGB_8888, true), null, getRect(), r0);
        r2.drawBitmap(ThumbnailUtils.extractThumbnail(getClassifyAvatar(), getWidth(), getHeight()), null, getRect(), r0);
        return bm;
    }

    public static void onColorThemeChange(Context context) {
        sDefaultAvatar = null;
        sDefaultGroupAvatar = null;
        NameAvatarController.getInstances(context).reInitRoundBG();
    }

    public void setName(String name) {
        String r2 = NameAvatarController.getContactPhotoName(getContext(), name);
        if (TextUtils.equals(r2, this.mDrawName) == true) goto L6;
        this.mDrawName = r2;
        invalidate();
        return;
    }

    public void setIsSpam(boolean isSpam) {
        if (this.mIsSpam == isSpam) goto L6;
        this.mIsSpam = isSpam;
        invalidate();
        return;
    }

    public void setIsGroup(boolean isGroup) {
        if (this.mIsGroup == isGroup) goto L6;
        this.mIsGroup = isGroup;
        invalidate();
        return;
    }

    public void setClassify(String classify) {
        if (TextUtils.equals(classify, this.mClassify) == true) goto L6;
        this.mClassify = classify;
        invalidate();
        return;
    }

    public void setIsInDatabase(boolean isInDatabase) {
        if (this.mIsInDatabase == isInDatabase) goto L6;
        this.mIsInDatabase = isInDatabase;
        invalidate();
        return;
    }

    public void setLogo(Bitmap logo) {
        if (logo != null) goto L4;
    L5:
        if (logo == null) goto L7;
        return;
    L7:
        if (this.mLogo == null) goto L11;
    L8:
        this.mLogo = logo;
        invalidate();
        return;
    L11:
        return;
    L4:
        if (logo.equals(this.mLogo) == false) goto L8;
        goto L5
    }

    public Bitmap getLogo() {
        return this.mLogo;
    }
}
