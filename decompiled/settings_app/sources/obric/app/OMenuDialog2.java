package obric.app;

import android.app.DialogSmtEx;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.titlebar.OCTitleBar;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes5.dex */
public class OMenuDialog2 extends OInsetSheet implements DialogInterface.OnKeyListener {
    public static final int LOCATION_APP_BOTTOM = 0;
    public static final int LOCATION_APP_CENTER = 1;
    public static final int LOCATION_DISPLAY_CENTER = 2;
    private View mContentView;
    private Context mContext;
    private ListView mListView;
    private OButton mOkBtn;
    private OCTitleBar mTitleBar;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.CLASS)
    public @interface DialogLocation {
        int from() default 0;

        int to() default 2;
    }

    public OMenuDialog2(Context r2) {
        super(r2);
        this.mListView = null;
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
        OCTitleBar r0 = new OCTitleBar(this.mContext);
        this.mTitleBar = r0;
        r0.setTitleText(this.mContext.getString(R.string.user_rename));
        this.mTitleBar.setShowLeftBack(false);
        OCTitleBar r1 = this.mTitleBar;
        OButton r2 = r1.createNeutralButton(this.mContext, r1.mRightContainer);
        r2.setButtonSourceBitmap(R.drawable.o_ic_close);
        r2.setOnClickListener(new AnonymousClass1(this));
        View r3 = View.inflate(this.mContext, R.layout.password_menu_dialog2, null);
        this.mContentView = r3;
        ListView r4 = (ListView) r3.findViewById(R.id.content_list);
        this.mListView = r4;
        r4.setFocusable(false);
        setOnKeyListener(this);
    }

    private void initViews() {
        OCTitleBar r0 = this.mTitleBar;
        if (r0 == null) goto L5;
        setHeaderView(r0);
    L5:
        View r1 = this.mContentView;
        if (r1 == null) goto L9;
        setContainerView(r1);
        return;
    }

    public void setAdapter(OMenuDialogListAdapter2 r4) {
        boolean r1 = false;
        this.mListView.setVisibility(0);
        this.mListView.setAdapter(r4);
        if (r4.getCount() < 5) goto L5;
        r1 = true;
    L5:
        ViewGroup.LayoutParams r0 = this.mListView.getLayoutParams();
        if (r1 == false) goto L8;
        int r2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.multi_menu_dialog_list_height);
    L9:
        r0.height = r2;
        r4.setDialog(this);
        initViews();
        return;
    L8:
        r2 = -2;
        goto L9
    }

    public ListView getListView() {
        return this.mListView;
    }

    public OMenuDialog2(Context r1, int r2) {
        super(r1);
        this.mListView = null;
        this.mContext = r1;
        init();
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
}
