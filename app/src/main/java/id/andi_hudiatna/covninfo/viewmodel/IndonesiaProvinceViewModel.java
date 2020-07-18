
package id.andi_hudiatna.covninfo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import id.andi_hudiatna.covninfo.model.IndonesiaProvinsiModel;
import id.andi_hudiatna.covninfo.service.ApiEndpoint;
import id.andi_hudiatna.covninfo.service.RetrofitServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IndonesiaProvinceViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<IndonesiaProvinsiModel>> liveData = new MutableLiveData<>();

    public void setProvinceData() {
        Retrofit retrofit = RetrofitServiceApi.getRetrofitServiceIndo();
        ApiEndpoint endpoint = retrofit.create(ApiEndpoint.class);
        Call<List<IndonesiaProvinsiModel>> call = endpoint.getProvince();
        call.enqueue(new Callback<List<IndonesiaProvinsiModel>>() {
            @Override
            public void onResponse(Call<List<IndonesiaProvinsiModel>> call, Response<List<IndonesiaProvinsiModel>> response) {
                liveData.setValue((ArrayList<IndonesiaProvinsiModel>) response.body());
            }

            @Override
            public void onFailure(Call<List<IndonesiaProvinsiModel>> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<IndonesiaProvinsiModel>> getProvinceData() {
        return liveData;
    }
}
