package core.services;

import core.helpers.User;
import io.qameta.atlas.webdriver.extension.Path;
import retrofit2.Response;
import retrofit2.http.GET;

public interface UserService {

    @GET("/service/users/{id}")
    Response<User> getUser(@Path("id") String id);

//    static UserService createUserService() {
//        Retrofit retrofit = new Retrofit().newBuilder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("")
//                .build();
//        return retrofit.create(UserService.class);
//    }

    static User createUser(String username, String password) {
        return new User(username, password);
    }
}