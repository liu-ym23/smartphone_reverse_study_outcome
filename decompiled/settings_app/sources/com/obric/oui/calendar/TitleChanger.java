package com.obric.oui.calendar;

import android.R;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.obric.oui.calendar.format.TitleFormatter;

/* JADX INFO: loaded from: classes4.dex */
class TitleChanger {
    public static final int DEFAULT_ANIMATION_DELAY = 400;
    public static final int DEFAULT_Y_TRANSLATION_DP = 20;
    private final int animDelay;
    private final int animDuration;
    private final Interpolator interpolator;
    private long lastAnimTime;
    private int orientation;
    private CalendarDay previousMonth;
    private final TextView title;
    private TitleFormatter titleFormatter;
    private final int translate;

    static /* synthetic */ TextView access$000(TitleChanger r0) {
        return r0.title;
    }

    static /* synthetic */ void access$100(TitleChanger r0, TextView r1, int r2) {
        r0.doTranslation(r1, r2);
    }

    static /* synthetic */ int access$200(TitleChanger r0) {
        return r0.orientation;
    }

    static /* synthetic */ Interpolator access$300(TitleChanger r0) {
        return r0.interpolator;
    }

    static /* synthetic */ int access$400(TitleChanger r0) {
        return r0.animDuration;
    }

    public TitleChanger(TextView r3) {
        this.titleFormatter = TitleFormatter.DEFAULT;
        this.interpolator = new DecelerateInterpolator(2.0f);
        this.orientation = 0;
        this.lastAnimTime = 0;
        this.previousMonth = null;
        this.title = r3;
        Resources r4 = r3.getResources();
        this.animDelay = 400;
        this.animDuration = r4.getInteger(R.integer.config_shortAnimTime) / 2;
        this.translate = (int) TypedValue.applyDimension(1, 20.0f, r4.getDisplayMetrics());
    }

    public void change(CalendarDay r7) {
        long r0 = System.currentTimeMillis();
        if (r7 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.title.getText()) == false) goto L8;
    L9:
        doChange(r0, r7, false);
    L11:
        if (r7.equals(this.previousMonth) == false) goto L13;
        return;
    L13:
        if (r7.getMonth() == this.previousMonth.getMonth()) goto L15;
    L17:
        doChange(r0, r7, true);
        return;
    L15:
        if (r7.getYear() != this.previousMonth.getYear()) goto L17;
        return;
    L8:
        if ((r0 - this.lastAnimTime) >= this.animDelay) goto L11;
        goto L9
    }

    private void doChange(long r3, CalendarDay r5, boolean r6) {
        this.title.animate().cancel();
        doTranslation(this.title, 0);
        this.title.setAlpha(1.0f);
        this.lastAnimTime = r3;
        final CharSequence r4 = this.titleFormatter.format(r5);
        if (r6 == true) goto L5;
        this.title.setText(r4);
    L14:
        this.previousMonth = r5;
        return;
    L5:
        int r7 = this.translate;
        if (this.previousMonth.isBefore(r5) == false) goto L8;
        int r8 = 1;
    L9:
        final int r9 = r7 * r8;
        ViewPropertyAnimator r10 = this.title.animate();
        if (this.orientation != 1) goto L12;
        r10.translationX(r9 * (-1));
    L13:
        r10.alpha(0.0f).setDuration(this.animDuration).setInterpolator(this.interpolator).setListener(new AnonymousClass1(this, r4, r9)).start();
        goto L14
    L12:
        r10.translationY(r9 * (-1));
        goto L13
    L8:
        r8 = -1;
        goto L9
    }

    private void doTranslation(TextView r2, int r3) {
        if (this.orientation != 1) goto L5;
        r2.setTranslationX(r3);
        return;
    L5:
        r2.setTranslationY(r3);
    }

    public void setTitleFormatter(TitleFormatter r1) {
        if (r1 != null) goto L4;
        r1 = TitleFormatter.DEFAULT;
    L4:
        this.titleFormatter = r1;
    }

    public void setOrientation(int r1) {
        this.orientation = r1;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setPreviousMonth(CalendarDay r1) {
        this.previousMonth = r1;
    }
}
