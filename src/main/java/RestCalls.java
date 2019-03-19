import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface RestCalls {

    @GET("todos")
    Call<List<JsonPlaceHolderDTO>> getTodos();

    @GET("todos/{id}")
    Call<JsonPlaceHolderDTO> getTodoByID(@Path("id") int id);

    @GET("/")
    Call<ResponseBody> dummyUnsafeApiCallTest();

    @POST("posts")
    Call<ResponseBody> postSomeData(@Body DataToBePostedDTO data);

}
