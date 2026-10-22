package com.android.settings.inputmethod;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.forms.OInputView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UserDictionaryActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    private static final String DELETE_SELECTION = "word=?";
    private static final int FREQUENCY_FOR_USER_DICTIONARY_ADDS = 250;
    private static final String[] QUERY_PROJECTION = null;
    private static final String QUERY_SELECTION = "locale=?";
    private static final int SINGLE_LINE_WORD_COUNT_1 = 1;
    private static final int SINGLE_LINE_WORD_COUNT_2 = 2;
    private static final int SINGLE_LINE_WORD_COUNT_3 = 3;
    private static final int SINGLE_LINE_WORD_COUNT_4 = 4;
    private static final int SINGLE_LINE_WORD_COUNT_5 = 5;
    private EditText editText;
    private int[] levels;
    private DictWordAdapter mAdapter;
    private View.OnClickListener mDelClickListener;
    private AlertDialog mDialog;
    private String mEditingWord;
    private ListView mUserDictionaryList;
    private View.OnClickListener mWordClickListener;
    private ArrayList<ArrayList<String>> mWordGroup;

    public class DictWordAdapter extends ArrayAdapter<ArrayList<String>> {
        private static final int MAX_COUNT_SINGLE_LINE = 5;
        private int[] ids;
        private View.OnClickListener mDelListener;
        private View.OnClickListener mEditListener;
        private LayoutInflater mInflater;
        private int mItemResId;
        final /* synthetic */ UserDictionaryActivity this$0;

        class ViewHolder {
            DictWordItem[] items;
            final /* synthetic */ DictWordAdapter this$1;

            ViewHolder(DictWordAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public DictWordAdapter(UserDictionaryActivity r1, Context r2, int r3) {
            this.this$0 = r1;
            super(r2, r3);
            this.ids = new int[]{R.id.item_0, R.id.item_1, R.id.item_2, R.id.item_3, R.id.item_4};
            this.mItemResId = r3;
            this.mInflater = LayoutInflater.from(r2);
        }

        public void setOnDeleteClickListener(View.OnClickListener r1) {
            this.mDelListener = r1;
        }

        public void setOnWordClickListener(View.OnClickListener r1) {
            this.mEditListener = r1;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return UserDictionaryActivity.access$500(this.this$0).size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public ArrayList<String> getItem(int r1) {
            return (ArrayList) UserDictionaryActivity.access$500(this.this$0).get(r1);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r7, View r8, ViewGroup r9) {
            if (r8 != null) goto L5;
        L8:
            r8 = this.mInflater.inflate(this.mItemResId, r9, false);
            ViewHolder r10 = new ViewHolder(this);
            r10.items = new DictWordItem[5];
            int r2 = 0;
        L9:
            if (r2 >= 5) goto L11;
            r10.items[r2] = (DictWordItem) r8.findViewById(this.ids[r2]);
            r2 = r2 + 1;
            goto L9
        L11:
            r8.setTag(r10);
        L12:
            ArrayList r11 = (ArrayList) UserDictionaryActivity.access$500(this.this$0).get(r7);
            int r3 = 0;
        L13:
            if (r3 >= 5) goto L19;
            if (r3 >= r11.size()) goto L17;
            String r4 = (String) r11.get(r3);
            r10.items[r3].setText(r4);
            r10.items[r3].setVisibility(0);
            r10.items[r3].setOnWordClickListener(this.mEditListener);
            r10.items[r3].setOnDeleteClickListener(this.mDelListener, r4);
        L18:
            r3 = r3 + 1;
            goto L13
        L17:
            r10.items[r3].setVisibility(8);
            goto L18
        L19:
            return r8;
        L5:
            if ((r8.getTag() instanceof ViewHolder) == false) goto L8;
            r10 = (ViewHolder) r8.getTag();
            goto L12
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public void com_android_settings_inputmethod_UserDictionaryActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_inputmethod_UserDictionaryActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_inputmethod_UserDictionaryActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_inputmethod_UserDictionaryActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public UserDictionaryActivity() {
        this.mWordGroup = new ArrayList();
        this.levels = new int[5];
        this.mWordClickListener = new AnonymousClass1(this);
        this.mDelClickListener = new AnonymousClass2(this);
    }

    static /* synthetic */ void access$000(UserDictionaryActivity r0, String r1) {
        r0.showDialog(r1);
    }

    static /* synthetic */ int access$100(UserDictionaryActivity r0, String r1) {
        return r0.deleteWord(r1);
    }

    static /* synthetic */ void access$200(UserDictionaryActivity r0) {
        r0.updateUserDictionaryList();
    }

    static /* synthetic */ EditText access$300(UserDictionaryActivity r0) {
        return r0.editText;
    }

    static /* synthetic */ void access$400(UserDictionaryActivity r0, String r1) {
        r0.onAddOrEditFinished(r1);
    }

    static /* synthetic */ ArrayList access$500(UserDictionaryActivity r0) {
        return r0.mWordGroup;
    }

    static {
        QUERY_PROJECTION = new String[]{UserDictionaryAddWordContents.EXTRA_WORD};
    }

    public void com_android_settings_inputmethod_UserDictionaryActivity__onCreate$___twin___(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.user_dictionary_settings_layout);
        DisplayMetrics r9 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(r9);
        int r10 = r9.widthPixels;
        int r0 = getResources().getDimensionPixelSize(R.dimen.dict_word_list_padding);
        int r1 = getResources().getDrawable(R.drawable.dict_word_delete).getIntrinsicWidth();
        int r2 = 0;
    L3:
        int[] r3 = this.levels;
        if (r2 >= r3.length) goto L6;
        int r5 = r2 + 1;
        r3[r2] = (r10 - (r0 * 2)) - (r1 * r5);
        r2 = r5;
        goto L3
    L6:
        this.mUserDictionaryList = (ListView) NullSafe.nonNull(findViewById(R.id.user_dictionary_list));
        DictWordAdapter r11 = new DictWordAdapter(this, this, R.layout.dict_words_adapter_item);
        this.mAdapter = r11;
        this.mUserDictionaryList.setAdapter(r11);
        this.mAdapter.setOnWordClickListener(this.mWordClickListener);
        this.mAdapter.setOnDeleteClickListener(this.mDelClickListener);
        TextView r12 = (TextView) NullSafe.nonNull(findViewById(android.R.id.empty));
        this.mUserDictionaryList.setEmptyView(r12);
        updateUserDictionaryList();
        ((OFloatingTitleBar) NullSafe.nonNull(findViewById(R.id.view_title))).addEndAction(R.string.language_keyboard_item_title_add_user_dictionary, -1, null).setOnClickListener(this);
        setupBackBtnOnTitle();
    }

    public void com_android_settings_inputmethod_UserDictionaryActivity__onDestroy$___twin___() {
        super.onDestroy();
        clearData();
        this.mWordGroup = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        showDialog(null);
    }

    private void showDialog(String r8) {
        this.mEditingWord = r8;
        if (this.mDialog != null) goto L5;
        AlertDialog.Builder r0 = new AlertDialog.Builder(this);
        View r2 = LayoutInflater.from(r0.getContext()).inflate(R.layout.dialog_edittext, null);
        this.editText = ((OInputView) r2.findViewById(R.id.edittext)).getVInput();
        this.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        this.mDialog = r0.setView(r2).setPositiveButton(android.R.string.ok, new AnonymousClass3(this)).setNegativeButton(android.R.string.cancel, null).create();
    L5:
        AlertDialog r1 = this.mDialog;
        if (r8 == null) goto L8;
        int r3 = R.string.user_dict_settings_edit_dialog_title;
    L9:
        r1.setTitle(r3);
        this.editText.setText(r8);
        this.editText.addTextChangedListener(this);
        this.editText.requestFocus();
        if (r8 == null) goto L12;
        this.editText.setSelection(0, r8.length());
    L12:
        this.editText.setInputType(65537);
        this.mDialog.getWindow().setSoftInputMode(36);
        this.mDialog.show();
        this.mDialog.getButton(-1).setEnabled(false);
        return;
    L8:
        r3 = R.string.user_dict_settings_add_dialog_title;
        goto L9
    }

    private void onAddOrEditFinished(String r3) {
        if (isWordExist(r3) == false) goto L6;
        Utils.showShortToast(this, getString(R.string.user_dictionary_word_duplicate_toast));
        return;
    L6:
        String r0 = this.mEditingWord;
        if (r0 == null) goto L9;
        deleteWord(r0);
    L9:
        UserDictionary.Words.addWord(this, r3.toString(), 250, 1);
        updateUserDictionaryList();
    }

    private boolean isWordExist(String r9) {
        boolean r1 = false;
        if (TextUtils.isEmpty(r9) == true) goto L11;
        Cursor r10 = getContentResolver().query(UserDictionary.Words.CONTENT_URI, QUERY_PROJECTION, DELETE_SELECTION, new String[]{r9}, null);
        if (r10 != null) goto L7;
    L9:
        if (r10 == null) goto L11;
        r10.close();
        goto L11
    L7:
        if (r10.getCount() <= 0) goto L9;
        r1 = true;
    L11:
        return r1;
    }

    private int deleteWord(String r4) {
        return getContentResolver().delete(UserDictionary.Words.CONTENT_URI, DELETE_SELECTION, new String[]{r4});
    }

    private void updateUserDictionaryList() {
        queryUserDictionary();
        DictWordAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.notifyDataSetChanged();
        return;
    }

    private void clearData() {
        if (this.mWordGroup.isEmpty() == true) goto L11;
        Iterator<ArrayList<String>> r0 = this.mWordGroup.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().clear();
        goto L6
    L8:
        this.mWordGroup.clear();
        return;
    }

    private void queryUserDictionary() {
        Cursor r0 = getContentResolver().query(UserDictionary.Words.CONTENT_URI, QUERY_PROJECTION, QUERY_SELECTION, new String[]{Locale.getDefault().toString()}, "UPPER(word)");
        clearData();
        if (r0 == null) goto L63;
        ArrayList<String> r2 = null;
    L5:
        float r4 = 0.0f;
        int r3 = 0;
    L7:
        if (r0.moveToNext() == false) goto L37;
        String r5 = r0.getString(0);
        r3 = r3 + 1;
        float r6 = measureTextWidth(r5);
        r4 = r4 + r6;
        if (r3 != 1) goto L11;
        r2 = new ArrayList();
        this.mWordGroup.add(r2);
        r2.add(r5);
        goto L7
    L11:
        if (r3 != 2) goto L13;
        if (r4 > this.levels[r3 - 1]) goto L33;
        r2.add(r5);
        goto L7
    L33:
        r2 = new ArrayList();
        this.mWordGroup.add(r2);
        r2.add(r5);
    L34:
        r4 = r6;
        r3 = 1;
        goto L7
    L13:
        if (r3 != 3) goto L15;
        if (r4 > this.levels[r3 - 1]) goto L29;
        r2.add(r5);
        goto L7
    L29:
        r2 = new ArrayList();
        this.mWordGroup.add(r2);
        r2.add(r5);
        goto L34
    L15:
        if (r3 != 4) goto L17;
        if (r4 > this.levels[r3 - 1]) goto L25;
        r2.add(r5);
        goto L7
    L25:
        r2 = new ArrayList();
        this.mWordGroup.add(r2);
        r2.add(r5);
        goto L34
    L17:
        if (r3 != 5) goto L7;
        if (r4 <= this.levels[r3 - 1]) goto L22;
        r2 = new ArrayList();
        this.mWordGroup.add(r2);
        r2.add(r5);
        goto L34
    L22:
        r2.add(r5);
        goto L5
    L37:
        r0.close();
        return;
    }

    private float measureTextWidth(String r2) {
        DictWordItem r0 = new DictWordItem(this);
        r0.setText(r2);
        return r0.getWordMeasuredWidth();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r3) {
        Button r0 = this.mDialog.getButton(-1);
        String r4 = r3.toString();
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L8:
        r0.setEnabled(false);
        return;
    L5:
        if (r4.equals(this.mEditingWord) == true) goto L8;
        r0.setEnabled(true);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(UserDictionaryActivity r1) {
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_PrivacyHook_onCreate(UserDictionaryActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        UserDictionaryActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_inputmethod_UserDictionaryActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(UserDictionaryActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(UserDictionaryActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        UserDictionaryActivity r5 = r4;
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
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(UserDictionaryActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_inputmethod_UserDictionaryActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(UserDictionaryActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_inputmethod_UserDictionaryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_PrivacyHook_onResume(UserDictionaryActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        UserDictionaryActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_inputmethod_UserDictionaryActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(UserDictionaryActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_PrivacyHook_onPause(UserDictionaryActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        UserDictionaryActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_inputmethod_UserDictionaryActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(UserDictionaryActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        UserDictionaryActivity r5 = r3;
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
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_PrivacyHook_onStop(UserDictionaryActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        UserDictionaryActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_inputmethod_UserDictionaryActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_inputmethod_UserDictionaryActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(UserDictionaryActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        UserDictionaryActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_inputmethod_UserDictionaryActivity__onDestroy$___twin___();
    }
}
