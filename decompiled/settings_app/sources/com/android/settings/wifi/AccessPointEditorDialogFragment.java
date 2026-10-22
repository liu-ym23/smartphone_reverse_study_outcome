package com.android.settings.wifi;

import android.app.Dialog;
import android.net.NetworkUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.ProxySelector;
import com.android.settings.R;
import com.android.settings.applications.utils.ODialogUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.forms.OInputView;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class AccessPointEditorDialogFragment extends DialogFragment implements TextWatcher {
    private static final String TAG = "com.android.settings.wifi.AccessPointEditorDialogFragment";
    private CharSequence mContent;
    private OSimpleFormDialog mDialog;
    private EditText mEditor;
    private Handler mHandler;
    private View.OnClickListener mListener;
    private OButton mPositiveButton;
    private int mTag;
    private CharSequence mTitle;

    static {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public void com_android_settings_wifi_AccessPointEditorDialogFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_wifi_AccessPointEditorDialogFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_AccessPointEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_AccessPointEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public AccessPointEditorDialogFragment() {
    }

    static /* synthetic */ View.OnClickListener access$000(AccessPointEditorDialogFragment r0) {
        return r0.mListener;
    }

    static /* synthetic */ EditText access$100(AccessPointEditorDialogFragment r0) {
        return r0.mEditor;
    }

    static /* synthetic */ OSimpleFormDialog access$200(AccessPointEditorDialogFragment r0) {
        return r0.mDialog;
    }

    static /* synthetic */ OButton access$300(AccessPointEditorDialogFragment r0) {
        return r0.mPositiveButton;
    }

    public void init(int r1, CharSequence r2, CharSequence r3, View.OnClickListener r4) {
        this.mTag = r1;
        this.mTitle = r2;
        this.mContent = r3;
        this.mListener = r4;
        this.mHandler = new Handler();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r12) {
        ODialogUtils r0 = ODialogUtils.INSTANCE;
        FragmentActivity r1 = getActivity();
        CharSequence r13 = this.mTitle;
        if (r13 != null) goto L5;
        String r14 = "";
    L6:
        OSimpleFormDialog r15 = r0.getMiscDialog(r1, r14, "", getActivity().getString(R.string.wifi_save), getActivity().getString(R.string.cancel), "", "", false, new AnonymousClass1(this), new AnonymousClass2(this));
        OInputLayout r2 = (OInputLayout) ((ViewGroup) r15.findViewById(R.id.simple_form_input_1_container)).getChildAt(0);
        r2.showClear(true);
        this.mEditor = r2.getVInput();
        setupEditor(this.mContent);
        this.mPositiveButton = (OButton) r15.findViewById(R.id.actionPositive);
        updateSaveButtonEnableState();
        this.mDialog = r15;
        r15.getWindow().setSoftInputMode(37);
        return this.mDialog;
    L5:
        r14 = r13.toString();
        goto L6
    }

    private View createDialogView(CharSequence r4) {
        View r0 = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.dialog_edittext, null);
        this.mEditor = ((OInputView) r0.findViewById(R.id.edittext)).getVInput();
        setupEditor(r4);
        return r0;
    }

    private void setupEditor(CharSequence r3) {
        switch(this.mTag) {
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L7;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L6;
            case 16: goto L5;
            case 17: goto L5;
            case 18: goto L4;
            case 19: goto L7;
            default: goto L4;
        };
    L4:
        int r0 = 1;
    L8:
        setHintForEditor();
        this.mEditor.setInputType(r0);
        this.mEditor.addTextChangedListener(this);
        if (TextUtils.isEmpty(r3) == true) goto L12;
        this.mEditor.setText(r3);
        this.mEditor.setSelection(0, r3.length());
        return;
    L12:
        return;
    L5:
        r0 = 3;
        goto L8
    L6:
        r0 = 2;
        goto L8
    L7:
        r0 = 16;
        goto L8
    }

    private void setHintForEditor() {
        switch(this.mTag) {
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L6;
            case 18: goto L4;
            case 19: goto L5;
            default: goto L4;
        };
    L4:
        int r0 = -1;
    L14:
        if (r0 == (-1)) goto L17;
        this.mEditor.setHint(r0);
        return;
    L17:
        return;
    L5:
        r0 = R.string.wifi_proxy_hint;
        goto L14
    L6:
        r0 = R.string.wifi_dns2_hint;
        goto L14
    L7:
        r0 = R.string.wifi_dns1_hint;
        goto L14
    L8:
        r0 = R.string.wifi_network_prefix_length_hint;
        goto L14
    L9:
        r0 = R.string.wifi_gateway_hint;
        goto L14
    L10:
        r0 = R.string.wifi_ip_address_hint;
        goto L14
    L11:
        r0 = R.string.proxy_exclusionlist_hint;
        goto L14
    L12:
        r0 = R.string.proxy_port_hint;
        goto L14
    L13:
        r0 = R.string.proxy_hostname_hint;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EditText r0 = this.mEditor;
        if (r0 == null) goto L5;
        r0.removeTextChangedListener(this);
    L5:
        this.mDialog = null;
        this.mListener = null;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
        updateSaveButtonEnableState();
    }

    private void updateSaveButtonEnableState() {
        final boolean r0 = isInputContentValid(this.mEditor.getText().toString());
        Handler r1 = this.mHandler;
        if (r1 == null) goto L6;
        r1.post(new AnonymousClass3(this, r0));
        return;
    }

    private boolean isInputContentValid(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L8;
        if (this.mTag == 12) goto L8;
        return false;
    L8:
        switch(this.mTag) {
            case 10: goto L27;
            case 11: goto L25;
            case 12: goto L23;
            case 13: goto L21;
            case 14: goto L19;
            case 15: goto L17;
            case 16: goto L15;
            case 17: goto L13;
            case 18: goto L9;
            case 19: goto L11;
            default: goto L9;
        };
    L9:
        return false;
    L11:
        return isProxyPacValid(r4);
    L13:
        return isDnsValid(r4);
    L15:
        return isDnsValid(r4);
    L17:
        return isNetworkPrefixLengthValid(r4);
    L19:
        return isGatewayValid(r4);
    L21:
        return isIpAddressValid(r4);
    L23:
        return isProxyExclusionValid(r4);
    L25:
        return isProxyPortValid(r4);
    L27:
        return isProxyHostValid(r4);
    }

    private boolean isIpAddressValid(String r2) {
        NetworkUtils.numericToInetAddress(r2);     // Catch: IllegalArgumentException -> L5
        return true;
    L5:
        e = move-exception;
        OLog.d(TAG, "", e.fillInStackTrace());
        return false;
    }

    private boolean isGatewayValid(String r1) {
        NetworkUtils.numericToInetAddress(r1);     // Catch: IllegalArgumentException -> L5
        return true;
    L5:
        return false;
    }

    private boolean isNetworkPrefixLengthValid(String r2) {
        int r3 = Integer.parseInt(r2);     // Catch: NumberFormatException -> L10
        if (r3 >= 0) goto L6;
        return false;
    L6:
        if (r3 > 32) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    private boolean isDnsValid(String r1) {
        NetworkUtils.numericToInetAddress(r1);     // Catch: IllegalArgumentException -> L5
        return true;
    L5:
        return false;
    }

    private boolean isProxyHostValid(String r1) {
        if (ProxySelector.HOSTNAME_PATTERN.matcher(r1).matches() == true) goto L6;
        return false;
    L6:
        return true;
    }

    private boolean isProxyPortValid(String r2) {
        int r3 = Integer.parseInt(r2);     // Catch: NumberFormatException -> L10
        if (r3 > 0) goto L6;
        return false;
    L6:
        if (r3 > 65535) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    private boolean isProxyExclusionValid(String r5) {
        String[] r4 = r5.split(",");
        int r6 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L8;
        if (ProxySelector.EXCLUSION_PATTERN.matcher(r4[r1]).matches() == false) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private boolean isProxyPacValid(String r1) {
        if (Uri.parse(r1) != null) goto L6;
        return false;
    L6:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_AccessPointEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccessPointEditorDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_AccessPointEditorDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_AccessPointEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccessPointEditorDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_AccessPointEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_AccessPointEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccessPointEditorDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_AccessPointEditorDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
