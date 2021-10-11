package com.febrian.coroutineretrofit

data class Responses(
    var title : String? = null,
    var thumb : String? = null
)

data class Response(
    var results : List<Responses>
)
