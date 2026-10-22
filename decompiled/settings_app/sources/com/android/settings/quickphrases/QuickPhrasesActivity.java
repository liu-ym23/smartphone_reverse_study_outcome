package com.android.settings.quickphrases;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.QuickPhrases;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class QuickPhrasesActivity extends BaseActivity implements View.OnClickListener, QueryHandler.QueryCallback {
    private static String IMEStr = null;
    private static final int MAX_ITEM_SIZE = 10;
    private static final int REQUEST_ADD_OR_EDIT_PHRASE = 0;
    private static final String TAG = "QuickPhrase";
    public static final int TOKEN_DELETE = 2;
    public static final int TOKEN_QUERY = 0;
    private static final String[] mProjection = null;
    private ListNotesAdapter mAdapter;
    private TextView mAddButton;
    private ArrayList<QuickPhrase> mArrayPhrases;
    private TextView mEditButton;
    private boolean mEditMode;
    private SettingItemSwitch mEnabledSwitch;
    private AdapterView.OnItemClickListener mItemClickListener;
    private ListView mList;
    private ModeChanger mModeChanger;
    private boolean mPhraseEnabled;
    private QueryHandler mQueryHandler;
    private boolean mSpecialEditMode;
    private View mViewGap;

    class ListNotesAdapter extends SettingsAdapter {
        private Context mContext;
        private int mId;
        private int mPosition;
        final /* synthetic */ QuickPhrasesActivity this$0;

        class ViewHolder {
            ImageView imageMove;
            ImageView imageRemove;
            TextView text;
            final /* synthetic */ ListNotesAdapter this$1;

            ViewHolder(ListNotesAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        static /* synthetic */ int access$600(ListNotesAdapter r0) {
            return r0.mPosition;
        }

        static /* synthetic */ int access$602(ListNotesAdapter r0, int r1) {
            r0.mPosition = r1;
            return r1;
        }

        public ListNotesAdapter(QuickPhrasesActivity r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return QuickPhrasesActivity.access$200(this.this$0).size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(final int r6, View r7, ViewGroup r8) {
            if (r7 != null) goto L4;
            ViewHolder r9 = new ViewHolder(this);
            SettingItemEditable r10 = new SettingItemEditable(this.mContext);
            r9.text = r10.getTextView();
            r9.imageRemove = r10.getLeftImage();
            r10.setTag(r9);
            View r11 = r10;
        L5:
            final QuickPhrase r0 = (QuickPhrase) QuickPhrasesActivity.access$200(this.this$0).get(r6);
            r9.text.setText(r0.getDetail());
            if (QuickPhrasesActivity.access$000(this.this$0) == false) goto L8;
            r9.text.setTextColor(this.mContext.getResources().getColorStateList(R.color.setting_item_text_colorlist));
        L9:
            r9.imageRemove.setTag(Integer.valueOf(r6));
            r9.imageRemove.setOnClickListener(new AnonymousClass1(this, r0, r6));
            ((SettingItemEditable) r11).switchMode(QuickPhrasesActivity.access$000(this.this$0));
            r11.setBackgroundResource(getBackgroundRes(QuickPhrasesActivity.access$200(this.this$0).size(), r6));
            if (QuickPhrasesActivity.access$000(this.this$0) == false) goto L12;
        L15:
            boolean r5 = true;
        L16:
            r11.setEnabled(r5);
            return r11;
        L12:
            if (QuickPhrasesActivity.access$800(this.this$0) == true) goto L15;
            r5 = false;
            goto L16
        L8:
            r9.text.setTextColor(this.mContext.getResources().getColor(R.color.setting_item_text_color));
            goto L9
        L4:
            ViewHolder r12 = (ViewHolder) r7.getTag();
            r11 = r7;
            r9 = r12;
            goto L5
        }
    }

    public void com_android_settings_quickphrases_QuickPhrasesActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_quickphrases_QuickPhrasesActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_quickphrases_QuickPhrasesActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public QuickPhrasesActivity() {
        this.mEditMode = false;
        this.mArrayPhrases = new ArrayList();
        this.mItemClickListener = new AnonymousClass1(this);
    }

    static /* synthetic */ boolean access$000(QuickPhrasesActivity r0) {
        return r0.mEditMode;
    }

    static /* synthetic */ ListView access$100(QuickPhrasesActivity r0) {
        return r0.mList;
    }

    static /* synthetic */ ArrayList access$200(QuickPhrasesActivity r0) {
        return r0.mArrayPhrases;
    }

    static /* synthetic */ boolean access$302(QuickPhrasesActivity r0, boolean r1) {
        r0.mPhraseEnabled = r1;
        return r1;
    }

    static /* synthetic */ void access$400(QuickPhrasesActivity r0) {
        r0.updateEnabledStatus();
    }

    static /* synthetic */ void access$500(QuickPhrasesActivity r0, int r1) {
        r0.asyncDeletePhrase(r1);
    }

    static /* synthetic */ ListNotesAdapter access$700(QuickPhrasesActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ boolean access$800(QuickPhrasesActivity r0) {
        return r0.mSpecialEditMode;
    }

    static {
        mProjection = new String[]{"_id", "phrase", "pos"};
        IMEStr = "";
    }

    public void com_android_settings_quickphrases_QuickPhrasesActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.ringtone_settings_layout);
        this.mModeChanger = new ModeChanger(R.id.rl_list_item_parent, this);
        boolean r1 = true;
        if (Settings.Global.getInt(getContentResolver(), "quick_phrases_enabled", 1) == 1) goto L6;
        r1 = false;
    L6:
        this.mPhraseEnabled = r1;
        QueryHandler r5 = new QueryHandler(getContentResolver());
        this.mQueryHandler = r5;
        r5.setCallback(this);
        this.mList = (ListView) findViewById(android.R.id.list);
        ListNotesAdapter r6 = new ListNotesAdapter(this, this);
        this.mAdapter = r6;
        this.mList.setAdapter(r6);
        this.mList.setOnItemClickListener(this.mItemClickListener);
        setupBackBtnOnTitle();
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.view_title);
        this.mTitle.setCenterTitle(getString(R.string.quick_phrase));
        this.mEditButton = new TextView(this);
        this.mTitle.addEndAction(this.mEditButton, -1);
        this.mEditButton.setVisibility(0);
        this.mEditButton.setText(R.string.edit);
        this.mEditButton.setOnClickListener(this);
        addHeaderFooter();
        if (this.mPhraseEnabled == false) goto L10;
        asyncQuery();
        return;
    }

    public void com_android_settings_quickphrases_QuickPhrasesActivity__onResume$___twin___() {
        super.onResume();
        updateEnabledStatus();
    }

    private void addHeaderFooter() {
        View r0 = LayoutInflater.from(this).inflate(R.layout.settings_header_switch_layout, null);
        SettingItemSwitch r1 = (SettingItemSwitch) r0.findViewById(R.id.item_text_switch);
        this.mEnabledSwitch = r1;
        r1.setTitle(R.string.quick_phrase);
        this.mEnabledSwitch.setOnCheckedChangeListener(new AnonymousClass2(this));
        this.mList.addHeaderView(r0);
        View r2 = LayoutInflater.from(this).inflate(R.layout.settings_header_text, null);
        TextView r3 = (TextView) NullSafe.nonNull((TextView) r2.findViewById(R.id.text));
        this.mAddButton = r3;
        r3.setText(R.string.add_quick_phrase);
        this.mAddButton.setOnClickListener(this);
        this.mList.addFooterView(r2);
    }

    @Override // com.android.settings.quickphrases.QueryHandler.QueryCallback
    public void asyncQuery() {
        this.mQueryHandler.startQuery(0, null, QuickPhrases.CONTENT_URI, null, null, null, "pos ASC");
    }

    @Override // com.android.settings.quickphrases.QueryHandler.QueryCallback
    public void onQueryComplete(ArrayList<QuickPhrase> r3) {
        this.mArrayPhrases = r3;
        this.mAdapter.notifyDataSetChanged();
        if (r3.size() != 0) goto L6;
        this.mEditMode = false;
        updateEditMode();
        this.mEditButton.setEnabled(false);
        return;
    L6:
        if (r3.size() < 10) goto L8;
        this.mAddButton.setVisibility(8);
        return;
    L8:
        this.mAddButton.setVisibility(0);
    }

    private void asyncDeletePhrase(int r7) {
        this.mQueryHandler.startDelete(2, null, QuickPhrases.CONTENT_URI, "_id=" + r7, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 != this.mAddButton) goto L6;
        Utils.startActivity(this, new Intent(this, AddQuickPhraseActivity.class), 1, 0);
        return;
    L6:
        if (r3 != this.mEditButton) goto L10;
        this.mEditMode = !this.mEditMode;
        updateEditMode();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 0) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L9;
        asyncQuery();
        return;
    }

    private void updateEnabledStatus() {
        this.mEnabledSwitch.setChecked(this.mPhraseEnabled);
        this.mEditButton.setEnabled(this.mPhraseEnabled);
        TextView r0 = this.mAddButton;
        if (r0 == null) goto L10;
        if (this.mPhraseEnabled == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        goto L10
    L7:
        r1 = 8;
    L10:
        if (this.mPhraseEnabled == true) goto L12;
        this.mArrayPhrases.clear();
        this.mAdapter.notifyDataSetChanged();
        return;
    L12:
        asyncQuery();
    }

    private void updateEditMode() {
        if (this.mEditMode == false) goto L5;
        this.mAddButton.setEnabled(false);
        this.mEnabledSwitch.getSwitch().setEnabled(false);
        this.mEditButton.setText(getString(R.string.done));
        this.mModeChanger.beginEdit(this.mList, null);
        return;
    L5:
        this.mAddButton.setEnabled(true);
        this.mEnabledSwitch.getSwitch().setEnabled(true);
        this.mEditButton.setText(getString(R.string.edit));
        this.mModeChanger.endEdit(this.mList, null);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean r0 = this.mEditMode;
        if (r0 == false) goto L6;
        this.mEditMode = !r0;
        updateEditMode();
        return;
    L6:
        super.onBackPressed();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(QuickPhrasesActivity r1) {
        com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_PrivacyHook_onCreate(QuickPhrasesActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        QuickPhrasesActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_quickphrases_QuickPhrasesActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(QuickPhrasesActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(QuickPhrasesActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        QuickPhrasesActivity r5 = r4;
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
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(QuickPhrasesActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_quickphrases_QuickPhrasesActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(QuickPhrasesActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_quickphrases_QuickPhrasesActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_PrivacyHook_onResume(QuickPhrasesActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        QuickPhrasesActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_quickphrases_QuickPhrasesActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(QuickPhrasesActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_PrivacyHook_onPause(QuickPhrasesActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        QuickPhrasesActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_quickphrases_QuickPhrasesActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(QuickPhrasesActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        QuickPhrasesActivity r5 = r3;
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
    public static void com_android_settings_quickphrases_QuickPhrasesActivity_com_obric_hook_lancet_PrivacyHook_onStop(QuickPhrasesActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        QuickPhrasesActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_quickphrases_QuickPhrasesActivity__onStop$___twin___();
    }
}
