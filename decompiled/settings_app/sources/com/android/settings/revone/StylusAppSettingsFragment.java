package com.android.settings.revone;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class StylusAppSettingsFragment extends BaseFragment {
    private final String TAG;
    private AppAdapter mAppAdapter;
    private RecyclerView mAppListView;
    private StylusClickType mClickType;
    private TextView mEmptyView;
    private String mSettingsId;

    /* JADX INFO: renamed from: com.android.settings.revone.StylusAppSettingsFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class AppAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ApplicationsState.Callbacks {
        private ArrayList<ApplicationsState.AppEntry> mAppEntries;
        private int mCurrentIndex;
        private boolean mResumed;
        private final ApplicationsState.Session mSession;
        final /* synthetic */ StylusAppSettingsFragment this$0;

        private class LoadAppListTask extends AsyncTask<Void, Void, ArrayList<ApplicationsState.AppEntry>> {
            final /* synthetic */ AppAdapter this$1;

            private LoadAppListTask(AppAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ LoadAppListTask(AppAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ ArrayList<ApplicationsState.AppEntry> doInBackground(Void[] r1) {
                return doInBackground2(r1);
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ void onPostExecute(ArrayList<ApplicationsState.AppEntry> r1) {
                onPostExecute2(r1);
            }

            /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
            protected ArrayList<ApplicationsState.AppEntry> doInBackground2(Void... r2) {
                return AppAdapter.access$100(this.this$1).rebuild(ApplicationsState.COMMON_APP_FILTER, ApplicationsState.ALPHA_COMPARATOR);
            }

            /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
            protected void onPostExecute2(ArrayList<ApplicationsState.AppEntry> r2) {
                if (this.this$1.this$0.isAdded() == true) goto L5;
                return;
            L5:
                if (r2 == null) goto L8;
                this.this$1.updateAppEntries(r2);
                this.this$1.notifyDataSetChanged();
                StylusAppSettingsFragment.access$200(this.this$1.this$0).setVisibility(8);
                return;
            }
        }

        static /* synthetic */ ApplicationsState.Session access$100(AppAdapter r0) {
            return r0.mSession;
        }

        static /* synthetic */ int access$302(AppAdapter r0, int r1) {
            r0.mCurrentIndex = r1;
            return r1;
        }

        static /* synthetic */ ArrayList access$500(AppAdapter r0) {
            return r0.mAppEntries;
        }

        public AppAdapter(StylusAppSettingsFragment r1, ApplicationsState r2) {
            this.this$0 = r1;
            this.mAppEntries = new ArrayList();
            this.mSession = r2.newSession(this);
        }

        public void resume() {
            if (this.mResumed == true) goto L5;
            this.mResumed = true;
            this.mSession.resume(true);
        L5:
            rebuild();
        }

        public void pause() {
            if (this.mResumed == false) goto L6;
            this.mResumed = false;
            this.mSession.pause();
            return;
        }

        public void destroy() {
            this.mSession.release();
        }

        public void rebuild() {
            new LoadAppListTask(this, null).execute(new Void[0]);
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRunningStateChanged(boolean r1) {
            OLog.i("StylusAppSettingsFragment", "onRunningStateChanged");
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageListChanged() {
            OLog.i("StylusAppSettingsFragment", "onPackageListChanged");
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r1) {
            OLog.i("StylusAppSettingsFragment", "onRebuildComplete");
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageIconChanged() {
            notifyDataSetChanged();
            OLog.i("StylusAppSettingsFragment", "onPackageIconChanged");
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageSizeChanged(String r1) {
            OLog.i("StylusAppSettingsFragment", "onPackageSizeChanged");
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onAllSizesComputed() {
            OLog.i("StylusAppSettingsFragment", "onAllSizesComputed");
        }

        protected void updateAppEntries(ArrayList<ApplicationsState.AppEntry> r2) {
            if (r2 != null) goto L4;
        L8:
            this.mAppEntries.clear();
            return;
        L4:
            if (r2.isEmpty() == true) goto L8;
            this.mAppEntries.clear();
            this.mAppEntries.addAll(r2);
            OLog.i("StylusAppSettingsFragment", "updateAppEntries mAppEntries:" + this.mAppEntries.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            View r5 = LayoutInflater.from(this.this$0.mContext).inflate(R.layout.list_content_item_check, r3, false);
            return new AppViewHolder(this.this$0, r5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder r4, final int r5) {
            OLog.i("StylusAppSettingsFragment", "onBindViewHolder");
            ApplicationsState.AppEntry r0 = this.mAppEntries.get(r5);
            AppViewHolder r6 = (AppViewHolder) r4;
            r6.getItemCheck().setTitle(r0.label);
            r6.getItemCheck().setIcon(r0.icon);
            setIconSize(r6.getItemCheck());
            Utils.setItemBgStyle(r6.getItemCheck(), getItemCount(), r5);
            r6.getItemCheck().setOnClickListener(new AnonymousClass1(this, r5));
            if (TextUtils.equals(StylusAppSettingsFragment.access$600(this.this$0).getSpecifiedApp(this.this$0.mContext), r0.info.packageName) == false) goto L5;
            this.mCurrentIndex = r5;
            r6.getItemCheck().setChecked(true);
            return;
        L5:
            r6.getItemCheck().setChecked(false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mAppEntries.size();
        }

        private void setIconSize(SettingItemCheck r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            ImageView r5 = r4.getIcon();
            ViewGroup.LayoutParams r0 = r5.getLayoutParams();
            r0.width = this.this$0.mContext.getResources().getDimensionPixelOffset(R.dimen.settings_list_item_icon_size);
            r0.height = this.this$0.mContext.getResources().getDimensionPixelOffset(R.dimen.settings_list_item_icon_size);
            r5.setLayoutParams(r0);
        }
    }

    private class AppViewHolder extends RecyclerView.ViewHolder {
        private SettingItemCheck mItemCheck;
        final /* synthetic */ StylusAppSettingsFragment this$0;

        public AppViewHolder(StylusAppSettingsFragment r1, View r2) {
            this.this$0 = r1;
            super(r2);
            this.mItemCheck = (SettingItemCheck) r2.findViewById(R.id.item_check);
        }

        public SettingItemCheck getItemCheck() {
            return this.mItemCheck;
        }
    }

    public void com_android_settings_revone_StylusAppSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_StylusAppSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_StylusAppSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ TextView access$200(StylusAppSettingsFragment r0) {
        return r0.mEmptyView;
    }

    static /* synthetic */ String access$400(StylusAppSettingsFragment r0) {
        return r0.mSettingsId;
    }

    static /* synthetic */ StylusClickType access$600(StylusAppSettingsFragment r0) {
        return r0.mClickType;
    }

    public StylusAppSettingsFragment() {
        super(R.layout.revone_fragment_stylus_app_settings);
        this.TAG = "StylusAppSettingsFragment";
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        StylusClickType r4 = new StylusClickType(getArguments().getInt(StylusKeySettingsFragment.EXTRA_CLICK_TYPE));
        this.mClickType = r4;
        this.mSettingsId = r4.getSpecifiedAppSettingsId(this.mContext);
        this.mAppListView = (RecyclerView) findViewByIdNullable(R.id.options_list);
        this.mEmptyView = (TextView) findViewByIdNullable(R.id.view_empty);
        this.mAppListView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mAppListView.setVerticalScrollBarEnabled(false);
        this.mAppListView.setNestedScrollingEnabled(false);
        AppAdapter r5 = new AppAdapter(this, ApplicationsState.getInstance(requireActivity().getApplication(), false));
        this.mAppAdapter = r5;
        this.mAppListView.setAdapter(r5);
    }

    public void com_android_settings_revone_StylusAppSettingsFragment__onResume$___twin___() {
        super.onResume();
        this.mAppAdapter.resume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mAppAdapter.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mAppAdapter.destroy();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_StylusAppSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(StylusAppSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_StylusAppSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_StylusAppSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(StylusAppSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_StylusAppSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_StylusAppSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(StylusAppSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_StylusAppSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
