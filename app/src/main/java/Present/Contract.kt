package Present

import android.view.View
import com.example.githubapidemo.model.GitHubUsers
import retrofit2.Response

interface Contract {

    interface Viewinterface{

        fun setData(response: GitHubUsers)

    }

    interface Presenter
    {

        fun fetchdata(newstring : String)


    }

}