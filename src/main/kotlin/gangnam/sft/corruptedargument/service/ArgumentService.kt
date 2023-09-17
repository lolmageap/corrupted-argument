package gangnam.sft.corruptedargument.service

import gangnam.sft.corruptedargument.domain.argument.ArgumentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
@Transactional(readOnly = true)
class ArgumentService(private val argumentRepository: ArgumentRepository) {

    @Transactional
    fun saveArgument(request: ArgumentServiceRequest) {
        argumentRepository.save(request.toArgument())
    }

    fun findArgument(id: Long): ArgumentServiceResponse {
        val argument = argumentRepository.findById(id).orElseThrow { RuntimeException() }
        return ArgumentServiceResponse.from(argument)
    }
}