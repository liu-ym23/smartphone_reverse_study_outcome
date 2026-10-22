package com.android.settings.inputmethod;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.android.settings.R;
import com.android.settings.UserDictionarySettings;
import com.android.settings.Utils;
import com.obric.oui.forms.OInputView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class UserDictionaryAddWordContents {
    public static final String EXTRA_LOCALE = "locale";
    public static final String EXTRA_MODE = "mode";
    public static final String EXTRA_ORIGINAL_SHORTCUT = "originalShortcut";
    public static final String EXTRA_ORIGINAL_WORD = "originalWord";
    public static final String EXTRA_SHORTCUT = "shortcut";
    public static final String EXTRA_WORD = "word";
    private static final int FREQUENCY_FOR_USER_DICTIONARY_ADDS = 250;
    private static final String[] HAS_WORD_PROJECTION = null;
    private static final String HAS_WORD_SELECTION_ALL_LOCALES = "word=? AND locale is null";
    private static final String HAS_WORD_SELECTION_ONE_LOCALE = "word=? AND locale=?";
    public static final int MODE_EDIT = 0;
    public static final int MODE_INSERT = 1;
    private String mLocale;
    private final int mMode;
    private final String mOldShortcut;
    private final String mOldWord;
    private String mSavedShortcut;
    private String mSavedWord;
    private final EditText mShortcutEditText;
    private final EditText mWordEditText;

    public static class LocaleRenderer {
        private final String mDescription;
        private final String mLocaleString;

        public LocaleRenderer(Context r2, String r3) {
            this.mLocaleString = r3;
            if (r3 != null) goto L6;
            this.mDescription = r2.getString(R.string.user_dict_settings_more_languages);
            return;
        L6:
            if ("".equals(r3) == false) goto L8;
            this.mDescription = r2.getString(R.string.user_dict_settings_all_languages);
            return;
        L8:
            this.mDescription = Utils.createLocaleFromString(r3).getDisplayName();
        }

        public String toString() {
            return this.mDescription;
        }

        public String getLocaleString() {
            return this.mLocaleString;
        }

        public boolean isMoreLanguages() {
            if (this.mLocaleString != null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    UserDictionaryAddWordContents(View r4, Bundle r5) {
        View r0 = r4.findViewById(R.id.edittext);
        if ((r0 instanceof OInputView) == false) goto L5;
        this.mWordEditText = ((OInputView) r0).getVInput();
    L6:
        View r6 = r4.findViewById(R.id.user_dictionary_add_shortcut);
        if ((r6 instanceof EditText) == false) goto L9;
        this.mShortcutEditText = (EditText) r6;
    L10:
        String r1 = r5.getString(EXTRA_WORD);
        if (r1 == null) goto L13;
        this.mWordEditText.setText(r1);
        EditText r2 = this.mWordEditText;
        r2.setSelection(r2.getText().length());
    L13:
        String r3 = r5.getString(EXTRA_SHORTCUT);
        if (r3 == null) goto L18;
        EditText r7 = this.mShortcutEditText;
        if (r7 == null) goto L18;
        r7.setText(r3);
    L18:
        this.mMode = r5.getInt("mode");
        this.mOldWord = r5.getString(EXTRA_WORD);
        this.mOldShortcut = r5.getString(EXTRA_SHORTCUT);
        updateLocale(r5.getString("locale"));
        return;
    L9:
        this.mShortcutEditText = null;
        goto L10
    L5:
        this.mWordEditText = (EditText) r0;
        goto L6
    }

    UserDictionaryAddWordContents(View r2, UserDictionaryAddWordContents r3) {
        this.mWordEditText = (EditText) r2.findViewById(R.id.edittext);
        this.mShortcutEditText = (EditText) r2.findViewById(R.id.user_dictionary_add_shortcut);
        this.mMode = 0;
        this.mOldWord = r3.mSavedWord;
        this.mOldShortcut = r3.mSavedShortcut;
        updateLocale(this.mLocale);
    }

    void updateLocale(String r1) {
        if (r1 != null) goto L4;
        r1 = Locale.getDefault().toString();
    L4:
        this.mLocale = r1;
    }

    void saveStateIntoBundle(Bundle r3) {
        r3.putString(EXTRA_WORD, this.mWordEditText.getText().toString());
        r3.putString(EXTRA_ORIGINAL_WORD, this.mOldWord);
        EditText r0 = this.mShortcutEditText;
        if (r0 == null) goto L5;
        r3.putString(EXTRA_SHORTCUT, r0.getText().toString());
    L5:
        String r1 = this.mOldShortcut;
        if (r1 == null) goto L8;
        r3.putString(EXTRA_ORIGINAL_SHORTCUT, r1);
    L8:
        r3.putString("locale", this.mLocale);
    }

    void delete(Context r2) {
        if (this.mMode == 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mOldWord) == true) goto L9;
        ContentResolver r3 = r2.getContentResolver();
        UserDictionarySettings.deleteWord(this.mOldWord, this.mOldShortcut, r3);
        return;
    }

    int apply(Context r5, Bundle r6) {
        if (r6 == null) goto L4;
        saveStateIntoBundle(r6);
    L4:
        ContentResolver r7 = r5.getContentResolver();
        if (this.mMode == 0) goto L7;
    L9:
        String r0 = this.mWordEditText.getText().toString();
        EditText r1 = this.mShortcutEditText;
        Locale r2 = null;
        if (r1 != null) goto L12;
    L11:
        String r3 = null;
    L16:
        if (TextUtils.isEmpty(r0) == false) goto L19;
        return 1;
    L19:
        this.mSavedWord = r0;
        this.mSavedShortcut = r3;
        if (TextUtils.isEmpty(r3) == true) goto L22;
    L25:
        UserDictionarySettings.deleteWord(r0, null, r7);
        if (TextUtils.isEmpty(r3) == true) goto L28;
        UserDictionarySettings.deleteWord(r0, r3, r7);
    L28:
        String r8 = r0.toString();
        if (TextUtils.isEmpty(this.mLocale) == true) goto L32;
        r2 = Utils.createLocaleFromString(this.mLocale);
    L32:
        UserDictionary.Words.addWord(r5, r8, 250, r3, r2);
        return 0;
    L22:
        if (hasWord(r0, r5) == false) goto L25;
        return 2;
    L12:
        r3 = r1.getText().toString();
        if (TextUtils.isEmpty(r3) == false) goto L16;
    L7:
        if (TextUtils.isEmpty(this.mOldWord) == true) goto L9;
        UserDictionarySettings.deleteWord(this.mOldWord, this.mOldShortcut, r7);
        goto L9
    }

    static {
        HAS_WORD_PROJECTION = new String[]{EXTRA_WORD};
    }

    private boolean hasWord(String r11, Context r12) {
        Cursor r0 = null;
        boolean r2 = true;
        if ("".equals(this.mLocale) == false) goto L7;
        Cursor r10 = r12.getContentResolver().query(UserDictionary.Words.CONTENT_URI, HAS_WORD_PROJECTION, HAS_WORD_SELECTION_ALL_LOCALES, new String[]{r11}, null);     // Catch: Throwable -> L20
    L6:
        r0 = r10;
        if (r0 != null) goto L13;
        if (r0 == null) goto L12;
        r0.close();
    L12:
        return false;
    L13:
        if (r0.getCount() > 0) goto L17;
        r2 = false;
    L17:
        if (r0 == null) goto L19;
        r0.close();
    L19:
        return r2;
    L7:
        r10 = r12.getContentResolver().query(UserDictionary.Words.CONTENT_URI, HAS_WORD_PROJECTION, HAS_WORD_SELECTION_ONE_LOCALE, new String[]{r11, this.mLocale}, null);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r0 == null) goto L23;
        r0.close();
    L23:
        throw th;
    }

    private static void addLocaleDisplayNameToList(Context r1, ArrayList<LocaleRenderer> r2, String r3) {
        if (r3 == null) goto L5;
        r2.add(new LocaleRenderer(r1, r3));
        return;
    }

    public ArrayList<LocaleRenderer> getLocalesList(Activity r6) {
        TreeSet<String> r0 = UserDictionaryList.getUserDictionaryLocalesSet(r6);
        r0.remove(this.mLocale);
        String r1 = Locale.getDefault().toString();
        r0.remove(r1);
        r0.remove("");
        ArrayList<LocaleRenderer> r3 = new ArrayList();
        addLocaleDisplayNameToList(r6, r3, this.mLocale);
        if (r1.equals(this.mLocale) == true) goto L5;
        addLocaleDisplayNameToList(r6, r3, r1);
    L5:
        Iterator<String> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L10;
        addLocaleDisplayNameToList(r6, r3, r2.next());
        goto L7
    L10:
        if ("".equals(this.mLocale) == true) goto L12;
        addLocaleDisplayNameToList(r6, r3, "");
    L12:
        r3.add(new LocaleRenderer(r6, null));
        return r3;
    }

    public String getCurrentUserDictionaryLocale() {
        return this.mLocale;
    }
}
