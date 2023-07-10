package com.inigo.organizeme_front.data.auth

interface AuthRepository {
    suspend fun signUp(username: String, password: String):AuthResult<Unit>
    suspend fun signIn(username: String, password: String):AuthResult<Unit>
    suspend fun authenticate():AuthResult<Unit>
}