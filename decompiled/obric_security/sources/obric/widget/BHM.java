package obric.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BHM {
    private static final String TAG = "BHM";
    private View dialogContentView;
    private boolean isSingleOnly;
    private BHMListAdapter mCombinedAdapter;
    private List<BHMDrawerItem> mCombinedItems;
    private OnBHMListItemClickListener mCombinedListItemClickListener;
    private ListView mCombinedListView;
    private BHMContentLayout mContentLayout;
    private BHMListAdapter mCustomCombinedAdapter;
    private BHMListAdapter mCustomSingleAdapter;
    private BHMDialog mDialog;
    private BHMDialogListener mDialogListener;
    private OnTitleButtonClickListener mLeftLitener;
    private OnTitleButtonClickListener mRightLitener;
    private BHMListAdapter mSingleAdapter;
    private List<BHMDrawerItem> mSingleItems;
    private OnBHMListItemClickListener mSingleListItemClickListener;
    private ListView mSingleListView;
    private Animation mSlideInFromLeft;
    private Animation mSlideInFromRight;
    private Animation mSlideOutToLeft;
    private Animation mSlideOutToRight;
    private String mTitle;
    private Window mWindow;
    private MenuDialogTitleBar titleBar;

    private class BHMDialog extends Dialog {
        final /* synthetic */ BHM this$0;

        public BHMDialog(final BHM this$0, Context context, int theme) {
            this.this$0 = this$0;
            super(context, theme);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            if (BHM.access$600(this.this$0) != null) goto L5;
            return;
        L5:
            if (BHM.access$600(this.this$0).onBackPressed() == true) goto L9;
            super.onBackPressed();
            return;
        }
    }

    public interface BHMDialogListener {
        boolean onBackPressed();

        void onDialogDismiss();

        void onDialogShow();

        void onDialogStatueChanged();
    }

    public interface OnBHMListItemClickListener {
        void onItemClick(AdapterView<?> parent, View view, int position, long id);
    }

    public interface OnTitleButtonClickListener {
        void onClick(View view);
    }

    static {
    }

    private static void setMaxTextSize(View view, int dimenRes) {
    }

    @Deprecated
    public void setRightButtonText(String text) {
    }

    static /* synthetic */ OnBHMListItemClickListener access$000(BHM r0) {
        return r0.mSingleListItemClickListener;
    }

    static /* synthetic */ OnBHMListItemClickListener access$100(BHM r0) {
        return r0.mCombinedListItemClickListener;
    }

    static /* synthetic */ ListView access$200(BHM r0) {
        return r0.mCombinedListView;
    }

    static /* synthetic */ ListView access$300(BHM r0) {
        return r0.mSingleListView;
    }

    static /* synthetic */ OnTitleButtonClickListener access$400(BHM r0) {
        return r0.mLeftLitener;
    }

    static /* synthetic */ OnTitleButtonClickListener access$500(BHM r0) {
        return r0.mRightLitener;
    }

    static /* synthetic */ BHMDialogListener access$600(BHM r0) {
        return r0.mDialogListener;
    }

    public BHM() {
    }

    public void setCustomCombinedAdapter(BHMListAdapter adapter) {
        this.mCustomCombinedAdapter = adapter;
        this.mCombinedAdapter = adapter;
        ListView r0 = this.mCombinedListView;
        if (r0 == null) goto L6;
        r0.setAdapter(adapter);
        return;
    }

    public void setCustomSingleAdapter(BHMListAdapter adapter) {
        this.mCustomSingleAdapter = adapter;
        this.mSingleAdapter = adapter;
        ListView r0 = this.mSingleListView;
        if (r0 == null) goto L6;
        r0.setAdapter(adapter);
        return;
    }

    public void initBottomFolderListDialog(Context context) {
        initBottomFolderListDialog(context, null, null);
    }

    public void setSingleOnlyMode(boolean isSingleOnly) {
        this.isSingleOnly = isSingleOnly;
    }

    public void initBottomFolderListDialog(Context context, ArrayList<BHMDrawerItem> combinedItems, ArrayList<BHMDrawerItem> singleItems) {
        this.mCombinedItems = combinedItems;
        this.mSingleItems = singleItems;
        BHMDialog r7 = new BHMDialog(this, context, R.style.BHMDialog);
        this.mDialog = r7;
        Window r8 = r7.getWindow();
        this.mWindow = r8;
        if (r8 == null) goto L5;
        r8.setGravity(80);
    L5:
        Activity r9 = (Activity) context;
        View r10 = r9.getLayoutInflater().inflate(R.layout.bhm_content_layout, null);
        this.dialogContentView = r10;
        ListView r11 = (ListView) r10.findViewById(R.id.single_list_view);
        this.mSingleListView = r11;
        r11.setSelector(android.R.color.transparent);
        this.mSingleListView.setDividerHeight(0);
        View r12 = r9.getLayoutInflater().inflate(R.layout.bhm_list_header_separator, this.mSingleListView, false);
        this.mSingleListView.addHeaderView(r12, null, false);
        if (this.isSingleOnly == false) goto L8;
        showSingleList();
    L8:
        BHMListAdapter r13 = this.mCustomSingleAdapter;
        if (r13 == null) goto L11;
        this.mSingleAdapter = r13;
    L16:
        BHMListAdapter r14 = this.mSingleAdapter;
        if (r14 == null) goto L19;
        this.mSingleListView.setAdapter(r14);
    L19:
        this.mSingleListView.setOnItemClickListener(new AnonymousClass1(this));
        if (this.isSingleOnly == true) goto L36;
        ViewStub r15 = (ViewStub) this.dialogContentView.findViewById(R.id.combined_list_view_view_stub);
        if (r15 == null) goto L24;
        r15.inflate();
    L24:
        ListView r16 = (ListView) this.dialogContentView.findViewById(R.id.combined_list_view);
        this.mCombinedListView = r16;
        r16.setSelector(android.R.color.transparent);
        this.mCombinedListView.setDividerHeight(0);
        View r17 = r9.getLayoutInflater().inflate(R.layout.bhm_list_header_separator, this.mCombinedListView, false);
        this.mCombinedListView.addHeaderView(r17, null, false);
        BHMListAdapter r18 = this.mCustomCombinedAdapter;
        if (r18 == null) goto L27;
        this.mCombinedAdapter = r18;
    L32:
        BHMListAdapter r19 = this.mCombinedAdapter;
        if (r19 == null) goto L35;
        this.mCombinedListView.setAdapter(r19);
    L35:
        this.mCombinedListView.setOnItemClickListener(new AnonymousClass2(this));
        goto L36
    L27:
        List<BHMDrawerItem> r20 = this.mCombinedItems;
        if (r20 == null) goto L32;
        if (r20.size() <= 0) goto L32;
        this.mCombinedAdapter = new BHMListAdapter(this.mCombinedItems);
    L36:
        Point r21 = getScreenSize(context);
        int r22 = r21.y;
        int r23 = r21.x;
        BHMContentLayout r0 = (BHMContentLayout) this.dialogContentView.findViewById(R.id.bhm_content_layout);
        this.mContentLayout = r0;
        r0.setMaxHeight((r22 * 2) / 3);
        this.mDialog.setContentView(this.dialogContentView, new ViewGroup.LayoutParams(r23, -2));
        onViewCreated(this.dialogContentView);
        if (this.isSingleOnly == true) goto L40;
        initAnim(context);
        return;
    L40:
        return;
    L11:
        List<BHMDrawerItem> r24 = this.mSingleItems;
        if (r24 == null) goto L16;
        if (r24.size() <= 0) goto L16;
        this.mSingleAdapter = new BHMListAdapter(this.mSingleItems);
        goto L16
    }

    public Window getDialogWindow() {
        return this.mWindow;
    }

    public BHMDialog getDialog() {
        return this.mDialog;
    }

    public void setCancelable(boolean cancelable) {
        BHMDialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.setCancelable(cancelable);
        return;
    }

    public void showSingleList() {
        this.mSingleListView.setVisibility(0);
        if (this.isSingleOnly == false) goto L5;
        return;
    L5:
        this.mCombinedListView.setVisibility(8);
    }

    public void showCombinedList() {
        if (this.isSingleOnly == false) goto L5;
        return;
    L5:
        this.mSingleListView.setVisibility(8);
        this.mCombinedListView.setVisibility(0);
    }

    public void enterSingleList(String title, boolean withAnim, boolean onlySingle) {
        if (this.mSingleAdapter == null) goto L14;
        ViewGroup.LayoutParams r0 = this.dialogContentView.getLayoutParams();
        r0.height = this.dialogContentView.getHeight();
        setTitle(title);
        if (onlySingle == false) goto L7;
    L13:
        this.titleBar.setLeftButtonVisibility(4);
        showSingleList();
        return;
    L7:
        if (this.isSingleOnly == true) goto L13;
        this.titleBar.setLeftButtonVisibility(0);
        if (withAnim == false) goto L12;
        this.mCombinedListView.startAnimation(this.mSlideOutToLeft);
        this.mSingleListView.startAnimation(this.mSlideInFromRight);
        return;
    L12:
        showSingleList();
        return;
    L14:
        Log.w(TAG, "mSingleAdapter is null, can not enter single list.");
    }

    public void enterCombinedList(boolean withAnim) {
        if (this.isSingleOnly == false) goto L5;
        return;
    L5:
        this.titleBar.setLeftButtonVisibility(4);
        setTitle(this.mTitle);
        if (withAnim == false) goto L8;
        this.mCombinedListView.startAnimation(this.mSlideInFromLeft);
        this.mSingleListView.startAnimation(this.mSlideOutToRight);
        return;
    L8:
        showCombinedList();
    }

    public ListView getCombinedListView() {
        return this.mCombinedListView;
    }

    public ListView getSingleListView() {
        return this.mSingleListView;
    }

    private void initAnim(Context context) {
        this.mSlideInFromRight = AnimationUtils.loadAnimation(context, R.anim.bhm_slide_in_from_right);
        Animation r0 = AnimationUtils.loadAnimation(context, R.anim.bhm_slide_out_to_left);
        this.mSlideOutToLeft = r0;
        r0.setAnimationListener(new AnonymousClass3(this));
        this.mSlideInFromLeft = AnimationUtils.loadAnimation(context, R.anim.bhm_slide_in_from_left);
        Animation r3 = AnimationUtils.loadAnimation(context, R.anim.bhm_slide_out_to_right);
        this.mSlideOutToRight = r3;
        r3.setAnimationListener(new AnonymousClass4(this));
    }

    public void setOnCombinedListItemClickListener(OnBHMListItemClickListener listener) {
        this.mCombinedListItemClickListener = listener;
    }

    public void setOnSingleListItemClickListener(OnBHMListItemClickListener listener) {
        this.mSingleListItemClickListener = listener;
    }

    private Point getScreenSize(Context context) {
        WindowManager r0 = (WindowManager) context.getSystemService("window");
        Point r1 = new Point();
        r0.getDefaultDisplay().getRealSize(r1);
        return r1;
    }

    public void setOnLeftButtonClickListener(OnTitleButtonClickListener listener) {
        this.mLeftLitener = listener;
    }

    public void setOnRightButtonClickListener(OnTitleButtonClickListener listener) {
        this.mRightLitener = listener;
    }

    private void onViewCreated(View root) {
        MenuDialogTitleBar r2 = (MenuDialogTitleBar) root.findViewById(R.id.menu_dialog_title_bar);
        this.titleBar = r2;
        if (this.isSingleOnly == true) goto L5;
        r2.getLeftImageView().setImageResource(R.drawable.standard_icon_back_selector);
        this.titleBar.setOnLeftButtonClickListener(new AnonymousClass5(this));
    L5:
        this.titleBar.setTitleSingleLine(true);
        this.titleBar.addCancelImage(false);
        this.titleBar.setOnRightButtonClickListener(new AnonymousClass6(this));
    }

    public void setTitle(String text) {
        this.mTitle = text;
        MenuDialogTitleBar r0 = this.titleBar;
        if (r0 == null) goto L6;
        r0.setTitle(text);
        return;
    }

    public void setTitleBarTopShadowVisibility(boolean visible) {
        this.titleBar.showTopShadow(visible);
    }

    public int getTitleBarTopShadowHeight() {
        return this.titleBar.getTopShadowHeight();
    }

    @Deprecated
    public void setLeftButtonText(String text) {
        this.titleBar.setLeftButtonText(text);
    }

    public void setLeftImageViewRes(int id) {
        this.titleBar.setLeftImageViewRes(id);
    }

    public void setRightImageViewRes(int id) {
        this.titleBar.setRightImageRes(id);
    }

    public void setDialogListener(BHMDialogListener listener) {
        if (listener != null) goto L4;
        return;
    L4:
        this.mDialogListener = listener;
        this.mDialog.setOnDismissListener(new AnonymousClass7(this));
        this.mDialog.setOnShowListener(new AnonymousClass8(this));
    }

    public void setData(ArrayList<BHMDrawerItem> combinedItems, ArrayList<BHMDrawerItem> singleItems) {
        if (this.isSingleOnly == true) goto L5;
        this.mCombinedItems = combinedItems;
        this.mCombinedAdapter.notifyDataSetChanged();
    L5:
        this.mSingleItems = singleItems;
        this.mSingleAdapter.notifyDataSetChanged();
    }

    public void setMaxHeight(int height) {
        BHMContentLayout r0 = this.mContentLayout;
        if (r0 == null) goto L6;
        r0.setMaxHeight(height);
        return;
    }

    public void showBHM() {
        this.mDialog.show();
    }

    public void dismissBHM() {
        this.mDialog.dismiss();
    }

    public boolean isBHMShowing() {
        BHMDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isShowing();
    }
}
