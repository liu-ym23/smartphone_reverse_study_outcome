package obric.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class DialogPatternTwoLineSingleChoice extends RelativeLayout {
    private ImageView mSelectedView;
    private TextView mSummary;
    private TextView mTitle;

    public DialogPatternTwoLineSingleChoice(Context context) {
        this(context, null);
    }

    public DialogPatternTwoLineSingleChoice(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DialogPatternTwoLineSingleChoice(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View r1 = LayoutInflater.from(context).inflate(R.layout.dlg_pattern_two_line_single_choice_item, this);
        this.mSelectedView = (ImageView) r1.findViewById(R.id.item_check);
        this.mTitle = (TextView) r1.findViewById(R.id.item_title);
        this.mSummary = (TextView) r1.findViewById(R.id.item_summary);
    }

    public void setTitle(int resId) {
        setTitle(getResources().getString(resId));
    }

    public void setTitle(CharSequence s) {
        this.mTitle.setText(s);
    }

    public void setSummary(int resId) {
        setSummary(getResources().getString(resId));
    }

    public void setSummary(CharSequence s) {
        this.mSummary.setText(s);
        TextView r1 = this.mSummary;
        if (TextUtils.isEmpty(s) == false) goto L5;
        int r2 = 8;
    L6:
        r1.setVisibility(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void setChecked(boolean checked) {
        ImageView r0 = this.mSelectedView;
        if (checked == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 4;
        goto L6
    }
}
