package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import com.obric.capabilitykit.common.ErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class ExpandButton extends Preference {
    private long mId;

    ExpandButton(Context r1, List<Preference> r2, long r3) {
        super(r1);
        initLayout();
        setSummary(r2);
        this.mId = r3 + 1000000;
    }

    private void initLayout() {
        setLayoutResource(R.layout.expand_button);
        setIcon(R.drawable.ic_arrow_down_24dp);
        setTitle(R.string.expand_button_title);
        setOrder(ErrorCode.NOT_SUPPORTED);
    }

    private void setSummary(List<Preference> r8) {
        ArrayList r0 = new ArrayList();
        Iterator<Preference> r9 = r8.iterator();
        CharSequence r1 = null;
    L4:
        if (r9.hasNext() == false) goto L19;
        Preference r2 = r9.next();
        CharSequence r3 = r2.getTitle();
        boolean r4 = r2 instanceof PreferenceGroup;
        if (r4 == false) goto L11;
        if (TextUtils.isEmpty(r3) == true) goto L11;
        r0.add((PreferenceGroup) r2);
    L11:
        if (r0.contains(r2.getParent()) == true) goto L12;
        if (TextUtils.isEmpty(r3) == true) goto L4;
        if (r1 == null) goto L17;
        r1 = getContext().getString(R.string.summary_collapsed_preference_list, new Object[]{r1, r3});
        goto L4
    L17:
        r1 = r3;
        goto L4
    L12:
        if (r4 == false) goto L4;
        r0.add((PreferenceGroup) r2);
        goto L4
    L19:
        setSummary(r1);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        r1.setDividerAllowedAbove(false);
    }

    @Override // androidx.preference.Preference
    long getId() {
        return this.mId;
    }
}
