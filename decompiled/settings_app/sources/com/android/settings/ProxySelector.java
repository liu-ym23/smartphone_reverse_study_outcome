package com.android.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.android.net.module.util.ProxyUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ProxySelector extends InstrumentedFragment implements DialogCreatable {
    private static final int ERROR_DIALOG_ID = 0;
    public static final Pattern EXCLUSION_PATTERN = null;
    public static final String EXCLUSION_REGEXP = "$|^(\\*)?\\.?[a-zA-Z0-9\\_]+(\\-[a-zA-Z0-9\\_]+)*(\\.[a-zA-Z0-9\\_]+(\\-[a-zA-Z0-9\\_]+)*)*$";
    private static final String HC = "a-zA-Z0-9\\_";
    public static final Pattern HOSTNAME_PATTERN = null;
    private static final String HOSTNAME_REGEXP = "^$|^[a-zA-Z0-9\\_]+(\\-[a-zA-Z0-9\\_]+)*(\\.[a-zA-Z0-9\\_]+(\\-[a-zA-Z0-9\\_]+)*)*$";
    private static final String TAG = "ProxySelector";
    Button mClearButton;
    View.OnClickListener mClearHandler;
    Button mDefaultButton;
    View.OnClickListener mDefaultHandler;
    private SettingsPreferenceFragment.SettingsDialogFragment mDialogFragment;
    EditText mExclusionListField;
    EditText mHostnameField;
    Button mOKButton;
    View.OnClickListener mOKHandler;
    View.OnFocusChangeListener mOnFocusChangeHandler;
    EditText mPortField;
    private View mView;

    public void com_android_settings_ProxySelector__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ProxySelector_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ProxySelector_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ProxySelector() {
        this.mOKHandler = new AnonymousClass1(this);
        this.mClearHandler = new AnonymousClass2(this);
        this.mDefaultHandler = new AnonymousClass3(this);
        this.mOnFocusChangeHandler = new AnonymousClass4(this);
    }

    static {
        HOSTNAME_PATTERN = Pattern.compile(HOSTNAME_REGEXP);
        EXCLUSION_PATTERN = Pattern.compile(EXCLUSION_REGEXP);
    }

    public void com_android_settings_ProxySelector__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(R.layout.proxy, r3, false);
        this.mView = r5;
        initView(r5);
        populateFields();
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        if (((DevicePolicyManager) getActivity().getSystemService("device_policy")).getGlobalProxyAdmin() != null) goto L5;
        boolean r3 = true;
    L6:
        this.mHostnameField.setEnabled(r3);
        this.mPortField.setEnabled(r3);
        this.mExclusionListField.setEnabled(r3);
        this.mOKButton.setEnabled(r3);
        this.mClearButton.setEnabled(r3);
        this.mDefaultButton.setEnabled(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.android.settings.DialogCreatable
    public Dialog onCreateDialog(int r5) {
        if (r5 != 0) goto L10;
        String r6 = this.mHostnameField.getText().toString().trim();
        String r1 = this.mPortField.getText().toString().trim();
        String r2 = this.mExclusionListField.getText().toString().trim();
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L7;
        String r7 = r3.getString(validate(r6, r1, r2));
    L9:
        return new AlertDialog.Builder(getActivity(), getResources().getInteger(R.integer.dialog_style_id)).setTitle(R.string.proxy_error).setPositiveButton(R.string.proxy_error_dismiss, null).setMessage(r7).create();
    L7:
        r7 = "";
        goto L9
    L10:
        return null;
    }

    private void showDialog(int r3) {
        if (this.mDialogFragment == null) goto L5;
        OLog.e(TAG, "Old dialog fragment not null!");
    L5:
        SettingsPreferenceFragment.SettingsDialogFragment r0 = new SettingsPreferenceFragment.SettingsDialogFragment(this, r3);
        this.mDialogFragment = r0;
        r0.show(getChildFragmentManager(), Integer.toString(r3));
    }

    private void initView(View r3) {
        EditText r0 = (EditText) r3.findViewById(R.id.hostname);
        this.mHostnameField = r0;
        r0.setOnFocusChangeListener(this.mOnFocusChangeHandler);
        EditText r1 = (EditText) r3.findViewById(R.id.port);
        this.mPortField = r1;
        r1.setOnClickListener(this.mOKHandler);
        this.mPortField.setOnFocusChangeListener(this.mOnFocusChangeHandler);
        EditText r2 = (EditText) r3.findViewById(R.id.exclusionlist);
        this.mExclusionListField = r2;
        r2.setOnFocusChangeListener(this.mOnFocusChangeHandler);
        Button r4 = (Button) r3.findViewById(R.id.action);
        this.mOKButton = r4;
        r4.setOnClickListener(this.mOKHandler);
        Button r5 = (Button) r3.findViewById(R.id.clear);
        this.mClearButton = r5;
        r5.setOnClickListener(this.mClearHandler);
        Button r6 = (Button) r3.findViewById(R.id.defaultView);
        this.mDefaultButton = r6;
        r6.setOnClickListener(this.mDefaultHandler);
    }

    void populateFields() {
        FragmentActivity r0 = getActivity();
        ProxyInfo r1 = ((ConnectivityManager) getActivity().getSystemService("connectivity")).getGlobalProxy();
        String r2 = "";
        if (r1 == null) goto L5;
        String r4 = r1.getHost();
        int r5 = r1.getPort();
        String r3 = r1.getExclusionListAsString();
    L6:
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        this.mHostnameField.setText(r4);
        if (r5 == (-1)) goto L12;
        r2 = Integer.toString(r5);
    L12:
        this.mPortField.setText(r2);
        this.mExclusionListField.setText(r3);
        Intent r6 = r0.getIntent();
        String r7 = r6.getStringExtra("button-label");
        if (TextUtils.isEmpty(r7) == true) goto L15;
        this.mOKButton.setText(r7);
    L15:
        String r8 = r6.getStringExtra("title");
        if (TextUtils.isEmpty(r8) == true) goto L19;
        r0.setTitle(r8);
        return;
    L19:
        return;
    L5:
        r3 = "";
        r4 = r3;
        r5 = -1;
        goto L6
    }

    public static int validate(String r0, String r1, String r2) {
        int r3 = ProxyUtils.validate(r0, r1, r2);
        if (r3 != 0) goto L5;
        return 0;
    L5:
        if (r3 != 1) goto L7;
        return R.string.proxy_error_empty_host_set_port;
    L7:
        if (r3 != 2) goto L9;
        return R.string.proxy_error_invalid_host;
    L9:
        if (r3 != 3) goto L11;
        return R.string.proxy_error_empty_port;
    L11:
        if (r3 != 4) goto L13;
        return R.string.proxy_error_invalid_port;
    L13:
        if (r3 == 5) goto L16;
        OLog.e(TAG, "Unknown proxy settings error");
        return -1;
    L16:
        return R.string.proxy_error_invalid_exclusion_list;
    }

    boolean saveToDb() {
        String r0 = this.mHostnameField.getText().toString().trim();
        String r1 = this.mPortField.getText().toString().trim();
        String r2 = this.mExclusionListField.getText().toString().trim();
        int r4 = 0;
        if (validate(r0, r1, r2) == 0) goto L7;
        showDialog(0);
        return false;
    L7:
        if (r1.length() > 0) goto L13;
    L11:
        ProxyInfo r3 = new ProxyInfo(r0, r4, r2);
        ((ConnectivityManager) getActivity().getSystemService("connectivity")).setGlobalProxy(r3);
        return true;
    L13:
        r4 = Integer.parseInt(r1);     // Catch: NumberFormatException -> L10
    L10:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ProxySelector_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ProxySelector r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ProxySelector__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ProxySelector_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ProxySelector r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ProxySelector_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ProxySelector_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ProxySelector r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ProxySelector__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
