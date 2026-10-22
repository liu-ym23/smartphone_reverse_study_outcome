package com.android.settings.applications;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.settings.EventType;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import settings.PreferredActivityChooseUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PreferredActivityDetails extends BaseFragment {
    private static final String CATEGORY = "category";
    private static final String FROM_SEARCH = "from_search";
    private static final String MIME_TYPE = "mimetype";
    private static final int MSG_REFRESH_UI = 10001;
    public static final String REQUEST_KEY_REQUEST_PREFERRED_ALL_CHOOSE = "request_key_request_preferred_all_choose";
    public static final String REQUEST_KEY_REQUEST_PREFERRED_CHOOSE_FOR_FILE_MANAGE = "request_key_request_preferred_file_choose";
    private static final int REQUEST_PREFERRED_CHOOSE_FOR_FILE_MANAGE = 101;
    public static final long TIME_OUT = 200;
    private static boolean mFirstInitView = true;
    private PreferedActivityAdapter mAdapter;
    private OListItemSettings mAllItem;
    private PreferredSettingsUtils.Category mCategory;
    private PreferredActivityChooseUtils mChooseUtils;
    private String mDisplayType;
    private List<PreferredSettingsUtils.FileType> mFileTypes;
    private Handler mHandler;
    private boolean mIsFromFileManager;
    private boolean mIsPauseNotify;
    AdapterView.OnItemClickListener mItemClickListener;
    private ListView mListView;
    private LoadDataAsyncTask mLoadDataAsyncTask;
    private View mLoadingView;
    private OtherFileTypeObserver mOtherFileTypeObserver;
    private PackageManager mPm;
    private ComponentName mPreferredActivity;
    private View mPreferredEmptyView;
    private String mSelectAction;

    /* JADX INFO: renamed from: com.android.settings.applications.PreferredActivityDetails$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category = null;

        static {
            int[] r0 = new int[PreferredSettingsUtils.Category.values().length];
            $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category = r0;
            r0[PreferredSettingsUtils.Category.audio.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[PreferredSettingsUtils.Category.video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[PreferredSettingsUtils.Category.text.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[PreferredSettingsUtils.Category.image.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static class LoadDataAsyncTask extends AsyncTask<Void, Integer, List<PreferredSettingsUtils.FileType>> {
        private WeakReference<PreferredActivityDetails> weakReference;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ List<PreferredSettingsUtils.FileType> doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(List<PreferredSettingsUtils.FileType> r1) {
            onPostExecute2(r1);
        }

        public LoadDataAsyncTask(PreferredActivityDetails r2) {
            this.weakReference = new WeakReference(r2);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected List<PreferredSettingsUtils.FileType> doInBackground2(Void... r1) {
            PreferredActivityDetails r2 = this.weakReference.get();
            if (isCancelled() == true) goto L8;
            if (r2 == null) goto L8;
            return PreferredActivityDetails.access$1000(r2);
        L8:
            return Collections.EMPTY_LIST;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(List<PreferredSettingsUtils.FileType> r1) {
            super.onPostExecute(r1);
            PreferredActivityDetails r0 = this.weakReference.get();
            if (r0 == null) goto L6;
            PreferredActivityDetails.access$1400(r0, r1);
            PreferredActivityDetails.access$1500(r0);
            PreferredActivityDetails.access$1200(r0, PreferredActivityDetails.access$1100(r0, r1));
            PreferredActivityDetails.access$1600(r0);
            return;
        }
    }

    static class MyHandler extends Handler {
        private WeakReference<PreferredActivityDetails> weakReference;

        protected MyHandler(PreferredActivityDetails r2) {
            this.weakReference = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            super.handleMessage(r2);
            if (r2.what == 10001) goto L5;
            return;
        L5:
            if (hasMessages(10001) == false) goto L7;
            removeMessages(10001);
        L7:
            PreferredActivityDetails r1 = this.weakReference.get();
            if (r1 == null) goto L12;
            List r3 = PreferredActivityDetails.access$1000(r1);
            PreferredActivityDetails.access$1200(r1, PreferredActivityDetails.access$1100(r1, r3));
            PreferredActivityDetails.access$1300(r1, r3);
            return;
        }
    }

    private class OtherFileTypeObserver extends ContentObserver {
        final /* synthetic */ PreferredActivityDetails this$0;

        public OtherFileTypeObserver(PreferredActivityDetails r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1, Uri r2) {
            if (PreferredActivityDetails.access$000(this.this$0) != PreferredSettingsUtils.Category.others) goto L6;
            PreferredActivityDetails.access$900(this.this$0);
            return;
        }
    }

    class PreferedActivityAdapter extends SettingsAdapter {
        private Context mContext;
        private View.OnTouchListener mTouchListener;
        final /* synthetic */ PreferredActivityDetails this$0;

        class ViewHolder {
            OListItemSettings item;
            final /* synthetic */ PreferedActivityAdapter this$1;

            ViewHolder(PreferedActivityAdapter r1) {
                this.this$1 = r1;
            }
        }

        public PreferedActivityAdapter(final PreferredActivityDetails r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
            this.mTouchListener = new AnonymousClass1(this, r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return PreferredActivityDetails.access$400(this.this$0).size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            PreferredSettingsUtils.FileType r8 = (PreferredSettingsUtils.FileType) PreferredActivityDetails.access$400(this.this$0).get(r5);
            if (r6 != null) goto L5;
            r6 = LayoutInflater.from(this.mContext).inflate(R.layout.list_content_item_text_oui, null, false);
            ViewHolder r1 = new ViewHolder(this);
            r1.item = (OListItemSettings) r6.findViewById(R.id.item_text);
            r1.item.setOnTouchListener(this.mTouchListener);
            r6.setTag(r1);
        L6:
            r1.item.setTitleString(PreferredActivityDetails.access$500(this.this$0, r8));
            r1.item.setEnabled(isEnabled(r5));
            ComponentName r9 = r8.getComponentName();     // Catch: PackageManager.NameNotFoundException -> L17
            if (r9 == null) goto L15;
            String r10 = r9.getPackageName();     // Catch: PackageManager.NameNotFoundException -> L17
            String r11 = PreferredActivityDetails.access$600(this.this$0).getApplicationInfo(r10, 0).loadLabel(PreferredActivityDetails.access$600(this.this$0)).toString();     // Catch: PackageManager.NameNotFoundException -> L17
            if (TextUtils.isEmpty(r10) == false) goto L12;
        L14:
            r1.item.setTrailingTextString(r11);     // Catch: PackageManager.NameNotFoundException -> L17
        L19:
            return r6;
        L12:
            if (r10.equals(PreferredSettingsUtils.getDefaultAppByCategory(PreferredActivityDetails.access$000(this.this$0))) == false) goto L14;
            r11 = r11 + this.mContext.getString(R.string.preferred_default_app);     // Catch: PackageManager.NameNotFoundException -> L17
            goto L14
        L15:
            r1.item.setTrailingTextString(this.mContext.getString(R.string.preferred_empty));     // Catch: PackageManager.NameNotFoundException -> L17
        L17:
            e = move-exception;
            e.printStackTrace();
            goto L19
        L5:
            r1 = (ViewHolder) r6.getTag();
            goto L6
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r2) {
            PreferredSettingsUtils.FileType r3 = (PreferredSettingsUtils.FileType) PreferredActivityDetails.access$400(this.this$0).get(r2);
            if (r3.getComponentName() == null) goto L5;
            return true;
        L5:
            if (r3.getIntentFilter() == null) goto L7;
            return true;
        L7:
            return PreferredSettingsUtils.isHasOpenApp(PreferredActivityDetails.access$700(this.this$0), r3.getMimeType(), false);
        }
    }

    static {
    }

    static /* synthetic */ PreferredSettingsUtils.FileType lambda$findFileTypeByMimeType$1(PreferredSettingsUtils.FileType r0) {
        return r0;
    }

    static /* synthetic */ PreferredSettingsUtils.FileType lambda$findFileTypeByMimeType$3(PreferredSettingsUtils.FileType r0) {
        return r0;
    }

    public void com_android_settings_applications_PreferredActivityDetails__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_applications_PreferredActivityDetails__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_PreferredActivityDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_PreferredActivityDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PreferredActivityDetails() {
        this.mSelectAction = "android.intent.action.VIEW";
        this.mFileTypes = new ArrayList();
        this.mIsFromFileManager = false;
        this.mIsPauseNotify = false;
        this.mItemClickListener = new AnonymousClass2(this);
    }

    static /* synthetic */ PreferredSettingsUtils.Category access$000(PreferredActivityDetails r0) {
        return r0.mCategory;
    }

    static /* synthetic */ boolean access$100(PreferredActivityDetails r0) {
        return r0.isShowChecked();
    }

    static /* synthetic */ List access$1000(PreferredActivityDetails r0) {
        return r0.loadFileTypesData();
    }

    static /* synthetic */ String access$1100(PreferredActivityDetails r0, List r1) {
        return r0.getAllItemSubTitle(r1);
    }

    static /* synthetic */ void access$1200(PreferredActivityDetails r0, String r1) {
        r0.setAllItemSubTitle(r1);
    }

    static /* synthetic */ void access$1300(PreferredActivityDetails r0, List r1) {
        r0.updateView(r1);
    }

    static /* synthetic */ void access$1400(PreferredActivityDetails r0, List r1) {
        r0.bindAdapter(r1);
    }

    static /* synthetic */ void access$1500(PreferredActivityDetails r0) {
        r0.showPreferredEmptyViewIfNeeded();
    }

    static /* synthetic */ void access$1600(PreferredActivityDetails r0) {
        r0.refreshAdapterIfLoadedDelayed();
    }

    static /* synthetic */ ComponentName access$200(PreferredActivityDetails r0) {
        return r0.mPreferredActivity;
    }

    static /* synthetic */ void access$300(PreferredActivityDetails r0) {
        r0.removeRefreshMsgIfNeeded();
    }

    static /* synthetic */ List access$400(PreferredActivityDetails r0) {
        return r0.mFileTypes;
    }

    static /* synthetic */ String access$500(PreferredActivityDetails r0, PreferredSettingsUtils.FileType r1) {
        return r0.getDisplayTitle(r1);
    }

    static /* synthetic */ PackageManager access$600(PreferredActivityDetails r0) {
        return r0.mPm;
    }

    static /* synthetic */ PreferredActivityChooseUtils access$700(PreferredActivityDetails r0) {
        return r0.mChooseUtils;
    }

    static /* synthetic */ ListView access$800(PreferredActivityDetails r0) {
        return r0.mListView;
    }

    static /* synthetic */ void access$900(PreferredActivityDetails r0) {
        r0.sendRefreshMsg();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.manage_applications_layout, r4, false);
        this.mPm = getPackageManager();
        this.mChooseUtils = new PreferredActivityChooseUtils(this.mContext);
        this.mHandler = new MyHandler(this);
        this.mOtherFileTypeObserver = new OtherFileTypeObserver(this, this.mHandler);
        Bundle r6 = getArguments();
        this.mIsFromFileManager = r6.getBoolean(PreferredSettingsUtils.INTENT_FROM_FILE_MANAGE, false);
        if (r6.getBoolean(FROM_SEARCH) == false) goto L6;
        this.mCategory = PreferredSettingsUtils.Category.valueOf(r6.getString("category"));
        setTitleText();
    L10:
        if (PreferredSettingsUtils.Category.text != this.mCategory) goto L13;
        EventBus.getDefault().register(this);
    L13:
        if (PreferredSettingsUtils.Category.others != this.mCategory) goto L15;
        getContentResolver().registerContentObserver(PreferredSettingsUtils.URI_OTHER_FILE_TYPE, true, this.mOtherFileTypeObserver);
    L15:
        this.mDisplayType = getDisplayType();
        this.mListView = (ListView) findViewByIdNullable(R.id.listView);
        this.mPreferredEmptyView = findViewByIdNullable(R.id.preferred_empty);
        View r7 = findViewByIdNullable(R.id.view_empty);
        this.mLoadingView = r7;
        r7.setVisibility(8);
        this.mPreferredEmptyView.setVisibility(8);
        View r8 = getLayoutInflater().inflate(R.layout.list_item_tips, null, false);
        ((OSectionSupportiveText) r8.findViewById(R.id.item_tips)).setSectionDes(this.mContext.getString(R.string.preferred_app_empty_summary));
        this.mListView.addFooterView(r8);
        addListHeaderViewIfNeeded();
        this.mListView.setOnItemClickListener(this.mItemClickListener);
        this.mListView.setEmptyView(this.mLoadingView);
        PreferedActivityAdapter r9 = new PreferedActivityAdapter(this, getActivity());
        this.mAdapter = r9;
        this.mListView.setAdapter(r9);
        LoadDataAsyncTask r10 = new LoadDataAsyncTask(this);
        this.mLoadDataAsyncTask = r10;
        r10.execute(new Void[0]);
        return this.mRootView;
    L6:
        if (this.mIsFromFileManager == false) goto L8;
        handlerIntentFromFileManager(r6);
        setTitleText();
        goto L10
    L8:
        this.mCategory = (PreferredSettingsUtils.Category) r6.getSerializable("category");
        goto L10
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (mFirstInitView == false) goto L7;
        mFirstInitView = false;
        if (this.mFileTypes.isEmpty() == true) goto L9;
        this.mListView.setVisibility(0);
        this.mAdapter.notifyDataSetChanged();
        return;
    L9:
        return;
    L7:
        sendRefreshMsg();
    }

    private void setTitleText() {
        int r0 = AnonymousClass3.$SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[this.mCategory.ordinal()];
        if (r0 != 1) goto L5;
        String r1 = this.mContext.getString(R.string.preferred_category_audio);
    L15:
        OFloatingTitleBar r2 = this.mTitleView;
        if (r2 == null) goto L19;
        r2.setCenterTitle(r1);
        return;
    L19:
        return;
    L5:
        if (r0 != 2) goto L7;
        r1 = this.mContext.getString(R.string.preferred_category_video);
        goto L15
    L7:
        if (r0 != 3) goto L9;
        r1 = this.mContext.getString(R.string.preferred_category_text);
        goto L15
    L9:
        if (r0 == 4) goto L11;
        r1 = "";
        goto L15
    L11:
        r1 = this.mContext.getString(R.string.preferred_category_image);
        goto L15
    }

    private PreferredSettingsUtils.FileType findFileTypeByMimeType(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L6;
        return null;
    L6:
        Iterator r0 = ((Map) PreferredSettingsUtils.createAllFileType().stream().collect(Collectors.toMap(new PreferredActivityDetails$$ExternalSyntheticLambda3(), new PreferredActivityDetails$$ExternalSyntheticLambda4()))).entrySet().iterator();
    L8:
        if (r0.hasNext() == false) goto L19;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        if (r2.contains(r7) == false) goto L8;
        String[] r3 = r2.split(";");
        int r4 = r3.length;
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L8;
        if (r3[r5].equals(r7) == true) goto L16;
        r5 = r5 + 1;
        goto L12
    L16:
        return (PreferredSettingsUtils.FileType) r1.getValue();
    L19:
        return (PreferredSettingsUtils.FileType) ((Map) PreferredSettingsUtils.getFileType(getActivity(), PreferredSettingsUtils.Category.others, this.mChooseUtils).stream().collect(Collectors.toMap(new PreferredActivityDetails$$ExternalSyntheticLambda5(), new PreferredActivityDetails$$ExternalSyntheticLambda6()))).get(r7);
    }

    static /* synthetic */ String lambda$findFileTypeByMimeType$0(PreferredSettingsUtils.FileType r0) {
        return r0.getMimeType();
    }

    static /* synthetic */ String lambda$findFileTypeByMimeType$2(PreferredSettingsUtils.FileType r0) {
        return r0.getMimeType();
    }

    private void handlerIntentFromFileManager(Bundle r6) {
        String r7 = r6.getString("mimetype");
        OLog.d(this.TAG, "FROM_FILE_MANAGE mimeType: " + r7);
        final PreferredSettingsUtils.FileType r8 = findFileTypeByMimeType(r7);
        if (r8 != null) goto L6;
        finish();
        return;
    L6:
        this.mCategory = r8.getCategory();
        PreferredSettingsUtils.FileType r1 = PreferredSettingsUtils.getFileType(getActivity(), this.mCategory, this.mChooseUtils).stream().filter(new PreferredActivityDetails$$ExternalSyntheticLambda7(r8)).findFirst().orElse(null);
        if (r1 == null) goto L9;
        r8.setComponentName(r1.getComponentName());
        r8.setIntentFilter(r1.getIntentFilter());
    L9:
        PreferredActivityChooserExtendFragment r2 = new PreferredActivityChooserExtendFragment();
        Bundle r3 = new Bundle();
        r3.putBoolean(PreferredSettingsUtils.INTENT_FROM_FILE_MANAGE, this.mIsFromFileManager);
        r3.putString("mimetype", r8.getMimeType());
        r3.putParcelable("filter", r8.getIntentFilter());
        r3.putString("summary", getDisplayTitle(r8));
        r3.putSerializable("category", r8.getCategory());
        r3.putString("title", getDisplayTitle(r8));
        r2.setArguments(r3);
        start(r2);
    }

    static /* synthetic */ boolean lambda$handlerIntentFromFileManager$4(PreferredSettingsUtils.FileType r0, PreferredSettingsUtils.FileType r1) {
        return r1.getMimeType().equals(r0.getMimeType());
    }

    private void addListHeaderViewIfNeeded() {
        if (this.mCategory != PreferredSettingsUtils.Category.others) goto L5;
        return;
    L5:
        View r0 = getLayoutInflater().inflate(R.layout.preferred_activity_details_header, null, false);
        ((TextView) r0.findViewById(R.id.file_type)).setText(getDisplayFileType());
        r0.findViewById(R.id.ll_all).setOnClickListener(new AnonymousClass1(this));
        this.mAllItem = (OListItemSettings) r0.findViewById(R.id.item_all_text);
        this.mListView.addHeaderView(r0);
    }

    private boolean isShowChecked() {
        String r0 = this.mAllItem.getTrailingTextString();
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mContext.getString(R.string.preferred_details_varied).equals(r0) == true) goto L9;
        if (this.mContext.getString(R.string.preferred_empty).equals(r0) == true) goto L9;
        return true;
    }

    private void refreshAdapterIfLoadedDelayed() {
        if (mFirstInitView == false) goto L5;
        return;
    L5:
        if (this.mFileTypes.isEmpty() == true) goto L9;
        this.mAdapter.notifyDataSetChanged();
        return;
    }

    private void sendRefreshMsg() {
        removeRefreshMsgIfNeeded();
        this.mIsPauseNotify = false;
        this.mHandler.sendEmptyMessageDelayed(10001, 200);
    }

    private void removeRefreshMsgIfNeeded() {
        this.mIsPauseNotify = true;
        if (this.mHandler.hasMessages(10001) == false) goto L6;
        this.mHandler.removeMessages(10001);
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        removeRefreshMsgIfNeeded();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        mFirstInitView = true;
        this.mIsPauseNotify = false;
        this.mLoadDataAsyncTask.cancel(true);
        this.mLoadDataAsyncTask = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mCategory != PreferredSettingsUtils.Category.others) goto L6;
        getContentResolver().unregisterContentObserver(this.mOtherFileTypeObserver);
    L6:
        if (this.mCategory != PreferredSettingsUtils.Category.text) goto L9;
        EventBus.getDefault().unregister(this);
        return;
    }

    private void bindAdapter(List<PreferredSettingsUtils.FileType> r2) {
        this.mFileTypes.clear();
        this.mFileTypes.addAll(r2);
    }

    private List<PreferredSettingsUtils.FileType> loadFileTypesData() {
        if (this.mIsPauseNotify == false) goto L7;
        return Collections.EMPTY_LIST;
    L7:
        return PreferredSettingsUtils.getFileType(getActivity(), this.mCategory, this.mChooseUtils);
    }

    private void updateView(List<PreferredSettingsUtils.FileType> r2) {
        if (this.mIsPauseNotify == false) goto L5;
        return;
    L5:
        bindAdapter(r2);
        this.mAdapter.notifyDataSetChanged();
        showPreferredEmptyViewIfNeeded();
        if (this.mFileTypes.isEmpty() == true) goto L9;
        this.mPreferredEmptyView.setVisibility(8);
        this.mListView.setVisibility(0);
        return;
    }

    private void showPreferredEmptyViewIfNeeded() {
        if (this.mFileTypes.isEmpty() == false) goto L6;
        this.mListView.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mPreferredEmptyView.setVisibility(0);
        return;
    }

    private boolean hasOpenMimeTypeWithPreferredPkg(List<PreferredSettingsUtils.FileType> r7, final String r8) {
        if (this.mPreferredActivity == null) goto L26;
        if (r7 == null) goto L26;
        if (r7.isEmpty() == true) goto L26;
        Iterator<PreferredSettingsUtils.FileType> r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L26;
        PreferredSettingsUtils.FileType r0 = r9.next();
        if (TextUtils.isEmpty(r0.getMimeType()) == true) goto L10;
        String[] r1 = r0.getMimeType().split(";");
        int r2 = r1.length;
        int r3 = 0;
    L15:
        if (r3 >= r2) goto L10;
        this.mChooseUtils.generateData(PreferredActivityChooseUtils.makeIntentByFilter(PreferredSettingsUtils.getIntentFilterForType(r1[r3])), false);
        List<ResolveInfo> r4 = this.mChooseUtils.getResolveInfoList();
        if (r4 == null) goto L25;
        if (r4.isEmpty() == true) goto L25;
        if (r4.stream().filter(new PreferredActivityDetails$$ExternalSyntheticLambda1()).anyMatch(new PreferredActivityDetails$$ExternalSyntheticLambda2(this, r8)) == false) goto L25;
        return true;
    L25:
        r3 = r3 + 1;
    L26:
        return false;
    }

    static /* synthetic */ boolean lambda$hasOpenMimeTypeWithPreferredPkg$5(ResolveInfo r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.activityInfo == null) goto L6;
        return true;
    }

    /* JADX INFO: renamed from: lambda$hasOpenMimeTypeWithPreferredPkg$6$com-android-settings-applications-PreferredActivityDetails, reason: not valid java name */
    /* synthetic */ boolean m308x6088a868(String r2, ResolveInfo r3) {
        if (this.mPreferredActivity.getPackageName().equals(r3.activityInfo.packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.contains(r3.activityInfo.name) == false) goto L7;
        return true;
    }

    private void setAllItemSubTitle(String r3) {
        if (this.mCategory == PreferredSettingsUtils.Category.others) goto L6;
        this.mAllItem.setTrailingTextString(r3);
        return;
    }

    private String getAllItemSubTitle(List<PreferredSettingsUtils.FileType> r4) {
        if (this.mCategory != PreferredSettingsUtils.Category.others) goto L5;
        return "";
    L5:
        if (this.mContext != null) goto L7;
        return "";
    L7:
        if (isAdded() == true) goto L9;
        return "";
    L9:
        if (r4.isEmpty() == true) goto L25;
        List r0 = (List) r4.stream().filter(new PreferredActivityDetails$$ExternalSyntheticLambda10()).filter(PreferredSettingsUtils.distinctByKey(new PreferredActivityDetails$$ExternalSyntheticLambda11())).collect(Collectors.toList());
        if (r0.isEmpty() == false) goto L16;
        return this.mContext.getString(R.string.preferred_empty);
    L16:
        if (r0.size() <= 1) goto L20;
        return this.mContext.getString(R.string.preferred_details_varied);
    L20:
        return getSinglePkgAllItemText(r4, ((PreferredSettingsUtils.FileType) r0.get(0)).getComponentName().getPackageName());
    L25:
        return "";
    }

    static /* synthetic */ boolean lambda$getAllItemSubTitle$7(PreferredSettingsUtils.FileType r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.getComponentName() == null) goto L6;
        return true;
    }

    static /* synthetic */ Object lambda$getAllItemSubTitle$8(PreferredSettingsUtils.FileType r0) {
        return r0.getComponentName().getPackageName();
    }

    private String getSinglePkgAllItemText(List<PreferredSettingsUtils.FileType> r8, String r9) {
        StringBuffer r0 = new StringBuffer();
        ArrayList r1 = new ArrayList();
        Iterator<PreferredSettingsUtils.FileType> r2 = r8.iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        PreferredSettingsUtils.FileType r3 = r2.next();
        if (r3 == null) goto L4;
        ComponentName r4 = r3.getComponentName();
        if (r4 != null) goto L11;
        if (this.mCategory != PreferredSettingsUtils.Category.text) goto L4;
        r1.add(r3);
        goto L4
    L11:
        if (r4.getPackageName().equals(r9) == false) goto L4;
        r0.append(r4.getClassName() + ";");
        goto L4
    L16:
        String r5 = r0.toString();
        this.mPreferredActivity = new ComponentName(r9, r5);
        Map<String, List<ResolveInfo>> r10 = PreferredSettingsUtils.loadSeeAndSendResolveInfoMap(this.mCategory, r8, this.mChooseUtils);
        List<ResolveInfo> r6 = r10.get("android.intent.action.VIEW");
        Iterator<ResolveInfo> r11 = r10.get("android.intent.action.SEND").iterator();
        boolean r7 = false;
    L18:
        if (r11.hasNext() == false) goto L24;
        ResolveInfo r12 = r11.next();
        if (r7 == true) goto L18;
        if (r5.contains(r12.activityInfo.name) == false) goto L18;
        r7 = true;
        goto L18
    L24:
        Iterator<ResolveInfo> r13 = r6.iterator();
        boolean r14 = false;
    L26:
        if (r13.hasNext() == false) goto L32;
        ResolveInfo r15 = r13.next();
        if (r14 == true) goto L26;
        if (r5.contains(r15.activityInfo.name) == false) goto L26;
        r14 = true;
        goto L26
    L32:
        if (r14 == false) goto L37;
        if (r7 == false) goto L37;
        return this.mContext.getString(R.string.preferred_details_varied);
    L37:
        if (this.mCategory == PreferredSettingsUtils.Category.text) goto L39;
    L49:
        String r16 = this.mPm.getApplicationInfo(r9, 0).loadLabel(this.mPm).toString();     // Catch: PackageManager.NameNotFoundException -> L46
        if (PreferredSettingsUtils.getDefaultAppByCategory(this.mCategory).equals(r9) == false) goto L77;
        return r16 + this.mContext.getString(R.string.preferred_default_app);
    L77:
        return r16;
    L46:
        e = move-exception;
        OLog.e(this.TAG, e.getMessage());
        return "";
    L39:
        if (hasOpenMimeTypeWithPreferredPkg(r1, r5) == false) goto L49;
        return this.mContext.getString(R.string.preferred_empty);
    }

    @Override // com.android.settings.base.BaseFragment
    public List<String> getFragmentRequestKeys() {
        ArrayList r1 = new ArrayList();
        r1.add(REQUEST_KEY_REQUEST_PREFERRED_ALL_CHOOSE);
        r1.add(REQUEST_KEY_REQUEST_PREFERRED_CHOOSE_FOR_FILE_MANAGE);
        return r1;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onFragmentResult(String r2, int r3, Bundle r4) {
        super.onFragmentResult(r2, r3, r4);
        if (r2.equals(REQUEST_KEY_REQUEST_PREFERRED_ALL_CHOOSE) == false) goto L12;
        if (r3 != RESULT_OK) goto L12;
        ArrayList r5 = r4.getParcelableArrayList(PreferredSettingsUtils.INTENT_EXTRA_SELECT_PREFERRED_ACTIVITY_ARRAY);
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.isEmpty() == true) goto L18;
        this.mSelectAction = r4.getString(PreferredSettingsUtils.INTENT_EXTRA_SELECT_ACTION);
        setAllMimeTypes(r5);
        sendRefreshMsg();
        return;
    L18:
        return;
    L12:
        if (r2.equals(REQUEST_KEY_REQUEST_PREFERRED_CHOOSE_FOR_FILE_MANAGE) == true) goto L14;
        return;
    L14:
        if (r3 != RESULT_OK) goto L21;
        sendRefreshMsg();
        return;
    }

    private void setAllMimeTypes(final List<ResolveInfo> r5) {
        final AtomicInteger r0 = new AtomicInteger(0);
        final AtomicInteger r2 = new AtomicInteger(0);
        this.mFileTypes.stream().filter(new PreferredActivityDetails$$ExternalSyntheticLambda8()).forEach(new PreferredActivityDetails$$ExternalSyntheticLambda9(this, r5, r2, r0));
    }

    static /* synthetic */ boolean lambda$setAllMimeTypes$9(PreferredSettingsUtils.FileType r0) {
        return !TextUtils.isEmpty(r0.getMimeType());
    }

    /* JADX INFO: renamed from: lambda$setAllMimeTypes$11$com-android-settings-applications-PreferredActivityDetails, reason: not valid java name */
    /* synthetic */ void m309x74d34205(List r4, AtomicInteger r5, AtomicInteger r6, PreferredSettingsUtils.FileType r7) {
        List r0 = new ArrayList();
        if (r7.getMimeType().contains(";") == false) goto L6;
        r0 = (List) Stream.of(r7.getMimeType().split(";")).map(new PreferredActivityDetails$$ExternalSyntheticLambda0()).collect(Collectors.toList());
    L9:
        Iterator r8 = r0.iterator();
        boolean r1 = false;
    L11:
        if (r8.hasNext() == false) goto L15;
        if (addPreferredActivityForChooserAll((IntentFilter) r8.next(), r4) == false) goto L11;
        r1 = true;
        goto L11
    L15:
        if (r1 == false) goto L17;
        r5.getAndIncrement();
        return;
    L17:
        r6.getAndIncrement();
        return;
    L6:
        if (r7.getIntentFilter() == null) goto L8;
        r0.add(r7.getIntentFilter());
        goto L9
    L8:
        r0.add(PreferredSettingsUtils.getIntentFilterForType(r7.getMimeType()));
        goto L9
    }

    static /* synthetic */ IntentFilter lambda$setAllMimeTypes$10(String r0) {
        return PreferredSettingsUtils.getIntentFilterForType(r0);
    }

    private boolean addPreferredActivityForChooserAll(IntentFilter r5, List<ResolveInfo> r6) {
        Iterator<ResolveInfo> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        ResolveInfo r0 = r7.next();
        ComponentName r2 = new ComponentName(r0.activityInfo.packageName, r0.activityInfo.name);
        if (PreferredSettingsUtils.addPreferredActivity(r5, this.mChooseUtils, this.mPm, false, r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private String getDisplayType() {
        if (PreferredSettingsUtils.Category.audio.equals(this.mCategory) == false) goto L7;
        return this.mContext.getString(R.string.type_audio);
    L7:
        if (PreferredSettingsUtils.Category.video.equals(this.mCategory) == false) goto L11;
        return this.mContext.getString(R.string.type_video);
    L11:
        if (PreferredSettingsUtils.Category.text.equals(this.mCategory) == false) goto L15;
        return this.mContext.getString(R.string.type_text);
    L15:
        if (PreferredSettingsUtils.Category.image.equals(this.mCategory) == false) goto L19;
        return this.mContext.getString(R.string.type_image);
    L19:
        return this.mContext.getString(R.string.type_normal);
    }

    private String getDisplayFileType() {
        if (PreferredSettingsUtils.Category.audio.equals(this.mCategory) == false) goto L7;
        return this.mContext.getString(R.string.preferred_details_file_type_audio);
    L7:
        if (PreferredSettingsUtils.Category.video.equals(this.mCategory) == false) goto L11;
        return this.mContext.getString(R.string.preferred_details_file_type_video);
    L11:
        if (PreferredSettingsUtils.Category.text.equals(this.mCategory) == false) goto L15;
        return this.mContext.getString(R.string.preferred_details_file_type_text);
    L15:
        if (PreferredSettingsUtils.Category.image.equals(this.mCategory) == false) goto L19;
        return this.mContext.getString(R.string.preferred_details_file_type_image);
    L19:
        return this.mContext.getString(R.string.preferred_details_file_type_text);
    }

    private String getToastText(int r7, int r8) {
        if (this.mContext != null) goto L5;
        return "";
    L5:
        int r0 = AnonymousClass3.$SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[this.mCategory.ordinal()];
        if (r0 == 1) goto L20;
        if (r0 == 2) goto L18;
        if (r0 == 3) goto L16;
        if (r0 == 4) goto L14;
        return "";
    L14:
        return this.mContext.getString(R.string.preferred_image_toast, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)});
    L16:
        return this.mContext.getString(R.string.preferred_text_toast, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)});
    L18:
        return this.mContext.getString(R.string.preferred_video_toast, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)});
    L20:
        return this.mContext.getString(R.string.preferred_audio_toast, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)});
    }

    private String getDisplayTitle(PreferredSettingsUtils.FileType r6) {
        StringBuffer r0 = new StringBuffer();
        if (PreferredSettingsUtils.Category.audio.equals(this.mCategory) == false) goto L5;
    L8:
        r0.append(this.mContext.getString(R.string.android_intent_action_view_multimedia));
    L9:
        String r1 = r6.getSuffixes();
        if (TextUtils.isEmpty(r1) == true) goto L12;
        List r2 = (List) Arrays.stream(r1.split(HanziToPinyin.Token.SEPARATOR)).collect(Collectors.toList());
        String r7 = r6.getSuffix();
        if (TextUtils.isEmpty(r7) == true) goto L16;
    L18:
        r0.append(HanziToPinyin.Token.SEPARATOR).append(r7).append(HanziToPinyin.Token.SEPARATOR).append(getDisplayType()).append(" (").append(r1).append(")");
        return r0.toString();
    L16:
        if (r2.isEmpty() == true) goto L18;
        r7 = (String) r2.get(0);
        goto L18
    L12:
        return r0.append(HanziToPinyin.Token.SEPARATOR).append(r6.getMimeType()).append(HanziToPinyin.Token.SEPARATOR).append(getDisplayType()).toString();
    L5:
        if (PreferredSettingsUtils.Category.video.equals(this.mCategory) == true) goto L8;
        r0.append(this.mContext.getString(R.string.android_intent_action_view));
        goto L9
    }

    @Subscribe
    public void onEvent(EventType.InstallWpsEvent r2) {
        if (PreferredSettingsUtils.Category.text == this.mCategory) goto L5;
        return;
    L5:
        if (this.mIsFragmentVisible == false) goto L9;
        sendRefreshMsg();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_PreferredActivityDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PreferredActivityDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PreferredActivityDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_PreferredActivityDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PreferredActivityDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
