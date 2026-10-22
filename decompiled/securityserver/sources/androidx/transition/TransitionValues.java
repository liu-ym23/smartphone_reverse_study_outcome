package androidx.transition;

import a.a;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TransitionValues {
    final ArrayList<Transition> mTargetedTransitions;
    public final Map<String, Object> values;
    public View view;

    @Deprecated
    public TransitionValues() {
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof TransitionValues) == false) goto L10;
        TransitionValues r4 = (TransitionValues) r3;
        if (this.view == r4.view) goto L7;
        return false;
    L7:
        if (this.values.equals(r4.values) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        int r0 = this.view.hashCode() * 31;
        return this.values.hashCode() + r0;
    }

    public String toString() {
        StringBuilder r0 = a.t("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        r0.append(this.view);
        r0.append("\n");
        String r1 = a.j(r0.toString(), "    values:");
        Iterator<String> r2 = this.values.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = r2.next();
        r1 = r1 + "    " + r3 + ": " + this.values.get(r3) + "\n";
        goto L4
    L6:
        return r1;
    }

    public TransitionValues(@NonNull View r2) {
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
        this.view = r2;
    }
}
