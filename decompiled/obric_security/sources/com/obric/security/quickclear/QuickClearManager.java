package com.obric.security.quickclear;

import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.securitycenter.task.MemoryWorkTask;
import com.bytedanceos.securitycenter.task.TrashFileWorkTask;
import com.bytedanceos.securitycenter.task.WorkGroup;
import com.bytedanceos.securitycenter.task.WorkTask;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuickClearManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\nJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/security/quickclear/QuickClearManager;", "", "()V", "callBack", "Lcom/obric/security/quickclear/QuickClearCallBack;", "currentScore", "", "init", "", "memoryWorkTask", "Lcom/bytedanceos/securitycenter/task/MemoryWorkTask;", "score", "Lcom/obric/security/quickclear/Score;", "getScore", "()Lcom/obric/security/quickclear/Score;", "setScore", "(Lcom/obric/security/quickclear/Score;)V", "totalScore", "trashFileWorkTask", "Lcom/bytedanceos/securitycenter/task/TrashFileWorkTask;", "workGroup", "Lcom/bytedanceos/securitycenter/task/WorkGroup;", "getMemoryWorkTask", "getTrashFileWorkTask", "initWork", "", "onAllTaskFinish", "onCleanFinish", "onDestroy", "pause", "resume", "startWork", "type", "Lcom/bytedanceos/securitycenter/task/WorkTask$WorkType;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class QuickClearManager {
    private QuickClearCallBack callBack;
    private int currentScore;
    private boolean init;
    private MemoryWorkTask memoryWorkTask;
    private Score score;
    private int totalScore;
    private TrashFileWorkTask trashFileWorkTask;
    private WorkGroup workGroup;

    public QuickClearManager() {
        this.totalScore = 100;
        this.currentScore = 100;
    }

    public static final /* synthetic */ void access$onAllTaskFinish(QuickClearManager r0) {
        r0.onAllTaskFinish();
    }

    public static final /* synthetic */ void access$onCleanFinish(QuickClearManager r0) {
        r0.onCleanFinish();
    }

    public final Score getScore() {
        return this.score;
    }

    public final void setScore(Score r1) {
        this.score = r1;
    }

    public final void initWork(QuickClearCallBack r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        if (this.init == true) goto L5;
    L7:
        this.callBack = r2;
        this.score = new Score();
        this.workGroup = new WorkGroup();
        TrashFileWorkTask r3 = new TrashFileWorkTask();
        this.trashFileWorkTask = r3;
        WorkGroup r0 = this.workGroup;
        if (r0 == null) goto L10;
        r0.addTask(r3);
    L10:
        MemoryWorkTask r4 = new MemoryWorkTask();
        this.memoryWorkTask = r4;
        WorkGroup r1 = this.workGroup;
        if (r1 == null) goto L13;
        r1.addTask(r4);
    L13:
        WorkGroup r5 = this.workGroup;
        if (r5 == null) goto L16;
        r5.setWorkStatusListener(new AnonymousClass1(this));
    L16:
        WorkGroup r6 = this.workGroup;
        if (r6 == null) goto L19;
        r6.onCreate(SecurityCenterApplication.getContext());
    L19:
        this.init = true;
        return;
    L5:
        if (this.workGroup == null) goto L7;
    }

    public final TrashFileWorkTask getTrashFileWorkTask() {
        return this.trashFileWorkTask;
    }

    public final MemoryWorkTask getMemoryWorkTask() {
        return this.memoryWorkTask;
    }

    public final void resume() {
        WorkGroup r0 = this.workGroup;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final void pause() {
        WorkGroup r0 = this.workGroup;
        if (r0 == null) goto L6;
        r0.onPause();
        return;
    }

    public final void startWork(WorkTask.WorkType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        WorkGroup r0 = this.workGroup;
        if (r0 == null) goto L5;
        r0.startWork(r2);
    L5:
        resume();
    }

    public final void onDestroy() {
        this.init = false;
        WorkGroup r1 = this.workGroup;
        if (r1 == null) goto L6;
        r1.onDestory(SecurityCenterApplication.getContext());
        return;
    }

    private final void onAllTaskFinish() {
        Score r0 = this.score;
        Integer r1 = null;
        if (r0 == null) goto L9;
        TrashFileWorkTask r2 = this.trashFileWorkTask;
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.getScore());
    L8:
        r0.trashScore = r3.intValue();
        goto L9
    L7:
        r3 = null;
    L9:
        Score r4 = this.score;
        if (r4 == null) goto L16;
        MemoryWorkTask r5 = this.memoryWorkTask;
        if (r5 == null) goto L14;
        Integer r6 = Integer.valueOf(r5.getScore());
    L15:
        r4.memoryScore = r6.intValue();
        goto L16
    L14:
        r6 = null;
    L16:
        Score r7 = this.score;
        if (r7 == null) goto L19;
        r7.totalScore = this.totalScore;
    L19:
        int r8 = this.totalScore;
        Score r9 = this.score;
        if (r9 == null) goto L22;
        int r10 = r9.getCleanScore();
    L23:
        this.currentScore = r8 - r10;
        StringBuilder r11 = new StringBuilder("trashScore :");
        Score r12 = this.score;
        if (r12 == null) goto L26;
        Integer r13 = Integer.valueOf(r12.trashScore);
    L27:
        StringBuilder r14 = r11.append(r13).append(", memoryScore:");
        Score r15 = this.score;
        if (r15 == null) goto L30;
        r1 = Integer.valueOf(r15.memoryScore);
    L30:
        OLog.d("heyan", r14.append(r1).append(",currentScore:").append(this.currentScore).toString());
        Score r16 = this.score;
        if (r16 == null) goto L33;
        r16.getCleanScore();
    L33:
        QuickClearCallBack r17 = this.callBack;
        if (r17 == null) goto L37;
        r17.allScanTaskFinish(this.score);
        return;
    L37:
        return;
    L26:
        r13 = null;
        goto L27
    L22:
        r10 = 0;
        goto L23
    }

    private final void onCleanFinish() {
        int r0 = this.currentScore;
        Score r1 = this.score;
        if (r1 == null) goto L5;
        int r2 = r1.getCleanScore();
    L6:
        this.currentScore = r0 + r2;
        QuickClearCallBack r3 = this.callBack;
        if (r3 == null) goto L10;
        r3.allClearTaskFinish(this.score);
        return;
    L10:
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
