package br.com.kym.todolist.domain.generator

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import java.io.Serializable
import java.util.*

class UUIDGeneratorId : IdentifierGenerator {
    override fun generate(p0: SharedSessionContractImplementor?, p1: Any?): Serializable =
        UUID.randomUUID().toString()

}