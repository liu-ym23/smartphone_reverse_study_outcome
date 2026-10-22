package obric.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes5.dex */
public class SettingItemText extends ListContentItemText {
    private ImageView mBadgeImageView;
    private ImageView mInfoBtn;
    private ViewStub mInfoBtnVS;

    public SettingItemText(Context context) {
        this(context, null);
    }

    public SettingItemText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingItemText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ImageView getBadgeImageView() {
        return this.mBadgeImageView;
    }

    public void setIconResource(int iconRes) {
        setIcon(iconRes);
    }

    public void setIconDrawable(Drawable iconDrawable) {
        setIcon(iconDrawable);
    }

    public void setIconRightMargin(int marginRight) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mLeftContainer.getLayoutParams();
        r0.rightMargin = marginRight;
        this.mLeftContainer.setLayoutParams(r0);
    }

    public void setSubTitle(CharSequence aSubTitle) {
        setSubtitle(aSubTitle);
    }

    public void setSubTitle(int subTitleRes) {
        setSubtitle(subTitleRes);
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return R.layout.setting_item_mid_layout;
    }

    @Override // obric.widget.ListContentItem
    protected void initMidWidget() {
        super.initMidWidget();
        this.mInfoBtnVS = (ViewStub) findViewById(R.id.info_btn_viewstub);
    }

    public void setupInfoButton(boolean visible, View.OnClickListener listener) {
        if (visible == true) goto L4;
        ImageView r1 = this.mInfoBtn;
        if (r1 == null) goto L12;
        r1.setVisibility(8);
        return;
    L12:
        return;
    L4:
        if (this.mInfoBtn != null) goto L6;
        this.mInfoBtn = (ImageView) this.mInfoBtnVS.inflate();
    L6:
        this.mInfoBtn.setVisibility(0);
        this.mInfoBtn.setOnClickListener(listener);
    }

    @Deprecated
    public void setItemEnable(boolean enabled) {
        setEnabled(enabled);
    }

    public void setBadgeResources(int badgeResId) {
        if (badgeResId > 0) goto L4;
        this.mBadgeImageView = null;
    L8:
        setRightExpandView(this.mBadgeImageView);
        return;
    L4:
        if (this.mBadgeImageView != null) goto L6;
        this.mBadgeImageView = new ImageView(getContext());
    L6:
        this.mBadgeImageView.setImageResource(badgeResId);
        goto L8
    }

    public void setupView(int titleRes, CharSequence subTitle, int iconRes, int bgStyle, int iconRightMarginDimen) {
        if (titleRes <= 0) goto L4;
        setTitle(titleRes);
    L5:
        setSubtitle(subTitle);
        setIconResource(iconRes);
        setIconRightMargin(iconRightMarginDimen);
        setBackgroundStyle(bgStyle);
        return;
    L4:
        setTitle(null);
        goto L5
    }
}
