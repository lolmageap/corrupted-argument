package gangnam.sft.corruptedargument.exception

class NotFoundException(val state: Domain) : GlobalRuntimeException(
//    message = state
) {

    override fun getStatusCode(): Int {
        return 1
    }

}