package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes5.dex */
public class Button extends android.widget.Button {
    public static final int STYLE_AREA_ONLY_ICON = 7;
    public static final int STYLE_BACK = 1;
    public static final int STYLE_CUSTOM_BACKGROUND = 9;
    public static final int STYLE_DELETE = 3;
    public static final int STYLE_HIGHLIGHT_BLUE = 4;
    public static final int STYLE_HIGHLIGHT_RED = 5;
    public static final int STYLE_MIX = 10;
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NORMAL_WITH_ICON = 6;
    public static final int STYLE_SEARCH = 8;
    public static final int STYLE_SETTING = 2;
    public static final int STYLE_TNT_3_BLUE = 11;
    private int mAreaIconHeight;
    private int mAreaIconWidth;
    private int mBtnFixedHeight;
    private int mBtnFixedWidth;
    private int mButtonStyle;
    private Bitmap mImageBitmap;
    private int mImageSourceId;

    public Button(Context context) {
        this(context, null);
    }

    public Button(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Button(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mBtnFixedWidth = (int) context.getResources().getDimension(R.dimen.obric_button_fixed_width);
        this.mBtnFixedHeight = (int) context.getResources().getDimension(R.dimen.samrtisan_button_fixed_height);
        this.mAreaIconWidth = (int) context.getResources().getDimension(R.dimen.obric_button_icon_area_width);
        this.mAreaIconHeight = (int) context.getResources().getDimension(R.dimen.obric_button_icon_area_height);
        TypedArray r2 = context.obtainStyledAttributes(attrs, R.styleable.BytedanceButton);
        this.mButtonStyle = r2.getInt(R.styleable.BytedanceButton_smtButtonStyle, -1);
        this.mImageSourceId = r2.getResourceId(R.styleable.BytedanceButton_buttonSrc, -1);
        r2.recycle();
        setGravity(17);
        setTypeface(Typeface.DEFAULT_BOLD);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        setTextSize(0, getResources().getDimension(R.dimen.semi_small_text_size));
        int r3 = this.mImageSourceId;
        if (r3 < 0) goto L6;
        setButtonSourceBitmap(r3);
    L6:
        if (this.mButtonStyle < 0) goto L9;
        init();
        return;
    }

    public void setButtonSourceBitmap(int resId) {
        if (resId >= 0) goto L4;
        return;
    L4:
        int r0 = this.mButtonStyle;
        if (r0 == 6) goto L10;
        if (r0 == 7) goto L10;
        return;
    L10:
        if (this.mAreaIconHeight > 0) goto L12;
        return;
    L12:
        Bitmap r9 = BitmapFactory.decodeResource(getContext().getResources(), resId);
        this.mImageBitmap = r9;
        if (r9 != null) goto L15;
    L17:
        invalidate();
        return;
    L15:
        if (r9.getHeight() <= this.mAreaIconHeight) goto L17;
        Matrix r6 = new Matrix();
        float r10 = this.mAreaIconHeight / this.mImageBitmap.getHeight();
        r6.postScale(r10, r10);
        Bitmap r1 = this.mImageBitmap;
        this.mImageBitmap = Bitmap.createBitmap(r1, 0, 0, r1.getWidth(), this.mImageBitmap.getHeight(), r6, true);
        goto L17
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int r0 = this.mButtonStyle;
        if (r0 != 6) goto L5;
    L6:
        if (r0 != 6) goto L8;
        int r2 = this.mBtnFixedWidth;
    L9:
        if (r0 != 6) goto L11;
        int r1 = this.mBtnFixedHeight;
    L12:
        int r3 = View.MeasureSpec.getMode(widthMeasureSpec);
        int r6 = View.MeasureSpec.getSize(widthMeasureSpec);
        int r4 = View.MeasureSpec.getMode(heightMeasureSpec);
        int r7 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (r3 != 1073741824) goto L15;
        r2 = r6;
    L15:
        if (r4 != 1073741824) goto L17;
        r1 = r7;
    L17:
        setMeasuredDimension(r2, r1);
        return;
    L11:
        r1 = this.mAreaIconHeight;
        goto L12
    L8:
        r2 = this.mAreaIconWidth;
        goto L9
    L5:
        if (r0 == 7) goto L6;
    }

    private void init() {
        setClickable(true);
        initButtonStyle(this.mButtonStyle);
    }

    private void initButtonStyle(int styleType) {
        switch(styleType) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L16;
            case 11: goto L5;
            default: goto L16;
        };
    L5:
        setMaxWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_max_width));
        setMinWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_min_width));
        setTextColor(getContext().getResources().getColor(R.color.white));
        setBackgroundResource(R.drawable.selector_small_btn_highlight_tnt_3_blue);
        goto L16
    L6:
        setText("");
        goto L16
    L7:
        setText("");
        setBackgroundResource(R.drawable.selector_small_icon_btn_search);
        goto L16
    L8:
        setText("");
        setBackground(new ColorDrawable(0));
        goto L16
    L9:
        setText("");
        setMinWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_min_width));
        setMaxWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_min_width));
        setBackgroundResource(R.drawable.selector_small_btn_standard);
        goto L16
    L10:
        setMaxWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_max_width));
        setMinWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_min_width));
        setTextColor(getContext().getResources().getColor(R.color.white));
        setShadowLayer(0.1f, 0.0f, -2.0f, getContext().getResources().getColor(R.color.obric_button_highlight_enable_shadow_color));
        setBackgroundResource(R.drawable.selector_small_btn_highlight_red);
        goto L16
    L11:
        setMaxWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_max_width));
        setMinWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_min_width));
        setTextColor(getContext().getResources().getColor(R.color.white));
        setShadowLayer(0.1f, 0.0f, -2.0f, getContext().getResources().getColor(R.color.obric_button_highlight_enable_shadow_color));
        setBackgroundResource(R.drawable.selector_small_btn_highlight);
        goto L16
    L12:
        setText("");
        setBackgroundResource(R.drawable.selector_small_icon_btn_delete);
        goto L16
    L13:
        setText("");
        setBackgroundResource(R.drawable.selector_small_icon_btn_setting);
        goto L16
    L14:
        setMaxWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_max_width));
        setMinWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_min_width));
        setTextColor(getContext().getResources().getColor(R.color.obric_button_normal_text_color));
        setShadowLayer(0.1f, 0.0f, 2.0f, getContext().getResources().getColor(R.color.obric_button_normal_enable_shadow_color));
        setBackgroundResource(R.drawable.selector_small_btn_back);
        goto L16
    L15:
        setMaxWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_max_width));
        setMinWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_min_width));
        setTextColor(getContext().getResources().getColor(R.color.obric_button_normal_text_color));
        setShadowLayer(0.1f, 0.0f, 2.0f, getContext().getResources().getColor(R.color.obric_button_normal_enable_shadow_color));
        setBackgroundResource(R.drawable.selector_small_btn_standard);
    L16:
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L20;
        return;
    L20:
        if (styleType != 6) goto L23;
        r0.width = this.mBtnFixedWidth;
        r0.height = this.mBtnFixedHeight;
    L26:
        setLayoutParams(r0);
        return;
    L23:
        if (styleType != 7) goto L25;
        r0.width = this.mAreaIconWidth;
        r0.height = this.mAreaIconHeight;
        goto L26
    L25:
        r0.width = -2;
        r0.height = -2;
        goto L26
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r0 = this.mButtonStyle;
        if (r0 == 6) goto L7;
        if (r0 == 7) goto L7;
        return;
    L7:
        if (this.mImageBitmap == null) goto L11;
        canvas.drawBitmap(this.mImageBitmap, (getWidth() - this.mImageBitmap.getWidth()) / 2, (getHeight() - this.mImageBitmap.getHeight()) / 2, new Paint());
        return;
    }

    public void setButtonStyle(int style) {
        if (style >= 0) goto L4;
        return;
    L4:
        this.mButtonStyle = style;
        init();
    }

    public void setButtonText(String text) {
        if (TextUtils.isEmpty(text) == false) goto L5;
        return;
    L5:
        int r0 = this.mButtonStyle;
        if (r0 != 2) goto L8;
        return;
    L8:
        if (r0 != 3) goto L10;
        return;
    L10:
        if (r0 != 8) goto L12;
        return;
    L12:
        if (r0 != 6) goto L14;
        return;
    L14:
        if (r0 != 7) goto L16;
        return;
    L16:
        if (r0 == 9) goto L25;
        setText(text);
        return;
    }

    public void setButtonText(int resId) {
        setButtonText(getResources().getString(resId));
    }

    public void setEnabledStyle(boolean enable) {
        if (enable == false) goto L4;
        float r0 = 1.0f;
    L5:
        setAlpha(r0);
        int r1 = this.mButtonStyle;
        if (r1 == 0) goto L19;
        if (r1 == 1) goto L19;
        if (r1 == 4) goto L15;
        if (r1 == 5) goto L15;
        return;
    L15:
        if (enable == false) goto L17;
        setShadowLayer(0.1f, 0.0f, -2.0f, getContext().getResources().getColor(R.color.obric_button_highlight_enable_shadow_color));
        return;
    L17:
        setShadowLayer(0.1f, 0.0f, -2.0f, 0);
        return;
    L19:
        if (enable == false) goto L21;
        setShadowLayer(0.1f, 0.0f, 2.0f, getContext().getResources().getColor(R.color.obric_button_normal_enable_shadow_color));
        return;
    L21:
        setShadowLayer(0.1f, 0.0f, 2.0f, 0);
        return;
    L4:
        r0 = 0.5f;
        goto L5
    }
}
