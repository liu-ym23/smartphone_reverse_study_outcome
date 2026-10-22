package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents;
    private final Context mSourceContext;

    static class Api16Impl {
        private Api16Impl() {
        }

        static PendingIntent getActivities(Context r0, int r1, Intent[] r2, int r3, Bundle r4) {
            return PendingIntent.getActivities(r0, r1, r2, r3, r4);
        }
    }

    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    private TaskStackBuilder(Context r2) {
        this.mIntents = new ArrayList();
        this.mSourceContext = r2;
    }

    public static TaskStackBuilder create(Context r1) {
        return new TaskStackBuilder(r1);
    }

    @Deprecated
    public static TaskStackBuilder from(Context r0) {
        return create(r0);
    }

    public TaskStackBuilder addNextIntent(Intent r2) {
        this.mIntents.add(r2);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent r2) {
        ComponentName r0 = r2.getComponent();
        if (r0 != null) goto L5;
        r0 = r2.resolveActivity(this.mSourceContext.getPackageManager());
    L5:
        if (r0 == null) goto L7;
        addParentStack(r0);
    L7:
        addNextIntent(r2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TaskStackBuilder addParentStack(Activity r2) {
        if ((r2 instanceof SupportParentable) == false) goto L5;
        Intent r0 = ((SupportParentable) r2).getSupportParentActivityIntent();
    L6:
        if (r0 != null) goto L8;
        r0 = NavUtils.getParentActivityIntent(r2);
    L8:
        if (r0 == null) goto L13;
        ComponentName r3 = r0.getComponent();
        if (r3 != null) goto L12;
        r3 = r0.resolveActivity(this.mSourceContext.getPackageManager());
    L12:
        addParentStack(r3);
        addNextIntent(r0);
    L13:
        return this;
    L5:
        r0 = null;
        goto L6
    }

    public TaskStackBuilder addParentStack(Class<?> r3) {
        return addParentStack(new ComponentName(this.mSourceContext, r3));
    }

    public TaskStackBuilder addParentStack(ComponentName r3) {
        int r0 = this.mIntents.size();
        Intent r4 = NavUtils.getParentActivityIntent(this.mSourceContext, r3);     // Catch: PackageManager.NameNotFoundException -> L8
    L4:
        if (r4 == null) goto L7;
        this.mIntents.add(r0, r4);     // Catch: PackageManager.NameNotFoundException -> L8
        r4 = NavUtils.getParentActivityIntent(this.mSourceContext, r4.getComponent());     // Catch: PackageManager.NameNotFoundException -> L8
        goto L4
    L7:
        return this;
    L8:
        e = move-exception;
        Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(e);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    @Deprecated
    public Intent getIntent(int r1) {
        return editIntentAt(r1);
    }

    public Intent editIntentAt(int r1) {
        return this.mIntents.get(r1);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(Bundle r5) {
        if (this.mIntents.isEmpty() == true) goto L9;
        Intent[] r0 = (Intent[]) this.mIntents.toArray(new Intent[0]);
        r0[0] = new Intent(r0[0]).addFlags(268484608);
        if (ContextCompat.startActivities(this.mSourceContext, r0, r5) == true) goto L10;
        Intent r6 = new Intent(r0[r0.length - 1]);
        r6.addFlags(268435456);
        this.mSourceContext.startActivity(r6);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    public PendingIntent getPendingIntent(int r2, int r3) {
        return getPendingIntent(r2, r3, null);
    }

    public PendingIntent getPendingIntent(int r5, int r6, Bundle r7) {
        if (this.mIntents.isEmpty() == true) goto L7;
        Intent[] r0 = (Intent[]) this.mIntents.toArray(new Intent[0]);
        r0[0] = new Intent(r0[0]).addFlags(268484608);
        return Api16Impl.getActivities(this.mSourceContext, r5, r0, r6, r7);
    L7:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    public Intent[] getIntents() {
        int r0 = this.mIntents.size();
        Intent[] r1 = new Intent[r0];
        if (r0 != 0) goto L5;
        return r1;
    L5:
        r1[0] = new Intent(this.mIntents.get(0)).addFlags(268484608);
        int r2 = 1;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2] = new Intent(this.mIntents.get(r2));
        r2 = r2 + 1;
        goto L6
    L8:
        return r1;
    }
}
