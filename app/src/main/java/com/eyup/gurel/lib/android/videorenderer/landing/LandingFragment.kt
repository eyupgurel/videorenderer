package com.eyup.gurel.lib.android.videorenderer.landing

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.eyup.gurel.lib.adapter.monster.adapter.RecyclerAdapter
import com.eyup.gurel.lib.adapter.monster.adapter.RecyclerDataSource
import com.eyup.gurel.lib.android.base.components.BaseFragment
import com.eyup.gurel.lib.android.videorenderer.R
import com.eyup.gurel.lib.dagger2.di.ScreenScope
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_landing.*
import javax.inject.Inject

@ScreenScope
class LandingFragment @Inject constructor(): BaseFragment() {
    @Inject lateinit var presenter: Landing
    @Inject lateinit var viewModel: LandingViewModel
    @Inject lateinit var dataSource: RecyclerDataSource

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tradeItemList.layoutManager =  LinearLayoutManager(view.context)
        tradeItemList.adapter = RecyclerAdapter(dataSource)
        tradeItemList.itemAnimator = null
    }

    override fun layoutRes(): Int {
       return R.layout.fragment_landing
    }

    override fun subscriptions(): Array<Disposable> {
        return emptyArray()
    }
}