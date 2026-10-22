package obric.app;

import android.app.Dialog;
import android.app.DialogExt;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import obric.InvokeApi;
import obric.widget.MenuDialogTitleBar;
import obric.widget.R;
import obric.widget.ShadowButton;

/* JADX INFO: loaded from: classes5.dex */
public class MenuDialog extends Dialog implements DialogInterface.OnKeyListener {
    public static final int LOCATION_APP_BOTTOM = 0;
    public static final int LOCATION_APP_CENTER = 1;
    public static final int LOCATION_DISPLAY_CENTER = 2;
    private View.OnClickListener mCancelListener;
    private Context mContext;
    private ListView mListView;
    private int mMarginEdge;
    private int mMarginView;
    private ShadowButton mOkBtn;
    private MenuDialogTitleBar mTitleBar;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.CLASS)
    public @interface DialogLocation {
        int from() default 0;

        int to() default 2;
    }

    public MenuDialog(Context context) {
        super(context, R.style.MenuDialogTheme);
        this.mListView = null;
        this.mCancelListener = new AnonymousClass1(this);
        this.mContext = context;
        init();
    }

    @Override // android.app.Dialog
    public void setTitle(int titleId) {
        this.mTitleBar.setTitle(this.mContext.getText(titleId));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence title) {
        this.mTitleBar.setTitle(title);
    }

    public void setTitleSinleLine(boolean singleLine) {
        this.mTitleBar.setTitleSingleLine(singleLine);
    }

    private void init() {
        setContentView(R.layout.menu_dialog);
        MenuDialogTitleBar r0 = (MenuDialogTitleBar) findViewById(R.id.menu_dialog_title_bar);
        this.mTitleBar = r0;
        r0.forceRequestAccessibilityFocusWhenAttached(false);
        this.mTitleBar.setOnRightButtonClickListener(this.mCancelListener);
        this.mTitleBar.setOnLeftButtonClickListener(this.mCancelListener);
        this.mTitleBar.setShadowVisible(false);
        initLeftRightHands();
        this.mOkBtn = (ShadowButton) findViewById(R.id.btn_ok);
        ListView r1 = (ListView) findViewById(R.id.content_list);
        this.mListView = r1;
        r1.setFocusable(false);
        getWindow().setGravity(80);
        getWindow().setLayout(-1, -2);
        getWindow().addFlags(262144);
        getWindow().addFlags(131072);
        InvokeApi.xWindow.addPrivateFlags(getWindow(), "PRIVATE_FLAG_NO_MOVE_ANIMATION");
        this.mMarginView = this.mContext.getResources().getDimensionPixelOffset(R.dimen.menu_dialog_btn_margin_view);
        this.mMarginEdge = this.mContext.getResources().getDimensionPixelOffset(R.dimen.menu_dialog_btn_margin_edge);
        setOnKeyListener(this);
    }

    private void initLeftRightHands() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "one_hand_mode", 1) != 0) goto L5;
        this.mTitleBar.setLeftButtonVisibility(0);
        this.mTitleBar.setRightButtonVisibility(4);
        return;
    L5:
        this.mTitleBar.setLeftButtonVisibility(4);
        this.mTitleBar.setRightButtonVisibility(0);
    }

    public void setAdapter(final MenuDialogListAdapter adapter) {
        boolean r1 = false;
        this.mListView.setVisibility(0);
        adjustLayoutParams();
        this.mListView.setAdapter(adapter);
        if (adapter.getCount() < 5) goto L5;
        r1 = true;
    L5:
        ViewGroup.LayoutParams r0 = this.mListView.getLayoutParams();
        if (r1 == false) goto L8;
        int r2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.multi_menu_dialog_list_height);
    L9:
        r0.height = r2;
        adapter.setDialog(this);
        return;
    L8:
        r2 = -2;
        goto L9
    }

    public void setAdaper(final MenuDialogMultiAdapter adapter, final AdapterView.OnItemClickListener listener) {
        this.mListView.setVisibility(0);
        adjustLayoutParams();
        this.mListView.setAdapter(adapter);
        this.mListView.setOnItemClickListener(listener);
        ViewGroup.LayoutParams r3 = this.mListView.getLayoutParams();
        r3.height = (int) this.mContext.getResources().getDimension(R.dimen.menu_dialog_multi_list_height);
        this.mListView.setBackgroundResource(R.drawable.menu_dialog_multi_list_bg);
    }

    public ListView getListView() {
        return this.mListView;
    }

    @Deprecated
    public void setNegativeButton(int textId, View.OnClickListener listener) {
        setNegativeButton(this.mContext.getText(textId), listener);
    }

    @Deprecated
    public void setNegativeButton(CharSequence text, View.OnClickListener listener) {
        this.mTitleBar.setRightButtonText(text);
        this.mTitleBar.setLeftButtonText(text);
        setNegativeButton(listener);
    }

    public void setNegativeImage(int resId, View.OnClickListener listener) {
        this.mTitleBar.setRightImageRes(resId);
        this.mTitleBar.setLeftImageViewRes(resId);
        setNegativeButton(listener);
    }

    public void setNegativeButton(View.OnClickListener listener) {
        this.mTitleBar.setOnRightButtonClickListener(listener);
        this.mTitleBar.setOnLeftButtonClickListener(listener);
    }

    public void setPositiveRedBg(boolean isRedBackground) {
        if (isRedBackground == false) goto L4;
        setPositiveBgStyle(ShadowButton.LongButtonStyle.RED);
        return;
    L4:
        setPositiveBgStyle(ShadowButton.LongButtonStyle.GRAY);
    }

    public void setPositiveBgStyle(ShadowButton.LongButtonStyle style) {
        this.mOkBtn.updateBackgroundStyle(style);
    }

    public void setPositiveButton(int textId, View.OnClickListener listener) {
        setPositiveButton(this.mContext.getText(textId), listener);
    }

    public void setPositiveButton(CharSequence text, final View.OnClickListener listener) {
        this.mOkBtn.setVisibility(0);
        adjustLayoutParams();
        this.mOkBtn.setText(text);
        this.mOkBtn.setOnClickListener(new AnonymousClass2(this, listener));
    }

    public void setPositiveButtonGone() {
        this.mOkBtn.setText(null);
        this.mOkBtn.setOnClickListener(null);
        this.mOkBtn.setVisibility(8);
        adjustLayoutParams();
    }

    private void adjustLayoutParams() {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mOkBtn.getLayoutParams();
        int r2 = 0;
        if (this.mListView.getVisibility() == 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        r2 = this.mMarginView;
    L11:
        r0.topMargin = r2;
        this.mOkBtn.setLayoutParams(r0);
        if (r1 == false) goto L14;
        int r3 = this.mMarginView;
    L15:
        ListView r4 = this.mListView;
        r4.setPadding(r4.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getPaddingRight(), r3);
        return;
    L14:
        r3 = this.mMarginEdge;
        goto L15
    L5:
        if (this.mOkBtn.getVisibility() != 0) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus == false) goto L5;
        initLeftRightHands();
        return;
    }

    public MenuDialog(Context context, int location) {
        super(context, R.style.MenuDialogTheme);
        this.mListView = null;
        this.mCancelListener = new AnonymousClass1(this);
        this.mContext = context;
        init();
        locateDialog(location);
    }

    private void locateDialog(int location) {
        if (location != 0) goto L4;
        getWindow().setGravity(80);
        return;
    L4:
        if (location != 1) goto L6;
    L8:
        getWindow().setGravity(17);
        return;
    L6:
        if (location == 2) goto L8;
    }

    protected View[] getButtons() {
        return new View[]{this.mOkBtn, this.mTitleBar.getLeftImageView(), this.mTitleBar.getRightImageView()};
    }

    private boolean isButtonAvailable(View button) {
        if (button != null) goto L4;
        return false;
    L4:
        if (button.isEnabled() == true) goto L6;
        return false;
    L6:
        if (button.isFocusable() == true) goto L8;
        return false;
    L8:
        if (button.isClickable() == true) goto L12;
        if (button.isLongClickable() == true) goto L12;
        return false;
    L12:
        if (button.getVisibility() != 0) goto L20;
        return true;
    L20:
        return false;
    }

    private View getMostAvailableButton() {
        View[] r0 = getButtons();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        View r3 = r0[r2];
        if (isButtonAvailable(r3) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        int r2 = event.getAction();
        if (r2 == 0) goto L9;
        if (r2 == 1) goto L11;
        return false;
    L11:
        return onKeyEventUp(keyCode, event);
    L9:
        return onKeyEventDown(keyCode, event);
    }

    private boolean onKeyEventDown(int keyCode, KeyEvent event) {
        if (DialogExt.hasFocus(this) == false) goto L5;
        return false;
    L5:
        if (event.hasNoModifiers() == true) goto L7;
        return false;
    L7:
        if (keyCode != 66) goto L9;
    L10:
        View r2 = getMostAvailableButton();
        if (r2 != null) goto L13;
        return false;
    L13:
        if (r2.requestFocus() == true) goto L15;
        return false;
    L15:
        if (r2.onKeyDown(keyCode, event) == false) goto L23;
        return true;
    L23:
        return false;
    L9:
        if (keyCode == 160) goto L10;
        return false;
    }

    private boolean onKeyEventUp(int keyCode, KeyEvent event) {
        if (event.hasNoModifiers() == true) goto L5;
    L19:
        return false;
    L5:
        if (keyCode != 66) goto L7;
    L8:
        View[] r0 = getButtons();
        int r2 = r0.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L19;
        View r4 = r0[r3];
        if (isButtonAvailable(r4) == false) goto L18;
        if (r4.hasFocus() == false) goto L18;
        if (r4.isPressed() == false) goto L18;
        return r4.onKeyUp(keyCode, event);
    L18:
        r3 = r3 + 1;
        goto L9
    L7:
        if (keyCode != 160) goto L19;
        goto L8
    }

    public void onConfigurationChanged(Configuration newConfig) {
        int r4 = getContext().getResources().getDimensionPixelOffset(R.dimen.menu_dialog_horizontal_distance);
        int r0 = this.mListView.getPaddingTop();
        int r1 = this.mListView.getPaddingBottom();
        this.mListView.setPadding(r4, r0, r4, r1);
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) this.mOkBtn.getLayoutParams();
        r2.leftMargin = r4;
        r2.rightMargin = r4;
        this.mOkBtn.setLayoutParams(r2);
    }
}
