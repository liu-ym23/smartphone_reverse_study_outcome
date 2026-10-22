package com.android.settings.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;
import java.util.ArrayList;
import java.util.List;
import obric.widget.SearchBar;
import obric.widget.support.IMenuItem;
import obric.widget.support.ListPopupMenu;

/* JADX INFO: loaded from: classes.dex */
public class SearchBarSmt extends RelativeLayout implements AdapterView.OnItemClickListener {
    private static final float ARROW_X_DIP = 190.6f;
    public static final int FILTER_BY_NAME = 2;
    public static final int FILTER_BY_SWITCH = 1;
    private static final float X_DIP = 218.5f;
    private static final float Y_DIP = 6.5f;
    private static int sSortMode = 2;
    private ImageView mBtnSort;
    private ListPopupMenu mBytedanceListPopupMenu;
    private Context mContext;
    private SortTypeMenuItem mCurrentSelectItem;
    private boolean mIsNoAnimCancel;
    private Listener mListener;
    private List<IMenuItem> mMenus;
    private SearchBar mSearchBar;
    private SearchBarListener mSearchBarListener;
    private EditText mSearchEdit;

    /* JADX INFO: renamed from: com.android.settings.widget.SearchBarSmt$1, reason: invalid class name */
    class AnonymousClass1 implements PopupWindow.OnDismissListener {
        final /* synthetic */ SearchBarSmt this$0;

        AnonymousClass1(SearchBarSmt r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            SearchBarSmt.access$300(this.this$0).setActivated(false);
            SearchBarSmt.access$400(this.this$0).setEnabled(true);
        }
    }

    public static class FilterMode {
        public static final int FILTER_APP_LOCK = 1;

        public FilterMode() {
        }
    }

    public interface Listener {
        void endSearchAnimation();

        void hideQuickContactView();

        boolean onModeChange(int r1);

        void onQueryTextChange(String r1);

        void recoverQuickBar();

        void startSearchAnimation();
    }

    private class SearchBarListener extends SearchBar.ListenerAdapter {
        final /* synthetic */ SearchBarSmt this$0;

