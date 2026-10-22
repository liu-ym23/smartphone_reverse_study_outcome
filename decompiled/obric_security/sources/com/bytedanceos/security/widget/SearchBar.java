package com.bytedanceos.security.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.List;
import obric.widget.support.IMenuItem;
import obric.widget.support.ListPopMenuStandardAdapter;
import obric.widget.support.ListPopupMenu;

/* JADX INFO: loaded from: classes2.dex */
public class SearchBar extends RelativeLayout implements AdapterView.OnItemClickListener {
    public static final int FILTER_BY_ALL = 6;
    public static final int FILTER_BY_ALLOW = 0;
    public static final int FILTER_BY_ALLOWED = 7;
    public static final int FILTER_BY_ALLOW_ASK = 0;
    public static final int FILTER_BY_DENY = 0;
    public static final int FILTER_BY_INUSE = 0;
    public static final int FILTER_BY_NOT_ALLOW = 8;
    public static final int FILTER_BY_NOT_SET = 7;
    public static final int FILTER_DANGROUS_IN_USE = 13;
    public static final int FILTER_NET_ALLOW = 10;
    public static final int FILTER_NET_DISCONNECT_BACKGROUD = 12;
    public static final int FILTER_NET_DISCONNECT_KEYGUARD = 11;
    private ImageView mBtnSort;
    private Context mContext;
    private SortTypeMenuItem mCurrentSelectItem;
    private boolean mIsNoAnimCancel;
    private ListPopupMenu mListPopupMenu;
    private Listener mListener;
    private List<IMenuItem> mMenus;
    private SearchBarListener mSearchBarListener;
    private obric.widget.SearchBar mSearchBarView;
    private EditText mSearchEdit;

    private class AnimationListenerWrapper implements Animation.AnimationListener {
        final /* synthetic */ SearchBar this$0;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        private AnimationListenerWrapper(final SearchBar this$0) {
            this.this$0 = this$0;
        }
    }

    public static class FILTER_MODE {
        public static final int FILTER_BY_ALLOWED_NOT_ALLOW = 7;
        public static final int FILTER_DANGROUS_IN_USE = 6;
        public static final int FILTER_LOCATION = 3;
        public static final int FILTER_NET = 5;
        public static final int FILTER_NORMAL = 1;
        public static final int FILTER_PERMISSION_ALL = 4;
        public static final int FILTER_SWITCH = 2;

        public FILTER_MODE() {
        }
    }

    public interface Listener {
        void endSearchAnimation();

        void endSearchAnimationWithoutAnimation();

        void hideQuickContactView();

        boolean onModeChange(int sortMode);

        void onQueryTextChange(String newString);

        void recoverQuickBar();

        void setSoftKeyboardHide();

        void startSearchAnimation();
    }

