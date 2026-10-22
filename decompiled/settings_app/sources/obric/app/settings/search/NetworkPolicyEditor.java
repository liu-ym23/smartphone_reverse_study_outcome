package obric.app.settings.search;

import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkTemplate;
import android.text.format.Time;
import com.android.internal.util.Preconditions;
import com.google.android.collect.Lists;
import com.google.android.collect.Sets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class NetworkPolicyEditor {
    public static final boolean ENABLE_SPLIT_POLICIES = false;
    private ArrayList<NetworkPolicy> mPolicies;
    private NetworkPolicyManager mPolicyManager;

    private static NetworkTemplate buildUnquotedNetworkTemplate(NetworkTemplate r0) {
        return null;
    }

    @Deprecated
    private boolean setMobilePolicySplitInternal(String r1, boolean r2) {
        return false;
    }

    @Deprecated
    public boolean isMobilePolicySplit(String r1) {
        return false;
    }

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

    /* JADX WARN: Type inference failed for: r1v2, types: [obric.app.settings.search.NetworkPolicyEditor$1] */
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
        if (r2.hasNext() == false) goto L5;
        NetworkPolicy r0 = r2.next();
        if (r0.template.equals(r3) == false) goto L4;
        return r0;
    L5:
        return null;
    }

    public NetworkPolicy getPolicyMaybeUnquoted(NetworkTemplate r2) {
        NetworkPolicy r0 = getPolicy(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getPolicy(buildUnquotedNetworkTemplate(r2));
    }

    @Deprecated
    private static NetworkPolicy buildDefaultPolicy(NetworkTemplate r17) {
        if (r17.getMatchRule() != 4) goto L5;
        boolean r2 = false;
        int r5 = -1;
        String r6 = "UTC";
    L7:
        return new NetworkPolicy(r17, r5, r6, -1, -1, -1, -1, r2, true);
    L5:
        Time r0 = new Time();
        r0.setToNow();
        int r1 = r0.monthDay;
        r2 = true;
        r6 = r0.timezone;
        r5 = r1;
        goto L7
    }

    public long getPolicyWarningBytes(NetworkTemplate r1) {
        return getPolicy(r1).warningBytes;
    }

    public void setPolicyWarningBytes(NetworkTemplate r1, long r2) {
        NetworkPolicy r3 = getOrCreatePolicy(r1);
        r3.warningBytes = r2;
        r3.inferred = false;
        r3.clearSnooze();
        writeAsync();
    }

    public long getPolicyLimitBytes(NetworkTemplate r1) {
        return getPolicy(r1).limitBytes;
    }

    public void setPolicyLimitBytes(NetworkTemplate r1, long r2) {
        NetworkPolicy r3 = getOrCreatePolicy(r1);
        r3.limitBytes = r2;
        r3.inferred = false;
        r3.clearSnooze();
        writeAsync();
    }

    public boolean getPolicyMetered(NetworkTemplate r1) {
        NetworkPolicy r0 = getPolicy(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.metered;
    }

    public void setPolicyMetered(NetworkTemplate r4, boolean r5) {
        NetworkPolicy r0 = getPolicy(r4);
        boolean r1 = true;
        boolean r2 = false;
        if (r5 == false) goto L10;
        if (r0 != null) goto L8;
        NetworkPolicy r6 = buildDefaultPolicy(r4);
        r6.metered = true;
        r6.inferred = false;
        this.mPolicies.add(r6);
    L6:
        r2 = true;
    L14:
        NetworkPolicy r7 = getPolicy(buildUnquotedNetworkTemplate(r4));
        if (r7 == null) goto L17;
        this.mPolicies.remove(r7);
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
    public void setMobilePolicySplit(String r1, boolean r2) {
        if (setMobilePolicySplitInternal(r1, r2) == false) goto L6;
        writeAsync();
        return;
    }

    public void addPolicy(NetworkPolicy r2) {
        this.mPolicies.add(r2);
        writeAsync();
    }
}
