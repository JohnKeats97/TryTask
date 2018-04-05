package ru.ftl.besthack.repositories.users

import android.graphics.Bitmap
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ru.ftl.besthack.data.auth.UserModel

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project BestHack
 * @date 06.03.18
 */

interface IUsersRepository {
    fun getUsers(): Flowable<List<UserModel>>
    fun saveUser(userModel: UserModel): Single<UserModel>
}