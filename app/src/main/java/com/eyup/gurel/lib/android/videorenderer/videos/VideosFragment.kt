package com.eyup.gurel.lib.android.videorenderer.videos

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.eyup.gurel.lib.adapter.monster.adapter.RecyclerAdapter
import com.eyup.gurel.lib.adapter.monster.adapter.RecyclerDataSource
import com.eyup.gurel.lib.android.base.components.BaseFragment
import com.eyup.gurel.lib.android.videorenderer.R
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.frament_videos.*
import javax.inject.Inject


class VideosFragment:BaseFragment() {
    @Inject lateinit var viewModel: VideosViewModel
    @Inject lateinit var presenter: VideosPresenter
    @Inject lateinit var  dataSource: RecyclerDataSource

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        video_list.layoutManager = LinearLayoutManager(view.context)
        video_list.adapter = RecyclerAdapter(dataSource)
    }
    override fun layoutRes(): Int {
        return R.layout.frament_videos
    }

    override fun subscriptions(): Array<Disposable> {
        return emptyArray()
    }
}