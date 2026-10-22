package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class DialogPatternSectionGroup extends LinearLayout {
    private TextView mMessage;
    private TextView mPrimaryTitle;
    private TextView mSubtitle;

    public DialogPatternSectionGroup(Context context) {
        this(context, null);
    }

    public DialogPatternSectionGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DialogPatternSectionGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(1);
        View r0 = LayoutInflater.from(context).inflate(R.layout.dlg_pattern_section_group_layout, this);
        this.mPrimaryTitle = (TextView) r0.findViewById(R.id.section_primary_title);
        this.mSubtitle = (TextView) r0.findViewById(R.id.section_subtitle);
        this.mMessage = (TextView) r0.findViewById(R.id.section_message);
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.DialogPatternSectionGroup, defStyleAttr, 0);
        setPrimaryTitle(r3.getString(R.styleable.DialogPatternSectionGroup_section_primary_title));
        setSubtitle(r3.getString(R.styleable.DialogPatternSectionGroup_section_subtitle));
        setMessage(r3.getString(R.styleable.DialogPatternSectionGroup_section_message));
        r3.recycle();
    }

    public void setPrimaryTitle(int resId) {
        setPrimaryTitle(getResources().getString(resId));
    }

    public void setPrimaryTitle(CharSequence s) {
        this.mPrimaryTitle.setText(s);
        TextView r1 = this.mPrimaryTitle;
        if (TextUtils.isEmpty(s) == false) goto L5;
        int r2 = 8;
    L6:
        r1.setVisibility(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void setSubtitle(int resId) {
        setSubtitle(getResources().getString(resId));
    }

    public void setSubtitle(CharSequence s) {
        this.mSubtitle.setText(s);
        TextView r1 = this.mSubtitle;
        if (TextUtils.isEmpty(s) == false) goto L5;
        int r2 = 8;
    L6:
        r1.setVisibility(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void setMessage(int resId) {
        setMessage(getResources().getString(resId));
    }

    public void setMessage(CharSequence s) {
        this.mMessage.setText(s);
        TextView r1 = this.mMessage;
        if (TextUtils.isEmpty(s) == false) goto L5;
        int r2 = 8;
    L6:
        r1.setVisibility(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
