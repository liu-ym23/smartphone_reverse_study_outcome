package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

/* JADX INFO: loaded from: classes5.dex */
public class SliderWithIcons extends RelativeLayout {
    private static final String TAG = "SliderWithIcons";
    private ImageView mLeftIcon;
    private ImageView mRightIcon;
    private SmoothSeekBar mSeekBar;
    private SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;

    static {
    }

    static /* synthetic */ SeekBar.OnSeekBarChangeListener access$000(SliderWithIcons r0) {
        return r0.mSeekBarChangeListener;
    }

    public SliderWithIcons(Context context) {
        this(context, null);
    }

    public SliderWithIcons(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SliderWithIcons(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setGravity(16);
        View r0 = LayoutInflater.from(context).inflate(R.layout.slider_with_icons_layout, this, true);
        this.mLeftIcon = (ImageView) r0.findViewById(R.id.left_icon);
        this.mRightIcon = (ImageView) r0.findViewById(R.id.right_icon);
        SmoothSeekBar r1 = (SmoothSeekBar) r0.findViewById(R.id.seek_bar);
        this.mSeekBar = r1;
        r1.setOnSeekBarChangeListener(new AnonymousClass1(this));
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.SliderWithIcons, defStyle, 0);
        int r5 = r4.getResourceId(R.styleable.SliderWithIcons_left_icon_src, -1);
        int r6 = r4.getResourceId(R.styleable.SliderWithIcons_right_icon_src, -1);
        if (r5 <= 0) goto L6;
        if (r6 <= 0) goto L6;
        this.mLeftIcon.setImageResource(r5);
        this.mRightIcon.setImageResource(r6);
    L7:
        Drawable r7 = r4.getDrawable(R.styleable.SliderWithIcons_android_progressDrawable);
        if (r7 == null) goto L10;
        this.mSeekBar.setProgressDrawable(r7);
    L10:
        Drawable r8 = r4.getDrawable(R.styleable.SliderWithIcons_android_thumb);
        if (r8 == null) goto L13;
        this.mSeekBar.setThumb(r8);
    L13:
        r4.recycle();
        return;
    L6:
        this.mLeftIcon.setVisibility(8);
        this.mRightIcon.setVisibility(8);
        goto L7
    }

    public void setMax(int max) {
        this.mSeekBar.setMax(max);
    }

    public void setProgress(int progress) {
        this.mSeekBar.setProgress(progress);
    }

    public void setProgressSmooth(int progress) {
        this.mSeekBar.setProgressSmooth(progress);
    }

    public SeekBar getSeekBar() {
        return this.mSeekBar;
    }

    public ImageView getLeftImageView() {
        return this.mLeftIcon;
    }

    public void setLeftIconVisible(boolean visible) {
        ImageView r0 = this.mLeftIcon;
        if (visible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setLeftIcon(int resId) {
        this.mLeftIcon.setImageResource(resId);
    }

    public void setLeftIcon(Drawable d) {
        this.mLeftIcon.setImageDrawable(d);
    }

    public ImageView getRightImageView() {
        return this.mRightIcon;
    }

    public void setRightIconVisible(boolean visible) {
        ImageView r0 = this.mRightIcon;
        if (visible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setRightIcon(int resId) {
        this.mRightIcon.setImageResource(resId);
    }

    public void setRightIcon(Drawable d) {
        this.mRightIcon.setImageDrawable(d);
    }

    public int getProgress() {
        return this.mSeekBar.getProgress();
    }

    public int getMax() {
        return this.mSeekBar.getMax();
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener listener) {
        this.mSeekBarChangeListener = listener;
    }
}
