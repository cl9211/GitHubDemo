package com.bennyhuo.github.network.services

import com.bennyhuo.github.network.entities.Issue
import com.bennyhuo.github.network.retrofit
import retrofit2.adapter.rxjava.GitHubPaging
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by CHULEI on 2019/11/19.
 */
object IssueService : IssueApi by retrofit.create(IssueApi::class.java)

interface IssueApi {
    @GET("/issues?filter=all&state=all")
    fun listIssuesOfAuthenticatedUser(@Query("page") page: Int = 1,
                                      @Query("per_page") per_page: Int = 20): Observable<GitHubPaging<Issue>>

}