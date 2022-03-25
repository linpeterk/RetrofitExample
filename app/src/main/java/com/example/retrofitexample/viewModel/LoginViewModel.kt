package com.example.retrofitexample.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitexample.network.Login
import com.example.retrofitexample.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val loginRequestLiveData = MutableLiveData<Boolean>()

    fun login(email:String, password:String){

        viewModelScope.launch (Dispatchers.IO){

            try{
                val authService = RetrofitHelper.getAuthService()

                val responseService = authService.getLogin(Login(email = email, password= password))

                if(responseService.isSuccessful){

                    responseService.body()?.let { token->

                        Log.d("logging success", "Response token $token")

                    }

                }
                else{
                    responseService.errorBody()?.let{ error->

                        Log.d("logging error", "Response token $error")
                        error.close()

                    }
                }
                loginRequestLiveData.postValue(responseService.isSuccessful)
            }
            catch(e:Exception){
            Log.d("Network ex Logging", "Exceptions in Networking $e")
            }

        }
    }

}