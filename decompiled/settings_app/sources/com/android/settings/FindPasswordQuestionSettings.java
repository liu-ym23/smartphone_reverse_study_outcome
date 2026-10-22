package com.android.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import bytedanceos.api.SpinnerSmt;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class FindPasswordQuestionSettings extends Fragment implements TextWatcher, View.OnClickListener {
    public static final String EXTRA_ANSWER = "extra_answer";
    public static final String EXTRA_QUESTION_INDEX = "extra_question_index";
    private static final int WARNING_LEN = 10;
    private BaseAdapter adapter;
    private View mBackView;
    private TextView mCountDownText;
    private AlertDialog mDialog;
    private EditText mEditor;
    private Handler mHandler;
    private int mMaxLenOfAnswer;
    private View mRightView;
    private Spinner mSpinner;
    private OFloatingTitleBar mTitle;
    private String password;
    private String[] questions;

    class QuestionAdapter extends BaseAdapter implements SpinnerAdapter {
        LayoutInflater mInflater;
        final /* synthetic */ FindPasswordQuestionSettings this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            return 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return false;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return false;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver r1) {
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver r1) {
        }

        public QuestionAdapter(FindPasswordQuestionSettings r1) {
            this.this$0 = r1;
            this.mInflater = LayoutInflater.from(r1.getActivity());
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return FindPasswordQuestionSettings.access$700(this.this$0).length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return FindPasswordQuestionSettings.access$700(this.this$0)[r1];
        }

        @Override // android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L4;
        L7:
            r3 = this.mInflater.inflate(R.layout.questions_spinner_prompt_view, null);
            TextView r5 = (TextView) r3.findViewById(R.id.prompt_view);
            r3.setTag(r5);
        L8:
            r5.setText(FindPasswordQuestionSettings.access$700(this.this$0)[r2]);
            return r3;
        L4:
            if ((r3.getTag() instanceof TextView) == false) goto L7;
            r5 = (TextView) r3.getTag();
            goto L8
        }

        @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L4;
        L7:
            r3 = this.mInflater.inflate(R.layout.settings_spinner_dropdown_item, null);
            TextView r5 = (TextView) r3.findViewById(android.R.id.text1);
            r3.setTag(r5);
        L8:
            r5.setText(FindPasswordQuestionSettings.access$700(this.this$0)[r2]);
            return r3;
        L4:
            if ((r3.getTag() instanceof TextView) == false) goto L7;
            r5 = (TextView) r3.getTag();
            goto L8
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_FindPasswordQuestionSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_FindPasswordQuestionSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public FindPasswordQuestionSettings() {
    }

    static /* synthetic */ View access$000(FindPasswordQuestionSettings r0) {
        return r0.mRightView;
    }

    static /* synthetic */ TextView access$100(FindPasswordQuestionSettings r0) {
        return r0.mCountDownText;
    }

    static /* synthetic */ int access$200(FindPasswordQuestionSettings r0) {
        return r0.mMaxLenOfAnswer;
    }

    static /* synthetic */ String access$300(FindPasswordQuestionSettings r0) {
        return r0.password;
    }

    static /* synthetic */ Intent access$400(FindPasswordQuestionSettings r0) {
        return r0.getOkIntent();
    }

    static /* synthetic */ void access$500(FindPasswordQuestionSettings r0, int r1, Intent r2) {
        r0.exitActivity(r1, r2);
    }

    static /* synthetic */ EditText access$600(FindPasswordQuestionSettings r0) {
        return r0.mEditor;
    }

    static /* synthetic */ String[] access$700(FindPasswordQuestionSettings r0) {
        return r0.questions;
    }

    public void com_android_settings_FindPasswordQuestionSettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mHandler = new Handler();
        this.questions = getResources().getStringArray(R.array.find_password_questions);
        this.password = getActivity().getIntent().getStringExtra("password");
        this.adapter = new QuestionAdapter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        View r6 = r3.inflate(R.layout.find_password_question_settings, r4);
        OFloatingTitleBar r7 = (OFloatingTitleBar) r6.findViewById(R.id.view_title);
        this.mTitle = r7;
        View r8 = r7.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView = r8;
        r8.setOnClickListener(this);
        View r9 = this.mTitle.addEndAction(R.drawable.standard_icon_complete_selector, -1, null);
        this.mRightView = r9;
        r9.setOnClickListener(this);
        this.mRightView.setEnabled(false);
        Spinner r10 = (Spinner) r6.findViewById(R.id.spinner);
        this.mSpinner = r10;
        r10.setAdapter(this.adapter);
        SpinnerSmt.getInstance().setBytedanceTopSelector(this.mSpinner, true);
        SpinnerSmt.getInstance().setBytedanceBottomSelector(this.mSpinner, true);
        EditText r11 = (EditText) r6.findViewById(R.id.answer_editor);
        this.mEditor = r11;
        r11.addTextChangedListener(this);
        this.mCountDownText = (TextView) r6.findViewById(R.id.countdown_text);
        this.mMaxLenOfAnswer = getResources().getInteger(R.integer.find_password_answer_max_length);
        return r6;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    public void com_android_settings_FindPasswordQuestionSettings__onResume$___twin___() {
        super.onResume();
        if (isQuestionSelected() == false) goto L7;
        if (AppLockUtil.isLocked(getActivity()) == false) goto L7;
    L8:
        getActivity().finish();
        return;
    L7:
        if (TextUtils.isEmpty(this.password) == true) goto L8;
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L13;
    L20:
        Utils.showSoftInputMethod(getActivity(), this.mEditor);
        return;
    L13:
        if (r0.isShowing() == false) goto L20;
        AlertDialog r1 = this.mDialog;
        if (r1 != null) goto L18;
        return;
    L18:
        if (r1.isShowing() == false) goto L23;
        Utils.hideInputMethod(getActivity());
        return;
    }

    private boolean isQuestionSelected() {
        return !TextUtils.isEmpty(AppLockUtil.getSelectedQuestion(getActivity()));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r3) {
        final int r4 = r3.length();
        this.mHandler.post(new AnonymousClass1(this, r4));
    }

    private void showPassWarningDialog() {
        if (this.mDialog != null) goto L6;
        this.mDialog = new AlertDialog.Builder(getActivity()).setTitle(R.string.find_password_setting_pass).setMessage(R.string.find_password_pass_warning_msg).setNegativeButton(R.string.cancel, new AnonymousClass4(this)).setOnCancelListener(new AnonymousClass3(this)).setPositiveButton(R.string.ok, new AnonymousClass2(this)).create();
    L6:
        if (this.mDialog.isShowing() == true) goto L9;
        this.mDialog.show();
        return;
    }

    public static void saveSelectedQuestionIndex(Context r0, int r1) {
        AppLockUtil.saveSelectedQuestion(r0, r1);
    }

    public static void saveAnswer(Context r0, String r1) {
        AppLockUtil.saveAnswer(r0, r1);
    }

    public static void savePassword(Context r0, String r1) {
        OLog.e("FindPasswordQuestionSettings", "savePassword");
    }

    private void exitActivity(int r2) {
        getActivity().setResult(r2);
        getActivity().finish();
    }

    private void exitActivity(int r2, Intent r3) {
        getActivity().setResult(r2, r3);
        getActivity().finish();
    }

    private Intent getOkIntent() {
        int r0 = this.mSpinner.getSelectedItemPosition();
        Intent r1 = new Intent();
        r1.putExtra(EXTRA_ANSWER, this.mEditor.getText().toString());
        r1.putExtra(EXTRA_QUESTION_INDEX, r0);
        return r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mRightView) goto L9;
        if (this.mEditor.getText().toString().length() != 0) goto L7;
        showPassWarningDialog();
        return;
    L7:
        exitActivity(-1, getOkIntent());
        return;
    L9:
        if (r2 != this.mBackView) goto L14;
        exitActivity(0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_FindPasswordQuestionSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FindPasswordQuestionSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_FindPasswordQuestionSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FindPasswordQuestionSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FindPasswordQuestionSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_FindPasswordQuestionSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FindPasswordQuestionSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FindPasswordQuestionSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_FindPasswordQuestionSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