    private class SearchBarListener extends obric.widget.SearchBar.ListenerAdapter {
        final /* synthetic */ SearchBar this$0;

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void exeAnimationEnd() {
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchLeftIcon() {
        }

        private SearchBarListener(final SearchBar this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ SearchBarListener(SearchBar r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickCancelButton() {
            SearchBar.access$100(this.this$0).setEnabled(true);
            if (TextUtils.isEmpty(SearchBar.access$200(this.this$0).getText().toString()) == true) goto L6;
            this.this$0.clearSearchText();
        L6:
            if (SearchBar.access$300(this.this$0) == null) goto L9;
            SearchBar.access$300(this.this$0).onQueryTextChange("");
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchEdit() {
            if (SearchBar.access$300(this.this$0) == null) goto L6;
            SearchBar.access$300(this.this$0).hideQuickContactView();
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchRightView() {
            if (SearchBar.access$300(this.this$0) == null) goto L5;
            SearchBar.access$300(this.this$0).hideQuickContactView();
            SearchBar.access$300(this.this$0).recoverQuickBar();
        L5:
            SearchBar.access$200(this.this$0).setEnabled(false);
            SearchBar.access$400(this.this$0);
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void searchText(String text) {
            if (SearchBar.access$300(this.this$0) != null) goto L5;
            return;
        L5:
            if (this.this$0.isInSearchMode() == false) goto L9;
            SearchBar.access$300(this.this$0).onQueryTextChange(text);
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void exeAnimationStart() {
            if (this.this$0.isInSearchMode() == false) goto L6;
            SearchBar.access$502(this.this$0, false);
            SearchBar.access$300(this.this$0).startSearchAnimation();
            return;
        L6:
            if (SearchBar.access$500(this.this$0) == true) goto L10;
            SearchBar.access$300(this.this$0).setSoftKeyboardHide();
            SearchBar.access$300(this.this$0).endSearchAnimation();
            return;
        }
    }

    public class SortTypeMenuItem implements IMenuItem {
        public boolean selected;
        final /* synthetic */ SearchBar this$0;
        public int titleResId;
        public int value;

        @Override // obric.widget.support.IMenuItem
        public boolean hasMenuIcon() {
            return false;
        }

        @Override // obric.widget.support.IMenuItem
        public void setMenuIcon(ImageView targetImageView) {
        }

        public SortTypeMenuItem(final SearchBar this$0, int titleId, boolean selected, int value) {
            this.this$0 = this$0;
            this.titleResId = titleId;
            this.selected = selected;
            this.value = value;
        }

        @Override // obric.widget.support.IMenuItem
        public String getTitle() {
            return SearchBar.access$600(this.this$0, this.titleResId);
        }

        public int getValue() {
            return this.value;
        }

        @Override // obric.widget.support.IMenuItem
        public boolean isSelected() {
            return this.selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

    static /* synthetic */ ImageView access$100(SearchBar r0) {
        return r0.mBtnSort;
    }

    static /* synthetic */ EditText access$200(SearchBar r0) {
        return r0.mSearchEdit;
    }

    static /* synthetic */ Listener access$300(SearchBar r0) {
        return r0.mListener;
    }

    static /* synthetic */ void access$400(SearchBar r0) {
        r0.showSortByPopupWindow();
    }

    static /* synthetic */ boolean access$500(SearchBar r0) {
        return r0.mIsNoAnimCancel;
    }

    static /* synthetic */ boolean access$502(SearchBar r0, boolean r1) {
        r0.mIsNoAnimCancel = r1;
        return r1;
    }

    static /* synthetic */ String access$600(SearchBar r0, int r1) {
        return r0.getTitleStr(r1);
    }

    static {
        FILTER_BY_ALLOW = OpsManagerHelper.get_MODE_ALLOWED();
        FILTER_BY_ALLOW_ASK = OpsManagerHelper.get_MODE_ASK();
        FILTER_BY_DENY = OpsManagerHelper.get_MODE_IGNORED();
        FILTER_BY_INUSE = OpsManagerHelper.get_MODE_DURING_USE();
    }

    private List<IMenuItem> getMenusByMode(int mode) {
        SortTypeMenuItem r1 = new SortTypeMenuItem(this, R.string.permission_status_all, false, 6);
        int r3 = FILTER_BY_ALLOW;
        SortTypeMenuItem r2 = new SortTypeMenuItem(this, R.string.permission_status_allow, false, r3);
        int r6 = FILTER_BY_DENY;
        SortTypeMenuItem r5 = new SortTypeMenuItem(this, R.string.permission_status_deny, false, r6);
        SortTypeMenuItem r8 = new SortTypeMenuItem(this, R.string.permission_status_prompt, false, FILTER_BY_ALLOW_ASK);
        SortTypeMenuItem r9 = new SortTypeMenuItem(this, R.string.permission_status_foreground_allow, false, FILTER_BY_INUSE);
        SortTypeMenuItem r10 = new SortTypeMenuItem(this, R.string.permission_status_not_set, false, 7);
        SortTypeMenuItem r11 = new SortTypeMenuItem(this, R.string.switch_open, false, r3);
        SortTypeMenuItem r4 = new SortTypeMenuItem(this, R.string.switch_close, false, r6);
        SortTypeMenuItem r7 = new SortTypeMenuItem(this, R.string.background_network_allow, false, 10);
        SortTypeMenuItem r13 = new SortTypeMenuItem(this, R.string.background_network_reject_screen_off, false, 11);
        SortTypeMenuItem r14 = new SortTypeMenuItem(this, R.string.background_network_reject, false, 12);
        SortTypeMenuItem r12 = new SortTypeMenuItem(this, R.string.permission_allow_in_use, false, 13);
        SortTypeMenuItem r15 = new SortTypeMenuItem(this, R.string.permission_allow_button, false, 7);
        SortTypeMenuItem r16 = new SortTypeMenuItem(this, R.string.permission_status_deny, false, 8);
        ArrayList r17 = new ArrayList();
        r1.setSelected(true);
        this.mCurrentSelectItem = r1;
        r17.add(r1);
        switch(mode) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L12;
        };
    L5:
        r17.add(r15);
        r17.add(r16);
        goto L12
    L6:
        r17.add(r2);
        r17.add(r12);
        r17.add(r5);
        goto L12
    L7:
        r17.add(r7);
        r17.add(r13);
        r17.add(r14);
        goto L12
    L8:
        r17.add(r10);
        r17.add(r2);
        r17.add(r8);
        r17.add(r5);
        goto L12
    L9:
        r17.add(r10);
        r17.add(r2);
        r17.add(r9);
        r17.add(r5);
        goto L12
    L10:
        r17.add(r11);
        r17.add(r4);
        goto L12
    L11:
        r17.add(r2);
        r17.add(r5);
    L12:
        return r17;
    }

    public SearchBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBtnSort = null;
        this.mIsNoAnimCancel = false;
        this.mCurrentSelectItem = null;
        this.mContext = context;
        LayoutInflater r2 = (LayoutInflater) context.getSystemService("layout_inflater");
        if (r2 == null) goto L6;
        this.mSearchBarView = (obric.widget.SearchBar) r2.inflate(R.layout.searchbar, this).findViewById(R.id.search_bar);
        setViews();
        return;
    }

    private void setViews() {
        SearchBarListener r0 = new SearchBarListener(this, null);
        this.mSearchBarListener = r0;
        obric.widget.SearchBar r1 = this.mSearchBarView;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setListener(r0);
        ImageView r2 = (ImageView) this.mSearchBarView.getSearchRightView();
        this.mBtnSort = r2;
        r2.setContentDescription(getContext().getString(R.string.filter_dlg_title));
        this.mSearchBarView.getClearView().setContentDescription(this.mContext.getString(R.string.clear_search_tip));
        this.mSearchEdit = (EditText) this.mSearchBarView.getSearchEditor();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        obric.widget.SearchBar r0 = this.mSearchBarView;
        if (r0 == null) goto L6;
        r0.setEnabled(enabled);
        return;
    }

    public void setSortButton(boolean hide) {
        this.mSearchBarView.setHasSearchRightView(!hide);
    }

    public void clearSearchText() {
        EditText r1 = this.mSearchEdit;
        if (r1 == null) goto L6;
        r1.setText("");
        return;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position >= this.mMenus.size()) goto L11;
        if (position < 0) goto L12;
        SortTypeMenuItem r1 = (SortTypeMenuItem) this.mMenus.get(position);
        if (r1 != null) goto L9;
        return;
    L9:
        switchSelectedItem(r1);
        return;
    L12:
        return;
    }

    private void showSortByPopupWindow() {
        this.mBtnSort.setActivated(true);
        this.mListPopupMenu = new ListPopupMenu(this.mContext);
        if (this.mMenus != null) goto L5;
        return;
    L5:
        ListPopMenuStandardAdapter r0 = new ListPopMenuStandardAdapter(this.mContext, this.mMenus);
        this.mListPopupMenu.setAnchorView(this.mBtnSort);
        this.mListPopupMenu.setAdapter(r0);
        this.mListPopupMenu.setMenuListTitle(this.mContext.getString(R.string.filter_menu_title));
        this.mListPopupMenu.setMenuListTitleVisible(true);
        this.mListPopupMenu.setOnItemClickListener(this);
        this.mListPopupMenu.setOnDismissListener(new AnonymousClass1(this));
        this.mListPopupMenu.show(0, (int) (-this.mContext.getResources().getDimension(R.dimen.permission_popwindow_x)), (int) (-this.mContext.getResources().getDimension(R.dimen.permission_popwindow_y)), (int) this.mContext.getResources().getDimension(R.dimen.permission_popwindow_arrow_x), 0);
    }

    public void setFilterMode(int mode) {
        this.mMenus = getMenusByMode(mode);
    }

    private void switchSelectedItem(SortTypeMenuItem item) {
        ListPopupMenu r0 = this.mListPopupMenu;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        this.mListPopupMenu.dismiss();
    L8:
        if (this.mCurrentSelectItem != item) goto L11;
        return;
    L11:
        if (this.mListener.onModeChange(item.getValue()) == false) goto L14;
        this.mCurrentSelectItem.setSelected(false);
        this.mCurrentSelectItem = item;
        item.setSelected(true);
        return;
    }

    public void cancelSearch() {
        if (isPlayingSearchAnimation() == false) goto L5;
        return;
    L5:
        if (isInSearchMode() == false) goto L9;
        this.mSearchBarView.onClickCancelView(true);
        this.mBtnSort.setEnabled(true);
        return;
    }

    public void cancelSearchWithoutAnimation() {
        if (isPlayingSearchAnimation() == false) goto L5;
        return;
    L5:
        if (isInSearchMode() == false) goto L11;
        this.mIsNoAnimCancel = true;
        this.mSearchBarView.onClickCancelView(false);
        this.mBtnSort.setEnabled(true);
        Listener r3 = this.mListener;
        if (r3 == null) goto L12;
        r3.endSearchAnimationWithoutAnimation();
        return;
    L12:
        return;
    }

    public void setCursorVisible(boolean isVisible) {
        this.mSearchEdit.setCursorVisible(isVisible);
    }

    public boolean isPlayingSearchAnimation() {
        return this.mSearchBarView.isPlayingAnimation();
    }

    public boolean isInSearchMode() {
        return this.mSearchBarView.isSearchMode();
    }

    private String getTitleStr(int titleRes) {
        Context r0 = this.mContext;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString(titleRes);
    }
}
