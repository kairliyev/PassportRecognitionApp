package kz.alibi.hday;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("echo?user_content_key=iPazso8Q1xDwon0EIK5GJ6nYb3ty_eziLMZgjVo24iG6WmZp_EHhOFcqLlOPg3NKw2N_69rDKNHcu_o4air1mFIhnpMDNfPqOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUhofmAbwAhtMQdFmpmDA8r9g0gmRH-UnzbjinvrUiLAyMoLkJO7T_YeTG54gbOaUhYdO8VyFAHGlQt_SOwr8O2w&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva")
    Call<UsersList> getMyJson();

    @POST("s/AKfycbxI3uXtx7vS76YZ9ucd2gw3HuIHun9hK0oiu2x25CFMr-qpMGP8/exec")
    @FormUrlEncoded
    Call<Listz> createUsera(@Field("name") String na,
                            @Field("surname") String su,
                            @Field("email") String email);
}
