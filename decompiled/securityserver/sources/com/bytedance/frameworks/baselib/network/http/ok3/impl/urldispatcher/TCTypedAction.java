package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TCTypedAction extends URLDispatchAction {
    public static final int DEFAULT_DROP_CODE = -555;
    private static final int MAX_USER_DEFINED_DROP_CODE = -5551;
    private static final int MIN_USER_DEFINED_DROP_CODE = -5559;
    private static final String TAG = "TCTypedAction";
    private int mDropCode;
    private String mHostReplace;
    private boolean mIsDrop;
    private boolean mIsInvalid;
    private String mPathReplace;
    private int mPossibility;
    private String mReplaceRegex;
    private String mReplaceValue;
    private String mSchemeReplace;

    public TCTypedAction() {
        this.mIsDrop = false;
        this.mDropCode = -555;
        this.mPossibility = 100;
        this.mIsInvalid = false;
    }

    private boolean canReplceScheme(String r5, String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return false;
    L6:
        if (r5.equals(r6) == false) goto L9;
        return true;
    L9:
        if (r5.equals(HttpHost.DEFAULT_SCHEME_NAME) == true) goto L13;
        if (r5.equals("https") == true) goto L13;
    L18:
        if (r5.equals("ws") == true) goto L22;
        if (r5.equals("wss") == true) goto L22;
    L26:
        return false;
    L22:
        if (r6.equals("ws") == false) goto L24;
    L27:
        return true;
    L24:
        if (r6.equals("wss") == false) goto L26;
    L13:
        if (r6.equals(HttpHost.DEFAULT_SCHEME_NAME) == true) goto L27;
        if (r6.equals("https") == false) goto L18;
        goto L27
    }

    private boolean isPossibilityHit() {
        int r0 = this.mPossibility;
        if (r0 < 100) goto L6;
        return true;
    L6:
        if (r0 > 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(100) >= this.mPossibility) goto L12;
        return true;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "tc drop action was probabilistic discard");
    L14:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public BaseDispatchAction.DispatchResultEnum dispatch(URLRequest r4, String r5, List<String> r6) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "tc action");
    L5:
        Uri r7 = Uri.parse(r5);
        if (this.mIsInvalid == false) goto L8;
    L53:
        r6.set(0, r5);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L8:
        if (isMatchRules(r7) == false) goto L53;
        r6.set(0, r5);
        if (this.mIsDrop == false) goto L22;
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "drop action");
    L16:
        if (isPossibilityHit() == false) goto L20;
        r6.set(0, "");
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP;
    L20:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L22:
        if (this.mHostReplace.isEmpty() == false) goto L37;
        if (this.mSchemeReplace.isEmpty() == false) goto L37;
        if (this.mPathReplace.isEmpty() == false) goto L37;
        if (TextUtils.isEmpty(this.mReplaceValue) == true) goto L35;
        if (TextUtils.isEmpty(this.mReplaceRegex) == true) goto L35;
        r6.set(0, r5.replaceAll(this.mReplaceRegex, this.mReplaceValue));
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
    L35:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L37:
        if (r7.getScheme() == null) goto L42;
        if (canReplceScheme(r7.getScheme(), this.mSchemeReplace) == false) goto L42;
        r5 = r5.replaceFirst(r7.getScheme(), this.mSchemeReplace);
    L42:
        if (r7.getHost() == null) goto L47;
        if (TextUtils.isEmpty(this.mHostReplace) == true) goto L47;
        r5 = r5.replaceFirst(r7.getHost(), this.mHostReplace);
    L47:
        if (r7.getPath() != null) goto L49;
    L51:
        r6.set(0, r5);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
    L49:
        if (TextUtils.isEmpty(this.mPathReplace) == true) goto L51;
        r5 = r5.replaceFirst(r7.getPath(), this.mPathReplace);
        goto L51
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public int getDispatchStrategyType() {
        return -1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public int getTcTypedDropCode() {
        return this.mDropCode;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public boolean loadActionParam(JSONObject r2, List<Boolean> r3, String r4, long r5) {
        loadMatchRules(r2);
        this.mServiceName = r2.optString("service_name");
        this.mSchemeReplace = r2.optString("scheme_replace");
        this.mHostReplace = r2.optString("host_replace");
        this.mPathReplace = r2.optString("path_replace");
        String r6 = r2.optString("replace");
        this.mReplaceValue = r6;
        if (TextUtils.isEmpty(r6) == true) goto L10;
        String r7 = r2.optString("regex");
        if (BaseDispatchAction.isPatternStringValid(r7) == false) goto L7;
        this.mReplaceRegex = r7;
        goto L10
    L7:
        this.mIsInvalid = true;
        return true;
    L10:
        if (r2.optInt("drop") != 1) goto L12;
        boolean r8 = true;
    L13:
        this.mIsDrop = r8;
        int r9 = r2.optInt("drop_code", -1);
        if (r9 != (-555)) goto L16;
    L19:
        this.mDropCode = r9;
    L20:
        int r10 = r2.optInt("possibility", 100);
        if (r10 < 0) goto L25;
        if (r10 > 100) goto L25;
        this.mPossibility = r10;
    L25:
        if (this.mEqualGroup.isEmpty() == false) goto L35;
        if (this.mPrefixGroup.isEmpty() == false) goto L35;
        if (this.mContainGroup.isEmpty() == false) goto L35;
        if (this.mPatternGroup.isEmpty() == false) goto L35;
        if (this.mFullUrlGroup.isEmpty() == false) goto L35;
    L44:
        this.mIsInvalid = true;
    L45:
        r3.set(0, Boolean.FALSE);
        return true;
    L35:
        if (this.mIsDrop == true) goto L45;
        if (this.mSchemeReplace.isEmpty() == false) goto L45;
        if (this.mHostReplace.isEmpty() == false) goto L45;
        if (this.mPathReplace.isEmpty() == false) goto L45;
        if (this.mReplaceValue.isEmpty() == false) goto L45;
    L16:
        if (r9 < (-5559)) goto L20;
        if (r9 > (-5551)) goto L20;
    L12:
        r8 = false;
        goto L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public void onRequestCompleted(String r1, boolean r2, int r3) {
    }
}
