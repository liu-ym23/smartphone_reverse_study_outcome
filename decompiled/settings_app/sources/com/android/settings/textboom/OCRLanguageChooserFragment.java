package com.android.settings.textboom;

import android.app.AlertDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.settings.PreferenceMgr;
import com.android.settings.PrivacyPolicyDialog;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class OCRLanguageChooserFragment extends BaseFragment {
    private static final String TAG = "OCRLanguageChooserFragment";
    public static Integer[] sOCRLangArray;
    private BaseAdapter mAdapter;
    private boolean mNotShowWarningThisTime;
    private int mOCRLanguageValue;
    private String[] mOptions;
    private ListView mOptionsList;
    private PrivacyPolicyDialog mPrivacyPolicyDialog;
    private Integer[] mValues;
    private AlertDialog mWarningDialog;

    private class OptionsAdapter extends BaseAdapter {
        final /* synthetic */ OCRLanguageChooserFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private OptionsAdapter(OCRLanguageChooserFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OptionsAdapter(OCRLanguageChooserFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return OCRLanguageChooserFragment.access$1100(this.this$0).length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L4;
            r3 = View.inflate(this.this$0._mActivity, R.layout.list_content_item_check, null);
            SettingItemCheck r5 = (SettingItemCheck) r3.findViewById(R.id.item_check);
            r3.setTag(r5);
        L5:
            Utils.setItemBgStyle(r5, getCount(), r2);
            r5.setTitle(OCRLanguageChooserFragment.access$1100(this.this$0)[r2]);
            OCRLanguageChooserFragment r1 = this.this$0;
            r5.setChecked(OCRLanguageChooserFragment.access$400(r1, OCRLanguageChooserFragment.access$200(r1)[r2].intValue()));
            return r3;
        L4:
            r5 = (SettingItemCheck) r3.getTag();
            goto L5
        }
    }

    public void com_android_settings_textboom_OCRLanguageChooserFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_textboom_OCRLanguageChooserFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_textboom_OCRLanguageChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_textboom_OCRLanguageChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OCRLanguageChooserFragment() {
    }

    static /* synthetic */ ListView access$100(OCRLanguageChooserFragment r0) {
        return r0.mOptionsList;
    }

    static /* synthetic */ boolean access$1002(OCRLanguageChooserFragment r0, boolean r1) {
        r0.mNotShowWarningThisTime = r1;
        return r1;
    }

    static /* synthetic */ String[] access$1100(OCRLanguageChooserFragment r0) {
        return r0.mOptions;
    }

    static /* synthetic */ Integer[] access$200(OCRLanguageChooserFragment r0) {
        return r0.mValues;
    }

    static /* synthetic */ PrivacyPolicyDialog access$300(OCRLanguageChooserFragment r0) {
        return r0.mPrivacyPolicyDialog;
    }

    static /* synthetic */ PrivacyPolicyDialog access$302(OCRLanguageChooserFragment r0, PrivacyPolicyDialog r1) {
        r0.mPrivacyPolicyDialog = r1;
        return r1;
    }

    static /* synthetic */ boolean access$400(OCRLanguageChooserFragment r0, int r1) {
        return r0.isSelected(r1);
    }

    static /* synthetic */ int access$500(OCRLanguageChooserFragment r0) {
        return r0.getSelectedLangCount();
    }

    static /* synthetic */ void access$600(OCRLanguageChooserFragment r0) {
        r0.showChooseNoneWarningDialog();
    }

    static /* synthetic */ void access$700(OCRLanguageChooserFragment r0) {
        r0.showSelectTooMuchWarningDialog();
    }

    static /* synthetic */ int access$800(OCRLanguageChooserFragment r0) {
        return r0.mOCRLanguageValue;
    }

    static /* synthetic */ int access$880(OCRLanguageChooserFragment r1, int r2) {
        int r3 = r2 ^ r1.mOCRLanguageValue;
        r1.mOCRLanguageValue = r3;
        return r3;
    }

    static /* synthetic */ BaseAdapter access$900(OCRLanguageChooserFragment r0) {
        return r0.mAdapter;
    }

    static {
        sOCRLangArray = new Integer[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.options_layout, r3, false);
        initData();
        this.mOptionsList = (ListView) NullSafe.nonNull(this.mRootView.findViewById(R.id.options_list));
        addHeaderFooterViews();
        OptionsAdapter r5 = new OptionsAdapter(this, null);
        this.mAdapter = r5;
        this.mOptionsList.setAdapter(r5);
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this));
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        setTitle(R.string.ocr_recognize_language_title);
        updateViews();
    }

    private void addHeaderFooterViews() {
        View r0 = this.mLayoutInflater.inflate(R.layout.header_text_layout, null);
        TextView r1 = (TextView) NullSafe.nonNull(r0.findViewById(R.id.header_text));
        r0.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ocr_language_listview_padding_top), 0, 0);
        r0.findViewById(R.id.empty_head).setVisibility(8);
        r1.setText(R.string.ocr_language_chooser_tips);
        this.mOptionsList.addHeaderView(r0);
    }

    private void initData() {
        String[] r0 = getResources().getStringArray(R.array.ocr_language_list);
        if (r0.length != sOCRLangArray.length) goto L14;
        this.mOCRLanguageValue = Settings.Global.getInt(getContentResolver(), "big_bang_ocr_language", 3);
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        int r3 = sOCRLangArray.length;
        this.mOptions = new String[r3];
        this.mValues = new Integer[r3];
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r3) goto L11;
        if (isSelected(sOCRLangArray[r4].intValue()) == false) goto L9;
        r2.add(r5, sOCRLangArray[r4]);
        r1.add(r5, r0[r4]);
        r5 = r5 + 1;
    L10:
        r4 = r4 + 1;
        goto L5
    L9:
        r2.add(sOCRLangArray[r4]);
        r1.add(r0[r4]);
        goto L10
    L11:
        this.mOptions = (String[]) r1.toArray(this.mOptions);
        this.mValues = (Integer[]) r2.toArray(this.mValues);
        return;
    L14:
        throw new IllegalArgumentException("different array length!");
    }

    public void updateViews() {
        boolean r2 = true;
        if (Settings.Global.getInt(getContentResolver(), "text_boom", 1) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (Settings.Global.getInt(getContentResolver(), "big_bang_ocr", 0) == 1) goto L10;
        r2 = false;
    L10:
        if (r0 == false) goto L12;
        if (r2 == false) goto L12;
    L13:
        this.mOCRLanguageValue = Settings.Global.getInt(getContentResolver(), "big_bang_ocr_language", 3);
        this.mAdapter.notifyDataSetChanged();
        return;
    L12:
        finish();
        goto L13
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private boolean isSelected(int r1) {
        if ((this.mOCRLanguageValue & r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int getSelectedLangCount() {
        int r0 = 0;
        int r1 = 0;
    L3:
        Integer[] r2 = sOCRLangArray;
        if (r0 >= r2.length) goto L9;
        if (isSelected(r2[r0].intValue()) == false) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        return r1;
    }

    private void showSelectTooMuchWarningDialog() {
        if (PreferenceMgr.getInstance(this.mContext).getBoolean(PreferenceMgr.KEY_OCR_LANGUAGE_WARNING_SELECTED_TOO_MUCH, true) == true) goto L5;
        return;
    L5:
        if (this.mNotShowWarningThisTime == false) goto L7;
        return;
    L7:
        if (this.mPrivacyPolicyDialog != null) goto L10;
        PrivacyPolicyDialog r0 = new PrivacyPolicyDialog(this._mActivity, 5);
        this.mPrivacyPolicyDialog = r0;
        r0.setTitle(R.string.dialog_title_alert);
        this.mPrivacyPolicyDialog.setMessage(R.string.ocr_language_too_much_warning_msg);
        this.mPrivacyPolicyDialog.setCancelable(false);
        this.mPrivacyPolicyDialog.setButton(-1, this.mContext.getString(android.R.string.ok), new AnonymousClass2(this));
        this.mPrivacyPolicyDialog.setOnDismissListener(new AnonymousClass3(this));
    L10:
        if (this.mPrivacyPolicyDialog.isShowing() == true) goto L15;
        this.mPrivacyPolicyDialog.show();
        return;
    }

    private void showChooseNoneWarningDialog() {
        if (this.mWarningDialog != null) goto L6;
        this.mWarningDialog = new AlertDialog.Builder(this._mActivity).setTitle(R.string.dialog_title_alert).setMessage(R.string.at_least_one_selected_dialog_msg).setCancelable(false).setPositiveButton(android.R.string.ok, new AnonymousClass4(this)).create();
    L6:
        if (this.mWarningDialog.isShowing() == true) goto L9;
        this.mWarningDialog.show();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_textboom_OCRLanguageChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OCRLanguageChooserFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_OCRLanguageChooserFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_OCRLanguageChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OCRLanguageChooserFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_textboom_OCRLanguageChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_OCRLanguageChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OCRLanguageChooserFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_OCRLanguageChooserFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
