package com.bytedance.frameworks.baselib.network.queryfilter;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.client.Request;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class QueryFilterAction {
    private static final String KEY_ENCRYPT_ACTION = "encrypt";
    private static final String KEY_EQUAL_GROUP = "equal_group";
    private static final String KEY_HOST_GROUP = "host_group";
    private static final String KEY_PATTERN_GROUP = "pattern_group";
    private static final String KEY_PREFIX_GROUP = "prefix_group";
    private static final String KEY_RM_ACTION = "rm";
    private static final String TAG = "QueryFilterAction";
    private Set<String> mDomainFilterSet;
    private Set<String> mEqualPathSet;
    protected boolean mNeedBackgroundProtect;
    private Set<Pattern> mPatternPathSet;
    private Set<String> mPrefixPathSet;
    private int mPriority;
    private int mSetReqPriority;

    static {
    }

    protected abstract boolean dispatch(Request r1, Map<String, List<String>> r2);

    protected abstract void loadActionParam(JSONObject r1);

    public QueryFilterAction(int r2) {
        this.mNeedBackgroundProtect = false;
        this.mDomainFilterSet = new HashSet();
        this.mEqualPathSet = new HashSet();
        this.mPrefixPathSet = new HashSet();
        this.mPatternPathSet = new HashSet();
        this.mPriority = r2;
        this.mSetReqPriority = r2;
    }

    public int getPriority() {
        return this.mPriority;
    }

    protected boolean takeAction(Request r4, Map<String, List<String>> r5, List<QueryActionInfo> r6) {
        QueryActionInfo r0 = new QueryActionInfo();
        r0.setActionStartTime(SystemClock.uptimeMillis());
        boolean r7 = doDispatch(r4, r5);
        if (r7 == false) goto L5;
        r4.setQueryFilterPriority(this.mSetReqPriority);
    L5:
        r0.setActionHit(r7);
        r0.setActionPriority(this.mPriority);
        r0.setActionEndTime(SystemClock.uptimeMillis());
        r6.add(r0);
        return r7;
    }

    protected static QueryFilterAction createQueryFilterAction(String r1, int r2, int r3, JSONObject r4) {
        if (r1.equals(KEY_RM_ACTION) == false) goto L6;
        QueryFilterAction r5 = new QueryRemoveAction(r2);
    L8:
        r5.loadActionParam(r4);
        r5.setReqPriority(r3);
        return r5;
    L6:
        if (r1.equals(KEY_ENCRYPT_ACTION) == false) goto L10;
        r5 = new QueryEncryptAction(r2);
        goto L8
    L10:
        return null;
    }

    protected void loadMatchRules(JSONObject r3) {
        parseArraySetStringConfig(r3.optJSONArray(KEY_HOST_GROUP), this.mDomainFilterSet);
        parseArraySetStringConfig(r3.optJSONArray(KEY_EQUAL_GROUP), this.mEqualPathSet);
        parseArraySetStringConfig(r3.optJSONArray(KEY_PREFIX_GROUP), this.mPrefixPathSet);
        parseArraySetPatternConfig(r3.optJSONArray(KEY_PATTERN_GROUP), this.mPatternPathSet);
    }

    private boolean isHostMatch(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Iterator<String> r2 = this.mDomainFilterSet.iterator();
    L7:
        if (r2.hasNext() == false) goto L15;
        if (UrlUtils.matchPattern(r3, r2.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    protected boolean isMatchUrlRules(Request r6) {
        if (this.mNeedBackgroundProtect == false) goto L8;
        if (QueryFilterStateListener.getInstance().mIsBackgroundState.get() == true) goto L8;
        return false;
    L8:
        if (isEmptySet(this.mDomainFilterSet) == false) goto L10;
    L12:
        String r7 = r6.getPath();
        if (TextUtils.isEmpty(r7) == true) goto L15;
        int r0 = r7.length();
        if (r0 <= 1) goto L24;
        int r1 = r0 - 1;
        if (r7.substring(r1).equals(LibrarianImpl.Constants.SEPARATOR) == false) goto L24;
        r7 = r7.substring(0, r1);
    L24:
        if (isEmptySet(this.mEqualPathSet) == true) goto L29;
        if (this.mEqualPathSet.contains(r7) == false) goto L29;
        return true;
    L29:
        if (isEmptySet(this.mPrefixPathSet) == true) goto L37;
        Iterator<String> r2 = this.mPrefixPathSet.iterator();
    L32:
        if (r2.hasNext() == false) goto L37;
        if (r7.startsWith(r2.next()) == false) goto L32;
        return true;
    L37:
        if (isEmptySet(this.mPatternPathSet) == true) goto L46;
        Iterator<Pattern> r5 = this.mPatternPathSet.iterator();
    L40:
        if (r5.hasNext() == false) goto L46;
        Pattern r3 = r5.next();
        if (r3 == null) goto L40;
        if (r3.matcher(r7).matches() == false) goto L40;
        return true;
    L46:
        return false;
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "Path is empty: " + r7);
    L17:
        return false;
    L10:
        if (isHostMatch(r6.getHost()) == true) goto L12;
        return false;
    }

    private static void parseArraySetPatternConfig(JSONArray r3, Set<Pattern> r4) {
        if (r3 == null) goto L13;
        if (r4 == null) goto L23;
        int r0 = 0;
    L16:
        if (r0 >= r3.length()) goto L25;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r4.add(Pattern.compile(r1, 2));     // Catch: Throwable -> L14
    L12:
        r0 = r0 + 1;
        goto L16
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    private void parseArraySetStringConfig(JSONArray r3, Set<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r2 = 0;
    L14:
        if (r2 >= r3.length()) goto L21;
        String r0 = r3.getString(r2);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r0) == true) goto L11;
        r4.add(r0);     // Catch: JSONException -> L13
    L11:
        r2 = r2 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private void setReqPriority(int r1) {
        this.mSetReqPriority = r1;
    }

    private boolean isActionEffective(Request r1) {
        if (r1.getQueryFilterPriority() <= this.mPriority) goto L6;
        return false;
    L6:
        return true;
    }

    private boolean doDispatch(Request r2, Map<String, List<String>> r3) {
        if (isActionEffective(r2) == true) goto L7;
        return false;
    L7:
        return dispatch(r2, r3);
    }

    private static boolean isEmptySet(Set<?> r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }
}
