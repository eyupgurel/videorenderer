package com.eyup.gurel.lib.android.videorenderer.home

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.eyup.gurel.lib.android.base.components.BaseNavActivity
import com.eyup.gurel.lib.android.base.components.SimpleBaseNavActivity
import com.eyup.gurel.lib.android.videorenderer.R

class MainNavActivity : SimpleBaseNavActivity() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(layoutRes())
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
        activityStateHandler.navController = navHostFragment.navController
    }

    override fun layoutRes(): Int {
        return R.layout.activity_main_nav
    }

}