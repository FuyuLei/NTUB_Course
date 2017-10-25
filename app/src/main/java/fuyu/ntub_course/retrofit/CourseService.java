package fuyu.ntub_course.retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CourseService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://140.131.110.76/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    CourseService service = CourseService.retrofit.create(CourseService.class);

    @Headers("x-requested-with:com.hanglong.NTUBStdApp")
    @FormUrlEncoded
    @POST("JMobile_STD/AjaxPage/SRHCUR_Schedule_ajax.aspx")
    Call<String> Data(@Field("StdNo") String std_no, @Field("today") String today);
}
