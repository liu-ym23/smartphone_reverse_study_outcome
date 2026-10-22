package obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class BHMItemView extends RelativeLayout {
    public static final int COUNT_BLUE = 0;
    public static final int COUNT_GREY = 2;
    public static final int COUNT_RED = 1;
    private ImageView mAlert;
    private TextView mCount;
    private String mCountNum;
    private ImageView mIcon;
    private ProgressBar mProgressBar;
    private View mRootView;
    private TextView mSubTitle;
    private TextView mTitle;

    public BHMItemView(Context context) {
        super(context);
    }

    public BHMItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BHMItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mRootView = findViewById(R.id.bhm_item_layout);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mIcon = (ImageView) findViewById(R.id.icon);
        this.mCount = (TextView) findViewById(R.id.count);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
        this.mSubTitle = (TextView) findViewById(R.id.subtitle);
        this.mAlert = (ImageView) findViewById(R.id.alert);
    }

    public void bind(String title, int iconResId, String count, int countColor, boolean showProgressBar, boolean showAlert, String subTitle, int paddingLeft) {
        setTitle(title);
        Resources r2 = getResources();
        if (TextUtils.isEmpty(subTitle) == false) goto L5;
        int r0 = R.dimen.bhm_list_view_title_max_width;
    L6:
        setTitleMaxWidth(r2.getDimensionPixelOffset(r0));
        setIcon(iconResId);
        setCount(count);
        setCountColor(countColor);
        showProgressBar(showProgressBar);
        showAlert(showAlert);
        setSubTitle(subTitle);
        setLeftPadding(paddingLeft);
        return;
    L5:
        r0 = R.dimen.bhm_list_view_title_max_width_subtitle_exists;
        goto L6
    }

    public void setIcon(int iconResId) {
        this.mIcon.setBackgroundResource(iconResId);
    }

    public void setIcon(Drawable drawable) {
        this.mIcon.setBackground(drawable);
    }

    public void setCount(final String countStr) {
        this.mCountNum = countStr;
        boolean r0 = TextUtils.isEmpty(countStr);
        TextView r1 = this.mCount;
        if (r0 == true) goto L5;
        int r2 = 0;
    L6:
        r1.setVisibility(r2);
        if (r0 == true) goto L10;
        this.mCount.setText(countStr);
        return;
    L10:
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setCountColor(final int color) {
        if (color != 0) goto L4;
        int r2 = R.drawable.bhm_num_blue_2;
    L11:
        this.mCount.setBackgroundResource(r2);
        return;
    L4:
        if (color != 1) goto L6;
        r2 = R.drawable.bhm_num_red;
        goto L11
    L6:
        if (color == 2) goto L8;
        r2 = R.drawable.bhm_num_blue_2;
        goto L11
    L8:
        r2 = R.drawable.bhm_num_grey;
        goto L11
    }

    public void setTitleColor(final int color) {
        this.mTitle.setTextColor(color);
    }

    public void setTitle(String title) {
        this.mTitle.setText(title);
    }

    public void setTitleMaxWidth(int maxWidth) {
        this.mTitle.setMaxWidth(maxWidth);
    }

    public void setTitleSelected(boolean isSelected) {
        this.mTitle.setSelected(isSelected);
    }

    public void setCountSelected(boolean isSelected) {
        this.mCount.setSelected(isSelected);
    }

    public final String getCount() {
        return this.mCountNum;
    }

    public void setSubTitle(String text) {
        if (TextUtils.isEmpty(text) == true) goto L5;
        this.mSubTitle.setVisibility(0);
        this.mSubTitle.setText(text);
        return;
    L5:
        this.mSubTitle.setVisibility(8);
    }

    public String getSubTitle() {
        return this.mSubTitle.getText().toString();
    }

    public void showAlert(boolean isShow) {
        ImageView r0 = this.mAlert;
        if (isShow == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void showProgressBar(boolean isShow) {
        ProgressBar r0 = this.mProgressBar;
        if (isShow == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setLeftPadding(int left) {
        setPadding(left, 0, 0, 0);
    }
}