        private SearchBarListener(SearchBarSmt r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SearchBarListener(SearchBarSmt r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void exeAnimationStart() {
            if (this.this$0.isInSearchMode() == false) goto L6;
            SearchBarSmt.access$102(this.this$0, false);
            SearchBarSmt.access$200(this.this$0).startSearchAnimation();
            return;
        L6:
            if (SearchBarSmt.access$100(this.this$0) == true) goto L10;
            SearchBarSmt.access$200(this.this$0).endSearchAnimation();
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void searchText(String r2) {
            if (SearchBarSmt.access$200(this.this$0) != null) goto L5;
            return;
        L5:
            if (this.this$0.isInSearchMode() == false) goto L9;
            SearchBarSmt.access$200(this.this$0).onQueryTextChange(r2);
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchEdit() {
            if (SearchBarSmt.access$200(this.this$0) == null) goto L6;
            SearchBarSmt.access$200(this.this$0).hideQuickContactView();
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickCancelButton() {
            SearchBarSmt.access$300(this.this$0).setEnabled(true);
            if (TextUtils.isEmpty(SearchBarSmt.access$400(this.this$0).getText().toString()) == true) goto L6;
            this.this$0.clearSearchText();
        L6:
            if (SearchBarSmt.access$200(this.this$0) == null) goto L9;
            SearchBarSmt.access$200(this.this$0).onQueryTextChange("");
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchRightView() {
            if (SearchBarSmt.access$200(this.this$0) == null) goto L5;
            SearchBarSmt.access$200(this.this$0).hideQuickContactView();
            SearchBarSmt.access$200(this.this$0).recoverQuickBar();
        L5:
            SearchBarSmt.access$400(this.this$0).setEnabled(false);
            SearchBarSmt.access$500(this.this$0);
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchLeftIcon() {
            super.onClickSearchLeftIcon();
        }
    }

    public class SortTypeMenuItem implements IMenuItem {
        public int mIconRes;
        public boolean mSelected;
        public int mTitleResId;
        public int mValue;
        final /* synthetic */ SearchBarSmt this$0;

        @Override // obric.widget.support.IMenuItem
        public boolean hasMenuIcon() {
            return true;
        }

        public SortTypeMenuItem(SearchBarSmt r7, int r8, boolean r9, int r10) {
            this(r7, r8, r9, r10, -1);
        }

        public SortTypeMenuItem(SearchBarSmt r1, int r2, boolean r3, int r4, int r5) {
            this.this$0 = r1;
            this.mTitleResId = r2;
            this.mSelected = r3;
            this.mValue = r4;
            this.mIconRes = r5;
        }

        @Override // obric.widget.support.IMenuItem
        public String getTitle() {
            return SearchBarSmt.access$600(this.this$0, this.mTitleResId);
        }

        @Override // obric.widget.support.IMenuItem
        public void setMenuIcon(ImageView r1) {
            r1.setImageResource(this.mIconRes);
        }

        public int getValue() {
            return this.mValue;
        }

        @Override // obric.widget.support.IMenuItem
        public boolean isSelected() {
            return this.mSelected;
        }

        public void setSelected(boolean r1) {
            this.mSelected = r1;
        }
    }

    static {
    }

    static /* synthetic */ boolean access$100(SearchBarSmt r0) {
        return r0.mIsNoAnimCancel;
    }

    static /* synthetic */ boolean access$102(SearchBarSmt r0, boolean r1) {
        r0.mIsNoAnimCancel = r1;
        return r1;
    }

    static /* synthetic */ Listener access$200(SearchBarSmt r0) {
        return r0.mListener;
    }

    static /* synthetic */ ImageView access$300(SearchBarSmt r0) {
        return r0.mBtnSort;
    }

    static /* synthetic */ EditText access$400(SearchBarSmt r0) {
        return r0.mSearchEdit;
    }

    static /* synthetic */ void access$500(SearchBarSmt r0) {
        r0.showSortByPopupWindow();
    }

    static /* synthetic */ String access$600(SearchBarSmt r0, int r1) {
        return r0.getTitleStr(r1);
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    public SearchBarSmt(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mBtnSort = null;
        this.mCurrentSelectItem = null;
        this.mIsNoAnimCancel = false;
        this.mContext = r1;
        this.mSearchBar = (SearchBar) NullSafe.nonNull(((LayoutInflater) NullSafe.nonNull(r1.getSystemService("layout_inflater"))).inflate(R.layout.searchbar, this).findViewById(R.id.search_bar));
        setViews();
    }

    private void setViews() {
        SearchBarListener r0 = new SearchBarListener(this, null);
        this.mSearchBarListener = r0;
        this.mSearchBar.setListener(r0);
        ImageView r1 = (ImageView) this.mSearchBar.getSearchRightView();
        this.mBtnSort = r1;
        r1.setContentDescription(getContext().getString(R.string.filter_dlg_title));
        this.mSearchEdit = (EditText) this.mSearchBar.getSearchEditor();
    }

    public void cancelSearch() {
        if (isPlayingSearchAnimation() == false) goto L5;
        return;
    L5:
        if (isInSearchMode() == false) goto L9;
        this.mSearchBar.onClickCancelView(true);
        this.mBtnSort.setEnabled(true);
        return;
    }

    public boolean isPlayingSearchAnimation() {
        return this.mSearchBar.isPlayingAnimation();
    }

    public boolean isInSearchMode() {
        return this.mSearchBar.isSearchMode();
    }

    public void clearSearchText() {
        EditText r1 = this.mSearchEdit;
        if (r1 == null) goto L6;
        r1.setText("");
        return;
    }

    private void showSortByPopupWindow() {
        this.mBtnSort.setActivated(true);
        this.mBytedanceListPopupMenu = new ListPopupMenu(this.mContext);
        List<IMenuItem> r2 = this.mMenus;
        if (r2 != null) goto L5;
        return;
    L5:
        List r0 = null;
        r0.add((IMenuItem) r2);
        throw null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        if (r3 >= this.mMenus.size()) goto L11;
        if (r3 < 0) goto L12;
        SortTypeMenuItem r5 = (SortTypeMenuItem) this.mMenus.get(r3);
        if (r5 != null) goto L9;
        return;
    L9:
        switchSelectedItem(r5);
        return;
    L12:
        return;
    }

    private void switchSelectedItem(SortTypeMenuItem r3) {
        ListPopupMenu r0 = this.mBytedanceListPopupMenu;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        this.mBytedanceListPopupMenu.dismiss();
    L8:
        if (this.mCurrentSelectItem != r3) goto L11;
        return;
    L11:
        if (this.mListener.onModeChange(r3.getValue()) == false) goto L14;
        sSortMode = r3.getValue();
        this.mCurrentSelectItem.setSelected(false);
        this.mCurrentSelectItem = r3;
        r3.setSelected(true);
        return;
    }

    private String getTitleStr(int r1) {
        Context r0 = this.mContext;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString(r1);
    }

    private List<IMenuItem> getMenusByMode(int r14) {
        SortTypeMenuItem r6 = new SortTypeMenuItem(this, R.string.switch_status, false, 1, R.drawable.sort_menu_switch_icon);
        SortTypeMenuItem r0 = new SortTypeMenuItem(this, R.string.sort_by_name, false, 2, R.drawable.sort_menu_name_icon);
        ArrayList r1 = new ArrayList();
        if (sSortMode != 1) goto L5;
        r6.setSelected(true);
        this.mCurrentSelectItem = r6;
    L6:
        if (r14 != 1) goto L9;
        r1.add(r0);
        r1.add(r6);
    L9:
        return r1;
    L5:
        r0.setSelected(true);
        this.mCurrentSelectItem = r0;
        goto L6
    }

    public void setFilterMode(int r1) {
        this.mMenus = getMenusByMode(r1);
    }
}
