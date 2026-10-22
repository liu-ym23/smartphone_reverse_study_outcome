package obric.app;

import android.app.DialogSmtEx;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.icu.lang.UCharacter;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.android.settings.R;
import com.android.settings.utils.UIUtils;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes5.dex */
public class OMenuDialog extends OInsetSheet implements DialogInterface.OnKeyListener {
    public static final int LOCATION_APP_BOTTOM = 0;
    public static final int LOCATION_APP_CENTER = 1;
    public static final int LOCATION_DISPLAY_CENTER = 2;
    private View.OnClickListener mCancelListener;
    private View mContentView;
    private Context mContext;
    private ListView mListView;
    private int mMarginEdge;
    private int mMarginView;
    private OListItemGeneral mOkBtn;
    private OInsetSheetTitleBar mTitleBar;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.CLASS)
    public @interface DialogLocation {
        int from() default 0;

        int to() default 2;
    }

    private void adjustLayoutParams() {
    }

    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
    }

    public void setPositiveRedBg(boolean r1) {
    }

    public OMenuDialog(Context r2) {
        super(r2);
        this.mListView = null;
        this.mCancelListener = new AnonymousClass1(this);
        this.mContext = r2;
        init();
    }

    @Override // android.app.Dialog
    public void setTitle(int r2) {
        this.mTitleBar.setTitleText(this.mContext.getText(r2).toString());
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r1) {
        this.mTitleBar.setTitleText(r1.toString());
    }

    private void init() {
        setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(this.mContext);
        this.mTitleBar = r0;
        r0.getMTitleView().setTextAppearance(R.style.Label_L);
        this.mTitleBar.getMTitleView().setTextColor(this.mContext.getColor(R.color.oui_text_2));
        this.mTitleBar.setShowLeftBack(false);
        OInsetSheetTitleBar r1 = this.mTitleBar;
        OButton r2 = r1.createNeutralButton(this.mContext, r1.mRightContainer);
        r2.setButtonSourceBitmap(R.drawable.o_ic_close);
        r2.setOnClickListener(this.mCancelListener);
        View r3 = View.inflate(this.mContext, R.layout.password_menu_dialog_content, null);
        this.mContentView = r3;
        ListView r4 = (ListView) r3.findViewById(R.id.content_list);
        this.mListView = r4;
        r4.setFocusable(false);
        OListItemGeneral r5 = (OListItemGeneral) this.mContentView.findViewById(R.id.btn_ok);
        this.mOkBtn = r5;
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5.getMTvTitle().getLayoutParams();
        r6.gravity = 17;
        this.mOkBtn.getMTvTitle().setLayoutParams(r6);
        this.mOkBtn.getMTvTitle().setTextColor(this.mContext.getColor(R.color.oui_functional_red_7));
        this.mOkBtn.setBackgroundResource(R.color.oui_fill_list_item_card);
        this.mMarginView = this.mContext.getResources().getDimensionPixelOffset(R.dimen.menu_dialog_btn_margin_view);
        this.mMarginEdge = this.mContext.getResources().getDimensionPixelOffset(R.dimen.menu_dialog_btn_margin_edge);
        setOnKeyListener(this);
    }

    public void setAdapter(OMenuDialogListAdapter r3) {
        this.mListView.setVisibility(0);
        adjustLayoutParams();
        this.mListView.setAdapter(r3);
        r3.getCount();
        ViewGroup.LayoutParams r0 = this.mListView.getLayoutParams();
        r0.height = calcListViewHeight(r3.getCount());
        r3.setDialog(this);
    }

    public int calcListViewHeight(int r3) {
        if (r3 > 0) goto L5;
        return 0;
    L5:
        int r2 = UIUtils.INSTANCE.dp2px(4);
        int r0 = UIUtils.INSTANCE.dp2px(56);
        if (r3 < 5) goto L10;
        return UIUtils.INSTANCE.dp2px(UCharacter.UnicodeBlock.MODI_ID);
    L10:
        return ((r3 - 1) * r2) + (r3 * r0);
    }

    public ListView getListView() {
        return this.mListView;
    }

    @Deprecated
    public void setNegativeButton(int r2, View.OnClickListener r3) {
        setNegativeButton(this.mContext.getText(r2), r3);
    }

    @Deprecated
    public void setNegativeButton(CharSequence r1, View.OnClickListener r2) {
        setNegativeButton(r2);
    }

    public void setNegativeImage(int r1, View.OnClickListener r2) {
        setNegativeButton(r2);
    }

    public void setNegativeButton(View.OnClickListener r2) {
        this.mTitleBar.getMLeftActionBack().setOnClickListener(r2);
        this.mTitleBar.getMRightContainer().setOnClickListener(r2);
    }

    public void setPositiveButton(int r2, View.OnClickListener r3) {
        setPositiveButton(this.mContext.getText(r2), r3);
    }

    public void setPositiveButton(CharSequence r3, final View.OnClickListener r4) {
        this.mOkBtn.setVisibility(0);
        adjustLayoutParams();
        this.mOkBtn.setTitleString(r3);
        this.mOkBtn.setOnClickListener(new AnonymousClass2(this, r4));
    }

    public void setPositiveButtonGone() {
        this.mOkBtn.setTitleString("");
        this.mOkBtn.setOnClickListener(null);
        this.mOkBtn.setVisibility(8);
        adjustLayoutParams();
    }

    public OMenuDialog(Context r2, int r3) {
        super(r2);
        this.mListView = null;
        this.mCancelListener = new AnonymousClass1(this);
        this.mContext = r2;
        init();
        locateDialog(r3);
    }

    private void locateDialog(int r2) {
        if (r2 != 0) goto L4;
        getWindow().setGravity(80);
        return;
    L4:
        if (r2 != 1) goto L6;
    L8:
        getWindow().setGravity(17);
        return;
    L6:
        if (r2 == 2) goto L8;
    }

    protected View[] getButtons() {
        return new View[]{this.mOkBtn, this.mTitleBar.getMLeftActionBack(), this.mTitleBar.getMRightContainer()};
    }

    private boolean isButtonAvailable(View r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.isEnabled() == true) goto L6;
        return false;
    L6:
        if (r1.isFocusable() == true) goto L8;
        return false;
    L8:
        if (r1.isClickable() == true) goto L12;
        if (r1.isLongClickable() == true) goto L12;
        return false;
    L12:
        if (r1.getVisibility() != 0) goto L20;
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
    public boolean onKey(DialogInterface r2, int r3, KeyEvent r4) {
        int r5 = r4.getAction();
        if (r5 == 0) goto L9;
        if (r5 == 1) goto L11;
        return false;
    L11:
        return onKeyEventUp(r3, r4);
    L9:
        return onKeyEventDown(r3, r4);
    }

    private boolean onKeyEventDown(int r3, KeyEvent r4) {
        if (new DialogSmtEx(this).hasFocus() == false) goto L5;
        return false;
    L5:
        if (r4.hasNoModifiers() == true) goto L7;
        return false;
    L7:
        if (r3 != 66) goto L9;
    L10:
        View r2 = getMostAvailableButton();
        if (r2 != null) goto L13;
        return false;
    L13:
        if (r2.requestFocus() == true) goto L15;
        return false;
    L15:
        if (r2.onKeyDown(r3, r4) == false) goto L23;
        return true;
    L23:
        return false;
    L9:
        if (r3 == 160) goto L10;
        return false;
    }

    private boolean onKeyEventUp(int r7, KeyEvent r8) {
        if (r8.hasNoModifiers() == true) goto L5;
    L19:
        return false;
    L5:
        if (r7 != 66) goto L7;
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
        return r4.onKeyUp(r7, r8);
    L18:
        r3 = r3 + 1;
        goto L9
    L7:
        if (r7 != 160) goto L19;
        goto L8
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog
    public void show() {
        OInsetSheetTitleBar r0 = this.mTitleBar;
        if (r0 == null) goto L5;
        setHeaderView(r0);
    L5:
        View r1 = this.mContentView;
        if (r1 == null) goto L8;
        setContainerView(r1);
    L8:
        setFooterView(null);
        super.show();
    }
}
