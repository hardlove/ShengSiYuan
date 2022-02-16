package com.carlos._06_dataclass

data class Ext(
    val access_token: String,
    val expires_in: Int,
    val login_type: Int,
    val refresh_token: String,
    val sope: String,
    val third_type: Int,
    val user_id: Int
)