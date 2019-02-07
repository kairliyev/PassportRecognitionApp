package kz.alibi.hday;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InsertData {
    @FormUrlEncoded
    @POST("AKfycbxI3uXtx7vS76YZ9ucd2gw3HuIHun9hK0oiu2x25CFMr-qpMGP8/exec")
    public Call<UsersList> insertUser(
            @Field("name") String name,
            @Field("surname") String surname,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("team") String team,
            @Field("org") String org,
            @Field("city") String city,
            @Field("section") String section
            );
}