package com.android.settings.search;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.app.settings.search.EnablerObserverAndReceiverFactory;
import bytedanceos.app.settings.search.SearchResultItem;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SearchTextListener;
import com.android.settings.SettingsTracker;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.inputmethod.LanguageOption;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.settingitemsprovider.SearchEngine;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.MinorUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.ThreadUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.HorizontalScrollListView;
import com.android.settings.widget.SettingItemButton;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.olog.OLog;
import com.obric.oui.SearchAnimationHelper;
import com.obric.oui.forms.OEditText;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.api.schema.impl.bean.DocumentTokenPosition;
import com.obric.search.api.utils.DocumentsUtilKt;
import com.obric.settingcommon.EnablerFactory;
import com.obric.settingcommon.SettingsEnabler;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.FeedbackLauncher;

/* JADX INFO: loaded from: classes2.dex */
public class SearchFragment extends BaseFragment implements View.OnClickListener, EnablerObserverAndReceiverFactory.ContentChangeListenerExpand, SearchTextListener {
    public static final String CYPHER_COMPONENT = "com.android.settings/com.android.settings.MasterClearActivity";
    private static final int GET_HISTORY_DATA = 1;
    private static final int SEARCH_ID_ITEM_BASE = 1;
    public static final String SEARCH_KEY = "search_key";
    private static final int SEARCH_KEYWORDS_DELAY = 2;
    private static final int SEARCH_KEYWORDS_NOW = 3;
    private static final String TAG = "SettingsSearch";
    private boolean finished;
    private boolean isChinese;
    private boolean isFromRecreation;
    private View mCancelBtn;
    private String mCurrentSearchText;
    private Executor mDatabaseExecutor;
    private AlertDialog mDialog;
    private Handler mHandler;
    private View mHeader;
    private SearchResultAdapter mHistoryAdapter;
    private List<SearchResultItemWithIndex> mHistoryItemsWithItems;
    private View mHistoryLayout;
    private ListView mHistoryListview;
    private SearchResultAdapter mSearchAdapter;
    private TextView mSearchBackground;
    private OSearchBar mSearchBar;
    private int mSearchBarPaddingLeft;
    private View mSearchEmptyView;
    private SearchEngine mSearchEngine;
    private SearchHistoryImpl mSearchHistoryImpl;
    private ArrayList<SearchResultItemWithIndex> mSearchResultItemWithIndex;
    private HorizontalScrollListView mSearchResultListView;
    private View mSearchResultView;

    /* JADX INFO: renamed from: com.android.settings.search.SearchFragment$7, reason: invalid class name */
    class AnonymousClass7 implements Consumer<List<SearchResultItem>> {
        final /* synthetic */ SearchFragment this$0;

        AnonymousClass7(SearchFragment r1) {
            this.this$0 = r1;
        }

        @Override // com.android.settings.search.Consumer
        public /* bridge */ /* synthetic */ boolean consume(List<SearchResultItem> r1) {
            return consume2(r1);
        }

        /* JADX INFO: renamed from: consume, reason: avoid collision after fix types in other method */
        public boolean consume2(final List<SearchResultItem> r3) {
            if (r3 != null) goto L4;
            return true;
        L4:
            if (this.this$0.getActivity() == null) goto L9;
            this.this$0.getActivity().runOnUiThread(new SearchFragment$7$$ExternalSyntheticLambda0(this, r3));
            return true;
        L9:
            return true;
        }

        /* JADX INFO: renamed from: lambda$consume$0$com-android-settings-search-SearchFragment$7, reason: not valid java name */
        /* synthetic */ void m588lambda$consume$0$comandroidsettingssearchSearchFragment$7(List r6) {
            OLog.i(SearchFragment.TAG, "show search history list " + r6.size());
            SearchFragment.access$600(this.this$0).clear();
            Iterator r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            SearchFragment.access$600(this.this$0).add(new SearchResultItemWithIndex(this.this$0, (SearchResultItem) r7.next(), null));
            goto L4
        L6:
            SearchFragment.access$700(this.this$0).notifyDataSetChanged();
            View r8 = SearchFragment.access$800(this.this$0);
            if (TextUtils.isEmpty(SearchFragment.access$200(this.this$0)) == true) goto L9;
        L11:
            int r5 = 8;
        L12:
            r8.setVisibility(r5);
            return;
        L9:
            if (SearchFragment.access$600(this.this$0).isEmpty() == true) goto L11;
            r5 = 0;
            goto L12
        }
    }

    class SearchResultAdapter extends BaseAdapter {
        List<SearchResultItemWithIndex> mDataList;
        LayoutInflater mInflater;
        String mKeyWord;
        int mSmartSearchItemPosition;
        final /* synthetic */ SearchFragment this$0;

        class ViewHolder {
            OCardListItem item;
            OSectionTitleBar textView;
            OSectionTitleBar textViewWithGap;
            final /* synthetic */ SearchResultAdapter this$1;

            ViewHolder(SearchResultAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public SearchResultAdapter(SearchFragment r2, List<SearchResultItemWithIndex> r3) {
            this.this$0 = r2;
            this.mSmartSearchItemPosition = -1;
            this.mDataList = r3;
            this.mInflater = LayoutInflater.from(r2.mContext);
            setSmartSearchItemPosition(this.mDataList);
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            setSmartSearchItemPosition(this.mDataList);
        }

        private void setSmartSearchItemPosition(List<SearchResultItemWithIndex> r5) {
            this.mSmartSearchItemPosition = -1;
            int r1 = 0;
        L4:
            if (r1 >= r5.size()) goto L16;
            SearchResultItemWithIndex r2 = r5.get(r1);
            if (r2.mSearchResultItem.mId == 0) goto L11;
            if (r2.mSearchResultItem.mId == (-1)) goto L11;
            r1 = r1 + 1;
        L11:
            this.mSmartSearchItemPosition = r1;
            return;
        }

        public void setKeyWord(String r1) {
            this.mKeyWord = r1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r7) {
            int r0 = this.mSmartSearchItemPosition;
            if (r0 == (-1)) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == false) goto L30;
            if (r7 >= r0) goto L17;
            if (r0 != 1) goto L11;
            return 0;
        L11:
            if (r7 != 0) goto L14;
            return 1;
        L14:
            if (r7 != (r0 - 1)) goto L16;
            return 3;
        L16:
            return 2;
        L17:
            if (r7 <= r0) goto L28;
            int r2 = this.mDataList.size() - 1;
            int r3 = this.mSmartSearchItemPosition;
            if ((r2 - r3) != 1) goto L22;
            return 0;
        L22:
            if (r7 != (r3 + 1)) goto L25;
            return 1;
        L25:
            if (r7 != (this.mDataList.size() - 1)) goto L27;
            return 3;
        L27:
            return 2;
        L28:
            return 0;
        L30:
            if (this.mDataList.size() != 1) goto L32;
            return 0;
        L32:
            if (r7 != 0) goto L35;
            return 1;
        L35:
            if (r7 != (this.mDataList.size() - 1)) goto L37;
            return 3;
        L37:
            return 2;
        L5:
            r1 = false;
            goto L7
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mDataList.size();
        }

