package com.bennyhuo.github.view.fragment.subfragments

import com.bennyhuo.github.network.entities.Repository
import com.bennyhuo.github.network.entities.User
import com.bennyhuo.github.presenter.RepoListPresenter
import com.bennyhuo.github.view.common.CommonListFragment
import com.bennyhuo.tieguanyin.annotations.FragmentBuilder
import com.bennyhuo.tieguanyin.annotations.Optional

/**
 * Created by CHULEI on 2019/11/15.
 */
@FragmentBuilder
class RepoListFragment : CommonListFragment<Repository, RepoListPresenter>() {

    @Optional
    var user: User? = null

    override val adapter = RepoListAdapter()
}