package ru.ftl.besthack.interactor.auth

import io.reactivex.Single
import ru.ftl.besthack.data.auth.UserApi
import ru.ftl.besthack.data.auth.UserModel

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project BestHack
 * @date 06.03.18
 */

interface IAuthInteractor {
    fun getToken(): String?

}