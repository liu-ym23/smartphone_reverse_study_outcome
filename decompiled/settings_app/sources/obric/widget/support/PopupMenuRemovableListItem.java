package obric.widget.support;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class PopupMenuRemovableListItem extends RelativeLayout {
    private FrameLayout mCloseIcon;
    private ImageView mMenuIcon;
    private TextView mMenuTitle;

    public PopupMenuRemovableListItem(Context context) {
        this(context, null);
    }

    public PopupMenuRemovableListItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopupMenuRemovableListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View r1 = LayoutInflater.from(context).inflate(R.layout.popup_menu_removable_list_item, this, true);
        this.mMenuIcon = (ImageView) r1.findViewById(R.id.menu_icon);
        this.mMenuTitle = (TextView) r1.findViewById(R.id.menu_title);
        this.mCloseIcon = (FrameLayout) r1.findViewById(R.id.menu_closed);
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
        int r2 = 0;
    L5:
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mMenuTitle.getLayoutParams();
        if (r0 == null) goto L9;
        r0.leftMargin = r2;
        this.mMenuTitle.setLayoutParams(r0);
        return;
    L9:
        return;
    L4:
        r2 = getResources().getDimensionPixelSize(R.dimen.popup_list_title_left_margin);
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
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(PopupMenuStandardListItem.class.getName());
        info.setCheckable(true);
    }

    public void setOnCloseIconClickListener(View.OnClickListener listener) {
        this.mCloseIcon.setOnClickListener(listener);
    }

    public View getCloseIconView() {
        return this.mCloseIcon;
    }

    public void setCloseIconVisibility(int visible) {
        this.mCloseIcon.setVisibility(visible);
    }
}
