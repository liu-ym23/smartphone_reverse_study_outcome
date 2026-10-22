package com.android.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.DialogFragment;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.android.internal.util.ArrayUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.mobile.dataservice.DataServiceUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.olog.OLog;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.privacy.GrantUtil;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.obex.ObexHelper;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ApnEditor extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {
    private static final int APN_INDEX = 2;
    public static final String[] APN_TYPES = null;
    public static final String APN_TYPE_ALL = "*";
    public static final String APN_TYPE_CBS = "cbs";
    public static final String APN_TYPE_DEFAULT = "default";
    public static final String APN_TYPE_DUN = "dun";
    public static final String APN_TYPE_EMERGENCY = "emergency";
    public static final String APN_TYPE_FOTA = "fota";
    public static final String APN_TYPE_HIPRI = "hipri";
    public static final String APN_TYPE_IA = "ia";
    public static final String APN_TYPE_IMS = "ims";
    public static final String APN_TYPE_MCX = "mcx";
    public static final String APN_TYPE_MMS = "mms";
    public static final String APN_TYPE_SUPL = "supl";
    public static final String APN_TYPE_XCAP = "xcap";
    private static final int AUTH_TYPE_INDEX = 14;
    private static final int BEARER_BITMASK_INDEX = 19;
    private static final int BEARER_INDEX = 18;
    private static final int CARRIER_ENABLED_INDEX = 17;
    protected static final String EDIT_ACTION = "edit_action";
    protected static final String EDIT_DATA = "edit_data";
    private static final int ID_INDEX = 0;
    private static final String KEY_AUTH_TYPE = "auth_type";
    private static final String KEY_BEARER_MULTI = "bearer_multi";
    private static final String KEY_CARRIER_ENABLED = "carrier_enabled";
    private static final String KEY_MVNO_TYPE = "mvno_type";
    private static final String KEY_PROTOCOL = "apn_protocol";
    private static final String KEY_ROAMING_PROTOCOL = "apn_roaming_protocol";
    private static final int MCC_INDEX = 9;
    private static final int MENU_CANCEL = 3;
    private static final int MENU_DELETE = 1;
    private static final int MENU_SAVE = 2;
    private static final int MMSC_INDEX = 8;
    private static final int MMSPORT_INDEX = 13;
    private static final int MMSPROXY_INDEX = 12;
    private static final int MNC_INDEX = 10;
    private static final int MVNO_MATCH_DATA_INDEX = 22;
    private static final int MVNO_TYPE_INDEX = 21;
    private static final int NAME_INDEX = 1;
    private static final int PASSWORD_INDEX = 7;
    private static final int PORT_INDEX = 4;
    private static final int PROTOCOL_INDEX = 16;
    private static final String PROTOCOL_IPV4V6 = "IPV4V6";
    private static final int PROXY_INDEX = 3;
    private static final int ROAMING_PROTOCOL_INDEX = 20;
    private static final String SAVED_POS = "pos";
    private static final int SERVER_INDEX = 6;
    private static final String TAG = "ApnEditor";
    private static final int TYPE_INDEX = 15;
    private static final int USER_EDITABLE_INDEX = 23;
    private static final int USER_INDEX = 5;
    private static String sNotSet;
    private static final String[] sProjection = null;
    private EditTextPreference mApn;
    private EditTextPreference mApnType;
    private ListPreference mAuthType;
    private int mBearerInitialVal;
    private MultiSelectListPreference mBearerMulti;
    private SwitchPreference mCarrierEnabled;
    private String mCurMcc;
    private String mCurMnc;
    private Cursor mCursor;
    private boolean mDisableEditor;
    private boolean mFirstTime;
    private EditTextPreference mMcc;
    private EditTextPreference mMmsPort;
    private EditTextPreference mMmsProxy;
    private EditTextPreference mMmsc;
    private EditTextPreference mMnc;
    private EditTextPreference mMvnoMatchData;
    private String mMvnoMatchDataStr;
    private ListPreference mMvnoType;
    private String mMvnoTypeStr;
    private EditTextPreference mName;
    private boolean mNewApn;
    private EditTextPreference mPassword;
    private EditTextPreference mPort;
    private ListPreference mProtocol;
    private EditTextPreference mProxy;
    private Resources mRes;
    private ListPreference mRoamingProtocol;
    private EditTextPreference mServer;
    private int mSubId;
    private TelephonyManager mTelephonyManager;
    private Uri mUri;
    private EditTextPreference mUser;

    public static class ErrorDialog extends DialogFragment {
        public void com_android_settings_ApnEditor$ErrorDialog__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_ApnEditor$ErrorDialog__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_ApnEditor$ErrorDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_ApnEditor$ErrorDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ErrorDialog() {
        }

        public static void showError(ApnEditor r2) {
            ErrorDialog r0 = new ErrorDialog();
            r0.setTargetFragment(r2, 0);
            r0.show(r2.getParentFragmentManager(), "error");
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r3) {
            String r4 = ApnEditor.access$000((ApnEditor) getTargetFragment());
            return new AlertDialog.Builder(getContext()).setTitle(R.string.error_title).setPositiveButton(android.R.string.ok, null).setMessage(r4).create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_ApnEditor$ErrorDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ErrorDialog r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ApnEditor$ErrorDialog__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ApnEditor$ErrorDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ErrorDialog r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_ApnEditor$ErrorDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ApnEditor$ErrorDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ErrorDialog r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ApnEditor$ErrorDialog__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ApnEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ApnEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ApnEditor() {
        this.mDisableEditor = false;
        this.mBearerInitialVal = 0;
    }

    static /* synthetic */ String access$000(ApnEditor r0) {
        return r0.getErrorMsg();
    }

    static {
        APN_TYPES = new String[]{"default", APN_TYPE_MMS, APN_TYPE_SUPL, APN_TYPE_DUN, APN_TYPE_HIPRI, APN_TYPE_FOTA, APN_TYPE_IMS, APN_TYPE_CBS, APN_TYPE_IA, APN_TYPE_EMERGENCY, APN_TYPE_MCX, APN_TYPE_XCAP};
        sProjection = new String[]{"_id", "name", "apn", "proxy", ClientCookie.PORT_ATTR, PickApplicationActivity.EXTRA_USER, "server", "password", "mmsc", DataServiceUtils.SubscriptionInfoData.COLUMN_MCC, DataServiceUtils.SubscriptionInfoData.COLUMN_MNC, "numeric", "mmsproxy", "mmsport", "authtype", "type", "protocol", KEY_CARRIER_ENABLED, "bearer", "bearer_bitmask", "roaming_protocol", "mvno_type", ApnSettings.MVNO_MATCH_DATA, "user_editable"};
    }

    public void com_android_settings_ApnEditor__onCreate$___twin___(Bundle r11) {
        super.onCreate(r11);
        addPreferencesFromResource(R.xml.apn_editor);
        sNotSet = getResources().getString(R.string.apn_not_set);
        this.mName = (EditTextPreference) findPreference("apn_name");
        this.mApn = (EditTextPreference) findPreference("apn_apn");
        this.mProxy = (EditTextPreference) findPreference("apn_http_proxy");
        this.mPort = (EditTextPreference) findPreference("apn_http_port");
        this.mUser = (EditTextPreference) findPreference("apn_user");
        this.mServer = (EditTextPreference) findPreference("apn_server");
        this.mPassword = (EditTextPreference) findPreference("apn_password");
        this.mMmsProxy = (EditTextPreference) findPreference("apn_mms_proxy");
        this.mMmsPort = (EditTextPreference) findPreference("apn_mms_port");
        this.mMmsc = (EditTextPreference) findPreference("apn_mmsc");
        this.mMcc = (EditTextPreference) findPreference("apn_mcc");
        this.mMnc = (EditTextPreference) findPreference("apn_mnc");
        this.mApnType = (EditTextPreference) findPreference("apn_type");
        ListPreference r0 = (ListPreference) findPreference(KEY_AUTH_TYPE);
        this.mAuthType = r0;
        r0.setOnPreferenceChangeListener(this);
        ListPreference r1 = (ListPreference) findPreference(KEY_PROTOCOL);
        this.mProtocol = r1;
        r1.setOnPreferenceChangeListener(this);
        ListPreference r2 = (ListPreference) findPreference(KEY_ROAMING_PROTOCOL);
        this.mRoamingProtocol = r2;
        r2.setOnPreferenceChangeListener(this);
        this.mCarrierEnabled = (SwitchPreference) findPreference(KEY_CARRIER_ENABLED);
        MultiSelectListPreference r3 = (MultiSelectListPreference) findPreference(KEY_BEARER_MULTI);
        this.mBearerMulti = r3;
        r3.setOnPreferenceChangeListener(this);
        ListPreference r4 = (ListPreference) findPreference("mvno_type");
        this.mMvnoType = r4;
        r4.setOnPreferenceChangeListener(this);
        this.mMvnoMatchData = (EditTextPreference) findPreference(ApnSettings.MVNO_MATCH_DATA);
        this.mRes = getResources();
        Intent r5 = getIntent();
        String r6 = r5.getAction();
        this.mSubId = r5.getIntExtra(ApnSettings.SUB_ID, -1);
        int r7 = 0;
        boolean r8 = r5.getBooleanExtra("DISABLE_EDITOR", false);
        this.mDisableEditor = r8;
        if (r8 == false) goto L6;
        getPreferenceScreen().setEnabled(false);
        OLog.d(TAG, "ApnEditor form is disabled.");
    L6:
        if (r11 != null) goto L8;
        boolean r9 = true;
    L9:
        this.mFirstTime = r9;
        if (r6.equals("android.intent.action.EDIT") == false) goto L17;
        Uri r12 = r5.getData();
        if (r12.isPathPrefixMatch(Telephony.Carriers.CONTENT_URI) == true) goto L15;
        OLog.e(TAG, "Edit request not for carrier table. Uri: " + r12);
        finish();
        return;
    L15:
        this.mUri = r12;
    L34:
        Cursor r13 = getActivity().managedQuery(this.mUri, sProjection, null, null);
        this.mCursor = r13;
        r13.moveToFirst();
        this.mTelephonyManager = (TelephonyManager) getActivity().getSystemService(MultiSimAdapter.PHONE_KEY);
    L36:
        if (r7 >= getPreferenceScreen().getPreferenceCount()) goto L38;
        getPreferenceScreen().getPreference(r7).setOnPreferenceChangeListener(this);
        r7 = r7 + 1;
        goto L36
    L38:
        fillUi();
        return;
    L17:
        if (r6.equals("android.intent.action.INSERT") == true) goto L19;
        finish();
        return;
    L19:
        if (this.mFirstTime == false) goto L21;
    L24:
        Uri r14 = r5.getData();
        if (r14.isPathPrefixMatch(Telephony.Carriers.CONTENT_URI) == true) goto L28;
        OLog.e(TAG, "Insert request not for carrier table. Uri: " + r14);
        finish();
        return;
    L28:
        ContentValues r10 = new ContentValues();
        r10.put("protocol", PROTOCOL_IPV4V6);
        r10.put("roaming_protocol", PROTOCOL_IPV4V6);
        this.mUri = getContentResolver().insert(r14, r10);
    L29:
        this.mNewApn = true;
        this.mMvnoTypeStr = r5.getStringExtra("mvno_type");
        this.mMvnoMatchDataStr = r5.getStringExtra(ApnSettings.MVNO_MATCH_DATA);
        if (this.mUri != null) goto L33;
        OLog.w(TAG, "Failed to insert new telephony provider into " + getIntent().getData());
        finish();
        return;
    L33:
        setResult(-1, new Intent().setAction(this.mUri.toString()));
        goto L34
    L21:
        if (r11.getInt(SAVED_POS) == 0) goto L24;
        this.mUri = ContentUris.withAppendedId(Telephony.Carriers.CONTENT_URI, r11.getInt(SAVED_POS));
        goto L29
    L8:
        r9 = false;
        goto L9
    }

    public void com_android_settings_ApnEditor__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    private void fillUi() {
        if (this.mFirstTime == false) goto L42;
        this.mFirstTime = false;
        this.mName.setText(this.mCursor.getString(1));
        this.mApn.setText(this.mCursor.getString(2));
        this.mProxy.setText(this.mCursor.getString(3));
        this.mPort.setText(this.mCursor.getString(4));
        this.mUser.setText(this.mCursor.getString(5));
        this.mServer.setText(this.mCursor.getString(6));
        this.mPassword.setText(this.mCursor.getString(7));
        this.mMmsProxy.setText(this.mCursor.getString(12));
        this.mMmsPort.setText(this.mCursor.getString(13));
        this.mMmsc.setText(this.mCursor.getString(8));
        this.mMcc.setText(this.mCursor.getString(9));
        this.mMnc.setText(this.mCursor.getString(10));
        this.mApnType.setText(this.mCursor.getString(15));
        if (this.mNewApn == false) goto L11;
        String r0 = this.mTelephonyManager.getSimOperator(this.mSubId);
        if (r0 == null) goto L11;
        if (r0.length() <= 4) goto L11;
        String r3 = r0.substring(0, 3);
        String r1 = r0.substring(3);
        this.mMcc.setText(r3);
        this.mMnc.setText(r1);
        this.mCurMnc = r1;
        this.mCurMcc = r3;
    L11:
        int r2 = this.mCursor.getInt(14);
        if (r2 == (-1)) goto L14;
        this.mAuthType.setValueIndex(r2);
    L15:
        this.mProtocol.setValue(this.mCursor.getString(16));
        this.mRoamingProtocol.setValue(this.mCursor.getString(20));
        SwitchPreference r4 = this.mCarrierEnabled;
        if (this.mCursor.getInt(17) != 1) goto L18;
        boolean r5 = true;
    L19:
        r4.setChecked(r5);
        this.mBearerInitialVal = this.mCursor.getInt(18);
        HashSet r6 = new HashSet();
        int r7 = this.mCursor.getInt(19);
        if (r7 == 0) goto L22;
        int r8 = 1;
    L25:
        if (r7 == 0) goto L31;
        if ((r7 & 1) != 1) goto L29;
        r6.add("" + r8);
    L29:
        r7 = r7 >> 1;
        r8 = r8 + 1;
    L31:
        if (this.mBearerInitialVal != 0) goto L33;
    L35:
        this.mBearerMulti.setValues(r6);
        this.mMvnoType.setValue(this.mCursor.getString(21));
        this.mMvnoMatchData.setEnabled(false);
        this.mMvnoMatchData.setText(this.mCursor.getString(22));
        if (this.mNewApn == false) goto L42;
        String r9 = this.mMvnoTypeStr;
        if (r9 == null) goto L42;
        if (this.mMvnoMatchDataStr == null) goto L42;
        this.mMvnoType.setValue(r9);
        this.mMvnoMatchData.setText(this.mMvnoMatchDataStr);
        goto L42
    L33:
        if (r6.contains("" + this.mBearerInitialVal) == true) goto L35;
        r6.add("" + this.mBearerInitialVal);
        goto L35
    L22:
        if (this.mBearerInitialVal != 0) goto L31;
        r6.add("0");
        goto L31
    L18:
        r5 = false;
        goto L19
    L14:
        this.mAuthType.setValue(null);
    L42:
        EditTextPreference r10 = this.mName;
        r10.setSummary(checkNull(r10.getText()));
        EditTextPreference r11 = this.mApn;
        r11.setSummary(checkNull(r11.getText()));
        EditTextPreference r12 = this.mProxy;
        r12.setSummary(checkNull(r12.getText()));
        EditTextPreference r13 = this.mPort;
        r13.setSummary(checkNull(r13.getText()));
        EditTextPreference r14 = this.mUser;
        r14.setSummary(checkNull(r14.getText()));
        EditTextPreference r15 = this.mServer;
        r15.setSummary(checkNull(r15.getText()));
        EditTextPreference r16 = this.mPassword;
        r16.setSummary(starify(r16.getText()));
        EditTextPreference r17 = this.mMmsProxy;
        r17.setSummary(checkNull(r17.getText()));
        EditTextPreference r18 = this.mMmsPort;
        r18.setSummary(checkNull(r18.getText()));
        EditTextPreference r19 = this.mMmsc;
        r19.setSummary(checkNull(r19.getText()));
        EditTextPreference r20 = this.mMcc;
        r20.setSummary(checkNull(r20.getText()));
        EditTextPreference r21 = this.mMnc;
        r21.setSummary(checkNull(r21.getText()));
        EditTextPreference r22 = this.mApnType;
        r22.setSummary(checkNull(r22.getText()));
        String r23 = this.mAuthType.getValue();
        if (r23 == null) goto L45;
        int r24 = Integer.parseInt(r23);
        this.mAuthType.setValueIndex(r24);
        this.mAuthType.setSummary(this.mRes.getStringArray(R.array.apn_auth_entries)[r24]);
    L46:
        ListPreference r25 = this.mProtocol;
        r25.setSummary(checkNull(protocolDescription(r25.getValue(), this.mProtocol)));
        ListPreference r26 = this.mRoamingProtocol;
        r26.setSummary(checkNull(protocolDescription(r26.getValue(), this.mRoamingProtocol)));
        MultiSelectListPreference r27 = this.mBearerMulti;
        r27.setSummary(checkNull(bearerMultiDescription(r27.getValues())));
        ListPreference r28 = this.mMvnoType;
        r28.setSummary(checkNull(mvnoDescription(r28.getValue())));
        EditTextPreference r29 = this.mMvnoMatchData;
        r29.setSummary(checkNull(r29.getText()));
        if (getResources().getBoolean(R.bool.config_allow_edit_carrier_enabled) == false) goto L49;
        this.mCarrierEnabled.setEnabled(true);
        return;
    L49:
        this.mCarrierEnabled.setEnabled(false);
        return;
    L45:
        this.mAuthType.setSummary(sNotSet);
        goto L46
    }

    private String protocolDescription(String r2, ListPreference r3) {
        int r4 = r3.findIndexOfValue(r2);
        if (r4 != (-1)) goto L9;
        return null;
    L9:
        return this.mRes.getStringArray(R.array.apn_protocol_entries)[r4];
    L8:
        return null;
    }

    private String bearerDescription(String r3) {
        int r4 = this.mBearerMulti.findIndexOfValue(r3);
        if (r4 != (-1)) goto L9;
        return null;
    L9:
        return this.mRes.getStringArray(R.array.bearer_entries)[r4];
    L8:
        return null;
    }

    private String bearerMultiDescription(Set<String> r7) {
        String[] r0 = this.mRes.getStringArray(R.array.bearer_entries);
        StringBuilder r1 = new StringBuilder();
        Iterator<String> r8 = r7.iterator();
        boolean r2 = true;
    L4:
        if (r8.hasNext() == false) goto L10;
        int r3 = this.mBearerMulti.findIndexOfValue(r8.next());
        if (r2 == false) goto L8;
        r1.append(r0[r3]);     // Catch: ArrayIndexOutOfBoundsException -> L15
        r2 = false;
        goto L4
    L8:
        r1.append(", " + r0[r3]);     // Catch: ArrayIndexOutOfBoundsException -> L15
        goto L4
    L10:
        String r6 = r1.toString();
        if (TextUtils.isEmpty(r6) == true) goto L13;
        return r6;
    L13:
        return null;
    }

    private String mvnoDescription(String r7) {
        int r0 = this.mMvnoType.findIndexOfValue(r7);
        String r1 = this.mMvnoType.getValue();
        if (r0 != (-1)) goto L5;
        return null;
    L5:
        String[] r2 = this.mRes.getStringArray(R.array.mvno_type_entries);
        EditTextPreference r4 = this.mMvnoMatchData;
        if (r0 == 0) goto L8;
        boolean r5 = true;
    L9:
        r4.setEnabled(r5);
        if (r7 != null) goto L12;
    L30:
        return r2[r0];
    L29:
        return null;
    L12:
        if (r7.equals(r1) == true) goto L30;
        if (r2[r0].equals("SPN") == false) goto L17;
        this.mMvnoMatchData.setText(this.mTelephonyManager.getSimOperatorName());
        goto L30
    L17:
        if (r2[r0].equals("IMSI") == false) goto L20;
        this.mMvnoMatchData.setText(this.mTelephonyManager.getSimOperator(this.mSubId) + MaterialConfigFormatNames.X);
        goto L30
    L20:
        if (r2[r0].equals("GID") == false) goto L23;
        this.mMvnoMatchData.setText(this.mTelephonyManager.getGroupIdLevel1());
        goto L30
    L23:
        if (r2[r0].equals("ICCID") == false) goto L30;
        if (this.mMvnoMatchDataStr == null) goto L30;
        OLog.d(TAG, "mMvnoMatchDataStr: " + this.mMvnoMatchDataStr);
        this.mMvnoMatchData.setText(this.mMvnoMatchDataStr);
        goto L30
    L8:
        r5 = false;
        goto L9
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r4, Object r5) {
        String r0 = r4.getKey();
        if (KEY_AUTH_TYPE.equals(r0) == false) goto L8;
        int r6 = Integer.parseInt((String) r5);     // Catch: NumberFormatException -> L6
        this.mAuthType.setValueIndex(r6);     // Catch: NumberFormatException -> L6
        String[] r7 = this.mRes.getStringArray(R.array.apn_auth_entries);     // Catch: NumberFormatException -> L6
        this.mAuthType.setSummary(r7[r6]);     // Catch: NumberFormatException -> L6
        return true;
    L6:
        return false;
    L8:
        if (KEY_PROTOCOL.equals(r0) == false) goto L14;
        String r8 = (String) r5;
        String r9 = protocolDescription(r8, this.mProtocol);
        if (r9 != null) goto L12;
        return false;
    L12:
        this.mProtocol.setSummary(r9);
        this.mProtocol.setValue(r8);
        return true;
    L14:
        if (KEY_ROAMING_PROTOCOL.equals(r0) == false) goto L20;
        String r10 = (String) r5;
        String r11 = protocolDescription(r10, this.mRoamingProtocol);
        if (r11 != null) goto L18;
        return false;
    L18:
        this.mRoamingProtocol.setSummary(r11);
        this.mRoamingProtocol.setValue(r10);
        return true;
    L20:
        if (KEY_BEARER_MULTI.equals(r0) == false) goto L26;
        Set<String> r12 = (Set) r5;
        String r13 = bearerMultiDescription(r12);
        if (r13 != null) goto L24;
        return false;
    L24:
        this.mBearerMulti.setValues(r12);
        this.mBearerMulti.setSummary(r13);
        return true;
    L26:
        if ("mvno_type".equals(r0) == false) goto L32;
        String r14 = (String) r5;
        String r15 = mvnoDescription(r14);
        if (r15 != null) goto L30;
        return false;
    L30:
        this.mMvnoType.setValue(r14);
        this.mMvnoType.setSummary(r15);
        return true;
    L32:
        if (r4.equals(this.mPassword) == false) goto L38;
        if (r5 == null) goto L35;
        String r16 = String.valueOf(r5);
    L36:
        r4.setSummary(starify(r16));
        return true;
    L35:
        r16 = "";
        goto L36
    L38:
        if (r4.equals(this.mCarrierEnabled) == true) goto L54;
        if (r5 == null) goto L42;
        String r17 = String.valueOf(r5);
    L43:
        r4.setSummary(checkNull(r17));
        return true;
    L42:
        r17 = null;
        goto L43
    L54:
        return true;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r2, MenuInflater r3) {
        super.onCreateOptionsMenu(r2, r3);
        if (this.mDisableEditor == false) goto L7;
        OLog.d(TAG, "Form is disabled. Do not create the options menu.");
        return;
    L7:
        if (this.mNewApn == true) goto L9;
        r2.add(0, 1, 0, R.string.menu_delete);
    L9:
        r2.add(0, 2, 0, R.string.menu_save).setIcon(android.R.drawable.ic_menu_save);
        r2.add(0, 3, 0, R.string.menu_cancel).setIcon(android.R.drawable.ic_menu_close_clear_cancel);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r4) {
        int r0 = r4.getItemId();
        if (r0 != 1) goto L5;
        deleteApn();
        return true;
    L5:
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L11;
        return super.onOptionsItemSelected(r4);
    L11:
        if (this.mNewApn == false) goto L13;
        getContentResolver().delete(this.mUri, null, null);
    L13:
        finish();
        return true;
    L16:
        if (validateAndSave(false) == false) goto L18;
        finish();
    L18:
        return true;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        if (validateAndSave(true) == false) goto L8;
        Cursor r1 = this.mCursor;
        if (r1 == null) goto L9;
        r2.putInt(SAVED_POS, r1.getInt(0));
        return;
    L9:
        return;
    }

    private boolean validateAndSave(boolean r9) {
        if (this.mDisableEditor == false) goto L6;
        OLog.d(TAG, "Form is disabled. Nothing to save.");
        return true;
    L6:
        String r0 = checkNotSet(this.mName.getText());
        String r2 = checkNotSet(this.mApn.getText());
        String r3 = checkNotSet(this.mMcc.getText());
        String r4 = checkNotSet(this.mMnc.getText());
        int r6 = 0;
        if (getErrorMsg() == null) goto L12;
        if (r9 == true) goto L12;
        ErrorDialog.showError(this);
        return false;
    L12:
        if (this.mCursor.moveToFirst() == true) goto L16;
        OLog.w(TAG, "Could not go to the first row in the Cursor when saving data.");
        return false;
    L16:
        if (r9 == true) goto L18;
    L25:
        ContentValues r10 = new ContentValues();
        if (r0.length() >= 1) goto L28;
        r0 = getResources().getString(R.string.untitled_apn);
    L28:
        r10.put("name", r0);
        r10.put("apn", r2);
        r10.put("proxy", checkNotSet(this.mProxy.getText()));
        r10.put(ClientCookie.PORT_ATTR, checkNotSet(this.mPort.getText()));
        r10.put("mmsproxy", checkNotSet(this.mMmsProxy.getText()));
        r10.put("mmsport", checkNotSet(this.mMmsPort.getText()));
        r10.put(PickApplicationActivity.EXTRA_USER, checkNotSet(this.mUser.getText()));
        r10.put("server", checkNotSet(this.mServer.getText()));
        r10.put("password", checkNotSet(this.mPassword.getText()));
        r10.put("mmsc", checkNotSet(this.mMmsc.getText()));
        String r1 = this.mAuthType.getValue();
        if (r1 == null) goto L31;
        r10.put("authtype", Integer.valueOf(Integer.parseInt(r1)));
    L31:
        r10.put("protocol", checkNotSet(this.mProtocol.getValue()));
        r10.put("roaming_protocol", checkNotSet(this.mRoamingProtocol.getValue()));
        r10.put("type", checkNotSet(this.mApnType.getText()));
        r10.put(DataServiceUtils.SubscriptionInfoData.COLUMN_MCC, r3);
        r10.put(DataServiceUtils.SubscriptionInfoData.COLUMN_MNC, r4);
        r10.put("numeric", r3 + r4);
        String r5 = this.mCurMnc;
        if (r5 != null) goto L34;
    L40:
        Iterator<String> r7 = this.mBearerMulti.getValues().iterator();
        int r8 = 0;
    L42:
        if (r7.hasNext() == false) goto L47;
        String r11 = r7.next();
        if (Integer.parseInt(r11) == 0) goto L45;
        r8 = r8 | ServiceState.getBitmaskForTech(Integer.parseInt(r11));
        goto L42
    L45:
        r8 = 0;
    L47:
        r10.put("bearer_bitmask", Integer.valueOf(r8));
        if (r8 == 0) goto L55;
        int r12 = this.mBearerInitialVal;
        if (r12 == 0) goto L55;
        if (ServiceState.bitmaskHasTech(r8, r12) == false) goto L55;
        r6 = this.mBearerInitialVal;
    L55:
        r10.put("bearer", Integer.valueOf(r6));
        r10.put("mvno_type", checkNotSet(this.mMvnoType.getValue()));
        r10.put(ApnSettings.MVNO_MATCH_DATA, checkNotSet(this.mMvnoMatchData.getText()));
        r10.put(KEY_CARRIER_ENABLED, Integer.valueOf(this.mCarrierEnabled.isChecked() ? 1 : 0));
        getContentResolver().update(this.mUri, r10, null, null);
        return true;
    L34:
        if (this.mCurMcc == null) goto L40;
        if (r5.equals(r4) == false) goto L40;
        if (this.mCurMcc.equals(r3) == false) goto L40;
        r10.put(PerfConsts.KEY_CURRENT_GALVANIC, 1);
        goto L40
    L18:
        if (this.mNewApn == false) goto L25;
        if (r0.length() >= 1) goto L25;
        if (r2.length() >= 1) goto L25;
        getContentResolver().delete(this.mUri, null, null);
        return false;
    }

    private String getErrorMsg() {
        String r0 = checkNotSet(this.mName.getText());
        String r1 = checkNotSet(this.mApn.getText());
        String r2 = checkNotSet(this.mMcc.getText());
        String r3 = checkNotSet(this.mMnc.getText());
        if (r0.length() >= 1) goto L6;
        return this.mRes.getString(R.string.error_name_empty);
    L6:
        if (r1.length() >= 1) goto L9;
        return this.mRes.getString(R.string.error_apn_empty);
    L9:
        if (r2.length() == 3) goto L12;
        return this.mRes.getString(R.string.error_mcc_not3);
    L12:
        if ((r3.length() & ObexHelper.MAX_PACKET_SIZE_INT) != 2) goto L19;
        return null;
    L19:
        return this.mRes.getString(R.string.error_mnc_not23);
    }

    private void deleteApn() {
        getContentResolver().delete(this.mUri, null, null);
        finish();
    }

    private String starify(String r3) {
        if (r3 == null) goto L12;
        if (r3.length() == 0) goto L12;
        int r2 = r3.length();
        char[] r4 = new char[r2];
        int r0 = 0;
    L7:
        if (r0 >= r2) goto L10;
        r4[r0] = '*';
        r0 = r0 + 1;
        goto L7
    L10:
        return new String(r4);
    L12:
        return sNotSet;
    }

    private String checkNull(String r1) {
        if (r1 == null) goto L8;
        if (r1.length() == 0) goto L8;
        return r1;
    L8:
        return sNotSet;
    }

    static boolean hasAllApns(String[] r6) {
        if (ArrayUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        List r7 = Arrays.asList(r6);
        if (r7.contains(APN_TYPE_ALL) == false) goto L9;
        OLog.d(TAG, "hasAllApns: true because apnList.contains(APN_TYPE_ALL)");
        return true;
    L9:
        String[] r0 = APN_TYPES;
        int r3 = r0.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L15;
        if (r7.contains(r0[r4]) == false) goto L13;
        r4 = r4 + 1;
        goto L10
    L13:
        return false;
    L15:
        OLog.d(TAG, "hasAllApns: true");
        return true;
    }

    private String checkNotSet(String r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        if (r1.equals(sNotSet) == true) goto L9;
        return r1;
    L9:
        return "";
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ApnEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ApnEditor r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ApnEditor__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ApnEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ApnEditor r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ApnEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ApnEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ApnEditor r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ApnEditor__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
