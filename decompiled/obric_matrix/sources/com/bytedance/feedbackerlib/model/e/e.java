package com.bytedance.feedbackerlib.model.e;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("username")
    public final String f4622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c(NotificationCompat.CATEGORY_EMAIL)
    public final String f4623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("avatar_url")
    public final String f4624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("employee_id")
    public final int f4625d;

    @NonNull
    public String toString() {
        return "username: " + this.f4622a + ", useremail: " + this.f4623b + ", useravatarurl: " + this.f4624c + ", employeeId: " + this.f4625d;
    }
}