        @Override // android.widget.Adapter
        public SearchResultItemWithIndex getItem(int r1) {
            return this.mDataList.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            View r13 = this.mInflater.inflate(R.layout.search_result_layout, null);
            final ViewHolder r14 = new ViewHolder(this);
            r14.item = (OCardListItem) NullSafe.nonNull(r13.findViewById(R.id.item));
            r14.textView = (OSectionTitleBar) NullSafe.nonNull(r13.findViewById(R.id.title));
            r14.textViewWithGap = (OSectionTitleBar) NullSafe.nonNull(r13.findViewById(R.id.title_with_gap));
            r13.setTag(r14);
            r14.item.setCardPosition(getItemViewType(r10));
            if (r10 == 0) goto L5;
        L7:
            SearchResultItemWithIndex r2 = getItem(r10);
            SearchResultItem r3 = r2.mSearchResultItem;
            if (r3 == null) goto L36;
            String r4 = this.mKeyWord;
            if (r4 != null) goto L12;
        L14:
            r14.item.setTitle(r3.mText);
        L15:
            String r5 = "";
            if (TextUtils.isEmpty(r3.mPath1) == true) goto L18;
            String r6 = r3.mPath1;
        L19:
            StringBuilder r7 = new StringBuilder().append(r6);
            if (TextUtils.isEmpty(r3.mPath2) == true) goto L22;
            r5 = r3.mPath2;
        L22:
            String r8 = r7.append(r5).toString();
            r14.item.setSubTitle(r8);
            if (r3.mId != 0) goto L26;
            r14.item.setVisibility(8);
            r14.textView.setVisibility(0);
            r14.textViewWithGap.setVisibility(8);
        L30:
            if ("1".equals(r3.mIsSwitch) == false) goto L35;
            r14.item.setDefaultCustomEndView(1);
            r14.item.showCustomEnd(true);
            r14.item.showTailIcon(false);
            r14.item.setOnContentClickListener(null);
            if (r14.item.getEndSwitch() == null) goto L34;
            r14.item.getEndSwitch().setChangeAlphaWhenDisable(true);
        L34:
            EnablerFactory.createSettingsEnabler(this.this$0.mContext, (OSwitch) r14.item.getCustomEndView(), r3, false);
            goto L36
        L35:
            r14.item.setId(r10 + 1);
            r14.item.showCustomEnd(false);
            r14.item.showTailIcon(true);
            r14.item.setOnContentClickListener(new AnonymousClass1(this, r14));
            goto L36
        L26:
            if (r3.mId != (-1)) goto L28;
            r14.item.setVisibility(8);
            r14.textView.setVisibility(8);
            r14.textViewWithGap.setVisibility(0);
            goto L30
        L28:
            r14.item.setVisibility(0);
            r14.textView.setVisibility(8);
            r14.textViewWithGap.setVisibility(8);
            goto L30
        L18:
            r6 = "";
            goto L19
        L12:
            if (r4.isEmpty() == true) goto L14;
            SpannableStringBuilder r9 = SearchFragment.access$1000(this.this$0, r3.mText, this.mKeyWord, r2.mDocumentTokenPosition, ResourceUtils.getResources().getColor(R.color.oui_functional_blue_6, null));
            r14.item.setTitle(r9);
        L36:
            return r13;
        L5:
            if (SearchFragment.access$900(this.this$0).isEmpty() == true) goto L7;
            r13.setPadding(0, this.this$0.getResources().getDimensionPixelSize(R.dimen.main_settings_first_item_card_gap), 0, 0);
            goto L7
        }
    }

    class SearchResultItemWithIndex {
        DocumentTokenPosition mDocumentTokenPosition;
        SearchResultItem mSearchResultItem;
        final /* synthetic */ SearchFragment this$0;

        SearchResultItemWithIndex(SearchFragment r1, SearchResultItem r2, DocumentTokenPosition r3) {
            this.this$0 = r1;
            this.mSearchResultItem = r2;
            this.mDocumentTokenPosition = r3;
        }
    }

