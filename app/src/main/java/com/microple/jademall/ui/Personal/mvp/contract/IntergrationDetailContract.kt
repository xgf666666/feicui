package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.IntergrationDetail
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface IntergrationDetailContract {
    interface View :BaseMvpView{
        fun getDetail(detail:IntergrationDetail)

    }
    interface Model{
        fun getDetail(token:String,up_id:String): Observable<BaseResponseEntity<IntergrationDetail>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getDetail(token:String,up_id:String)
    }
}