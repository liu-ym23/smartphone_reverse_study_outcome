package com.android.settings;

import android.app.ListFragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.provider.UserDictionary;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AlphabetIndexer;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import com.android.settings.inputmethod.UserDictionaryAddWordFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UserDictionarySettings extends ListFragment {
    private static final String DELETE_SELECTION_WITHOUT_SHORTCUT = "word=? AND shortcut is null OR shortcut=''";
    private static final String DELETE_SELECTION_WITH_SHORTCUT = "word=? AND shortcut=?";
    private static final int INDEX_SHORTCUT = 2;
    private static final int OPTIONS_MENU_ADD = 1;
    private static final String[] QUERY_PROJECTION = null;
    private static final String QUERY_SELECTION = "locale=?";
    private static final String QUERY_SELECTION_ALL_LOCALES = "locale is null";
    private static final String TAG = "UserDictionarySettings";
    private Cursor mCursor;
    protected String mLocale;

    private static class MyAdapter extends SimpleCursorAdapter implements SectionIndexer {
        private AlphabetIndexer mIndexer;
        private final SimpleCursorAdapter.ViewBinder mViewBinder;

        public MyAdapter(Context r1, int r2, Cursor r3, String[] r4, int[] r5, UserDictionarySettings r6) {
            super(r1, r2, r3, r4, r5);
            SimpleCursorAdapter.ViewBinder r7 = new AnonymousClass1(this);
            this.mViewBinder = r7;
            if (r3 == null) goto L5;
            String r8 = r1.getString(android.R.string.global_action_lockdown);
            this.mIndexer = new AlphabetIndexer(r3, r3.getColumnIndexOrThrow(UserDictionaryAddWordContents.EXTRA_WORD), r8);
        L5:
            setViewBinder(r7);
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int r1) {
            AlphabetIndexer r0 = this.mIndexer;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getPositionForSection(r1);
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int r1) {
            AlphabetIndexer r0 = this.mIndexer;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getSectionForPosition(r1);
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            AlphabetIndexer r0 = this.mIndexer;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.getSections();
        }
    }

    public void com_android_settings_UserDictionarySettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_UserDictionarySettings__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_UserDictionarySettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_UserDictionarySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
    }

    @Override // android.app.Fragment
    public void onPause() {
        com_android_settings_UserDictionarySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        com_android_settings_UserDictionarySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
    }

    public UserDictionarySettings() {
    }

    static {
        QUERY_PROJECTION = new String[]{"_id", UserDictionaryAddWordContents.EXTRA_WORD, UserDictionaryAddWordContents.EXTRA_SHORTCUT};
    }

    @Override // android.app.ListFragment, android.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        return r1.inflate(android.R.layout.text_edit_suggestions_window, r2, false);
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        Intent r5 = getActivity().getIntent();
        String r1 = null;
        if (r5 != null) goto L5;
        String r6 = null;
    L6:
        Bundle r2 = getArguments();
        if (r2 != null) goto L9;
        String r0 = null;
    L10:
        if (r0 == null) goto L12;
        r1 = r0;
    L14:
        this.mLocale = r1;
        this.mCursor = createCursor(r1);
        TextView r7 = (TextView) getView().findViewById(android.R.id.empty);
        r7.setText(R.string.user_dict_settings_empty_text);
        ListView r3 = getListView();
        r3.setAdapter(createAdapter());
        r3.setFastScrollEnabled(true);
        r3.setEmptyView(r7);
        setHasOptionsMenu(true);
        return;
    L12:
        if (r6 == null) goto L14;
        r1 = r6;
        goto L14
    L9:
        r0 = r2.getString("locale");
        goto L10
    L5:
        r6 = r5.getStringExtra("locale");
        goto L6
    }

    private Cursor createCursor(String r8) {
        if ("".equals(r8) == true) goto L5;
        if (r8 != null) goto L10;
        r8 = Locale.getDefault().toString();
    L10:
        return getActivity().managedQuery(UserDictionary.Words.CONTENT_URI, QUERY_PROJECTION, QUERY_SELECTION, new String[]{r8}, "UPPER(word)");
    L5:
        return getActivity().managedQuery(UserDictionary.Words.CONTENT_URI, QUERY_PROJECTION, QUERY_SELECTION_ALL_LOCALES, null, "UPPER(word)");
    }

    private ListAdapter createAdapter() {
        return new MyAdapter(getActivity(), R.layout.user_dictionary_item, this.mCursor, new String[]{UserDictionaryAddWordContents.EXTRA_WORD, UserDictionaryAddWordContents.EXTRA_SHORTCUT}, new int[]{android.R.id.text1, android.R.id.text2}, this);
    }

    @Override // android.app.ListFragment
    public void onListItemClick(ListView r1, View r2, int r3, long r4) {
        String r5 = getWord(r3);
        String r6 = getShortcut(r3);
        if (r5 == null) goto L6;
        showAddOrEditDialog(r5, r6);
        return;
    }

    private void showAddOrEditDialog(String r8, String r9) {
        Bundle r2 = new Bundle();
        if (r8 != null) goto L5;
        int r0 = 1;
    L6:
        r2.putInt("mode", r0);
        r2.putString(UserDictionaryAddWordContents.EXTRA_WORD, r8);
        r2.putString(UserDictionaryAddWordContents.EXTRA_SHORTCUT, r9);
        r2.putString("locale", this.mLocale);
        ((PreferenceActivity) getActivity()).startPreferencePanel(UserDictionaryAddWordFragment.class.getName(), r2, R.string.user_dict_settings_add_dialog_title, null, null, 0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private String getWord(int r3) {
        Cursor r0 = this.mCursor;
        if (r0 != null) goto L5;
        return null;
    L5:
        r0.moveToPosition(r3);
        if (this.mCursor.isAfterLast() == false) goto L8;
        return null;
    L8:
        Cursor r2 = this.mCursor;
        return r2.getString(r2.getColumnIndexOrThrow(UserDictionaryAddWordContents.EXTRA_WORD));
    }

    private String getShortcut(int r3) {
        Cursor r0 = this.mCursor;
        if (r0 != null) goto L5;
        return null;
    L5:
        r0.moveToPosition(r3);
        if (this.mCursor.isAfterLast() == false) goto L8;
        return null;
    L8:
        Cursor r2 = this.mCursor;
        return r2.getString(r2.getColumnIndexOrThrow(UserDictionaryAddWordContents.EXTRA_SHORTCUT));
    }

    public static void deleteWord(String r4, String r5, ContentResolver r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        r6.delete(UserDictionary.Words.CONTENT_URI, DELETE_SELECTION_WITHOUT_SHORTCUT, new String[]{r4});
        return;
    L5:
        r6.delete(UserDictionary.Words.CONTENT_URI, DELETE_SELECTION_WITH_SHORTCUT, new String[]{r4, r5});
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_UserDictionarySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(UserDictionarySettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_UserDictionarySettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_UserDictionarySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(UserDictionarySettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_UserDictionarySettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_UserDictionarySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(UserDictionarySettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_UserDictionarySettings__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
