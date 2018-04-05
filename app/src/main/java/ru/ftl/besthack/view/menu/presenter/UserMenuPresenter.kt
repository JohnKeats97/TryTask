package ru.ftl.besthack.view.menu.presenter

import android.graphics.Bitmap
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.ftl.besthack.App
import ru.ftl.besthack.data.auth.UserModel
import ru.ftl.besthack.di.users.UsersModule
import ru.ftl.besthack.interactor.users.IUsersInteractor
import ru.ftl.besthack.view.menu.ui.IUserMenuActivity
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project BestHack
 * @date 27.03.18
 */

@InjectViewState
class UserMenuPresenter : MvpPresenter<IUserMenuActivity>() {
    @Inject
    lateinit var usersInteractor: IUsersInteractor
    private val disposable = CompositeDisposable()

    init {
        App.appComponent.plus(UsersModule()).inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadList()
    }

    fun loadList() {
        disposable.addAll(usersInteractor.getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.setList(it)
                }, {
                    Timber.e(it)
                    viewState.onError()
                }))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}