package gangnam.sft.corruptedargument.util

import org.hibernate.annotations.Where

@Where(clause = "deleted = false")
abstract class BaseDeleteEntity(
    val deleted: Boolean = false,
): BaseEntity() {

}
