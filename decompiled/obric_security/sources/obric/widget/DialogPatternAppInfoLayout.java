package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class DialogPatternAppInfoLayout extends LinearLayout {
    private ImageView mIcon;
    private TextView mSummary;
    private TextView mTitle;

    public DialogPatternAppInfoLayout(Context context) {
        this(context, null);
    }

    public DialogPatternAppInfoLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DialogPatternAppInfoLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(0);
        View r1 = LayoutInflater.from(context).inflate(R.layout.dlg_pattern_app_info_layout, this);
        this.mIcon = (ImageView) r1.findViewById(R.id.app_info_icon);
        this.mTitle = (TextView) r1.findViewById(R.id.app_info_title);
        this.mSummary = (TextView) r1.findViewById(R.id.app_info_summary);
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.DialogPatternAppInfoLayout, defStyleAttr, 0);
        setTitle(r4.getString(R.styleable.DialogPatternAppInfoLayout_smtTitle));
        setSummary(r4.getString(R.styleable.DialogPatternAppInfoLayout_smtSummary));
        Drawable r5 = r4.getDrawable(R.styleable.DialogPatternAppInfoLayout_smtIcon);
        if (r5 == null) goto L5;
        setIcon(r5);
    L5:
        r4.recycle();
    }

    public void setIcon(int resId) {
        setIcon(getResources().getDrawable(resId));
    }

    public void setIcon(Drawable d) {
        this.mIcon.setImageDrawable(d);
    }

    public void setTitle(CharSequence s) {
        this.mTitle.setText(s);
    }

    public void setTitle(int resId) {
        setTitle(getResources().getString(resId));
    }

    public void setSummary(CharSequence s) {
        this.mSummary.setText(s);
    }

    public void setSummary(int resId) {
        setSummary(getResources().getString(resId));
    }
}
