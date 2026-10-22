package com.bytedance.frameworks.baselib.network.config.hostpathmatch;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathValueBase;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class TTHostPathRuleBaseTNCConfig<T extends TTHostPathValueBase> {
    private static final String TAG = "TTHostPathMatchRule";
    private T mDefaultValue;
    protected final AtomicBoolean mEnable;
    private final List<Pair<TTHostPathCondition, T>> mRuleList;

    public TTHostPathRuleBaseTNCConfig() {
        this.mEnable = new AtomicBoolean(false);
        this.mRuleList = new CopyOnWriteArrayList();
    }

    public abstract String getConfigRootKey();

    public T getValue(String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L104:
        return null;
    L5:
        if (this.mEnable.get() == false) goto L104;
        Uri r12 = Uri.parse(r11);
        if (r12 != null) goto L10;
        return null;
    L10:
        String r0 = r12.getHost();
        String r13 = r12.getPath();
        if (TextUtils.isEmpty(r0) == true) goto L104;
        if (TextUtils.isEmpty(r13) == true) goto L104;
        Iterator<Pair<TTHostPathCondition, T>> r1 = this.mRuleList.iterator();
    L17:
        if (r1.hasNext() == false) goto L100;
        Pair<TTHostPathCondition, T> r2 = r1.next();
        if (r2 == null) goto L17;
        TTHostPathCondition r4 = (TTHostPathCondition) r2.first;
        if (r4 == null) goto L17;
        Set<String> r5 = r4.hostEq;
        boolean r6 = false;
        boolean r7 = true;
        if (r5 != null) goto L27;
    L32:
        boolean r8 = false;
    L33:
        if (r8 == true) goto L45;
        Set<String> r9 = r4.hostWc;
        if (r9 == null) goto L45;
        Iterator<String> r10 = r9.iterator();
    L38:
        if (r10.hasNext() == false) goto L45;
        if (UrlUtils.matchPattern(r0, r10.next()) == false) goto L38;
        if (Logger.debug() == false) goto L44;
        Logger.d(TAG, "hitRule: host_wc.");
    L44:
        r8 = true;
    L45:
        if (r8 == false) goto L100;
        Set<String> r14 = r4.pathEq;
        if (r14 != null) goto L50;
    L55:
        if (r6 == true) goto L67;
        Set<String> r15 = r4.pathPrefix;
        if (r15 == null) goto L67;
        Iterator<String> r16 = r15.iterator();
    L60:
        if (r16.hasNext() == false) goto L67;
        if (r13.startsWith(r16.next()) == false) goto L60;
        if (Logger.debug() == false) goto L66;
        Logger.d(TAG, "hitRule: path_prefix.");
    L66:
        r6 = true;
    L67:
        if (r6 == true) goto L79;
        Set<String> r17 = r4.pathContain;
        if (r17 == null) goto L79;
        Iterator<String> r18 = r17.iterator();
    L72:
        if (r18.hasNext() == false) goto L79;
        if (r13.contains(r18.next()) == false) goto L72;
        if (Logger.debug() == false) goto L78;
        Logger.d(TAG, "hitRule: path_contain.");
    L78:
        r6 = true;
    L79:
        if (r6 == true) goto L94;
        Set<Pattern> r19 = r4.pathPattern;
        if (r19 == null) goto L94;
        Iterator<Pattern> r20 = r19.iterator();
    L84:
        if (r20.hasNext() == false) goto L94;
        Pattern r21 = r20.next();
        if (r21 == null) goto L84;
        if (r21.matcher(r13).matches() == false) goto L84;
    L93:
        r6 = true;
        goto L84
    L90:
        if (Logger.debug() == false) goto L95;
        Logger.d(TAG, "hitRule: path_pattern.");     // Catch: Throwable -> L93
    L95:
        if (r7 == false) goto L17;
        return (T) r2.second;
    L94:
        r7 = r6;
        goto L95
    L50:
        if (r14.contains(r13) == false) goto L55;
        if (Logger.debug() == false) goto L54;
        Logger.d(TAG, "hitRule: path_eq.");
    L54:
        r6 = true;
        goto L55
    L27:
        if (r5.contains(r0) == false) goto L32;
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "hitRule: host_eq.");
    L31:
        r8 = true;
    L100:
        if (Logger.debug() == false) goto L103;
        Logger.d(TAG, "use default config");
    L103:
        return this.mDefaultValue;
    }

    public List<Pair<TTHostPathCondition, T>> getmRuleList() {
        return this.mRuleList;
    }

    public boolean isEnabled() {
        return this.mEnable.get();
    }

    public abstract T parseHostPathValue(Object r1);

    public Set<String> parseJSONArrayToSet(JSONArray r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.length() == 0) goto L19;
        HashSet r3 = new HashSet();
        int r0 = 0;
    L8:
        if (r0 >= r4.length()) goto L13;
        String r1 = r4.optString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r3.add(r1);
    L12:
        r0 = r0 + 1;
        goto L8
    L13:
        return r3;
    L19:
        return null;
    }

    public boolean parseSpecificConfig(JSONObject r1) {
        return true;
    }

    public boolean parseTNCConfig(JSONObject r9) {
        int r1 = 0;
        this.mEnable.set(false);
        this.mRuleList.clear();
        if (r9 != null) goto L5;
    L95:
        return false;
    L5:
        if (r9.length() == 0) goto L95;
        JSONObject r10 = r9.optJSONObject(getConfigRootKey());
        if (r10 != null) goto L10;
    L94:
        return true;
    L10:
        if (r10.length() == 0) goto L94;
        AtomicBoolean r2 = this.mEnable;
        if (r10.optInt("enabled", 0) <= 0) goto L15;
        boolean r3 = true;
    L16:
        r2.set(r3);
        if (this.mEnable.get() == true) goto L20;
        return true;
    L20:
        if (parseSpecificConfig(r10) == true) goto L22;
        return false;
    L22:
        Object r4 = r10.opt("default");
        if (r4 == null) goto L25;
        this.mDefaultValue = (T) parseHostPathValue(r4);
    L25:
        JSONArray r11 = r10.optJSONArray("rule_list");
        if (r11 != null) goto L28;
    L93:
        return false;
    L28:
        if (r11.length() == 0) goto L93;
    L31:
        if (r1 >= r11.length()) goto L92;
        JSONObject r5 = r11.optJSONObject(r1);
        if (r5 == null) goto L91;
        if (r5.length() == 0) goto L91;
        TTHostPathCondition r6 = new TTHostPathCondition();
        r6.hostEq = parseJSONArrayToSet(r5.optJSONArray("host_eq"));
        r6.hostWc = parseJSONArrayToSet(r5.optJSONArray("host_wc"));
        Set<String> r7 = r6.hostEq;
        if (r7 != null) goto L40;
    L41:
        Set<String> r8 = r6.hostWc;
        if (r8 == null) goto L89;
        if (r8.isEmpty() == true) goto L89;
    L46:
        r6.pathEq = parseJSONArrayToSet(r5.optJSONArray("path_eq"));
        r6.pathPrefix = parseJSONArrayToSet(r5.optJSONArray("path_prefix"));
        r6.pathContain = parseJSONArrayToSet(r5.optJSONArray("path_contain"));
        Set<String> r12 = parseJSONArrayToSet(r5.optJSONArray("path_pattern"));
        if (r12 == null) goto L54;
        r6.pathPattern = new HashSet();
        Iterator<String> r13 = r12.iterator();
    L50:
        if (r13.hasNext() == false) goto L54;
        r6.pathPattern.add(Pattern.compile(r13.next()));     // Catch: Throwable -> L96
    L54:
        Set<String> r14 = r6.pathEq;
        if (r14 != null) goto L57;
    L58:
        Set<String> r15 = r6.pathPrefix;
        if (r15 != null) goto L61;
    L62:
        Set<String> r16 = r6.pathContain;
        if (r16 != null) goto L65;
    L66:
        Set<Pattern> r17 = r6.pathPattern;
        if (r17 == null) goto L86;
        if (r17.isEmpty() == true) goto L86;
    L71:
        Object r18 = r5.opt("value");
        if (r18 == null) goto L74;
        TTHostPathValueBase r19 = parseHostPathValue(r18);
        if (r19 == null) goto L79;
        String r20 = r5.optString("sign");
        if (TextUtils.isEmpty(r20) == true) goto L84;
        r19.sign = r20;
    L84:
        this.mRuleList.add(new Pair(r6, r19));
        goto L91
    L79:
        if (Logger.debug() == false) goto L91;
        Logger.d(TAG, "ParseHostPathValue failed.");
        goto L91
    L74:
        if (Logger.debug() == false) goto L91;
        Logger.d(TAG, "value is null.");
    L86:
        if (Logger.debug() == false) goto L91;
        Logger.d(TAG, "no path filter exist.");
        goto L91
    L65:
        if (r16.isEmpty() == false) goto L71;
    L61:
        if (r15.isEmpty() == false) goto L71;
    L57:
        if (r14.isEmpty() == false) goto L71;
    L89:
        if (Logger.debug() == false) goto L91;
        Logger.d(TAG, "both host_eq and host_wc empty.");
        goto L91
    L40:
        if (r7.isEmpty() == false) goto L46;
    L91:
        r1 = r1 + 1;
        goto L31
    L92:
        return true;
    L15:
        r3 = false;
        goto L16
    }

    public void setEnabled(boolean r1) {
        this.mEnable.set(r1);
    }
}
