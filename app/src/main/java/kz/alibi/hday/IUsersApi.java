package kz.alibi.hday;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUsersApi {

    @POST("s/AKfycbxI3uXtx7vS76YZ9ucd2gw3HuIHun9hK0oiu2x25CFMr-qpMGP8/exec")
    Call<UsersList> createUser(@Body UsersList user);

}