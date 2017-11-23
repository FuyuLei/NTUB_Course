package fuyu.ntub_course.retrofit;

import fuyu.ntub_course.model.Course;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CourseService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://140.131.110.76/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    CourseService service = retrofit.create(CourseService.class);

    @Headers("x-requested-with:com.hanglong.NTUBStdApp")
    @POST("JMobile_STD/AjaxPage/SRHCUR_Schedule_ajax.aspx")
    Call<Course> Login(@Body Course course);
}