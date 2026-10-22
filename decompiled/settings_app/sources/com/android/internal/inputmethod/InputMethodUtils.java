package com.android.internal.inputmethod;

import android.R;
import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.res.Resources;
import android.os.LocaleList;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Printer;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textservice.SpellCheckerInfo;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class InputMethodUtils {
    public static final boolean DEBUG = false;
    private static final Locale ENGLISH_LOCALE = null;
    private static final char INPUT_METHOD_SEPARATOR = ':';
    private static final char INPUT_METHOD_SUBTYPE_SEPARATOR = ';';
    public static final int NOT_A_SUBTYPE_ID = -1;
    private static final String NOT_A_SUBTYPE_ID_STR = null;
    private static final Locale[] SEARCH_ORDER_OF_FALLBACK_LOCALES = null;
    public static final String SUBTYPE_MODE_ANY = null;
    public static final String SUBTYPE_MODE_KEYBOARD = "keyboard";
    public static final String SUBTYPE_MODE_VOICE = "voice";
    private static final String TAG = "InputMethodUtils";
    private static final String TAG_ENABLED_WHEN_DEFAULT_IS_NOT_ASCII_CAPABLE = "EnabledWhenDefaultIsNotAsciiCapable";
    private static final Object sCacheLock = null;
    private static InputMethodInfo sCachedInputMethodInfo;
    private static ArrayList<InputMethodSubtype> sCachedResult;
    private static LocaleList sCachedSystemLocales;
    private static final LocaleUtils.LocaleExtractor<InputMethodSubtype> sSubtypeToLocale = null;

    public static class InputMethodSettings {
        private static final ArraySet<String> CLONE_TO_MANAGED_PROFILE = null;
        private boolean mCopyOnWrite;
        private final ArrayMap<String, String> mCopyOnWriteDataStore;
        private int[] mCurrentProfileIds;
        private int mCurrentUserId;
        private String mEnabledInputMethodsStrCache;
        private final TextUtils.SimpleStringSplitter mInputMethodSplitter;
        private final HashMap<String, InputMethodInfo> mMethodMap;
        private final Resources mRes;
        private final ContentResolver mResolver;
        private final TextUtils.SimpleStringSplitter mSubtypeSplitter;

        static {
            ArraySet<String> r0 = new ArraySet();
            CLONE_TO_MANAGED_PROFILE = r0;
            Settings.Secure.getCloneToManagedProfileSettings(r0);
        }

        private static void buildEnabledInputMethodsSettingString(StringBuilder r2, Pair<String, ArrayList<String>> r3) {
            r2.append((String) r3.first);
            Iterator r4 = ((ArrayList) r3.second).iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            String r0 = (String) r4.next();
            r2.append(InputMethodUtils.INPUT_METHOD_SUBTYPE_SEPARATOR).append(r0);
            goto L4
        }

        public static List<Pair<String, ArrayList<String>>> buildInputMethodsAndSubtypeList(String r3, TextUtils.SimpleStringSplitter r4, TextUtils.SimpleStringSplitter r5) {
            ArrayList r0 = new ArrayList();
            if (TextUtils.isEmpty(r3) == false) goto L5;
            return r0;
        L5:
            r4.setString(r3);
        L7:
            if (r4.hasNext() == false) goto L15;
            r5.setString(r4.next());
            if (r5.hasNext() == false) goto L7;
            ArrayList r6 = new ArrayList();
            String r1 = r5.next();
        L12:
            if (r5.hasNext() == false) goto L14;
            r6.add(r5.next());
            goto L12
        L14:
            r0.add(new Pair(r1, r6));
            goto L7
        L15:
            return r0;
        }

        public InputMethodSettings(Resources r2, ContentResolver r3, HashMap<String, InputMethodInfo> r4, ArrayList<InputMethodInfo> r5, int r6, boolean r7) {
            this.mInputMethodSplitter = new TextUtils.SimpleStringSplitter(':');
            this.mSubtypeSplitter = new TextUtils.SimpleStringSplitter(InputMethodUtils.INPUT_METHOD_SUBTYPE_SEPARATOR);
            this.mCopyOnWriteDataStore = new ArrayMap();
            this.mCopyOnWrite = false;
            this.mEnabledInputMethodsStrCache = "";
            this.mCurrentProfileIds = new int[0];
            this.mRes = r2;
            this.mResolver = r3;
            this.mMethodMap = r4;
            switchCurrentUser(r6, r7);
        }

        public void switchCurrentUser(int r2, boolean r3) {
            if (this.mCurrentUserId == r2) goto L5;
        L6:
            this.mCopyOnWriteDataStore.clear();
            this.mEnabledInputMethodsStrCache = "";
        L7:
            this.mCurrentUserId = r2;
            this.mCopyOnWrite = r3;
            return;
        L5:
            if (this.mCopyOnWrite == r3) goto L7;
            goto L6
        }

        private void putString(String r2, String r3) {
            if (this.mCopyOnWrite == false) goto L5;
            this.mCopyOnWriteDataStore.put(r2, r3);
            return;
        L5:
            int r0 = this.mCurrentUserId;
            Settings.Secure.putStringForUser(this.mResolver, r2, r3, r0);
        }

        private String getString(String r2, String r3) {
            if (this.mCopyOnWrite == true) goto L5;
        L7:
            String r1 = Settings.Secure.getStringForUser(this.mResolver, r2, this.mCurrentUserId);
        L8:
            if (r1 != null) goto L10;
            return r3;
        L10:
            return r1;
        L5:
            if (this.mCopyOnWriteDataStore.containsKey(r2) == false) goto L7;
            r1 = this.mCopyOnWriteDataStore.get(r2);
            goto L8
        }

        private void putInt(String r2, int r3) {
            if (this.mCopyOnWrite == false) goto L5;
            this.mCopyOnWriteDataStore.put(r2, String.valueOf(r3));
            return;
        L5:
            int r0 = this.mCurrentUserId;
            Settings.Secure.putIntForUser(this.mResolver, r2, r3, r0);
        }

        private int getInt(String r2, int r3) {
            if (this.mCopyOnWrite == false) goto L11;
            if (this.mCopyOnWriteDataStore.containsKey(r2) == false) goto L11;
            String r1 = this.mCopyOnWriteDataStore.get(r2);
            if (r1 != null) goto L9;
            return r3;
        L9:
            return Integer.parseInt(r1);
        L11:
            return Settings.Secure.getIntForUser(this.mResolver, r2, r3, this.mCurrentUserId);
        }

        private void putBoolean(String r1, boolean r2) {
            putInt(r1, r2 ? 1 : 0);
        }

        private boolean getBoolean(String r1, boolean r2) {
            if (getInt(r1, r2 ? 1 : 0) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public void setCurrentProfileIds(int[] r1) {
            monitor-enter(this);
            this.mCurrentProfileIds = r1;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public boolean isCurrentProfile(int r6) {
            monitor-enter(this);
        L17:
            th = move-exception;
            throw th;
        L4:
            if (r6 != this.mCurrentUserId) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L17
            return true;
        L7:
            int r2 = 0;
        L8:
            int[] r3 = this.mCurrentProfileIds;     // Catch: Throwable -> L17
            if (r2 >= r3.length) goto L15;
            if (r6 == r3[r2]) goto L12;
            r2 = r2 + 1;     // Catch: Throwable -> L17
            goto L8
        L12:
            monitor-exit(this);     // Catch: Throwable -> L17
            return true;
        L15:
            monitor-exit(this);     // Catch: Throwable -> L17
            return false;
        }

        public ArrayList<InputMethodInfo> getEnabledInputMethodListLocked() {
            return createEnabledInputMethodListLocked(getEnabledInputMethodsAndSubtypeListLocked());
        }

        public List<InputMethodSubtype> getEnabledInputMethodSubtypeListLocked(Context r1, InputMethodInfo r2, boolean r3) {
            List<InputMethodSubtype> r0 = getEnabledInputMethodSubtypeListLocked(r2);
            if (r3 == false) goto L8;
            if (r0.isEmpty() == false) goto L8;
            r0 = InputMethodUtils.getImplicitlyApplicableSubtypesLocked(r1.getResources(), r2);
        L8:
            return InputMethodSubtype.sort(r2, r0);
        }

        public List<InputMethodSubtype> getEnabledInputMethodSubtypeListLocked(InputMethodInfo r8) {
            List<Pair<String, ArrayList<String>>> r0 = getEnabledInputMethodsAndSubtypeListLocked();
            ArrayList r1 = new ArrayList();
            if (r8 == null) goto L20;
            Iterator<Pair<String, ArrayList<String>>> r2 = r0.iterator();
        L6:
            if (r2.hasNext() == false) goto L20;
            Pair<String, ArrayList<String>> r3 = r2.next();
            InputMethodInfo r4 = this.mMethodMap.get(r3.first);
            if (r4 == null) goto L6;
            if (r4.getId().equals(r8.getId()) == false) goto L6;
            int r7 = r4.getSubtypeCount();
            int r9 = 0;
        L12:
            if (r9 >= r7) goto L20;
            InputMethodSubtype r5 = r4.getSubtypeAt(r9);
            Iterator r6 = ((ArrayList) r3.second).iterator();
        L15:
            if (r6.hasNext() == false) goto L19;
            String r10 = (String) r6.next();
            if (String.valueOf(r5.hashCode()).equals(r10) == false) goto L15;
            r1.add(r5);
            goto L15
        L19:
            r9 = r9 + 1;
        L20:
            return r1;
        }

        public List<Pair<String, ArrayList<String>>> getEnabledInputMethodsAndSubtypeListLocked() {
            return buildInputMethodsAndSubtypeList(getEnabledInputMethodsStr(), this.mInputMethodSplitter, this.mSubtypeSplitter);
        }

        public void appendAndPutEnabledInputMethodLocked(String r2, boolean r3) {
            if (r3 == false) goto L5;
            getEnabledInputMethodsStr();
        L5:
            if (TextUtils.isEmpty(this.mEnabledInputMethodsStrCache) == false) goto L7;
            putEnabledInputMethodsStr(r2);
            return;
        L7:
            putEnabledInputMethodsStr(this.mEnabledInputMethodsStrCache + ':' + r2);
        }

        public boolean buildAndPutEnabledInputMethodsStrRemovingIdLocked(StringBuilder r6, List<Pair<String, ArrayList<String>>> r7, String r8) {
            Iterator<Pair<String, ArrayList<String>>> r9 = r7.iterator();
            boolean r0 = false;
            boolean r1 = false;
        L4:
            if (r9.hasNext() == false) goto L12;
            Pair<String, ArrayList<String>> r2 = r9.next();
            if (((String) r2.first).equals(r8) == true) goto L7;
            if (r1 == false) goto L10;
            r6.append(':');
        L11:
            buildEnabledInputMethodsSettingString(r6, r2);
            goto L4
        L10:
            r1 = true;
            goto L11
        L7:
            r0 = true;
            goto L4
        L12:
            if (r0 == false) goto L14;
            putEnabledInputMethodsStr(r6.toString());
        L14:
            return r0;
        }

        private ArrayList<InputMethodInfo> createEnabledInputMethodListLocked(List<Pair<String, ArrayList<String>>> r4) {
            ArrayList<InputMethodInfo> r0 = new ArrayList();
            Iterator<Pair<String, ArrayList<String>>> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L10;
            Pair<String, ArrayList<String>> r1 = r5.next();
            InputMethodInfo r2 = this.mMethodMap.get(r1.first);
            if (r2 == null) goto L4;
            if (r2.isVrOnly() == true) goto L4;
            r0.add(r2);
            goto L4
        L10:
            return r0;
        }

        void putEnabledInputMethodsStr(String r3) {
            if (TextUtils.isEmpty(r3) == false) goto L5;
            putString("enabled_input_methods", null);
        L6:
            if (r3 != null) goto L9;
            r3 = "";
        L9:
            this.mEnabledInputMethodsStrCache = r3;
            return;
        L5:
            putString("enabled_input_methods", r3);
            goto L6
        }

        public String getEnabledInputMethodsStr() {
            String r0 = getString("enabled_input_methods", "");
            this.mEnabledInputMethodsStrCache = r0;
            return r0;
        }

        private void saveSubtypeHistory(List<Pair<String, String>> r6, String r7, String r8) {
            StringBuilder r0 = new StringBuilder();
            if (TextUtils.isEmpty(r7) == false) goto L5;
        L7:
            boolean r9 = false;
        L8:
            Iterator<Pair<String, String>> r10 = r6.iterator();
        L10:
            if (r10.hasNext() == false) goto L18;
            Pair<String, String> r11 = r10.next();
            String r1 = (String) r11.first;
            String r12 = (String) r11.second;
            if (TextUtils.isEmpty(r12) == false) goto L14;
            r12 = InputMethodUtils.access$000();
        L14:
            if (r9 == false) goto L16;
            r0.append(':');
        L17:
            r0.append(r1).append(InputMethodUtils.INPUT_METHOD_SUBTYPE_SEPARATOR).append(r12);
            goto L10
        L16:
            r9 = true;
            goto L17
        L18:
            putSubtypeHistoryStr(r0.toString());
            return;
        L5:
            if (TextUtils.isEmpty(r8) == true) goto L7;
            r0.append(r7).append(InputMethodUtils.INPUT_METHOD_SUBTYPE_SEPARATOR).append(r8);
            r9 = true;
            goto L8
        }

        private void addSubtypeToHistory(String r5, String r6) {
            List<Pair<String, String>> r0 = loadInputMethodAndSubtypeHistoryLocked();
            Iterator<Pair<String, String>> r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            Pair<String, String> r2 = r1.next();
            if (((String) r2.first).equals(r5) == false) goto L4;
            r0.remove(r2);
        L8:
            saveSubtypeHistory(r0, r5, r6);
        }

        private void putSubtypeHistoryStr(String r3) {
            if (TextUtils.isEmpty(r3) == false) goto L5;
            putString("input_methods_subtype_history", null);
            return;
        L5:
            putString("input_methods_subtype_history", r3);
        }

        public Pair<String, String> getLastInputMethodAndSubtypeLocked() {
            return getLastSubtypeForInputMethodLockedInternal(null);
        }

        public String getLastSubtypeForInputMethodLocked(String r1) {
            Pair<String, String> r0 = getLastSubtypeForInputMethodLockedInternal(r1);
            if (r0 != null) goto L5;
            return null;
        L5:
            return (String) r0.second;
        }

        private Pair<String, String> getLastSubtypeForInputMethodLockedInternal(String r6) {
            List<Pair<String, ArrayList<String>>> r0 = getEnabledInputMethodsAndSubtypeListLocked();
            Iterator<Pair<String, String>> r1 = loadInputMethodAndSubtypeHistoryLocked().iterator();
        L4:
            if (r1.hasNext() == false) goto L13;
            Pair<String, String> r2 = r1.next();
            String r3 = (String) r2.first;
            if (TextUtils.isEmpty(r6) == true) goto L9;
            if (r3.equals(r6) == false) goto L4;
        L9:
            String r4 = getEnabledSubtypeHashCodeForInputMethodAndSubtypeLocked(r0, r3, (String) r2.second);
            if (TextUtils.isEmpty(r4) == true) goto L4;
            return new Pair(r3, r4);
        L13:
            return null;
        }

        private String getEnabledSubtypeHashCodeForInputMethodAndSubtypeLocked(List<Pair<String, ArrayList<String>>> r3, String r4, String r5) {
            Iterator<Pair<String, ArrayList<String>>> r6 = r3.iterator();
        L4:
            if (r6.hasNext() == false) goto L34;
            Pair<String, ArrayList<String>> r0 = r6.next();
            if (((String) r0.first).equals(r4) == false) goto L4;
            ArrayList r7 = (ArrayList) r0.second;
            InputMethodInfo r8 = this.mMethodMap.get(r4);
            if (r7.size() != 0) goto L20;
            if (r8 == null) goto L33;
            if (r8.getSubtypeCount() <= 0) goto L33;
            ArrayList<InputMethodSubtype> r2 = InputMethodUtils.getImplicitlyApplicableSubtypesLocked(this.mRes, r8);
            if (r2 == null) goto L33;
            int r9 = r2.size();
            int r10 = 0;
        L15:
            if (r10 >= r9) goto L33;
            if (String.valueOf(r2.get(r10).hashCode()).equals(r5) == true) goto L18;
            r10 = r10 + 1;
            goto L15
        L18:
            return r5;
        L33:
            return InputMethodUtils.access$000();
        L20:
            Iterator r11 = r7.iterator();
        L22:
            if (r11.hasNext() == false) goto L33;
            String r12 = (String) r11.next();
            if (r12.equals(r5) == false) goto L22;
            if (InputMethodUtils.isValidSubtypeId(r8, Integer.parseInt(r5)) == false) goto L28;
            return r12;
        L28:
            return InputMethodUtils.access$000();
        L31:
            return InputMethodUtils.access$000();
        L34:
            return null;
        }

        private List<Pair<String, String>> loadInputMethodAndSubtypeHistoryLocked() {
            ArrayList r0 = new ArrayList();
            String r1 = getSubtypeHistoryStr();
            if (TextUtils.isEmpty(r1) == false) goto L5;
            return r0;
        L5:
            this.mInputMethodSplitter.setString(r1);
        L7:
            if (this.mInputMethodSplitter.hasNext() == false) goto L14;
            String r2 = this.mInputMethodSplitter.next();
            this.mSubtypeSplitter.setString(r2);
            if (this.mSubtypeSplitter.hasNext() == false) goto L7;
            String r3 = InputMethodUtils.access$000();
            String r4 = this.mSubtypeSplitter.next();
            if (this.mSubtypeSplitter.hasNext() == false) goto L13;
            r3 = this.mSubtypeSplitter.next();
        L13:
            r0.add(new Pair(r4, r3));
            goto L7
        L14:
            return r0;
        }

        private String getSubtypeHistoryStr() {
            return getString("input_methods_subtype_history", "");
        }

        public void putSelectedInputMethod(String r2) {
            putString("default_input_method", r2);
        }

        public void putDefaultChsInputMethod(String r3) {
            Settings.Secure.putStringForUser(this.mResolver, "default_chs_input_method", r3, this.mCurrentUserId);
        }

        public void putSelectedSubtype(int r2) {
            putInt("selected_input_method_subtype", r2);
        }

        public String getSelectedInputMethod() {
            return getString("default_input_method", null);
        }

        public String getDefaultChsInputMethod() {
            return Settings.Secure.getStringForUser(this.mResolver, "default_chs_input_method", this.mCurrentUserId);
        }

        public boolean isSubtypeSelected() {
            if (getSelectedInputMethodSubtypeHashCode() == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        private int getSelectedInputMethodSubtypeHashCode() {
            return getInt("selected_input_method_subtype", -1);
        }

        public boolean isShowImeWithHardKeyboardEnabled() {
            return getBoolean("show_ime_with_hard_keyboard", false);
        }

        public void setShowImeWithHardKeyboard(boolean r2) {
            putBoolean("show_ime_with_hard_keyboard", r2);
        }

        public int getCurrentUserId() {
            return this.mCurrentUserId;
        }

        public int getSelectedInputMethodSubtypeId(String r2) {
            InputMethodInfo r3 = this.mMethodMap.get(r2);
            if (r3 != null) goto L7;
            return -1;
        L7:
            return InputMethodUtils.getSubtypeIdFromHashCode(r3, getSelectedInputMethodSubtypeHashCode());
        }

        public void saveCurrentInputMethodAndSubtypeToHistory(String r2, InputMethodSubtype r3) {
            String r0 = InputMethodUtils.access$000();
            if (r3 == null) goto L6;
            r0 = String.valueOf(r3.hashCode());
        L6:
            if (InputMethodUtils.canAddToLastInputMethod(r3) == false) goto L9;
            addSubtypeToHistory(r2, r0);
            return;
        }

        public void dumpLocked(Printer r3, String r4) {
            r3.println(r4 + "mCurrentUserId=" + this.mCurrentUserId);
            r3.println(r4 + "mCurrentProfileIds=" + Arrays.toString(this.mCurrentProfileIds));
            r3.println(r4 + "mCopyOnWrite=" + this.mCopyOnWrite);
            r3.println(r4 + "mEnabledInputMethodsStrCache=" + this.mEnabledInputMethodsStrCache);
        }
    }

    static /* synthetic */ String access$000() {
        return NOT_A_SUBTYPE_ID_STR;
    }

    static {
        ENGLISH_LOCALE = new Locale("en");
        NOT_A_SUBTYPE_ID_STR = String.valueOf(-1);
        SEARCH_ORDER_OF_FALLBACK_LOCALES = new Locale[]{Locale.ENGLISH, Locale.US, Locale.UK};
        sCacheLock = new Object();
        sSubtypeToLocale = new AnonymousClass1();
    }

    private InputMethodUtils() {
    }

    public static String getApiCallStack() {
    L4:
        e = move-exception;
        StackTraceElement[] r0 = e.getStackTrace();
        int r1 = 1;
        String r2 = "";
    L7:
        if (r1 >= r0.length) goto L14;
        String r3 = r0[r1].toString();
        if (TextUtils.isEmpty(r2) == true) goto L13;
        if (r3.indexOf("Transact(") >= 0) goto L14;
    L13:
        r1 = r1 + 1;
        r2 = r3;
    L14:
        return r2;
    L3:
        throw new RuntimeException();     // Catch: RuntimeException -> L4
    }

    public static boolean isSystemIme(InputMethodInfo r1) {
        if ((r1.getServiceInfo().applicationInfo.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isSystemImeThatHasSubtypeOf(InputMethodInfo r2, Context r3, boolean r4, Locale r5, boolean r6, String r7) {
        if (isSystemIme(r2) == true) goto L5;
        return false;
    L5:
        if (r4 == false) goto L10;
        if (r2.isDefault(r3) == true) goto L10;
        return false;
    L10:
        if (containsSubtypeOf(r2, r5, r6, r7) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public static Locale getSystemLocaleFromContext(Context r0) {
        return r0.getResources().getConfiguration().locale;
    L4:
        return null;
    }

    public static boolean containsSubtypeOf(InputMethodInfo r7, Locale r8, boolean r9, String r10) {
        if (r8 != null) goto L5;
        return false;
    L5:
        int r1 = r7.getSubtypeCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L29;
        InputMethodSubtype r3 = r7.getSubtypeAt(r2);
        if (r9 == false) goto L17;
        Locale r4 = r3.getLocaleObject();
        if (r4 == null) goto L26;
        if (TextUtils.equals(r4.getLanguage(), r8.getLanguage()) == false) goto L26;
        if (TextUtils.equals(r4.getCountry(), r8.getCountry()) == false) goto L26;
    L20:
        if (r10 == SUBTYPE_MODE_ANY) goto L27;
        if (TextUtils.isEmpty(r10) == true) goto L39;
        if (r10.equalsIgnoreCase(r3.getMode()) == false) goto L26;
        return true;
    L39:
        return true;
    L27:
        return true;
    L26:
        r2 = r2 + 1;
        goto L6
    L17:
        if (TextUtils.equals(new Locale(getLanguageFromLocaleString(r3.getLocale())).getLanguage(), r8.getLanguage()) == true) goto L20;
    L29:
        return false;
    }

    public static ArrayList<InputMethodSubtype> getSubtypes(InputMethodInfo r4) {
        ArrayList<InputMethodSubtype> r0 = new ArrayList();
        int r1 = r4.getSubtypeCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(r4.getSubtypeAt(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static boolean isValidSubtypeId(InputMethodInfo r0, int r1) {
        if (getSubtypeIdFromHashCode(r0, r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getSubtypeIdFromHashCode(InputMethodInfo r3, int r4) {
        if (r3 == null) goto L9;
        int r0 = r3.getSubtypeCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L13;
        if (r4 == r3.getSubtypeAt(r1).hashCode()) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return r1;
    L13:
        return -1;
    L9:
        return -1;
    }

    public static boolean isCurrentLocaleChinese(Context r1) {
        Locale r2 = getSystemLocaleFromContext(r1);
        if (Locale.SIMPLIFIED_CHINESE.equals(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (Locale.TRADITIONAL_CHINESE.equals(r2) == true) goto L8;
        return false;
    }

    public static ArrayList<InputMethodSubtype> getImplicitlyApplicableSubtypesLocked(Resources r3, InputMethodInfo r4) {
        LocaleList r0 = r3.getConfiguration().getLocales();
        Object r1 = sCacheLock;
        monitor-enter(r1);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (r0.equals(sCachedSystemLocales) == true) goto L7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L20
        ArrayList<InputMethodSubtype> r5 = getImplicitlyApplicableSubtypesLockedImpl(r3, r4);
        monitor-enter(r1);
        sCachedSystemLocales = r0;     // Catch: Throwable -> L17
        sCachedInputMethodInfo = r4;     // Catch: Throwable -> L17
        sCachedResult = new ArrayList(r5);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r5;
    L17:
        th = move-exception;
        throw th;
    L7:
        if (sCachedInputMethodInfo != r4) goto L11;
        ArrayList<InputMethodSubtype> r6 = new ArrayList(sCachedResult);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        return r6;
    }

    private static ArrayList<InputMethodSubtype> getImplicitlyApplicableSubtypesLockedImpl(Resources r11, InputMethodInfo r12) {
        ArrayList<InputMethodSubtype> r13 = getSubtypes(r12);
        LocaleList r0 = r11.getConfiguration().getLocales();
        int r1 = 0;
        String r2 = r0.get(0).toString();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        int r3 = r13.size();
        ArrayMap r4 = new ArrayMap();
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L15;
        InputMethodSubtype r6 = r13.get(r5);
        if (r6.overridesImplicitlyEnabledSubtype() == false) goto L13;
        String r7 = r6.getMode();
        if (r4.containsKey(r7) == true) goto L13;
        r4.put(r7, r6);
    L13:
        r5 = r5 + 1;
        goto L7
    L15:
        if (r4.size() > 0) goto L17;
        ArrayMap r8 = new ArrayMap();
        ArrayList r9 = new ArrayList();
        int r10 = 0;
    L20:
        if (r10 >= r3) goto L29;
        InputMethodSubtype r14 = r13.get(r10);
        String r15 = r14.getMode();
        if ("keyboard".equals(r15) == false) goto L25;
        r9.add(r14);
    L28:
        r10 = r10 + 1;
        goto L20
    L25:
        if (r8.containsKey(r15) == true) goto L27;
        r8.put(r15, new ArrayList());
    L27:
        ((ArrayList) r8.get(r15)).add(r14);
        goto L28
    L29:
        ArrayList<InputMethodSubtype> r16 = new ArrayList();
        LocaleUtils.filterByLanguage(r9, sSubtypeToLocale, r0, r16);
        if (r16.isEmpty() == true) goto L48;
        int r17 = r16.size();
        int r18 = 0;
    L32:
        if (r18 >= r17) goto L37;
        if (r16.get(r18).isAsciiCapable() == true) goto L35;
        r18 = r18 + 1;
        goto L32
    L35:
        boolean r19 = true;
    L38:
        if (r19 == true) goto L48;
        int r20 = r9.size();
    L40:
        if (r1 >= r20) goto L48;
        InputMethodSubtype r21 = (InputMethodSubtype) r9.get(r1);
        if ("keyboard".equals(r21.getMode()) == false) goto L46;
        if (r21.containsExtraValueKey(TAG_ENABLED_WHEN_DEFAULT_IS_NOT_ASCII_CAPABLE) == false) goto L46;
        r16.add(r21);
    L46:
        r1 = r1 + 1;
        goto L40
    L37:
        r19 = false;
    L48:
        if (r16.isEmpty() == false) goto L52;
        InputMethodSubtype r110 = findLastResortApplicableSubtypeLocked(r11, r13, "keyboard", r2, true);
        if (r110 == null) goto L52;
        r16.add(r110);
    L52:
        Iterator r111 = r8.values().iterator();
    L54:
        if (r111.hasNext() == false) goto L56;
        LocaleUtils.filterByLanguage((ArrayList) r111.next(), sSubtypeToLocale, r0, r16);
        goto L54
    L56:
        return r16;
    L17:
        return new ArrayList(r4.values());
    L5:
        return new ArrayList();
    }

    public static String getLanguageFromLocaleString(String r2) {
        int r0 = r2.indexOf(95);
        if (r0 >= 0) goto L6;
        return r2;
    L6:
        return r2.substring(0, r0);
    }

    public static InputMethodSubtype findLastResortApplicableSubtypeLocked(Resources r9, List<InputMethodSubtype> r10, String r11, String r12, boolean r13) {
        InputMethodSubtype r0 = null;
        if (r10 != null) goto L5;
    L30:
        return null;
    L5:
        if (r10.size() == 0) goto L30;
        if (TextUtils.isEmpty(r12) == false) goto L10;
        r12 = r9.getConfiguration().locale.toString();
    L10:
        String r14 = getLanguageFromLocaleString(r12);
        int r1 = r10.size();
        int r3 = 0;
        boolean r4 = false;
        InputMethodSubtype r2 = null;
    L11:
        if (r3 >= r1) goto L26;
        InputMethodSubtype r5 = r10.get(r3);
        String r6 = r5.getLocale();
        String r7 = getLanguageFromLocaleString(r6);
        if (r11 != null) goto L15;
    L16:
        if (r0 != null) goto L19;
        r0 = r5;
    L19:
        if (r12.equals(r6) == true) goto L20;
        if (r4 == true) goto L25;
        if (r14.equals(r7) == false) goto L25;
        r4 = true;
        r2 = r5;
    L25:
        r3 = r3 + 1;
        goto L11
    L20:
        r2 = r5;
        goto L26
    L15:
        if (r10.get(r3).getMode().equalsIgnoreCase(r11) == false) goto L25;
    L26:
        if (r2 != null) goto L29;
        if (r13 == false) goto L29;
        return r0;
    L29:
        return r2;
    }

    public static boolean canAddToLastInputMethod(InputMethodSubtype r1) {
        if (r1 != null) goto L6;
        return true;
    L6:
        return !r1.isAuxiliary();
    }

    public static void setNonSelectedSystemImesDisabledUntilUsed(IPackageManager r9, List<InputMethodInfo> r10, int r11, String r12) {
        String[] r0 = Resources.getSystem().getStringArray(R.array.config_displayWhiteBalanceHighLightAmbientBiasesStrong);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length == 0) goto L49;
        SpellCheckerInfo r1 = TextServicesManagerInternal.get().getCurrentSpellCheckerForUser(r11);
        int r2 = r0.length;
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L50;
        String r5 = r0[r4];
        int r6 = 0;
    L10:
        boolean r8 = true;
        if (r6 >= r10.size()) goto L16;
        if (r5.equals(r10.get(r6).getPackageName()) == true) goto L14;
        r6 = r6 + 1;
        goto L10
    L14:
        boolean r7 = true;
    L17:
        if (r7 == true) goto L36;
        if (r1 == null) goto L38;
        if (r5.equals(r1.getPackageName()) == true) goto L36;
    L38:
        ApplicationInfo r13 = r9.getApplicationInfo(r5, 32768, r11);     // Catch: RemoteException -> L34
        if (r13 == null) goto L36;
        if ((r13.flags & 1) != 0) goto L31;
        r8 = false;
    L31:
        if (r8 == false) goto L36;
        setDisabledUntilUsed(r9, r5, r11, r12);
    L34:
        e = move-exception;
        Slog.w(TAG, "getApplicationInfo failed. packageName=" + r5 + " userId=" + r11, e);
    L36:
        r4 = r4 + 1;
        goto L8
    L16:
        r7 = false;
        goto L17
    L50:
        return;
    }

    private static void setDisabledUntilUsed(IPackageManager r10, String r11, int r12, String r13) {
        int r2 = r10.getApplicationEnabledSetting(r11, r12);     // Catch: RemoteException -> L13
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L18;
        return;
    L18:
        r10.setApplicationEnabledSetting(r11, 4, 0, r12, r13);     // Catch: RemoteException -> L10
        return;
    L10:
        e = move-exception;
        Slog.w(TAG, "setApplicationEnabledSetting failed. packageName=" + r11 + " userId=" + r12 + " callingPackage=" + r13, e);
        return;
    L13:
        e = move-exception;
        Slog.w(TAG, "getApplicationEnabledSetting failed. packageName=" + r11 + " userId=" + r12, e);
    }

    public static CharSequence getImeAndSubtypeDisplayName(Context r3, InputMethodInfo r4, InputMethodSubtype r5) {
        String r1 = "";
        if (r3.getPackageManager() == null) goto L5;
        CharSequence r0 = r4.loadLabel(r3.getPackageManager());
    L6:
        if (r5 == null) goto L15;
        CharSequence r6 = r5.getDisplayName(r3, r4.getPackageName(), r4.getServiceInfo().applicationInfo);
        if (TextUtils.isEmpty(r0) == false) goto L10;
    L13:
        OLog.d(TAG, "getImeAndSubtypeDisplayName displayName:" + r6 + ", imiLabel:" + r0);
        return TextUtils.concat(new CharSequence[]{r6, r1, r0});
    L10:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r1 = " - ";
        goto L13
    L15:
        return r0;
    L5:
        r0 = "";
        goto L6
    }

    public static boolean checkIfPackageBelongsToUid(AppOpsManager r0, int r1, String r2) {
        r0.checkPackage(r1, r2);     // Catch: SecurityException -> L5
        return true;
    L5:
        return false;
    }
}
