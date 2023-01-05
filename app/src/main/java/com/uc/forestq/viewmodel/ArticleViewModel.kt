package com.uc.forestq.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.forestq.model.*
import com.uc.forestq.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: ArticleRepository): ViewModel() {

    //Article VM
    val _article: MutableLiveData<ArrayList<ArticleData>> by lazy{
        MutableLiveData<ArrayList<ArticleData>>()
    }

    val article: LiveData<ArrayList<ArticleData>> get() = _article

    fun getArticle() = viewModelScope.launch {
        repository.getArticleResults().let {
            response ->
                if (response.isSuccessful){
                    Log.e("Get Data","Success!")
                    _article.postValue(response.body()?.data as ArrayList<ArticleData>?)
                }else {
                    Log.e("Get Data","Failed!")
                }
        }
    }

    //Fauna VM
    val _fauna: MutableLiveData<ArrayList<FaunaData>> by lazy{
        MutableLiveData<ArrayList<FaunaData>>()
    }

    val fauna: LiveData<ArrayList<FaunaData>> get() = _fauna

    fun getFauna() = viewModelScope.launch {
        repository.getFaunaResults().let { response ->
            if (response.isSuccessful){
                Log.e("Get Data","Success!")
                _fauna.postValue(response.body()?.data as ArrayList<FaunaData>?)
            }else {
                Log.e("Get Data","Failed!")
            }
        }
    }

    //Flora VM
    val _flora: MutableLiveData<ArrayList<FloraData>> by lazy{
        MutableLiveData<ArrayList<FloraData>>()
    }

    val flora: LiveData<ArrayList<FloraData>> get() = _flora

    fun getFlora() = viewModelScope.launch {
        repository.getFloraResults().let { response ->
            if (response.isSuccessful){
                Log.e("Get Data","Success!")
                _flora.postValue(response.body()?.data as ArrayList<FloraData>?)
            }else {
                Log.e("Get Data","Failed!")
            }
        }
    }

    //Get Fauna Details

    val _faunaD: MutableLiveData<FaunaData> by lazy{
        MutableLiveData<FaunaData>()
    }

    val faunaD: LiveData<FaunaData>get() = _faunaD

    fun getDetailFauna(faunaId: Int) = viewModelScope.launch {
        repository.getFaunaDetail().let { response ->
            if (response.isSuccessful){
                Log.e("Get Data","Success!")
                _faunaD.postValue(response.body() as FaunaData)
            }else {
                Log.e("Get Data","Failed!")
            }
        }
    }

    //Get Flora Details

    val _floraD: MutableLiveData<FloraData> by lazy{
        MutableLiveData<FloraData>()
    }

    val floraD: LiveData<FloraData>get() = _floraD

    fun getDetailFlora(floraId: Int) = viewModelScope.launch {
        repository.getFloraDetail().let { response ->
            if (response.isSuccessful){
                Log.e("Get Data","Success!")
                _floraD.postValue(response.body() as FloraData)
            }else {
                Log.e("Get Data","Failed!")
            }
        }
    }

    //Get Article Details

    val _articleD: MutableLiveData<ArticleData> by lazy{
        MutableLiveData<ArticleData>()
    }

    val articleD: LiveData<ArticleData>get() = _articleD

    fun getDetailArticle(articleId: Int) = viewModelScope.launch {
        repository.getArticleDetail().let { response ->
            if (response.isSuccessful){
                Log.e("Get Data","Success!")
                _articleD.postValue(response.body() as ArticleData)
            }else {
                Log.e("Get Data","Failed!")
            }
        }
    }

}