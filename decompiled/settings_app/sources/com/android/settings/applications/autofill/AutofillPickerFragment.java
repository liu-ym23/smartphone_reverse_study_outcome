package com.android.settings.applications.autofill;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.content.PackageMonitor;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OListItemCheck;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AutofillPickerFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private static final String AUTOFILL_ACTION = "android.service.autofill.AutofillService";
    public static final String EXTRA_PACKAGE_NAME = "package_name";
    private final int MSG_UPDATE;
    private AutofillAppAdapter mAdapter;
    private List<AutofillServiceApp> mAutofillServiceApps;
    private int mCheckedPosition;
    private OAlertDialog mConfirmDialog;
    private final Handler mHandler;
    private ListView mListView;
    private final PackageMonitor mSettingsPackageMonitor;

    private class AutofillAppAdapter extends BaseAdapter {
        final /* synthetic */ AutofillPickerFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private AutofillAppAdapter(AutofillPickerFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AutofillAppAdapter(AutofillPickerFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (AutofillPickerFragment.access$700(this.this$0) != null) goto L6;
            return 0;
        L6:
            return AutofillPickerFragment.access$700(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public AutofillServiceApp getItem(int r1) {
            return (AutofillServiceApp) AutofillPickerFragment.access$700(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            boolean r0 = false;
            if (r6 != null) goto L5;
            r6 = LayoutInflater.from(this.this$0.getActivity()).inflate(R.layout.olist_content_item_check, r7, false);
            OListItemCheck r8 = (OListItemCheck) r6.findViewById(R.id.item_check);
            r6.setTag(r8);
        L6:
            AutofillServiceApp r1 = getItem(r5);
            r8.setTrailingImageView(this.this$0.mContext.getDrawable(R.drawable.icon_check_confirm_rounded));
            r8.setTitle(r1.mLabel.toString());
            if (r5 != AutofillPickerFragment.access$400(this.this$0)) goto L9;
            r0 = true;
        L9:
            r8.setChecked(r0);
            return r6;
        L5:
            r8 = (OListItemCheck) r6.getTag();
            goto L6
        }
    }

    private static class AutofillServiceApp {
        ComponentName mComponentName;
        CharSequence mLabel;

        private AutofillServiceApp() {
        }

        /* synthetic */ AutofillServiceApp(AnonymousClass1 r1) {
            this();
        }
    }

    public void com_android_settings_applications_autofill_AutofillPickerFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_applications_autofill_AutofillPickerFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.autofill_app;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_autofill_AutofillPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_autofill_AutofillPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(AutofillPickerFragment r0) {
        r0.update();
    }

    static /* synthetic */ Handler access$100(AutofillPickerFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ int access$400(AutofillPickerFragment r0) {
        return r0.mCheckedPosition;
    }

    static /* synthetic */ int access$402(AutofillPickerFragment r0, int r1) {
        r0.mCheckedPosition = r1;
        return r1;
    }

    static /* synthetic */ AutofillAppAdapter access$500(AutofillPickerFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ void access$600(Context r0, ComponentName r1) {
        setAutofillService(r0, r1);
    }

    static /* synthetic */ List access$700(AutofillPickerFragment r0) {
        return r0.mAutofillServiceApps;
    }

    public AutofillPickerFragment() {
        super(R.layout.options_layout);
        this.mCheckedPosition = -1;
        this.MSG_UPDATE = 1;
        this.mHandler = new AnonymousClass1(this);
        this.mSettingsPackageMonitor = new AnonymousClass2(this);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        TextView r6 = new TextView(getActivity());
        r6.setTextSize(20.0f);
        r6.setText("Test Provider Service Alternate");
        r6.setId(android.R.id.text1);
        r6.setContentDescription("Test Provider Service Alternate");
        ViewGroup.MarginLayoutParams r0 = new ViewGroup.MarginLayoutParams(1, 1);
        r0.topMargin = Utils.dp2Pixels(getActivity(), 200.0f);
        r6.setLayoutParams(r0);
        ((ViewGroup) r4).addView(r6);
        this.mListView = (ListView) findViewByIdNullable(R.id.options_list);
        View r7 = Utils.inflateListTransparentHeader(this.mContext);
        r7.setMinimumHeight(ResourceUtils.getResources().getDimensionPixelSize(R.dimen.top_gap));
        this.mListView.addHeaderView(r7);
        this.mListView.setOnItemClickListener(this);
        this.mSettingsPackageMonitor.register(this.mContext, Looper.getMainLooper(), false);
        update();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mSettingsPackageMonitor.unregister();
    }

    private void update() {
        OAlertDialog r0 = this.mConfirmDialog;
        if (r0 != null) goto L5;
    L7:
        fetchAutofillServices();
        AutofillAppAdapter r1 = this.mAdapter;
        if (r1 != null) goto L10;
        AutofillAppAdapter r2 = new AutofillAppAdapter(this, null);
        this.mAdapter = r2;
        this.mListView.setAdapter(r2);
        return;
    L10:
        r1.notifyDataSetChanged();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mConfirmDialog.dismiss();
        goto L7
    }

    private void fetchAutofillServices() {
        ArrayList r0 = new ArrayList();
        String r1 = getCurrentAutofillService(this.mContext);
        AnonymousClass1 r3 = null;
        AutofillServiceApp r2 = new AutofillServiceApp(r3);
        r2.mLabel = getString(R.string.app_list_preference_none);
        r0.add(r2);
        int r4 = 0;
        if (r1 != null) goto L5;
        int r5 = 0;
    L6:
        PackageManager r6 = getPackageManager();
        List<ResolveInfo> r7 = r6.queryIntentServices(new Intent(AUTOFILL_ACTION), 128);
        if (r7 == null) goto L19;
        Iterator<ResolveInfo> r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L19;
        ResolveInfo r9 = r8.next();
        if ("android.permission.BIND_AUTOFILL_SERVICE".equals(r9.serviceInfo.permission) == false) goto L10;
        AutofillServiceApp r10 = new AutofillServiceApp(r3);
        r10.mComponentName = new ComponentName(r9.serviceInfo.packageName, r9.serviceInfo.name);
        r10.mLabel = r9.loadLabel(r6);
        r0.add(r10);
        if (r1 == null) goto L10;
        if (r1.equals(r10.mComponentName.flattenToString()) == false) goto L10;
        r5 = r0.size() - 1;
    L19:
        if (r5 == (-1)) goto L22;
        r4 = r5;
    L22:
        this.mCheckedPosition = r4;
        this.mAutofillServiceApps = r0;
        return;
    L5:
        r5 = -1;
        goto L6
    }

    private static void setAutofillService(Context r1, ComponentName r2) {
        if (r2 != null) goto L4;
        String r3 = null;
    L5:
        Settings.Secure.putString(r1.getContentResolver(), "autofill_service", r3);
        return;
    L4:
        r3 = r2.flattenToString();
        goto L5
    }

    public static String getCurrentAutofillService(Context r1) {
        String r2 = Settings.Secure.getString(r1.getContentResolver(), "autofill_service");
        if (r2 == null) goto L8;
        ComponentName r3 = ComponentName.unflattenFromString(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.flattenToString();
    L8:
        return null;
    }

    public static CharSequence getCurrentAutofillServiceAppLabel(Context r4) {
        String r0 = getCurrentAutofillService(r4);
        if (r0 != null) goto L5;
        ComponentName r1 = null;
    L6:
        String r2 = r4.getString(R.string.app_list_preference_none);
        if (r1 != null) goto L9;
        return r2;
    L9:
        PackageManager r5 = r4.getPackageManager();
        ResolveInfo r3 = r5.resolveService(new Intent(AUTOFILL_ACTION).setComponent(r1), 128);
        if (r3 != null) goto L13;
        return r2;
    L13:
        return r3.loadLabel(r5);
    L5:
        r1 = ComponentName.unflattenFromString(r0);
        goto L6
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r3, View r4, int r5, long r6) {
        int r7 = r5 - this.mListView.getHeaderViewsCount();
        if (r7 >= 0) goto L5;
        return;
    L5:
        if (r7 <= (this.mAdapter.getCount() - 1)) goto L8;
        return;
    L8:
        if (r7 != this.mCheckedPosition) goto L10;
        return;
    L10:
        OAlertDialog r8 = this.mConfirmDialog;
        if (r8 != null) goto L13;
    L15:
        final int r9 = this.mCheckedPosition;
        this.mCheckedPosition = r7;
        this.mAdapter.notifyDataSetChanged();
        if (r7 != 0) goto L19;
        setAutofillService(this.mContext, null);
        return;
    L19:
        FragmentActivity r10 = getActivity();
        if (r10 != null) goto L23;
        OLog.e(this.TAG, "onItemClick, activity is null, return");
        return;
    L23:
        final AutofillServiceApp r11 = this.mAdapter.getItem(r7);
        OAlertDialog r12 = (OAlertDialog) new OAlertDialogBuilder(r10).autoDismiss(false).title(R.string.warning).message(getString(R.string.autofill_confirm_msg, new Object[]{r11.mLabel})).horizontalButton(true).negativeButton(R.string.cancel, new AnonymousClass5(this, r9)).positiveButton(R.string.okay, new AnonymousClass4(this, r11)).onCancel(new AnonymousClass3(this, r9)).createDialog();
        this.mConfirmDialog = r12;
        if ((r12.rootView instanceof ViewGroup) == false) goto L26;
        ViewGroup r13 = (ViewGroup) this.mConfirmDialog.rootView;
        View r14 = LayoutInflater.from(getActivity()).inflate(R.layout.cts_alert_dialog, r13, false);
        ((TextView) r14.findViewById(android.R.id.message)).setText(getString(R.string.cts_alert_dialog_message, new Object[]{r11.mLabel}));
        r13.addView(r14);
    L26:
        this.mConfirmDialog.show();
        return;
    L13:
        if (r8.isShowing() == false) goto L15;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_autofill_AutofillPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AutofillPickerFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_autofill_AutofillPickerFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_autofill_AutofillPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AutofillPickerFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_autofill_AutofillPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_autofill_AutofillPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AutofillPickerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_autofill_AutofillPickerFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
