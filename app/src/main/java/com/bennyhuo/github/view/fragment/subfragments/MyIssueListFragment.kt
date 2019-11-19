package com.bennyhuo.github.view.fragment.subfragments

import com.bennyhuo.github.network.entities.Issue
import com.bennyhuo.github.presenter.MyIssuePresenter
import com.bennyhuo.github.view.common.CommonListAdapter
import com.bennyhuo.github.view.common.CommonListFragment

/**
 * Created by CHULEI on 2019/11/19.
 */
class MyIssueListFragment : CommonListFragment<Issue, MyIssuePresenter>(){
    companion object {
        const val REPOSITORY_NAME = "repository_name"
        const val OWNER_LOGIN = "owner_login"
    }


    override val adapter: CommonListAdapter<Issue> = IssueListAdapter()
}