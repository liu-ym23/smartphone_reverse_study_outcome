package obric.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class PopupMenuLongPressedListItem extends RelativeLayout {
    private ImageView mIcon;
    private MenuItemImpl mItemData;
    private TextView mTitleText;

    public PopupMenuLongPressedListItem(Context context) {
        super(context);
        init(context, null, 0);
    }

    public PopupMenuLongPressedListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public PopupMenuLongPressedListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.popup_menu_long_pressed_list_item, this, true);
        this.mIcon = (ImageView) findViewById(R.id.menu_icon);
        this.mTitleText = (TextView) findViewById(R.id.menu_title);
    }

    public void initialize(MenuItemImpl itemData, int position) {
        this.mItemData = itemData;
        this.mTitleText.setText(itemData.getTitle());
        this.mIcon.setImageDrawable(itemData.getIcon());
        if (itemData.isVisible() == false) goto L5;
        int r3 = 0;
    L6:
        setVisibility(r3);
        setEnabled(itemData.isEnabled());
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }
}
