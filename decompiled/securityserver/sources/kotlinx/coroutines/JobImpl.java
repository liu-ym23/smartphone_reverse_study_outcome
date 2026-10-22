package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class JobImpl extends JobSupport implements CompletableJob {
    public final boolean c;

    public JobImpl(Job r5) {
        boolean r0 = true;
        super(true);
        f0(r5);
        ChildHandle r6 = b0();
        if ((r6 instanceof ChildHandleNode) == true) goto L5;
        r6 = null;
    L5:
        ChildHandleNode r7 = (ChildHandleNode) r6;
        if (r7 == null) goto L20;
        JobSupport r8 = (JobSupport) r7.f;
        if (r8 == null) goto L20;
    L10:
        if (r8.Y() == true) goto L21;
        ChildHandle r9 = r8.b0();
        if ((r9 instanceof ChildHandleNode) == true) goto L15;
        r9 = null;
    L15:
        ChildHandleNode r10 = (ChildHandleNode) r9;
        if (r10 == null) goto L20;
        r8 = (JobSupport) r10.f;
        if (r8 == null) goto L20;
    L21:
        this.c = r0;
        return;
    L20:
        r0 = false;
        goto L21
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean Y() {
        return this.c;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean Z() {
        return true;
    }
}
