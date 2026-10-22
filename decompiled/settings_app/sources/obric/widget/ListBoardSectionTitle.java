package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class ListBoardSectionTitle extends LinearLayout {
    private View mDivider;
    private ImageView mSectionArrow;
    private View mSectionInfoLayout;
    private TextView mSectionTitle;
    private View mTopSpace;

    public ListBoardSectionTitle(Context context) {
        this(context, null);
    }

    public ListBoardSectionTitle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListBoardSectionTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(1);
        View r1 = LayoutInflater.from(context).inflate(R.layout.list_board_section_title_layout, this);
        this.mTopSpace = r1.findViewById(R.id.top_space);
        this.mSectionInfoLayout = r1.findViewById(R.id.section_info);
        this.mSectionTitle = (TextView) r1.findViewById(R.id.section_title);
        this.mSectionArrow = (ImageView) r1.findViewById(R.id.section_arrow);
        this.mDivider = r1.findViewById(R.id.divider);
    }

    public void setTopSpaceVisible(boolean visible) {
        View r0 = this.mTopSpace;
        if (visible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setSectionInfoVisible(boolean visible) {
        View r0 = this.mSectionInfoLayout;
        int r1 = 0;
        if (visible == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        View r4 = this.mDivider;
        if (visible == true) goto L10;
        r1 = 8;
    L10:
        r4.setVisibility(r1);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setSectionArrowVisible(boolean visible) {
        ImageView r0 = this.mSectionArrow;
        if (visible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setSectionTitle(CharSequence s) {
        this.mSectionTitle.setText(s);
    }

    public void setSectionTitle(int resId) {
        setSectionTitle(getResources().getString(resId));
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.mSectionInfoLayout.setOnClickListener(l);
    }
}
