package com.android.settingslib;

import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkTemplate;
import android.util.RecurrenceRule;
import com.android.internal.util.Preconditions;
import com.google.android.collect.Lists;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class NetworkPolicyEditor {
    public static final boolean ENABLE_SPLIT_POLICIES = false;
    private ArrayList<NetworkPolicy> mPolicies;
    private NetworkPolicyManager mPolicyManager;

    public NetworkPolicyEditor(NetworkPolicyManager r2) {
        this.mPolicies = Lists.newArrayList();
        this.mPolicyManager = (NetworkPolicyManager) Preconditions.checkNotNull(r2);
    }

    public void read() {
        NetworkPolicy[] r0 = this.mPolicyManager.getNetworkPolicies();
        this.mPolicies.clear();
        int r1 = r0.length;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L11;
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
    L11:
        if (r3 == false) goto L17;
        writeAsync();
        return;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.android.settingslib.NetworkPolicyEditor$1] */
    public void writeAsync() {
        ArrayList<NetworkPolicy> r0 = this.mPolicies;
        final NetworkPolicy[] r1 = (NetworkPolicy[]) r0.toArray(new NetworkPolicy[r0.size()]);
        new AnonymousClass1(this, r1).execute(new Void[0]);
    }

    public void write(NetworkPolicy[] r1) {
        this.mPolicyManager.setNetworkPolicies(r1);
    }

    public boolean hasLimitedPolicy(NetworkTemplate r3) {
        NetworkPolicy r2 = getPolicy(r3);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.limitBytes == (-1)) goto L7;
        return true;
    }

    public NetworkPolicy getOrCreatePolicy(NetworkTemplate r2) {
        NetworkPolicy r0 = getPolicy(r2);
        if (r0 != null) goto L6;
        NetworkPolicy r1 = buildDefaultPolicy(r2);
        this.mPolicies.add(r1);
        return r1;
    L6:
        return r0;
    }

    public NetworkPolicy getPolicy(NetworkTemplate r3) {
        Iterator<NetworkPolicy> r2 = this.mPolicies.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        NetworkPolicy r0 = r2.next();
        if (r0.template.equals(r3) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    public NetworkPolicy getPolicyMaybeUnquoted(NetworkTemplate r2) {
        NetworkPolicy r0 = getPolicy(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getPolicy(r2);
    }

    @Deprecated
    private static NetworkPolicy buildDefaultPolicy(NetworkTemplate r15) {
        if (r15.getMatchRule() != 4) goto L5;
        RecurrenceRule r0 = RecurrenceRule.buildNever();
        boolean r1 = false;
    L7:
        return new NetworkPolicy(r15, r0, -1, -1, -1, -1, r1, true);
    L5:
        r0 = RecurrenceRule.buildRecurringMonthly(ZonedDateTime.now().getDayOfMonth(), ZoneId.systemDefault());
        r1 = true;
        goto L7
    }

    @Deprecated
    public int getPolicyCycleDay(NetworkTemplate r1) {
        NetworkPolicy r0 = getPolicy(r1);
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r0.cycleRule.isMonthly() == true) goto L7;
        return -1;
    L7:
        return r0.cycleRule.start.getDayOfMonth();
    }

    @Deprecated
    public void setPolicyCycleDay(NetworkTemplate r1, int r2, String r3) {
        NetworkPolicy r4 = getOrCreatePolicy(r1);
        r4.cycleRule = NetworkPolicy.buildRule(r2, ZoneId.of(r3));
        r4.inferred = false;
        r4.clearSnooze();
        writeAsync();
    }

    public long getPolicyWarningBytes(NetworkTemplate r1) {
        NetworkPolicy r0 = getPolicy(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.warningBytes;
    }

    private void setPolicyWarningBytesInner(NetworkTemplate r1, long r2) {
        NetworkPolicy r3 = getOrCreatePolicy(r1);
        r3.warningBytes = r2;
        r3.inferred = false;
        r3.clearSnooze();
        writeAsync();
    }

    public void setPolicyWarningBytes(NetworkTemplate r5, long r6) {
        long r0 = getPolicyLimitBytes(r5);
        if (r0 == (-1)) goto L6;
        r6 = Math.min(r6, r0);
    L6:
        setPolicyWarningBytesInner(r5, r6);
    }

    public long getPolicyLimitBytes(NetworkTemplate r1) {
        NetworkPolicy r0 = getPolicy(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.limitBytes;
    }

    public void setPolicyLimitBytes(NetworkTemplate r3, long r4) {
        if (getPolicyWarningBytes(r3) > r4) goto L5;
    L7:
        NetworkPolicy r5 = getOrCreatePolicy(r3);
        r5.limitBytes = r4;
        r5.inferred = false;
        r5.clearSnooze();
        writeAsync();
        return;
    L5:
        if (r4 == (-1)) goto L7;
        setPolicyWarningBytesInner(r3, r4);
        goto L7
    }
}
