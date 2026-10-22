package com.bytedanceos.application;

import android.text.TextUtils;
import bytedanceos.t9search.HanziToPinyin;
import com.bytedanceos.security.widget.pinyin.PinyinUtils;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.security.R;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LabelEntry {
    private static String mSpecialLableSource;
    private static String mSpecialLableSourceExclude;
    private static String mSpecialLableTarget;
    public char firstChar;
    public String firstLetters;
    public String label;
    public String labelPinyin;

    static {
        mSpecialLableSource = SecurityCenterApplication.getApplication().getString(R.string.speical_app_label_source);
        mSpecialLableTarget = SecurityCenterApplication.getApplication().getString(R.string.speical_app_label_target);
        mSpecialLableSourceExclude = SecurityCenterApplication.getApplication().getString(R.string.speical_app_label_source_music);
    }

    public LabelEntry(String label) {
        init(label);
    }

    private void init(String label) {
        this.label = label;
        List r0 = Collections.emptyList();
        HanziToPinyin r1 = HanziToPinyin.getInstance();     // Catch: Exception -> L5
    L8:
        if (label == null) goto L22;
        String r3 = label.trim();
        if (TextUtils.isEmpty(r3) == true) goto L22;
        if (TextUtils.isEmpty(mSpecialLableSource) == true) goto L22;
        if (TextUtils.isEmpty(mSpecialLableSourceExclude) == true) goto L22;
        if (r3.startsWith(mSpecialLableSource) == false) goto L22;
        if (r3.startsWith(mSpecialLableSourceExclude) == true) goto L22;
        boolean r5 = true;
        String r4 = new StringBuilder().append(mSpecialLableTarget).append(r3.substring(1)).toString();
        if (r1 == null) goto L23;
        r0 = r1.get(r4);
    L23:
        if (r5 == true) goto L26;
        if (r1 == null) goto L26;
        r0 = r1.get(label);
    L26:
        StringBuilder r7 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();
        Iterator r6 = r0.iterator();
    L28:
        if (r6.hasNext() == false) goto L32;
        HanziToPinyin.Token r8 = (HanziToPinyin.Token) r6.next();
        char r9 = r8.target.charAt(0);
        if (Character.isSpaceChar(r9) == true) goto L28;
        r7.append(r9);
        r2.append(r8.target);
        goto L28
    L32:
        this.labelPinyin = r2.toString();
        this.firstLetters = r7.toString();
        this.firstChar = PinyinUtils.getFirstChar(this.labelPinyin);
        return;
    L22:
        r5 = false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L8
    }

    public String toString() {
        return "LabelEntry{label='" + this.label + "', labelPinyin='" + this.labelPinyin + "', firstLetters='" + this.firstLetters + "', firstChar=" + this.firstChar + '}';
    }
}
