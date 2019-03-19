public class App {

    public static void main(String[] args){

        //This is the simple example of Retrofit Library to perform HTTP GET method to get some Data
        RestHandler_Retrofit.checkForResponse();

        //This is the simple example of Retrofit Library to perform HTTP GET Method with Path Param to fetch some data
        RestHandler_Retrofit.CheckParamBasedCall(3);

        //This is the simple example on how to Access API ENDPOINTS with improper SSL certificates
        RestHandler_Retrofit.testUnsafeApiCalls();

        //This is the simple example on how to POST some data to API ENDPOINT
        RestHandler_Retrofit.PostSomeDataToServer(21, 1, "Testing POST Method in Retrofit", "Nothing to say about this, lets check the console!");

    }

}
