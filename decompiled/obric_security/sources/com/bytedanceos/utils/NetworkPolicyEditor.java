package com.bytedanceos.utils;

import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkTemplate;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import android.text.format.Time;
import com.android.internal.util.Preconditions;
import com.google.android.collect.Lists;
import com.google.android.collect.Sets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkPolicyEditor {
    public static final boolean ENABLE_SPLIT_POLICIES = false;
    private ArrayList<NetworkPolicy> mPolicies;
    private NetworkPolicyManager mPolicyManager;

    @Deprecated
    private boolean setMobilePolicySplitInternal(String subscriberId, boolean split) {
        return false;
    }

    @Deprecated
    public boolean isMobilePolicySplit(String subscriberId) {
        return false;
    }

    public NetworkPolicyEditor(NetworkPolicyManager policyManager) {
        this.mPolicies = Lists.newArrayList();
        this.mPolicyManager = (NetworkPolicyManager) Preconditions.checkNotNull(policyManager);
    }

    public void read() {
        NetworkPolicy[] r0 = this.mPolicyManager.getNetworkPolicies();
        this.mPolicies.clear();
        int r1 = r0.length;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L12;
        NetworkPolicy r4 = r0[r2];
        if (r4.limitBytes >= (-1)) goto L8;
        r4.limitBytes = -1;
        r3 = true;
    L8:
        if (r4.warningBytes >= (-1)) goto L10;
        r4.warningBytes = -1;
        r3 = true;
    L10:
        this.mPolicies.add(r4);
        r2 = r2 + 1;
        goto L3
    L12:
        if ((forceMobilePolicyCombined() | r3) == false) goto L18;
        writeAsync();
        return;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedanceos.utils.NetworkPolicyEditor$1] */
    public void writeAsync() {
        ArrayList<NetworkPolicy> r0 = this.mPolicies;
        final NetworkPolicy[] r1 = (NetworkPolicy[]) r0.toArray(new NetworkPolicy[r0.size()]);
        new AnonymousClass1(this, r1).execute(new Void[0]);
    }

    public void write(NetworkPolicy[] policies) {
        this.mPolicyManager.setNetworkPolicies(policies);
    }

    public boolean hasLimitedPolicy(NetworkTemplate template) {
        NetworkPolicy r2 = getPolicy(template);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.limitBytes == (-1)) goto L7;
        return true;
    }

    public NetworkPolicy getOrCreatePolicy(NetworkTemplate template) {
        NetworkPolicy r0 = getPolicy(template);
        if (r0 != null) goto L6;
        NetworkPolicy r1 = buildDefaultPolicy(template);
        this.mPolicies.add(r1);
        return r1;
    L6:
        return r0;
    }

    public NetworkPolicy getPolicy(NetworkTemplate template) {
        Iterator<NetworkPolicy> r2 = this.mPolicies.iterator();
    L4:
        if (r2.hasNext() == false) goto L5;
        NetworkPolicy r0 = r2.next();
        if (r0.template.equals(template) == false) goto L4;
        return r0;
    L5:
        return null;
    }

    public NetworkPolicy getPolicyMaybeUnquoted(NetworkTemplate template) {
        NetworkPolicy r0 = getPolicy(template);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getPolicy(buildUnquotedNetworkTemplate(template));
    }

    @Deprecated
    private static NetworkPolicy buildDefaultPolicy(NetworkTemplate template) {
        if (template.getMatchRule() != 4) goto L5;
        boolean r2 = false;
        int r5 = -1;
        String r6 = "UTC";
    L7:
        return new NetworkPolicy(template, r5, r6, -1, -1, -1, -1, r2, true);
    L5:
        Time r0 = new Time();
        r0.setToNow();
        int r1 = r0.monthDay;
        r2 = true;
        r6 = r0.timezone;
        r5 = r1;
        goto L7
    }

    public long getPolicyWarningBytes(NetworkTemplate template) {
        return getPolicy(template).warningBytes;
    }

    public void setPolicyWarningBytes(NetworkTemplate template, long warningBytes) {
        NetworkPolicy r1 = getOrCreatePolicy(template);
        r1.warningBytes = warningBytes;
        r1.inferred = false;
        r1.clearSnooze();
        writeAsync();
    }

    public long getPolicyLimitBytes(NetworkTemplate template) {
        return getPolicy(template).limitBytes;
    }

    public void setPolicyLimitBytes(NetworkTemplate template, long limitBytes) {
        NetworkPolicy r1 = getOrCreatePolicy(template);
        r1.limitBytes = limitBytes;
        r1.inferred = false;
        r1.clearSnooze();
        writeAsync();
    }

    public boolean getPolicyMetered(NetworkTemplate template) {
        NetworkPolicy r0 = getPolicy(template);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.metered;
    }

    public void setPolicyMetered(NetworkTemplate template, boolean metered) {
        NetworkPolicy r0 = getPolicy(template);
        boolean r1 = true;
        boolean r2 = false;
        if (metered == false) goto L10;
        if (r0 != null) goto L8;
        NetworkPolicy r5 = buildDefaultPolicy(template);
        r5.metered = true;
        r5.inferred = false;
        this.mPolicies.add(r5);
    L6:
        r2 = true;
    L14:
        NetworkPolicy r4 = getPolicy(buildUnquotedNetworkTemplate(template));
        if (r4 == null) goto L17;
        this.mPolicies.remove(r4);
    L18:
        if (r1 == false) goto L21;
        writeAsync();
        return;
    L21:
        return;
    L17:
        r1 = r2;
        goto L18
    L8:
        if (r0.metered == true) goto L14;
        r0.metered = true;
        r0.inferred = false;
        goto L6
    L10:
        if (r0 == null) goto L14;
        if (r0.metered == false) goto L14;
        r0.metered = false;
        r0.inferred = false;
        goto L6
    }

    private boolean forceMobilePolicyCombined() {
        HashSet r0 = Sets.newHashSet();
        Iterator<NetworkPolicy> r1 = this.mPolicies.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().template.getSubscriberId());
        goto L4
    L6:
        Iterator r2 = r0.iterator();
        boolean r3 = false;
    L8:
        if (r2.hasNext() == false) goto L10;
        r3 = r3 | setMobilePolicySplitInternal((String) r2.next(), false);
        goto L8
    L10:
        return r3;
    }

    @Deprecated
    public void setMobilePolicySplit(String subscriberId, boolean split) {
        if (setMobilePolicySplitInternal(subscriberId, split) == false) goto L6;
        writeAsync();
        return;
    }

    private static NetworkTemplate buildUnquotedNetworkTemplate(NetworkTemplate template) {
        if (template != null) goto L5;
        return null;
    L5:
        String r1 = template.getNetworkId();
        String r2 = WifiInfo.removeDoubleQuotes(r1);
        if (TextUtils.equals(r2, r1) == false) goto L8;
        return null;
    L8:
        return new NetworkTemplate(template.getMatchRule(), template.getSubscriberId(), r2);
    }

    public void addPolicy(NetworkPolicy policy) {
        this.mPolicies.add(policy);
        writeAsync();
    }
}
