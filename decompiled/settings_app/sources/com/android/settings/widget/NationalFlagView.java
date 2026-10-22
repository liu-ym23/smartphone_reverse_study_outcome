package com.android.settings.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class NationalFlagView {
    private static final boolean ENABLE_REORDER_NATIONAL_FLAG = false;
    private static int HONG_KONG_FLAG_INDEX = 1;
    private static int IMAGE_HEIGHT = 0;
    private static int IMAGE_WIDTH = 0;
    private static int MAX_FLAGS_COUNT = 0;
    private static final int RESIDENT_FLAG_SIZE = 7;
    private static final String TAG = "NationalFlagView";
    private static List<LocaleFlag> mFlagArray = null;
    private static boolean mSkipHongkongFlag = true;
    private Context mContext;
    private Drawable mFlagDrawable;
    private Locale mLocaleOfFlagImage;

    private static class LocaleFlag {
        int flagRes;
        Locale locale;

        public LocaleFlag(Locale r1, int r2) {
            this.locale = r1;
            this.flagRes = r2;
        }
    }

    static {
        mFlagArray = Arrays.asList(new LocaleFlag[]{new LocaleFlag(Locale.SIMPLIFIED_CHINESE, R.drawable.flag_china), new LocaleFlag(Locale.TRADITIONAL_CHINESE, R.drawable.flag_hong_kong), new LocaleFlag(Locale.GERMANY, R.drawable.flag_germany), new LocaleFlag(Locale.US, R.drawable.flag_usa), new LocaleFlag(Locale.FRANCE, R.drawable.flag_france), new LocaleFlag(Locale.KOREA, R.drawable.flag_korea), new LocaleFlag(Locale.JAPAN, R.drawable.flag_japan), new LocaleFlag(Locale.TRADITIONAL_CHINESE, R.drawable.flag_china), new LocaleFlag(new Locale("in", "ID"), R.drawable.flag_of_indonesia), new LocaleFlag(new Locale("ru", "Ru"), R.drawable.flag_russia)});
    }

    public NationalFlagView(Context r2) {
        Context r3 = r2.getApplicationContext();
        this.mContext = r3;
        IMAGE_HEIGHT = r3.getResources().getDimensionPixelSize(R.dimen.national_flag_size_height);
        IMAGE_WIDTH = this.mContext.getResources().getDimensionPixelSize(R.dimen.national_flag_size_width);
        if (this.mContext.getResources().getDisplayMetrics().density != 3.5f) goto L6;
        mSkipHongkongFlag = false;
    L6:
        if (mSkipHongkongFlag == false) goto L8;
        int r1 = 6;
    L9:
        MAX_FLAGS_COUNT = r1;
        return;
    L8:
        r1 = 7;
        goto L9
    }

    public void updateFlagViewIfNeed(LinearLayout r4) {
        boolean r0 = !Locale.getDefault().equals(this.mLocaleOfFlagImage);
        this.mLocaleOfFlagImage = Locale.getDefault();
        OLog.d(TAG, "isNeedUpdate " + r0);
        updateFlagImage(r4);
    }

    private static int getPositionInList(Locale r3) {
        int r0 = 0;
    L4:
        if (r0 >= mFlagArray.size()) goto L14;
        if (mSkipHongkongFlag == false) goto L11;
        if (r0 != HONG_KONG_FLAG_INDEX) goto L11;
    L13:
        r0 = r0 + 1;
    L11:
        if (mFlagArray.get(r0).locale.getCountry().equals(r3.getCountry()) == false) goto L13;
        return r0;
    L14:
        return -1;
    }

    private static Bitmap createFlagBitmap(Context r13) {
        Locale r0 = Locale.SIMPLIFIED_CHINESE;
        OLog.d(TAG, "currentLocale: " + r0 + ", country: " + r0.getCountry());
        int r1 = r13.getResources().getDimensionPixelSize(R.dimen.national_flag_spacing);
        int r2 = IMAGE_WIDTH;
        int r3 = MAX_FLAGS_COUNT;
        Bitmap r4 = Bitmap.createBitmap((r2 * r3) + (r3 * r1), IMAGE_HEIGHT, Bitmap.Config.ARGB_8888);
        Canvas r5 = new Canvas(r4);
        int r6 = getPositionInList(r0);
        boolean r8 = true;
        int r9 = 0;
        if (r6 <= (-1)) goto L5;
        r5.drawBitmap(BitmapFactory.decodeResource(r13.getResources(), mFlagArray.get(r6).flagRes), 0.0f, 6.0f, null);
        int r7 = 1;
    L7:
        if (r6 < 7) goto L10;
        r8 = false;
    L10:
        if (r9 >= 7) goto L25;
        if (mSkipHongkongFlag == true) goto L14;
    L16:
        LocaleFlag r10 = mFlagArray.get(r9);
        if (r8 == true) goto L19;
        if (r9 == 0) goto L24;
    L23:
        r5.drawBitmap(BitmapFactory.decodeResource(r13.getResources(), r10.flagRes), (IMAGE_WIDTH + r1) * r7, 6.0f, null);
        r7 = r7 + 1;
    L24:
        r9 = r9 + 1;
        goto L10
    L19:
        if (r10.locale.getCountry().equals(r0.getCountry()) == false) goto L23;
    L14:
        if (r9 != HONG_KONG_FLAG_INDEX) goto L16;
    L25:
        return r4;
    L5:
        r7 = 0;
        goto L7
    }

    private static Drawable getNationalFlagDrawable(Context r2) {
        return new BitmapDrawable(r2.getResources(), createFlagBitmap(r2));
    }

    private void updateFlagImage(LinearLayout r9) {
        r9.setWeightSum(7.0f);
        Locale r0 = Locale.SIMPLIFIED_CHINESE;
        int r1 = getPositionInList(r0);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        if (r1 <= (-1)) goto L5;
        ImageView r3 = new ImageView(this.mContext);
        r3.setLayoutParams(r2);
        r3.setImageResource(mFlagArray.get(r1).flagRes);
        r9.addView(r3);
    L5:
        int r4 = 0;
        if (r1 >= 7) goto L8;
        boolean r5 = true;
    L9:
        if (r4 >= 7) goto L24;
        if (mSkipHongkongFlag == true) goto L13;
    L15:
        LocaleFlag r6 = mFlagArray.get(r4);
        if (r5 == true) goto L18;
        if (r4 == 0) goto L23;
    L22:
        ImageView r7 = new ImageView(this.mContext);
        r7.setLayoutParams(r2);
        r7.setImageResource(r6.flagRes);
        r9.addView(r7);
    L23:
        r4 = r4 + 1;
        goto L9
    L18:
        if (r6.locale.getCountry().equals(r0.getCountry()) == false) goto L22;
    L13:
        if (r4 != HONG_KONG_FLAG_INDEX) goto L15;
    L24:
        return;
    L8:
        r5 = false;
        goto L9
    }
}
