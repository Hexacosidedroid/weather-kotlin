package ru.cib.weatherapi.mail

//import org.springframework.mail.SimpleMailMessage
//import org.springframework.mail.javamail.JavaMailSender
//import org.springframework.stereotype.Service
//
//@Service
//class MailNotifier(
//        val javaMailSender: JavaMailSender
//) {
//    fun sendMail(messageText: String, vararg replyTo: String) {
//        val message = SimpleMailMessage()
//        message.apply {
//            setFrom("noreply@WeatherKotlin.ru")
//            setTo(replyTo.joinToString(","))
//            setSubject("Weather report")
//            setText(messageText)
//        }
//        javaMailSender.send(message)
//    }
//}