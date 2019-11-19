package com.bennyhuo.github.presenter

import com.bennyhuo.github.model.issue.MyIssuePage
import com.bennyhuo.github.model.page.ListPage
import com.bennyhuo.github.network.entities.Issue
import com.bennyhuo.github.view.common.CommonListPresenter
import com.bennyhuo.github.view.fragment.subfragments.MyIssueListFragment

/**
 * Created by CHULEI on 2019/11/19.
 */
class MyIssuePresenter : CommonListPresenter<Issue, MyIssueListFragment>() {
    override val listPage: ListPage<Issue> = MyIssuePage()

}