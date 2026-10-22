package com.android.settings;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserManager;
import android.provider.Telephony;
import android.telephony.CarrierConfigManager;
import android.telephony.ServiceState;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import bytedanceos.util.Features;
import com.GlobalProxyLancet;
import com.android.ims.ImsManager;
import com.android.internal.telephony.ITelephony;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.telephony.uicc.IccRecords;
import com.android.internal.telephony.uicc.UiccController;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ApnSettings extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, View.OnLongClickListener {
    private static final String ACTION_VOLTE_ENABLED_STATE_CHANGED = "org.codeaurora.intent.action.ACTION_ENHANCE_4G_SWITCH";
    private static final String APN_HIDE_RULE_STRINGS_ARRAY = "apn_hide_rule_strings_array";
    private static final String APN_HIDE_RULE_STRINGS_WITH_ICCIDS_ARRAY = "apn_hide_rule_strings_with_iccids_array";
    public static final String APN_ID = "apn_id";
    private static final int APN_INDEX = 2;
    private static final String APN_NAME_DM = "CMCC DM";
    private static final int BEARER_BITMASK_INDEX = 8;
    private static final int BEARER_INDEX = 7;
    private static final String CHOOSE_APN = "choose_vpn";
    private static final String CT_ALLOW_SHOW_APNS = "ctnet,ims";
    private static final Uri DEFAULTAPN_URI = null;
    private static final int DIALOG_RESTORE_DEFAULTAPN = 1001;
    private static final int EVENT_RESTORE_DEFAULTAPN_COMPLETE = 2;
    private static final int EVENT_RESTORE_DEFAULTAPN_START = 1;
    public static final String EXTRA_POSITION = "position";
    public static final boolean FOR_CT_TEST_ONLY = false;
    private static final int ID_INDEX = 0;
    private static final String INCLUDE_COMMON_RULES = "include_common_rules";
    public static final String MVNO_MATCH_DATA = "mvno_match_data";
    private static final int MVNO_MATCH_DATA_INDEX = 5;
    public static final String MVNO_TYPE = "mvno_type";
    private static final int MVNO_TYPE_INDEX = 4;
    private static final int NAME_INDEX = 1;
    public static final String OPERATOR_NUMERIC_EXTRA = "operator";
    private static final Uri PREFERAPN_URI = null;
    public static final String PREFERRED_APN_URI = "content://telephony/carriers/preferapn";
    private static final String PREFERRED_APN_USING_SUBID_URI = "content://telephony/carriers/preferapn/subId";
    public static final String RESTORE_CARRIERS_URI = "content://telephony/carriers/restore";
    private static final String RESTORE_CARRIERS_USING_SUBID_URI = "content://telephony/carriers/restore/subId";
    private static final int RO_INDEX = 6;
    public static final String SUB_ID = "sub_id";
    static final String TAG = "ApnSettings";
    private static final int TYPES_INDEX = 3;
    private static boolean mRestoreDefaultApnMode;
    private boolean mAllowAddingApns;
    private boolean mApnSettingsHidden;
    private OButton mBtnReset;
    private ArrayList<ApnItem> mData;
    private OAlertDialog mDeleteConfirmDialog;
    private PersistableBundle mHideApnsGroupByIccid;
    private String[] mHideApnsWithIccidRule;
    private String[] mHideApnsWithRule;
    private boolean mHideImsApn;
    private boolean mHidePresetApnDetails;
    private ListView mList;
    private IntentFilter mMobileStateFilter;
    private final BroadcastReceiver mMobileStateReceiver;
    private String mMvnoMatchData;
    private String mMvnoType;
    private RestoreApnProcessHandler mRestoreApnProcessHandler;
    private RestoreApnUiHandler mRestoreApnUiHandler;
    private HandlerThread mRestoreDefaultApnThread;
    private View mRightButton;
    private String mSelectedKey;
    private int mSubId;
    private SubscriptionInfo mSubscriptionInfo;
    private int mTitleStringResId;
    private UiccController mUiccController;
    private boolean mUnavailable;
    private Uri mUri;
    private UserManager mUserManager;

    /* JADX INFO: renamed from: com.android.settings.ApnSettings$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$android$internal$telephony$PhoneConstants$DataState = null;

        static {
            int[] r0 = new int[PhoneConstants.DataState.values().length];
            $SwitchMap$com$android$internal$telephony$PhoneConstants$DataState = r0;
            r0[PhoneConstants.DataState.CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    private class ApnItemAdapter extends BaseAdapter {
        final /* synthetic */ ApnSettings this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private ApnItemAdapter(ApnSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ApnItemAdapter(ApnSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$900(ApnItemAdapter r0, String r1) {
            r0.updateSelectedApnView(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (ApnSettings.access$800(this.this$0) != null) goto L6;
            return 0;
        L6:
            return ApnSettings.access$800(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return ApnSettings.access$800(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            ApnSettings r8 = this.this$0;
            final ApnItem r0 = (ApnItem) ApnSettings.access$800(r8).get(r5);
            if (r6 != null) goto L5;
            final OCardListItem r9 = new OCardListItem(r8);
        L6:
            r9.setTitle(r0.getTitle());
            int r10 = 1;
            r9.showTitle(true);
            r9.setSubTitle(r0.getSummary());
            r9.showSubTitle(true);
            if (r0.getSelectable() == false) goto L13;
            OCardListItemUtils.setCustomEndImageView(r9);
            r9.getCustomEndView().setClickable(r0.getSelectable());
            View r1 = r9.getCustomEndView();
            if (r0.isChecked() == false) goto L11;
            float r3 = 1.0f;
        L12:
            r1.setAlpha(r3);
            r9.getCustomEndView().setOnClickListener(new AnonymousClass1(this));
            r9.getCustomEndView().setTag(r0);
            r9.setDefaultTailIcon(0);
            r9.showTailIcon(false);
        L14:
            r9.getContentContainer().setTag(r0);
            r9.setOnContentClickListener(this.this$0);
            r9.setOnContentLongClickListener(this.this$0);
            if (ApnSettings.access$1100(this.this$0, r0) == false) goto L27;
            r9.setSwipeView(R.layout.layout_card_list_item_delete_swip);
            r9.setEnableSwipe(true);
            if (r9.getSwipeView() == null) goto L19;
            OIconButton r2 = (OIconButton) r9.getSwipeView().findViewById(R.id.btn_delete);
            r2.setTag(r0);
            r2.setOnClickListener(new AnonymousClass2(this));
        L19:
            OSwipeLayout r4 = r9.getSwipeLayout();
            if (r4 != null) goto L22;
        L28:
            if (r5 != 0) goto L34;
            if (getCount() != 1) goto L32;
            r10 = 0;
        L32:
            r9.setCardPosition(r10);
        L37:
            return r9;
        L34:
            if (r5 != (getCount() - 1)) goto L36;
            r9.setCardPosition(3);
            goto L37
        L36:
            r9.setCardPosition(2);
            goto L37
        L22:
            if (r4.getTag() != null) goto L24;
        L26:
            OSwipeLayout.SwipeListener r11 = new AnonymousClass3(this, r9, r0);
            r4.addSwipeListener(r11);
            r4.setTag(r11);
            goto L28
        L24:
            if ((r4.getTag() instanceof OSwipeLayout.SwipeListener) == false) goto L26;
            r4.removeSwipeListener((OSwipeLayout.SwipeListener) r4.getTag());
            goto L26
        L27:
            r9.setEnableSwipe(false);
            goto L28
        L11:
            r3 = 0.0f;
            goto L12
        L13:
            OCardListItemUtils.setCustomEndTipTextView(r9, this.this$0.getString(R.string.can_not_choose));
            r9.setDefaultTailIcon(0);
            r9.showTailIcon(true);
            goto L14
        L5:
            r9 = (OCardListItem) r6;
            goto L6
        }

        private void updateSelectedApnView(String r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (ApnSettings.access$800(this.this$0) == null) goto L14;
            Iterator r0 = ApnSettings.access$800(this.this$0).iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            ApnItem r1 = (ApnItem) r0.next();
            r1.setChecked(r1.getKey().equals(r4));
            goto L8
        L10:
            notifyDataSetChanged();
            return;
        }
    }

    private class RestoreApnProcessHandler extends Handler {
        private Handler mRestoreApnUiHandler;
        final /* synthetic */ ApnSettings this$0;

        public RestoreApnProcessHandler(ApnSettings r1, Looper r2, Handler r3) {
            this.this$0 = r1;
            super(r2);
            this.mRestoreApnUiHandler = r3;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            if (r3.what != 1) goto L11;
            ContentResolver r4 = this.this$0.getContentResolver();
            if (MultiSimAdapter.isMultiSimEnabled() == false) goto L8;
            Uri r0 = Uri.parse("content://telephony/carriers/restore/subId/" + ApnSettings.access$600(this.this$0));
        L9:
            r4.delete(r0, null, null);
            this.mRestoreApnUiHandler.sendEmptyMessage(2);
            return;
        L8:
            r0 = ApnSettings.access$700();
            goto L9
        }
    }

    private class RestoreApnUiHandler extends Handler {
        final /* synthetic */ ApnSettings this$0;

        private RestoreApnUiHandler(ApnSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ RestoreApnUiHandler(ApnSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            if (r2.what != 2) goto L7;
            ApnSettings.access$200(this.this$0);
            ApnSettings.access$500(this.this$0).setEnabled(true);
            ApnSettings.access$102(false);
            this.this$0.removeDialog(1001);
            ApnSettings r1 = this.this$0;
            ToastUtils.show(r1, r1.getResources().getString(R.string.restore_default_apn_completed));
            return;
        }
    }

    private int networkTypeToRilRidioTechnology(int r1) {
        switch(r1) {
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L3;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            case 20: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 20;
    L7:
        return 19;
    L9:
        return 18;
    L11:
        return 17;
    L13:
        return 16;
    L15:
        return 15;
    L17:
        return 13;
    L19:
        return 14;
    L21:
        return 12;
    L23:
        return 11;
    L25:
        return 10;
    L27:
        return 9;
    L29:
        return 6;
    L31:
        return 8;
    L33:
        return 7;
    L35:
        return 5;
    L37:
        return 3;
    L39:
        return 2;
    L41:
        return 1;
    }

    public void com_android_settings_ApnSettings__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_ApnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_settings_ApnSettings_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_ApnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_ApnSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_ApnSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_ApnSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ApnSettings() {
        this.mMobileStateReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ PhoneConstants.DataState access$000(Intent r0) {
        return getMobileDataState(r0);
    }

    static /* synthetic */ boolean access$100() {
        return mRestoreDefaultApnMode;
    }

    static /* synthetic */ void access$1000(ApnSettings r0, String r1) {
        r0.setSelectedApnKey(r1);
    }

    static /* synthetic */ boolean access$102(boolean r0) {
        mRestoreDefaultApnMode = r0;
        return r0;
    }

    static /* synthetic */ boolean access$1100(ApnSettings r0, ApnItem r1) {
        return r0.isApnEditable(r1);
    }

    static /* synthetic */ Uri access$1200(ApnSettings r0) {
        return r0.mUri;
    }

    static /* synthetic */ Uri access$1202(ApnSettings r0, Uri r1) {
        r0.mUri = r1;
        return r1;
    }

    static /* synthetic */ void access$1300(ApnSettings r0) {
        r0.showDeleteConfirmDialog();
    }

    static /* synthetic */ OAlertDialog access$1400(ApnSettings r0) {
        return r0.mDeleteConfirmDialog;
    }

    static /* synthetic */ void access$200(ApnSettings r0) {
        r0.fillList();
    }

    static /* synthetic */ ListView access$500(ApnSettings r0) {
        return r0.mList;
    }

    static /* synthetic */ int access$600(ApnSettings r0) {
        return r0.mSubId;
    }

    static /* synthetic */ Uri access$700() {
        return DEFAULTAPN_URI;
    }

    static /* synthetic */ ArrayList access$800(ApnSettings r0) {
        return r0.mData;
    }

    static {
        FOR_CT_TEST_ONLY = "ct".equals(SystemProperties.get("ro.build.operator", "open"));
        DEFAULTAPN_URI = Uri.parse(RESTORE_CARRIERS_URI);
        PREFERAPN_URI = Uri.parse(PREFERRED_APN_URI);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (this.mRightButton != r5) goto L6;
        addNewApn();
        return;
    L6:
        if (this.mBtnReset != r5) goto L8;
        restoreDefaultApn();
        return;
    L8:
        ApnItem r6 = (ApnItem) r5.getTag();
        Intent r1 = new Intent("android.intent.action.EDIT", ContentUris.withAppendedId(Telephony.Carriers.CONTENT_URI, Integer.parseInt(r6.getKey())));
        r1.setPackage("com.android.settings");
        r1.putExtra("title", getResources().getString(R.string.apn_deitor_title_edit));
        r1.putExtra("back_text_id", this.mTitleStringResId);
        r1.putExtra(ApnEditorActivity.EXTRA_EDITABLE, isApnEditable(r6));
        Utils.startActivity(this, r1);
    }

    private void addNewApn() {
        Intent r0 = new Intent("android.intent.action.INSERT", Telephony.Carriers.CONTENT_URI);
        r0.setPackage("com.android.settings");
        r0.putExtra("title", getResources().getString(R.string.apn_deitor_title_new));
        r0.putExtra("back_text_id", this.mTitleStringResId);
        SubscriptionInfo r1 = this.mSubscriptionInfo;
        if (r1 == null) goto L5;
        int r2 = r1.getSubscriptionId();
    L6:
        r0.putExtra(SUB_ID, r2);
        r0.putExtra("operator", getOperatorNumeric());
        if (TextUtils.isEmpty(this.mMvnoType) == false) goto L9;
    L11:
        Utils.startActivity(this, r0);
        return;
    L9:
        if (TextUtils.isEmpty(this.mMvnoMatchData) == true) goto L11;
        r0.putExtra(MVNO_TYPE, this.mMvnoType);
        r0.putExtra(MVNO_MATCH_DATA, this.mMvnoMatchData);
        goto L11
    L5:
        r2 = -1;
        goto L6
    }

    private static PhoneConstants.DataState getMobileDataState(Intent r1) {
        String r2 = r1.getStringExtra("state");
        if (r2 == null) goto L9;
        return Enum.valueOf(PhoneConstants.DataState.class, r2);
    L7:
        return PhoneConstants.DataState.DISCONNECTED;
    L9:
        return PhoneConstants.DataState.DISCONNECTED;
    }

    public void com_android_settings_ApnSettings__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        this.mUserManager = UserManager.get(this);
        if (isUserRestricted() == false) goto L6;
        OLog.e(TAG, "This setting isn't available due to user restriction.");
        this.mUnavailable = true;
        finish();
        return;
    L6:
        setContentView(R.layout.apn_settings_layout);
        int r6 = Utils.getIntExtraSafely(getIntent(), "slot", MultiSimAdapter.getDefaultDataSlot());
        this.mSubId = MultiSimAdapter.slot2Sub(r6);
        OLog.d(TAG, "onCreate slot:" + r6 + ", sub:" + this.mSubId);
        this.mTitleStringResId = R.string.mobile_network_vpn;
        this.mList = (ListView) findViewById(R.id.view_list);
        OButton r7 = (OButton) findViewById(R.id.item_apn_reset);
        this.mBtnReset = r7;
        r7.setOnClickListener(this);
        this.mMobileStateFilter = new IntentFilter("android.intent.action.ANY_DATA_STATE");
        this.mSubscriptionInfo = SubscriptionManager.from(this).getActiveSubscriptionInfo(this.mSubId);
        View r8 = this.mTitle.addEndAction(R.drawable.oui_icon_oic_plus, -1, null);
        this.mRightButton = r8;
        r8.setOnClickListener(this);
        this.mBackView = this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass2(this));
        PersistableBundle r9 = ((CarrierConfigManager) getSystemService("carrier_config")).getConfigForSubId(this.mSubId);
        this.mHideImsApn = r9.getBoolean("hide_ims_apn_bool");
        this.mAllowAddingApns = r9.getBoolean("allow_adding_apns_bool");
        this.mHideApnsWithRule = r9.getStringArray(APN_HIDE_RULE_STRINGS_ARRAY);
        this.mHideApnsWithIccidRule = r9.getStringArray(APN_HIDE_RULE_STRINGS_WITH_ICCIDS_ARRAY);
        SubscriptionInfo r1 = this.mSubscriptionInfo;
        if (r1 == null) goto L10;
        String r2 = r1.getIccId();
        OLog.d(TAG, "iccid: " + r2);
        this.mHideApnsGroupByIccid = r9.getPersistableBundle(r2);
    L10:
        if (this.mAllowAddingApns == true) goto L12;
    L14:
        this.mHidePresetApnDetails = r9.getBoolean("hide_preset_apn_details_bool");
        return;
    L12:
        if (ApnEditor.hasAllApns(r9.getStringArray("read_only_apn_types_string_array")) == false) goto L14;
        OLog.d(TAG, "not allowing adding APN because all APN types are read only");
        this.mAllowAddingApns = false;
        goto L14
    }

    boolean isUserRestricted() {
        UserManager r0 = this.mUserManager;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.isAdminUser() == true) goto L10;
        OLog.e(TAG, "User is not an admin");
        return true;
    L10:
        if (this.mUserManager.hasUserRestriction("no_config_mobile_networks") == false) goto L13;
        OLog.e(TAG, "User is not allowed to configure mobile network");
        return true;
    L13:
        return false;
    }

    public void com_android_settings_ApnSettings__onStop$___twin___() {
        super.onStop();
        this.mApnSettingsHidden = true;
    }

    public void com_android_settings_ApnSettings__onResume$___twin___() {
        super.onResume();
        if (this.mUnavailable == false) goto L5;
        return;
    L5:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mMobileStateReceiver, this.mMobileStateFilter, 2);
        if (mRestoreDefaultApnMode == true) goto L8;
        fillList();
    L8:
        this.mApnSettingsHidden = false;
    }

    public void com_android_settings_ApnSettings__onPause$___twin___() {
        super.onPause();
        if (this.mUnavailable == false) goto L5;
        return;
    L5:
        unregisterReceiver(this.mMobileStateReceiver);
        if (isConfirmDialogShowing() == false) goto L9;
        this.mDeleteConfirmDialog.dismiss();
        return;
    }

    public void com_android_settings_ApnSettings__onDestroy$___twin___() {
        super.onDestroy();
        HandlerThread r0 = this.mRestoreDefaultApnThread;
        if (r0 == null) goto L6;
        r0.quit();
        return;
    }

    private String getOperatorNumeric() {
        TelephonyManager r0 = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
        if (this.mSubscriptionInfo != null) goto L14;
    L12:
        return "";
    L14:
    L16:
        return (String) TelephonyManager.class.getMethod("getSimOperator", new Class[]{Integer.TYPE}).invoke(r0, new Object[]{Integer.valueOf(this.mSubscriptionInfo.getSubscriptionId())});
    L6:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private void fillList() {
        String r8 = getOperatorNumeric();
        OLog.d(TAG, "mccmnc = " + r8);
        StringBuilder r1 = new StringBuilder("numeric=\"" + r8 + "\" AND NOT (type='ia' AND (apn=\"\" OR apn IS NULL)) AND user_visible!=0");
        r1.append(" AND NOT (type='emergency')");
        SubscriptionInfo r2 = this.mSubscriptionInfo;
        if (r2 == null) goto L5;
        int r3 = r2.getSubscriptionId();
    L6:
        int r10 = r3;
        int r4 = SubscriptionManager.getPhoneId(r10);
        Context r5 = getApplicationContext();
        boolean r6 = ImsManager.getInstance(r5, r4).isEnhanced4gLteModeSettingEnabledByUser();
        if (this.mHideImsApn == false) goto L9;
    L11:
        r1.append(" AND NOT (type='ims')");
    L12:
        appendFilter(r1);
        String[] r7 = {"_id", "name", "apn", "type", MVNO_TYPE, MVNO_MATCH_DATA, "bearer", "bearer_bitmask", "user_editable"};     // Catch: Throwable -> L85 Exception -> L87
        Cursor r12 = getContentResolver().query(Uri.withAppendedPath(Telephony.Carriers.SIM_APN_URI, String.valueOf(r10)), r7, r1.toString(), null, "name ASC");     // Catch: Throwable -> L85 Exception -> L87
        if (r12 != null) goto L99;
    L78:
        this.mList.setAdapter(new ApnItemAdapter(this, null));     // Catch: Throwable -> L81 Exception -> L83
        if (r12 == null) goto L110;
        r12.close();
        return;
    L110:
        return;
    L83:
        e = e;
        Cursor r11 = r12;
    L97:
        e.printStackTrace();     // Catch: Throwable -> L93
        if (r11 == null) goto L112;
        r11.close();
        return;
    L112:
        return;
    L93:
        th = th;
    L94:
        if (r11 == null) goto L96;
        r11.close();
    L96:
        throw th;
    L81:
        th = th;
        r11 = r12;
        goto L94
    L99:
        this.mData = new ArrayList();     // Catch: Throwable -> L81 Exception -> L83
        ArrayList<ApnItem> r14 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L83
        ArrayList<ApnItem> r15 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L83
        ArrayList<ApnItem> r16 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L83
        ArrayList<ApnItem> r17 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L83
        this.mSelectedKey = getSelectedApnKey();     // Catch: Throwable -> L81 Exception -> L83
        r12.moveToFirst();     // Catch: Throwable -> L81 Exception -> L83
        boolean r18 = false;
    L17:
        if (r12.isAfterLast() == true) goto L62;
        String r9 = r12.getString(r12.getColumnIndex("name"));     // Catch: Throwable -> L81 Exception -> L83
        String r13 = r12.getString(r12.getColumnIndex("apn"));     // Catch: Throwable -> L81 Exception -> L83
        String r19 = r12.getString(r12.getColumnIndex("_id"));     // Catch: Throwable -> L81 Exception -> L83
        String r20 = r12.getString(r12.getColumnIndex("type"));     // Catch: Throwable -> L81 Exception -> L83
        String r21 = r12.getString(r12.getColumnIndex(MVNO_TYPE));     // Catch: Throwable -> L81 Exception -> L83
        String r22 = r12.getString(r12.getColumnIndex(MVNO_MATCH_DATA));     // Catch: Throwable -> L81 Exception -> L83
        if (r12.getInt(r12.getColumnIndex("user_editable")) != 0) goto L21;
        boolean r110 = true;
    L22:
        int r111 = r12.getInt(r12.getColumnIndex("bearer"));     // Catch: Throwable -> L81 Exception -> L83
        int r23 = r12.getInt(r12.getColumnIndex("bearer_bitmask"));     // Catch: Throwable -> L81 Exception -> L83
        ArrayList<ApnItem> r24 = r15;
        ArrayList<ApnItem> r25 = r14;
        OLog.d(TAG, "name " + r9 + ", apn " + r13 + ", key " + r19 + ", type " + r20 + ",mvnoType " + r21 + ",mvnoMatchData " + r22 + ",readOnly " + r110 + ",bearer " + r111);     // Catch: Throwable -> L81 Exception -> L83
        int r112 = ServiceState.getBitmaskForTech(r111) | r23;     // Catch: Throwable -> L81 Exception -> L83
        int r113 = networkTypeToRilRidioTechnology(TelephonyManager.getDefault().getDataNetworkType(r10));     // Catch: Throwable -> L81 Exception -> L83
        if (ServiceState.bitmaskHasTech(r112, r113) == true) goto L31;
        if (r111 != 0) goto L26;
        if (r23 == 0) goto L31;
    L26:
        if (r113 != 0) goto L29;
        if (r111 != 0) goto L31;
        if (r113 != 0) goto L31;
    L29:
        r12.moveToNext();     // Catch: Throwable -> L81 Exception -> L83
        OLog.d(TAG, "ignore for invalid radioTech");     // Catch: Throwable -> L81 Exception -> L83
    L40:
        r15 = r24;
        r14 = r25;
    L31:
        if (TextUtils.isEmpty(r13) == false) goto L34;
        r12.moveToNext();     // Catch: Throwable -> L81 Exception -> L83
        goto L40
    L34:
        if (FOR_CT_TEST_ONLY == true) goto L36;
    L41:
        ApnItem r26 = new ApnItem();     // Catch: Throwable -> L81 Exception -> L83
        r26.setReadOnly(r110);     // Catch: Throwable -> L81 Exception -> L83
        r26.setTitle(normalize(r9, r8));     // Catch: Throwable -> L81 Exception -> L83
        r26.setSummary(r13);     // Catch: Throwable -> L81 Exception -> L83
        r26.setKey(r19);     // Catch: Throwable -> L81 Exception -> L83
        if (r20 != null) goto L44;
    L51:
        boolean r27 = true;
    L52:
        r26.setSelectable(r27);     // Catch: Throwable -> L81 Exception -> L83
        if (r27 == false) goto L60;
        String r28 = this.mSelectedKey;     // Catch: Throwable -> L81 Exception -> L83
        if (r28 != null) goto L57;
    L59:
        addApnToList(r26, r25, r24, null, r21, r22);     // Catch: Throwable -> L81 Exception -> L83
    L61:
        r12.moveToNext();     // Catch: Throwable -> L81 Exception -> L83
        goto L40
    L57:
        if (r28.equals(r19) == false) goto L59;
        r26.setChecked(true);     // Catch: Throwable -> L81 Exception -> L83
        OLog.d(TAG, "find select key = " + this.mSelectedKey);     // Catch: Throwable -> L81 Exception -> L83
        r18 = true;
        goto L59
    L60:
        addApnToList(r26, r16, r17, null, r21, r22);     // Catch: Throwable -> L81 Exception -> L83
        goto L61
    L44:
        if (r20.equals(ApnEditor.APN_TYPE_MMS) == false) goto L46;
    L50:
        r27 = false;
        goto L52
    L46:
        if (r20.equals(ApnEditor.APN_TYPE_IA) == true) goto L50;
        if (r20.equalsIgnoreCase(ApnEditor.APN_TYPE_IMS) == true) goto L50;
    L36:
        if (isChinaTelecom(r8) == false) goto L41;
        if (isCTAllowApn(r13) == true) goto L41;
        r12.moveToNext();     // Catch: Throwable -> L81 Exception -> L83
        OLog.d(TAG, "not allow apn " + r13);     // Catch: Throwable -> L81 Exception -> L83
        goto L40
    L21:
        r110 = false;
        goto L22
    L62:
        ArrayList<ApnItem> r29 = r14;
        ArrayList<ApnItem> r210 = r15;
        if (r210.isEmpty() == true) goto L65;
        r16 = r17;
        ArrayList<ApnItem> r114 = r210;
    L66:
        Iterator<ApnItem> r30 = r114.iterator();     // Catch: Throwable -> L81 Exception -> L83
    L68:
        if (r30.hasNext() == false) goto L70;
        this.mData.add(r30.next());     // Catch: Throwable -> L81 Exception -> L83
        goto L68
    L70:
        if (r18 == false) goto L72;
    L74:
        Iterator<ApnItem> r31 = r16.iterator();     // Catch: Throwable -> L81 Exception -> L83
    L76:
        if (r31.hasNext() == false) goto L78;
        this.mData.add(r31.next());     // Catch: Throwable -> L81 Exception -> L83
        goto L76
    L72:
        if (this.mData.size() <= 0) goto L74;
        ApnItem r32 = this.mData.get(0);     // Catch: Throwable -> L81 Exception -> L83
        r32.setChecked(true);     // Catch: Throwable -> L81 Exception -> L83
        setSelectedApnKey(r32.getKey());     // Catch: Throwable -> L81 Exception -> L83
        OLog.d(TAG, "set key to  " + r32.getKey());     // Catch: Throwable -> L81 Exception -> L83
        goto L74
    L65:
        r114 = r29;
        goto L66
    L87:
        e = e;
        r11 = null;
    L85:
        th = th;
        r11 = null;
        goto L94
    L9:
        if (Utils.isSupportCTPA(r5) == false) goto L12;
        if (r6 == true) goto L12;
    L5:
        r3 = -1;
        goto L6
    }

    private void appendFilter(StringBuilder r10) {
        PersistableBundle r0 = this.mHideApnsGroupByIccid;
        boolean r3 = true;
        if (r0 != null) goto L5;
    L14:
        boolean r1 = true;
    L15:
        String[] r4 = this.mHideApnsWithIccidRule;
        if (r4 == null) goto L30;
        HashMap<String, String> r5 = getApnRuleMap(r4);
        SubscriptionInfo r6 = this.mSubscriptionInfo;
        if (r6 != null) goto L20;
        String r7 = "";
    L22:
        if (isOperatorIccid(r5, r7) == false) goto L30;
        String r2 = r5.get(INCLUDE_COMMON_RULES);
        if (r2 != null) goto L26;
    L29:
        OLog.d(TAG, "apn hidden rules in iccids, include common rule: " + r3);
        filterWithKey(r5, r10);
        r1 = r3;
        goto L30
    L26:
        if (r2.equalsIgnoreCase(String.valueOf(false)) == false) goto L29;
        r3 = false;
        goto L29
    L20:
        r7 = r6.getIccId();
    L30:
        if (r1 == false) goto L42;
        String[] r8 = this.mHideApnsWithRule;
        if (r8 == null) goto L43;
        filterWithKey(getApnRuleMap(r8), r10);
        return;
    L43:
        return;
    L42:
        return;
    L5:
        if (r0.isEmpty() == true) goto L14;
        r1 = this.mHideApnsGroupByIccid.getBoolean(INCLUDE_COMMON_RULES, true);
        OLog.d(TAG, "apn hidden rules specified iccid, include common rule: " + r1);
        Iterator<String> r9 = this.mHideApnsGroupByIccid.keySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L15;
        String r11 = r9.next();
        if (Utils.carrierTableFieldValidate(r11) == false) goto L8;
        String r12 = this.mHideApnsGroupByIccid.getString(r11);
        if (r12 == null) goto L8;
        r10.append(" AND " + r11 + " <> \"" + r12 + "\"");
        goto L8
    }

    private HashMap<String, String> getApnRuleMap(String[] r5) {
        HashMap<String, String> r4 = new HashMap();
        if (r5 == null) goto L11;
        int r0 = r5.length;
        OLog.d(TAG, "ruleArray size = " + r0);
        if (r0 <= 0) goto L11;
        if ((r0 % 2) != 0) goto L11;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L11;
        r4.put(r5[r1].toLowerCase(), r5[r1 + 1]);
        r1 = r1 + 2;
    L11:
        return r4;
    }

    private boolean isOperatorIccid(HashMap<String, String> r4, String r5) {
        String r3 = r4.get("iccid");
        if (TextUtils.isEmpty(r3) == true) goto L11;
        String[] r6 = r3.split(",");
        int r7 = r6.length;
        int r1 = 0;
    L5:
        if (r1 >= r7) goto L11;
        if (r5.startsWith(r6[r1].trim()) == true) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    private void filterWithKey(Map<String, String> r8, StringBuilder r9) {
        Iterator<String> r7 = r8.keySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L12;
        String r0 = r7.next();
        if (Utils.carrierTableFieldValidate(r0) == false) goto L4;
        String r1 = r8.get(r0);
        if (TextUtils.isEmpty(r1) == true) goto L4;
        String[] r2 = r1.split(",");
        int r3 = r2.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L4;
        r9.append(" AND " + r0 + " <> \"" + r2[r4] + "\"");
        r4 = r4 + 1;
        goto L10
    }

    private static boolean isChinaTelecom(String r6) {
        String[] r0 = {"46003", "46005", "46011", "46012", "45507", "45502"};
        int r2 = 0;
    L4:
        if (r2 >= 6) goto L10;
        if (TextUtils.equals(r6, r0[r2]) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private String normalize(String r9, String r10) {
        String r1 = null;
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        if (FOR_CT_TEST_ONLY == true) goto L8;
        ITelephony r2 = ITelephony.Stub.asInterface(ServiceManager.checkService(MultiSimAdapter.PHONE_KEY));
        if (r2 == null) goto L20;
        if (MultiSimAdapter.isMultiSimEnabled() == false) goto L17;
        String r8 = r2.getDisplayPlmnMsim(r10, r9, null, false, MultiSimAdapter.sub2Slot(this.mSubId));     // Catch: RemoteException -> L26
    L18:
        r1 = r8;
        goto L20
    L17:
        r8 = r2.getDisplayPlmn(r10, r9, null, false);     // Catch: RemoteException -> L26
    L20:
        if (TextUtils.isEmpty(r1) == true) goto L23;
        return r1;
    L23:
        if (TextUtils.isEmpty(r9) == true) goto L25;
        return r9;
    L25:
        return r10;
    L8:
        if (r9.equals("APN_NAME_CTNET") == false) goto L11;
        return "CTNET";
    L11:
        return r9;
    }

    private void addApnToList(ApnItem r2, ArrayList<ApnItem> r3, ArrayList<ApnItem> r4, IccRecords r5, String r6, String r7) {
        if (r5 != null) goto L4;
    L10:
        r3.add(r2);
        return;
    L4:
        if (TextUtils.isEmpty(r6) == true) goto L10;
        if (TextUtils.isEmpty(r7) == true) goto L10;
        if (MultiSDKAdapterNew.mvnoMatches(r5, r6, r7) == false) goto L12;
        r4.add(r2);
        this.mMvnoType = r6;
        this.mMvnoMatchData = r7;
        return;
    }

    private void setSelectedApnKey(String r4) {
        this.mSelectedKey = r4;
        ContentResolver r5 = getContentResolver();
        ContentValues r0 = new ContentValues();
        r0.put(APN_ID, this.mSelectedKey);
        if (MultiSimAdapter.isMultiSimEnabled() == false) goto L5;
        Uri r3 = Uri.parse("content://telephony/carriers/preferapn/subId/" + this.mSubId);
    L6:
        r5.update(r3, r0, null, null);
        return;
    L5:
        r3 = PREFERAPN_URI;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.android.settings.ApnSettings] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.database.Cursor] */
    private String getSelectedApnKey() {
        if (MultiSimAdapter.isMultiSimEnabled() == false) goto L5;
        Uri r0 = Uri.parse("content://telephony/carriers/preferapn/subId/" + this.mSubId);
    L6:
        Uri r2 = r0;
        String r1 = null;
        Cursor r8 = getContentResolver().query(r2, new String[]{"_id"}, null, null, "name ASC");     // Catch: Throwable -> L17 Exception -> L19
        if (r8 != null) goto L30;
    L15:
        if (r8 == null) goto L24;
    L16:
        r8.close();
    L24:
        return r1;
    L30:
    L13:
        e = e;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L25
        if (r8 == null) goto L24;
    L10:
        if (r8.getCount() <= 0) goto L15;
        r8.moveToFirst();     // Catch: Exception -> L13 Throwable -> L25
        r1 = r8.getString(0);     // Catch: Exception -> L13 Throwable -> L25
        goto L15
    L25:
        Throwable th = th;
    L26:
        if (this == 0) goto L28;
        this.close();
    L28:
        throw th;
    L19:
        e = e;
        r8 = null;
    L17:
        th = move-exception;
        th = th;
        ApnSettings this = 0;
        goto L26
    L5:
        r0 = PREFERAPN_URI;
        goto L6
    }

    private void restoreDefaultApn() {
        showDialog(1001);
        mRestoreDefaultApnMode = true;
        if (this.mRestoreApnUiHandler != null) goto L6;
        this.mRestoreApnUiHandler = new RestoreApnUiHandler(this, null);
    L6:
        if (this.mRestoreApnProcessHandler != null) goto L8;
    L9:
        HandlerThread r1 = new HandlerThread("Restore default APN Handler: Process Thread");
        this.mRestoreDefaultApnThread = r1;
        r1.start();
        Looper r2 = this.mRestoreDefaultApnThread.getLooper();
        if (r2 != null) goto L12;
        return;
    L12:
        this.mRestoreApnProcessHandler = new RestoreApnProcessHandler(this, r2, this.mRestoreApnUiHandler);
    L13:
        this.mRestoreApnProcessHandler.sendEmptyMessage(1);
        return;
    L8:
        if (this.mRestoreDefaultApnThread != null) goto L13;
        goto L9
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int r5) {
        if (r5 != 1001) goto L6;
        StatusDialog r6 = new StatusDialog(this, new StatusDialog.Modifier(getResources().getString(R.string.restore_default_apn), "", null, null));
        r6.setCanceledOnTouchOutside(false);
        this.mList.setEnabled(false);
        return r6;
    L6:
        return null;
    }

    private boolean isCTAllowApn(String r5) {
        String[] r4 = CT_ALLOW_SHOW_APNS.split(",");
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r5.equalsIgnoreCase(r4[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean isApnEditable(ApnItem r2) {
        if (Features.isFeatureCTEnabled(this.mContext).booleanValue() == false) goto L7;
        return !isCTAllowApn(r2.getSummary());
    L7:
        return !r2.getReadOnly();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        int r5 = this.mList.getHeaderViewsCount();
    L4:
        if (r5 >= (this.mList.getChildCount() - this.mList.getFooterViewsCount())) goto L14;
        View r0 = this.mList.getChildAt(r5);
        if (r0 == null) goto L13;
        RadioButton r1 = (RadioButton) r0.findViewById(R.id.checkbox);
        r1.setOnCheckedChangeListener(null);
        if (r1 != r3) goto L11;
        boolean r2 = true;
    L12:
        r1.setChecked(r2);
        r1.setOnCheckedChangeListener(this);
        goto L13
    L11:
        r2 = false;
    L13:
        r5 = r5 + 1;
        goto L4
    L14:
        setSelectedApnKey(((ApnItem) r3.getTag()).getKey());
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r4) {
        this.mUri = ContentUris.withAppendedId(Telephony.Carriers.CONTENT_URI, Integer.parseInt(((ApnItem) r4.getTag()).getKey()));
        showDeleteConfirmDialog();
        return false;
    }

    private void showDeleteConfirmDialog() {
        if (this.mDeleteConfirmDialog != null) goto L5;
        this.mDeleteConfirmDialog = new OAlertDialogBuilder(this.mActivity).title(R.string.apn_delete_confirm_title).horizontalButton(true).negativeButton(R.string.menu_cancel_confirm, new AnonymousClass4(this)).positiveButton(R.string.menu_delete_confirm, new AnonymousClass3(this)).build();
    L5:
        this.mDeleteConfirmDialog.show();
    }

    private boolean isConfirmDialogShowing() {
        OAlertDialog r0 = this.mDeleteConfirmDialog;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isShowing();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ApnSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ApnSettings r1) {
        com_android_settings_ApnSettings_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_PrivacyHook_onCreate(ApnSettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ApnSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ApnSettings__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(ApnSettings r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_ApnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ApnSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ApnSettings_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ApnSettings r5 = r4;
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
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ApnSettings r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_ApnSettings__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(ApnSettings r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_ApnSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_PrivacyHook_onResume(ApnSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ApnSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_ApnSettings__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ApnSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ApnSettings_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_PrivacyHook_onPause(ApnSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ApnSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_ApnSettings__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ApnSettings r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_ApnSettings_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ApnSettings r5 = r3;
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
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_PrivacyHook_onStop(ApnSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ApnSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_ApnSettings__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_ApnSettings_com_obric_hook_lancet_PrivacyHook_onDestroy(ApnSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ApnSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_ApnSettings__onDestroy$___twin___();
    }
}
