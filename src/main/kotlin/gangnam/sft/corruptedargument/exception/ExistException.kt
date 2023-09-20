package gangnam.sft.corruptedargument.exception

class ExistException(val property: Property) : GlobalRuntimeException(
//    message = property
) {

    override fun getStatusCode(): Int {
        return 1
    }

}