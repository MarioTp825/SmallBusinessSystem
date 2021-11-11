package edu.uni.website.models

sealed class MailSchema {
    data class Email(
        var name: String?,
        var phone: String?,
        var email: String?,
        var message: String?
    )
}
