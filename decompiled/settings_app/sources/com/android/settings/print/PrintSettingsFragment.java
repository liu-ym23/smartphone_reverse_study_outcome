package com.android.settings.print;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.app.admin.DevicePolicyResourcesManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Flags;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.os.UserManager;
import android.print.PrintJob;
import android.print.PrintJobInfo;
import android.print.PrintManager;
import android.printservice.PrintServiceInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import com.android.settings.R;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ViewUtils;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.v2.OPopover;
import com.obric.privacy.GrantUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PrintSettingsFragment extends BaseFragment implements Indexable {
    private static final boolean DEBUG_MOCK_DATA = false;
    private static final String EXTRA_ACTIVITY = "EXTRA_ACTIVITY";
    static final String EXTRA_CHECKED = "EXTRA_CHECKED";
    static final String EXTRA_SERVICE_COMPONENT_NAME = "EXTRA_SERVICE_COMPONENT_NAME";
    static final String EXTRA_TITLE = "EXTRA_TITLE";
    private static final int LOADER_ID_PRINT_JOBS_LOADER = 1;
    private static final int LOADER_ID_PRINT_SERVICES = 2;
    private static final String PACKAGE_BIPS = "com.android.bips";
    private static final String PACKAGE_BIPS_ADDPRINTERS = "com.android.bips.ui.AddPrintersActivity";
    private static final String SYSTEM_PRINTSERVICE = "com.android.bips/com.android.bips.BuiltInPrintService";
    public static final String TAG = "PrintSettingsFragment";
    private OCardListItem mAddServiceButton;
    private Handler mHandler;
    private OCardListItem mItemProfile;
    private PrintJobListAdapter mPrintJobListAdapter;
    private ListView mPrintJobListView;
    private PrintJobsController mPrintJobsController;
    private PrintServiceListAdapter mPrintServiceListAdapter;
    private ListView mPrintServiceListView;
    private PrintServicesController mPrintServicesController;
    private OPopover mUserPopover;

    private static class MockPrintService {
        public String componentName;
        public boolean isEnabled;
        public String title;

        public MockPrintService(String r1, String r2, boolean r3) {
            this.title = r1;
            this.componentName = r2;
            this.isEnabled = r3;
        }
    }

    private class PrintJobListAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mLayoutInflater;
        private List<PrintJobInfo> mList;
        final /* synthetic */ PrintSettingsFragment this$0;

        private class PrintJobViewHolder {
            public OCardListItem printItem;
            final /* synthetic */ PrintJobListAdapter this$1;

            private PrintJobViewHolder(PrintJobListAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ PrintJobViewHolder(PrintJobListAdapter r1, AnonymousClass1 r2) {
                this(r1);
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

        public PrintJobListAdapter(PrintSettingsFragment r1, Context r2) {
            this.this$0 = r1;
            this.mList = null;
            this.mContext = r2;
            this.mLayoutInflater = LayoutInflater.from(r2);
        }

        public void setData(List<PrintJobInfo> r1) {
            this.mList = r1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<PrintJobInfo> r0 = this.mList;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public PrintJobInfo getItem(int r3) {
            if (this.mList != null) goto L5;
            return null;
        L5:
            int r0 = getCount();
            if (r0 <= 0) goto L11;
            if (r3 >= r0) goto L11;
            return this.mList.get(r3);
        L11:
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.widget.Adapter
        public View getView(final int r18, View r19, final ViewGroup r20) {
            String r3 = null;
            Object[] r4 = 0;
            if (r19 != null) goto L5;
            final View r5 = this.mLayoutInflater.inflate(R.layout.print_job_list_item, r20, false);
            PrintJobViewHolder r6 = new PrintJobViewHolder(this, r4 == true ? 1 : 0);
            r6.printItem = (OCardListItem) r5.findViewById(R.id.print_job_item);
            r5.setTag(r6);
        L6:
            PrintJobInfo r7 = getItem(r18);
            if (r7 != null) goto L10;
            return r5;
        L10:
            if (r18 == 0) goto L12;
        L14:
            if (r18 != 0) goto L17;
            r6.printItem.setCardPosition(1);
        L20:
            String r11 = r7.getLabel();
            if (TextUtils.isEmpty(r11) == false) goto L23;
            return r5;
        L23:
            r6.printItem.setTitle(r11);
            int r12 = r7.getState();
            int r15 = R.color.oui_functional_blue_6;
            if (r12 == 2) goto L37;
            if (r12 == 3) goto L37;
            if (r12 == 4) goto L33;
            if (r12 != 6) goto L40;
            r3 = this.this$0.getString(R.string.print_failed_state_title_template);
        L31:
            r15 = R.color.oui_functional_red_6;
        L40:
            if (r3 == null) goto L42;
            r6.printItem.setSubTitle(r3);
            r6.printItem.showSubTitle(true);
            r6.printItem.setTitleColor(this.this$0.getResources().getColor(R.color.oui_basic_text_1), this.this$0.getResources().getColor(r15));
        L42:
            r7.getPrinterName();
            int r8 = r7.getState();
            if (r8 == 2) goto L53;
            if (r8 == 3) goto L53;
            if (r8 == 4) goto L48;
            if (r8 == 6) goto L48;
        L54:
            r6.printItem.setOnContentClickListener(new PrintSettingsFragment$PrintJobListAdapter$$ExternalSyntheticLambda0(this, r20, r5, r18));
            return r5;
        L48:
            r6.printItem.showCustomStart(false);
            Drawable r9 = this.this$0.getActivity().getDrawable(R.drawable.print_error);
            if (r9 == null) goto L54;
            r6.printItem.setIcon(r9);
            ImageView r10 = r6.printItem.getIconView();
            if ((r10.getParent() instanceof FrameLayout) == false) goto L54;
            ((FrameLayout) r10.getParent()).setPadding(0, 0, 0, 0);
        L53:
            r6.printItem.showIcon(false);
            r6.printItem.showCustomStart(true);
            goto L54
        L33:
            if (r7.isCancelling() == true) goto L35;
            r3 = this.this$0.getString(R.string.print_blocked_state_title_template);
            goto L31
        L35:
            r3 = this.this$0.getString(R.string.print_cancelling_state_title_template);
        L37:
            if (r7.isCancelling() == true) goto L39;
            r3 = this.this$0.getString(R.string.print_printing_state_title_template);
            goto L40
        L39:
            r3 = this.this$0.getString(R.string.print_cancelling_state_title_template);
            goto L40
        L17:
            if (r18 != (this.mList.size() - 1)) goto L19;
            r6.printItem.setCardPosition(3);
            goto L20
        L19:
            r6.printItem.setCardPosition(2);
            goto L20
        L12:
            if (this.mList.size() != 1) goto L14;
            r6.printItem.setCardPosition(0);
            goto L20
        L5:
            r6 = (PrintJobViewHolder) r19.getTag();
            r5 = r19;
            goto L6
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-print-PrintSettingsFragment$PrintJobListAdapter, reason: not valid java name */
        /* synthetic */ void m538x29d20a17(ViewGroup r7, View r8, int r9, View r10) {
            if ((r7 instanceof ListView) == false) goto L8;
            ListView r1 = (ListView) r7;
            AdapterView.OnItemClickListener r0 = r1.getOnItemClickListener();
            if (r0 == null) goto L9;
            r0.onItemClick(r1, r8, r9, getItemId(r9));
            return;
        L9:
            return;
        }
    }

    private final class PrintJobsController implements LoaderManager.LoaderCallbacks<List<PrintJobInfo>> {
        final /* synthetic */ PrintSettingsFragment this$0;

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<List<PrintJobInfo>> r1) {
        }

        private PrintJobsController(PrintSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PrintJobsController(PrintSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<PrintJobInfo>> r1, List<PrintJobInfo> r2) {
            onLoadFinished2(r1, r2);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader<List<PrintJobInfo>> onCreateLoader(int r1, Bundle r2) {
            if (r1 == 1) goto L5;
            return null;
        L5:
            return new PrintJobsLoader(this.this$0.getContext());
        }

        /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
        public void onLoadFinished2(Loader<List<PrintJobInfo>> r2, List<PrintJobInfo> r3) {
            PrintSettingsFragment.access$300(this.this$0).setData(r3);
            PrintSettingsFragment.access$300(this.this$0).notifyDataSetChanged();
            View r4 = this.this$0.findViewByIdNullable(R.id.print_job_title);
            if (r4 == null) goto L10;
            if (r3 != null) goto L6;
        L9:
            r4.setVisibility(8);
            PrintSettingsFragment.access$800(this.this$0).setVisibility(8);
            goto L10
        L6:
            if (r3.isEmpty() == true) goto L9;
            r4.setVisibility(0);
            PrintSettingsFragment.access$800(this.this$0).setVisibility(0);
        L10:
            ViewUtils.setListViewHeightBasedOnChildren(PrintSettingsFragment.access$800(this.this$0), PrintSettingsFragment.access$300(this.this$0));
        }
    }

    private static final class PrintJobsLoader extends AsyncTaskLoader<List<PrintJobInfo>> {
        private static final boolean DEBUG = false;
        private static final String LOG_TAG = "PrintJobsLoader";
        private PrintManager.PrintJobStateChangeListener mPrintJobStateChangeListener;
        private List<PrintJobInfo> mPrintJobs;
        private final PrintManager mPrintManager;

        static /* synthetic */ void access$900(PrintJobsLoader r0) {
            r0.onForceLoad();
        }

        @Override // androidx.loader.content.Loader
        public /* bridge */ /* synthetic */ void deliverResult(Object r1) {
            deliverResult((List) r1);
        }

        @Override // androidx.loader.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ List<PrintJobInfo> loadInBackground() {
            return loadInBackground2();
        }

        public PrintJobsLoader(Context r2) {
            super(r2);
            this.mPrintJobs = new ArrayList();
            this.mPrintManager = ((PrintManager) r2.getSystemService("print")).getGlobalPrintManagerForUser(r2.getUserId());
        }

        public void deliverResult(List<PrintJobInfo> r2) {
            if (isStarted() == false) goto L6;
            super.deliverResult(r2);
            return;
        }

        @Override // androidx.loader.content.Loader
        protected void onStartLoading() {
            super.onStartLoading();
            if (this.mPrintJobs.isEmpty() == true) goto L6;
            deliverResult(new ArrayList(this.mPrintJobs));
        L6:
            if (this.mPrintJobStateChangeListener != null) goto L9;
            PrintManager.PrintJobStateChangeListener r0 = new AnonymousClass1(this);
            this.mPrintJobStateChangeListener = r0;
            this.mPrintManager.addPrintJobStateChangeListener(r0);
        L9:
            if (this.mPrintJobs.isEmpty() == false) goto L12;
            onForceLoad();
            return;
        }

        @Override // androidx.loader.content.Loader
        protected void onStopLoading() {
            onCancelLoad();
        }

        @Override // androidx.loader.content.Loader
        protected void onReset() {
            onStopLoading();
            this.mPrintJobs.clear();
            PrintManager.PrintJobStateChangeListener r0 = this.mPrintJobStateChangeListener;
            if (r0 == null) goto L6;
            this.mPrintManager.removePrintJobStateChangeListener(r0);
            this.mPrintJobStateChangeListener = null;
            return;
        }

        @Override // androidx.loader.content.AsyncTaskLoader
        /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
        public List<PrintJobInfo> loadInBackground2() {
            List<PrintJob> r5 = this.mPrintManager.getPrintJobs();
            int r0 = r5.size();
            ArrayList r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L10;
            PrintJobInfo r3 = r5.get(r2).getInfo();
            if (PrintSettingsFragment.access$1000(r3) == false) goto L9;
            if (r1 != null) goto L8;
            r1 = new ArrayList();
        L8:
            r1.add(r3);
        L9:
            r2 = r2 + 1;
            goto L3
        L10:
            return r1;
        }
    }

    private class PrintServiceListAdapter extends BaseAdapter {
        private Context mContext;
        private boolean mIsMockMode;
        private LayoutInflater mLayoutInflater;
        private List<PrintServiceInfo> mList;
        private List<MockPrintService> mMockList;
        final /* synthetic */ PrintSettingsFragment this$0;

        private class PrintServiceViewHolder {
            public OCardListItem printItem;
            final /* synthetic */ PrintServiceListAdapter this$1;

            private PrintServiceViewHolder(PrintServiceListAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ PrintServiceViewHolder(PrintServiceListAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public PrintServiceListAdapter(PrintSettingsFragment r1, Context r2) {
            this.this$0 = r1;
            this.mList = null;
            this.mMockList = null;
            this.mIsMockMode = false;
            this.mContext = r2;
            this.mLayoutInflater = LayoutInflater.from(r2);
        }

        public void setData(List<PrintServiceInfo> r1) {
            this.mList = r1;
            this.mMockList = null;
            this.mIsMockMode = false;
        }

        public void setMockData(List<MockPrintService> r1) {
            this.mMockList = r1;
            this.mList = null;
            this.mIsMockMode = true;
        }

        public int getServiceCount() {
            if (this.mIsMockMode == false) goto L9;
            List<MockPrintService> r2 = this.mMockList;
            if (r2 != null) goto L8;
            return 0;
        L8:
            return r2.size();
        L9:
            List<PrintServiceInfo> r3 = this.mList;
            if (r3 != null) goto L13;
            return 0;
        L13:
            return r3.size();
        }

        public PrintServiceInfo getServiceItem(int r3) {
            if (this.mIsMockMode == false) goto L5;
        L13:
            return null;
        L5:
            if (this.mList == null) goto L13;
            int r0 = getServiceCount();
            if (r0 <= 0) goto L13;
            if (r3 >= r0) goto L13;
            return this.mList.get(r3);
        }

        public MockPrintService getMockServiceItem(int r3) {
            if (this.mIsMockMode == true) goto L5;
        L13:
            return null;
        L5:
            if (this.mMockList == null) goto L13;
            int r0 = getServiceCount();
            if (r0 <= 0) goto L13;
            if (r3 >= r0) goto L13;
            return this.mMockList.get(r3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return getServiceCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            if (this.mIsMockMode == false) goto L7;
            return getMockServiceItem(r2);
        L7:
            return getServiceItem(r2);
        }

        @Override // android.widget.Adapter
        public View getView(final int r7, final View r8, final ViewGroup r9) {
            if (r8 != null) goto L4;
            r8 = this.mLayoutInflater.inflate(R.layout.print_service_list_item, r9, false);
            PrintServiceViewHolder r0 = new PrintServiceViewHolder(this, null);
            r0.printItem = (OCardListItem) r8.findViewById(R.id.print_service_item);
            r8.setTag(r0);
        L6:
            if (this.mIsMockMode == false) goto L11;
            MockPrintService r1 = getMockServiceItem(r7);
            if (r1 != null) goto L10;
            return r8;
        L10:
            String r2 = r1.title;
            String r3 = r1.componentName;
            boolean r4 = r1.isEnabled;
        L18:
            if (r4 == false) goto L20;
            r0.printItem.setEndDetailText(this.this$0.getString(R.string.settings_state_on));
        L22:
            if (PrintSettingsFragment.SYSTEM_PRINTSERVICE.equals(r3) == false) goto L24;
            r0.printItem.setTitle(this.this$0.getString(R.string.system_print_service));
        L25:
            int r5 = getServiceCount();
            if (r7 != 0) goto L29;
            if (r5 != 1) goto L29;
            r0.printItem.setCardPosition(1);
        L35:
            r0.printItem.setOnContentClickListener(new PrintSettingsFragment$PrintServiceListAdapter$$ExternalSyntheticLambda0(this, r9, r8, r7));
            return r8;
        L29:
            if (r7 != 0) goto L32;
            r0.printItem.setCardPosition(1);
            goto L35
        L32:
            if (r7 != (r5 - 1)) goto L34;
            r0.printItem.setCardPosition(2);
            goto L35
        L34:
            r0.printItem.setCardPosition(2);
            goto L35
        L24:
            r0.printItem.setTitle(r2);
            goto L25
        L20:
            r0.printItem.setEndDetailText(this.this$0.getString(R.string.settings_state_off));
            goto L22
        L11:
            PrintServiceInfo r6 = getServiceItem(r7);
            if (r6 != null) goto L14;
            return r8;
        L14:
            FragmentActivity r10 = this.this$0.getActivity();
            if (r10 != null) goto L17;
            return r8;
        L17:
            PackageManager r11 = r10.getPackageManager();
            r2 = r6.getResolveInfo().loadLabel(r11).toString();
            r3 = r6.getComponentName().flattenToString();
            r4 = r6.isEnabled();
            goto L18
        L4:
            r0 = (PrintServiceViewHolder) r8.getTag();
            goto L6
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-print-PrintSettingsFragment$PrintServiceListAdapter, reason: not valid java name */
        /* synthetic */ void m539x684d7a9f(ViewGroup r7, View r8, int r9, View r10) {
            if ((r7 instanceof ListView) == false) goto L8;
            ListView r1 = (ListView) r7;
            AdapterView.OnItemClickListener r0 = r1.getOnItemClickListener();
            if (r0 == null) goto L9;
            r0.onItemClick(r1, r8, r9 + 1, getItemId(r9));
            return;
        L9:
            return;
        }
    }

    private final class PrintServicesController implements LoaderManager.LoaderCallbacks<List<PrintServiceInfo>> {
        final /* synthetic */ PrintSettingsFragment this$0;

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<List<PrintServiceInfo>> r1) {
        }

        private PrintServicesController(PrintSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PrintServicesController(PrintSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<PrintServiceInfo>> r1, List<PrintServiceInfo> r2) {
            onLoadFinished2(r1, r2);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader<List<PrintServiceInfo>> onCreateLoader(int r1, Bundle r2) {
            PrintManager r3 = (PrintManager) this.this$0.getContext().getSystemService("print");
            if (r3 != null) goto L5;
            return null;
        L5:
            return new PrintServicesLoaderCompat(this.this$0.getContext(), r3);
        }

        /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
        public void onLoadFinished2(Loader<List<PrintServiceInfo>> r6, List<PrintServiceInfo> r7) {
            PrintSettingsFragment.access$200(this.this$0).setData(r7);
            PrintSettingsFragment.access$200(this.this$0).notifyDataSetChanged();
            PrintSettingsFragment.access$500(this.this$0);
            int r8 = 0;
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r8 >= PrintSettingsFragment.access$200(this.this$0).getCount()) goto L9;
            View r2 = PrintSettingsFragment.access$200(this.this$0).getView(r8, null, PrintSettingsFragment.access$600(this.this$0));
            if (r2.getVisibility() != 0) goto L8;
            r2.measure(0, 0);
            r1 = r1 + r2.getMeasuredHeight();
            r0 = r0 + 1;
        L8:
            r8 = r8 + 1;
            goto L4
        L9:
            if (r0 == 0) goto L13;
            int r9 = PrintSettingsFragment.access$600(this.this$0).getDividerHeight();
            if (r9 <= 0) goto L13;
            r1 = r1 + (r9 * (r0 - 1));
        L13:
            View r10 = PrintSettingsFragment.access$600(this.this$0).getChildAt(0);
            if (r10 == null) goto L16;
            r10.measure(0, 0);
            int r11 = r10.getMeasuredHeight();
        L17:
            int r3 = r1 + r11;
            if (PrintSettingsFragment.access$700(this.this$0) == null) goto L20;
            PrintSettingsFragment.access$700(this.this$0).measure(0, 0);
            r3 = r3 + PrintSettingsFragment.access$700(this.this$0).getMeasuredHeight();
        L20:
            ViewGroup.LayoutParams r12 = PrintSettingsFragment.access$600(this.this$0).getLayoutParams();
            r12.height = r3;
            PrintSettingsFragment.access$600(this.this$0).setLayoutParams(r12);
            return;
        L16:
            View r13 = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.print_list_header, null);
            r13.measure(0, 0);
            r11 = r13.getMeasuredHeight();
            goto L17
        }
    }

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

    public void com_android_settings_print_PrintSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_print_PrintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_print_PrintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PrintSettingsFragment() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ boolean access$1000(PrintJobInfo r0) {
        return shouldShowToUser(r0);
    }

    static /* synthetic */ PrintServiceListAdapter access$200(PrintSettingsFragment r0) {
        return r0.mPrintServiceListAdapter;
    }

    static /* synthetic */ PrintJobListAdapter access$300(PrintSettingsFragment r0) {
        return r0.mPrintJobListAdapter;
    }

    static /* synthetic */ void access$400(PrintSettingsFragment r0, PrintJobInfo r1) {
        r0.showPrintJobDialog(r1);
    }

    static /* synthetic */ void access$500(PrintSettingsFragment r0) {
        r0.updateAddServiceButtonPosition();
    }

    static /* synthetic */ ListView access$600(PrintSettingsFragment r0) {
        return r0.mPrintServiceListView;
    }

    static /* synthetic */ OCardListItem access$700(PrintSettingsFragment r0) {
        return r0.mAddServiceButton;
    }

    static /* synthetic */ ListView access$800(PrintSettingsFragment r0) {
        return r0.mPrintJobListView;
    }

    public void com_android_settings_print_PrintSettingsFragment__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        AnonymousClass1 r0 = null;
        this.mPrintJobsController = new PrintJobsController(this, r0);
        LoaderManager.getInstance(this).initLoader(1, null, this.mPrintJobsController);
        this.mPrintServicesController = new PrintServicesController(this, r0);
        LoaderManager.getInstance(this).initLoader(2, null, this.mPrintServicesController);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.fragment_print_settings_layout, r3, false);
        this.mPrintJobListView = (ListView) findViewByIdNullable(R.id.print_job_list);
        this.mPrintServiceListView = (ListView) findViewByIdNullable(R.id.print_list);
        this.mPrintJobListAdapter = new PrintJobListAdapter(this, getContext());
        this.mPrintServiceListAdapter = new PrintServiceListAdapter(this, getContext());
        View r5 = r2.inflate(R.layout.print_list_header, null);
        this.mPrintServiceListView.addHeaderView(r5);
        setupAddServiceButton();
        this.mPrintServiceListView.setAdapter(this.mPrintServiceListAdapter);
        this.mPrintJobListView.setAdapter(this.mPrintJobListAdapter);
        this.mPrintServiceListView.setOnItemClickListener(new AnonymousClass1(this));
        this.mPrintJobListView.setOnItemClickListener(new AnonymousClass2(this));
        OCardListItem r6 = (OCardListItem) r5.findViewById(R.id.item_profile);
        this.mItemProfile = r6;
        setupUserProfile(r6);
        return this.mRootView;
    }

    private void setupAddServiceButton() {
        final Intent r0 = createAddNewServiceIntentOrNull();
        if (r0 != null) goto L5;
        return;
    L5:
        OCardListItem r1 = new OCardListItem(getContext());
        this.mAddServiceButton = r1;
        r1.setShowCardBg(true);
        this.mAddServiceButton.setCardType(2);
        this.mAddServiceButton.setCustomStartView(R.layout.print_add_service_btn_layout);
        this.mAddServiceButton.setOnContentClickListener(new PrintSettingsFragment$$ExternalSyntheticLambda2(this, r0));
        this.mPrintServiceListView.addFooterView(this.mAddServiceButton);
    }

    /* JADX INFO: renamed from: lambda$setupAddServiceButton$0$com-android-settings-print-PrintSettingsFragment, reason: not valid java name */
    /* synthetic */ void m532xfabc5c92(Intent r1, View r2) {
        startActivity(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Unable to start activity", e);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void setupUserProfile(final OCardListItem r8) {
        final UserManager r4 = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        final List<UserHandle> r6 = r4.getUserProfiles();
        if (r6.size() >= 2) goto L6;
        r8.setVisibility(8);
        return;
    L6:
        r8.setVisibility(0);
        final UserHandle r5 = new UserHandle(UserHandle.myUserId());
        r6.remove(r5);
        r6.add(0, r5);
        r8.setEndDetailText(getTitle(this._mActivity, r5, r4));
        r8.showCustomEnd(true);
        r8.setOnContentClickListener(new PrintSettingsFragment$$ExternalSyntheticLambda6(this, r8, r4, r5, r6));
    }

    /* JADX INFO: renamed from: lambda$setupUserProfile$1$com-android-settings-print-PrintSettingsFragment, reason: not valid java name */
    /* synthetic */ void m533xc246de79(OCardListItem r1, UserManager r2, UserHandle r3, List r4, View r5) {
        showUserPopover(r1, r2, r3, r4);
    }

    private void showUserPopover(View r6, UserManager r7, final UserHandle r8, final List<UserHandle> r9) {
        ArrayList r0 = new ArrayList();
        Iterator<UserHandle> r1 = r9.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        UserHandle r2 = r1.next();
        r0.add(new Item(getTitle(this._mActivity, r2, r7), r2.equals(r8)));
        goto L4
    L6:
        this.mUserPopover = OPopoverHelper.showPopoverList(this._mActivity, r6, r0, new PrintSettingsFragment$$ExternalSyntheticLambda8(this, r9, r8));
    }

    /* JADX INFO: renamed from: lambda$showUserPopover$3$com-android-settings-print-PrintSettingsFragment, reason: not valid java name */
    /* synthetic */ void m537x360a1115(List r1, UserHandle r2, View r3, int r4) {
        OPopover r5 = this.mUserPopover;
        if (r5 == null) goto L5;
        r5.dismiss();
    L5:
        UserHandle r6 = (UserHandle) r1.get(r4);
        if (r6 == r2) goto L9;
        Intent r7 = new Intent("android.settings.ACTION_PRINT_SETTINGS").setPackage(getContext().getPackageName());
        r7.addFlags(268435456);
        r7.addFlags(32768);
        this._mActivity.startActivityAsUser(r7, r6);
        TransitionAnimHelper.overrideEnterAnim(this._mActivity, TransitionAnimStyle.Standard);
        this.mHandler.post(new PrintSettingsFragment$$ExternalSyntheticLambda7(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$showUserPopover$2$com-android-settings-print-PrintSettingsFragment, reason: not valid java name */
    /* synthetic */ void m536x44606af6() {
        this._mActivity.finish();
    }

    private void updateAddServiceButtonPosition() {
        if (this.mAddServiceButton != null) goto L6;
        return;
    L6:
        if (this.mPrintServiceListAdapter.getServiceCount() <= 0) goto L8;
        this.mAddServiceButton.setCardPosition(3);
        return;
    L8:
        this.mAddServiceButton.setCardPosition(0);
    }

    private Intent createAddNewServiceIntentOrNull() {
        String r2 = Settings.Secure.getString(getContentResolver(), "print_service_search_uri");
        if (TextUtils.isEmpty(r2) == true) goto L7;
        return new Intent("android.intent.action.VIEW", Uri.parse(r2));
    L7:
        return new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=print service"));
    }

    private void showPrintJobDialog(PrintJobInfo r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.getState();
        boolean r1 = r4.isCancelling();
        if (r0 != 2) goto L7;
    L15:
        if (r1 == true) goto L20;
        showCancelPrintDialog(r4);
        return;
    L20:
        return;
    L7:
        if (r0 == 3) goto L15;
        if (r0 != 6) goto L12;
    L14:
        showRestartPrintDialog(r4);
        return;
    L12:
        if (r0 == 4) goto L14;
        if (r1 == true) goto L14;
    }

    private void showCancelPrintDialog(final PrintJobInfo r4) {
        new OAlertDialogBuilder(getContext()).title(R.string.print_dialog_cancel_title).message(R.string.print_dialog_cancel_message).horizontalButton(true).negativeButton(R.string.print_dialog_cancel_close, new PrintSettingsFragment$$ExternalSyntheticLambda0()).positiveButton(R.string.print_dialog_cancel_confirm, new PrintSettingsFragment$$ExternalSyntheticLambda3(this, r4)).createDialog().show();
    }

    static /* synthetic */ void lambda$showCancelPrintDialog$4(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    /* JADX INFO: renamed from: lambda$showCancelPrintDialog$5$com-android-settings-print-PrintSettingsFragment, reason: not valid java name */
    /* synthetic */ void m534xf8aa4912(PrintJobInfo r1, DialogInterface r2, int r3) {
        cancelPrintJob(r1);
        r2.dismiss();
    }

    private void showRestartPrintDialog(final PrintJobInfo r4) {
        new OAlertDialogBuilder(getContext()).title(R.string.print_dialog_restart_title).message(R.string.print_dialog_restart_message).horizontalButton().negativeButton(R.string.print_dialog_restart_close, new PrintSettingsFragment$$ExternalSyntheticLambda4()).positiveButton(R.string.print_dialog_restart_confirm, new PrintSettingsFragment$$ExternalSyntheticLambda5(this, r4)).createDialog().show();
    }

    static /* synthetic */ void lambda$showRestartPrintDialog$6(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    /* JADX INFO: renamed from: lambda$showRestartPrintDialog$7$com-android-settings-print-PrintSettingsFragment, reason: not valid java name */
    /* synthetic */ void m535x27337b1(PrintJobInfo r1, DialogInterface r2, int r3) {
        restartPrintJob(r1);
        r2.dismiss();
    }

    private void cancelPrintJob(PrintJobInfo r5) {
        if (r5 != null) goto L17;
        return;
    L17:
        PrintManager r4 = (PrintManager) getContext().getSystemService("print");     // Catch: Exception -> L14
        if (r4 == null) goto L22;
        Iterator<PrintJob> r6 = r4.getPrintJobs().iterator();     // Catch: Exception -> L14
    L9:
        if (r6.hasNext() == false) goto L24;
        PrintJob r1 = r6.next();     // Catch: Exception -> L14
        if (r1.getId().equals(r5.getId()) == false) goto L9;
        r1.cancel();     // Catch: Exception -> L14
        OLog.w(TAG, "Success to cancel print job");     // Catch: Exception -> L14
        return;
    L24:
        return;
    L22:
        return;
    L14:
        e = move-exception;
        OLog.w(TAG, "Failed to cancel print job", e);
    }

    private void restartPrintJob(PrintJobInfo r5) {
        if (r5 != null) goto L17;
        return;
    L17:
        PrintManager r4 = (PrintManager) getContext().getSystemService("print");     // Catch: Exception -> L14
        if (r4 == null) goto L22;
        Iterator<PrintJob> r6 = r4.getPrintJobs().iterator();     // Catch: Exception -> L14
    L9:
        if (r6.hasNext() == false) goto L24;
        PrintJob r1 = r6.next();     // Catch: Exception -> L14
        if (r1.getId().equals(r5.getId()) == false) goto L9;
        r1.restart();     // Catch: Exception -> L14
        OLog.w(TAG, "Success to restart print job");     // Catch: Exception -> L14
        return;
    L24:
        return;
    L22:
        return;
    L14:
        e = move-exception;
        OLog.w(TAG, "Failed to restart print job", e);
    }

    private static boolean shouldShowToUser(PrintJobInfo r1) {
        int r2 = r1.getState();
        if (r2 != 2) goto L5;
        return true;
    L5:
        if (r2 != 3) goto L7;
        return true;
    L7:
        if (r2 != 4) goto L9;
        return true;
    L9:
        if (r2 == 6) goto L16;
        return false;
    L16:
        return true;
    }

    private List<MockPrintService> createMockPrintServices() {
        ArrayList r4 = new ArrayList();
        r4.add(new MockPrintService("系统打印服务", SYSTEM_PRINTSERVICE, true));
        r4.add(new MockPrintService("HP Print Service Plugin", "com.hp.android.printservice/.PrintService", true));
        r4.add(new MockPrintService("Canon Print Service", "jp.co.canon.android.printservice.plugin/.PrintService", false));
        r4.add(new MockPrintService("Epson Print Enabler", "com.epson.print/.PrintService", false));
        return r4;
    }

    private List<PrintJobInfo> createMockPrintJobs() {
        ArrayList r0 = new ArrayList();
        Object[][] r2 = {new Object[]{"年度报告.pdf", 2, "HP OfficeJet Pro 8720", 60000L, false}, new Object[]{"产品设计稿.png", 3, "Canon PIXMA TR8520", 180000L, false}, new Object[]{"财务报表.xlsx", 3, "Epson EcoTank ET-4760", 300000L, true}, new Object[]{"客户合同.docx", 4, "Brother MFC-L8900CDW", 600000L, false}, new Object[]{"发票_2024_01.pdf", 4, "Xerox VersaLink C405", 900000L, true}, new Object[]{"市场推广方案.pptx", 6, "Samsung Xpress C1860FW", 1800000L, false}, new Object[]{"员工手册.pdf", 6, "Kyocera ECOSYS M5526cdw", 3600000L, false}, new Object[]{"产品规格书.txt", 2, "Lexmark CX522ade", 7200000L, false}};
        int r3 = 0;
    L3:
        if (r3 >= 8) goto L8;
        Object[] r4 = r2[r3];
        PrintJobInfo r5 = createMockPrintJob((String) r4[0], ((Integer) r4[1]).intValue(), (String) r4[2], System.currentTimeMillis() - ((Long) r4[3]).longValue(), ((Boolean) r4[4]).booleanValue(), r3);
        if (r5 == null) goto L7;
        r0.add(r5);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return r0;
    }

    private PrintJobInfo createMockPrintJob(String r18, int r19, String r20, long r21, boolean r23, int r24) {
        String r0 = "state";
        String r2 = "label";
        Class<?> r5 = Class.forName("android.print.PrintJobInfo");     // Catch: Exception -> L117
        boolean r6 = true;
        int r7 = 0;
        Class<?> r8 = Class.forName("android.print.PrintJobInfo$Builder");     // Catch: ClassNotFoundException -> L26 Exception -> L117
        Constructor<?>[] r9 = r8.getConstructors();     // Catch: ClassNotFoundException -> L26 Exception -> L117
        int r10 = r9.length;     // Catch: ClassNotFoundException -> L26 Exception -> L117
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L19;
        Constructor<?> r12 = r9[r11];     // Catch: ClassNotFoundException -> L26 Exception -> L117
        Class<?>[] r13 = r12.getParameterTypes();     // Catch: ClassNotFoundException -> L26 Exception -> L117
        if (r13.length == 0) goto L9;
        if (r13.length != 1) goto L16;
        if (PrintJobInfo.class.isAssignableFrom(r13[0]) == false) goto L16;
        Object[] r14 = {null};     // Catch: ClassNotFoundException -> L26 Exception -> L117
    L20:
        if (r12 != null) goto L154;
    L27:
        PrintJobInfo r15 = null;
    L28:
        if (r15 == null) goto L150;
    L39:
        if (r15 == null) goto L173;
        Field[] r16 = r5.getDeclaredFields();     // Catch: Exception -> L117
        OLog.d(TAG, "PrintJobInfo fields count: " + r16.length);     // Catch: Exception -> L117
        int r17 = r16.length;     // Catch: Exception -> L117
        int r110 = 0;
    L41:
        if (r110 >= r17) goto L43;
        Field r111 = r16[r110];     // Catch: Exception -> L117
        OLog.d(TAG, "  Field: " + r111.getName() + " : " + r111.getType().getName());     // Catch: Exception -> L117
        r110 = r110 + 1;     // Catch: Exception -> L117
        goto L41
    L43:
        int r22 = r16.length;     // Catch: Exception -> L117
        boolean r112 = false;
        boolean r113 = false;
        boolean r114 = false;
        boolean r115 = false;
        boolean r116 = false;
    L44:
        if (r7 >= r22) goto L114;
        Field r117 = r16[r7];     // Catch: Exception -> L117
        String r4 = r117.getName();     // Catch: Exception -> L117
        r117.setAccessible(r6);     // Catch: Exception -> L117
        if (r112 == false) goto L48;
    L58:
        if (r113 == false) goto L60;
    L70:
        if (r114 == true) goto L86;
        if (r4.equals("mPrinterName") == true) goto L152;
        if (r4.equals("printerName") == true) goto L152;
        if (r4.contains("Printer") == true) goto L152;
        if (r4.contains("printer") == false) goto L86;
    L152:
        r117.set(r15, r20);     // Catch: Exception -> L129
        String r118 = r0;
        OLog.d(TAG, "Set printerName via field: " + r4);     // Catch: Exception -> L124
    L84:
        r114 = true;
    L88:
        if (r115 == false) goto L90;
    L100:
        if (r116 == true) goto L112;
        if (r23 == false) goto L112;
        if (r4.equals("mIsCancelling") == false) goto L105;
    L108:
        String r25 = r2;
        boolean r1 = true;
        r117.set(r15, true);     // Catch: Exception -> L128
        OLog.d(TAG, "Set isCancelling via field: " + r4);     // Catch: Exception -> L127
    L111:
        r116 = true;
    L113:
        r7 = r7 + 1;
        r2 = r25;
        r6 = r1;
        r0 = r118;
        goto L44
    L105:
        if (r4.equals("isCancelling") == true) goto L108;
        if (r4.contains("Cancell") == true) goto L108;
    L112:
        r25 = r2;
        r1 = true;
        goto L113
    L90:
        if (r4.equals("mCreationTime") == false) goto L92;
    L136:
        r117.set(r15, Long.valueOf(r21));     // Catch: Exception -> L126
        OLog.d(TAG, "Set creationTime via field: " + r4);     // Catch: Exception -> L125
    L99:
        r115 = true;
        goto L100
    L92:
        if (r4.equals("creationTime") == true) goto L136;
        if (r4.contains("Creation") == true) goto L136;
        if (r4.contains("Time") == false) goto L100;
    L85:
        r118 = r0;
    L86:
        r118 = r0;
        goto L88
    L60:
        if (r4.equals("mState") == false) goto L62;
    L146:
        r117.set(r15, Integer.valueOf(r19));     // Catch: Exception -> L123
        OLog.d(TAG, "Set state via field: " + r4);     // Catch: Exception -> L122
    L69:
        r113 = true;
        goto L70
    L62:
        if (r4.equals(r0) == true) goto L146;
        if (r4.equalsIgnoreCase(r0) == true) goto L146;
        if (r4.contains("State") == false) goto L70;
    L48:
        if (r4.equals("mLabel") == false) goto L50;
    L160:
        r117.set(r15, r18);     // Catch: Exception -> L121
        OLog.d(TAG, "Set label via field: " + r4);     // Catch: Exception -> L120
    L57:
        r112 = true;
        goto L58
    L50:
        if (r4.equals(r2) == true) goto L160;
        if (r4.equalsIgnoreCase(r2) == true) goto L160;
        if (r4.contains("Label") == false) goto L58;
    L114:
        OLog.d(TAG, "Job created - labelSet:" + r112 + " stateSet:" + r113 + " printerSet:" + r114 + " timeSet:" + r115);     // Catch: Exception -> L117
        return r15;
    L173:
        return null;
    L150:
        Constructor<?> r26 = r5.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L31 Exception -> L117
        r26.setAccessible(true);     // Catch: NoSuchMethodException -> L31 Exception -> L117
        r15 = (PrintJobInfo) r26.newInstance(new Object[0]);     // Catch: NoSuchMethodException -> L31 Exception -> L117
        goto L39
    L31:
        Constructor<?>[] r27 = r5.getDeclaredConstructors();     // Catch: Exception -> L117
        int r119 = r27.length;     // Catch: Exception -> L117
        int r120 = 0;
    L32:
        if (r120 >= r119) goto L39;
        Constructor<?> r121 = r27[r120];     // Catch: Exception -> L117
        r121.setAccessible(true);     // Catch: Exception -> L130
        PrintJobInfo r122 = (PrintJobInfo) r121.newInstance(new Object[r121.getParameterTypes().length]);     // Catch: Exception -> L130
        if (r122 != null) goto L36;
        r15 = r122;
        goto L38
    L36:
        r15 = r122;
    L38:
        r120 = r120 + 1;
        goto L32
    L154:
        r15 = (PrintJobInfo) r8.getMethod(IndexDatabaseHelper.MetaColumns.BUILD, new Class[0]).invoke(r12.newInstance(r14), new Object[0]);     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L26 Exception -> L117
    L24:
        OLog.w(TAG, "build() method not found");     // Catch: ClassNotFoundException -> L26 Exception -> L117
    L16:
        if (r13.length == 1) goto L17;
        r11 = r11 + 1;     // Catch: ClassNotFoundException -> L26 Exception -> L117
        goto L6
    L17:
        r14 = new Object[]{null};     // Catch: ClassNotFoundException -> L26 Exception -> L117
        goto L20
    L9:
        r14 = new Object[0];     // Catch: ClassNotFoundException -> L26 Exception -> L117
        goto L20
    L19:
        r14 = null;
        r12 = null;
    L26:
        OLog.w(TAG, "PrintJobInfo.Builder not found");     // Catch: Exception -> L117
    L117:
        e = move-exception;
        OLog.w(TAG, "Failed to create mock print job: " + r18, e);
        return null;
    }

    private String getTitle(final Context r3, UserHandle r4, UserManager r5) {
        DevicePolicyResourcesManager r2 = ((DevicePolicyManager) Objects.requireNonNull((DevicePolicyManager) r3.getSystemService(DevicePolicyManager.class))).getResources();
        int r6 = r4.getIdentifier();
        if (r6 == (-2)) goto L24;
        if (r6 == ActivityManager.getCurrentUser()) goto L24;
        if (r5.isManagedProfile(r6) == false) goto L12;
        return r2.getString("Settings.WORK_CATEGORY_HEADER", new PrintSettingsFragment$$ExternalSyntheticLambda10(r3));
    L12:
        if (Flags.allowPrivateProfile() == true) goto L14;
    L21:
        OLog.w(TAG, "title requested for unexpected user id " + r6);
        return r2.getString("Settings.PERSONAL_CATEGORY_HEADER", new PrintSettingsFragment$$ExternalSyntheticLambda1(r3));
    L14:
        if (android.multiuser.Flags.enablePrivateSpaceFeatures() == false) goto L21;
        if (android.multiuser.Flags.handleInterleavedSettingsForPrivateSpace() == false) goto L21;
        if (r5.getUserInfo(r6).isPrivateProfile() == false) goto L21;
        return r2.getString("Settings.PRIVATE_CATEGORY_HEADER", new PrintSettingsFragment$$ExternalSyntheticLambda11(r3));
    L24:
        return r2.getString("Settings.PERSONAL_CATEGORY_HEADER", new PrintSettingsFragment$$ExternalSyntheticLambda9(r3));
    }

    static /* synthetic */ String lambda$getTitle$8(Context r1) {
        return r1.getString(R.string.category_personal);
    }

    static /* synthetic */ String lambda$getTitle$9(Context r1) {
        return r1.getString(R.string.category_work);
    }

    static /* synthetic */ String lambda$getTitle$10(Context r1) {
        return r1.getString(R.string.category_private);
    }

    static /* synthetic */ String lambda$getTitle$11(Context r1) {
        return r1.getString(R.string.category_personal);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_print_PrintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PrintSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_print_PrintSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_print_PrintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PrintSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_print_PrintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_print_PrintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PrintSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_print_PrintSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
