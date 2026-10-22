package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.io.IOUtils;

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

    public TransitionValues(View r2) {
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
        this.view = r2;
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
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String r0 = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + IOUtils.LINE_SEPARATOR_UNIX) + "    values:";
        Iterator<String> r2 = this.values.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = r2.next();
        r0 = r0 + "    " + r3 + ": " + this.values.get(r3) + IOUtils.LINE_SEPARATOR_UNIX;
        goto L4
    L6:
        return r0;
    }
}