    private class SearchTask extends AsyncTask<String, Void, ArrayList<SearchResultItemWithIndex>> {
        String keyword;
        long mainResultSize;
        long suggestResultSize;
        final /* synthetic */ SearchFragment this$0;
        long timestamp;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ ArrayList<SearchResultItemWithIndex> doInBackground(String[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(ArrayList<SearchResultItemWithIndex> r1) {
            onPostExecute2(r1);
        }

        SearchTask(SearchFragment r3, long r4) {
            this.this$0 = r3;
            this.keyword = "";
            this.mainResultSize = 0;
            this.suggestResultSize = 0;
            this.timestamp = r4;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected ArrayList<SearchResultItemWithIndex> doInBackground2(String... r40) {
            String r0 = r40[0];
            if (r0 != null) goto L5;
        L14:
            List<DocumentTokenPosition> r1 = null;
            List<DocumentTokenPosition> r6 = null;
        L15:
            ArrayList<SearchResultItemWithIndex> r7 = new ArrayList();
            ArrayList r8 = new ArrayList();
            ArrayList r9 = new ArrayList();
            if (r6 == null) goto L22;
            Iterator<DocumentTokenPosition> r10 = r6.iterator();
        L19:
            if (r10.hasNext() == false) goto L21;
            DocumentTokenPosition r11 = r10.next();
            r8.add(Long.valueOf(r11.getId()));
            r9.add(Long.valueOf(r11.getId()));
            goto L19
        L21:
            this.mainResultSize = r9.size();
        L22:
            if (r1 == null) goto L31;
            Iterator<DocumentTokenPosition> r12 = r1.iterator();
        L25:
            if (r12.hasNext() == false) goto L29;
            DocumentTokenPosition r13 = r12.next();
            if (r8.contains(Long.valueOf(r13.getId())) == true) goto L25;
            r8.add(Long.valueOf(r13.getId()));
            goto L25
        L29:
            this.suggestResultSize = ((long) r8.size()) - this.mainResultSize;
        L31:
            if (r8.isEmpty() == false) goto L33;
            return r7;
        L33:
            String r14 = "_id IN (" + TextUtils.join(",", r8) + ")";
            Uri r15 = Uri.parse("content://com.android.settings.SearchSuggestionProvider/search_suggest_settings?limit=50");
            this.keyword = r40[0];     // Catch: Throwable -> L110 Exception -> L112
            Cursor r16 = this.this$0.getContentResolver().query(r15, null, r14, null, null);     // Catch: Throwable -> L110 Exception -> L112
            if (r16 != null) goto L151;
        L105:
            String r17 = "exception when close";
            String r18 = SearchFragment.TAG;
            ArrayList<SearchResultItemWithIndex> r19 = r7;
        L106:
            if (r16 != null) goto L139;
        L118:
            return r19;
        L139:
            r16.close();     // Catch: Exception -> L109
        L109:
            String r2 = r17;
            String r3 = r18;
        L117:
            OLog.d(r3, r2);
            goto L118
        L151:
        L104:
            r19 = r7;
            r2 = "exception when close";
            r3 = SearchFragment.TAG;
            Cursor r5 = r16;
        L143:
            OLog.d(r3, "exception when query keyword");     // Catch: Throwable -> L119
            if (r5 == null) goto L118;
            r5.close();     // Catch: Exception -> L126
        L119:
            th = th;
        L120:
            if (r5 != null) goto L133;
        L124:
            throw th;
        L133:
            r5.close();     // Catch: Exception -> L123
        L123:
            OLog.d(r3, r2);
        L102:
            th = th;
            r2 = "exception when close";
            r3 = SearchFragment.TAG;
            r5 = r16;
            goto L120
        L37:
            if (r16.getCount() <= 0) goto L105;
            OLog.d(SearchFragment.TAG, "count is " + r16.getCount());     // Catch: Throwable -> L102 Exception -> L104
            int r110 = r16.getColumnIndex("suggest_intent_data");     // Catch: Throwable -> L102 Exception -> L104
            int r111 = r16.getColumnIndex("suggest_text_1");     // Catch: Throwable -> L102 Exception -> L104
            int r112 = r16.getColumnIndex("suggest_shortcut_id");     // Catch: Throwable -> L102 Exception -> L104
            int r113 = r16.getColumnIndex("is_switch");     // Catch: Throwable -> L102 Exception -> L104
            int r114 = r16.getColumnIndex("switch_table");     // Catch: Throwable -> L102 Exception -> L104
            int r115 = r16.getColumnIndex("switch_key");     // Catch: Throwable -> L102 Exception -> L104
            int r4 = r16.getColumnIndex("special_key");     // Catch: Throwable -> L102 Exception -> L104
            int r20 = r16.getColumnIndex("def_value");     // Catch: Throwable -> L102 Exception -> L104
            r17 = "exception when close";
            int r21 = r16.getColumnIndex(DatabaseHelper.ItemsRecord.ICON_ID);     // Catch: Throwable -> L99 Exception -> L101
            r18 = SearchFragment.TAG;
            int r22 = r16.getColumnIndex(DatabaseHelper.ItemsRecord.ITEM_PATH_1);     // Catch: Throwable -> L95 Exception -> L97
            List<DocumentTokenPosition> r116 = r1;
            int r23 = r16.getColumnIndex(DatabaseHelper.ItemsRecord.ITEM_PATH_2);     // Catch: Throwable -> L95 Exception -> L97
            ArrayList<SearchResultItemWithIndex> r117 = r7;
            ArrayList r41 = new ArrayList();     // Catch: Exception -> L94 Throwable -> L95
            ArrayList r24 = new ArrayList();     // Catch: Exception -> L94 Throwable -> L95
            int r25 = 1;
        L46:
            if (r16.moveToNext() == false) goto L62;
            String r26 = r16.getString(r110);     // Catch: Exception -> L61 Throwable -> L95
            String r27 = r16.getString(r111);     // Catch: Exception -> L61 Throwable -> L95
            String r28 = r16.getString(r112);     // Catch: Exception -> L61 Throwable -> L95
            String r29 = r16.getString(r113);     // Catch: Exception -> L61 Throwable -> L95
            String r210 = r16.getString(r114);     // Catch: Exception -> L61 Throwable -> L95
            String r211 = r16.getString(r115);     // Catch: Exception -> L61 Throwable -> L95
            String r212 = r16.getString(r4);     // Catch: Exception -> L61 Throwable -> L95
            String r30 = r16.getString(r20);     // Catch: Exception -> L61 Throwable -> L95
            int r31 = r16.getInt(r21);     // Catch: Exception -> L61 Throwable -> L95
            String r32 = r16.getString(r22);     // Catch: Exception -> L61 Throwable -> L95
            String r33 = r16.getString(r23);     // Catch: Exception -> L61 Throwable -> L95
            int r34 = r23;
            if (r9.contains(Long.valueOf(Long.parseLong(r28))) == false) goto L59;
            if (r6 == null) goto L57;
            Iterator<DocumentTokenPosition> r35 = r6.iterator();     // Catch: Exception -> L61 Throwable -> L95
        L52:
            if (r35.hasNext() == false) goto L57;
            DocumentTokenPosition r213 = r35.next();     // Catch: Exception -> L61 Throwable -> L95
            Iterator<DocumentTokenPosition> r214 = r35;
            int r38 = r21;
            int r37 = r4;
            if (r213.getId() == Integer.parseInt(r28)) goto L55;
            r35 = r214;
            r4 = r37;
            r21 = r38;
            goto L52
        L55:
            DocumentTokenPosition r36 = r213;
        L58:
            SearchResultItemWithIndex r39 = new SearchResultItemWithIndex(this.this$0, new SearchResultItem(r25, r26, r27, r28, r29, r210, r211, r212, r30, r31, r32, r33), r36);     // Catch: Exception -> L61 Throwable -> L95
            ArrayList r42 = r41;
            r42.add(r39);     // Catch: Exception -> L61 Throwable -> L95
        L60:
            r25 = r25 + 1;
            r20 = r20;
            r41 = r42;
            r23 = r34;
            r22 = r22;
            r4 = r37;
            r21 = r38;
        L57:
            r38 = r21;
            r37 = r4;
            r36 = null;
            goto L58
        L59:
            r42 = r41;
            r38 = r21;
            r37 = r4;
            r24.add(new SearchResultItemWithIndex(this.this$0, new SearchResultItem(r25, r26, r27, r28, r29, r210, r211, r212, r30, r31, r32, r33), null));     // Catch: Exception -> L61 Throwable -> L95
        L61:
            r5 = r16;
            r2 = r17;
            r3 = r18;
            r19 = r117;
            goto L143
        L62:
            ArrayList r43 = r41;
            if (r6 == null) goto L76;
            Iterator<DocumentTokenPosition> r44 = r6.iterator();     // Catch: Exception -> L94 Throwable -> L95
        L66:
            if (r44.hasNext() == false) goto L76;
            DocumentTokenPosition r45 = r44.next();     // Catch: Exception -> L94 Throwable -> L95
            Iterator r46 = r43.iterator();     // Catch: Exception -> L94 Throwable -> L95
        L69:
            if (r46.hasNext() == false) goto L74;
            SearchResultItemWithIndex r47 = (SearchResultItemWithIndex) r46.next();     // Catch: Exception -> L94 Throwable -> L95
            if (r47.mSearchResultItem.mShortcutId.equals(String.valueOf(r45.getId())) == false) goto L69;
            r19 = r117;
            r19.add(r47);     // Catch: Throwable -> L95 Exception -> L125
        L75:
            r117 = r19;
        L98:
            r5 = r16;
            r2 = r17;
            r3 = r18;
            goto L143
        L74:
            r19 = r117;
        L76:
            r19 = r117;
            if (r24.isEmpty() == true) goto L83;
            SearchFragment r48 = this.this$0;     // Catch: Throwable -> L95 Exception -> L125
            if (r19.isEmpty() == false) goto L81;
            int r215 = 0;
        L82:
            r19.add(new SearchResultItemWithIndex(r48, new SearchResultItem(r215, "", "", "", "1", "", "", "placeholder", "", 0, "", ""), null));     // Catch: Throwable -> L95 Exception -> L125
            goto L83
        L81:
            r215 = -1;
        L83:
            if (r116 == null) goto L106;
            Iterator<DocumentTokenPosition> r49 = r116.iterator();     // Catch: Throwable -> L95 Exception -> L125
        L85:
            if (r49.hasNext() == false) goto L106;
            DocumentTokenPosition r50 = r49.next();     // Catch: Throwable -> L95 Exception -> L125
            Iterator r51 = r24.iterator();     // Catch: Throwable -> L95 Exception -> L125
        L89:
            if (r51.hasNext() == false) goto L85;
            SearchResultItemWithIndex r52 = (SearchResultItemWithIndex) r51.next();     // Catch: Throwable -> L95 Exception -> L125
            if (r52.mSearchResultItem.mShortcutId.equals(String.valueOf(r50.getId())) == false) goto L89;
            r19.add(r52);     // Catch: Throwable -> L95 Exception -> L125
            goto L85
        L94:
            r19 = r117;
        L95:
            th = th;
            r5 = r16;
            r2 = r17;
            r3 = r18;
        L97:
            r19 = r7;
            goto L98
        L101:
            r19 = r7;
            r3 = SearchFragment.TAG;
            r5 = r16;
            r2 = r17;
        L99:
            th = th;
            r3 = SearchFragment.TAG;
            r5 = r16;
            r2 = r17;
            goto L120
        L112:
            r2 = "exception when close";
            r3 = SearchFragment.TAG;
            r19 = r7;
            r5 = null;
        L110:
            th = th;
            r2 = "exception when close";
            r3 = SearchFragment.TAG;
            r5 = null;
            goto L120
        L5:
            if (r0.isEmpty() == true) goto L14;
            SearchFragment r53 = this.this$0;     // Catch: Exception -> L11
            SearchFragment.access$1302(r53, SearchEngine.getInstance(r53.mContext));     // Catch: Exception -> L11
            r6 = SearchFragment.access$1300(this.this$0).search(r40[0]);     // Catch: Exception -> L11
            r1 = SearchFragment.access$1300(this.this$0).smartSearch(r40[0]);     // Catch: Exception -> L9
        L9:
            e = e;
        L13:
            OLog.d(SearchFragment.TAG, "search error " + e.getMessage());
            r1 = null;
        L11:
            e = e;
            r6 = null;
            goto L13
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(ArrayList<SearchResultItemWithIndex> r6) {
            ArrayList r0 = new ArrayList();
            Iterator<SearchResultItemWithIndex> r1 = r6.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            SearchResultItemWithIndex r2 = r1.next();
            if (MinorUtils.INSTANCE.getMinorsModeState(this.this$0.mContext) == true) goto L4;
            r0.add(r2.mSearchResultItem);
            goto L4
        L9:
            int r3 = 0;
            if (this.this$0.getView() != null) goto L12;
        L17:
            String r7 = this.keyword;
            if (r7 == null) goto L20;
            r3 = r7.length();
        L20:
            AppMetricsUtils.INSTANCE.durationEventEnd("search", this.timestamp, r3);
            HashMap r8 = new HashMap();
            r8.put("search_word_length", Integer.valueOf(r3));
            r8.put("duration", Long.valueOf(AppMetricsUtils.INSTANCE.getNanoTimeMillis() - this.timestamp));
            r8.put("result_length", Long.valueOf(this.mainResultSize));
            r8.put("suggestion_length", Long.valueOf(this.suggestResultSize));
            TrackerEvent.uploadEvent("settings_search_page_search_result", r8);
            return;
        L12:
            if (SearchFragment.access$1400(this.this$0) == null) goto L17;
            SearchFragment.access$900(this.this$0).clear();
            SearchFragment.access$900(this.this$0).addAll(r6);
            EnablerObserverAndReceiverFactory.getInstance().setContentChangeListener(this.this$0);
            EnablerObserverAndReceiverFactory.getInstance().registerObserverAndReceiver(this.this$0.mContext, r0);
            SearchFragment.access$1400(this.this$0).setKeyWord(this.keyword);
            SearchFragment.access$1400(this.this$0).notifyDataSetChanged();
            if (SearchFragment.access$900(this.this$0).isEmpty() == false) goto L16;
            SearchFragment.access$1600(this.this$0).setEmptyView(SearchFragment.access$1500(this.this$0));
            SearchFragment.access$1500(this.this$0).setVisibility(0);
            goto L17
        L16:
            SearchFragment.access$1600(this.this$0).setEmptyView(null);
            SearchFragment.access$1500(this.this$0).setVisibility(8);
            goto L17
        }
    }

    public static /* synthetic */ void $r8$lambda$I8l4yTcESsmx9DY1BT67CGX0Z6E(SearchFragment r0) {
        r0.searchExistingKeywords();
    }

    private boolean checkFirstCharacter(char r1) {
        if (r1 < 'a') goto L7;
        if (r1 > 'z') goto L7;
    L14:
        return true;
    L7:
        if (r1 < 'A') goto L11;
        if (r1 <= 'Z') goto L14;
    L11:
        if (r1 >= '0') goto L13;
    L15:
        return false;
    L13:
        if (r1 > '9') goto L15;
        goto L14
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_search_SearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_search_SearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SearchFragment() {
        this.mSearchResultItemWithIndex = new ArrayList();
        this.mHistoryItemsWithItems = new ArrayList();
        this.finished = false;
        this.isChinese = false;
        this.mHandler = new Handler(new AnonymousClass1(this));
        this.mDatabaseExecutor = Executors.newSingleThreadExecutor();
    }

    static /* synthetic */ Handler access$000(SearchFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$100(SearchFragment r0) {
        r0.searchExistingKeywords();
    }

    static /* synthetic */ SpannableStringBuilder access$1000(SearchFragment r0, String r1, String r2, DocumentTokenPosition r3, int r4) {
        return r0.getHighlightText(r1, r2, r3, r4);
    }

    static /* synthetic */ boolean access$1100(SearchFragment r0) {
        return r0.isHistoryClicked();
    }

    static /* synthetic */ void access$1200(SearchFragment r0, boolean r1, int r2) {
        r0.handleSearchResult(r1, r2);
    }

    static /* synthetic */ SearchEngine access$1300(SearchFragment r0) {
        return r0.mSearchEngine;
    }

    static /* synthetic */ SearchEngine access$1302(SearchFragment r0, SearchEngine r1) {
        r0.mSearchEngine = r1;
        return r1;
    }

    static /* synthetic */ SearchResultAdapter access$1400(SearchFragment r0) {
        return r0.mSearchAdapter;
    }

    static /* synthetic */ View access$1500(SearchFragment r0) {
        return r0.mSearchEmptyView;
    }

    static /* synthetic */ HorizontalScrollListView access$1600(SearchFragment r0) {
        return r0.mSearchResultListView;
    }

    static /* synthetic */ String access$200(SearchFragment r0) {
        return r0.mCurrentSearchText;
    }

    static /* synthetic */ String access$202(SearchFragment r0, String r1) {
        r0.mCurrentSearchText = r1;
        return r1;
    }

    static /* synthetic */ void access$300(SearchFragment r0, String r1) {
        r0.search(r1);
    }

    static /* synthetic */ void access$400(SearchFragment r0) {
        r0.clearCurrentFocus();
    }

    static /* synthetic */ SearchHistoryImpl access$500(SearchFragment r0) {
        return r0.mSearchHistoryImpl;
    }

    static /* synthetic */ List access$600(SearchFragment r0) {
        return r0.mHistoryItemsWithItems;
    }

    static /* synthetic */ SearchResultAdapter access$700(SearchFragment r0) {
        return r0.mHistoryAdapter;
    }

    static /* synthetic */ View access$800(SearchFragment r0) {
        return r0.mHistoryLayout;
    }

    static /* synthetic */ ArrayList access$900(SearchFragment r0) {
        return r0.mSearchResultItemWithIndex;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r3) {
        OLog.d(TAG, "onAttach");
        super.onAttach(r3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        OLog.d(TAG, "onActivityCreated");
        super.onActivityCreated(r3);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        this.isChinese = LanguageOption.isChinese();
        this.mRootView = r5.inflate(R.layout.settings_search_layout, r6, false);
        View r8 = findViewByIdNullable(R.id.seachresultview);
        this.mSearchResultView = r8;
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(r8);
        this.mSearchResultView.setAlpha(1.0f);
        this.mSearchBarPaddingLeft = getResources().getDimensionPixelSize(R.dimen.search_title_bar_right_margin);
        OSearchBar r9 = (OSearchBar) findViewByIdNullable(R.id.id_search_bar);
        this.mSearchBar = r9;
        r9.getInputView().setHint(getString(R.string.search_in_settings));
        View r10 = findViewByIdNullable(R.id.search_cancel_button);
        this.mCancelBtn = r10;
        r10.setOnClickListener(this);
        if (r7 != null) goto L5;
        this.mCancelBtn.setAlpha(0.0f);
        this.mSearchBar.setAlpha(0.0f);
    L5:
        this.mSearchBar.getInputView().addTextChangedListener(new AnonymousClass2(this));
        HorizontalScrollListView r11 = (HorizontalScrollListView) findViewByIdNullable(R.id.search_listview);
        this.mSearchResultListView = r11;
        r11.setScrollEnabled(false);
        SearchResultAdapter r12 = new SearchResultAdapter(this, this.mSearchResultItemWithIndex);
        this.mSearchAdapter = r12;
        this.mSearchResultListView.setAdapter(r12);
        this.mSearchEmptyView = findViewByIdNullable(R.id.empty_view);
        ((OTextView) findViewByIdNullable(R.id.search_empty_view)).setText(R.string.settingitem_search_no_result);
        TextView r13 = (TextView) findViewByIdNullable(R.id.searchview_bg);
        this.mSearchBackground = r13;
        r13.setVisibility(8);
        this.mSearchResultListView.setOnScrollListener(new AnonymousClass3(this));
        this.mHistoryLayout = findViewByIdNullable(R.id.history_layout);
        View r14 = LayoutInflater.from(this.mContext).inflate(R.layout.search_history_header, null);
        this.mHeader = r14;
        OSectionTitleBar r15 = (OSectionTitleBar) r14.findViewById(R.id.search_history);
        r15.setCustomEndView(LayoutInflater.from(this.mContext).inflate(R.layout.search_history_header_icon, null));
        r15.showCustomEnd(true);
        if (r15.getCustomEndView() == null) goto L8;
        r15.getCustomEndView().setOnClickListener(new AnonymousClass4(this));
    L8:
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mHistoryLayout);
        this.mHistoryAdapter = new SearchResultAdapter(this, this.mHistoryItemsWithItems);
        ListView r16 = (ListView) findViewByIdNullable(R.id.search_history_view);
        this.mHistoryListview = r16;
        r16.addHeaderView(this.mHeader);
        this.mHistoryListview.setAdapter(this.mHistoryAdapter);
        this.mHistoryListview.setOnScrollListener(new AnonymousClass5(this));
        if (this.mHistoryItemsWithItems.isEmpty() == false) goto L12;
        this.mHistoryLayout.setVisibility(8);
    L12:
        if (r7 == null) goto L15;
        this.mCurrentSearchText = r7.getString(SEARCH_KEY);
    L15:
        if (TextUtils.isEmpty(this.mCurrentSearchText) == false) goto L20;
        Bundle r17 = getArguments();
        String r0 = r17.getString(SEARCH_KEY);
        this.mCurrentSearchText = r0;
        if (TextUtils.isEmpty(r0) == true) goto L20;
        requireActivity().getIntent().removeExtra(SEARCH_KEY);
        r17.remove(SEARCH_KEY);
    L20:
        if (TextUtils.isEmpty(this.mCurrentSearchText) == true) goto L23;
        OEditText r18 = this.mSearchBar.getInputView();
        r18.setText(this.mCurrentSearchText);
        r18.setSelection(this.mCurrentSearchText.length());
    L23:
        if (this.mIsLandScreen == true) goto L25;
    L27:
        checkoutSearchIndex();
        this.mSearchEngine = SearchEngine.getInstance(this.mContext);
        return this.mRootView;
    L25:
        if (this.mIsExtDisplaying == false) goto L27;
        this.mSearchBar.setVisibility(8);
        this.mSearchBar.setFocusable(false);
        goto L27
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r6, Bundle r7) {
        super.onViewCreated(r6, r7);
        new SearchAnimationHelper().playSearchBoxEnter(this.mSearchBar, this.mSearchBarPaddingLeft, this.mCancelBtn, Arrays.asList(new View[]{this.mSearchResultView, this.mHistoryLayout}));
        this.mSearchBar.getInputView().requestFocus();
        showSoftInput(this.mSearchBar.getInputView());
    }

    private void clearCurrentFocus() {
        if (getActivity() == null) goto L5;
        View r1 = getActivity().getCurrentFocus();
    L6:
        if (r1 == null) goto L9;
        r1.clearFocus();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private View createListViewFooter() {
        if (this.mIsLandScreen == false) goto L9;
        if (this.mIsExtDisplaying == false) goto L9;
        View r0 = LayoutInflater.from(this.mContext).inflate(R.layout.search_history_footer, null);
        SettingItemButton r1 = (SettingItemButton) NullSafe.nonNull(r0.findViewById(R.id.setting_item_btn_clear_history));
        r1.setBackgroundStyle(1);
        r1.setOnClickListener(this);
        return r0;
    L9:
        return createListViewShadowFooter();
    }

    private View createListViewShadowFooter() {
        ImageView r0 = new ImageView(this.mContext);
        r0.setImportantForAccessibility(2);
        r0.setBackgroundResource(R.drawable.list_item_bg_shadow);
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putString(SEARCH_KEY, this.mCurrentSearchText);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        EnablerObserverAndReceiverFactory.getInstance().clearObserverAndReceivers(this.mContext);
    }

    public void com_android_settings_search_SearchFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        if (r2 == null) goto L5;
        boolean r3 = true;
    L6:
        this.isFromRecreation = r3;
        this.mSearchHistoryImpl = new SearchHistoryImpl(this.mContext);
        ThreadUtils.postOnBackgroundThread(new AnonymousClass6(this));
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCurrentSearchText = "";
        this.mHandler.removeCallbacksAndMessages(null);
        EnablerObserverAndReceiverFactory.getInstance().setContentChangeListener(null);
        SearchEngine.unloadSegmentationDict();
        SettingsEnabler.setConfirm(false);
    }

    public void com_android_settings_search_SearchFragment__onResume$___twin___() {
        super.onResume();
        Runnable r0 = new SearchFragment$$ExternalSyntheticLambda1(this);
        if (this.isFromRecreation == true) goto L5;
    L7:
        r0.run();
        return;
    L5:
        if (getView() == null) goto L7;
        getView().postDelayed(r0, 200);
    }

    /* JADX INFO: renamed from: lambda$onResume$0$com-android-settings-search-SearchFragment, reason: not valid java name */
    /* synthetic */ void m586lambda$onResume$0$comandroidsettingssearchSearchFragment() {
        if (TextUtils.isEmpty(this.mCurrentSearchText) == false) goto L5;
        updateIntelligentSettingItems(new SearchFragment$$ExternalSyntheticLambda0(this));
        return;
    L5:
        searchExistingKeywords();
        updateIntelligentSettingItems(null);
    }

    private void updateIntelligentSettingItems(final Runnable r3) {
        this.mDatabaseExecutor.execute(new SearchFragment$$ExternalSyntheticLambda4(this, r3));
    }

    /* JADX INFO: renamed from: lambda$updateIntelligentSettingItems$1$com-android-settings-search-SearchFragment, reason: not valid java name */
    /* synthetic */ void m587xdc709393(Runnable r1) {
        DatabaseHelper r0 = DatabaseHelper.getInstance(this.mContext);
        r0.ensureSearchDataReadyForQuery();
        r0.handleAccountLoginStateChanged();
        r0.handleDashBoardStateChanged();
        if (r1 == null) goto L6;
        ThreadUtils.getUiThreadHandler().post(r1);
        return;
    }

    private void checkoutSearchIndex() {
        this.mDatabaseExecutor.execute(new SearchFragment$$ExternalSyntheticLambda3(this));
    }

    /* JADX INFO: renamed from: lambda$checkoutSearchIndex$2$com-android-settings-search-SearchFragment, reason: not valid java name */
    /* synthetic */ void m585x573bc86c() {
        if (DatabaseHelper.getInstance(this.mContext).isSearchIndexCreated() == true) goto L9;
        OLog.d(TAG, "checkoutSearchIndex: rebuild search index");
        if (SearchEngine.isSearchEngineInit() == false) goto L7;
        DatabaseHelper.getInstance(this.mContext).createSearchIndex();
        return;
    L7:
        DatabaseHelper.getInstance(this.mContext).createSearchIndexWaitInitFinish();
        return;
    }

    private void searchExistingKeywords() {
        search(this.mCurrentSearchText);
    }

    private void showSearchHistory() {
        this.mSearchHistoryImpl.getAllItems(new AnonymousClass7(this));
    }

    @Override // com.android.settings.SearchTextListener
    public void searchText(String r1) {
        this.mCurrentSearchText = r1;
        search(r1);
    }

    public void onContentChange() {
        SearchResultAdapter r0 = this.mSearchAdapter;
        if (r0 == null) goto L6;
        r0.notifyDataSetChanged();
        return;
    }

    public void onContentChange(boolean r1, Uri r2) {
        if (needResearch(r2) == false) goto L6;
        this.mHandler.sendEmptyMessage(2);
        return;
    }

    private int getIndexOfKeyword(String r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return -1;
    L5:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return -1;
    L8:
        return r1.toLowerCase().indexOf(r2.toLowerCase());
    }

    private SpannableStringBuilder getHighlightText(String r3, String r4, int r5) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r3);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r0;
    L5:
        int r2 = getIndexOfKeyword(r3, r4);
        int r6 = r4.length() + r2;
        if (r2 >= 0) goto L8;
        return r0;
    L8:
        r0.setSpan(new ForegroundColorSpan(r5), r2, r6, 33);
        return r0;
    }

    private SpannableStringBuilder getHighlightText(String r9, String r10, DocumentTokenPosition r11, int r12) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r9);
        if (r11 == null) goto L50;
        if (r9 == null) goto L50;
        if (r9.isEmpty() == true) goto L50;
        if (r10 == null) goto L50;
        if (r10.isEmpty() == true) goto L50;
        if (r11.getColumnsTokenPosition().isEmpty() == false) goto L14;
        return r0;
    L14:
        Iterator<Pair<Integer, Integer>> r13 = DocumentsUtilKt.getOTokenizerColumnHighlightPosition(0, r9, r11, FullTextSearchSchema.TOKENIZER.O_TOKENIZER_1).iterator();
    L16:
        if (r13.hasNext() == false) goto L50;
        Pair<Integer, Integer> r1 = r13.next();
        OLog.d(TAG, r9 + " new Highlight pair = " + r1.getFirst() + HanziToPinyin.Token.SEPARATOR + r1.getSecond());
        int r2 = r1.getFirst().intValue();
        int r3 = ((r1.getSecond().intValue() - r1.getFirst().intValue()) + 1) + r2;
        if (r3 >= 1) goto L20;
    L41:
        if (r2 < 0) goto L16;
        if (r2 > r9.length()) goto L16;
        if (r3 < 0) goto L16;
        if (r3 > r9.length()) goto L16;
        if (r2 > r3) goto L16;
        r0.setSpan(new ForegroundColorSpan(r12), r2, r3, 33);
        goto L16
    L20:
        if (r3 > r9.length()) goto L41;
        int r4 = r3 - 1;
        if (checkFirstCharacter(r9.charAt(r4)) == false) goto L41;
    L23:
        if (r4 < r2) goto L41;
        char r5 = r9.charAt(r4);
        if (r5 < 'a') goto L29;
        if (r5 > 'z') goto L29;
    L32:
        char r6 = Character.toUpperCase(r5);
        char r7 = Character.toLowerCase(r5);
        if (r6 == r10.charAt(r10.length() - 1)) goto L39;
        if (r7 == r10.charAt(r10.length() - 1)) goto L39;
    L40:
        r4 = r4 - 1;
    L39:
        r3 = r4 + 1;
    L29:
        if (r5 < 'A') goto L38;
        if (r5 <= 'Z') goto L32;
    L38:
        if (r5 != r10.charAt(r10.length() - 1)) goto L40;
    L50:
        return r0;
    }

    private boolean isContainsLatterOrDigit(String r4) {
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L10;
        if (checkFirstCharacter(r4.charAt(r1)) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private String getConverted(String r8) {
        StringBuilder r0 = new StringBuilder();
        boolean r4 = true;
        int r3 = 0;
    L4:
        if (r3 >= r8.length()) goto L12;
        char r5 = r8.charAt(r3);
        if (checkFirstCharacter(r5) == false) goto L9;
        if (r4 == false) goto L10;
        r0.append(r5);
        r4 = false;
    L10:
        r3 = r3 + 1;
        goto L4
    L9:
        r0.append(r5);
        r4 = true;
        goto L10
    L12:
        return r0.toString();
    }

    private int getStartIndex(int r8, String r9, String r10) {
        int r2 = 0;
        int r3 = 0;
        boolean r4 = true;
    L4:
        if (r2 >= r10.length()) goto L19;
        char r5 = r10.charAt(r2);
        if (checkFirstCharacter(r5) == false) goto L13;
        if (r4 == false) goto L18;
        if (r8 == r3) goto L10;
    L12:
        r3 = r3 + 1;
        r4 = false;
        goto L18
    L10:
        if (r5 != r9.charAt(r8)) goto L12;
        return r2;
    L18:
        r2 = r2 + 1;
        goto L4
    L13:
        if (r8 == r3) goto L15;
    L17:
        r3 = r3 + 1;
        r4 = true;
        goto L18
    L15:
        if (r5 != r9.charAt(r8)) goto L17;
        return r2;
    L19:
        return 0;
    }

    private void handleSearchResult(boolean r11, int r12) {
        if (r11 == true) goto L11;
        ArrayList<SearchResultItemWithIndex> r13 = this.mSearchResultItemWithIndex;
        if (r13 != null) goto L7;
        return;
    L7:
        if (r13.isEmpty() == true) goto L75;
        SearchResultItem r14 = this.mSearchResultItemWithIndex.get(r12 - 1).mSearchResultItem;
    L18:
        if ("1".equals(r14.mIsSwitch) == true) goto L77;
        String r15 = r14.mIntent;
        String r3 = null;
        if (r15.contains("intent=") == true) goto L67;
    L27:
        Intent r16 = null;
    L28:
        if (r16 != null) goto L60;
        r16 = new Intent("android.intent.action.MAIN");
        r16.setData(Uri.parse(r14.mIntent));
        List<String> r1 = Uri.parse(r14.mIntent).getPathSegments();
        if (r1.size() <= 2) goto L33;
        r16.setComponent(new ComponentName(r1.get(1), r1.get(2)));
    L33:
        if (r1.size() <= 3) goto L35;
        r3 = r1.get(3);
    L35:
        if (r3 == null) goto L60;
        OLog.i(TAG, "extra : " + r3);
        String[] r2 = r3.split("\\|");
        int r4 = r2.length;
        int r5 = 0;
    L37:
        if (r5 >= r4) goto L60;
        String[] r6 = r2[r5].split("=");
        String r7 = r6[0];
        String r8 = r6[1];
        if (r8.startsWith("[") == false) goto L47;
        if (r8.endsWith("]") == false) goto L47;
        String[] r9 = r8.substring(1, r8.length() - 1).split(",");
        r16.putExtra(r7, r9);
        int r10 = 0;
    L44:
        if (r10 >= r9.length) goto L59;
        OLog.d(TAG, "value = " + r9[r10]);
        r10 = r10 + 1;
    L59:
        r5 = r5 + 1;
    L47:
        if ("view_id".equals(r7) == false) goto L50;
        r16.putExtra(r7, r8);
        goto L59
    L50:
        if (TextUtils.isDigitsOnly(r8) == false) goto L53;
        r16.putExtra(r7, Integer.valueOf(r8).intValue());
        goto L59
    L53:
        if ("true".equals(r8) == false) goto L55;
    L58:
        r16.putExtra(r7, Boolean.valueOf(r8));
        goto L59
    L55:
        if ("false".equals(r8) == true) goto L58;
        r16.putExtra(r7, r8);
    L60:
        hideInputMethod();
        launchIntent(r16);
        this.mSearchHistoryImpl.addItem(r14);
        HashMap r17 = new HashMap();
        if (r16 != null) goto L63;
    L65:
        r17.put("prev_page_name", SearchFragment.class.getName());
        TrackerEvent.uploadEvent("page_show", r17);
        return;
    L63:
        if (r16.getComponent() == null) goto L65;
        r17.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r16.getComponent().getClassName());
        goto L65
    L67:
        r16 = Intent.parseUri(r15.substring(r15.indexOf("intent=") + 7), 0);     // Catch: URISyntaxException -> L23 IndexOutOfBoundsException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L27
    L77:
        return;
    L75:
        return;
    L11:
        List<SearchResultItemWithIndex> r18 = this.mHistoryItemsWithItems;
        if (r18 != null) goto L14;
        return;
    L14:
        if (r18.isEmpty() == true) goto L78;
        r14 = this.mHistoryItemsWithItems.get(r12 - 1).mSearchResultItem;
        goto L18
    }

    protected void launchIntent(Intent r6) {
        OLog.d(TAG, "launchIntent " + r6);
        if (r6 != null) goto L6;
        return;
    L6:
        if (isFeedbackIntent(r6) == false) goto L12;
        r6.putExtra("from_search", true);
        r6.putExtra("start_from_setting", true);
        processCustomData(r6);
        if (startFeedback(r6) == true) goto L32;
        OLog.d(TAG, "launchIntent, open feedback failed");
        return;
    L32:
        return;
    L12:
        if (r6.getComponent() != null) goto L14;
    L20:
        r6.putExtra("from_search", true);
        if (r6.getComponent() == null) goto L26;
        if (r6.getComponent().getPackageName().equals(Constants.PKG_BUG2GO) == false) goto L26;
        OLog.d(TAG, "launchIntent, open feedback from setting search");
        r6.putExtra("start_from_setting", true);
    L26:
        if (r6.getComponent() != null) goto L28;
    L30:
        processCustomData(r6);
        Utils.startActivity(this._mActivity, r6);
        return;
    L28:
        if (r6.getComponent().getPackageName().equals("com.google.android.apps.safetyhub") == false) goto L30;
        r6.setAction(null);
        goto L30
    L14:
        if (isIntentAvailable(r6) == true) goto L20;
        String r0 = r6.getComponent().getPackageName();
        if (Constants.PKG_HAND_IN_HAND.equals(r0) == false) goto L18;
        showInstallDialog(r6.getComponent().getPackageName(), getString(R.string.hand_in_hand_dialog_title));
    L18:
        OLog.d(TAG, " No package installed : " + r0);
    }

    private boolean isFeedbackIntent(Intent r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.getComponent() == null) goto L8;
        if (Constants.PKG_BUG2GO.equals(r1.getComponent().getPackageName()) == false) goto L8;
        return true;
    }

    private boolean startFeedback(final Intent r3) {
        Bundle r0 = r3.getExtras();
        return FeedbackLauncher.startFeedback(this.mContext, r0, new SearchFragment$$ExternalSyntheticLambda2(r3));
    }

    static /* synthetic */ void lambda$startFeedback$3(Intent r1, Intent r2) {
        r2.setAction(r1.getAction());
        r2.setData(r1.getData());
        Set<String> r3 = r1.getCategories();
        if (r3 == null) goto L8;
        Iterator<String> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        r2.addCategory(r4.next());
        goto L6
    L10:
        return;
    }

    protected boolean isIntentAvailable(Intent r1) {
        return Utils.isPackageInstalled(this.mContext, r1.getComponent().getPackageName());
    }

    private void showInstallDialog(final String r5, String r6) {
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        final FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(TAG, "showInstallDialog, activity is null, return");
        return;
    L11:
        this.mDialog = new AlertDialog.Builder(r1).setTitle(R.string.dlg_title_notice).setMessage(getString(R.string.install_package_message, new Object[]{r6})).setNegativeButton(android.R.string.cancel, null).setPositiveButton(R.string.install_text, new AnonymousClass8(this, r1, r5)).show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void processCustomData(Intent r8) {
        String r7 = r8.getDataString();
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.contains(Constants.PKG_GLOBAL_ROAMING) == false) goto L9;
        r8.setData(null);
    L9:
        if (r7.contains(Utils.TOGGLEABLE_SERVICE_KEY) == false) goto L16;
        String[] r9 = r7.split("\\|");
        int r0 = r9.length;
        int r2 = 0;
    L11:
        if (r2 >= r0) goto L20;
        String[] r3 = r9[r2].split("=");
        if (r3.length <= 1) goto L15;
        r8.putExtra(r3[0], r3[1]);
        OLog.v(TAG, "launchIntent: key:" + r3[0] + ", value:" + r3[1]);
    L15:
        r2 = r2 + 1;
        goto L11
    L20:
        return;
    }

    private boolean needResearch(Uri r1) {
        return EnablerObserverAndReceiverFactory.isEspecialObservingUri(r1);
    }

    private boolean needResearch(String r1) {
        return EnablerObserverAndReceiverFactory.isEspecialObservingKey(r1);
    }

    private void search(String r8) {
        long r0 = AppMetricsUtils.INSTANCE.getNanoTimeMillis();
        if (TextUtils.isEmpty(r8) == true) goto L5;
        AppMetricsUtils.INSTANCE.durationEventStart("search", r0);
    L5:
        showSearchHistory();
        int r4 = 8;
        if (TextUtils.isEmpty(r8) == false) goto L13;
        this.mSearchResultListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultListView.restoreScrollState(false);
        this.mSearchBackground.setClickable(true);
        this.mSearchResultListView.setVisibility(8);
        View r2 = this.mHistoryLayout;
        if (this.mHistoryItemsWithItems.isEmpty() == true) goto L11;
        r4 = 0;
    L11:
        r2.setVisibility(r4);
    L17:
        new SearchTask(this, r0).execute(new String[]{r8});
        return;
    L13:
        if (this.isChinese == false) goto L15;
        String r3 = "";
    L16:
        r8 = r8.replaceAll("\\s+", r3).replaceAll("_", "[_]").replaceAll("%", "[%]");
        this.mSearchResultListView.setVisibility(0);
        this.mSearchBackground.setClickable(false);
        this.mSearchResultView.setVisibility(0);
        this.mHistoryLayout.setVisibility(8);
        this.mSearchEmptyView.setVisibility(8);
        goto L17
    L15:
        r3 = HanziToPinyin.Token.SEPARATOR;
        goto L16
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3.getId() != R.id.setting_item_btn_clear_history) goto L7;
        this.mSearchHistoryImpl.clearAllItems();
        this.mHistoryItemsWithItems.clear();
        this.mHistoryListview.removeHeaderView(this.mHeader);
        this.mHistoryAdapter.notifyDataSetChanged();
    L7:
        if (r3 != this.mCancelBtn) goto L10;
        finish();
        SettingsTracker.onEvent("A130007");
        return;
    }

