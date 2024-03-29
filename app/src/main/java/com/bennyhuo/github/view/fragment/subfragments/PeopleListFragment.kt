package com.bennyhuo.github.view.fragment.subfragments

import com.bennyhuo.github.network.entities.User
import com.bennyhuo.github.presenter.PeopleListPresenter
import com.bennyhuo.github.view.common.CommonListFragment
import com.bennyhuo.tieguanyin.annotations.FragmentBuilder
import com.bennyhuo.tieguanyin.annotations.Optional
import com.bennyhuo.tieguanyin.annotations.Required

/**
 * Created by CHULEI on 2019/11/18.
 */
@FragmentBuilder
class PeopleListFragment : CommonListFragment<User, PeopleListPresenter>() {
    @Optional
    lateinit var login: String

    @Required
    lateinit var type: String

    override val adapter = PeopleListAdapter()
}