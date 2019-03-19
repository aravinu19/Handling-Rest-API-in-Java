import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;

public class RestHandler_Retrofit {

    public static String base_url = "https://jsonplaceholder.typicode.com/";

    public static void checkForResponse(){

        Retrofit retrofit = getRetrofitInstance();

        RestCalls callAPI = retrofit.create(RestCalls.class);

        Call<List<JsonPlaceHolderDTO>> APiExec = callAPI.getTodos();

        try {
            Response<List<JsonPlaceHolderDTO>> response = APiExec.execute();

            for (JsonPlaceHolderDTO item : response.body()){
                System.out.println(item.getId() + " " + item.getUserId() + " " + item.getTitle() + " " + item.isCompleted());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void CheckParamBasedCall(int id){

        Retrofit retrofit = getRetrofitInstance();

        RestCalls callApi = retrofit.create(RestCalls.class);
        Call<JsonPlaceHolderDTO> ApiExec = callApi.getTodoByID(id);

        try {
            Response<JsonPlaceHolderDTO> response = ApiExec.execute();
            JsonPlaceHolderDTO item = response.body();
            System.out.println(item.getId() + " " + item.getUserId() + " " + item.getTitle() + " " + item.isCompleted());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void testUnsafeApiCalls(){

        Retrofit retrofit = new Retrofit.Builder()
                .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
                .baseUrl("https://untrusted-root.badssl.com")
                .build();

        RestCalls callApi = retrofit.create(RestCalls.class);

        Call<ResponseBody> ApiExec = callApi.dummyUnsafeApiCallTest();

        try{

            Response<ResponseBody> response = ApiExec.execute();

            System.out.println(response.body().string());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void PostSomeDataToServer(int id, int userId, String title, String body){

        Retrofit retrofit = getRetrofitInstance();

        RestCalls CallApi = retrofit.create(RestCalls.class);

        Call<ResponseBody> ApiExec = CallApi.postSomeData(new DataToBePostedDTO(id, userId, title, body));

        try{

            Response<ResponseBody> response = ApiExec.execute();
            System.out.println(response.code());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Retrofit getRetrofitInstance(){

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_url)
                .build();

        return retrofit;

    }

}
