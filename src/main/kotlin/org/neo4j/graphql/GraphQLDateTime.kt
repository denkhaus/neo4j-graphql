package org.neo4j.graphql

import graphql.Scalars.*
import graphql.schema.*
import java.time.ZonedDateTime


var GraphQLDateTime = GraphQLScalarType("DateTime", "Built-in DateTime", object : Coercing<ZonedDateTime, ZonedDateTime> {
    override fun serialize(input: Any): ZonedDateTime? {
        val result = (input as ZonedDateTime)
        return result ?: throw CoercingSerializeException("Invalid input '$input' for DateTime")
    }

    override fun parseValue(input: Any): ZonedDateTime? {
        val result = ZonedDateTime.parse(input as String)
        return result ?: throw CoercingParseValueException("Invalid input '$input' for DateTime")
    }

    override fun parseLiteral(input: Any): ZonedDateTime? {
        return if (input is String) {
            ZonedDateTime.parse(input as String)
        } else null
    }
})