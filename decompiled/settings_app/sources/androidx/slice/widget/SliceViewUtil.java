package androidx.slice.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.format.DateUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class SliceViewUtil {
    public static int resolveLayoutDirection(int r1) {
        if (r1 != 2) goto L5;
        return r1;
    L5:
        if (r1 != 3) goto L7;
        return r1;
    L7:
        if (r1 == 1) goto L14;
        if (r1 == 0) goto L15;
        return -1;
    L15:
        return r1;
    L14:
        return r1;
    }

    public static int getColorAccent(Context r1) {
        return getColorAttr(r1, R.attr.colorAccent);
    }

    public static int getColorError(Context r1) {
        return getColorAttr(r1, R.attr.colorError);
    }

    public static int getDefaultColor(Context r0, int r1) {
        return ContextCompat.getColorStateList(r0, r1).getDefaultColor();
    }

    public static int getDisabled(Context r1, int r2) {
        return applyAlphaAttr(r1, R.attr.disabledAlpha, r2);
    }

    public static int applyAlphaAttr(Context r2, int r3, int r4) {
        TypedArray r5 = r2.obtainStyledAttributes(new int[]{r3});
        float r6 = r5.getFloat(0, 0.0f);
        r5.recycle();
        return applyAlpha(r6, r4);
    }

    public static int applyAlpha(float r2, int r3) {
        return Color.argb((int) (r2 * Color.alpha(r3)), Color.red(r3), Color.green(r3), Color.blue(r3));
    }

    public static int getColorAttr(Context r2, int r3) {
        TypedArray r4 = r2.obtainStyledAttributes(new int[]{r3});
        int r5 = r4.getColor(0, 0);
        r4.recycle();
        return r5;
    }

    public static int getThemeAttr(Context r2, int r3) {
        TypedArray r4 = r2.obtainStyledAttributes(new int[]{r3});
        int r5 = r4.getResourceId(0, 0);
        r4.recycle();
        return r5;
    }

    public static Drawable getDrawable(Context r2, int r3) {
        TypedArray r4 = r2.obtainStyledAttributes(new int[]{r3});
        Drawable r5 = r4.getDrawable(0);
        r4.recycle();
        return r5;
    }

    public static IconCompat createIconFromDrawable(Drawable r5) {
        if ((r5 instanceof BitmapDrawable) == true) goto L5;
        Bitmap r0 = Bitmap.createBitmap(r5.getIntrinsicWidth(), r5.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        r5.setBounds(0, 0, r1.getWidth(), r1.getHeight());
        r5.draw(r1);
        return IconCompat.createWithBitmap(r0);
    L5:
        return IconCompat.createWithBitmap(((BitmapDrawable) r5).getBitmap());
    }

    public static void createCircledIcon(Context r1, int r2, IconCompat r3, boolean r4, ViewGroup r5) {
        ImageView r0 = new ImageView(r1);
        r0.setImageDrawable(r3.loadDrawable(r1));
        if (r4 == false) goto L5;
        ImageView.ScaleType r6 = ImageView.ScaleType.CENTER_CROP;
    L6:
        r0.setScaleType(r6);
        r5.addView(r0);
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r0.getLayoutParams();
        if (r4 == false) goto L9;
        Bitmap r8 = Bitmap.createBitmap(r2, r2, Bitmap.Config.ARGB_8888);
        Canvas r9 = new Canvas(r8);
        r0.layout(0, 0, r2, r2);
        r0.draw(r9);
        r0.setImageBitmap(getCircularBitmap(r8));
    L10:
        r7.width = r2;
        r7.height = r2;
        r7.gravity = 17;
        return;
    L9:
        r0.setColorFilter(-1);
        goto L10
    L5:
        r6 = ImageView.ScaleType.CENTER_INSIDE;
        goto L6
    }

    public static Bitmap getCircularBitmap(Bitmap r7) {
        Bitmap r0 = Bitmap.createBitmap(r7.getWidth(), r7.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        Paint r2 = new Paint();
        Rect r3 = new Rect(0, 0, r7.getWidth(), r7.getHeight());
        r2.setAntiAlias(true);
        r1.drawARGB(0, 0, 0, 0);
        r1.drawCircle(r7.getWidth() / 2, r7.getHeight() / 2, r7.getWidth() / 2, r2);
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r1.drawBitmap(r7, r3, r3, r2);
        return r0;
    }

    public static CharSequence getTimestampString(Context r7, long r8) {
        if (r8 < System.currentTimeMillis()) goto L10;
        if (DateUtils.isToday(r8) == true) goto L10;
        return DateUtils.formatDateTime(r7, r8, 8);
    L10:
        return DateUtils.getRelativeTimeSpanString(r8, Calendar.getInstance().getTimeInMillis(), 60000, 262144);
    }

    public static void tintIndeterminateProgressBar(Context r2, ProgressBar r3) {
        int r4 = getColorAttr(r2, androidx.slice.view.R.attr.colorControlHighlight);
        Drawable r0 = DrawableCompat.wrap(r3.getIndeterminateDrawable());
        if (r0 == null) goto L6;
        r0.setColorFilter(r4, PorterDuff.Mode.MULTIPLY);
        r3.setProgressDrawable(r0);
        return;
    }

    private SliceViewUtil() {
    }
}
