package com.android.settings.print;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.print.PrintManager;
import android.print.PrinterDiscoverySession;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.printservice.PrintServiceInfo;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.SwitchBar;
import com.android.settings.widget.ToggleSwitch;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PrintServiceSettingsFragment extends SettingsPreferenceFragment implements SwitchBar.OnSwitchChangeListener, LoaderManager.LoaderCallbacks<List<PrintServiceInfo>> {
    private static final int LOADER_ID_PRINTERS_LOADER = 1;
    private static final int LOADER_ID_PRINT_SERVICE_LOADER = 2;
    private static final String LOG_TAG = "PrintServiceSettingsFragment";
    private Intent mAddPrintersIntent;
    private ComponentName mComponentName;
    private final DataSetObserver mDataObserver;
    private int mLastUnfilteredItemCount;
    private CharSequence mOldActivityTitle;
    private String mPreferenceKey;
    private PrintersAdapter mPrintersAdapter;
    private SearchView mSearchView;
    private boolean mServiceEnabled;
    private Intent mSettingsIntent;
    private SwitchBar mSwitchBar;
    private ToggleSwitch mToggleSwitch;

    private static final class PrintServicesLoaderCompat extends AsyncTaskLoader<List<PrintServiceInfo>> {
        private final PrintManager mPrintManager;

        @Override // androidx.loader.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ List<PrintServiceInfo> loadInBackground() {
            return loadInBackground2();
        }

        PrintServicesLoaderCompat(Context r1, PrintManager r2) {
            super(r1);
            this.mPrintManager = r2;
        }

        @Override // androidx.loader.content.AsyncTaskLoader
        /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
        public List<PrintServiceInfo> loadInBackground2() {
            PrintManager r1 = this.mPrintManager;
            if (r1 == null) goto L6;
            return r1.getPrintServices(3);
        L6:
            return Collections.emptyList();
        }

        @Override // androidx.loader.content.Loader
        protected void onStartLoading() {
            forceLoad();
        }
    }

    private final class PrintersAdapter extends BaseAdapter implements LoaderManager.LoaderCallbacks<List<PrinterInfo>>, Filterable {
        private final List<PrinterInfo> mFilteredPrinters;
        private CharSequence mLastSearchString;
        private final Object mLock;
        private final List<PrinterInfo> mPrinters;
        final /* synthetic */ PrintServiceSettingsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private PrintersAdapter(PrintServiceSettingsFragment r1) {
            this.this$0 = r1;
            this.mLock = new Object();
            this.mPrinters = new ArrayList();
            this.mFilteredPrinters = new ArrayList();
        }

        /* synthetic */ PrintersAdapter(PrintServiceSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ Object access$600(PrintersAdapter r0) {
            return r0.mLock;
        }

        static /* synthetic */ List access$700(PrintersAdapter r0) {
            return r0.mPrinters;
        }

        static /* synthetic */ CharSequence access$802(PrintersAdapter r0, CharSequence r1) {
            r0.mLastSearchString = r1;
            return r1;
        }

        static /* synthetic */ List access$900(PrintersAdapter r0) {
            return r0.mFilteredPrinters;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<PrinterInfo>> r1, List<PrinterInfo> r2) {
            onLoadFinished2(r1, r2);
        }

        public void enable() {
            LoaderManager.getInstance(this.this$0).initLoader(1, null, this);
        }

        public void disable() {
            LoaderManager.getInstance(this.this$0).destroyLoader(1);
            this.mPrinters.clear();
        }

        public int getUnfilteredCount() {
            return this.mPrinters.size();
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return new AnonymousClass1(this);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int r1 = this.mFilteredPrinters.size();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            PrinterInfo r1 = this.mFilteredPrinters.get(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isActionable(int r1) {
            if (((PrinterInfo) getItem(r1)).getStatus() == 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.widget.Adapter
        public View getView(int r7, View r8, ViewGroup r9) {
            if (r8 != null) goto L5;
            r8 = this.this$0.getActivity().getLayoutInflater().inflate(R.layout.printer_dropdown_item, r9, false);
        L5:
            r8.setEnabled(isActionable(r7));
            final PrinterInfo r10 = (PrinterInfo) getItem(r7);
            String r1 = r10.getName();
            String r2 = r10.getDescription();
            Drawable r3 = r10.loadIcon(this.this$0.getActivity());
            ((TextView) r8.findViewById(R.id.title)).setText(r1);
            TextView r4 = (TextView) r8.findViewById(R.id.subtitle);
            if (TextUtils.isEmpty(r2) == true) goto L8;
            r4.setText(r2);
            r4.setVisibility(0);
        L9:
            LinearLayout r5 = (LinearLayout) r8.findViewById(R.id.more_info);
            if (r10.getInfoIntent() == null) goto L12;
            r5.setVisibility(0);
            r5.setOnClickListener(new AnonymousClass2(this, r10));
        L13:
            ImageView r11 = (ImageView) r8.findViewById(R.id.icon);
            if (r3 == null) goto L19;
            r11.setVisibility(0);
            if (isActionable(r7) == true) goto L18;
            r3.mutate();
            TypedValue r12 = new TypedValue();
            this.this$0.getActivity().getTheme().resolveAttribute(android.R.attr.disabledAlpha, r12, true);
            r3.setAlpha((int) (r12.getFloat() * 255.0f));
        L18:
            r11.setImageDrawable(r3);
        L20:
            return r8;
        L19:
            r11.setVisibility(8);
            goto L20
        L12:
            r5.setVisibility(8);
            goto L13
        L8:
            r4.setText(null);
            r4.setVisibility(8);
            goto L9
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader<List<PrinterInfo>> onCreateLoader(int r1, Bundle r2) {
            if (r1 == 1) goto L5;
            return null;
        L5:
            return new PrintersLoader(this.this$0.getContext());
        }

        /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
        public void onLoadFinished2(Loader<List<PrinterInfo>> r6, List<PrinterInfo> r7) {
            Object r8 = this.mLock;
            monitor-enter(r8);
            this.mPrinters.clear();     // Catch: Throwable -> L16
            int r0 = r7.size();     // Catch: Throwable -> L16
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L10;
            PrinterInfo r2 = r7.get(r1);     // Catch: Throwable -> L16
            if (r2.getId().getServiceName().equals(PrintServiceSettingsFragment.access$1000(this.this$0)) == false) goto L9;
            this.mPrinters.add(r2);     // Catch: Throwable -> L16
        L9:
            r1 = r1 + 1;     // Catch: Throwable -> L16
            goto L5
        L10:
            this.mFilteredPrinters.clear();     // Catch: Throwable -> L16
            this.mFilteredPrinters.addAll(this.mPrinters);     // Catch: Throwable -> L16
            if (TextUtils.isEmpty(this.mLastSearchString) == true) goto L13;
            getFilter().filter(this.mLastSearchString);     // Catch: Throwable -> L16
        L13:
            monitor-exit(r8);     // Catch: Throwable -> L16
            notifyDataSetChanged();
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<List<PrinterInfo>> r2) {
            Object r3 = this.mLock;
            monitor-enter(r3);
            this.mPrinters.clear();     // Catch: Throwable -> L8
            this.mFilteredPrinters.clear();     // Catch: Throwable -> L8
            this.mLastSearchString = null;     // Catch: Throwable -> L8
            monitor-exit(r3);     // Catch: Throwable -> L8
            notifyDataSetInvalidated();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private static class PrintersLoader extends Loader<List<PrinterInfo>> {
        private static final boolean DEBUG = false;
        private static final String LOG_TAG = "PrintersLoader";
        private PrinterDiscoverySession mDiscoverySession;
        private final Map<PrinterId, PrinterInfo> mPrinters;

        static /* synthetic */ PrinterDiscoverySession access$1100(PrintersLoader r0) {
            return r0.mDiscoverySession;
        }

        @Override // androidx.loader.content.Loader
        public /* bridge */ /* synthetic */ void deliverResult(List<PrinterInfo> r1) {
            deliverResult2(r1);
        }

        public PrintersLoader(Context r1) {
            super(r1);
            this.mPrinters = new LinkedHashMap();
        }

        /* JADX INFO: renamed from: deliverResult, reason: avoid collision after fix types in other method */
        public void deliverResult2(List<PrinterInfo> r2) {
            if (isStarted() == false) goto L6;
            super.deliverResult(r2);
            return;
        }

        @Override // androidx.loader.content.Loader
        protected void onStartLoading() {
            if (this.mPrinters.isEmpty() == true) goto L5;
            deliverResult2(new ArrayList(this.mPrinters.values()));
        L5:
            onForceLoad();
        }

        @Override // androidx.loader.content.Loader
        protected void onStopLoading() {
            onCancelLoad();
        }

        @Override // androidx.loader.content.Loader
        protected void onForceLoad() {
            loadInternal();
        }

        @Override // androidx.loader.content.Loader
        protected boolean onCancelLoad() {
            return cancelInternal();
        }

        @Override // androidx.loader.content.Loader
        protected void onReset() {
            onStopLoading();
            this.mPrinters.clear();
            PrinterDiscoverySession r0 = this.mDiscoverySession;
            if (r0 == null) goto L6;
            r0.destroy();
            this.mDiscoverySession = null;
            return;
        }

        @Override // androidx.loader.content.Loader
        protected void onAbandon() {
            onStopLoading();
        }

        private boolean cancelInternal() {
            PrinterDiscoverySession r0 = this.mDiscoverySession;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.isPrinterDiscoveryStarted() == false) goto L10;
            this.mDiscoverySession.stopPrinterDiscovery();
            return true;
        L10:
            return false;
        }

        private void loadInternal() {
            if (this.mDiscoverySession != null) goto L8;
            PrintManager r0 = (PrintManager) getContext().getSystemService("print");
            if (r0 != null) goto L7;
            return;
        L7:
            PrinterDiscoverySession r1 = r0.createPrinterDiscoverySession();
            this.mDiscoverySession = r1;
            r1.setOnPrintersChangeListener(new AnonymousClass1(this));
        L8:
            this.mDiscoverySession.startPrinterDiscovery(null);
        }
    }

    public void com_android_settings_print_PrintServiceSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_print_PrintServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_print_PrintServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PrintServiceSettingsFragment() {
        this.mDataObserver = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(PrintServiceSettingsFragment r0) {
        r0.updateEmptyView();
    }

    static /* synthetic */ PrintersAdapter access$100(PrintServiceSettingsFragment r0) {
        return r0.mPrintersAdapter;
    }

    static /* synthetic */ ComponentName access$1000(PrintServiceSettingsFragment r0) {
        return r0.mComponentName;
    }

    static /* synthetic */ int access$200(PrintServiceSettingsFragment r0) {
        return r0.mLastUnfilteredItemCount;
    }

    static /* synthetic */ int access$202(PrintServiceSettingsFragment r0, int r1) {
        r0.mLastUnfilteredItemCount = r1;
        return r1;
    }

    static /* synthetic */ String access$400(PrintServiceSettingsFragment r0) {
        return r0.mPreferenceKey;
    }

    static /* synthetic */ void access$500(PrintServiceSettingsFragment r0, String r1, boolean r2) {
        r0.onPreferenceToggled(r1, r2);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<PrintServiceInfo>> r1, List<PrintServiceInfo> r2) {
        onLoadFinished2(r1, r2);
    }

    public void com_android_settings_print_PrintServiceSettingsFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mServiceEnabled = getArguments().getBoolean("EXTRA_CHECKED");
        String r3 = getArguments().getString("EXTRA_TITLE");
        if (TextUtils.isEmpty(r3) == true) goto L6;
        getActivity().setTitle(r3);
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        updateEmptyView();
        updateUiForServiceState();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        SearchView r0 = this.mSearchView;
        if (r0 == null) goto L5;
        r0.setOnQueryTextListener(null);
    L5:
        super.onPause();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        initComponents();
        updateUiForArguments();
        NullSafe.nonNull(getBackupListView()).setVisibility(0);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.mOldActivityTitle == null) goto L5;
        getActivity().getActionBar().setTitle(this.mOldActivityTitle);
    L5:
        super.onDestroyView();
        this.mSwitchBar.removeOnSwitchChangeListener(this);
        this.mSwitchBar.hide();
    }

    private void onPreferenceToggled(String r2, boolean r3) {
        Context r4 = getContext();
        if (r4 == null) goto L6;
        ((PrintManager) r4.getSystemService("print")).setPrintServiceEnabled(this.mComponentName, r3);
        return;
    }

    private ListView getBackupListView() {
        return (ListView) getView().findViewById(R.id.backup_list);
    }

    private void updateEmptyView() {
        ViewGroup r0 = (ViewGroup) getListView().getParent();
        View r1 = getBackupListView().getEmptyView();
        if (this.mToggleSwitch.isChecked() == true) goto L11;
        if (r1 != null) goto L6;
    L8:
        if (r1 != null) goto L27;
        View r2 = getActivity().getLayoutInflater().inflate(R.layout.empty_print_state, r0, false);
        ((ImageView) r2.findViewById(R.id.icon)).setContentDescription(getString(R.string.print_service_disabled));
        ((TextView) r2.findViewById(R.id.message)).setText(R.string.print_service_disabled);
        r0.addView(r2);
        getBackupListView().setEmptyView(r2);
        return;
    L27:
        return;
    L6:
        if (r1.getId() == R.id.empty_print_state) goto L8;
        r0.removeView(r1);
        r1 = null;
        goto L8
    L11:
        if (this.mPrintersAdapter.getUnfilteredCount() > 0) goto L19;
        if (r1 != null) goto L14;
    L16:
        if (r1 != null) goto L29;
        View r3 = getActivity().getLayoutInflater().inflate(R.layout.empty_printers_list_service_enabled, r0, false);
        r0.addView(r3);
        getBackupListView().setEmptyView(r3);
        return;
    L29:
        return;
    L14:
        if (r1.getId() == R.id.empty_printers_list_service_enabled) goto L16;
        r0.removeView(r1);
        r1 = null;
        goto L16
    L19:
        if (this.mPrintersAdapter.getCount() > 0) goto L31;
        if (r1 != null) goto L22;
    L24:
        if (r1 != null) goto L32;
        View r4 = getActivity().getLayoutInflater().inflate(R.layout.empty_print_state, r0, false);
        ((ImageView) r4.findViewById(R.id.icon)).setContentDescription(getString(R.string.print_no_printers_found));
        ((TextView) r4.findViewById(R.id.message)).setText(R.string.print_no_printers_found);
        r0.addView(r4);
        getBackupListView().setEmptyView(r4);
        return;
    L32:
        return;
    L22:
        if (r1.getId() == R.id.empty_print_state) goto L24;
        r0.removeView(r1);
        r1 = null;
        goto L24
    }

    private void updateUiForServiceState() {
        if (this.mServiceEnabled == false) goto L5;
        this.mSwitchBar.setCheckedInternal(true);
        this.mPrintersAdapter.enable();
    L6:
        getActivity().invalidateOptionsMenu();
        return;
    L5:
        this.mSwitchBar.setCheckedInternal(false);
        this.mPrintersAdapter.disable();
        goto L6
    }

    private void initComponents() {
        PrintersAdapter r0 = new PrintersAdapter(this, null);
        this.mPrintersAdapter = r0;
        r0.registerDataSetObserver(this.mDataObserver);
        SwitchBar r1 = ((SettingsActivity) getActivity()).getSwitchBar();
        this.mSwitchBar = r1;
        r1.addOnSwitchChangeListener(this);
        this.mSwitchBar.show();
        ToggleSwitch r2 = this.mSwitchBar.getSwitch();
        this.mToggleSwitch = r2;
        r2.setOnBeforeCheckedChangeListener(new AnonymousClass2(this));
        ListView r3 = getBackupListView();
        if (r3 == null) goto L6;
        r3.setSelector(new ColorDrawable(0));
        r3.setAdapter(this.mPrintersAdapter);
        r3.setOnItemClickListener(new AnonymousClass3(this));
        return;
    }

    @Override // com.android.settings.widget.SwitchBar.OnSwitchChangeListener
    public void onSwitchChanged(Switch r1, boolean r2) {
        updateEmptyView();
    }

    private void updateUiForArguments() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return;
    L5:
        ComponentName r1 = ComponentName.unflattenFromString(r0.getString("EXTRA_SERVICE_COMPONENT_NAME"));
        this.mComponentName = r1;
        this.mPreferenceKey = r1.flattenToString();
        boolean r2 = r0.getBoolean("EXTRA_CHECKED");
        this.mSwitchBar.setCheckedInternal(r2);
        LoaderManager.getInstance(this).initLoader(2, null, this);
        setHasOptionsMenu(true);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<PrintServiceInfo>> onCreateLoader(int r2, Bundle r3) {
        return new PrintServicesLoaderCompat(getContext(), (PrintManager) getContext().getSystemService("print"));
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<PrintServiceInfo>> r7, List<PrintServiceInfo> r8) {
        if (r8 == null) goto L10;
        int r1 = r8.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        if (r8.get(r2).getComponentName().equals(this.mComponentName) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        PrintServiceInfo r9 = r8.get(r2);
    L11:
        if (r9 != null) goto L14;
        finishFragment();
        return;
    L14:
        this.mServiceEnabled = r9.isEnabled();
        if (r9.getSettingsActivityName() == null) goto L21;
        Intent r3 = new Intent("android.intent.action.MAIN");
        r3.setComponent(new ComponentName(r9.getComponentName().getPackageName(), r9.getSettingsActivityName()));
        List<ResolveInfo> r4 = getPackageManager().queryIntentActivities(r3, 0);
        if (r4.isEmpty() == true) goto L23;
        if (r4.get(0).activityInfo.exported == false) goto L23;
        this.mSettingsIntent = r3;
    L23:
        if (r9.getAddPrintersActivityName() == null) goto L29;
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.setComponent(new ComponentName(r9.getComponentName().getPackageName(), r9.getAddPrintersActivityName()));
        List<ResolveInfo> r10 = getPackageManager().queryIntentActivities(r0, 0);
        if (r10.isEmpty() == false) goto L27;
    L30:
        updateUiForServiceState();
        return;
    L27:
        if (r10.get(0).activityInfo.exported == false) goto L30;
        this.mAddPrintersIntent = r0;
        goto L30
    L29:
        this.mAddPrintersIntent = null;
        goto L30
    L21:
        this.mSettingsIntent = null;
    L10:
        r9 = null;
        goto L11
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<PrintServiceInfo>> r1) {
        updateUiForServiceState();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r3, MenuInflater r4) {
        super.onCreateOptionsMenu(r3, r4);
        r4.inflate(R.menu.print_service_settings, r3);
        MenuItem r0 = r3.findItem(R.id.print_menu_item_add_printer);
        if (this.mServiceEnabled == false) goto L7;
        Intent r1 = this.mAddPrintersIntent;
        if (r1 == null) goto L7;
        r0.setIntent(r1);
    L8:
        MenuItem r2 = r3.findItem(R.id.print_menu_item_settings);
        if (this.mServiceEnabled == false) goto L13;
        Intent r5 = this.mSettingsIntent;
        if (r5 == null) goto L13;
        r2.setIntent(r5);
    L14:
        MenuItem r6 = r3.findItem(R.id.print_menu_item_search);
        if (this.mServiceEnabled == true) goto L17;
    L19:
        r3.removeItem(R.id.print_menu_item_search);
        return;
    L17:
        if (this.mPrintersAdapter.getUnfilteredCount() <= 0) goto L19;
        SearchView r7 = (SearchView) r6.getActionView();
        this.mSearchView = r7;
        r7.setOnQueryTextListener(new AnonymousClass4(this));
        this.mSearchView.addOnAttachStateChangeListener(new AnonymousClass5(this));
        return;
    L13:
        r3.removeItem(R.id.print_menu_item_settings);
    L7:
        r3.removeItem(R.id.print_menu_item_add_printer);
        goto L8
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_print_PrintServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PrintServiceSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_print_PrintServiceSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_print_PrintServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PrintServiceSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_print_PrintServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_print_PrintServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PrintServiceSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_print_PrintServiceSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
