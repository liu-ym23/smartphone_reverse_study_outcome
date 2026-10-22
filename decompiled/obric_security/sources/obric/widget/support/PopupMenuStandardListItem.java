package obric.widget.support;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class PopupMenuStandardListItem extends RelativeLayout {
    private ImageView mMenuIcon;
    private TextView mMenuSubtitle;
    private TextView mMenuTitle;
    private ImageView mSelectedIcon;

    public PopupMenuStandardListItem(Context context) {
        this(context, null);
    }

    public PopupMenuStandardListItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopupMenuStandardListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View r1 = LayoutInflater.from(context).inflate(R.layout.popup_menu_standard_list_item, this, true);
        this.mMenuIcon = (ImageView) r1.findViewById(R.id.menu_icon);
        this.mSelectedIcon = (ImageView) r1.findViewById(R.id.menu_selected);
        this.mMenuTitle = (TextView) r1.findViewById(R.id.menu_title);
        this.mMenuSubtitle = (TextView) r1.findViewById(R.id.subtitle);
    }

    public void setMenuIcon(int resId) {
        setMenuIcon(getResources().getDrawable(resId));
    }

    public void setMenuIcon(Drawable d) {
        this.mMenuIcon.setImageDrawable(d);
        ImageView r0 = this.mMenuIcon;
        boolean r1 = false;
        if (d == null) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        if (d == null) goto L9;
        r1 = true;
    L9:
        adjustMenuTitleMargin(r1);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void adjustMenuTitleMargin(boolean hasMenuIcon) {
        if (hasMenuIcon == false) goto L4;
        int r4 = 0;
    L5:
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mMenuTitle.getLayoutParams();
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.mMenuSubtitle.getLayoutParams();
        if (r0 == null) goto L8;
        r0.leftMargin = r4;
        this.mMenuTitle.setLayoutParams(r0);
    L8:
        if (r1 == null) goto L11;
        r1.leftMargin = r4;
        this.mMenuSubtitle.setLayoutParams(r1);
        return;
    L11:
        return;
    L4:
        r4 = getResources().getDimensionPixelSize(R.dimen.popup_list_title_left_margin);
        goto L5
    }

    public ImageView getIconView() {
        return this.mMenuIcon;
    }

    public void setMenuTitle(int resId) {
        setMenuTitle(getResources().getString(resId));
    }

    public void setMenuTitle(CharSequence s) {
        this.mMenuTitle.setText(s);
        adjustTitleTextSize();
    }

    public void setMenuSubtitle(CharSequence s) {
        this.mMenuSubtitle.setVisibility(0);
        this.mMenuSubtitle.setText(s);
        adjustTitleTextSize();
    }

    public void adjustTitleTextSize() {
        if (this.mMenuSubtitle.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        TextView r1 = this.mMenuTitle;
        if (r0 == false) goto L9;
        float r2 = 14.0f;
    L10:
        r1.setTextSize(r2);
        return;
    L9:
        r2 = 15.0f;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public void setChecked(boolean checked) {
        ImageView r0 = this.mSelectedIcon;
        if (checked == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public boolean isChecked() {
        if (this.mSelectedIcon.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(PopupMenuStandardListItem.class.getName());
        info.setCheckable(true);
        info.setChecked(isChecked());
    }
}
