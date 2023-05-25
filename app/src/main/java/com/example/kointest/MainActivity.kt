package com.example.kointest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kointest.Repository.UserRepository
import com.example.kointest.Repository.UserRepositoryImpl
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {

    // TODO 7: The UserPresenter component will be created, resolving the UserRepository instance with it. To get it into our Activity, let's inject it with the by inject() delegate function:
    private val presenter: UserPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO 8: We need to start Koin with our Android application.
        //  Just call the startKoin() function in the application's main entry point, our MainApplication class:
        startKoin{
            androidLogger()
            androidContext(this@MainActivity)
            modules(appModule)
        }
    }

    // TODO 4: Let's declare our first component.
    //  We want a singleton of UserRepository, by creating an instance of UserRepositoryImpl
    val appModule = module {
        single<UserRepository> { UserRepositoryImpl() }

//        TODO 6:We declare UserPresenter in our Koin module.
//         We declare it as a factory definition, to not keep any instance in memory (avoid any leak with Android lifecycle):
        factory { UserPresenter(get()) }
    }

}