package obric.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class ChipsView extends TextView {
    public static final float CHIPS_DEFAULT_FONT_SIZE = 13.5f;
    public static final int CHIPS_MAX_LINES = 1;
    public static final int ERROR = 4;
    public static final int FLOATED = 8;
    public static final int FLOATED_ERROR = 12;
    public static final int FLOATED_REMOVE = 10;
    public static final int FLOATED_VIP = 9;
    public static final int HISTORY = 144;
    public static final int HOT = 145;
    public static final int LIGHT = 147;
    public static final int NORMAL = 0;
    public static final int RECOMMENDED = 146;
    public static final int REMOVE = 2;
    public static final int REMOVE_ERROR = 6;
    public static final int VIP = 1;
    public static final int VIP_ERROR = 5;
    private int mType;

    public ChipsView(Context context) {
        this(context, null);
    }

    public ChipsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChipsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mType = 0;
        TypedArray r1 = context.obtainStyledAttributes(attrs, R.styleable.ChipsView, defStyleAttr, 0);
        int r2 = r1.getInt(R.styleable.ChipsView_type, 0);
        r1.recycle();
        TypedArray r5 = context.obtainStyledAttributes(attrs, android.R.styleable.TextView, defStyleAttr, 0);
        boolean r6 = r5.getBoolean(30, true);
        int r0 = r5.getInt(10, 8388627);
        int r3 = r5.getInt(22, 1);
        setTextSize(13.5f);
        setClickable(r6);
        setGravity(r0);
        setMaxLines(r3);
        if (r3 != 1) goto L5;
        setSingleLine();
    L5:
        setType(r2);
        r5.recycle();
    }

    public void setType(int type) {
        this.mType = type;
        update();
    }

    public int getType() {
        return this.mType;
    }

    private void update() {
        int r0 = R.drawable.chips_normal_selector;
        int r1 = R.color.chips_normal_colorlist;
        int r2 = this.mType;
        if (r2 != 1) goto L5;
    L28:
        r0 = R.drawable.chips_vip_selector;
    L29:
        setBackgroundResource(r0);
        setTextColor(getResources().getColorStateList(r1));
        return;
    L5:
        if (r2 != 2) goto L7;
    L27:
        r0 = R.drawable.chips_remove_selector;
        goto L29
    L7:
        if (r2 != 4) goto L9;
    L26:
        r0 = R.drawable.chips_error_selector;
        r1 = R.color.chips_error_colorlist;
        goto L29
    L9:
        if (r2 != 5) goto L11;
        r0 = R.drawable.chips_vip_error_selector;
        r1 = R.color.chips_error_colorlist;
        goto L29
    L11:
        if (r2 != 6) goto L13;
        r0 = R.drawable.chips_remove_error_selector;
        r1 = R.color.chips_error_colorlist;
        goto L29
    L13:
        if (r2 == 9) goto L28;
        if (r2 == 10) goto L27;
        if (r2 == 12) goto L26;
        switch(r2) {
            case 144: goto L23;
            case 145: goto L22;
            case 146: goto L21;
            case 147: goto L20;
            default: goto L29;
        };
    L20:
        r0 = R.drawable.chips_light_selector;
        r1 = R.color.chips_light_colorlist;
        goto L29
    L21:
        r0 = R.drawable.chips_recommended_selector;
        r1 = R.color.chips_recommended_colorlist;
        goto L29
    L22:
        r0 = R.drawable.chips_hot_selector;
        r1 = R.color.chips_hot_colorlist;
        goto L29
    L23:
        r0 = R.drawable.chips_history_selector;
        r1 = R.color.chips_history_colorlist;
        goto L29
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int r0 = this.mType;
        if (r0 != 0) goto L5;
    L12:
        updateTextShadow(-2.0f);
        return;
    L5:
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L12;
        if (r0 == 147) goto L12;
        switch(r0) {
            case 8: goto L12;
            case 9: goto L12;
            case 10: goto L12;
            default: goto L11;
        };
    L11:
        updateTextShadow(0.0f);
    }

    private void updateTextShadow(float dy) {
        ColorStateList r0 = getResources().getColorStateList(R.color.chips_shadow_colorlist);
        if (r0 == null) goto L6;
        setShadowLayer(0.1f, 0.0f, dy, r0.getColorForState(getDrawableState(), 0));
        invalidate();
        return;
    }
}