    private boolean isHistoryClicked() {
        if (this.mHistoryLayout.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void hideInputMethod() {
        InputMethodManager r0 = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (r0 == null) goto L6;
        r0.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onBackPressedSupport() {
        hideInputMethod();
        if (this.finished == true) goto L7;
        this.finished = true;
        new SearchAnimationHelper().playSearchBoxExit(this.mSearchBar, this.mSearchBarPaddingLeft, this.mCancelBtn, Arrays.asList(new View[]{this.mSearchResultView, this.mHistoryLayout}));
        ThreadUtils.getUiThreadHandler().postDelayed(new AnonymousClass9(this), 100);
        return true;
    L7:
        return super.onBackPressedSupport();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (r2 == 2016) goto L6;
        return;
    L6:
        if (r3 != (-1)) goto L13;
        SearchResultItem r5 = r4.getParcelableExtra("extra_SearchResultItem");
        SettingsEnabler.setConfirm(true);
        SettingsEnabler.trigger(getActivity(), r5, false);
        if (r5 != null) goto L10;
        return;
    L10:
        if (needResearch(r5.mSwitchKey) == false) goto L15;
        OLog.d(TAG, r5.mText + " switch has triggered and need research");
        this.mHandler.sendEmptyMessage(2);
        return;
    L15:
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_search_SearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SearchFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_search_SearchFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_search_SearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SearchFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_search_SearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_search_SearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SearchFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_search_SearchFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
