package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final View.OnClickListener mButtonHandler;
    private final int mButtonIconDimen;
    Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    int mCheckedItem;
    private final Context mContext;
    private View mCustomTitleView;
    final AppCompatDialog mDialog;
    Handler mHandler;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified;
    private int mViewSpacingTop;
    private final Window mWindow;

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$2, reason: invalid class name */
    class AnonymousClass2 implements NestedScrollView.OnScrollChangeListener {
        final /* synthetic */ AlertController this$0;
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        AnonymousClass2(AlertController r1, View r2, View r3) {
            this.this$0 = r1;
            this.val$top = r2;
            this.val$bottom = r3;
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView r1, int r2, int r3, int r4, int r5) {
            AlertController.manageScrollIndicators(r1, this.val$top, this.val$bottom);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ AlertController this$0;
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        AnonymousClass3(AlertController r1, View r2, View r3) {
            this.this$0 = r1;
            this.val$top = r2;
            this.val$bottom = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.manageScrollIndicators(this.this$0.mScrollView, this.val$top, this.val$bottom);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$4, reason: invalid class name */
    class AnonymousClass4 implements AbsListView.OnScrollListener {
        final /* synthetic */ AlertController this$0;
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView r1, int r2) {
        }

        AnonymousClass4(AlertController r1, View r2, View r3) {
            this.this$0 = r1;
            this.val$top = r2;
            this.val$bottom = r3;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView r1, int r2, int r3, int r4) {
            AlertController.manageScrollIndicators(r1, this.val$top, this.val$bottom);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ AlertController this$0;
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        AnonymousClass5(AlertController r1, View r2, View r3) {
            this.this$0 = r1;
            this.val$top = r2;
            this.val$bottom = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.manageScrollIndicators(this.this$0.mListView, this.val$top, this.val$bottom);
        }
    }

    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId;
        public int mIconId;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified;
        public int mViewSpacingTop;

        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView r1);
        }

        public AlertParams(Context r2) {
            this.mIconId = 0;
            this.mIconAttrId = 0;
            this.mViewSpacingSpecified = false;
            this.mCheckedItem = -1;
            this.mRecycleOnMeasure = true;
            this.mContext = r2;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) r2.getSystemService("layout_inflater");
        }

        public void apply(AlertController r14) {
            View r0 = this.mCustomTitleView;
            if (r0 == null) goto L5;
            r14.setCustomTitle(r0);
        L17:
            CharSequence r1 = this.mMessage;
            if (r1 == null) goto L20;
            r14.setMessage(r1);
        L20:
            CharSequence r3 = this.mPositiveButtonText;
            if (r3 == null) goto L23;
        L24:
            r14.setButton(-1, r3, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
        L25:
            CharSequence r9 = this.mNegativeButtonText;
            if (r9 == null) goto L28;
        L29:
            r14.setButton(-2, r9, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
        L30:
            CharSequence r2 = this.mNeutralButtonText;
            if (r2 == null) goto L33;
        L34:
            r14.setButton(-3, r2, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
        L36:
            if (this.mItems == null) goto L38;
        L41:
            createListView(r14);
        L42:
            View r4 = this.mView;
            if (r4 != null) goto L45;
            int r13 = this.mViewLayoutResId;
            if (r13 == 0) goto L54;
            r14.setView(r13);
            return;
        L54:
            return;
        L45:
            if (this.mViewSpacingSpecified == false) goto L47;
            r14.setView(r4, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            return;
        L47:
            r14.setView(r4);
            return;
        L38:
            if (this.mCursor != null) goto L41;
            if (this.mAdapter == null) goto L42;
        L33:
            if (this.mNeutralButtonIcon == null) goto L36;
        L28:
            if (this.mNegativeButtonIcon == null) goto L30;
        L23:
            if (this.mPositiveButtonIcon == null) goto L25;
        L5:
            CharSequence r5 = this.mTitle;
            if (r5 == null) goto L8;
            r14.setTitle(r5);
        L8:
            Drawable r6 = this.mIcon;
            if (r6 == null) goto L11;
            r14.setIcon(r6);
        L11:
            int r7 = this.mIconId;
            if (r7 == 0) goto L14;
            r14.setIcon(r7);
        L14:
            int r8 = this.mIconAttrId;
            if (r8 == 0) goto L17;
            r14.setIcon(r14.getIconAttributeResId(r8));
            goto L17
        }

        private void createListView(final AlertController r11) {
            final RecycleListView r0 = (RecycleListView) this.mInflater.inflate(r11.mListLayout, null);
            if (this.mIsMultiChoice == false) goto L9;
            if (this.mCursor != null) goto L7;
            final Context r3 = this.mContext;
            final int r4 = r11.mMultiChoiceItemLayout;
            final int r5 = R.id.text1;
            final CharSequence[] r6 = this.mItems;
            ListAdapter r9 = new AnonymousClass1(this, r3, r4, r5, r6, r0);
        L19:
            OnPrepareListViewListener r1 = this.mOnPrepareListViewListener;
            if (r1 == null) goto L22;
            r1.onPrepareListView(r0);
        L22:
            r11.mAdapter = r9;
            r11.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener == null) goto L26;
            r0.setOnItemClickListener(new AnonymousClass3(this, r11));
        L28:
            AdapterView.OnItemSelectedListener r2 = this.mOnItemSelectedListener;
            if (r2 == null) goto L32;
            r0.setOnItemSelectedListener(r2);
        L32:
            if (this.mIsSingleChoice == false) goto L35;
            r0.setChoiceMode(1);
        L37:
            r11.mListView = r0;
            return;
        L35:
            if (this.mIsMultiChoice == false) goto L37;
            r0.setChoiceMode(2);
            goto L37
        L26:
            if (this.mOnCheckboxClickListener == null) goto L28;
            r0.setOnItemClickListener(new AnonymousClass4(this, r0, r11));
            goto L28
        L7:
            final Context r7 = this.mContext;
            final Cursor r8 = this.mCursor;
            final boolean r10 = false;
            r9 = new AnonymousClass2(this, r7, r8, r10, r0, r11);
            goto L19
        L9:
            if (this.mIsSingleChoice == false) goto L11;
            int r12 = r11.mSingleChoiceItemLayout;
        L12:
            int r13 = r12;
            if (this.mCursor == null) goto L15;
            r9 = new SimpleCursorAdapter(this.mContext, r13, this.mCursor, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
            goto L19
        L15:
            r9 = this.mAdapter;
            if (r9 != null) goto L19;
            r9 = new CheckedItemAdapter(this.mContext, r13, R.id.text1, this.mItems);
            goto L19
        L11:
            r12 = r11.mListItemLayout;
            goto L12
        }
    }

    private static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface r2) {
            this.mDialog = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            int r0 = r3.what;
            if (r0 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r3.obj).onClick(this.mDialog.get(), r3.what);
            return;
        L5:
            if (r0 == (-2)) goto L12;
            if (r0 == (-1)) goto L12;
            if (r0 != 1) goto L15;
            ((DialogInterface) r3.obj).dismiss();
            return;
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public CheckedItemAdapter(Context r1, int r2, int r3, CharSequence[] r4) {
            super(r1, r2, r3, r4);
        }
    }

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context r2) {
            this(r2, null);
        }

        public RecycleListView(Context r2, AttributeSet r3) {
            super(r2, r3);
            TypedArray r4 = r2.obtainStyledAttributes(r3, androidx.appcompat.R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = r4.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = r4.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean r3, boolean r4) {
            if (r4 == false) goto L4;
            if (r3 == false) goto L4;
            return;
        L4:
            int r0 = getPaddingLeft();
            if (r3 == false) goto L7;
            int r5 = getPaddingTop();
        L8:
            int r1 = getPaddingRight();
            if (r4 == false) goto L11;
            int r6 = getPaddingBottom();
        L12:
            setPadding(r0, r5, r1, r6);
            return;
        L11:
            r6 = this.mPaddingBottomNoButtons;
            goto L12
        L7:
            r5 = this.mPaddingTopNoTitle;
            goto L8
        }
    }

    private static boolean shouldCenterSingleButton(Context r3) {
        TypedValue r0 = new TypedValue();
        r3.getTheme().resolveAttribute(androidx.appcompat.R.attr.alertDialogCenterButtons, r0, true);
        if (r0.data != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public AlertController(Context r4, AppCompatDialog r5, Window r6) {
        this.mViewSpacingSpecified = false;
        this.mIconId = 0;
        this.mCheckedItem = -1;
        this.mButtonPanelLayoutHint = 0;
        this.mButtonHandler = new AnonymousClass1(this);
        this.mContext = r4;
        this.mDialog = r5;
        this.mWindow = r6;
        this.mHandler = new ButtonHandler(r5);
        TypedArray r7 = r4.obtainStyledAttributes(null, androidx.appcompat.R.styleable.AlertDialog, androidx.appcompat.R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = r7.getResourceId(androidx.appcompat.R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = r7.getResourceId(androidx.appcompat.R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = r7.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = r7.getResourceId(androidx.appcompat.R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = r7.getResourceId(androidx.appcompat.R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = r7.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = r7.getBoolean(androidx.appcompat.R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = r7.getDimensionPixelSize(androidx.appcompat.R.styleable.AlertDialog_buttonIconDimen, 0);
        r7.recycle();
        r5.supportRequestWindowFeature(1);
    }

    static boolean canTextInput(View r4) {
        if (r4.onCheckIsTextEditor() == false) goto L6;
        return true;
    L6:
        if ((r4 instanceof ViewGroup) == true) goto L8;
        return false;
    L8:
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
    L9:
        if (r0 <= 0) goto L13;
        r0 = r0 - 1;
        if (canTextInput(r5.getChildAt(r0)) == false) goto L9;
        return true;
    L13:
        return false;
    }

    public void installContent() {
        int r0 = selectContentView();
        this.mDialog.setContentView(r0);
        setupView();
    }

    private int selectContentView() {
        int r0 = this.mButtonPanelSideLayout;
        if (r0 != 0) goto L7;
        return this.mAlertDialogLayout;
    L7:
        if (this.mButtonPanelLayoutHint != 1) goto L10;
        return r0;
    L10:
        return this.mAlertDialogLayout;
    }

    public void setTitle(CharSequence r1) {
        this.mTitle = r1;
        TextView r0 = this.mTitleView;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    public void setCustomTitle(View r1) {
        this.mCustomTitleView = r1;
    }

    public void setMessage(CharSequence r1) {
        this.mMessage = r1;
        TextView r0 = this.mMessageView;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    public void setView(int r2) {
        this.mView = null;
        this.mViewLayoutResId = r2;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View r1) {
        this.mView = r1;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View r1, int r2, int r3, int r4, int r5) {
        this.mView = r1;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = r2;
        this.mViewSpacingTop = r3;
        this.mViewSpacingRight = r4;
        this.mViewSpacingBottom = r5;
    }

    public void setButtonPanelLayoutHint(int r1) {
        this.mButtonPanelLayoutHint = r1;
    }

    public void setButton(int r1, CharSequence r2, DialogInterface.OnClickListener r3, Message r4, Drawable r5) {
        if (r4 != null) goto L6;
        if (r3 == null) goto L6;
        r4 = this.mHandler.obtainMessage(r1, r3);
    L6:
        if (r1 != (-3)) goto L8;
        this.mButtonNeutralText = r2;
        this.mButtonNeutralMessage = r4;
        this.mButtonNeutralIcon = r5;
        return;
    L8:
        if (r1 != (-2)) goto L10;
        this.mButtonNegativeText = r2;
        this.mButtonNegativeMessage = r4;
        this.mButtonNegativeIcon = r5;
        return;
    L10:
        if (r1 != (-1)) goto L13;
        this.mButtonPositiveText = r2;
        this.mButtonPositiveMessage = r4;
        this.mButtonPositiveIcon = r5;
        return;
    L13:
        throw new IllegalArgumentException("Button does not exist");
    }

    public void setIcon(int r2) {
        this.mIcon = null;
        this.mIconId = r2;
        ImageView r0 = this.mIconView;
        if (r0 == null) goto L8;
        if (r2 == 0) goto L6;
        r0.setVisibility(0);
        this.mIconView.setImageResource(this.mIconId);
        return;
    L6:
        r0.setVisibility(8);
        return;
    }

    public void setIcon(Drawable r3) {
        this.mIcon = r3;
        this.mIconId = 0;
        ImageView r1 = this.mIconView;
        if (r1 == null) goto L8;
        if (r3 == null) goto L6;
        r1.setVisibility(0);
        this.mIconView.setImageDrawable(r3);
        return;
    L6:
        r1.setVisibility(8);
        return;
    }

    public int getIconAttributeResId(int r3) {
        TypedValue r0 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(r3, r0, true);
        return r0.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public Button getButton(int r2) {
        if (r2 == (-3)) goto L15;
        if (r2 == (-2)) goto L13;
        if (r2 == (-1)) goto L11;
        return null;
    L11:
        return this.mButtonPositive;
    L13:
        return this.mButtonNegative;
    L15:
        return this.mButtonNeutral;
    }

    public boolean onKeyDown(int r1, KeyEvent r2) {
        NestedScrollView r0 = this.mScrollView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.executeKeyEvent(r2) == false) goto L7;
        return true;
    }

    public boolean onKeyUp(int r1, KeyEvent r2) {
        NestedScrollView r0 = this.mScrollView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.executeKeyEvent(r2) == false) goto L7;
        return true;
    }

    private ViewGroup resolvePanel(View r2, View r3) {
        if (r2 == null) goto L4;
        if (r3 == null) goto L13;
        ViewParent r1 = r3.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L13;
        ((ViewGroup) r1).removeView(r3);
    L13:
        if ((r2 instanceof ViewStub) == false) goto L16;
        r2 = ((ViewStub) r2).inflate();
    L16:
        return (ViewGroup) r2;
    L4:
        if ((r3 instanceof ViewStub) == false) goto L7;
        r3 = ((ViewStub) r3).inflate();
    L7:
        return (ViewGroup) r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupView() {
        View r0 = this.mWindow.findViewById(androidx.appcompat.R.id.parentPanel);
        View r1 = r0.findViewById(androidx.appcompat.R.id.topPanel);
        View r2 = r0.findViewById(androidx.appcompat.R.id.contentPanel);
        View r3 = r0.findViewById(androidx.appcompat.R.id.buttonPanel);
        ViewGroup r4 = (ViewGroup) r0.findViewById(androidx.appcompat.R.id.customPanel);
        setupCustomContent(r4);
        View r5 = r4.findViewById(androidx.appcompat.R.id.topPanel);
        View r6 = r4.findViewById(androidx.appcompat.R.id.contentPanel);
        View r7 = r4.findViewById(androidx.appcompat.R.id.buttonPanel);
        ViewGroup r8 = resolvePanel(r5, r1);
        ViewGroup r9 = resolvePanel(r6, r2);
        ViewGroup r10 = resolvePanel(r7, r3);
        setupContent(r9);
        setupButtons(r10);
        setupTitle(r8);
        int r11 = 0;
        if (r4 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r8 != null) goto L10;
    L12:
        boolean r13 = 0;
    L13:
        if (r10 != null) goto L15;
    L17:
        boolean r14 = false;
    L18:
        if (r14 == true) goto L23;
        if (r9 == null) goto L23;
        View r15 = r9.findViewById(androidx.appcompat.R.id.textSpacerNoButtons);
        if (r15 == null) goto L23;
        r15.setVisibility(0);
    L23:
        if (r13 == 0) goto L36;
        NestedScrollView r16 = this.mScrollView;
        if (r16 == null) goto L28;
        r16.setClipToPadding(true);
    L28:
        if (this.mMessage == null) goto L30;
    L33:
        View r17 = r8.findViewById(androidx.appcompat.R.id.titleDividerNoCustom);
    L34:
        if (r17 == null) goto L40;
        r17.setVisibility(0);
    L40:
        ListView r18 = this.mListView;
        if ((r18 instanceof RecycleListView) == false) goto L43;
        ((RecycleListView) r18).setHasDecor(r13, r14);
    L43:
        if (r12 == true) goto L52;
        View r19 = this.mListView;
        if (r19 != null) goto L48;
        r19 = this.mScrollView;
    L48:
        if (r19 == null) goto L52;
        if (r14 == false) goto L51;
        r11 = 2;
    L51:
        setScrollIndicators(r9, r19, r13 | r11, 3);
    L52:
        ListView r20 = this.mListView;
        if (r20 == null) goto L60;
        ListAdapter r21 = this.mAdapter;
        if (r21 == null) goto L61;
        r20.setAdapter(r21);
        int r22 = this.mCheckedItem;
        if (r22 <= (-1)) goto L62;
        r20.setItemChecked(r22, true);
        r20.setSelection(r22);
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L30:
        if (this.mListView != null) goto L33;
        r17 = null;
        goto L34
    L36:
        if (r9 == null) goto L40;
        View r23 = r9.findViewById(androidx.appcompat.R.id.textSpacerNoTitle);
        if (r23 == null) goto L40;
        r23.setVisibility(0);
        goto L40
    L15:
        if (r10.getVisibility() == 8) goto L17;
        r14 = true;
        goto L18
    L10:
        if (r8.getVisibility() == 8) goto L12;
        r13 = 1;
        goto L13
    L5:
        if (r4.getVisibility() == 8) goto L7;
        r12 = true;
        goto L8
    }

    private void setScrollIndicators(ViewGroup r3, View r4, int r5, int r6) {
        View r0 = this.mWindow.findViewById(androidx.appcompat.R.id.scrollIndicatorUp);
        View r2 = this.mWindow.findViewById(androidx.appcompat.R.id.scrollIndicatorDown);
        ViewCompat.setScrollIndicators(r4, r5, r6);
        if (r0 == null) goto L5;
        r3.removeView(r0);
    L5:
        if (r2 == null) goto L8;
        r3.removeView(r2);
        return;
    }

    private void setupCustomContent(ViewGroup r6) {
        View r0 = this.mView;
        boolean r1 = false;
        if (r0 == null) goto L6;
    L9:
        if (r0 == null) goto L11;
        r1 = true;
    L11:
        if (r1 == true) goto L13;
    L14:
        this.mWindow.setFlags(131072, 131072);
    L15:
        if (r1 == false) goto L22;
        FrameLayout r2 = (FrameLayout) this.mWindow.findViewById(androidx.appcompat.R.id.custom);
        r2.addView(r0, new ViewGroup.LayoutParams(-1, -1));
        if (this.mViewSpacingSpecified == false) goto L20;
        r2.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
    L20:
        if (this.mListView == null) goto L24;
        ((LinearLayoutCompat.LayoutParams) r6.getLayoutParams()).weight = 0.0f;
        return;
    L24:
        return;
    L22:
        r6.setVisibility(8);
        return;
    L13:
        if (canTextInput(r0) == true) goto L15;
    L6:
        if (this.mViewLayoutResId == 0) goto L8;
        r0 = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, r6, false);
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    private void setupTitle(ViewGroup r6) {
        if (this.mCustomTitleView == null) goto L5;
        r6.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
        this.mWindow.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
        return;
    L5:
        this.mIconView = (ImageView) this.mWindow.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(this.mTitle)) == true) goto L8;
    L16:
        this.mWindow.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
        this.mIconView.setVisibility(8);
        r6.setVisibility(8);
        return;
    L8:
        if (this.mShowTitle == false) goto L16;
        TextView r7 = (TextView) this.mWindow.findViewById(androidx.appcompat.R.id.alertTitle);
        this.mTitleView = r7;
        r7.setText(this.mTitle);
        int r8 = this.mIconId;
        if (r8 == 0) goto L12;
        this.mIconView.setImageResource(r8);
        return;
    L12:
        Drawable r9 = this.mIcon;
        if (r9 == null) goto L15;
        this.mIconView.setImageDrawable(r9);
        return;
    L15:
        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
        this.mIconView.setVisibility(8);
    }

    private void setupContent(ViewGroup r4) {
        NestedScrollView r0 = (NestedScrollView) this.mWindow.findViewById(androidx.appcompat.R.id.scrollView);
        this.mScrollView = r0;
        r0.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        TextView r1 = (TextView) r4.findViewById(R.id.message);
        this.mMessageView = r1;
        if (r1 != null) goto L5;
        return;
    L5:
        CharSequence r2 = this.mMessage;
        if (r2 == null) goto L8;
        r1.setText(r2);
        return;
    L8:
        r1.setVisibility(8);
        this.mScrollView.removeView(this.mMessageView);
        if (this.mListView == null) goto L11;
        ViewGroup r5 = (ViewGroup) this.mScrollView.getParent();
        int r3 = r5.indexOfChild(this.mScrollView);
        r5.removeViewAt(r3);
        r5.addView(this.mListView, r3, new ViewGroup.LayoutParams(-1, -1));
        return;
    L11:
        r4.setVisibility(8);
    }

    static void manageScrollIndicators(View r3, View r4, View r5) {
        int r0 = 0;
        if (r4 != null) goto L5;
    L9:
        if (r5 != null) goto L11;
        return;
    L11:
        if (r3.canScrollVertically(1) == true) goto L14;
        r0 = 4;
    L14:
        r5.setVisibility(r0);
        return;
    L5:
        if (r3.canScrollVertically(-1) == false) goto L7;
        int r2 = 0;
    L8:
        r4.setVisibility(r2);
        goto L9
    L7:
        r2 = 4;
        goto L8
    }

    private void setupButtons(ViewGroup r8) {
        Button r0 = (Button) r8.findViewById(R.id.button1);
        this.mButtonPositive = r0;
        r0.setOnClickListener(this.mButtonHandler);
        boolean r3 = true;
        if (TextUtils.isEmpty(this.mButtonPositiveText) == true) goto L5;
    L7:
        this.mButtonPositive.setText(this.mButtonPositiveText);
        Drawable r1 = this.mButtonPositiveIcon;
        if (r1 == null) goto L10;
        int r5 = this.mButtonIconDimen;
        r1.setBounds(0, 0, r5, r5);
        this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
    L10:
        this.mButtonPositive.setVisibility(0);
        int r2 = 1;
    L11:
        Button r6 = (Button) r8.findViewById(R.id.button2);
        this.mButtonNegative = r6;
        r6.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNegativeText) == true) goto L14;
    L16:
        this.mButtonNegative.setText(this.mButtonNegativeText);
        Drawable r7 = this.mButtonNegativeIcon;
        if (r7 == null) goto L19;
        int r9 = this.mButtonIconDimen;
        r7.setBounds(0, 0, r9, r9);
        this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
    L19:
        this.mButtonNegative.setVisibility(0);
        r2 = r2 | 2;
    L20:
        Button r10 = (Button) r8.findViewById(R.id.button3);
        this.mButtonNeutral = r10;
        r10.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNeutralText) == true) goto L23;
    L25:
        this.mButtonNeutral.setText(this.mButtonNeutralText);
        Drawable r11 = this.mButtonNeutralIcon;
        if (r11 == null) goto L28;
        int r12 = this.mButtonIconDimen;
        r11.setBounds(0, 0, r12, r12);
        this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
    L28:
        this.mButtonNeutral.setVisibility(0);
        r2 = r2 | 4;
    L30:
        if (shouldCenterSingleButton(this.mContext) == false) goto L39;
        if (r2 != 1) goto L34;
        centerButton(this.mButtonPositive);
        goto L39
    L34:
        if (r2 != 2) goto L37;
        centerButton(this.mButtonNegative);
        goto L39
    L37:
        if (r2 != 4) goto L39;
        centerButton(this.mButtonNeutral);
    L39:
        if (r2 != 0) goto L42;
        r3 = false;
    L42:
        if (r3 == true) goto L45;
        r8.setVisibility(8);
        return;
    L45:
        return;
    L23:
        if (this.mButtonNeutralIcon != null) goto L25;
        this.mButtonNeutral.setVisibility(8);
        goto L30
    L14:
        if (this.mButtonNegativeIcon != null) goto L16;
        this.mButtonNegative.setVisibility(8);
        goto L20
    L5:
        if (this.mButtonPositiveIcon != null) goto L7;
        this.mButtonPositive.setVisibility(8);
        r2 = 0;
        goto L11
    }

    private void centerButton(Button r2) {
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r2.getLayoutParams();
        r1.gravity = 1;
        r1.weight = 0.5f;
        r2.setLayoutParams(r1);
    }
}
