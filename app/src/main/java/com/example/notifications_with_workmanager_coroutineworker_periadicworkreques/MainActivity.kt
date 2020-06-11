package com.example.notifications_with_workmanager_coroutineworker_periadicworkreques

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var work1: PeriodicWorkRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStop() {
        super.onStop()
        work1 = PeriodicWorkRequest.Builder(MyWork::class.java, 10, TimeUnit.MILLISECONDS).build()
        WorkManager.getInstance(this).enqueue(work1)
    }

    override fun onPause() {
        super.onPause()
        work1 = PeriodicWorkRequest.Builder(MyWork::class.java, 10, TimeUnit.MILLISECONDS).build()
        WorkManager.getInstance(this).enqueue(work1)
    }
}
