package obric.tablet.widget;

import android.content.ContentResolver;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import bytedanceos.api.SettingsSmt;
import com.android.settings.R;
import obric.app.MenuDialogMultiAdapter;
import obric.app.OMenuDialogListAdapter;
import obric.widget.MenuDialogTitleBar;

/* JADX INFO: loaded from: classes5.dex */
public class BytedanceMenuPopupWindow extends BytedancePopupWindowBase {
    private final View.OnClickListener mCancelListener;
    private ListView mListView;
    private TextView mOkBtn;
    private MenuDialogTitleBar mTitleBar;

    public BytedanceMenuPopupWindow(View r1) {
        super(r1);
        this.mCancelListener = new AnonymousClass1(this);
    }

    @Override // obric.tablet.widget.BytedancePopupWindowBase
    protected void initContentView(ViewGroup r4) {
        ViewGroup r5 = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.menu_dialog, r4, true);
        MenuDialogTitleBar r0 = (MenuDialogTitleBar) r5.findViewById(R.id.menu_dialog_title_bar);
        this.mTitleBar = r0;
        r0.forceRequestAccessibilityFocusWhenAttached(false);
        this.mTitleBar.showTopShadow(false);
        this.mContext.getResources().getDimensionPixelOffset(R.dimen.revone_popup_window_shadow_radius);
        initLeftRightHands();
        this.mOkBtn = (TextView) r5.findViewById(R.id.btn_ok);
        this.mListView = (ListView) r5.findViewById(R.id.content_list);
    }

    @Override // obric.tablet.widget.BytedancePopupWindowBase
    protected void preShow() {
        this.mTitleBar.setOnRightButtonClickListener(this.mCancelListener);
        this.mTitleBar.setOnLeftButtonClickListener(this.mCancelListener);
    }

    public void setTitle(int r2) {
        this.mTitleBar.setTitle(this.mContext.getText(r2));
    }

    public void setTitle(CharSequence r1) {
        this.mTitleBar.setTitle(r1);
    }

    public void setTitleSinleLine(boolean r1) {
        this.mTitleBar.setTitleSingleLine(r1);
    }

    private void initLeftRightHands() {
        ContentResolver r0 = this.mContext.getContentResolver();
        SettingsSmt.getInstance();
        if (Settings.Global.getInt(r0, SettingsSmt.get_ONE_HAND_MODE(), 1) != 0) goto L5;
        this.mTitleBar.setLeftButtonVisibility(0);
        this.mTitleBar.setRightButtonVisibility(4);
        return;
    L5:
        this.mTitleBar.setLeftButtonVisibility(4);
        this.mTitleBar.setRightButtonVisibility(0);
    }

    public void setAdapter(OMenuDialogListAdapter r3) {
        this.mListView.setVisibility(0);
        this.mListView.setAdapter(r3);
        this.mListView.getLayoutParams().height = -2;
    }

    public void setAdaper(MenuDialogMultiAdapter r3, AdapterView.OnItemClickListener r4) {
        this.mListView.setVisibility(0);
        this.mListView.setAdapter(r3);
        this.mListView.setOnItemClickListener(r4);
        ViewGroup.LayoutParams r5 = this.mListView.getLayoutParams();
        r5.height = (int) this.mContext.getResources().getDimension(R.dimen.menu_dialog_multi_list_height);
        this.mListView.setBackgroundResource(R.drawable.menu_dialog_multi_list_bg);
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void setNegativeButton(int r2, View.OnClickListener r3) {
        setNegativeButton(this.mContext.getText(r2), r3);
    }

    public void setNegativeButton(CharSequence r2, View.OnClickListener r3) {
        this.mTitleBar.setRightButtonText(r2);
        this.mTitleBar.setOnRightButtonClickListener(r3);
        this.mTitleBar.setLeftButtonText(r2);
        this.mTitleBar.setOnLeftButtonClickListener(r3);
    }

    public void setNegativeButton(View.OnClickListener r2) {
        this.mTitleBar.setOnRightButtonClickListener(r2);
        this.mTitleBar.setOnLeftButtonClickListener(r2);
    }

    public void setPositiveRedBg(boolean r1) {
        if (r1 == false) goto L4;
        this.mOkBtn.setBackgroundResource(R.drawable.selector_shrink_long_btn_highlight_red);
        return;
    L4:
        this.mOkBtn.setBackgroundResource(R.drawable.selector_shrink_long_btn);
    }

    public void setPositiveButton(int r2, View.OnClickListener r3) {
        setPositiveButton(this.mContext.getText(r2), r3);
    }

    public void setPositiveButton(CharSequence r3, final View.OnClickListener r4) {
        this.mOkBtn.setVisibility(0);
        this.mOkBtn.setText(r3);
        this.mOkBtn.setOnClickListener(new AnonymousClass2(this, r4));
    }

    public void setPositiveButtonGone() {
        this.mOkBtn.setText(null);
        this.mOkBtn.setOnClickListener(null);
        this.mOkBtn.setVisibility(8);
    }
}
