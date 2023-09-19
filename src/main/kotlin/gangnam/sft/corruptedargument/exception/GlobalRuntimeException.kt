package gangnam.sft.corruptedargument.exception

import java.util.concurrent.ConcurrentHashMap

abstract class GlobalRuntimeException(message: String? = null, cause: Throwable? = null) : RuntimeException() {


    private val validation: MutableMap<String, String> = ConcurrentHashMap()

    abstract fun getStatusCode(): Int

    fun getMessage(state: Domain): String {
        return state.value + "이(가) 존재하지 않습니다."
    }

    open fun addValidation(fieldName: String, message: String) {
        validation[fieldName] = message
    }

}