package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDispatchAction {
    private static final String TAG = "BaseDispatchAction";
    protected List<String> mContainGroup;
    protected List<String> mEqualGroup;
    protected List<String> mFullUrlGroup;
    protected List<String> mFullUrlGroupPathContain;
    protected List<String> mHostGroup;
    private long mLifetimeBegin;
    private long mLifetimeEnd;
    protected List<String> mPatternGroup;
    protected List<String> mPrefixGroup;
    private int mPriority;
    private long mRuleId;
    protected String mServiceName;
    protected int mSetReqPriority;
    private List<String> mSupportedMethods;

    public static final enum DispatchResultEnum extends Enum<DispatchResultEnum> {
        private static final /* synthetic */ DispatchResultEnum[] $VALUES = null;
        public static final DispatchResultEnum DISPATCH_DELAY = null;
        public static final DispatchResultEnum DISPATCH_DROP = null;
        public static final DispatchResultEnum DISPATCH_HIT = null;
        public static final DispatchResultEnum DISPATCH_NONE = null;

        static {
            DispatchResultEnum r0 = new DispatchResultEnum("DISPATCH_NONE", 0);
            DISPATCH_NONE = r0;
            DispatchResultEnum r1 = new DispatchResultEnum("DISPATCH_HIT", 1);
            DISPATCH_HIT = r1;
            DispatchResultEnum r3 = new DispatchResultEnum("DISPATCH_DROP", 2);
            DISPATCH_DROP = r3;
            DispatchResultEnum r5 = new DispatchResultEnum("DISPATCH_DELAY", 3);
            DISPATCH_DELAY = r5;
            $VALUES = new DispatchResultEnum[]{r0, r1, r3, r5};
        }

        private DispatchResultEnum(String r1, int r2) {
            super(r1, r2);
        }

        public static DispatchResultEnum valueOf(String r1) {
            return (DispatchResultEnum) Enum.valueOf(DispatchResultEnum.class, r1);
        }

        public static DispatchResultEnum[] values() {
            return (DispatchResultEnum[]) $VALUES.clone();
        }
    }

    static {
    }

    public abstract boolean initWithActionParam(JSONObject r1, String r2, long r3);

    public BaseDispatchAction() {
        this.mHostGroup = new ArrayList();
        this.mEqualGroup = new ArrayList();
        this.mPrefixGroup = new ArrayList();
        this.mContainGroup = new ArrayList();
        this.mPatternGroup = new ArrayList();
        this.mFullUrlGroup = new ArrayList();
        this.mFullUrlGroupPathContain = new ArrayList();
        this.mSupportedMethods = new ArrayList();
    }

    public static BaseDispatchAction factory(String r7, JSONObject r8, int r9, long r10, long r12, long r14, String r16, long r17, List<String> r19, int r20) {
        if (r7.equals("tc") == false) goto L5;
        BaseDispatchAction r1 = new TCTypedAction();
    L7:
        if (r7.equals("dispatch") == false) goto L10;
        r1 = new DispatchTypedAction();
    L10:
        if (r7.equals("delay") == false) goto L12;
        r1 = new DelayTypedAction();
    L12:
        if (r1 != null) goto L14;
        return null;
    L14:
        r1.setPriority(r9);
        r1.setLifeCycle(r10, r12);
        r1.setRuleId(r14);
        r1.setSupportedMethods(r19);
        r1.setSetRequestPriority(r20);
        if (r1.initWithActionParam(r8, r16, r17) == false) goto L17;
        return r1;
    L17:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    private void setPriority(int r1) {
        this.mPriority = r1;
    }

    private void setLifeCycle(long r1, long r3) {
        this.mLifetimeBegin = r1;
        this.mLifetimeEnd = r3;
    }

    private void setRuleId(long r1) {
        this.mRuleId = r1;
    }

    private void setSupportedMethods(List<String> r1) {
        this.mSupportedMethods = r1;
    }

    private void setSetRequestPriority(int r1) {
        if (r1 >= 0) goto L4;
        this.mSetReqPriority = Integer.MAX_VALUE;
        return;
    L4:
        this.mSetReqPriority = r1;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public long getRuleId() {
        return this.mRuleId;
    }

    public String getServiceName() {
        return this.mServiceName;
    }

    public boolean isActionEffective(URLRequest r5) {
        if (r5.getDispatchPriority() <= this.mPriority) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "jump action: " + this.mServiceName + ", dispatchPriority: " + r5.getDispatchPriority() + ", actionPriority: " + this.mPriority);
    L7:
        return false;
    L9:
        if (this.mSupportedMethods.isEmpty() == true) goto L19;
        if (TextUtils.isEmpty(r5.getMethod()) == true) goto L19;
        if (this.mSupportedMethods.contains(r5.getMethod()) == true) goto L19;
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "request method not support: " + r5.getMethod());
    L17:
        return false;
    L19:
        return isLifeTimeEffective();
    }

    public boolean isDelayActionEffective() {
        return isLifeTimeEffective();
    }

    private boolean isLifeTimeEffective() {
        long r0 = this.mLifetimeBegin;
        if (r0 != 0) goto L8;
        if (this.mLifetimeEnd != 0) goto L8;
        return true;
    L8:
        if (r0 != (-1)) goto L10;
    L20:
        return false;
    L10:
        if (this.mLifetimeEnd == (-1)) goto L20;
        long r2 = System.currentTimeMillis();
        if (r2 <= this.mLifetimeBegin) goto L18;
        if (r2 >= this.mLifetimeEnd) goto L18;
        return true;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "current time is out action lifecycle");
        goto L20
    }

    protected void loadMatchRules(JSONObject r5) {
        loadParamList(r5, "host_group", this.mHostGroup, false);
        loadParamList(r5, "equal_group", this.mEqualGroup, false);
        loadParamList(r5, "prefixes_group", this.mPrefixGroup, false);
        loadParamList(r5, "contain_group", this.mContainGroup, false);
        loadParamList(r5, "pattern_group", this.mPatternGroup, true);
        loadParamList(r5, "url_group", this.mFullUrlGroup, true);
        loadParamList(r5, "path_contain", this.mFullUrlGroupPathContain, false);
    }

    protected boolean isMatchRules(Uri r7) {
        if (this.mHostGroup.isEmpty() == false) goto L5;
    L4:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        String r1 = r7.getPath();
        if (TextUtils.isEmpty(r1) == false) goto L21;
        return false;
    L21:
        if (this.mEqualGroup.isEmpty() == true) goto L32;
        Iterator<String> r3 = this.mEqualGroup.iterator();
    L24:
        if (r3.hasNext() == false) goto L32;
        String r4 = r3.next();
        if (r1.equals(r4) == false) goto L24;
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "path equal hit: " + r4);
    L30:
        return true;
    L32:
        if (this.mPrefixGroup.isEmpty() == true) goto L43;
        Iterator<String> r5 = this.mPrefixGroup.iterator();
    L35:
        if (r5.hasNext() == false) goto L43;
        String r6 = r5.next();
        if (r1.startsWith(r6) == false) goto L35;
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "path prefix hit: " + r6);
    L41:
        return true;
    L43:
        if (this.mContainGroup.isEmpty() == true) goto L54;
        Iterator<String> r8 = this.mContainGroup.iterator();
    L46:
        if (r8.hasNext() == false) goto L54;
        String r9 = r8.next();
        if (r1.contains(r9) == false) goto L46;
        if (Logger.debug() == false) goto L52;
        Logger.d(TAG, "path contain hit: " + r9);
    L52:
        return true;
    L54:
        if (this.mPatternGroup.isEmpty() == true) goto L65;
        Iterator<String> r10 = this.mPatternGroup.iterator();
    L57:
        if (r10.hasNext() == false) goto L65;
        String r11 = r10.next();
        if (r1.matches(r11) == false) goto L57;
        if (Logger.debug() == false) goto L63;
        Logger.d(TAG, "path pattern hit: " + r11);
    L63:
        return true;
    L65:
        if (this.mFullUrlGroup.isEmpty() == false) goto L67;
    L86:
        return false;
    L67:
        if (this.mFullUrlGroupPathContain.isEmpty() == true) goto L77;
        Iterator<String> r12 = this.mFullUrlGroupPathContain.iterator();
    L70:
        if (r12.hasNext() == false) goto L74;
        if (r1.contains(r12.next()) == false) goto L70;
        boolean r2 = true;
    L75:
        if (r2 == true) goto L77;
        return false;
    L74:
        r2 = false;
    L77:
        Iterator<String> r13 = this.mFullUrlGroup.iterator();
    L79:
        if (r13.hasNext() == false) goto L86;
        String r14 = r13.next();
        if (r7.toString().matches(r14) == false) goto L79;
        if (Logger.debug() == false) goto L85;
        Logger.d(TAG, "full url hit: " + r14);
    L85:
        return true;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "host group is not match");
    L16:
        return false;
    L5:
        Iterator<String> r15 = this.mHostGroup.iterator();
    L7:
        if (r15.hasNext() == false) goto L11;
        if (UrlUtils.matchPattern(r7.getHost(), r15.next()) == false) goto L7;
    L11:
        r0 = false;
        goto L12
    }

    private void loadParamList(JSONObject r2, String r3, List<String> r4, boolean r5) {
        JSONArray r1 = r2.optJSONArray(r3);
        if (r1 == null) goto L15;
        int r6 = 0;
    L6:
        if (r6 >= r1.length()) goto L21;
        String r7 = r1.optString(r6);
        if (TextUtils.isEmpty(r7) == true) goto L14;
        if (r5 == true) goto L11;
        r4.add(r7);
        goto L14
    L11:
        if (isPatternStringValid(r7) == false) goto L14;
        r4.add(r7);
    L14:
        r6 = r6 + 1;
        goto L6
    L21:
        return;
    }

    public static boolean isPatternStringValid(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return false;
    L9:
        Pattern.compile(r2);     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }
}
