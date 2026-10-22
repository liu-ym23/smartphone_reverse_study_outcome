package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes5.dex */
public class ShadowChipsView extends RelativeLayout {
    private ChipsView mChipsView;
    private CharSequence mText;
    private int mType;

    public ShadowChipsView(Context context) {
        this(context, null);
    }

    public ShadowChipsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShadowChipsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray r0 = context.obtainStyledAttributes(attrs, R.styleable.ChipsView, defStyleAttr, 0);
        this.mType = r0.getInt(R.styleable.ChipsView_type, 0);
        r0.recycle();
        TypedArray r8 = context.obtainStyledAttributes(attrs, android.R.styleable.TextView, defStyleAttr, 0);
        boolean r9 = r8.getBoolean(30, true);
        boolean r1 = r8.getBoolean(0, true);
        int r2 = r8.getInt(10, 8388627);
        int r3 = r8.getInt(22, 1);
        CharSequence r4 = r8.getText(18);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        this.mText = r4;
    L5:
        r8.recycle();
        LayoutInflater.from(context).inflate(R.layout.chips_view_layout, this, true);
        ChipsView r7 = (ChipsView) findViewById(R.id.chips_view);
        this.mChipsView = r7;
        r7.setTextSize(13.5f);
        this.mChipsView.setClickable(r9);
        this.mChipsView.setGravity(r2);
        this.mChipsView.setMaxLines(r3);
        this.mChipsView.setEnabled(r1);
        if (r3 != 1) goto L8;
        this.mChipsView.setSingleLine();
    L8:
        setType(this.mType);
        setText(this.mText);
    }

    public void showShadow() {
        setBackgroundResource(R.drawable.chips_view_layout_bg);
    }

    public void hideShadow() {
        setBackgroundResource(0);
    }

    public void setType(int type) {
        this.mType = type;
        this.mChipsView.setType(type);
        int r2 = this.mType;
        if (r2 != 8) goto L5;
    L12:
        showShadow();
        return;
    L5:
        if (r2 == 12) goto L12;
        if (r2 == 10) goto L12;
        if (r2 == 9) goto L12;
        hideShadow();
    }

    public int getType() {
        return this.mChipsView.getType();
    }

    public void setText(CharSequence text) {
        if (TextUtils.isEmpty(text) == false) goto L5;
        return;
    L5:
        this.mText = text;
        this.mChipsView.setText(text);
    }

    public CharSequence getText() {
        return this.mText;
    }

    public ChipsView getChipsView() {
        return this.mChipsView;
    }
}
