package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.app1.databinding.ActivityLoginPageBinding
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.MimeMessage


class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.SystemDefault.setOnClickListener {setTheme(R.style.Base_Theme_App1)
        }


        binding.map.setOnClickListener{
            var intent = Intent(this,maps::class.java)
            startActivity(intent)
        }
        binding.car.setOnClickListener{
            var intent = Intent(this,Model::class.java)
            startActivity(intent)
        }

        }
    fun buttonSendEmail(view: View?) {
        try {
            val stringSenderEmail = "Email"
            val stringReceiverEmail = "dhruv.goel2804@gmail.com"
            val stringPasswordSenderEmail = "123456"
            val stringHost = "smtp.gmail.com"
            val properties = System.getProperties()
            properties["mail.smtp.host"] = stringHost
            properties["mail.smtp.port"] = "465"
            properties["mail.smtp.ssl.enable"] = "true"
            properties["mail.smtp.auth"] = "true"
            val session = Session.getInstance(properties, object : Authenticator() {
                override fun getPasswordAuthentication(): PasswordAuthentication {
                    return PasswordAuthentication(stringSenderEmail, stringPasswordSenderEmail)
                }
            })
            val mimeMessage = MimeMessage(session)
            mimeMessage.addRecipients(Message.RecipientType.TO, stringReceiverEmail)
            mimeMessage.subject = "Android Test"
            mimeMessage.setText("Hello")
            val thread = Thread {
                try {
                    Transport.send(mimeMessage)
                } catch (e: MessagingException) {
                    throw RuntimeException(e)
                }
            }
            thread.start()
            Transport.send(mimeMessage)
        } catch (e: MessagingException) {
            throw RuntimeException(e)
        }
    }
    }

