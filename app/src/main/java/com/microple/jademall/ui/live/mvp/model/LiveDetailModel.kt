package com.microple.jademall.ui.live.mvp.model

import com.microple.jademall.bean.LiveDetail
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.live.mvp.contract.LiveDetailContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LiveDetailModel: LiveDetailContract.Model {
    override fun liveYuyue(token: String, live_id: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().liveYuyue(token,live_id)

    override fun getDetail(token: String, live_id: String): Observable<BaseResponseEntity<LiveDetail>> =AppApi.Api().liveDetail(token,live_id)
}