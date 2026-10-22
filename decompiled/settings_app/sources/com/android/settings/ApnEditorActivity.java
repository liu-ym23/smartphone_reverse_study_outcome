package com.android.settings;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserManager;
import android.provider.Telephony;
import android.telephony.CarrierConfigManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.android.internal.util.ArrayUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ThreadUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.mobile.dataservice.DataServiceUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.v2.OPopover;
import com.obric.privacy.GrantUtil;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.obex.ObexHelper;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ApnEditorActivity extends BaseActivity implements View.OnClickListener {
    private static final String APN_DEFALUT_VALUES_STRING_ARRAY = "apn_default_values_strings_array";
    private static final int APN_INDEX = 2;
    private static final int AUTH_TYPE_INDEX = 14;
    private static final int BEARER_BITMASK_INDEX = 19;
    private static final int BEARER_INDEX = 18;
    private static final int CARRIER_ENABLED_INDEX = 17;
    public static final String EXTRA_EDITABLE = "extra_editable";
    private static final int ID_INDEX = 0;
    private static final int MCC_INDEX = 9;
    private static final int MMSC_INDEX = 8;
    private static final int MMSPORT_INDEX = 13;
    private static final int MMSPROXY_INDEX = 12;
    private static final int MNC_INDEX = 10;
    private static final int MVNO_MATCH_DATA_INDEX = 22;
    private static final int MVNO_TYPE_INDEX = 21;
    private static final int NAME_INDEX = 1;
    private static final int PASSWORD_INDEX = 7;
    private static final int PORT_INDEX = 4;
    private static final int PPP_NUMBER_INDEX = 23;
    private static final int PROTOCOL_INDEX = 16;
    private static final int PROXY_INDEX = 3;
    private static final int ROAMING_PROTOCOL_INDEX = 20;
    private static final int SERVER_INDEX = 6;
    private static final String TAG = null;
    private static final int TYPE_INDEX = 15;
    private static final int USER_INDEX = 5;
    private static final boolean VDBG = false;
    private static String sApnDefault;
    private static String sNotSet;
    private static final String[] sProjection = null;
    private static final String[] sUIConfigurableItems = null;
    private TitleSummaryItem mApn;
    private ApnData mApnData;
    private TitleSummaryItem mApnType;
    private TitleSummaryItem mAuthType;
    private TitleSummaryItem mBearer;
    private TitleSummaryItem mCarrierEnabled;
    private Uri mCarrierUri;
    private String mCurMcc;
    private String mCurMnc;
    private boolean mEditAble;
    private TitleSummaryItem mMcc;
    private TitleSummaryItem mMmsPort;
    private TitleSummaryItem mMmsProxy;
    private TitleSummaryItem mMmsc;
    private TitleSummaryItem mMnc;
    private TitleSummaryItem mMvnoMatchData;
    private String mMvnoMatchDataStr;
    private TitleSummaryItem mMvnoType;
    private String mMvnoTypeStr;
    private TitleSummaryItem mName;
    private boolean mNewApn;
    private TitleSummaryItem mPassword;
    private OPopover mPopover;
    private TitleSummaryItem mPort;
    private TitleSummaryItem mProtocol;
    private TitleSummaryItem mProxy;
    private Resources mRes;
    private View mRightBtn;
    private TitleSummaryItem mRoamingProtocol;
    private TitleSummaryItem mServer;
    private int mSubId;
    private TelephonyManager mTelephonyManager;
    private TitleSummaryItem mUser;

    static class ApnData {
        Object[] mData;
        Uri mUri;

        ApnData(int r1) {
            this.mData = new Object[r1];
        }

        ApnData(Uri r3, Cursor r4) {
            this.mUri = r3;
            this.mData = new Object[r4.getColumnCount()];
            int r5 = 0;
        L4:
            if (r5 >= this.mData.length) goto L19;
            int r0 = r4.getType(r5);
            if (r0 != 1) goto L8;
            this.mData[r5] = Integer.valueOf(r4.getInt(r5));
        L18:
            r5 = r5 + 1;
            goto L4
        L8:
            if (r0 != 2) goto L10;
            this.mData[r5] = Float.valueOf(r4.getFloat(r5));
            goto L18
        L10:
            if (r0 != 3) goto L12;
            this.mData[r5] = r4.getString(r5);
            goto L18
        L12:
            if (r0 == 4) goto L14;
            this.mData[r5] = null;
            goto L18
        L14:
            this.mData[r5] = r4.getBlob(r5);
            goto L18
        }

        Uri getUri() {
            return this.mUri;
        }

        void setUri(Uri r1) {
            this.mUri = r1;
        }

        Integer getInteger(int r1) {
            return (Integer) this.mData[r1];
        }

        Integer getInteger(int r1, Integer r2) {
            Integer r0 = getInteger(r1);
            if (r0 != null) goto L6;
            return r2;
        L6:
            return r0;
        }

        String getString(int r1) {
            return (String) this.mData[r1];
        }

        void setObject(int r1, Object r2) {
            this.mData[r1] = r2;
        }
    }

    public void com_android_settings_ApnEditorActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_ApnEditorActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_ApnEditorActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_ApnEditorActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_ApnEditorActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_ApnEditorActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_ApnEditorActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_ApnEditorActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_ApnEditorActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ApnEditorActivity() {
        this.mPopover = null;
    }

    static /* synthetic */ TitleSummaryItem access$000(ApnEditorActivity r0) {
        return r0.mCarrierEnabled;
    }

    static /* synthetic */ String access$100() {
        return sNotSet;
    }

    static /* synthetic */ TitleSummaryItem access$200(ApnEditorActivity r0) {
        return r0.mMvnoType;
    }

    static /* synthetic */ String access$300(ApnEditorActivity r0, String r1) {
        return r0.mvnoDescription(r1);
    }

    static /* synthetic */ OPopover access$400(ApnEditorActivity r0) {
        return r0.mPopover;
    }

    static /* synthetic */ OPopover access$402(ApnEditorActivity r0, OPopover r1) {
        r0.mPopover = r1;
        return r1;
    }

    static /* synthetic */ String access$500() {
        return TAG;
    }

    static {
        TAG = "ApnEditor";
        sProjection = new String[]{"_id", "name", "apn", "proxy", ClientCookie.PORT_ATTR, PickApplicationActivity.EXTRA_USER, "server", "password", "mmsc", DataServiceUtils.SubscriptionInfoData.COLUMN_MCC, DataServiceUtils.SubscriptionInfoData.COLUMN_MNC, "numeric", "mmsproxy", "mmsport", "authtype", "type", "protocol", "carrier_enabled", "bearer", "bearer_bitmask", "roaming_protocol", ApnSettings.MVNO_TYPE, ApnSettings.MVNO_MATCH_DATA};
        sUIConfigurableItems = new String[]{"name", "apn", "proxy", ClientCookie.PORT_ATTR, PickApplicationActivity.EXTRA_USER, "server", "password", "mmsc", "mmsproxy", "mmsport", "authtype", "type", "protocol", "carrier_enabled", "bearer", "bearer_bitmask", "roaming_protocol"};
    }

    public void com_android_settings_ApnEditorActivity__onCreate$___twin___(Bundle r9) {
        Uri r0 = null;
        super.onCreate(null);
        if (isUserRestricted() == false) goto L6;
        OLog.e(TAG, "This setting isn't available due to user restriction.");
        finish();
        return;
    L6:
        setContentView(R.layout.apn_editor_layout);
        this.mTitle.setCenterTitle(Utils.getStringExtraSafely(getIntent(), "title"));
        if (isDarkMode() == false) goto L9;
        this.mTitle.setEndButtonGroupStyle(2132017895);
    L10:
        View r1 = this.mTitle.addEndAction(R.drawable.o_card_list_item_tail_icon_mark, -1, null);
        this.mRightBtn = r1;
        r1.setOnClickListener(this);
        boolean r4 = true;
        this.mEditAble = Utils.getBooleanExtraSafely(getIntent(), EXTRA_EDITABLE, true);
        sNotSet = getResources().getString(R.string.apn_not_set);
        sApnDefault = getResources().getString(R.string.apn_type_default);
        TitleSummaryItem r5 = (TitleSummaryItem) findViewById(R.id.item_name);
        this.mName = r5;
        OCardListItemUtils.setCustomEndTipTextView(r5, getString(R.string.apn_not_set));
        this.mName.getContentContainer().setTag(Integer.valueOf(R.id.item_name));
        this.mName.setOnContentClickListener(this);
        TitleSummaryItem r6 = (TitleSummaryItem) findViewById(R.id.item_apn);
        this.mApn = r6;
        OCardListItemUtils.setCustomEndTipTextView(r6, getString(R.string.apn_not_set));
        this.mApn.getContentContainer().setTag(Integer.valueOf(R.id.item_apn));
        this.mApn.setOnContentClickListener(this);
        TitleSummaryItem r7 = (TitleSummaryItem) findViewById(R.id.item_proxy);
        this.mProxy = r7;
        OCardListItemUtils.setCustomEndTipTextView(r7, getString(R.string.apn_not_set));
        this.mProxy.getContentContainer().setTag(Integer.valueOf(R.id.item_proxy));
        this.mProxy.setOnContentClickListener(this);
        TitleSummaryItem r8 = (TitleSummaryItem) findViewById(R.id.item_port);
        this.mPort = r8;
        OCardListItemUtils.setCustomEndTipTextView(r8, getString(R.string.apn_not_set));
        this.mPort.getContentContainer().setTag(Integer.valueOf(R.id.item_port));
        this.mPort.setOnContentClickListener(this);
        TitleSummaryItem r10 = (TitleSummaryItem) findViewById(R.id.item_user);
        this.mUser = r10;
        OCardListItemUtils.setCustomEndTipTextView(r10, getString(R.string.apn_not_set));
        this.mUser.getContentContainer().setTag(Integer.valueOf(R.id.item_user));
        this.mUser.setOnContentClickListener(this);
        TitleSummaryItem r11 = (TitleSummaryItem) findViewById(R.id.item_password);
        this.mPassword = r11;
        OCardListItemUtils.setCustomEndTipTextView(r11, getString(R.string.apn_not_set));
        this.mPassword.getContentContainer().setTag(Integer.valueOf(R.id.item_password));
        this.mPassword.setOnContentClickListener(this);
        TitleSummaryItem r12 = (TitleSummaryItem) findViewById(R.id.item_server);
        this.mServer = r12;
        OCardListItemUtils.setCustomEndTipTextView(r12, getString(R.string.apn_not_set));
        this.mServer.getContentContainer().setTag(Integer.valueOf(R.id.item_server));
        this.mServer.setOnContentClickListener(this);
        TitleSummaryItem r13 = (TitleSummaryItem) findViewById(R.id.item_mmsc);
        this.mMmsc = r13;
        OCardListItemUtils.setCustomEndTipTextView(r13, getString(R.string.apn_not_set));
        this.mMmsc.getContentContainer().setTag(Integer.valueOf(R.id.item_mmsc));
        this.mMmsc.setOnContentClickListener(this);
        TitleSummaryItem r14 = (TitleSummaryItem) findViewById(R.id.item_mms_proxy);
        this.mMmsProxy = r14;
        OCardListItemUtils.setCustomEndTipTextView(r14, getString(R.string.apn_not_set));
        this.mMmsProxy.getContentContainer().setTag(Integer.valueOf(R.id.item_mms_proxy));
        this.mMmsProxy.setOnContentClickListener(this);
        TitleSummaryItem r15 = (TitleSummaryItem) findViewById(R.id.item_mms_port);
        this.mMmsPort = r15;
        OCardListItemUtils.setCustomEndTipTextView(r15, getString(R.string.apn_not_set));
        this.mMmsPort.getContentContainer().setTag(Integer.valueOf(R.id.item_mms_port));
        this.mMmsPort.setOnContentClickListener(this);
        TitleSummaryItem r16 = (TitleSummaryItem) findViewById(R.id.item_mcc);
        this.mMcc = r16;
        OCardListItemUtils.setCustomEndTipTextView(r16, getString(R.string.apn_not_set));
        this.mMcc.getContentContainer().setTag(Integer.valueOf(R.id.item_mcc));
        this.mMcc.setOnContentClickListener(this);
        TitleSummaryItem r17 = (TitleSummaryItem) findViewById(R.id.item_mnc);
        this.mMnc = r17;
        OCardListItemUtils.setCustomEndTipTextView(r17, getString(R.string.apn_not_set));
        this.mMnc.getContentContainer().setTag(Integer.valueOf(R.id.item_mnc));
        this.mMnc.setOnContentClickListener(this);
        TitleSummaryItem r18 = (TitleSummaryItem) findViewById(R.id.item_auth_type);
        this.mAuthType = r18;
        OCardListItemUtils.setCustomEndTipTextView(r18, getString(R.string.apn_not_set));
        this.mAuthType.getContentContainer().setTag(Integer.valueOf(R.id.item_auth_type));
        this.mAuthType.setOnContentClickListener(this);
        TitleSummaryItem r19 = (TitleSummaryItem) findViewById(R.id.item_apn_type);
        this.mApnType = r19;
        OCardListItemUtils.setCustomEndTipTextView(r19, getString(R.string.apn_not_set));
        this.mApnType.getContentContainer().setTag(Integer.valueOf(R.id.item_apn_type));
        this.mApnType.setOnContentClickListener(this);
        TitleSummaryItem r20 = (TitleSummaryItem) findViewById(R.id.item_protocal);
        this.mProtocol = r20;
        OCardListItemUtils.setCustomEndTipTextView(r20, getString(R.string.apn_not_set));
        this.mProtocol.getContentContainer().setTag(Integer.valueOf(R.id.item_protocal));
        this.mProtocol.setOnContentClickListener(this);
        TitleSummaryItem r21 = (TitleSummaryItem) findViewById(R.id.item_roaming_protocal);
        this.mRoamingProtocol = r21;
        OCardListItemUtils.setCustomEndTipTextView(r21, getString(R.string.apn_not_set));
        this.mRoamingProtocol.getContentContainer().setTag(Integer.valueOf(R.id.item_roaming_protocal));
        this.mRoamingProtocol.setOnContentClickListener(this);
        TelephonyManager r22 = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
        TitleSummaryItem r23 = (TitleSummaryItem) findViewById(R.id.item_carrier_enabled);
        this.mCarrierEnabled = r23;
        r23.getContentContainer().setClickable(false);
        TitleSummaryItem r24 = (TitleSummaryItem) findViewById(R.id.item_bearer);
        this.mBearer = r24;
        OCardListItemUtils.setCustomEndTipTextView(r24, getString(R.string.apn_not_set));
        this.mBearer.getContentContainer().setTag(Integer.valueOf(R.id.item_bearer));
        this.mBearer.setOnContentClickListener(this);
        TitleSummaryItem r25 = (TitleSummaryItem) findViewById(R.id.mvno_type);
        this.mMvnoType = r25;
        OCardListItemUtils.setCustomEndTipTextView(r25, getString(R.string.apn_not_set));
        this.mMvnoType.getContentContainer().setTag(Integer.valueOf(R.id.mvno_type));
        this.mMvnoType.setOnContentClickListener(this);
        TitleSummaryItem r26 = (TitleSummaryItem) findViewById(R.id.mvno_match_data);
        this.mMvnoMatchData = r26;
        OCardListItemUtils.setCustomEndTipTextView(r26, getString(R.string.apn_not_set));
        this.mMvnoMatchData.getContentContainer().setTag(Integer.valueOf(R.id.mvno_match_data));
        this.mMvnoMatchData.setOnContentClickListener(this);
        this.mRes = getResources();
        Intent r2 = getIntent();
        String r27 = r2.getAction();
        this.mSubId = r2.getIntExtra(ApnSettings.SUB_ID, -1);
        if ("android.intent.action.EDIT".equals(r27) == false) goto L17;
        r0 = r2.getData();
        if (Utils.isPathPrefixMatch(r0, Telephony.Carriers.CONTENT_URI) == true) goto L23;
        OLog.e(TAG, "Edit request not for carrier table. Uri: " + r0);
        finish();
        return;
    L23:
        if (r0 == null) goto L27;
        ApnData r3 = getApnDataFromUri(r0);
        this.mApnData = r3;
        if (r3 != null) goto L28;
        OLog.w(TAG, "Edit request APN data is empty. Uri: " + r0);
        createDefaultApnData(r27);
    L28:
        this.mTelephonyManager = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r9 == null) goto L32;
        r4 = false;
    L32:
        fillUI(r4);
        setupBackBtnOnTitle();
        if (this.mEditAble == true) goto L35;
        this.mRightBtn.setVisibility(8);
    L35:
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewById(R.id.page_container));
        return;
    L27:
        createDefaultApnData(r27);
        goto L28
    L17:
        if ("android.intent.action.INSERT".equals(r27) == false) goto L37;
        Uri r28 = r2.getData();
        this.mCarrierUri = r28;
        if (Utils.isPathPrefixMatch(r28, Telephony.Carriers.CONTENT_URI) == true) goto L22;
        OLog.e(TAG, "Insert request not for carrier table. Uri: " + this.mCarrierUri);
        finish();
        return;
    L22:
        this.mNewApn = true;
        this.mMvnoTypeStr = r2.getStringExtra(ApnSettings.MVNO_TYPE);
        this.mMvnoMatchDataStr = r2.getStringExtra(ApnSettings.MVNO_MATCH_DATA);
        goto L23
    L37:
        finish();
        return;
    L9:
        this.mTitle.setEndButtonGroupStyle(2132017893);
        goto L10
    }

    private void createDefaultApnData(String r3) {
        this.mApnData = new ApnData(sProjection.length);
        if (r3.equals("android.intent.action.INSERT") == false) goto L6;
        setDefaultData();
        return;
    }

    private boolean isDarkMode() {
        if ((this.mContext.getResources().getConfiguration().uiMode & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isUserRestricted() {
        UserManager r3 = (UserManager) getSystemService(UserManager.class);
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isAdminUser() == true) goto L10;
        OLog.e(TAG, "User is not an admin");
        return true;
    L10:
        if (r3.hasUserRestriction("no_config_mobile_networks") == false) goto L13;
        OLog.e(TAG, "User is not allowed to configure mobile network");
        return true;
    L13:
        return false;
    }

    static boolean hasAllApns(String[] r2) {
        if (ArrayUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        if (Arrays.asList(r2).contains(ApnEditor.APN_TYPE_ALL) == false) goto L10;
        OLog.d(TAG, "hasAllApns: true because apnList.contains(PhoneConstants.APN_TYPE_ALL)");
        return true;
    L10:
        OLog.d(TAG, "hasAllApns: true");
        return true;
    }

    private boolean apnTypesMatch(String[] r6, String r7) {
        if (ArrayUtils.isEmpty(r6) == false) goto L6;
        return false;
    L6:
        if (hasAllApns(r6) == false) goto L8;
    L19:
        return true;
    L8:
        if (TextUtils.isEmpty(r7) == true) goto L19;
        List r5 = Arrays.asList(r6);
        String[] r8 = r7.split(",");
        int r9 = r8.length;
        int r2 = 0;
    L11:
        if (r2 >= r9) goto L17;
        String r3 = r8[r2];
        if (r5.contains(r3.trim()) == true) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        OLog.d(TAG, "apnTypesMatch: true because match found for " + r3.trim());
        return true;
    L17:
        OLog.d(TAG, "apnTypesMatch: false");
        return false;
    }

    void fillUI(boolean r8) {
        String r0 = getIntent().getAction();
        if (r8 == true) goto L5;
    L48:
        TitleSummaryItem r9 = this.mName;
        OCardListItemUtils.setCustomEndTipTextView(r9, checkNull(r9.getText()));
        TitleSummaryItem r10 = this.mApn;
        OCardListItemUtils.setCustomEndTipTextView(r10, checkNull(r10.getText()));
        TitleSummaryItem r11 = this.mProxy;
        OCardListItemUtils.setCustomEndTipTextView(r11, checkNull(r11.getText()));
        TitleSummaryItem r12 = this.mPort;
        OCardListItemUtils.setCustomEndTipTextView(r12, checkNull(r12.getText()));
        TitleSummaryItem r13 = this.mUser;
        OCardListItemUtils.setCustomEndTipTextView(r13, checkNull(r13.getText()));
        TitleSummaryItem r14 = this.mServer;
        OCardListItemUtils.setCustomEndTipTextView(r14, checkNull(r14.getText()));
        TitleSummaryItem r15 = this.mPassword;
        OCardListItemUtils.setCustomEndTipTextView(r15, checkNull(r15.getText()));
        TitleSummaryItem r16 = this.mMmsProxy;
        OCardListItemUtils.setCustomEndTipTextView(r16, checkNull(r16.getText()));
        TitleSummaryItem r17 = this.mMmsPort;
        OCardListItemUtils.setCustomEndTipTextView(r17, checkNull(r17.getText()));
        TitleSummaryItem r18 = this.mMmsc;
        OCardListItemUtils.setCustomEndTipTextView(r18, checkNull(r18.getText()));
        TitleSummaryItem r19 = this.mMcc;
        OCardListItemUtils.setCustomEndTipTextView(r19, checkNull(r19.getText()));
        TitleSummaryItem r20 = this.mMnc;
        OCardListItemUtils.setCustomEndTipTextView(r20, checkNull(r20.getText()));
        String r21 = this.mAuthType.getValue();
        if (r21 == null) goto L55;
        int r22 = this.mAuthType.findIndexOfValue(r21);
        if (r22 != (-1)) goto L53;
    L56:
        TitleSummaryItem r23 = this.mProtocol;
        OCardListItemUtils.setCustomEndTipTextView(r23, checkNull(protocolDescription(r23.getValue(), this.mProtocol)));
        TitleSummaryItem r24 = this.mRoamingProtocol;
        OCardListItemUtils.setCustomEndTipTextView(r24, checkNull(protocolDescription(r24.getValue(), this.mRoamingProtocol)));
        TitleSummaryItem r25 = this.mBearer;
        OCardListItemUtils.setCustomEndTipTextView(r25, checkNull(bearerDescription(r25.getValue())));
        TitleSummaryItem r26 = this.mMvnoType;
        OCardListItemUtils.setCustomEndTipTextView(r26, checkNull(mvnoDescription(r26.getValue())));
        TitleSummaryItem r27 = this.mMvnoMatchData;
        OCardListItemUtils.setCustomEndTipTextView(r27, checkNull(r27.getText()));
        return;
    L53:
        if (this.mAuthType.getEntries() == null) goto L56;
        TitleSummaryItem r1 = this.mAuthType;
        OCardListItemUtils.setCustomEndTipTextView(r1, r1.getEntries()[r22].toString());
        goto L56
    L55:
        OCardListItemUtils.setCustomEndTipTextView(this.mAuthType, sNotSet);
        goto L56
    L5:
        if (ApnSettings.FOR_CT_TEST_ONLY == true) goto L7;
        this.mName.setText(this.mApnData.getString(1));
    L11:
        this.mApn.setText(this.mApnData.getString(2));
        this.mProxy.setText(this.mApnData.getString(3));
        this.mPort.setText(this.mApnData.getString(4));
        this.mUser.setText(this.mApnData.getString(5));
        this.mServer.setText(this.mApnData.getString(6));
        this.mPassword.setText(this.mApnData.getString(7));
        this.mMmsProxy.setText(this.mApnData.getString(12));
        this.mMmsPort.setText(this.mApnData.getString(13));
        this.mMmsc.setText(this.mApnData.getString(8));
        this.mMcc.setText(this.mApnData.getString(9));
        this.mMnc.setText(this.mApnData.getString(10));
        if (TextUtils.equals(r0, "android.intent.action.EDIT") == false) goto L14;
        this.mApnType.setText(this.mApnData.getString(15));
        TitleSummaryItem r28 = this.mApnType;
        OCardListItemUtils.setCustomEndTipTextView(r28, checkNull(r28.getText()));
    L16:
        if (this.mNewApn == false) goto L22;
        String r29 = this.mTelephonyManager.getSimOperator(this.mSubId);
        if (r29 == null) goto L22;
        if (r29.length() <= 4) goto L22;
        String r3 = r29.substring(0, 3);
        String r30 = r29.substring(3);
        this.mMcc.setText(r3);
        this.mMnc.setText(r30);
        this.mCurMnc = r30;
        this.mCurMcc = r3;
    L22:
        int r31 = this.mApnData.getInteger(14, -1).intValue();
        if (r31 == (-1)) goto L25;
        this.mAuthType.setValue(Integer.toString(r31));
    L26:
        this.mProtocol.setValue(this.mApnData.getString(16));
        this.mRoamingProtocol.setValue(this.mApnData.getString(20));
        if (this.mApnData.getInteger(17, 1).intValue() != 1) goto L29;
        boolean r32 = true;
    L30:
        this.mCarrierEnabled.setChecked(r32);
        if (getResources().getBoolean(R.bool.config_allow_edit_carrier_enabled) == false) goto L33;
        OCardListItemUtils.setEndSwitchEnabled(this.mCarrierEnabled, true);
        this.mCarrierEnabled.setOnCheckedChangeListener(new AnonymousClass1(this));
    L34:
        int r33 = this.mApnData.getInteger(18, 0).intValue();
        if (r33 >= 0) goto L37;
    L41:
        this.mMvnoType.setValue(this.mApnData.getString(21));
        OCardListItemUtils.setContentContainerEnabled(this.mMvnoMatchData, false);
        this.mMvnoMatchData.setText(this.mApnData.getString(22));
        if (this.mNewApn == false) goto L48;
        String r34 = this.mMvnoTypeStr;
        if (r34 == null) goto L48;
        if (this.mMvnoMatchDataStr == null) goto L48;
        this.mMvnoType.setValue(r34);
        this.mMvnoMatchData.setText(this.mMvnoMatchDataStr);
        goto L48
    L37:
        if (this.mBearer.getEntries() == null) goto L41;
        if (r33 >= this.mBearer.getEntries().length) goto L41;
        TitleSummaryItem r2 = this.mBearer;
        r2.setValue(r2.getEntries()[r33].toString());
        goto L41
    L33:
        OCardListItemUtils.setEndSwitchEnabled(this.mCarrierEnabled, false);
        goto L34
    L29:
        r32 = false;
        goto L30
    L25:
        this.mAuthType.setValue(null);
        goto L26
    L14:
        this.mApnType.setText(sApnDefault);
        TitleSummaryItem r35 = this.mApnType;
        OCardListItemUtils.setCustomEndTipTextView(r35, r35.getText());
        goto L16
    L7:
        if ("APN_NAME_CTNET".equals(this.mApnData.getString(1)) == false) goto L9;
        this.mName.setText("CTNET");
        goto L11
    L9:
        this.mName.setText(this.mApnData.getString(1));
        goto L11
    }

    private String protocolDescription(String r2, TitleSummaryItem r3) {
        int r4 = r3.findIndexOfValue(r2);
        if (r4 != (-1)) goto L9;
        return null;
    L9:
        return this.mRes.getStringArray(R.array.apn_protocol_entries)[r4];
    L8:
        return null;
    }

    private String bearerDescription(String r3) {
        int r4 = this.mBearer.findIndexOfValue(r3);
        if (r4 != (-1)) goto L9;
        return null;
    L9:
        return this.mRes.getStringArray(R.array.bearer_entries)[r4];
    L8:
        return null;
    }

    private String mvnoDescription(String r7) {
        int r0 = this.mMvnoType.findIndexOfValue(r7);
        String r1 = this.mMvnoType.getValue();
        if (r0 != (-1)) goto L5;
        return null;
    L5:
        String[] r2 = this.mRes.getStringArray(R.array.mvno_type_entries);
        TitleSummaryItem r4 = this.mMvnoMatchData;
        if (r0 == 0) goto L8;
        boolean r5 = true;
    L9:
        OCardListItemUtils.setContentContainerEnabled(r4, r5);
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

    private void showErrowDialog(String r3) {
        new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(r3, true).positiveButton(R.string.ok, new AnonymousClass2(this)).show();
    }

    boolean setStringValueAndCheckIfDiff(ContentValues r1, String r2, String r3, boolean r4, int r5) {
        String r0 = this.mApnData.getString(r5);
        if (r4 == false) goto L5;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L17;
        if (r3 == null) goto L17;
        r1.put(r2, r3);
    L17:
        return r6;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L7;
    L8:
        if (r3 == null) goto L13;
        if (r3.equals(r0) == false) goto L13;
    L12:
        r6 = false;
        goto L14
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L12;
        goto L8
    }

    boolean setIntValueAndCheckIfDiff(ContentValues r1, String r2, int r3, boolean r4, int r5) {
        Integer r0 = this.mApnData.getInteger(r5);
        if (r4 == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        r1.put(r2, Integer.valueOf(r3));
    L11:
        return r6;
    L5:
        if (r3 != r0.intValue()) goto L8;
        r6 = false;
        goto L9
    }

    boolean validateAndSaveApnData() {
        String r0 = checkNotSet(this.mName.getText());
        String r5 = checkNotSet(this.mApn.getText());
        String r1 = checkNotSet(this.mMcc.getText());
        String r12 = checkNotSet(this.mMnc.getText());
        String r2 = getErrorMsg();
        if (r2 == null) goto L6;
        showErrowDialog(r2);
        return false;
    L6:
        ContentValues r13 = new ContentValues();
        boolean r10 = this.mNewApn;
        if (r0.length() >= 1) goto L9;
        r0 = this.mRes.getString(R.string.untitled_apn);
    L9:
        boolean r6 = setStringValueAndCheckIfDiff(r13, "mmsc", checkNotSet(this.mMmsc.getText()), setStringValueAndCheckIfDiff(r13, "password", checkNotSet(this.mPassword.getText()), setStringValueAndCheckIfDiff(r13, "server", checkNotSet(this.mServer.getText()), setStringValueAndCheckIfDiff(r13, PickApplicationActivity.EXTRA_USER, checkNotSet(this.mUser.getText()), setStringValueAndCheckIfDiff(r13, "mmsport", checkNotSet(this.mMmsPort.getText()), setStringValueAndCheckIfDiff(r13, "mmsproxy", checkNotSet(this.mMmsProxy.getText()), setStringValueAndCheckIfDiff(r13, ClientCookie.PORT_ATTR, checkNotSet(this.mPort.getText()), setStringValueAndCheckIfDiff(r13, "proxy", checkNotSet(this.mProxy.getText()), setStringValueAndCheckIfDiff(r13, "apn", r5, setStringValueAndCheckIfDiff(r13, "name", r0, r10, 1), 2), 3), 4), 12), 13), 5), 6), 7), 8);
        String r3 = this.mAuthType.getValue();
        if (r3 == null) goto L12;
        r6 = setIntValueAndCheckIfDiff(r13, "authtype", Integer.parseInt(r3), r6, 14);
    L12:
        boolean r4 = setStringValueAndCheckIfDiff(r13, DataServiceUtils.SubscriptionInfoData.COLUMN_MNC, r12, setStringValueAndCheckIfDiff(r13, DataServiceUtils.SubscriptionInfoData.COLUMN_MCC, r1, setStringValueAndCheckIfDiff(r13, "type", checkNotSet(this.mApnType.getText()), setStringValueAndCheckIfDiff(r13, "roaming_protocol", checkNotSet(this.mRoamingProtocol.getValue()), setStringValueAndCheckIfDiff(r13, "protocol", checkNotSet(this.mProtocol.getValue()), r6, 16), 20), 15), 9), 10);
        r13.put("numeric", r1 + r12);
        String r7 = this.mCurMnc;
        if (r7 != null) goto L15;
    L21:
        TitleSummaryItem r8 = this.mBearer;
        boolean r9 = setIntValueAndCheckIfDiff(r13, "carrier_enabled", this.mCarrierEnabled.isChecked() ? 1 : 0, setStringValueAndCheckIfDiff(r13, ApnSettings.MVNO_MATCH_DATA, checkNotSet(this.mMvnoMatchData.getText()), setStringValueAndCheckIfDiff(r13, ApnSettings.MVNO_TYPE, checkNotSet(this.mMvnoType.getValue()), setIntValueAndCheckIfDiff(r13, "bearer", r8.findIndexOfValue(r8.getValue()), r4, 18), 21), 22), 17);
        r13.put("edited", 1);
        if (r9 == true) goto L24;
    L28:
        return true;
    L24:
        if (this.mApnData.getUri() != null) goto L26;
        Uri r11 = this.mCarrierUri;
    L27:
        updateApnDataToDatabase(r11, r13);
        goto L28
    L26:
        r11 = this.mApnData.getUri();
        goto L27
    L15:
        if (this.mCurMcc == null) goto L21;
        if (r7.equals(r12) == false) goto L21;
        if (this.mCurMcc.equals(r1) == false) goto L21;
        r13.put(PerfConsts.KEY_CURRENT_GALVANIC, 1);
        goto L21
    }

    private void updateApnDataToDatabase(final Uri r2, final ContentValues r3) {
        ThreadUtils.postOnBackgroundThread(new ApnEditorActivity$$ExternalSyntheticLambda0(this, r2, r3));
    }

    /* JADX INFO: renamed from: lambda$updateApnDataToDatabase$0$com-android-settings-ApnEditorActivity, reason: not valid java name */
    /* synthetic */ void m98x296b6cba(Uri r2, ContentValues r3) {
        if (r2.equals(this.mCarrierUri) == true) goto L5;
        getContentResolver().update(r2, r3, null, null);
        return;
    L5:
        if (getContentResolver().insert(this.mCarrierUri, r3) != null) goto L9;
        OLog.e(TAG, "Can't add a new apn to database " + this.mCarrierUri);
        return;
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
        if (this.mApnData.getUri() == null) goto L6;
        getContentResolver().delete(this.mApnData.getUri(), null, null);
        this.mApnData = new ApnData(sProjection.length);
        return;
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

    private String checkApnTypeNull(String r1) {
        if (r1 == null) goto L8;
        if (r1.length() == 0) goto L8;
        return r1;
    L8:
        return sApnDefault;
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

    private void setDefaultData() {
        CarrierConfigManager r0 = (CarrierConfigManager) getSystemService("carrier_config");
        if (r0 == null) goto L16;
        PersistableBundle r1 = r0.getConfigForSubId(this.mSubId);
        if (r1 == null) goto L22;
        PersistableBundle r2 = r1.getPersistableBundle(APN_DEFALUT_VALUES_STRING_ARRAY);
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.isEmpty() == true) goto L24;
        Iterator<String> r3 = r2.keySet().iterator();
    L12:
        if (r3.hasNext() == false) goto L25;
        String r4 = r3.next();
        if (fieldValidate(r4) == false) goto L12;
        setAppData(r4, r2.get(r4));
        goto L12
    L25:
        return;
    L24:
        return;
    L22:
        return;
    }

    private void setAppData(String r1, Object r2) {
        int r3 = findIndexOfKey(r1);
        if (r3 < 0) goto L6;
        this.mApnData.setObject(r3, r2);
        return;
    }

    private int findIndexOfKey(String r3) {
        int r2 = 0;
    L3:
        String[] r0 = sProjection;
        if (r2 >= r0.length) goto L9;
        if (r0[r2].equals(r3) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return r2;
    L9:
        return -1;
    }

    private boolean fieldValidate(String r5) {
        String[] r4 = sUIConfigurableItems;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].equalsIgnoreCase(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        OLog.w(TAG, r5 + " is not configurable");
        return false;
    }

    private void showEditDialog(final TitleSummaryItem r3) {
        ApnEditorItemFragment r0 = new ApnEditorItemFragment(r3);
        r0.setOnClickListener(new AnonymousClass3(this, r3));
        r0.show(getSupportFragmentManager(), "Apn item editor");
    }

    private void showPopMenu(final TitleSummaryItem r10) {
        final CharSequence[] r0 = r10.getEntries();
        final CharSequence[] r1 = r10.getEntryValues();
        if (r0 == null) goto L28;
        if (r0.length == 0) goto L28;
        if (r1 == null) goto L26;
        if (r1.length == 0) goto L26;
        int r2 = r10.findIndexOfValue(r10.getValue());
        if (r2 < (-1)) goto L24;
        if (r2 >= r0.length) goto L24;
        ArrayList r3 = new ArrayList();
        int r5 = 0;
    L14:
        boolean r7 = true;
        if (r5 >= r0.length) goto L21;
        String r8 = r0[r5].toString();
        if (r5 == r2) goto L20;
        r7 = false;
    L20:
        r3.add(new Item(r8, r7));
        r5 = r5 + 1;
        goto L14
    L21:
        this.mPopover = OPopoverHelper.showPopoverList(this.mActivity, r10.getCardContainer(), r3, new AnonymousClass4(this, r10, r1, r0), true);
        return;
    L24:
        throw new IllegalArgumentException("illegal index " + r2);
    L26:
        throw new IllegalArgumentException("entryValues is empty");
    L28:
        throw new IllegalArgumentException("entries is empty");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (this.mRightBtn != r3) goto L8;
        if (validateAndSaveApnData() == false) goto L21;
        finish();
        return;
    L21:
        return;
    L8:
        if (this.mEditAble == true) goto L19;
        return;
    L19:
        TitleSummaryItem r4 = (TitleSummaryItem) findViewById(((Integer) r3.getTag()).intValue());     // Catch: Exception -> L17
        if (r4.getType() != 0) goto L14;
        showEditDialog(r4);     // Catch: Exception -> L17
    L18:
        return;
    L14:
        if (r4.getType() != 1) goto L18;
        showPopMenu(r4);     // Catch: Exception -> L17
    }

    ApnData getApnDataFromUri(Uri r7) {
        Cursor r6 = getContentResolver().query(r7, sProjection, null, null, null);
        if (r6 != null) goto L23;
    L15:
        ApnData r0 = null;
    L16:
        if (r6 == null) goto L18;
        r6.close();
    L18:
        if (r0 != null) goto L20;
        OLog.d(TAG, "Can't get apnData from Uri " + r7);
    L20:
        return r0;
    L23:
    L8:
        th = move-exception;
        if (r6 != null) goto L21;
    L14:
        throw th;
    L21:
        r6.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    L5:
        if (r6.moveToFirst() == false) goto L15;
        r0 = new ApnData(r7, r6);     // Catch: Throwable -> L8
        goto L16
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ApnEditorActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ApnEditorActivity r1) {
        com_android_settings_ApnEditorActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_ApnEditorActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ApnEditorActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ApnEditorActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ApnEditorActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ApnEditorActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ApnEditorActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_ApnEditorActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ApnEditorActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ApnEditorActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ApnEditorActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ApnEditorActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_ApnEditorActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ApnEditorActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_ApnEditorActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ApnEditorActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ApnEditorActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_ApnEditorActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_ApnEditorActivity_com_obric_hook_lancet_PrivacyHook_onResume(ApnEditorActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ApnEditorActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_ApnEditorActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_ApnEditorActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ApnEditorActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ApnEditorActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_ApnEditorActivity_com_obric_hook_lancet_PrivacyHook_onPause(ApnEditorActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ApnEditorActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_ApnEditorActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ApnEditorActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ApnEditorActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_ApnEditorActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ApnEditorActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_ApnEditorActivity_com_obric_hook_lancet_PrivacyHook_onStop(ApnEditorActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ApnEditorActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_ApnEditorActivity__onStop$___twin___();
    }
}
